import com.sun.net.httpserver.HttpServer;
import java.net.InetSocketAddress;
import java.io.OutputStream;

public class TurtleServer {
  public static void main(String[] args) throws Exception {
    HttpServer server = HttpServer.create(new InetSocketAddress(5757), 0);

    server.createContext("/hello", exchange -> {
      byte[] response = "hello".getBytes();
      exchange.sendResponseHeaders(200, response.length);
      try (OutputStream os = exchange.getResponseBody()) {
        os.write(response);
      }
    });

    server.setExecutor(null);
    server.start();
    System.out.println("Server running on port 5757");
  }
}
