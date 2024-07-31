import java.util.*;
public class Search_in_a_Sorted_rotated_array {
    public static void main(String[] args) {
        Scanner Sc=new Scanner(System.in);
        System.out.print("Enter the size of array: ");
        int n=Sc.nextInt();
        int[] arr=new int[n];
        System.out.println("Enter the elements in rotated sorted manner: ");
        for(int i=0;i<n;i++)
            arr[i]=Sc.nextInt();
        System.out.print("Enter the target: ");
        int target=Sc.nextInt();
        System.out.println("Entered Array is: ");
        for(int ele:arr)
            System.out.print(ele+" ");
        System.out.println();
        System.out.println("The index of "+target+" in the Array is "+answer(arr,target));
    }
    static int answer(int[] arr,int target){
        int n=arr.length;
        int idx=Pivot_Index(arr);
        int ans=Binary_Search(arr,target,0,idx);
        if(ans!=-1)
            return ans;
        ans=Binary_Search(arr,target,idx+1,n-1);
        return ans;
    }
    static int Pivot_Index(int[] arr){
        int n=arr.length;
        int low=1,high=n-2;
        while(low<=high){
            int mid=(low+high)/2;
            if(arr[mid-1]<arr[mid] && arr[mid]>arr[mid+1])
                return mid;
            else if(arr[mid-1]>arr[mid] && arr[mid]<arr[mid+1])
                return mid+1;
            else{
                if(arr[mid]<arr[n-1])
                    high=mid-1;
                else
                    low=mid+1;
            }
        }
        if(arr[n-1]>arr[n-2] && arr[n-1]>arr[0])
            return n-1;
        return 0;
    }
    static int Binary_Search(int[] arr,int target,int low,int high){
        while(low<=high){
            int mid=(low+high)/2;
            if(arr[mid]==target)
                return mid;
            else if(arr[mid]>target)
                high=mid-1;
            else
                low=mid+1;
        }
        return -1;
    }
}
