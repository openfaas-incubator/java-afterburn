package com.openfaas;

import java.io.*;

public class Parser {
    public void acceptIncoming(DataInputStream dataStream, BufferedWriter out, HeaderReader parser) throws IOException {

        StringBuffer rawHeader = parser.readHeader();
        System.err.println("rawHeader: \'"+ rawHeader + "\''");

        HttpHeader header = new HttpHeader(rawHeader.toString());

        if(header.getMethod() != null) {
            System.err.println("\'" + header.getMethod() + "\' method");
            System.err.println(header.getContentLength()  + " bytes");
            
            byte[] body = header.readBody(dataStream);

            function.Handler handler = new function.Handler();
            String functionResponse = handler.function(new String(body), header.getMethod());
            
            HttpResponse response = new HttpResponse();
            response.setStatus(200);
            response.setContentType("text/plain");
            StringBuffer outBuffer = response.serialize(functionResponse);

            out.write(outBuffer.toString(), 0, outBuffer.length());
            out.flush();
        }
    }
}
