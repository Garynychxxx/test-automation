package com.epam.automation.exception;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


class Student {
    String studentName;
    private int Id;
    private List<Subject> individualJournal = new ArrayList<>();

    Student(String name, int id, Subject... subjects) {
        this.studentName = name;
        Id = id;
        this.individualJournal.addAll(Arrays.asList(subjects));
    }

    Double getAverageMarkOfOneSubject(String subjectName) {
        Double returnStatement = 0.0;
        for (Subject subject : individualJournal) {
            if (subject.getSubjectName().equals(subjectName) || subjectName.equals("All")) {
                returnStatement = subject.getAverageMark();
            }
        }
        return returnStatement;
    }
}
