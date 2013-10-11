/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fastfood.common.addtionbean;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author Everything
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "ProductView"
})
@XmlRootElement(name = "ProductViews")
public class ProductViews {

    @XmlElement(required = true)
    protected List<ProductView> ProductView;

    public ProductViews() {
    }

    public List<ProductView> getProductView() {
        if (ProductView == null) {
            ProductView = new ArrayList<ProductView>();
        }
        return this.ProductView;
    }

    public void setProductView(List<ProductView> ProductView) {
        this.ProductView = ProductView;
    }
}
