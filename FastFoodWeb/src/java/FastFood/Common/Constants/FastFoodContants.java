/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package FastFood.Common.Constants;

/**
 *
 * @author Everything
 */
public class FastFoodContants {
    /* DB connection */
    //driver
    final static public String DRIVER = "driver";
    //url
    final static public String URL = "url";
    //filename
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

    final static public String CAT_ID = "ID";
    final static public String CAT_NAME = "Name";

    /*ProductDao*/
    final static public String ID = "ID";
    final static public String P_NAME = "Name";
    final static public String PRICE = "Price";
    final static public String IMAGE = "Image";
    final static public String DESCRIPTION = "Description";
    final static public String P_CATEID = "CateID";
    final static public String BUYCOUNT = "BuyCount";
    final static public String lAST_UPDATE = "LastUpdate";

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
}
