
package quanlydiemhocsinh.DAO;

import java.sql.SQLException;
import java.util.List;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import quanlydiemhocsinh.Database.DBHelper;
import java.sql.ResultSet;
import java.util.ArrayList;
import quanlydiemhocsinh.Model.HocSinh;

public class HocSinhDAO {

    DBHelper db = new DBHelper();

    public List<HocSinh> getHocSinhs() {
        List<HocSinh> hocSinhs = new ArrayList<HocSinh>();
        try {
            Statement statement = db.getConnection().createStatement();
            ResultSet rs = statement.executeQuery("getHocSinh");
            while (rs.next()) {
                HocSinh hocSinh = new HocSinh(rs.getInt("id"), rs.getString("hoten"), rs.getString("ngaysinh"),
                        rs.getString("diachi"), rs.getString("sodienthoai"), rs.getString("lop"));
                hocSinhs.add(hocSinh);
            }
        } catch (SQLException ex) {
            Logger.getLogger(HocSinhDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return hocSinhs;

    }

    public boolean addHocSinh(String hoten, String ngaysinh, String diachi, String sodienthoai, String lop) {
        boolean rs = false;
        try {
            Statement statement = db.getConnection().createStatement();
            String query = String.format("addHocSinh '%s','%s','%s','%s','%s'", hoten, ngaysinh, diachi, sodienthoai,
                    lop);
            rs = statement.execute(query);
        } catch (SQLException ex) {
            Logger.getLogger(HocSinhDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }

    public boolean updateHocSinh(int id, String hoten, String ngaysinh, String diachi, String sodienthoai, String lop) {
        boolean rs = false;
        try {
            Statement statement = db.getConnection().createStatement();
            String query = String.format("updateHocSinh %s, N'%s',N'%s',N'%s',N'%s',N'%s'",id, hoten, ngaysinh, diachi, sodienthoai,
                    lop);
            rs = statement.execute(query);
        } catch (SQLException ex) {
            Logger.getLogger(HocSinhDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }
    public boolean deleteHocSinh(int id){
        boolean rs = false;
        try {
            Statement statement = db.getConnection().createStatement();
            String query = String.format("deleteHocSinh %s",id);
            rs = statement.execute(query);
        } catch (SQLException ex) {
            Logger.getLogger(HocSinhDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }
}
