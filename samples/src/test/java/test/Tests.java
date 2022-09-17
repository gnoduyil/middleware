package test;

import java.util.UUID;

public class Tests {
    public static void main(String[] args) {

        System.out.print(UUID.randomUUID().toString().replace("-", ""));
        System.out.println(UUID.randomUUID().toString().replace("-", ""));


        Integer a = 89999;
        Integer b = 89999;

        System.out.println(a == b);
    }
}
