package edu.escuelaing.arem.ASE.app;

import static spark.Spark.*;

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
            System.out.println(list1 + "0" + list1.length + value);
            System.out.println("aquitambien");
            int resp = binarySearch(list1, 0, list1.length - 1, value);
            System.out.println(resp);
            String reps1 = "{\"operation\":\"BinarySearch\",\"inputlist\": " + list + ",\"value\":" + value
                    + ",\"output\":" + resp + "}";
            return reps1;
        });
    }

    public static int binarySearch(String[] list, int l, int r, int x) {

        if (r >= l && l <= list.length - 1) {

            int mid = l + (r - l) / 2;
            if (Integer.parseInt(list[mid]) == x)
                return mid;

            if (Integer.parseInt(list[mid]) > x)
                return binarySearch(list, l, mid - 1, x);

            return binarySearch(list, mid + 1, r, x);
        }
        return -1;
    }

    private static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 4567;
    }

}