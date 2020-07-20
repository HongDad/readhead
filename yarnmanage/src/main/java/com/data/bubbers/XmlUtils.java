package com.data.bubbers;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;


public class XmlUtils {
    private static String url = "http://zp-dp-hadoop-rm:8088/cluster/apps/RUNNING";
   // private static Logger logger = LoggerFactory.getLogger(XmlUtils.class);
    private static String isKill = null;
    private static String hour = null;

    public static void main(String[] args) throws IOException {

        //传入要判断的小时数
        // String hour = System.getProperty("hour");
        //String command = System.getProperty("command");
        //获取页面
        if (args.length > 0) {
            hour = args[0];
        }
        Document doc = Jsoup.connect(url).get();
        //爬取页面数据
        for (Element table : doc.select("table")) {
            int count = 0;
            //拿到所有运行的任务
            for (Element row : table.select("script")) {
                String datas = row.data();
                String[] split = datas.split("],");
               // logger.info("总共有" + split.length + "条正在运行的数据！");
                System.out.println("总共有" + split.length + "条正在运行的数据！");

                for (String data : split) {
                    YarnApplication ya = null;
                    String[] tds = data.split(",");
                    String applicationName = tds[0].split(">")[1].split("<")[0];
                    String User = tds[1];
                    String name = tds[2];
                    String applicationType = tds[3];
                    String startTime = tds[5];
                    String status = tds[7];
                    String AllocatedCPUVCores = tds[10];
                    String AllocatedMemoryMB = tds[11];
                    String tt = startTime.replace("\"", "");
                    //获取当前时间
                    long time = System.currentTimeMillis();
                    //拿到类型为MAPREDUCE和时间超过传入参数的任务
                    if ("\"MAPREDUCE\"".equals(applicationType) && (time - Long.parseLong(tt) >= Long.parseLong(hour) * 3600 * 1000)) {
                        ya = new YarnApplication(applicationName, User, name, applicationType, startTime, status, AllocatedCPUVCores, AllocatedMemoryMB);
                        count++;
                        //logger.info(">" + hour + "小时的数据：" + ya);
                        System.out.println(">" + hour + "小时的数据：" + ya);
                        if (args.length > 1) {

                            isKill = args[1];
                            if ("list".equals(isKill)) {

                                //运行linux 命令，kill这个任务:yarn application -kill

                               //测试的时候用这个 String puid = "yarn application -status " + applicationName.replace("\"", "");
                                String puid = "yarn application -kill application_1593774144661_382344";
                                //logger.info(puid);
                                System.out.println(puid);
                                String[] cmdArray = new String[]{puid};
                                Process exec = Runtime.getRuntime().exec(puid);


                            }
                        }
                    }
                }
                //logger.info("共有" + count + "条超过" + hour + "小时的数据！");
                System.out.println("共有" + count + "条超过" + hour + "小时的数据！");
            }
            return;
        }
    }
}