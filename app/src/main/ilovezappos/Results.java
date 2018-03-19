package christine.ilovezappos;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;

/**
 * Class that stores Product objects after a JSON object is deserialized
 */
public class Results {
    @SerializedName(("results"))
    private List<Product> products;

    public Results() {
        products = new ArrayList<Product>();
    }

    public List<Product> getProducts() {return products; }
}
