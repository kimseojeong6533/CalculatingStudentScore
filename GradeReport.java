package gradescalculation;

import java.util.ArrayList;

public class GradeReport {  // 과목별로 학생의 정보와 점수, 중점과목에 따른 학점을 출력
	
	School ksjschool = School.getInstance();
	public static final String TITLE = " 수강생 학점 \t\t\n";
	public static final String HEADER = " 이름  |  학번  |  중점과목  | 점수   \n";
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
			
			if (student.getMajor() == subject) {  // 해당과목이 학생의 필수과목일 경우,
				examGrade = majorEvaluation.pointSubject(examScore);
			}
			else {   
				examGrade = basicEvaluation.pointSubject(examScore);
			}
			
			buffer.append(examScore+" : "+examGrade+"\n");
			
		}
		
		
	}
	
	public int getScoreGrade(Student student, int subjectId) {
		// 학생의 subjectID에 해당하는 과목점수 산출 
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
