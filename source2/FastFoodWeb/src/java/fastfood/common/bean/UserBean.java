/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package fastfood.common.bean;

import java.sql.Date;

/**
 *
 * @author Everything
 */
public class UserBean {
    private String UserName;
    private String Password;
    private String FirstName;
    private String LastName;
    private String Email;
    private String Address;
    private String Phone;
    private String Role;
    private Date CreateDate;
    private boolean Active;

    public UserBean()
    {
    }

    public UserBean(String UserName, String Password, String FirstName, 
            String LastName, String Email, String Address, String Phone,
            String Role, Date CreateDate, boolean Active) {
        this.UserName = UserName;
        this.Password = Password;
        this.FirstName = FirstName;
        this.LastName = LastName;
        this.Email = Email;
        this.Address = Address;
        this.Phone = Phone;
        this.Role = Role;
        this.CreateDate = CreateDate;
        this.Active = Active;
    }

    public boolean isActive() {
        return Active;
    }

    public void setActive(boolean Active) {
        this.Active = Active;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public Date getCreateDate() {
        return CreateDate;
    }

    public void setCreateDate(Date CreateDate) {
        this.CreateDate = CreateDate;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String FirstName) {
        this.FirstName = FirstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String LastName) {
        this.LastName = LastName;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String Phone) {
        this.Phone = Phone;
    }

    public String getRole() {
        return Role;
    }

    public void setRole(String Role) {
        this.Role = Role;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String UserName) {
        this.UserName = UserName;
    }
}
