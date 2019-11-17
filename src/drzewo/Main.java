package drzewo;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        //porownanie();
        int[] tablica = new int[15];

        Wezel drzewo = new Wezel();
        drzewo.dodaj(5);
        drzewo.dodaj(12);
        drzewo.dodaj(10);
        drzewo.dodaj(15);
        drzewo.dodaj(3);
        drzewo.dodaj(4);
        drzewo.dodaj(14);
        drzewo.dodaj(17);
        drzewo.dodaj(18);
        /*int[] wiekszaTablica = generujTablice(25);
        for (int i = 0; i < wiekszaTablica.length; i++) {
            drzewo.dodaj(wiekszaTablica[i]);
        }*/
        //drzewo.wypisz();
        drzewo.wypiszPosortowane();
        //char a = 124;
//        System.out.println("|");
//        System.out.println("└");
//        System.out.println("├");

        /*
        Do wyboru:
        1. Spróbować zrobić test 'wydajnosci', tablica na np. 10 000 liczb. Wartosci z tablicy wrzucic tez do drzewa.
        Porownac ile czasu zajmie sprawdzenie czy istnieje w tablicy i drzewie jakas wybrana liczba.
        Liczbe mozna wziac z tablicy (np. z indeksu 1000, 5000, 9000).
        Do generacji warto przyjac liczby z przedzialu do ok. 100 000.

        2. Spróbować znaleźć sposob na wydrukowanie drzewa. Kazda linia to dany 'poziom' z wezlami.

        3. Spróbować znaleźć sposob na wypisanie wartosci z drzewa posortowanych rosnaco i/lub malejaco.
        Bez sortowania samemu - z wykorzystaniem tylko drzewa.
         */


    }

    public static boolean czyJestTu(int szukana,int[] tab) {
        for (int i = 0; i < tab.length; i++) {
            if(tab[i]==szukana) {
                return true;
            }
        }
        return false;
    }

    public static int[] generujTablice(int rozmiar) {
        Random r = new Random();

        int[] tablica = new int[rozmiar];

        for (int i = 0; i < rozmiar; i++) {
            tablica[i] = r.nextInt(100);
        }

        return tablica;
    }

    public static void porownanie() {
        int[] tab = generujTablice(1000000);
        int szukana = 100000000;//tab[9800];
        Wezel drzewo = new Wezel();
//        drzewo.dodaj(7);
//        drzewo.dodaj(10);
//        drzewo.dodaj(4);
//        drzewo.dodaj(6);
//        drzewo.dodaj(2);
        for (int i = 0; i < tab.length; i++) {
            drzewo.dodaj(tab[i]);
        }

        //drzewo
        long czas1 = System.nanoTime();
        if(drzewo.czyIstnieje(szukana)){
            System.out.println("tak");
        }else{
            System.out.println("nie");
        }
        long czas2 = System.nanoTime();
        System.out.println("Drzewo: "+ (czas2-czas1) + "ns");
        //tablica
        czas1 = System.nanoTime();
        if(czyJestTu(szukana,tab))
            System.out.println("tak");
        else
            System.out.println("nie");
        czas2 = System.nanoTime();
        System.out.println("Tablica: "+ (czas2-czas1) + "ns");
    }

}
