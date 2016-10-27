package com.rance.beautypapa.adapter;

import android.content.Context;
import android.view.ViewGroup;

import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;
import com.rance.beautypapa.adapter.holder.NewsViewHolder;
import com.rance.beautypapa.adapter.holder.VideoViewHolder;
import com.rance.beautypapa.model.NewsEntity;
import com.rance.beautypapa.model.VideoEntity;

/**
 * 作者：Rance on 2016/10/25 15:19
 * 邮箱：rance935@163.com
 */
public class NewsRecyclerAdapter extends RecyclerArrayAdapter<NewsEntity.StoriesBean> {

    public NewsRecyclerAdapter(Context context) {
        super(context);
    }

    @Override
    public BaseViewHolder OnCreateViewHolder(ViewGroup parent, int viewType) {
        return new NewsViewHolder(parent);
    }
}
