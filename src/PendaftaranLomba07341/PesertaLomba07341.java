package PendaftaranLomba07341;

public class PesertaLomba07341 extends BiodataLomba07341 {
    private String umur07341;
    
    public PesertaLomba07341 (String umur07341,String nama07341,String noTelp07341,String alamat07341){
        super(nama07341,noTelp07341,alamat07341);
        this.umur07341 = umur07341;
    }
    /*
     * Fuction dibawah ini merupakan getter dan setter (Accessor)
     * yang digunakan untuk mengakses variable yang terenkapsulasi 
     * (dalam kasus ini private)
    */
    
    public String getUmur(){
        return umur07341;
    }
    public void setUmur(String umur07341){
        this.umur07341 = umur07341;
    }
}
