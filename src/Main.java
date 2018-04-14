
import containers.ProductContainerRecorder;


public class Main {

    public static void main(String[] args) {
        ProductContainerRecorder someProduct = new ProductContainerRecorder("productName", 1000, 1000);
        
        someProduct.takeFromTheContainer(11.3);
        someProduct.addToTheContainer(1);
        
        someProduct.printAnalysis();
    }

}
