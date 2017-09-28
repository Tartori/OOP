/**
 * Created by julia on 16-Dec-16.
 */
public abstract class Vehicle {
    private double maxSpeed;
    private double currentSpeed;
    public Vehicle(double maxSpeed ){
        this.maxSpeed=maxSpeed;
    }
    public abstract void accelerate();

    public void pedalToTheMetal(){
        while(Math.abs(maxSpeed-currentSpeed)>=1e-13){
            accelerate();
        }
    }

    public double getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(double maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public double getCurrentSpeed() {
        return currentSpeed;
    }

    public void setCurrentSpeed(double currentSpeed) {
        this.currentSpeed = currentSpeed;
    }
}
