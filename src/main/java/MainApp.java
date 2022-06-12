import com.mkyong.JsonResource;
import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

import java.io.IOException;
import java.net.URI;

/**
 * Info: https://mkyong.com/webservices/jax-rs/json-example-with-jersey-jackson/
 */
public class MainApp {
    public static final URI BASE_URI = URI.create("http://localhost:8080");

    // Starts Grizzly HTTP server
    public static HttpServer startServer() {
        final ResourceConfig config = new ResourceConfig();
        config.register(JsonResource.class);
        // JacksonFeature for JAXB/POJO, for pure JSON, no need this JacksonFeature
        // config.register(JacksonFeature.class);

        return GrizzlyHttpServerFactory.createHttpServer(BASE_URI, config);
    }

    public static void main(String[] args) {
        try {
            final HttpServer server = startServer();
            server.start();

            //shutdown hook
            Runtime.getRuntime().addShutdownHook(new Thread(server::shutdownNow));

            System.out.println(String.format("Application started.%nStop the application using CTRL+C"));

            // block and wait shut down signal, like CTRL+C
            Thread.currentThread().join();
        } catch (InterruptedException | IOException e) {
            throw new RuntimeException(e);
        }
    }
}
