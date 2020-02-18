package com.example.demo.Mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.example.demo.Domain.WorkDateType;

@Mapper
public interface WorkDateMapper {
	// 全検索
	@Select("SELECT * FROM workDate")
	List<WorkDateType> findAll();

	// 新規作成
	@Insert("INSERT INTO workDate (workDateId,workDateName,inputAddorSubYear,inputAddOrSubMonth,inputAddorSubDay)VALUE(#{workDateId},#{workDateName},#{inputAddOrSubYear},#{inputAddOrSubMonth},#{inputAddOrSubDay})")
	void createWorkDateType(WorkDateType workDataType);

	// id検索
	@Select("SELECT * FROM workDate where id=#{id}")
	WorkDateType findOneById(Integer id);

	// 編集
	@Update("UPDATE workDate set workDateId=#{workDateId},workDateName=#{workDateName},inputAddOrSubYear=#{inputAddOrSubYear},inputAddOrSubMonth=#{inputAddOrSubMonth},inputAddOrSubDay=#{inputAddOrSubDay} where id=#{id}")
	void update(WorkDateType workDateType);

	// 削除
	@Delete("DELETE FROM workDate where id = #{id}")
	void deleteWorkDateType(Integer id);

	// 日付ID検索
	@Select("SELECT * FROM workDate where workDateId = #{workDateId}")
	List<WorkDateType> searchByWorkDateId(String workDateId);

//	// IDで検索
//	@Select("SELECT * FROM work_data where id=#{id}")
//	WorkDate searchById(Integer id);
//
////		全件削除
//	@Delete("DELETE  FROM work_data")
//	void deleteAll();

}
