package com.juliao.adryel.meuslivros;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by adryel.juliao on 21/09/2017.
 */

public class LivroAdapterRecycler extends RecyclerView.Adapter{
    Context context;
    List<Livro> livroList;


    public LivroAdapterRecycler(Context context, List<Livro> livroList) {
        this.context = context;
        this.livroList = livroList;
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {




        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
