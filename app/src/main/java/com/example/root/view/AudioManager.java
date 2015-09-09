package com.example.root.view;

import android.media.MediaRecorder;

/**
 * Created by root on 15-9-1.
 */
public class AudioManager {

    /**
     *
     */
    private MediaRecorder mMediaRecorder;
    /**
     *文件夹名称
     */
    private String mDir;
    /**
     *保存路径，回传给button，button回传给activity
     */
    private String mCureentFilePath;
    /**
     * 使用单例
     */
    private static AudioManager mInstance;

    private AudioManager(){}

    /**
     *回调准备
     *显示录音框，显示计时
     */
    public interface AudioStateListener{
        void wellPrepared();
    }

    public AudioStateListener mListener;

    /**
     *回调准备完毕
     * @param audioStateListener
     */
    public void setOnAudioStateListener(AudioStateListener audioStateListener){
        mListener = audioStateListener;
    }

    public static AudioManager getInstance(){

        if (mInstance == null){
            /**
             * 同步
             */
            synchronized (AudioManager.class){
                if (mInstance == null ){
                    mInstance = new AudioManager();
                }
            }
        }

        return mInstance;
    }

}
