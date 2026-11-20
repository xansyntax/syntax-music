package com.metrolist.music.utils.potoken;

import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class PoTokenWebView$$ExternalSyntheticLambda0 implements Function1 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ PoTokenWebView f$0;

    public /* synthetic */ PoTokenWebView$$ExternalSyntheticLambda0(PoTokenWebView poTokenWebView, byte b) {
        this.$r8$classId = b;
        this.f$0 = poTokenWebView;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        byte b = this.$r8$classId;
        PoTokenWebView poTokenWebView = this.f$0;
        String str = (String) obj;
        switch (b) {
            case 0:
                return PoTokenWebView.downloadAndRunBotguard$lambda$0(poTokenWebView, str);
            default:
                return PoTokenWebView.onRunBotguardResult$lambda$0(poTokenWebView, str);
        }
    }
}
