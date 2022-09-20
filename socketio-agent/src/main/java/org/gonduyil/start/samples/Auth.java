package org.gonduyil.start.samples;

import java.util.Map;
import java.util.Objects;

public class Auth {


    public static boolean auth(Map<String, String> args) {
        if (Objects.equals(args.get("userId"), "gonduyli")) {
            return true;
        }

        return false;
    }
}
