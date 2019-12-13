package com.wzk.utiliy;

import com.alibaba.fastjson.JSONObject;
import com.tencentcloudapi.common.Credential;
import com.tencentcloudapi.common.profile.ClientProfile;
import com.tencentcloudapi.common.profile.HttpProfile;
import com.tencentcloudapi.common.exception.TencentCloudSDKException;

import com.tencentcloudapi.sms.v20190711.SmsClient;

import com.tencentcloudapi.sms.v20190711.models.SendSmsRequest;
import com.tencentcloudapi.sms.v20190711.models.SendSmsResponse;

import java.util.List;

/**
 * @program: ssm_MultipleDataSources_demo
 * @author: DANRAN2333
 * @create: 2019-12-06 21:43
 * @description:腾讯云发送短信工具类
 */
public class SendSmsUtiliy {

    //密钥ID
    private static final String SecretId = "";
    //密钥key
    private static final String SecretKey = "";
    //地区代码
    private static final String Region = "";
    //短信模板ID
    private static final String TemplateID = "";
    //短信SDKAPPId
    private static final String SmsSdkAppid = "";
    //短信签名
    private static final String Sign = "";

    /**
     * PhoneNumberSet发给手机号的List<String>集合，
     * TemplateParamSet短信模板中的参数List<String>集合
     * 该方法用于对腾讯云短信API的调用
     *
     * @Param: [PhoneNumberSet, TemplateParamSet]
     * @return: java.lang.String
     * @Author: DANRAN2333
     * @Date: 2019/12/6 21:56
     */
    public String sendSms(List<String> PhoneNumberSet, List<String> TemplateParamSet) {
        String s="";
        try {

            Credential cred = new Credential(SecretId, SecretKey);

            HttpProfile httpProfile = new HttpProfile();
            httpProfile.setEndpoint("sms.tencentcloudapi.com");

            ClientProfile clientProfile = new ClientProfile();
            clientProfile.setHttpProfile(httpProfile);

            SmsClient client = new SmsClient(cred, Region, clientProfile);

            String params = "{\"PhoneNumberSet\":" +
                    JSONObject.toJSONString(PhoneNumberSet) +
                    ",\"TemplateID\":\""+TemplateID+"\",\"Sign\":\""+Sign+"\",\"TemplateParamSet\":"
                    + JSONObject.toJSONString(TemplateParamSet) + ",\"SmsSdkAppid\":\""+SmsSdkAppid+"\"}";
            SendSmsRequest req = SendSmsRequest.fromJsonString(params, SendSmsRequest.class);

            SendSmsResponse resp = client.SendSms(req);

            s=SendSmsRequest.toJsonString(resp);
        } catch (TencentCloudSDKException e) {
            System.out.println(e.toString());
        }
        return s;
    }

}
