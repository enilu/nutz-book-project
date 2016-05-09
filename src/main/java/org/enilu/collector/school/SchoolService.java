package org.enilu.collector.school;

import org.apache.commons.dbutils.DbUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.nutz.http.Http;
import org.parboiled.common.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

/**
 * class SchoolService<br>
 * </p> Copyright by easecredit.com<br>
 * 作者: zhangtao <br>
 * 创建日期: 16-5-8<br>
 */
public class SchoolService {
    private Logger logger = LoggerFactory.getLogger(SchoolService.class);
    public static  void main(String[] args) throws Exception {
        new SchoolService().collect();
    }
     Map<String,String> provinceMap = new HashMap<String,String>();
    Map<String,String> school = new HashMap<String,String>();
    public void collect()throws Exception{
       String txt = FileUtils.readAllText(new File("/home/public/province"), Charset.forName("UTF8"));
        String[] txtArr = txt.split("#");
        for(String tmp:txtArr){
            try {
                String[] tmp2 = tmp.split("-");
                System.out.println(tmp2[1].trim()+","+tmp2[0].trim());
                provinceMap.put(tmp2[1].trim(), tmp2[0].trim());
            }catch (Exception e){

            }
        }
        System.exit(-1);
        String url  = "http://www.huaue.com/gx01.htm";
        Elements elements = get(url).getElementById("table1").getElementsByTag("a");
        for(Element element:elements){
            String jiancheng = element.text().trim();
          colletOne(element.attr("href"),jiancheng);
//            break;
        }
    }
    public void colletOne(String url,String jiancheng){
        String province = provinceMap.get(jiancheng);
//        logger.info("url:{}",url);
        Document document = get(url);
        Elements elements = document.getElementsByClass("FONT");

        for(Element element:elements){

            String str = element.html();
            String[] strArr = str.split("<br>");
            for(int i=1;i<strArr.length;i++){
//                INSERT INTO `t_school` VALUES ('1', '北京大学', 'http://www.pku.edu.cn/', null, '北京');
                StringBuilder result = new StringBuilder();
                String tmp = strArr[i];
                Document oneSchool  =Jsoup.parse(tmp);
                Elements hrefs = oneSchool.getElementsByTag("a");
                try {
//                    logger.info("province:{},学校：{}",province, hrefs.get(0).text());
                    String schoolName = hrefs.get(0).text().trim();
                    if(school.get(schoolName)!=null){
                        continue;
                    }
                    school.put(schoolName, schoolName);
                    result.append(province).append(",").append(schoolName);

                }catch (Exception e){
                    continue;
                }
                try {
                    String website = hrefs.get(1).attr("href");
                    if(!website.equals("")) {
                        result.append(",").append(website);
                    }else{
                        result.append(",").append("url");
                    }
//                    logger.info("url：{}", hrefs.get(1).attr("href"));
                }catch (Exception e){
                    result.append(",url");
                }
                System.out.println(result.toString());
            }
        }
    }

    private Document get(String url ){

        Http.encode("gb2312");
        String html = Http.get(url).getContent("gb2312");
        Document document = Jsoup.parse(html);
        return document;
    }
}
