package com.epam.automation.exception;

import java.util.ArrayList;
import java.util.Arrays;

public class Group {
    String groupName;
    ArrayList<Student> listOFStudents = new ArrayList<>();

    public Group(String groupName) {
        this.groupName = groupName;
    }

    public String getGroupName() {
        return groupName;
    }

    public void addStudent(Student... students) {
        listOFStudents.addAll(Arrays.asList(students));
    }

    public Double getAverageMarkOfOneSubjectInGroup(String subjectName) {
        Double sumOfMarksOFAllStudentsByOneSubject = 0.0;
        for (Student student : listOFStudents) {
            sumOfMarksOFAllStudentsByOneSubject += student.getAverageMarkOfOneSubject(subjectName);
        }
        return sumOfMarksOFAllStudentsByOneSubject / listOFStudents.size();
    }
}
