package christine.ilovezappos;


import java.util.Observable;

/**
 * Class that holds the information of a product
 */
public class Product {
    private transient String originalTerm;
    private transient String currentResultCount;
    private transient String totalResultsCount;
    private transient String term;
    private String brandName;
    private String thumbnailImageUrl;
    private String productId;
    private String originalPrice;
    private String styleId;
    private String colorId;
    private String price;
    private String percentOff;
    private String productUrl;
    private String productName;

    public String getBrandName() {return brandName;}

    public String getThumbnailImageUrl() {return thumbnailImageUrl; }

    public String getProductId() {
        return productId;
    }

    public String getOriginalPrice() {
        return originalPrice;
    }

    public String getStyleId() {
        return styleId;
    }

    public String getColorId() {
        return colorId;
    }

    public String getPrice() {
        return price;
    }

    public String getPercentOff() {
        return percentOff;
    }

    public String getProductUrl() {
        return productUrl;
    }

    public String getProductName() {return productName; }
}
