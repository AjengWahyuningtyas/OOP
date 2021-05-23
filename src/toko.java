import static java.lang.System.in;                     
import java.util.Scanner;
public abstract class toko implements pendataan {      //class toko dengan mengimplementasikan pendataan

    @Override
    public abstract void setData();                     //class abstract
    
    @Override
    public abstract void tampil();                      //class abstract
    public static Scanner in=new Scanner(System.in);
    public static Scanner str=new Scanner(System.in);
    public static void main(String[] args) {
        int menu=0,z=0,a,cari;
        barang[] data=new barang[1024];
        data[z]=new barang();
        data[z].setId();
        while(menu!=6){
            System.out.print("\n----------PILIH MENU----------\n ");    //Menampilkan Menu
            System.out.print("\n1.Masukkan Data");                      //Menampilkan Menu
            System.out.print("\n2.Menampilkan Data");                   //Menampilkan Menu
            System.out.print("\n3.Cari Data");                          //Menampilkan Menu
            System.out.print("\n4.Update Data");                        //Menampilkan Menu
            System.out.print("\n5.Hapus Data");                         //Menampilkan Menu
            System.out.print("\nMasukkan Disini = ");                   //Meinput pilihan
            menu=data[0].in.nextInt();
            if(menu==1){
                z++;
                data[z]=new barang();
                data[z].setId(data[z-1].getId());
                data[z].setData();
            }else if(menu==2){
                if(z<1)
                    System.out.println("data kosong");
                else{
                    a=0;
                    while(a<z){
                        a++;
                        System.out.println("---"+a+"---");
                        data[a].tampil();
                    }
                }
            }else if(menu==3 || menu==4 || menu==5){
                System.out.print("masukkan id barang : ");
                cari=data[0].in.nextInt();
                a=1;
                while(a<=z){
                    if(data[a].getId()==cari)
                        break;
                    a++;
                }
                if(a<=z){
                    if(menu==3)
                        data[a].tampil();
                    else if(menu==4){
                        data[a].tampil();
                        data[a].setData();
                    }
                    else{
                        while(a<z){
                            data[a]=data[a+1];
                            a++;
                        }
                        z--;
                        System.out.println("data "+cari+" berhasil dihapus");
                    }
                }
                else
                    System.out.println("data tidak ditemukan");
            }else if(menu==6)
                System.out.println("keluar...");
            else
                System.out.println("menu ilegal");
        }
    }
   
}
 
interface pendataan{
    public int getId();
    public void setId();
    public void setId(int id);
    public void setData();
    public void tampil();
}
 
class barang extends toko{
    int idBarang,harga,jumlah,total;
    String nama;
 
    @Override
    public void setData(){
        System.out.print("Masukkan Nama Barang  : ");
        this.nama=str.nextLine();
        System.out.print("Masukkan Harga Barang : ");
        this.harga=in.nextInt();
        System.out.print("Masukkan Jumlah Barang: ");
        this.jumlah=in.nextInt();
        this.total=this.harga*this.jumlah;
    }
   
    @Override
    public void tampil(){
        System.out.println("Id Barang    : "+this.idBarang);
        System.out.println("Nama Barang  : "+this.nama);
        System.out.println("Harga Barang : "+this.harga);
        System.out.println("Jumlah Barang: "+this.jumlah);
        System.out.println("Total        : "+this.total);
    }
 
    @Override
    public int getId(){
        return this.idBarang;
    }
    
    @Override
    public void setId(){
        this.idBarang=1;
    }
   
    @Override
    public void setId(int id){
        this.idBarang=id+1;
    }
}