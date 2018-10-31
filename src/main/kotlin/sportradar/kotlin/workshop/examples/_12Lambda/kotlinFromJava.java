package sportradar.kotlin.workshop.examples._12Lambda;

import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;

import java.util.List;

public class kotlinFromJava {
  public static void main(String[] args){

    List<Integer> list = CollectionsKt.listOf(1, 2, 3);
    boolean hasEven = CollectionsKt.any(list,
        new Function1<Integer, Boolean>() {
          @Override
          public Boolean invoke(Integer integer) {
            return integer % 2 == 0;
          }
        });
    boolean hasEven2 = CollectionsKt.any(list, i -> i % 2 == 0);
    System.out.println(hasEven);
  }
}
