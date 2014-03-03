/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package net.sourceforge.jeval;

import net.sourceforge.jeval.function.math.Perm;

/**
* Factory class to create Evaluator instances.
*
* @author Maximilian Friedersdorff
*/
public class EvaluatorFactory {
    
    /**
* Creates an Evaluator instance using the no-argument constructor.
*
* Additionally preloads the Evaluator instance with additional custom
* functions relevant for PIPE.
*
* @return An Evaluator instance.
*/
    public static Evaluator createEvaluator(){
        Evaluator evaluator = new Evaluator();
        Perm perm = new Perm();
        evaluator.putFunction(perm);
        return evaluator;
    }
    
    /**
* Creates an Evaluator instance using the main constructor.
*
* Additionally preloads the Evaluator instance with additional custom
* functions relevant for PIPE.
*
* @param quoteCharacter - The quote character to use when evaluating expression.
* @param loadMathVariables - Indicates if the standard Math variables should be loaded or not.
* @param loadMathFunctions - Indicates if the standard Math functions should be loaded or not.
* @param loadStringFunctions - Indicates if the standard String functions should be loaded or not.
* @param processNestedFunctions - Indicates if nested function calls should be processed or not.
* @return An Evaluator instance
* @throws java.lang.IllegalArgumentException - Thrown when the quote character is not a valid quote character.
*/
    public static Evaluator createEvaluator(char quoteCharacter,
            boolean loadMathVariables, boolean loadMathFunctions,
            boolean loadStringFunctions, boolean processNestedFunctions)
            throws java.lang.IllegalArgumentException{
        
        Evaluator evaluator = new Evaluator(quoteCharacter, loadMathVariables,
                                            loadMathFunctions, loadStringFunctions,
                                            processNestedFunctions);
        Perm perm = new Perm();
        evaluator.putFunction(perm);
        return evaluator;
    }
            
}