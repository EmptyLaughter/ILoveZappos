package christine.ilovezappos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.EditText;
import java.util.List;

/**
 * Search page
 * Displays search screen
 */
public class MainActivity extends AppCompatActivity {
    String searchQuery;
    public String itemName;
    public String brand;
    public String imageUrl;
    public String price;
    public String itemUrl;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * Takes user query to create a product page
     * @param view View Object
     */
    public void search(View view) {
        //box for search query
        int id = R.id.searchBox;
        EditText searchBoxET = (EditText) findViewById(id);
        Editable searchBoxE = searchBoxET.getText();
        searchQuery = searchBoxE.toString();

        if(id != 0) {
            try {
                //waits for call to finish
                List<Product> fetch = new ProductFetch().execute(searchQuery).get();
                Product firstProduct = fetch.get(0);

                itemName = firstProduct.getProductName();
                brand = firstProduct.getBrandName();
                imageUrl = firstProduct.getThumbnailImageUrl();
                price = firstProduct.getPrice();
                itemUrl = firstProduct.getProductUrl();

                //product page
                Intent intent = new Intent(this, ProductPage.class);
                intent.putExtra("itemName", itemName);
                intent.putExtra("brand", brand);
                intent.putExtra("imageUrl", imageUrl);
                intent.putExtra("price", price);
                intent.putExtra("itemUrl", itemUrl);
                startActivity(intent);
            }
            catch(Exception e) {
                e.printStackTrace();
            }
        }
    }
}

/**
 * Resources:
 * https://code.tutsplus.com/tutorials/create-a-weather-app-on-android--cms-21587
 * http://stackoverflow.com/questions/1395551/convert-a-json-string-to-object-in-java-me
 * http://stackoverflow.com/questions/5554217/google-gson-deserialize-listclass-object-generic-type
 * http://guides.codepath.com/android/leveraging-the-gson-library#initializing-collections
 * https://www.mkyong.com/java/how-do-convert-java-object-to-from-json-format-gson-api/
 * https://developer.android.com/training/basics/firstapp/starting-activity.html
 * http://api.zappos.com/
 * http://stackoverflow.com/questions/5776851/load-image-from-url
 * http://stackoverflow.com/questions/10413659/how-to-resize-image-in-android
 * https://github.com/google/material-design-icons/blob/master/content/drawable-hdpi/ic_add_white_24dp.png
 */