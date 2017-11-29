package com.example.multiitem;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by Roy12 on 2017/11/28.
 * 用于生成 item 之间的间隔
 */

public class SpaceDecoration extends RecyclerView.ItemDecoration {

    private int space;

    public SpaceDecoration(int space) {
        this.space = space;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent,
                               RecyclerView.State state) {
        // 间隔只需要计算 item 相对左上的距离
        outRect.top = space;
        outRect.left = space;
    }
}

