package cc.yelcat.sisyphus.utils;

import okhttp3.*;

import java.io.IOException;
import java.util.Objects;

public class HttpUtil {
    private static final OkHttpClient httpClient = new OkHttpClient();


    public static String sendGet(String url, String param) throws  IOException {
        String result;
        String urlNameString = url + "?" + param;

        Request req = new Request.Builder().url(urlNameString).build();
        Response response = httpClient.newCall(req).execute();
        if (!response.isSuccessful())
        {
            throw new IOException("Unexpected code " + response);
        }
        result = Objects.requireNonNull(response.body()).string();

        return result;
    }

    public static String sendPost(String url, String jsonData) throws IOException {
        String result;
        RequestBody body = RequestBody
                .Companion
                .create(jsonData, MediaType.parse("application/json;charset=utf-8"));
        Request req = new Request
                    .Builder()
                    .url(url)
                    .header("Content-Type", "application/json")
                    .post(body)
                    .build();
        Response response = httpClient.newCall(req).execute();
        if (!response.isSuccessful())
        {
            throw new IOException("Unexpected code " + response);
        }
        result = Objects.requireNonNull(response.body()).string();

        return result;
    }

}
