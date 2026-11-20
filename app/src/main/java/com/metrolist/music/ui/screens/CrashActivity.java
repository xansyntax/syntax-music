package com.metrolist.music.ui.screens;

import android.os.Bundle;
import androidx.activity.ComponentActivity;
import androidx.activity.EdgeToEdge;
import androidx.activity.SystemBarStyle;
import androidx.activity.SystemBarStyle$Companion$$ExternalSyntheticLambda0;
import androidx.activity.compose.ComponentActivityKt;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import com.yalantis.ucrop.R;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class CrashActivity extends ComponentActivity {
    public static final /* synthetic */ int $r8$clinit = 0;

    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        byte b = 2;
        byte b2 = 0;
        EdgeToEdge.enable(this, new SystemBarStyle(0, 0, 0, new SystemBarStyle$Companion$$ExternalSyntheticLambda0(b)), new SystemBarStyle(EdgeToEdge.DefaultLightScrim, EdgeToEdge.DefaultDarkScrim, 0, new SystemBarStyle$Companion$$ExternalSyntheticLambda0(b)));
        String stringExtra = getIntent().getStringExtra("crash_log");
        if (stringExtra == null) {
            stringExtra = getString(R.string.crash_no_log);
            stringExtra.getClass();
        }
        ComponentActivityKt.setContent$default(this, new ComposableLambdaImpl(true, -47612908, new CrashActivity$$ExternalSyntheticLambda0(stringExtra, this, b2)));
    }
}
