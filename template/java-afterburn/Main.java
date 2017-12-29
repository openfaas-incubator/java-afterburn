import java.io.*;
import com.openfaas.*;

public class Main {
    
    public static void main(String[] args) throws Exception {

        DataInputStream dataStream = new DataInputStream(System.in);
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        HeaderReader headerReader = new HeaderReader(dataStream);
        
        Parser parser = new Parser();

        while(true) {
            parser.acceptIncoming(dataStream, out, headerReader);
        }
    }
}
