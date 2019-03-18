package com.jjaneto.problem.impl;

import com.jjaneto.problem.AbstractGrammaticalEvolutionProblem;
import com.jjaneto.solution.impl.DefaultHHSolution;
import org.uma.jmetal.problem.Problem;
import org.uma.jmetal.solution.Solution;

import java.util.List;

public class SMPSOGenerationProblem<S extends Solution<?>>
        extends AbstractGrammaticalEvolutionProblem { //TODO: Implement the generic type

    Problem<S> problem;

    private int maxAlgorithmEvaluation;

    public SMPSOGenerationProblem(Problem<S> problem,
                                  int minInitialCodons,
                                  int maxInitialCodons,
                                  int maxAlgorithmEvaluation,
                                  String grammarFile) {
        super(null, minInitialCodons, maxInitialCodons, grammarFile); //TODO: Fix null mapper

        this.problem = problem;
        this.maxAlgorithmEvaluation = maxAlgorithmEvaluation;
        setName("SMPSO generator class");
    }

    @Override
    public void evaluateAll(List parents, List offspring) {

    }

    @Override
    public void evaluate(DefaultHHSolution solution) {

    }
}
