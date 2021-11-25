package PendaftaranLomba07341;
import java.util.Date;
import java.util.Scanner;
/**
 *
 * @author Rafi
 */
public class PendaftaranLomba07341 {
    private static Scanner input = new Scanner(System.in);
    private static PesertaLomba07341[] peserta07341 = new PesertaLomba07341[100];
    private static Panitia07341[] panitia07341 = new Panitia07341[100];
    private static PesertaTerdaftar07341[] terdaftar07341 = new PesertaTerdaftar07341[100];
    private static int pilLomba07341;
    private static int jumPeserta07341 = 0;
    private static int cekPanitia07341;
    
    public static void main (String[] args){
        dataPanitia07341();
        int pil07341;
        
        do {
            System.out.println("Jumlah Peserta :" + jumPeserta07341);
            System.out.println("1.Login Panitia");
            System.out.println("2.Lihat PEserta Terdaftar");
            System.out.println("3.Biodata Panitia");
            pil07341 = input.nextInt();
            input.nextLine();
            switch (pil07341){
                case 1 -> loginPanitia();
                case 2 -> viewPeserta();
                case 3 -> viewPanitia();
            }
        }while (pil07341 != 0);
    }
    /**
     * method dataPanitia berfungsi untuk memasukkan data-data Panitia ke panitia07341
     * @return mengembalikan nilai dari total jumlah data yang telah dimasukkan dalam panitia07341
     */
    static int dataPanitia07341() {
        String namaPanitia07341[] = {"Agam","Adit","Dian","Aji","Rakha"};
        String passPanitia07341[] = {"01","02","03","04","05"};
        String noTelpPanitia07341[] = {"081","082","083","084","085","086","087"};
        String alamatPanitia07341[] = {"jl.","jl.","jl.","jl.","jl."};
        for (int i = 0;i < namaPanitia07341.length;i++){
            panitia07341[i] = new Panitia07341(passPanitia07341[i],namaPanitia07341[i],noTelpPanitia07341[i],alamatPanitia07341[i]);
        }
        return namaPanitia07341.length;
    }
    
    /**
     * method loginPanitia ini berfungsi menyimpan input untuk Nama dan Password yang nantinya akan di cek,
     * setelah itu menampilkan pilihan2 yang dapat dilakukan oleh Panitia07341
     */
    static void loginPanitia(){
        System.out.println("Nama :");
        String nama07341 = input.next();
        System.out.println("Password :");
        String password07341 = input.next();
        cekPanitia07341 = login(nama07341,password07341);
        System.out.println("Selamat Datang" + panitia07341[cekPanitia07341].getNama());
        int pil07341;
        do{
            System.out.println("Jumlah Peserta :" + jumPeserta07341);
            System.out.println("1. Daftarkan Peserta");
            System.out.println("2. Ubah Data Peserta");
            System.out.println("3. Liat Peserta Terdaftar");
            System.out.println("4. Hapus Peserta");
            System.out.println("0. Log out");
            pil07341 = input.nextInt();
            input.nextLine();
            switch (pil07341){
                case 1 -> insertPeserta();
                case 2 -> updatePeserta();
                case 3 -> viewPeserta();
                case 4 -> deletePeserta();                           
            }            
        }while (pil07341 != 0 );
    }
    
    /**
     * Fungsi method login ini yaitu menangkap masukan berupa nama dan password lalu melakukan pengecekan terhadapnya
     * @param nama merupakan nama dari panitia yang tersimpan dalam panitia07341
     * @param password merupakan password dari panitia yang tersimpan dalam panitia07341
     * @return mengembalikan nilai yang digunakan untuk menentukan apakah nama dan password yang dimasukkan
     * betul atau salah
     */
    
    static int login(String nama07341, String password07341){
        int loop =0;
        for (int i = 0 ; i <= dataPanitia07341(); i++){
            if (panitia07341[i].getNama().equals(nama07341)&& panitia07341[i].getPassword().equals(password07341)){
                break;
            }else {
                loop++;
            }
        }
        return loop;
    }
    /**
     * method insertPeserta berfungsi untuk memasukkan data ke dalam Peserta07341 sesuai dengan inputan yang 
     * dimasukkan oleh user
     */
    static void insertPeserta(){
        System.out.println("Input Nama :");
        String nama07341 = input.nextLine();
        System.out.println("Input Umur :");
        String umur07341 = input.nextLine();
        System.out.println("Input Alamat :");
        String alamat07341 = input.nextLine();
        System.out.println("Input No.Telp :");
        String noTelp07341 = input.nextLine();
        
        peserta07341[jumPeserta07341] = new PesertaLomba07341(umur07341,nama07341,noTelp07341,alamat07341);
        insertLomba();
    }
    /**
     * method insertlomba berfungsi untuk memasukkan data ke dalam pesertaTerdaftar07341 dan menambah
     * indikator jumPeserta07341 setelah mendapat inputan dari user berupa pilihan Lomba
     */
    static void insertLomba(){
        System.out.println("Lomba :");
        for (int i =0 ; i < Lomba07341.lomba.length ; i++){
                System.out.println(i + ". " + Lomba07341.lomba[i]);
        }
            System.out.println("Pilih Lomba :");
            pilLomba07341 = input.nextInt();
            System.out.println("Input Kode Peserta");
            String kodePeserta = input.next();
            terdaftar07341[jumPeserta07341] = new PesertaTerdaftar07341(peserta07341[jumPeserta07341],pilLomba07341,kodePeserta);
            jumPeserta07341 = jumPeserta07341 + 1;
    }
    /**
     * method updatePeserta berfungsi untuk memperbarui data Peserta sesuai dengan kode Peserta yang dimasukkan
     */
    static void updatePeserta(){
        System.out.println("Masukkan Kode Peserta yang mau di Edit :");
        String search07341 = input.next();
        int cari =0;
        do{
            if (cari == jumPeserta07341){
                System.err.println("Tidak ada data");
                break;
            }else if (terdaftar07341[cari].getKodePeserta().equals(search07341)){
                int pilEdit;
                do{
                    System.out.println("Pilih data yang ingin diubah :");
                    System.out.println("1. Lihat Biodata");
                    System.out.println("2. Nama");
                    System.out.println("3. Alamat");
                    System.out.println("4. no.Telp");
                    System.out.println("5. Umur");
                    System.out.println("6. Lomba");
                    System.out.println("0. Exit");
                    pilEdit = input.nextInt();
                    input.nextLine();
                    if (pilEdit == 1){
                        System.out.println("======================");
                        System.out.println("Kode Peserta :" + terdaftar07341[cari].getKodePeserta());
                        System.out.println("======================");
                        System.out.println("Nama :" + peserta07341[cari].getNama() + "\n Umur" + peserta07341[cari].getUmur() + "\n Alamat" + peserta07341[cari].getAlamat() + "\n No.Telp" + peserta07341[cari].getNoTelp() + "\n Lomba" + Lomba07341.lomba[terdaftar07341[cari].getIndexLomba()]);
                        System.out.println("======================");
                    }else if (pilEdit == 2){
                        System.out.println("Ubah Nama :");
                        String editNama = input.nextLine();
                        peserta07341[cari].setNama(editNama);
                    }else if (pilEdit == 3){
                        System.out.println("Ubah Alamat :");
                        String editAlamat = input.nextLine();
                        peserta07341[cari].setAlamat(editAlamat);
                    }else if (pilEdit == 4){
                        System.out.println("Ubah no.Telp :");
                        String editNoTelp = input.nextLine();
                        peserta07341[cari].setNoTelp(editNoTelp);                        
                    }else if (pilEdit == 5){
                        System.out.println("Ubah Umur :");
                        String editUmur = input.nextLine();
                        peserta07341[cari].setUmur(editUmur);
                    }else if (pilEdit == 6){
                        System.out.println("Pilih Lomba :");
                        for (int i = 0; i <Lomba07341.lomba.length; i++){
                            System.out.println(i + ". " + Lomba07341.lomba[i]);
                        }    
                            System.out.println("Pilih Lomba :");
                            int editLomba = input.nextInt();
                            terdaftar07341[cari].setIndexLomba(editLomba);
                        }
                    }while (pilEdit != 0);
                break;
            }else{
                cari = cari +1;
            }
        }while(true);
    }
    /**
     * method viewPeserta berfungsi untuk menampilkan data peserta sesuai dengan data yang telah tersimpan di dalam
     * peserta07341
     */
    static void viewPeserta(){
        if (jumPeserta07341 == 0){
            System.out.println("Belum ada peserta Terdaftar");
        }else{
            for (int i = 0 ; i < jumPeserta07341; i++){
                System.out.println("=========================");
                System.out.println("Kode Peserta :" + terdaftar07341[i].getKodePeserta());
                System.out.println("=========================");
                System.out.println("Nama :" + peserta07341[i].getNama() + "\n Umur" + peserta07341[i].getUmur() + "\n Alamat" + peserta07341[i].getAlamat() + "\n No.Telp" + peserta07341[i].getNoTelp() + "\n Lomba" + Lomba07341.lomba[terdaftar07341[i].getIndexLomba()]);
                System.out.println("=========================");
            }
        }
    }
    /**
     * Method viewPanitia Berfungsi untuk menampilkan data peserta sesuai dengan data yang telah tersimpan di dalam
     * Panitia07341
     */
    static void viewPanitia(){
        for (int i = 0; i < dataPanitia07341();i++){
            System.out.println("=========================");
            System.out.println("Nama :" + panitia07341[i].getNama() + "\n No.Telp :"+ panitia07341[i].getNoTelp() + "\n Alamat :" + panitia07341[i].getAlamat());
            System.out.println("=========================");
        }
    }
    /**
     * method deletePeserta berfungsi untuk memindah data data peserta sesuai dengan
     * kode peserta yang di masukkan yang tersimpan didalam peserta07341 dan terdaftar07341
     * ke array data selanjutnya sehingga tidak terbaca oleh program lalu mengurangi jumlah jumPeserta07341
     */
    static void deletePeserta(){
        System.out.print("Masukan Kode Peserta yang akan di Hapus :");
        String search07341 = input.next();
        input.nextLine();
        int cari = 0;
        do{
            if (cari == jumPeserta07341){
                System.err.println("Tidak ada Data !");
                break;
            }else if (terdaftar07341[cari].getKodePeserta().equals(search07341)){
                if (cari == jumPeserta07341 - 1){
                    jumPeserta07341 = jumPeserta07341 - 1;
                }else {
                    for (int i = cari; i < jumPeserta07341; i++){
                        terdaftar07341[i] = terdaftar07341[i+1];
                        peserta07341[i] = peserta07341[i+1];
                    }
                    jumPeserta07341 = jumPeserta07341 - 1;
                    }
            break;
            }else {
                cari = cari + 1;
            }
        }while(true);
    }
}