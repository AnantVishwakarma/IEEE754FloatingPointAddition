
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.MouseEvent;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import java.awt.Cursor;

public class IEEESimulator extends JFrame {

	private JPanel contentPane;
	private JTextField eFN;
	private JTextField eSN;
	private JTextField eFNSB;
	private JTextField eFNE;
	private JTextField eFNM;
	private JTextField eSNSB;
	private JTextField eSNE;
	private JTextField eSNM;
	private JTextField eRSB;
	private JTextField eRE;
	private JTextField eRM;
	double FN,SN;
	
	private int xMouse,yMouse;
	
	private Color colorPrimary=Color.BLACK,
	colorSecondary=Color.WHITE,
	colorHighlight=new Color(255, 153, 0);

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IEEESimulator frame = new IEEESimulator();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public IEEESimulator() {		
		setTitle("Simulator");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setUndecorated(true);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		
		contentPane.setBackground(colorHighlight);
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(colorPrimary);
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setVgap(10);
		flowLayout.setHgap(10);
		flowLayout.setAlignment(FlowLayout.RIGHT);
		contentPane.add(panel, BorderLayout.SOUTH);
		
		JButton btnAdd = new JButton("ADD");
		btnAdd.setPreferredSize(btnAdd.getPreferredSize());
		btnAdd.setForeground(colorHighlight);
		btnAdd.setBackground(Color.BLACK);
		btnAdd.setBorder(new LineBorder(colorHighlight,1));
		btnAdd.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnAdd.setForeground(Color.WHITE);
				btnAdd.setBackground(colorHighlight);	
				btnAdd.setBorder(new EmptyBorder(1,1,1,1));
				
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnAdd.setForeground(colorHighlight);
				btnAdd.setBackground(Color.BLACK);
				btnAdd.setBorder(new LineBorder(colorHighlight,1));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				btnAdd.setForeground(Color.WHITE);
				btnAdd.setBackground(colorHighlight);
			}						
		});		
		btnAdd.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnAdd.setFocusable(false);
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cmdAdd();
			}
		});
		panel.add(btnAdd);
		
		JButton btnReset = new JButton("RESET");
		btnReset.setPreferredSize(btnAdd.getPreferredSize());
		btnReset.setForeground(colorHighlight);
		btnReset.setBackground(Color.BLACK);
		btnReset.setBorder(new LineBorder(colorHighlight,1));
		btnReset.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnReset.setForeground(Color.WHITE);
				btnReset.setBackground(colorHighlight);				
				btnReset.setBorder(new EmptyBorder(1,1,1,1));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnReset.setForeground(colorHighlight);
				btnReset.setBackground(Color.BLACK);
				btnReset.setBorder(new LineBorder(colorHighlight,1));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				btnReset.setForeground(Color.WHITE);
				btnReset.setBackground(colorHighlight);
			}	
		});		
		btnReset.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnReset.setFocusable(false);
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cmdReset();
			}
		});
		panel.add(btnReset);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(colorPrimary);
		contentPane.add(panel_1, BorderLayout.CENTER);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{0, 0};
		gbl_panel_1.rowHeights = new int[]{0, 0, 0, 0};
		gbl_panel_1.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{1.0, 1.0, 1.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(colorPrimary);		
		panel_2.setBorder(new TitledBorder(new LineBorder(new Color(255, 255, 255), 1, true), "Input", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(255, 255, 255)));
		((TitledBorder)panel_2.getBorder()).setTitleFont(new Font("Tahoma", Font.PLAIN, 11));
		GridBagConstraints gbc_panel_2 = new GridBagConstraints();
		gbc_panel_2.ipadx = 10;
		gbc_panel_2.ipady = 10;
		gbc_panel_2.weighty = 1.0;
		gbc_panel_2.insets = new Insets(10, 10, 10, 10);
		gbc_panel_2.fill = GridBagConstraints.BOTH;
		gbc_panel_2.gridx = 0;
		gbc_panel_2.gridy = 0;
		panel_1.add(panel_2, gbc_panel_2);
		GridBagLayout gbl_panel_2 = new GridBagLayout();
		gbl_panel_2.columnWidths = new int[]{0, 0, 0};
		gbl_panel_2.rowHeights = new int[]{0, 0, 0};
		gbl_panel_2.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_panel_2.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		panel_2.setLayout(gbl_panel_2);
		
		JLabel lblNewLabel = new JLabel("First Number:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.weighty = 1.0;
		gbc_lblNewLabel.insets = new Insets(5, 5, 5, 5);
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		panel_2.add(lblNewLabel, gbc_lblNewLabel);
		
		eFN = new JTextField();
		eFN.setForeground(colorHighlight);
		eFN.setOpaque(false);
		eFN.setBorder(new MatteBorder(0, 0, 1, 0, colorSecondary));
		GridBagConstraints gbc_eFN = new GridBagConstraints();
		gbc_eFN.weighty = 1.0;
		gbc_eFN.insets = new Insets(5, 5, 5, 5);
		gbc_eFN.fill = GridBagConstraints.HORIZONTAL;
		gbc_eFN.gridx = 1;
		gbc_eFN.gridy = 0;
		panel_2.add(eFN, gbc_eFN);
		eFN.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Second Number:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.weighty = 1.0;
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.insets = new Insets(5, 5, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 1;
		panel_2.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		eSN = new JTextField();
		eSN.setForeground(colorHighlight);
		eSN.setOpaque(false);
		eSN.setBorder(new MatteBorder(0, 0, 1, 0, colorSecondary));
		GridBagConstraints gbc_eSN = new GridBagConstraints();
		gbc_eSN.insets = new Insets(5, 5, 5, 5);
		gbc_eSN.weighty = 1.0;
		gbc_eSN.fill = GridBagConstraints.HORIZONTAL;
		gbc_eSN.gridx = 1;
		gbc_eSN.gridy = 1;
		panel_2.add(eSN, gbc_eSN);
		eSN.setColumns(10);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(colorPrimary);
		panel_3.setBorder(new TitledBorder(new LineBorder(new Color(255, 255, 255)), "IEEE 754 Representation", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(255, 255, 255)));
		((TitledBorder)panel_3.getBorder()).setTitleFont(new Font("Tahoma", Font.PLAIN, 11));
		GridBagConstraints gbc_panel_3 = new GridBagConstraints();
		gbc_panel_3.ipady = 10;
		gbc_panel_3.ipadx = 10;
		gbc_panel_3.weighty = 1.0;
		gbc_panel_3.insets = new Insets(10, 10, 10, 10);
		gbc_panel_3.fill = GridBagConstraints.BOTH;
		gbc_panel_3.gridx = 0;
		gbc_panel_3.gridy = 1;
		panel_1.add(panel_3, gbc_panel_3);
		GridBagLayout gbl_panel_3 = new GridBagLayout();
		gbl_panel_3.columnWidths = new int[]{0, 0, 0, 0, 0};
		gbl_panel_3.rowHeights = new int[]{0, 0, 0, 0};
		gbl_panel_3.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_panel_3.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_3.setLayout(gbl_panel_3);
		
		JLabel lblNewLabel_3 = new JLabel("Sign Bit");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel_3.setForeground(new Color(255, 255, 255));
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.weighty = 1.0;
		gbc_lblNewLabel_3.insets = new Insets(5, 5, 5, 5);
		gbc_lblNewLabel_3.gridx = 1;
		gbc_lblNewLabel_3.gridy = 0;
		panel_3.add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Exponent");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel_4.setForeground(new Color(255, 255, 255));
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.weighty = 1.0;
		gbc_lblNewLabel_4.insets = new Insets(5, 5, 5, 5);
		gbc_lblNewLabel_4.gridx = 2;
		gbc_lblNewLabel_4.gridy = 0;
		panel_3.add(lblNewLabel_4, gbc_lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Mantissa");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel_5.setForeground(new Color(255, 255, 255));
		GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
		gbc_lblNewLabel_5.weighty = 1.0;
		gbc_lblNewLabel_5.insets = new Insets(5, 5, 5, 5);
		gbc_lblNewLabel_5.gridx = 3;
		gbc_lblNewLabel_5.gridy = 0;
		panel_3.add(lblNewLabel_5, gbc_lblNewLabel_5);
		
		JLabel lblNewLabel_2 = new JLabel("First Number");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.weighty = 1.0;
		gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2.insets = new Insets(5, 5, 5, 5);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 1;
		panel_3.add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		eFNSB = new JTextField();
		eFNSB.setForeground(colorHighlight);
		eFNSB.setOpaque(false);
		eFNSB.setBorder(new MatteBorder(1, 1, 1, 1, colorSecondary));
		GridBagConstraints gbc_eFNSB = new GridBagConstraints();
		gbc_eFNSB.fill = GridBagConstraints.HORIZONTAL;
		gbc_eFNSB.weighty = 1.0;
		gbc_eFNSB.insets = new Insets(5, 5, 5, 5);
		gbc_eFNSB.gridx = 1;
		gbc_eFNSB.gridy = 1;
		panel_3.add(eFNSB, gbc_eFNSB);
		eFNSB.setColumns(1);
		
		eFNE = new JTextField();
		eFNE.setForeground(colorHighlight);
		eFNE.setOpaque(false);
		eFNE.setBorder(new MatteBorder(1, 1, 1, 1, colorSecondary));
		GridBagConstraints gbc_eFNE = new GridBagConstraints();
		gbc_eFNE.weighty = 1.0;
		gbc_eFNE.insets = new Insets(5, 5, 5, 5);
		gbc_eFNE.fill = GridBagConstraints.HORIZONTAL;
		gbc_eFNE.gridx = 2;
		gbc_eFNE.gridy = 1;
		panel_3.add(eFNE, gbc_eFNE);
		eFNE.setColumns(8);
		
		eFNM = new JTextField();
		eFNM.setForeground(colorHighlight);
		eFNM.setOpaque(false);
		eFNM.setBorder(new MatteBorder(1, 1, 1, 1, colorSecondary));
		GridBagConstraints gbc_eFNM = new GridBagConstraints();
		gbc_eFNM.weighty = 1.0;
		gbc_eFNM.insets = new Insets(5, 5, 5, 5);
		gbc_eFNM.fill = GridBagConstraints.HORIZONTAL;
		gbc_eFNM.gridx = 3;
		gbc_eFNM.gridy = 1;
		panel_3.add(eFNM, gbc_eFNM);
		eFNM.setColumns(23);
		
		JLabel lblNewLabel_6 = new JLabel("Second Number");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel_6.setForeground(new Color(255, 255, 255));
		GridBagConstraints gbc_lblNewLabel_6 = new GridBagConstraints();
		gbc_lblNewLabel_6.weighty = 1.0;
		gbc_lblNewLabel_6.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_6.insets = new Insets(5, 5, 5, 5);
		gbc_lblNewLabel_6.gridx = 0;
		gbc_lblNewLabel_6.gridy = 2;
		panel_3.add(lblNewLabel_6, gbc_lblNewLabel_6);
		
		eSNSB = new JTextField();
		eSNSB.setForeground(colorHighlight);
		eSNSB.setOpaque(false);
		eSNSB.setBorder(new MatteBorder(1, 1, 1, 1, colorSecondary));
		GridBagConstraints gbc_eSNSB = new GridBagConstraints();
		gbc_eSNSB.fill = GridBagConstraints.HORIZONTAL;
		gbc_eSNSB.weighty = 1.0;
		gbc_eSNSB.insets = new Insets(5, 5, 5, 5);
		gbc_eSNSB.gridx = 1;
		gbc_eSNSB.gridy = 2;
		panel_3.add(eSNSB, gbc_eSNSB);
		eSNSB.setColumns(1);
		
		eSNE = new JTextField();
		eSNE.setForeground(colorHighlight);
		eSNE.setOpaque(false);
		eSNE.setBorder(new MatteBorder(1, 1, 1, 1, colorSecondary));
		GridBagConstraints gbc_eSNE = new GridBagConstraints();
		gbc_eSNE.weighty = 1.0;
		gbc_eSNE.insets = new Insets(5, 5, 5, 5);
		gbc_eSNE.fill = GridBagConstraints.HORIZONTAL;
		gbc_eSNE.gridx = 2;
		gbc_eSNE.gridy = 2;
		panel_3.add(eSNE, gbc_eSNE);
		eSNE.setColumns(8);
		
		eSNM = new JTextField();
		eSNM.setForeground(colorHighlight);
		eSNM.setOpaque(false);
		eSNM.setBorder(new MatteBorder(1, 1, 1, 1, colorSecondary));
		GridBagConstraints gbc_eSNM = new GridBagConstraints();
		gbc_eSNM.insets = new Insets(5, 5, 5, 5);
		gbc_eSNM.weighty = 1.0;
		gbc_eSNM.fill = GridBagConstraints.HORIZONTAL;
		gbc_eSNM.gridx = 3;
		gbc_eSNM.gridy = 2;
		panel_3.add(eSNM, gbc_eSNM);
		eSNM.setColumns(23);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(colorPrimary);
		panel_4.setBorder(new TitledBorder(new LineBorder(new Color(255, 255, 255)), "Result", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(255, 255, 255)));
		((TitledBorder)panel_4.getBorder()).setTitleFont(new Font("Tahoma", Font.PLAIN, 11));
		GridBagConstraints gbc_panel_4 = new GridBagConstraints();
		gbc_panel_4.insets = new Insets(10, 10, 10, 10);
		gbc_panel_4.ipadx = 10;
		gbc_panel_4.ipady = 10;
		gbc_panel_4.weighty = 1.0;
		gbc_panel_4.fill = GridBagConstraints.BOTH;
		gbc_panel_4.gridx = 0;
		gbc_panel_4.gridy = 2;
		panel_1.add(panel_4, gbc_panel_4);
		GridBagLayout gbl_panel_4 = new GridBagLayout();
		gbl_panel_4.columnWidths = new int[]{0, 0, 0, 0};
		gbl_panel_4.rowHeights = new int[]{0, 0, 0};
		gbl_panel_4.columnWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_panel_4.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		panel_4.setLayout(gbl_panel_4);
		
		JLabel lblNewLabel_8 = new JLabel("Sign Bit");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel_8.setForeground(new Color(255, 255, 255));
		GridBagConstraints gbc_lblNewLabel_8 = new GridBagConstraints();
		gbc_lblNewLabel_8.weighty = 1.0;
		gbc_lblNewLabel_8.insets = new Insets(5, 5, 5, 5);
		gbc_lblNewLabel_8.gridx = 0;
		gbc_lblNewLabel_8.gridy = 0;
		panel_4.add(lblNewLabel_8, gbc_lblNewLabel_8);
		
		JLabel lblNewLabel_7 = new JLabel("Exponent");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel_7.setForeground(new Color(255, 255, 255));
		GridBagConstraints gbc_lblNewLabel_7 = new GridBagConstraints();
		gbc_lblNewLabel_7.weighty = 1.0;
		gbc_lblNewLabel_7.insets = new Insets(5, 5, 5, 5);
		gbc_lblNewLabel_7.gridx = 1;
		gbc_lblNewLabel_7.gridy = 0;
		panel_4.add(lblNewLabel_7, gbc_lblNewLabel_7);
		
		JLabel lblNewLabel_9 = new JLabel("Mantissa");
		lblNewLabel_9.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel_9.setForeground(new Color(255, 255, 255));
		GridBagConstraints gbc_lblNewLabel_9 = new GridBagConstraints();
		gbc_lblNewLabel_9.weighty = 1.0;
		gbc_lblNewLabel_9.insets = new Insets(5, 5, 5, 5);
		gbc_lblNewLabel_9.gridx = 2;
		gbc_lblNewLabel_9.gridy = 0;
		panel_4.add(lblNewLabel_9, gbc_lblNewLabel_9);
		
		eRSB = new JTextField();
		eRSB.setForeground(colorHighlight);
		eRSB.setOpaque(false);
		eRSB.setBorder(new MatteBorder(1, 1, 1, 1, colorSecondary));
		GridBagConstraints gbc_eRSB = new GridBagConstraints();
		gbc_eRSB.weighty = 1.0;
		gbc_eRSB.insets = new Insets(5, 5, 5, 5);
		gbc_eRSB.fill = GridBagConstraints.HORIZONTAL;
		gbc_eRSB.gridx = 0;
		gbc_eRSB.gridy = 1;
		panel_4.add(eRSB, gbc_eRSB);
		eRSB.setColumns(1);
		
		eRE = new JTextField();
		eRE.setForeground(colorHighlight);
		eRE.setOpaque(false);
		eRE.setBorder(new MatteBorder(1, 1, 1, 1, colorSecondary));
		GridBagConstraints gbc_eRE = new GridBagConstraints();
		gbc_eRE.weighty = 1.0;
		gbc_eRE.insets = new Insets(5, 5, 5, 5);
		gbc_eRE.fill = GridBagConstraints.HORIZONTAL;
		gbc_eRE.gridx = 1;
		gbc_eRE.gridy = 1;
		panel_4.add(eRE, gbc_eRE);
		eRE.setColumns(8);
		
		eRM = new JTextField();
		eRM.setForeground(colorHighlight);
		eRM.setOpaque(false);
		eRM.setBorder(new MatteBorder(1, 1, 1, 1, colorSecondary));
		GridBagConstraints gbc_eRM = new GridBagConstraints();
		gbc_eRM.insets = new Insets(5, 5, 5, 5);
		gbc_eRM.weighty = 1.0;
		gbc_eRM.fill = GridBagConstraints.HORIZONTAL;
		gbc_eRM.gridx = 2;
		gbc_eRM.gridy = 1;
		panel_4.add(eRM, gbc_eRM);
		eRM.setColumns(23);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(colorHighlight);
		panel_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				xMouse=e.getX();
				yMouse=e.getY();
			}
		});
		panel_5.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				int x=e.getXOnScreen();
				int y=e.getYOnScreen();
				setLocation(x-xMouse,y-yMouse);
			}
		});
		contentPane.add(panel_5, BorderLayout.NORTH);
		GridBagLayout gbl_panel_5 = new GridBagLayout();
		gbl_panel_5.columnWidths = new int[]{0, 0, 0};
		gbl_panel_5.rowHeights = new int[]{0, 0};
		gbl_panel_5.columnWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
		gbl_panel_5.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel_5.setLayout(gbl_panel_5);
		
		JLabel lblNewLabel_10 = new JLabel("IEEE 754 Floating Point Addition Simulator");
		lblNewLabel_10.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_10.setForeground(new Color(0, 0, 0));
		GridBagConstraints gbc_lblNewLabel_10 = new GridBagConstraints();
		gbc_lblNewLabel_10.ipady = 20;
		gbc_lblNewLabel_10.ipadx = 10;
		gbc_lblNewLabel_10.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblNewLabel_10.insets = new Insets(0, 5, 0, 5);
		gbc_lblNewLabel_10.gridx = 0;
		gbc_lblNewLabel_10.gridy = 0;
		panel_5.add(lblNewLabel_10, gbc_lblNewLabel_10);
		
		JLabel btnClose = new JLabel("  x  ");		
		btnClose.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		JFrame thisFrame=this;
		btnClose.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispatchEvent(new WindowEvent(thisFrame, WindowEvent.WINDOW_CLOSING));
			}
		});
		btnClose.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnClose.setForeground(new Color(0, 0, 0));
		GridBagConstraints gbc_btnClose = new GridBagConstraints();
		gbc_btnClose.gridx = 1;
		gbc_btnClose.gridy = 0;
		panel_5.add(btnClose, gbc_btnClose);
		pack();
	}
	
	void cmdAdd()
    {
        if(eFN.getText().isEmpty() || eSN.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(this, "Enter Numbers");
            return;
        }
        try
        {
            FN=Double.parseDouble(eFN.getText());
            SN=Double.parseDouble(eSN.getText());
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(this, "Enter Valid Numbers");
            return;
        }
        
        IEEEFloatingPointNumber X=IEEEFloatingPointNumber.getIEEERepresentation(FN);
        IEEEFloatingPointNumber Y=IEEEFloatingPointNumber.getIEEERepresentation(SN);
        IEEEFloatingPointNumber res=IEEEFloatingPointNumber.add(X,Y);
        eFNSB.setText(Integer.toString(X.signBit));
        eFNE.setText(Binary.toBinaryString(X.biasedExponent));
        eFNM.setText(Binary.toBinaryString(X.mantissa));
        eSNSB.setText(Integer.toString(Y.signBit));
        eSNE.setText(Binary.toBinaryString(Y.biasedExponent));
        eSNM.setText(Binary.toBinaryString(Y.mantissa));

        eRSB.setText(Integer.toString(res.signBit));
        eRE.setText(Binary.toBinaryString(res.biasedExponent));
        eRM.setText(Binary.toBinaryString(res.mantissa));

        ProcedureDialog pd=new ProcedureDialog(this,FN,SN);
    }

    void cmdReset()
    {
        FN=0;
        SN=0;
        eFN.setText("");
        eSN.setText("");

        eFNSB.setText("");
        eFNE.setText("");
        eFNM.setText("");

        eSNSB.setText("");
        eSNE.setText("");
        eSNM.setText("");

        eRSB.setText("");
        eRE.setText("");
        eRM.setText("");
    }

}
