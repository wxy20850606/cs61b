public class Demo {

    public class Dog {
        public void bark(){
            System.out.println("Whoof!");
        }
    }

    public class Corgi extends Dog {
        public void bark(){
            System.out.println("Bark!");
        }
    }
    public static void main(String[] args) {
        Dog a = new Corgi();
    }
}