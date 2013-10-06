/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fastfood.common.dao;

import fastfood.common.bean.UserBean;
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
public class UserDaoImp implements UserDaoInterface {

    @Override
    public boolean Add(UserBean user) {
        Connection conn = null;
        PreparedStatement pst = null;
        try {
            conn = DBUtility.makeConnection();
            String query = "INSERT INTO [User] VALUES(?,?,?,?,?,?,?,?,?,?)";
            pst = conn.prepareStatement(query);
            pst.setString(1, user.getUserName());
            pst.setString(2, user.getPassword());
            pst.setString(3, user.getFirstName());
            pst.setString(4, user.getLastName());
            pst.setString(5, user.getEmail());
            pst.setString(6, user.getAddress());
            pst.setString(7, user.getPhone());
            pst.setString(8, "Customer");

            Date todayD = new Date(System.currentTimeMillis());
            SimpleDateFormat dayFormat = new SimpleDateFormat("yyyy/MM/dd");
            String todayS = dayFormat.format(todayD);
            pst.setString(9, todayS);

            pst.setString(10, "true");
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
    public boolean Update(UserBean user) {
        Connection conn = null;
        PreparedStatement pst = null;
        try {
            conn = DBUtility.makeConnection();
            String query = "UPDATE [User] SET Password=?, FirstName=?, LastName=?,"
                    + " Email=?,Address=?, Phone=?,[Role]=?,IsActive=? WHERE UserName=?";
            pst = conn.prepareStatement(query);
            pst.setString(1, user.getPassword());
            pst.setString(2, user.getFirstName());
            pst.setString(3, user.getLastName());
            pst.setString(4, user.getEmail());
            pst.setString(5, user.getAddress());
            pst.setString(6, user.getPhone());
            pst.setString(7, user.getRole());
            pst.setBoolean(8, user.isActive());
            pst.setString(9, user.getUserName());

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
    public boolean Delete(String UserName) {
        Connection conn = null;
        PreparedStatement pst = null;
        try {
            conn = DBUtility.makeConnection();
            String query = "UPDATE [User] SET IsActive= 'false' WHERE UserName=?";
            pst = conn.prepareStatement(query);
            pst.setString(1, UserName);

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
    public UserBean ListByUserName(String UserName) {
        UserBean result = null;
        Connection conn = null;
        PreparedStatement pst = null;
        try {
            conn = DBUtility.makeConnection();
            String query = "SELECT * FROM [User] WHERE UserName=?";
            pst = conn.prepareStatement(query);
            pst.setString(1, UserName);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                String username = rs.getString(FastFoodContants.USER_NAME);
                String password = rs.getString(FastFoodContants.PASSWORD);
                String firstname = rs.getString(FastFoodContants.FIRST_NAME);
                String lastname = rs.getString(FastFoodContants.LAST_NAME);
                String email = rs.getString(FastFoodContants.EMAIL);
                String address = rs.getString(FastFoodContants.ADDRESS);
                String phone = rs.getString(FastFoodContants.PHONE);
                String role = rs.getString(FastFoodContants.ROLE);
                Date createDate = rs.getDate(FastFoodContants.CREATE_DATE);
                boolean isActive = rs.getBoolean(FastFoodContants.IS_ACTIVE);

                result = new UserBean(username, password, firstname,
                        lastname, email, address, phone, role, createDate, isActive);

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
    public List<String> ListAllUserName(boolean showActiveOnly) {
        ArrayList<String> result = null;
        Connection conn = null;
        PreparedStatement pst = null;
        try {
            conn = DBUtility.makeConnection();
            String query = "";
            if (showActiveOnly == true) {
                query = "SELECT UserName FROM [User] WHERE IsActive = 'true'";
            } else {
                query = "SELECT UserName FROM [User]";
            }
            pst = conn.prepareStatement(query);

            ResultSet rs = pst.executeQuery();
            result = new ArrayList<String>();
            while (rs.next()) {
                String username = rs.getString(FastFoodContants.USER_NAME);
                result.add(username);
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
