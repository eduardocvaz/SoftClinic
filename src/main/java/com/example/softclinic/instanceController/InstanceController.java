package com.example.softclinic.instanceController;

public interface InstanceController {
    public enum StoreTypes{
        ADMIN, MED, RECP
    }
    public static StoreTypes currentInstanceType = StoreTypes.ADMIN;
}
