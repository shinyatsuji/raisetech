package com.example.demo.Controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.Domain.WorkDateType;
import com.example.demo.Form.WorkDateTypeRegistForm;
import com.example.demo.Service.WorkDateService;

//新規登録
@Controller
public class RegistController {

	@Autowired
	WorkDateService workDateService;

	@ModelAttribute
	WorkDateTypeRegistForm setUpWorkDateTypeRegistForm() {
		return new WorkDateTypeRegistForm();
	}

	// 画面遷移
	@GetMapping(value = "create")
	String workDateTypeRegistForm() {
		return "regist";
	}

	// 登録
	@PostMapping(value = "create")
	String workDateTypeRegist(Model model, @Validated WorkDateTypeRegistForm form, BindingResult result) {
		if (result.hasErrors()) {
			return workDateTypeRegistForm();
		}

		WorkDateType workDateType = new WorkDateType();
		BeanUtils.copyProperties(form, workDateType);
		workDateService.createWorkDateType(workDateType);
		return "redirect:/";
	}

	// トップページへ戻る
	@PostMapping(value = "create", params = "GoToTop")
	String goToTopFromRegist() {
		return "redirect:/";
	}

}
