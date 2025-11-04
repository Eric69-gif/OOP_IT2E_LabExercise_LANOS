import java.awt.*;
import java.util.Random;
import javax.swing.*;

public class ArithmeticGameCalculator extends JFrame {
    private JLabel leftNumLabel, operatorLabel, rightNumLabel, equalsLabel;
    private JTextField answerField;
    private JButton submitBtn, nextBtn;
    private JLabel resultBox;
    private JLabel scoreLabel;
    private JComboBox<String> difficultyCombo;
    private Random rand = new Random();

    private int leftNum, rightNum;
    private char operator = '+';
    private int correct = 0, total = 0;
    private boolean answered = false;

    public ArithmeticGameCalculator() {
        super("Arithmetic Game Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 420);
        setLocationRelativeTo(null);

        // ===== TOP PANEL (score + question display) =====
        JPanel topPanel = new JPanel(new BorderLayout());

        // Score label (top-right)
        scoreLabel = new JLabel("Score: 0 / 0", SwingConstants.RIGHT);
        scoreLabel.setFont(new Font("SansSerif", Font.BOLD, 18));
        scoreLabel.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
        topPanel.add(scoreLabel, BorderLayout.NORTH);

        // Question area
        JPanel questionPanel = new JPanel(new GridBagLayout());
        questionPanel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5,5,5,5);

        leftNumLabel = bigLabel("0");
        operatorLabel = bigLabel("+");
        rightNumLabel = bigLabel("0");
        equalsLabel = bigLabel("=");
        resultBox = bigLabel("?");

        gbc.gridx=0; questionPanel.add(leftNumLabel,gbc);
        gbc.gridx=1; questionPanel.add(operatorLabel,gbc);
        gbc.gridx=2; questionPanel.add(rightNumLabel,gbc);
        gbc.gridx=3; questionPanel.add(equalsLabel,gbc);
        gbc.gridx=4; questionPanel.add(resultBox,gbc);

        topPanel.add(questionPanel, BorderLayout.CENTER);

        // ===== INPUT AREA =====
        JPanel inputPanel = new JPanel(new FlowLayout(FlowLayout.LEFT,10,8));
        inputPanel.add(new JLabel("Answer:"));
        answerField = new JTextField(8);
        answerField.setFont(new Font("SansSerif", Font.PLAIN,18));
        inputPanel.add(answerField);
        submitBtn = new JButton("Submit");
        inputPanel.add(submitBtn);
        nextBtn = new JButton("Next");
        inputPanel.add(nextBtn);

        // ===== LEFT SIDE: OPERATION + DIFFICULTY =====
        JPanel leftPanel = new JPanel(new BorderLayout(5,5));

        // Operator buttons (VERTICAL layout)
        JPanel operatorPanel = new JPanel(new GridLayout(4,1,8,8));
        operatorPanel.setBorder(BorderFactory.createTitledBorder("Choose Operation"));
        JButton addBtn = new JButton("Add");
        JButton subBtn = new JButton("Subtract");
        JButton mulBtn = new JButton("Multiply");
        JButton divBtn = new JButton("Divide");
        operatorPanel.add(addBtn);
        operatorPanel.add(subBtn);
        operatorPanel.add(mulBtn);
        operatorPanel.add(divBtn);
        leftPanel.add(operatorPanel, BorderLayout.CENTER);

        // Difficulty selector
        JPanel diffPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        diffPanel.setBorder(BorderFactory.createTitledBorder("Difficulty"));
        String[] diffs = {"Easy (1-10)", "Medium (1-50)", "Hard (1-200)"};
        difficultyCombo = new JComboBox<>(diffs);
        diffPanel.add(difficultyCombo);
        leftPanel.add(diffPanel, BorderLayout.SOUTH);

        // ===== MAIN CONTAINER =====
        Container cp = getContentPane();
        cp.setLayout(new BorderLayout(10,10));
        cp.add(topPanel, BorderLayout.NORTH);
        cp.add(inputPanel, BorderLayout.SOUTH);
        cp.add(leftPanel, BorderLayout.WEST);

        // ===== ACTIONS =====
        addBtn.addActionListener(e -> { operator = '+'; nextQuestion(); });
        subBtn.addActionListener(e -> { operator = '-'; nextQuestion(); });
        mulBtn.addActionListener(e -> { operator = '*'; nextQuestion(); });
        divBtn.addActionListener(e -> { operator = '/'; nextQuestion(); });

        submitBtn.addActionListener(e -> checkAnswer());
        nextBtn.addActionListener(e -> nextQuestion());
        answerField.addActionListener(e -> checkAnswer());

        nextQuestion();
    }

    private void nextQuestion() {
        int max = switch (difficultyCombo.getSelectedIndex()) {
            case 0 -> 10;
            case 1 -> 50;
            default -> 200;
        };

        leftNum = rand.nextInt(max) + 1;
        rightNum = rand.nextInt(max) + 1;

        if (operator == '/') {
            rightNum = rand.nextInt(Math.max(1, max/4)) + 1;
            leftNum = rightNum * (rand.nextInt(Math.max(1, max/rightNum)) + 1);
        }

        leftNumLabel.setText(String.valueOf(leftNum));
        rightNumLabel.setText(String.valueOf(rightNum));
        operatorLabel.setText(String.valueOf(operator));
        resultBox.setText("?");
        resultBox.setForeground(Color.BLACK);
        answerField.setText("");
        answerField.requestFocusInWindow();
        answered = false;
    }

    private void checkAnswer() {
        if (answered) return;
        String ans = answerField.getText().trim();
        if (ans.isEmpty()) return;
        answered = true;
        total++;

        double correctAns = switch (operator) {
            case '+' -> leftNum + rightNum;
            case '-' -> leftNum - rightNum;
            case '*' -> leftNum * rightNum;
            case '/' -> (double) leftNum / rightNum;
            default -> 0;
        };

        try {
            double user = Double.parseDouble(ans);
            boolean isCorrect = Math.abs(user - correctAns) < 1e-6;
            if (isCorrect) {
                correct++;
                resultBox.setText("✔");
                resultBox.setForeground(new Color(0,130,0));
            } else {
                resultBox.setText(String.valueOf(correctAns));
                resultBox.setForeground(Color.RED);
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Invalid number.", "Error", JOptionPane.ERROR_MESSAGE);
            total--;
        }

        scoreLabel.setText("Score: " + correct + " / " + total);
    }

    private JLabel bigLabel(String t) {
        JLabel lbl = new JLabel(t, SwingConstants.CENTER);
        lbl.setPreferredSize(new Dimension(80, 70));
        lbl.setOpaque(true);
        lbl.setBackground(new Color(250, 250, 250));
        lbl.setFont(new Font("SansSerif", Font.BOLD, 26));
        lbl.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(0, 120, 215), 3),
                BorderFactory.createEmptyBorder(5,5,5,5)
        ));
        return lbl;
    }

    public static void main(String[] args) {
        try { UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName()); } catch(Exception ignored){}
        SwingUtilities.invokeLater(() -> new ArithmeticGameCalculator().setVisible(true));
    }
}
