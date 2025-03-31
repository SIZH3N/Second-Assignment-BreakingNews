package AP;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalDate;
import org.json.*;

public class Infrastructure {

    private final String URL;
    private final String APIKEY;
    private final String JSONRESULT;
    private ArrayList<News> newsList; // TODO: Create the News class


    public Infrastructure(String APIKEY) {
        this.APIKEY = APIKEY;
        this.URL = "https://newsapi.org/v2/everything?q=tesla&from=" + LocalDate.now().minusDays(1) + "&sortBy=publishedAt&apiKey=";
        this.JSONRESULT = getInformation();
        parseInformation();
    }

    public ArrayList<News> getNewsList() {
        return newsList;
    }

    private String getInformation() {
        try {
            HttpClient client = HttpClient.newHttpClient();

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(URL + APIKEY))
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            if (response.statusCode() == 200) {
                return response.body();
            } else {
                throw new IOException("HTTP error code: " + response.statusCode());
            }
        } catch (Exception e) {
            System.out.println("!!Exception : " + e.getMessage());
        }
        return null;
    }

    private void parseInformation() {

        JSONObject obj = new JSONObject(JSONRESULT);
        //newsList.clear();
        newsList = new ArrayList<News>();
        JSONArray jsonArray = obj.getJSONArray("articles");

        for (int i = 0; i < Math.min(jsonArray.length(), 20); i++) {
            newsList.add(new News());

            JSONObject s = jsonArray.getJSONObject(i);
            String title = s.optString("title");
            String author = s.optString("author");
            String description = s.optString("description");
            String url = s.optString("url");
            String publishedAt = s.optString("publishedAt");

            JSONObject srcName = s.optJSONObject("source");
            String sourceName = srcName.optString("name");
            newsList.get(i).setData(title, author, description, url, publishedAt, sourceName);
        }

        // TODO: Get the first 20 news from the articles array of the json result
        //  and parse the information of each on of them to be mapped to News class
        //  finally add them to newsList in this class to display them in the output

    }

    public void displayNewsList() {
        int counter = 1;
        for (News news : newsList) {
            System.out.println(counter + news.toString());
            counter++;
        }

        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        System.out.print("\nEnter the news number: ");

        int userName = myObj.nextInt();


        try {
            System.out.println("*********** News ***********" );
            newsList.get(userName - 1).displayNews();
        } catch (Exception e) {
            System.out.println("++++++++++++++ " + e.getMessage());
        }


        // TODO: Display titles of the news you got from api
        //  and print them in a way that user can choose one
        //  to see the full information of the news
    }

//    public static void main(String[] args) {
//        String api = "6e6beaec95014f8baf91954086c2a212";
//        Infrastructure iif = new Infrastructure(api);
//        iif.parseInformation();
//
//    }
}
