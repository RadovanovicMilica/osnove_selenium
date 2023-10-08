package d02_10_2023;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class Helper {
    public static int getHTTPResponseStatusCode (String x) throws IOException {
        URL url= new URL(x);
        HttpURLConnection http= (HttpURLConnection)url.openConnection();
        return http.getResponseCode();
    }

        public static void downloadImage(String imageUrl, String destinationFolder) throws IOException {
            URL url = new URL(imageUrl);
            File destinationFile = new File(destinationFolder, getFileNameFromUrl(imageUrl));
            FileUtils.copyURLToFile(url, destinationFile);
    }

    private static String getFileNameFromUrl(String imageUrl) {
        return imageUrl;
    }
}
