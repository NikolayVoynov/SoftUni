import java.util.Scanner;

public class ExamPreparation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberLowGrade = Integer.parseInt(scanner.nextLine());
        String problem = scanner.nextLine();

        int counterLowGrade = 0;
        String lastProblem = "";
        int sumGrade = 0;
        int counterProblems = 0;
        int counterGrades = 0;
        double averageGrade = 0.0;

        while (!problem.equals("Enough")) {
            int grade = Integer.parseInt(scanner.nextLine());
            lastProblem = problem;
            sumGrade += grade;
            counterProblems++;
            counterGrades++;

            if (grade <= 4) {
                counterLowGrade++;
                if (counterLowGrade == numberLowGrade) {
                    System.out.printf("You need a break, %d poor grades.", numberLowGrade);
                    return;
                }
            }

            problem = scanner.nextLine();
        }
        averageGrade = sumGrade * 1.0 / counterGrades;
        System.out.printf("Average score: %.2f%n", averageGrade);
        System.out.printf("Number of problems: %d%n", counterProblems);
        System.out.printf("Last problem: %s", lastProblem);

    }
}

