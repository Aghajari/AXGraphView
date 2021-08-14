package com.aghajari.app.graph;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.aghajari.graphview.AXGraphView;
import com.aghajari.app.graph.adapter.AdapterData;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AdapterData.init(getApplicationContext());
        setContentView(R.layout.activity_main);

        RecyclerView rv = findViewById(R.id.rv);
        rv.setAdapter(new Adapter());
    }

    public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder>{

        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            if (viewType == -1) {
                AppCompatTextView textView = new AppCompatTextView(parent.getContext());
                textView.setGravity(Gravity.CENTER);
                textView.setTypeface(Typeface.DEFAULT_BOLD);
                textView.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
                textView.setTextSize(20);
                textView.setText(R.string.author);
                textView.setLayoutParams(new FrameLayout.LayoutParams(-1, (int) (56 * getResources().getDisplayMetrics().density)));
                return new ViewHolder(textView);
            } else {
                return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_item, parent, false));
            }
        }

        @Override
        public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
            holder.bind(position);
        }

        @Override
        public int getItemCount() {
            return AdapterData.list.size() + 1;
        }

        @Override
        public int getItemViewType(int position) {
            return position == (getItemCount()-1) ? -1 : 1;
        }

        public class ViewHolder extends RecyclerView.ViewHolder{
            AXGraphView view;
            TextView name;

            public ViewHolder(@NonNull View itemView) {
                super(itemView);
                view = itemView.findViewById(R.id.graph_view);
                name = itemView.findViewById(R.id.graph_name);
            }

            public ViewHolder(@NonNull TextView itemView) {
                super(itemView);
            }

            public void bind(final int index){
                if (view == null) return;
                AdapterData.GraphInfo info = AdapterData.list.get(index);
                name.setText(info.getName());
                view.clearFormulas();
                view.addFormulas(info.getFormulas());
                view.setGraphOptions(info.getMainActivityOptions());

                view.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        GraphActivity.start(MainActivity.this, (View) view.getParent().getParent(),index);
                    }
                });
            }
        }
    }
}