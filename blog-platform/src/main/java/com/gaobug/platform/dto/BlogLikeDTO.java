package com.gaobug.platform.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
public class BlogLikeDTO {

    private Long userId;

    private Long article;

    private Date likeTime;
}