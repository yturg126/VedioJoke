package com.xin.ppjoke.ui.my;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.xin.libcommon.utils.StatusBar;
import com.xin.ppjoke.R;

public class UserBehaviorListActivity extends AppCompatActivity {
    public static final int BEHAVIOR_FAVORITE = 0;
    public static final int BEHAVIOR_HISTORY = 1;

    public static final String KEY_BEHAVIOR = "behavior";

    public static void startBehaviorListActivity(Context context, int behavior) {
        Intent intent = new Intent(context, UserBehaviorListActivity.class);
        intent.putExtra(KEY_BEHAVIOR, behavior);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        StatusBar.fitSystemBar(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout_list);

        UserBehaviorListFragment fragment = UserBehaviorListFragment.newInstance(getIntent().getIntExtra(KEY_BEHAVIOR, BEHAVIOR_FAVORITE));
        getSupportFragmentManager().beginTransaction().add(R.id.contanier, fragment, "userBehavior").commit();
    }
}
