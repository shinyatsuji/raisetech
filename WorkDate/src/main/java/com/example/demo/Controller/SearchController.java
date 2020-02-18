package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.Domain.WorkDateType;
import com.example.demo.Form.WorkDateTypeSearchByIdForm;
import com.example.demo.Service.WorkDateService;

@Controller
public class SearchController {

	@Autowired
	WorkDateService workDateService;

	@ModelAttribute
	WorkDateTypeSearchByIdForm setUpWorkDateSearchByIdForm() {
		return new WorkDateTypeSearchByIdForm();
	}

	@GetMapping(value = "search")
	String searchWorkDateTypeForm() {
		return "search";
	}

	@PostMapping(value = "search")
	String searchWorkDateType(@Validated WorkDateTypeSearchByIdForm form, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "search";
		}

		String workDateId = form.getWorkDateId();
		List<WorkDateType> workDateType = workDateService.searchByWorkDateId(workDateId);
		model.addAttribute("lists", workDateType);
		System.out.println(model);
		return "search";
	}

	// トップページへ戻る
	@PostMapping(value = "search", params = "GoToTop")
	String goToTopFromSearch() {
		return "redirect:/";
	}

}
