import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class ToyShop {
    private List<Toy> toys = new ArrayList<>();
    private List<Toy> prizeToys = new ArrayList<>();
    private Random random = new Random();
    
    public void addToy(Toy toy) {
        toys.add(toy);
    }
    
    public void setToyWeight(int toyId, double weight) {
        for (Toy toy : toys) {
            if (toy.getId() == toyId) {
                toy.setWeight(weight);
            }
        }
    }
    
    public Toy drawPrizeToy() {
        double totalWeight = 0;
        for (Toy toy : toys) {
            totalWeight += toy.getWeight();
        }
        
        double randomNumber = random.nextDouble() * totalWeight;
        double currentWeight = 0;
        for (Toy toy : toys) {
            currentWeight += toy.getWeight();
            if (currentWeight >= randomNumber) {
                if (toy.getQuantity() > 0) {
                    toy.setQuantity(toy.getQuantity() - 1);
                    prizeToys.add(toy);
                    return toy;
                } else {
                    System.out.println("Toy is out of stock");
                    return null;
                }
            }
        }
        return null;
    }
    
    public Toy getPrizeToy() {
        if (prizeToys.isEmpty()) {
            System.out.println("The list of prize toys is empty");
            return null;
        }
        Toy prizeToy = prizeToys.get(0);
        prizeToys.remove(0);
        try {
            FileWriter writer = new FileWriter("prizeToys.txt", true);
            writer.write(prizeToy.getName() + System.lineSeparator());
            writer.close();
        } catch (IOException e) {
            System.out.println("An error occurred while writing to a file");
        }
        return prizeToy;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (Toy toy : toys) {
            result.append(toy).append(System.lineSeparator());
        }
        return result.toString();
    }
}