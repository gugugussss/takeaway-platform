package com.atguigu.elm.dao;
import com.atguigu.elm.po.Admin;

public interface AdminDao {

	public Admin getAdminByNameByPass(String adminName,String password);
	
}
