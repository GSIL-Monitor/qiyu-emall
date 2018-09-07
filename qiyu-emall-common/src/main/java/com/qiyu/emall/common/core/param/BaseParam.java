package com.qiyu.emall.common.core.param;


import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import java.io.Serializable;

/**
 * baseParam by shaozhou
 */
public class BaseParam implements Serializable {

   private static final long serialVersionUID = 1L;

   /**
    * 分页数据 每页大小
    */
   private Integer pageSize;

   /**
    * 分页数据 当前页 从1开始 不传或传0表示获取全部数据
    */
   private Integer currentPage;

   public Integer getPageSize() {
      return pageSize;
   }

   public void setPageSize(Integer pageSize) {
      this.pageSize = pageSize;
   }

   public Integer getCurrentPage() {
      return currentPage;
   }

   public void setCurrentPage(Integer currentPage) {
      this.currentPage = currentPage;
   }

   @Override
   public String toString() {
      return ToStringBuilder.reflectionToString(this, ToStringStyle.DEFAULT_STYLE);
   }
}
