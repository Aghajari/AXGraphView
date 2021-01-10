package com.aghajari.app.graph.parser;

import android.content.Context;

import com.aghajari.app.graph.adapter.PaintedGraphFormula;
import com.aghajari.app.graph.R;

import java.util.Arrays;

public class GraphFormulaParser extends PaintedGraphFormula {
    FormulaParser parser;

    public GraphFormulaParser(Context context,String formula,Float... customPointsX){
        super(context);
        parser = new FormulaParser(formula);
        if (customPointsX.length>0)
            setCustomFunctionPoints(Arrays.asList(customPointsX));
    }

    public GraphFormulaParser(Context context,String formula,int colorId,Float... customPointsX){
        super(context);
        getGraphPaint().setColor(context.getResources().getColor(colorId));
        getPointPaint().setColor(context.getResources().getColor(R.color.colorPrimaryDark));
        parser = new FormulaParser(formula);
        if (customPointsX.length>0)
            setCustomFunctionPoints(Arrays.asList(customPointsX));
    }

    @Override
    public float function(float x) {
        try {
            return (float) parser.parse(x);
        }catch (Exception ignore){
            return Float.POSITIVE_INFINITY; // undefined
        }
    }

}
