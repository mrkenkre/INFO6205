package edu.neu.coe.info6205.union_find;

import java.util.Random;

public class HWQUPC_Solution {

	public static int count(int n) {
		UF_HWQUPC uf = new UF_HWQUPC(n);
		int count = 0;
		if (n != 0) {
			// int n=Integer.parseInt(args[0]);
			Random random = new Random();

			while (uf.components() != 1) {
				int x = random.nextInt(n);
				int y = random.nextInt(n);
				// System.out.println("(" + x + ", " + y + ")");
				if (!uf.connected(x, y)) {
					uf.union(x, y);
				}
				count++;

			}

		}
		return count;
	}

	public static void main(String args[]) {
		int count = 0;
		int n = 0;
		int d = 100;
		if (args.length != 0) {
			count = count(Integer.parseInt(args[0]));
		} else {
			Random random = new Random();
			for (int i = 0; i < 15; i++) {
				// n=random.nextInt(100);
				for(int j=0;j<10;j++) {
					count += count(d);
				}
				count=count/10;
				// System.out.println("M: "+n);
				//System.out.println("For n: " + d + " Total connections made: " + count);
				System.out.println(d + "\t" + count);
				d = d * 2;
			}
		}

	}

}
