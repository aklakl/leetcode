http://fangda.me/2018/04/11/%E6%B7%B1%E5%BA%A6%E4%BC%98%E5%85%88%E6%90%9C%E7%B4%A2%EF%BC%88DFS%EF%BC%89%E5%92%8C%E5%B9%BF%E5%BA%A6%E4%BC%98%E5%85%88%E6%90%9C%E7%B4%A2%EF%BC%88BFS%EF%BC%89%E8%AF%A6%E8%A7%A3/

the graph traversal feature is these:
广度优先搜索算法（Breadth First Search）BFS-Queue[The characteristics of queue are FistIn FistOut]
借助队列数据结构，由于队列是先进先出的顺序，因此可以先将左子树入队，然后再将右子树入队。
有很多种结果。转换成树后很容易理解，一层一层从左往右走，适合层次关系

深度优先搜索算法（Depth First Search）DFS-Stack[The characteristics of stack are FistIn LastOut]
借助堆栈的数据结构，由于堆栈是后进先出的顺序，由此可以先将右子树压栈，然后再对左子树压栈，
DFS-Stack:有很多种结果。走到最根节点后，回到上一节点再遍历.

using for solve with the graph,the course prerequisite question. etc.

comparison
1.BFS是用来搜索最短径路的解是比较合适的，比如求最少步数的解，最少交换次数的解，因为BFS搜索过程中遇到的解一定是离根最近的，所以遇到一个解，一定就是最优解，此时搜索算法可以终止。这个时候不适宜使用DFS，因为DFS搜索到的解不一定是离根最近的，只有全局搜索完毕，才能从所有解中找出离根的最近的解。（当然这个DFS的不足，可以使用迭代加深搜索ID-DFS去弥补）
2.空间优劣上，DFS是有优势的，DFS不需要保存搜索过程中的状态，而BFS在搜索过程中需要保存搜索过的状态，而且一般情况需要一个队列来记录。
3.DFS适合搜索全部的解，因为要搜索全部的解，那么BFS搜索过程中，遇到离根最近的解，并没有什么用，也必须遍历完整棵搜索树，DFS搜索也会搜索全部，但是相比DFS不用记录过多信息，所以搜素全部解的问题，DFS显然更加合适。
上面提到的迭代加深搜索（ID-dfs）我觉得充分吸收了BFS和DFS各自的长处

A Tree is typically traversed in two ways:
Breadth First Traversal (Or Level Order Traversal)
Depth First Traversals (DFS for tree has two ways):
Inorder Traversal (Left-Root-Right)
Preorder Traversal (Root-Left-Right)
Postorder Traversal (Left-Right-Root)



DFS and BFS implement : https://www.jianshu.com/p/a753d5c733ec
bfs-vs-dfs-binary-tree :https://www.geeksforgeeks.org/bfs-vs-dfs-binary-tree/
comparison with tree and graph DFS,BFS https://www.geeksforgeeks.org/depth-first-search-or-dfs-for-a-graph/
