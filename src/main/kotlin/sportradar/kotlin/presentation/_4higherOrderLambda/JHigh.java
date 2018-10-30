package sportradar.kotlin.presentation._4higherOrderLambda;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

public class JHigh {
  public static void main(String[] args) {
    List<Integer> listOf = List.of(1, 2, 3, 4, 5, 6);
    List<Integer> doubleList = listOf.stream().map(integer -> integer * 2).collect(toList());
    List<Integer> doubleList2 = map(listOf, it -> it * 2);
    List<Integer> doubleBelowTenList = listOf.stream()
        .map(it -> it * 2)
        .filter(it -> it < 10)
        .collect(toList());

    Integer folded = fold(listOf, 0, (acc, nextElement) -> acc + nextElement);
    System.out.println(folded);
  }

  static <T, R> List<R> map(List<T> input, Function<T, R> transformer) {
    List<R> rs = new ArrayList<>();
    input.forEach(it-> rs.add(transformer.apply(it)));
    return rs;
  }
  static <T,R> R fold(Collection<T> src, R init, Combiner<T, R> combiner){
    R accumulator = init;
    for (T element : src) {
      accumulator = combiner.combine(accumulator, element);
    }
    return accumulator;
  }
  interface Combiner<T,R> {
    R combine(R acc, T nextElement);
  }

}
