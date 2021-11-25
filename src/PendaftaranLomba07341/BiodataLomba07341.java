package PendaftaranLomba07341;

public class BiodataLomba07341 {
    protected String nama07341,noTelp07341,alamat07341;
    
    public BiodataLomba07341(String nama07341,String noTelp07341,String alamat07341){
        this.nama07341 = nama07341;
        this.noTelp07341 = noTelp07341;
        this.alamat07341 = alamat07341;        
    }
    /*
    *funtion dibawah ini merupakan funtion getter dan setter (accessor)
    *yang digunakan untuk mengakses variable yang terenkapsulasi
    *(dalam kasus ini protected)
    */
    
    public String getNama(){
        return nama07341;        
    }
    
    public void setNama(String nama07341){
        this.nama07341 = nama07341;        
    }
    public String getNoTelp(){
        return noTelp07341;
    }
    public void setNoTelp(String noTelp07341){
        this.noTelp07341 = noTelp07341;        
    }
    public String getAlamat(){
        return alamat07341;        
    }
    public void setAlamat(String alamat07341){
        this.alamat07341 = alamat07341;
    }
}