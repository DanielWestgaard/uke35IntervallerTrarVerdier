import static org.junit.jupiter.api.Assertions.*;

class IntervallerTest {

    @org.junit.jupiter.api.Test
    void min1() {
        int[] tabellenMin = {32, 89, 1, 34, 6, 9, 7, 4, 12, 21};
        int index = Intervaller.min1(tabellenMin, 0, tabellenMin.length);
        assertEquals(2, index);
    }
}
