package com.example.demo.Form;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class WorkDateTypeRegistForm {

	@Size(min = 1, max = 8, message = "8文字以内で入力して下さい。")
	private String workDateId;

	@Size(min = 1, max = 8, message = "８文字以内で入力して下さい")
	private String workDateName;

	@NotNull(message = "未入力です。")
	private Integer inputAddOrSubYear;

	@NotNull(message = "未入力です。")
	private Integer inputAddOrSubMonth;

	@NotNull(message = "未入力です。")
	private Integer inputAddOrSubDay;
}
