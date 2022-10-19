public class Bahnhof {

    private Stack<Waggon> gleisA;
    private Stack<Waggon> gleisB;
    private Stack<Waggon> gleisC;
    private int WaggonNummer;

    public Bahnhof() {

        gleisA = new Stack<Waggon>();
        gleisB = new Stack<Waggon>();
        gleisC = new Stack<Waggon>();

        for (int i = 0; i < 4; i++) {

            Waggon w = new Waggon();
            gleisA.push(w);
            System.out.println(w.getNummer());
        }

    }

    public void sortiereZumKleinsten() {

        while (!gleisA.isEmpty() || !gleisB.isEmpty()) {
            WaggonNummer = Integer.MAX_VALUE;
            while (!gleisA.isEmpty()) {
                int topANummer = gleisA.top().getNummer();
                if (topANummer < WaggonNummer) {
                    WaggonNummer = topANummer;
                }
                gleisB.push(gleisA.top());
                gleisA.pop();
            }

            while (!gleisB.isEmpty()) {
                int topBNummer = gleisB.top().getNummer();
                if (topBNummer == WaggonNummer) {
                    gleisC.push(gleisB.top());
                } else {
                    gleisA.push(gleisB.top());
                }
                gleisB.pop();
            }
        }
    }

    public Stack<Waggon> getGleisC() {
        return gleisC;
    }
}