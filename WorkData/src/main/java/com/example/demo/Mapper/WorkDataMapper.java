package com.example.demo.Mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.example.demo.Domain.WorkData;
import com.example.demo.Form.WorkDataForm;

@Mapper
public interface WorkDataMapper {
//全検索
	@Select("SELECT * FROM work_data")
	List<WorkData> findAll();

//新規作成
	@Insert("INSERT INTO work_data (data_id,data_name,calc_year,calc_month,calc_day)VALUE(#{data_id},#{data_name},#{calc_year},#{calc_month},#{calc_day})")
	void create(WorkDataForm workDataForm);

//id検索
	@Select("SELECT * FROM work_data where id=#{id}")
	WorkData findOne(Integer id);

//編集
	@Update("UPDATE work_data set data_id=#{data_id},data_name=#{data_name},calc_year=#{calc_year},calc_month=#{calc_month},calc_day=#{calc_day} where id=#{id}")
	void update(WorkData data);

//削除
	@Delete("DELETE FROM work_data where id = #{id}")
	void delete(Integer id);

//日付ID検索
	@Select("SELECT * FROM work_data where data_id = #{data_id}")
	List<WorkData> searchDataId(String data_id);

//IDで検索
	@Select("SELECT * FROM work_data where id=#{id}")
	WorkData searchById(Integer id);

}
