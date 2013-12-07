package com.love320.templateparser.label.action;

import java.util.Map;

import com.love320.templateparser.label.LabelAction;

public class IncludeTempAction implements LabelAction {

	@Override
	public Map<String, Object> action(Map<String, Object> data) {
		return null;
	}

	@Override
	public String template(String tem, Map<String, Object> data) {
		
		return tem;
	}

}
