package com.github.killermech.flashcardengine;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.Window;

public class MenuActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
        return new MenuFragment();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
    }
}
