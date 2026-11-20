package com.metrolist.music.listentogether;

import android.os.SystemClock;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class ListenTogetherClient$serverClock$1 extends FunctionReferenceImpl implements Function0 {
    public static final ListenTogetherClient$serverClock$1 INSTANCE = new ListenTogetherClient$serverClock$1(0, SystemClock.class, "elapsedRealtime", "elapsedRealtime()J", 0);

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        return Long.valueOf(SystemClock.elapsedRealtime());
    }
}
