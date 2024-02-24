import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String str = br.readLine();
		StringTokenizer strTo = new StringTokenizer(str, " ");
		int a = Integer.parseInt(strTo.nextToken());
		int b = Integer.parseInt(strTo.nextToken());
		int v = Integer.parseInt(strTo.nextToken());

		int n = (v - a) / (a - b);
		if ((v - a) % (a - b) == 0) {
			n += 1;
		} else {
			n += 2;
		}
		System.out.println(n);
	}

}