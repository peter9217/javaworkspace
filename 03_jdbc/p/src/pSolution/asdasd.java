package pSolution;

public class asdasd {
	public static void main(String[] args) {
	      
	      int[][] score1 = {{80, 70}, {90, 50}, {40, 70}, {50, 80}};
	      int[][] score2 = {{80, 70}, {70, 80}, {30, 50}, {90, 100}, {100, 90}, {100, 100}, {10, 30}};
	      
	      int[] answer1 = solution(score1);
	      int[] answer2 = solution(score2);
	      
	      // [1, 2, 4, 3]
	      for(int i : answer1) 
	         System.out.print(i + " ");
	      
	      System.out.println();
	      
	      // [4, 4, 6, 2, 2, 1, 7]
	      for(int i : answer2)
				System.out.print(i + " ");
		}

		public static int[] solution(int[][] score) {
			int[] answer = new int[score.length];

			int num = 1;
			int j = score[0][0] + score[0][1];
			int p =0;
			for (int i = 0; i < score.length; i++) {

				for (int k = 0; k < score.length; k++) {
					if (j < score[k][0] + score[k][1]) {
						j = score[k][0] + score[k][1];
					}
				}
				for (int h = 0; h < score.length; h++) {
					if (j == score[h][0] + score[h][1]) {
						answer[h] = num;
						score[h][0] = -1;
						score[h][1] = -1;
						p++;
					}

				}
				j = 0;
				for(int q=0; q<p; q++) {
					num++;
				}
				p=0;
				
			}

	        return answer;
	   }

}
