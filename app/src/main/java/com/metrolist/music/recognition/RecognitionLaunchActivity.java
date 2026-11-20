package com.metrolist.music.recognition;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import androidx.core.app.NavUtils;
import com.metrolist.music.MainActivity;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class RecognitionLaunchActivity extends Activity {
    public final void handleRecognitionLaunch() {
        if (NavUtils.checkSelfPermission(this, "android.permission.RECORD_AUDIO") != 0) {
            Intent intent = new Intent(this, (Class<?>) MainActivity.class);
            intent.setAction("com.metrolist.music.action.RECOGNITION");
            intent.putExtra("auto_start_recognition", true);
            intent.setFlags(805306368);
            startActivity(intent);
        } else if (NavUtils.checkSelfPermission(this, "android.permission.RECORD_AUDIO") == 0) {
            startForegroundService(new Intent(this, (Class<?>) RecognitionForegroundService.class));
        }
        finish();
    }

    @Override // android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        handleRecognitionLaunch();
    }

    @Override // android.app.Activity
    public final void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        handleRecognitionLaunch();
    }
}
