package Projekt.pancerze;

import Projekt.pancerze.zachowaniaPancerzy.GlupiePancerze;
import Projekt.pancerze.zachowaniaPancerzy.OdpowiedzialnePancerze;

public class StrojHotDoga extends Pancerz {
    public StrojHotDoga() {
        setOchronaPancerza(new GlupiePancerze());
    }
}
