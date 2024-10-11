package com.example;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws UnknownHostException, IOException {
        System.out.println("Client partito");
        Socket s = new Socket("localhost", 3000);
        System.out.println("Il client si è collegato");

        Scanner scanner = new Scanner(System.in);
        System.out.println("Inserisci una stringa: ");
        Scanner input = new Scanner(s.getInputStream());
        DataOutputStream out = new DataOutputStream(s.getOutputStream());

        String stringa;
        do {
            stringa = scanner.nextLine();
            out.writeBytes(stringa + "\n");

            if (input.hasNextLine()) {
                String risposta = input.nextLine();
                System.out.println("Risposta del server: " + risposta);
            }
        } while (!stringa.equals("!"));
        
        out.close();
        input.close();
        scanner.close();
        s.close();
    }
}