package com.aghajari.app.graph;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityOptionsCompat;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;

import com.aghajari.graphview.AXGraphView;
import com.aghajari.app.graph.adapter.AdapterData;

public class GraphActivity extends AppCompatActivity {
    AXGraphView view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graph);

        int graphIndex = getIntent().getIntExtra("graph",0);
        AdapterData.GraphInfo info = AdapterData.list.get(graphIndex);
        getSupportActionBar().setTitle(info.getName());

        view = findViewById(R.id.graph_view);
        view.addFormulas(info.getFormulas());
        view.setGraphOptions(info.getGraphActivityOptions());
        view.setBackgroundColor(Color.WHITE);
    }

    public static void start(Context context, View view, int index) {
        Intent starter = new Intent(context, GraphActivity.class);
        starter.putExtra("graph",index);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            ActivityOptionsCompat options = ActivityOptionsCompat.
                    makeSceneTransitionAnimation((Activity) context, view, "graph");
            context.startActivity(starter, options.toBundle());
        }else {
            context.startActivity(starter);
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        view.resetScroll(false);
    }
}