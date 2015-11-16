package com.stone.site.service;



import org.springframework.stereotype.Service;

import com.stone.site.model.RSVote;


@Service
public interface IRSVoteService {

	public int vote(RSVote rsv);
	
	
}
