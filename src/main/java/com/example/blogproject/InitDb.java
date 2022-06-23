package com.example.blogproject;

import com.example.blogproject.page.domain.PageUser;
import com.example.blogproject.page.dto.PageUserRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class InitDb {
    private final InitService initService;

    @PostConstruct
    public void init(){
        initService.pageInit();
    }
    @Component
    @Transactional
    @RequiredArgsConstructor
    static class  InitService{
        private final EntityManager em;
        public void pageInit(){
            PageUserRequestDto dto = PageUserRequestDto.builder().userName("유저").address("주소").intro("소개").build();
            for(int i=1;i<67;i++){
                PageUser user = new PageUser(UUID.randomUUID().toString(),dto.getUserName()+i,dto.getAddress()+i,dto.getIntro()+i);
                em.persist(user);
            }
        }
    }
}
