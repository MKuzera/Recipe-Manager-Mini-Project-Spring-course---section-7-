package com.SpringCourse.Section7.SayHelloController;



import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class SayHelloController {

@RequestMapping("hello")
@ResponseBody
    public String sayHello(){
        return "Hello!";
    }
    @RequestMapping("hello-html")
    @ResponseBody
    public String sayHelloHtml(){
        return "Hello!";
    }

    @RequestMapping("hello-jsp")
    public String sayHelloJsp(){
        return "HelloJSP!";
    }
}
