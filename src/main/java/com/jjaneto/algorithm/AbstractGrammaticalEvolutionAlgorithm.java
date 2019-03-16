package com.jjaneto.algorithm;

import com.jjaneto.operators.mutation.DuplicationMutation;
import com.jjaneto.operators.mutation.PruneMutation;
import com.jjaneto.solution.impl.DefaultHHSolution;
import org.uma.jmetal.algorithm.Algorithm;

import java.util.Comparator;

public abstract class AbstractGrammaticalEvolutionAlgorithm<R> implements Algorithm<R> {

    protected PruneMutation pruneMutationOperator;
    protected DuplicationMutation duplicationMutationOperator;

    protected Comparator<DefaultHHSolution> comparator;

}
