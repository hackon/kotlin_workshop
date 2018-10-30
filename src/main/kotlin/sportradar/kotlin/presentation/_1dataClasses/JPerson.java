package sportradar.kotlin.presentation._1dataClasses;

import java.util.Objects;

public class JPerson {
    private final String name;
    private final int age;


    public JPerson(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "JPerson{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        JPerson jPerson = (JPerson) o;
        return age == jPerson.age &&
                Objects.equals(name, jPerson.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    public int getAge() {
        return age;
    }
}
