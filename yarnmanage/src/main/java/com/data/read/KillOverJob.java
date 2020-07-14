package com.data.read;

import com.alibaba.fastjson.JSONException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.List;



public class KillOverJob {
    Logger logger=LoggerFactory.getLogger(KillOverJob.class);

    public static void main(String[] args) throws IOException, JSONException {


        //查询application的信息
        List<YarnApplication> list = YarnUtils.fetchApp();
        for (YarnApplication yarnApplication:list){
            System.out.println(yarnApplication.toString());
        }


    }

}
