import static org.junit.Assert.*;

import org.junit.Test;

import junit.framework.TestCase;
/**
 * JUnit tests for Student and Course
 * @author dshook
 *
 */
public class StudentAndCourseTest extends TestCase {
	@Test
	public void testStudentInitWithGPA() {
		Student s = new Student("Doug", "Shook", 111111, 30.0, 3.9);
		assertEquals("Doug Shook", s.getName());
		assertEquals(111111, s.getStudentID());
		assertEquals(30.0, s.getCredits());
		assertEquals(3.9, s.getGPA());

        //Generate some random students, and test
		for (int i = 0; i < 20; ++i) {
			double a =  (Math.random() * 5000);
			double b =  (Math.random() * 5000);
			int c = (int)(Math.random() * 5000);
			double cred3 = Math.random() * 120;
			double gpa3 = Math.random() * 4.0;
			Student s3 = new Student("" + a, "" + b, c, cred3, gpa3);
			assertEquals(a + " " + b, s3.getName());
			assertEquals(c, s3.getStudentID());
			assertEquals(cred3, s3.getCredits());
			assertEquals(gpa3, s3.getGPA());
		}
	}

	@Test
	public void testStudentInitWithoutGPA() {
		Student s = new Student("Doug", "Shook", 111111);
		assertEquals("Doug Shook", s.getName());
		assertEquals(111111, s.getStudentID());
		//No credits, no GPA
		assertEquals(0.0, s.getCredits());
		assertEquals(0.0, s.getGPA());

		//Generate some random students, and test
		for (int i = 0; i < 20; ++i) {
			double a =  (Math.random() * 5000);
			double b =  (Math.random() * 5000);
			int c = (int)(Math.random() * 5000);
			Student s3 = new Student("" + a, "" + b, c);
			assertEquals(a + " " + b, s3.getName());
			assertEquals(0.0, s3.getGPA());
			assertEquals(0.0, s3.getCredits());
		}
	}

    @Test
    public void testToStringStudent() {
		Student s4 = new Student("John", "Smith", 222222, 29.5, 3.5);
		assertEquals("John Smith 222222", s4.toString());
	}

	@Test
	public void testGetClassStanding() {
		Student s5 = new Student("William", "Wallace", 333333, 29.5, 3.0);
		assertEquals("Freshman", s5.getClassStanding());
		Student s6 = new Student("James", "Jones", 444444, 30.0, 2.1);
		assertEquals("Sophomore", s6.getClassStanding());
		Student s7 = new Student("Mary", "Matthews", 555555, 59.5, 4.0);
		assertEquals("Sophomore", s7.getClassStanding());
		Student s8 = new Student("Elizabeth", "Emerson", 666666, 67.0, 2.4);
		assertEquals("Junior", s8.getClassStanding());
		Student s9 = new Student("Valerie", "Vernon", 777777, 89.5, 3.7);
		assertEquals("Junior", s9.getClassStanding());
		Student s10 = new Student("Timothy", "Taylor", 888888, 90.5, 1.2);
		assertEquals("Senior", s10.getClassStanding());
	}

	@Test
	public void testSubmitGrade() {
		Student s5 = new Student("William", "Wallace", 333333, 29.5, 3.0);
		assertEquals(3.0, s5.submitGrade(2.5, 3.0));
	}

	@Test
	public void testComputeTuition() {
		Student s10 = new Student("Timothy", "Taylor", 888888, 90.5, 1.2);
		assertEquals(120666.67, s10.computeTuition());
	}

	@Test
	public void testCreateLegacy() {
		Student p1 = new Student("William", "Wallace", 333333, 29.5, 3.0);
		Student p2 = new Student("Valerie", "Vernon", 777777, 89.5, 3.7);
		Student legacy = p1.createLegacy(p2);
		assertEquals("William Wallace Valerie Vernon", legacy.getName());
		assertEquals(3.35, legacy.getGPA());
		assertEquals(89.5, legacy.getCredits());
	}

	@Test
	public void testCourseInit() {
		Student p1 = new Student("William", "Wallace", 333333, 29.5, 3.0);
		Student p2 = new Student("Valerie", "Vernon", 777777, 89.5, 3.7);
		Course intro = new Course("Art History 101", 3.0, 50);
		assertEquals("Art History 101", intro.getName());
		assertEquals(3.0, intro.getCredits());
		assertEquals(50, intro.getTotalSeats());
	}

	@Test
	public void testToStringCourse() {
		Student p1 = new Student("William", "Wallace", 333333, 29.5, 3.0);
		Student p2 = new Student("Valerie", "Vernon", 777777, 89.5, 3.7);
		Student[] roster = new Student[2];
		roster[0] = p1;
		roster[1] = p2;
		Course intro = new Course("Art History 101", 3.0, 50);
		assertEquals("Art History 101 3.0", intro.toString());
	}

	@Test
	public void testAddStudent() {
		Student s1 = new Student("William", "Wallace", 333333, 29.5, 3.0);
		Student s2 = new Student("Valerie", "Vernon", 777777, 89.5, 3.7);
		Student s3 = new Student("Elizabeth", "Emerson", 666666, 67.0, 2.4);
		Course intro = new Course("Art History 101", 3.0, 2);
		assertEquals(true, intro.addStudent(s1));
		assertEquals(s1, intro.getRoster()[0]);
		assertEquals(true, intro.addStudent(s2));
		assertEquals(s2, intro.getRoster()[1]);
		assertEquals(false, intro.addStudent(s3));
		assertEquals(true, intro.addStudent(s1));
	}

	@Test
	public void testPrintRoster() {
		Student s1 = new Student("William", "Wallace", 333333, 29.5, 3.0);
		Student s2 = new Student("Valerie", "Vernon", 777777, 89.5, 3.7);
		Student s3 = new Student("Elizabeth", "Emerson", 666666, 67.0, 2.4);
		Course intro = new Course("Art History 101", 3.0, 5);
		intro.addStudent(s1);
		intro.addStudent(s2);
		intro.addStudent(s3);
		intro.printRoster();
	}

	@Test
	public void testAverageGPA() {
		Student s1 = new Student("William", "Wallace", 333333, 29.5, 3.0);
		Student s2 = new Student("Valerie", "Vernon", 777777, 89.5, 3.7);
		Student s3 = new Student("Elizabeth", "Emerson", 666666, 67.0, 2.4);
		Course intro = new Course("Art History 101", 3.0, 5);
		intro.addStudent(s1);
		intro.addStudent(s2);
		intro.addStudent(s3);
		assertEquals(3.0, intro.averageGPA());
	}


}


