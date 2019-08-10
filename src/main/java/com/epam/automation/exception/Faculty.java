package com.epam.automation.exception;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Faculty {
    private String facultyName;
    private List<Group> groups = new ArrayList<>();

    String getFacultyName() {
        return facultyName;
    }

    List<Group> getGroups() {
        return groups;
    }

    Faculty(String facultyName, Group... groups) {
        this.facultyName = facultyName;
        this.groups.addAll(Arrays.asList(groups));

    }

    Double getAverageMarkOfOneSubjectInGroupInFaculty(String groupName, String subjectName) {
        int howMuchStudentsHaveThisSubject = 0;
        Double sumOfMarksOFAllStudentsByOneSubjectByGroup = 0.0;
        for (Group group : groups) {
            if (group.getGroupName().equals(groupName) || groupName.equals("All")) {
                howMuchStudentsHaveThisSubject++;
                sumOfMarksOFAllStudentsByOneSubjectByGroup += group.getAverageMarkOfOneSubjectInGroup(subjectName);
            }
        }
        return sumOfMarksOFAllStudentsByOneSubjectByGroup / howMuchStudentsHaveThisSubject;
    }
}
