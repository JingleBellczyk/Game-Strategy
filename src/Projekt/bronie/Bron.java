package Projekt.bronie;

import Projekt.bronie.zachowaniaBroni.OdglosBroni;
import Projekt.bronie.zachowaniaBroni.ZadawanieObrazenBronia;

public abstract class Bron implements OdglosBroni, ZadawanieObrazenBronia {
    protected OdglosBroni odglosBroni;
    protected ZadawanieObrazenBronia zadawanieObrazenBronia;



    public ZadawanieObrazenBronia getZadawanieObrazenBronia() {
        return zadawanieObrazenBronia;
    }

    public void setZadawanieObrazenBronia(ZadawanieObrazenBronia zadawanieObrazenBronia) {
        this.zadawanieObrazenBronia = zadawanieObrazenBronia;
    }

    public OdglosBroni getOdglosBroni() {
        return odglosBroni;
    }

    public void setOdglosBroni(OdglosBroni odglosBroni) {
        this.odglosBroni = odglosBroni;
    }

    public void prezentujBron() {
        System.out.println(getOdglosBroni());
    }


    @Override
    public void wydajOdglos() {
        odglosBroni.wydajOdglos();
    }

    @Override
    public int zran() {
        return zadawanieObrazenBronia.zran();
    }


}
