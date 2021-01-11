package com.aghajari.app.graph.adapter;

import android.content.Context;
import android.graphics.Color;

import com.aghajari.app.graph.graphs.AbsoluteValueGraphFormula;
import com.aghajari.app.graph.graphs.BracketGraphFormula;
import com.aghajari.app.graph.graphs.CircleGraphFormula;
import com.aghajari.app.graph.graphs.CubicRootGraphFormula;
import com.aghajari.app.graph.graphs.CubicRootX2GraphFormula;
import com.aghajari.app.graph.multigraphs.BatmanGraphFormula;
import com.aghajari.app.graph.multigraphs.CaptainAmericaGraphFormula;
import com.aghajari.app.graph.multigraphs.FlashGraphFormula;
import com.aghajari.app.graph.multigraphs.HeartGraphFormula;
import com.aghajari.app.graph.graphs.CustomGraphFormula;
import com.aghajari.app.graph.multigraphs.SupermanGraphFormula;
import com.aghajari.app.graph.multigraphs.WonderWomanGraphFormula;
import com.aghajari.app.graph.parser.GraphFormulaParser;
import com.aghajari.graphview.AXGraphFormula;
import com.aghajari.graphview.AXGraphOptions;
import com.aghajari.app.graph.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AdapterData {
    public static List<GraphInfo> list;

    public static void init(Context context){
        list = new ArrayList<>();

        list.add(new GraphInfo("Quadratic (x^2)",
                createOptions(context,true),
                createOptions(context,false),
                new GraphFormulaParser(context,"(x)^2",0f)));

        list.add(new GraphInfo("Cubic (x^3)",
                createOptions(context,true),
                createOptions(context,false),
                new GraphFormulaParser(context,"(x)^3",0f)));

        list.add(new GraphInfo("x^3 And x^2",
                createOptions(context,true),
                createOptions(context,false),
                new GraphFormulaParser(context,"(x)^3"),
                new GraphFormulaParser(context,"(x)^2", R.color.colorPrimary,0f,1f)));

        list.add(new GraphInfo("Homographic (1/x)",
                createCustomOptions(context,true),
                createCustomOptions(context,false),
                new GraphFormulaParser(context,"1/(x)")));

        list.add(new GraphInfo("Square (√x)",
                createOptions(context,true),
                createOptions(context,false),
                new GraphFormulaParser(context,"sqrt(x)",0f)));

        list.add(new GraphInfo("Cubic Root (3√x)",
                createOptions(context,true),
                createOptions(context,false),
                new CubicRootGraphFormula(context)));

        list.add(new GraphInfo("Cubic Root x^2 (3√(x^2))",
                createOptions(context,true),
                createOptions(context,false),
                new CubicRootX2GraphFormula(context)));

        list.add(new GraphInfo("Bracket ([x])",
                createOptions(context,true),
                createOptions(context,false),
                new BracketGraphFormula(context)));

        list.add(new GraphInfo("Absolute value (|x|)",
                createOptions(context,true),
                createOptions(context,false),
                new AbsoluteValueGraphFormula(context)));

        list.add(new GraphInfo("Custom (|x+1| - |x-1|)",
                createCustomOptions(context,true),
                createCustomOptions(context,false),
                new CustomGraphFormula(context)));

        list.add(new GraphInfo("Exponential (2^x)",
                createOptions(context,true),
                createOptions(context,false),
                new GraphFormulaParser(context,"2^(x)")));

        list.add(new GraphInfo("Logarithm (log(x))",
                createOptions(context,true),
                createOptions(context,false),
                new GraphFormulaParser(context,"log(x)")));

        list.add(new GraphInfo("Sine (sin(x))",
                createTrigonometryOptions(context,true),
                createTrigonometryOptions(context,false),
                new GraphFormulaParser(context,"sin(x)")));

        list.add(new GraphInfo("Cosine (cos(x))",
                createTrigonometryOptions(context,true),
                createTrigonometryOptions(context,false),
                new GraphFormulaParser(context,"cos(x)")));

        list.add(new GraphInfo("sin(x) And cos(x)",
                createTrigonometryOptions(context,true),
                createTrigonometryOptions(context,false),
                new GraphFormulaParser(context,"sin(x)"),
                new GraphFormulaParser(context,"cos(x)", R.color.colorPrimary)));

        list.add(new GraphInfo("Tangent (tan(x))",
                createTrigonometryOptions(context,true),
                createTrigonometryOptions(context,false),
                new GraphFormulaParser(context,"tan(x)")));

        list.add(new GraphInfo("Cotangent (cot(x))",
                createTrigonometryOptions(context,true),
                createTrigonometryOptions(context,false),
                new GraphFormulaParser(context,"cot(x)")));

        list.add(new GraphInfo("tan(x) And cot(x)",
                createTrigonometryOptions(context,true),
                createTrigonometryOptions(context,false),
                new GraphFormulaParser(context,"tan(x)"),
                new GraphFormulaParser(context,"cot(x)",R.color.colorPrimary)));

        list.add(new GraphInfo("Custom Draw",
                createCircleOptions(context,true),
                createCircleOptions(context,false),
                new CircleGraphFormula(context,1, 60)));

        list.add(new GraphInfo("Heart",
                createMultiGraphOptions(context,true),
                createMultiGraphOptions(context,false),
                new HeartGraphFormula(context)));

        list.add(new GraphInfo("The Flash",
                createMultiGraphOptions(context,true),
                createMultiGraphOptions(context,false),
                new FlashGraphFormula(context)));

        list.add(new GraphInfo("Captain America",
                createMultiGraphOptions(context,true),
                createMultiGraphOptions(context,false),
                new CaptainAmericaGraphFormula(context)));

        list.add(new GraphInfo("Batman",
                createMultiGraphOptions(context,true),
                createMultiGraphOptions(context,false),
                new BatmanGraphFormula(context)));

        list.add(new GraphInfo("Wonder Woman",
                createMultiGraphOptions(context,true),
                createMultiGraphOptions(context,false),
                new WonderWomanGraphFormula(context)));

        list.add(new GraphInfo("Superman",
                createMultiGraphOptions(context,true),
                createMultiGraphOptions(context,false),
                new SupermanGraphFormula(context)));
    }

    private static AXGraphOptions createOptions(Context context, boolean mainActivity){
        if (!mainActivity) return new AXGraphOptions(context);
        AXGraphOptions options = new AXGraphOptions(context);
        options.scrollEnabled = false;
        options.xDividerIntervalInPx = 150;
        options.yDividerIntervalInPx = 150;
        return options;
    }

    private static AXGraphOptions createCustomOptions(Context context, boolean mainActivity){
        if (!mainActivity) return new AXGraphOptions(context);
        AXGraphOptions options = new AXGraphOptions(context);
        options.scrollEnabled = false;
        options.xDividerIntervalInPx = 80;
        options.yDividerIntervalInPx = 80;

        return options;
    }

    private static AXGraphOptions createCircleOptions(Context context, boolean mainActivity){
        AXGraphOptions options = new AXGraphOptions(context);
        options.scrollEnabled = false;
        options.xDividerIntervalInPx = 150;
        options.yDividerIntervalInPx = 150;

        if (!mainActivity) {
            options.xDividerInterval = 0.5f;
            options.yDividerInterval = 0.5f;
        }
        return options;
    }

    private static AXGraphOptions createTrigonometryOptions(Context context, boolean mainActivity){
        TrigonometryGraphOptions options = new TrigonometryGraphOptions(context);

        options.scrollEnabled = false;
        options.xDividerIntervalInPx = 100 * options.xDividerInterval;
        options.yDividerInterval = 1;
        options.yDividerIntervalInPx = 100;

        /**if (!mainActivity){
            options.xLength *= 2;
            options.yLength *= 2;
        }*/
        return options;
    }

    private static AXGraphOptions createMultiGraphOptions(Context context, boolean mainActivity){
        AXGraphOptions options = new AXGraphOptions(context);
        options.scrollEnabled = false;
        options.xDividerIntervalInPx = 150;
        options.yDividerIntervalInPx = 150;
        options.maxZoom = 2.25f;
        options.minZoom = 0.25f;
        options.axisPaint.setColor(Color.GRAY);

        if (mainActivity) {
            options.xDividerInterval = 2f;
            options.yDividerInterval = 2f;
        }
        return options;
    }

    public static class GraphInfo {
        final List<AXGraphFormula> formulas;
        final AXGraphOptions options;
        final AXGraphOptions mainOptions;
        final String name;

        public GraphInfo(String name, AXGraphOptions options, AXGraphOptions mainOptions, AXGraphFormula... graphFormulas){
            formulas = new ArrayList<>(Arrays.asList(graphFormulas));
            this.name = name;
            this.options = options;
            this.mainOptions = mainOptions;
        }

        public List<AXGraphFormula> getFormulas() {
            return formulas;
        }

        public String getName() {
            return name;
        }

        public AXGraphOptions getMainActivityOptions() {
            options.scrollEnabled = false;
            return options;
        }

        public AXGraphOptions getGraphActivityOptions() {
            mainOptions.scrollEnabled = true;
            return mainOptions;
        }
    }
}
