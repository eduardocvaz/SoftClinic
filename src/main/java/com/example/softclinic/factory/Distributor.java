package com.example.softclinic.factory;

import com.example.softclinic.instanceController.InstanceController;

public class Distributor implements AbstractFactory{
    private static Distributor instance;

    AbstractFactory factory;

    public static Distributor getInstance() {
        if(instance == null) instance = new Distributor();
        return instance;
    }

    private Distributor() {
        switch(InstanceController.currentInstanceType) {
            case ADMIN:
                factory = new AdminFactory();
                break;
            case MED:
                factory = new MedFactory();
                break;

            case RECP:
                factory = new RecpFactory();
                break;

            default:
                factory = null;
        }
    }
}
