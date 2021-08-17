package gradescalculation;

import java.util.ArrayList;

public class GradeReport {  // ���񺰷� �л��� ������ ����, �������� ���� ������ ���
	
	School ksjschool = School.getInstance();
	public static final String TITLE = " ������ ���� \t\t\n";
	public static final String HEADER = " �̸�  |  �й�  |  ��������  | ����   \n";
	public static final String LINE = "--------------------------------------------------------\n";
	private StringBuffer buffer = new StringBuffer();  

	public String getReport() {
		for(Subject subject : ksjschool.getSubjects()) {
			makeHeader(subject);
			makeBody(subject);
			makefoot();
		}
		return buffer.toString();
	}
	
	public void makeHeader(Subject subject) {
		buffer.append(LINE);
		buffer.append(subject.getSubjectName() + "\t" + TITLE);
		buffer.append(HEADER);
		buffer.append(LINE);
	}
	
	public void makeBody(Subject subject) {
		
		ArrayList <Student> tempStudentList = subject.getStudentList();
		
		for(int i=0;i<tempStudentList.size();i++) {
			Student student = tempStudentList.get(i);
			
			
			buffer.append(student.getStudentName()+"\t|\t");
			buffer.append(student.getStudentId()+"\t|\t"+student.getMajor().getSubjectName()+"\t\t|\t");
			int examScore = getScoreGrade(student,subject.getSubjectId());  
			
			String examGrade;
			
			MajorEvaluation majorEvaluation = new MajorEvaluation();
			BasicEvaluation basicEvaluation = new BasicEvaluation();
			
			if (student.getMajor() == subject) {  // �ش������ �л��� �ʼ������� ���,
				examGrade = majorEvaluation.pointSubject(examScore);
			}
			else {   
				examGrade = basicEvaluation.pointSubject(examScore);
			}
			
			buffer.append(examScore+" : "+examGrade+"\n");
			
		}
		
		
	}
	
	public int getScoreGrade(Student student, int subjectId) {
		// �л��� subjectID�� �ش��ϴ� �������� ���� 
		ArrayList <Score> scoreList = student.getScoreList();
		
		int resultScore=0;
		for(Score s : scoreList) {
			if (s.getSubject().getSubjectId() == subjectId) {
				resultScore = s.getPoint();
				return resultScore;
			}
		}
		return resultScore;
	}
	
	public void makefoot() {
		buffer.append("\n");
	}
	

}
