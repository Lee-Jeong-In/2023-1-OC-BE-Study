package GDSC.GDSCBackend.controller;

import org.apache.tomcat.util.net.TLSClientHelloExtractor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller

public class helloController {

    @GetMapping("hello")
    public String hello(Model model){
       model.addAttribute("data","hello!!");
       return "hello";
    }

    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam("name") String name, Model model){
        model.addAttribute("name",name);
        return "hello-template";
    }

    @GetMapping("hello-string")
    @ResponseBody                   // http에서 body부에 다음의 데이터를 직접 넣어주겠다.
    public String helloString(@RequestParam("name") String name) {
        return "hello " + name;     // "hello spring" 이렇게 나올것이다. +  웹에서 소스보기 하면 글자만 출력된다.
    }

    @GetMapping("hello-api")        // json 형식 {key:value}의 형태로 나온다.
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name){
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
    }

    static class Hello{
        private String name;

        /* Java의 bin 표준방식 Getter Setter형식*/
        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
    }
}
