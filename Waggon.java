public class Waggon {

    private int nummer;

    public Waggon() {

        nummer = (int) (Math.random() * 50 + 1);

    }

    public int getNummer() {

        return nummer;
    }
}
