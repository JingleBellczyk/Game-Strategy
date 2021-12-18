package Projekt.bronie;

import Projekt.bronie.zachowaniaBroni.OdglosTnace;
import Projekt.bronie.zachowaniaBroni.TnaceObrazenia;

public class DiamentowyMiecz extends Bron {

    public final String className = this.getClass().getSimpleName();

    public String getClassName() {
        return className;
    }

    public DiamentowyMiecz() {
        setOdglosBroni(new OdglosTnace());
        setZadawanieObrazenBronia(new TnaceObrazenia());
    }
}
