package database;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Student Database Class that uses Student. This version is built off of Class
 * StudentDatabase but adapted to work with a webpage rather than a console.
 * Includes methods that are in Class Controller.
 * 
 * @author lsong
 */
public class StudentDatabaseWeb {

	private final String schoolName;
	private final List<Student> studentList = new ArrayList<Student>();

	public StudentDatabaseWeb(String schoolName) {
		this.schoolName = schoolName;
	}

	public String getSchoolName() {
		return schoolName;
	}


	/**
	 * Updated:
	 * Combination of getStudentbyID and getStudentByFullName and its search methods.
	 * Needs to be redone for more complex search queries.
	 * Get ID as a string to consider cases when ID is not inputed e.g. ''
	 */
	public String getStudentByParameters(String fullName, int id){
		
		//If ID field is provided, check only ID since ID is unique.		
		if (id > 0){
			for (Student student : studentList){
				if(student.getID() == id){
					return "<br/>" + student.toString();
				}
			}
		}
		
		//Find all students who have the full name with matches. May not be unique
		String matches = "";
		if (fullName != null && !fullName.trim().isEmpty()){
			for (Student student : studentList) {

				if (student.getFullName().equals(fullName)) {
					matches = matches + "<br/>" + student.toString();
				}
			}
			return matches;
		}
		
		return "No matches";
	}

	/**
	 * Look for student's full name in array list. Using for-each loop
	 */
	// Combine findStudentByName and findStudentByID using a method as a
	// parameter
	public Student getStudentByFullName(String fullName) {

		for (Student student : studentList) {

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

		Iterator<Student> it = studentList.iterator();

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
	public String addStudent(String firstName, String lastName, int age) {
		Student student = new Student(firstName, lastName, age);
		studentList.add(student);

		return student.toString() + " has been sucessfully added";
	}

	 /**
	  * Returns list of students that breaks after each student using html.
	  * Based off of StudentDatabase.printStudents()
	  */
	public String getStudentListString() {

		// Case that no student is enrolled
		if (studentList.isEmpty()) {
			return "Error: No students are enrolled";
		}
		// Case that students are enrolled
		else {

			StringBuilder sb = new StringBuilder();

			for (Student student : studentList) {
				sb.append(student); // This is the student.toString()
				sb.append("<br/>");
			}

			return sb.toString();
		}

	}
	
	public List<Student> getStudentList(){
		return studentList;
	}

	/**
	 * Calls findStudentByFullName(fullName) If is not found, print error
	 * message Else student full name is found, remove object and print message
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
			studentList.remove(student);
			System.out
					.println(fullName + " has been removed from the database");
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

	public void editStudentName(Student student, String newFirstName,
			String newLastName) {
		student.setFirstName(newFirstName);
		student.setLastName(newLastName);
	}
	
	/**
	 * Saves user's database as a csv file named by the school on
	 * desktop
	 */
	public String saveDataAsCsv() {
		String filename = "/Users/lornasong/Desktop/"
				+ getSchoolName() + ".csv";

		File file = new File(filename);

		try {

			FileWriter fw = new FileWriter(file);
			PrintWriter out = new PrintWriter(fw);
			// very expensive. synchronized. try buffered writer wrapped in

			out.println("ID,Student Name,Age");

			for (Student s : getStudentList()) {
				out.println(s.getID() + "," + s.getFullName() + ", "
						+ s.getAge());
			}

			out.close(); // close will already flush
			fw.close();

			return "Your csv has been saved on your desktop.";

		} catch (IOException e) {
			return "Error saving file";
		}

	}

}
