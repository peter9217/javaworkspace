package pSolution;

import java.util.ArrayList;
import java.util.List;

public class asdasd3 {
	public static void main(String[] args) {
	      int[] ingredient = {1, 1, 2, 1, 2, 3, 1, 3, 1, 2, 3, 1};
//	      int[] ingredient = {1, 2, 3, 1};
	      // [1, 2, 4, 3]
	      // [4, 4, 6, 2, 2, 1, 7]
	      int s = solution(ingredient);
	    	  System.out.print(s);
	}
	public static int solution(int[] ingredient) {
        int answer = 0;
        
        List<Integer> l= new ArrayList(ingredient.length);
        for(int n=0; n<ingredient.length; n++) {
        	l.add(ingredient[n]);
        	System.out.print(l.get(n));
        }
        
        for(int i=0; i<l.size(); i++ ) {
        	int h = 0;
        	if(l.size()<i+3){
        		for(int g : l) {
        		System.out.print(g);
        		}
        		System.out.println();
        		return answer;
        	}
        	System.out.println(i);
        	if((l.get(i))==1) {
        		if((l.get(i+1))==2) {
        			if((l.get(i+2)) ==3) {
        				if((l.get(i+3)) ==1) {
        					answer+=1;
        					
        					for(int n=0; n<4; n++) {
        						l.remove(i);
        					}
        					System.out.println(answer + "삭제 후" + i);
        					for(int g : l) {
        						System.out.print(g);
        					}
        					System.out.println();
        					
        					if(i<=1) {
        						i=-1;
        						System.out.println("i -1 설정");
        					}else {
        						i=i-4;
        						System.out.println("i i-2 설정");
        					}
        				}else i+=2;
        			}else i+=1;
        		}
        	}
        	System.out.println(i +"ddaaa");
        	
        }
        return answer;
    }
}
