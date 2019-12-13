package com.wzk.utiliy;

import com.alibaba.fastjson.JSONObject;
import com.tencentcloudapi.common.Credential;
import com.tencentcloudapi.common.profile.ClientProfile;
import com.tencentcloudapi.common.profile.HttpProfile;
import com.tencentcloudapi.common.exception.TencentCloudSDKException;

import com.tencentcloudapi.sms.v20190711.SmsClient;

import com.tencentcloudapi.sms.v20190711.models.SendSmsRequest;
import com.tencentcloudapi.sms.v20190711.models.SendSmsResponse;

import java.util.LinkedList;
import java.util.List;

/**
 * @program: ssm_MultipleDataSources_demo
 * @author: DANRAN2333
 * @create: 2019-12-06 21:15
 * @description:
 */

public class SendSms {
    public static void main(String[] args) {

        List<String> list1 =new LinkedList<>();
        list1.add("");

        List<String> list2 =new LinkedList<>();
        list2.add("");
        System.out.println(JSONObject.toJSONString(list1)+JSONObject.toJSONString(list2));

        SendSmsUtiliy sendSmsUtiliy=new SendSmsUtiliy();
        System.out.println(sendSmsUtiliy.sendSms(list1,list2));

    }

}
