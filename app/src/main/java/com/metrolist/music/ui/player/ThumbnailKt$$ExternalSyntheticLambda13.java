package com.metrolist.music.ui.player;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ThumbnailKt$$ExternalSyntheticLambda13 implements Function0 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ boolean f$0;
    public final /* synthetic */ Function0 f$1;

    public /* synthetic */ ThumbnailKt$$ExternalSyntheticLambda13(byte b, Function0 function0, boolean z) {
        this.$r8$classId = b;
        this.f$0 = z;
        this.f$1 = function0;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        byte b = this.$r8$classId;
        Function0 function0 = this.f$1;
        boolean z = this.f$0;
        switch (b) {
            case 0:
                return Boolean.valueOf(z && ((Boolean) function0.invoke()).booleanValue());
            default:
                if (z) {
                    function0.invoke();
                }
                return Unit.INSTANCE;
        }
    }
}
