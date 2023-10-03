package co.edu.escuelaing.arep;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class HttpRemoteCaller {

    private static final String USER_AGENT = "Mozilla/5.0";
    private static final String[] LOG_SERVERS = new String[]{
                                                    "http://localhost:4568",
                                                    "http://localhost:4569",
                                                    "http://localhost:4570",
                                                };
    //private static final String GET_URL = "https://www.alphavantage.co/query?function=TIME_SERIES_DAILY&symbol=fb&apikey=Q1QZFVJQ21K7C6XM";

    private static int currentServer = 0;
                                         
    public static String remoteLogCall(String message) throws IOException{
        String encodedMessage = URLEncoder.encode(message, "UTF-8"); // Para permitir espacios en el mensaje
        return remoteHttpCall(LOG_SERVERS[currentServer] + "/logService?value=" + encodedMessage);
    }

    public static String remoteHttpCall(String url) throws IOException {

        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("User-Agent", USER_AGENT);
        
        //The following invocation perform the connection implicitly before getting the code
        int responseCode = con.getResponseCode();
        System.out.println("GET Response Code: " + responseCode);
        StringBuffer response = new StringBuffer();
        
        if (responseCode == HttpURLConnection.HTTP_OK) { // success
            BufferedReader in = new BufferedReader(new InputStreamReader(
                    con.getInputStream()));
            String inputLine;

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            // print result
            System.out.println(response.toString());
        } else {
            System.out.println("GET request not worked");
        }
        System.out.println("GET DONE from Port: " + LOG_SERVERS[currentServer]);

        rotateRoundrobinServer();
        return response.toString();
    }

    public static void rotateRoundrobinServer(){
        currentServer = (currentServer + 1) % 3;
    }

} 
     
