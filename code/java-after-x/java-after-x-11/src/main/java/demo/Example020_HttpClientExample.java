package demo;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpHeaders;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Java 9 introduced a new incubating HttpClient API for dealing with HTTP requests.
 * As of Java 11 this API is now final and available in the standard libraries package java.net. Let's explore what we can do with this API.
 */
public class Example020_HttpClientExample {

    public static void main(String[] args) throws Exception {

        // package import java.net.http;

        demo1();
//        System.out.println("#########");
//
//        demo2();
//
//        System.out.println("#########");
//
//        demo3();
    }

    /**
     * Example for sending a synchronous GET request
     *
     * @throws java.io.IOException
     * @throws InterruptedException
     */
    private static void demo1() throws java.io.IOException, InterruptedException {

        System.out.println("Demo 1");
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://example.com"))
                .header("X-App", "Demo")
                .GET()
                .build();

        /*
        The new HttpClient can be used either synchronously or asynchronously.

        A /synchronous/ request blocks the current thread until the response is available.
        BodyHandlers define the expected type of response body (e.g. as string, byte-array or file):
         */
        var client = HttpClient.newHttpClient();

        HttpResponse.BodyHandler<String> asString = HttpResponse.BodyHandlers.ofString();
        /*
         * HttpResponse.BodyHandlers
         *    .olfLines() | .ofByteArray() | ofFile() | ofFileDownload()
         */

        HttpResponse<String> response = client.send(request, asString);

        int statusCode = response.statusCode();
        System.out.printf("Status Code: %s%n", statusCode);
        HttpHeaders headers = response.headers();
        System.out.printf("Response Headers: %s%n", headers);
        System.out.println(response.body());
    }

    /**
     * Example for sending an asynchronous GET request
     *
     * @throws InterruptedException
     * @throws java.util.concurrent.ExecutionException
     */
    private static void demo2() throws InterruptedException, java.util.concurrent.ExecutionException {

        System.out.println("Demo 2");

        var request = HttpRequest.newBuilder()
                .uri(URI.create("https://example.com"))
                // .GET() // can be omitted as it is the default...
                .build();


        /*
         * A request can also be performed asynchronously.
         * Calling sendAsync does not block the current thread and instead returns a
         * CompletableFuture to construct asynchronous operation pipelines.
         */

        var client = HttpClient.newHttpClient();
        CompletableFuture<HttpResponse<String>> responseFuture = client.sendAsync(request, HttpResponse.BodyHandlers.ofString());

        responseFuture
                .thenApply(HttpResponse::body)
                .thenAccept(System.out::println)
                .get() // wait for result
        ;
    }

    /**
     * Example for sending an asynchronous POST request
     *
     * @throws InterruptedException
     * @throws java.util.concurrent.ExecutionException
     */
    private static void demo3() throws ExecutionException, InterruptedException {

        System.out.println("Demo 3");

        var postRequest = HttpRequest.newBuilder()
                .uri(URI.create("https://postman-echo.com/post"))
                .header("Content-Type", "text/plain")
                .POST(HttpRequest.BodyPublishers.ofString("Hi there!"))
                .build();

        ExecutorService executor = Executors.newSingleThreadExecutor();
        var client = HttpClient.newBuilder().executor(executor).build();

        var responseFuture = client.sendAsync(postRequest, HttpResponse.BodyHandlers.ofString());

        responseFuture.thenApply(response -> {
            System.out.printf("StatusCode: %s%n", response.statusCode());
            return response;
        })
                .thenApply(HttpResponse::body)
                .thenAccept(System.out::println)
                .get();

        executor.shutdownNow();
    }
}
