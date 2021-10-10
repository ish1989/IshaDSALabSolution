package dataStructurelabSolution;

import java.util.ArrayList;

public class longestPathRootToLeaf
{
	class Node
	{
		Node left;
		Node right;
		int data;
	};

	
		public Node insertNode( int data)
		{

			Node newNode=new Node();
			newNode.left=null;
			newNode.right=null;
			newNode.data=data;

			return newNode;

		}
	

		public static ArrayList<Integer> longestPath(Node root) {

			if(root ==null)
			{
				ArrayList<Integer> result= new ArrayList<>();
				return result;
			}
			ArrayList<Integer> rightNode= longestPath(root.right) ;
			ArrayList<Integer> leftNode= longestPath(root.left) ;

			if(rightNode.size()<leftNode.size())
				leftNode.add(root.data);
			else
			{
				rightNode.add(root.data);
			}
			return ((leftNode.size()>rightNode.size()) ? leftNode:rightNode);
		}



	


	public static void main(String arg[])
	{
		longestPathRootToLeaf bt=new longestPathRootToLeaf();
		Node root=bt.insertNode(100);
		root.left=bt.insertNode(20);
		root.right=bt.insertNode(130);
		root.left.left=bt.insertNode(10);
		root.left.right=bt.insertNode(50);
		root.right.left=bt.insertNode(110);
		root.right.right=bt.insertNode(140);
		root.left.left.left=bt.insertNode(5);

		ArrayList<Integer> result = longestPath(root);
		int size = result.size();
		System.out.print("The longest Path is\n ");
		System.out.print(result.get(size - 1));
		

		for (int i = size - 2; i >= 0; i--) 
		{
			System.out.print(" ----> " + result.get(i));
		}
	}




}

