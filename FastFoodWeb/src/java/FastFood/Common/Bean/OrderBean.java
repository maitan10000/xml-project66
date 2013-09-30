/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package FastFood.Common.Bean;

import java.sql.Date;

/**
 *
 * @author bao
 */
public class OrderBean {

    private int ID;
    private String BuyerName;
    private String Creator;
    private String Status;
    private String Notes;
    private String ReceiveAddress;
    private Date CreateDate;
    private boolean IsActive;

    public OrderBean() {
    }

    public OrderBean(int ID, String BuyerName, String Creator, String Status, String Notes, String ReceiveAddress, Date CreateDate, boolean IsActive) {
        this.ID = ID;
        this.BuyerName = BuyerName;
        this.Creator = Creator;
        this.Status = Status;
        this.Notes = Notes;
        this.ReceiveAddress = ReceiveAddress;
        this.CreateDate = CreateDate;
        this.IsActive = IsActive;
    }

    public String getBuyerName() {
        return BuyerName;
    }

    public void setBuyerName(String BuyerName) {
        this.BuyerName = BuyerName;
    }

    public Date getCreateDate() {
        return CreateDate;
    }

    public void setCreateDate(Date CreateDate) {
        this.CreateDate = CreateDate;
    }

    public String getCreator() {
        return Creator;
    }

    public void setCreator(String Creator) {
        this.Creator = Creator;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public boolean isIsActive() {
        return IsActive;
    }

    public void setIsActive(boolean IsActive) {
        this.IsActive = IsActive;
    }

    public String getNotes() {
        return Notes;
    }

    public void setNotes(String Notes) {
        this.Notes = Notes;
    }

    public String getReceiveAddress() {
        return ReceiveAddress;
    }

    public void setReceiveAddress(String ReceiveAddress) {
        this.ReceiveAddress = ReceiveAddress;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }
}
