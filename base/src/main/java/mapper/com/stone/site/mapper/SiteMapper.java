package com.stone.site.mapper;


import java.util.List;

import org.apache.ibatis.annotations.*;

import com.stone.site.model.Site;

public interface SiteMapper {
	
	@Insert("insert into site(name,url,cid) values(#{name},#{url},#{cid})")
	void add(Site site);
	
	@Select("SELECT * FROM site where cid = #{cid} ORDER BY priority ,id DESC")
	Site list(int cid);
	
	@Select("SELECT * FROM site where id = #{id}")
	Site find(int id);
	
	@Update("update site set name = #{name},url = #{url} where id = #{id}")
	void update(Site site);
	
	@Update("update site set priority = #{priority} where id = #{id}")
	void updatePris(List<Site> l);
	
	@Delete("delete from site where id = #{id}")
	void delete(int id);
	
	@Delete("delete from recSite where pid = #{cid}")
	void deleteByCid(int cid);
}
