package http;

import http.cons.Constants;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpStatusChecker {
    public String getStatusImage(int code) throws IOException {
        String url = Constants.HTTP + code + Constants.FORMAT;
        HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
        int responseCode = connection.getResponseCode();
        if (responseCode == 404) {
            throw new FileNotFoundException("Image not found for code: " + code);
        } else {
            return url;
        }
    }
}
