/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fastfood.common.constants;

/**
 *
 * @author Everything
 */
public class FastFoodContants {

    /* DB connection */
    final static public String DRIVER = "driver";
    final static public String URL = "url";
    final static public String DB = "DB";

    /* UserDao */
    final static public String USER_NAME = "UserName";
    final static public String PASSWORD = "Password";
    final static public String FIRST_NAME = "FirstName";
    final static public String LAST_NAME = "LastName";
    final static public String EMAIL = "Email";
    final static public String ADDRESS = "Address";
    final static public String PHONE = "Phone";
    final static public String ROLE = "Role";
    final static public String CREATE_DATE = "CreateDate";
    final static public String IS_ACTIVE = "IsActive";

    /*CatDao*/
    final static public String ID = "ID";
    final static public String NAME = "Name";

    /*ProductDao, EditProduct.jsp*/
    final static public String PRICE = "Price";
    final static public String IMAGE = "Image";
    final static public String DESCRIPTION = "Description";
    final static public String P_CATEID = "CateID";
    final static public String BUY_COUNT = "BuyCount";
    final static public String LAST_UPDATE = "LastUpdate";

    /*OrderDetailDao*/
    final static public String ORDER_ID = "OrderID";
    final static public String PRODUCT_ID = "ProductID";
    final static public String QUANTITY = "Quantity";

    /* OrderDao */
    //final static public String ORDER_ID = "ID";
    final static public String BUYER_NAME = "BuyerName";
    final static public String CREATOR = "Creator";
    final static public String STATUS = "Status";
    final static public String NOTES = "Notes";
    final static public String RECEIVE_ADDRESS = "ReceiveAddress";

    /* Controller Admin*/
    //Product
    final static public String ACTION = "Action";
    final static public String LIST_PRODUCT = "ListProduct";
    final static public String DELETE_PRODUCT = "DeleteProduct";
    final static public String EDIT_PRODUCT = "EditProduct";
    final static public String ADD_PRODUCT = "AddProduct";
    final static public String SESSION_PRODUCT = "PRODUCT";
    final static public String SESSION_CATE = "CATE";
    //User
    final static public String LIST_USER = "ListUser";
    final static public String DELETE_USER = "DeleteUser";
    final static public String EDIT_USER = "EditUser";
    final static public String SESSION_USER = "USER";
    //Order
    final static public String LIST_ORDER = "ListOrder";
    final static public String DELETE_ORDER = "DeleteOrder";
    final static public String EDIT_ORDER = "EditOrder";
    final static public String SESSION_ORDER = "ORDER";
}
