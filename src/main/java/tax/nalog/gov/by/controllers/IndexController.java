package tax.nalog.gov.by.controllers;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import tax.nalog.gov.by.utils.SpringConfig;

@Controller
public class IndexController {
	
	private static final Logger logger = Logger.getLogger(IndexController.class);
	
	public IndexController() {
		logger.info("IndexController");
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(SpringConfig.class);
		//ctx.getBean("hibernateSession");
		ctx.close();
	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	   public ModelAndView mainView(ModelMap modelMap) throws Exception{
			ModelAndView model = new ModelAndView("index");
			//model.addObject("passwordForm", new PasswordForm());
			//modelMap.addAttribute("loginfo", "");
			return model;
	   }

}
