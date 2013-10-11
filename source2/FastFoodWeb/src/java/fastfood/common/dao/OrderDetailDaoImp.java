/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fastfood.common.dao;

import fastfood.common.bean.OrderDetailBean;
import fastfood.common.constants.FastFoodContants;
import fastfood.common.utility.DBUtility;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author bao
 */
public class OrderDetailDaoImp implements OrderDetailDaoInterface {

    @Override
    public boolean Add(OrderDetailBean orderDetail) {
        Connection conn = null;
        PreparedStatement pst = null;
        try {
            conn = DBUtility.makeConnection();
            String query = "INSERT INTO OrderDetail VALUES(?,?,?,?,?)";
            pst = conn.prepareStatement(query);
            pst.setInt(1, orderDetail.getOrderID());
            pst.setInt(2, orderDetail.getProductID());
            pst.setInt(3, orderDetail.getPrice());
            pst.setInt(4, orderDetail.getQuantity());
            pst.setString(5, "true");
            return pst.executeUpdate() > 0;//return result
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (pst != null) {
                    pst.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    @Override
    public boolean Update(OrderDetailBean orderDetail) {
        Connection conn = null;
        PreparedStatement pst = null;
        try {
            conn = DBUtility.makeConnection();
            String query = "UPDATE OrderDetail SET Price=?,Quantity=?,"
                    + "IsActive=? WHERE OrderID=? and ProductID=?";
            pst = conn.prepareStatement(query);

            pst.setInt(1, orderDetail.getPrice());
            pst.setInt(2, orderDetail.getQuantity());
            pst.setInt(4, orderDetail.getOrderID());
            pst.setInt(5, orderDetail.getProductID());
            return pst.executeUpdate() > 0;//return result
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (pst != null) {
                    pst.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    @Override
    public boolean Delete(int orderID, int productID) {
        Connection conn = null;
        PreparedStatement pst = null;
        try {
            conn = DBUtility.makeConnection();
            String query = "UPDATE OrderDetail SET IsActive='false'"
                    + " WHERE OrderID=? and ProductID=?";
            pst = conn.prepareStatement(query);
            pst.setInt(1, orderID);
            pst.setInt(2, productID);
            return pst.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                if (pst != null) {
                    pst.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    @Override
    public OrderDetailBean ListByOrderDetailID(int orderID, int productID) {
        OrderDetailBean result = null;
        Connection conn = null;
        PreparedStatement pst = null;
        try {
            conn = DBUtility.makeConnection();
            String query = "SELECT * FROM OrderDetail WHERE OrderID=? and ProductID=?";
            pst = conn.prepareStatement(query);
            pst.setInt(1, orderID);
            pst.setInt(2, productID);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                int OrderID = rs.getInt(FastFoodContants.ORDER_ID);
                int ProductID = rs.getInt(FastFoodContants.PRODUCT_ID);
                int Price = rs.getInt(FastFoodContants.PRICE);
                int Quantity = rs.getInt(FastFoodContants.QUANTITY);
                boolean IsActive = rs.getBoolean(FastFoodContants.IS_ACTIVE);
                result = new OrderDetailBean(OrderID, ProductID, Price, Quantity, IsActive);
                return result;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (pst != null) {
                    pst.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public List<Integer[]> ListAllOrderDetailID() {
        ArrayList<Integer[]> result = null;
        Connection conn = null;
        PreparedStatement pst = null;
        try {
            conn = DBUtility.makeConnection();
            String query = "SELECT OrderID, ProductID FROM OrderDetail";
            pst = conn.prepareStatement(query);

            ResultSet rs = pst.executeQuery();
            result = new ArrayList<Integer[]>();
            while (rs.next()) {
                int OrderID = rs.getInt(FastFoodContants.ORDER_ID);
                int ProductID = rs.getInt(FastFoodContants.PRODUCT_ID);

                result.add(new Integer[]{OrderID, ProductID});
            }
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (pst != null) {
                    pst.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public List<OrderDetailBean> ListByOrderDetailByOrderID(int orderID) {
        List<OrderDetailBean> result = null;
        Connection conn = null;
        PreparedStatement pst = null;
        try {
            conn = DBUtility.makeConnection();
            String query = "SELECT * FROM OrderDetail WHERE OrderID=?";
            pst = conn.prepareStatement(query);
            pst.setInt(1, orderID);
            ResultSet rs = pst.executeQuery();
            result = new ArrayList<OrderDetailBean>();
            while (rs.next()) {
                int OrderID = rs.getInt(FastFoodContants.ORDER_ID);
                int ProductID = rs.getInt(FastFoodContants.PRODUCT_ID);
                int Price = rs.getInt(FastFoodContants.PRICE);
                int Quantity = rs.getInt(FastFoodContants.QUANTITY);
                boolean IsActive = rs.getBoolean(FastFoodContants.IS_ACTIVE);
                result.add(new OrderDetailBean(OrderID, ProductID, Price, Quantity, IsActive));
            }
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (pst != null) {
                    pst.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
