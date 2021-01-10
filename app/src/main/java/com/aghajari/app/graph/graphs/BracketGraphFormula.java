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

import com.aghajari.app.graph.adapter.PaintedGraphFormula;
import com.aghajari.graphview.AXGraphPointType;
import com.aghajari.graphview.AXGraphView;

public class BracketGraphFormula extends PaintedGraphFormula {

    public BracketGraphFormula(Context context){
        super(context);
        getPointPaint().setColor(getGraphPaint().getColor());
    }

    @Override
    public float function(float x) {
        return (float) Math.ceil(x);
    }

    @Override
    public AXGraphPointType getPointType(float x, float y) {
        float y1 = function(x - graphView.findFormulaX(AXGraphView.EPSILON));
        float y2 = function(x + graphView.findFormulaX(AXGraphView.EPSILON));

        if (y != y2) {
            return AXGraphPointType.EMPTY;
        }

        if (y != y1) {
            return AXGraphPointType.FILL;
        }
        return super.getPointType(x, y);
    }

    @Override
    protected float sensitive() {
        return 0.9f;
    }
}
