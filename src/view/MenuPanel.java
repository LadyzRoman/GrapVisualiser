package view;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

public class MenuPanel extends JPanel
{

    private View view;

    private JLabel yLabel;
    private JTextField function;
    private JTextPane funcInfo;
    private JTextPane moveInfo;
    private JButton createButton;
    private JTextField minX;
    private JTextField maxX;
    private JTextField step;

    public MenuPanel(View view)
    {
        this.view = view;
        initComponents();
    }

    private void initComponents() {
        function = new javax.swing.JTextField();
        yLabel = new javax.swing.JLabel();
        createButton = new javax.swing.JButton();
        JLabel title = new javax.swing.JLabel();
        JLabel jLabel2 = new javax.swing.JLabel();
        JLabel jLabel3 = new javax.swing.JLabel();
        JLabel jLabel4 = new javax.swing.JLabel();
        step = new javax.swing.JTextField();
        maxX = new javax.swing.JTextField();
        minX = new javax.swing.JTextField();
        funcInfo = new javax.swing.JTextPane();
        moveInfo = new javax.swing.JTextPane();

        yLabel.setText("y = ");

        createButton.setText("Показать");

        title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        title.setText("Введите функцию");

        jLabel2.setText("Минимум");

        jLabel3.setText("Максимум");
        jLabel3.setToolTipText("");

        jLabel4.setText("Шаг");

        step.setText("0.01");

        maxX.setText("20");

        minX.setText("-20");


        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(title, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(yLabel)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(function, javax.swing.GroupLayout.PREFERRED_SIZE, 416, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(createButton)
                                                .addGap(20, 20, 20))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(minX, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                        .addComponent(step)
                                                                        .addComponent(maxX, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                                .addGap(18, 18, 18)
                                                .addComponent(funcInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(32, 32, 32)
                                                .addComponent(moveInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(50, 50, 50))))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(title)
                                .addGap(9, 9, 9)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(function, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(yLabel)
                                        .addComponent(createButton))
                                .addGap(9, 9, 9)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(funcInfo, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabel2)
                                                        .addComponent(minX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(maxX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel3))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(step, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel4)))
                                        .addComponent(moveInfo))
                                .addContainerGap(28, Short.MAX_VALUE))
        );

        funcInfo.setText("Операции:\n" +
                "+\t-\t*\t/\t^\t)\t(\t" +
                "sin\tcos\ttan\tasin\tacos\tatan\tlog\t" +
                "log10\texp\tabs\tsignum\tsqrt\tcbrt");
        funcInfo.setBackground(view.getBackground());
        StyledDocument doc = funcInfo.getStyledDocument();
        SimpleAttributeSet center = new SimpleAttributeSet();
        StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
        doc.setParagraphAttributes(0, doc.getLength(), center, false);
        funcInfo.setBorder(BorderFactory.createEtchedBorder());
        moveInfo.setText("+\tПриблизить\n" +
                "-\tОтдалить\n" +
                "Стрелочки\tПеремещение");
        moveInfo.setBackground(view.getBackground());
        moveInfo.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
        doc = moveInfo.getStyledDocument();
        doc.setParagraphAttributes(0,doc.getLength(),center,false);


        view.getRootPane().setDefaultButton(createButton);
        createButton.addActionListener((e) -> view.getController().createFunction());



    }



    public void requestFunction()
    {
        function.requestFocus();
    }

    String getFunction()
    {
        return function.getText();
    }

    String getMinX()
    {
        return minX.getText();
    }


    String getMaxX()
    {
        return maxX.getText();
    }

    String getStep()
    {
        return step.getText();
    }

}


