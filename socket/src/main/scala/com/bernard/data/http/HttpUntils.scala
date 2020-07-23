package com.bernard.data.http


import com.alibaba.fastjson.JSON
import scalaj.http.Http


object HttpUntils {
  def main(args: Array[String]): Unit = {
    val url = "http://openapi.yoyi.com.cn/openapi/v1/campaign/listAllCampaign"
    val body = "{\"userName\":\"adplus@yoyi.com.cn\",\"passWord\":\"Z4IaFHLHMPUQ2018\",\"systemId\":\"1\"}"
    val head = Map(
      //  "token" -> "13814O87nM48014339O9T03x735zN0gOLP08",
      "Content-Type" -> "application/json; charset=UTF-8",
      "Accept" -> "application/json; charset=UTF-8"
    )
    val url1 = "http://nms9.data.yoyi:8088/ws/v1/cluster/apps"
    val str = getOrigin(url1)
    val nObject = JSON.parseObject(str)
    val apps = nObject.getJSONObject("apps").getJSONArray("app")
    for (i <- 0 until apps.size()) {
      val app = apps.getJSONObject(i)
      val finalStatus = app.getString("finalStatus")
      val id = app.getString("id")
      val state = app.getString("state")
      val elapsedTime = app.getLong("elapsedTime")
      val applicationType = app.getString("applicationType")
      if ("RUNNING".equals(state)){
        if ((elapsedTime/3600000)>6){

           // postHead(url,"")
        }
      }
    }
  }

  def postHead(url: String, header: Map[String, String], body: String) = {
    val request = Http(url)
    for ((key, value) <- header) {
      request.header(key, value)
    }
    request.postData(body.getBytes).asString
  }

  //从接口拿取数据,通过get的方式
  def get(url: String, header: Map[String, String]) = {
    val request = Http(url)
    for ((key, value) <- header) {
      request.header(key, value)
    }
    request.asString
  }

  //从接口拿取数据,通过get的方式
  def getOrigin(url: String) = {
    val request = Http(url).asString
    request.body
  }
}
