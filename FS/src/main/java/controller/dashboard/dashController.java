package controller.dashboard;

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
import domain.session.session;
//import service.gestion.PlanService;
import service.fs.bsmlService;

@Controller
@RequestMapping("/indicadores")
@SessionAttributes({ "user_inicio" })
public class dashController {

	@Autowired
	private bsmlService kpiService;
	
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
			model.addAttribute("n",((session) model.asMap().get("user_inicio")).getNivel());
			System.out.println("Nia"+((session) model.asMap().get("user_inicio")).getNivel());
			if (!nia.equals("n")){
				((session) model.asMap().get("user_inicio")).setDash_nia(nia);
				((session) model.asMap().get("user_inicio")).setDash_region(companyService.getCompanyRegion(nia).getRegion_id().getRegion_id());
			}
			switch (Integer.parseInt(op10)) {
            	case 1:
            		model.addAttribute("viewl","/fs/pgal");
            		model.addAttribute("viewu","/fs/pgau");
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
	
	
}
