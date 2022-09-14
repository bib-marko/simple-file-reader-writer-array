import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Optional;
import java.util.Scanner;

public class ArrayB {
    public static void main(String[] args) throws IOException {

        int flag = 0;
        Scanner scan = new Scanner(System.in);

        System.out.print("Please input the number of Students: ");
        int numberOfStud = scan.nextInt();
        int[] stud = new int[numberOfStud];

        System.out.print("Please input the number of Quizzes: ");
        int numberOfQuiz = scan.nextInt();


        Object[][]studentGrade = new Object[numberOfStud][];

        System.out.println("Grades of Quizzes: ");


        //Get the input of the Quizzes
        for (int i = 0; i < stud.length; i++) {
            Integer[] grades = new Integer[numberOfQuiz];
            System.out.println("Student#" + (i + 1) + ": ");

            for (int j = 0; j < grades.length; j++) {
                System.out.print("Quiz #" + (j + 1) + ": ");
                grades[j] = scan.nextInt();
//                    //Checker: Grade must not be over 100 or less than 50
//                    if (grades[j] > 100 || grades[j] < 50) {
//                        System.out.println("Grade must not be over 100!");
//                    }
            }
            studentGrade[i] = grades;
        }


        do {

            System.out.println("\nMain Menu\n"
                    + "1. View Grades\n"
                    + "2. Update Grades\n"
                    + "3. Delete Grades\n"
                    + "4. Exit \n"
            );
            System.out.print("Please select an option: ");
            int option = scan.nextInt();

            switch (option) {
                case 1:
                    readGrade(stud, studentGrade, numberOfStud);
                    System.out.println("=========================================================================================");
                    break;
                case 2:

                    System.out.println("=========================================================================================");
                    break;
                case 3:

                    System.out.println("=========================================================================================");
                    break;
                case 4:
                    flag++;
                    System.out.println("INSERT YOUR NAME HERE");
                    break;
                default:
                    System.out.println("INVALID OPTION");
            }
        } while (flag == 0);
    }

    private static void readGrade(int[] arrStudents, Object[] grades, int numberOfQuiz) throws IOException {

        double average;
        String remarkFail = "Failed";
        String remarkPass = "Passed";
        int sum = 0;
        int length = grades.length;
        BufferedWriter writer = new BufferedWriter(new FileWriter("Student.txt"));


        //Display table
        for (int i = 0; i < arrStudents.length; i++) {
            writer.write("Student#" + (i + 1));
            writer.newLine();
            System.out.println("Student#" + (i + 1));

            for (int j = 0; j < grades.length; j++) {
                writer.write("Quiz#" + (j + 1) + ": " + grades[j]);
                writer.newLine();
                System.out.println("Quiz#" + (j + 1) + ": " + grades[j]);


//                //Get the Average
//                for (int grade : grades) {
//                    sum += grade;
//                }
//                average = sum / length;
//                writer.write("Average: " + average);
//                writer.newLine();
//                System.out.println("Average: " + average);
//
//                //Get the Remarks: (Pass or Fail)
//                if (average >= 75 && average <= 100) {
//                    writer.write("Remarks: " + remarkPass);
//                    writer.newLine();
//                    System.out.println(remarkPass);
//                } else {
//                    writer.write("Remarks: " + remarkFail);
//                    writer.newLine();
//                    System.out.println(remarkFail);
//                }

            }

        }
        writer.flush();
        writer.close();

    }


    private static File updateGrades(int arrStudents[], int grades) {

        return null;
    }

    private static File deleteGrades(int arrStudents[], int grades) {

        return null;
    }
}

