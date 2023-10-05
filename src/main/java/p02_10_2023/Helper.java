package p02_10_2023;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.channels.Channel;
import java.nio.channels.ReadableByteChannel;
public class DownloadFile {

    public DownloadFile() {

    }

    public DownloadFile(String url, String location) throws IOException {
        downloadFile(url, location);
    }

    private void downloadFile(String url, String location) throws MalformedURLException {
        URL link = new URL(url);






    }
}