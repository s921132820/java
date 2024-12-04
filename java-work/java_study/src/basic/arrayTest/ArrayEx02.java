package basic.arrayTest;

public class ArrayEx02 {
    public static void main(String[] args) {
        // int[] 붙여도 됨
        int nums[] = new int[3];
        nums[0] = 4;
        nums[1] = 5;
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
        // advanced for 구문
        // int x : nums -> int 타입인 x 에 nums에 있는걸 하나씩 빼서 넣겠다는 뜻
         for (int x : nums) {
             System.out.println(x);
         }
    }
}