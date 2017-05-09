/*
    link: https://www.hackerrank.com/challenges/30-inheritance?h_r=next-challenge&h_v=zen
    point: 100/100
*/

import java.util.Scanner;

public class Main {
    static boolean debug = false;

    public static void main(String[] args) {
        new Main().run();
    }

    void run() {
        Scanner in = new Scanner(System.in);
        int arr[][] = new int[6][6];
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                arr[i][j] = in.nextInt();
            }
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < 4; i++)
            for (int j = 0; j < 4; j++) {
                int sum = arr[i][j] + arr[i][j + 1] + arr[i][j + 2]
                            + arr[i + 1][j + 1]
                        + arr[i + 2][j] + arr[i + 2][j + 1] + arr[i + 2][j + 2];
                if (max < sum)
                    max = sum;
            }
        System.out.println(max);
    }


    class Person {
        protected String firstName;
        protected String lastName;
        protected int idNumber;

        // Constructor
        Person(String firstName, String lastName, int identification){
            this.firstName = firstName;
            this.lastName = lastName;
            this.idNumber = identification;
        }

        // Print person data
        public void printPerson(){
            System.out.println(
                    "Name: " + lastName + ", " + firstName
                            + 	"\nID: " + idNumber);
        }

    }

    class Student extends Person{
        private int[] testScores;

        /*
        *   Class Constructor
        *
        *   @param firstName - A string denoting the Person's first name.
        *   @param lastName - A string denoting the Person's last name.
        *   @param id - An integer denoting the Person's ID number.
        *   @param scores - An array of integers denoting the Person's test scores.
        */
        // Write your constructor here
        Student(String firstName, String lastName, int id, int[] scores) {
            super(firstName, lastName, id);
            this.testScores = scores;
        }

        /*
        *   Method Name: calculate
        *   @return A character denoting the grade.
        */
        // Write your method here
        char calculate() {
            int sum = 0;
            for (int i = 0; i < testScores.length; i++)
                sum += testScores[i];
            double avg = ((double) sum) / testScores.length;
            if (avg >= 90)
                return 'O';
            if (avg >= 80)
                return 'E';
            if (avg >= 70)
                return 'A';
            if (avg >= 55)
                return 'P';
            if (avg >= 40)
                return 'D';
            return 'T';
        }
    }
}