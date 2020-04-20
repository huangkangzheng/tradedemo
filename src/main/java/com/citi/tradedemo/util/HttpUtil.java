package com.citi.tradedemo.util;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HttpUtil {
    private static CloseableHttpClient httpClient = HttpClientBuilder.create().build();
    private static Logger logger = LoggerFactory.getLogger(HttpUtil.class);

    public static String doGet (String url) {
        String results = "";
        logger.info("url: " + url);
        try {
            HttpGet httpGet = new HttpGet(url);
            HttpResponse response = httpClient.execute(httpGet);
            HttpEntity entity = response.getEntity();
            results = EntityUtils.toString(entity);
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        return results;
    }
}
