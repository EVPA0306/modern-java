package misc;

import java.util.ArrayList;
import java.util.List;

public class ClientSystem {

    private String name;

    private List<String> managedSubcategoryCodes;

    public ClientSystem(String name) {
        this();
        this.name = name;
    }

    public ClientSystem() {
        initCollections();
    }

    public static void main(String[] args) {
        ClientSystem clientSystem = new ClientSystem("Eugene");
        clientSystem.managedSubcategoryCodes.forEach(System.out::println);
    }

    private void initCollections() {
        managedSubcategoryCodes = new ArrayList<>();
        managedSubcategoryCodes.add("pr6");
        managedSubcategoryCodes.add("ps5");
        managedSubcategoryCodes.add("pr5");
        managedSubcategoryCodes.add("mgo");
        managedSubcategoryCodes.add("mro");
        managedSubcategoryCodes.add("ep6");
        managedSubcategoryCodes.add("ep5");
        managedSubcategoryCodes.add("ezc");
        managedSubcategoryCodes.add("ep2");
        managedSubcategoryCodes.add("elp");
        managedSubcategoryCodes.add("ps6");
        managedSubcategoryCodes.add("ps2");
        managedSubcategoryCodes.add("pr2");
        managedSubcategoryCodes.add("mgd");
        managedSubcategoryCodes.add("mre");
        managedSubcategoryCodes.add("hnw");
        managedSubcategoryCodes.add("hnr");
        managedSubcategoryCodes.add("elm");
        managedSubcategoryCodes.add("imp");
        managedSubcategoryCodes.add("irp");
        managedSubcategoryCodes.add("fr1");
        managedSubcategoryCodes.add("fr2");
        managedSubcategoryCodes.add("elo");
        managedSubcategoryCodes.add("opp");
        managedSubcategoryCodes.add("ort");
        managedSubcategoryCodes.add("osm");
        managedSubcategoryCodes.add("mrr");
        managedSubcategoryCodes.add("pas");
        managedSubcategoryCodes.add("prt");
        managedSubcategoryCodes.add("mgi");
        managedSubcategoryCodes.add("mri");
    }
}
