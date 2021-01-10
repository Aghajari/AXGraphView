package com.aghajari.app.graph.adapter;

import android.content.Context;

import com.aghajari.graphview.AXGraphOptions;

public class TrigonometryGraphOptions extends AXGraphOptions {

    final static String pi = "π";
    final static int pi_d = 2; // π/2

    public TrigonometryGraphOptions(Context context) {
        super(context);
        xDividerInterval = (float) Math.PI / pi_d;
    }

    @Override
    protected String getTextForXAxis(float x, int i) {
        float e = 1/calculateLastScaleEffect();
        int a = Math.abs(i);
        int b = pi_d;
        if (e<1) a /= e; else b *= e;

        while (a % 2 == 0 && b % 2 == 0){
            a /= 2;
            b /= 2;
        }

        String da = a!=1 ? String.valueOf(a) : "";
        String db = b!=1 ? "/"+b : "";
        String n = i<0 ? "-" : "";
        return n + da + pi + db;
    }

    @Override
    protected String getTextForYAxis(float y, int index) {
        return super.getTextForYAxis(y, index);
    }

}
