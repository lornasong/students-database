package database;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class StudentDatabaseMap {
	
	private final String schoolName;
	Map<Integer, Student> studentMap = new HashMap<Integer, Student>();

	// Notes: This will update by not change. Make final so won't be replaced

	public StudentDatabaseMap(String schoolName) {
		this.schoolName = schoolName;
	}

	public String getSchoolName() {
		return schoolName;
	}
	
	public Map<Integer, Student> getStudentList(){
		return studentMap;
	}

	/**
	 * Look for student's full name in array list. Using for-each loop
	 */
	// Combine findStudentByName and findStudentByID using a method as a
	// parameter
	public Student getStudentByFullName(String fullName) {

		for (Student student : studentMap) {

			// Student is in student array list
			if (student.getFullName().equals(fullName)) {
				return student;
			}
		}
		// Student is not in array list
		return null;
	}

	/**
	 * Look for student id in array list. Using while loop iterator Notes: use
	 * iterator when removing things from that array
	 */
	private Student getStudentByID(int studentID) {

		return studentMap.getValue
		
		Iterator<Student> it = studentMap.iterator();

		// Loop through student array list to remove
		while (it.hasNext()) {
			Student student = it.next();

			// Student is in student array list
			if (student.getID() == studentID) {
				return student;
			}
		}
		// Student is not in array
		return null;
	}

	/**
	 * Creates an instance of Student and adds object to arrayList of database
	 */
	public void addStudent(String firstName, String lastName, int age) {
		Student student = new Student(firstName, lastName, age);
		studentMap.add(student);
	}

	/**
	 * If there are students enrolled, print student ID and full name Else no
	 * students enrolled, print error message
	 */
	public void printStudents() {

		// Case that no student is enrolled
		if (studentMap.isEmpty()) {
			System.out.println("Error: No students are enrolled at "
					+ getSchoolName());
		}
		// Case that students are enrolled
		else {

			System.out.println("Students Enrolled At " + getSchoolName() + ":");

			for (Student student : studentMap) {
				System.out.println(student); // This is the student.toString()
			}
		}

	}

	/**
	 * Calls findStudentByFullName(fullName) If is not found, print error message
	 * Else student full name is found, remove object and print message
	 */
	public void removeStudent(String fullName) {

		Student student = getStudentByFullName(fullName);

		// Student is not in array list
		if (student == null) {
			System.out.println("Error: Student is not enrolled at "
					+ getSchoolName());
		}
		// Student is in array list
		else {
			studentMap.remove(student);
			System.out.println(fullName
					+ " has been removed from the database");
		}

	}

	/**
	 * Returns the student ID for a query of a student name
	 */
	public int searchByFullName(String userInput) {
		Student student = getStudentByFullName(userInput);
		return student.getID();
	}

	/**
	 * Returns the student's full name for a query of a student ID
	 */
	public String searchByID(int studentId) {
		Student student = getStudentByID(studentId);
		return student.getFullName();
	}
	
	public void editStudentName(Student student, String newFirstName, String newLastName){
		student.setFirstName(newFirstName);
		student.setLastName(newLastName);
	}
	
}
