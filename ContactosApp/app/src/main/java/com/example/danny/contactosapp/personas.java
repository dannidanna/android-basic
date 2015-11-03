package com.example.danny.contactosapp;

/**
 * Created by Danny on 02/11/2015.
 */
public class personas {
    private String nom;
    private String apell;
    private int ed;
    private int cel;
    private int tel;
    private String ema;

    public personas(){}

    public personas(String nombre, String apellido, int edad, int celular,int telefono, String email){
        this.nom = nombre;
        this.apell= apellido;
        this.ed=edad;
        this.cel=celular;
        this.tel=telefono;
        this.ema=email;
    }

    public String getNom(){
        return nom;
    }
    public void setNom(String nom){
        this.nom=nom;
    }
    public String getApell(){
        return apell;
    }
    public void setApell(String apell){
        this.apell=apell;
    }
    public int getEd(){
        return ed;
    }
    public void setEd(int ed){
        this.ed=ed;
    }
    public int getCel(){
        return cel;
    }
    public void setCel(int cel){
        this.cel=cel;
    }
    public int getTel(){
        return tel;
    }
    public void setTel(int tel){
        this.tel=tel;
    }
    public String getEma(){
        return ema;
    }
    public void setEma(String ema){
        this.ema=ema;
    }

}
