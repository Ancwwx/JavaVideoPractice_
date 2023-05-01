package com.hspedu.mhl.service;

import java.util.List;

import com.hspedu.mhl.dao.MenuDAO;
import com.hspedu.mhl.domain.Menu;

public class MenuService {

	private MenuDAO menuDAO=new MenuDAO();
	public List<Menu> list(){
		return menuDAO.queryMulti("select * from menu",Menu.class);
	}
	public Menu getMenuById(int id) {
		return menuDAO.querySingle("select * from menu where id = ?",Menu.class, id);
	}
	
	
}
