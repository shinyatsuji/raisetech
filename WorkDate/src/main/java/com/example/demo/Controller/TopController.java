package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.Domain.WorkDateType;
import com.example.demo.Form.WorkDateCalcForm;
import com.example.demo.Service.WorkDateService;

@RequestMapping
@Controller
public class TopController {

	@Autowired
	WorkDateService workDateService;

	@ModelAttribute
	WorkDateCalcForm setUpWorkDateCalcForm() {
		return new WorkDateCalcForm();
	}

	@GetMapping
	String IndexWorkDate(Model model) {
		List<WorkDateType> list = workDateService.findAll();
		model.addAttribute("lists", list);
		return "index";
	}
}
