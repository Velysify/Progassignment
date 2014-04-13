package main;
import graphs.ListGraph.*;
import graphs.ListGraph;
import java.io.*;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

@SuppressWarnings("serial")
public class PathFinder extends JFrame {
	PathFinder(){
		super("Vägfinnare");
			JMenuBar menuBar = new JMenuBar();
			JMenu menu = new JMenu("Arkiv");
			JMenuItem menuItem = new JMenuItem("Ny");
			menuItem.addActionListener(new NewImage());
			menu.add(menuItem);
			menuItem = new JMenuItem("Avsluta");
			menuItem.addActionListener(new Exit());
			menu.add(menuItem);
			menuBar.add(menu);
			menu = new JMenu("Operationer");
			menuItem = new JMenuItem("Hitta väg");
			menu.add(menuItem);
			menuItem = new JMenuItem("Visa förbindelse");
			menu.add(menuItem);
			menuItem = new JMenuItem("Ny plats");
			menu.add(menuItem);
			menuItem = new JMenuItem("Ny förbindelse");
			menu.add(menuItem);
			menuItem = new JMenuItem("Ändra förbindelse");
			menu.add(menuItem);
			menuBar.add(menu);
			add(menuBar, BorderLayout.NORTH);

			JPanel buttonBar = new JPanel();
			JButton button = new JButton("Hitta väg");
			buttonBar.add(button);
			button = new JButton("Visa förbindelse");
			buttonBar.add(button);
			button = new JButton("Ny plats");
			buttonBar.add(button);
			button = new JButton("Ny förbindelse");
			buttonBar.add(button);
			button = new JButton("Ändra förbindelse");
			buttonBar.add(button);
			add(buttonBar);
			
			setDefaultCloseOperation(EXIT_ON_CLOSE);
			setSize(1300,1000);
			setLocation(300,300);
			setVisible(true);
	}
	public class NewImage implements ActionListener{
		public void actionPerformed(ActionEvent e){
			JFileChooser fc = new JFileChooser(new File("."));
			int returnval = fc.showOpenDialog(PathFinder.this);
			if(returnval!= JFileChooser.APPROVE_OPTION)
				return;
			
			
		}
	}

	public class Exit implements ActionListener{
		public void actionPerformed(ActionEvent e){
			System.exit(0);
		}
	}
	


	public static void main (String [] args){
		ListGraph graph = new ListGraph();
		new PathFinder();
		/*Node node1 = new Node("stockholm"); Node node2 = new Node("malmo"); Node node3 = new Node("linkoping"); 	Node node4 = new Node("goteborg");
		Node node5 = new Node("karlskrona"); Node node6 = new Node("mora");	Node node7 = new Node("borlange");	Node node8 = new Node("kiruna");
		Node node9 = new Node("umea"); Node node10 = new Node("norrtalje");
		graph.add(node1); graph.add(node2); graph.add(node3); graph.add(node4);	graph.add(node5); graph.add(node6); graph.add(node7); graph.add(node8); graph.add(node9); graph.add(node10);
		graph.connect(node1, node2, "Flyg", 2);
		graph.connect(node3, node5, "Tunnelbana", 5);
		graph.connect(node4, node6, "Pendeltåg", 6);
		graph.connect(node5, node6, "Lunch", 11);
		graph.connect(node3, node9, "Tomatsoppa", 20);
		graph.connect(node1, node3, "Middag", 3);
		graph.setConnectionWeight(node4, node6, 4);
		System.out.println(graph);
		System.out.println(graph.getNodes());
		System.out.println(graph.getEdgesFrom(node3));
		System.out.println(graph.pathExist(node1, node10));*/
	}
	
}


