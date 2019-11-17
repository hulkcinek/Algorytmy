public class Kolejka {
    int[] wartosci = new int[10];
    int liczbaWartosci = 0;
    void push (int v){
        if(wartosci.length-liczbaWartosci==0) {
            int[] wartosci2 = new int[wartosci.length+1];
            for (int i = 0; i < wartosci.length; i++) {
                wartosci2[i] = wartosci[i];
            }
            wartosci = wartosci2;
        }


        for (int i = liczbaWartosci-1; i >= 0 ; i--) {
            wartosci[i+1] = wartosci[i];
        }
        liczbaWartosci++;
        wartosci[0] = v;

    }

    int pop(){
        int obslozonaLiczba = wartosci[wartosci.length-1];
        for (int i = liczbaWartosci; i < 1; i++) {
            wartosci[i+1]=wartosci[1];
        }
        liczbaWartosci--;
        return obslozonaLiczba;
    }

    void print(){
        for (int i = 0; i < liczbaWartosci; i++) {
            System.out.print(wartosci[i] + " ");
        }
        System.out.println();
    }
}
