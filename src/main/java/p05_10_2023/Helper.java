package p05_10_2023;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class Helper {

    public static int getHTTPResponseStatusCode (String h) throws IOException {
        URL url= new URL(h);
        HttpURLConnection http= (HttpURLConnection)url.openConnection();
        return http.getResponseCode();
    }
}
