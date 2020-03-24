package com.others.traversal;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
//import static org.junit.Assert.*;
import java.util.Stack;

//Traversal
//[Breadth First Search(Traversal)]BFS-Queue 有很多种结果。转换成树后很容易理解，一层一层从左往右走，适合层次关系


public class Graph {
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Graph g = new Graph();
		g.testing();

	}

	//BFStesting for https://www.youtube.com/watch?v=bD8RT0ub--0
	public void testing() {
		//List graph = ArrayList<>();
		//graph.add(popup);
		HashMap<Character,char[]> graph = new HashMap<Character,char[]>();
		graph.put('A',"BC".toCharArray());
		graph.put('B',"ACD".toCharArray());
		graph.put('C',"ABDE".toCharArray());
		graph.put('D',"BCEF".toCharArray());
		graph.put('E',"CD".toCharArray());
		graph.put('F',"D".toCharArray());
		
		System.out.println("graph="+graph);
		String result = BFStesting(graph,'A');//the result should be ABCDEF
		System.out.println("BFStesting.result="+result);
		result = BFStesting(graph,'E');	//the result should be ECDABF
		System.out.println("BFStesting.result="+result);
		
		result = DFStesting(graph,'A');//the result should be ACEDFB
		System.out.println("DFStesting.result="+result);
		result = DFStesting(graph,'E');	//the result should be ECDABF
		System.out.println("DFStesting.result="+result);
	}
	
	public String BFStesting(HashMap<Character,char[]> graph, char topPoint) {
		Queue<Character> queue = new LinkedList<Character>();		
		queue.offer(topPoint);
		HashMap<Character,Character> visited = new HashMap<Character, Character>();	//already visited
		visited.put(topPoint, topPoint);
		String result = "";
		while (queue.size()>0) {
			char vertex = queue.poll();
			char[] visitors = graph.get(vertex);
			int i =0;
			while(visitors!=null && i < visitors.length) {
				char v = visitors[i++];
				if (!visited.containsKey(v)) {
					queue.offer(v);
					visited.put(v, v);
				}
			}
			result += vertex;
			//System.out.println("vertex="+vertex);
		}
		return result;
	}
	
	public String DFStesting(HashMap<Character,char[]> graph, char topPoint) {
		Stack<Character> stack = new Stack<Character>();		
		stack.push(topPoint);
		HashMap<Character,Character> visited = new HashMap<Character, Character>();	//already visited
		visited.put(topPoint, topPoint);
		String result = "";
		while (stack.size()>0) {
			char vertex = stack.pop();
			char[] visitors = graph.get(vertex);
			int i =0;
			while(visitors!=null && i < visitors.length) {
				char v = visitors[i++];
				if (!visited.containsKey(v)) {
					stack.push(v);
					visited.put(v, v);
				}
			}
			result += vertex;
			//System.out.println("vertex="+vertex);
		}
		return result;
	}
	
}
