package com.aghajari.app.graph.multigraphs;

import android.content.Context;
import android.view.Gravity;

import com.aghajari.app.graph.adapter.PaintedGraphMultiFormula;
import com.aghajari.graphview.AXGraphCanvas;

public class HeartGraphFormula extends PaintedGraphMultiFormula {

    public HeartGraphFormula(Context context){
        super(context);

        //applyTransformMove(0,1);
    }

    @Override
    public float[] multiFunction(float x) {
        return new float[] {
                function1(x),
                function2(x)
        };
    }

    public float function1(float x) {
        return (float) Math.sqrt(1 - Math.pow(Math.abs(x) - 1,2));
    }

    public float function2(float x) {
        return (float) (Math.acos(1 - Math.abs(x)) - Math.PI);
    }

    @Override
    protected float sensitive() {
        return super.sensitive()/4f;
    }

}
