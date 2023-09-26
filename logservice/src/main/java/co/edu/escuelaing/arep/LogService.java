package co.edu.escuelaing.arep;

import static spark.Spark.*;


public class LogService{
    public static void main( String[] args ){
        port(getPort());
        staticFiles.location("/public");
        //get("/cliente", (req, pesp) -> getCliente());
        get("/logService", (req, pesp) -> {
            String val = req.queryParams("value");
            return logMessage(val);
        });
    }

    private static int getPort(){
        if(System.getenv("PORT") != null){
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 4568;
    }

    private static String logMessage(String val){
        return """
            {"m1":"mensaj1",
            "m2":"mensaj2",
            "m3":"mensaj3"}
            """;
    }
}
