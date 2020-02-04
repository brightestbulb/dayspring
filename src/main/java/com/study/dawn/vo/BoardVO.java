package com.study.dawn.vo;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Date;

@Getter
@RequiredArgsConstructor // 선언된 모든 final 필드가 포함된 생성자를 생성. final이 없는 필드는 생성자에 포함X
public class BoardVO {
    private int id;
    private String title;
    private String writer;
    private Date del_tm;
    private boolean done;
}
