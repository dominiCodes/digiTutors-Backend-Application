package com.exam.model;

public class LeaderBoardRequest {
	    private Long quiz;
	    private Long user;
	    private int userScorePerQuiz;
		

		public Long getQuiz() {
			return quiz;
		}


		public void setQuiz(Long quiz) {
			this.quiz = quiz;
		}


		public Long getUser() {
			return user;
		}


		public void setUser(Long user) {
			this.user = user;
		}


		public int getUserScorePerQuiz() {
			return userScorePerQuiz;
		}


		public void setUserScorePerQuiz(int userScorePerQuiz) {
			this.userScorePerQuiz = userScorePerQuiz;
		}


//		public LeaderBoardRequest(Long quiz, Long user, int userScorePerQuiz) {
//			super();
//			this.quiz = quiz;
//			this.user = user;
//			this.userScorePerQuiz = userScorePerQuiz;
//		}


		public LeaderBoardRequest() {}
	}

