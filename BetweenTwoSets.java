/*
* You will be given two arrays of integers and asked to determine all integers that satisfy the following two conditions:

1/ The elements of the first array are all factors of the integer being considered
2/ The integer being considered is a factor of all elements of the second array

* These numbers are referred to as being between the two arrays. You must determine how many such numbers exist
*/

class Solution {

    public static int[] commonDivisors(List<Integer> list) {
        Collections.sort(list); int limit = list.get(list.size()-1);
        int[] divisors = new int[1000]; int c = 0; // Variable to indicate index
        for(int p = 1; p <= limit; p++) {
            boolean bool = true;
            for(Integer j: list) {
                if(j % p != 0) {
                    bool = false;
                    break;
                }
            }
            if(bool) {
                divisors[c] = p; c++;
            }
        }
        return divisors;
    }

    public static int trueLength(int[] array) {
        int length = 0;
        for(int index = 0; index < array.length; index++) {
            if(array[index] == 0) {
                break;
            }
            length++;
        }
        return length;
    }

    public static int getTotalX(List<Integer> a, List<Integer> b) {
        int[] divisors = commonDivisors(b); int length = trueLength(divisors);
        int count = 0; // Count for how many integers satisfied the given conditions
        for(int y = 0; y < length; y++) {
            int d = divisors[y]; boolean bool = true;
            for(Integer i: a) {
                if(d % i != 0) {
                    bool = false;
                    break;
                }
            }
            if(bool) {
                count++;
            }
        }
        return count;
    }
}
