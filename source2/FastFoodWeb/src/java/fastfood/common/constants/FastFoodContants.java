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
    //Category
    final static public String LIST_CATEGORY = "ListCategory";
    final static public String ADD_CATEGORY = "AddCategory";
    final static public String EDIT_CATEGORY = "EditCategory";
    final static public String DELETE_CATEGORY = "DeleteCategory";

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
    //Export product
    final static public String EXPORT_PRODUCT = "ExportProduct";
    final static public String EXPORT_CATE = "ExportCategory";
    final static public String EXPORT_DATA = "ExportData";


    /* Order status */
    final static public String STATUS_UNAPPROVED = "UNAPPROVED";
    final static public String STATUS_APPROVED = "APPROVED";
    final static public String STATUS_DELIVERED = "DELIVERED";
    final static public String STATUS_CANCEL = "CANCEL";
    /* Controller Guest */
    //Register
    final static public String REGISTER = "Register";
    final static public String SESSION_MSG = "MSG";
    final static public String VERIFY = "Verify";
    final static public String TOKEN = "Token";

    /* Controller User */
    //login
    final static public String LOGIN = "Login";
    final static public String LOGOUT = "Logout";
    final static public String SESSION_LOGIN = "LOGIN";
    //reset pass
    final static public String RESET_PASS = "Reset";
    //profile
    final static public String VIEW_PROFILE = "ViewProfile";
    final static public String EDIT_PROFILE = "EditProfile";
    //product
    final static public String PRODUCT_DETAIL = "ProductDetail";
    //buy product
    final static public String BUY_PRODUCT = "BuyProduct";
    final static public String CHECKOUT = "Checkout";
    final static public String CONFIRM_ORDER = "ConfirmOrder";
    final static public String VIEW_CART = "ViewCart";
    final static public String EDIT_CART = "EditCart";
    final static public String DELETE_CART = "DeleteCart";
    //view orderdetail
    final static public String SESSION_ORDERDETAIL = "ORDERDETAIL";
    final static public String PRINT_PDF = "PrintPDF";
    final static public String LIST_OLD_ORDER = "ListOldOrder";
    final static public String VIEW_ORDER_DETAIL = "OrderDetail";
}
