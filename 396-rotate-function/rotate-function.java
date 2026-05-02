/*
Let's say our original array is [a,b,c,d,e]

The value of this currently is
F(0) = 0*a + 1*b + 2*c + 3*d + 4*e

Now when we right rotate it, the array will become [e,a,b,c,d]

So value of this array will be
F(1) = 0*e + 1*a + 2*b + 3*c + 4*d

What is the difference between two ? If you look carefully and do F(1) - F(0), the difference will be

a*(1-0) + b*(2-1) + c*(3-2) + d*(4-3) + e*(0-4)

which is same as difference being
a + b + c + d + e - 5*e

Again now our array was [e,a,b,c,d].
F(1) wasF(1) = 0*e + 1*a + 2*b + 3*c + 4*d

Let's say we rotate it once more so new array will be [d,e,a,b,c].
Value of this will be
F(2) = 0*d + 1*e + 2*a + 3*b + 4*c

So now if we do F(2)-F(1), we will get difference as
e*(1-0) + a*(2-1) + b*(3-2) + c*(4-3) + d*(0-4)

Which is same as difference being
a + b + c + d + e - 5*d

Final conclusion
We'll calculate F(0) and let's say its value is X

Now to get F(1) , we simply have to add the difference which is
a + b + c + d + e - 5*e.

Now F(1) value is Y

Now to get F(2), we simply have to again add the next difference to value Y which is
a + b + c + d + e - 5*d

Now F(2) value is Z

So diffrences to be added after each rotation will be
a + b + c + d + e - 5*e then
a + b + c + d + e - 5*d then
a + b + c + d + e - 5*c and so on

This can be calculated in O(1) time.

So we will compute value of F(0), and then find values of F(1),F(2) till F(n-1) using the difference concept and try to maximise our answer each and everytime

TC - 0(N)
SC - 0(N)
*/
class Solution {
    public int maxRotateFunction(int[] nums) {
        int n = nums.length;

        int sum=0; int mx=0;
        int origsum=0;
        for(int i=0;i<n;i++) {
            sum += i * nums[i];
            origsum += nums[i];
        }

        mx = sum;

        for(int i=n-1;i>=0;i--)
        {
            sum +=  ( (origsum) - n*nums[i] );
            mx = Math.max(mx,sum);
        }

        return mx;
    }
}
