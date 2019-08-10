package com.epam.automation.exception;

class Subject {
    private String subjectName;
    private int[] marksOfThisSubject;

    Subject(String subjectName, int... marksOfThisSubject) {
        this.subjectName = subjectName;
        this.marksOfThisSubject = marksOfThisSubject;
    }

    String getSubjectName() {
        return subjectName;
    }

    Double getAverageMark() {
        int sumAllMarksOfOneSubject=0;

        for (int oneMark : marksOfThisSubject) {
            if (oneMark>10 || oneMark <0){
                throw new IndexOutOfBoundsException("Оценка не может быть ниже 0 или выше 10");
            }
            sumAllMarksOfOneSubject+=oneMark;
        }
        return sumAllMarksOfOneSubject/(marksOfThisSubject.length*1.0);
    }
}



