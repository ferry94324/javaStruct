package liubo.tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;

public class HuffmanTree {
	public static <T>HuffNode<T> creatTree(List<HuffNode<T>> nodes){
		while(nodes.size()>1){
			Collections.sort(nodes);
			HuffNode<T> left = nodes.get(nodes.size()-1);
			HuffNode<T> right = nodes.get(nodes.size()-2);
			HuffNode<T> parent = new HuffNode<T>(null, left.getWeight()+right.getWeight());
			parent.setRight(right);
			parent.setLeft(left);
			nodes.remove(right);
			nodes.remove(left);
			nodes.add(parent);
		}
		return nodes.get(0);
	}
	public static <T>List<HuffNode<T>> breadth(HuffNode<T> root){
		List<HuffNode<T>> list = new ArrayList<HuffNode<T>>();
		Queue<HuffNode<T>> queue = new ArrayDeque<HuffNode<T>>();
		
		if(root!=null){
			queue.offer(root);
		}
		while(!queue.isEmpty()){
			list.add(queue.peek());
			HuffNode<T> node = queue.poll();
			
			if(node.getLeft()!=null){
				queue.offer(node.getLeft());
			}
			if(node.getRight()!=null){
				queue.offer(node.getRight());
			}
		}
		return list;
	}
	
	public static void main(String[] args) {
		List<HuffNode<String>>list = new ArrayList<HuffNode<String>>();
		list.add(new HuffNode<String>("a",7));  
        list.add(new HuffNode<String>("b",5));  
        list.add(new HuffNode<String>("c",4));  
        list.add(new HuffNode<String>("d",2));  
        
        HuffNode<String> root = HuffmanTree.creatTree(list);  
        System.out.println(HuffmanTree.breadth(root)); 
         
	}
}
