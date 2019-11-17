public class Stos {

    int[] wartosci = new int[0];
    int liczbaWartosci = 0;

    public Stos() {

    }

    void push(int v) { // wlozenie wartosci na wierzch
        if(wartosci.length-liczbaWartosci==0) {
            int[] wartosci2 = new int[wartosci.length+1];
            for (int i = 0; i < wartosci.length; i++) {
                wartosci2[i] = wartosci[i];
            }
            wartosci = wartosci2; // kopiujemy adres tablicy wartosci2 do wartosci
        }

        for (int i = liczbaWartosci-1; i >= 0 ; i--) {
            wartosci[i+1] = wartosci[i];
        }
        liczbaWartosci++;
        wartosci[0]=v;
    }

    int pop() { // wyjecie wartosci z wierzchu
        int zabieranaLiczba = wartosci[0];
        for (int i = 1; i < liczbaWartosci; i++) {
            wartosci[i-1] = wartosci[i];
        }
        liczbaWartosci--;
        return zabieranaLiczba;
    }

    void print() {
        for (int i = 0; i < liczbaWartosci; i++) {
            System.out.print(wartosci[i] + " ");
        }
        System.out.println();
    }

}
