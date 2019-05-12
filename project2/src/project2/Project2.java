package project2;

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
/**
 * 
 * @author Joel Salisbury
 * This Class generates a gui interface using the Swing libraries,
 * and allows the user to input a string representing two rational Expressions
 * The program then calculates the value of Rational Expression resulting from 
 * performing the operation input by the user on the Rational Expressions 
 * input by the user.
 */
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
	 * Generic Constructor for the class
	 * instantiates the gui interface for the class
	 */
	public Project2()
	{
		/**
		 * Generate the MenuBar
		 */
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

		/**
		 * create the user interface for the frame
		 */
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
		 * Calculate Function uses an annonymous Class to generate an 
		 * actionlistener for the calculate button. 
		 * 
		 * 
		 */
		calculate.addActionListener(new ActionListener() {
	        
			/**
			 * ActionPerformed method required for all ActionListeners
			 * gets the value of the string from the Expression 
			 * text field determines the operands and operator from the string.
			 * generates error messages if the text has been input in an 
			 * improper manner 
			 */
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
					int testResult = r1.getNumerator()/r1.getDenominator();
					testResult = r2.getNumerator()/r2.getDenominator();

					String result = doOperation(r1, r2, operation);
					String returnString = r1.toString() + " " 
										+ expression[1] + " " 
										+ r2.toString() + " "
										+ "= " 
										+ result.toString();
					value.setText(returnString);
					
					
					
				}
	    		catch(ArithmeticException e)
	    		{
	    			JOptionPane.showMessageDialog(null, 
							"denominator cannot be zero", 
							"",JOptionPane.ERROR_MESSAGE);	
	    		}
	    		catch(ArrayIndexOutOfBoundsException e){
	    			try{
	    				String firstRE = expression[0];
						RationalExpression r1= new RationalNumber(firstRE);
						int testResult;
						testResult = r1.getNumerator()/r1.getDenominator();
						String returnString = r1.toString();
						if(expression[0]==null){
						value.setText(returnString);
						}else{
							JOptionPane.showMessageDialog(null, 
									"Include spaces between operands and operator", 
									"",JOptionPane.ERROR_MESSAGE);	
						}
	    				}
	    			catch(ArithmeticException e2)
	    			{
	    				JOptionPane.showMessageDialog(null, 
								"Numerator cannot be zero", 
								"",JOptionPane.ERROR_MESSAGE);	
	    			}
	    			catch(NumberFormatException e2)
	    			{
	    				JOptionPane.showMessageDialog(null, 
								"Include spaces between operands and operator", 
								"",JOptionPane.ERROR_MESSAGE);	
	    			}
	    		}
	    		catch (NumberFormatException e) {
					JOptionPane.showMessageDialog(null, 
							"All Values are not valid Rational Expressions ", 
							"",JOptionPane.ERROR_MESSAGE);	

				}catch(NullPointerException e){
					JOptionPane.showMessageDialog(null, 
							"Operation to perform on Rational Expressions Must Be \n /,*,+,-,+,<=,>=", 
							"",JOptionPane.ERROR_MESSAGE);	

				}
	    		
	    		}
	        	}
		      });
		
		/**
		 * set the accelerator key for the calculate function
		 */
		jmiCalculate.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L,
				ActionEvent.CTRL_MASK));
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
/**
 * ActionListener class for the clear button
 * 
 */
		clear.addActionListener(new ActionListener(){
			/**
			 * Sets the value of both the equation and value 
			 * text fields to null
			 */
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
		
		jmiAbout.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_T, 
				ActionEvent.CTRL_MASK));
		jmiAbout.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				JOptionPane.showMessageDialog(null, "Computing Fraction Value",
						"",JOptionPane.INFORMATION_MESSAGE);	
			}
		});
		
		jmiInputInfo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_I,
				ActionEvent.CTRL_MASK));
		jmiInputInfo.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				JOptionPane.showMessageDialog(null,
						"Example for Input \n 1/2 + 2/3 \n "
						+ "need space between operand and operation");
			}
		});
		
		
		jmiExit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, 
				ActionEvent.CTRL_MASK));
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
	 * @return
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
	 * doOperation function determines the value of the operator and calls 
	 * the associated method  
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


