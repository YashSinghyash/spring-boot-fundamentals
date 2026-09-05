package com.restlearn.springboot.first_rest_api.survey;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.assertj.MockMvcTester;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

//SurveyResource
@WebMvcTest(controllers = SurveyResource.class)
@AutoConfigureMockMvc(addFilters = false)
public final class SurveyResourceTest {
    //MOCK -> surveyService.retrieveSpecificSurveyQuestion(surveyId , questionId)

    @MockitoBean
    private SurveyService surveyService;

    @Autowired
    private MockMvc mockMvc;
    // /surveys/{surveyId}/questions/{questionId}
    // http://localhost:8080/surveys/Survey1/questions/Question1 GET


    private static String SPECIFIC_QUESTION_URL = "http://localhost:8080/surveys/Survey1/questions/Question1";
    private static String GENERIC_QUESTIONS_URL = "/surveys/Survey1/questions";


    @Test
    void retriveSpecificSurveyQuestion_404Scenerio() throws Exception {
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get(SPECIFIC_QUESTION_URL).accept(MediaType.APPLICATION_JSON);
        MvcResult mvcResult = mockMvc.perform(requestBuilder).andReturn();
        assertEquals(404, mvcResult.getResponse().getStatus());

    }

    @Test
    void retriveSpecificSurveyQuestion_basicScenerio() throws Exception {
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get(SPECIFIC_QUESTION_URL).accept(MediaType.APPLICATION_JSON);

        Question question = new Question("Question1", "Most Popular Cloud Platform Today",
                Arrays.asList("AWS", "Azure", "Google Cloud", "Oracle Cloud"),
                "AWS");
        when(surveyService.retriveSpecificSurveyQuestion("Survey1", "Question1")).thenReturn(question);
        MvcResult mvcResult = mockMvc.perform(requestBuilder).andReturn();
        String expectedResponse = """
        {"id":"Question1","description":"Most Popular Cloud Platform Today","options":["AWS","Azure","Google Cloud","Oracle Cloud"],"correctAnswer":"AWS"}""";
        System.out.println(mvcResult.getResponse().getContentAsString());
        assertEquals(200, mvcResult.getResponse().getStatus());
        JSONAssert.assertEquals(expectedResponse , mvcResult.getResponse().getContentAsString() , false);
    }

    // addNewSurveyQuestion
    @Test
    void addNewSurveyQuestion_basicScenario() throws Exception {
        String requestBody = """
        {
            "description": "Favorite language",
            "options": [
                "Python",
                "C++",
                "Java",
                "JavaScript"
            ],
            "correctAnswer": "C++"
        }""";

        RequestBuilder requestBuilder = MockMvcRequestBuilders.post(GENERIC_QUESTIONS_URL).
                accept(MediaType.APPLICATION_JSON).content(requestBody).contentType(MediaType.APPLICATION_JSON);

        when(surveyService.addNewSurveyQuestion(anyString(), any())).thenReturn("SOME_ID");


        MvcResult mvcResult = mockMvc.perform(requestBuilder).andReturn();
        String locationHeader = mvcResult.getResponse().getHeader("Location");
        assertEquals(201, mvcResult.getResponse().getStatus());
        assertTrue(locationHeader.contains("/surveys/Survey1/questions/SOME_ID"));

    }

}
