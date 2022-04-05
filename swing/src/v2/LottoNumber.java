package v2;

import java.util.Arrays;
import java.util.Random;

public class LottoNumber {

    static final int LOTTO_NUM_SIZE = 6;

    public int[] getLottoNumber() {

        int[] numbers = new int[LOTTO_NUM_SIZE];
        Random random = new Random();

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = random.nextInt(45) + 1;

            for (int j = 0; j < i; j++) {
                if (numbers[i] == numbers[j]) {
                    i = i - 1;
                    break;
                }
            }
        }

        Arrays.sort(numbers);

        return numbers;

	}
//public static void main(String[] args) {
//    // 테스트 코드
//    LottoNumber lottoNumber = new LottoNumber();
//    int[] nums = lottoNumber.getLottoNumber();
//    for(int i : nums) {
//        System.out.print(i + "\t");
//    }
//}

}