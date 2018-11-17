package array;

import java.util.*;

public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix){
	List<Integer> ret= new ArrayList<>();
	
	if(matrix.length==0) return ret;
	
	//Use four bounds to tell if complete
	int rowBegin = 0;
	int rowEnd = matrix.length-1;
	int colBegin = 0;
	int colEnd = matrix[0].length-1;
	
	//At least one element, so use 2 "<="
	while(rowBegin <= rowEnd && colBegin<=colEnd){
	    for(int j=colBegin;j<=colEnd;j++){
		ret.add(matrix[rowBegin][j]);
	    }
	    rowBegin++;
	    
	    for(int j=rowBegin;j<=rowEnd;j++){
		ret.add(matrix[rowBegin][j]);
	    }
	    colEnd--;
	    
	    //move left, check if this is a repeated row
	    if(rowBegin<=rowEnd){
		for(int j=colEnd;j>=colBegin;j--){
		    ret.add(matrix[rowEnd][j]);
		}
	    }
	    rowEnd--;
	    
	    //move up, check if this is a repeated col
	    if(colBegin<=colEnd){
		for(int j=rowEnd;j>=rowBegin;j--){
		    ret.add(matrix[j][colBegin]);
		}
	    }
	    colBegin++;
	}
	
	return ret;
    }
}
