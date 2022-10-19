public class App {
    public static void main(String[] args) {

        Bahnhof b = new Bahnhof();
        b.sortiereZumKleinsten();
        Stack<Waggon> GleisC = b.getGleisC();
        System.out.println("GleisC");

        while (!GleisC.isEmpty()) {

            Waggon w = GleisC.top();
            GleisC.pop();
            System.out.println(w.getNummer());
        }
    }
}
