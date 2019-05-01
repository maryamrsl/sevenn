package seven;

import java.sql.*;
import java.util.ArrayList;

public class StudentDAO {
    private Connection connection;
    private PreparedStatement preparedStatement;

    public StudentDAO() {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "mary", "myjava123");
        } catch (Exception ms) {
            System.out.println("could not connect to db" + ms.getMessage());
        }
    }

    public void insert(Student st) {
        try {
            preparedStatement = connection.prepareStatement("insert into student(id,name) values(?,?)");
            preparedStatement.setLong(1, st.getId());
            preparedStatement.setString(2, st.getName());
            preparedStatement.executeUpdate();
        } catch (Exception ms) {
            System.out.println("khata dar insert student: " + ms.getMessage());
        }
    }

    public Student getStudentById(long xid) {
        try {
            preparedStatement = connection.prepareStatement("select * from student where id=?");
            preparedStatement.setLong(1, xid);
            ResultSet rs = preparedStatement.executeQuery();
            Student st = new Student();
            st.setId(rs.getLong("id"));
            st.setName(rs.getString("name"));
            return st;

        } catch (Exception ms) {
            System.out.println("khata dar getStudentById Student" + ms.getMessage());
            return null;
        }

    }

    public void updatestudent(Student st){
        try {

            preparedStatement = connection.prepareStatement("update student set name=? where id=?");
            preparedStatement.setString(1, st.getName());
            preparedStatement.setLong(2, st.getId());
            preparedStatement.executeUpdate();
        }catch (Exception em){
            System.out.println("khata dar update student "+em.getMessage());
        }
    }
    public void delet(Student st){
        try {
            preparedStatement=connection.prepareStatement("delete student where name=?");
            preparedStatement.setString(1,st.getName());
            preparedStatement.executeUpdate();
        }catch (Exception em){
            System.out.println("khata dar delet "+em.getMessage());
        }
    }
    public ArrayList<Student> getallstudent() throws Exception{

            preparedStatement=connection.prepareStatement("select * from student");
           ResultSet rs= preparedStatement.executeQuery();
           ArrayList<Student> list=new ArrayList<>();
           while (rs.next()) {
               Student student = new Student();
               student.setName(rs.getString("name"));
               student.setId(rs.getLong("id"));
               list.add(student);
           }
           for (Student holo:list){
               System.out.println(holo.getName());
               System.out.println(holo.getId());
           }
           return list;


    }
}