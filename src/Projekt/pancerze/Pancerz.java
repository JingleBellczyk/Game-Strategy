package Projekt.pancerze;

import Projekt.pancerze.zachowaniaPancerzy.OchronaPancerza;

public abstract class Pancerz implements OchronaPancerza {
    protected OchronaPancerza ochronaPancerza;

    public OchronaPancerza getZachowaniePancerza() {
        return ochronaPancerza;
    }

    public void setOchronaPancerza(OchronaPancerza ochronaPancerza) {
        this.ochronaPancerza = ochronaPancerza;
    }

    @Override
    public int plusPunkty() {
        return ochronaPancerza.plusPunkty();
    }
}
