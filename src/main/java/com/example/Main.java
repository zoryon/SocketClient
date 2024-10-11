package com.example;

import java.io.IOException;
import java.io.PrintWriter;
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

        String stringa = scanner.nextLine();
        PrintWriter out = new PrintWriter(s.getOutputStream(), true);
        out.println(stringa); 

        Scanner input = new Scanner(s.getInputStream());
        if (input.hasNextLine()) {
            String risposta = input.nextLine();
            System.out.println("Risposta del server: " + risposta);
        }

        scanner.close();
        input.close();
        out.close();
        s.close();
    }
}