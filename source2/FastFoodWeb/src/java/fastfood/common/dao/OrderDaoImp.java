/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fastfood.common.dao;

import fastfood.common.addtionbean.OrderStaticBean;
import fastfood.common.bean.OrderBean;
import fastfood.common.constants.FastFoodContants;
import fastfood.common.utility.DBUtility;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Everything
 */
public class OrderDaoImp implements OrderDaoInterface {

    @Override
    public boolean Add(OrderBean order) {
        Connection conn = null;
        PreparedStatement pst = null;
        try {
            conn = DBUtility.makeConnection();
            String query = "INSERT INTO [Order](BuyerName, Status, Notes,"
                    + " ReceiveAddress, CreateDate, IsActive)"
                    + "VALUES(?, ?, ?, ?, ?, ?)";
            pst = conn.prepareStatement(query);
            pst.setString(1, order.getBuyerName());
            pst.setString(2, order.getStatus());
            pst.setString(3, order.getNotes());
            pst.setString(4, order.getReceiveAddress());
            Date todayD = new Date(System.currentTimeMillis());
            SimpleDateFormat dayFormat = new SimpleDateFormat("yyyy/MM/dd");
            String todayS = dayFormat.format(todayD);
            pst.setString(5, todayS);
            pst.setBoolean(6, true);
            return pst.executeUpdate() > 0;
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
    public boolean Update(OrderBean order) {
        Connection conn = null;
        PreparedStatement pst = null;
        try {
            conn = DBUtility.makeConnection();
            String query = "UPDATE [Order] SET BuyerName=?,Creator=?, Status=?, Notes=?,"
                    + " ReceiveAddress=?, IsActive = ? WHERE ID = ?";
            pst = conn.prepareStatement(query);
            pst.setString(1, order.getBuyerName());
            pst.setString(2, order.getCreator());
            pst.setString(3, order.getStatus());
            pst.setString(4, order.getNotes());
            pst.setString(5, order.getReceiveAddress());
            pst.setBoolean(6, order.isIsActive());
            pst.setInt(7, order.getID());
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
    public boolean Delete(int ID) {
        Connection conn = null;
        PreparedStatement pst = null;
        try {
            conn = DBUtility.makeConnection();
            String query = "UPDATE [Order] SET IsActive = 'false' WHERE ID = ?";
            pst = conn.prepareStatement(query);
            pst.setInt(1, ID);
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
    public OrderBean ListByOrderID(int ID) {
        Connection conn = null;
        PreparedStatement pst = null;
        try {
            conn = DBUtility.makeConnection();
            String query = "SELECT * FROM [Order] WHERE ID = ?";
            pst = conn.prepareStatement(query);
            pst.setInt(1, ID);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                int id = rs.getInt(FastFoodContants.ID);
                String buyerName = rs.getString(FastFoodContants.BUYER_NAME);
                String creator = rs.getString(FastFoodContants.CREATOR);
                String status = rs.getString(FastFoodContants.STATUS);
                String notes = rs.getString(FastFoodContants.NOTES);
                String receiveAddress = rs.getString(FastFoodContants.RECEIVE_ADDRESS);
                Date createDate = rs.getDate(FastFoodContants.CREATE_DATE);
                Boolean isActive = rs.getBoolean(FastFoodContants.IS_ACTIVE);
                OrderBean order = new OrderBean();
                order.setID(id);
                order.setBuyerName(buyerName);
                order.setCreator(creator);
                order.setStatus(status);
                order.setNotes(notes);
                order.setReceiveAddress(receiveAddress);
                order.setCreateDate(createDate);
                order.setIsActive(isActive);
                return order;
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
    public List<Integer> ListAllOrderID(boolean showActiveOnly) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        Connection conn = null;
        PreparedStatement pst = null;
        try {
            conn = DBUtility.makeConnection();
            String query = "";
            if (showActiveOnly == true) {
                query = "SELECT ID FROM [Order] WHERE IsActive = 'true'";
            } else {
                query = "SELECT ID FROM [Order]";
            }
            pst = conn.prepareStatement(query);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                int id = rs.getInt(FastFoodContants.ID);
                result.add(id);
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

    @Override
    public List<Integer> ListAllOrderByBuyer(String BuyerName) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        Connection conn = null;
        PreparedStatement pst = null;
        try {
            conn = DBUtility.makeConnection();
            String query = "SELECT ID FROM [Order] WHERE BuyerName= ?";
            pst = conn.prepareStatement(query);
            pst.setString(1, BuyerName);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                int id = rs.getInt(FastFoodContants.ID);
                result.add(id);
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

    @Override
    public List<Integer> ListAllOrderByCreator(String Creator) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        Connection conn = null;
        PreparedStatement pst = null;
        try {
            conn = DBUtility.makeConnection();
            String query = "SELECT ID FROM [Order] WHERE Creator= ?";
            pst = conn.prepareStatement(query);
            pst.setString(1, Creator);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                int id = rs.getInt(FastFoodContants.ID);
                result.add(id);
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

    public List<Integer> ListAllOrderByStatus(String status) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        Connection conn = null;
        PreparedStatement pst = null;
        try {
            conn = DBUtility.makeConnection();
            String query = "";
            query = "SELECT ID FROM [Order] WHERE IsActive = 'true' AND Status=?";
            pst = conn.prepareStatement(query);
            pst.setString(1, status);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                int id = rs.getInt(FastFoodContants.ID);
                result.add(id);
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

    public List<OrderStaticBean> ListOrderStatic(Date from, Date to) {
        ArrayList<OrderStaticBean> result = new ArrayList<OrderStaticBean>();
        Connection conn = null;
        PreparedStatement pst = null;
        try {
            conn = DBUtility.makeConnection();
            String query = "";
            query = "SELECT r1.CreateDate, SUM(r2.Total) as Total FROM(SELECT *"
                    + " FROM [Order] WHERE Status = 'DELIVERED' AND IsActive = 'true'"
                    + " AND CreateDate >= ?	AND	CreateDate <= ?) r1,	"
                    + "(SELECT OrderID, SUM(Price*Quantity) as Total FROM OrderDetail "
                    + "GROUP BY OrderID) r2 WHERE r1.ID = r2.OrderID "
                    + "GROUP BY r1.CreateDate";
            pst = conn.prepareStatement(query);
            pst.setDate(1, from);
            pst.setDate(2, to);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Date date = rs.getDate(FastFoodContants.CREATE_DATE);
                int total = rs.getInt("Total");
                result.add(new OrderStaticBean(date, total));
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
