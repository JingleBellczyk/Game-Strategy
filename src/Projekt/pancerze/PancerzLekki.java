package Projekt.pancerze;

import Projekt.pancerze.zachowaniaPancerzy.OdpowiedzialnePancerze;

public class PancerzLekki extends Pancerz {
    public PancerzLekki() {
        setOchronaPancerza(new OdpowiedzialnePancerze());
    }
}
