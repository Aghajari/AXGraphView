package com.aghajari.app.graph.multigraphs;

import android.content.Context;
import android.graphics.Color;

import com.aghajari.app.graph.adapter.PaintedGraphMultiFormula;

public class BatmanGraphFormula extends PaintedGraphMultiFormula {

    public BatmanGraphFormula(Context context){
        super(context);
        applyTransformScale(0.5f,0.5f);
        getGraphPaint().setColor(Color.BLACK);
    }

    @Override
    public float[] multiFunction(float x) {
        return new float[] {
                function1(x),
                function2(x),
                function3(x),
                function4(x),
                function5(x),
                function6(x),
                function7(x)
        };
    }

    public float function1(float x) {
        if (Math.abs(x) > 3)
            return (float) (3 * Math.sqrt(-Math.pow(x/7,2) + 1));
        else
            return Float.POSITIVE_INFINITY;
    }

    public float function2(float x) {
        if (Math.abs(x) > 4)
            return (float) (-3 * Math.sqrt(-Math.pow(x/7,2) + 1));
        else
            return Float.POSITIVE_INFINITY;
    }

    public float function3(float x) {
        return (float) (Math.abs(x/2) - Math.pow(x,2) * ((3*Math.sqrt(33) - 7)/112)
                        + Math.sqrt(1 - Math.pow(Math.abs(Math.abs(x) - 2)-1,2)) - 3);
    }

    public float function4(float x) {
        if (Math.abs(x) > 0.75 && Math.abs(x) < 1)
            return (float) (9 - 8*Math.abs(x));
        else
            return Float.POSITIVE_INFINITY;
    }

    public float function5(float x) {
        if (Math.abs(x) > 0.5 && Math.abs(x) < 0.75)
            return (float) (3*Math.abs(x) + 0.75);
        else
            return Float.POSITIVE_INFINITY;
    }

    public float function6(float x) {
        if (Math.abs(x) < 0.5)
            return 2.25f;
        else
            return Float.POSITIVE_INFINITY;
    }

    public float function7(float x) {
        if (Math.abs(x) > 1)
            return (float) (1.5 - 0.5 * Math.abs(x) - ((6*Math.sqrt(10))/14)
                                * (Math.sqrt(3-Math.pow(x,2)+2*Math.abs(x))-2));
        else
            return Float.POSITIVE_INFINITY;
    }

    @Override
    protected float sensitive() {
        return super.sensitive()/4f;
    }
}
