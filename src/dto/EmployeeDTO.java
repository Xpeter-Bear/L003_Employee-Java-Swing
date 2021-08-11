/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import java.util.Date;

/**
 *
 * @author Modern 15
 */
public class EmployeeDTO {

    String EmpID;
    String FullName;
    String Phone;
    String Email;
    String Address;
    Date DateOfBirth;
    boolean IsDelete = false;

    public EmployeeDTO(String EmpID, String FullName, String Phone, String Email, String Address, Date DateOfBirth ,boolean IsDelete) {
        this.EmpID = EmpID;
        this.FullName = FullName;
        this.Phone = Phone;
        this.Email = Email;
        this.Address = Address;
        this.DateOfBirth = DateOfBirth;
        this.IsDelete = IsDelete;
    }

    public EmployeeDTO() {
    }

    public String getEmpID() {
        return EmpID;
    }

    public void setEmpID(String EmpID) {
        this.EmpID = EmpID;
    }

    public String getFullName() {
        return FullName;
    }

    public void setFullName(String FullName) {
        this.FullName = FullName;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String Phone) {
        this.Phone = Phone;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public Date getDateOfBirth() {
        return DateOfBirth;
    }

    public void setDateOfBirth(Date DateOfBirth) {
        this.DateOfBirth = DateOfBirth;
    }

    public boolean isIsDelete() {
        return IsDelete;
    }

    public void setIsDelete(boolean IsDelete) {
        this.IsDelete = IsDelete;
    }

}
