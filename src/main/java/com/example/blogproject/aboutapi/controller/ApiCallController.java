package com.example.blogproject.aboutapi.controller;

import com.example.blogproject.aboutapi.dto.ApiRequestDto;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/call")
public class ApiCallController {
    private final RestTemplate restTemplate;
    private final WebClient webClient;
    private final String EXPRESS_URL = "http://localhost:8000/api";

    public ApiCallController(RestTemplateBuilder restTemplateBuilder, WebClient.Builder webClientBuilder){
        this.restTemplate = restTemplateBuilder.build();
        this.webClient = webClientBuilder.build();
    }
    @PostMapping ("/rest-template")
    public ResponseEntity callRestTemplate(@RequestBody ApiRequestDto dto){
        try{
            ResponseEntity<ApiRequestDto> stringResponseEntity = restTemplate
                    .postForEntity(EXPRESS_URL+"/receive",
                            dto,
                            ApiRequestDto.class
                    );
            System.out.println(stringResponseEntity.getBody());
            return new ResponseEntity(stringResponseEntity.getBody(),HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity("잘못 요청했습니다.",HttpStatus.BAD_REQUEST);
        }
    }

    /*
    * 도움되는 글 :
    * https://gngsn.tistory.com/154
    * https://www.baeldung.com/spring-webclient-get-response-body
    * */
    @PostMapping("/web-client")
    public ResponseEntity callWebClient(@RequestBody ApiRequestDto dto){
        try{

            // mono 0~1
            // flux 0~N
            ApiRequestDto block = webClient.post()
                    .uri(EXPRESS_URL + "/receive")
                    .body(Mono.just(dto), ApiRequestDto.class)
                    .retrieve()
                    .bodyToMono(ApiRequestDto.class).block();

            System.out.println(block);
            return new ResponseEntity(block,HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity("잘못 요청했습니다.",HttpStatus.BAD_REQUEST);
        }

    }

}
