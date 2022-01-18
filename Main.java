import java.io.IOException;
//import com.google.gson.JsonParser;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class Main {
  public static void main(String[] args) throws IOException {

    String CLIENT_ID = "eb10f4bfc1da4ac49632ac79da23bf5b";
    String CLIENT_SECRET = "b2d5717e6a5d421e9285d41cb9ba0855";
    String TOKEN = "https://accounts.spotify.com/api/token";

    URL url = new URL(TOKEN);
    HttpURLConnection http = (HttpURLConnection) url.openConnection();
    http.setRequestMethod("POST");
    http.setDoOutput(true);
    http.setRequestProperty("content-type", "application/x-www-form-urlencoded");

    String data = "grant_type=client_credentials&client_id=" + CLIENT_ID + "&client_secret=" + CLIENT_SECRET + "";

    byte[] out = data.getBytes(StandardCharsets.UTF_8);

    OutputStream stream = http.getOutputStream();
    stream.write(out);

    BufferedReader Lines = new BufferedReader(new InputStreamReader(http.getInputStream()));
    String currentLine = Lines.readLine();
    StringBuilder response = new StringBuilder();
    while (currentLine != null) {
      response.append(currentLine).append("\n");
      currentLine = Lines.readLine();
    }

    //String accessToken = String.valueOf(JsonParser.parseString(String.valueOf(response)).getAsJsonObject().getAsJsonObject("access_token"));
    //String expiresIn = String.valueOf(JsonParser.parseString(String.valueOf(response)).getAsJsonObject().getAsJsonObject("expires_in"));

    http.disconnect();

    System.out.print(response);

    //System.out.print(accessToken);
    //System.out.print(expiresIn);
  }
}

//public class SpotifyToken {
//  public String accessToken = "";
//  public String expiresIn = "";
//
//
//  public static void get() throws IOException {
//
//    URL url = new URL(Endpoints.TOKEN);
//    HttpURLConnection http = (HttpURLConnection) url.openConnection();
//    http.setRequestMethod("POST");
//    http.setDoOutput(true);
//    http.setRequestProperty("content-type", "application/x-www-form-urlencoded");
//
//    String data = "grant_type=client_credentials&client_id=" + Endpoints.CLIENT_ID + "&client_secret=" + Endpoints.CLIENT_SECRET + "";
//
//    byte[] out = data.getBytes(StandardCharsets.UTF_8);
//
//    OutputStream stream = http.getOutputStream();
//    stream.write(out);
//
//    BufferedReader Lines = new BufferedReader(new InputStreamReader(http.getInputStream()));
//    String currentLine = Lines.readLine();
//    StringBuilder response = new StringBuilder();
//    while (currentLine != null) {
//      response.append(currentLine).append("\n");
//      currentLine = Lines.readLine();
//    }
//
//    this.accessToken = String.valueOf(JsonParser.parseString(String.valueOf(response)).getAsJsonObject().getAsJsonObject("access_token"));
//    this.expiresIn = String.valueOf(JsonParser.parseString(String.valueOf(response)).getAsJsonObject().getAsJsonObject("expires_in"));
//
//    http.disconnect();
//  }
//}
//
//public class Endpoints {
//  public static final String CLIENT_ID = "eb10f4bfc1da4ac49632ac79da23bf5b";
//  public static final String CLIENT_SECRET = "b2d5717e6a5d421e9285d41cb9ba0855";
//  public static final String TOKEN = "https://accounts.spotify.com/api/token";
//}
