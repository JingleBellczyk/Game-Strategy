package Projekt.bronie;

import Projekt.bronie.zachowaniaBroni.OdglosUderzajace;
import Projekt.bronie.zachowaniaBroni.UderzajaceObrazenia;

public class Bat extends Bron {
    public final String className = this.getClass().getSimpleName();

    public String getClassName() {
        return className;
    }

    public Bat() {
        setOdglosBroni(new OdglosUderzajace());
        setZadawanieObrazenBronia(new UderzajaceObrazenia());
    }

    @Override
    public void prezentujBron() {
        System.out.println("Moja bron to bat\n");

    }
}
