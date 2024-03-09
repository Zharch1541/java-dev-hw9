package http;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.IOException;


class HttpStatusCheckerTest {

    private HttpStatusChecker httpStatusChecker;

    @BeforeEach
    public void BeforeEach() {
        httpStatusChecker = new HttpStatusChecker();
    }

    @Test
    public void getStatusImageTest() throws IOException {
        String url = "https://http.cat/200.jpg";
        Assertions.assertEquals(url, httpStatusChecker.getStatusImage(200));
    }
    @Test
    public void getStatusImageTestThatReturnEx() {
        int illegalCode = 1234;
        Assertions.assertThrows(FileNotFoundException.class, () -> httpStatusChecker.getStatusImage(illegalCode));
    }
}