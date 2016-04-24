package easy;

/**
 * @author: decaywood
 * @date: 2016/4/24 13:08.
 * <p>
 * Factory is a design pattern in common usage. Please implement a ToyFactory which can generate proper toy based on the given type.
 * <p>
 *
 * Example
 * ToyFactory tf = ToyFactory();
 * Toy toy = tf.getToy('Dog');
 * toy.talk();
 * >> Wow
 * <p>
 * toy = tf.getToy('Cat');
 * toy.talk();
 * >> Meow
 *
 */
public class ToyFactory {

    static interface Toy {
        void talk();
    }

    private static class Dog implements Toy {
        @Override
        public void talk() {
            System.out.println("Wow");
        }
    }

    private static class Cat implements Toy {
        @Override
        public void talk() {
            System.out.println("Meow");
        }
    }

    public Toy getToy(String type) {
        if ("Dog".equals(type)) return new Dog();
        else return new Cat();
    }

}
