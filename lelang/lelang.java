package lelang;

    import java.util.ArrayList;
    import java.util.Scanner;

        public class lelang{
            int menawar;
            public lelang(barangLelang barang, Masyarakat masyarakat, Petugas petugas){
             prosesLelang(barang, masyarakat, petugas);
            }
            private ArrayList<Integer>  idPenawar = new ArrayList<Integer>();
            private ArrayList<Integer>  idBarang  = new ArrayList<Integer>();
            private ArrayList<Integer> hargatawar = new ArrayList<Integer>();
            private ArrayList<Integer> hargabarang= new ArrayList<Integer>();
            
            public void prosesLelang(barangLelang barang, Masyarakat masyarakat, Petugas petugas){
                Scanner scan = new Scanner(System.in);
                String input = "";
                
                    while (!input.equalsIgnoreCase("y")){
                        System.out.println("Selamat datang\n anda masuk sebagai (1/2)\n 1. Petugas\n2. Masyarakat\npilihan:");
                        int masuk = scan.nextInt();

                        System.out.print("ID anda : ");
                        int id = scan.nextInt();

                      if (id > petugas.getJumlah() || id > masyarakat.getJumlah()) {
                        System.out.println("ID tidak valdi");
                        break;
                                                                                   }

                    switch (masuk) {
                        case 1 -> {
                            String keluar = "";
                                while (!keluar.equalsIgnoreCase("y")) {
                                    
                                    System.out.print("Welcome Petugas " + petugas.getNama(id) + " Apa yang ingin anda lakukan : \n1. Tambah barang\n2. Edit Status Barang\n3. Delete Barang\n4. Keluar\npilihan: ");
                                    int pilihan = scan.nextInt();

                                switch (pilihan) {
                                    case 1 -> {
                                        barang.TabelBarang();
                                        System.out.print("Masukkan Nama Barang: ");
                                        scan.nextLine();
                                        String namaBarang = scan.nextLine();
                                        System.out.print("Masukkan Harga Barang: ");
                                        int hargaBarang = scan.nextInt();
                                        barang.addNewBarang(namaBarang, hargaBarang, true);
                                              }

                                    case 2 -> {
                                        barang.TabelBarang();
                                        System.out.print("Masukkan ID Barang: ");
                                        int idBarang = scan.nextInt();
                                        ArrayList<Object> penawarTertinggi = getPenawarTertinggi(idBarang, masyarakat, barang.getHarga(idBarang));
                                        System.out.print("Apakah anda ingin mengganti status " + barang.getNama(idBarang) + "(y/t)? ");
                                        String pilihan2 = scan.next();
                                        
                                            if (!penawarTertinggi.get(1).equals(0)) {
                                            barang.setStatus(idBarang, !pilihan2.equalsIgnoreCase("y")); // Jika selain y maka status tidak dirubah
                                            System.out.println("Berhasil mengganti status " + barang.getNama(idBarang));
                                            System.out.println(barang.getNama(idBarang) + " telah dijual kepada " +
                                            penawarTertinggi.get(1) + " dengan harga " + penawarTertinggi.get(0));
                                            barang.deleteBarang(idBarang);
                                                                                    }       
                                            else {
                                                System.out.println("Tidak ada penawar untuk " + barang.getNama(idBarang));
                                                 }
                                              }

                                    case 3 -> {
                                        barang.TabelBarang();
                                        System.out.print("Masukkan ID Barang: ");
                                        int idBarang = scan.nextInt();
                                        barang.deleteBarang(idBarang);
                                        System.out.println("Barang telah di hapus");
                                              }

                                    case 4 -> {
                                    keluar = "y";
                                              }
                                                 }
                            System.out.print("Apakah anda ingin keluar(y/n)? ");
                            keluar = scan.next();
                                                                      }
                                  }

                        case 2 -> {
                            String keluar = "";
                                while (!keluar.equalsIgnoreCase("y")) {
                                    barang.TabelBarang();
                                    System.out.print("Welcome " + masyarakat.getNama(id) + "\nApa yang ingin anda lakukan? :" + "\n1. Menawar Barang\n2. Keluar\nPilihan anda?: ");
                                    int pilihan = scan.nextInt();
                            
                            switch (pilihan) {
                                case 1 -> {
                                    System.out.print("Masukkan ID barang: ");
                                    int idBarang = scan.nextInt();
                                    
                                    ArrayList<Object> penawarTertinggi = getPenawarTertinggi(idBarang, masyarakat, barang.getHarga(idBarang));
                                    System.out.print("\n" + barang.getNama(idBarang) + " seharga: " + barang.getHarga(idBarang) +
                                                      "\nTawaran tertinggi: " + penawarTertinggi.get(0) + " atas nama " + penawarTertinggi.get(1) +
                                                       "\nTawaran anda : ");
                                            
                                    int menawar = scan.nextInt();
                                    int harga = barang.getHarga(id);
                                    addTransaksi(id, idBarang, menawar, harga);
                                          }

                                case 2 -> {
                                    keluar = "y";
                                          }
                                             }
                                    System.out.print("Apakah anda ingin keluar y/n)? ");
                                    keluar = scan.next();
                                                                     }
                                  }

                        default -> System.out.println("Inputan tidak valid");
                                   }

                                    System.out.print("Apakah anda yakin ingin berhenti (y/n)? ");
                                    input = scan.next();
                                                      }
                                                                                                  } 
    

    private void addTransaksi(int idPenawar, int idBarang, int hargaTawar, int harga) {
        Scanner scan = new Scanner(System.in);
    boolean kurang = true;

    while (kurang) {
        this.idPenawar.add(idPenawar);
        this.idBarang.add(idBarang);
        this.hargatawar.add(hargaTawar);
        this.hargabarang.add(harga);
        
        if (hargaTawar >= harga) {
            System.out.println("Harga tawar Anda sudah memenuhi persyaratan");
            kurang = false;
        } else {
            System.out.println("Penawaran harus lebih tinggi dari harga barang");
            System.out.print("Tawaran Anda: ");
            hargaTawar = scan.nextInt();
        }
    }
    }

    private ArrayList<Object> getPenawarTertinggi(int idBarang, Masyarakat masyarakat, int hargaBarang) {
        int max = 0;
        String nama = "Tidak Ada";
        ArrayList<Object> nawar = new ArrayList<>();
        for (int i = 0; i < this.idBarang.size(); i++) {
            if (this.idBarang.get(i) == idBarang) {
                if(this.hargatawar.get(i) > max && this.hargatawar.get(i) > hargaBarang) {
                    max = hargatawar.get(i);
                    nama = masyarakat.getNama(idPenawar.get(i));
                                                                                         }
                                                  }
                                                       }
        nawar.add(max); //harga
        nawar.add(nama); //nama
        return nawar; 
                                                                                                        }
                       }
//                this.idPenawar.add(idPenawar);
//                this.idBarang.add(idBarang);
//                this.hargatawar.add(hargaTawar);
//                this.hargabarang.add(harga);
//            while (hargaTawar >  harga ){
//                System.out.println("Harga tawar anda sudah memenuhi persyaratan");
//            }  (hargaTawar < harga) {
//                System.out.println("Penawaran harus lebih tinggi dari harga barang");
//            }       