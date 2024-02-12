import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

public class Main extends JFrame {

    public static void main(String[] args) throws IOException {

        new MyFrame();
    }

}

//ДАЛЕЕ СОЗДАЁМ КЛАСС В НОВОМ ОКНЕ
class MyFrame extends JFrame implements KeyListener {
    @Override
    public void keyTyped(KeyEvent e) {

        switch (e.getKeyChar()) {
            case 'a' -> label.setLocation(label.getX() - 20, label.getY());
            case 'w' -> label.setLocation(label.getX(), label.getY() - 20);
            case 'd' -> label.setLocation(label.getX() + 20, label.getY());
            case 's' -> label.setLocation(label.getX(), label.getY() + 20);
        }

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {
        System.out.println("Released: "+e.getKeyChar());
        System.out.println("Code: " + e.getKeyCode());
    }

    JLabel label = new JLabel();
    static int width = 800, height = 600;//размеры окна
    MyFrame() throws IOException {


        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //для его закрытия
        this.setTitle("Пикассо");
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setBounds(dim.width / 2 - width / 2, dim.height / 2 - height / 2, width, height + 30);


        BufferedImage im = ImageIO.read(new URL("https://tgram.ru/wiki/stickers/img/rmrick/png/6.png"));//скачиваем картинку
        JPanel panel = new JPanel (new FlowLayout(FlowLayout.LEFT));
        panel.setFocusable(true);
        label = new JLabel(new ImageIcon(im),JLabel.RIGHT);
        panel.add(label, BorderLayout.NORTH);
        this.add(panel);
        this.addKeyListener(this);
        this.setVisible(true);



    }
}