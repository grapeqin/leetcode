package github.grapeqin.binarytree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LeetCode103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(null == root){
            return ans;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean ordered = true;
        while(!queue.isEmpty()){
            int n = queue.size();
            List<Integer> list = new ArrayList<>();
            for(int i = 0;i < n;i++){
                TreeNode node = queue.poll();
                //相比层次遍历只是需要调整组装列表的顺序
                if(ordered){
                    list.add(node.val);
                }else{
                    list.add(0,node.val);
                }
                if(node.left != null){
                    queue.add(node.left);
                }
                if(node.right != null){
                    queue.add(node.right);
                }
            }
            ordered = !ordered;
            ans.add(list);
        }
        return ans;
    }
}
