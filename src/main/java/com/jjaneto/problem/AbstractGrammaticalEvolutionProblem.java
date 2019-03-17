package com.jjaneto.problem;

import com.jjaneto.mapper.AbstractGrammarMapper;
import com.jjaneto.solution.impl.DefaultHHSolution;
import org.uma.jmetal.problem.impl.AbstractGenericProblem;

import java.util.List;

public abstract class AbstractGrammaticalEvolutionProblem<MapperReturn> extends AbstractGenericProblem<DefaultHHSolution> {

    private AbstractGrammarMapper<MapperReturn> mapper;
    private int minInitialCodons;
    private int maxInitialCodons;
    private String grammarFile;

    public AbstractGrammaticalEvolutionProblem(AbstractGrammarMapper<MapperReturn> mapper,
                                               int minInitialCodons,
                                               int maxInitialCodons,
                                               String grammarFile) {
        this.mapper = mapper;
        this.minInitialCodons = minInitialCodons;
        this.maxInitialCodons = maxInitialCodons;
        this.grammarFile = grammarFile;
    }

    @Override
    public DefaultHHSolution createSolution() {
        return null;
    }

    public abstract void evaluateAll(List<DefaultHHSolution> parents, List<DefaultHHSolution> offspring);

    // <editor-fold desc="Getters and Setters">
    public AbstractGrammarMapper<MapperReturn> getMapper() {
        return mapper;
    }

    public AbstractGrammaticalEvolutionProblem<MapperReturn> setMapper(AbstractGrammarMapper<MapperReturn> mapper) {
        this.mapper = mapper;
        return this;
    }

    public int getMinInitialCodons() {
        return minInitialCodons;
    }

    public AbstractGrammaticalEvolutionProblem<MapperReturn> setMinInitialCodons(int minInitialCodons) {
        this.minInitialCodons = minInitialCodons;
        return this;
    }

    public int getMaxInitialCodons() {
        return maxInitialCodons;
    }

    public AbstractGrammaticalEvolutionProblem<MapperReturn> setMaxInitialCodons(int maxInitialCodons) {
        this.maxInitialCodons = maxInitialCodons;
        return this;
    }

    public String getGrammarFile() {
        return grammarFile;
    }

    public AbstractGrammaticalEvolutionProblem<MapperReturn> setGrammarFile(String grammarFile) {
        this.grammarFile = grammarFile;
        return this;
    }
    //</editor-fold>
}
