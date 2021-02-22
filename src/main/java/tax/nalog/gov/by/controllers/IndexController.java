package tax.nalog.gov.by.controllers;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import tax.nalog.gov.by.utils.SpringConfig;
import tax.nalog.gov.by.entity.Admins;
import tax.nalog.gov.by.form.PasswordForm;
import tax.nalog.gov.by.form.AppearDataForm;
import tax.nalog.gov.by.service.AdminsService;

@Controller
public class IndexController {
	
	private static final Logger logger = Logger.getLogger(IndexController.class);
	
	public IndexController() {
		logger.info("IndexController");
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(SpringConfig.class);
		ctx.close();
	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView indexViewGet(ModelMap modelMap) throws Exception{
		logger.info("indexViewGet");
		ModelAndView model = new ModelAndView("index");
		model.addObject("passwordForm", new PasswordForm());
		modelMap.addAttribute("loginfo", "");
		return model;
	}
	
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public ModelAndView indexViewPost(@ModelAttribute("passwordForm")PasswordForm passwordForm, ModelMap model) throws Exception{
		logger.info("indexViewPost");
		
		AdminsService adminService = new AdminsService();
		Admins admin = adminService.findByLogin(passwordForm.getUsername());
		ModelAndView modelView;
		
		if (admin == null) {
			logger.info("admin is null");
			model.addAttribute("loginfo", "Неверный логин/пароль");
	    	modelView = new ModelAndView("index");
	    	return modelView;
		}
		
		boolean rez = passwordForm.equals(admin);
		
		if (rez == false) {
	    	model.addAttribute("loginfo", "Неверный логин/пароль");
	    	modelView = new ModelAndView("index");
	    	return modelView;
	    }
		
		logger.info("autorization:" + rez);
	    modelView = new ModelAndView("main");
	    modelView.addObject("appearDataForm", new AppearDataForm());
		
		return modelView;
	}
	
	@RequestMapping(value = "/main", method = RequestMethod.GET)
	public ModelAndView mainViewGet(ModelMap modelMap) throws Exception{
		logger.info("mainVievGet");
		
		ModelAndView modelView = new ModelAndView("main");
		
		return modelView;
	}
	
	
	  @RequestMapping(value = "/main", method = RequestMethod.POST) 
	  public ModelAndView mainViewPost(@ModelAttribute("appearDataForm") AppearDataForm
	  appearDataForm, ModelMap modelMap) throws Exception{
		  logger.info("mainVievGet");
		  
		  ModelAndView modelView = new ModelAndView("main");
		  
		  return modelView; 
	  }
	 
	
}
