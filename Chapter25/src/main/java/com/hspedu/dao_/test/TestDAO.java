package com.hspedu.dao_.test;

import java.util.List;

import org.junit.Test;

import com.hspedu.dao_.dao.ActorDAO;
import com.hspedu.jdbc.datasource.Actor;

public class TestDAO {
@Test
	public void testActorDAO() {
		ActorDAO actorDAO = new ActorDAO();

		List<Actor> actors = actorDAO.queryMulti("select * from actor where id >= ?", Actor.class, 1);
		System.out.println("===查询结果===");
		for (Actor actor : actors) {
			System.out.println(actor);
		}
		Actor actor=actorDAO.querySingle("select * from actor where id = ?", Actor.class, 4);
		System.out.println("===查询单行结果===");
		System.out.println(actor);
	
		Object object=actorDAO.queryScalar("select name from actor where id = ?", 4);
		System.out.println("===查询单行单列结果===");
		System.out.println(object);
		
		int rows= actorDAO.update("insert into actor values(null,?,?,?,?)", "张无忌","男","2000-01-20","999");
	
		System.out.println(rows>0?"成功":"失败");

}

}
