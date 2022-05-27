/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quanlydiemhocsinh.Model;

/**
 *
 * @author TonDZ
 */
public class Diem {

    private int id;
    private int idHocSinh;
    private String hoten;
    private int kihoc;

    public Diem(int id, int idHocSinh, String hoten, int kihoc) {
        this.id = id;
        this.idHocSinh = idHocSinh;
        this.hoten = hoten;
        this.kihoc = kihoc;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdHocSinh() {
        return idHocSinh;
    }

    public void setIdHocSinh(int idHocSinh) {
        this.idHocSinh = idHocSinh;
    }

    public String getHoten() {
        return hoten;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    public int getKihoc() {
        return kihoc;
    }

    public void setKihoc(int kihoc) {
        this.kihoc = kihoc;
    }
    
}
