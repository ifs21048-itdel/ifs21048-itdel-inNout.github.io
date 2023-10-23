package controllers;

import com.mysql.jdbc.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import models.Student;
import models.User;
import utils.ConstUtil;
import utils.DatabaseUtil;

public class StudentController {

    private DatabaseUtil koneksi;
    private ResultSet rs;
    private PreparedStatement pre;

    public StudentController() {
        koneksi = new DatabaseUtil();
    }
    
    public Student getByNim(String nim){
        ArrayList<String> data = new ArrayList<String>();
        data.add(nim);
        Student s = null;
        
        rs = koneksi.executeSelect("SELECT * FROM students WHERE nim = ?", data);
        if(rs != null){
            try{
                while(rs.next()){
                    s = new Student (
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4)
                    );
                break;
                }
            }catch(Exception ex){
            
            }
        }
        return s;
    }
    
    public ArrayList<Student> getAll() {
        ArrayList<Student> result = new ArrayList<Student>();
        rs = koneksi.executeSelect("SELECT * FROM students");
        if (rs != null) {
            try {
                while (rs.next()) {
                    Student students = new Student(
                            rs.getString(1),
                            rs.getString(2),
                            rs.getString(3),
                            rs.getString(4));
                    result.add(students);
                }

            } catch (Exception e) {

            }
        }
        return result;
    }

    public Boolean insert(Student students) {
        ArrayList<String> data = new ArrayList<String>();
        data.add(students.getNim());
        data.add(students.getNama());
        data.add(students.getGender());
        data.add(students.getAngkatan());

        if (koneksi.execute("INSERT into students (nim, nama, gender, angkatan) VALUES (?, ?, ?, ?)", data)) {
            return true;
        } else {
            return false;
        }
    }
    
    public Boolean delete(String nim) {
        ArrayList<String> data = new ArrayList<String>();
        data.add(nim);
        if (koneksi.execute("Delete from students WHERE nim = ?", data)) {
            return true;
        } else {
            return false;
        }
    }

    public Boolean update(Student s) {
        ArrayList<String> data = new ArrayList<String>();
        data.add(s.getNim());
        data.add(s.getNama());
        data.add(s.getGender());
        data.add(s.getAngkatan());
        data.add(ConstUtil.targetStudent);
        if (koneksi.execute("UPDATE students Set nim = ?, nama = ?, gender = ?, angkatan = ?  WHERE nim = ?", data)) {
            return true;
        } else {
            return false;
        }
    }
}
