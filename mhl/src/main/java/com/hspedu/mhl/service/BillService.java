package com.hspedu.mhl.service;

import java.util.List;
import java.util.UUID;

import com.hspedu.mhl.dao.BillDAO;
import com.hspedu.mhl.domain.Bill;

public class BillService {

	private BillDAO billDAO = new BillDAO();
	private MenuService menuService = new MenuService();
	private DiningTableService diningTableService = new DiningTableService();

	public boolean orderMenu(int menuId, int nums, int diningTableId) {
		String billID = UUID.randomUUID().toString();
		int update = billDAO.update("insert into bill values(null,?,?,?,?,?,now(),'未结账')", billID, menuId, nums,
				menuService.getMenuById(menuId).getPrice() * nums, diningTableId);
		if (update <= 0) {
			return false;
		}
		return diningTableService.updateDiningTableState(diningTableId, "就餐中");

	}
	
	public List<Bill> list(){
		return billDAO.queryMulti("select * from bill ", Bill.class);
	}
	public boolean hasPayBillByDiningTableId(int diningTableId) {
		Bill bill= billDAO.querySingle("select * from bill where diningTableId=? and state='未结账' Limit 0,1", Bill.class, diningTableId);
		return bill != null;
	}
	public boolean payBill(int diningTableId,String payMode) {
		int update= billDAO.update("update bill set state=? where diningTableId=? and state='未结账'", payMode,diningTableId );
		if(update <=0) {
			return false;
		}
		if(!diningTableService.updateDiningTableToFree(diningTableId, "空")) {
			return false;
		}
		return true;
	}

}
