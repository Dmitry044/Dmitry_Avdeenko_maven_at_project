package classwork.day18;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import org.apache.hc.client5.http.classic.methods.HttpPost;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClientBuilder;
import org.apache.hc.core5.http.io.entity.EntityUtils;
import org.apache.hc.core5.http.io.entity.StringEntity;
import org.apache.hc.core5.net.URIBuilder;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;


public class MyParser {

    private static final String JSON = "src/test/resources/recipe.json";

    public static void main(String[] args) throws IOException {
        MyParser myParser = new MyParser();
        myParser.parseGSON();

        MyParser myParser1 = new MyParser();
        myParser1.fromGSON();
    }

    public void parseGSON() throws IOException {
        Gson gson = new Gson();
        Recipe recipe = gson.fromJson(new JsonReader(new FileReader(JSON)), Recipe.class);
        System.out.println(recipe.getIngredlist());
        System.out.println(recipe.getPreptime());
        System.out.println(recipe.getRecipename());
    }

    public void fromGSON() {
        Gson gson = new Gson();
        List<Ingredient> ingredientList = new ArrayList<>();
        ingredientList.add(new Ingredient("makaroni", 5));
        ingredientList.add(new Ingredient("grechka", 6));
        ingredientList.add(new Ingredient("rice", 9));
        ingredientList.add(new Ingredient("manka", 55));
        Recipe recipe = new Recipe("Borsch", ingredientList, 120);
        System.out.println(gson.toJson(recipe));
    }

    public static String fromGSON (Search search) {
        Gson gson = new Gson ();
        return gson.toJson (search);
    }




}
