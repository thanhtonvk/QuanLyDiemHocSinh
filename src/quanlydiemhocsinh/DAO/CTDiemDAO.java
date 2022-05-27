package quanlydiemhocsinh.DAO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import quanlydiemhocsinh.Database.DBHelper;
import quanlydiemhocsinh.Model.CTDiem;
import java.sql.ResultSet;

public class CTDiemDAO {
    DBHelper dbHelper;
    Statement statement;

    public CTDiemDAO() {
        dbHelper = new DBHelper();
        try {
            statement = dbHelper.getConnection().createStatement();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public List<CTDiem> getDSDiem(int idDiem) {
        List<CTDiem> diemList = new ArrayList<CTDiem>();

        ResultSet rs;
        try {
            rs = statement.executeQuery("getCTDiem "+idDiem);
            while (rs.next()) {
                CTDiem diem = new CTDiem(rs.getInt("id"), rs.getInt("iddiem"), rs.getInt("idmonhoc"),
                        rs.getString("tenmonhoc"), rs.getInt("sotc"), rs.getFloat("diem"));
                diemList.add(diem);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
      

        return diemList;
    }
    public boolean addCTDiem(int iddiem, int idmonhoc, float diem){
        boolean result = false;
        try{
            String query = String.format("addCTDiem %s,%s,%s",iddiem,idmonhoc,diem);
            result = statement.execute(query);
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
    public boolean removeCTDiem(int id){
        boolean result = false;
        try{
            String query = String.format("deleteCTDiem %s",id);
            result = statement.execute(query);
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
    public boolean updateCTDiem(int id, int iddiem, int idmonhoc, float diem){
        boolean result = false;
        try{
            String query = String.format("updateCTDiem %s,%s,%s,%s",id,iddiem,idmonhoc,diem);
            result = statement.execute(query);
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
}