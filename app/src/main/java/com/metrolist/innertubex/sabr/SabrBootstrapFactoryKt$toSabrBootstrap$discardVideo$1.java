package com.metrolist.innertubex.sabr;

import com.metrolist.innertubex.models.response.PlayerResponse;
import kotlin.jvm.internal.PropertyReference1Impl;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class SabrBootstrapFactoryKt$toSabrBootstrap$discardVideo$1 extends PropertyReference1Impl {
    public static final SabrBootstrapFactoryKt$toSabrBootstrap$discardVideo$1 INSTANCE = new SabrBootstrapFactoryKt$toSabrBootstrap$discardVideo$1(PlayerResponse.StreamingData.Format.class, "isAudio", "isAudio()Z");

    @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
    public final Object get(Object obj) {
        return Boolean.valueOf(((PlayerResponse.StreamingData.Format) obj).isAudio());
    }
}
