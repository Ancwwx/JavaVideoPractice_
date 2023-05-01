package com.hspedu.mhl.service;

import java.util.List;

import com.hspedu.mhl.dao.DiningTableDAO;
import com.hspedu.mhl.domain.DiningTable;

public class DiningTableService {

	private DiningTableDAO diningTableDAO = new DiningTableDAO();

	public List<DiningTable> list() {
		return diningTableDAO.queryMulti("select id,state from diningTable", DiningTable.class);

	}

	public DiningTable getDiningTableById(int id) {
		return diningTableDAO.querySingle("select * from diningTable where id=?", DiningTable.class, id);

	}

	public boolean orderDiningTable(int id, String orderName, String orderTel) {
		int update = diningTableDAO.update("update diningTable set state='已经预定',orderName=?,orderTel=? where id=?",
				orderName, orderTel, id);
		return update > 0;

	}

	public boolean updateDiningTableState(int id, String state) {
		int update = diningTableDAO.update("update diningTable set state=? where id =?", state, id);
		return update > 0;

	}
	public boolean updateDiningTableToFree(int id, String state) {
		int update = diningTableDAO.update("update diningTable set state=?,orderName='',orderTel=''where id =?", state, id);
		return update > 0;

	}
	

}
