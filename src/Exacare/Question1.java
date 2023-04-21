package Exacare;
/*
* You are working with the owner of a brand new assisted living community.

There are n residents standing in a line waiting to enter the community for the first time. Residents have given you preferences for each room, and unfortunately you could not meet all of their preferences. Each resident is assigned an unhappiness score given in the integer array unhappinessScores. This score represents how unhappy the resident is with their assigned room. The owner has decided that he wants to give money to the residents in order to help alleviate their unhappiness.

You are assigned to help. You will be giving money to these residents subjected to the following requirements:

Each resident must have at least one $1
Residents that are more unhappy get more money than their neighbors or their unhappiness does not go away.
Return the minimum number of dollars you need to have to distribute the money to the residents to alleviate all of their unhappiness.

Example 1:

Input: unhappinessScores = [1,0,2]

Output: 5

Explanation: You can allocate to the first, second and third resident with 2, 1, 2 dollars respectively.

Example 2:

Input: unhappinessScores = [1,2,2]

Output: 4

Explanation: You can allocate to the first, second and third resident with 1, 2, 1 dollars respectively. The third resident gets 1 dollar because it satisfies the above two conditions.

*
* Input: unhappinessScores = [3,2,1,0] => 1+2+3+4 =10
[1,0,2,0,4,3,2,1]
*
* [0,3,2,1] =>
*  1,2,1,x
*  1,3,2,1
    1 , 3 , 2 ,1 => 7
    1, 2, 1, x
    *
    * 1, 2, 2
    *  1   2  1 =>
    * [1,0,2] [2, 1, 2] => need to minimum 0
    * 1,0,2 =>
    * 2,1,2
    * [1,0,2,0,4,2]
    * 2,1,2,1,2,1
Constraints:

n == unhappinessScores.length
1 <= n <= 2 * 104
0 <= unhappinessScores[i] <= 10*/

import java.util.Arrays;

public class Question1 {

    public static void main(String[] args) {
        int[] unhappinessScores = {0,3,2,1,2,3,0};
        Question1 question = new Question1();
        int res = question.unHappinessIndex(unhappinessScores);
        System.out.println(res);
    }

    private int unHappinessIndex(int[] unhappinessScores) {
        //is it decreasing
        // is it increasing
        // is it mix of both
        // find all inflection points => the point at which the array trend changes assign them 1s,
        // and define the values of others based on that.
        int[] result =new int[unhappinessScores.length];
        Arrays.fill(result, 1);
        for(int i=1;i<unhappinessScores.length;i++) {
            if(unhappinessScores[i-1]<unhappinessScores[i]) {
                result[i]=result[i-1]+1;
            }
        }
        for(int i=unhappinessScores.length-2;i>=0;i--) {
            if (unhappinessScores[i+1]<unhappinessScores[i]) {
                result[i] = Integer.max(result[i],result[i+1] + 1);
            }
        }
        int sum = 0;
        for( int i : result) {
            sum += i;
        }
        return sum;
    }

}
