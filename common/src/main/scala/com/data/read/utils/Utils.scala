package com.data.read.utils

import java.io.File

import com.typesafe.config.{Config, ConfigFactory}


/**
 * @AUTHOR wdh
 * @time 2020-07-07
 * @define  基础工具类
 */
object Utils {

  private var _config: Option[Config] = None

  //得到配置文件
  def getConf(): Config = {
    var configFile: String = ""
    var devConfigFile = ""
    if (!this.Ismac()) { //线上环境
      configFile = "application.conf"
      devConfigFile = "application_dev.conf"
    } else { //本地环境
      configFile = "conf/application.conf"
      devConfigFile = "conf/application_dev.conf"
    }

    _config match {
      case Some(conf) => conf
      case None => {
        var config = ConfigFactory.load
        if (!this.Ismac()) {
          val customerConfig = ConfigFactory.parseFile(new File(configFile))
          config = customerConfig.withFallback(config)
        }
        val devConfig = ConfigFactory.parseFile(new File(devConfigFile))
        config = devConfig.withFallback(config)
        _config = Some(config)
        config
      }
    }
  }

  //判断电脑类别
  def Ismac(): Boolean = {
    if (System.getProperty("os.name").toLowerCase().startsWith("mac"))
      true
    else
      false
  }
}
