package com.exam.model;

import javax.persistence.*;

import com.exam.model.exam.Quiz;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class LeaderBoard {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

	@ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "user_id")
    private User user;

	@ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "quiz_id")
    private Quiz quiz;

    private int userScorePerQuiz;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Quiz getQuiz() {
		return quiz;
	}

	public void setQuiz(Quiz quiz) {
		this.quiz = quiz;
	}

	
    
//    private Double userScorePerCat;
	
	public int getUserScorePerQuiz() {
		return userScorePerQuiz;
	}

	public void setUserScorePerQuiz(int userScorePerQuiz) {
		this.userScorePerQuiz = userScorePerQuiz;
	}

	public LeaderBoard() {
		
	}

	public LeaderBoard(User user2, Quiz quiz2, int userScore) {
		// TODO Auto-generated constructor stub
		this.user= user2;
		this.quiz=quiz2;
		this.userScorePerQuiz= userScore;
	}

	@Override
	public String toString() {
		return "LeaderBoard [id=" + id + ", user=" + user + ", quiz=" + quiz + ", userScorePerQuiz=" + userScorePerQuiz
				+ "]";
	}

	

}
