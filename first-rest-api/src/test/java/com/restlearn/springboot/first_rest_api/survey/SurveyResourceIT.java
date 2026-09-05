package com.restlearn.springboot.first_rest_api.survey;

import org.json.JSONException;
import org.jspecify.annotations.NonNull;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.resttestclient.autoconfigure.AutoConfigureTestRestTemplate;
import org.springframework.boot.resttestclient.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import java.util.Base64;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureTestRestTemplate
public class SurveyResourceIT {

    private static String SPECIFIC_QUESTION_URL = "/surveys/Survey1/questions/Question1";
    private static String GENERIC_QUESTIONS_URL = "/surveys/Survey1/questions";

    @Autowired
    private TestRestTemplate template;


    @Test
    void retriveSpecificSurveyQuestion_basicScenario() throws JSONException {
        HttpHeaders headers = getHttpHeaders();

        HttpEntity<String> httpEntity = new HttpEntity<String>(null, headers);
        ResponseEntity<String> responseEntity = template.exchange(SPECIFIC_QUESTION_URL, HttpMethod.GET, httpEntity, String.class);


        String expectedResponse = """
                            {"id":"Question1","description":"Most Popular Cloud Platform Today",
                            "correctAnswer":"AWS"}""";


        assertTrue(responseEntity.getStatusCode().is2xxSuccessful());
        assertEquals("application/json",responseEntity.getHeaders().get("Content-Type").get(0));
        JSONAssert.assertEquals(expectedResponse , responseEntity.getBody() , false);


        /*[Content-Type : "/applications.json",
        Status of Response is it 200]*/
    }

    @Test
    void retriveAllSurveyQuestions_basicScenario() throws JSONException {
        HttpHeaders headers = getHttpHeaders();

        HttpEntity<String> httpEntity = new HttpEntity<String>(null, headers);
        ResponseEntity<String> responseEntity = template.exchange(GENERIC_QUESTIONS_URL, HttpMethod.GET, httpEntity, String.class);

        String expectedResponse = """
          [
              {
                  "id": "Question1"
              },
              {
                  "id": "Question2"
              },
              {
                  "id": "Question3"
              }
          ]""";


        assertTrue(responseEntity.getStatusCode().is2xxSuccessful());
        assertEquals("application/json",responseEntity.getHeaders().get("Content-Type").get(0));
        JSONAssert.assertEquals(expectedResponse , responseEntity.getBody() , false);

    }



    @Test
    void addNewSurveyQuestion_basicScenario(){
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

        HttpHeaders headers = getHttpHeaders();

        HttpEntity<String> httpEntity = new HttpEntity<String>(requestBody, headers);
        ResponseEntity<String> responseEntity = template.exchange(GENERIC_QUESTIONS_URL, HttpMethod.POST, httpEntity, String.class);
        System.out.println(responseEntity.getHeaders());
        assertTrue(responseEntity.getStatusCode().is2xxSuccessful());
        String location = responseEntity.getHeaders().get("Location").get(0);
        assertTrue(location.contains("/surveys/Survey1/questions/"));

        ResponseEntity<String> responseEntityDelete = template.exchange(location , HttpMethod.DELETE , httpEntity , String.class);
        assertTrue(responseEntityDelete.getStatusCode().is2xxSuccessful());
        //template.delete(location);
    }

    private @NonNull HttpHeaders getHttpHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type" , "application/json" );
        headers.add("Authorization" , "Basic " +  performBasicAuthEncoding("admin" ,"dummy" ));
        return headers;
    }

    String performBasicAuthEncoding(String user, String password){
        String combined = user + ":" + password;
        //Base64 Encoding => Bytes
        byte[] encodedBytes = Base64.getEncoder().encode(combined.getBytes());
        return new String(encodedBytes);
    }
}