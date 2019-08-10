package com.epam.automation.exception;

import java.util.ArrayList;
import java.util.Arrays;


public class Student {
    String studentName;
    int Id;

    public Student(String name, int id, Subject...subjects) {
        this.studentName = name;
        Id = id;
        this.individualJournal.addAll(Arrays.asList(subjects));
    }

    public ArrayList<Subject> getIndividualJournal() {
        return individualJournal;
    }

    ArrayList<Subject> individualJournal = new ArrayList<>();


    public Double getAverageMarkOfOneSubject(String subjectName) {
        Double returnStatement = 0.0;
        for (Subject subject : individualJournal) {
            if (subject.getSubjectName().equals(subjectName) || subjectName.equals("All")) {
                returnStatement = subject.getAverageMark();
            }
        }
        return returnStatement;
    }
}
