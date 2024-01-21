package Task3;

public class Shop {
    private int productCount = 0;

    public synchronized void produceProduct() throws InterruptedException {
        while (productCount >= 3) {
            wait();
        }

        System.out.println("Мужик произвел 1 продукт");
        productCount++;
        notifyAll();
    }

    public synchronized void buyProduct() throws InterruptedException {
        while (productCount == 0) {
            wait();
        }

        System.out.println("Женщина купила 1 продукт");
        productCount--;
        notifyAll();
    }
}