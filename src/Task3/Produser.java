package Task3;

class Produser extends Thread {
    private Shop shop;

    public Produser(Shop shop) {
        this.shop = shop;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 5; i++) {
                shop.produceProduct();
                Thread.sleep(1000); // время работы типо
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
