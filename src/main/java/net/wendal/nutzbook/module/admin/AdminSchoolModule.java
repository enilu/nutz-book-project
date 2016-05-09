package net.wendal.nutzbook.module.admin;

import net.wendal.nutzbook.page.Pagination;
import net.wendal.nutzbook.service.system.SchoolService;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.mvc.annotation.At;
import org.nutz.mvc.annotation.Ok;
import org.nutz.mvc.annotation.Param;

@At("/admin/dic/school")
@IocBean
/**
 * 基础数据管理
 */
public class AdminSchoolModule {

	@Inject
	private SchoolService schoolService;

	@At("/list")
	@Ok("fm:templates.admin.dic.list")
	@RequiresPermissions(value = { "school:view", "school:update" }, logical = Logical.OR)
	public Pagination list(@Param(value = "pageNumber", df = "1") int pageNumber) {
		return schoolService.getListByPager(pageNumber);
	}

}
