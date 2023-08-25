package lelang;

    import java.util.ArrayList;

        public class Masyarakat implements userLelang {
            private ArrayList<String> nama = new ArrayList<String>(),
                                    alamat = new ArrayList<String>(),
                                   telepon = new ArrayList<String>();
    
            public Masyarakat(){
                addMasyarakat("Sulthan","Jawa Timur","0818247983259835");
                 addMasyarakat("Rafi","Malang","082350950983409");
                  addMasyarakat("Aufaa","Blitar","083419024091284");
                   addMasyarakat("Budiman","Bandung","08124918428787");
                               }
            public void addMasyarakat(String name, String address, String telp){
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
                return nama.size();
                                  }
                                                      }