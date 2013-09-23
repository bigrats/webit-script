// Copyright (c) 2013, Webit Team. All Rights Reserved.
package webit.script.core.ast.statments;

import webit.script.core.ast.Expression;
import webit.script.core.ast.Statment;
import webit.script.core.ast.StatmentPart;
import webit.script.util.StatmentUtil;

/**
 *
 * @author Zqq
 */
public final class ForMapStatmentPart extends StatmentPart {

    private int keyIndex;
    private int valueIndex;
    private int iterIndex;
    private Expression mapExpr;
    private BlockStatment bodyStatment;
    private Statment elseStatment;
    private String label;

    public ForMapStatmentPart(int keyIndex, int valueIndex, int iterIndex, Expression mapExpr, int line, int column) {
        super(line, column);
        this.keyIndex = keyIndex;
        this.valueIndex = valueIndex;
        this.iterIndex = iterIndex;
        this.mapExpr = mapExpr;
    }
    

    public ForMapStatmentPart setLabel(String label) {
        this.label = label;
        return this;
    }

//    public ForMapStatmentPart setMapExpr(Expression mapExpr) {
//        this.mapExpr = mapExpr;
//        return this;
//    }

    public ForMapStatmentPart setBodyStatment(BlockStatment bodyStatment) {
        this.bodyStatment = bodyStatment.optimize();
        return this;
    }

    public ForMapStatmentPart setElseStatment(Statment elseStatment) {
        this.elseStatment = StatmentUtil.optimize(elseStatment);
        return this;
    }
    
    public Statment pop(){
        return StatmentUtil.optimize(new ForMapStatment(keyIndex, valueIndex, iterIndex, mapExpr, bodyStatment, elseStatment, label, line, column));
    }
}
