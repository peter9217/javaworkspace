package pSolution;

public class asdasd {
	public static void main(String[] args) {
	      int[] ingredient = {2, 1, 1, 2, 3, 1, 2, 3, 1, 1 ,2 ,3, 1, 3 ,1};
	      // [1, 2, 4, 3]
	      // [4, 4, 6, 2, 2, 1, 7]
	      int s = solution(ingredient);
	      
	    	  System.out.println(s);
	      
	      
	}
	public static int solution(int[] ingredient) {
		int answer = 0;
        int h = 0;
        for(int i=0; i<ingredient.length; i++) {
            h=0;
            for(int j=1; j<6; j++) {
            	while(ingredient[i]==0) i++;
            	while(j==4) j++;
                if(ingredient[i]==j%4) {
                
                	if(i<ingredient.length-1){
                        i++;
                        h++;
                    }else if(i==ingredient.length-1 && h==3) {
                    	answer++;
                    	return answer;
                    }
                }
            }
            int p = 1;
            if(h==4) {
                answer++;
               while(ingredient[i-4*p]==0) p+=1;
               for(int n=i-4*p; n<i; n++) ingredient[n] = 0;
                i=-1;    
            }else i-=h;
        }
        return answer;
    }
    
}
