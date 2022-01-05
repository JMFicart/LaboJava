package be.technifutur.gestioninscriptions;

import java.util.concurrent.Callable;

public interface MenuNode {
    String getName();

    Callable getAction();
}
