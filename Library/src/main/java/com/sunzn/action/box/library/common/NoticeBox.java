package com.sunzn.action.box.library.common;

import android.content.Context;

import com.sunzn.action.box.library.ActionBox;

public class NoticeBox extends ActionBox {

    private int time;

    public static NoticeBox newBox(Context context, int resource) {
        return new NoticeBox(context, resource);
    }

    public NoticeBox(Context context, int resource) {
        super(context, resource);
    }

    public NoticeBox setTime(int time) {
        this.time = time;
        return this;
    }

    @Override
    public void onActionBoxCreated() {

    }

    @Override
    public void onShow() {
        postDelayFade(time);
    }

}
