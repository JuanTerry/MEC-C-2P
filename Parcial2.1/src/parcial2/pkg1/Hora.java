import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Calendar;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
public class Hora extends JFrame implements ActionListener, ChangeListener {
    private JTextField hora;
    private JTextField minutos;
    private JTextField segundos;
    private JButton iniciar;
    private JButton detener;
    private JSlider slider;
    private Timer timer;

    public Hora() {
        super("Reloj");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 150);

        JPanel panel = new JPanel(new GridLayout(1, 3));
        hora = new JTextField(2);
        minutos = new JTextField(2);
        segundos = new JTextField(2);
        panel.add(hora);
        panel.add(minutos);
        panel.add(segundos);
        getContentPane().add(panel, BorderLayout.CENTER);

        iniciar = new JButton("Iniciar");
        detener = new JButton("Detener");
        slider = new JSlider(0, 100, 50);
        getContentPane().add(iniciar, BorderLayout.WEST);
        getContentPane().add(detener, BorderLayout.EAST);
        getContentPane().add(slider, BorderLayout.SOUTH);

        timer = new Timer(1000, this);
        iniciar.addActionListener(e -> iniciar());
        detener.addActionListener(e -> detener());
        slider.addChangeListener(this);
    }

    public void iniciar() {
        timer.start();
    }

    public void detener() {
        timer.stop();
    }

    public void actionPerformed(ActionEvent e) {
        hora.setText(String.valueOf(Calendar.getInstance().get(Calendar.HOUR_OF_DAY)));
        minutos.setText(String.valueOf(Calendar.getInstance().get(Calendar.MINUTE)));
        segundos.setText(String.valueOf(Calendar.getInstance().get(Calendar.SECOND)));
    }

    public void stateChanged(ChangeEvent e) {
        timer.setDelay(1000/slider.getValue());
    }

    public static void main(String[] args) {
        Hora reloj = new Hora();
        reloj.setVisible(true);
    }
}