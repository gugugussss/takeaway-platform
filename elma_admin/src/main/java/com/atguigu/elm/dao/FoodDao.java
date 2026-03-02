package com.atguigu.elm.dao;
import java.util.List;
import com.atguigu.elm.po.Food;
public interface FoodDao {
 public List<Food> listFoodByBusinessId(Integer businessId);
 public int saveFood(Food food);
 public Food getFoodById(Integer foodId);
 public int updateFood(Food food);
 public int removeFood(Integer foodId);
}