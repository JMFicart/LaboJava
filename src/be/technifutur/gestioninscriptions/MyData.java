package be.technifutur.gestioninscriptions;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class MyData implements Serializable {
        public Map<String, ActivityType> list = new TreeMap<>();
}

