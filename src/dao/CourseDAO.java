package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bean.Course;

public class CourseDAO extends DAO {

	public List<Course> selectAll() throws Exception{

		List<Course> list = new ArrayList<>();
		Connection con = getConnection();

		PreparedStatement st = con.prepareStatement(
				"SELECT * FROM COURSE");
		ResultSet rs = st.executeQuery();

		while(rs.next()){
			Course cou = new Course();
			cou.setCourseId(rs.getInt("course_id"));
			cou.setCourseName(rs.getString("course_name"));
			list.add(cou);
		}

		st.close();
		con.close();

		return list;
	}

	//chap20問題14で追加
	public Course insert(String name) throws Exception{
		Connection con = getConnection();

		PreparedStatement st = con.prepareStatement(
				"SELECT MAX(COURSE_ID) AS MAXID FROM COURSE");
		ResultSet rs = st.executeQuery();
		rs.next();
		int id = rs.getInt("MAXID") + 1;

		st = con.prepareStatement(
				"INSERT INTO COURSE VALUES (?,?)");
		st.setInt(1, id);
		st.setString(2, name);

		int line = st.executeUpdate();
		Course cou = null;

		if(line > 0){
			cou = new Course();
			cou.setCourseId(id);
			cou.setCourseName(name);
		}

		st.close();
		con.close();

		return cou;
	}

	//chap21問題12で追加
	public Course delete(int id) throws Exception{
		Connection con = getConnection();
		Course cou = new Course();

		PreparedStatement st = con.prepareStatement(
				"SELECT * FROM COURSE WHERE COURSE_ID = ?");
		st.setInt(1, id);
		ResultSet rs = st.executeQuery();
		rs.next();
		cou.setCourseId(id);
		cou.setCourseName(rs.getString("course_name"));

		st = con.prepareStatement("DELETE FROM COURSE WHERE COURSE_ID = ?");
		st.setInt(1, id);

		int line = st.executeUpdate();

		if(line == 0){
			cou = null;
		}

		st.close();
		con.close();

		return cou;
	}

	//chap21問題12で追加
	public Course selectById(int id) throws Exception{
		Connection con = getConnection();
		Course cou = new Course();
		PreparedStatement st = con.prepareStatement(
				"SELECT * FROM COURSE WHERE COURSE_ID = ?");
		st.setInt(1, id);
		ResultSet rs = st.executeQuery();
		rs.next();
		cou.setCourseId(id);
		cou.setCourseName(rs.getString("course_name"));

		st.close();
		con.close();

		return cou;
	}

	//chap21問題12で追加
	public int update(Course cou) throws Exception{
		Connection con = getConnection();

		PreparedStatement st = con.prepareStatement(
				"UPDATE COURSE SET COURSE_NAME = ? WHERE COURSE_ID = ?");
		st.setString(1, cou.getCourseName());
		st.setInt(2, cou.getCourseId());
		int line = st.executeUpdate();

		st.close();
		con.close();

		return line;
	}
}
