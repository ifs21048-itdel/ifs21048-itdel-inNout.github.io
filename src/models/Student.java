package models;

public class Student {
    private String nim;
    private String nama;
    private String gender;
    private String angkatan;
    
    public Student (String nim, String nama, String gender, String angkatan){
        this.nim = nim;
        this.nama = nama;
        this.gender = gender;
        this.angkatan = angkatan;
    }
    
    public String getNim(){
        return nim;
    }
    public void setNim(String id){
        this.nim = id;
    }
    public String getNama(){
        return nama;
    }
    public void setNama(String nama){
        this.nama = nama;
    }
    public String getGender(){
        return gender;
    }
    public void setGender(String gender){
        this.gender = gender;
    }
    public String getAngkatan(){
        return angkatan;
    }
    public void setAngkatan(String angkatan){
        this.angkatan = angkatan;
    }
    
    @Override 
    public String toString(){
        return String.format("NIM: %s, Nama : %s, Jenis Kelamin: %s, Angkatan: %s",
                getNim(),
                getNama(),
                getGender(),
                getAngkatan()
        );
    }
}
