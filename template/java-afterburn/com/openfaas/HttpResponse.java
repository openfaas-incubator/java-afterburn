package com.openfaas;
public class HttpResponse {
    public HttpResponse() {

    }
    
    public void setStatus(int status) {
        this.status = status;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public StringBuffer serialize(String body) {
        StringBuffer outBuffer = new StringBuffer();
        outBuffer.append("HTTP/1.1 " + this.status + " OK\r\n");
        outBuffer.append("Content-Length: "+body.length()+"\r\n");
        outBuffer.append("Connection: Close\r\n");
        if (contentType != null) {
            outBuffer.append("Content-Type: "+contentType+"\r\n");
        }

        outBuffer.append("\r\n");
        outBuffer.append(body.toString());
        return outBuffer;
    }

    private int status;

    private String contentType;
}