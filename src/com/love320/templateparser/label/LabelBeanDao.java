 /**
 * Copyright (c) 2010-2012 love320.com
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * 
 * Founder admin@love320.com
 */
package com.love320.templateparser.label;

import java.util.List;

import com.love320.templateparser.factory.entity.LabelBean;

/** 
 * @ClassName: LabelManager 
 * @Description: TODO
 * @author love320.com
 * @date 2012-6-23 下午06:47:54 
 *  标签信息管理接口
 */
public interface LabelBeanDao {
	
	public boolean add(LabelBean labelBean); //添加
	
	public boolean delete(String labelName);//删除 - 已名称

	public boolean delete(LabelBean labelBean);//删除 - 已对象
	
	public boolean update(LabelBean labelBean);//修改
	
	public List<LabelBean> getAll();//获取所有
	 
	public LabelBean get(String labelName);//获取标签信息
}
