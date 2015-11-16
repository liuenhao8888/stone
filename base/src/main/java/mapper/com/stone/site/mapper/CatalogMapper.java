package com.stone.site.mapper;

import java.util.List;

import org.apache.ibatis.annotations.*;

import com.stone.site.model.Catalog;

public interface CatalogMapper {
	
	@Insert("insert into catalog(name,pid) values(#{name},#{pid})")
	void add(Catalog c);
	
	@Select("SELECT * FROM catalog where pid = #{pid} ORDER BY priority DESC")
	Catalog listAll(int pid);
	
	@Select("SELECT * FROM catalog where pid = #{pid} and status = #{status} ORDER BY priority DESC")
	Catalog list(Catalog c);
	
	@Select("SELECT * FROM catalog where pid != 0")
	Catalog listSub();
	
	@Select("SELECT * FROM catalog where id = #{id}")
	Catalog find(int id);
	
	@Update("update catalog set name = #{name} where id = #{id}")
	void update(Catalog c);
	
	@Update("update catalog set status = #{status} where id = #{id}")
	void updateStatus(Catalog c);
	
	@Delete("delete from catalog where id = #{id}")
	void delete(int id);
	
	@Delete("delete from catalog where pid = #{pid}")
	void deleteSubList(int pid);
	
	
	@Update("update catalog set priority = #{priority} where id = #{id}")
	void updatePris(List<Catalog> l);
	
	@Delete("delete from catalog where pid = #{pid}")
	void deleteList(int pid);
}
