/*
 * Copyright (C) 2021 - Amir Hossein Aghajari
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */


package com.aghajari.app.graph.graphs;

import android.content.Context;
import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.view.Gravity;

import com.aghajari.app.graph.adapter.PaintedGraphFormula;
import com.aghajari.graphview.AXGraphCanvas;
import com.aghajari.graphview.AXGraphPointType;
import com.aghajari.app.graph.R;

public class CircleGraphFormula extends PaintedGraphFormula {

    private float r;
    private int angle;
    Paint paint;

    public CircleGraphFormula(Context context,float r,int angle){
        super(context);
        this.r = r;
        this.angle = angle;
        paint = new Paint();

        getGraphPaint().setStyle(Paint.Style.STROKE);
        getPointPaint().setColor(getGraphPaint().getColor());
        setPointCircleRadius(getPointCircleRadius()*1.2f);

        addCustomPoint(0,r);
        addCustomPoint(0,-r);
        addCustomPoint(r,0);
        addCustomPoint(-r,0);
    }

    @Override
    protected boolean onDraw(AXGraphCanvas canvas) {
        canvas.setRadiusFromAxis(true);
        canvas.drawCircle(0,0,r, getGraphPaint());

        if (angle!=0) {
            float angleR = (float) Math.toRadians(angle);
            String text = angle+"°";

            paint.setColor(Color.parseColor("#03DAC5"));
            paint.setStrokeWidth(getGraphPaint().getStrokeWidth());
            final float x = (float) Math.cos(angleR) * r;
            final float y = (float) Math.sin(angleR) * r;

            //paint.setStyle(Paint.Style.STROKE);
            float r2 = r/5;
            paint.setStyle(Paint.Style.STROKE);
            canvas.drawArc(-r2,-r2,r2,r2,-angle,angle,true,paint);

            paint.setStyle(Paint.Style.FILL);
            paint.setTextSize(canvas.findGraphX(r)/10);
            canvas.drawText(text,r2,r2/1.5f, Gravity.CENTER_VERTICAL|Gravity.LEFT,paint);

            canvas.drawLine(0,0,x,0,paint);
            paint.setPathEffect(new DashPathEffect(new float[] {20f/canvas.getGraphScale(),20f/canvas.getGraphScale()}, 0f));
            canvas.drawLine(x,y,x,0,paint);
            canvas.drawLine(0,y,x,y,paint);
            paint.setPathEffect(null);

            paint.setColor(canvas.getGraphView().getContext().getResources().getColor(R.color.colorPrimary));
            canvas.drawLine(0,0,x,y,paint);

            int savedColor = getPointPaint().getColor();
            getPointPaint().setColor(paint.getColor());
            drawPoint(canvas,x,y, AXGraphPointType.CUSTOM);
            getPointPaint().setColor(savedColor);
        }
        return true; //skip drawing function
    }

    @Override
    public float function(float x) {
        return Float.POSITIVE_INFINITY; //undefined
    }

    @Override
    public boolean isInDomain(float x) {
        return false;
    }
}

