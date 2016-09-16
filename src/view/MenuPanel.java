package view;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

public class MenuPanel extends JPanel
{

    private View view;

    private JLabel jLabel1;
    private JLabel jLabel2;
    private JTextField function;
    private JTextPane funcInfo;
    private JTextPane moveInfo;
    private JButton createButton;

    public MenuPanel(View view)
    {
        this.view = view;
        initComponents();
    }

    private void initComponents() {

        createButton = new JButton();
        function = new JTextField();
        jLabel1 = new JLabel();
        jLabel2 = new JLabel();
        funcInfo = new JTextPane();
        moveInfo = new JTextPane();

        funcInfo.setText("Операции:\n" +
                "+\t-\t*\t/\t^\t)\t(\n" +
                "sin\tcos\ttan\tasin\tacos\tatan\tlog\n" +
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


        createButton.setText("Показать");

        jLabel1.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel1.setText("Введите функцию");

        jLabel2.setText("y=");

        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(226, 226, 226)
                                .addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 214, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(88, Short.MAX_VALUE)
                                .addComponent(jLabel2, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(function, GroupLayout.PREFERRED_SIZE, 385, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(createButton))
                                        .addGroup(layout.createSequentialGroup()
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addGap(40, 40, 40))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(7, 7, 7)
                                .addComponent(jLabel1)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(createButton)
                                        .addComponent(function, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel2))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING))
                                .addContainerGap(24, Short.MAX_VALUE))
        );
    }

    public void requestFunction()
    {
        function.requestFocus();
    }

    String getFunction()
    {
        return function.getText();
    }



}


