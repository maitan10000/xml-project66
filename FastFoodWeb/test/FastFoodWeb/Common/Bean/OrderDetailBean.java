/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package FastFoodWeb.Common.Bean;

/**
 *
 * @author bao
 */
public class OrderDetailBean {
    private int OrderID;
    private int ProductID;
    private int Price;
    private int Quantity;
    private boolean IsActive;

    public OrderDetailBean(int OrderID, int ProductID, int Price, int Quantity) {
        this.OrderID = OrderID;
        this.ProductID = ProductID;
        this.Price = Price;
        this.Quantity = Quantity;
    }
    public OrderDetailBean(int OrderID, int ProductID)
    {
        this.OrderID = OrderID;
        this.ProductID = ProductID;
    }

    public boolean isIsActive() {
        return IsActive;
    }

    public void setIsActive(boolean IsActive) {
        this.IsActive = IsActive;
    }

    public int getOrderID() {
        return OrderID;
    }

    public void setOrderID(int OrderID) {
        this.OrderID = OrderID;
    }

    public int getPrice() {
        return Price;
    }

    public void setPrice(int Price) {
        this.Price = Price;
    }

    public int getProductID() {
        return ProductID;
    }

    public void setProductID(int ProductID) {
        this.ProductID = ProductID;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int Quantity) {
        this.Quantity = Quantity;
    }
}
