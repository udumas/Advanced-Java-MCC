

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.KeyStroke;

@SuppressWarnings("serial")
public class Project2 extends JFrame
{
	private JLabel equationLabel = new JLabel("Enter and Equation");
	private JTextField equation = new JTextField(15);
	private JLabel valueLabel = new JLabel("Value:            ");
	private JTextField value = new JTextField(15);
	private JButton calculate = new JButton("Calculate");
	private JButton clear = new JButton("Clear");
	private JMenuItem jmiCalculate;
	private JMenuItem jmiClear;
	private JMenuItem jmiExit;
	private JMenuItem jmiAbout;
	private JMenuItem jmiInputInfo;


	/**
	 * 
	 */
	public Project2()
	{
		JMenuBar jmenuBar = new JMenuBar();
		setJMenuBar(jmenuBar);
		JMenu operationMenu = new JMenu("Operation");
		JMenu helpMenu = new JMenu("Help");
		operationMenu.setMnemonic(KeyEvent.VK_O);
		operationMenu.setDisplayedMnemonicIndex(0);
		helpMenu.setMnemonic(KeyEvent.VK_H);
		helpMenu.setDisplayedMnemonicIndex(0);
		jmenuBar.add(operationMenu);	
		jmenuBar.add(helpMenu);
		operationMenu.add(jmiCalculate = new JMenuItem("Calculate"));
		operationMenu.add(jmiClear = new JMenuItem("Clear"));
		operationMenu.insertSeparator(2);
		operationMenu.add(jmiExit = new JMenuItem("Exit"));
		helpMenu.add(jmiAbout = new JMenuItem("About"));
		helpMenu.add(jmiInputInfo = new JMenuItem("Input Information"));
		jmiClear.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R, ActionEvent.CTRL_MASK));

		setLayout(new GridLayout(2,2,5,5));
		
		JPanel p1 = new JPanel(new GridLayout(2,3));
		p1.add(equationLabel);
		p1.add(equation);
		p1.add(valueLabel);
		p1.add(value);
		
		JPanel p2 = new JPanel(new GridLayout(1,3));
		p2.add(calculate);
		p2.add(clear);
		add(p1,BorderLayout.CENTER);
		add(p2,BorderLayout.SOUTH);
		
		
		/**
		 * Set up the calculate Button and the Menu Item for the calculate function
		 * 
		 */
		calculate.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent arg0) {
	        	String[] expression=getExpression();
	    		if(expression[0].equals("q"))
	    		{
	    			equation.setText("");
	    			value.setText("");
	    		}else{
	    			
	    		try {
					String firstRE = expression[0];
					String secondRE = expression[2];
					String operation = expression[1];
					RationalExpression r1= new RationalNumber(firstRE);
					RationalExpression r2= new RationalNumber(secondRE);
					@SuppressWarnings("unused")
					RationalExpression testResult = r1.div(r2);
					String result = doOperation(r1, r2, operation);
					String returnString = r1.toString() + " " 
										+ expression[1] + " " 
										+ r2.toString() + " "
										+ "= " 
										+ result.toString();
					value.setText(returnString);
				} catch (NumberFormatException e) {
					JOptionPane.showMessageDialog(null, "All Values are not valid Rational Expressions ", "",JOptionPane.INFORMATION_MESSAGE);	

				}catch(NullPointerException e){
					JOptionPane.showMessageDialog(null, "Operation to perform on Rational Expressions Must Be \n /,*,+,-,+,<=,>=", "",JOptionPane.INFORMATION_MESSAGE);	

				}
	    		
	    		}
	        	}
		      });
		
		/**
		 * set the accelerator key for the calculate function
		 */
		jmiCalculate.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L, ActionEvent.CTRL_MASK));
		jmiCalculate.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent arg0) {
	        	String[] expression=getExpression();
	    		if(expression[0].equals("q"))
	    		{
	    			equation.setText("");
	    			value.setText("");
	    		}else{
	    		String firstRE = expression[0];
	    		String secondRE = expression[2];
	    		String operation = expression[1];
	    		RationalExpression r1= new RationalNumber(firstRE);
	    		RationalExpression r2= new RationalNumber(secondRE);
	    		String result = doOperation(r1, r2, operation);
	    		String returnString = r1.toString() + " " 
	    							+ expression[1] + " " 
	    							+ r2.toString() + " "
	    							+ "= " 
	    							+ result.toString();
	    		value.setText(returnString);
	    		}
	        	}
		      });

		clear.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				value.setText("");
				equation.setText("");
			}

		});
		jmiClear.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				value.setText("");
				equation.setText("");
			}

		});
		
		jmiAbout.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_T, ActionEvent.CTRL_MASK));
		jmiAbout.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				JOptionPane.showMessageDialog(null, "Computing Fraction Value", "",JOptionPane.INFORMATION_MESSAGE);	
			}
		});
		
		jmiInputInfo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_I, ActionEvent.CTRL_MASK));
		jmiInputInfo.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				JOptionPane.showMessageDialog(null,"Example for Input \n 1/2 + 2/3 \n "
						+ "need space between operand and operation");
			}
		});
		
		
		jmiExit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, ActionEvent.CTRL_MASK));
		jmiExit.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
			
		});
	}
	

	public static void main(String[] args)
	{
		Project2 frame = new Project2();
		frame.setTitle("Project 2");
		frame.setSize(200,125);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	
	/**
	 * Prints a message to the user to input the appropriate  data
	 * calls the checkValid function to validate the input, and loops until 
	 * valid data has been entered
	 * @return
	 */
	private String[] getExpression() 
	{
		String expression;
		expression=equation.getText();
//		if(!checkValid(expression))
//		{
//			String[] tokens = {"q"};
//			return tokens;
//		}else{
			String[] tokens = expression.split("\\s+");
			return tokens;
//		}

	}

	/**
	 * uses a regular expression to validate that the expression ios of the 
	 * will contain only digits and the following operators /,-,+,=,*,<,>,
	 * @param NUMBER_OF_TOKENS
	 * @param tokens
	 */
//	private boolean checkValid(String expression) 
//	{
//		
//		if(expression.matches("\\d*/*\\d*\\s(-|\\+|=|\\*|/|<|>)?\\s\\d*/*\\d*"))
//		{
//			return true;
//		}else{
//			return false;
//		}
//	}
		
	/**
	 * doOperation function determines the value of the operator and calls the associated method 
	 * the class 
	 * @param r1
	 * @param r2
	 * @param operation
	 * @return
	 */
	private String doOperation(RationalExpression r1,RationalExpression r2,String operation)
	{
		String result;
		switch(operation)
		{
		case "+":
			result=r1.add(r2).toString();
			break;
		case "-":
			result=r1.sub(r2).toString();
			break;
		case "*":
			result=r1.mlt(r2).toString();
			break;
		case "/":
			result=r1.div(r2).toString();
			break;
		case "<=":
		case "=<":
			result=((Boolean)r1.le(r2)).toString();
			break;
		case ">=":
		case "=>":
			result=((Boolean)r1.ge(r2)).toString();
			break;
		case "<":
			result=((Boolean)r1.lt(r2)).toString();
			break;
		case ">":
			result=((Boolean)r1.gt(r2)).toString();
			break;
		case "==":
		case "=":
			result=((Boolean)r1.eq(r2)).toString();
			break;
		default:
			result= null;
		
		}
		return result;
	}

}


