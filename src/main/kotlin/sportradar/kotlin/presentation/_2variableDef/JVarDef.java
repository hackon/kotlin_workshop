package sportradar.kotlin.presentation._2variableDef;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class JVarDef {
  public static void main(String[] args) {
    final double pi = StrictMath.PI;
    final Double piObj = StrictMath.PI;
    final BigDecimal piBD = BigDecimal.valueOf(StrictMath.PI);

    String name = "java";
    name = "kotlin";
    int age = 23;
    age = 2;

    //java 9+ Immutable list, but still list interface with add method
    //throw UnsupportedOperationException
    List<Character> listOf = List.of('1', '2', '3');
    System.out.println(listOf);
    //    listOf.add('4'); throws exception
    List<Character> mutableList = new ArrayList<>(listOf);
    mutableList.add('4');
    System.out.println(mutableList);
  }
}
