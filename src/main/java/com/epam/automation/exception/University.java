package com.epam.automation.exception;

import java.util.ArrayList;
import java.util.Arrays;

public class University {

    private static University university;

    private University() {
    }

    public static University getUniversity() {
        if (university == null) {
            university = new University();
        }
        return university;
    }

    ArrayList<Faculty> listOfFaculty = new ArrayList<>();

    public ArrayList<Faculty> getListOfFaculty() {
        return listOfFaculty;
    }

    public void addFaculty(Faculty... faculty) {
        this.listOfFaculty.addAll(Arrays.asList(faculty));

    }

    public Double getAverageMarkOfOneSubjectInOneGroupInOneFaculty(String facultyName, String groupName, String subjectName) {
        Double sumAverageMarksOfOneSubjectInOneGroupInOneFaculty = 0.0;
        int howFacultiesHasGroupHasStudentHasSubject = 0;
        for (int i = 0; i < listOfFaculty.size(); i++) {
            if (listOfFaculty.get(i).getFacultyName().equals(facultyName) || facultyName.equals("All")) {
                sumAverageMarksOfOneSubjectInOneGroupInOneFaculty += listOfFaculty.get(i).getAverageMarkOfOneSubjectInGroupInFaculty(groupName, subjectName);
                howFacultiesHasGroupHasStudentHasSubject++;
            }
        }
        return sumAverageMarksOfOneSubjectInOneGroupInOneFaculty / howFacultiesHasGroupHasStudentHasSubject;
    }

    public Double getAverageMarkOfOneSubjectInAllUniversity(String subjectName) {
        return getAverageMarkOfOneSubjectInOneGroupInOneFaculty("All", "All", subjectName);
    }
}
