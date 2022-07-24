package com.example.blogproject.aboutaop.service;

import com.example.blogproject.aboutaop.repository.AopRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class AopService {
    private final AopRepository aopRepository;
    public String service(){

            String save = aopRepository.save();
            log.info("respository msg = {}",save);
            return "ServiceOk";


    }

}
