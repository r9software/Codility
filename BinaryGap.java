/**
 *
 * @author rodolfo.abarca
 * 
 * Binary Gap
 * A binary Gap within a positive integer N is any maximal sequence of consecutive 
 * zeros that is surrounded by ones at both ends in the binary representation of N.
 * For example, number 9 has a binary representation 1001 and contains a binary
 * gap of length 2. The number 529 has binary representation 1000010001 
 * and contains two binary gaps: one of length 4 and one of length 3. The number
 * 20 has binary representation 1111 and has no binary gaps.
   Write a function: 
	class Solution { public int solution(int N); }
 * that, given a positive integer N, returns the length of its longest 
 * binary gap. The function should return 0 if N doesn’t contain a binary gap.
 * For example, given N=1041 the function should return 5, because N has binary 
 * representation 10000010001 and so its longest binary gap is of length 5.
 * Assume that: 
    •	N is an integer within the range [1.. 2,147,483,647],
 * Complexity:
    •	Expected worst-case time complexity is O (log(N));
    •	Expected Worst-case space complexity is O (1).
 * 
 */
public class BinaryGap {

    public int solution(int n) {
        int finalGap = 0;
        //1 is  0
        if (n == 1) {
            return 0;
        }
        //use the shortest way to convert to a binary representation
        char binaryRep[] = Integer.toBinaryString(n).toCharArray();
        int tempGap=0; 
        //the binary representation must start with 1 we continue counting the 0 while 
        // we found a new one, and then return the longest binary gap 
        // the binary numbers ending on 0 cant be counted because it should be 1 0000..1 
        // to be a valid gap
        for (int x = 0; x < binaryRep.length; x++) {
            if(binaryRep[x]=='0'){
                tempGap++;
                continue;
            }else if(binaryRep[x]=='1'){
                if(tempGap>finalGap)
                finalGap=tempGap;
                tempGap=0;
            }
            
        }
        return finalGap;
    }
}
