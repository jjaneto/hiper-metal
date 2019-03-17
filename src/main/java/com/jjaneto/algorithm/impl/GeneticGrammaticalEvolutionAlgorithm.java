package com.jjaneto.algorithm.impl;

import com.jjaneto.algorithm.AbstractGeneticGrammaticalEvolutionAlgorithm;
import com.jjaneto.operators.mutation.DuplicationMutation;
import com.jjaneto.operators.mutation.PruneMutation;
import com.jjaneto.problem.AbstractGrammaticalEvolutionProblem;
import com.jjaneto.solution.impl.DefaultHHSolution;
import org.uma.jmetal.problem.Problem;
import org.uma.jmetal.util.comparator.ObjectiveComparator;
import org.uma.jmetal.util.evaluator.SolutionListEvaluator;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GeneticGrammaticalEvolutionAlgorithm
        extends AbstractGeneticGrammaticalEvolutionAlgorithm<DefaultHHSolution, DefaultHHSolution> {

    private int evaluations;
    private int maxEvaluations;
    private int populationSize;
    private final String outputFile;

    private AbstractGrammaticalEvolutionProblem problem;
    private Comparator<DefaultHHSolution> comparator;
    private SolutionListEvaluator<DefaultHHSolution> evaluator;

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

        comparator = new ObjectiveComparator<>(0);

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
    protected List<DefaultHHSolution> createInitialPopulation() {
        List<DefaultHHSolution> population = new ArrayList<>(populationSize);
        for (int i = 0; i < populationSize; i++) {
            DefaultHHSolution newIndividual = problem.createSolution();
            population.add(newIndividual);
            newIndividual.setAttribute("FoundIn", 1);
        }
        return population;
    }

    @Override
    protected void initProgress() {
        printProgress();
        evaluations = populationSize;
    }

    @Override
    protected void updateProgress() {
        printProgress();
        evaluations += populationSize;
    }

    @Override
    protected boolean isStoppingConditionReached() {
        return (evaluations >= maxEvaluations);
    }

    @Override
    protected List<DefaultHHSolution> evaluatePopulation(List<DefaultHHSolution> population) {
        population = evaluator.evaluate(population, problem);

        return population;
    }

    @Override
    protected List<DefaultHHSolution> replacement(List<DefaultHHSolution> population, List<DefaultHHSolution> offspringPopulation) {
        List<DefaultHHSolution> jointPopulation = new ArrayList<>();
        jointPopulation.addAll(population);
        jointPopulation.addAll(offspringPopulation);
        Collections.sort(jointPopulation, comparator);

        return jointPopulation.subList(0, populationSize);
    }

    @Override
    public DefaultHHSolution getResult() {
        Collections.sort(getPopulation(), comparator);
        return getPopulation().get(0);
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
        List<DefaultHHSolution> offspringPopulation;
        List<DefaultHHSolution> matingPopulation;

        setPopulation(createInitialPopulation());

        //Execute the algorithm
        evaluatePopulation(getPopulation());
        //Calculate the Hypervolume (fitness)
        problem.evaluateAll(getPopulation(), Collections.emptyList());

        initProgress();
        while (!isStoppingConditionReached()) {
            matingPopulation = selection(getPopulation());
            offspringPopulation = reproduction(matingPopulation);

            //Execute the algorithm
            evaluatePopulation(offspringPopulation);
            //Calculate the Hypervolume (fitness)
            problem.evaluateAll(getPopulation(), offspringPopulation);

            setPopulation(replacement(getPopulation(), offspringPopulation));
            updateProgress();
        }
    }
}
