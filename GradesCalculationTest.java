package gradescalculation;

import java.util.ArrayList;
import java.util.Arrays;

public class GradesCalculationTest {

	School school = School.getInstance();
	public static int studentId_Start = 1000;
	Subject korean;
	Subject math;
	GradeReport GradeReport = new GradeReport();
	
	public static void main(String[] args) {
		
		GradesCalculationTest test = new GradesCalculationTest();
		test.createSubject();  // 과목 생성
		test.createStudent();  // 학생생성-등록-과목별 점수입력

		System.out.println(test.GradeReport.getReport());   // 과목별 학생점수 및 학점 출력
		      
		
	}
	
	// 과목 생성 
	public void createSubject() {
		korean = new Subject(1,"국어");
		math = new Subject(2,"수학");
		
		school.addSubject(korean);
		school.addSubject(math);
	}
	
	
	public void createStudent() {
		//학생 임의로 생성
		Student st1 = new Student(studentId_Start++,"김서정",math);
		Student st2 = new Student(studentId_Start++,"정형돈",korean);
		Student st3 = new Student(studentId_Start++,"노홍철",korean);
		Student st4 = new Student(studentId_Start++,"유재석",math);
		Student st5 = new Student(studentId_Start++,"박명수",math);
		
		//학생 등록
		school.addStudent(st1);
		school.addStudent(st2);
		school.addStudent(st3);
		school.addStudent(st4);
		school.addStudent(st5);
		
		//Subject의 studentList에 add
		korean.addStudent(st1);
		korean.addStudent(st2);
		korean.addStudent(st3);
		korean.addStudent(st4);
		korean.addStudent(st5);
		
		math.addStudent(st1);
		math.addStudent(st2);
		math.addStudent(st3);
		math.addStudent(st4);
		math.addStudent(st5);
		
		
		// 각 학생의 과목별 점수를 추가
		addScoreForStudent(st1,korean,95);
		addScoreForStudent(st1,math,56);
		
		addScoreForStudent(st2,korean,95);
		addScoreForStudent(st2,math,95);
		
		addScoreForStudent(st3,korean,100);
		addScoreForStudent(st3,math,88);
		
		addScoreForStudent(st4,korean,89);
		addScoreForStudent(st4,math,95);
		
		addScoreForStudent(st5,korean,85);
		addScoreForStudent(st5,math,56);
		
	}
	
	public void addScoreForStudent(Student student, Subject subject, int point) {
		Score score = new Score(student.getStudentId(),subject,point);
		student.addSubjectScore(score);
	}

}
