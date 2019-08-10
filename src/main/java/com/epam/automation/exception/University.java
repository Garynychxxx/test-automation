package com.epam.automation.exception;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class University {

    private static University university;

    private University() {
    }

    static University getUniversity() {
        if (university == null) {
            university = new University();
        }
        return university;
    }

    private List<Faculty> faculties = new ArrayList<>();

    List<Faculty> getFaculties() {
        return faculties;
    }

    void addFaculty(Faculty... faculty) {
        this.faculties.addAll(Arrays.asList(faculty));

    }

    Double getAverageMarkOfOneSubject(String facultyName, String groupName, String subjectName) {
        Double sumAverageMarksOfOneSubjectInOneGroupInOneFaculty = 0.0;
        int howMuchFacultiesHasGroupHasStudentHasSubject = 0;
        for (Faculty faculty : faculties) {
            if (faculty.getFacultyName().equals(facultyName) || facultyName.equals("All")) {
                sumAverageMarksOfOneSubjectInOneGroupInOneFaculty += faculty.getAverageMarkOfOneSubjectInGroupInFaculty(groupName, subjectName);
                howMuchFacultiesHasGroupHasStudentHasSubject++;
            }
        }
        return sumAverageMarksOfOneSubjectInOneGroupInOneFaculty / howMuchFacultiesHasGroupHasStudentHasSubject;
    }

    Double getAverageMarkOfOneSubject(String subjectName) {
        return getAverageMarkOfOneSubject("All", "All", subjectName);
    }
}
