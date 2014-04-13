package graphs;
import graphs.ListGraph.Node;

public class Edge {
	String name;
	Integer weight;
	Node destination;
	Edge(Node destination, String name, int weight){
		this.destination = destination;
		this.name = name;
		this.weight = weight;
	}
	public Node getDestination(Edge e){
		return e.destination;
	}
	public Integer getWeight(){
		return weight;
	}
	public void setWeight(int newWeight){
		if(newWeight >= 0){
			weight = newWeight;
		}
		else{
			throw new IllegalArgumentException (); 
		}
	}
	public String getName(Edge e){
		return name;
	}
	public String toString(){
		String str = name +" " + weight+ " " + destination + " ";
		return str;
	}
}
