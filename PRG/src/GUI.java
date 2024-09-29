import javax.swing.*;

public class GUI {
    public static void main() {

        JFrame frame = new JFrame();

        ImageIcon titleCard = new ImageIcon("C:\\Users\\micha\\Documents\\GitHub\\Project-R\\PRG\\Sprites\\title_concept_0.png");
        JLabel label0 = new JLabel(titleCard);
        label0.setIcon(titleCard);
        label0.setText("Welcome");
        label0.setHorizontalTextPosition(SwingConstants.TRAILING);

        frame.setTitle("PRG");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setVisible(true);
        frame.add(label0);
    }
}
