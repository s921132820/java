package basic.arrayTest;

public class ArrayEx01 {
    public static void main(String[] args) {
        // num라는 변수에는 3,4,5 가 들어가 있음
        int[] nums = {3,4,5};
        System.out.println(nums[0]);
        System.out.println(nums[1]);
        System.out.println(nums[2]);
//        System.out.println(nums[3]);
        System.out.println("====" + nums.length);
        for (int i = 0; i <nums.length; i++) {
            System.out.println(nums[i]);
        }
    }
}

// 배열의 길이를 알면 쉽게 작업이 가능함
// 배열은 클래스다
// 모든 배열과 리스트는
