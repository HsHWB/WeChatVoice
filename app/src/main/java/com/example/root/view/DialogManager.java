package com.example.root.view;

import android.app.Dialog;
import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.root.wechatvoice.R;

/**
 * Created by root on 15-8-7.
 */
public class DialogManager {

    private Dialog mDialog;
    private ImageView mIcon;
    private ImageView mVoice;

    private TextView mLable;

    private Context mContext;

    public DialogManager(Context mContext) {
        this.mContext = mContext;
    }

    public void showRecordingDialog(){
        mDialog = new Dialog(mContext, R.style.Theme_AudioDialog);
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View view = inflater.inflate(R.layout.dialog_recorder, null);
        mDialog.setContentView(view);

        mIcon = (ImageView) view.findViewById(R.id.recorder_dialog_iv1);
        mVoice = (ImageView) view.findViewById(R.id.recorder_dialog_iv2);
        mLable = (TextView) view.findViewById(R.id.recorder_dialog_tx);
        mDialog.show();

    }

    /**
     * 动态切换过程
     */
    public void recording(){

        if (mDialog != null && mDialog.isShowing()){
            mIcon.setVisibility(View.VISIBLE);
            mVoice.setVisibility(View.VISIBLE);
            mLable.setVisibility(View.VISIBLE);

            mIcon.setImageResource(R.mipmap.recorder);
            mLable.setText(mContext.getResources().getText(R.string.tx_dialog));
        }

    }

    public void wantToCancle(){

        if (mDialog != null && mDialog.isShowing()){
            mIcon.setVisibility(View.VISIBLE);
            mVoice.setVisibility(View.GONE);
            mLable.setVisibility(View.VISIBLE);

            mIcon.setImageResource(R.mipmap.cancel);
            mLable.setText(mContext.getResources().getText(R.string.recorder_cancle));
        }

    }

    public void tooShort(){

        if (mDialog != null && mDialog.isShowing()){
            mIcon.setVisibility(View.VISIBLE);
            mVoice.setVisibility(View.GONE);
            mLable.setVisibility(View.VISIBLE);

            mIcon.setImageResource(R.mipmap.voice_to_short);
            mLable.setText(mContext.getResources().getText(R.string.recorder_too_short));
        }

    }

    /**
     * 销毁Dialog
     */
    public void dimissDialog(){

        if (mDialog != null && mDialog.isShowing()){
            mDialog.dismiss();
            mDialog = null;
        }

    }

    /**
     * 通过level去更新voice上的图片
     * @param level 1-->7
     */
    public void updateVoiceLevel(int level){

        if (mDialog != null && mDialog.isShowing()){
            mIcon.setVisibility(View.VISIBLE);
            mVoice.setVisibility(View.VISIBLE);
            mLable.setVisibility(View.VISIBLE);

            /**
             * 通过方法名找资源
             */
            int resId = mContext.getResources().getIdentifier("v"+level, "mipmap",
                    mContext.getPackageName());
            mVoice.setImageResource(resId);
        }

    }
}
