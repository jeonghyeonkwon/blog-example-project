package com.example.blogproject.aboutjava.dto;

import lombok.Getter;

import java.util.Objects;

@Getter
public class EqualsDto implements Comparable<EqualsDto>{
    private String name;
    private String commonValue;
    private Long number;

    public EqualsDto(String name, String commonValue, Long number) {
        this.name = name;
        this.commonValue = commonValue;
        this.number = number;
    }

    @Override
    public boolean equals(Object o) {
        return this.commonValue.equals(((EqualsDto)o).commonValue);
    }

    @Override
    public int hashCode() {
        return Objects.hash(commonValue);
    }

    @Override
    public int compareTo(EqualsDto o) {
        return this.getNumber().intValue()-o.getNumber().intValue();
    }
}
