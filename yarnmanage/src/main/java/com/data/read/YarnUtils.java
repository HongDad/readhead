package com.data.read;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

public class YarnUtils {

    private static final String YarnUri = "http://nms9.data.yoyi:8088";
    private static final String FETCH_Application = "/cluster/apps";
    //private static final Logger LOGGER = LoggerFactory.getLogger(YarnUtils.class);

    private static String readAll(Reader rd) throws IOException {
        StringBuilder sb = new StringBuilder();
        int cp;
        while ((cp = rd.read()) != -1) {
            sb.append((char) cp);
        }
        return sb.toString();
    }

    public static JSONObject readJsonFromUrl(String url) throws IOException, JSONException {
        InputStream is = new URL(url).openStream();
        try {
            BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
            String jsonText = readAll(rd);
            System.out.println("----------------------");
            System.out.println(jsonText);
            JSONObject ss = JSONObject.parseObject(jsonText);
            JSONObject json = new JSONObject(ss);
            return json;
        } finally {
            is.close();
        }
    }


    /**
     * 查看job信息
     *
     * @return
     * @throws IOException
     * @throws JSONException
     */
    public static List<YarnApplication> fetchApp() throws IOException, JSONException {
        ArrayList<YarnApplication> list = new ArrayList<>();
        JSONObject json = readJsonFromUrl(YarnUri + FETCH_Application);
        System.out.println(json.toString());
        if (json.toString().equals("{\"apps\":null}")) {
            //LOGGER.error("无job信息,请检查yarn页面");
            System.out.println("无job信息,请检查yarn页面");
            System.exit(1);
        }
        JSONObject apps = json.getJSONObject("apps");
        JSONArray app = apps.getJSONArray("app");
        for (int i = 0; app.size() > i; i++) {
            JSONObject info = app.getJSONObject(i);
            YarnApplication yarnApplication = new YarnApplication();
            yarnApplication.setId(info.getString("id"));
            yarnApplication.setUser(info.getString("user"));
            yarnApplication.setName(info.getString("name"));
            yarnApplication.setApplicationType(info.getString("applicationType"));
            yarnApplication.setStartedTime(info.getLong("startedTime"));
            yarnApplication.setStartedTime(info.getLong("AllocatedCPUVCores"));
            yarnApplication.setStartedTime(info.getLong("AllocatedMemoryMB"));
            list.add(yarnApplication);
        }

        return list;
    }
}
