package christine.ilovezappos;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;


/**
 * Class that loads an image from a URL
 * Runs in the background because it performs a networking operation
 * Async takes 3 types: <Params, Progress, Result>
 */

public class ImageFetch extends AsyncTask<String, Void, Bitmap> {
    ImageView bmImage;

    public ImageFetch(ImageView bmImage) {
        this.bmImage = bmImage;
    }

    /**
     * Extracts image from URL
     * @param urls Array of Strings; url will be the first element
     * @return image Bitmap object
     */
    public Bitmap doInBackground(String... urls) {
        String url = urls[0];
        Bitmap image = null;
        try {
            InputStream in = new java.net.URL(url).openStream();
            image = BitmapFactory.decodeStream(in);
        }
        catch(MalformedURLException e) {
            e.printStackTrace();
        }
        catch(IOException e) {
            e.printStackTrace();
        }
        return image;
    }

    /**
     * Rescales the Bitmap object and sets as the image
     * @param result Bitmap object
     */
    public void onPostExecute(Bitmap result) {
        int rescaledWidth = result.getWidth() * 5;
        int rescaledHeight = result.getHeight() * 5;
        Bitmap newResult = Bitmap.createScaledBitmap(result, rescaledWidth, rescaledHeight, true);
        bmImage.setImageBitmap(newResult);
    }
}
