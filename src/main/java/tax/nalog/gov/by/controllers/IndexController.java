package tax.nalog.gov.by.controllers;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import tax.nalog.gov.by.utils.ExelDocument;
import tax.nalog.gov.by.utils.SpringConfig;
import tax.nalog.gov.by.entity.Admins;
import tax.nalog.gov.by.entity.Appeals;
import tax.nalog.gov.by.entity.Imns;
import tax.nalog.gov.by.form.PasswordForm;
import tax.nalog.gov.by.form.ReportDataForm;
import tax.nalog.gov.by.form.AppearDataForm;
import tax.nalog.gov.by.form.AppearIdForm;
import tax.nalog.gov.by.service.AdminsService;
import tax.nalog.gov.by.service.AppealsService;
import tax.nalog.gov.by.service.ImnsService;

@Controller
public class IndexController {
	
	private static final Logger logger = Logger.getLogger(IndexController.class);
	private Map<String, String> typeList;
	private String[] types = {"7.1 Жалоба в район", "7.2 Жалоба в область", "7.3 Жалоба в МНС", "7.4 Жалоба в суд", "7.5 Предписание прокуратуры", "7.6 Письмо МНС", "7.7 Письмо область", "Иной документ"};
	
	@Autowired 
	private HttpSession httpSession;
	
	public IndexController() {
		logger.info("IndexController");
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(SpringConfig.class);
		ctx.close();
		
		typeList = new TreeMap<String, String>();
		for (int i=0; i<types.length; i++) {
			typeList.put(types[i], types[i]);
		}
	}
	
	@GetMapping("/")
	public ModelAndView indexViewGet(ModelMap modelMap) throws Exception{
		logger.info("indexViewGet");
		ModelAndView model = new ModelAndView("index");
		model.addObject("passwordForm", new PasswordForm());
		modelMap.addAttribute("loginfo", "");
		System.out.println(httpSession.getId());
		return model;
	}
	
	@PostMapping("/")
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
		httpSession.setAttribute("admin", admin);
	    modelView = new ModelAndView("main");
	    
	    ImnsService imnsService = new ImnsService();
	    List<Imns> imnsList = new ArrayList<Imns>();
	    if (admin.getAccess() == 1) {
	    	imnsList = imnsService.findAll();
	    }else {
	    	imnsList.add( admin.getImns() );
	    }
	    modelView.addObject("imnsList", imnsList);
	    
	    modelView.addObject("appearDataForm", new AppearDataForm());
	    modelView.addObject("appearIdForm", new AppearIdForm());
	    modelView.addObject("reportDataForm", new ReportDataForm());
	    modelView.addObject("typeList", typeList);
	    modelView.addObject("display", false);
	    Imns imns = admin.getImns();
	    AppealsService appealsService = new AppealsService();
	    List<Appeals> listAppeals = null;
	    listAppeals = appealsService.getListByImns(imns);

	    modelView.addObject("imnsname", imns.getShotName());
	    modelView.addObject("appealsList", listAppeals);
		
		return modelView;
	}
	
	@GetMapping("/main")
	public ModelAndView mainViewGet(@ModelAttribute("appearIdForm") AppearIdForm appearIdForm, 
			ModelMap modelMap) throws Exception{
		  logger.info("mainVievGet");
		  
		  Admins admin = (Admins)httpSession.getAttribute("admin");		  
		  if (admin == null) {
			  return null;
		  }
		  
		  AppealsService appealsService = new AppealsService();
		  AppearDataForm appealDataForm = new AppearDataForm();
		  if (appearIdForm != null) { 
			  Appeals appleal = appealsService.findByID(appearIdForm.getId_fild());
			  appealDataForm.setByAppeal(appleal);
		  }
		  	  
		  ModelAndView modelView = new ModelAndView("main");
		  modelView.addObject("typeList", typeList);
		  
		  ImnsService imnsService = new ImnsService();
		  List<Imns> imnsList = new ArrayList<Imns>();
		  if (admin.getAccess() == 1) {
		   	imnsList = imnsService.findAll();
		  }else {
		  	imnsList.add( admin.getImns() );
		  }
		  modelView.addObject("imnsList", imnsList);
		  
		  modelView.addObject("appearDataForm", appealDataForm);
		  modelView.addObject("appearIdForm", new AppearIdForm());
		  modelView.addObject("reportDataForm", new ReportDataForm());
		  Imns imns = admin.getImns();
		  List<Appeals> listAppeals = null;
		    listAppeals = appealsService.getListByImns(imns);
		  modelView.addObject("imnsname", imns.getShotName());
		  modelView.addObject("appealsList", listAppeals);
		  modelView.addObject("display", true);
		  
		  return modelView; 
	}
	
	
	  @PostMapping("/main") 
	  public ModelAndView mainViewPost(@ModelAttribute("appearDataForm") AppearDataForm appearDataForm, 
			  ModelMap modelMap) throws Exception{
		  logger.info("mainVievGet");
		  
		  Admins admin = (Admins)httpSession.getAttribute("admin");		  
		  if (admin == null) {
			  return null;
		  }
		  
		  AppealsService appealsService = new AppealsService();
		  appealsService.createEntity(appearDataForm, admin.getImns());
		  
		  ModelAndView modelView = new ModelAndView("main");
		  
		    ImnsService imnsService = new ImnsService();
		    List<Imns> imnsList = new ArrayList<Imns>();
		    if (admin.getAccess() == 1) {
		    	imnsList = imnsService.findAll();
		    }else {
		    	imnsList.add( admin.getImns() );
		    }
		    modelView.addObject("imnsList", imnsList);
		  
		  modelView.addObject("appearDataForm", new AppearDataForm());
		  modelView.addObject("appearIdForm", new AppearIdForm());
		  modelView.addObject("reportDataForm", new ReportDataForm());
		  modelView.addObject("typeList", typeList);
		  Imns imns = admin.getImns();
		  List<Appeals> listAppeals = null;
	    	listAppeals = appealsService.getListByImns(imns);
		  modelView.addObject("imnsname", imns.getShotName());
		  modelView.addObject("appealsList", listAppeals);
		  modelView.addObject("display", false);
		  
		  return modelView; 
	  }
	  
	  @GetMapping("report")
	  public ModelAndView report( HttpServletResponse response, 
			  @RequestParam(name = "button") String name, 
			  @ModelAttribute("reportDataForm") ReportDataForm reportDataForm ) {
		  logger.info(name);
		  
		  Admins admin = (Admins)httpSession.getAttribute("admin");		  
		  if (admin == null) {
			  return null;
		  }
		  
		  ModelAndView modelView = null;
		  AppealsService appealsService = new AppealsService();
		  List<Appeals> appealList = null;
		  ExelDocument exelDocument = new ExelDocument();
		  
		  switch (name) {
				case "Отчет по жалобам":					
					appealList = appealsService.getListReport7(admin, "%Письмо%", reportDataForm.getFrom(), reportDataForm.getTo());
				  
					modelView = new ModelAndView("7");
					modelView.addObject("reportsList7", appealList);
					break;
					
				case "Письма":
					appealList = appealsService.getListReport74(admin, "%Письмо%", reportDataForm.getFrom(), reportDataForm.getTo());
					  
					modelView = new ModelAndView("74");
					modelView.addObject("reportsList74", appealList);
					break;
					
				case "Excel отчет по жалобам":
					appealList = appealsService.getListReport7(admin, "%Письмо%", reportDataForm.getFrom(), reportDataForm.getTo());
					String path = exelDocument.createReport7(appealList, admin.getImns());
					try {
						File downloadFile = new File(path);
						FileInputStream inputStream = new FileInputStream(downloadFile);
						response.setContentType("application/octet-stream");
						response.setContentLength((int) downloadFile.length());
						String headerKey = "Content-Disposition";
						String headerValue = String.format("attachment; filename=\"%s\"",
				                downloadFile.getName());
				        response.setHeader(headerKey, headerValue);
				        OutputStream outStream = response.getOutputStream();
				        byte[] buffer = new byte[4096];
				        int bytesRead = -1;
				        while ((bytesRead = inputStream.read(buffer)) != -1) {
				            outStream.write(buffer, 0, bytesRead);
				        }
				 
				        inputStream.close();
				        outStream.close();
					}catch (Exception e) {
						e.printStackTrace();
					}
					break;
					
				case "Excel Письма":
					appealList = appealsService.getListReport74(admin, "%Письмо%", reportDataForm.getFrom(), reportDataForm.getTo());
					
					String path2 = exelDocument.createReport74(appealList, admin.getImns());
					try {
						File downloadFile = new File(path2);
						FileInputStream inputStream = new FileInputStream(downloadFile);
						response.setContentType("application/octet-stream");
						response.setContentLength((int) downloadFile.length());
						String headerKey = "Content-Disposition";
						String headerValue = String.format("attachment; filename=\"%s\"",
				                downloadFile.getName());
				        response.setHeader(headerKey, headerValue);
				        OutputStream outStream = response.getOutputStream();
				        byte[] buffer = new byte[4096];
				        int bytesRead = -1;
				        while ((bytesRead = inputStream.read(buffer)) != -1) {
				            outStream.write(buffer, 0, bytesRead);
				        }
				 
				        inputStream.close();
				        outStream.close();
					}catch (Exception e) {
						e.printStackTrace();
					}
					
					break;
		  }
		  

		  return modelView; 
	  }
}
