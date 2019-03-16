package com.jjaneto.algorithm.impl;

import com.jjaneto.algorithm.AbstractGrammaticalEvolutionAlgorithm;
import com.jjaneto.problem.AbstractGrammaticalEvolutionProblem;
import com.jjaneto.solution.impl.DefaultHHSolution;
import org.uma.jmetal.util.evaluator.SolutionListEvaluator;

public class GeneticGrammaticalEvolutionAlgorithm
        extends AbstractGrammaticalEvolutionAlgorithm<DefaultHHSolution> {

    private int evaluations;
    private int maxEvaluations;
    private int populationSize;

    private SolutionListEvaluator<DefaultHHSolution> evaluator;
    private AbstractGrammaticalEvolutionProblem problem;

    @Override
    public void run() {

    }

    @Override
    public DefaultHHSolution getResult() {
        return null;
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public String getDescription() {
        return null;
    }
}
