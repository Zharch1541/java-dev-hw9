package http;

import http.cons.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpStatusImageDownloader {

    private static Logger logger = LoggerFactory.getLogger(HttpStatusImageDownloader.class);

    public void downloadStatusImage(int code) throws IOException {
        String url = new HttpStatusChecker().getStatusImage(code);
        String path = Constants.PATH + code + Constants.FORMAT;

        HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();

        try (InputStream inputStream = connection.getInputStream();
             FileOutputStream outputStream = new FileOutputStream(path)) {

            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }
            logger.info("Image downloaded successfully to: " + path);
        }
        catch (Exception e) {
            throw new FileNotFoundException("File with code " + code + " not found");
        }
    }

}
