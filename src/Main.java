import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        Currancy currancy = new Currancy();
        try {
            System.out.println("conversor de moedas");
            Current newCurrent = currancy.exchangeCurrency("BRL", "USD");
            System.out.println(newCurrent);
        } catch (RuntimeException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
