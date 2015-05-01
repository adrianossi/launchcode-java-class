import java.text.DecimalFormat;

/**
 * Created by adrian on 4/29/15.
 */
public class Student {
    private String firstName;
    private String lastName;
    private int studentID;
    private double credits;
    private double gpa;

    public Student(String firstName, String lastName, int studentID, double credits, double gpa) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.studentID = studentID;
        this.credits = credits;
        this.gpa = gpa;
    }

    public Student(String firstName, String lastName, int studentID) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.studentID = studentID;
        this.credits = 0.0;
        this.gpa = 0.0;
    }

    public Student(Student parent1, Student parent2) {
        this.firstName = parent1.firstName + " " + parent1.lastName;
        this.lastName = parent2.firstName + " " + parent2.lastName;
        this.studentID = (int)(Math.random() * 999999);
        this.credits = Math.max(parent1.getCredits(), parent2.getCredits());
        this.gpa = (parent1.gpa + parent2.gpa) / 2;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public String getName() {
        return this.firstName + " " + this.lastName;
    }

    public void setFirstName (String firstName) {
        this.firstName = firstName;
    }

    public void setLastName (String lastName) {
        this.lastName = lastName;
    }

    public void setName (String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public int getStudentID() {
        return this.studentID;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    public double getCredits() {
        return this.credits;
    }

    public void setCredits(double credits) {
        this.credits = credits;
    }

    public double getGPA () {
        return this.gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    public String toString() {
        String stringID = String.valueOf(this.studentID);
        return this.firstName + " " + this.lastName + " " + stringID;
    }

    public String getClassStanding() {
        double credits = getCredits();
        if (credits >= 0 && credits < 30) {
            return "Freshman";
        }
        else if (credits >= 30 && credits < 60) {
            return "Sophomore";
        }
        else if (credits >= 60 && credits < 90) {
            return "Junior";
        }
        else if (credits >= 90) {
            return "Senior";
        }
        else {
            return "Error";
        }
    }

    public double submitGrade(double grade, double courseCredits) {
        DecimalFormat df = new DecimalFormat("#.#");
        double updatedGPA = Double.valueOf(df.format((this.getCredits() * this.getGPA() + courseCredits * grade) / (this.getCredits() + courseCredits)));
        this.setCredits(this.getCredits() + courseCredits);
        this.setGpa(updatedGPA);
        return updatedGPA;
    }

    public double computeTuition() {
        DecimalFormat df = new DecimalFormat("#.##");
        return Double.valueOf(df.format(getCredits() * (20000.0 / 15)));
    }

    public Student createLegacy(Student parent) {
        return new Student(this, parent);
    }

    public static void main(String args[]) {

        // create some students
        Student s1 = new Student("William", "Wallace", 333333, 29.5, 3.0);
        Student s2 = new Student("James", "Jones", 444444, 30.0, 2.1);
        Student s3 = new Student("Mary", "Matthews", 555555, 59.5, 4.0);
        Student s4 = new Student("Elizabeth", "Emerson", 666666, 67.0, 2.4);
        Student s5 = new Student("Valerie", "Vernon", 777777, 89.5, 3.7);
        Student s6 = new Student("Timothy", "Taylor", 888888, 90.5, 1.2);

        // make a legacy, print name, print tuition
        Student l1 = s1.createLegacy(s3);
        System.out.println(l1.toString());
        System.out.println(s1.computeTuition());
        System.out.println(""); // new line

        // make a course
        Course intro = new Course("Art History 101", 3.0, 5);

        // add all the students, print roster with class standing, print avg GPA
        intro.addStudent(s1);
        intro.addStudent(s2);
        intro.addStudent(s3);
        intro.addStudent(s4);
        intro.addStudent(s5);
        intro.addStudent(s6);

        System.out.println("The students enrolled in " + intro.getName() + " are:");
        for (int i = 0; i < intro.getFilledSeats(); i++) {
            System.out.println(intro.getRoster()[i].getName() + ", " + intro.getRoster()[i].getClassStanding());
        }

        System.out.println("The average GPA for students enrolled in " + intro.getName() + " is " + intro.averageGPA() + ".");
        System.out.println(""); // new line

        // Calculate total tuition enrolled students have paid
        double totalTuition = 0;
        for (int i = 0; i < intro.getFilledSeats(); i++) {
            totalTuition = totalTuition + intro.getRoster()[i].computeTuition();
        }
        System.out.println("Students enrolled in " + intro.getName() + " have paid $" + totalTuition + " to this fine institution.");
        System.out.println(""); // new line

        // submit a grade, printing before and after
        System.out.println(s5.getName() + "'s current GPA is " + s5.getGPA() + ", and she is a " + s5.getClassStanding() + ".");
        System.out.println(s5.getName() + " got a D in " + intro.getName());
        s5.submitGrade(1.0, 3.0);
        System.out.println(s5.getName() + "'s updated GPA is " + s5.getGPA() + ", " + "and her class standing is now " + s5.getClassStanding() + ".");
    }
}
