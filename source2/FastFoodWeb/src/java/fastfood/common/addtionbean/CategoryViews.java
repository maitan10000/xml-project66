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
    "CategoryView"
})
@XmlRootElement(name = "CategoryViews")
public class CategoryViews {

    @XmlElement(required = true)
    protected List<CategoryView> CategoryView;

    public CategoryViews() {
    }

    public List<CategoryView> getCategoryView() {
        if (CategoryView == null) {
            CategoryView = new ArrayList<CategoryView>();
        }
        return this.CategoryView;
    }

    public void setCategoryView(List<CategoryView> CategoryView) {
        this.CategoryView = CategoryView;
    }
}
