public class Demo {

    public static void main(String[] args) {
        Demo d = new Demo();
        d.play(2.3);
    }

    void play(float f) {
        System.out.println("float play");
    }

    void play(double d) {
        System.out.println("double play");
    }

}
