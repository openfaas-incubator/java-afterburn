package com.openfaas;

import java.io.DataInputStream;
import java.io.*;

public class HttpHeader {
    private String method;
    private Integer contentLength;

    public HttpHeader(String raw)  {
        String[] parts  = raw.split("\n");

        for(int i=0;i<parts.length;i++) {
            String line = parts[i];
            if (i==0 && line.length() > 0) {
                method = line.substring(0,line.indexOf(' '));
            }
            if (line.startsWith("Content-Length:")) {
                String contentLengthStr = line.substring(line.indexOf(" ")+1);
                contentLength = Integer.parseInt(contentLengthStr);
            }
        }
    }

    public byte[] readBody(DataInputStream stream) throws IOException {
        int len = getContentLength();
        byte[] bytes = new byte[len];
        System.err.println(len);
        for (int i =0;i<len; i++) {             
            bytes[i] = stream.readByte();
        }
        return bytes;
    }

    public Integer getContentLength() {
        return this.contentLength;
    }

    public String getMethod() {
        return this.method;
    }
}