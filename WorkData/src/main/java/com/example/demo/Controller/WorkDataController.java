package com.example.demo.Controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.Domain.WorkData;
import com.example.demo.Form.CalcData_Form;
import com.example.demo.Form.Data_id_Form;
import com.example.demo.Form.WorkDataForm;
import com.example.demo.Service.WorkDataService;

@RequestMapping()
@RestController
public class WorkDataController {

	@Autowired
	WorkDataService workDataService;

	@ModelAttribute
	WorkDataForm setUpForm() {
		return new WorkDataForm();
	}

	@ModelAttribute
	Data_id_Form setUpIdForm() {
		return new Data_id_Form();
	}

	@ModelAttribute
	CalcData_Form setCalcForm() {
		return new CalcData_Form();
	}

//一覧表示
	@GetMapping
	ModelAndView getWorkData(ModelAndView mav) {
		List<WorkData> list = workDataService.findAll();
		mav.addObject("lists", list);
		mav.setViewName("index");
		return mav;
	}

//新規作成　画面表示
	@GetMapping(value = "create")
	ModelAndView creatFormWorkData(ModelAndView mav) {
		mav.setViewName("create");
		return mav;
	}

//新規作成　
	@PostMapping(value = "create")
	ModelAndView createWorkData(ModelAndView mav, @Validated WorkDataForm workDataForm, BindingResult result) {
		if (result.hasErrors()) {
			return creatFormWorkData(mav);
		}
		WorkData workData = new WorkData();
		BeanUtils.copyProperties(workDataForm, workData);
		workDataService.create(workData);
		mav.setViewName("redirect:/");
		return mav;
	}

//編集画面　表示	
	@PostMapping(value = "edit", params = "edit_form")
	ModelAndView edit_WD_Form(ModelAndView mav, @RequestParam Integer id) {
		WorkData data = workDataService.findOne(id);
		mav.addObject("workData", data);
		mav.setViewName("edit");
		return mav;
	}

//編集
	@PostMapping(value = "edit")
	ModelAndView edit(ModelAndView mav, @RequestParam Integer id, @Validated WorkDataForm form, BindingResult result) {
		if (result.hasErrors()) {
			return edit_WD_Form(mav, id);
		}

		WorkData data = new WorkData();
		BeanUtils.copyProperties(form, data);
		data.setId(id);
		workDataService.update(data);
		mav.setViewName("redirect:/");
		return mav;
	}

// 初期画面に戻る(編集)
	@PostMapping(value = "edit", params = "GoToTop")
	ModelAndView goToTop_from_edit(ModelAndView mav) {
		mav.setViewName("redirect:/");
		return mav;
	}

//削除
	@PostMapping(value = "delete")
	ModelAndView delete(ModelAndView mav, @RequestParam Integer id) {
		workDataService.delete(id);
		mav.setViewName("redirect:/");
		return mav;
	}

//日付ID　検索画面
	@GetMapping(value = "search")
	ModelAndView searchForm(ModelAndView mav) {
		mav.setViewName("list");
		return mav;
	}

//日付ID　検索
	@PostMapping(value = "search")
	ModelAndView searchDataId(ModelAndView mav, @Validated Data_id_Form form, BindingResult result) {
		if (result.hasErrors()) {
			return searchForm(mav);
		}
		String data_id = form.getData_id();
		List<WorkData> dataIdSearch = workDataService.searchByData_Id(data_id);
		mav.addObject("lists", dataIdSearch);
		mav.setViewName("list");
		return mav;
	}

// 初期画面に戻る(新規作成)
	@PostMapping(value = "create", params = "GoToTop")
	ModelAndView goToTop_from_create(ModelAndView mav) {
		mav.setViewName("redirect:/");
		return mav;
	}

//初期画面に戻る
	@PostMapping(value = "search", params = "GoToTop")
	ModelAndView goToTop(ModelAndView mav) {
		mav.setViewName("redirect:/");
		return mav;
	}

//計算リセット
	@PostMapping(value = "calc", params = "reset")
	ModelAndView reset(ModelAndView mav) {
		mav.setViewName("redirect:/");
		return mav;
	}

//日付計算
	@PostMapping(value = "calc")
	ModelAndView calcData(ModelAndView mav, @Validated CalcData_Form form, BindingResult result) {
		if (result.hasErrors()) {
			return getWorkData(mav);
		}
//フォームから情報取得	
		LocalDate date = form.getDate();

		System.out.println(date);
		Integer id = form.getId();
//idから加減する年/月/日を取得
		WorkData wd = workDataService.searchById(id);
		Integer year = wd.getCalc_year();
		Integer month = wd.getCalc_month();
		Integer day = wd.getCalc_day();
//入力した年月日に加減
		date = date.plusYears(year);
		date = date.plusMonths(month);
		date = date.plusDays(day);
		mav.addObject("date", date);
		mav.addObject("wd", wd);
		System.out.println(mav);
		mav.setViewName("index");
		return mav;
	}
}
