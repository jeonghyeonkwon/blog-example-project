package com.example.blogproject.page.controller;

import com.example.blogproject.page.dto.PagenationFrame;
import com.example.blogproject.page.service.PageService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/page")
public class ApiPageController {
    private final PageService pageService;


    @GetMapping("/user")
    public ResponseEntity userList(@PageableDefault(size = 10,
            sort="userName",
            direction = Sort.Direction.DESC) Pageable pageable){
        PagenationFrame pagenationFrame = pageService.apiList(pageable);
        return new ResponseEntity(pagenationFrame,HttpStatus.OK);

    }
}
