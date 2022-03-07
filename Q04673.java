
public class Q04673 {
	public static final int MAX = 10000;
	static int[] count = new int[MAX+36];
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SelfNumber();
	}
	
	public static void SelfNumber() {
		int a,b,c,d,sum;
		for (int i = 0; i < MAX; i++) {
			a = i/1000;
			b = (i/100)%10;
			c = (i/10)%10;
			d = i%10;
			sum = i + a + b + c + d;
			count[sum] = sum;
		}
		for (int i = 0; i < MAX; i++) {
			if(i>0 && count[i]==0)
				System.out.println(i);
		}
	}
}
