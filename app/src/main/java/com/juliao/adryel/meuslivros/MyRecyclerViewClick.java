package com.juliao.adryel.meuslivros;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
 


/**
 * Created by adryel.juliao on 21/09/2017.
 */

public class MyRecyclerViewClick implements RecyclerView.OnItemTouchListener {


    GestureDetector myGestureDetector;

    public MyRecyclerViewClick(Context context, final RecyclerView view, final MyClickListener listener){


        myGestureDetector = new GestureDetector(context, new GestureDetector.SimpleOnGestureListener() {
           @Override
            public boolean onSingleTapUp(MotionEvent motionEvent) {
                super.onSingleTapUp(motionEvent);
                View viewClicada = view.findChildViewUnder(motionEvent.getX(), motionEvent.getY());
               if (viewClicada != null && listener != null){
                  listener.clickCurto(viewClicada, view.getChildAdapterPosition(viewClicada));
               }
               return false;
            }



            @Override
            public void onLongPress(MotionEvent motionEvent) {
                View viewClicada = view.findChildViewUnder(motionEvent.getX(), motionEvent.getY());
                if(viewClicada != null && listener != null){
                    listener.clickLongo(viewClicada, view.getChildAdapterPosition(viewClicada));
                }
            }

        });




    }




    @Override
    public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {
        myGestureDetector.onTouchEvent(e);
        return false;
    }

    @Override
    public void onTouchEvent(RecyclerView rv, MotionEvent e) {

    }

    @Override
    public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

    }


    public interface MyClickListener{
        void clickCurto(View v, int position);
        void clickLongo(View v, int position);

    }





}
