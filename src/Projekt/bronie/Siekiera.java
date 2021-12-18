package Projekt.bronie;

import Projekt.bronie.zachowaniaBroni.OdglosTnace;
import Projekt.bronie.zachowaniaBroni.TnaceObrazenia;

public class Siekiera extends Bron {
    public final String className = this.getClass().getSimpleName();

    public String getClassName() {
        return className;
    }

    public Siekiera() {
        setOdglosBroni(new OdglosTnace());
        setZadawanieObrazenBronia(new TnaceObrazenia());
    }


}
