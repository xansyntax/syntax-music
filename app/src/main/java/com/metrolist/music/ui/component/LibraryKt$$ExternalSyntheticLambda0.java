package com.metrolist.music.ui.component;

import androidx.compose.runtime.internal.ComposableLambdaImpl;
import com.metrolist.music.db.entities.Album;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class LibraryKt$$ExternalSyntheticLambda0 implements Function0 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ MenuState f$0;
    public final /* synthetic */ Album f$1;

    public /* synthetic */ LibraryKt$$ExternalSyntheticLambda0(byte b, Album album, MenuState menuState) {
        this.$r8$classId = b;
        this.f$0 = menuState;
        this.f$1 = album;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        Album album = this.f$1;
        MenuState menuState = this.f$0;
        byte b2 = 1;
        switch (b) {
            case 0:
                menuState.show(new ComposableLambdaImpl(true, -257111756, new LibraryKt$$ExternalSyntheticLambda3((byte) 0, album, menuState)));
                break;
            default:
                menuState.show(new ComposableLambdaImpl(true, -563497961, new LibraryKt$$ExternalSyntheticLambda3(b2, album, menuState)));
                break;
        }
        return unit;
    }
}
