import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import java.awt.event.ActionListener; // Importa o "Ouvinte"
import java.awt.event.ActionEvent;   // Importa o "Evento" que o ouvinte recebe

/**
 * Nossa classe AGORA TAMBÉM é um Ouvinte de Ações (ActionListener)
 */
public class ContadorApp extends JFrame implements ActionListener {

    // ... (variáveis do Passo 2) ...
    private JButton botaoClique;
    private JLabel labelContador;
    private int contador;

    // Construtor
    public ContadorApp() {
        // ... (configurações da janela do Passo 1) ...
        setTitle("Meu Primeiro Contador Swing");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new FlowLayout());

        // ... (inicialização do Passo 2) ...
        contador = 0;
        botaoClique = new JButton("Clique");
        labelContador = new JLabel("Planeta: " + contador);

        // --- Passo 3: REGISTRANDO O OUVINTE ---
        // Dizemos ao botão: "Ei, quando alguém clicar em você,
        // avise a ESTA classe (this) chamando o método actionPerformed."
        botaoClique.addActionListener(this);

        // ... (adicionando componentes do Passo 2) ...
        add(botaoClique);
        add(labelContador);
    }

    /**
     * Este método é OBRIGATÓRIO por causa do "implements ActionListener".
     * Ele é chamado automaticamente sempre que o "botaoClique" for pressionado.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        // 1. Incrementa a variável
        contador++;
        
        // 2. Atualiza o texto do JLabel
        labelContador.setText("Planeta: " + contador);
    }

    // ... (método main do Passo 1) ...
    // ATUALIZAÇÃO NO MAIN (BOA PRÁTICA)
    public static void main(String[] args) {
        // Interfaces gráficas em Swing devem ser criadas na "Event Dispatch Thread" (EDT)
        // Usar SwingUtilities.invokeLater garante isso.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                ContadorApp minhaJanela = new ContadorApp();
                minhaJanela.setVisible(true);
            }
        });
    }
}