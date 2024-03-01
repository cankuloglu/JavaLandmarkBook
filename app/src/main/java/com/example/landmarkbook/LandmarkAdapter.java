package com.example.landmarkbook;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.example.landmarkbook.databinding.RecyclerRowBinding;

import java.util.ArrayList;

public class LandmarkAdapter extends RecyclerView.Adapter<LandmarkAdapter.LandmarkHolder>{

    ArrayList<Landmark> landmarkArrayList;

    public LandmarkAdapter(ArrayList<Landmark> landmarkArrayList) {
        this.landmarkArrayList = landmarkArrayList;
    }

    public class LandmarkHolder extends RecyclerView.ViewHolder {

        private RecyclerRowBinding binding;
        public LandmarkHolder(RecyclerRowBinding binding){
            super(binding.getRoot());
            this.binding = binding;
        }

    }

    @NonNull
    @Override
    public LandmarkAdapter.LandmarkHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        RecyclerRowBinding recyclerRowBinding = RecyclerRowBinding.inflate(LayoutInflater.from(viewGroup.getContext()));
        return new LandmarkHolder(recyclerRowBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull LandmarkAdapter.LandmarkHolder holder, int i) {
        holder.binding.recyclerViewTextView.setText(landmarkArrayList.get(i).name);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(holder.itemView.getContext(),DetailsActivity.class);
                //intent.putExtra("landmark",landmarkArrayList.get(i));
                Singleton singleton = Singleton.getInstance();
                singleton.setSentLandmark(landmarkArrayList.get(i));
                holder.itemView.getContext().startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return landmarkArrayList.size();
    }
}
