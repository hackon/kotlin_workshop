package sportradar.kotlin.presentation._3nullSafety;

public class JNullSafety {
  public static void main(String[] args) {
    String name = getName();
    if (name == null) {
      name = "other name";
    }

    String name2 = name == null ? name : "other name 2";
  }

  static String getName() {
    return null;
  }
}
