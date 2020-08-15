package mvc;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JColorChooser;

import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.border.EtchedBorder;


import javax.swing.JMenuBar;
import javax.swing.JScrollPane;
import javax.swing.JToggleButton;
import javax.swing.border.TitledBorder;
import javax.swing.ImageIcon;

public class Frame extends JFrame {

	
	private static final long serialVersionUID = 1L;
	private DefaultListModel<String> dlm = new DefaultListModel<String>(); 
	private Controller controller;
	private View view= new View();
	private Color chosenOutColor = Color.BLACK;
	private Color chosenInColor = Color.WHITE;
	private JButton btnEdit,btnDelete,btnColorIn,btnColorOut;
	private JToggleButton btnSelect,btnPoint,btnLine,btnCircle,btnSquare,btnRectangle,btnHexagon;
	
	public Frame() {
		JPanel jpMainPanel = new JPanel();
		jpMainPanel.setBackground(new Color(255, 255, 153));
		getContentPane().add(jpMainPanel, BorderLayout.CENTER);
		jpMainPanel.setLayout(new BorderLayout(5, 0));
		
		JPanel jpToolsPanel = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) jpToolsPanel.getLayout();
		flowLayout_1.setVgap(2);
		flowLayout_1.setAlignment(FlowLayout.LEFT);
		jpToolsPanel.setBackground(new Color(255, 255, 153));
		jpMainPanel.add(jpToolsPanel, BorderLayout.NORTH);
		
		JPanel jpActionsPanel = new JPanel();
		jpActionsPanel.setBorder(new TitledBorder(null, "Actions", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		FlowLayout flowLayout_5 = (FlowLayout) jpActionsPanel.getLayout();
		flowLayout_5.setHgap(2);
		flowLayout_5.setVgap(12);
		jpActionsPanel.setBackground(new Color(255, 255, 153));
		jpToolsPanel.add(jpActionsPanel);
		
		btnSelect = new JToggleButton("");
		btnSelect.setBackground(new Color(255, 255, 204));
		btnSelect.setToolTipText("Select");
		btnSelect.setIcon(new ImageIcon(Frame.class.getResource("/images/cursor.png")));
		jpActionsPanel.add(btnSelect);
		
		btnEdit = new JButton("");
		btnEdit.setBackground(new Color(255, 255, 204));
		btnEdit.setForeground(new Color(0, 0, 0));
		btnEdit.setToolTipText("Edit");
		btnEdit.setIcon(new ImageIcon(Frame.class.getResource("/images/pencil.png")));
		jpActionsPanel.add(btnEdit);
		
		 btnDelete = new JButton("");
		btnDelete.setBackground(new Color(255, 255, 204));
		btnDelete.setToolTipText("Delete");
		btnDelete.setIcon(new ImageIcon(Frame.class.getResource("/images/delete.png")));
		jpActionsPanel.add(btnDelete);
		
		JPanel jpShapesPanel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) jpShapesPanel.getLayout();
		flowLayout.setHgap(2);
		flowLayout.setVgap(12);
		flowLayout.setAlignment(FlowLayout.LEFT);
		jpToolsPanel.add(jpShapesPanel);
		jpShapesPanel.setBackground(new Color(255, 255, 153));
		jpShapesPanel.setBorder(new TitledBorder(null, "Shapes", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		btnPoint = new JToggleButton("");
		btnPoint.setBackground(new Color(255, 255, 204));
		btnPoint.setToolTipText("point");
		btnPoint.setIcon(new ImageIcon(Frame.class.getResource("/images/cross-shaped-target.png")));
		jpShapesPanel.add(btnPoint);
		
		btnLine = new JToggleButton("");
		btnLine.setBackground(new Color(255, 255, 204));
		btnLine.setToolTipText("line");
		btnLine.setIcon(new ImageIcon(Frame.class.getResource("/images/line.png")));
		jpShapesPanel.add(btnLine);
		
		 btnCircle = new JToggleButton("");
		btnCircle.setBackground(new Color(255, 255, 204));
		btnCircle.setToolTipText("circle");
		btnCircle.setIcon(new ImageIcon(Frame.class.getResource("/images/clean.png")));
		jpShapesPanel.add(btnCircle);
		
		btnSquare = new JToggleButton("");
		btnSquare.setBackground(new Color(255, 255, 204));
		btnSquare.setToolTipText("square");
		btnSquare.setIcon(new ImageIcon(Frame.class.getResource("/images/check-box.png")));
		jpShapesPanel.add(btnSquare);
		
		btnRectangle = new JToggleButton("");
		btnRectangle.setBackground(new Color(255, 255, 204));
		btnRectangle.setToolTipText("rectangle");
		btnRectangle.setIcon(new ImageIcon(Frame.class.getResource("/images/rectangle.png")));
		jpShapesPanel.add(btnRectangle);
		
		btnHexagon = new JToggleButton("");
		btnHexagon.setBackground(new Color(255, 255, 204));
		btnHexagon.setToolTipText("hexagon");
		btnHexagon.setIcon(new ImageIcon(Frame.class.getResource("/images/hexagon.png")));
		jpShapesPanel.add(btnHexagon);
		
		ButtonGroup btnGroup = new ButtonGroup();
		btnGroup.add(btnSelect);
		btnGroup.add(btnPoint);
		btnGroup.add(btnLine);
		btnGroup.add(btnSquare);
		btnGroup.add(btnRectangle);
		btnGroup.add(btnCircle);
		btnGroup.add(btnHexagon);
		
		JPanel jpColorPanel = new JPanel();
		jpToolsPanel.add(jpColorPanel);
		jpColorPanel.setBorder(new TitledBorder(null, "Color", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		jpColorPanel.setBackground(new Color(255, 255, 153));
		
		 btnColorIn = new JButton("");
		btnColorIn.setToolTipText("inside");
		btnColorIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Color temp = JColorChooser.showDialog(null, "choose color", chosenInColor);
				if (temp != null) {
					chosenInColor = temp;
btnColorIn.setBackground(chosenInColor);
				}
			}
		});
		btnColorIn.setBackground(new Color(255, 255, 255));
		
		btnColorOut = new JButton("");
		btnColorOut.setToolTipText("outside");
        btnColorOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Color temp = JColorChooser.showDialog(null, "choose color", chosenOutColor);
				if (temp != null) {
					chosenOutColor = temp;
					btnColorOut.setBackground(chosenOutColor);
				}
			}
		});
        btnColorOut.setBackground(new Color(0, 0, 0));
		
				
				GroupLayout gl_jpColorPanel = new GroupLayout(jpColorPanel);
				gl_jpColorPanel.setHorizontalGroup(
					gl_jpColorPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_jpColorPanel.createSequentialGroup()
							.addGap(5)
							.addComponent(btnColorIn)
							.addGap(5)
							.addComponent(btnColorOut)
							.addContainerGap())
				);
				gl_jpColorPanel.setVerticalGroup(
					gl_jpColorPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_jpColorPanel.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_jpColorPanel.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(btnColorOut, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnColorIn, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE))
							.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				);
				jpColorPanel.setLayout(gl_jpColorPanel);

		JPanel jpPositionPanel = new JPanel();
		FlowLayout flowLayout_2 = (FlowLayout) jpPositionPanel.getLayout();
		flowLayout_2.setHgap(2);
		flowLayout_2.setVgap(12);
		jpToolsPanel.add(jpPositionPanel);
		jpPositionPanel.setBorder(new TitledBorder(null, "Switch Position", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		jpPositionPanel.setBackground(new Color(255, 255, 153));
		
		
		JButton btnToFront = new JButton("");
		btnToFront.setBackground(new Color(255, 255, 204));
		btnToFront.setToolTipText("bring to front");
		btnToFront.setIcon(new ImageIcon(Frame.class.getResource("/images/Bring to front (2).png")));
		jpPositionPanel.add(btnToFront);
		
		JButton btnToBack = new JButton("");
		btnToBack.setBackground(new Color(255, 255, 204));
		btnToBack.setToolTipText("bing to back");
		btnToBack.setIcon(new ImageIcon(Frame.class.getResource("/images/Bring to back (1).png")));
		jpPositionPanel.add(btnToBack);
		
		JButton btnBringBack = new JButton("");
		btnBringBack.setBackground(new Color(255, 255, 204));
		btnBringBack.setToolTipText("bring back");
		btnBringBack.setIcon(new ImageIcon(Frame.class.getResource("/images/bring back (1).png")));
		jpPositionPanel.add(btnBringBack);
		
		JButton btnBringFront = new JButton("");
		btnBringFront.setBackground(new Color(255, 255, 204));
		btnBringFront.setToolTipText("bring front");
		btnBringFront.setIcon(new ImageIcon(Frame.class.getResource("/images/Bring front (1).png")));
		jpPositionPanel.add(btnBringFront);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(new Color(245,129,115));
		setJMenuBar(menuBar);
		
		JButton btnSave = new JButton("Save");
		btnSave.setBackground(new Color(255, 204, 153));
		btnSave.setIcon(new ImageIcon(Frame.class.getResource("/images/diskette.png")));
		menuBar.add(btnSave);
		
		JButton btnOpen = new JButton("Open");
		btnOpen.setBackground(new Color(255, 204, 153));
		btnOpen.setIcon(new ImageIcon(Frame.class.getResource("/images/folder.png")));
		menuBar.add(btnOpen);
		
		JButton btnUndo = new JButton("Undo");
		btnUndo.setBackground(new Color(255, 204, 153));
		btnUndo.setIcon(new ImageIcon(Frame.class.getResource("/images/left-turn-arrow (1).png")));
		menuBar.add(btnUndo);
		
		JButton btnRedo = new JButton("Redo");
		btnRedo.setBackground(new Color(255, 204, 153));
		btnRedo.setIcon(new ImageIcon(Frame.class.getResource("/images/send.png")));
		menuBar.add(btnRedo);

		JPanel panel = new JPanel();
		FlowLayout flowLayout_4 = (FlowLayout) panel.getLayout();
		flowLayout_4.setVgap(0);
		panel.setBackground(new Color(255, 255, 153));
		jpMainPanel.add(panel, BorderLayout.EAST);
		
		JScrollPane scrollPane = new JScrollPane();
		panel.add(scrollPane);
		JList<String> logList = new JList<String>();
		logList.setVisibleRowCount(27);
		logList.setFixedCellWidth(230);
		logList.setModel(dlm);
		scrollPane.setViewportView(logList);
		FlowLayout flowLayout_3 = (FlowLayout) view.getLayout();

		jpMainPanel.add(view, BorderLayout.CENTER);
		view.setBackground(Color.WHITE);

	}


		public View getView() {
		return view;
	}
	public void setController(Controller controller) {
		this.controller = controller;
	}
}