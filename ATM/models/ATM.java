package ATM.models;

import ATM.state.MachineState;

public class ATM {
    private MachineState state;
    private int atmBalance;
    private int numOfTwoThousandNotes;
    private int numOfFiveHundredNotes;
    private int numOfTwoHundredNotes;
    private int numOfOneHundredNotes;

    public ATM(MachineState state, int atmBalance, int numOfTwoThousandNotes, int numOfFiveHundredNotes, int numOfTwoHundredNotes, int numOfOneHundredNotes) {
        this.state = state;
        this.numOfTwoThousandNotes = numOfTwoThousandNotes;
        this.numOfFiveHundredNotes = numOfFiveHundredNotes;
        this.numOfTwoHundredNotes = numOfTwoHundredNotes;
        this.numOfOneHundredNotes = numOfOneHundredNotes;
        this.atmBalance = 2000 * numOfTwoThousandNotes + 500 * numOfFiveHundredNotes + 200 * numOfTwoHundredNotes + 100 * numOfOneHundredNotes;
    }

    public MachineState getState() {
        return state;
    }

    public void setState(MachineState state) {
        this.state = state;
    }

    public int getAtmBalance() {
        return atmBalance;
    }

    public void setAtmBalance(int atmBalance) {
        this.atmBalance = atmBalance;
    }

    public int getNumOfTwoThousandNotes() {
        return numOfTwoThousandNotes;
    }

    public void setNumOfTwoThousandNotes(int numOfTwoThousandNotes) {
        this.numOfTwoThousandNotes = numOfTwoThousandNotes;
    }

    public int getNumOfFiveHundredNotes() {
        return numOfFiveHundredNotes;
    }

    public void setNumOfFiveHundredNotes(int numOfFiveHundredNotes) {
        this.numOfFiveHundredNotes = numOfFiveHundredNotes;
    }

    public int getNumOfTwoHundredNotes() {
        return numOfTwoHundredNotes;
    }

    public void setNumOfTwoHundredNotes(int numOfTwoHundredNotes) {
        this.numOfTwoHundredNotes = numOfTwoHundredNotes;
    }

    public int getNumOfOneHundredNotes() {
        return numOfOneHundredNotes;
    }

    public void setNumOfOneHundredNotes(int numOfOneHundredNotes) {
        this.numOfOneHundredNotes = numOfOneHundredNotes;
    }
    
}
