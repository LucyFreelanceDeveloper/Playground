package com.example.quizapp.model;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class Question {

    private String name;
    private List<Answer> answers;
}
