package com.qiyu.emall.controller;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.http.cookie.Cookie;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Controller
public class BaseController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    public static final Integer PAGE_SIZE = 10;// 分页大小

    public static final Integer CURRENT_PAGE = 1;// 当前页数


    public static PageBounds fillPaginate(Integer pageSize, Integer currentPage) {
        PageBounds pageBounds = new PageBounds();
        pageBounds.setContainsTotalCount(Boolean.TRUE);
        pageBounds.setLimit(pageSize == null ? PAGE_SIZE : pageSize);
        pageBounds.setPage(currentPage == null ? CURRENT_PAGE : currentPage);
        return pageBounds;
    }

}
