package com.love320.templateparser.label;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

public class BuLabel extends AbstractLabelAction {

    private final static Logger logger = LoggerFactory.getLogger(BuLabel.class);

	@Override
	protected Map exec(Map renderMap, Map systemMap) {
        logger.debug("运行:处理.buLabel");
		return renderMap;
	}

}
