package net.wendal.nutzbook.service.collector.weixin.caoz;

import net.wendal.nutzbook.bean.yvr.Topic;
import net.wendal.nutzbook.service.collector.BaseCollector;
import net.wendal.nutzbook.service.collector.ICollector;
import org.jsoup.nodes.Document;

import java.util.List;

/**
 * class CaozCollector<br>
 * </p> Copyright by easecredit.com<br>
 * 作者: zhangtao <br>
 * 创建日期: 16-5-8<br>
 */
public class CaozCollector extends BaseCollector implements ICollector {
    @Override
    public List<Topic> collect() {
        String url = "http://mp.weixin.qq.com/profile?src=3&timestamp=1462719547&ver=1&signature=9fsskkvIyh5BuoNcP1ksIT5TfoZ-s9zm0fZs0Rn97eGuvG8oD4hlfpis26dqJ1rlFV9b3VZaTbOF8F6JUe6Rhg==";
        Document document = get(url);

        return null;
    }
}
