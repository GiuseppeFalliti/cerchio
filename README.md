# Animazione di un Cerchio con Swing

Questo programma Java crea un'animazione semplice di un cerchio rimbalzante utilizzando il framework Swing. Il cerchio si muove all'interno di un JFrame e rimbalza sui bordi.

## Descrizione

La classe `Cerchio` estende `JFrame` e crea una finestra contenente un cerchio rimbalzante. La posizione del cerchio viene aggiornata nel metodo `moveCircle`, e un `Timer` viene utilizzato per invocare ripetutamente questo metodo per creare l'animazione.

## Spiegazione del Codice

1. **Inizializzazione del Frame:**
    - Il frame viene inizializzato con proprietà specifiche come titolo, operazione di chiusura e impostazioni di ridimensionamento.

```java
setTitle("Cerchio Animato");
setDefaultCloseOperation(EXIT_ON_CLOSE);
setResizable(false);
```

2. **Creazione del Pannello:**
    - Viene creato un `JPanel` per disegnare il cerchio utilizzando il metodo `paintComponent`.

```java
JPanel panel = new JPanel() {
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.BLUE);
        g2d.fillOval(x, y, circleSize, circleSize);
    }
};
panel.setPreferredSize(new Dimension(500, 500));
```

3. **Configurazione del Timer:**
    - Un `Timer` viene utilizzato per invocare ripetutamente il metodo `moveCircle` e ridisegnare il pannello.

```java
Timer timer = new Timer(10, new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        moveCircle();
        panel.repaint();
    }
});
timer.start();
```

4. **Movimento del Cerchio:**
    - Il metodo `moveCircle` gestisce il movimento del cerchio e controlla le collisioni con i bordi del pannello.

```java
private void moveCircle() {
    // Controlla i limiti verticali
    if (y + ySpeed < 0 || y + ySpeed > getHeight() - circleSize) {
        ySpeed = -ySpeed;
    }
    y += ySpeed;

    // Controlla i limiti orizzontali
    if (x + xSpeed < 0 || x + xSpeed > getWidth() - circleSize) {
        xSpeed = -xSpeed;
    }
    x += xSpeed;
}
```

5. **Metodo Principale:**
    - Il metodo `main` inizializza l'oggetto `Cerchio` e rende il frame visibile.

```java
public static void main(String[] args) {
    SwingUtilities.invokeLater(() -> {
        Cerchio cerchio = new Cerchio();
        cerchio.setVisible(true);
    });
}
```

## Licence

MIT License.

## Come Eseguire il Programma

1. Compila il codice Java.
2. Esegui il programma compilato.
3. Una finestra comparirà con un'animazione del cerchio rimbalzante.
