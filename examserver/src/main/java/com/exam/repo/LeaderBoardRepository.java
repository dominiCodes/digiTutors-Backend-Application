package com.exam.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.exam.model.LeaderBoard;
import com.exam.model.User;
import com.exam.model.exam.Category;

public interface LeaderBoardRepository extends JpaRepository<LeaderBoard, Long>{
	 List<LeaderBoard> findAllByOrderByUserScorePerQuizDesc();
	 
	 @Query("SELECT DISTINCT lb.user FROM LeaderBoard lb ORDER BY lb.userScorePerQuiz DESC")
	    List<User> findAllUsersOrderByUserScoreDesc();
	 
	 @Query("SELECT lb.user FROM LeaderBoard lb WHERE lb.id = :leaderBoardId")
	    User findUserByLeaderBoardId(@Param("leaderBoardId") Long leaderBoardId);
}
