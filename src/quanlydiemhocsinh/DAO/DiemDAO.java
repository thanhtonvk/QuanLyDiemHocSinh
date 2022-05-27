package quanlydiemhocsinh.DAO;

import java.sql.SQLException;
import java.util.List;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import quanlydiemhocsinh.Database.DBHelper;
import quanlydiemhocsinh.Model.Diem;

import java.sql.ResultSet;
import java.util.ArrayList;

public class DiemDAO {
    DBHelper dbHelper;
    Statement statement;

    public DiemDAO() {
        dbHelper = new DBHelper();
        try {
            statement = dbHelper.getConnection().createStatement();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public List<Diem> getDiemList(int idHocSinh) {
        List<Diem> list = new ArrayList<Diem>();
        String query = String.format("getDiem %s", idHocSinh);
        try {
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
                Diem diem = new Diem(rs.getInt("id"), rs.getInt("idhocsinh"), rs.getString("hoten"), rs.getInt("kyhoc"));
                list.add(diem);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return list;

    }

    public boolean addDiem(int idHocSinh, int kihoc) {
        boolean rs = false;
        String query  = String.format("addDiem %s,%s",idHocSinh,kihoc);
        try{
            rs= statement.execute(query);
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }
    public boolean updateDiem(int id,int idHocSinh,int kihoc){
        boolean rs = false;
        String query = String.format("updateDiem %s, %s, %s",id,idHocSinh,kihoc);
        try{
            rs = statement.execute(query);
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }
    public boolean deleteDiem(int id){
        boolean rs = false;
        String query = String.format("deleteDiem %s",id);
        try{
            rs = statement.execute(query);
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }
}
