package com.example;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

import com.example.lib.ResponseMessages;

public class Main {
    public static void main(String[] args) throws UnknownHostException, IOException {
        Socket s = new Socket("localhost", 3000);

        BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
        DataOutputStream out = new DataOutputStream(s.getOutputStream());
        Scanner keyboard = new Scanner(System.in);

        int choice;
        do {
            menu();

            String strChoice = sanitize(in, out, keyboard);
            choice = Integer.parseInt(strChoice);
            switch (choice) {
                case 0:
                    System.out.println("Connessione chiusa.");
                    keyboard.close();
                    s.close();
                    break;
                case 1:
                case 2:
                case 3:
                case 4:
                    sendReq(out, keyboard);
                    break;
                default:
            }
            
            if (!s.isClosed()) showRes(in);
        } while (choice != 0);
    }

    public static void menu() {
        System.out.println("\n- - - MENU - - -");
        System.out.println("1) Trasformare stringa in maiuscolo");
        System.out.println("2) Trasformare stringa in minuscolo");
        System.out.println("3) Ribaltare i caratteri della stringa");
        System.out.println("4) Contare il numero di caratteri");
        System.out.println("0) Esci");
        System.out.print(": ");
    }

    public static String newLine() {
        return "\n";
    }

    public static String sanitize(BufferedReader in, DataOutputStream out, Scanner keyboard) throws IOException {
        String ans;
        boolean validChoice;
        do {
            ans = keyboard.nextLine();
            out.writeBytes(ans + newLine());

            String serverResponse = in.readLine();

            if (serverResponse.equals(ResponseMessages.getINVALID_CHOICE())) {
                System.out.println(serverResponse);
                validChoice = false;
            } else {
                validChoice = true;
            }
        } while (!validChoice);

        return ans;
    }

    public static void sendReq(DataOutputStream out, Scanner keyboard) throws IOException {
        System.out.println("Inserisci la stringa da modificare: ");
        out.writeBytes(keyboard.nextLine() + newLine());
    }

    public static String catchRes(BufferedReader in) throws IOException {
        return in.readLine();
    }

    public static void showRes(BufferedReader in) throws IOException {
        System.out.println(catchRes(in));
    }
}