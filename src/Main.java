public class Main {

    public static void main(String[] args) {

        Stos s = new Stos();
        Kolejka k = new Kolejka();
        k.print();
        k.push(5);
        k.push(3);
        k.print();
//        System.out.println("wyjmujemy: " + s.pop());
        k.print();
        k.push(21);
        k.push(14);
        k.push(3);
        k.push(5);
        k.print();
        k.pop();
        k.print();
        k.pop();
        k.print();
        k.pop();
        k.print();


        /*
        1. Zrobic druga klase - z kolejką - zasada jak w realnej kolejce, pierwszy przychodzi, pierwszy wychodzi
        2. Te same metody - push, pop, print
        3. Zrobic wspolny interfejs na te dwie klasy
         */
    }
}
