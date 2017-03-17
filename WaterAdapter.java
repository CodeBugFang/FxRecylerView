package com.fjh.fxrecylerview;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Android on 2016/12/9.
 */

public class WaterAdapter extends RecyclerView.Adapter<IViewHolder>{
    private LayoutInflater mInflater;
    private Context mContext;
    private List<String> mDatas;
    private List<Integer> mHeights;
    public interface OnItemClickListener{
        void onItemClick(View view, int position);
        void onItemLongClick(View view, int position);
    }
    private SimpleAdapter.OnItemClickListener mOnItemClickListener;

    public void setOnItemClickListener(SimpleAdapter.OnItemClickListener listener){
        this.mOnItemClickListener=listener;
    }


    public WaterAdapter(Context context, List<String> datas){
        this.mContext=context;
        this.mDatas=datas;
        mInflater=LayoutInflater.from(context);
        mHeights=new ArrayList<Integer>();
        for (int i=0;i<mDatas.size();i++){
            mHeights.add((int)(100+Math.random()*300));
        }
    }

    @Override
    public IViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=mInflater.inflate(R.layout.item_single_textview,parent,false);
        IViewHolder viewHolder=new IViewHolder(view);
        return viewHolder;
    }


    @Override
    public void onBindViewHolder(final IViewHolder holder, final int position) {
        ViewGroup.LayoutParams lp=holder.itemView.getLayoutParams();
        lp.height=mHeights.get(position);
        holder.itemView.setLayoutParams(lp);
        holder.tv.setText(mDatas.get(position));
        if (mOnItemClickListener!=null){
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (mOnItemClickListener!=null){
                        mOnItemClickListener.onItemClick(holder.itemView,position);
                    }
                }
            });
            holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View view) {
                    mOnItemClickListener.onItemLongClick(holder.itemView,position);
                    return false;
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return mDatas.size();
    }


}
class IViewHolder extends RecyclerView.ViewHolder{
    TextView tv;
    public IViewHolder(View arg0){
        super(arg0);
        tv=(TextView) arg0.findViewById(R.id.id_tv);
    }
}
