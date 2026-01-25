package Splitwise.Split;

public class PercentSplit extends Split {
    private double percentage;
    public PercentSplit(User user, double percentage) {
        super(user);
        this.percentage = percentage;
    }

    public double getPercentage() {
        return this.percentage;
    }
    
}
