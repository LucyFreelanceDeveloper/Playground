package com.example.quizapp.service;

import com.example.quizapp.model.Answer;
import com.example.quizapp.model.Dificulty;
import com.example.quizapp.model.Question;
import com.example.quizapp.repository.QuestionAnswerRepository;

import java.util.*;
import java.util.stream.Collectors;

public class QuestionAnswerManager {

    private final QuestionAnswerRepository questionAnswerRepository;

    private final List<Question> questions;

    public QuestionAnswerManager(QuestionAnswerRepository questionAnswerRepository) {
        this.questionAnswerRepository = questionAnswerRepository;
        this.questions = questionAnswerRepository.load();
    }

    public boolean createAnswer(final Answer answer, final String questionName){
        Optional<Question> existingQuestion = questions.stream()
                .filter(question -> question.getName().equals(questionName))
                .findFirst();

        if (existingQuestion.isPresent()) {
            existingQuestion.get().getAnswers().add(answer);
        } else {
            System.out.println("Did not find given name of questionName: creating new questionName");
            List<Answer> answers = new ArrayList<>();
            answers.add(answer);
            questions.add(new Question(questionName, answers));
        }
        return true;
    }

    public boolean updateAnswer(final Answer answer) {
        return questions.stream()
                .flatMap(question -> question.getAnswers().stream())
                .filter(existingAnswer -> existingAnswer.getId().equals(answer.getId()))
                .findFirst()
                .map(existingAnswer -> {
                    existingAnswer.setAnswer(answer.getAnswer());
                    existingAnswer.setLearned(answer.isLearned());
                    return true;
                }).orElse(false);
    }

    public boolean setLearned(final UUID id) {
        return questions.stream()
                .flatMap(question -> question.getAnswers().stream())
                .filter(answer -> answer.getId().equals(id))
                .findFirst()
                .map(answer -> {
                    answer.setLearned(true);
                    return true;
                }).orElse(false);
    }

    public List<Answer> getBy(final String questionName) {
        return questions.stream()
                .filter(question -> question.getName().equals(questionName))
                .map(Question::getAnswers)
                .findFirst().orElse(Collections.emptyList());
    }

    public List<Answer> getBy(final String questionName, final Dificulty dificulty) {
        return questions.stream()
                .filter(question -> question.getName().equals(questionName))
                .flatMap(question -> question.getAnswers().stream())
                .filter(answer -> answer.getDificulty() == dificulty)
                .collect(Collectors.toList());
    }

    public List<Answer> getBy(final String questionName, final boolean learned) {
        return questions.stream()
                .filter(question -> question.getName().equals(questionName))
                .flatMap(question -> question.getAnswers().stream())
                .filter(answer -> answer.isLearned() == learned)
                .collect(Collectors.toList());
    }

    public boolean deleteQuestion(final String questionName) {
        boolean deleted = false;
        for(Question question: questions) {
            boolean result = question.getName().equals(questionName);
            if(result) {
                deleted = true;
            }
        }
        return deleted;
    }

    public void saveAnswersToFile() {
        questionAnswerRepository.save(questions);
    }
}
