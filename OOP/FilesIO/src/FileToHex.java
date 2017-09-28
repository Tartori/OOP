import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Created by julia on 24-Feb-17.
 */
public class FileToHex {
    public static String toHex(String filename) throws IOException {
        String ret = "";
        File file = new File(filename);
        boolean exists = file.exists();
        if(!exists){
            return ret;
        }
        byte[] bytes = Files.readAllBytes(Paths.get(filename));
        for (int i=0; i<bytes.length ; i++) {
            ret+=Integer.toHexString(bytes[i]) + " ";
        }
        return ret;
    }
}
