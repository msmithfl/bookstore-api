package group.twentysix.bookstore;

import org.springframework.http.HttpRequest;
import java.net.URI;
import java.net.http.HttpClient;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class BookRating {
    private final String bookId;
    private final String userId;

    public BookRating(String bookId, String userId) {
        this.bookId = bookId;
        this.userId = userId;
    }

    public void rateBook(int rating) {
        if (rating < 1 || rating > 5) {
            throw new IllegalArgumentException("Rating must be between 1 and 5.");
        }

        // Get the current date and time
        LocalDateTime datestamp = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE_TIME;
        String formattedDatestamp = datestamp.format(formatter);

        // Send a request to the API to create the rating
        // Replace API_ENDPOINT with the endpoint URL
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(API_ENDPOINT + "/books/" + bookId + "/ratings"))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(String.format("{\"book_id\":\"%s\", \"rating\":%d, \"user_id\":\"%s\", \"datestamp\":\"%s\"}",
                        bookId, rating, userId, formattedDatestamp)))
                .build();
        client.send(request, HttpResponse.BodyHandlers.ofString());
    }
}
