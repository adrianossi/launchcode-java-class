/**
 * Created by adrian on 4/30/15.
 */
public class Course {
    private String name;
    private double credits;
    private int totalSeats;
    private int filledSeats;
    private Student[] roster;

    public Course(String name, double credits, int totalSeats) {
        this.name = name;
        this.credits = credits;
        this.totalSeats = totalSeats;
        this.filledSeats = 0;
        this.roster = new Student[totalSeats];
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCredits(double credits) {
        this.credits = credits;
    }

    public String getName() {
        return this.name;
    }

    public double getCredits() {
        return this.credits;
    }

    public int getTotalSeats() {
        return this.totalSeats;
    }

    public int getFilledSeats() {
        return this.filledSeats;
    }

    public Student[] getRoster() {
        return this.roster;
    }

    public String toString() {
        return this.getName() + " " + this.getCredits();
    }

    public boolean addStudent(Student enrollee) {
        if (this.findStudent(enrollee)) {
            return true;
        }
        if (this.filledSeats == this.totalSeats) {
            return false;
        }
        this.getRoster()[this.filledSeats] = enrollee;
        this.filledSeats++;
        return true;

    }

    public boolean findStudent(Student enrollee) {
        for (int i = 0; i < this.totalSeats; i++) {
            if (this.getRoster()[i] == enrollee) {
                return true;
            }
        }
        return false;
    }

    public void printRoster() {
        for (int i = 0; i < this.getFilledSeats(); i++) {
            System.out.println(this.getRoster()[i].getName());
        }
    }

    public double averageGPA() {
        double summedGPAs = 0;
        for (int i = 0; i < this.getFilledSeats(); i++) {
            summedGPAs = this.getRoster()[i].getGPA() + summedGPAs;
        }
        return ((double)(Math.round((summedGPAs / this.getFilledSeats()) * 10)))/10;
    }
}
