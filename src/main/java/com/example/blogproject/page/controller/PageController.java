package com.example.blogproject.page.controller;

import com.example.blogproject.page.dto.PagenationFrame;
import com.example.blogproject.page.service.PageService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/page")
public class PageController {
    private final PageService pageService;

    @GetMapping("/user")
    public String userList(@PageableDefault(size=5,
            sort="userName",
            direction = Sort.Direction.DESC) Pageable pageable,
            Model model){

        PagenationFrame dtos = pageService.apiList(pageable);
        System.out.println(dtos);
        model.addAttribute("dtos",dtos);
        return "pagenation";
    }
}
