


class Main {
    public static void main(String[] args) {
        int [] arr = {2, 4, 6, 8, 10, 12};
        int target = 10;
        int answer = BinarySearch(arr , target);
        if(answer !=-1){
        System.out.println("The target element is present at index "+answer);
        }else{
            System.out.println("The element is not present "+answer);
        }
    }
    static int BinarySearch(int [] arr , int target){
        int start = arr[0];
        int last = arr.length -1 ;
        
        while(start <= last){
            int mid = (start + (last - start)) / 2; //using this beacouse some time int go out of bound in (start+end)/2
            if (arr[mid] == target){
                return mid ;
            }
            else if (arr[mid] < target){
                start = mid + 1;
            }
            else if(arr[mid] > target){
                last = mid -1;
            }
            
        }
        return -1;
        
    }
}
