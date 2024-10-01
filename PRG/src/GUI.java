import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI {
    public static void main(){

        JFrame frame = new JFrame();
        frame.setLayout(new BorderLayout());


        // Title Icon
        ImageIcon titleIcon = new ImageIcon("C:\\Users\\micha\\Documents\\GitHub\\Project-R\\PRG\\src\\Sprites\\title_concept_0.png");
        JLabel titleLabel = new JLabel(titleIcon);
        titleLabel.setIcon(titleIcon);
        titleLabel.setText("Welcome");

        ImageIcon cbIcon = new ImageIcon("C:\\Users\\micha\\Documents\\GitHub\\Project-R\\PRG\\src\\Sprites\\commence_button.png");
        Image cbIconImage = cbIcon.getImage();
        Image cbiiScaled = cbIconImage.getScaledInstance(200, 100, Image.SCALE_SMOOTH);
        ImageIcon scaledCbIcon = new ImageIcon(cbiiScaled);
        JButton commenceButton = new JButton(scaledCbIcon);
        commenceButton.setBorderPainted(false); // Removes border
        commenceButton.setFocusPainted(false); // Removes Ugly Grey Square

        commenceButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Commence Button Pressed");
            }
        });

        frame.setTitle("PRG");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.add(titleLabel, BorderLayout.CENTER);
        frame.add(commenceButton, BorderLayout.SOUTH);

        frame.setVisible(true);
    }
}
