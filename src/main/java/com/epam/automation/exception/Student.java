package com.epam.automation.exception;

import com.epam.automation.exception.exeptionsForTask.MarkOutOfBoundsException;
import com.epam.automation.exception.exeptionsForTask.NoSubjectExceprion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


class Student {
    String studentName;
    private int Id;
    private Map<SubjectType, ArrayList<Integer>> listOfSubject = new HashMap<>();

    Student(String name, int id) {
        this.studentName = name;
        Id = id;

    }

    public void addSubjectAndMarks(SubjectType subjectType, Integer... marks) {

        listOfSubject.put(subjectType, new ArrayList<Integer>(Arrays.asList(marks)));
    }

    boolean studentHasSubject(SubjectType subjectType) {
        return listOfSubject.containsKey(subjectType);
    }

    Double getAverageMarkOfSubject() throws MarkOutOfBoundsException, NoSubjectExceprion {
        Double sumOfMarks = 0.0;
        int howMuchMarks = 0;

        for (SubjectType subjectType : listOfSubject.keySet()) {
            sumOfMarks += getAverageMarkOfSubject(subjectType);
            howMuchMarks++;
        }
        return sumOfMarks / howMuchMarks;

    }

    Double getAverageMarkOfSubject(SubjectType subjectType) throws MarkOutOfBoundsException, NoSubjectExceprion {
        Double sumOfMarks = 0.0;
        int howMuchMarks = 0;
        if (listOfSubject.isEmpty()) {
            throw new NoSubjectExceprion("У студента должен быть хотя бы один предмет");
        }

        if (studentHasSubject(subjectType)) {

            for (Integer mark : listOfSubject.get(subjectType)) {
                if (mark <= 0 || mark > 10) {
                    throw new MarkOutOfBoundsException("Оценка не может быть ниже 0 или выше 10");
                }
                sumOfMarks += mark;
                howMuchMarks++;
            }
            return sumOfMarks / howMuchMarks;
        }
        return 0.0;
    }
}


