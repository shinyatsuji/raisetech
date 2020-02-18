package com.example.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Domain.WorkDateType;
import com.example.demo.Mapper.WorkDateMapper;

@Service
public class WorkDateService {

	@Autowired
	WorkDateMapper workDateMapper;

//全検索
	public List<WorkDateType> findAll() {
		return workDateMapper.findAll();
	}

//新規作成
	public void createWorkDateType(WorkDateType workDataType) {
		workDateMapper.createWorkDateType(workDataType);
	}

//id検索
	public WorkDateType findOneById(Integer id) {
		return workDateMapper.findOneById(id);

	}

//編集
	public void update(WorkDateType workDateType) {
		workDateMapper.update(workDateType);
	}

//削除
	public void deleteWorkDateType(Integer id) {
		workDateMapper.deleteWorkDateType(id);
	}

//日付ID検索
	public List<WorkDateType> searchByWorkDateId(String workDateId) {
		return workDateMapper.searchByWorkDateId(workDateId);
	}

//	public WorkData searchById(Integer id) {
//
//		return workDataMapper.searchById(id);
//	}
//
////	全件削除
//	public void deleteAll() {
//		workDataMapper.deleteAll();
//	}
////

}
