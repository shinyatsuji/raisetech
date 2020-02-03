package com.example.demo.Form;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class WorkDataForm {

	@Size(min = 1, max = 6, message = "６文字以内で入力して下さい。")
	private String data_id;

	@Size(min = 1, max = 6, message = "６文字以内で入力して下さい。")
	private String data_name;

//	@Size(min = 1, max = 8, message = "８文字以内で入力して下さい。")
//	private String calc_result;

	@NotNull(message = "未入力です。")
	private Integer calc_year;

	@NotNull(message = "未入力です。")
	private Integer calc_month;

	@NotNull(message = "未入力です。")
	private Integer calc_day;
}
