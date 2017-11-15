package com.baidu.hi.ai.client;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.HashMap;

import javax.print.attribute.standard.OutputDeviceAssigned;

import org.json.JSONObject;

import com.baidu.aip.speech.AipSpeech;
import com.baidu.aip.speech.TtsResponse;

public class AipSpeechClient extends BaseClient{

    public static String test_16k = FILE_BASH_DIR + "16k_test.wav";
    public static String test_8k = FILE_BASH_DIR + "8k_test.pcm";

    public void asr(AipSpeech client){
        client.setConnectionTimeoutInMillis(2000);
        client.setSocketTimeoutInMillis(60000);

        JSONObject res = client.asr(test_8k, "pcm", 16000, null);
        System.out.println(res);
    }
    
    public void synthesis(AipSpeech client) throws Exception
    {

        // 设置可选参数
        HashMap<String, Object> options = new HashMap<String, Object>();
        options.put("spd", "5");
        options.put("pit", "5");
        options.put("per", "3");
        TtsResponse res1 = client.synthesis("李世民先生你好，你好帅！", "zh", 1, options);
        System.out.println(res1.getErrorCode());
        byte[] data = res1.getData();
        File file = new File(FILE_BASH_DIR + "out.wav");
        FileOutputStream fileOS = new FileOutputStream(file);
        fileOS.write(data);
        fileOS.close();
    }

    
    public static void main(String[] args) throws Exception {
        
        //初始化一个FaceClient
        AipSpeech client = new AipSpeech(APP_ID, API_KEY, SECRET_KEY);
        AipSpeechClient asClient = new AipSpeechClient();
        asClient.synthesis(client);
    }
    
}
