package edu.escuelaing.arem.ASE.app;

/**
 * Hello world!
 *
 */

import static spark.Spark.*;

public class ProxyServer {

    static String[] sites = { "", "" };
    static int counter = 0;

    public static void main(String[] args) {

        sites[0] = args[0];
        sites[1] = args[0];

        staticFiles.location("/public"); // Static files

        port(getPort());

        get("/linearsearch", (req, res) -> {
            res.type("Application/json");
            int value = Integer.parseInt(req.queryParams("value"));
            String list = req.queryParams("list");
            return HttpConnectionExample.main(change_URL_RR() + "/linearsearch?list=" + list + "&value=" + value);
        });

        get("/binarysearch", (req, res) -> {
            res.type("Application/json");
            int value = Integer.parseInt(req.queryParams("value"));
            String list = req.queryParams("list");
            return HttpConnectionExample.main(change_URL_RR() + "/binarysearch?list=" + list + "&value=" + value);
        });
    }

    private static String change_URL_RR() {
        String site = sites[counter];
        if (counter == 0) {
            counter = 1;
        } else if (counter == 1) {
            counter = 0;
        }
        return site;
    }

    private static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 4567;
    }
}
