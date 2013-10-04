/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package FastFood.Common.Business.Admin;

import FastFood.Common.Bean.ProductBean;
import FastFood.Common.Dao.ProductDaoImp;

/**
 *
 * @author bao
 */
public class ProductBUSImp implements ProductBUSInterface {
    private ProductDaoImp ProDao;
    public ProductBUSImp(){
    ProDao = new ProductDaoImp();
    }

    @Override
    public boolean add(ProductBean product) {
       return ProDao.Add(product);

    }

    @Override
    public boolean update(ProductBean product) {
        return ProDao.Update(product);

    }

    @Override
    public boolean setActive(int productID, boolean active) {
        ProductBean product = ProDao.ListByProductID(productID);
        product.setIsActive(active);
        return ProDao.Update(product);
    }


}
