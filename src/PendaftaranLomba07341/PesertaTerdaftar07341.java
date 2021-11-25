package PendaftaranLomba07341;

public class PesertaTerdaftar07341 {
    private PesertaLomba07341 peserta07341;
    private int indexLomba07341;
    private String kodePeserta07341;
    
    public PesertaTerdaftar07341(PesertaLomba07341 peserta07341, int indexLomba07341,String kodePeserta07341){
        this.peserta07341 = peserta07341;
        this.indexLomba07341 = indexLomba07341;
        this.kodePeserta07341 = kodePeserta07341;
    }
    /*
     * Fuction dibawah ini merupakan getter dan setter (Accessor)
     * yang digunakan untuk mengakses variable yang terenkapsulasi 
     * (dalam kasus ini private)
    */
    public PesertaLomba07341 getPeserta(){
        return peserta07341;
    }
    public void setPeserta(PesertaLomba07341 peserta07341){
        this.peserta07341 = peserta07341;
    }
    public int getIndexLomba(){
        return indexLomba07341;
    }
    public void setIndexLomba(int indexLomba07341){
        this.indexLomba07341 = indexLomba07341;
    }
    public String getKodePeserta(){
        return kodePeserta07341;
    }
    public void setKodePeserta(String kodePeserta07341){
        this.kodePeserta07341 = kodePeserta07341;
    }
}