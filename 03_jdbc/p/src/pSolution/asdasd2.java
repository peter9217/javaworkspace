package pSolution;

import java.util.ArrayList;
import java.util.List;

public class asdasd2 {
	public static void main(String[] args) {
	      int[] ingredient = {1, 1, 1, 2, 3, 1, 2, 3, 1, 2, 3, 1};
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
        }
        for(int i=0; i<l.size(); i++ ) {
        	int h = 0;
        int f = 0;
        int s = 0;
        int t = 0;
        int fo = 0;
        	for(int j=1; j<6; j++){
        		if(j==4) j++;
        		if(i==l.size()) break;
        		if(l.get(i)==(Integer)(j%4)){
        			h++;
        			System.out.println(i+"번째 j의 값"+l.get(i));
        			
        			if(l.get(i)==1&&h==4){
        				fo=i;
        			}else if(l.get(i)==2) {
        				s=i;
        			}else if(l.get(i)==3) {
        				t=i;
        			}else if(l.get(i)==1) {
        				f=i;
        			}
        			i++;
        		}
        	}
        	System.out.println("h : "+h);
        	if(h==4) {
        		answer++;
        		l.remove(fo);
        		l.remove(t);
        		l.remove(s);
        		l.remove(f);
        		i=-1;
        	}else {
        		i-=h;
        	}
        	for(int q : l) {
        		System.out.print(q);
        	}
        	System.out.println();
        
        	
        	h=0;
        }
        return answer;
    }
}
