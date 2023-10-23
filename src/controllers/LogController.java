  /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import com.mysql.jdbc.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import models.Log;
import models.Student;
import utils.DatabaseUtil;

public class LogController {
    
    private DatabaseUtil koneksi;
    private ResultSet rs;
    private PreparedStatement pre;

    public LogController() {
        koneksi = new DatabaseUtil();
    }
public ArrayList<Log> getAll(){
        ArrayList<Log> result = new ArrayList<Log>();
        rs = koneksi.executeSelect("SELECT * FROM logs WHERE ");
        if(rs != null){
            try{
                while(rs.next()){
                    Log logs = new Log(
                    rs.getInt(1),
                    rs.getString(2),
                    rs.getTimestamp(3).toLocalDateTime(),
                    rs.getTimestamp(4).toLocalDateTime());
                result.add(logs); 
                }
            }catch(Exception e){
                
            }
        }return result;
}
    public Log getLatestByNim(String nim){
        ArrayList<String> data = new ArrayList<String>();
        data.add(nim);
        Log l = null;
        
        rs = koneksi.executeSelect("SELECT * FROM logs WHERE nim = ? ORDER BY id DESC", data);
        if(rs != null){
            try{
                while(rs.next()){
                    
                    LocalDateTime dateOut = null;
                    try{
                        dateOut = rs.getTimestamp(4).toLocalDateTime();
                    }catch(Exception ex){}
                    
                    l = new Log (
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getTimestamp(3).toLocalDateTime(),
                        dateOut
                    );

                    break;
                }
            }catch(Exception ex){
                
            }
        }
        return l;
    }
    
//    public Boolean insert(String nim) {
//        ArrayList<String> data = new ArrayList<String>();
//        data.add(nim);
//
//        if (koneksi.execute("INSERT into logs (nim, date_in) VALUES (?, now())", data)) {
//            return true;
//        } else {
//            return false;
//        }
//    }
    public Boolean insert(String nim){
        ArrayList<String> data = new ArrayList<String>();
        data.add(nim);
        
        try {
            if(rs.next()){
                JOptionPane.showMessageDialog(null,"Maaf, data tersebut telah tersedia");
                return false;
            }else {
                koneksi.execute("INSERT into logs (nim, date_in) VALUES (?, now())", data);
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(LogController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public Boolean delete(String nim, String nama, String gender, String angkatan){
        ArrayList<String> data = new ArrayList<String>();
        data.add(nim);
        
        if(koneksi.execute("DELETE FROM students WHERE nim = ?", data)){
            return true;
        }
        else {
            return false;
        }
        
    }
    
    public Boolean update(String nim) {
        ArrayList<String> data = new ArrayList<String>();
        data.add(nim);

        if (koneksi.execute("UPDATE logs SET date_out = now() WHERE nim = ?", data)) {
          
            return true;
        } else {
            return false;
        }
    }
    
    public Boolean checkNim(String nim) {
        ArrayList<String> data = new ArrayList<String>();
        data.add(nim);
        
        Log l = null;
        rs = koneksi.executeSelect("SELECT * FROM logs WHERE nim = ? AND date_out IS NULL", data);
        if(rs != null){
            try{
                while(rs.next()){
                    
                    LocalDateTime dateOut = null;
                    try{
                        dateOut = rs.getTimestamp(4).toLocalDateTime();
                    }catch(Exception ex){
                        
                    }
                    
                    l = new Log (
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getTimestamp(3).toLocalDateTime(),
                        dateOut
                    );

                    break;
                }
            }catch(Exception ex){
                
            }
        }
        
        if(l == null) return false;
        return true;
    }
    
}
