# Searching-in-Rotated-Sorted-Array-
<h2>Problem Statement</h2>
<p>Given a Sorted Array, which is rotated by any value. We have to search if the given target exists in the Array or not, if it exists print it's index, else print -1.</p>
<h2>Intution</h2>
<p>
<br>Here, there is one thing to notice that ,for sorted Array, from 1st elemnt to largest element ,the Array is sorted.Similarly, from next element till last element , The Array is sorted.<br>
For Example [5,7,9,1,3]<br>
<br>Let the index for Largest element in the Array be K.<br>
<br>So, we simply have to apply Binary Search from [0,K] index and if target is not there then we'll apply binary search from [k+1,array's length-1].<br>
<br>So, We only have to find this value of k.<br>
</p>
<h2>Algorithm</h2>
<p>
<br>To find value of K, we'll use Binary Search method to check if arr[mid]>arr[mid-1] and arr[mid]>arr[mid+1], thus we'll get our value of K,which is same as mid.<br>
<br>But, even if we are able to check if arr[mid-1]>arr[mid] and arr[mid+1]>arr[mid],then also we'll get value of k,which will be mid-1, as in sorted Rotated Array, smallest term is always ahead of largest term.<br>
<br>Other than these two conditions, we also need to change the values of low and high variables.For this we can take help of arr[n-2].If the Array is seen properly, we can say that all elements from 0 to K-1 index are greater than arr[n-2].So if mid index falls any of these index , so we can say that, update low from 1 to mid+1.<br>
<br>Similarly from [k+2,n-1] index values are either less than or equal to arr[n-2].So if mid index falls any of these index , so we can say that, update high from n-2 to mid-1.<br>
<br>But here, if you would have noticed , The value of low is shifted from 1 to mid+1 and not from 0.Similarly, for high it is from n-2 to mid-1 and not from n-1.<br>
<br>This is to avoid index out of bound Error as for n-1 the indices checked will be n and n-2 but n index doesn't exists.<br>
<br>So, first  we'll go for binary search with low=1,high=n-2.<br>
<br>After that we'll check if arr[n-1]>arr[0] and arr[n-1]>arr[n-2].If it's true then return n-1.<br>
<br> if not Then check if arr[0]>arr[n-1] and arr[0]>arr[1].If it's true then return 0.<br>
<br>After getting value of K, run binary searches two times, once from 0 to K and other from K+1 to n-1.<br>
<br>If target is found, return it's index.If not return -1.<br>
</p>
