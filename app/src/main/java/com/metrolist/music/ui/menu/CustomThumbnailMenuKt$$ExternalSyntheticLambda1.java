package com.metrolist.music.ui.menu;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Stack;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class CustomThumbnailMenuKt$$ExternalSyntheticLambda1 implements Function2 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ Function0 f$0;
    public final /* synthetic */ Function0 f$1;
    public final /* synthetic */ Function0 f$2;

    public /* synthetic */ CustomThumbnailMenuKt$$ExternalSyntheticLambda1(Function0 function0, Function0 function1, Function0 function2, int i, byte b) {
        this.$r8$classId = b;
        this.f$0 = function0;
        this.f$1 = function1;
        this.f$2 = function2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        Function0 function0 = this.f$2;
        Function0 function1 = this.f$1;
        Function0 function2 = this.f$0;
        Composer composer = (Composer) obj;
        ((Integer) obj2).getClass();
        switch (b) {
            case 0:
                AlbumMenuKt.CustomThumbnailMenu(function2, function1, function0, composer, Stack.updateChangedFlags(1));
                break;
            default:
                AlbumMenuKt.CachePlaylistMenu(function2, function1, function0, composer, Stack.updateChangedFlags(7));
                break;
        }
        return unit;
    }
}
