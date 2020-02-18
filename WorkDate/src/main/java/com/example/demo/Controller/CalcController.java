package com.example.demo.Controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.Domain.WorkDateType;
import com.example.demo.Form.WorkDateCalcForm;
import com.example.demo.Service.WorkDateService;

@Controller
public class CalcController {

	@Autowired
	WorkDateService workDateService;

	@GetMapping(value = "calc")
	String IndexWorkDate(Model model) {
		List<WorkDateType> list = workDateService.findAll();
		model.addAttribute("lists", list);
		return "calcResult";
	}

	@PostMapping(value = "calc")
	String WorkDateTypeCalc(@Validated WorkDateCalcForm form, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "index";
		}

		List<WorkDateType> list = workDateService.findAll();
		model.addAttribute("lists", list);

//入力フォームのidから計算式を取得して、年・月・日の増減値を取得。
		WorkDateType workDateType = workDateService.findOneById(form.getId());
		model.addAttribute("workDateType", workDateType);
		Integer inputAddOrSubYear = workDateType.getInputAddOrSubYear();
		Integer inputAddOrSubMonth = workDateType.getInputAddOrSubMonth();
		Integer inputAddOrSubDay = workDateType.getInputAddOrSubDay();

//入力フォームの日付に年・月・日の値の加減を行う。
		LocalDate inputDate = form.getInputDate();
		inputDate = inputDate.plusYears(inputAddOrSubYear);
		inputDate = inputDate.plusMonths(inputAddOrSubMonth);
		inputDate = inputDate.plusDays(inputAddOrSubDay);
		System.out.println(inputDate);
		model.addAttribute("inputDate", inputDate);
		return "calcResult";
	}

	// 計算リセット
	@PostMapping(value = "calc", params = "reset")
	String CalcReset() {
		return "redirect:/";
	}

}