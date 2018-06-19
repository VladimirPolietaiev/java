package AppClass;
import java.lang.annotation.*;

public class Main {
    @Target(ElementType.TYPE)
    @Retention(RetentionPolicy.RUNTIME)
    public @interface Animal {
        int massa() default 3;
    }

    public static void main(String[] args) {

        @Animal()
        class Cat {
        }

        Cat a = new Cat();

        Class cl = a.getClass();
        Animal an = (Animal)cl.getAnnotation(Animal.class);

        System.out.println(an.massa());

        @Animal(massa = 5)
        class Dog {
        }

        Dog b = new Dog();

        Class clb = b.getClass();
        Animal anb = (Animal)cl.getAnnotation(Animal.class);

        System.out.println(anb.massa());
    }
}

