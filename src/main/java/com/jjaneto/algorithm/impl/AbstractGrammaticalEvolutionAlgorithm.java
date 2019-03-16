package com.jjaneto.algorithm.impl;

import com.jjaneto.operators.mutation.DuplicationMutation;
import com.jjaneto.operators.mutation.PruneMutation;
import org.uma.jmetal.algorithm.Algorithm;

public abstract class AbstractGrammaticalEvolutionAlgorithm<R> implements Algorithm<R> {

    protected PruneMutation pruneMutationOperator;
    protected DuplicationMutation duplicationMutationOperator;

}
