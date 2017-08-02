package asynchttpclient;


import org.asynchttpclient.AsyncHttpClient;
import org.asynchttpclient.AsyncHttpClientConfig;
import org.asynchttpclient.DefaultAsyncHttpClient;
import org.asynchttpclient.Response;

import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * @author zhangkun
 * @version 1.0
 * @date 2017/8/2
 * @description
 */
public class AsyncHttpClientTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException, IOException {
//        test1_9_8();
        test2_x_x();
    }

    private static void test2_x_x() throws ExecutionException, InterruptedException {
        AsyncHttpClient asyncHttpClient = new DefaultAsyncHttpClient();
        Future<Response> f = asyncHttpClient.prepareGet("http://www.baidu.com/").execute();
        Response response = f.get();
        System.out.println(response.getResponseBody());
    }

    /*private static void test1_9_8() throws ExecutionException, InterruptedException, IOException {
        AsyncHttpClientConfig.Builder builder = new AsyncHttpClientConfig.Builder();
        AsyncHttpClient asyncHttpClient = new AsyncHttpClient(builder.build());
        Future<Response> f = asyncHttpClient
                .prepareGet("http://localhost:8080/server/add")
                .addQueryParam("a", "1")
                .addQueryParam("b", "7")
                .execute();
        Response response = f.get();
        System.out.println(response.getResponseBody());
    }*/
}
