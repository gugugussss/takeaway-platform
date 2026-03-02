package com.atguigu.elm.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.atguigu.elm.dao.FoodDao;
import com.atguigu.elm.po.Food;
import com.atguigu.elm.util.DBUtil;

public class FoodDaoImpl implements FoodDao {

    private Connection con = null;
    private PreparedStatement pst = null;
    private ResultSet rs = null;

    @Override
    public List<Food> listFoodByBusinessId(Integer businessId) {
        List<Food> list = new ArrayList<>();
        String sql = "select * from food where businessId=?";
        try {
            con = DBUtil.getConnection();
            pst = con.prepareStatement(sql);
            pst.setInt(1, businessId);
            rs = pst.executeQuery();
            while (rs.next()) {
                Food food = new Food();
                food.setFoodId(rs.getInt("foodId"));
                food.setFoodName(rs.getString("foodName"));
                food.setFoodExplain(rs.getString("foodExplain"));
                food.setFoodImg(rs.getString("foodImg"));
                food.setFoodPrice(rs.getDouble("foodPrice"));
                food.setBusinessId(rs.getInt("businessId"));
                food.setRemarks(rs.getString("remarks"));
                list.add(food);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(rs, pst, con);
        }
        return list;
    }

    @Override
    public int saveFood(Food food) {
        int result = 0;
        String sql = "insert into food values(null,?,?,?,?,?,?)";
        try {
            con = DBUtil.getConnection();
            pst = con.prepareStatement(sql);
            pst.setString(1, food.getFoodName());
            pst.setString(2, food.getFoodExplain());
            pst.setString(3, food.getFoodImg());
            pst.setDouble(4, food.getFoodPrice());
            pst.setInt(5, food.getBusinessId());
            pst.setString(6, food.getRemarks());
            result = pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(null, pst, con);
        }
        return result;
    }

    @Override
    public Food getFoodById(Integer foodId) {
        Food food = null;
        String sql = "select * from food where foodId=?";
        try {
            con = DBUtil.getConnection();
            pst = con.prepareStatement(sql);
            pst.setInt(1, foodId);
            rs = pst.executeQuery();
            while (rs.next()) {
                food = new Food();
                food.setFoodId(rs.getInt("foodId"));
                food.setFoodName(rs.getString("foodName"));
                food.setFoodExplain(rs.getString("foodExplain"));
                food.setFoodImg(rs.getString("foodImg"));
                food.setFoodPrice(rs.getDouble("foodPrice"));
                food.setBusinessId(rs.getInt("businessId"));
                food.setRemarks(rs.getString("remarks"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(rs, pst, con);
        }
        return food;
    }

    @Override
    public int updateFood(Food food) {
        int result = 0;
        String sql = "update food set foodName=?,foodExplain=?,foodImg=?,foodPrice=?,remarks=? where foodId=?";
        try {
            con = DBUtil.getConnection();
            pst = con.prepareStatement(sql);
            pst.setString(1, food.getFoodName());
            pst.setString(2, food.getFoodExplain());
            pst.setString(3, food.getFoodImg());
            pst.setDouble(4, food.getFoodPrice());
            pst.setString(5, food.getRemarks());
            pst.setInt(6, food.getFoodId());
            result = pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(null, pst, con);
        }
        return result;
    }

    @Override
    public int removeFood(Integer foodId) {
        int result = 0;
        String sql = "delete from food where foodId=?";
        try {
            con = DBUtil.getConnection();
            pst = con.prepareStatement(sql);
            pst.setInt(1, foodId);
            result = pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(null, pst, con);
        }
        return result;
    }
}