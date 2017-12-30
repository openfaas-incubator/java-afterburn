package com.openfaas;

import java.io.*;

public class HeaderReader {
    private java.io.DataInputStream inputStream;

    public HeaderReader(java.io.DataInputStream inputStream) {
        this.inputStream = inputStream;
    }

    public StringBuffer readHeader() throws IOException {
        StringBuffer header = new StringBuffer();
        
        String line;
        while(true)  {
            line = readLine();
            if (line.equals("\n")) {
                break;
            }
            
            header.append(line);
        }
        return header;
    }

    private  String readLine() throws IOException {
        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        // int terminateHeader = (int)'\n';

        char character;
        while ((character = (char)this.inputStream.read()) > -1) {          
            
            if (character == '\r') {
                continue;
            }

            buffer.write(character);

            if (character == '\n') {
                break;
            }

        }

        return buffer.toString();
    }
}
