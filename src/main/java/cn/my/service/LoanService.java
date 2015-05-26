package cn.my.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.my.dao.MenuMapper;
import cn.my.model.Menu;

@Service
public class LoanService {
	
	@Autowired
	private MenuMapper menuMapper;
	
	public Menu getMenuById(Long id) {
		Menu m = menuMapper.selectMenuById(id);
		return m;
	}
	
	
	public List<Menu> selectAllMenu() {
		List<Menu> list = menuMapper.selectAllMenu();
		return list;
	}
	
}
