import java.util.Scanner;

public abstract class Tabung extends BangunRuang{
    Tabung(String name) {

        super(name);
    }
    Scanner scanner = new Scanner(System.in);
    private double tinggi;
    private double jari_jari;
    public void setTinggi (double tinggi) {
        this.tinggi = tinggi;
    }

    public double getTinggi () {
        return tinggi;
    }

    public void setJari_jari (double jari_jari) {
        this.jari_jari = jari_jari;
    }

    public double getJari_jari () {
        return jari_jari;
    }

    @Override
    public void inputNilai(){
        super.inputNilai();
        System.out.print("Input tinggi: ");
        tinggi = scanner.nextDouble();
        System.out.print("Input jari-jari: ");
        jari_jari = scanner.nextDouble();
    }

    @Override
    public void luasPermukaan(){
        double hasil = 2 * Math.PI * jari_jari * (jari_jari + tinggi);
        super.luasPermukaan();
        System.out.println("Hasil luas permukaan: " + hasil);
    }

    @Override
    public void volume(){
        double hasil = Math.PI * Math.pow(jari_jari, 2) * tinggi;
        super.volume();
        System.out.println("Hasil volume: " + hasil);
    }
}