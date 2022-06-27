package com.example.blogproject.page.service;

import com.example.blogproject.page.dto.PageUserResponseDto;
import com.example.blogproject.page.dto.PagenationFrame;
import com.example.blogproject.page.repository.PageUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class PageService {
    private final PageUserRepository pageUserRepository;
    public PagenationFrame apiList(Pageable pageable) {
        Page<PageUserResponseDto> result = pageUserRepository.userList(pageable);

        PagenationFrame dtos = new PagenationFrame<>(result.getNumber(),
                result.isFirst(),
                result.isLast(),
                result.getTotalPages(),
                result.getTotalElements(),
                result.getContent()
        );
        return dtos;
    }
}
