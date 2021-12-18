package Projekt.bronie;

import Projekt.bronie.zachowaniaBroni.OdglosUderzajace;
import Projekt.bronie.zachowaniaBroni.UderzajaceObrazenia;

public class Linijka extends Bron {

    public final String className = this.getClass().getSimpleName();

    public String getClassName() {
        return className;
    }

    public Linijka() {
        setOdglosBroni(new OdglosUderzajace());
        setZadawanieObrazenBronia(new UderzajaceObrazenia());
    }


}
