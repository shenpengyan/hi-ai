package com.baidu.hi.ai.client;

import java.util.HashMap;

import org.json.JSONObject;

import com.baidu.aip.ocr.AipOcr;

public class AipOcrClient extends BaseClient {

    public static String IDCARD = FILE_BASH_DIR + "idcard.jpeg";
    public static String BANK_CARD = FILE_BASH_DIR + "bank_card.jpeg";

    public static void main(String[] args) {
        AipOcr client = new AipOcr(APP_ID, API_KEY, SECRET_KEY);

        client.setConnectionTimeoutInMillis(2000);
        client.setSocketTimeoutInMillis(60000);

        JSONObject idcardRes = client.idcard(IDCARD, true, new HashMap<String, String>());
        System.out.println(idcardRes.toString(2));

        // 调用银行卡识别接口
        JSONObject bankRes = client.bankcard(BANK_CARD);
        System.out.println(bankRes.toString(2));

        // 调用通用识别接口
        JSONObject genRes = client.basicGeneral(IDCARD, new HashMap<String, String>());
        System.out.println(genRes.toString(2));

        // 调用通用识别（含位置信息）接口
        JSONObject genRes2 = client.general(BANK_CARD, new HashMap<String, String>());
        System.out.println(genRes2.toString(2));

    }

}
