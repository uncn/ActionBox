package com.sunzn.action.box.sample;

import android.content.Context;
import android.view.View;

import com.sunzn.action.box.library.ActionBox;

/**
 * Created by sunzn on 2017/2/17.
 */

public class MessageBox extends ActionBox {

    public static MessageBox newBox(Context context) {
        return new MessageBox(context, R.layout.message_box);
    }

    public MessageBox(Context context, int resource) {
        super(context, resource);
    }

    @Override
    public void onActionBoxCreated() {
        findViewById(R.id.btn1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
                NoticeBox.newBox(getContext()).setCancelable(true).setCanceledOnTouch(true).create().show();

            }
        });
        findViewById(R.id.btn2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });
    }

}
