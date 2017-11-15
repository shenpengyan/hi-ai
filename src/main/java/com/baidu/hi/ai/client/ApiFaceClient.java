package com.baidu.hi.ai.client;

import java.util.ArrayList;
import java.util.HashMap;

import org.json.JSONObject;

import com.baidu.aip.face.AipFace;

public class ApiFaceClient extends BaseClient {

    public static String FANBINGBING1 = FILE_BASH_DIR + "fanbingbing1.jpeg";
    
    public static void main(String[] args) {
        // 初始化一个FaceClient
        AipFace client = new AipFace(APP_ID, API_KEY, SECRET_KEY);
        // 可选：设置网络连接参数
        client.setConnectionTimeoutInMillis(2000);
        client.setSocketTimeoutInMillis(60000);

        ApiFaceClient afClient = new ApiFaceClient();
//        afClient.faceRecognize(client);
        afClient.faceCompare(client);
    }

    // 人脸检测
    public void faceRecognize(AipFace client) {
        
        HashMap<String, String> options = new HashMap<String, String>();
        options.put("max_face_num", "1");
        options.put("face_fields", "expression");
        options.put("face_fields", "age");
        options.put("face_fields", "beauty");

        // 参数为本地图片路径
        JSONObject response = client.detect(FANBINGBING1, options);
        
        System.out.println(response.toString());

    }

    // 人脸比对
    public void faceCompare(AipFace client) {
        // 参数为本地图片路径
        String imagePath1 = FANBINGBING1;
        String imagePath2 = FANBINGBING1;
        ArrayList<String> pathArray = new ArrayList<String>();
        pathArray.add(imagePath1);
        pathArray.add(imagePath2);
        JSONObject response = client.match(pathArray, new HashMap<String, String>());
        System.out.println(response.toString());
    }

    
    
}
