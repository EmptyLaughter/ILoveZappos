package christine.ilovezappos;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Product Page
 * Displays a product page for the first product of a search query
 */

public class ProductPage extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_productpage);

        Intent intent = getIntent();
        String brand = intent.getStringExtra("brand");
        String name = intent.getStringExtra("itemName");
        String imageUrl = intent.getStringExtra("imageUrl");
        String price = intent.getStringExtra("price");
        String itemUrl = intent.getStringExtra("itemUrl");

        int brandBoxID = R.id.brandBox;
        int nameBoxID = R.id.nameBox;
        int imageViewID = R.id.imageView;
        int priceBoxID = R.id.priceBox;
        int shareBoxID = R.id.shareBox;

        TextView brandBoxTV = (TextView) findViewById(brandBoxID);
        TextView nameBoxTV = (TextView) findViewById(nameBoxID);
        ImageView imageView = (ImageView) findViewById(imageViewID);
        TextView priceBoxTV = (TextView) findViewById(priceBoxID);
        TextView shareBoxTV = (TextView) findViewById(shareBoxID);

        brandBoxTV.setText(brand);
        nameBoxTV.setText(name);
        priceBoxTV.setText(price);
        shareBoxTV.append("\n");
        shareBoxTV.append(itemUrl);

        new ImageFetch(imageView).execute(imageUrl);
    }

    /**
     * Returns to search page
     * @param view View object
     */
    public void returnToMain(View view) {
        startActivity(new Intent(this, MainActivity.class));
    }

    /**
     * Animation effect for when a user chooses to add to cart
     * How to create "bounce" animation: http://evgenii.com/blog/spring-button-animation-on-android/
     * @param view View object
     */
    public void addToCart(View view) {
        int id = R.id.imageButton;
        ImageButton animatedCartButton = (ImageButton) findViewById(id);
        final Animation animation = AnimationUtils.loadAnimation(this, R.anim.inflate);
        animatedCartButton.startAnimation(animation);
    }
}
