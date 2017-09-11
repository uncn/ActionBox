package com.sunzn.action.box.library;

import android.app.Dialog;
import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

/**
 * Created by sunzn on 2017/2/16.
 */

public abstract class ActionBox {

    private int mResource;
    private View mRootView;
    private Context mContext;
    private Dialog mActionBox;
    private boolean mCancelable = true;
    private boolean mCanceledOnTouch = true;

    public ActionBox(Context context, int resource) {
        this.mContext = context;
        this.mResource = resource;
    }

    public ActionBox create() {
        mRootView = LayoutInflater.from(mContext).inflate(mResource, null);
        mActionBox = new Dialog(mContext, R.style.Theme_ActionBox);
        mActionBox.setCanceledOnTouchOutside(getCanceledOnTouch());
        mActionBox.setCancelable(getCancelable());
        mActionBox.setContentView(mRootView);
        Window window = mActionBox.getWindow();
        if (window != null) {
            window.setGravity(Gravity.BOTTOM);
            WindowManager.LayoutParams params = window.getAttributes();
            params.x = 0;
            params.y = 0;
            params.width = ScreenUtils.getScreenWidth(mContext);
            window.setAttributes(params);
        }
        onActionBoxCreated();
        return this;
    }

    public void onShow() {
        // TODO
    }

    public void onFade() {
        // TODO
    }

    public <T> void onShow(T t) {
        // TODO
    }

    public <T> void onFade(T t) {
        // TODO
    }

    public void show() {
        if (mActionBox != null && !mActionBox.isShowing()) {
            mActionBox.show();
            onShow();
        }
    }

    public void fade() {
        if (mActionBox != null && mActionBox.isShowing()) {
            mActionBox.dismiss();
            onFade();
        }
    }

    public <T> void show(T t) {
        if (mActionBox != null && !mActionBox.isShowing()) {
            mActionBox.show();
            onShow(t);
        }
    }

    public <T> void fade(T t) {
        if (mActionBox != null && mActionBox.isShowing()) {
            mActionBox.dismiss();
            onFade(t);
        }
    }

    public void postDelayShow(long millis) {
        if (mActionBox != null && !mActionBox.isShowing() && mRootView != null) {
            mRootView.postDelayed(new Runnable() {
                @Override
                public void run() {
                    show();
                }
            }, millis);
        }
    }

    public void postDelayFade(long millis) {
        if (mActionBox != null && mActionBox.isShowing() && mRootView != null) {
            mRootView.postDelayed(new Runnable() {
                @Override
                public void run() {
                    fade();
                }
            }, millis);
        }
    }

    public <T> void postDelayShow(long millis, final T t) {
        if (mActionBox != null && !mActionBox.isShowing() && mRootView != null) {
            mRootView.postDelayed(new Runnable() {
                @Override
                public void run() {
                    show(t);
                }
            }, millis);
        }
    }

    public <T> void postDelayFade(long millis, final T t) {
        if (mActionBox != null && mActionBox.isShowing() && mRootView != null) {
            mRootView.postDelayed(new Runnable() {
                @Override
                public void run() {
                    fade(t);
                }
            }, millis);
        }
    }

    public abstract void onActionBoxCreated();

    private boolean getCancelable() {
        return this.mCancelable;
    }

    private boolean getCanceledOnTouch() {
        return this.mCanceledOnTouch;
    }

    public ActionBox setCancelable(boolean cancel) {
        this.mCancelable = cancel;
        return this;
    }

    public ActionBox setCanceledOnTouch(boolean cancel) {
        this.mCanceledOnTouch = cancel;
        return this;
    }

    public Context getContext() {
        return mActionBox.getContext();
    }

    protected View findViewById(int id) {
        return mRootView == null ? null : mRootView.findViewById(id);
    }

}
