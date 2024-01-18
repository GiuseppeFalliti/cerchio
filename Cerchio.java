import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Cerchio extends JFrame {
    private static int y=50;
    private static int ySpeed=10;
    private static int x=50; 
    private static int xSpeed=10;
    private static final int circleSize = 100;

    public  Cerchio () {
        setTitle("Circle");
        setDefaultCloseOperation(EXIT_ON_CLOSE);//gestisce la chiusura del programma.
        setResizable(false);

        /**
         * creo un panello dove riscrivo il metodo paintComponent
         */
        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g); //richiamo il costruttore della classe passando il parametro grafico g.
                Graphics2D c2d = (Graphics2D) g; //creo un oggetto Graphics2D usando il casting specificando che è un oggetto Graphics2D e non un ogetto Graphics.
                c2d.setColor(Color.BLUE);//colore del cerchio.
                c2d.fillOval(x, y, circleSize, circleSize); //metodo che crea il cerchio passando x,y, altezza e lunghezza del cerchio.
            }
        };
        
        panel.setPreferredSize(new Dimension(500, 500)); //dimensione del panello.

        /**
         * creo un oggetto di tipo Timer in cui genera un evento ActionEvent ogni 10millisecondi.
         * ogni 10 millisendi verranno eseguiti il metodo moveCircle che 
         */
        Timer timer = new Timer(10, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                moveCircle();
                panel.repaint(); //ogni volta verrà ridisegnato il panello.
            }
        });
        timer.start();

         setSize(400, 400); 
        setLocationRelativeTo(null);

       add(panel);
       pack();//metodo che calcola la dimensione idale del frame in base alla dimensione del panello collegato al frame.
       
       
    }

    /**
     * metodo che gestisce il movimento del cerchio.
     * 
     */
    private void moveCircle() {
        //controlla se il cerchio sta per andare al di fuori dei limiti verticali del pannello.
        if (y + ySpeed < 0 || y + ySpeed > getHeight() - 100) {
            ySpeed = -ySpeed;
        }
        y += ySpeed;

        if (x+ xSpeed < 0 || x + xSpeed > getWidth() - 100) {
            xSpeed = -xSpeed;
        }
        x += xSpeed;
    }

    

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Cerchio cerchio = new Cerchio();
           cerchio.setVisible(true);
        });
    }
}
