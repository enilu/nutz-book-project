package net.wendal.nutzbook.service.collector;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.nutz.http.Http;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * class BaseCollector<br>
 * </p> Copyright by easecredit.com<br>
 * 作者: zhangtao <br>
 * 创建日期: 16-5-8<br>
 */
public class BaseCollector {
    protected Logger logger = LoggerFactory.getLogger(getClass());
    private Integer userId = 16;//社区机器人
    protected Document get(String url,String encode ){
        Http.encode(encode);
        String html = Http.get(url).getContent(encode);
        Document document = Jsoup.parse(html);
        return document;
    }
    protected Document get(String url ){

       return get(url,"utf8");
    }

}
