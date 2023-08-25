package lelang;

    import java.util.ArrayList;

        public class Petugas implements userLelang {
            private ArrayList<String> nama = new ArrayList<String>(),
                                    alamat = new ArrayList<String>(),
                                   telepon = new ArrayList<String>();
        public Petugas (){
            addPetugas("Rxo","Perancis","082387285");
             addPetugas("Shin","Indonesia","084328748101");
              addPetugas("Ran","Jawa","0824834787");
                         }
        public void addPetugas(String name, String address, String telp){
            addNama(name);
             addAlamat(address);
              addTelepon(telp);
                                                                        }
       @Override
        public void addNama(String name){
            nama.add(name);
                                        }
       @Override
        public String getNama(int idn){
           return nama.get(idn);
                                     }
       @Override
        public void addAlamat(String address){
            alamat.add(address);
                                             }
       @Override
        public String getAlamat(int ida){
            return alamat.get(ida);
                                        }
       @Override
        public void addTelepon(String telp){
            telepon.add(telp);
                                           }
       @Override
        public String getTelepon(int idt){
            return telepon.get(idt);
                                        }
       @Override
        public int getJumlah(){
            return alamat.size();
                              }
                                                   }
