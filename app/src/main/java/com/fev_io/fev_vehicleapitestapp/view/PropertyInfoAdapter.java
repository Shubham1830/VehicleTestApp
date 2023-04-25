package com.fev_io.fev_vehicleapitestapp.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.fev_io.fev_vehicleapitestapp.R;
import com.fev_io.fev_vehicleapitestapp.model.PropertyInfo;

import java.util.ArrayList;
import java.util.List;

public class PropertyInfoAdapter extends RecyclerView.Adapter<PropertyInfoAdapter.ViewHolder> {
     List<PropertyInfo> mPropertyInfo;

    IClickListner mListener;
    Context mContext;

    public PropertyInfoAdapter(Context mContext, ArrayList<PropertyInfo> mPropertyInfo, IClickListner mListener) {
        this.mContext = mContext;
        this.mPropertyInfo = mPropertyInfo;
        this.mListener = mListener;
    }

    @NonNull
    @Override
    public PropertyInfoAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item,parent,false);
        return new ViewHolder(view, mListener);
    }

    @Override
    public void onBindViewHolder(@NonNull PropertyInfoAdapter.ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        PropertyInfo propertyInfo = mPropertyInfo.get(position);
        holder.mPropertyName.setText(propertyInfo.getmPropertyName());
        /*PropertyInfo mList = mMyList.get(position);
        holder.mPropertyName.setText(mList);*/
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.itemClicked(position);
                Log.d("PropAdapter", "onClick: "+mPropertyInfo.get(position));
            }
        });
    }

    @Override
    public int getItemCount() {
        Log.d("list Size", "getItemCount: "+mPropertyInfo.size());
        return mPropertyInfo.size();


    }

    public int getItemViewType(int position) {

        return position;
    }

    public interface IClickListner{
        void itemClicked(int position);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private final IClickListner mListener;
        public TextView mPropertyName;
        public ViewHolder(@NonNull View itemView, IClickListner mListener) {
            super(itemView);
            this.mListener= mListener;
            mPropertyName = itemView.findViewById(R.id.tv_propertyName_screen1);
        }
    }
}

