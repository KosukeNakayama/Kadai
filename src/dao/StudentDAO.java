package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bean.Student;
import bean.StudentExp;

public class StudentDAO extends DAO {

	public List<Student> selectAll() throws Exception{

		List<Student> list = new ArrayList<>();
		Connection con = getConnection();

		PreparedStatement st = con.prepareStatement(
				"SELECT * FROM STUDENT");
		ResultSet rs = st.executeQuery();

		while(rs.next()){
			Student stu = new Student();
			stu.setStudentId(rs.getInt("student_id"));
			stu.setStudentName(rs.getString("student_name"));
			stu.setCourseId(rs.getInt("course_id"));
			list.add(stu);
		}

		st.close();
		con.close();

		return list;
	}

	//chap15問題15で追加
	public List<StudentExp> selectAllWithCourseName() throws Exception{

		List<StudentExp> list = new ArrayList<>();
		Connection con = getConnection();

		PreparedStatement st = con.prepareStatement(
				"SELECT * FROM STUDENT JOIN COURSE ON STUDENT.COURSE_ID = COURSE.COURSE_ID");
		ResultSet rs = st.executeQuery();

		while(rs.next()){
			StudentExp stu = new StudentExp();
			stu.setStudentId(rs.getInt("student_id"));
			stu.setStudentName(rs.getString("student_name"));
			stu.setCourseId(rs.getInt("course_id"));
			stu.setCourseName(rs.getString("course_name"));
			list.add(stu);
		}

		st.close();
		con.close();

		return list;
	}

	//chap16問題11で追加
	public int insertStudent(Student stu) throws Exception{
		//DBとの接続
		Connection con = getConnection();

		//新しいＩＤを決めるために現在の最大ＩＤを求める必要がある
		PreparedStatement st1 = con.prepareStatement("SELECT MAX(STUDENT_ID) AS MAX FROM STUDENT");
		ResultSet rs = st1.executeQuery();
		rs.next();
		int maxId = rs.getInt("max");

		//SQL文の準備
		PreparedStatement st = con.prepareStatement("INSERT INTO STUDENT VALUES (?,?,?)");
		st.setInt(1, maxId+1);//今、ＤＢで使われている、最大のＩＤの＋１
		st.setString(2, stu.getStudentName());
		st.setInt(3, stu.getCourseId());


		//SQL文の実行(DBの更新)
		int num = st.executeUpdate();

		//DBとの接続を切る
		st.close();
		con.close();

		//更新した行数を返却する
		return num;

//		Connection con = getConnection();
//		PreparedStatement st=con.prepareStatement(
//				"SELECT MAX(STUDENT_ID) AS max FROM STUDENT");
//		ResultSet rs=st.executeQuery();
//		rs.next();
//		int max = rs.getInt("max");
//
//		st = con.prepareStatement("INSERT INTO STUDENT VALUES (?,?,?)");
//		st.setInt(1, max+1);
//		st.setString(2, stu.getStudentName());
//		st.setInt(3, stu.getCourseId());
//		int line=st.executeUpdate();
//		stu.setStudentId(max+1);

//		return line;

	}

	//chap16問題12で追加
	public List<StudentExp> partialMatchSearchByName(String name) throws Exception{

		List<StudentExp> list = new ArrayList<>();
		Connection con = getConnection();
		PreparedStatement st = con.prepareStatement(
				"SELECT * FROM STUDENT JOIN COURSE ON STUDENT.COURSE_ID = COURSE.COURSE_ID WHERE STUDENT_NAME LIKE ?");
		st.setString(1, "%"+ name +"%");
		ResultSet rs = st.executeQuery();
		while(rs.next()){
			StudentExp stu = new StudentExp();
			stu.setStudentId(rs.getInt("student_id"));
			stu.setStudentName(rs.getString("student_name"));
			stu.setCourseId(rs.getInt("course_id"));
			stu.setCourseName(rs.getString("course_name"));
			list.add(stu);
		}

		st.close();
		con.close();

		return list;
	}

	//chap17問題14で追加
	public StudentExp selectById(int id) throws Exception{

		Connection con = getConnection();

		PreparedStatement st = con.prepareStatement(
				"SELECT * FROM STUDENT JOIN COURSE ON STUDENT.COURSE_ID = COURSE.COURSE_ID WHERE STUDENT_ID = ?");
		st.setInt(1, id);
		ResultSet rs = st.executeQuery();
		StudentExp stu = new StudentExp();
		rs.next();
		stu.setStudentId(rs.getInt("student_id"));
		stu.setStudentName(rs.getString("student_name"));
		stu.setCourseId(rs.getInt("course_id"));
		stu.setCourseName(rs.getString("course_name"));
		st.close();
		con.close();

		return stu;
	}

	//chap17問題15で追加
	public List<StudentExp> selectByIds(String[] ids) throws Exception{
		Connection con = getConnection();
		List<StudentExp> list = new ArrayList<>();

		String SQL = "SELECT * FROM STUDENT JOIN COURSE ON STUDENT.COURSE_ID = COURSE.COURSE_ID WHERE STUDENT_ID in (";

		for(int i=0;i<ids.length;i++){
			if(i==0){
				SQL += "?";
			}else{
				SQL += ",?";
			}
		}
		SQL += ")";

		PreparedStatement st = con.prepareStatement(SQL);
		for(int j=0;j<ids.length;j++){
			st.setInt(j+1, Integer.parseInt(ids[j]));
		}
		ResultSet rs = st.executeQuery();

		while(rs.next()){
			StudentExp stu = new StudentExp();
			stu.setStudentId(rs.getInt("student_id"));
			stu.setStudentName(rs.getString("student_name"));
			stu.setCourseId(rs.getInt("course_id"));
			stu.setCourseName(rs.getString("course_name"));
			list.add(stu);
		}

		st.close();
		con.close();

		return list;
	}

	//chap20問題15で追加
	public int update(Student stu) throws Exception{
		Connection con = getConnection();

		PreparedStatement st = con.prepareStatement("UPDATE STUDENT SET STUDENT_NAME = ?,COURSE_ID = ? WHERE STUDENT_ID = ?");
		st.setString(1, stu.getStudentName());
		st.setInt(2, stu.getCourseId());
		st.setInt(3, stu.getStudentId());
		int line = st.executeUpdate();
		st.close();
		con.close();
		return line;
	}

	//Chap22 問題12で追加
	public int insertStudents(List<Student> list) throws Exception{
		if (list.size() == 0) return 0;

		Connection con = getConnection();

		PreparedStatement st1 = con.prepareStatement("SELECT MAX(STUDENT_ID) AS MAX FROM STUDENT");
		ResultSet rs = st1.executeQuery();
		rs.next();
		int maxId = rs.getInt("max");

		String SQL = "INSERT INTO STUDENT VALUES ";
		for(int i=0;i<list.size();i++){
			if(i==0){
				SQL += "(?,?,?)";
			}else{
				SQL += ",(?,?,?)";
			}
		}

		PreparedStatement st = con.prepareStatement(SQL);

		for(int i=0;i<list.size();i++){
			st.setInt(1+3*i, ++maxId);
			st.setString(2+3*i, list.get(i).getStudentName());
			st.setInt(3+3*i, list.get(i).getCourseId());
		}

		int num = st.executeUpdate();

		st.close();
		con.close();

		return num;
	}

}
