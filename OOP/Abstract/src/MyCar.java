import java.util.Scanner;

public class MyCar extends Vehicle {

    public MyCar(double maxSpeed) {
        super(maxSpeed);
    }

    public void accelerate() {
        System.out.print(getCurrentSpeed() + " ");
        setCurrentSpeed(getCurrentSpeed() + 1.0);
    }

    public static void main(String[] arg) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the max speed:");
        int n = scanner.nextInt();
        scanner.close();

        MyCar myCar = new MyCar(n);
        System.out.println("Current Speed:" + myCar.getCurrentSpeed());
        System.out.println("Max Speed:" + myCar.getMaxSpeed());
        myCar.pedalToTheMetal();

    }
}