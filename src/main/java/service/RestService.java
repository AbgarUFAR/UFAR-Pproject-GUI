package service;

import static org.apache.http.HttpHeaders.ACCEPT;
import static org.apache.http.HttpHeaders.CONTENT_TYPE;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import utility.Pair;

public class RestService {

    private static final String BASE_URL = "http://localhost:8080/api/";

    public static Pair<Integer, String> sendPostRequest(String endpoint, String jsonBody) {
        final CloseableHttpClient httpClient = HttpClients.createDefault();
        final var httpPost = new HttpPost(BASE_URL + endpoint);
        try {
            final var entity = new StringEntity(jsonBody);
            httpPost.setEntity(entity);
            httpPost.setHeader(ACCEPT, "application/json");
            httpPost.setHeader(CONTENT_TYPE, "application/json");
            final CloseableHttpResponse response = httpClient.execute(httpPost);

            final int statusCode = response.getStatusLine().getStatusCode();
            final String responseBody = EntityUtils.toString(response.getEntity(), StandardCharsets.UTF_8);
            System.out.println("POST request to " + endpoint);
            System.out.println("status code = " + statusCode);
            System.out.println("response body = " + responseBody);
            return Pair.of(statusCode, responseBody);
        } catch (UnsupportedEncodingException e) {
            System.err.println("json body to entity failed");
            e.printStackTrace();
        } catch (IOException e) {
            System.err.println("http client execute failed");
            e.printStackTrace();
        }
        return null;
    }
}
