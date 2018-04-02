package liubo.tree;

public class HuffNode<T> implements Comparable<HuffNode<T>>{
	private T data;
	private double weight;
	private HuffNode<T> left;
	private HuffNode<T> right;
	public HuffNode(T data, double weight) {
		super();
		this.data = data;
		this.weight = weight;
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	public HuffNode<T> getLeft() {
		return left;
	}
	public void setLeft(HuffNode<T> left) {
		this.left = left;
	}
	public HuffNode<T> getRight() {
		return right;
	}
	public void setRight(HuffNode<T> right) {
		this.right = right;
	}
	@Override
	public String toString() {
		return "HuffNode [data=" + data + ", weight=" + weight + "]";
	}
	
	public int compareTo(HuffNode<T> other){
		if(other.getWeight()>this.getWeight()){
			return 1;
		}
		if(other.getWeight()<this.getWeight()){
			return -1;
		}
		return 0;
	}
}
