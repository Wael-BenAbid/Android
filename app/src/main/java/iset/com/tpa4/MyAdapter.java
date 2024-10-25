package iset.com.tpa4;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private ArrayList<String> myDataSet;
    private OnItemClickListener onItemClickListener;

    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    public MyAdapter(ArrayList<String> myDataSet, OnItemClickListener listener) {
        this.myDataSet = myDataSet;
        this.onItemClickListener = listener;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView vText;
        private OnItemClickListener listener;

        public ViewHolder(View itemView, final OnItemClickListener listener) {
            super(itemView);

            vText = itemView.findViewById(R.id.word);
            this.listener = listener;
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    if (position != RecyclerView.NO_POSITION) {
                        listener.onItemClick(position);
                    }
                }

            });
        }
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.ligne, parent, false);
        return new ViewHolder(view, onItemClickListener);
    }
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String current = myDataSet.get(position);
        holder.vText.setText(current);
    }

    @Override
    public int getItemCount() {
        return myDataSet.size();
    }
}
