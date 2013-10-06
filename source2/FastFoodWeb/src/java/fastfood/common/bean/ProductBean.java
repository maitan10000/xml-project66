/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fastfood.common.bean;

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

    public ProductBean(int ID, String Name, int Price, String Image,
            String Description, int CateID, int BuyCount, Date CreateDate,
            Date LastUpdate, boolean IsActive) {
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

    /**
     * @return the ID
     */
    public int getID() {
        return ID;
    }

    /**
     * @param ID the ID to set
     */
    public void setID(int ID) {
        this.ID = ID;
    }

    /**
     * @return the Name
     */
    public String getName() {
        return Name;
    }

    /**
     * @param Name the Name to set
     */
    public void setName(String Name) {
        this.Name = Name;
    }

    /**
     * @return the Price
     */
    public int getPrice() {
        return Price;
    }

    /**
     * @param Price the Price to set
     */
    public void setPrice(int Price) {
        this.Price = Price;
    }

    /**
     * @return the Image
     */
    public String getImage() {
        return Image;
    }

    /**
     * @param Image the Image to set
     */
    public void setImage(String Image) {
        this.Image = Image;
    }

    /**
     * @return the Description
     */
    public String getDescription() {
        return Description;
    }

    /**
     * @param Description the Description to set
     */
    public void setDescription(String Description) {
        this.Description = Description;
    }

    /**
     * @return the CateID
     */
    public int getCateID() {
        return CateID;
    }

    /**
     * @param CateID the CateID to set
     */
    public void setCateID(int CateID) {
        this.CateID = CateID;
    }

    /**
     * @return the BuyCount
     */
    public int getBuyCount() {
        return BuyCount;
    }

    /**
     * @param BuyCount the BuyCount to set
     */
    public void setBuyCount(int BuyCount) {
        this.BuyCount = BuyCount;
    }

    /**
     * @return the CreateDate
     */
    public Date getCreateDate() {
        return CreateDate;
    }

    /**
     * @param CreateDate the CreateDate to set
     */
    public void setCreateDate(Date CreateDate) {
        this.CreateDate = CreateDate;
    }

    /**
     * @return the LastUpdate
     */
    public Date getLastUpdate() {
        return LastUpdate;
    }

    /**
     * @param LastUpdate the LastUpdate to set
     */
    public void setLastUpdate(Date LastUpdate) {
        this.LastUpdate = LastUpdate;
    }

    /**
     * @return the IsActive
     */
    public boolean isIsActive() {
        return IsActive;
    }

    /**
     * @param IsActive the IsActive to set
     */
    public void setIsActive(boolean IsActive) {
        this.IsActive = IsActive;
    }
}
