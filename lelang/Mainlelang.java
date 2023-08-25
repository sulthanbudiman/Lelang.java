
package lelang;

public class Mainlelang {
    public static void main(String[] args) {
        Masyarakat masyarakat = new Masyarakat();
            Petugas petugas = new Petugas();
                barangLelang barang = new barangLelang();
                    lelang lelang = new lelang(barang, masyarakat, petugas);
    }
}
