package com.hspedu.mhl.domain;

public class DiningTable {
	private Integer id;
	private String state;
	private String orderName;
	private String orderTel;

	public DiningTable() {
		super();
	}

	public DiningTable(Integer id, String state, String orderName, String orderTel) {
		super();
		this.id = id;
		this.state = state;
		this.orderName = orderName;
		this.orderTel = orderTel;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getOrderName() {
		return orderName;
	}

	public void setOrderName(String orderName) {
		this.orderName = orderName;
	}

	public String getOrderTel() {
		return orderTel;
	}

	public void setOrderTel(String orderTel) {
		this.orderTel = orderTel;
	}

	@Override
	public String toString() {
		return id + "\t\t\t" + state;
	}

}
