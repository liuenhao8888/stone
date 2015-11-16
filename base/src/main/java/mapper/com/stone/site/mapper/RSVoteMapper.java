package com.stone.site.mapper;



import org.apache.ibatis.annotations.*;

import com.stone.site.model.RSVote;

public interface RSVoteMapper {
	
	@Insert("insert into rsvote(rsid,ip,type) values(#{rsid},#{ip},#{type})")
	void add(RSVote v);
	
	@Select("SELECT count(*) FROM rsvote where rsid = #{rsid} and ip = #{ip}")
	int count(RSVote v);
}
