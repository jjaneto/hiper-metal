package com.jjaneto.mapper;

import java.util.HashMap;

public abstract class AbstractGrammarMapper<T> {

    public static final String BNF_MATCHER = "((?<=<).+?(?=>))|((?<=\")(?:[\\S]+?.*?|)(?=\")|\\(|\\))";
    public static final int NON_TERMINAL_NODE = 1;
    public static final int TERMINAL_NODE = 2;

    protected Node rootNode;
    protected HashMap<String, Node> nonTerminalNodes;
    protected HashMap<String, Node> terminalNodes;


}
