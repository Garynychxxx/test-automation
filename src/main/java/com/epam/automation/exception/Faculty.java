package com.epam.automation.exception;

import com.epam.automation.exception.exeptionsForTask.MarkOutOfBoundsException;
import com.epam.automation.exception.exeptionsForTask.NoGroupException;
import com.epam.automation.exception.exeptionsForTask.NoStudentException;
import com.epam.automation.exception.exeptionsForTask.NoSubjectExceprion;

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

    Double getAverageMarkOfOneSubjectInGroupInFaculty(String groupName, SubjectType subjectType) throws MarkOutOfBoundsException, NoSubjectExceprion, NoGroupException, NoStudentException {
        int howMuchStudentsHaveThisSubject = 0;
        Double sumOfMarksOFAllStudentsByOneSubjectByGroup = 0.0;
        for (Group group : groups) {
            if (groups.isEmpty()) {
                throw new NoGroupException("На факультете должна быть хотя бы одна группа.");
            }
            if ((group.getGroupName().equals(groupName) || groupName.equals("All")) && group.getAverageMarkOfOneSubjectInGroup(subjectType) != 0) {

                howMuchStudentsHaveThisSubject++;
                sumOfMarksOFAllStudentsByOneSubjectByGroup += group.getAverageMarkOfOneSubjectInGroup(subjectType);

            }
        }
        return howMuchStudentsHaveThisSubject == 0 ? 0 : sumOfMarksOFAllStudentsByOneSubjectByGroup / howMuchStudentsHaveThisSubject;
    }
}
