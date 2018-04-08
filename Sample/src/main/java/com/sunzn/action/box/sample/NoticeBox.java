package com.sunzn.action.box.sample;

import android.content.Context;
import android.content.DialogInterface;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.sunzn.action.box.library.ActionBox;

/**
 * Created by sunzn on 2017/2/17.
 */

public class NoticeBox extends ActionBox {

    private AudioListener mAudioListener;

    public interface AudioListener {

        void finish();

        void cancel();

        void dismiss();

    }

    public NoticeBox setAudioListener(AudioListener listener) {
        mAudioListener = listener;
        return this;
    }

    public static NoticeBox newBox(Context context) {
        return new NoticeBox(context, R.layout.notice_box);
    }

    public static NoticeBox newBox(Context context, int resource) {
        return new NoticeBox(context, resource);
    }

    private NoticeBox(Context context, int resource) {
        super(context, resource);
    }

    @Override
    public void onActionBoxCreated() {
        findViewById(R.id.btn1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fade();
                MessageBox.newBox(getContext()).setCancelable(true).setCanceledOnTouch(true).create().show();
            }
        });
        findViewById(R.id.btn2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fade();
                fade("a");
            }
        });
    }


    @Override
    public <T> void onShow(T t) {
        super.onShow(t);
    }

    @Override
    public <T> void onFade(T t) {
        super.onFade(t);
        Log.e("sunzn", (String) t);
    }

    @Override
    public void onShow() {
        Toast.makeText(getContext(), "onShow", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onFade() {
        Toast.makeText(getContext(), "onFade", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDismiss(DialogInterface dialog) {
        super.onDismiss(dialog);
        if (mAudioListener != null) mAudioListener.cancel();
    }

}
