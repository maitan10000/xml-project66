/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fastfood.common.business.admin;

import fastfood.common.bean.ProductBean;
import fastfood.common.dao.ProductDaoImp;
import fastfood.common.dao.ProductDaoInterface;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author bao
 */
public class ProductBUSImp implements ProductBUSInterface {

    private ProductDaoInterface proDao;

    public ProductBUSImp() {
        proDao = new ProductDaoImp();
    }

    @Override
    public boolean add(ProductBean product) {
        return proDao.Add(product);

    }

    @Override
    public boolean update(ProductBean product) {
        return proDao.Update(product);

    }

    @Override
    public boolean setActive(int productID, boolean active) {
        ProductBean product = proDao.ListByProductID(productID);
        product.setIsActive(active);
        return proDao.Update(product);
    }

    /**
     * List all user
     * @param showActiveOnly
     * @return list user
     */
    @Override
    public List<ProductBean> listAll(boolean showActiveOnly) {
        List<ProductBean> result = new ArrayList<ProductBean>();
        List<Integer> listProductID = proDao.ListAllProductID(showActiveOnly);
        for (int i = 0; i < listProductID.size(); i++) {
            result.add(proDao.ListByProductID(listProductID.get(i)));
        }
        return result;
    }

    @Override
    public ProductBean getProductByID(int ID) {
        return proDao.ListByProductID(ID);
    }
}
