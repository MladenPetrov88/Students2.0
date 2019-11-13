import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Students {
    static class Student {
        String firstName;
        String lastName;
        double grade;

        Student (String firstName, String lastName, double grade) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.grade = grade;
        }

        public double getGrade () {
            return this.grade;
        }

        @Override
        public String toString() {
            return String.format("%s %s: %.2f", firstName, lastName, grade);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int count = Integer.parseInt(scanner.nextLine());
        List<Student> students = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            String[] temp = scanner.nextLine().split("\\s+");
            String firstName = temp[0];
            String lastName = temp[1];
            double grade = Double.parseDouble(temp[2]);

            Student student = new Student(firstName, lastName, grade);
            students.add(student);
        }

        students.stream().sorted((s1, s2) -> Double.compare(s2.getGrade(),s1.getGrade())).forEach(e -> System.out.println(e));

    }
}
