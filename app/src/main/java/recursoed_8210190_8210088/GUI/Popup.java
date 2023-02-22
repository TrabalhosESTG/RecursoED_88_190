package recursoed_8210190_8210088.GUI;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * @author guilherme
 */
public class Popup {
	JFrame contentPane= new JFrame("Aviso");
	public Popup(String aviso) {
		initComponents(aviso);
	}

	private void close(ActionEvent e) {
		contentPane.dispose();
	}

	private void initComponents(String aviso) {
		// JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
		// Generated using JFormDesigner Evaluation license - guilherme
		label1 = new JLabel();
		button1 = new JButton();

		//---- label1 ----
		label1.setText(aviso);
		label1.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(label1);
		label1.setBounds(6, 12, 271, 110);

		//---- button1 ----
		button1.setText("OK");
		contentPane.add(button1);
		button1.setBounds(new Rectangle(new Point(102, 128), button1.getPreferredSize()));
		button1.addActionListener(e -> close(e));

		contentPane.setSize(280,200);
		contentPane.setLayout(null);
		contentPane.setVisible(true);

		// JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
	}

	// JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
	// Generated using JFormDesigner Evaluation license - guilherme
	private JLabel label1;
	private JButton button1;
	// JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
