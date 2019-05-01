package seven;

import java.util.ArrayList;

public class StudentBL {
    private StudentDAO stDAO;
    public StudentBL() {
        stDAO=new StudentDAO();
    }
    public void register(Student st){
        stDAO.insert(st);

    }
    public void delete(Student st){
        stDAO.delet(st);
    }
    public void editstudent(long id){
        Student st=stDAO.getStudentById(id);
        stDAO.updatestudent(st);
    }
    public ArrayList<Student> showallstudent() throws Exception{
        return stDAO.getallstudent();
    }
}
