package com.aghajari.app.graph.multigraphs;

import android.content.Context;
import android.graphics.Color;

import com.aghajari.app.graph.adapter.PaintedGraphMultiFormula;
import com.aghajari.graphview.AXGraphCanvas;

public class FlashGraphFormula extends PaintedGraphMultiFormula {

    public FlashGraphFormula(Context context){
        super(context);
        applyTransformScale(0.5f,0.5f);

        getPointPaint().setColor(Color.BLACK);
        getGraphPaint().setColor(Color.parseColor("#FF8C00"));
    }

    @Override
    public float[] multiFunction(float x) {
        return new float[] {
                function1(x),
                function2(x),
                function3(x),
                function4(x),
                function5(x),
                function6(x)
        };
    }

    public float function1(float x) {
        if (isInRange(-3.35f,x,3.5f))
            return 0.86f * x + 2f;
        else
            return Float.POSITIVE_INFINITY;
    }

    public float function2(float x) {
        if (isInRange(0.3f,x,3.5f))
            return 1.53f * x - 0.36f;
        else
            return Float.POSITIVE_INFINITY;
    }

    public float function3(float x) {
        if (isInRange(0.3f,x,3.1f))
            return 0.036f * x+ 0.09f;
        else
            return Float.POSITIVE_INFINITY;
    }

    public float function4(float x) {
        if (isInRange(-4.9f,x,3.1f))
            return 0.71f * x - 2f;
        else
            return Float.POSITIVE_INFINITY;
    }

    public float function5(float x) {
        if (isInRange(-4.9f,x,-1.1f))
            return 1.24f * x + 0.56f;
        else
            return Float.POSITIVE_INFINITY;
    }

    public float function6(float x) {
        if (isInRange(-3.35f,x,-1.1f))
            return 0.043f * x - 0.75f;
        else
            return Float.POSITIVE_INFINITY;
    }


    @Override
    protected boolean onDraw(AXGraphCanvas canvas) {
        canvas.setApplyFormulaTransform(true);
        canvas.setRadiusFromAxis(true);

        canvas.drawBorderCircle(0,0,4,getPointCircleRadius()/2/canvas.getGraphScale(),getPointPaint());
        canvas.drawBorderCircle(0,0,(float) Math.sqrt(22.4),getPointCircleRadius()/2/canvas.getGraphScale(),getPointPaint());
        return super.onDraw(canvas);
    }

    public boolean isInRange(float c, float x, float b){
        return c<=x && x<=b;
    }
}
