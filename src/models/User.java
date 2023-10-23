package models;
import java.time.LocalDateTime;
public class User {
    private String id;
    private String name;
    private String username;
    private String password;
    private String status;
    private LocalDateTime createdAt;
    
    public User(String id, String name, String username, String password, LocalDateTime createdAt){
        this.id = id;
        this.name = name;
        this.username = username;
        this.password = password;
        this.createdAt = createdAt;
    }
    
    public String getId() {
        return id;
    }
    public void setId(String id){
        this.id = id;
    }
    public String getName(){
        return name;
    }
    public void setName (String name){
        this.name = name;
    }
    public String getUsername(){
        return username;
    }
    public void setUsername (String username){
        this.username = username;
    }
    public String getPassword(){
        return password;
    }
    public void setPassword (String password){
        this.password = password;
    }
    public String getStatus(){
        return status;
    }
    public void setStatus(String status){
        this.status = status;
    }
    public LocalDateTime getCreatedAt(){
        return createdAt;
    }
    public void setCreatedAt (LocalDateTime createdAt){
        this.createdAt = createdAt;
    }
    
    @Override 
    public String toString(){
        return String.format("ID: %s, Name : %s, Username: %s, Created At: %s",
                getId(),
                getName(),
                getUsername(),
                getCreatedAt()
        );
    }
}
