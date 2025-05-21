import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElementII {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        Arrays.fill(res, -1);

        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < 2 * n; i++) {
            while (!st.isEmpty() && nums[i % n] > nums[st.peek()]) {
                int popped = st.pop();
                res[popped] = nums[i % n];
            }
            if (i < n) {
                st.push(i);
            } else {
                if (i == st.peek())
                    break;
            }
        }

        return res;
    }
}

//TC: O(3n), SC: O(n)
