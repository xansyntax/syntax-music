package com.metrolist.music.ui.component;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Stack;
import androidx.compose.ui.Modifier;
import com.metrolist.music.db.entities.Artist;
import kotlin.Function;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ItemsKt$$ExternalSyntheticLambda25 implements Function2 {
    public final /* synthetic */ byte $r8$classId = 0;
    public final /* synthetic */ Object f$0;
    public final /* synthetic */ Object f$1;
    public final /* synthetic */ Function f$2;
    public final /* synthetic */ boolean f$3;
    public final /* synthetic */ int f$4;
    public final /* synthetic */ byte f$5;

    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ ItemsKt$$ExternalSyntheticLambda25(Artist artist, Modifier modifier, Function3 function3, boolean z, int i, int i2) {
        this.f$0 = artist;
        this.f$1 = modifier;
        this.f$2 = function3;
        this.f$3 = z;
        this.f$4 = i;
        this.f$5 = i2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        int i = this.f$4;
        Function function = this.f$2;
        Object obj3 = this.f$1;
        Object obj4 = this.f$0;
        switch (b) {
            case 0:
                ((Integer) obj2).getClass();
                int iUpdateChangedFlags = Stack.updateChangedFlags(i | 1);
                MenuKt.ArtistGridItem((Artist) obj4, (Modifier) obj3, (Function3) function, this.f$3, (Composer) obj, iUpdateChangedFlags, this.f$5);
                break;
            default:
                ((Integer) obj2).getClass();
                int iUpdateChangedFlags2 = Stack.updateChangedFlags(i | 1);
                DialogKt.CreatePlaylistDialog((Function0) obj4, (String) obj3, this.f$3, (Function1) function, (Composer) obj, iUpdateChangedFlags2, this.f$5);
                break;
        }
        return unit;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ ItemsKt$$ExternalSyntheticLambda25(Function0 function0, String str, boolean z, Function1 function1, int i, int i2) {
        this.f$0 = function0;
        this.f$1 = str;
        this.f$3 = z;
        this.f$2 = function1;
        this.f$4 = i;
        this.f$5 = i2;
    }
}
