package net.wendal.nutzbook.service.collector.ruanyifeng;

import net.wendal.nutzbook.bean.yvr.Topic;
import net.wendal.nutzbook.bean.yvr.TopicType;
import net.wendal.nutzbook.service.collector.BaseCollector;
import net.wendal.nutzbook.service.collector.ICollector;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.nutz.json.Json;
import org.nutz.mapl.Mapl;

import java.util.ArrayList;
import java.util.List;

/**
 * 阮一峰博客采集<br>
 *     采集地址地址：http://www.schoolmate.help/yvr/collect/ruanyifeng|2016-04
 *     已经采集到：2016-04
 * </p> Copyright by easecredit.com<br>
 * 作者: zhangtao <br>
 * 创建日期: 16-5-8<br>
 */
public class RuanyifengCollector extends BaseCollector implements ICollector {
    String contentStart = "转载自：阮一峰的网络日志";
    public static  void main(String[] args){

        for(int i=2013;i>2002;i--){
            for(int j=1;j<=12;j++){
                String month = j+"";
                if(j<10){
                    month = "0"+j;
                }
                String url = "http://www.schoolmate.help/yvr/collect/ruanyifeng|"+i+"-"+month;
                new RuanyifengCollector().get(url);
                System.out.println(url);
            }
        }
    }
    private  String year,month;
    public RuanyifengCollector(){

    }
    public RuanyifengCollector(String year,String month){
        this.year = year;
        this.month = month;
    }
    @Override
    public List<Topic> collect() {
        String url = "http://www.ruanyifeng.com/blog/"+year+"/"+month+"/";
        Document document = get(url);
        Element element = document.getElementsByClass("module-list").get(0);
        Elements elements = element.getElementsByTag("a");
        List<Topic> result = new ArrayList<Topic>();
        for(Element article:elements){
            String title = article.text();
            String articleUrl = article.attr("href");
//        logger.info("title:{}，url:{}", title, articleUrl);
            Topic topic = collectOne(title,articleUrl);
            result.add(topic);
        }
        return result;
    }
    private Topic collectOne(String title,String url){
        Document document = get(url);
        String html = document.getElementById("main-content").html();
        Topic topic = new Topic();
        String content = contentStart+
                "原文地址:<a href=\""+url+"\">"+url+"</a>"
                +html;
        topic.setContent(content);
        topic.setUserId(16);
        topic.setTitle(title);
        topic.setType(TopicType.share);
        return topic;
    }
}
