package cn.my.controller;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.my.model.Menu;
import cn.my.service.LoanService;
import cn.my.util.myUtil;

import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
@RequestMapping(value = "aa")
public class LoanController {
	
    private static final ObjectMapper jsonMapper = new ObjectMapper();
	
	@Autowired
	private LoanService loanService;
	
    @RequestMapping(value = "/gg{id}.html")
    @ResponseBody
    public String getMenu(HttpServletRequest request, @PathVariable String id, ModelMap model) {
		String str = "";
    	try {
    		Menu m = loanService.getMenuById(248l);
    		str = m.getTextch();
		} catch (Exception e) {
			e.printStackTrace();
		}
    	
    	return ""+str;
    }
    
    @RequestMapping(value = "/all.html")
    @ResponseBody
    public String getAllMenu(HttpServletRequest request, ModelMap model) throws Exception {
		String str = "";
		String json = "[]";
     
    		List<Menu> list = loanService.selectAllMenu();
    		
			if(list.size() == 0){
			  return json;
			}
			json = jsonMapper.writeValueAsString(list);
			Exception e = new Exception();
			e.printStackTrace();
    	//	str = m.getTextch();
		 
    	return json;
    }
    
    @RequestMapping(value = "/null")
    @ResponseBody
    public String getNull(){
    	
    	return "";
    }
    
    @RequestMapping(value = "/login")
    //@ResponseBody
    public String Login(HttpServletRequest request, ModelMap model, HttpServletResponse response){
    	  String validateC = (String) request.getSession().getAttribute("validateCode");   
    	 // String str = (String) request.getAttribute("c");
    	  String name = (String) request.getParameter("name");
    	  String pass = (String) request.getParameter("pass");
    	  
    	  String str = (String) request.getParameter("veryCode");
    	  
    	  HttpSession session = request.getSession();         
          session.setAttribute("userInfo", name);  
    	  
    	  String flag = "false";
    	  if(validateC.equalsIgnoreCase(str) || validateC.equals(str)){
    		  
    	  } else {
    		  flag = "false";
    		  model.put("flag", flag);
    		  return "/jsp/main.html";
    	  }
    	  
    	  if(name.equals("miao") && pass.equals("miao")){
    		  flag = "success";
    		  model.put("flag", flag);
    		  return "/jsp/main.html";
    	  }
    	  //jsp/main.html
    	return "/jsp/main.html";
    }
    
    @RequestMapping(value = "/init")
    public String getInit(HttpServletRequest request, ModelMap model, HttpServletResponse response){
    	/*String checkCode ;
    	try {
    		checkCode = myUtil.getRandomChar();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}*/
    	
    	return "/jsp/test.html";
    }
}
