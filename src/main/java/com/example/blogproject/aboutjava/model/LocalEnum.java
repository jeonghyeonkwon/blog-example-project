package com.example.blogproject.aboutjava.model;

import com.example.blogproject.aboutjava.dto.LocalDto;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum LocalEnum {
    SEOUL("서울"),
    GYEONGGI("경기"),
    BUSAN("부산"),
    DEAGU("대구"),
    INCHEON("인천"),
    GWANGJU("광주"),
    DAEJEON("대전"),
    ULSAN("울산"),
    CHUNGCHEONBUK("충북"),
    CHUNGCHEONNAM("충남"),
    JEOLLANAM("전남"),
    JEOLLABUK("전북"),
    GYEONGSANGBUK("경북"),
    GYEONGSANGNAM("경남"),
    JEJU("제주"),
    GANGWON("강원");
    private String kor;
    LocalEnum(String kor){
        this.kor = kor;
    }

    public static LocalDto findLocalByKor(String kor){
        LocalEnum localEnum = Stream.of(values())
                .filter(local -> local.kor.equals(kor))
                .findFirst()
                .orElse(null);
        return new LocalDto(localEnum.name(), localEnum.kor);
    }
    public static List<LocalDto> localList(){
        List<LocalDto> collect = Stream.of(values()).map(data -> new LocalDto(data.name(), data.kor)).collect(Collectors.toList());
        return collect;
    }
}
