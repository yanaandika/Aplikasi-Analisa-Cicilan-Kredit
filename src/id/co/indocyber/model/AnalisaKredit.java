/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.co.indocyber.model;

/**
 *
 * @author user
 */
public class AnalisaKredit {
    private int pokokPinjman;
    private int uangMuka;
    private int bunga;
    private double durasi;
    private int jumlahTanggungan;
    private double pokokCicilan;
    private double cicilanPerbulan;
    private int penghasilanBulanan;
    double totalKredit;
    private int gaji;
    private int bonus;
    private int penghasilanTambahan;
    double limitPinjaman;
    double bungaCicilan;
    private boolean isApprove;

    public AnalisaKredit(int pokokPinjman, int uangMuka, int bunga, int durasi, int jumlahTanggungan,int gaji,int bonus,int penghasilanTambahan) {
        this.pokokPinjman = pokokPinjman;
        this.uangMuka = uangMuka;
        this.bunga = bunga;
        this.durasi = durasi;
        this.jumlahTanggungan = jumlahTanggungan;
        this.gaji = gaji;
        this.bonus = bonus;
        this.penghasilanTambahan = penghasilanTambahan;
    }
    
    
    
    
    public double pokokCicilan(){
        this.pokokCicilan = (int)(this.getPokokPinjman()-this.getUangMuka());
        return pokokCicilan;           
    }
    public double bungaCicilan(){
        this.bungaCicilan =  (double)(this.getDurasi()/12.0) * pokokCicilan() * (this.getBunga()/100.0);
        return bungaCicilan;
    }
    public double totalKredit(){
        this.totalKredit = (double)(pokokCicilan()+bungaCicilan());
        return totalKredit;
    }
    public double cicilanPerbulan(){
        this.cicilanPerbulan = Math.ceil((double)totalKredit()/this.getDurasi());
        return cicilanPerbulan;
    }
    public int penghasilBulanan(){
        this.penghasilanBulanan = (int)(this.getGaji()+this.getBonus()+this.getPenghasilanTambahan());
        return penghasilanBulanan;
    }
    public double limitPinjaman(){
        this.limitPinjaman = (double)(penghasilBulanan()/(this.getJumlahTanggungan()+1));
        return limitPinjaman;
    }
    

    /**
     * @return the pokokPinjman
     */
    public int getPokokPinjman() {
        return pokokPinjman;
    }

    /**
     * @param pokokPinjman the pokokPinjman to set
     */
    public void setPokokPinjman(int pokokPinjman) {
        this.pokokPinjman = pokokPinjman;
    }

    /**
     * @return the uangMuka
     */
    public int getUangMuka() {
        return uangMuka;
    }

    /**
     * @param uangMuka the uangMuka to set
     */
    public void setUangMuka(int uangMuka) {
        this.uangMuka = uangMuka;
    }

    /**
     * @return the bunga
     */
    public int getBunga() {
        return bunga;
    }

    /**
     * @param bunga the bunga to set
     */
    public void setBunga(int bunga) {
        this.bunga = bunga;
    }

    /**
     * @return the durasi
     */
    public double getDurasi() {
        return durasi;
    }

    /**
     * @param durasi the durasi to set
     */
    public void setDurasi(int durasi) {
        this.durasi = durasi;
    }

    /**
     * @return the jumlahTanggungan
     */
    public int getJumlahTanggungan() {
        return jumlahTanggungan;
    }

    /**
     * @param jumlahTanggungan the jumlahTanggungan to set
     */
    public void setJumlahTanggungan(int jumlahTanggungan) {
        this.jumlahTanggungan = jumlahTanggungan;
    }
    
    

    /**
     * @return the gaji
     */
    public int getGaji() {
        return gaji;
    }

    /**
     * @param gaji the gaji to set
     */
    public void setGaji(int gaji) {
        this.gaji = gaji;
    }

    /**
     * @return the bonus
     */
    public int getBonus() {
        return bonus;
    }

    /**
     * @param bonus the bonus to set
     */
    public void setBonus(int bonus) {
        this.bonus = bonus;
    }

    /**
     * @return the penghasilanTambahan
     */
    public int getPenghasilanTambahan() {
        return penghasilanTambahan;
    }

    /**
     * @param penghasilanTambahan the penghasilanTambahan to set
     */
    public void setPenghasilanTambahan(int penghasilanTambahan) {
        this.penghasilanTambahan = penghasilanTambahan;
    }

    /**
     * @return the isApprove
     */
    public boolean isIsApprove(double limit,double cicilan) {
        boolean setuju = false;
        if(limitPinjaman() > cicilanPerbulan())
        setuju = true;
        return setuju;
    }
  
    
}
