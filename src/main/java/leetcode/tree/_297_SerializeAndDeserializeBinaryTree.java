package leetcode.tree;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 序列化是将一个数据结构或者对象转换为连续的比特位的操作，进而可以将转换后的数据存储在一个文件或者内存中，同时也可以通过网络传输到另一个计算机环境，采取相反方式重构得到原数据。
 *
 * 请设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列 / 反序列化算法执行逻辑，你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串反序列化为原始的树结构。
 *
 * 示例:
 *
 * 你可以将以下二叉树：
 *
 *     1
 *    / \
 *   2   3
 *      / \
 *     4   5
 *
 * 序列化为 "[1,2,3,null,null,4,5]"
 * 提示: 这与 LeetCode 目前使用的方式一致，详情请参阅 LeetCode 序列化二叉树的格式。你并非必须采取这种方式，你也可以采用其他的方法解决这个问题。
 *
 * 说明: 不要使用类的成员 / 全局 / 静态变量来存储状态，你的序列化和反序列化算法应该是无状态的。
 */
public class _297_SerializeAndDeserializeBinaryTree {

    String serialize(TreeNode root){
        if(root==null){
            return "";
        }
        return serializeByPre(root);
    }
    String serializeByPre(TreeNode root) {
        String res = "";
        if (root == null) {
            return "null,";
        }
        res += root.val + ",";
        res += serializeByPre(root.left);
        res += serializeByPre(root.right);

        return res;
    }



   public TreeNode deserialize(String data) {
        if (data == null || data.length() == 0) {
            return null;
        }
        String[] values = data.split(",");
        Queue<String> queue = new LinkedList<String>();
        for (int i = 0; i < values.length; i++) {
            queue.offer(values[i]);
        }
        return deserialByPre(queue);
    }

    public TreeNode deserialByPre(Queue<String> q) {
        String value = q.poll();
        if (value.equals("null") ) {
            return null;

        }
        TreeNode root = new TreeNode(Integer.valueOf(value));
        root.left = deserialByPre(q);
        root.right = deserialByPre(q);
        return root;
    }
}
