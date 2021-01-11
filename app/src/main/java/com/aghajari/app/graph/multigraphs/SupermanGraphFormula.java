package com.aghajari.app.graph.multigraphs;

import android.content.Context;

import com.aghajari.app.graph.adapter.PaintedGraphMultiFormula;
import com.aghajari.graphview.AXGraphCanvas;

public class SupermanGraphFormula extends PaintedGraphMultiFormula {

    public SupermanGraphFormula(Context context){
        super(context);
        applyTransformScale(0.2f,0.2f);
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
                function17(x),
                function18(x),
                function19(x),
                function20(x),
        };
    }

    //y=-|x|+21 {-18<x<-12,12<x<18}
    public float function1(float x) {
        if (12 < Math.abs(x) && Math.abs(x) < 18)
            return - Math.abs(x) + 21f;
        else
            return Float.POSITIVE_INFINITY;
    }

    // y=9 {-12<x<12}
    public float function2(float x) {
        if (12 > Math.abs(x))
            return 9f;
        else
            return Float.POSITIVE_INFINITY;
    }

    //y=|x|-15 {-18<x<18}
    public float function3(float x) {
        if (18 > Math.abs(x))
            return Math.abs(x) - 15f;
        else
            return Float.POSITIVE_INFINITY;
    }

    //y=7 {-11<x<-8 -1<x<0 , 7<x<9}
    public float function4(float x) {
        if (isInRange(-11,x,-8) || isInRange(-1,x,0) || isInRange(7,x,9))
            return 7f;
        else
            return Float.POSITIVE_INFINITY;
    }

    //y=-|x|+18 {-15<x<-11, 12<x<15}
    public float function5(float x) {
        if (isInRange(-15,x,-11) || isInRange(12,x,15))
            return -Math.abs(x) + 18f;
        else
            return Float.POSITIVE_INFINITY;
    }

    //y=|x|-12 {-15<x<-13, -9<x<-6, -4<x<4, 11<x<15}
    public float function6(float x) {
        if (isInRange(-15,x,-13) || isInRange(-9,x,-6) || isInRange(-4,x,4) || isInRange(11,x,15))
            return Math.abs(x) - 12f;
        else
            return Float.POSITIVE_INFINITY;
    }

    //y=-((1/3)x)^{2}+7 {0<x<6}
    public float function7(float x) {
        if (isInRange(0,x,6))
            return (float) (- Math.pow(x/3,2) + 7f);
        else
            return Float.POSITIVE_INFINITY;
    }

    //y=3 {6<x<12}
    public float function8(float x) {
        if (isInRange(6,x,12))
            return 3f;
        else
            return Float.POSITIVE_INFINITY;
    }

    //y=sqrt{x+5}+5 {x<-1}
    public float function9(float x) {
        if (x<-1)
            return (float) (Math.sqrt(x+5) + 5);
        else
            return Float.POSITIVE_INFINITY;
    }

    //y=(x/4)^{2}-9 {-4<x<4}
    public float function10(float x) {
        if (isInRange(-4,x,4))
            return (float) (Math.pow(x/4,2) -9);
        else
            return Float.POSITIVE_INFINITY;
    }

    //y= 2*sqrt{-(x-8)}+5 {7<x<8}
    public float function11(float x) {
        if (isInRange(7,x,8))
            return (float) (2 * Math.sqrt(-x+8) + 5);
        else
            return Float.POSITIVE_INFINITY;
    }

    //y=2x-11 {8<x<9}
    public float function12(float x) {
        if (isInRange(8,x,9))
            return (float) (2 * x - 11);
        else
            return Float.POSITIVE_INFINITY;
    }

    //y=6 sqrt{(x+13)/5}+1\ {x<-8}
    public float function13(float x) {
        if (x<-8)
            return (float) (6 * Math.sqrt((x+13)/5) + 1);
        else
            return Float.POSITIVE_INFINITY;
    }

    //y=-((x+3)/3)^{2}-5 {-6<x<0}
    public float function14(float x) {
        if (isInRange(-6,x,0))
            return (float) (- Math.pow((x+3)/3,2) -5);
        else
            return Float.POSITIVE_INFINITY;
    }

    //y=((x+1)/8)^{2}-4 {-9<x<-1}
    public float function15(float x) {
        if (isInRange(-9,x,-1))
            return (float) (Math.pow((x+1)/8,2) -4);
        else
            return Float.POSITIVE_INFINITY;
    }

    //y=-4 {-1<x<0}
    public float function16(float x) {
        if (isInRange(-1,x,0))
            return -4f;
        else
            return Float.POSITIVE_INFINITY;
    }

    //y=sqrt{-(x-6)/6} -5 {0<x}
    public float function17(float x) {
        if (x>0)
            return (float) (Math.sqrt((-x+6)/6) -5);
        else
            return Float.POSITIVE_INFINITY;
    }

    //y=-sqrt{-(x-6)/6} -5 {0<x}
    public float function18(float x) {
        if (x>0)
            return (float) (-Math.sqrt((-x+6)/6) -5);
        else
            return Float.POSITIVE_INFINITY;
    }

    //y= (-3/5 * sqrt{5(x+5)}) +5 {x<0}
    public float function19(float x) {
        if (x<0)
            return (float) ( -(Math.sqrt(5*x + 25) * 3)/5 + 5);
        else
            return Float.POSITIVE_INFINITY;
    }

    //y= ( 3/5 * sqrt{-2.27* (x-11)}) -1 {x>0}
    public float function20(float x) {
        if (x>0)
            return (float) ((Math.sqrt(2.27*(11-x))*3)/5 -1);
        else
            return Float.POSITIVE_INFINITY;
    }

    @Override
    protected boolean onDraw(AXGraphCanvas canvas) {
        canvas.setApplyFormulaTransform(true);
        //x=12 {3<y<6} (CUSTOM DRAW NEEDED)
        canvas.drawLine(12,3,12,6);
        return super.onDraw(canvas);
    }

    public boolean isInRange(float c, float x, float b){
        return c<x && x<b;
    }
}
