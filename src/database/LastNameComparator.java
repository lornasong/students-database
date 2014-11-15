package database;

import java.util.Comparator;

public class LastNameComparator implements Comparator<Student> {

	@Override
	public int compare(Student student1, Student student2){
		if (student1.getLastName().equals(student2.getLastName())){
			return student1.getFirstName().compareTo(student2.getFirstName());
		}
		else{
			return student1.getLastName().compareTo(student2.getLastName());
		}
	}
}
