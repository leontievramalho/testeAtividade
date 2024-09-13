import java.util.HashMap;
// Classe Singleton que garante que seja instanciada uma única vez

public class SingletonCarFactory {
    private static SingletonCarFactory instance;
    private int totalCars;
    private static HashMap<String, Integer> totalVendas;


    public SingletonCarFactory() {
    }

    public static SingletonCarFactory getInstance(){
        if(instance==null){
            instance = new SingletonCarFactory();
            totalVendas = new HashMap<>();
        }
        return instance;
    }

    public Car buildCar(String model){
        model = model.toLowerCase();
        Car car = new Car();
        car.setModel(model);
        totalCars ++;
        if(totalVendas.containsKey(model)){
            totalVendas.replace(model, totalVendas.get(model), totalVendas.get(model) + 1 );
        }else{
            totalVendas.put(model, 1);
        }
        System.out.println("Carro do modelo " + model + " criado");
        return car;
    }

    public String getTotal(){
        return "Total de carros criados: " + totalCars;
    }

    public String reportSales(){
        String report = "Relatório de carros vendidos: \n";
        String maisVendido = "";
        for(int i=0; i<totalVendas.size(); i++){
            String key = totalVendas.keySet().toArray()[i].toString();
            report = report.concat(key +": " + totalVendas.get(key) + " unidades vendidas. \n");
            if(i == 0) {
                maisVendido = key;
            } else if(totalVendas.get(key)>totalVendas.get(maisVendido)){
                maisVendido = key;
            }
        }
        report = report.concat("O modelo " + maisVendido + " é o mais vendido.");
        return report;
    }
}