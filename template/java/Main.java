import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import function.*;

public class Main {

    public static void main(String[] args) {
        try {
            String input = readStdin();
            function.Handler h = new function.Handler();
            System.out.print(h.invoke(input, "POST"));

        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    private static String readStdin() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = "";
        while(true) {
            String line = br.readLine();
            if(line==null) {
                break;
            }
            input = input + line + "\n";
        }
        return input;
    }
}
