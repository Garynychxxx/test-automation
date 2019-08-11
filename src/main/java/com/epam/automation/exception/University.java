package com.epam.automation.exception;

import com.epam.automation.exception.exeptionsForTask.*;

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

    Double getAverageMarkOfOneSubject(String facultyName, String groupName, SubjectType subjectType) throws MarkOutOfBoundsException, NoSubjectExceprion, NoGroupException, NoStudentException, NoFacultyException {
        Double sumAverageMarksOfOneSubjectInOneGroupInOneFaculty = 0.0;
        int howMuchFacultiesHasGroupHasStudentHasSubject = 0;
        if (faculties.isEmpty()) {
            throw new NoFacultyException("В университете должен быть хотя бы один факультет");
        }
        for (Faculty faculty : faculties) {
            if ((faculty.getFacultyName().equals(facultyName) || facultyName.equals("All"))) {
                if (faculty.getAverageMarkOfOneSubjectInGroupInFaculty(groupName, subjectType) != 0) {
                    sumAverageMarksOfOneSubjectInOneGroupInOneFaculty += faculty.getAverageMarkOfOneSubjectInGroupInFaculty(groupName, subjectType);
                    howMuchFacultiesHasGroupHasStudentHasSubject++;
                }
            }
        }
        return howMuchFacultiesHasGroupHasStudentHasSubject == 0 ? 0 : sumAverageMarksOfOneSubjectInOneGroupInOneFaculty / howMuchFacultiesHasGroupHasStudentHasSubject;
    }

    Double getAverageMarkOfOneSubject(SubjectType subjectType) throws MarkOutOfBoundsException, NoSubjectExceprion, NoGroupException, NoStudentException, NoFacultyException {
        return getAverageMarkOfOneSubject("All", "All", subjectType);
    }
}
