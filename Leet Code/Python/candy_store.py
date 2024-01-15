"""
From Leet Code: https://leetcode.com/problems/candy/
There are n children standing in a line. Each child is assigned a rating value given in the integer array ratings.

You are giving candies to these children subjected to the following requirements:

    Each child must have at least one candy.
    Children with a higher rating get more candies than their neighbors.

Return the minimum number of candies you need to have to distribute the candies to the children.
"""

class Solution(object):
    def candy(self, ratings):
        """
        :type ratings: List[int]
        :rtype: int
        """
        
        #initialize candies array, all children get 1 candy to start to meet requirement 1

        n = len(ratings)
        
        candy = [1] * n

        #begin allocating candies to the right of each child
        for i in range(1, n):
            #if the child to the right has a higher rating, give them 1 more candy than the current child
            if ratings[i] > ratings[i-1]:
                candy[i] = candy[i-1] + 1
        
        #go back and allocate candies to the left of each child
        for i in range(n-2, -1, -1):
            #if the child to the left has a higher rating, give them 1 more candy than the current child
            if ratings[i] > ratings[i+1] and candy[i] <= candy[i+1]:
                candy[i] = candy[i+1] + 1
        
        print(candy)

        #return sum of candies
        return sum(candy)