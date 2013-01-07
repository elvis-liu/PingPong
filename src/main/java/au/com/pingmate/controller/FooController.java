package au.com.pingmate.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class FooController {

    @RequestMapping(value = "*", method = RequestMethod.GET)
    @ResponseBody
    public String getAll() {
        return "hi";
    }
}