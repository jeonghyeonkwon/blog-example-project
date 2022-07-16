package com.example.blogproject.aboutvalidate.dto;

import lombok.Data;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;


@Data
public class ValidationUserDto {
    @NotBlank(message = "빈 값을 채워주세요")
    private String userId;

    @NotNull(message = "빈 값을 채워주세요")
    @Range(min = 1,max= 1000)
    private Long number;

    @NotBlank(message = "빈 값을 채워주세요")
    @Email
    private String email;

    @NotBlank(message = "빈 값을 채워주세요")
    @Pattern(regexp = "\\d{3}-\\d{4}-\\d{4}",message = "전화 번호 양식이 올바르지 않습니다.")
    private String phone;
}
