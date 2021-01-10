package com.aghajari.app.graph.adapter;

import android.content.Context;

import com.aghajari.graphview.AXGraphFormula;
import com.aghajari.app.graph.R;

public abstract class PaintedGraphFormula extends AXGraphFormula {

    public PaintedGraphFormula(Context context){
        getGraphPaint().setColor(context.getResources().getColor(R.color.colorAccent));
        getPointPaint().setColor(context.getResources().getColor(R.color.colorPrimary));
    }
}
