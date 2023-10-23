package controllers;

import com.mysql.jdbc.PreparedStatement;
import utils.DatabaseUtil;
import java.sql.Timestamp;
import java.sql.ResultSet;
import java.util.ArrayList;
import models.User;

public class UserController {
    private DatabaseUtil koneksi;
    private ResultSet rs;
    private PreparedStatement pre;
    
    public UserController(){
        koneksi = new DatabaseUtil();
    }
    
    public ArrayList<User> getAll(){
        ArrayList<User> result = new ArrayList<User>();
        rs = koneksi.executeSelect("SELECT * FROM members");
        if(rs != null){
            try{
                while(rs.next()){
                    Timestamp timestamp = rs.getTimestamp(5);
                    User pengguna = new User(
                            rs.getString(1),
                            rs.getString(2),
                            rs.getString(3),
                            rs.getString(4),
                            timestamp.toLocalDateTime());
                    result.add(pengguna);
                }
            }catch(Exception ex){
                
            }
        }return result;
    }
    
    public User getById(int user_id){
        ArrayList<String> data = new ArrayList<String>();
        data.add(String.valueOf(user_id));
        User pengguna = null;
        
        rs = koneksi.executeSelect("SELECT * FROM members WHERE id = ?", data);
        if(rs != null){
            try{
                while(rs.next()){
                    Timestamp timestamp = rs.getTimestamp(5);
                    pengguna = new User (
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        timestamp.toLocalDateTime());
                break;
                }
            }catch(Exception ex){
            
            }
        }return pengguna;
    }
    
    public Boolean delete(String user_id){
        ArrayList<String> data = new ArrayList<String>();
        data.add(user_id);
        if(koneksi.execute("Delete from members WHERE id = ?", data)){
            return true;
        }else{
            return false;
        }
    }
    
    public Boolean insert (User pengguna){
        ArrayList<String> data = new ArrayList<String>();
        if(pengguna.getId() != null){
            data.add(String.valueOf(pengguna.getId()));
        }
        data.add(pengguna.getName());
        data.add(pengguna.getUsername());
        data.add(pengguna.getPassword());
        
        if(pengguna.getId() != null){
            if(koneksi.execute("INSERT into pengguna(id, name, username, password)" + "VALUES (?, ?, ?, ?)", data)){
                return true;
            }else{
               return false; 
            }
        }
        else{
            if(koneksi.execute("INSERT INTO members (id, name, username, password)" + "VALUES (?, ?, ?, ?)", data)){
                return true;
            }else{
                return false;
            }
        }        
    }
    
    public User getLogin(String username, String password){
        ArrayList<String> data = new ArrayList<String>();
        data.add(username);
        data.add(password);
        User pengguna = null;
        
        rs = koneksi.executeSelect("SELECT * FROM members WHERE username = ? AND password = ?", data);
        if(rs != null){
            try{
                while(rs.next()){
                    Timestamp timestamp = rs.getTimestamp(5);
                    pengguna = new User (rs.getString(1),
                                        rs.getString(2),
                                        rs.getString(3),
                                        rs.getString(4),
                                        timestamp.toLocalDateTime());
                 break;               
                }
            }catch(Exception ex){
            
            }
        }
        return pengguna;
    }
    
    public void close(){
        koneksi.stop();
    }
}
