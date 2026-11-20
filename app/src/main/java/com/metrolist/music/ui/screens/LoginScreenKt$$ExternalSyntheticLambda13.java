package com.metrolist.music.ui.screens;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.CompletableDeferredImpl;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class LoginScreenKt$$ExternalSyntheticLambda13 implements Function1 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ CompletableDeferredImpl f$0;

    public /* synthetic */ LoginScreenKt$$ExternalSyntheticLambda13(CompletableDeferredImpl completableDeferredImpl, byte b) {
        this.$r8$classId = b;
        this.f$0 = completableDeferredImpl;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        CompletableDeferredImpl completableDeferredImpl = this.f$0;
        String str = (String) obj;
        switch (b) {
            case 0:
                if (!completableDeferredImpl.isCompleted()) {
                    completableDeferredImpl.makeCompleting$kotlinx_coroutines_core(str);
                }
                break;
            case 1:
                if (!completableDeferredImpl.isCompleted()) {
                    completableDeferredImpl.makeCompleting$kotlinx_coroutines_core(str);
                }
                break;
            default:
                if (!completableDeferredImpl.isCompleted()) {
                    completableDeferredImpl.makeCompleting$kotlinx_coroutines_core(str);
                }
                break;
        }
        return unit;
    }
}
