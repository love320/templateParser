package com.love320.templateparser.label;

import java.util.Map;

public class BuLabel extends AbstractLabelAction {

	@Override
	protected Map exec(Map renderMap, Map systemMap) {
		System.out.println("运行:处理.buLabel");
		return renderMap;
	}

}
