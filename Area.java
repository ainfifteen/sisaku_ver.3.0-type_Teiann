package sisaku_Teian;

import java.util.Random;

public class Area {
	int peaple;
	int serchArea;
	int serchCase;
	int[][] field = new int[24][24];//データの格納
	int [][] divisionField = new int[36][36];//データの格納

	Area(int peaple, int serchArea, int serchCase){
		this.peaple = peaple;
		this.serchArea = serchArea;
		this.serchCase = serchCase ;

		int a = (serchArea - 1) % 3;
		int b = (serchArea - 1) / 3;

		/*System.out.print("x_FieldValue " + 2 + " + ");
		System.out.println(8 * a + 2 * (serchCase - 1));
		System.out.print("y_FieldValue " + 8 + " + ");
		System.out.println(8 * b);*/

		Random rnd1 = new Random();
		int x_FieldValue = rnd1.nextInt(2) + 8 * a + 2 * (serchCase - 1) ;
		int y_FieldValue = rnd1.nextInt(8) + 8 * b;

		//System.out.println(x_FieldValue + " " + y_FieldValue);



		Random rnd2 = new Random();
		int[]iValue = new int[peaple];
		int[]jValue = new int[peaple];

		for(int i = 0; i < 24; i++) {
			for(int j = 0; j < 24; j++) {
				field[i][j] = 0;
				//field[0][6] = 1;
			}
		}


		field[x_FieldValue][y_FieldValue] = 1;

		for(int i = 0; i < 36; i++) {
			for(int j = 0; j < 36; j++) {
				divisionField[i][j] = 0;
			}
		}

		for(int k = 0; k < peaple; k ++) {

	    	  iValue[k] = rnd2.nextInt(12) + 12 * a;
	    	  jValue[k] = rnd2.nextInt(12) + 12 * b;
	    	  boolean flag = false;
	    	  divisionField[iValue[k]][jValue[k]] = 1;

	    	  do {
	              flag = false;
	              for (int j = k - 1; j >= 0; j--) {
	                  if (iValue[k] == iValue[j] && jValue[k] == jValue[j]) {
	                      flag = true;
	                      iValue[k] = rnd2.nextInt(12) + 12 * a;
	                	  jValue[k] = rnd2.nextInt(12) + 12 * b;
	                	  divisionField[iValue[k]][jValue[k]] = 1;
	                  }
	              }

	          } while (flag == true);

	    	  divisionField[iValue[k]][jValue[k]] = 1;
	    }
	}
}
