public class Main {
    public static void main(String[] args) {
        ToyShop toyShop = new ToyShop();
        toyShop.addToy(new Toy(1, "Teddy bear", 10, 50));
        toyShop.addToy(new Toy(2, "Doll", 20, 20));
        toyShop.addToy(new Toy(3, "Car", 5, 30));
        
        System.out.println("Initial toys:");
        System.out.println(toyShop);
        
        toyShop.setToyWeight(1, 70);
        
        System.out.println("Toys after weight change:");
        System.out.println(toyShop);
        
        System.out.println("Drawing 10 prize toys:");
        for (int i = 0; i < 10; i++) {
            Toy prizeToy = toyShop.drawPrizeToy();
            if (prizeToy != null) {
                System.out.println(prizeToy);
            }
        }
        
        System.out.println("List of prize toys:");
        System.out.println(toyShop);
        
        System.out.println("Getting prize toys:");
        while (true) {
            Toy prizeToy = toyShop.getPrizeToy();
            if (prizeToy == null) {
                break;
            }
        }
    }
}