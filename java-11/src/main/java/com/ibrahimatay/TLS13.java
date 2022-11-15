package com.ibrahimatay;

import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import java.io.*;

public class TLS13 {
    public static void main(String[] args) {

        //JEP 332: Transport Layer Security (TLS) 1.3
        // https://openjdk.org/jeps/332

        try {
            var factory = (SSLSocketFactory) SSLSocketFactory.getDefault();
            var socket = (SSLSocket) factory.createSocket("google.com", 443);

            socket.setEnabledProtocols(new String[]{"TLSv1.3"});
            socket.setEnabledCipherSuites(new String[]{"TLS_AES_128_GCM_SHA256"});

            socket.startHandshake();

            var out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())));
            out.println("GET / HTTP/1.0");
            out.println();
            out.flush();

            if(out.checkError()) {
                System.out.println("SSLSocketClient:  java.io.PrintWriter error");
            }

            var in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            String inputLine;
            while((inputLine = in.readLine()) != null) {
                System.out.println(inputLine);
            }

        } catch (Exception exception) {
            System.out.println("Error:"+exception.getMessage());
        }
    }
}
