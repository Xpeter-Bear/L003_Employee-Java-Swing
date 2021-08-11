/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import dto.EmployeeDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Formatter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.DBUtils;

/**
 *
 * @author Modern 15
 */
public class EmployeeDAO {

    private Connection con = null;
    private Statement sm = null;
    private ResultSet rs = null;
    private PreparedStatement psm = null;
    SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");

    public List<EmployeeDTO> getAll() {
        List<EmployeeDTO> list = new ArrayList<>();
        try {
            con = DBUtils.getConnnection();
            sm = con.createStatement();
            rs = sm.executeQuery("Select * from Employeetbl");
            while (rs.next()) {
                String EmpID = rs.getString("EmpID").trim();
                String FullName = rs.getString("Fullname").trim();
                String Phone = rs.getString("Phone").trim();
                String Email = rs.getString("Email").trim();
                String Address = rs.getString("Address");
                Date DateOfBirth = formatter.parse(rs.getString("DateOfBirth").trim());
                boolean IsDelete = rs.getBoolean("IsDelete");
                EmployeeDTO dTO = new EmployeeDTO(EmpID, FullName, Phone, Email, Address, DateOfBirth, IsDelete);
                list.add(dTO);
            }
            rs.close();
            sm.close();
            con.close();
        } catch (Exception e) {
        }
        return list;
    }

    public void deleteAll() {
        try {
            con = DBUtils.getConnnection();
            sm = con.createStatement();
            rs = sm.executeQuery("Delete  from Employeetbl");
        } catch (SQLException ex) {
        }
    }

    public void insert(EmployeeDTO dTO) {
        try {
            String sql = "Insert Employeetbl Values(?, ?, ?, ?, ?, ?, ?)";
            con = DBUtils.getConnnection();
            psm = con.prepareStatement(sql);
            psm.setString(1, dTO.getEmpID());
            psm.setString(2, dTO.getFullName());
            psm.setString(3, dTO.getPhone());
            psm.setString(4, dTO.getEmail());
            psm.setString(5, dTO.getAddress());
            psm.setString(6, formatter.format(dTO.getDateOfBirth()));
            psm.setBoolean(7, dTO.isIsDelete());
            psm.executeUpdate();
        } catch (SQLException ex) {

        }

    }

}
