package com.metrolist.music.ui.component;

import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.material3.CardKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.NeverEqualPolicy;
import androidx.room.RoomDatabase$closeBarrier$1;
import com.metrolist.music.db.entities.Artist;
import com.metrolist.music.ui.menu.AlbumMenuKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.reflect.KFunction;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class LibraryKt$$ExternalSyntheticLambda17 implements Function3 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ MenuState f$0;
    public final /* synthetic */ Artist f$1;
    public final /* synthetic */ CoroutineScope f$2;

    public /* synthetic */ LibraryKt$$ExternalSyntheticLambda17(MenuState menuState, Artist artist, CoroutineScope coroutineScope) {
        this.$r8$classId = (byte) 0;
        this.f$0 = menuState;
        this.f$1 = artist;
        this.f$2 = coroutineScope;
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        NeverEqualPolicy neverEqualPolicy = Composer.Companion.Empty;
        CoroutineScope coroutineScope = this.f$2;
        Artist artist = this.f$1;
        byte b2 = 1;
        switch (b) {
            case 0:
                Composer composer = (Composer) obj2;
                int iIntValue = ((Integer) obj3).intValue();
                ((RowScope) obj).getClass();
                GapComposer gapComposer = (GapComposer) composer;
                if (!gapComposer.shouldExecute(iIntValue & 1, (iIntValue & 17) != 16)) {
                    gapComposer.skipToGroupEnd();
                } else {
                    MenuState menuState = this.f$0;
                    boolean zChanged = gapComposer.changed(menuState) | gapComposer.changed(artist) | gapComposer.changedInstance(coroutineScope);
                    Object objRememberedValue = gapComposer.rememberedValue();
                    if (zChanged || objRememberedValue == neverEqualPolicy) {
                        objRememberedValue = new LibraryKt$$ExternalSyntheticLambda10(b2, artist, menuState, coroutineScope);
                        gapComposer.updateRememberedValue(objRememberedValue);
                    }
                    CardKt.IconButton((Function0) objRememberedValue, null, false, null, null, DialogKt.lambda$890088552, gapComposer, 1572864, 62);
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
                    MenuState menuState2 = this.f$0;
                    boolean zChanged2 = gapComposer2.changed(menuState2);
                    Object objRememberedValue2 = gapComposer2.rememberedValue();
                    if (zChanged2 || objRememberedValue2 == neverEqualPolicy) {
                        RoomDatabase$closeBarrier$1 roomDatabase$closeBarrier$1 = new RoomDatabase$closeBarrier$1(0, menuState2, MenuState.class, "dismiss", "dismiss()V", 0, (byte) 12);
                        gapComposer2.updateRememberedValue(roomDatabase$closeBarrier$1);
                        objRememberedValue2 = roomDatabase$closeBarrier$1;
                    }
                    AlbumMenuKt.ArtistMenu(artist, coroutineScope, (Function0) ((KFunction) objRememberedValue2), gapComposer2, 0);
                }
                break;
            default:
                Composer composer3 = (Composer) obj2;
                int iIntValue3 = ((Integer) obj3).intValue();
                ((ColumnScopeInstance) obj).getClass();
                GapComposer gapComposer3 = (GapComposer) composer3;
                if (!gapComposer3.shouldExecute(iIntValue3 & 1, (iIntValue3 & 17) != 16)) {
                    gapComposer3.skipToGroupEnd();
                } else {
                    MenuState menuState3 = this.f$0;
                    boolean zChanged3 = gapComposer3.changed(menuState3);
                    Object objRememberedValue3 = gapComposer3.rememberedValue();
                    if (zChanged3 || objRememberedValue3 == neverEqualPolicy) {
                        RoomDatabase$closeBarrier$1 roomDatabase$closeBarrier$2 = new RoomDatabase$closeBarrier$1(0, menuState3, MenuState.class, "dismiss", "dismiss()V", 0, (byte) 13);
                        gapComposer3.updateRememberedValue(roomDatabase$closeBarrier$2);
                        objRememberedValue3 = roomDatabase$closeBarrier$2;
                    }
                    AlbumMenuKt.ArtistMenu(artist, coroutineScope, (Function0) ((KFunction) objRememberedValue3), gapComposer3, 0);
                }
                break;
        }
        return unit;
    }

    public /* synthetic */ LibraryKt$$ExternalSyntheticLambda17(byte b, Artist artist, MenuState menuState, CoroutineScope coroutineScope) {
        this.$r8$classId = b;
        this.f$1 = artist;
        this.f$2 = coroutineScope;
        this.f$0 = menuState;
    }
}
