import javax.swing.*;

public class Synthesizer {
    private JFrame frame = new JFrame("FMSynth");
    Synthesizer()
    {
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        frame.setSize(1000, 700);
        frame.setResizable(false);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
