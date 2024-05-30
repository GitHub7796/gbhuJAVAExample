package main.gbhu.FunctionProgram;

import org.junit.Test;

import java.util.Collections;
import java.util.Comparator;
import java.util.function.BinaryOperator;
import java.util.function.UnaryOperator;

public class LambdaLearn {
    @Test
    public void test() {
        String a = "123";
        MyFactory myFactory = (chars -> {
            return a + " " + new String(chars);
        });
//        a = "234";
    }
}
