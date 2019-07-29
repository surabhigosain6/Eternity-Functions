package Surbhi;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.font.NumericShaper;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class LogXb {
	
	public static int NUM_ITERATIONS = 100;
	
	public double power(double num, double exp) {
		double res = 1;
		for(int i = 0; i < exp; i++) {
			res = res * num;
		}
		return res;
	}
	
	public double logBasee(double num) {
		
		double ctr = 1;
		double sum = 0;
		
		for(int i = 0; i < NUM_ITERATIONS; i++) {
			double tmp = (num - 1) / (num + 1);
			tmp = power(tmp, ctr);
			tmp = tmp * (1.0 / ctr);
			sum += tmp;
			ctr += 2;
		}
		
		sum = sum * 2;
		
		return sum;
	}
	
	public double calcLog(double num, double base) {
		if(num <= 0 || base <= 0) {
			return 0;
		}
		
		if(num == 1) {
			return 0;
		}
		
		double result = 0.0;
		double numerator = logBasee(num);
		double denominator = logBasee(base);
		
		result =  numerator/denominator;
		return result;
	}
	
	public void runGui() {
		JFrame.setDefaultLookAndFeelDecorated(true);
		JFrame win = new JFrame();
		win = new JFrame("Log Calculator");
		win.setLayout(null);
		win.setSize(250,200);
		win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel numLabel = new JLabel("Enter the number");
		numLabel.setBounds(10, 10, 100, 20);
		win.add(numLabel);
		
		JTextField numText = new JTextField();
		numText.setBounds(150, 10, 50, 20);
		win.add(numText);
		
		JLabel expLabel = new JLabel("Enter the base");
		expLabel.setBounds(10, 40, 130, 20);
		win.add(expLabel);
		
		JTextField expText = new JTextField();
		expText.setBounds(150, 40, 50, 20);
		win.add(expText);
		
		JLabel resLabel = new JLabel("");
		resLabel.setBounds(10, 100, 250, 20);
		win.add(resLabel);
		
		JButton calc = new JButton("Calculate Log");
		calc.setBounds(40, 70, 120, 20);
		calc.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String num1 = numText.getText();
				String num2 = expText.getText();
				if(num1.length() < 1 || num2.length() < 1) {
					JOptionPane.showMessageDialog(null, "Please enter numerical values", 
							"Error", JOptionPane.INFORMATION_MESSAGE);
				}
				else {
					try {
						Double x = Double.parseDouble(num1);
						Double base = Double.parseDouble(num2);
						
						if(x <= 0 || base <= 0) {
							JOptionPane.showMessageDialog(null, "Please enter values greater than 0", 
									"Error", JOptionPane.INFORMATION_MESSAGE);
						}
						else {
							if(x == 1) {
								resLabel.setText("Result: 0");
							}
							else {
								Double result = calcLog(x, base);
								resLabel.setText("Result: " + result);
							}
						}
					}
					catch(Exception excep) {
						JOptionPane.showMessageDialog(null, "Please enter only numbers and decimal", 
								"Error", JOptionPane.INFORMATION_MESSAGE);
					}
				}
			}
		});
		win.add(calc);
		
		
		
		win.setVisible(true);
	}
	
	public static void main(String[] args) {
		LogXb obj = new LogXb();
		obj.runGui();
	}

}
