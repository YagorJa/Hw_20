package Task3;

public class Test {
    public static void main(String[] args) {
        Shop shop = new Shop();
        Produser producer = new Produser(shop);
        Consumer consumer = new Consumer(shop);

        producer.start();
        consumer.start();
    }
}
