package com.metrolist.music.ui.component;

import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.material3.CardKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.NeverEqualPolicy;
import androidx.room.RoomDatabase$closeBarrier$1;
import com.metrolist.music.db.entities.Album;
import com.metrolist.music.ui.menu.AlbumMenuKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.reflect.KFunction;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class LibraryKt$$ExternalSyntheticLambda3 implements Function3 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ Album f$0;
    public final /* synthetic */ MenuState f$1;

    public /* synthetic */ LibraryKt$$ExternalSyntheticLambda3(MenuState menuState, Album album) {
        this.$r8$classId = (byte) 2;
        this.f$1 = menuState;
        this.f$0 = album;
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        NeverEqualPolicy neverEqualPolicy = Composer.Companion.Empty;
        Album album = this.f$0;
        byte b2 = 1;
        switch (b) {
            case 0:
                Composer composer = (Composer) obj2;
                int iIntValue = ((Integer) obj3).intValue();
                ((ColumnScopeInstance) obj).getClass();
                GapComposer gapComposer = (GapComposer) composer;
                if (!gapComposer.shouldExecute(iIntValue & 1, (iIntValue & 17) != 16)) {
                    gapComposer.skipToGroupEnd();
                } else {
                    MenuState menuState = this.f$1;
                    boolean zChanged = gapComposer.changed(menuState);
                    Object objRememberedValue = gapComposer.rememberedValue();
                    if (zChanged || objRememberedValue == neverEqualPolicy) {
                        RoomDatabase$closeBarrier$1 roomDatabase$closeBarrier$1 = new RoomDatabase$closeBarrier$1(0, menuState, MenuState.class, "dismiss", "dismiss()V", 0, (byte) 10);
                        gapComposer.updateRememberedValue(roomDatabase$closeBarrier$1);
                        objRememberedValue = roomDatabase$closeBarrier$1;
                    }
                    AlbumMenuKt.AlbumMenu(album, (Function0) ((KFunction) objRememberedValue), gapComposer, 0);
                }
                break;
            case 1:
                Composer composer2 = (Composer) obj2;
                int iIntValue2 = ((Integer) obj3).intValue();
                ((ColumnScopeInstance) obj).getClass();
                GapComposer gapComposer2 = (GapComposer) composer2;
                if (!gapComposer2.shouldExecute(iIntValue2 & 1, (iIntValue2 & 17) != 16)) {
                    gapComposer2.skipToGroupEnd();
                } else {
                    MenuState menuState2 = this.f$1;
                    boolean zChanged2 = gapComposer2.changed(menuState2);
                    Object objRememberedValue2 = gapComposer2.rememberedValue();
                    if (zChanged2 || objRememberedValue2 == neverEqualPolicy) {
                        RoomDatabase$closeBarrier$1 roomDatabase$closeBarrier$2 = new RoomDatabase$closeBarrier$1(0, menuState2, MenuState.class, "dismiss", "dismiss()V", 0, (byte) 11);
                        gapComposer2.updateRememberedValue(roomDatabase$closeBarrier$2);
                        objRememberedValue2 = roomDatabase$closeBarrier$2;
                    }
                    AlbumMenuKt.AlbumMenu(album, (Function0) ((KFunction) objRememberedValue2), gapComposer2, 0);
                }
                break;
            default:
                Composer composer3 = (Composer) obj2;
                int iIntValue3 = ((Integer) obj3).intValue();
                ((RowScope) obj).getClass();
                GapComposer gapComposer3 = (GapComposer) composer3;
                if (!gapComposer3.shouldExecute(iIntValue3 & 1, (iIntValue3 & 17) != 16)) {
                    gapComposer3.skipToGroupEnd();
                } else {
                    MenuState menuState3 = this.f$1;
                    boolean zChanged3 = gapComposer3.changed(menuState3) | gapComposer3.changed(album);
                    Object objRememberedValue3 = gapComposer3.rememberedValue();
                    if (zChanged3 || objRememberedValue3 == neverEqualPolicy) {
                        objRememberedValue3 = new LibraryKt$$ExternalSyntheticLambda0(b2, album, menuState3);
                        gapComposer3.updateRememberedValue(objRememberedValue3);
                    }
                    CardKt.IconButton((Function0) objRememberedValue3, null, false, null, null, DialogKt.lambda$223726883, gapComposer3, 1572864, 62);
                }
                break;
        }
        return unit;
    }

    public /* synthetic */ LibraryKt$$ExternalSyntheticLambda3(byte b, Album album, MenuState menuState) {
        this.$r8$classId = b;
        this.f$0 = album;
        this.f$1 = menuState;
    }
}
