package com.example.demo.RestApiController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Domain.WorkDateType;
import com.example.demo.Service.WorkDateService;

@RequestMapping("index")
@RestController
public class IndexApiController {

	@Autowired
	WorkDateService workDateService;

	@GetMapping
	List<WorkDateType> IndexWorkDateType() {
		List<WorkDateType> workDateType = workDateService.findAll();
		return workDateType;
	}
}