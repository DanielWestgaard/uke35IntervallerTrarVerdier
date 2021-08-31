import java.util.*;
public class Tabell {
    private Tabell() {}   // privat standardkonstruktør - hindrer instansiering

    // Metoden bytt(int[] a, int i, int j)       Programkode 1.1.8 d)
    public static void bytt(int[] a, int i, int j) {
        int temp = a[i]; a[i] = a[j]; a[j] = temp;
    }
    // 1.2.2.3
    static void bytt(char[] c, int i, int j) {
        // Lager først en kopi av de to verdiene, før jeg bytter plass på dem
        char kopi1 = c[i]; /* bytter så plass på dem: */ c[i] = c[j]; c[j] = kopi1;
    }

    // Metoden randPerm(int n)                   Programkode 1.1.8 e)
    public static int[] randPerm(int n) {   // en effektiv versjon
        Random r = new Random();         // en randomgenerator
        int[] a = new int[n];            // en tabell med plass til n tall

        Arrays.setAll(a, i -> i + 1);    // legger inn tallene 1, 2, . , n

        for (int k = n - 1; k > 0; k--)  // løkke som går n - 1 ganger
        {
            int i = r.nextInt(k+1);        // en tilfeldig tall fra 0 til k
            bytt(a,k,i);                   // bytter om
        }

        return a;                        // permutasjonen returneres
    }
    // Metoden randPerm(int[] a)                 Programkode 1.1.8 f)
    public static void randPerm(int[] a) { // stokker om a
        Random r = new Random();     // en randomgenerator

        for (int k = a.length - 1; k > 0; k--)
        {
            int i = r.nextInt(k + 1);  // tilfeldig tall fra [0,k]
            bytt(a,k,i);
        }
    }

    // Metoden maks(int[] a, int fra, int til)   Programkode 1.2.1 b)
    public static int maks(int[] a, int fra, int til) {
        if (fra < 0 || til > a.length || fra >= til)
        {
            throw new IllegalArgumentException("Illegalt intervall!");
        }

        int m = fra;              // indeks til største verdi i a[fra:til>
        int maksverdi = a[fra];   // største verdi i a[fra:til>

        for (int i = fra + 1; i < til; i++)
        {
            if (a[i] > maksverdi)
            {
                m = i;                // indeks til største verdi oppdateres
                maksverdi = a[m];     // største verdi oppdateres
            }
        }

        return m;  // posisjonen til største verdi i a[fra:til>
    }

    // Metoden maks(int[] a)                     Programkode 1.2.1 c)
    public static int maks(int[] a)  // bruker hele tabellen
    {
        return maks(a,0,a.length);     // kaller metoden over
    }

    // min-metodene - se Oppgave 1 i Avsnitt 1.2.1
    public static int min1 (int[] tabell, int fra, int til) { // 1.2.1a)
        if (fra<0 || til>tabell.length || fra>=til) { //disse argumentene må være gyldige for at søket skal kunne gjøres
            throw new IllegalArgumentException("Ikke gyldig intervall! - min1");
        }
        int minsteIndeks = fra; //største indeks i intevallet
        int minsteTall = tabell[fra]; //største verdi i intevallet
        for (int i=fra+1 ; i<til ; i++) {
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

    public static int min2 (int[] a) { // 1.2.1a)
        return min1(a, 0, a.length);
    }

    // 1.2.2.4
    public static void skriv(int[] a, int fra, int til) {
        /* Den skal skrive ut tallene i intervallet a[fra:til> til konsollet - alle på én linje og et mellomrom mellom
         * hvert tall. Ikke mellomrom og ikke linjeskift etter siste verdi.*/
        String ut = "Tallene fra " + a[fra] + " til " + a[til] + " er: ";
        for (int i=fra ; i<til ; i++) {
            ut += a[i] + ", ";
        }
        System.out.println(ut);
    }
    public static void skriv(int[] a) {
        /*
        Den skal skrive ut hele tabellen - alle på én linje, en blank mellom hvert tall. Ikke mellomrom og ikke linjeskift etter siste verdi.
         */
        for (int k : a) {
            System.out.print(k + " ");
        }
    }

    // 1.2.2.5
    public static void skrivln(int[] a, int fra, int til) {
        /* Den skal skrive ut tallene i intervallet a[fra:til> til konsollet - alle på én linje og et mellomrom mellom
         * hvert tall. Ikke mellomrom og ikke linjeskift etter siste verdi.*/
        String ut = "Tallene fra " + a[fra] + " til " + a[til] + " er: ";
        for (int i=fra ; i<til ; i++) {
            ut += a[i] + ", ";
        }
        System.out.println(ut + "\n");
    }
    public static void skrivln(int[] a) {
        /*
        Den skal skrive ut hele tabellen - alle på én linje, en blank mellom hvert tall. Ikke mellomrom og ikke linjeskift etter siste verdi.
         */
        for (int k : a) {
            System.out.print(k + " ");
        }
        System.out.println();
    }
}
