package com.slide;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

public class FragmentView2 extends Fragment {
    MediaPlayer mp;
    ImageButton play;


	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View myView = inflater.inflate(R.layout.about2, container, false);

        play = (ImageButton) myView.findViewById(R.id.imageButton);

        play.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                try {
                    mp.stop();
                    mp = MediaPlayer.create(getActivity(), R.raw.cats);
                    mp.start();
                } catch (NullPointerException e) {
                    mp.stop();

                }

            }
        });

        return myView;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mp = MediaPlayer.create(getActivity(), R.raw.cats);

        PhoneStateListener phoneStateListener = new PhoneStateListener() {
            @Override
            public void onCallStateChanged(int state, String incomingNumber) {
                if (state == TelephonyManager.CALL_STATE_RINGING) {

                    if(mp!=null){//check mp


                        if(mp.isPlaying()){

                            mp.pause();
                        }
                    }

                } else if(state == TelephonyManager.CALL_STATE_IDLE) {
                    mp.start();

                } else if(state == TelephonyManager.CALL_STATE_OFFHOOK) {

                    if(mp!=null){//check mp


                        if(mp.isPlaying()){

                            mp.pause();
                        }
                    }
                }
                super.onCallStateChanged(state, incomingNumber);
            }
        };//end PhoneStateListener


    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        // TODO Auto-generated method stub
        super.onHiddenChanged(hidden);
        try {

            mp.stop();
        }
        catch(NullPointerException e)
        {
            e.printStackTrace();
        }
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);

        // Make sure that we are currently visible
        if (this.isVisible()) {
            // If we are becoming invisible, then...
            if (!isVisibleToUser) {

                mp.stop();
                mp.reset();

            }
            else {
                mp.stop();
                mp = MediaPlayer.create(getActivity(), R.raw.cats);
                mp.start();
            }
        }
    }

    @Override
    public void onDestroy() {
        if(null!=mp){
            mp.release();
        }
        super.onDestroy();

    }
    @Override
    public void onPause() {
        super.onPause();
        mp.stop();
        mp.reset();
    }

    @Override
    public void onStop() {
        super.onStop();
        mp.stop();
        mp.reset();
    }




}




