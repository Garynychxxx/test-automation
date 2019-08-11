package com.epam.automation.exception;

import com.epam.automation.exception.exeptionsForTask.MarkOutOfBoundsException;
import com.epam.automation.exception.exeptionsForTask.NoStudentException;
import com.epam.automation.exception.exeptionsForTask.NoSubjectExceprion;

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

    Double getAverageMarkOfOneSubjectInGroup(SubjectType subjectType) throws MarkOutOfBoundsException, NoSubjectExceprion, NoStudentException {
        Double sumOfMarksOFAllStudentsByOneSubject = 0.0;
        int howMuchMarks = 0;

        for (Student student : students) {
            if (students.isEmpty()) {
                throw new NoStudentException("В группе должен быть хотя бы один студент");
            }
            if (student.getAverageMarkOfSubject(subjectType) != 0.0) {

                howMuchMarks++;
                sumOfMarksOFAllStudentsByOneSubject += student.getAverageMarkOfSubject(subjectType);
            }
        }
        return howMuchMarks == 0 ? 0 : sumOfMarksOFAllStudentsByOneSubject / howMuchMarks;
    }
}
