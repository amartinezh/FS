package controller.dashboard;

import java.text.DecimalFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import domain.adm.Plan;
import domain.fs.Conbsml;
import domain.session.session;
import service.fs.bsmlService;

@Controller
@RequestMapping("/indicadores")
@SessionAttributes({ "user_inicio" })
public class dashController {

	@Autowired
	private bsmlService Service;
	
	@Autowired
	private service.adm.RegionService regionService;
	
	@Autowired
	private service.adm.CompanyService companyService;
	
	@Autowired
	private service.adm.CurrencyService currencyService;

	//@Autowired
	//private PlanService planService;
	
	private enum Months {
		January, February, March, April, May, June, July, August, September, October, November, December;
	}

	// En éste controlador quedo el inicio
	@RequestMapping(value = "/inicio", method = RequestMethod.GET)
	public String inicio(Model model) {
		if (model.containsAttribute("user_inicio") == true) {
			((session) model.asMap().get("user_inicio")).setDash_region(companyService.getCompanyRegion(((session) model.asMap().get("user_inicio")).getDash_nia()).getRegion_id().getRegion_id());
			//System.out.println("------------La region: "+((session) model.asMap().get("user_inicio")).getDash_region());
			model.addAttribute("r3g", ((session) model.asMap().get("user_inicio")).getDash_region());
			model.addAttribute("c1a", ((session) model.asMap().get("user_inicio")).getDash_nia());
			model.addAttribute("cur", ((session) model.asMap().get("user_inicio")).getDash_moneda());
			model.addAttribute("tas", ((session) model.asMap().get("user_inicio")).getDash_tasa());
			model.addAttribute("anio",((session) model.asMap().get("user_inicio")).getAnio());
			model.addAttribute("usuario",((session) model.asMap().get("user_inicio")).getUsuario());
			model.addAttribute("tipo",((session) model.asMap().get("user_inicio")).getTipoUsuario());
			if (((session) model.asMap().get("user_inicio")).getTipoUsuario() == 2) {
				model.addAttribute("companyList", companyService.listCompany(((session) model.asMap().get("user_inicio")).getDash_region()));
			} else {
				if (((session) model.asMap().get("user_inicio")).getTipoUsuario() == 3) {
					model.addAttribute("companyList", companyService.listCompany("Todas"));
				}
			}
			
			return "dashboard";
		} else {
			return "redirect:/index/ingreso";
		}
	}
	
	@RequestMapping(value = "/menu", method = RequestMethod.GET)
	public String menu(Model model, @RequestParam String t, @RequestParam String r3g, @RequestParam String op10, @RequestParam String nia) {
		if (model.containsAttribute("user_inicio") == true) {
			model.addAttribute("tit",t);
			model.addAttribute("r3g",r3g);
			model.addAttribute("op10",op10);
			//model.addAttribute("n",((session) model.asMap().get("user_inicio")).getNivel());
			model.addAttribute("n","1");
			System.out.println("Nia"+((session) model.asMap().get("user_inicio")).getNivel());
			if (!nia.equals("n")){
				((session) model.asMap().get("user_inicio")).setDash_nia(nia);
				((session) model.asMap().get("user_inicio")).setDash_region(companyService.getCompanyRegion(nia).getRegion_id().getRegion_id());
			}
			switch (Integer.parseInt(op10)) {
            	case 1:
            		model.addAttribute("viewl","bsml");
            		model.addAttribute("viewu","bsmu");
            		break;
            	case 2:
            		model.addAttribute("viewl","/fs/pgml");
            		model.addAttribute("viewu","/fs/pgmu");
            		break;
            	case 3: 
            		model.addAttribute("viewl","/fs/bsml");
            		model.addAttribute("viewu","/fs/bsmu");
            		break;
            	default:
            		break;
			}
			return "menu";
		} else {
			return "redirect:/index/ingreso";
		}
	}
	
	@RequestMapping(value = "/intruso", method = RequestMethod.GET)
	public String intruso(Model model) {
		if (model.containsAttribute("user_inicio") == true) {
			((session) model.asMap().get("user_inicio")).setDash_region(companyService.getCompanyRegion(((session) model.asMap().get("user_inicio")).getDash_nia()).getRegion_id().getRegion_id());
			//System.out.println("------------La region: "+((session) model.asMap().get("user_inicio")).getDash_region());
			model.addAttribute("r3g", ((session) model.asMap().get("user_inicio")).getDash_region());
			model.addAttribute("c1a", ((session) model.asMap().get("user_inicio")).getDash_nia());
			model.addAttribute("cur", ((session) model.asMap().get("user_inicio")).getDash_moneda());
			model.addAttribute("tas", ((session) model.asMap().get("user_inicio")).getDash_tasa());
			model.addAttribute("anio",((session) model.asMap().get("user_inicio")).getAnio());
			model.addAttribute("usuario",((session) model.asMap().get("user_inicio")).getUsuario());
			model.addAttribute("tipo",((session) model.asMap().get("user_inicio")).getTipoUsuario());
			if (((session) model.asMap().get("user_inicio")).getTipoUsuario() == 2) {
				model.addAttribute("companyList", companyService.listCompany(((session) model.asMap().get("user_inicio")).getDash_region()));
			} else {
				if (((session) model.asMap().get("user_inicio")).getTipoUsuario() == 3) {
					model.addAttribute("companyList", companyService.listCompany("Todas"));
				}
			}
			
			return "menu_adm";
		} else {
			return "redirect:/index/ingreso";
		}
	}
	
	///////////////////////////////////////////////////////////////////////////////////
	
	@RequestMapping(value = "/bsml", method = RequestMethod.GET)
	public String salesYear(Model model, @RequestParam String t, @RequestParam String op10) {
		if (model.containsAttribute("user_inicio") == true) {
			StringBuffer buf = new StringBuffer();
			DecimalFormat ftm = new DecimalFormat("###,###.###");
			model.addAttribute("tit",t);
			String r=((session) model.asMap().get("user_inicio")).getDash_region();
			String n=((session) model.asMap().get("user_inicio")).getDash_nia();
			//String nit=((session) model.asMap().get("user_inicio")).get;
			int m= Integer.parseInt(((session) model.asMap().get("user_inicio")).getMes());
			if (!r.equals("Todas")) r = regionService.getRegion(((session) model.asMap().get("user_inicio")).getDash_region()).get(0).getDescripcion();
			if (!n.equals("Todas")) n = companyService.listCompany__(((session) model.asMap().get("user_inicio")).getDash_nia()).get(0).getDescripcion();
			List<Conbsml> listado = Service.list(((session) model.asMap().get("user_inicio")).getDash_nia());
			
			buf.append("<!DOCTYPE html><html><head><title>Finance System</title>");
			buf.append("<style>table { border-collapse: collapse; width: 100%; line-height: 100%; font: 90% monospace; table-layout: fixed; } th {    text-align: center; padding: 10px; font: 90% monospace;} td { padding: 0px;} body { margin-top: 20px; margin-left: 50px; }</style></head>");
			buf.append("<body> <div style=\"overflow-x:auto;\"><table style=\" white-space: pre\"><tr><td align=\"left\" colspan=\"4\">GB BIOPACOL ANDINA S.A.S <br/> N.I.T.:  900588276 - 4  <br/> CON060R5 </td> <th colspan=\"4\">CONSOLIDATED BELANCE SHEET INFORMATION <br/>PRELIMINARY <br/>FEBRUARY  2.017 <br/>COP ('000') </th> <th colspan=\"4\"></th> </tr> <tr> <td colspan=\"4\"></td> <td align=\"right\">ACTUAL</td><td align=\"right\">LAST MONTH</td> <td align=\"right\">LAST YEAR</td> <td align=\"right\"></td> <td align=\"right\"></td><td align=\"right\"></td> </tr>");
			String style="";
			for (Conbsml conbsml : listado) {
				style = (conbsml.getCdesc().equals("LINEA"))?"border-style: solid none none none":((conbsml.getCdesc().equals("DOBLE LINEA"))?"border-style: dashed none none none":"");
				buf.append("<tr><td colspan=\"4\">"+conbsml.getCdesc()+"</td>");
				buf.append("<td style=\""+style+"\" align=\"right\">"+((ftm.format(Double.parseDouble(conbsml.getCvalaa())).equals("0"))?"":ftm.format(Double.parseDouble(conbsml.getCvalaa())))+"</td>");
				buf.append("<td style=\""+style+"\" align=\"right\">"+((ftm.format(Double.parseDouble(conbsml.getCvalm())).equals("0"))?"":ftm.format(Double.parseDouble(conbsml.getCvalm())))+"</td>");
				buf.append("<td style=\""+style+"\" align=\"right\">"+((ftm.format(Double.parseDouble(conbsml.getCvalma())).equals("0"))?"":ftm.format(Double.parseDouble(conbsml.getCvalma())))+"</td>");
				buf.append("<td align=\"right\"></td>");
				buf.append("<td align=\"right\"></td>");
				buf.append("<td align=\"right\"></td>");
				buf.append("</tr>");
			}
			buf.append("</table></div></body></html>");
			model.addAttribute("r",r);
			model.addAttribute("meta",buf);
			model.addAttribute("bsml",listado);
			model.addAttribute("buf",buf);
			return "fs/bsml";
		} else {
			return "redirect:/index/ingreso";
		}
	}
	
	///////////////////////////////////////////////////////////////////////////////////
	
	@RequestMapping(value = "/salir", method = RequestMethod.GET)
	public String salir(Model model, SessionStatus status) {
		status.setComplete();
		
		return "redirect:/index/ingreso";
	}
}
