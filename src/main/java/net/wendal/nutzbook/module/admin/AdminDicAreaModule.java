package net.wendal.nutzbook.module.admin;

import net.wendal.nutzbook.page.Pagination;
import net.wendal.nutzbook.service.system.DicAreaService;
import net.wendal.nutzbook.service.system.SchoolService;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.mvc.annotation.At;
import org.nutz.mvc.annotation.Ok;
import org.nutz.mvc.annotation.Param;

/**
 * 地区管理<br>
 * </p> Copyright by easecredit.com<br>
 * 作者: zhangtao <br>
 * 创建日期: 16-5-8<br>
 */
@At("/admin/dic/area")
@IocBean
public class AdminDicAreaModule {

    @Inject
    private DicAreaService  dicAreaService;

    @At("/list")
    @Ok("fm:templates.admin.dic.list")
    @RequiresPermissions(value = { "school:view", "school:update" }, logical = Logical.OR)
    public Pagination list(@Param(value = "pageNumber", df = "1") int pageNumber) {
        return dicAreaService.getListByPager(pageNumber);
    }

}
