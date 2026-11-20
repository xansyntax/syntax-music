package com.metrolist.music.ui.component;

import android.app.Activity;
import android.content.Context;
import android.view.Window;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class OriginalLyricsKt$$ExternalSyntheticLambda2 implements Function1 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ Context f$0;
    public final /* synthetic */ boolean f$1;

    public /* synthetic */ OriginalLyricsKt$$ExternalSyntheticLambda2(Context context, boolean z, byte b) {
        this.$r8$classId = b;
        this.f$0 = context;
        this.f$1 = z;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        final Activity activity;
        Window window;
        Window window2;
        byte b = this.$r8$classId;
        boolean z = this.f$1;
        Context context = this.f$0;
        DisposableEffectScope disposableEffectScope = (DisposableEffectScope) obj;
        switch (b) {
            case 0:
                disposableEffectScope.getClass();
                activity = context instanceof Activity ? (Activity) context : null;
                if (z && activity != null && (window = activity.getWindow()) != null) {
                    window.addFlags(128);
                }
                final byte b2 = 0;
                return new DisposableEffectResult() { // from class: com.metrolist.music.ui.component.OriginalLyricsKt$OriginalLyrics$lambda$99$0$$inlined$onDispose$1
                    @Override // androidx.compose.runtime.DisposableEffectResult
                    public final void dispose() {
                        Window window3;
                        Window window4;
                        byte b3 = b2;
                        Activity activity2 = activity;
                        switch (b3) {
                            case 0:
                                if (activity2 != null && (window3 = activity2.getWindow()) != null) {
                                    window3.clearFlags(128);
                                    break;
                                }
                                break;
                            default:
                                if (activity2 != null && (window4 = activity2.getWindow()) != null) {
                                    window4.clearFlags(128);
                                    break;
                                }
                                break;
                        }
                    }
                };
            default:
                disposableEffectScope.getClass();
                activity = context instanceof Activity ? (Activity) context : null;
                if (z && activity != null && (window2 = activity.getWindow()) != null) {
                    window2.addFlags(128);
                }
                final byte b3 = 1;
                return new DisposableEffectResult() { // from class: com.metrolist.music.ui.component.OriginalLyricsKt$OriginalLyrics$lambda$99$0$$inlined$onDispose$1
                    @Override // androidx.compose.runtime.DisposableEffectResult
                    public final void dispose() {
                        Window window3;
                        Window window4;
                        byte b4 = b3;
                        Activity activity2 = activity;
                        switch (b4) {
                            case 0:
                                if (activity2 != null && (window3 = activity2.getWindow()) != null) {
                                    window3.clearFlags(128);
                                    break;
                                }
                                break;
                            default:
                                if (activity2 != null && (window4 = activity2.getWindow()) != null) {
                                    window4.clearFlags(128);
                                    break;
                                }
                                break;
                        }
                    }
                };
        }
    }
}
