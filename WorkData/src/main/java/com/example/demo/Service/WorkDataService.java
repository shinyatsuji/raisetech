package com.example.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Domain.WorkData;
import com.example.demo.Form.Data_id_Form;
import com.example.demo.Form.WorkDataForm;
import com.example.demo.Mapper.WorkDataMapper;

@Service
public class WorkDataService {

	@Autowired
	WorkDataMapper workDataMapper;

//全検索
	public List<WorkData> findAll() {
		return workDataMapper.findAll();
	}

//新規作成
	public void create(WorkDataForm workDataForm) {
		workDataMapper.create(workDataForm);
	}

//id検索
	public WorkData findOne(Integer id) {
		return workDataMapper.findOne(id);

	}

//編集
	public void update(WorkData data) {
		workDataMapper.update(data);
	}

//削除
	public void delete(Integer id) {
		workDataMapper.delete(id);
	}

//日付ID検索
	public List<WorkData> searchByData_Id(Data_id_Form form) {
		return workDataMapper.searchDataId(form);
	}
}
