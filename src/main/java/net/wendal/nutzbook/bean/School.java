package net.wendal.nutzbook.bean;

import org.nutz.dao.entity.annotation.*;

/**
 * class School<br>
 * </p> Copyright by easecredit.com<br>
 * 作者: zhangtao <br>
 * 创建日期: 16-5-2<br>
 */
@Table("t_school")
public class School {

    @Id
    protected int id;
    @Name
    @Column
    @ColDefine(width=64)
    private String name;
    @Column
    @ColDefine(width=128)
    private String website;
    @Column
    private String logo ;
    @Column
    private String province;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }
}
