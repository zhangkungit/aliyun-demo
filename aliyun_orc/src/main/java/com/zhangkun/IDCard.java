package com.zhangkun;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.commons.codec.binary.Base64;
import org.json.JSONObject;
import org.json.JSONArray;
import org.json.JSONException;

/**
 * Created by zk on 2017/7/19.
 */
public class IDCard {
    /*
     * 获取参数的json对象
     */
    public static JSONObject getParam(int type, JSONObject dataValue) {
        JSONObject obj = new JSONObject();
        try {
            obj.put("dataType", type);
            obj.put("dataValue", dataValue);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return obj;
    }
    /*
     * 获取参数的json对象
     */
    public static JSONObject getParam(int type, String dataValue) {
        JSONObject obj = new JSONObject();
        try {
            obj.put("dataType", type);
            obj.put("dataValue", dataValue);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return obj;
    }
    public static void main(String[] args) {
        String imgFile = "idcard.jpg";
        String serviceURL = "your-service-url";
        String akID = "your access key id";
        String akSecret = "your access key secret";
        // 对图像进行base64编码
        String imgBase64 = "";
        try {
            File file = new File(imgFile);
            byte[] content = new byte[(int) file.length()];
            FileInputStream fileInputStream = new FileInputStream(file);
            fileInputStream.read(content);
            fileInputStream.close();
            imgBase64 = new String(Base64.encodeBase64(content));
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
        // 拼装请求body的json字符串
        JSONObject requestObj = new JSONObject();
        try {
            JSONObject configObj = new JSONObject();
            JSONObject obj = new JSONObject();
            JSONArray inputArray = new JSONArray();
//            ???????????????
//            configObj.put("side", configStr);
            configObj.put("side", "");
            obj.put("image", getParam(50, imgBase64));
            obj.put("configure", getParam(50, configObj.toString()));
            inputArray.put(obj);
            requestObj.put("inputs", inputArray);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        String body = requestObj.toString();
        //Sender代码参考 https://help.aliyun.com/document_detail/shujia/OCR/ocr-api/sender.html
        String result = Sender.sendPost(serviceURL, body, akID, akSecret);
        System.out.println(result);
        // 解析请求结果
        try {
            JSONObject resultObj = new JSONObject(result);
            JSONArray outputArray = resultObj.getJSONArray("outputs");
            String output = outputArray.getJSONObject(0).getJSONObject("outputValue").getString("dataValue"); // 取出结果json字符串
            JSONObject out = new JSONObject(output);
            if (out.getBoolean("success")) {
                String addr = out.getString("address"); // 获取地址
                String name = out.getString("name"); // 获取名字
                String num = out.getString("num"); // 获取身份证号
                System.out.printf(" name : %s \n num : %s\n address : %s\n", name, num, addr);
            } else {
                System.out.println("predict error");
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
