import org.junit.After;
import org.junit.Test;

public class 戦車継承のテスト {
	// テスト対象
	private 戦車インターフェイス target;
	@After
	public void tearDown() {
		System.out.println("-----これは" + target.getClass().getSimpleName() + "クラスです-----");
		target.printParts();
	}
	
	@Test
	public void test戦車impl() {
		target = new 戦車impl();
	}
	
	@Test
	public void testLT38() {
		target = new LT38();
	}
	
	@Test
	public void testヘッツァー() {
		target = new ヘッツァー();
	}
	
	@Test
	public void testラムダ戦車() {
		// 戦車インターフェイスを実装
		// 勝手にprintPartsメソッドを上書きする
		target = () -> {
			System.out.println("なにも実装してません");
		};
	}
	
	/**
	 * 戦車インターフェイス
	 */
	@FunctionalInterface
	interface 戦車インターフェイス {
		static final String なし = "なし";
		void printParts();
	}

	/**
	 * 戦車実装クラス
	 */
	class 戦車impl implements 戦車インターフェイス {
		protected String 砲;
		protected String 砲塔;
		protected String 履帯;

		public 戦車impl() {
			this.砲 = なし;
			this.砲塔 = なし;
			this.履帯 = なし;
		}

		@Override
		public void printParts() {
			System.out.println("砲塔は" + this.砲塔);
			System.out.println("砲は" + this.砲);
			System.out.println("履帯は" + this.履帯);
		}
	}

	/**
	 * 38tクラス
	 */
	class LT38 extends 戦車impl {
		public LT38() {
	        this.砲塔 = "Pz.Kpfw 38(t) Ausf. G";
	        this.砲 = "4,7 cm Kw.K. 38 (t) L/43";
	        this.履帯 = "Pz.Kpfw 38(t) Ausf. E";
		}
	}
	
	/**
	 * ヘッツァークラス
	 */
	class ヘッツァー extends LT38 {
		public ヘッツァー() {
	        this.砲 = "10.5 cm Stu.H. 42 L/28";
	        this.砲塔 = "ヘッツァー改装キット";
		}
	}
}
