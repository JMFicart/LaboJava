package be.technifutur.gestioninscriptions;

import java.io.Serializable;
import java.util.Map;
import java.util.TreeMap;

public class DataActivity implements Serializable {
    public Map<String, Activity> list = new TreeMap<>();
}
