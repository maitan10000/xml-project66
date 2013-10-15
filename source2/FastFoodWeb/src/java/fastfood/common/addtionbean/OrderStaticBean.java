/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fastfood.common.addtionbean;

import java.sql.Date;

/**
 *
 * @author Everything
 */
public class OrderStaticBean {

    private Date Date;
    private int Total;

    public OrderStaticBean() {
    }

    public OrderStaticBean(Date Date, int Total) {
        this.Date = Date;
        this.Total = Total;
    }

    /**
     * @return the Date
     */
    public Date getDate() {
        return Date;
    }

    /**
     * @param Date the Date to set
     */
    public void setDate(Date Date) {
        this.Date = Date;
    }

    /**
     * @return the Total
     */
    public int getTotal() {
        return Total;
    }

    /**
     * @param Total the Total to set
     */
    public void setTotal(int Total) {
        this.Total = Total;
    }
}
