package graphs;
import java.util.*;

public class ListGraph {
	HashMap<String, Node> graph = new HashMap<String, Node> ();
	public static class Node{
		String name;
		Boolean visited = false;
		HashMap<String, Edge> adjacencyList = new HashMap<String, Edge> ();
		
		public Node(String name){
			this.name=name; 
		}
		public String toString(){
			String str = name + " ";
			return str;
		}
		
	}
	public void add(Node n){
		if(graph.containsKey(n.name)== false){
			graph.put(n.name, n);
		}
	}
	public void connect(Node first, Node last, String edgeName, int weight){
		if (weight > 0){
			Edge edge1 = new Edge(first,edgeName, weight);
			Edge edge2 = new Edge(last,edgeName, weight);
			if(graph.get(first.name) != null && graph.get(last.name) != null){
				first.adjacencyList.put(last.name, edge2);
				last.adjacencyList.put(first.name, edge1);
			}
			else{
				throw new NoSuchElementException ();
			}
		}
		else{
			throw new IllegalArgumentException ();
		}

	}
	public void setConnectionWeight(Node first, Node last, int weight){
			Edge edge = getEdgeBetween(first, last);
			edge.setWeight(weight);
		}
	public ArrayList<Node> getNodes(){
		ArrayList<Node> nodeList= new ArrayList <Node>(graph.values());
		return nodeList;
	}
	public ArrayList<Edge> getEdgesFrom(Node first){
		if(graph.get(first.name)!=null){
			ArrayList<Edge> edgeList = new ArrayList<Edge>(first.adjacencyList.values());
			return edgeList;
		}
		else{
			throw new NoSuchElementException();	
		}
	}
	public Edge getEdgeBetween(Node first, Node last){
		if(graph.containsKey(first.name)!=false && graph.containsKey(last.name)!=false){
			if(first.adjacencyList.containsKey(last.name)){
				Edge edgeBetween = first.adjacencyList.get(last.name);
				return edgeBetween;
			}
			else{
				throw new NoSuchElementException();
			}
		}
		else{
			throw new NoSuchElementException();
		}
	}
	public Boolean pathExist(Node first, Node last){
		if(graph.containsKey(first.name)!=false && graph.containsKey(last.name)!=false){
			ArrayList<Node> nodeList = getNodes();
			for(Node n : nodeList){
				n.visited = false;
			}
			deepFirstSearch(first, last);
			return last.visited;
		}
		else{
			return false;
		}
	}
	private void deepFirstSearch(Node first, Node last){ //Base from Data Structures and Algorithm Analysis in Java by Mark Allen Weiss
		ArrayList<Edge> edgeList = new ArrayList<Edge> (first.adjacencyList.values());
		first.visited = true;
		for(int index = 0; index < edgeList.size(); index++){
			Edge edge = edgeList.get(index);
			Node destinationNode = edge.getDestination(edge);
			if(!destinationNode.visited){	
					deepFirstSearch(destinationNode, last);
			}
			else{
			}
		}
	}
	public String toString(){
		String str = null;
		String edgeStr = null; 
		ArrayList<Node> nodeList = getNodes();
		for(int index = 0; index <nodeList.size(); index++){
			Node n = nodeList.get(index);
			ArrayList<Edge> edgeList = getEdgesFrom(n);
			for(int edgeIndex = 0; edgeIndex < edgeList.size(); edgeIndex++){
				Edge e = edgeList.get(edgeIndex);
				if(edgeIndex == 0)
					edgeStr = e.toString();
				else
					edgeStr += e.toString();
			}
			if(index == 0)
				str = n.toString() + edgeStr + "\n";
			else
				str += n.toString() + edgeStr + "\n";
		}
		return str;
	}
	

}
