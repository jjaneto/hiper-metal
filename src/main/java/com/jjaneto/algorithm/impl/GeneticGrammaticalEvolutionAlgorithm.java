package com.jjaneto.algorithm.impl;

import com.jjaneto.algorithm.AbstractGeneticGrammaticalEvolutionAlgorithm;
import com.jjaneto.operators.mutation.DuplicationMutation;
import com.jjaneto.operators.mutation.PruneMutation;
import com.jjaneto.problem.AbstractGrammaticalEvolutionProblem;
import com.jjaneto.solution.impl.DefaultHHSolution;
import org.uma.jmetal.problem.Problem;
import org.uma.jmetal.util.evaluator.SolutionListEvaluator;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GeneticGrammaticalEvolutionAlgorithm
        extends AbstractGeneticGrammaticalEvolutionAlgorithm<DefaultHHSolution, DefaultHHSolution> {

    private int evaluations;
    private int maxEvaluations;
    private int populationSize;
    private final String outputFile;

    private SolutionListEvaluator<DefaultHHSolution> evaluator;
    private AbstractGrammaticalEvolutionProblem problem;

    public GeneticGrammaticalEvolutionAlgorithm(Problem<DefaultHHSolution> problem,
                                                int evaluations,
                                                int maxEvaluations,
                                                int populationSize,
                                                String outputFile,
                                                SolutionListEvaluator<DefaultHHSolution> evaluator,
                                                AbstractGrammaticalEvolutionProblem problem1,
                                                PruneMutation pruneMutation,
                                                DuplicationMutation duplicationMutation) {
        super(problem);
        this.evaluations = evaluations;
        this.maxEvaluations = maxEvaluations;
        this.populationSize = populationSize;
        this.outputFile = outputFile;
        this.evaluator = evaluator;
        this.problem = problem1;

        this.pruneMutationOperator = pruneMutation;
        this.duplicationMutationOperator = duplicationMutation;

        new File(outputFile).getParentFile().mkdirs();
    }

    /**
     * Constructor
     *
     * @param problem The problem to solve
     * @param outputFile
     */
    public GeneticGrammaticalEvolutionAlgorithm(Problem problem, String outputFile) {
        super(problem);
        this.outputFile = outputFile;

        new File(outputFile).getParentFile().mkdirs();
    }

    @Override
    protected void initProgress() {

    }

    @Override
    protected void updateProgress() {

    }

    @Override
    protected boolean isStoppingConditionReached() {
        return (evaluations >= maxEvaluations);
    }

    @Override
    protected List evaluatePopulation(List population) {
        return null;
    }

    @Override
    protected List replacement(List population, List offspringPopulation) {
        return null;
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

    private void printProgress() {
        try (FileWriter writer = new FileWriter(outputFile, true)) {
            writer.write(getResult().getAttribute("FoundIn") + " - " + getResult().getVariables() + "\n");
        } catch (IOException ex) {
            Logger.getLogger(GeneticGrammaticalEvolutionAlgorithm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void run() {

    }
}
