package drzewo;

public class Wezel {

    int wartosc;
    Wezel leweDziecko;
    Wezel praweDziecko;

    /*
    public boolean czyMamRodzenstwo(){
        return true;
    }
    */
    public void dodaj(int w) {
        if(wartosc == 0)
            wartosc = w;
        else if (w >= wartosc) {
            // prawe dziecko
            if (praweDziecko == null)
                praweDziecko = new Wezel();
            praweDziecko.dodaj(w);
        } else if (w < wartosc) {
            // lewe dziecko
            if (leweDziecko == null)
                leweDziecko = new Wezel();
            leweDziecko.dodaj(w);
        }
    }

    public boolean czyIstnieje(int szukanaLiczba) {
        if (szukanaLiczba == wartosc) {
            return true;
        } else if(szukanaLiczba < wartosc){
            if(leweDziecko != null)
                return leweDziecko.czyIstnieje(szukanaLiczba);
            else // brak lewego dziecka
                return false;
        } else if (szukanaLiczba > wartosc){
            if(praweDziecko != null)
                return praweDziecko.czyIstnieje(szukanaLiczba);
            else // brak prawego dziecka
                return false;
        }
        // nie moze sie wykonac
        //cos w stylu: throw new Exception();
        return false;
    }

    public void wypisz() {
        //wypisz(0);
        wypisz(0, "", true);
        // te same nazwy - inna funkcjonalnosc
        //String s = new String();
        //s = new String("");
        //    |
        //    └
        //    ├
    }

    /*
    ├- - uzywamy dla wezla ktory ma jeszcze rodzenstwo, ma pod soba jednego 'brata'
    Używamy przy prawym tylko kiedy istnieje tez lewe

    └- - uzywamy kiedy dany wezel nie ma juz 'brata' pod sobą
    Przy lewym zawsze, przy prawym gdy nie ma lewego dziecka

    alternatywnie:
    Uzywamy gdy rodzic ma tylko jedno dziecko albo przy lewym dziecku jesli bylo prawe
    Uzywamy przy prawym jesli nie ma lewego pod sobą lub w przypadku lewego gdy jest tez prawe

    */

    // czyOstatni - czy rodzic byl ostatni w rodzenstwie (w kolejnosci)
    public void wypisz(int licznik, String znak, boolean czyOstatni) {
        // wypisanie pionowych linii zalezy od glebokosci czyli zmiennej licznik
        // wypisujemy pionowa linie kiedy dane rodzic ma brata pod sobą (ma rodzenstwo)

        // wypisywanie pionowych linii
        for (int i = 1; i < licznik; i++) {
            //System.out.print("  ");
            if (czyOstatni == true){
                System.out.print("  ");
            }else{
                System.out.print("| ");
            }

        }


        System.out.println(znak + wartosc);
        licznik++;

        /*
        ├- - uzywamy dla wezla ktory ma jeszcze rodzenstwo, ma pod soba jednego 'brata'
        Używamy przy prawym tylko kiedy istnieje tez lewe

        └- - uzywamy kiedy dany wezel nie ma juz 'brata' pod sobą
        Przy lewym zawsze, przy prawym gdy nie ma lewego dziecka
         */

        if(praweDziecko != null) {
            if(leweDziecko != null) { // kiedy ma sie dwojke dzieci
                if (znak.equals("├-")) {
                    praweDziecko.wypisz(licznik, "├-", false);
                }else{
                    praweDziecko.wypisz(licznik, "├-", true);
                }
            }else { //jesli jest tylko prawe dziecko
                if (znak.equals("├-")) {
                    praweDziecko.wypisz(licznik, "└-", false);
                }else{
                    praweDziecko.wypisz(licznik, "└-", true);
                }
            }
        }
        if(leweDziecko != null){
            if(znak.equals("├-")) {
                leweDziecko.wypisz(licznik, "└-", false);
            }else{
                leweDziecko.wypisz(licznik, "└-", true);
            }
        }
    }



    public void wypiszPosortowane() {
        // wypisz lewe (rekurencyjnie)
        if (leweDziecko != null){
            leweDziecko.wypiszPosortowane();
        }
        // wypisuje siebie
        System.out.print(wartosc + " ");
        // wypisz prawe (rekurencyjnie)
        if (praweDziecko != null){
            praweDziecko.wypiszPosortowane();
        }
    }

    // dodatkowo zamiast rekurencji - iteracja (for) -
    public void wypiszPosortowaneIteracyjnie() {
        /*
        Do wyrzucenia: jestemLewymCzyPrawym

        Przygotować klasę i algorytm ze stosem.
        Funkcje push(), pop(), peek() - podejrzenie elementu (bez jego sciagania)
        Zrobić to na tablicach (z opcją ich rozszerzania)

        Metoda sortowania:
        Wrzucamy na stos prawe dziecko, siebie, lewe dziecko
        Dopoki jest cos na stosie, zdejmujemy to, sprawdzamy czy ma dzieci i wrzucamy w tej kolejnosci
        co wyżej.
        W momencie gdy nie mamy zadnych dzieci to wypisujemy siebie
        (i oznaczamy to w jakis sposob w stosie(?)) - do zastanowienia jak


         Do pobawienia sie jak działa GIT, komendy:
         git add nazwa_pliku
         git add .
         git commit -m "Nazwa commita" (do zapisania zmian do wyslania)
         git push -u origin master (do wrzucenia zmian)=

        git pull (pobranie zmian z repozytorium)

         */
    }
}
