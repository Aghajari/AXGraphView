package com.aghajari.app.graph.multigraphs;

import android.content.Context;
import android.graphics.Color;

import com.aghajari.app.graph.adapter.PaintedGraphMultiFormula;

public class WonderWomanGraphFormula extends PaintedGraphMultiFormula {

    public WonderWomanGraphFormula(Context context){
        super(context);
        getGraphPaint().setColor(Color.parseColor("#FFB302"));
        applyTransformScale(0.4f,0.4f);
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
                function7(x),
                function8(x),
                function9(x),
                function10(x),
                function11(x),
                function12(x),
                function13(x),
                function14(x),
                function15(x),
                function16(x),
                function17(x)
        };
    }

    public float function1(float x) {
        if (isInRange(-5,x,0))
            return Math.abs(x + 2) + 2f;
        else
            return Float.POSITIVE_INFINITY;
    }

    public float function2(float x) {
        if (isInRange(0,x,5))
            return Math.abs(x - 2) + 2f;
        else
            return Float.POSITIVE_INFINITY;
    }

    public float function3(float x) {
        if (isInRange(5,Math.abs(x),10))
            return 5;
        else
            return Float.POSITIVE_INFINITY;
    }

    public float function4(float x) {
        if (isInRange(-2,x,2))
            return - Math.abs(x) + 2f;
        else
            return Float.POSITIVE_INFINITY;
    }

    public float function5(float x) {
        if (isInRange(-5,x,0))
            return Math.abs(x + 2);
        else
            return Float.POSITIVE_INFINITY;
    }

    public float function6(float x) {
        if (isInRange(0,x,5))
            return Math.abs(x - 2);
        else
            return Float.POSITIVE_INFINITY;
    }

    public float function7(float x) {
        if (isInRange(-2,x,2))
            return - Math.abs(x);
        else
            return Float.POSITIVE_INFINITY;
    }

    public float function8(float x) {
        if (isInRange(-5,x,0))
            return Math.abs(x + 2) - 2f;
        else
            return Float.POSITIVE_INFINITY;
    }

    public float function9(float x) {
        if (isInRange(0,x,5))
            return Math.abs(x - 2) - 2f;
        else
            return Float.POSITIVE_INFINITY;
    }

    public float function10(float x) {
        if (isInRange(5,Math.abs(x),9))
            return 3;
        else
            return Float.POSITIVE_INFINITY;
    }

    public float function11(float x) {
        if (isInRange(5,Math.abs(x),8))
            return 1;
        else
            return Float.POSITIVE_INFINITY;
    }

    public float function12(float x) {
        if (isInRange(-5,x,0))
            return Math.abs(x + 2) - 4f;
        else
            return Float.POSITIVE_INFINITY;
    }

    public float function13(float x) {
        if (isInRange(0,x,5))
            return Math.abs(x - 2) - 4f;
        else
            return Float.POSITIVE_INFINITY;
    }

    public float function14(float x) {
        if (isInRange(5,Math.abs(x),7))
            return -1;
        else
            return Float.POSITIVE_INFINITY;
    }

    public float function15(float x) {
        if (x <= -9.1f)
            return (float) (-2.1 * (Math.sqrt(x+10)) + 5);
        else if (x >= 9.1f)
            return (float) (-2.1 * (Math.sqrt(-x+10)) + 5);
        else
            return Float.POSITIVE_INFINITY;
    }

    public float function16(float x) {
        if (x <= -8.1f)
            return (float) (-2.1 * (Math.sqrt(x+9)) + 3);
        else if (x >= 8.1f)
            return (float) (-2.1 * (Math.sqrt(-x+9)) + 3);
        else
            return Float.POSITIVE_INFINITY;
    }

    public float function17(float x) {
        if (x <= -7.1f)
            return (float) (-2.1 * (Math.sqrt(x+8)) + 1);
        else if (x >= 7.1f)
            return (float) (-2.1 * (Math.sqrt(-x+8)) + 1);
        else
            return Float.POSITIVE_INFINITY;
    }

    public boolean isInRange(float c, float x, float b){
        return c<=x && x<=b;
    }
}
