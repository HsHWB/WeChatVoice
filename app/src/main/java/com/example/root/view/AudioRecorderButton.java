package com.example.root.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.Button;

import com.example.root.wechatvoice.R;

import java.util.ResourceBundle;

/**
 * Created by root on 15-8-7.
 */
public class AudioRecorderButton extends Button {

    private static final int STATE_NORMAL = 1;
    private static final int STATE_RECORDING = 2;
    private static final int STATE_CANCLE = 3;
    private static final int DISTANCE_Y_CANCLE = 50;
    private boolean isRecording = false;
    private int mCurState;


    public AudioRecorderButton(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public AudioRecorderButton(Context context) {

        super(context, null);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        int action = event.getAction();
        int x = (int) event.getX();
        int y = (int) event.getY();

        switch (action){
            case MotionEvent.ACTION_DOWN:
                isRecording = true;
                changeState(STATE_RECORDING);
                break;
            case MotionEvent.ACTION_MOVE:
                //已经在录音
                if (isRecording){
                    //根据x，y坐标，判断是否想要取消
                    if (wantToCancle(x,y)){
                        changeState(STATE_CANCLE);
                    }else{
                        changeState(STATE_RECORDING);
                    }
                }
                break;
            case MotionEvent.ACTION_UP:
                if (mCurState == STATE_RECORDING){
                    
                }else if (mCurState == STATE_CANCLE){
                    
                }
                reset();
                break;
        }

        return super.onTouchEvent(event);
    }

    /**
     * 恢复标志位
     */
    private void reset() {
        isRecording = false;
        changeState(STATE_NORMAL);
    }

    private boolean wantToCancle(int x, int y) {

        if (x < 0 || x >getWidth()){
            return true;
        }

        if (y < -DISTANCE_Y_CANCLE || y > getHeight() +DISTANCE_Y_CANCLE){
            return true;
        }

        return false;
    }

    /**
     *改变按钮的文本和背景色
     * @param flag
     */
    private void changeState(int flag) {
        if (mCurState != flag){
            switch (flag){
                case STATE_NORMAL:
                    setBackgroundResource(R.drawable.button_recorder_normal);
                    setText(R.string.recorder_normal);
                    break;
                case STATE_RECORDING:
                    setBackgroundResource(R.drawable.button_recorder_recording);
                    setText(R.string.recorder_recordering);
                    /**
                     * Dialog也显示和按钮文本一样的提示
                     */
                    if (isRecording){
                        //TODO Dialog.recording();
                    }
                    break;
                case STATE_CANCLE:
                    setBackgroundResource(R.drawable.button_recorder_wantcancle);
                    setText(R.string.recorder_cancle);
                    /**
                     * Dialog也显示和按钮文本一样的提示
                     */
                    if (isRecording){
                        //TODO Dialog.cancle();
                    }
                    break;
            }
        }
    }

}
