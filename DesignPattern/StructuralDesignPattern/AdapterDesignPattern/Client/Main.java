package DesignPattern.StructuralDesignPattern.AdapterDesignPattern.Client;

import DesignPattern.StructuralDesignPattern.AdapterDesignPattern.Adaptee.WeightMachineForBabies;
import DesignPattern.StructuralDesignPattern.AdapterDesignPattern.Adapter.WeightMachineAdapter;
import DesignPattern.StructuralDesignPattern.AdapterDesignPattern.Adapter.WeightMachineAdapterImpl;

public class Main {
    public static void main(String[] args) {
        WeightMachineAdapter weightMachineAdapter = new WeightMachineAdapterImpl(new WeightMachineForBabies());
        System.out.println(weightMachineAdapter.getWeightInKg());
    }
}
