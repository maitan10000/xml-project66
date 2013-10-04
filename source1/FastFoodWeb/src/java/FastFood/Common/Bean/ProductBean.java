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
public class ProductBean {

    private int ID;
    private String Name;
    private int Price;
    private String Image;
    private String Description;
    private int CateID;
    private int BuyCount;
    private Date CreateDate;
    private Date LastUpdate;
    private boolean IsActive;


    public ProductBean() {
    }

    public ProductBean(int ID, String Name, int Price, String Image, String Description, int CateID, int BuyCount, Date CreateDate, Date LastUpdate, boolean IsActive) {
        this.ID = ID;
        this.Name = Name;
        this.Price = Price;
        this.Image = Image;
        this.Description = Description;
        this.CateID = CateID;
        this.BuyCount = BuyCount;
        this.CreateDate = CreateDate;
        this.LastUpdate = LastUpdate;
        this.IsActive = IsActive;
    }

    public int getBuyCount() {
        return BuyCount;
    }

    public void setBuyCount(int BuyCount) {
        this.BuyCount = BuyCount;
    }

    public int getCateID() {
        return CateID;
    }

    public void setCateID(int CateID) {
        this.CateID = CateID;
    }

    public Date getCreateDate() {
        return CreateDate;
    }

    public void setCreateDate(Date CreateDate) {
        this.CreateDate = CreateDate;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String Image) {
        this.Image = Image;
    }

    public boolean isIsActive() {
        return IsActive;
    }

    public void setIsActive(boolean IsActive) {
        this.IsActive = IsActive;
    }

    public Date getLastUpdate() {
        return LastUpdate;
    }

    public void setLastUpdate(Date LastUpdate) {
        this.LastUpdate = LastUpdate;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public int getPrice() {
        return Price;
    }

    public void setPrice(int Price) {
        this.Price = Price;
    }

}
