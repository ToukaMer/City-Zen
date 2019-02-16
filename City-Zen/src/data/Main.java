package data;

public class Main {

	public static void main(String[] args) {
		
		District[][] tab= null;
		
		int k=0;
		
		int width = 3;
		int height = 3;
		
		Node nodetab[]= new Node[width*height];
		
	/*	tab[0][0]="A";
		tab[0][1]="B";
		tab[0][2]="C";
		tab[1][0]="D";
		tab[1][1]="E";
		tab[1][2]="F";
		tab[2][0]="G";
		tab[2][1]="H";
		tab[2][2]="I";*/
		
		DistrictManager dm = new DistrictManager();
		tab=dm.initDistrictMap(width, height);
		
		for(int i=0; i<height; i++)
			for(int j=0; j<width; j++) {
				nodetab[k]= new Node(tab[i][j]);
				k++;
						
			}
				
		// TODO Auto-generated method stub
		/*Node nodeA = new Node("A");
		Node nodeB = new Node("B");
		Node nodeC = new Node("C");
		Node nodeD = new Node("D"); 
		Node nodeE = new Node("E");
		Node nodeF = new Node("F");
		 
		nodeA.addDestination(nodeB, 10);
		nodeA.addDestination(nodeC, 15);
		 
		nodeB.addDestination(nodeD, 12);
		nodeB.addDestination(nodeF, 15);
		 
		nodeC.addDestination(nodeE, 10);
		 
		nodeD.addDestination(nodeE, 2);
		nodeD.addDestination(nodeF, 1);
		 
		nodeF.addDestination(nodeE, 5);*/
		 
		Graph graph = new Graph();
		for(int p =0;p<nodetab.length;p++)
			System.out.println("-"+nodetab[p]);
		
		for(int i=0; i<height*width; i++) {
			if((i-1) > 0)
			nodetab[i].addDestination(nodetab[i-1], nodetab[i-1].getdistrict().getUsingTime());
			if((((i+1)%width)) > 0)
			nodetab[i].addDestination(nodetab[i+1], nodetab[i+1].getdistrict().getUsingTime());
			if((i-width) > 0)
			nodetab[i].addDestination(nodetab[i-width], nodetab[i-width].getdistrict().getUsingTime());
			if(i<(width*(height-1)))
			nodetab[i].addDestination(nodetab[i+width], nodetab[i+width].getdistrict().getUsingTime());
		}
		
		for(int u=0; u<nodetab.length; u++)
			graph.addNode(nodetab[u]);
		 
		/*graph.addNode(nodeA);
		graph.addNode(nodeB);
		graph.addNode(nodeC);
		graph.addNode(nodeD);
		graph.addNode(nodeE);
		graph.addNode(nodeF);*/
		 
		graph = Dijkstra.calculateShortestPathFromSource(graph, nodetab[0]);
		
		dm.printDistrictMap(tab, width, height);
		
		System.out.println(nodetab[8].getShortestPath());
		System.out.println(nodetab[8].getDistance());
		
	}

}
