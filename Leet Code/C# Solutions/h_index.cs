/// <summary>
/// From Leet Code: https://leetcode.com/problems/h-index/
/// Given an array of integers citations where citations[i] is the number of citations a researcher received for their ith paper, 
/// return the researcher's h-index.
/// 
/// </summary>
class Solution {
    public int hIndex(int[] citations) {
        int n = citations.Length;

        int[] papers = new int[n + 1];

        foreach (int c in citations) {

            if (c >= n) { papers[n]++; } //cap the maximum number of citations at n
            else { papers[c]++; }
        }
        
        int count = 0;

        for (int i = n; i >= 0; i--) {
            count += papers[i];
            if (count >= i) { return i; }
        }
        return 0;
    }
}