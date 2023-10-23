/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import java.time.LocalDateTime;

public class Log {
    private int id;
    private String nim;
    private LocalDateTime dateIn;
    private LocalDateTime dateOut;

    public Log() {
    }

    public Log(int id, String nim, LocalDateTime dateIn, LocalDateTime dateOut) {
        this.id = id;
        this.nim = nim;
        this.dateIn = dateIn;
        this.dateOut = dateOut;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNim() {
        return nim;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }

    public LocalDateTime getDateIn() {
        return dateIn;
    }

    public void setDateIn(LocalDateTime dateIn) {
        this.dateIn = dateIn;
    }

    public LocalDateTime getDateOut() {
        return dateOut;
    }

    public void setDateOut(LocalDateTime dateOut) {
        this.dateOut = dateOut;
    }

    @Override
    public String toString() {
        return "Log{" + "id=" + id + ", nim=" + nim + ", dateIn=" + dateIn + ", dateOut=" + dateOut + '}';
    }
    
    
}
