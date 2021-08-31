import java.util.*;

// for å teste på mac hold inn option+enter

public class Intervaller {
    public static void main(String... args) {
        int[] tabellenMin = {32, 89, 1, 34, 6, 9, 7, 4, 12, 21};
        // 1.2.1.1
        //System.out.println("Største tall ligger på indeks " + min1(tabellenMin, 2, 7));
        // 1.2.1.5
        //System.out.println(min2(tabellenMin));

        // 1.2.2.1
        //int[] a = Tabell.randPerm(20);              // en tilfeldig tabell
        for (int k : tabellenMin) System.out.print(k + " ");  // skriver ut a

        int m = Tabell.min2(tabellenMin);   // finner posisjonen til største verdi

        System.out.println("\nStørste verdi ligger på plass " + m);

        System.out.println();

        // 1.2.2.4
        Tabell.skriv(tabellenMin, 2, 8);
        Tabell.skriv(tabellenMin);
    }

    //start på tilhørende 1.2.1.1
    public static int min1(int[] tabell, int fra, int til) { // 1.2.1a)
        if (fra < 0 || til > tabell.length || fra >= til) { //disse argumentene må være gyldige for at søket skal kunne gjøres
            throw new IllegalArgumentException("Ikke gyldig intervall! - min1");
        }
        int minsteIndeks = fra; //største indeks i intevallet
        int minsteTall = tabell[fra]; //største verdi i intevallet
        for (int i = fra + 1; i < til; i++) {
            if (tabell[i] < minsteTall) {
                minsteIndeks = i;
                minsteTall = tabell[minsteIndeks];
            }
        }

        for (int k : tabell) {
            System.out.print(k); // lister ut alle verdiene, 1.2.1.5
        }

        return minsteIndeks;
    }

    public static int min2(int[] a) { // 1.2.1a)
        return min1(a, 0, a.length);
    }
//slutt på tilhørende 1.2.1.1
}
