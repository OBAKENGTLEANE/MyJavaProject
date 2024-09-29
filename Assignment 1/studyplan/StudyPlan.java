/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package studyplan;

// Subject class (Inheritance)
class Subject {
    private String subjectName;
    private int mark;

    // Constructor
    public Subject(String subjectName, int mark) {
        this.subjectName = subjectName;
        this.mark = mark;
    }

    // Getters and Setters (Information Hiding)
    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }
}

// Student class
class Student {
    private String name;
    private Subject[] subjects;
    private double[] studyTimePercentages;

    // Constructor
    public Student(String name, Subject[] subjects) {
        this.name = name;
        this.subjects = subjects;
        this.studyTimePercentages = new double[subjects.length];
    }

    // Method to calculate study time percentages
    public void calculateStudyTime() {
        int totalMarks = 0;
        for (Subject subject : subjects) {
            totalMarks += subject.getMark();
        }

        for (int i = 0; i < subjects.length; i++) {
            // Formula to calculate study time: (100 - subject mark) * (percentage of total time)
            studyTimePercentages[i] = ((100 - subjects[i].getMark()) / 100.0) * (100.0 / subjects.length);
        }
    }

    // Method to display the report
    public void displayReport() {
        System.out.println("Student Report for: " + name);
        System.out.println("----------------------------------");
        for (int i = 0; i < subjects.length; i++) {
            System.out.printf("Subject: %s, Mark: %d, Study Time %%: %.2f%%%n", 
                subjects[i].getSubjectName(), subjects[i].getMark(), studyTimePercentages[i]);
        }
        System.out.println("----------------------------------");
    }

    // Getters and Setters (Information Hiding)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Subject[] getSubjects() {
        return subjects;
    }

    public void setSubjects(Subject[] subjects) {
        this.subjects = subjects;
    }

    public double[] getStudyTimePercentages() {
        return studyTimePercentages;
    }
}

// Main class
public class StudyPlan {
    public static void main(String[] args) {
        
        Subject[] subjects = new Subject[]{
            new Subject("Math", 70),
            new Subject("Science", 65),
            new Subject("History", 80)
        };

        // Create student
        Student student = new Student("John Doe", subjects);

        // Calculate study time percentages
        student.calculateStudyTime();

        // Display the report
        student.displayReport();
    }
}

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class StudyPlanTests {

    @Test
    void testCalculateStudyTime() {
        Subject[] subjects = new Subject[]{
            new Subject("Math", 70),
            new Subject("Science", 65),
            new Subject("History", 80)
        };
        
        Student student = new Student("John Doe", subjects);
        student.calculateStudyTime();

        double[] expectedStudyTimes = {9.0, 10.5, 6.0};
        assertArrayEquals(expectedStudyTimes, student.getStudyTimePercentages(), 0.1);
    }

    @Test
    void testInvalidMark() {
        Subject[] subjects = new Subject[]{
            new Subject("Math", 110)  // Invalid mark, should be between 0 and 100
        };
        
        Student student = new Student("John Doe", subjects);
        
        assertThrows(IllegalArgumentException.class, student::calculateStudyTime);
    }

    @Test
    void testZeroMark() {
        Subject[] subjects = new Subject[]{
            new Subject("Math", 0),
            new Subject("Science", 50),
            new Subject("History", 100)
        };

        Student student = new Student("John Doe", subjects);
        student.calculateStudyTime();

        double[] expectedStudyTimes = {33.33, 16.67, 0.0};
        assertArrayEquals(expectedStudyTimes, student.getStudyTimePercentages(), 0.1);
    }
}