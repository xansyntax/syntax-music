package com.metrolist.music.ui.component;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Stack;
import androidx.compose.ui.Modifier;
import com.metrolist.music.db.entities.Playlist;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class LibraryKt$$ExternalSyntheticLambda9 implements Function2 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ MenuState f$0;
    public final /* synthetic */ CoroutineScope f$1;
    public final /* synthetic */ Playlist f$2;
    public final /* synthetic */ Modifier f$3;

    public /* synthetic */ LibraryKt$$ExternalSyntheticLambda9(MenuState menuState, CoroutineScope coroutineScope, Playlist playlist, Modifier modifier, int i, byte b) {
        this.$r8$classId = b;
        this.f$0 = menuState;
        this.f$1 = coroutineScope;
        this.f$2 = playlist;
        this.f$3 = modifier;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        switch (b) {
            case 0:
                ((Integer) obj2).getClass();
                int iUpdateChangedFlags = Stack.updateChangedFlags(1);
                LibraryKt.LibraryPlaylistGridItem(this.f$0, this.f$1, this.f$2, this.f$3, (Composer) obj, iUpdateChangedFlags);
                break;
            default:
                ((Integer) obj2).getClass();
                int iUpdateChangedFlags2 = Stack.updateChangedFlags(1);
                LibraryKt.LibraryPlaylistListItem(this.f$0, this.f$1, this.f$2, this.f$3, (Composer) obj, iUpdateChangedFlags2);
                break;
        }
        return unit;
    }
}
