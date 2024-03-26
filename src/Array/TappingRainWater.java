package Array;

public class TappingRainWater {

	public static void main(String[] args) {
//		int a[] =  {3,0,0,2,0,4};
		int a[] = {7,4,0,9};		
		int waterTappedActualArray = mySolution(a);
		a = ReverseArray.reverseArray(a);
		int waterTappedReversedArray = mySolution(a);
		System.out.println("Water Tapped: "+Math.min(waterTappedActualArray, waterTappedReversedArray));
		
		int b[] = {8,8,2,4,5,5,1};		
		int waterTappedOptimised = optimisedSolution(b,b.length);
		System.out.println(waterTappedOptimised);
		
	}
	//this is not working for problems with right extreme points e.g {8,8,2,4,5,5,1}.But it will work if you reverse the array
	//But it will work if you reverse the array. So the solution could be minimum of Actual array and reversed array with O(n) time and O(1) space complexity.
	public static int mySolution(int a[]) { 
		int initialHeight = a[0];
		int waterTapped = 0;
		for(int i=1; i<a.length; i++) {
			if(a[i]<initialHeight) {	//if the ith block is less than the initial block then only it can tap the water.
				waterTapped = waterTapped+(initialHeight-a[i]);
			}
			else {	//if ith block is greater/equal to initial block then till ith block ,no water tapped as such. So ith block become the initial block.
				initialHeight = a[i];
			}
		}
		return waterTapped;
	}
	
	public static int optimisedSolution(int arr[],int n) {
		//creating 2 arrays to have maximums till index i at left and right side respectively.
		int mxl[] = new int[n];
        int mxr[] = new int[n];
        
        mxl[0] = arr[0];
        for(int i = 1; i < n; i++){
            mxl[i] = Math.max(mxl[i - 1], arr[i]);
        }
        System.out.println("maximum array from left contains : ");
        for(int j:mxl) {
        	System.out.print(j+" ");
        }
        mxr[n - 1] = arr[n - 1];
        for(int i = n - 2; i >= 0; i--){
            mxr[i] = Math.max(mxr[i + 1], arr[i]);
        }
        System.out.println("\nmaximum array from right contains: ");
        for(int j:mxr) {
        	System.out.print(j+" ");
        }
        
        int ans=0;
        for(int i=0;i<n;i++){
            ans+=Math.min(mxl[i],mxr[i])-arr[i];
        }
        System.out.println(ans);
        return ans;
   
	}
}
