import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI {
    public static void main() {
        SwingUtilities.invokeLater(() -> {
            // Frame setup
            JFrame frame = new JFrame(); // Create frame
            frame.setLayout(new BorderLayout()); // Frame layout
            frame.setSize(1000, 700); // Frame size
            frame.setTitle("PRG"); // Frame title
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Frame Close

            // CardLayout Panel
            CardLayout cardLayout = new CardLayout();
            JPanel cardPanel = new JPanel(cardLayout);

            // Title Screen Panel
            JPanel titleScreen = new JPanel(new BorderLayout());

            // Title Icon
            ImageIcon titleIcon = new ImageIcon("C:\\Users\\micha\\Documents\\GitHub\\Project-R\\PRG\\src\\Sprites\\title_concept_1.gif");
            JLabel titleLabel = new JLabel(titleIcon);

            // Create and resize image
            ImageIcon cbIcon = new ImageIcon("C:\\Users\\micha\\Documents\\GitHub\\Project-R\\PRG\\src\\Sprites\\commence_button_1.gif");

            // Commence button
            JButton commenceButton = new JButton(cbIcon);
            commenceButton.setBorderPainted(false); // Removes border
            commenceButton.setFocusPainted(false); // Removes Ugly Grey Square

            commenceButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    cardLayout.show(cardPanel, "SecondScreen");
                }
            });

            // Adding elements to title screen
            titleScreen.add(titleLabel, BorderLayout.CENTER);
            titleScreen.add(commenceButton, BorderLayout.SOUTH);

            // Second Screen panel
            JPanel secondScreen = new JPanel(new BorderLayout());
            JLabel newLabel = new JLabel("\"o . o\"");
            newLabel.setHorizontalAlignment(SwingConstants.CENTER);
            secondScreen.add(newLabel, BorderLayout.CENTER);

            // Add screens to the card panel
            cardPanel.add(titleScreen, "Title Screen");
            cardPanel.add(secondScreen, "SecondScreen");

            // Add cardPanel to the frame
            frame.add(cardPanel, BorderLayout.CENTER);

            new Thread(() -> {
                playAudio("C:\\Users\\micha\\Documents\\GitHub\\Project-R\\PRG\\src\\Audio\\Minino.wav"); // Change to your audio file path
            }).start();

            // Set frame visibility at the end
            frame.setVisible(true); // Makes frame visible
        });
    }

    // Method to play audio
    private static void playAudio(String filePath) {
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new java.io.File(filePath).getAbsoluteFile());
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);

            // Set volume to half
            FloatControl volumeControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
            float currentVolume = volumeControl.getValue();
            float newVolume = currentVolume - 20.0f; // Decrease by 10 dB (approximately half volume)
            volumeControl.setValue(newVolume);

            clip.start();
            clip.loop(Clip.LOOP_CONTINUOUSLY); // Loop the audio continuously
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}