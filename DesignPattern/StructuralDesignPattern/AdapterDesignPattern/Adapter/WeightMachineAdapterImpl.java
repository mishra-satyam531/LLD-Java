package DesignPattern.StructuralDesignPattern.AdapterDesignPattern.Adapter;

import DesignPattern.StructuralDesignPattern.AdapterDesignPattern.Adaptee.WeightMachine;

public class WeightMachineAdapterImpl implements WeightMachineAdapter {
    WeightMachine weightMachine;
    
    public WeightMachineAdapterImpl(WeightMachine weightMachine) {
        this.weightMachine = weightMachine;
    }

    @Override
    public double getWeightInKg() {
        double weightInPound = weightMachine.getWeightInPound();
        
        double weightInKg = weightInPound * .45;
        return weightInKg;
    }
}
