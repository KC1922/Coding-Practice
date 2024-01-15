"""
From Leet Code: https://leetcode.com/problems/gas-station/
There are n gas stations along a circular route, where the amount of gas at the ith station is gas[i].

You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from the ith station to its next (i + 1)th station. 
You begin the journey with an empty tank at one of the gas stations.

Given two integer arrays gas and cost, return the starting gas station's index if you can travel around the circuit once in the clockwise direction, 
otherwise return -1. If there exists a solution, it is guaranteed to be unique
"""
class Solution(object):
    def canCompleteCircuit(self, gas, cost):
        """
        :type gas: List[int]
        :type cost: List[int]
        :rtype: int
        """
            
        #if there is less total gas than total cost, return -1
        if sum(gas) < sum(cost):
            return -1
        
        start = 0
        tank = 0

        for i in range(len(gas)):
            #check if there is negative gas, if so, reset the start and tank and continue from next station
            if tank < 0:
                start = i
                tank = 0
            
            tank += gas[i] - cost[i]
        
        
        return start