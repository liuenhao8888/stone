package com.stone.site.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.stone.base.exception.DaoException;
import com.stone.base.service.MybatisBaseServiceImpl;
import com.stone.site.mapper.RSVoteMapper;
import com.stone.site.mapper.RecSiteMapper;
import com.stone.site.model.RSVote;

@Service("rsvoteService")
public class RSVoteServiceImpl extends MybatisBaseServiceImpl implements
		IRSVoteService {

	@SuppressWarnings("finally")
	@Override
	@Transactional(rollbackFor = { DaoException.class })
	public int vote(RSVote rsv) {
			int length = this.getIbatisBaseDao().countObject(RSVoteMapper.class.getName() + ".count", rsv);
			if(length>0)return -1;
			this.getIbatisBaseDao().insertObject(RSVoteMapper.class.getName() + ".add", rsv);
			if(rsv.getType()==0){
				this.getIbatisBaseDao().updateObject(RecSiteMapper.class.getName()+".updateNegnum",rsv.getRsid());
				length = this.getIbatisBaseDao().countObject(RecSiteMapper.class.getName()+".findNegnum", rsv.getRsid());
			}else{
				this.getIbatisBaseDao().updateObject(RecSiteMapper.class.getName()+".updatePosnum", rsv.getRsid());
				length = this.getIbatisBaseDao().countObject(RecSiteMapper.class.getName()+".findPosnum", rsv.getRsid());
			}
			return length;
	}
}
