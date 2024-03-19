public class App {
    public static void main(String[] args) throws Exception {
        Tabung tabung = new Tabung("tabung") {
            @Override
            public void input() {

            }
        };
        Kubus kubus = new Kubus("kubus") {
            @Override
            public void input() {

            }
        };
        Balok balok;
        balok = new Balok("balok") {
            @Override
            public void input() {

            }
        };

        balok.inputNilai();
        balok.luasPermukaan();
        balok.volume();

        kubus.inputNilai();
        kubus.luasPermukaan();
        kubus.volume();

        tabung.inputNilai();
        tabung.luasPermukaan();
        tabung.volume();
    }
}