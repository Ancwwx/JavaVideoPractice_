package com.hspedu.mhl.view;

import java.util.List;

import com.hspedu.mhl.domain.Bill;
import com.hspedu.mhl.domain.DiningTable;
import com.hspedu.mhl.domain.Employee;
import com.hspedu.mhl.domain.Menu;
import com.hspedu.mhl.service.BillService;
import com.hspedu.mhl.service.DiningTableService;
import com.hspedu.mhl.service.EmployeeService;
import com.hspedu.mhl.service.MenuService;
import com.hspedu.mhl.utils.Utility;

//主界面
public class MHLView {

	// 控制是否退出菜单
	private boolean loop = true;
	private String key = "";
	private EmployeeService employeeService = new EmployeeService();
	private DiningTableService diningTableService = new DiningTableService();
	private MenuService menuService = new MenuService();
	private BillService billService = new BillService();

	public static void main(String[] args) {
		new MHLView().mainMenu();
	}
	public void payBill() {
		System.out.println("===========结账服务==========");
		System.out.println("请选择要结账的餐桌编号(-1退出): ");
		int diningTableId= Utility.readInt();
		if(diningTableId==-1) {
			System.out.println("===========取消结账==========");
			return;
		}
		DiningTable diningTable= diningTableService.getDiningTableById(diningTableId);
		if(diningTable==null) {
			System.out.println("===========结账餐桌号不存在==========");
			return;
		}
		if(!billService.hasPayBillByDiningTableId(diningTableId)) {
			System.out.println("===========该餐桌没有未结账账单==========");
			return;
		}
		System.out.println("结账方式(现金/支付宝/微信)回车表示退出: ");
		String payMode= Utility.readString(20, "");
		if("".equals(payMode)) {
			System.out.println("===========取消结账==========");
			return;
		}
		char key =Utility.readConfirmSelection();
		if(key=='Y') {
			if( billService.payBill(diningTableId, payMode)) {
				System.out.println("===========完成结账==========");
			}else {
				System.out.println("===========结账失败==========");
			}
		}else {
			System.out.println("===========取消结账==========");
		}
		
		
		
	}

	public void listBill() {
		List<Bill> Bills = billService.list();

		System.out.println("\n编号\t\t菜品号\t\t菜品量\t\t金额\t\t桌号\t\t日期\t\t\t\t状态");
		for (Bill bill : Bills) {
			System.out.println(bill);
		}
		System.out.println("===========显示完毕==========");
	}

	public void orderMenu() {
		System.out.println("===========点餐服务==========");
		System.out.println("请输入点餐的桌号(-1退出):");
		int orderDiningTableId = Utility.readInt();
		if (orderDiningTableId == -1) {
			System.out.println("===========取消点餐==========");
			return;
		}
		System.out.println("请输入点餐的菜品号(-1退出):");
		int orderMenuId = Utility.readInt();
		if (orderMenuId == -1) {
			System.out.println("===========取消点餐==========");
			return;
		}
		System.out.println("请输入点餐的菜品量(-1退出):");
		int orderNums = Utility.readInt();
		if (orderNums == -1) {
			System.out.println("===========取消点餐==========");
			return;
		}
		DiningTable diningTable = diningTableService.getDiningTableById(orderDiningTableId);
		if (diningTable == null) {
			System.out.println("===========餐桌号不存在==========");
			return;
		}
		Menu menu = menuService.getMenuById(orderMenuId);
		if (menu == null) {
			System.out.println("===========菜品号不存在==========");
			return;

		}
		if (billService.orderMenu(orderMenuId, orderNums, orderDiningTableId)) {
			System.out.println("===========点餐成功==========");

		} else {
			System.out.println("===========点餐失败==========");

		}

	}

	public void listMenu() {
		List<Menu> list = menuService.list();
		System.out.println("\n菜品编号\t\t菜品名\t\t类别\t\t价格");
		for (Menu menu : list) {
			System.out.println(menu);
		}
		System.out.println("===========显示完毕==========");
	}

	public void orderDiningTable() {
		System.out.println("===========预定餐桌==========");
		System.out.println("请选择要预定的餐桌编号(-1退出):");
		int orderId = Utility.readInt();
		if (orderId == -1) {
			System.out.println("===========取消预定餐桌==========");
			return;
		}
		Character key = Utility.readConfirmSelection();
		if (key == 'Y') {
			DiningTable diningTable = diningTableService.getDiningTableById(orderId);
			if (diningTable == null) {
				System.out.println("===========预定餐桌不存在==========");
				return;

			}
			if (!("空".equals(diningTable.getState()))) {
				System.out.println("==========该餐桌已预定或就餐中==========");
				return;
			}
			System.out.println("请输入预定人名字: ");
			String orderName = Utility.readString(50);
			System.out.println("请输入预定人电话: ");
			String orderTel = Utility.readString(50);

			if (diningTableService.orderDiningTable(orderId, orderName, orderTel)) {
				System.out.println("==========餐桌预定成功==========");
			} else {
				System.out.println("==========餐桌预定失败==========");
			}

		} else {
			System.out.println("===========取消预定餐桌==========");
		}
	}

	public void listDiningTable() {
		List<DiningTable> list = diningTableService.list();
		System.out.println("\n餐桌编号\t\t\t餐桌状态");
		for (DiningTable diningTable : list) {
			System.out.println(diningTable);
		}
		System.out.println("===========显示完毕==========");
	}

	public void mainMenu() {

		while (loop) {
			System.out.println("==============满汉楼=============");
			System.out.println("\t\t 1 登陆满汉楼 ");
			System.out.println("\t\t 2 退出满汉楼 ");
			System.out.println("请输入你的选择");
			key = Utility.readString(1);
			switch (key) {
			case "1":
				System.out.println("输入员工号: ");
				String empId = Utility.readString(50);
				System.out.println("输入密 码: ");
				String pwd = Utility.readString(50);
				Employee employee = employeeService.getEmployeeByIdAndPwd(empId, pwd);
				if (employee != null) {
					System.out.println("========= [" + employee.getName() + "] 登陆成功==========\n");
					while (loop) {
						System.out.println("\n===========满汉楼二级菜单==========");
						System.out.println("\t\t 1 显示餐桌状态 ");
						System.out.println("\t\t 2 预定餐桌 ");
						System.out.println("\t\t 3 显示所有菜品 ");
						System.out.println("\t\t 4 点餐服务 ");
						System.out.println("\t\t 5 查看账单 ");
						System.out.println("\t\t 6 结账 ");
						System.out.println("\t\t 9 退出满汉楼 ");

						System.out.println("请输入你的选择");
						key = Utility.readString(1);
						switch (key) {
						case "1":
							listDiningTable();
							break;
						case "2":
							orderDiningTable();
							break;
						case "3":
							listMenu();
							break;
						case "4":
							orderMenu();
							break;
						case "5":
							listBill();
							break;
						case "6":
							payBill();
							break;
						case "9":

							loop = false;
							break;

						default:
							System.out.println("输入有误，请重新输入");
							break;
						}

					}

				} else {
					System.out.println("==========登陆失败=========");
				}
				break;
			case "2":

				loop = false;
				break;

			default:
				System.out.println("输入有误，请重新输入");

			}

		}
		System.out.println("退出满汉楼系统 ");
	}

}
