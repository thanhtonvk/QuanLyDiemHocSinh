/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quanlydiemhocsinh.Model;

/**
 *
 * @author TonDZ
 */
public class CTDiem {
    private int id,iddiem,idmonhoc;
    private String tenmonhoc;
    private int sotc;
    private float diem;

    public CTDiem(int id, int iddiem, int idmonhoc, String tenmonhoc, int sotc, float diem) {
        this.id = id;
        this.iddiem = iddiem;
        this.idmonhoc = idmonhoc;
        this.tenmonhoc = tenmonhoc;
        this.sotc = sotc;
        this.diem = diem;
    }

    public CTDiem() {
      
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIddiem() {
        return iddiem;
    }

    public void setIddiem(int iddiem) {
        this.iddiem = iddiem;
    }

    public int getIdmonhoc() {
        return idmonhoc;
    }

    public void setIdmonhoc(int idmonhoc) {
        this.idmonhoc = idmonhoc;
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

    public float getDiem() {
        return diem;
    }

    public void setDiem(float diem) {
        this.diem = diem;
    }
    
}
