package controller.dashboard;

import java.text.DecimalFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import domain.fs.Conbsml;
import domain.fs.Conbsmu;
import domain.fs.Conpgal;
import domain.fs.Conpgau;
import domain.fs.Conpgml;
import domain.fs.Conpgmu;
import domain.session.session;
import service.fs.bsmlService;
import service.fs.bsmuService;
import service.fs.pgauService;
import service.fs.pgalService;
import service.fs.pgmuService;
import service.fs.pgmlService;

@Controller
@RequestMapping("/indicadores")
@SessionAttributes({ "user_inicio" })
public class dashController {

	@Autowired
	private bsmlService bsmlService;
	
	@Autowired
	private bsmuService bsmuService;
	
	@Autowired
	private pgauService pgauService;
	
	@Autowired
	private pgalService pgalService;
	
	@Autowired
	private pgmuService pgmuService;
	
	@Autowired
	private pgmlService pgmlService;
	
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
	
	private enum Years {
		a2016, a2017, a2028;
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
			model.addAttribute("month",Months.values());
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
	public String salesYear(Model model, @RequestParam String t, @RequestParam String year, @RequestParam String month, @RequestParam String m, @RequestParam String c) {
		if (model.containsAttribute("user_inicio") == true) {
			StringBuffer buf = new StringBuffer();
			DecimalFormat ftm = new DecimalFormat("###,###.###");
			model.addAttribute("tit",t);
			String r=((session) model.asMap().get("user_inicio")).getDash_region();
			String n=((session) model.asMap().get("user_inicio")).getDash_nia();
			if (!r.equals("Todas")) r = regionService.getRegion(((session) model.asMap().get("user_inicio")).getDash_region()).get(0).getDescripcion();
			if (!n.equals("Todas")) n = companyService.listCompany__(c).get(0).getDescripcion();
			List<Conbsmu> listadou = null;
			List<Conbsml> listadol = null;
			if (m.equals("u")){
				listadou = bsmuService.list(c, month, year);
				model.addAttribute("navegacion",
						"Region: " + r + " >> " +
						"Company: " + n + " >> " +
						"Currency: USD >> " +
						" >> Month: " + Months.values()[Integer.parseInt(month)-1] +
						" >> Year: " + year
						);
			}
			else{
				listadol = bsmlService.list(c, month, year);
				model.addAttribute("navegacion",
						"Region: " + r + " >> " +
						"Company: " + n + " >> " +
						"Currency: COP >> " +
						" >> Month: " + Months.values()[Integer.parseInt(month)-1] +
						" >> Year: " + year
						);
			}
			
			
			
			/*buf.append("<!DOCTYPE html><html><head><title>Finance System</title>");
			buf.append("<style>table { border-collapse: collapse; width: 100%; line-height: 100%; font: 90% monospace; table-layout: fixed; } th {    text-align: center; padding: 10px; font: 90% monospace;} td { padding: 0px;} body { margin-top: 20px; margin-left: 50px; }</style></head>");
			buf.append("<body> <div style=\"overflow-x:auto;\"><table style=\" white-space: pre\"><tr><td align=\"left\" colspan=\"4\">GB BIOPACOL ANDINA S.A.S <br/> N.I.T.:  900588276 - 4  <br/> CON060R5 </td> <th colspan=\"4\">CONSOLIDATED BELANCE SHEET INFORMATION <br/> <br/>FEBRUARY  2.017 <br/>COP ('000') </th> <th colspan=\"4\"></th> </tr> ");
			buf.append("<tr> <td colspan=\"4\"></td> <td align=\"right\">==============</td><td align=\"right\">==============</td> <td align=\"right\">==============</td> <td align=\"right\"></td> <td align=\"right\"></td><td align=\"right\"></td> </tr>");
			buf.append("<tr> <td colspan=\"4\"></td> <td align=\"right\">ACTUAL</td><td align=\"right\">LAST MONTH</td> <td align=\"right\">LAST YEAR</td> <td align=\"right\"></td> <td align=\"right\"></td><td align=\"right\"></td> </tr>");
			buf.append("<tr> <td colspan=\"4\"></td> <td align=\"right\">==============</td><td align=\"right\">==============</td> <td align=\"right\">==============</td> <td align=\"right\"></td> <td align=\"right\"></td><td align=\"right\"></td> </tr>");
			String style="";
			for (Conbsml conbsml : listado) {
				//style = (conbsml.getCdesc().equals("LINEA"))?"border-style: solid none none none":((conbsml.getCdesc().equals("DOBLE LINEA"))?"border-style: dashed none none none":"");
				
				if (conbsml.getCdesc().equals("LINEA")){
					buf.append("<tr><td colspan=\"4\"></td>");
					buf.append("<td style=\""+style+"\" align=\"right\">______________</td>");
					buf.append("<td style=\""+style+"\" align=\"right\">______________</td>");
					buf.append("<td style=\""+style+"\" align=\"right\">______________</td>");
				}
				else{
					if (conbsml.getCdesc().equals("DOBLE LINEA")){
						buf.append("<tr><td colspan=\"4\"></td>");
						buf.append("<td style=\""+style+"\" align=\"right\">==============</td>");
						buf.append("<td style=\""+style+"\" align=\"right\">==============</td>");
						buf.append("<td style=\""+style+"\" align=\"right\">==============</td>");
					}
					else{
						buf.append("<tr><td colspan=\"4\">"+conbsml.getCdesc()+"</td>");
						buf.append("<td style=\""+style+"\" align=\"right\">"+((ftm.format(Double.parseDouble(conbsml.getCvalaa())).equals("0"))?"":ftm.format(Double.parseDouble(conbsml.getCvalaa())))+"</td>");
						buf.append("<td style=\""+style+"\" align=\"right\">"+((ftm.format(Double.parseDouble(conbsml.getCvalm())).equals("0"))?"":ftm.format(Double.parseDouble(conbsml.getCvalm())))+"</td>");
						buf.append("<td style=\""+style+"\" align=\"right\">"+((ftm.format(Double.parseDouble(conbsml.getCvalma())).equals("0"))?"":ftm.format(Double.parseDouble(conbsml.getCvalma())))+"</td>");
					}
				}
				buf.append("<td align=\"right\"></td>");
				buf.append("<td align=\"right\"></td>");
				buf.append("<td align=\"right\"></td>");
				buf.append("<td align=\"right\"></td>");
				buf.append("</tr>");
			}
			buf.append("</table></div></body></html>");
			*/
			model.addAttribute("r",r);
			model.addAttribute("meta",buf);
			if (m.equals("u"))
				model.addAttribute("bsm",listadou);
			else
				model.addAttribute("bsm",listadol);
			
			model.addAttribute("buf",buf);
			return "fs/bsm";
		} else {
			return "redirect:/index/ingreso";
		}
	}
	
	///////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////
	
	@RequestMapping(value = "/pga", method = RequestMethod.GET)
	public String pga(Model model, @RequestParam String t, @RequestParam String year, @RequestParam String month, @RequestParam String m, @RequestParam String c) {
		if (model.containsAttribute("user_inicio") == true) {
			StringBuffer buf = new StringBuffer();
			DecimalFormat ftm = new DecimalFormat("###,###.###");
			model.addAttribute("tit",t);
			String r=((session) model.asMap().get("user_inicio")).getDash_region();
			String n=((session) model.asMap().get("user_inicio")).getDash_nia();
			if (!r.equals("Todas")) r = regionService.getRegion(((session) model.asMap().get("user_inicio")).getDash_region()).get(0).getDescripcion();
			if (!n.equals("Todas")) n = companyService.listCompany__(c).get(0).getDescripcion();
			List<Conpgau> listadou = null;
			List<Conpgal> listadol = null;
			if (m.equals("u")){
				listadou = pgauService.list(c, month, year);
				model.addAttribute("navegacion",
						"Region: " + r + " >> " +
						"Company: " + n + " >> " +
						"Currency: USD >> " +
						" >> Month: " + Months.values()[Integer.parseInt(month)-1] +
						" >> Year: " + year
						);
			}
			else{
				listadol = pgalService.list(c, month, year);
				model.addAttribute("navegacion",
						"Region: " + r + " >> " +
						"Company: " + n + " >> " +
						"Currency: COP >> " +
						" >> Month: " + Months.values()[Integer.parseInt(month)-1] +
						" >> Year: " + year
						);
			}
			
			model.addAttribute("r",r);
			model.addAttribute("meta",buf);
			if (m.equals("u"))
				model.addAttribute("pga",listadou);
			else
				model.addAttribute("pga",listadol);
			
			model.addAttribute("buf",buf);
			return "fs/pga";
		} else {
			return "redirect:/index/ingreso";
		}
	}
	
	///////////////////////////////////////////////////////////////////////////////////
	
	///////////////////////////////////////////////////////////////////////////////////
		
	@RequestMapping(value = "/pgm", method = RequestMethod.GET)
	public String pgm(Model model, @RequestParam String t, @RequestParam String year, @RequestParam String month, @RequestParam String m, @RequestParam String c) {
			if (model.containsAttribute("user_inicio") == true) {
				StringBuffer buf = new StringBuffer();
				DecimalFormat ftm = new DecimalFormat("###,###.###");
				model.addAttribute("tit", t);
				String r = ((session) model.asMap().get("user_inicio")).getDash_region();
				String n = ((session) model.asMap().get("user_inicio")).getDash_nia();
				if (!r.equals("Todas"))
					r = regionService.getRegion(((session) model.asMap().get("user_inicio")).getDash_region()).get(0).getDescripcion();
				if (!n.equals("Todas"))
					n = companyService.listCompany__(c).get(0).getDescripcion();
				List<Conpgmu> listadou = null;
				List<Conpgml> listadol = null;
				if (m.equals("u")){
					listadou = pgmuService.list(c, month, year);
					model.addAttribute("navegacion",
							"Region: " + r + " >> " +
							"Company: " + n + " >> " +
							"Currency: USD >> " +
							" >> Month: " + Months.values()[Integer.parseInt(month)-1] +
							" >> Year: " + year
							);
				}
				else{
					listadol = pgmlService.list(c, month, year);
					model.addAttribute("navegacion",
							"Region: " + r + " >> " +
							"Company: " + n + " >> " +
							"Currency: COP >> " +
							" >> Month: " + Months.values()[Integer.parseInt(month)-1] +
							" >> Year: " + year
							);
				}
	
				model.addAttribute("r", r);
				model.addAttribute("meta", buf);
				if (m.equals("u"))
					model.addAttribute("pgm", listadou);
				else
					model.addAttribute("pgm", listadol);
	
				model.addAttribute("buf", buf);
				return "fs/pgm";
			} else {
				return "redirect:/index/ingreso";
			}
	}
	
	///////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////
	
	@RequestMapping(value = "/rpt", method = RequestMethod.GET)
	public String rpt(Model model, @RequestParam String t, @RequestParam String year, @RequestParam String month, @RequestParam String m, @RequestParam String c, @RequestParam String ti) {
			if (model.containsAttribute("user_inicio") == true) {
				StringBuffer buf = new StringBuffer();
				DecimalFormat ftm = new DecimalFormat("###,###.###");
				model.addAttribute("tit", t);
				String r = ((session) model.asMap().get("user_inicio")).getDash_region();
				String n = ((session) model.asMap().get("user_inicio")).getDash_nia();
				if (!r.equals("Todas"))
					r = regionService.getRegion(((session) model.asMap().get("user_inicio")).getDash_region()).get(0).getDescripcion();
				if (!n.equals("Todas"))
					n = companyService.listCompany__(c).get(0).getDescripcion();
				List<Conbsmu> listado_bsmu = null;
				List<Conbsml> listado_bsml = null;
				List<Conpgau> listado_pgau = null;
				List<Conpgal> listado_pgal = null;
				List<Conpgmu> listado_pgmu = null;
				List<Conpgml> listado_pgml = null;
				char hi = ti.charAt(0);
				switch (hi){
					case '1': 
						if (m.equals("u")){
							listado_bsmu = bsmuService.list(c, month, year);
							model.addAttribute("data", listado_bsmu);
						}
						else{
							listado_bsml = bsmlService.list(c, month, year);
							model.addAttribute("data", listado_bsml);
						}
						break;
					case '2': 
						if (m.equals("u")){
							listado_pgau = pgauService.list(c, month, year);
							model.addAttribute("data", listado_pgau);
						}
						else{
							listado_pgal = pgalService.list(c, month, year);
							model.addAttribute("data", listado_pgal);
						}
						break;
					case '3': 
						if (m.equals("u")){
							listado_pgmu = pgmuService.list(c, month, year);
							model.addAttribute("data", listado_pgmu);
						}
						else{
							listado_pgml = pgmlService.list(c, month, year);
							model.addAttribute("data", listado_pgml);
						}
						break;
				}
				if (m.equals("u")){
					model.addAttribute("navegacion",
							"<br>" + n + " >> " +
							"<br>USD" +
							" <br>" + Months.values()[Integer.parseInt(month)-1] + " " + year
							);
				}
				else{
					model.addAttribute("navegacion",
							"<br>" + r + " >> " +
							"<br>" + n + " >> " +
							"<br>COP('000) " +
							"<br>" + Months.values()[Integer.parseInt(month)-1] + " " + year
							);
				}
				model.addAttribute("ti", ti);
				model.addAttribute("r", r);
				model.addAttribute("meta", buf);
				model.addAttribute("buf", buf);
				return "fs/rpt";
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
