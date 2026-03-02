package com.atguigu.elm;

import java.util.Scanner;
import com.atguigu.elm.po.Admin;
import com.atguigu.elm.view.AdminView;
import com.atguigu.elm.view.BusinessView;
import com.atguigu.elm.view.impl.AdminViewImpl;
import com.atguigu.elm.view.impl.BusinessViewImpl;

public class ElmAdminEntry {
    public void work() {
        Scanner input = new Scanner(System.in);

        System.out.println("---------------------------------------------------------");
        System.out.println("|             饿了么后台管理系统             |");
        System.out.println("---------------------------------------------------------");

        AdminView adminView = new AdminViewImpl();
        BusinessView businessView = new BusinessViewImpl();
        Admin admin = null;

        boolean loggedIn = false;
        while (!loggedIn) {
            admin = adminView.login();
            if (admin != null) {
                loggedIn = true;
            } else {
                System.out.println("\n管理员名称或密码输入错误!\n");
                System.out.println("是否重新输入管理员名称和密码？（是：1，否：0）");

                // 循环等待输入正确的选择（0或1）
                int choice = -1;
                while (choice != 0 && choice != 1) {
                    if (input.hasNextInt()) {
                        choice = input.nextInt();
                    } else {
                        input.next();
                    }
                    if (choice != 0 && choice != 1) {
                        System.out.println("输入错误！请重新输入正确的选择（是：1，否：0）：");
                    }
                }

                if (choice == 0) {
                    System.out.println("------------------------已退出系统-----------------------");
                    return;
                }
            }
        }

        int menu = 0;
        while (menu != 5) {
            // 输出主菜单
            System.out.println("\n========= 1.所有商家列表=2.搜索商家=3.新建商家=4.删除商家=5.退出系统 =========");
            System.out.println("请输入你的选择：");

            // 循环等待输入正确的菜单选项
            while (!input.hasNextInt()) {
                System.out.println("输入错误！请重新输入正确的菜单选项：");
                input.next();
            }

            menu = input.nextInt();

            switch (menu) {
                case 1:
                    businessView.listBusinessAll();
                    break;
                case 2:
                    businessView.listBusiness();
                    break;
                case 3:
                    businessView.saveBusiness();
                    break;
                case 4:
                    businessView.removeBusiness();
                    break;
                case 5:
                    System.out.println("------------------------欢迎下次光临饿了么后台管理系统-----------------------");
                    break;
                default:
                    System.out.println("没有这个选项！\n");
                    break;
            }
        }
    }

    public static void main(String[] args) {
        new ElmAdminEntry().work();
    }
}
