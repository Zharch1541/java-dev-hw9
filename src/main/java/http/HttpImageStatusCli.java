package http;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class HttpImageStatusCli {
    private HttpStatusImageDownloader httpStatusImageDownloader = new HttpStatusImageDownloader();
    private Scanner scanner = new Scanner(System.in);
    boolean isValidInput = false;
    public void askStatus() {
        while (!isValidInput) {
            System.out.println("Enter HTTP status code");
            int input = 0;
            try {
                input = scanner.nextInt();
                httpStatusImageDownloader.downloadStatusImage(input);
                isValidInput = true;

            } catch (IOException ex) {
                System.out.println(String.format("There is not image for HTTP status %s", input));
            } catch (InputMismatchException e) {
                System.out.println("Please enter valid number");
                scanner.next();
            }
        }
    }
}
