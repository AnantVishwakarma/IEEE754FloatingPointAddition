
import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import java.awt.CardLayout;
import javax.swing.JLabel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;

public class ProcedureDialog extends JDialog {


	/**
	 * Create the dialog.
	 */
	
	private int xMouse;
	private int yMouse;
	double n1,n2;
	private JTextArea eEqualizingExponents,eAddingSignificands,eNormalizingResult,eFinalResult;
	
	private Color colorPrimary=Color.BLACK,
			colorHighlight=new Color(255, 153, 0);
	
	public ProcedureDialog(JFrame parentFrame,double n1,double n2) {	
		super(parentFrame,true); 
        this.n1=n1;
        this.n2=n2;
        
		setBounds(100,100,450,300);
		setUndecorated(true);
		getContentPane().setLayout(new BorderLayout(0, 0));
		{
			JPanel pTitle = new JPanel();
			pTitle.setBackground(colorHighlight);
			pTitle.addMouseMotionListener(new MouseMotionAdapter() {
				@Override
				public void mouseDragged(MouseEvent e) {
					int x=e.getXOnScreen();
					int y=e.getYOnScreen();
					setLocation(x-xMouse,y-yMouse);
				}
			});
			pTitle.addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent e) {
					xMouse=e.getX();
					yMouse=e.getY();
				}
			});
			
			getContentPane().add(pTitle, BorderLayout.NORTH);
			GridBagLayout gbl_pTitle = new GridBagLayout();
			gbl_pTitle.columnWidths = new int[]{203, 27, 0, 0};
			gbl_pTitle.rowHeights = new int[]{14, 0};
			gbl_pTitle.columnWeights = new double[]{1.0, 0.0, 0.0, Double.MIN_VALUE};
			gbl_pTitle.rowWeights = new double[]{0.0, Double.MIN_VALUE};
			pTitle.setLayout(gbl_pTitle);
			
			JLabel lblNewLabel = new JLabel("Steps");
			lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
			GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
			gbc_lblNewLabel.anchor = GridBagConstraints.WEST;
			gbc_lblNewLabel.insets = new Insets(10, 10, 10, 10);
			gbc_lblNewLabel.gridx = 0;
			gbc_lblNewLabel.gridy = 0;
			pTitle.add(lblNewLabel, gbc_lblNewLabel);
			
			JLabel btnClose = new JLabel("  x  ");
			btnClose.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btnClose.setFont(new Font("Tahoma", Font.PLAIN, 14));
			JDialog thisDialog=this;
			btnClose.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					thisDialog.dispose();
				}
			});
			
			GridBagConstraints gbc_btnClose = new GridBagConstraints();
			gbc_btnClose.ipady = 10;
			gbc_btnClose.insets = new Insets(10, 10, 10, 10);
			gbc_btnClose.gridx = 2;
			gbc_btnClose.gridy = 0;
			pTitle.add(btnClose, gbc_btnClose);
		}
		
		
		
		JPanel pSteps = new JPanel();		
		getContentPane().add(pSteps, BorderLayout.CENTER);
		pSteps.setLayout(new CardLayout(0, 0));
		
		JPanel pEqEx = new JPanel();
		pEqEx.setBackground(colorPrimary);
		pSteps.add(pEqEx, "name_31097523014800");
		GridBagLayout gbl_pEqEx = new GridBagLayout();
		gbl_pEqEx.columnWidths = new int[]{0, 0};
		gbl_pEqEx.rowHeights = new int[]{0, 0, 0};
		gbl_pEqEx.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_pEqEx.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		pEqEx.setLayout(gbl_pEqEx);
		
		JLabel lblNewLabel_1 = new JLabel("1. Equalizing Exponent");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(10, 10, 10, 10);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 0;
		pEqEx.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.getVerticalScrollBar().setBackground(Color.BLACK);
		scrollPane.getHorizontalScrollBar().setBackground(Color.BLACK);
		scrollPane.getVerticalScrollBar().setForeground(colorHighlight);
		scrollPane.getHorizontalScrollBar().setForeground(colorHighlight);
		scrollPane.setBorder(null);
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.insets = new Insets(0, 10, 0, 10);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 1;
		pEqEx.add(scrollPane, gbc_scrollPane);
		
		eEqualizingExponents = new JTextArea();
		scrollPane.setViewportView(eEqualizingExponents);
		
		JPanel pAdSig = new JPanel();		
		pAdSig.setBackground(colorPrimary);
		pSteps.add(pAdSig, "name_31206103112000");
		GridBagLayout gbl_pAdSig = new GridBagLayout();
		gbl_pAdSig.columnWidths = new int[]{0, 0};
		gbl_pAdSig.rowHeights = new int[]{0, 0, 0};
		gbl_pAdSig.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_pAdSig.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		pAdSig.setLayout(gbl_pAdSig);
		
		JLabel lblNewLabel_2 = new JLabel("2. Adding Significands");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.insets = new Insets(10, 10, 10, 10);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 0;
		pAdSig.add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBorder(null);
		GridBagConstraints gbc_scrollPane_1 = new GridBagConstraints();
		gbc_scrollPane_1.insets = new Insets(0, 10, 0, 10);
		gbc_scrollPane_1.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_1.gridx = 0;
		gbc_scrollPane_1.gridy = 1;
		pAdSig.add(scrollPane_1, gbc_scrollPane_1);
		
		eAddingSignificands = new JTextArea();		
		scrollPane_1.setViewportView(eAddingSignificands);
		
		JPanel panel = new JPanel();
		panel.setBackground(colorPrimary);
		pSteps.add(panel, "name_91450174991800");
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0};
		gbl_panel.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JLabel lblNewLabel_3 = new JLabel("3. Normalizing Result");
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.insets = new Insets(10, 10, 10, 10);
		gbc_lblNewLabel_3.gridx = 0;
		gbc_lblNewLabel_3.gridy = 0;
		panel.add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBorder(null);
		GridBagConstraints gbc_scrollPane_2 = new GridBagConstraints();
		gbc_scrollPane_2.insets = new Insets(0, 10, 0, 10);
		gbc_scrollPane_2.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_2.gridx = 0;
		gbc_scrollPane_2.gridy = 1;
		panel.add(scrollPane_2, gbc_scrollPane_2);
		
		eNormalizingResult = new JTextArea();
		scrollPane_2.setViewportView(eNormalizingResult);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(colorPrimary);
		pSteps.add(panel_1, "name_91586120198400");
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{0, 0};
		gbl_panel_1.rowHeights = new int[]{0, 0, 0};
		gbl_panel_1.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		JLabel lblNewLabel_4 = new JLabel("4. Final Result");
		lblNewLabel_4.setForeground(Color.WHITE);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.insets = new Insets(10, 10, 10, 10);
		gbc_lblNewLabel_4.gridx = 0;
		gbc_lblNewLabel_4.gridy = 0;
		panel_1.add(lblNewLabel_4, gbc_lblNewLabel_4);
		
		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBorder(null);
		GridBagConstraints gbc_scrollPane_3 = new GridBagConstraints();
		gbc_scrollPane_3.insets = new Insets(0, 10, 0, 10);
		gbc_scrollPane_3.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_3.gridx = 0;
		gbc_scrollPane_3.gridy = 1;
		panel_1.add(scrollPane_3, gbc_scrollPane_3);
		
		eFinalResult = new JTextArea();
		scrollPane_3.setViewportView(eFinalResult);
		
		JPanel pButtonContainer = new JPanel();
		FlowLayout flowLayout = (FlowLayout) pButtonContainer.getLayout();
		flowLayout.setHgap(20);
		flowLayout.setVgap(10);
		pButtonContainer.setBackground(colorPrimary);
		getContentPane().add(pButtonContainer, BorderLayout.SOUTH);
		
		JButton btnNewButton_1 = new JButton("Previous");
		btnNewButton_1.setPreferredSize(btnNewButton_1.getPreferredSize());
		btnNewButton_1.setForeground(colorHighlight);
		btnNewButton_1.setBackground(Color.BLACK);
		btnNewButton_1.setBorder(new LineBorder(colorHighlight,1));
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnNewButton_1.setFocusable(false);
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnNewButton_1.setForeground(Color.WHITE);
				btnNewButton_1.setBackground(colorHighlight);	
				btnNewButton_1.setBorder(new EmptyBorder(1,1,1,1));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnNewButton_1.setForeground(colorHighlight);
				btnNewButton_1.setBackground(Color.BLACK);
				btnNewButton_1.setBorder(new LineBorder(colorHighlight,1));
			}
		});
		
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				((CardLayout)pSteps.getLayout()).previous(pSteps);
			}
		});
		pButtonContainer.add(btnNewButton_1);
		
		JButton btnNewButton = new JButton("Next");
		btnNewButton.setPreferredSize(btnNewButton_1.getPreferredSize());
		btnNewButton.setForeground(colorHighlight);
		btnNewButton.setBackground(Color.BLACK);
		btnNewButton.setBorder(new LineBorder(colorHighlight,1));
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnNewButton.setFocusable(false);
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnNewButton.setForeground(Color.WHITE);
				btnNewButton.setBackground(colorHighlight);	
				btnNewButton.setBorder(new EmptyBorder(1,1,1,1));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnNewButton.setForeground(colorHighlight);
				btnNewButton.setBackground(Color.BLACK);
				btnNewButton.setBorder(new LineBorder(colorHighlight,1));
			}
		});
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				((CardLayout)pSteps.getLayout()).next(pSteps);
			}
		});
		pButtonContainer.add(btnNewButton);
		performAndDisplay();
		pack();
		setVisible(true);
	}
	
	String getSignificand(int b[])
    {
        String x="";
        int n=b.length;
        int i;
        for(i=0;i<23;i++)x=b[n-i-1]+x;
        x="."+x;
        while(i<b.length)
        {
            x=b[n-i-1]+x;
            i++;
        }
        return x;
    }

    //eEqualizingExponents,eAddingSignificands,eNormalizingResult,eResult;
    void performAndDisplay()
    {
        IEEEFloatingPointNumber X=IEEEFloatingPointNumber.getIEEERepresentation(n1);
        IEEEFloatingPointNumber Y=IEEEFloatingPointNumber.getIEEERepresentation(n2);
        int significandX[]=new int[24];
        int significandY[]=new int[24];
        if(Binary.isZero(X.biasedExponent) && Binary.isZero(X.mantissa))
        {
            eFinalResult.append("First Number = 0\nAnswer = "+n2);
            return;
        }
        if(Binary.isZero(Y.biasedExponent) && Binary.isZero(Y.mantissa))
        {
        	eFinalResult.append("Second Number = 0\nAnswer = "+n1);
            return;
        }
        for(int i=0;i<23;i++)
        {
            significandX[i+1]=X.mantissa[i];
            significandY[i+1]=Y.mantissa[i];
        }
        significandX[0]=1;
        significandY[0]=1;        
        int expX=Binary.toInteger(X.biasedExponent);
        int expY=Binary.toInteger(Y.biasedExponent);
        int maxExp=(expX>expY)?expX:expY;
        eEqualizingExponents.append("Significand Of X = "+getSignificand(significandX)+", Exponent Of X = "+expX+"\n");
        eEqualizingExponents.append("Significand Of Y = "+getSignificand(significandY)+", Exponent Of Y = "+expY+"\n");

        //Make Exponents Equal
        if(expX!=expY)
        {
            eEqualizingExponents.append("Making Exponents Equal\n");
            while(expX<expY)
            {
                eEqualizingExponents.append("Exponent of X < Exponent of Y\n");                      
                Binary.logicalShiftRight(significandX);
                eEqualizingExponents.append("Right Shift Significand Of X, Significand Of X = "+getSignificand(significandX)+"\n");  
                expX++;
                eEqualizingExponents.append("Increment Biased Exponent of X, Biased Exponent Of X = "+expX+"\n");
                if(Binary.isZero(significandX))
                {
                    eEqualizingExponents.append("Answer = "+n2);
                    return;
                }
            }
            while(expY<expX)
            {
                eEqualizingExponents.append("Exponent of Y < Exponent of X\n");                      
                Binary.logicalShiftRight(significandY);
                eEqualizingExponents.append("Right Shift Significand Of Y, Significand Of Y = "+getSignificand(significandY)+"\n");  
                expY++;
                eEqualizingExponents.append("Increment Biased Exponent of Y, Biased Exponent Of Y = "+expY+"\n");
                if(Binary.isZero(significandY))
                {
                    eEqualizingExponents.append("Answer = "+n1);
                    return;
                }
            }
            eEqualizingExponents.append("Now Exponents Are Equal\n");
        }
        else
        {
            eEqualizingExponents.append("Exponents Are Already Equal\n");
        }

        //Adding Significands  
        eAddingSignificands.append("Significand of X = "+getSignificand(significandX)+"\nSignificand of Y = "+getSignificand(significandY)+"\n");
        if(X.signBit==Y.signBit)
        {
            eAddingSignificands.append("Sign bit of both numbers are same, hence taking addition of significands\n");
            int resAddition[]=Binary.addBinary(significandX,significandY);//25 bits            
            if(resAddition[0]==1)//Significand Overflow Case
            {
                eAddingSignificands.append("Resulting Significand = "+getSignificand(resAddition)+"\n");  
                eNormalizingResult.append("Significand Overflow Occured\nShifting Significand Right, ");
                Binary.logicalShiftRight(resAddition);//Normalizing Result 
                eNormalizingResult.append("Significand = "+getSignificand(Arrays.copyOfRange(resAddition,1,25))+"\n");
                maxExp++;
                eNormalizingResult.append("Increment Biased Exponent, Biased Exponent = "+maxExp+"\n");
                if(maxExp>254)//Exponent Overflow Case
                {
                    //throw new ExponentOverflowException("Exponent Overflow Occured");
                    eNormalizingResult.append("Exponent Overflow Occured\n");
                    return;
                }
            }
            else
            {
                eAddingSignificands.append("Resulting Significand = "+getSignificand(Arrays.copyOfRange(resAddition,1,25))+"\n"); 
                eNormalizingResult.append("Result Already Normalized\n");
            }
            IEEEFloatingPointNumber res=new IEEEFloatingPointNumber(X.signBit,maxExp,Arrays.copyOfRange(resAddition,2,25)); 
            eFinalResult.append("Result in IEEE 754 Format: "+res.getIEEEFormatString()+"\nAnswer: "+res.getNumber());
        }
        else
        {
            eAddingSignificands.append("Sign bit of both numbers are different, hence taking difference of significands\n");
            int rSignBit=0;
            if(IEEEFloatingPointNumber.absCompare(X,Y)==1)rSignBit=X.signBit;
            else if(IEEEFloatingPointNumber.absCompare(X,Y)==-1)rSignBit=Y.signBit;
            else //signs are different,magnitude is same,answer is 0
            {
            	eFinalResult.append("Since sign bits of both the numbers are different,magnitude is same\nAnswer = 0.0");
            }
            int resDifference[]=Binary.difference(significandX,significandY);//24 bits
            eAddingSignificands.append("Resulting Significand = "+getSignificand(resDifference)+"\n");
            if(resDifference[0]==0)//Result Not Normalized
            {                
                while(resDifference[0]==0)//Result Not Normalized
                {                
                    Binary.logicalShiftLeft(resDifference);
                    eNormalizingResult.append("Left Shift Significand, Significand="+getSignificand(resDifference)+"\n");
                    maxExp--;
                    eNormalizingResult.append("Decrement Exponent, Exponent = "+maxExp+"\n");
                    if(maxExp<1)//Exponent Underflow Case
                    {
                        //throw new ExponentUnderflowException("Exponent Underflow Occured");
                        eNormalizingResult.append("Exponent Underflow Occured\n");
                        return;
                    }
                }   
            }
            else
            {
                eNormalizingResult.append("Result Already Normalized\n");
            }
            IEEEFloatingPointNumber res=new IEEEFloatingPointNumber(rSignBit,maxExp,Arrays.copyOfRange(resDifference,1,24));
            eFinalResult.append("Result in IEEE 754 Format: "+res.getIEEEFormatString()+"\nAnswer: "+res.getNumber());
        }
    }

}
