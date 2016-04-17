import org.junit.After;
import org.junit.Test;

public class ラムダ式のテスト {
	
	private 数値を受け取って文字列を返すインターフェイス target;
	
	/**
	 * 最後にカウントする
	 */
	@After
	public void count1to30() {
		System.out.println("-----これは" + target.getClass().getSimpleName() + "クラスです-----");
		for (int i = 1; i <= 30; i++) {
			System.out.println(i + "のとき=" + target.getStringFromInt(i));
		}
	}
	
	@Test
	public void testFizzBuzz() {	
		target = (int num) -> {
			return FizzBuzzEnum.getFizzBuzz(num);
		};
	}
	
	@Test
	public void testFibonati() {
		target = (int num) -> {
			return Long.toString(fibonacci(num));
		};
	}

	long fibonacci(int x) {
		if (x == 0 || x == 1) {
			return x;
		}
		return fibonacci(x - 1) + fibonacci(x - 2);
	}
	
	
	@FunctionalInterface
	interface 数値を受け取って文字列を返すインターフェイス {
		String getStringFromInt(int i);
	}
	
	/**
	 * FizzBuzzクラス
	 */
	enum FizzBuzzEnum {
		FizzBuzz(15),
		Buzz(5),
		Fizz(3),
		;
		private int intValue;
		FizzBuzzEnum(int i) {
			this.intValue = i;
		}
		public static String getFizzBuzz(int num) {
			for (FizzBuzzEnum fb : FizzBuzzEnum.values()) {
				if (num % fb.intValue == 0) {
					return fb.name();
				}
			}
			return Integer.toString(num);
		}
	}
}
