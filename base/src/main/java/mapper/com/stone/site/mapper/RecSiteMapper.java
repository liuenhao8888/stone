package com.stone.site.mapper;



import org.apache.ibatis.annotations.*;

import com.stone.site.model.RecSite;

public interface RecSiteMapper {
	
	@Insert("insert into recSite(name,url,comment,cid,uid) values(#{name},#{url},#{comment},#{cid},#{uid})")
	void add(RecSite rs);
	
	@Select("SELECT * FROM recSite where cid = #{cid} ORDER BY posnum DESC")
	RecSite list(int cid);
	
	@Select("SELECT * FROM recSite where id = #{id}")
	RecSite find(int id);
	
	@Select("SELECT negnum FROM recSite where id = #{id}")
	int findNegnum(int id);
	
	@Select("SELECT posnum FROM recSite where id = #{id}")
	int findPosnum(int id);
	
	@Update("update recSite set name = #{name},url = #{url},comment = #{comment} where id = #{id}")
	void update(RecSite rs);
	
	@Update("update recSite set negnum = (negnum+1) where id = #{id}")
	void updateNegnum(int id);

	@Update("update recSite set posnum = (posnum+1) where id = #{id}")
	void updatePosnum(int id);
	
	@Delete("delete from recSite where id = #{id}")
	void delete(int id);
	
	@Delete("delete from recSite where pid = #{cid}")
	void deleteByCid(int cid);
}
