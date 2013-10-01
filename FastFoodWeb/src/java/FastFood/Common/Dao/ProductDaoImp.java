/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package FastFood.Common.Dao;

import FastFood.Common.Bean.ProductBean;
import FastFood.Common.Constants.FastFoodContants;
import FastFood.Common.Utility.DBUtility;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author bao
 */
public class ProductDaoImp implements ProductDaoInterface {

    //Implement method ADD
    @Override
    public boolean Add(ProductBean product) {
        Connection conn = null;
        PreparedStatement pst = null;
        try {
            conn = DBUtility.makeConnection();
            String query = "INSERT INTO Product([Name],Price,[Image],Description,"
                    + "CateID,BuyCount,CreateDate,LastUpdate,IsActive) "
                    + "VALUES(?,?,?,?,?,?,?,?,?)";
            pst = conn.prepareStatement(query);
            pst.setString(1, product.getName());
            pst.setInt(2, product.getPrice());
            pst.setString(3, product.getImage());
            pst.setString(4, product.getDescription());
            pst.setInt(5, product.getCateID());
            pst.setInt(6,0);
            Date todayD = new Date(System.currentTimeMillis());
            SimpleDateFormat dayFormat = new SimpleDateFormat("yyyy/MM/dd");
            String todayS = dayFormat.format(todayD);
            pst.setString(7, todayS);
            pst.setString(8, todayS);
            pst.setString(9, "true");
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

    //Implement method Update
    @Override
    public boolean Update(ProductBean product) {
        Connection conn = null;
        PreparedStatement pst = null;
        try {
            conn = DBUtility.makeConnection();
            String query = "UPDATE Product SET Name=?,Price=?,Image=?,Description=?,"
                    + "CateID=?,BuyCount=?,LastUpdate=?,IsActive=? WHERE ID=?";
            pst = conn.prepareStatement(query);
            pst.setString(1, product.getName());
            pst.setInt(2, product.getPrice());
            pst.setString(3, product.getImage());
            pst.setString(4, product.getDescription());
            pst.setInt(5, product.getCateID());
            pst.setInt(6, product.getBuyCount());
            Date todayD = new Date(System.currentTimeMillis());
            SimpleDateFormat dayFormat = new SimpleDateFormat("yyyy/MM/dd");
            String todayS = dayFormat.format(todayD);
            pst.setDate(7, todayD);
            pst.setBoolean(8, product.isIsActive());
            pst.setInt(9, product.getID());

            return (pst.executeUpdate() > 0);
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

    //Implements method Delete
    @Override
    public boolean Delete(int ID) {
        Connection conn = null;
        PreparedStatement pst = null;
        try {
            conn = DBUtility.makeConnection();
            String query = "UPDATE Product SET IsActive='false' WHERE ID=?";
            pst = conn.prepareStatement(query);
            pst.setInt(1, ID);
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
    public ProductBean ListByProductID(int ID) {
        ProductBean result = null;
        Connection conn = null;
        PreparedStatement pst = null;
        try {
            conn = DBUtility.makeConnection();
            String query = "SELECT * FROM Product WHERE ID=?";
            pst = conn.prepareStatement(query);
            pst.setInt(1, ID);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                int ProductID = rs.getInt(FastFoodContants.ID);
                String Name = rs.getString(FastFoodContants.P_NAME);
                int Price = rs.getInt(FastFoodContants.PRICE);
                String Image = rs.getString(FastFoodContants.IMAGE);
                String Description = rs.getString(FastFoodContants.DESCRIPTION);
                int CateID = rs.getInt(FastFoodContants.P_CATEID);
                int BuyCount = rs.getInt(FastFoodContants.BUYCOUNT);
                Date CreateDate = rs.getDate(FastFoodContants.CREATE_DATE);
                Date LastUpdate = rs.getDate(FastFoodContants.lAST_UPDATE);
                boolean IsActive = rs.getBoolean(FastFoodContants.IS_ACTIVE);

                result = new ProductBean(ProductID, Name, Price, Image, Description, CateID, BuyCount, CreateDate, LastUpdate, IsActive);
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
    public List<Integer> ListAllProductID() {
        ArrayList<Integer> result = null;
        Connection conn = null;
        PreparedStatement pst = null;
        try {
            conn = DBUtility.makeConnection();
            String query = "SELECT ID FROM Product";
            pst = conn.prepareStatement(query);

            ResultSet rs = pst.executeQuery();
            result = new ArrayList<Integer>();
            while (rs.next()) {
                int ProductID = rs.getInt(FastFoodContants.ID);
                result.add(ProductID);
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
    public List<Integer> ListByCatID(int ID) {
        ArrayList<Integer> result = null;
        Connection conn = null;
        PreparedStatement pst = null;
        try {
            conn = DBUtility.makeConnection();
            String query = "SELECT ID FROM Product WHERE CateID=?";
            pst = conn.prepareStatement(query);
            pst.setInt(1, ID);
            ResultSet rs = pst.executeQuery();
            //result = new ArrayList<String>();
            while (rs.next()) {
                int ProductID = rs.getInt(FastFoodContants.ID);
                result.add(ProductID);
            }
            return result;
        } catch (Exception e) {
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
        return null;

    }
}
