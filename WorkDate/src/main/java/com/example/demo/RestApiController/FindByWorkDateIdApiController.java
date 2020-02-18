package com.example.demo.RestApiController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Domain.WorkDateType;
import com.example.demo.Service.WorkDateService;

@RestController
@RequestMapping("search/{workDateId}")
public class FindByWorkDateIdApiController {

	@Autowired
	WorkDateService workDateService;

	@GetMapping
	List<WorkDateType> findOneByWorkDateId(@PathVariable String workDateId) {
		List<WorkDateType> workDateTypeList = workDateService.searchByWorkDateId(workDateId);
		return workDateTypeList;
	}
}