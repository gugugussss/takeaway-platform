package com.atguigu.elm.view.impl;

import java.util.List;
import java.util.Scanner;

import com.atguigu.elm.dao.FoodDao;
import com.atguigu.elm.dao.impl.FoodDaoImpl;
import com.atguigu.elm.po.Food;
import com.atguigu.elm.view.FoodView;

public class FoodViewImpl implements FoodView {

    private Scanner input = new Scanner(System.in);

    @Override
    public List<Food> showFoodList(Integer businessId) {
        FoodDao dao = new FoodDaoImpl();
        List<Food> list = dao.listFoodByBusinessId(businessId);
        System.out.println("食品编号\t食品名称\t食品介绍\t食品图片\t食品价格\t食品评价");
        for (Food food : list) {

            System.out.println(food.getFoodId() + "\t" + food.getFoodName() + "\t" + food.getFoodExplain() + "\t" + food.getFoodImg() + "\t" + food.getFoodPrice() + "\t" + food.getRemarks());
        }
        return list;
    }

    @Override
    public void saveFood(Integer businessId) {
        Food food = new Food();
        System.out.println("请输入食品名称：");
        food.setFoodName(input.next());
        System.out.println("请输入食品介绍：");
        food.setFoodExplain(input.next());
        System.out.println("请输入食品图片：");
        food.setFoodImg(input.next());
        System.out.println("请输入食品价格：");
        while (input.nextDouble()<0) {
            System.out.println("输入错误！请重新输入食品价格：");
            input.nextDouble();
        }
        food.setFoodPrice(input.nextDouble());
        food.setBusinessId(businessId);
        System.out.println("请输入食品评价：");
        food.setRemarks(input.next());
        FoodDao dao = new FoodDaoImpl();
        int result = dao.saveFood(food);
        if (result > 0) {
            System.out.println("\n新增食品成功！\n");
        } else {
            System.out.println("\n新增食品失败！\n");
        }
    }

    @Override
    public void updateFood(Integer businessId) {
        FoodDao dao = new FoodDaoImpl();
        List<Food> list = showFoodList(businessId);

        if (list.size() == 0) {
            System.out.println("没有任何食品！");
        } else {
            System.out.println("请选择要更新的食品编号：");
            int foodId = input.nextInt();
            Food food = dao.getFoodById(foodId);
            System.out.println(food);

            String inputStr = "";
            System.out.println("是否更新食品名称(y/n)：");
            while (true) {
                inputStr = input.next();
                if (inputStr.equals("y") || inputStr.equals("n")) {
                    break;
                } else {
                    System.out.println("输入错误！请重新输入(y/n)：");
                }
            }
            if (inputStr.equals("y")) {
                System.out.println("请输入新的食品名称：");
                food.setFoodName(input.next());
            }

            System.out.println("是否更新食品介绍(y/n)：");
            while (true) {
                inputStr = input.next();
                if (inputStr.equals("y") || inputStr.equals("n")) {
                    break;
                } else {
                    System.out.println("输入错误！请重新输入(y/n)：");
                }
            }
            if (inputStr.equals("y")) {
                System.out.println("请输入新的食品介绍：");
                food.setFoodExplain(input.next());
            }

            System.out.println("是否更新食品图片(y/n)：");
            while (true) {
                inputStr = input.next();
                if (inputStr.equals("y") || inputStr.equals("n")) {
                    break;
                } else {
                    System.out.println("输入错误！请重新输入(y/n)：");
                }
            }
            if (inputStr.equals("y")) {
                System.out.println("请输入新的食品图片：");
                food.setFoodImg(input.next());
            }


            System.out.println("是否更新食品价格(y/n)：");
            while (true) {
                inputStr = input.next();
                if (inputStr.equals("y") || inputStr.equals("n")) {
                    break;
                } else {
                    System.out.println("输入错误！请重新输入(y/n)：");
                }
            }
            if (inputStr.equals("y")) {
                System.out.println("请输入新的食品价格：");
                while (!input.hasNextBigDecimal()) {
                    System.out.println("输入错误！请重新输入新的食品价格：");
                    input.next();
                }
                food.setFoodPrice(input.nextDouble());
            }

            System.out.println("是否更新食品评价(y/n)：");
            while (true) {
                inputStr = input.next();
                if (inputStr.equals("y") || inputStr.equals("n")) {
                    break;
                } else {
                    System.out.println("输入错误！请重新输入(y/n)：");
                }
            }
            if (inputStr.equals("y")) {
                System.out.println("请输入新的食品评价：");
                food.setRemarks(input.next());
            }
            int result = dao.updateFood(food);
            if (result > 0) {
                System.out.println("\n修改食品成功！\n");
            } else {
                System.out.println("\n修改食品失败！\n");
            }
        }
    }

    @Override
    public void removeFood(Integer businessId) {
        FoodDao dao = new FoodDaoImpl();
        List<Food> list = showFoodList(businessId);

        if (list.size() == 0) {
            System.out.println("没有任何食品！");
        } else {
            System.out.println("请选择要删除的食品编号：");
            int foodId = input.nextInt();

            System.out.println("确认要删除吗(y/n)：");
            while (true) {
                String inputStr = input.next();
                if (inputStr.equals("y")) {
                    int result = dao.removeFood(foodId);
                    if (result > 0) {
                        System.out.println("\n删除食品成功！\n");
                    } else {
                        System.out.println("\n删除食品失败！\n");
                    }
                    break;
                } else if (inputStr.equals("n")) {
                    break;
                } else {
                    System.out.println("输入错误！请重新输入(y/n)：");
                }
            }
        }
    }
}