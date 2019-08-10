package com.epam.automation.exception;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Group {
    private String groupName;
    private List<Student> students = new ArrayList<>();

    Group(String groupName) {
        this.groupName = groupName;
    }

    String getGroupName() {
        return groupName;
    }

    void addStudent(Student... students) {
        this.students.addAll(Arrays.asList(students));
    }

    Double getAverageMarkOfOneSubjectInGroup(String subjectName) {
        Double sumOfMarksOFAllStudentsByOneSubject = 0.0;
        for (Student student : students) {
            sumOfMarksOFAllStudentsByOneSubject += student.getAverageMarkOfOneSubject(subjectName);
        }
        return sumOfMarksOFAllStudentsByOneSubject / students.size();
    }
}
