package classwork.day18;

import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.classic.methods.HttpPost;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClientBuilder;
import org.apache.hc.core5.http.ParseException;
import org.apache.hc.core5.http.io.entity.EntityUtils;
import org.apache.hc.core5.http.io.entity.StringEntity;
import org.apache.hc.core5.net.URIBuilder;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpResponse;

public class MyHttpClient {

    public static void main(String[] args) throws URISyntaxException, IOException, ParseException {
        MyHttpClient myHttpClient = new MyHttpClient();
        //myHttpClient.httpGet();
        myHttpClient.search(new Search("a", true));


    }
    public void httpGet() throws URISyntaxException, IOException, ParseException {

        CloseableHttpClient client = HttpClientBuilder.create().build();
        URIBuilder builder = new URIBuilder("https://api.chucknorris.io/jokes/random");
        HttpGet request = new HttpGet(builder.build());
        CloseableHttpResponse httpResponse = (client).execute(request);
        System.out.println(EntityUtils.toString((httpResponse).getEntity()));
    }

    public void search(Search search) throws IOException, URISyntaxException, ParseException {
        CloseableHttpClient client = HttpClientBuilder.create().build();
        URIBuilder builder = new URIBuilder("http://178.124.206.46:8001/app/ws/");
        HttpPost request = new HttpPost(builder.build());
        request.setEntity(new StringEntity(new MyParser().fromGSON(search)));
        CloseableHttpResponse response = ((CloseableHttpClient) client).execute(request);
        System.out.println(EntityUtils.toString(((CloseableHttpResponse) response).getEntity()));

    }

}
