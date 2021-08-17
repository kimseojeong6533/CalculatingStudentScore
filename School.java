package gradescalculation;

import java.util.ArrayList;

public class School {
	
	private static School instance = new School();
	private static String SCHOOL_NAME = "SJ_School";
	private ArrayList <Student> students = new ArrayList<Student>();
	private ArrayList <Subject> subjects = new ArrayList<Subject>();
	
	// 이게 왜 필요?
	public static School getInstance() {
		if(instance == null) {
			instance = new School();
		}
		return instance;
	}
	
	public ArrayList<Student> getStudents() {
		return students;
	}
	public void addStudent(Student s) {
		this.students.add(s);
	}
	
	public void setStudents(ArrayList<Student> students) {
		this.students = students;
	}
	public ArrayList<Subject> getSubjects() {
		return subjects;
	}
	
	public void addSubject(Subject s) {
		this.subjects.add(s);
	}
	
	public void setSubjects(ArrayList<Subject> subjects) {
		this.subjects = subjects;
	}
	
	
	
}
