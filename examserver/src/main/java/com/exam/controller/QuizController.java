package com.exam.controller;

import com.exam.model.LeaderBoard;
import com.exam.model.LeaderBoardRequest;
import com.exam.model.User;
import com.exam.model.exam.Category;
import com.exam.model.exam.Quiz;
import com.exam.service.LeaderBoardService;
import com.exam.service.QuizService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin("*")
@RequestMapping("/quiz")
public class QuizController {
    @Autowired
    private QuizService quizService;
    
    @Autowired
    private LeaderBoardService leaderBoardService;
    
    public QuizController(LeaderBoardService leaderBoardService) {
        this.leaderBoardService = leaderBoardService;
    }

    //add quiz service
    @PostMapping("/")
    public ResponseEntity<Quiz> add(@RequestBody Quiz quiz) {
        return ResponseEntity.ok(this.quizService.addQuiz(quiz));
    }

    //update quiz

    @PutMapping("/")
    public ResponseEntity<Quiz> update(@RequestBody Quiz quiz) {
        return ResponseEntity.ok(this.quizService.updateQuiz(quiz));
    }

    //get quiz
    @GetMapping("/")
    public ResponseEntity<?> quizzes() {
        return ResponseEntity.ok(this.quizService.getQuizzes());
    }

    //get single quiz
    @GetMapping("/{qid}")
    public Quiz quiz(@PathVariable("qid") Long qid) {
        return this.quizService.getQuiz(qid);
    }

    //delete the quiz
    @DeleteMapping("/{qid}")
    public void delete(@PathVariable("qid") Long qid) {
        this.quizService.deleteQuiz(qid);
    }

    @GetMapping("/category/{cid}")
    public List<Quiz> getQuizzesOfCategory(@PathVariable("cid") Long cid) {
        Category category = new Category();
        category.setCid(cid);
        return this.quizService.getQuizzesOfCategory(category);
    }

    //get active quizzes
    @GetMapping("/active")
    public List<Quiz> getActiveQuizzes() {
        return this.quizService.getActiveQuizzes();
    }

    //get active quizzes of category
    @GetMapping("/category/active/{cid}")
    public List<Quiz> getActiveQuizzes(@PathVariable("cid") Long cid) {
        Category category = new Category();
        category.setCid(cid);
        return this.quizService.getActiveQuizzesOfCategory(category);
    }
    
    @PostMapping("/leaderboard")
    public ResponseEntity<LeaderBoard> updateLeaderBoard(@RequestBody LeaderBoardRequest request) {
        LeaderBoard updatedLeaderBoard = leaderBoardService.updateLeaderBoard(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(updatedLeaderBoard);
    }
    
  //get user Score
  //get single quiz
//    @GetMapping("/leaderboard")
//    public List<LeaderBoard> getLeaderboardData() {
//        return leaderBoardService.getLeaderboardData();
//        
//    }
    
    @GetMapping("/leaderboard")
    public ResponseEntity<List<LeaderBoard>> getAllLeaderBoardData() {
        List<LeaderBoard> leaderBoardData = leaderBoardService.getLeaderboardData();
        
        return new ResponseEntity<>(leaderBoardData, HttpStatus.OK);
        
        
    }
    
    @GetMapping("/leaderboard/users")
    public ResponseEntity<List<User>> getAllUsersOrderByUserScoreDesc() {
        List<User> users = leaderBoardService.getAllUsersOrderByUserScoreDesc();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }
    
    
    }
    
    
    


