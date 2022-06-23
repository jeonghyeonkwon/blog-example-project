package com.example.blogproject.page.repository;

import com.example.blogproject.page.domain.PageUser;
import com.example.blogproject.page.dto.PageUserResponseDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PageUserRepository extends JpaRepository<PageUser, String> {

    @Query("SELECT new com.example.blogproject.page.dto.PageUserResponseDto(p.uuid,p.userName,p.address,p.intro)" +
            " FROM PageUser p")
    Page<PageUserResponseDto> userList(Pageable pageable);
}
