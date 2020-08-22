package mh.com.project.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by mh on 22/08/2020.
 */
@Controller
@RequestMapping("")
public class TemplateController {

    @GetMapping("/login")
    public String getLoginForm() {
        return "login";
    }

    @GetMapping("/courses")
    public String getCourses() {
        return "courses";
    }
}
