package cn.et.demo04;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ViewController {
    @RequestMapping("demo04/test1")
    public String test1(){
        return "demo04/view";
    }
}
