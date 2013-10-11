/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fastfood.common.addtionbean;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author Everything
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ProductView", propOrder = {
    "ID",
    "Name",
    "Price",
    "Image",
    "CateID"
})
public class ProductView {

    @XmlElement(required = true)
    protected int ID;
    @XmlElement(required = true)
    protected String Name;
    @XmlElement(required = true)
    protected int Price;
    @XmlElement(required = true)
    protected String Image;
    @XmlElement(required = true)
    protected int CateID;

    public ProductView() {
    }

    public ProductView(int ID, String Name, int Price, String Image, int CateID) {
        this.ID = ID;
        this.Name = Name;
        this.Price = Price;
        this.Image = Image;
        this.CateID = CateID;
    }

    public int getCateID() {
        return CateID;
    }

    public void setCateID(int CateID) {
        this.CateID = CateID;
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
