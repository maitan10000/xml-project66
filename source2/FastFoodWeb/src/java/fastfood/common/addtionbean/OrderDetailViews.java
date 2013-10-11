/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fastfood.common.addtionbean;

import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author Everything
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "OrderDetailViews", propOrder = {
    "ListOrderDetail"})
public class OrderDetailViews {

    @XmlElement(required = true)
    protected List<OrderDetailView> ListOrderDetail;

    public OrderDetailViews() {
    }

    public OrderDetailViews(List<OrderDetailView> ListOrderDetail) {
        this.ListOrderDetail = ListOrderDetail;
    }

    /**
     * @return the ListOrderDetail
     */
    public List<OrderDetailView> getListOrderDetail() {
        return ListOrderDetail;
    }

    /**
     * @param ListOrderDetail the ListOrderDetail to set
     */
    public void setListOrderDetail(List<OrderDetailView> ListOrderDetail) {
        this.ListOrderDetail = ListOrderDetail;
    }
}
