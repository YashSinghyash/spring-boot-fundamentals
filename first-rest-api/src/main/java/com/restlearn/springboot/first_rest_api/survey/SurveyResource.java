package com.restlearn.springboot.first_rest_api.survey;

import jakarta.servlet.Servlet;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Objects;

@RestController
public class SurveyResource {

    private final Servlet servlet;
    private SurveyService surveyService;

    public SurveyResource(SurveyService surveyService, Servlet servlet){
        super();
        this.surveyService = surveyService;
        this.servlet = servlet;
    }

    @RequestMapping("/surveys")
    public List<Survey> retrieveAllSurveys(){
        return surveyService.retriveAllSurveys();
    }

    @RequestMapping ("surveys/{surveyId}")
    public Survey retriveSurveyById(@PathVariable String surveyId){
        Survey survey = surveyService.retriveSurveyById(surveyId);
        if (survey == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        return survey;
    }

    @RequestMapping ("surveys/{surveyId}/questions")
    public List<Question> retriveAllSurveyQuestions(@PathVariable String surveyId){
        List<Question> questions = surveyService.retriveAllSurveyQuestions(surveyId);
        if (questions == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        return questions;
    }

    @RequestMapping ("surveys/{surveyId}/questions/{questionId}")
    public Question retriveSpecificSurveyQuestion(@PathVariable String surveyId , @PathVariable String questionId){
        Question question = surveyService.retriveSpecificSurveyQuestion(surveyId , questionId);
        if (question == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        return question;
    }

    @RequestMapping (value = "/surveys/{surveyId}/questions" , method = RequestMethod.POST)
    public ResponseEntity<Object> addNewSurveyQuestion(@PathVariable String surveyId , @RequestBody Question question){

        String questionId = surveyService.addNewSurveyQuestion(surveyId , question);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{questionId}")
                .buildAndExpand(questionId).toUri();
        return ResponseEntity.created(location).build();
    }

    @RequestMapping (value = "surveys/{surveyId}/questions/{questionId}" , method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteSurveyQuestion(@PathVariable String surveyId , @PathVariable String questionId){
        String s = surveyService.deleteSurveyQuestion(surveyId, questionId);
        if (s == null) return ResponseEntity.notFound().build();
        return ResponseEntity.noContent().build();
    }

    @RequestMapping (value = "surveys/{surveyId}/questions/{questionId}" , method = RequestMethod.PUT)
    public ResponseEntity<Object> updateSurveyQuestion(@PathVariable String surveyId , @PathVariable String questionId
                                                        ,@RequestBody Question question){
        String s = surveyService.updateSurveyQuestion(surveyId, questionId , question);
        if (s == null) return ResponseEntity.notFound().build();
        return ResponseEntity.noContent().build();
    }

}