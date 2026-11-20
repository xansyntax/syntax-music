package com.yalantis.ucrop;

import android.os.Bundle;
import android.view.View;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.WindowInsetsCompat;
import androidx.media3.common.Player;
import androidx.media3.common.util.Consumer;
import androidx.media3.common.util.ListenerSet;
import androidx.media3.exoplayer.analytics.AnalyticsListener;
import androidx.media3.session.MediaControllerImplBase;
import androidx.media3.session.MediaControllerStub;
import androidx.media3.session.PlayerWrapper;
import androidx.media3.session.SessionCommand;
import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class UCropActivity$$ExternalSyntheticLambda1 implements ListenerSet.Event, MediaControllerStub.ControllerTask, Consumer, OnApplyWindowInsetsListener {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ int f$0;

    public /* synthetic */ UCropActivity$$ExternalSyntheticLambda1(int i, SessionCommand sessionCommand, Bundle bundle, Bundle bundle2) {
        this.$r8$classId = (byte) 5;
        this.f$0 = i;
    }

    @Override // androidx.media3.common.util.Consumer
    public void accept(Object obj) {
        byte b = this.$r8$classId;
        int i = this.f$0;
        PlayerWrapper playerWrapper = (PlayerWrapper) obj;
        switch (b) {
            case 6:
                playerWrapper.decreaseDeviceVolume(i);
                break;
            case 7:
                playerWrapper.increaseDeviceVolume(i);
                break;
            case 8:
                playerWrapper.setRepeatMode(i);
                break;
            default:
                playerWrapper.setDeviceVolume(i);
                break;
        }
    }

    @Override // androidx.media3.common.util.ListenerSet.Event
    public void invoke(Object obj) {
        byte b = this.$r8$classId;
        int i = this.f$0;
        switch (b) {
            case 1:
                ((Player.Listener) obj).onRepeatModeChanged(i);
                break;
            case 2:
                ((Player.Listener) obj).onAudioSessionIdChanged(i);
                break;
            case 3:
                ((AnalyticsListener) obj).onDroppedVideoFrames(i);
                break;
            default:
                ((Player.Listener) obj).onRepeatModeChanged(i);
                break;
        }
    }

    @Override // androidx.core.view.OnApplyWindowInsetsListener
    public WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
        return UCropActivity.lambda$setupViews$0(this.f$0, view, windowInsetsCompat);
    }

    @Override // androidx.media3.session.MediaControllerStub.ControllerTask
    public void run(MediaControllerImplBase mediaControllerImplBase) {
        if (mediaControllerImplBase.isConnected() && mediaControllerImplBase.pendingCustomActionProgressListeners.get(this.f$0) != null) {
            PathKt$$ExternalSyntheticBUOutline0.m();
        }
    }

    public /* synthetic */ UCropActivity$$ExternalSyntheticLambda1(byte b, int i) {
        this.$r8$classId = b;
        this.f$0 = i;
    }

    public /* synthetic */ UCropActivity$$ExternalSyntheticLambda1(AnalyticsListener.EventTime eventTime, int i, long j) {
        this.$r8$classId = (byte) 3;
        this.f$0 = i;
    }
}
