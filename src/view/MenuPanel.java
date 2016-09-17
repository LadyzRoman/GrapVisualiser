package view;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

public class MenuPanel extends JPanel
{

    private View view;

    private JLabel title;
    private JLabel yLabel;
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
        title = new JLabel();
        yLabel = new JLabel();
        funcInfo = new JTextPane();
        moveInfo = new JTextPane();

        createButton.setText("Показать");

        title.setHorizontalAlignment(SwingConstants.CENTER);
        title.setText("Введите функцию");

        yLabel.setText("y=");
        yLabel.setHorizontalAlignment(SwingConstants.RIGHT);

        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(title, GroupLayout.PREFERRED_SIZE, 600, GroupLayout.PREFERRED_SIZE)
                                )
                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(yLabel, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(function, GroupLayout.PREFERRED_SIZE, 350, GroupLayout.PREFERRED_SIZE)
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
                                .addComponent(title)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(createButton)
                                        .addComponent(function, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(yLabel))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING))
                                .addContainerGap(24, Short.MAX_VALUE))
        );

 /*       funcInfo.setText("Операции:\n" +
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
        doc.setParagraphAttributes(0,doc.getLength(),center,false);*/


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



}


