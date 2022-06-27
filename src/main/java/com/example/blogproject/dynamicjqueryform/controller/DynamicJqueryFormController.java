package com.example.blogproject.dynamicjqueryform.controller;

import lombok.Getter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DynamicJqueryFormController {
    @GetMapping("/dynamic-jquery-form")
    public String dynamicForm(){
        return "dynamicJqueryFrom";
    }
}
