package com.epam.automation.exception;

import java.util.ArrayList;
import java.util.Arrays;

public class Faculty {
    String facultyName;
    ArrayList<Group> listOfGroup = new ArrayList<>();

    public String getFacultyName() {
        return facultyName;
    }

    public ArrayList<Group> getListOfGroup() {
        return listOfGroup;
    }

    public Faculty(String facultyName, Group... groups) {
        this.facultyName = facultyName;
        this.listOfGroup.addAll(Arrays.asList(groups));

    }

    public Double getAverageMarkOfOneSubjectInGroupInFaculty(String groupName, String subjectName) {
        int howMuchStudentsHaveThisSubject = 0;
        Double sumOfMarksOFAllStudentsByOneSubjectByGroup = 0.0;
        for (Group group : listOfGroup) {
            if (group.getGroupName().equals(groupName) || groupName.equals("All")) {
                howMuchStudentsHaveThisSubject++;
                sumOfMarksOFAllStudentsByOneSubjectByGroup += group.getAverageMarkOfOneSubjectInGroup(subjectName);
            }
        }
        return sumOfMarksOFAllStudentsByOneSubjectByGroup / howMuchStudentsHaveThisSubject;
    }

}
