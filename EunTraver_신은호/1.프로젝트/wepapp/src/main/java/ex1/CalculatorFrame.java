package ex1;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import ex2.CalculatorAgent;

public class CalculatorFrame extends JFrame implements ActionListener{

	protected JTextField operand1;
	protected JTextField operand2;
	protected String[] operatorData = {"+", "-", "*", "/"};
	protected JComboBox<String> operator;
	protected JButton equal;
	protected JTextField result;
	protected JButton clear;
	CalculatorAgent calcAgent;
	
	public CalculatorFrame() {
		operand1 = new JTextField(4);
		operand2 = new JTextField(4);
		operator = new JComboBox<String>(operatorData);
		equal = new JButton("=");
		result = new JTextField(6);
		clear = new JButton("clear");
		
		try {
			calcAgent = new CalculatorAgent("localhost",8888);
			
		}catch(Exception err) {
			JOptionPane.showMessageDialog(null, err.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
			System.exit(0);
		}
		
		this.setTitle("°è»ê±â");
		Container contentPane = this.getContentPane();
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
		contentPane.add(Box.createVerticalGlue());
		contentPane.add(this.createInputForm());
		contentPane.add(this.createToolBar());
		contentPane.add(Box.createVerticalGlue());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.pack();
		this.setLocationRelativeTo(null);
	}
	
	public void actionPerformed(ActionEvent event) {
		double a = Double.parseDouble(operand1.getText());
		double b = Double.parseDouble(operand2.getText());
		double r =0;
		if(event.getSource()==equal) {
			try {
				r = calcAgent.compute(operator.getSelectedItem().toString(),a,b);
				result.setText(Double.toString(r));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else {
			clearForm();
		}
	}
	private void compute() {
		double a = Double.parseDouble(operand1.getText());
		double b = Double.parseDouble(operand2.getText());
		double r =0;
		try {
			switch (operator.getSelectedItem().toString()) {
			case "+" : r = a+b; break;
			case "-" : r = a-b; break;
			case "*" : r = a*b; break;
			case "/" :
				if(b==0)throw new Exception("Exception!!");
				r=a/b; break;
			}
			result.setText(Double.toString(r));
		}catch ( Exception err) {
			JOptionPane.showMessageDialog(
					null,err.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
					
		}
	}
	private void clearForm() {
		this.operand1.setText("");
		this.operand2.setText("");
		this.result.setText("");
	}
	
	private Box createToolBar() {
		 Box box = Box.createHorizontalBox();
		 box.add(clear);
		 clear.addActionListener(this);
		 return box;
	}
	private Box createInputForm() {
		Box box = Box.createHorizontalBox();
		box.setMaximumSize(new Dimension(300,30));
		box.setAlignmentY(Box.CENTER_ALIGNMENT);
		box.add(operand1);
		box.add(operator);
		box.add(operand2);
		box.add(equal);
		box.add(result);
		equal.addActionListener(this);
		return box;
	}
	
	public static void main(String[] args) {
	CalculatorFrame app = new CalculatorFrame();
	app.setVisible(true);
	}

}
