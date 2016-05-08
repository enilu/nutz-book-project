package net.wendal.nutzbook.service;

import net.wendal.nutzbook.bean.School;
import net.wendal.nutzbook.page.Pagination;
import org.nutz.dao.pager.Pager;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.service.IdNameEntityService;

import java.util.List;

/**
 * class SchoolService<br>
 * </p> Copyright by easecredit.com<br>
 * 作者: zhangtao <br>
 * 创建日期: 16-5-2<br>
 */
@IocBean(fields = "dao")
public class SchoolService extends IdNameEntityService<School> {
    public Pagination getListByPager(int pageNumber) {
        Pager pager = dao().createPager(pageNumber, 20);
        List<School> list = dao().query(getEntityClass(), null, pager);
        pager.setRecordCount(dao().count(getEntityClass(), null));
        return new Pagination(pageNumber, 20, pager.getRecordCount(), list);
    }
}
