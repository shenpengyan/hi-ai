package com.baidu.hi.ai.client;

import java.util.Arrays;
import java.util.HashMap;

import org.json.JSONObject;

import com.baidu.aip.imagecensor.AipImageCensor;
import com.baidu.aip.imagecensor.EImgType;

public class AipAntipornClient extends BaseClient {

    public static void main(String[] args) {
        // 初始化一个AntipornClient
        AipImageCensor client = new AipImageCensor(APP_ID, API_KEY, SECRET_KEY);

        // 可选：设置网络连接参数
        client.setConnectionTimeoutInMillis(2000);
        client.setSocketTimeoutInMillis(60000);

        AipAntipornClient aapClient = new AipAntipornClient();
        
        aapClient.antiPorn(client);
        aapClient.antiGifPorn(client);
        aapClient.faceAudit(client);
    }

    public void antiPorn(AipImageCensor client) {
        // 参数为本地图片路径
        String imagePath = FILE_BASH_DIR + "porn.jpeg";
        JSONObject response = client.antiPorn(imagePath);
        System.out.println(response.toString());
    }

    public void antiGifPorn(AipImageCensor client) {
        // 参数为本地图片路径
        String imagePath = FILE_BASH_DIR + "gif_porn.gif";
        JSONObject response = client.antiPornGif(imagePath);
        System.out.println(response.toString());
    }

    public void faceAudit(AipImageCensor client) {
        // 参数为本地图片路径
        String path1 = FILE_BASH_DIR + "porn.jpeg";
        String path2 = FILE_BASH_DIR + "fanbingbing1.jpeg";
        JSONObject response = client.faceAudit(Arrays.asList(path1, path2), EImgType.FILE, new HashMap<String, String>());
        System.out.println(response.toString());

    }
    
}
