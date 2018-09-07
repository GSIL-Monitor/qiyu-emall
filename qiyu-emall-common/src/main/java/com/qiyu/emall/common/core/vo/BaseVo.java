package com.qiyu.emall.common.core.vo;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import java.io.Serializable;

public class BaseVo implements Serializable {

	private static final long serialVersionUID = 1535766112409210758L;

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.DEFAULT_STYLE);
	}
}
