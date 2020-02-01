package com.example.demo.Form;

import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class Data_id_Form {

	@Size(min = 1, max = 6, message = "６文字以内で入力して下さい。")
	private String data_id;

}
