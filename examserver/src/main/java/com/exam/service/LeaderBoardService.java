package com.exam.service;

import java.util.List;

import com.exam.model.LeaderBoard;
import com.exam.model.LeaderBoardRequest;
import com.exam.model.User;

public interface LeaderBoardService {

	public LeaderBoard updateLeaderBoard(LeaderBoard leaderboard);

	public LeaderBoard updateLeaderBoard(LeaderBoardRequest request);
	
	public int getScroePerQuiz(LeaderBoard lb);
	
	public List<LeaderBoard> getLeaderboardData();
	
	public List<User> getAllUsersOrderByUserScoreDesc();
       
    


}
