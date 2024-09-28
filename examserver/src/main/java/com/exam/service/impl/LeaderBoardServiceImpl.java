package com.exam.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.model.LeaderBoard;
import com.exam.model.LeaderBoardRequest;
import com.exam.model.User;
import com.exam.model.exam.Quiz;
import com.exam.repo.LeaderBoardRepository;
import com.exam.repo.QuizRepository;
import com.exam.repo.UserRepository;
import com.exam.service.LeaderBoardService;

@Service
public class LeaderBoardServiceImpl implements LeaderBoardService{

	@Autowired
	LeaderBoardRepository leaderBoardRepo;
	
	@Autowired 
	QuizRepository quizRepo;
	
	@Autowired
	UserRepository userRepo;
	
	
	
	@Override
//	public LeaderBoard updateLeaderBoard(LeaderBoard leaderBoard) {
//		// TODO Auto-generated method stub
//		LeaderBoard lb= new LeaderBoard();
//		lb.setId(leaderBoard.getId());
//		Quiz quiz= new Quiz();
//		quiz.setqId(leaderBoard.getQuiz().getqId());
//		User user= new User();
//		user.setId(leaderBoard.getUser().getId());
//		lb.setQuiz(quiz);
//		lb.setUser(user);
//		return this.leaderBoardRepo.save(lb);
//	}
	
	
//	 @Override
	    public LeaderBoard updateLeaderBoard(LeaderBoardRequest request) {
//			lb.setId(request.g);
	        Quiz quiz = quizRepo.findById(request.getQuiz()).get();
	        User user = userRepo.findById(request.getUser()).get();
	         
	        // Calculate the score and update the leaderboard
	        // ... (your score calculation logic here)
	        

	        LeaderBoard updatedLeaderBoard = leaderBoardRepo.save(new LeaderBoard(user, quiz, request.getUserScorePerQuiz()));
	        return updatedLeaderBoard;
	       
}
		public List<LeaderBoard> getLeaderboardData(){
			List<LeaderBoard> list= new ArrayList<>();
			list =leaderBoardRepo.findAllByOrderByUserScorePerQuizDesc();
			return list;
		}
	
		
		public List<User> getAllUsersOrderByUserScoreDesc() {
	        return leaderBoardRepo.findAllUsersOrderByUserScoreDesc();
	    }
		
		public User getUserByLeaderBoardId(Long leaderBoardId) {
	        return leaderBoardRepo.findUserByLeaderBoardId(leaderBoardId);
	    }

		

	

//	@Override
	public LeaderBoard updateLeaderBoard(LeaderBoard leaderboard) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getScroePerQuiz(LeaderBoard lb) {
		
		return 0;
	}

}
