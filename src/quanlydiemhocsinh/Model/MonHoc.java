/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quanlydiemhocsinh.Model;

/**
 *
 * @author TonDZ
 */
public class MonHoc {
    private int id;
    private String tenmonhoc;
    private int sotc;

    public MonHoc(int id, String tenmonhoc, int sotc) {
        this.id = id;
        this.tenmonhoc = tenmonhoc;
        this.sotc = sotc;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTenmonhoc() {
        return tenmonhoc;
    }

    public void setTenmonhoc(String tenmonhoc) {
        this.tenmonhoc = tenmonhoc;
    }

    public int getSotc() {
        return sotc;
    }

    public void setSotc(int sotc) {
        this.sotc = sotc;
    }
    
}
