package com.example.quizapp.model;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class Answer {

    private UUID id;
    private String answer;
    private boolean learned;
    private Dificulty dificulty;
}
