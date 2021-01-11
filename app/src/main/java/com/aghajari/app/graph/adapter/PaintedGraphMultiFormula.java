package com.aghajari.app.graph.adapter;

import android.content.Context;

import com.aghajari.app.graph.R;
import com.aghajari.graphview.AXGraphFormula;
import com.aghajari.graphview.AXGraphMultiFormula;

public abstract class PaintedGraphMultiFormula extends AXGraphMultiFormula {

    public PaintedGraphMultiFormula(Context context){
        super();
        getGraphPaint().setColor(context.getResources().getColor(R.color.colorAccent));
        getPointPaint().setColor(context.getResources().getColor(R.color.colorPrimary));
    }
}
