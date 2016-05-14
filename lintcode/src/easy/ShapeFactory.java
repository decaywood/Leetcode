package easy;

/**
 * @author: decaywood
 * @date: 2016/4/24 13:14.
 * <p>
 * Factory is design pattern in common usage. Implement a ShapeFactory that can generate correct shape.
 * <p>
 * Have you met this question in a real interview? Yes
 * Example
 * ShapeFactory sf = new ShapeFactory();
 * Shape shape = sf.getShape("Square");
 * shape.draw();
 * >>  ----
 * >> |    |
 * >> |    |
 * >>  ----
 * <p>
 * shape = sf.getShape("Triangle");
 * shape.draw();
 * >>   /\
 * >>  /  \
 * >> /____\
 * <p>
 * shape = sf.getShape("Rectangle");
 * shape.draw();
 * >>  ----
 * >> |    |
 * >>  ----
 *
 *
 */
public class ShapeFactory {

    interface Shape {
        void draw();
    }

    static class Rectangle implements Shape {
        @Override
        public void draw() {
            System.out.println(" ----");
            System.out.println("|    |");
            System.out.println(" ----");
        }
    }

    static class Square implements Shape {
        @Override
        public void draw() {
            System.out.println(" ----");
            System.out.println("|    |");
            System.out.println("|    |");
            System.out.println(" ----");
        }
    }

    static class Triangle implements Shape {
        @Override
        public void draw() {
            System.out.println("  /\\");
            System.out.println(" /  \\");
            System.out.println("/____\\");
        }
    }

    public Shape getShape(String shapeType) {
        if ("Square".equals(shapeType)) return new Square();
        else if ("Triangle".equals(shapeType)) return new Triangle();
        else return new Rectangle();
    }

}
