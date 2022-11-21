package uni.knu.vlad.tasktwo;


import javax.swing.*;
import java.awt.*;
import uni.knu.vlad.taskone.Slider;

public class SliderSemaphore extends Slider {
    private JButton startRight;
    private JButton startLeft;
    private JButton stopRight;
    private JButton stopLeft;
    private JLabel warningLabel;

    public SliderSemaphore() {
        super();
        startRight = new JButton("Start");
        startRight.setBounds(340, 60, 70, 50);
        startLeft = new JButton("Start");
        startLeft.setBounds(20, 60, 70, 50);
        stopRight = new JButton("Stop");
        stopRight.setBounds(415, 60, 70, 50);
        stopLeft = new JButton("Stop");
        stopLeft.setBounds(95, 60, 70, 50);
        warningLabel = new JLabel();
        warningLabel.setBounds(190, 120, 150, 30);

        panel.add(startLeft);
        panel.add(startRight);
        panel.add(stopLeft);
        panel.add(stopRight);
        panel.add(warningLabel);
    }

    public void setWarning() {
        warningLabel.setText("SEMAPHORE IS BUSY!");
    }

    public void clearWarning() {
        warningLabel.setText("");
    }

    public void setStartRightActionListener(Runnable r) {
        startRight.addActionListener(actionEvent -> r.run());
    }
    public void setStartLeftActionListener(Runnable r) {
        startLeft.addActionListener(actionEvent -> r.run());
    }
    public void setStopRightActionListener(Runnable r) {
        stopRight.addActionListener(actionEvent -> r.run());
    }
    public void setStopLeftActionListener(Runnable r) {
        stopLeft.addActionListener(actionEvent -> r.run());
    }

    public class Slider extends JFrame {
        protected JButton incrLeft;
        protected JButton incrRight;
        protected JButton decrLeft;
        protected JButton decrRight;
        private JLabel rightLabel;
        private JLabel leftLabel;

        protected JSlider slider;
        protected JPanel panel;

        public Slider() {
            JFrame.setDefaultLookAndFeelDecorated(true);
            setPreferredSize(new Dimension(550, 300));
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            panel = new JPanel();
            slider = new JSlider();
            slider.setBounds(190, 5, 150, 50);
            incrLeft = new JButton("+");
            incrLeft.setBounds(60, 5, 50, 50);
            incrRight = new JButton("+");
            incrRight.setBounds(340, 5, 50, 50);
            decrLeft = new JButton("-");
            decrLeft.setBounds(115, 5, 50, 50);
            decrRight = new JButton("-");
            decrRight.setBounds(395, 5, 50, 50);
            rightLabel = new JLabel();
            rightLabel.setBounds(470, 5, 50, 50);
            rightLabel.setText("5");
            leftLabel = new JLabel();
            leftLabel.setBounds(25, 5, 50, 50);
            leftLabel.setText("5");

            panel.setLayout(null);
            panel.add(leftLabel);
            panel.add(incrLeft);
            panel.add(decrLeft);
            panel.add(slider);
            panel.add(incrRight);
            panel.add(decrRight);
            panel.add(rightLabel);

            add(panel);
            pack();

            setVisible(true);
        }

        public synchronized void  moveOnePositionRight() {
            slider.setValue(slider.getValue()+1);
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        public synchronized void moveOnePositionLeft() {
            slider.setValue(slider.getValue()-1);
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        public synchronized void setRightIncrActionListener(Runnable r) {
            incrRight.addActionListener(actionEvent -> r.run());
        }
        public synchronized void setLeftIncrActionListener(Runnable r) {
            incrLeft.addActionListener(actionEvent -> r.run());
        }
        public synchronized void setRightDecrActionListener(Runnable r) {
            decrRight.addActionListener(actionEvent -> r.run());
        }
        public synchronized void setLeftDecrActionListener(Runnable r) {
            decrLeft.addActionListener(actionEvent -> r.run());
        }

        public void setRightLableText(String text) {
            rightLabel.setText(text);
        }

        public void setLeftLableText(String text) {
            leftLabel.setText(text);
        }
    }
}