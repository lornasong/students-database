package database;

/**
 * Entity Student Class
 * @author lsong
 * 8 September 2014
 */
public class Student {
	
	private String firstName;
	private String lastName;
	private int age;
	private static int nextId = 1;
	private final int studentId;
	
	public Student(String firstName, String lastName, int age) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		studentId = nextId++;
	}
	
	public String getFirstName(){
		return firstName;
	}
	
	public String getLastName(){
		return lastName;
	}
	
	public int getAge(){
		return age;
	}
	
	public String getFullName(){
		return firstName + " " + lastName;
	}
	
	public int getID(){
		return studentId;
	}
	
	public void setFirstName(String newFirstName){
		this.firstName = newFirstName;
	}
	
	public void setLastName(String newLastName){
		this.lastName = newLastName;
	}

	@Override//return a different int for every student
	//trying to calculate a unique number for each student
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result
				+ ((lastName == null) ? 0 : lastName.hashCode());
		return result;
	}

	@Override//Typically reference equality (not value equality) (HashMap has overriden this). can do equals builder. make sure to do toHashCode
	//Now override:
	public boolean equals(Object obj) {
		//if (this == obj) Usually can get rid of this
		//	return true;
		if (obj == null || getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ID: "  + getID() + " | Name: "+ getFullName() + " | Age: " + getAge();
	}
}