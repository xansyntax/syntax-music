package com.metrolist.music.ui.component;

import androidx.compose.runtime.internal.ComposableLambdaImpl;
import com.metrolist.music.db.entities.Playlist;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class LibraryKt$$ExternalSyntheticLambda7 implements Function0 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ MenuState f$0;
    public final /* synthetic */ Playlist f$1;
    public final /* synthetic */ CoroutineScope f$2;

    public /* synthetic */ LibraryKt$$ExternalSyntheticLambda7(byte b, Playlist playlist, MenuState menuState, CoroutineScope coroutineScope) {
        this.$r8$classId = b;
        this.f$0 = menuState;
        this.f$1 = playlist;
        this.f$2 = coroutineScope;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        CoroutineScope coroutineScope = this.f$2;
        Playlist playlist = this.f$1;
        MenuState menuState = this.f$0;
        byte b2 = 1;
        switch (b) {
            case 0:
                menuState.show(new ComposableLambdaImpl(true, 1639822598, new LibraryKt$$ExternalSyntheticLambda14(b2, playlist, menuState, coroutineScope)));
                break;
            default:
                menuState.show(new ComposableLambdaImpl(true, -1990547398, new LibraryKt$$ExternalSyntheticLambda14((byte) 2, playlist, menuState, coroutineScope)));
                break;
        }
        return unit;
    }
}
