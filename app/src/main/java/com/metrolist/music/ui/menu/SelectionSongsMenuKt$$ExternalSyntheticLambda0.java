package com.metrolist.music.ui.menu;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Stack;
import java.util.List;
import kotlin.Function;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class SelectionSongsMenuKt$$ExternalSyntheticLambda0 implements Function2 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ Object f$0;
    public final /* synthetic */ Object f$1;
    public final /* synthetic */ Function0 f$2;
    public final /* synthetic */ Function f$3;
    public final /* synthetic */ byte f$4;

    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ SelectionSongsMenuKt$$ExternalSyntheticLambda0(Function0 function0, String str, Function1 function1, Function1 function2, int i) {
        this.$r8$classId = (byte) 2;
        this.f$2 = function0;
        this.f$0 = str;
        this.f$1 = function1;
        this.f$3 = function2;
        this.f$4 = i;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        byte b2 = this.f$4;
        Function function = this.f$3;
        Object obj3 = this.f$1;
        Object obj4 = this.f$0;
        switch (b) {
            case 0:
                ((Integer) obj2).getClass();
                int iUpdateChangedFlags = Stack.updateChangedFlags(b2 | 1);
                YouTubeAlbumMenuKt.SelectionMediaMetadataMenu((List) obj4, (List) obj3, this.f$2, (Function0) function, (Composer) obj, iUpdateChangedFlags);
                break;
            case 1:
                ((Integer) obj2).getClass();
                int iUpdateChangedFlags2 = Stack.updateChangedFlags(b2 | 1);
                YouTubeAlbumMenuKt.SelectionMediaMetadataMenu((List) obj4, (List) obj3, this.f$2, (Function0) function, (Composer) obj, iUpdateChangedFlags2);
                break;
            default:
                ((Integer) obj2).getClass();
                int iUpdateChangedFlags3 = Stack.updateChangedFlags(b2 | 1);
                AlbumMenuKt.ExportDialog(this.f$2, (String) obj4, (Function1) obj3, (Function1) function, (Composer) obj, iUpdateChangedFlags3);
                break;
        }
        return unit;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ SelectionSongsMenuKt$$ExternalSyntheticLambda0(List list, List list2, Function0 function0, Function0 function1, int i, byte b) {
        this.$r8$classId = b;
        this.f$0 = list;
        this.f$1 = list2;
        this.f$2 = function0;
        this.f$3 = function1;
        this.f$4 = i;
    }
}
