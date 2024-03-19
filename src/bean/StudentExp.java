package bean;

import java.io.Serializable;

public class StudentExp extends Student implements Serializable {

	private String courseName; //chap15問題15で追加
	private boolean checkFlg = false; //chap17問題15で追加

	//chap15問題15で追加
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	//chap17問題15で追加
	public boolean isCheck() {
		return checkFlg;
	}
	public void setCheck() {
		this.checkFlg = true;
	}

}
