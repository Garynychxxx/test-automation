package com.epam.automation.exception;


public class Runner {
    public static void main(String[] args) {

        University university = University.getUniversity();

        university.addFaculty(
                new Faculty("ATF", new Group("11241"), new Group("11244"), new Group("11240")),
                new Faculty("IT", new Group("12324"), new Group("22340")));


        Student studentElovik = new Student("Еловик Олег", 771,
                new Subject("Математика", 10, 8, 2, 5, 1),
                new Subject("Физика", 5, 5, 5, 5, 5),
                new Subject("Информатика", 1, 9, 4, 7, 5));
        Student studentMozaikin = new Student("Мозайкин Павел", 571,
                new Subject("Математика", 3, 5, 7, 8, 2),
                new Subject("Физика", 5, 5, 5, 5, 5));
        Student studentErohovec = new Student("Ероховец Антон", 371,
                new Subject("Физика", 5, 5, 5, 5, 5),
                new Subject("Информатика", 10, 9, 8, 7, 6));
        university.getFaculties().get(0).getGroups().get(0).addStudent(studentElovik,studentErohovec,studentMozaikin);



        Student studentMazurka = new Student("Мазурка Евгений", 161,
                new Subject("Черчение", 1, 2, 2, 9, 10),
                new Subject("Физика", 3, 2, 9, 9, 2),
                new Subject("Информатика", 3, 2, 6, 8, 1));
        Student studentPaseka = new Student("Пасека Александр", 772,
                new Subject("Математика", 2, 3, 4, 5, 10),
                new Subject("Физика", 3, 4, 6, 6, 3),
                new Subject("Физкультура", 2, 6, 5, 3, 2));
        university.getFaculties().get(0).getGroups().get(1).addStudent(studentMazurka,studentPaseka);



        Student studentChertov = new Student("Чертов Зенон", 532,
                new Subject("Черчение", 7, 7, 7, 7, 7),
                new Subject("Физика", 1, 2, 7, 2, 7));

        university.getFaculties().get(0).getGroups().get(2).addStudent(studentChertov);



        Student studentKrotov = new Student("Кротов Егор", 775,
                new Subject("Математика", 10, 8, 10, 5, 10));
        Student studentZaboiniy = new Student("Забойный Влад", 771,
                new Subject("Математика", 7, 5, 6, 2, 8),
                new Subject("Информатика", 10, 4, 8, 9, 5));
        university.getFaculties().get(1).getGroups().get(0).addStudent(studentKrotov,studentZaboiniy);


        Student studentCherecako = new Student("Черевако Виталий", 623,
                new Subject("Физика", 3, 3, 4, 4, 4),
                new Subject("Информатика", 2, 6, 6, 6, 6));
        Student studentChalevinskiy = new Student("Хaлевинский Павел", 123,
                new Subject("Математика", 10, 8, 9, 9, 9),
                new Subject("Физика", 9, 9, 9, 9, 9),
                new Subject("Информатика", 10, 9, 10, 7, 9));

        university.getFaculties().get(1).getGroups().get(1).addStudent(studentCherecako,studentChalevinskiy);




        System.out.printf("%.2f\n",university.getAverageMarkOfOneSubject("Математика"));

        System.out.printf("%.2f\n",university.getAverageMarkOfOneSubject("ATF", "11241", "Физика"));

        System.out.printf("%.2f\n",studentChalevinskiy.getAverageMarkOfOneSubject("Физика"));
    }

}
