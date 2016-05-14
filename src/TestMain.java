import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
public class TestMain extends JFrame implements ActionListener{

	public static String Potassium = "soccer";
	public JButton button;
	public static void main(String[] args) {
		new TestMain();
	}
	public TestMain(){
		this.setSize(400,300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle(Potassium);
		this.setResizable(false);
		JPanel panel = new JPanel();
		button = new JButton("CLICK 5 SOCKER");
		button.addActionListener(this);
		panel.add(button);
		this.add(panel);
		this.setVisible(true);
		
	}
	private int ClickCount = 0;
	public void actionPerformed(ActionEvent e){
		if(e.getSource() == button){
			ClickCount ++;
			if(ClickCount == 1) 
				button.setText("IVE BEAN CLIKKED");
			else
				button.setText("IVE BEAN CLIKKED "+ClickCount+" Tmies");
		}
	}
	
}
