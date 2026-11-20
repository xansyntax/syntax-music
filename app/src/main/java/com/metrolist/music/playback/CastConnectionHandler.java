package com.metrolist.music.playback;

import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.StateFlowKt;
import kotlinx.coroutines.internal.ContextScope;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class CastConnectionHandler {
    public final StateFlowImpl castDeviceName;
    public final StateFlowImpl castDuration;
    public final StateFlowImpl castIsPlaying;
    public final StateFlowImpl castPosition;
    public final StateFlowImpl castVolume;
    public final StateFlowImpl isCasting;

    public CastConnectionHandler(MusicService musicService, ContextScope contextScope, MusicService musicService2) {
        contextScope.getClass();
        Boolean bool = Boolean.FALSE;
        this.isCasting = StateFlowKt.MutableStateFlow(bool);
        this.castDeviceName = StateFlowKt.MutableStateFlow(null);
        this.castPosition = StateFlowKt.MutableStateFlow(0L);
        this.castDuration = StateFlowKt.MutableStateFlow(0L);
        this.castIsPlaying = StateFlowKt.MutableStateFlow(bool);
        StateFlowKt.MutableStateFlow(bool);
        this.castVolume = StateFlowKt.MutableStateFlow(Float.valueOf(1.0f));
    }
}
