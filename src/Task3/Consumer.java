package Task3;

public class Consumer extends Thread {
    private Shop shop;

    public Consumer(Shop shop) {
        this.shop = shop;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 5; i++) {
                shop.buyProduct();
                Thread.sleep(1500); //время на покупку
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}