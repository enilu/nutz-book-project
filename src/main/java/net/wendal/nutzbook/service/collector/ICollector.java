package net.wendal.nutzbook.service.collector;

import net.wendal.nutzbook.bean.yvr.Topic;

import java.util.List;

/**
 * 采集器接口<br>
 * </p> Copyright by easecredit.com<br>
 * 作者: zhangtao <br>
 * 创建日期: 16-5-8<br>
 */
public interface ICollector {
    /**
     * 采集数据
     * @return
     */
    public List<Topic> collect();
}
