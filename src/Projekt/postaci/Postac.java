package Projekt.postaci;

import Projekt.bronie.Bron;
import Projekt.pancerze.Pancerz;

public abstract class Postac {


    protected String imie;
    protected Bron bron;
    protected Pancerz pancerz;

    public Postac() {
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public Bron getBron() {
        return bron;
    }

    public void setBron(Bron bron) {
        this.bron = bron;
    }

    public Pancerz getPancerz() {
        return pancerz;
    }

    public void setPancerz(Pancerz pancerz) {
        this.pancerz = pancerz;
    }

    public void prezentujBron() {
        System.out.print("Moja bron i jej dzwiek: " + getBron().getClass().getSimpleName());
        bron.getOdglosBroni().wydajOdglos();
    }

    public void idzDoPrzodu() {
        System.out.println("Jestem " + getClass().getSimpleName() + " " + getImie() + " i ide krok do przodu");
    }


}
