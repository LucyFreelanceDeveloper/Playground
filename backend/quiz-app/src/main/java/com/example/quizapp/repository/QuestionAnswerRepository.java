package com.example.quizapp.repository;

import com.example.quizapp.model.Question;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class QuestionAnswerRepository {

    private final String answerFileName;
    private final ObjectMapper mapper;

    public QuestionAnswerRepository(final String taskFileName, final ObjectMapper mapper) {
        this.answerFileName = taskFileName;
        this.mapper = mapper;
    }

    public List<Question> load() {
        List<Question> taskGroups = new ArrayList<>();

        try {
            taskGroups = mapper.readValue(Paths.get(answerFileName).toFile(), new TypeReference<>() {
            });
        } catch (IOException e) {
            System.err.printf(String.format("Failed to load answers from file: %s%n", answerFileName));
            e.printStackTrace();
        }

        return taskGroups;
    }

    public void save(final List<Question> taskGroups) {
        try {
            mapper.writeValue(new File(answerFileName), taskGroups);
        } catch (IOException e) {
            System.err.printf(String.format("Failed to save answers to file: %s", answerFileName));
            e.printStackTrace();
        }
    }
}
