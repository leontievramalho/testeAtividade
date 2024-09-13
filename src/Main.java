// Classe main para instanciar os carros e o singleton factory
public class Main {
    public static void main(String[] args){
        SingletonCarFactory singletonCarFactory = SingletonCarFactory.getInstance();
        singletonCarFactory.buildCar("Fiat");
        singletonCarFactory.buildCar("Sedan");
        singletonCarFactory.buildCar("Ferrari");
        singletonCarFactory.buildCar("Fiat");
        singletonCarFactory.buildCar("Fiat");
        singletonCarFactory.buildCar("Ferrari");

        System.out.println(singletonCarFactory.reportSales());
    }
}
