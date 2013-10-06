/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fastfood.common.dao;

import fastfood.common.bean.CategoryBean;
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
public class CategoryDaoImp implements CategoryDaoInterface {

    @Override
    public boolean Add(String Name) {
        Connection conn = null;
        PreparedStatement pst = null;
        try {
            conn = DBUtility.makeConnection();
            String query = "INSERT INTO Category([Name],IsActive) VALUES(?,?)";
            pst = conn.prepareStatement(query);
            pst.setString(1, Name);
            pst.setString(2, "true");

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
            return false;
        }
    }

    @Override
    public boolean Update(CategoryBean cate) {
        Connection conn = null;
        PreparedStatement pst = null;
        try {
            conn = DBUtility.makeConnection();
            String query = "UPDATE Category SET [Name]=?, IsActive=? WHERE ID=?";
            pst = conn.prepareStatement(query);
            pst.setString(1, cate.getName());
            pst.setBoolean(2, cate.isIsActive());
            pst.setInt(3, cate.getID());
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
    public boolean Delete(int ID) {
        Connection conn = null;
        PreparedStatement pst = null;
        try {
            conn = DBUtility.makeConnection();
            String query = "UPDATE Category SET IsActive='false' WHERE ID=?";
            pst = conn.prepareStatement(query);
            pst.setInt(1, ID);
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
    public CategoryBean ListByCatID(int ID) {

        Connection conn = null;
        PreparedStatement pst = null;
        try {
            conn = DBUtility.makeConnection();
            String query = "SELECT * FROM Category WHERE ID = ?";
            pst = conn.prepareStatement(query);
            pst.setInt(1, ID);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                int ID_cat = rs.getInt(FastFoodContants.ID);
                String name = rs.getString(FastFoodContants.NAME);
                boolean IsActive = rs.getBoolean(FastFoodContants.IS_ACTIVE);
                CategoryBean result = new CategoryBean(ID_cat, name, IsActive);
                return result;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        }
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
        return null;
    }

    @Override
    public List<Integer> ListAllCatID(boolean showActiveOnly) {
        ArrayList<Integer> result = null;
        Connection conn = null;
        PreparedStatement pst = null;
        try {
            conn = DBUtility.makeConnection();
            String query = "";
            if (showActiveOnly == true) {
                query = "SELECT * FROM Category WHERE IsActive = 'true'";
            } else {
                query = "SELECT * FROM Category";
            }
            pst = conn.prepareStatement(query);
            ResultSet rs = pst.executeQuery();
            result = new ArrayList<Integer>();
            while (rs.next()) {
                int ID = rs.getInt(FastFoodContants.ID);
                result.add(ID);
            }
            return result;
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
        return null;
    }
}
