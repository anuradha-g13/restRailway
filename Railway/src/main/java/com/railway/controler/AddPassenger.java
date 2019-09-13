package com.railway.controler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
@Controller
public class AddPassenger {
	private static final long serialVersionUID = 1L;

	@RequestMapping("/AddPassenger")
	protected ModelAndView doGet(HttpServletRequest request, HttpServletResponse response)
			 {
		ModelAndView mv= new ModelAndView();
		mv.setViewName("addPassenger");
		return mv;
	}



}
