public class Bahnhof {

    // Wir deklarieren die generischen Stacks
    private Stack<Waggon> gleisA;
    private Stack<Waggon> gleisB;
    private Stack<Waggon> gleisC;
    private int WaggonNummer;

    public Bahnhof() {

        // wir instanzieren die einzelnen Gleise mit einem generischen Stack
        gleisA = new Stack<Waggon>();
        gleisB = new Stack<Waggon>();
        gleisC = new Stack<Waggon>();

        // create x Waggons
        for (int i = 0; i < 8; i++) {
            Waggon w = new Waggon();
            gleisA.push(w);
            System.out.println(w.getNummer());
        }
    }

    public void sortiereZumKleinsten() {

        // Solange die Gleise A und B noch Waggons enthalten
        while (!gleisA.isEmpty() || !gleisB.isEmpty()) {

            // Reset Waggon Nummer
            WaggonNummer = Integer.MAX_VALUE;

            while (!gleisA.isEmpty()) {

                // Wir merken uns die Nummer des Waggons der zuerst
                // aus Gleis A heraus gefahren wird
                int topANummer = gleisA.top().getNummer();

                // Ist diese Nummer kleiner als die gemerkte WaggonNummer
                if (topANummer < WaggonNummer) {
                    // aktualisieren wir die gemerkte Waggonnummer
                    WaggonNummer = topANummer;
                }

                // umrangieren auf Gleis B
                gleisB.push(gleisA.top());
                gleisA.pop();
            }

            // Alle Waggons zurück zurück auf Gleis A
            // Außer dem Waggon mit der gemerkten Waggonnummer
            // der kommt auf Gleis C
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