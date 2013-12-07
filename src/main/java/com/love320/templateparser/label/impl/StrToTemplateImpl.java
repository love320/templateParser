package com.love320.templateparser.label.impl;

import com.love320.templateparser.factory.Factory;
import com.love320.templateparser.label.LabelAction;
import com.love320.templateparser.label.StrToTemplate;
import com.love320.templateparser.util.Log;
import com.love320.templateparser.util.MD5;
import com.love320.templateparser.util.StringUtil;

public class StrToTemplateImpl implements StrToTemplate {
	
	private String tagNamehead = "love320:";
	private String tagNamefoot = "/";
	private Factory factoryService;//bean工厂
	
	public void setTagNamehead(String tagNamehead) {
		this.tagNamehead = tagNamehead;
	}

	public void setTagNamefoot(String tagNamefoot) {
		this.tagNamefoot = tagNamefoot;
	}

	public void setFactoryService(Factory factoryService) {
		this.factoryService = factoryService;
	}

	@Override
	public String get(String str,String dir) {
		String template = "";
		for (String singStr : str.split("\r\n")) {//遍例每一条信息
			template += tagStrRow(singStr,dir);//分析并处理信息
		}
		return template;
	}
	
	/**
	 * 分析一条字符串有多少个标签并分离出来 ，方法为二分法
	 * */
	private String tagStrRow(String str,String dir) {
		String temstr = "";
		String[] strS = str.split("\\{" + tagNamehead);//二分法以 tagNamehead 内容分解
		if (strS.length > 1) { //字条串中有存在标签
			for (String singStr : strS) {
				if(singStr.indexOf(tagNamefoot+"}") != -1){//提取标签名
					String[] singStrS = singStr.split(tagNamefoot+"}");
					String actionData = dataAction(singStrS[0]+" dir="+dir);//处理数据并拼接 模板文件目录路径
					temstr += get(actionData,dir);//深层分析模板
					if (singStrS.length == 2) temstr += singStrS[1];
				}else{
					temstr = singStr;
				}
			}
		}else{
			temstr = str;
		}
		return temstr;
	}
	
	private String dataAction(String str){
		String[] ss = str.split(" ");
		if(ss.length > 1){
			LabelAction labelAction = (LabelAction)factoryService.getbean(ss[0]+"TempAction");//获取标签处理对象
			return labelAction.template(ss[0], StringUtil.templateToMap(str));
		}
		return "";
	}
	

}
