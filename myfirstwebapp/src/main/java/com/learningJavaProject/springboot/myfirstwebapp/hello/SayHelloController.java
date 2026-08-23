package com.learningJavaProject.springboot.myfirstwebapp.hello;



import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@Controller
public class SayHelloController {

    @RequestMapping("say-hello")
    @ResponseBody
    public String sayHello(){
        return "Hello! What are you learning today ?";
    }
    @RequestMapping("say-hello-html")
    @ResponseBody
    public String sayHelloHTML(){
        StringBuilder sb = new StringBuilder();
        sb.append("<html>");
        sb.append("<head>");
        sb.append("<title>Hello World</title>");
        sb.append("</head>");
        sb.append("<body>");
        sb.append("<h1>Hello World</h1>");
        sb.append("</body>");
        sb.append("</html>");

        return sb.toString();

    }
    ///Users/yashsingh/JAVA-coursera/myfirstwebapp/src/main/resources/META-INF/resources/WEB-INF/jsp/sayHello.jsp
    @RequestMapping("say-hello-jsp")
    public String sayHelloJSP(){
        return "sayHello";
    }
}
