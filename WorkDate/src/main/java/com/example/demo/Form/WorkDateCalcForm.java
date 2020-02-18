package com.example.demo.Form;

import java.time.LocalDate;

import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class WorkDateCalcForm {

	@NotNull(message = "未入力")
	private Integer id;
	@NotNull(message = "未入力")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate inputDate;
}
