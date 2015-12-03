package com.langeye.tags;

/**
 * Author:  Fish
 * Date:    2015/11/20.
 * Project: EasyPlat
 */
import java.io.IOException;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PagingTag extends SimpleTagSupport {
    protected final Log logger = LogFactory.getLog(getClass());

    private String href;
    private int page;
    private int pageSize;
    private int totalRecords;
    private String paras;
    private int pageCount;

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public String getParas() {
        return paras;
    }

    public void setParas(String paras) {
        this.paras = paras;
    }

    public int getTotalRecords() {
        return totalRecords;
    }

    public void setTotalRecords(int totalRecords) {
        this.totalRecords = totalRecords;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    @Override
    public void doTag() throws JspException, IOException {
        JspWriter out = getJspContext().getOut();
        StringBuilder sbPaging = new StringBuilder();
        sbPaging.append("<div class=\"pagin\">");
        sbPaging.append("<div class=\"message\">共<i class=\"blue\">"+this.totalRecords+"</i>条记录，");
        //sbPaging.append("共&nbsp;<i class=\"blue\">"+this.pageCount+"&nbsp;</i>页记录</div>");
        sbPaging.append("当前为第&nbsp;<i class=\"blue\">"+this.page+"&nbsp;</i>页</div>");
        String action = this.href;
        action = StringUtils.replace(action,"{page}",((Integer)this.page).toString());
        action = StringUtils.replace(action, "{pageSize}", ((Integer) this.pageSize).toString());
        if(!StringUtils.isEmpty(this.paras)){
            if(this.paras.indexOf("?")>-1){
                action = action+"&"+this.paras;
            }
            else {
                action = action+"?"+this.paras;
            }
        }
        //sbPaging.append("每页显示&nbsp;<i class=\"blue\">"+this.pageSize+"&nbsp;</i>笔记录</div>");
        sbPaging.append("<ul class=\"paginList\">");
        sbPaging.append("<li class=\"paginItem\"><a href=\"javascript:;\"><span class=\"pagepre\"></span></a></li>");
        for (int i =1; i <= this.pageCount;i++){
            if(i==this.page){
                sbPaging.append("<li class=\"paginItem current\"><a href=\""+action+"\">"+ i +"</a></li>");
            }
            else{
                sbPaging.append("<li class=\"paginItem\"><a href=\"\"+action+\"\">"+ i +"</a></li>");
            }
        }
       /* sbPaging.append("<li class=\"paginItem\"><a href=\"javascript:;\">1</a></li>");
        sbPaging.append("<li class=\"paginItem current\"><a href=\"javascript:;\">2</a></li>");
        sbPaging.append("<li class=\"paginItem\"><a href=\"javascript:;\">3</a></li>");
        sbPaging.append("<li class=\"paginItem\"><a href=\"javascript:;\">4</a></li>");
        sbPaging.append("<li class=\"paginItem\"><a href=\"javascript:;\">5</a></li>");*/
        sbPaging.append("<li class=\"paginItem more\"><a href=\"javascript:;\">...</a></li>");
        sbPaging.append("<li class=\"paginItem\"><a href=\"javascript:;\">10</a></li>");
        sbPaging.append("<li class=\"paginItem\"><a href=\"javascript:;\"><span class=\"pagenxt\"></span></a></li>");
        sbPaging.append("</div>");
        out.print(sbPaging.toString());
        super.doTag();
    }
}
