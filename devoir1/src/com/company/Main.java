package com.company;

import com.compagny.logic.Controller;
import com.compagny.vues.Connexion;

public class Main {

    public static void main(String[] args) {
        Controller controller = new Controller("connection");
        Connexion.run();
    }
}
