// Superclass
class Renovasi {
    public double hitungPasir(double luas) {
        return luas / 10;
    }
    
    public double hitungSemen(double luas) {
        return luas / 10 / 4;
    }

    public double hitungPasir(double luas, String tipeMaterial) {
        double faktor = tipeMaterial.equalsIgnoreCase("premium") ? 5 : 10;
        return luas / faktor;
    }
    
    public double hitungSemen(double luas, String tipeMaterial) {
        double faktor = tipeMaterial.equalsIgnoreCase("premium") ? 5 : 10;
        return luas / faktor / 4;
    }
  
    public void deskripsi() {
        System.out.println("Renovasi ruko membutuhkan bahan material sesuai kebutuhan.");
    }
}

// Subclass
class RenovasiInterior extends Renovasi {
    @Override
    public void deskripsi() {
        System.out.println("Renovasi interior fokus pada pengecatan dinding.");
    }

    public double hitungBahan(double luas, int jumlahWarna) {
        double catPerMeter = 0.1; // asumsi 0.1 liter cat per meter persegi
        return luas * catPerMeter * jumlahWarna;
    }
}

// Main Class
public class Main {
    public static void main(String[] args) {
        Renovasi renovasiUmum = new Renovasi();
        System.out.println("Bahan untuk 50m\u00B2 (standar) jumlah material yang diperlukan: " + renovasiUmum.hitungPasir(50) + " karung pasir dan " + renovasiUmum.hitungSemen(50) + " karung semen.");  
        System.out.println("Bahan untuk 50m\u00B2 (premium) jumlah material yang diperlukan: " + renovasiUmum.hitungPasir(50, "premium") + " karung pasir dan " + renovasiUmum.hitungSemen(50, "premium") + " karung semen.");
        renovasiUmum.deskripsi();

        System.out.println("------------------------");

        RenovasiInterior renovasiInterior = new RenovasiInterior();
        System.out.println("Bahan untuk 50m\u00B2, 3 warna cat: " + renovasiInterior.hitungBahan(50, 3) + " liter.");
        renovasiInterior.deskripsi();
    }
}
