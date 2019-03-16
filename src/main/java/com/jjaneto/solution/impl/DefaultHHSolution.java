package com.jjaneto.solution.impl;

import com.jjaneto.problem.AbstractGrammaticalEvolutionProblem;
import org.uma.jmetal.solution.IntegerSolution;
import org.uma.jmetal.solution.Solution;
import org.uma.jmetal.solution.impl.AbstractGenericSolution;

import java.util.Map;

public class DefaultHHSolution extends AbstractGenericSolution<Integer, AbstractGrammaticalEvolutionProblem<?>> implements IntegerSolution {

    public DefaultHHSolution(AbstractGrammaticalEvolutionProblem<?> problem) {
        super(problem);
    }

    @Override
    public Integer getLowerBound(int index) {
        return null;
    }

    @Override
    public Integer getUpperBound(int index) {
        return null;
    }

    @Override
    public String getVariableValueString(int index) {
        return null;
    }

    @Override
    public Solution<Integer> copy() {
        return null;
    }

    @Override
    public Map<Object, Object> getAttributes() {
        return null;
    }
}
