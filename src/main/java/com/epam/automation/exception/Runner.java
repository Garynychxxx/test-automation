package com.epam.automation.exception;


import com.epam.automation.exception.exeptionsForTask.*;

public class Runner {
    public static void main(String[] args) throws MarkOutOfBoundsException, NoSubjectExceprion, NoGroupException, NoFacultyException, NoStudentException {

        University university = University.getUniversity();

        university.addFaculty(
                new Faculty("ATF", new Group("11241"), new Group("11244"), new Group("11240")),
                new Faculty("IT", new Group("12324"), new Group("22340")));


        Student studentElovik = new Student("Еловик Олег", 771);
        studentElovik.addSubjectAndMarks(SubjectType.MATHS, 6, 2, 7, 1, 9);
        studentElovik.addSubjectAndMarks(SubjectType.PHYSICS, 1, 7, 9, 7, 2);
        studentElovik.addSubjectAndMarks(SubjectType.INFORMATICS, 7, 1, 9, 6, 6);


        Student studentMozaikin = new Student("Мозайкин Павел", 571);
        studentMozaikin.addSubjectAndMarks(SubjectType.PHYSICS, 5, 2, 7, 7, 5);


        Student studentErohovec = new Student("Ероховец Антон", 371);
        studentErohovec.addSubjectAndMarks(SubjectType.PHYSICS, 5, 2, 5, 5, 10);
        studentErohovec.addSubjectAndMarks(SubjectType.INFORMATICS, 9, 4, 1, 9, 2);

        university.getFaculties().get(0).getGroups().get(0).addStudent(studentElovik, studentErohovec, studentMozaikin);


        Student studentMazurka = new Student("Мазурка Евгений", 161);
        studentMazurka.addSubjectAndMarks(SubjectType.DRAWING, 1, 2, 2, 9, 10);
        studentMazurka.addSubjectAndMarks(SubjectType.PHYSICS, 3, 2, 9, 9, 2);
        studentMazurka.addSubjectAndMarks(SubjectType.INFORMATICS, 3, 2, 6, 8, 1);


        Student studentPaseka = new Student("Пасека Александр", 772);
        studentPaseka.addSubjectAndMarks(SubjectType.MATHS, 7, 1, 2, 7, 8);
        studentPaseka.addSubjectAndMarks(SubjectType.PHYSICS, 3, 4, 6, 6, 3);
        studentPaseka.addSubjectAndMarks(SubjectType.DRAWING, 2, 6, 5, 3, 2);

        university.getFaculties().get(0).getGroups().get(1).addStudent(studentMazurka, studentPaseka);


        Student studentChertov = new Student("Чертов Зенон", 532);
        studentChertov.addSubjectAndMarks(SubjectType.DRAWING, 7, 2, 7, 4, 5);
        studentChertov.addSubjectAndMarks(SubjectType.PHYSICS, 1, 2, 7, 2, 7);

        university.getFaculties().get(0).getGroups().get(2).addStudent(studentChertov);


        Student studentKrotov = new Student("Кротов Егор", 775);
        studentKrotov.addSubjectAndMarks(SubjectType.MATHS, 6, 1, 2, 8, 5);

        Student studentZaboiniy = new Student("Забойный Влад", 771);
        studentZaboiniy.addSubjectAndMarks(SubjectType.MATHS, 2, 8, 3, 7, 4);
        studentZaboiniy.addSubjectAndMarks(SubjectType.INFORMATICS, 10, 4, 8, 9, 5);
        university.getFaculties().get(1).getGroups().get(0).addStudent(studentKrotov, studentZaboiniy);


        Student studentCherecako = new Student("Черевако Виталий", 623);
        studentCherecako.addSubjectAndMarks(SubjectType.PHYSICS, 3, 3, 2, 4, 4);
        studentCherecako.addSubjectAndMarks(SubjectType.INFORMATICS, 2, 6, 6, 6, 6);

        Student studentChalevinskiy = new Student("Хaлевинский Павел", 123);
        studentChalevinskiy.addSubjectAndMarks(SubjectType.MATHS, 2, 5, 2, 9, 10);
        studentChalevinskiy.addSubjectAndMarks(SubjectType.PHYSICS, 9, 2, 6, 6, 9);
        studentChalevinskiy.addSubjectAndMarks(SubjectType.INFORMATICS, 10, 9, 10, 7, 9);

        university.getFaculties().get(1).getGroups().get(1).addStudent(studentCherecako, studentChalevinskiy);


        System.out.printf("%.2f\n", university.getAverageMarkOfOneSubject(SubjectType.MATHS));

        System.out.printf("%.2f\n", university.getAverageMarkOfOneSubject("ATF", "11241", SubjectType.INFORMATICS));

        System.out.printf("%.2f\n", studentElovik.getAverageMarkOfSubject());
    }
}
