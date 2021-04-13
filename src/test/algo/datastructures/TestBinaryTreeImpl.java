package algo.datastructures;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.logging.Logger;


public class TestBinaryTreeImpl {
    private static Logger LOG = Logger.getLogger(TestBinaryTreeImpl.class.getName());
    private static BinaryTreeNode arrayToTree(List<Integer> treeArray) {
        if (treeArray == null || treeArray.size() < 1) {
            return null;
        }
        BinaryTreeNode root = new BinaryTreeNode(treeArray.get(0));
        List<BinaryTreeNode> nodes = new ArrayList<>();
        nodes.add(root);
        for (int i = 0, j = 0; i < treeArray.size(); i++) {
            int leftIndex = 2 * i + 1, rightIndex = 2 * i + 2;
            if (treeArray.get(i) != -1) {
                BinaryTreeNode currNode = nodes.get(j++);
                if (leftIndex < treeArray.size() && treeArray.get(leftIndex) != -1) {
                    BinaryTreeNode leftNode = new BinaryTreeNode(treeArray.get(leftIndex));
                    nodes.add(leftNode);
                    currNode.left = leftNode;
                }

                if (rightIndex < treeArray.size() && treeArray.get(rightIndex) != -1) {
                    BinaryTreeNode rightNode = new BinaryTreeNode(treeArray.get(rightIndex));
                    nodes.add(rightNode);
                    currNode.right = rightNode;
                }
            }
        }
        return root;
    }

    @Test
    public void testInOrderTraversal() {
        // Adding an object array which will have input tree in inorder, out and corresponding testcase description
        Object[][] testCases = {
                {Arrays.asList(3,9,20,-1,-1,15,7), new Integer[]{9, 3, 15, 20, 7}, "Balanced binary tree"}
        };

        for (Object[] testCase : testCases) {
            String testName = (String) testCase[2];
            LOG.info("Running Test: " + testName);
            List<Integer> actualOutput = BinaryTreeImpl.inorderRecursive(arrayToTree( (List<Integer>) testCase[0]));
            List<Integer> expectedOutput = Arrays.asList((Integer[]) testCase[1]);

            Assert.assertTrue("Failed Test: " + testName + " Actual: " + actualOutput + " Expected: " + expectedOutput,
                    actualOutput.equals(expectedOutput));
        }
     }



}
