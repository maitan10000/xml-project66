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
@XmlType(name = "OrderDetailView", propOrder = {
    "ProductName",
    "Price",
    "Quantity",
    "Total"
})
public class OrderDetailView {

    @XmlElement(required = true)
    protected String ProductName;
    @XmlElement(required = true)
    protected int Price;
    @XmlElement(required = true)
    protected int Quantity;
    @XmlElement(required = true)
    protected int Total;

    public OrderDetailView() {
    }

    public OrderDetailView(String ProductName, int Price, int Quantity, int Total) {
        this.ProductName = ProductName;
        this.Price = Price;
        this.Quantity = Quantity;
        this.Total = Total;
    }

    public int getPrice() {
        return Price;
    }

    public void setPrice(int Price) {
        this.Price = Price;
    }

    public String getProductName() {
        return ProductName;
    }

    public void setProductName(String ProductName) {
        this.ProductName = ProductName;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int Quantity) {
        this.Quantity = Quantity;
    }

    public int getTotal() {
        return Total;
    }

    public void setTotal(int Total) {
        this.Total = Total;
    }
}
