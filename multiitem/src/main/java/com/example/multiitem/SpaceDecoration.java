package com.example.multiitem;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by Roy12 on 2017/11/28.
 */

public class SpaceDecoration extends RecyclerView.ItemDecoration {

    int space;

    public SpaceDecoration(int space) {
        this.space = space;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent,
                               RecyclerView.State state) {
        //if (parent.getChildLayoutPosition(view) == 0) {
            outRect.right = space;
            outRect.bottom = space;
        //}
    }
}

