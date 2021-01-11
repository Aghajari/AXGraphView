package com.aghajari.app.graph.multigraphs;

import android.content.Context;

import com.aghajari.app.graph.adapter.PaintedGraphMultiFormula;
import com.aghajari.graphview.AXGraphCanvas;

public class CaptainAmericaGraphFormula extends PaintedGraphMultiFormula {

    public CaptainAmericaGraphFormula(Context context){
        super(context);

        int color = getGraphPaint().getColor();
        getGraphPaint().setColor(getPointPaint().getColor());
        getPointPaint().setColor(color);

        applyTransformScale(0.2f,0.2f);
    }

    @Override
    public float[] multiFunction(float x) {
        return new float[] {
                function1(x),
                function12(x),
                function2(x),
                function3(x),
                function32(x)
        };
    }

    public float function1(float x) {
        if (isInRange(0,x,1.67f) || isInRange(2.62f,x,4.20f))
            return -3*x + 7;
        else
            return Float.POSITIVE_INFINITY;
    }

    public float function12(float x) {
        if (isInRange(-1.67f,x,0) || isInRange(-4.22f,x,-2.62f))
            return 3*x + 7;
        else
            return Float.POSITIVE_INFINITY;
    }

    public float function2(float x) {
        if (isInRange(1.67f,Math.abs(x),6.72f))
            return 2;
        else
            return Float.POSITIVE_INFINITY;
    }

    public float function3(float x) {
        if (isInRange(0,x,4.19f) || isInRange(-6.71f,x,-2.62f))
            return -0.7f * x - 2.7f;
        else
            return Float.POSITIVE_INFINITY;
    }

    public float function32(float x) {
        if (isInRange(-4.21f,x,0) || isInRange(2.62f,x,6.71f))
            return 0.7f * x - 2.7f;
        else
            return Float.POSITIVE_INFINITY;
    }

    @Override
    protected boolean onDraw(AXGraphCanvas canvas) {
        canvas.setApplyFormulaTransform(true);
        canvas.setRadiusFromAxis(true);

        canvas.drawBorderCircle(0,0,16,getPointCircleRadius()/2/canvas.getGraphScale(),getPointPaint());
        canvas.drawBorderCircle(0,0,13,getPointCircleRadius()/2/canvas.getGraphScale(),getPointPaint());
        canvas.drawBorderCircle(0,0,10,getPointCircleRadius()/2/canvas.getGraphScale(),getPointPaint());

        return super.onDraw(canvas);
    }

    public boolean isInRange(float c, float x, float b){
        return c<x && x<b;
    }
}
