package org.EA5;

public class FunctionOperatorTest {
  public static void main(String[] args) {
    var funcOp = new FunctionOperator();

    IntIntFunction f1 =
        new IntIntFunction() {
          public int perform(int input) {
            return input - 1;
          }
        };

    IntIntFunction f2 =
        new IntIntFunction() {
          public int perform(int input) {

            if (input % 2 == 0) {
              input = input / 2;
            } else {
              input = input * 3 + 1;
            }
            return input;
          }
        };

    System.out.println(funcOp.operate(f1, 10, -10));
    System.out.println(funcOp.operate(f2, 27, 1));
    System.out.println(funcOp.operate(x -> x - 1, 10, -10));
    System.out.println(funcOp.operate(x -> x % 2 == 0 ? x / 2 : x * 3 + 1, 27, 1));

    System.out.println(
        funcOp.operate(
            x -> {
              return x % 2 == 0 ? x / 2 : x * 3 + 1;
            }, 27, 1));
  }
}
