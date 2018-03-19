package christine.ilovezappos;

import android.os.AsyncTask;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

/**
 * Class that searches for a product using the Zappos api
 * Runs in the background because it's performing a networking operation
 * Async takes 3 types: <Params, Progress, Result>
 */

public class ProductFetch extends AsyncTask<String, Void, List<Product>> {
    private static final String ZAPPOS_API = "https://api.zappos.com/Search?";
    private static final String KEY = "some_random_api_key";

    /**
     * Obtains data for a product page by creating an http connection to send a search query,
     * receiving a response as a JSON object, and deserializing the JSON object
     * @param term Array of Strings; the query will be the first element
     * @return results List of Product objects
     */
    public List<Product> doInBackground(String... term) {
        String searchQuery = term[0];
        String search = ZAPPOS_API + "term=" + searchQuery + "&key=" + KEY;
        try {
            URL url = new URL(search);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));

            StringBuffer json = new StringBuffer();
            String response = "";
            while((response = reader.readLine()) != null) {
                json.append(response);
            }

            String jsonString = json.toString();
            Results results = parseJSON(jsonString);

            reader.close();
            return results.getProducts();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Helper method to deserialize JSON object
     * @param jsonString JSON String
     * @return results Results object
     */
    public Results parseJSON(String jsonString) {
        Gson gson = new GsonBuilder().create();
        Results results = gson.fromJson(jsonString, Results.class);
        return results;
    }

}
