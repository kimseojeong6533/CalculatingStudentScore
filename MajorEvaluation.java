package gradescalculation;

// 필수과목 학점 기준
public class MajorEvaluation implements ScorePolicy{

	@Override
	public String pointSubject(int point) {
		if (point>=95 && point<=100) {
			return "S";
		}
		else if(point>=90 && point<95) {
			return "A";
		}
		else if(point>=80 && point<90) {
			return "B";
		}
		else if(point>=70 && point<80) {
			return "C";
		}
		else if(point>=60 && point<70) {
			return "D";
		}
		else {
			return "F";
		}
	}

}
