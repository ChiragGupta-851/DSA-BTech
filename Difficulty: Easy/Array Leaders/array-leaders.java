class Solution {
    static ArrayList<Integer> leaders(int arr[]) { //On GeeksForGeeks
       
        ArrayList<Integer> list = new ArrayList<>();
        
       
        int maxi = Integer.MIN_VALUE;
        
       
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] >= maxi) { 
                list.add(arr[i]); 
                maxi = arr[i];    
            }
        }
        
        //  DO NOT SORT. Reverse the list to restore the original left-to-right order.
        Collections.reverse(list);
        
        return list;
    }
    }

