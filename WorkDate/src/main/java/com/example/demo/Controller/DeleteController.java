package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.Service.WorkDateService;

//削除機能

@Controller
public class DeleteController {

	@Autowired
	WorkDateService workDateService;

	@PostMapping(value = "delete")
	String WorkDateTypeDelete(@RequestParam Integer id) {
		workDateService.deleteWorkDateType(id);
		return "redirect:/";
	}
}
