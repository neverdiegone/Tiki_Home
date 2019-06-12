package com.ndinh.tikihome;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ItemVH> {

    private LayoutInflater mInflater;
    private List<String> mData;

    public ItemAdapter(Context context){
        mInflater = LayoutInflater.from(context);
        mData = new ArrayList<>();
    }

    public void setData(List<String> data){
        mData.clear();
        mData.addAll(data);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ItemVH onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = mInflater.inflate(R.layout.view_item, viewGroup, false);
        return new ItemVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemVH itemVH, int i) {
        itemVH.tvTitle.setText(getFinalKeyword(mData.get(i)));
        itemVH.tvTitle.setBackgroundColor(Color.parseColor(getRandomColor(i)));

    }

    private String getRandomColor(int position){
        return Constants.COLORS[position % 8].getValue();
    }



    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class ItemVH extends RecyclerView.ViewHolder{
        private TextView tvTitle;
        public ItemVH(@NonNull View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tv_title);
        }
    }

    private String getFinalKeyword(String words) {
        String result = words;
        String[] arrKeyword = words.split(" ");
        if (arrKeyword.length > 1) {
            int i;
            int mid = arrKeyword.length / 2;
            String head = "";
            String tail = "";
            for (i = 0; i < mid; i++)
                head += arrKeyword[i] + " ";
            for (i = mid; i < arrKeyword.length; i++)
                tail += arrKeyword[i] + " ";
            result = head + "\n" + tail;
        }
        return result;
    }

}
