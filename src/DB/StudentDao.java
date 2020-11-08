package DB;
import java.sql.Connection;
import DAL.Student;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDao {
	public static Connection getConnection() {
		Connection conn = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/studentDB",
					userName = "ibrahim", password = "ib123";
			conn = DriverManager.getConnection(url, userName, password);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
	
	public static int save(Student s) {
		int status = 0;
		try {
			Connection conn = getConnection();
			PreparedStatement ps = 
					conn.prepareStatement("insert into studenttable(fname, lname, password) values(?,?,?)");
			ps.setString(1, s.getFirstName());
			ps.setString(2, s.getLastName());
			ps.setString(3, s.getPassword());
			status = ps.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return status;
	}
	
	public static int delete(Student s) {
		int status = 0;
		
		try {
			Connection conn = getConnection();
			PreparedStatement ps = 
					conn.prepareStatement("delete from studenttable where id = ?");
			
			status = ps.executeUpdate();
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		return status;
	}
	
	public static List<Student> getAllRecords(){
		List<Student> students = new ArrayList<Student>();
		Connection conn = getConnection();
		try {
			PreparedStatement ps = 
					conn.prepareStatement("select * from studenttable");
			ResultSet resultset = ps.executeQuery();
			Student s = null;
			while(resultset.next()) {
				s = new Student();
				s.setId(resultset.getInt("id"));
				s.setFirstName(resultset.getString("fname"));
				s.setLastName(resultset.getString("lname"));
				s.setPassword(resultset.getString("password"));
				students.add(s);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return students;
	}
}
















