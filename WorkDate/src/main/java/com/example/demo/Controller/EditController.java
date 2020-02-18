package com.example.demo.Controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.Domain.WorkDateType;
import com.example.demo.Form.WorkDateTypeRegistForm;
import com.example.demo.Service.WorkDateService;

@Controller
public class EditController {

	@Autowired
	WorkDateService workDateService;

	@ModelAttribute
	WorkDateTypeRegistForm setUpWorkDateTypeRegistFrom() {
		return new WorkDateTypeRegistForm();
	}

//	編集画面に遷移
	@PostMapping(value = "edit", params = "edit")
	String workDateTypeEditForm(@RequestParam Integer id, WorkDateTypeRegistForm form) {
		System.out.println(id);
		System.out.println(form);
		WorkDateType workDateType = workDateService.findOneById(id);
		BeanUtils.copyProperties(workDateType, form);
		System.out.println(workDateType);
		System.out.println(form);
		return "edit";
	}

//編集処理
	@PostMapping(value = "edit")
	String workDateTypeEdit(@RequestParam Integer id, @Validated WorkDateTypeRegistForm form, BindingResult result) {
		System.out.println(id);
		System.out.println(form);

		if (result.hasErrors()) {
			return workDateTypeEditForm(id, form);
		}

		WorkDateType workDateType = new WorkDateType();
		BeanUtils.copyProperties(form, workDateType);
		workDateType.setId(id);
		System.out.println(workDateType);
		workDateService.update(workDateType);
		return "redirect:/";
	}

// トップページへ戻る
	@PostMapping(value = "edit", params = "GoToTop")
	String goToTopFromRegist() {
		return "redirect:/";
	}

}
