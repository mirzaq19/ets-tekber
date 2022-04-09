package com.example.formlearn;

import androidx.annotation.NonNull;

public class Mahasiswa {
    private String nama;
    private String nrp;
    private double ipk;
    private boolean jenis_kelamin;

    public Mahasiswa(String nama, String nrp, double ipk, boolean jenis_kelamin) {
        this.nama = nama;
        this.nrp = nrp;
        this.ipk = ipk;
        this.jenis_kelamin = jenis_kelamin;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNrp() {
        return nrp;
    }

    public void setNrp(String nrp) {
        this.nrp = nrp;
    }

    public double getIpk() {
        return ipk;
    }

    public void setIpk(double ipk) {
        this.ipk = ipk;
    }

    public String getJenis_kelamin() {
        if(this.jenis_kelamin){
            return "Laki-laki";
        }
        return "Perempuan";
    }

    public void setJenis_kelamin(boolean jenis_kelamin) {
        this.jenis_kelamin = jenis_kelamin;
    }

    public boolean isLaki(){
        return this.jenis_kelamin;
    }

    public boolean isPerempuan(){
        return !this.jenis_kelamin;
    }

    @NonNull
    @Override
    public String toString() {
        String res_str = String.format("Nama\t\t\t\t\t\t\t\t\t\t: %s\n",nama);
        res_str += String.format("NRP\t\t\t\t\t\t\t\t\t\t\t\t: %s\n",nrp);
        res_str += String.format("IPK\t\t\t\t\t\t\t\t\t\t\t\t\t: %s\n",ipk);
        res_str += String.format("Jenis Kelamin\t\t: %s",jenis_kelamin);
        return res_str;
    }
}
