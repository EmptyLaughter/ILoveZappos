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
