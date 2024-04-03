package kendaraan.khusus;

import kendaraan.Kendaraan;
import kendaraan.util.FlyAble;

public class Pesawat extends Kendaraan implements FlyAble {
    @Override
    public void Start() {
        System.out.println("Menyalakan pesawat " + this.getName());
    }

    @Override
    public void Stop() {
        System.out.println("Mematikan mesin pesawat " + this.getName());
    }

    @Override
    public void fly() {
        System.out.println("Pesawat " + this.getName() + " lepas landas");
    }

    public void Brake() {
        System.out.println("Pesawat " + this.getName() + " mengurangi kecepatan"); // menambahkan method override yang
        // dibutuhkan
    }
}