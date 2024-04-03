package kendaraan.khusus;

import kendaraan.Kendaraan;
import kendaraan.util.ShootAble;

public class Tank extends Kendaraan implements ShootAble{
    @Override
    public void Start() {
        System.out.println("Menyalakan tank " + this.getName() + " tank ");
    }

    @Override
    public void Stop() {
        System.out.println("Mematikan tank " + this.getName() + " tank ");
    }

    @Override
    public void Brake() {
        System.out.println("Tank berhenti");
    }

    @Override
    public void Shoot(String vehicle) {
        System.out.println("Tank menembak " + vehicle);
    }

    @Override
    public void shoot(String vehicle) {

    }
}