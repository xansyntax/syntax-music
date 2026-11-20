package com.metrolist.music.ui.screens.library;

import com.metrolist.music.constants.LibraryViewType;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class LibraryMixScreenKt$$ExternalSyntheticLambda56 implements Function0 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ Function1 f$0;
    public final /* synthetic */ LibraryViewType f$1;

    public /* synthetic */ LibraryMixScreenKt$$ExternalSyntheticLambda56(Function1 function1, LibraryViewType libraryViewType, byte b) {
        this.$r8$classId = b;
        this.f$0 = function1;
        this.f$1 = libraryViewType;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        LibraryViewType libraryViewType = this.f$1;
        Function1 function1 = this.f$0;
        switch (b) {
            case 0:
                function1.invoke(libraryViewType.toggle());
                break;
            default:
                function1.invoke(libraryViewType.toggle());
                break;
        }
        return unit;
    }
}
