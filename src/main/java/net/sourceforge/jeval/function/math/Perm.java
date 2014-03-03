/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package net.sourceforge.jeval.function.math;

import net.sourceforge.jeval.Evaluator;
import net.sourceforge.jeval.function.Function;
import net.sourceforge.jeval.function.FunctionConstants;
import net.sourceforge.jeval.function.FunctionException;
import net.sourceforge.jeval.function.FunctionResult;
import org.apache.commons.math3.util.ArithmeticUtils;

/**
*
* @author max
*/
public class Perm implements Function{
    
    private final String NAME = "perm";
    
    
    public FunctionResult execute(Evaluator evalutaor, String arguments) throws FunctionException{
        String[] argumentArray = arguments.split(",");
        
        // Arguments must be in the form n,k
        if(argumentArray.length != 2){
            throw new FunctionException("Incorrect Number of Arguments to " + NAME + " function.");
        }
        
        Double doubleN = Double.parseDouble(argumentArray[0]);
        Double doubleK = Double.parseDouble(argumentArray[1]);

        int n = doubleN.intValue();
        int k = doubleK.intValue();
        
        double perm = 0.0;
        
        // n must be larger than k, otherwise permutation is not possible.
        // To prevent crashing of program, 0 will be returned.
        if(n < k){
           perm = 0.0;
        }else {
            double logN = ArithmeticUtils.factorialLog(n);
            double logKN = ArithmeticUtils.factorialLog(n-k);
            perm = Math.exp(logN-logKN);
        }
        
        String result = Double.toString(perm);
        return new FunctionResult(result, FunctionConstants.FUNCTION_RESULT_TYPE_NUMERIC);
    }
    
    public String getName(){
        return NAME;
    }
    
}

