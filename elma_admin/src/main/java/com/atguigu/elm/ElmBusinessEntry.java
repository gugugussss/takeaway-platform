package com.atguigu.elm;

import java.util.Scanner;
import com.atguigu.elm.po.Business;
import com.atguigu.elm.view.BusinessView;
import com.atguigu.elm.view.FoodView;
import com.atguigu.elm.view.impl.BusinessViewImpl;
import com.atguigu.elm.view.impl.FoodViewImpl;

public class ElmBusinessEntry {
	public void work() {
		Scanner input = new Scanner(System.in);

		System.out.println("---------------------------------------------------------");
		System.out.println("|             饿了么后台管理系统             |");
		System.out.println("---------------------------------------------------------");

		BusinessView businessView = new BusinessViewImpl();

		// 商家登录
		Business business = null;

		boolean loggedIn = false;
		while (!loggedIn) {
			business = businessView.login();
			if (business != null) {
				loggedIn = true;
			} else {
				System.out.println("商家编号或密码输入错误！");
				System.out.println("是否重新输入商家编号和密码？（是：1，否：0）");

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
                    System.out.println("------------------------已登出系统-----------------------");
                    return;
                }
            }
		}

		int menu = 0;
		while (menu != 5) {
			// 输出一级菜单
			System.out.println("\n======= 一级菜单（商家管理）1.查看商家信息=2.修改商家信息=3.更新密码=4.所属商品管理=5.退出系统=======");
			System.out.println("请输入你的选择：");

			// 循环等待输入正确的菜单选项
			while (!input.hasNextInt()) {
				System.out.println("输入错误！请重新输入正确的菜单选项：");
				input.next();
			}

			menu = input.nextInt();

			switch (menu) {
			case 1:
				businessView.showBusiness(business.getBusinessId());
				break;
			case 2:
				businessView.editBusiness(business.getBusinessId());
				break;
			case 3:
				businessView.updateBusinessByPassword(business.getBusinessId());
				break;
			case 4:
				foodManager(business.getBusinessId());
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

	private void foodManager(int businessId) {
		Scanner input = new Scanner(System.in);

		FoodView foodView = new FoodViewImpl();

		int menu = 0;
		while (menu != 5) {
			// 输出二级菜单
			System.out.println("\n======= 二级菜单（食品管理）1.查看食品列表=2.新增食品=3.修改食品=4.删除食品=5.返回一级菜单 =======");
			System.out.println("请输入你的选择：");

			// 循环等待输入正确的菜单选项
			while (!input.hasNextInt()) {
				System.out.println("输入错误！请重新输入正确的菜单选项：");
				input.next();
			}

			menu = input.nextInt();

			switch (menu) {
			case 1:
				foodView.showFoodList(businessId);
				break;
			case 2:
				foodView.saveFood(businessId);
				break;
			case 3:
				foodView.updateFood(businessId);
				break;
			case 4:
				foodView.removeFood(businessId);
				break;
			case 5:
				break;
			default:
				System.out.println("没有这个选项！\n");
				break;
			}
		}
	}

	public static void main(String[] args) {
		new ElmBusinessEntry().work();
	}
}
