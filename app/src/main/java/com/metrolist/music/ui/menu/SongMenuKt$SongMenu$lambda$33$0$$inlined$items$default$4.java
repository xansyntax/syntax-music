package com.metrolist.music.ui.menu;

import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.lazy.LazyItemScopeImpl;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material3.MaterialTheme$Values;
import androidx.compose.material3.MaterialThemeKt;
import androidx.compose.material3.SurfaceKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.internal.Expect_jvmKt;
import androidx.compose.ui.Modifier;
import androidx.navigation.compose.NavHostKt$NavHost$32;
import com.metrolist.music.db.entities.Song;
import com.metrolist.music.listentogether.LogEntry;
import com.metrolist.music.ui.component.DraggableLyricsProviderItem;
import com.metrolist.music.ui.component.MenuKt;
import com.metrolist.music.ui.screens.settings.ChangelogScreenKt;
import com.metrolist.music.ui.screens.settings.integrations.ListenTogetherSettingsKt;
import com.metrolist.music.utils.ReleaseInfo;
import com.yalantis.ucrop.view.CropImageView;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function4;
import sh.calvin.reorderable.ReorderableCollectionItemScopeImpl;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class SongMenuKt$SongMenu$lambda$33$0$$inlined$items$default$4 implements Function4 {
    public final /* synthetic */ Object $items;
    public final /* synthetic */ byte $r8$classId;

    public /* synthetic */ SongMenuKt$SongMenu$lambda$33$0$$inlined$items$default$4(byte b, Object obj) {
        this.$r8$classId = b;
        this.$items = obj;
    }

    @Override // kotlin.jvm.functions.Function4
    public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        Object obj5 = this.$items;
        switch (b) {
            case 0:
                LazyItemScopeImpl lazyItemScopeImpl = (LazyItemScopeImpl) obj;
                int iIntValue = ((Number) obj2).intValue();
                Composer composer = (Composer) obj3;
                int iIntValue2 = ((Number) obj4).intValue();
                int i = (iIntValue2 & 6) == 0 ? iIntValue2 | (((GapComposer) composer).changed(lazyItemScopeImpl) ? 4 : 2) : iIntValue2;
                if ((iIntValue2 & 48) == 0) {
                    i |= ((GapComposer) composer).changed(iIntValue) ? 32 : 16;
                }
                GapComposer gapComposer = (GapComposer) composer;
                if (!gapComposer.shouldExecute(i & 1, (i & 147) != 146)) {
                    gapComposer.skipToGroupEnd();
                } else {
                    Song song = (Song) ((List) obj5).get(iIntValue);
                    gapComposer.startReplaceGroup(-1621572716);
                    MenuKt.SongListItem(song, null, null, false, false, false, null, null, false, false, false, null, null, gapComposer, 0, 0, 16382);
                    gapComposer.end(false);
                }
                break;
            case 1:
                LazyItemScopeImpl lazyItemScopeImpl2 = (LazyItemScopeImpl) obj;
                int iIntValue3 = ((Number) obj2).intValue();
                Composer composer2 = (Composer) obj3;
                int iIntValue4 = ((Number) obj4).intValue();
                int i2 = (iIntValue4 & 6) == 0 ? iIntValue4 | (((GapComposer) composer2).changed(lazyItemScopeImpl2) ? 4 : 2) : iIntValue4;
                if ((iIntValue4 & 48) == 0) {
                    i2 |= ((GapComposer) composer2).changed(iIntValue3) ? 32 : 16;
                }
                GapComposer gapComposer2 = (GapComposer) composer2;
                if (!gapComposer2.shouldExecute(i2 & 1, (i2 & 147) != 146)) {
                    gapComposer2.skipToGroupEnd();
                } else {
                    Song song2 = (Song) ((List) obj5).get(iIntValue3);
                    gapComposer2.startReplaceGroup(1549528053);
                    MenuKt.SongListItem(song2, null, null, false, false, false, null, null, false, false, false, null, null, gapComposer2, 0, 0, 16382);
                    gapComposer2.end(false);
                }
                break;
            case 2:
                LazyItemScopeImpl lazyItemScopeImpl3 = (LazyItemScopeImpl) obj;
                int iIntValue5 = ((Number) obj2).intValue();
                Composer composer3 = (Composer) obj3;
                int iIntValue6 = ((Number) obj4).intValue();
                int i3 = (iIntValue6 & 6) == 0 ? iIntValue6 | (((GapComposer) composer3).changed(lazyItemScopeImpl3) ? 4 : 2) : iIntValue6;
                if ((iIntValue6 & 48) == 0) {
                    i3 |= ((GapComposer) composer3).changed(iIntValue5) ? 32 : 16;
                }
                GapComposer gapComposer3 = (GapComposer) composer3;
                if (!gapComposer3.shouldExecute(i3 & 1, (i3 & 147) != 146)) {
                    gapComposer3.skipToGroupEnd();
                } else {
                    Song song3 = (Song) ((List) obj5).get(iIntValue5);
                    gapComposer3.startReplaceGroup(721430678);
                    MenuKt.SongListItem(song3, null, null, false, false, false, null, null, false, false, false, null, null, gapComposer3, 0, 0, 16382);
                    gapComposer3.end(false);
                }
                break;
            case 3:
                LazyItemScopeImpl lazyItemScopeImpl4 = (LazyItemScopeImpl) obj;
                int iIntValue7 = ((Number) obj2).intValue();
                Composer composer4 = (Composer) obj3;
                int iIntValue8 = ((Number) obj4).intValue();
                int i4 = (iIntValue8 & 6) == 0 ? iIntValue8 | (((GapComposer) composer4).changed(lazyItemScopeImpl4) ? 4 : 2) : iIntValue8;
                if ((iIntValue8 & 48) == 0) {
                    i4 |= ((GapComposer) composer4).changed(iIntValue7) ? 32 : 16;
                }
                GapComposer gapComposer4 = (GapComposer) composer4;
                if (!gapComposer4.shouldExecute(i4 & 1, (i4 & 147) != 146)) {
                    gapComposer4.skipToGroupEnd();
                } else {
                    ReleaseInfo releaseInfo = (ReleaseInfo) ((List) obj5).get(iIntValue7);
                    gapComposer4.startReplaceGroup(113644564);
                    ChangelogScreenKt.ReleaseItem(releaseInfo, gapComposer4, 8);
                    gapComposer4.end(false);
                }
                break;
            case 4:
                LazyItemScopeImpl lazyItemScopeImpl5 = (LazyItemScopeImpl) obj;
                int iIntValue9 = ((Number) obj2).intValue();
                Composer composer5 = (Composer) obj3;
                int iIntValue10 = ((Number) obj4).intValue();
                int i5 = (iIntValue10 & 6) == 0 ? iIntValue10 | (((GapComposer) composer5).changed(lazyItemScopeImpl5) ? 4 : 2) : iIntValue10;
                if ((iIntValue10 & 48) == 0) {
                    i5 |= ((GapComposer) composer5).changed(iIntValue9) ? 32 : 16;
                }
                GapComposer gapComposer5 = (GapComposer) composer5;
                if (!gapComposer5.shouldExecute(i5 & 1, (i5 & 147) != 146)) {
                    gapComposer5.skipToGroupEnd();
                } else {
                    LogEntry logEntry = (LogEntry) ((List) obj5).get(iIntValue9);
                    gapComposer5.startReplaceGroup(1537806108);
                    ListenTogetherSettingsKt.LogEntryItem(logEntry, gapComposer5, 0);
                    gapComposer5.end(false);
                }
                break;
            default:
                ReorderableCollectionItemScopeImpl reorderableCollectionItemScopeImpl = (ReorderableCollectionItemScopeImpl) obj;
                ((Boolean) obj2).getClass();
                Composer composer6 = (Composer) obj3;
                int iIntValue11 = ((Number) obj4).intValue();
                reorderableCollectionItemScopeImpl.getClass();
                if ((iIntValue11 & 6) == 0) {
                    iIntValue11 |= ((GapComposer) composer6).changed(reorderableCollectionItemScopeImpl) ? 4 : 2;
                }
                GapComposer gapComposer6 = (GapComposer) composer6;
                if (!gapComposer6.shouldExecute(iIntValue11 & 1, (iIntValue11 & 131) != 130)) {
                    gapComposer6.skipToGroupEnd();
                } else {
                    SurfaceKt.m337SurfaceT9BRK9s(OffsetKt.m137paddingVpY3zN4$default(SizeKt.fillMaxWidth(Modifier.Companion.$$INSTANCE, 1.0f), CropImageView.DEFAULT_ASPECT_RATIO, 4.0f, 1), RoundedCornerShapeKt.m185RoundedCornerShape0680j_4(8.0f), ((MaterialTheme$Values) gapComposer6.consume(MaterialThemeKt._localMaterialTheme)).colorScheme.surfaceContainer, 0L, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, null, Expect_jvmKt.rememberComposableLambda(-1887417637, new NavHostKt$NavHost$32.AnonymousClass1(reorderableCollectionItemScopeImpl, (DraggableLyricsProviderItem) obj5, (byte) 3), gapComposer6), gapComposer6, 12582918, 120);
                }
                break;
        }
        return unit;
    }
}
