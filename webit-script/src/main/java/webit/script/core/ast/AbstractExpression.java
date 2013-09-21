// Copyright (c) 2013, Webit Team. All Rights Reserved.
package webit.script.core.ast;

/**
 *
 * @author Zqq
 */
public abstract class AbstractExpression implements Expression {

    protected final int line;
    protected final int column;

    public AbstractExpression(int line, int column) {
        this.line = line;
        this.column = column;
    }

    public int getLine() {
        return line;
    }

    public int getColumn() {
        return column;
    }
}
