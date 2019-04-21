package android.examble.room2;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private List<animal>  animals;
    private LayoutInflater mInflater;
    public MyAdapter(Context context, List<animal> animals) {
        this.animals = animals;
        this.mInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = mInflater.inflate(R.layout.recycleritem, viewGroup, false);
        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapter.ViewHolder viewHolder, int i) {
        String type = animals.get(i).getType();
        viewHolder.myTextView.setText(type);
        String name = animals.get(i).getName();
        viewHolder.myTextView2.setText(name);

    }

    @Override
    public int getItemCount() {
        return animals.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView myTextView;
        TextView myTextView2;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            myTextView = itemView.findViewById(R.id.textview);
            myTextView2 = itemView.findViewById(R.id.textview2);

        }
    }
}
