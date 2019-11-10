package sample;

import sample.Investors;
import sample.Realization;

import java.io.IOException;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.SplittableRandom;

public class Mainn {
    static Scanner in;

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Investors investors = new Investors();
        Investors investorsFileRead = new Investors();
        Realization realization = new Realization("Investors.txt");

        in = new Scanner(System.in);
        int num = -1;
        boolean check = false;
        do {
            try {
                System.out.print("Input a number of investors: ");
                String number = in.nextLine();
                num = Integer.parseInt(number);
                if (num > 0)
                    check = true;
            } catch (InputMismatchException exc) {
                System.out.println(exc.getLocalizedMessage());
            } catch (Exception exc) {
                System.out.println(exc.getLocalizedMessage());
            }
        } while (!check);


        for (int i = 0; i < num; i++) {
            investors.addToList(getNewInvestor());
        }
        System.out.println(investors);

        System.out.println("Investors with FIO Investor: " + investors.getWithFIO("Investor"));

        System.out.println("Investors with deposit greater than 10000: " + investors.getWithGraterDeposit(10000));

        System.out.println("Investors with term deposit greater than 12: " + investors.getWithGraterTempDeposit(12));

        System.out.println("Enter FIO for delete: ");
        System.out.println("Delete investors with FIO: " + investors.deleteWithFIO(in.nextLine()));

        System.out.println(realization.New(investors));
        System.out.println(realization.Deserialization(investorsFileRead));
        System.out.println(investors + "\n" + investorsFileRead);
    }


    private static Investor getNewInvestor() {
        String FIO;
        String contractNumber;
        String address;
        String deposit;
        String contractTerm;

        do {
            System.out.print("Input FIO: ");
            FIO = in.nextLine();
        }
        while (!Investor.CheckCorrectFIO(FIO));

        System.out.print("Input Contract Number: ");
        contractNumber = in.nextLine();

        System.out.print("Input address: ");
        address = in.nextLine();

        do {
            System.out.print("Input deposit: ");
        }
        while (!Investor.CheckCorrectNumber(deposit = in.nextLine()));

        do {
            System.out.print("Input Term: ");
        } while (!Investor.CheckCorrectNumber(contractTerm = in.nextLine()));

        return new Investor(FIO, contractNumber, address, Integer.parseInt(deposit), Integer.parseInt(contractTerm));
    }
}