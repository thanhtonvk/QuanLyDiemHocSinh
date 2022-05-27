package quanlydiemhocsinh.DAO;

import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import quanlydiemhocsinh.Database.DBHelper;
import quanlydiemhocsinh.Model.MonHoc;

public class MonHocDAO {
    DBHelper db;
    Statement statement;

    public MonHocDAO() {
        db = new DBHelper();
        try {
            statement = db.getConnection().createStatement();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

    public List<MonHoc> getMonHocs() {
        List<MonHoc> monHocs = new ArrayList<>();

        ResultSet rs;
        try {
            rs = statement.executeQuery("getMonHoc");
            while (rs.next()) {
                MonHoc monHoc = new MonHoc(rs.getInt("id"), rs.getString("tenmonhoc"), rs.getInt("sotc"));
                monHocs.add(monHoc);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
       
        return monHocs;
    }

    public boolean addMonHoc(String tenmonhoc, int sotc) {
        boolean rs = false;
        try {
            String query = String.format("addMonHoc N'%s', %s", tenmonhoc, sotc);
            rs = statement.execute(query);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return rs;
    }
    public boolean updateMonHoc(int id, String tenmonhoc,int sotc){
        boolean rs = false;
        try {
            String query = String.format("updateMonHoc %s, N'%s', %s",id, tenmonhoc, sotc);
            rs = statement.execute(query);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return rs;
    }
    public boolean deleteMonHoc(int id){
        boolean rs = false;
        try{
            String query = String.format("deleteMonHoc %s",id);
            rs = statement.execute(query);
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }

}
