package lelang;

    import java.util.ArrayList;

        public class barangLelang {
            public barangLelang() {
                addNewBarang("Lukisan", 1_000, true);
                 addNewBarang("Barang prasejarah",2_000,true);
                  addNewBarang("Perhiasan",5_000,true);
                                  }
            public String getNama (int idn){
                return nama.get(idn);
                                           }
            public void addNama (String name){
                nama.add(name);
                                             }

            public int getHarga(int idh) {
                return harga.get(idh);
    }

            public void addHarga(int h) {
                harga.add(h);
    }

            public boolean getStatus(int ids) {
                return status.get(ids);
    }

            public void addStatus(boolean s) {
                status.add(s);
    }

            public void setStatus(int ids, boolean s) {
                status.set(ids, s);
    }

    public void addNewBarang(String name, int harga, boolean status) {
        addNama(name);
        addHarga(harga);
        addStatus(status);
    }

    public void deleteBarang(int idd) {
        nama.remove(idd);
        harga.remove(idd);
        status.remove(idd);
    }

    public void TabelBarang() {
        System.out.println("List Barang");
        System.out.println("ID\t|\tNama\t|\tHarga\t|");
            for (int i = 0; i < nama.size(); i++) {
                System.out.println(i + "\t|\t" + nama.get(i) + "\t|\t" + harga.get(i));
        }
    }

    private ArrayList<String> nama = new ArrayList<String>();
    private ArrayList<Integer> harga = new ArrayList<Integer>();
    private ArrayList<Boolean> status = new ArrayList<Boolean>();
                                    
        
        
        
        
        
        }
                                  