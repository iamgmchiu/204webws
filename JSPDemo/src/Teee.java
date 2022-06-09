
public class Teee {

	public static void main(String[] args) {

		
		int a,b,c,sum;
		sum=0;
		b=0;
		c=0;
		for (int i = 1; i <= 50; i++) {
			if (i/2==0) {b=i;
				
			} else {c=i;

			}sum+=(b*b)-(c*c);
			System.out.println(sum);
		}System.out.println(sum);
	}

}
