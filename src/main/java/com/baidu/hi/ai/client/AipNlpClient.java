package com.baidu.hi.ai.client;

import java.util.HashMap;

import org.json.JSONObject;

import com.baidu.aip.nlp.AipNlp;
import com.baidu.aip.nlp.ESimnetType;

public class AipNlpClient extends BaseClient {

    public static void main(String[] args) {
        // 初始化一个NLPClient
        AipNlp client = new AipNlp(APP_ID, API_KEY, SECRET_KEY);

        // 可选：设置网络连接参数
        client.setConnectionTimeoutInMillis(2000);
        client.setSocketTimeoutInMillis(60000);
        AipNlpClient anClient = new AipNlpClient();
        // anClient.NLPLexer(client);
        // anClient.wordpos(client);
//        anClient.NLPCommentTag(client);
        anClient.simnet(client);
    }

    public void NLPLexer(AipNlp client) {

        String text = "百度是一家高科技公司";
        JSONObject response = client.lexer(text);
        System.out.println(response.toString());
    }

    // 词性标注
    public void wordpos(AipNlp client) {
        // 获取一个词的词向量
        JSONObject response = client.wordpos("百度");
        System.out.println(response.toString());
    }

    public void NLPCommentTag(AipNlp client) {

        // 获取美食评论情感属性
        JSONObject response = client.commentTag("这家餐馆呵呵哒", ESimnetType.FOOD);
        System.out.println(response.toString());

        // 获取酒店评论情感属性
        JSONObject response1 = client.commentTag("喜来登酒店不错", ESimnetType.HOTEL);
        System.out.println(response1.toString());
    }

    public void simnet(AipNlp client) {

        // 获取两个文本的相似度
        JSONObject response = client.simnet("百度是个搜索公司", "谷歌是个搜索公司", null);
        System.out.println(response.toString());

        // 选择CNN算法
        HashMap<String, String> options = new HashMap<String, String>();
        options.put("model", "CNN");
        JSONObject response1 = client.simnet("联通是一家AI公司", "谷歌是个搜索公司", options);
        System.out.println(response1.toString());
    }
    
}
