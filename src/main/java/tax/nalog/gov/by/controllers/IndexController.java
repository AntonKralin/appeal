package tax.nalog.gov.by.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {
	
		@RequestMapping(value = "/", method = RequestMethod.GET)
		   public ModelAndView mainView(ModelMap modelMap) throws Exception{
				ModelAndView model = new ModelAndView("index");
				//model.addObject("passwordForm", new PasswordForm());
				//modelMap.addAttribute("loginfo", "");
				return model;
		   }
	
}
