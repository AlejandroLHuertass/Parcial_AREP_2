package edu.escuelaing.arem.ASE.app;

import static spark.Spark.*;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MathServices {

    public static void main(String[] args) {

        port(getPort());

        get("/linearsearch", (req, res) -> {
            res.type("Application/json");
            int value = Integer.parseInt(req.queryParams("value"));
            String list = req.queryParams("list");
            String[] list1 = list.toString().split(",");
            int resp = -1;
            for (int i = 0; i < list1.length; i++) {
                int value_to = Integer.parseInt(list1[i]);
                if (value_to == value) {
                    resp = i;
                }
            }
            String reps1 = "{\"operation\":\"linearSearch\",\"inputlist\": " + list + ",\"value\":" + value
                    + ",\"output\":" + resp + "}";
            return reps1;
        });

        get("/binarysearch", (req, res) -> {
            res.type("Application/json");
            int value = Integer.parseInt(req.queryParams("value"));
            String list = req.queryParams("list");
            String[] list1 = list.toString().split(",");

            int resp = -1;
            ArrayList<Integer> int_list;
            for (int i = 0; i < list1.length; i++) {
                int list1 = Integer.parseInt(list1[i]);

            }

            String reps1 = "{\"operation\":\"linearSearch\",\"inputlist\": " + list + ",\"value\":" + value
                    + ",\"output\":" + resp + "}";
            return reps1;
        });
    }

    private static int binarysearch(String[] list ) {

        int piv =
            
    }

    private static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 4567;
    }

}