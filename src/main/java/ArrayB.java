import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class ArrayB {

    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        int flag = 0;

        System.out.print("Please input the number of Students: ");
        int numberOfStud = scan.nextInt();
        int[] stud = new int[numberOfStud];

        System.out.print("Please input the number of Quizzes: ");
        int numberOfQuiz = scan.nextInt();

        Double[][]studentGrade = new Double[numberOfStud][];

        System.out.println("Grades of Quizzes: ");

        for (int i = 0; i < stud.length; i++) {
            Double[] grades = new Double[numberOfQuiz];
            System.out.println("Student#" + (i + 1) + ": ");

            for (int j = 0; j < grades.length; j++) {
                System.out.print("Quiz #" + (j + 1) + ": ");
                grades[j] = scan.nextDouble();
            }
            studentGrade[i] = grades;
        }

        do {
            System.out.println("\nMain Menu\n"
                    + "1. View Grades\n"
                    + "2. Update Grades\n"
                    + "3. Delete Grades\n"
                    + "4. Exit "
            );
            System.out.print("Please select an option: ");
            int option = scan.nextInt();

            switch (option) {
                case 1:
                    System.out.println();
                    readGrade(numberOfStud, studentGrade, numberOfQuiz);
                    break;
                case 2:
                    updateData(studentGrade);
                    clearFile();
                    break;
                case 3:
                    deleteData(studentGrade);
                    clearFile();
                    break;
                case 4:
                    break;
                default:
                    System.out.println("INVALID OPTION");
            }
        } while (flag == 0);
    }

    private static void updateData(Double[][] studentGrade) {
        System.out.println("Please enter Student Number: ");
        int studNumber = scan.nextInt();

        for (int j = 0; j < studentGrade[studNumber-1].length; j++) {
            System.out.print("Quiz #" + (j + 1) + ": ");
            studentGrade[studNumber-1][j] = scan.nextDouble();
        }
    }

    private static void deleteData(Double[][] studentGrade) {
        System.out.println("Please enter Student Number: ");
        int studNumber = scan.nextInt();
        Arrays.fill(studentGrade[--studNumber], (double) 0);
    }

    private static void clearFile() throws IOException {
        FileWriter fw = new FileWriter("Student.txt",false);
        PrintWriter out = new PrintWriter(fw, false);
        out.flush();
        out.close();
    }

    private static void readGrade(int arrStudents, Double[][] grades, int numberOfQuiz) throws IOException {

        displayHeader(numberOfQuiz);

        double average = 0;
        for (int i = 0; i < arrStudents; i++) {
            if(grades[i][0] != 0.0){
                System.out.println();
                System.out.printf(" %-20s ", "Student#"+ (i + 1));
                for (int j = 0; j < numberOfQuiz; j++) {
                    average += Double.parseDouble(String.valueOf(grades[i][j]));
                    System.out.printf(" %-20s ", grades[i][j].toString());
                }
                average /= 2;
                System.out.printf(" %-20s  %-20s ", average, average <= 100 && average >= 75 ? "Passed" :  "Failed");
                average = 0;
            }

        }

        saveDataToFile(arrStudents, grades, numberOfQuiz);

    }

    private static void saveDataToFile(int arrStudents, Double[][] grades, int numberOfQuiz) throws IOException {
        FileWriter fw = new FileWriter("Student.txt",true);
        PrintWriter out = new PrintWriter(fw);

        out.printf(" %-20s ", "List of Student:");
        for(int index = 1; index <= numberOfQuiz; index++){
            String rows = "Quiz #"+(index);
            out.printf(" %-20s ", rows);
        }
        out.printf(" %-20s ", "Average");
        out.printf(" %-20s ", "Remarks");


        double average = 0;
        for (int i = 0; i < arrStudents; i++) {
            if(grades[i][0] != 0.0) {
                out.println();
                out.printf(" %-20s ", "Student#" + (i + 1));
                for (int j = 0; j < numberOfQuiz; j++) {
                    average += Double.parseDouble(String.valueOf(grades[i][j]));
                    out.printf(" %-20s ", grades[i][j].toString());
                }
                average /= 2;
                out.printf(" %-20s  %-20s ", average, average <= 100 && average >= 75 ? "Passed" : "Failed");
                average = 0;
            }
        }

        out.close();
    }
    
    private static void displayHeader(int numberOfQuiz) {
        System.out.printf(" %-20s ", "List of Student:");
        for(int index = 1; index <= numberOfQuiz; index++){
            String rows = "Quiz #"+(index);
            System.out.printf(" %-20s ", rows);
        }
        System.out.printf(" %-20s  %-20s ", "Average", "Remarks");
    }
}

