package demo;

import java.lang.reflect.Method;
import java.util.ArrayList;

public class Demo {
    public static void main(String[] args) {
        {
            Class<?> obj = ArrayList.class;
            Method[] methods = obj.getDeclaredMethods();
            System.out.println(methods.length);
            for (int i = 0; i < methods.length; i++) {
                System.out.println(methods[i].getName());
            }
        } 
    }
}
