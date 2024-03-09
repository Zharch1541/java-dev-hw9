package http;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;

class HttpStatusImageDownloaderTest {
    private HttpStatusImageDownloader downloader;

    @BeforeEach
    public void BeforeEach() {
        downloader = new HttpStatusImageDownloader();
    }

    @Test
    public void downloadStatusImageDownloadImageToPackage() throws IOException {
        String path = "src/main/java/cats/200.jpg";
        downloader.downloadStatusImage(200);

        Path filePath = Paths.get(path);
        boolean actualFileExists = Files.exists(filePath);

        Assertions.assertEquals(true, actualFileExists);
    }

    @Test
    public void downloadStatusImageThrowFileNotFoundEx() {
        int code = 168;
        Assertions.assertThrows(FileNotFoundException.class, () ->  downloader.downloadStatusImage(code));
    }
}