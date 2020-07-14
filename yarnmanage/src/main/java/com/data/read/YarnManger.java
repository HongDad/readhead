//package com.data.read;
//
//import java.io.BufferedReader;
//
//import java.io.IOException;
//
//import java.io.InputStream;
//
//import java.io.InputStreamReader;
//
//import java.io.Reader;
//
//import java.net.URL;
//
//import java.nio.charset.Charset;
//
//import org.json.JSONArray;
//
//import org.json.JSONException;
//
//import org.json.JSONObject;
//
//
//public class YarnManger {
//    private static String readAll(Reader rd) throws IOException {
//
//   StringBuilder sb = new StringBuilder();
//
//   int cp;
//
//   while ((cp = rd.read()) != -1) {
//
//     sb.append((char) cp);
//
//   }
//
//   return sb.toString();
//
// }
//
//
//
// 
//
//    public static JSONObject readJsonFromUrl(String url) throws IOException, JSONException {
//
//   InputStream is = new URL(url).openStream();
//
//   try {
//
//     BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
//
//     String jsonText = readAll(rd);
//
//     JSONObject json = new JSONObject(jsonText);
//
//     return json;
//
//   } finally {
//
//     is.close();
//
//   }
//
// }
//
//
//
// 
//
//    public static void main(String[] args) throws IOException, JSONException {
//
//   JSONObject json = readJsonFromUrl("http://10.1.236.53:8088/ws/v1/cluster/apps");
//
//   System.out.println(json.toString());
//
//   JSONObject apps = json.getJSONObject("apps");
//
//   JSONArray app = apps.getJSONArray("app");
//
//   for (int i = 0; i < app.length(); i++) {
//
//   JSONObject info = app.getJSONObject(i);
//
//   String id = info.getString("id");
//
//   System.out.println("appid:" + id);
//
//   String user = info.getString("user");
//
//   System.out.println("user:" + user);
//
//   String name = info.getString("name");
//
//   System.out.println("job name:" + name);
//
//   String queue = info.getString("queue");
//
//   System.out.println("job queue:" + queue);
//
//   String state = info.getString("state");
//
//   System.out.println("job state:" + state);
//
//   String finalStatus = info.getString("finalStatus");
//
//   System.out.println("job finalStatus:" + finalStatus);
//
//   int progress = info.getInt("progress");
//
//   System.out.println("job progress:" + progress);
//
//   String applicationType = info.getString("applicationType");
//
//   System.out.println("job applicationType:" + applicationType);
//
//   long startedTime = info.getLong("startedTime");
//
//   System.out.println("job startedTime:" + startedTime);
//
//   long finishedTime = info.getLong("finishedTime");
//
//   System.out.println("job finishedTime:" + finishedTime);
//
//   long elapsedTime = info.getLong("elapsedTime");
//
//   System.out.println("job elapsedTime:" + elapsedTime);
//
//   
//            System.out.println("-------------------------------------------------------------------------------------------------------");
//
//   }
//
// }
//}
