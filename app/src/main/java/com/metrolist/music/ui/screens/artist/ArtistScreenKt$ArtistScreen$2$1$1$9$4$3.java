package com.metrolist.music.ui.screens.artist;

import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.material3.CardKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.NeverEqualPolicy;
import com.metrolist.innertube.models.SongItem;
import com.metrolist.innertube.models.YTItem;
import com.metrolist.music.ui.component.MenuState;
import com.metrolist.music.ui.menu.YouTubeSongMenuKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.reflect.KFunction;
import okhttp3.internal.http2.Http2Connection;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class ArtistScreenKt$ArtistScreen$2$1$1$9$4$3 implements Function3 {
    public final /* synthetic */ MenuState $menuState;
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ YTItem $song;

    public ArtistScreenKt$ArtistScreen$2$1$1$9$4$3(MenuState menuState, YTItem yTItem) {
        this.$r8$classId = (byte) 0;
        this.$menuState = menuState;
        this.$song = yTItem;
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        NeverEqualPolicy neverEqualPolicy = Composer.Companion.Empty;
        YTItem yTItem = this.$song;
        switch (b) {
            case 0:
                Composer composer = (Composer) obj2;
                int iIntValue = ((Number) obj3).intValue();
                ((RowScope) obj).getClass();
                GapComposer gapComposer = (GapComposer) composer;
                if (!gapComposer.shouldExecute(iIntValue & 1, (iIntValue & 17) != 16)) {
                    gapComposer.skipToGroupEnd();
                } else {
                    MenuState menuState = this.$menuState;
                    boolean zChanged = gapComposer.changed(menuState) | gapComposer.changedInstance(yTItem);
                    Object objRememberedValue = gapComposer.rememberedValue();
                    if (zChanged || objRememberedValue == neverEqualPolicy) {
                        objRememberedValue = new Http2Connection.ReaderRunnable(menuState, yTItem, (byte) 13);
                        gapComposer.updateRememberedValue(objRememberedValue);
                    }
                    CardKt.IconButton((Function0) objRememberedValue, null, false, null, null, ArtistItemsScreenKt.f347lambda$778940053, gapComposer, 1572864, 62);
                }
                break;
            case 1:
                Composer composer2 = (Composer) obj2;
                int iIntValue2 = ((Number) obj3).intValue();
                ((ColumnScopeInstance) obj).getClass();
                GapComposer gapComposer2 = (GapComposer) composer2;
                if (!gapComposer2.shouldExecute(iIntValue2 & 1, (iIntValue2 & 17) != 16)) {
                    gapComposer2.skipToGroupEnd();
                } else {
                    SongItem songItem = (SongItem) yTItem;
                    MenuState menuState2 = this.$menuState;
                    boolean zChanged2 = gapComposer2.changed(menuState2);
                    Object objRememberedValue2 = gapComposer2.rememberedValue();
                    if (zChanged2 || objRememberedValue2 == neverEqualPolicy) {
                        ArtistScreenKt$ArtistScreen$4$2$1 artistScreenKt$ArtistScreen$4$2$1 = new ArtistScreenKt$ArtistScreen$4$2$1(0, menuState2, MenuState.class, "dismiss", "dismiss()V", 0, (byte) 12);
                        gapComposer2.updateRememberedValue(artistScreenKt$ArtistScreen$4$2$1);
                        objRememberedValue2 = artistScreenKt$ArtistScreen$4$2$1;
                    }
                    YouTubeSongMenuKt.YouTubeSongMenu(songItem, (Function0) ((KFunction) objRememberedValue2), null, gapComposer2, 0, 4);
                }
                break;
            default:
                Composer composer3 = (Composer) obj2;
                int iIntValue3 = ((Number) obj3).intValue();
                ((ColumnScopeInstance) obj).getClass();
                GapComposer gapComposer3 = (GapComposer) composer3;
                if (!gapComposer3.shouldExecute(iIntValue3 & 1, (iIntValue3 & 17) != 16)) {
                    gapComposer3.skipToGroupEnd();
                } else {
                    SongItem songItem2 = (SongItem) yTItem;
                    MenuState menuState3 = this.$menuState;
                    boolean zChanged3 = gapComposer3.changed(menuState3);
                    Object objRememberedValue3 = gapComposer3.rememberedValue();
                    if (zChanged3 || objRememberedValue3 == neverEqualPolicy) {
                        ArtistScreenKt$ArtistScreen$4$2$1 artistScreenKt$ArtistScreen$4$2$2 = new ArtistScreenKt$ArtistScreen$4$2$1(0, menuState3, MenuState.class, "dismiss", "dismiss()V", 0, (byte) 13);
                        gapComposer3.updateRememberedValue(artistScreenKt$ArtistScreen$4$2$2);
                        objRememberedValue3 = artistScreenKt$ArtistScreen$4$2$2;
                    }
                    YouTubeSongMenuKt.YouTubeSongMenu(songItem2, (Function0) ((KFunction) objRememberedValue3), null, gapComposer3, 0, 4);
                }
                break;
        }
        return unit;
    }

    public /* synthetic */ ArtistScreenKt$ArtistScreen$2$1$1$9$4$3(YTItem yTItem, MenuState menuState, byte b) {
        this.$r8$classId = b;
        this.$song = yTItem;
        this.$menuState = menuState;
    }
}
