package cn.my.dao;

import java.util.List;

import cn.my.model.Menu;

public interface MenuMapper {

    Menu selectMenuById(Long id);
    
    List<Menu> selectAllMenu();

}