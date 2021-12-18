package Projekt;

import Projekt.bronie.*;
import Projekt.pancerze.*;
import Projekt.postaci.*;

import java.util.*;

public class Menu {
    Scanner scan = new Scanner(System.in);
    public List<Postac> listaPostaci = new ArrayList<>();
    public List<Integer> listaPunktowZycia = new ArrayList<>();
    public int ile = 0; //indeks z listy postaci ostatnio uzywanej

    //tworzenie postaci

    public int wybierzPostac() {
        System.out.println("Wybierz postac:\n" +
                "1 - Krol\n" +
                "2 - Elf\n" +
                "3 - Nauczyciel\n" +
                "4 - Smok");

        int n = checkedNumber(4);
        return n;
    }

    public String wybierzImie() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Podaj imie: ");
        String imie = scan.nextLine();
        return imie;
    }

    public Bron ustawBron() {
        System.out.println("Wybierz bron\n" +
                "1 - Diamentowy miecz\n" +
                "2 - Linijka\n" +
                "3 - Siekiera\n" +
                "4 - Bat");
        int n = checkedNumber(4);
        Bron b = new DiamentowyMiecz();


        switch (n) {
            case 2:
                b = new Linijka();
                break;
            case 3:
                b = new Siekiera();
                break;
            case 4:
                b = new Bat();
                break;
        }
        return b;
    }

    public Pancerz ustawPancerz() {
        System.out.println("Wybierz pancerz:\n" +
                "1 - Diamentoowa Zbroja\n" +
                "2 - Fartuch\n" +
                "3 - Pancerz Lekki\n" +
                "4 - Stroj Hotdoga");
        int n = checkedNumber(4);
        Pancerz p = new DiamentowaZbroja();


        switch (n) {
            case 2:
                p = new Fartuch();
                break;
            case 3:
                p = new PancerzLekki();
                break;
            case 4:
                p = new StrojHotDoga();
                break;
        }
        return p;
    }

    public void stworzPostac() {
        ile++;

        int n = wybierzPostac(); //zwraca liczbe
        String imie = wybierzImie(); //zwraca String

        Postac p = new Krol();
        switch (n) {
            case 1:
                p = new Krol(imie, ustawBron(), ustawPancerz());
                break;
            case 2:
                p = new Elf(imie, ustawBron(), ustawPancerz());
                break;
            case 3:
                p = new Nauczyciel(imie, ustawBron(), ustawPancerz());
                break;
            case 4:
                p = new Smok(imie, ustawBron(), ustawPancerz());
                break;
        }
        listaPunktowZycia.add(100 + p.getPancerz().plusPunkty()); //kazdy dostaje na poczatek 100 punktow
        listaPostaci.add(p);
        menu1();
    }

    //wyswietlenie i wybor
    public void wyswietl() {
        for (int i = 0; i < listaPostaci.size(); i++) {
            System.out.println((i + 1) + " " + listaPostaci.get(i).getClass().getSimpleName() + " "
                    + listaPostaci.get(i).getImie() + " "
                    + listaPostaci.get(i).getBron().getClass().getSimpleName() + " "
                    + listaPostaci.get(i).getPancerz().getClass().getSimpleName() + " "
                    + "ilosc punktow zycia: " + listaPunktowZycia.get(i)
            );
        }

    }

    public void wyborZListy() {
        System.out.println("Wybierz indeks z listy postaci ktora chcesz wybrac");
        int n = checkedNumber(listaPostaci.size());
        ile = n;
    }

    public void staty(int n1, int p1, int n2, int p2) {
        System.out.println("Stan postaci: ");
        System.out.println(listaPostaci.get(n1).getImie() + " punkty: " + p1);
        System.out.println(listaPostaci.get(n2).getImie() + " punkty " + p2);
    }

    public int runda(int n, int p1, int z2) { //ustawia punkty po walce
        listaPostaci.get(n).getBron().wydajOdglos();
        if (p1 + z2 < 0)
            p1 = 0;
        else
            p1 = p1 + z2;

        return p1;
    }

    public void walka() {
        System.out.println("Walka!!!");
        wyswietl();
        wyborZListy();
        int n1 = ile - 1;
        wyborZListy();
        int n2 = ile - 1;

        int p1 = listaPunktowZycia.get(n1);
        int p2 = listaPunktowZycia.get(n2);
        int z1 = listaPostaci.get(n1).getBron().zran(); // zwraca ujemne punkty
        int z2 = listaPostaci.get(n1).getBron().zran(); // zwraca ujemne punkty

        boolean b = true;
        int i = 1; //licznik rund
        staty(n1, p1, n2, p2);
        while ((b == true) && p1 > 0 && p2 > 0) {

            System.out.println("Runda nr " + i);

            p1 = runda(n1, p1, z2);
            p2 = runda(n1, p2, z1);

            if (p1 == 0) {
                if (p2 == 0) {
                    System.out.println("Remis!");
                    b = false;
                } else {
                    System.out.println("Koniec walki, wygral/a: " + listaPostaci.get(n2).getImie());
                    b = false;
                }
            } else if (p2 == 0) {
                System.out.println("Koniec walki, wygral/a: " + listaPostaci.get(n1).getImie());
                b = false;
            }

            if (b) {
                staty(n1, p1, n2, p2);
                System.out.println("Kliknij: \n" +
                        "1 - jesli chcesz zakonczyc walke\n" +
                        "2 - jesli chcesz kontynuowac");
                int n = checkedNumber(2);
                if (n == 1) {
                    b = false;
                    listaPunktowZycia.set(n1, p1);
                    listaPunktowZycia.set(n2, p2);
                }
            }
            i++;
        }
        menu1();
    }

    public static int checkedNumber(int n) { //spawdza czy liczba jest z od zakresu 1 do n
        int w;
        Scanner scan = new Scanner(System.in);
        try {
            w = scan.nextInt();
        } catch (InputMismatchException e) {
            scan.nextLine();
            w = 0;
        }

        while (w < 1 || w > n) {
            System.out.println("Podaj poprawna liczbe");
            try {
                w = scan.nextInt();
            } catch (InputMismatchException e) {
                scan.nextLine();
                w = 0;
            }

        }
        return w;
    }

    //start
    public void start() {
        int ile = 0;
        System.out.println("Witaj szanowny uzytkowniku!!\n" +
                "Wybierz co chcesz zrobic:\n" +
                "1 - Stworz Postac\n" +
                "2 - Zakoncz"
        );
        int n = checkedNumber(2);
        if (n == 1) stworzPostac();
        if (n == 2) stop();
    }

    public void stop() {
        System.out.println("Zegnaj!!! :(((");
    }

    public void menu1() {
        System.out.println("Drogi uzytkowniku, co chcesz teraz zrobic?:\n" +
                "1 - stworz kolejna postac\n" +
                "2 - wyswietl liste postaci\n" +
                "3 - prezentuj bron\n" +
                "4 - idz do przodu");
        if (listaPostaci.size() > 1)
            System.out.println("5 - walka"); // nie wyswiela sie gdy nie ma conajmniej 2 bohaterow
        System.out.println("6 - zakoncz");

        int n = checkedNumber(6);
        if (listaPostaci.size() < 2) {
            while (n == 5) {
                System.out.println("Nie wybieraj 5! Nie ma takiego numeru");
                n = checkedNumber(6);
            }
        }

        if (n == 1) {
            stworzPostac();
            //menu1();
        }
        if (n == 2) {
            wyswietl();
            menu1();
        }
        if (n == 3) {
            if (menu2() == false) {
                if (menu3()) {
                    wyswietl();
                }
                wyborZListy();
            }
            listaPostaci.get(ile - 1).prezentujBron();
            menu1();
        }
        if (n == 4) {
            if (menu2() == false) {
                if (menu3()) {
                    wyswietl();
                }
                wyborZListy();
            }
            listaPostaci.get(ile - 1).idzDoPrzodu();
            menu1();
        }
        if (n == 5) {
            walka();
        }
        if (n == 6) {
            stop();
        }
    }


    public boolean menu2() {
        System.out.println("Czy chcesz aby:\n1 - dotyczylo to ostatnio uzywanej postaci\n2 - chcesz wybrac postac z listy?\n");
        int n = checkedNumber(2);
        if (n == 1) return true;
        else return false;
    }

    public boolean menu3() {
        System.out.println("Czy chcesz aby:\n1 - wyswietlic liste postaci\n2 - nie wyswietlac listy postaci?\n");
        int n = checkedNumber(2);
        if (n == 1) return true;
        else return false;
    }
}
