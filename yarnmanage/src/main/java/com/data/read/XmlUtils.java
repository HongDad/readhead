package com.data.read;

import com.alibaba.fastjson.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class XmlUtils {
    private static String url = "http://nms9.data.yoyi:8088/cluster/apps";

    public static void main(String[] args) throws IOException {
        Document doc = Jsoup.connect(url).get();
        for (org.jsoup.nodes.Element table : doc.select("table")) {
            for (Element row : table.select("script")) {
                JSONObject jsonObject = new JSONObject();
                String datas = row.data();
                String[] split = datas.split("],");
                for (String data : split) {
                    String[] tds = data.split(",");
                    String applicationName = tds[0].split(">")[1].split("<")[0];
                    String User = tds[1];
                    String name = tds[2];
                    String applicationType = tds[3];
                    String queue = tds[4];
                    String applicationPrioity = tds[5];
                    String startTime = tds[6];
                    String launchTime = tds[7];
                    String finishTIME = tds[8];
                    String status = tds[9];
                    String finalStatus = tds[10];
                    jsonObject.put("applicationName", applicationName);
                    jsonObject.put("User", User);
                    jsonObject.put("name", name);
                    jsonObject.put("applicationType", applicationType);
                    jsonObject.put("queue", queue);
                    jsonObject.put("applicationPrioity", applicationPrioity);
                    jsonObject.put("startTime", startTime);
                    jsonObject.put("launchTime", launchTime);
                    jsonObject.put("finishTIME", finishTIME);
                    jsonObject.put("status", status);
                    jsonObject.put("finalStatus", finalStatus);
                    System.out.println(jsonObject.toJSONString());
                }
            }
        }
    }
}