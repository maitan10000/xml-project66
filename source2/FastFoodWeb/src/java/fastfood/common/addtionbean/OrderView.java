/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fastfood.common.addtionbean;

import fastfood.common.utility.SqlDateAdapter;
import java.sql.Date;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 *
 * @author Everything
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "UserName",
    "FirstName",
    "LastName",
    "Email",
    "ReceiveAddress",
    "Phone",
    "CreateDate",
    "OrderDetailViews",
    "TotalAll"
})
@XmlRootElement(name = "OrderView")
public class OrderView {

    @XmlElement(required = true)
    protected String UserName;
    @XmlElement(required = true)
    protected String FirstName;
    @XmlElement(required = true)
    protected String LastName;
    @XmlElement(required = true)
    protected String Email;
    @XmlElement(required = true)
    protected String ReceiveAddress;
    @XmlElement(required = true)
    protected String Phone;
    @XmlElement(required = true)
    @XmlJavaTypeAdapter(SqlDateAdapter.class)
    protected Date CreateDate;
    @XmlElement(required = true)
    protected OrderDetailViews OrderDetailViews;
    @XmlElement(required = true)
    protected int TotalAll;

    /**
     * @return the UserName
     */
    public String getUserName() {
        return UserName;
    }

    /**
     * @param UserName the UserName to set
     */
    public void setUserName(String UserName) {
        this.UserName = UserName;
    }

    /**
     * @return the FirstName
     */
    public String getFirstName() {
        return FirstName;
    }

    /**
     * @param FirstName the FirstName to set
     */
    public void setFirstName(String FirstName) {
        this.FirstName = FirstName;
    }

    /**
     * @return the LastName
     */
    public String getLastName() {
        return LastName;
    }

    /**
     * @param LastName the LastName to set
     */
    public void setLastName(String LastName) {
        this.LastName = LastName;
    }

    /**
     * @return the Email
     */
    public String getEmail() {
        return Email;
    }

    /**
     * @param Email the Email to set
     */
    public void setEmail(String Email) {
        this.Email = Email;
    }

    /**
     * @return the ReceiveAddress
     */
    public String getReceiveAddress() {
        return ReceiveAddress;
    }

    /**
     * @param ReceiveAddress the ReceiveAddress to set
     */
    public void setReceiveAddress(String ReceiveAddress) {
        this.ReceiveAddress = ReceiveAddress;
    }

    /**
     * @return the Phone
     */
    public String getPhone() {
        return Phone;
    }

    /**
     * @param Phone the Phone to set
     */
    public void setPhone(String Phone) {
        this.Phone = Phone;
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
     * @return the Total
     */
    public int getTotalAll() {
        return TotalAll;
    }

    /**
     * @param Total the Total to set
     */
    public void setTotalAll(int TotalAll) {
        this.TotalAll = TotalAll;
    }

    /**
     * @return the OrderDetailViews
     */
    public OrderDetailViews getOrderDetailViews() {
        return OrderDetailViews;
    }

    /**
     * @param OrderDetailViews the OrderDetailViews to set
     */
    public void setOrderDetailViews(OrderDetailViews OrderDetailViews) {
        this.OrderDetailViews = OrderDetailViews;
    }
}
