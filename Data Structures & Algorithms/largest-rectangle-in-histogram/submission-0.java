class Solution {
    public int largestRectangleArea(int[] heights) {
     int n = heights.length;
     int[] nextSmaller = new int[n];
     int[] prevSmaller = new int[n];
     Stack<Integer> st = new Stack<>();
     for(int i = n-1;i>=0;i--){
        while(!st.isEmpty() && heights[st.peek()] >= heights[i]){
            st.pop();
        }
        if(st.isEmpty()){
            nextSmaller[i] = -1;
        }
        else{
            nextSmaller[i] = st.peek();
        }
        st.push(i);
     };
     st.clear();
     for(int i = 0;i<n;i++){
        while(!st.isEmpty() && heights[st.peek()] >= heights[i]){
            st.pop();
        }
        if(st.isEmpty()){
            prevSmaller[i] = -1;
        }
        else{
            prevSmaller[i] = st.peek();
        }
        st.push(i);
     };

     int maxArea = 0;
     for(int i = 0;i<n;i++){
        int left = prevSmaller[i];
        int right = nextSmaller[i];

        if(right == -1){
            right = n;
        };
        int width = right-left-1;
        int area = heights[i]*width;

        maxArea = Math.max(maxArea, area);
     }
     return maxArea;
    }
}
