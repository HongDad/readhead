package com.bernard.data.http

import scalaj.http.Http

object HttpUntils {
  def main(args: Array[String]): Unit = {
    val url = "http://openapi.yoyi.com.cn/openapi/v1/campaign/listAllCampaign"
    val json = ""
    val response = Http(url)
      .header("token","13814O87nM48014339O9T03x735zN0gOLP08")
      .header("Content-Type","application/json; charset=UTF-8")
      .header("Accept","application/json; charset=UTF-8")
      .asString


    println(response.body)
  }
}
