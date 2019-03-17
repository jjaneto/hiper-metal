package com.jjaneto.algorithm;

import com.jjaneto.operators.mutation.DuplicationMutation;
import com.jjaneto.operators.mutation.PruneMutation;
import com.jjaneto.solution.impl.DefaultHHSolution;
import org.uma.jmetal.algorithm.impl.AbstractGeneticAlgorithm;
import org.uma.jmetal.problem.Problem;

public abstract class AbstractGeneticGrammaticalEvolutionAlgorithm<S extends DefaultHHSolution,  R>
        extends AbstractGeneticAlgorithm<DefaultHHSolution, R> {

    protected PruneMutation pruneMutationOperator;
    protected DuplicationMutation duplicationMutationOperator;

    /**
     * Constructor
     *
     * @param problem The problem to solve
     */
    public AbstractGeneticGrammaticalEvolutionAlgorithm(Problem<DefaultHHSolution> problem) {
        super(problem);
    }
}
