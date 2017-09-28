import java.io.IOException;

/**
 * Created by julia on 24-Feb-17.
 */
public class ConsoleUi {
    public static void main(String[] args){
        try {
            System.out.println(FileToHex.toHex(args[0]));
        } catch (IOException e) {
            System.out.println("LoL");
            e.printStackTrace();
        }
    }
}
