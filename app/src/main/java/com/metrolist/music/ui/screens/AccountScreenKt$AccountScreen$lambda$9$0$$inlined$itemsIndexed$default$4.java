package com.metrolist.music.ui.screens;

import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.lazy.LazyItemScopeImpl;
import androidx.compose.foundation.lazy.grid.LazyGridItemScopeImpl;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.NeverEqualPolicy;
import androidx.compose.ui.Modifier;
import androidx.navigation.NavHostController;
import com.metrolist.innertube.models.ArtistItem;
import com.metrolist.music.db.entities.Playlist;
import com.metrolist.music.db.entities.PodcastEntity;
import com.metrolist.music.ui.component.MenuKt;
import com.metrolist.music.ui.screens.library.LibraryScreenKt;
import java.io.IOException;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function4;
import okhttp3.internal.http2.Http2Connection;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class AccountScreenKt$AccountScreen$lambda$9$0$$inlined$itemsIndexed$default$4 implements Function4 {
    public final /* synthetic */ List $items;
    public final /* synthetic */ NavHostController $navController$inlined;
    public final /* synthetic */ byte $r8$classId;

    public /* synthetic */ AccountScreenKt$AccountScreen$lambda$9$0$$inlined$itemsIndexed$default$4(List list, NavHostController navHostController, byte b) {
        this.$r8$classId = b;
        this.$items = list;
        this.$navController$inlined = navHostController;
    }

    @Override // kotlin.jvm.functions.Function4
    public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) throws XmlPullParserException, IOException {
        byte b = this.$r8$classId;
        Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
        Unit unit = Unit.INSTANCE;
        NeverEqualPolicy neverEqualPolicy = Composer.Companion.Empty;
        List list = this.$items;
        NavHostController navHostController = this.$navController$inlined;
        switch (b) {
            case 0:
                LazyGridItemScopeImpl lazyGridItemScopeImpl = (LazyGridItemScopeImpl) obj;
                int iIntValue = ((Number) obj2).intValue();
                Composer composer = (Composer) obj3;
                int iIntValue2 = ((Number) obj4).intValue();
                int i = (iIntValue2 & 6) == 0 ? iIntValue2 | (((GapComposer) composer).changed(lazyGridItemScopeImpl) ? 4 : 2) : iIntValue2;
                if ((iIntValue2 & 48) == 0) {
                    i |= ((GapComposer) composer).changed(iIntValue) ? 32 : 16;
                }
                GapComposer gapComposer = (GapComposer) composer;
                if (!gapComposer.shouldExecute(i & 1, (i & 147) != 146)) {
                    gapComposer.skipToGroupEnd();
                } else {
                    PodcastEntity podcastEntity = (PodcastEntity) list.get(iIntValue);
                    gapComposer.startReplaceGroup(-1606004059);
                    String str = podcastEntity.thumbnailUrl;
                    String str2 = podcastEntity.title;
                    String str3 = podcastEntity.author;
                    boolean zChangedInstance = gapComposer.changedInstance(navHostController) | gapComposer.changed(podcastEntity);
                    Object objRememberedValue = gapComposer.rememberedValue();
                    if (zChangedInstance || objRememberedValue == neverEqualPolicy) {
                        objRememberedValue = new AccountScreenKt$AccountScreen$1$1$17$1$1(navHostController, podcastEntity, (byte) 0);
                        gapComposer.updateRememberedValue(objRememberedValue);
                    }
                    AlbumScreenKt.PodcastAccountItem(str, str2, str3, (Function0) objRememberedValue, null, gapComposer, 0);
                    gapComposer.end(false);
                }
                break;
            case 1:
                LazyGridItemScopeImpl lazyGridItemScopeImpl2 = (LazyGridItemScopeImpl) obj;
                int iIntValue3 = ((Number) obj2).intValue();
                Composer composer2 = (Composer) obj3;
                int iIntValue4 = ((Number) obj4).intValue();
                int i2 = (iIntValue4 & 6) == 0 ? iIntValue4 | (((GapComposer) composer2).changed(lazyGridItemScopeImpl2) ? 4 : 2) : iIntValue4;
                if ((iIntValue4 & 48) == 0) {
                    i2 |= ((GapComposer) composer2).changed(iIntValue3) ? 32 : 16;
                }
                GapComposer gapComposer2 = (GapComposer) composer2;
                if (!gapComposer2.shouldExecute(i2 & 1, (i2 & 147) != 146)) {
                    gapComposer2.skipToGroupEnd();
                } else {
                    ArtistItem artistItem = (ArtistItem) list.get(iIntValue3);
                    gapComposer2.startReplaceGroup(1274428187);
                    String str4 = artistItem.thumbnail;
                    String str5 = artistItem.title;
                    boolean zChangedInstance2 = gapComposer2.changedInstance(navHostController) | gapComposer2.changedInstance(artistItem);
                    Object objRememberedValue2 = gapComposer2.rememberedValue();
                    if (zChangedInstance2 || objRememberedValue2 == neverEqualPolicy) {
                        objRememberedValue2 = new AccountScreenKt$AccountScreen$1$1$11$2$1(navHostController, artistItem, (byte) 1);
                        gapComposer2.updateRememberedValue(objRememberedValue2);
                    }
                    AlbumScreenKt.PodcastChannelAccountItem(str4, str5, (Function0) objRememberedValue2, null, gapComposer2, 0);
                    gapComposer2.end(false);
                }
                break;
            case 2:
                LazyItemScopeImpl lazyItemScopeImpl = (LazyItemScopeImpl) obj;
                int iIntValue5 = ((Number) obj2).intValue();
                Composer composer3 = (Composer) obj3;
                int iIntValue6 = ((Number) obj4).intValue();
                int i3 = (iIntValue6 & 6) == 0 ? iIntValue6 | (((GapComposer) composer3).changed(lazyItemScopeImpl) ? 4 : 2) : iIntValue6;
                if ((iIntValue6 & 48) == 0) {
                    i3 |= ((GapComposer) composer3).changed(iIntValue5) ? 32 : 16;
                }
                GapComposer gapComposer3 = (GapComposer) composer3;
                if (!gapComposer3.shouldExecute(i3 & 1, (i3 & 147) != 146)) {
                    gapComposer3.skipToGroupEnd();
                } else {
                    Playlist playlist = (Playlist) list.get(iIntValue5);
                    gapComposer3.startReplaceGroup(-251504562);
                    boolean zChangedInstance3 = gapComposer3.changedInstance(navHostController) | gapComposer3.changed(playlist);
                    Object objRememberedValue3 = gapComposer3.rememberedValue();
                    if (zChangedInstance3 || objRememberedValue3 == neverEqualPolicy) {
                        objRememberedValue3 = new Http2Connection.ReaderRunnable(navHostController, playlist, (byte) 11);
                        gapComposer3.updateRememberedValue(objRememberedValue3);
                    }
                    MenuKt.PlaylistGridItem(playlist, ImageKt.m48combinedClickablehoGz1lA$default(companion, false, null, (Function0) objRememberedValue3, 255), true, null, false, gapComposer3, 384, 24);
                    gapComposer3.end(false);
                }
                break;
            default:
                LazyItemScopeImpl lazyItemScopeImpl2 = (LazyItemScopeImpl) obj;
                int iIntValue7 = ((Number) obj2).intValue();
                Composer composer4 = (Composer) obj3;
                int iIntValue8 = ((Number) obj4).intValue();
                int i4 = (iIntValue8 & 6) == 0 ? iIntValue8 | (((GapComposer) composer4).changed(lazyItemScopeImpl2) ? 4 : 2) : iIntValue8;
                if ((iIntValue8 & 48) == 0) {
                    i4 |= ((GapComposer) composer4).changed(iIntValue7) ? 32 : 16;
                }
                GapComposer gapComposer4 = (GapComposer) composer4;
                if (!gapComposer4.shouldExecute(i4 & 1, (i4 & 147) != 146)) {
                    gapComposer4.skipToGroupEnd();
                } else {
                    ArtistItem artistItem2 = (ArtistItem) list.get(iIntValue7);
                    gapComposer4.startReplaceGroup(-262368684);
                    String str6 = artistItem2.thumbnail;
                    String str7 = artistItem2.title;
                    Modifier modifierFillMaxWidth = SizeKt.fillMaxWidth(companion, 1.0f);
                    boolean zChangedInstance4 = gapComposer4.changedInstance(navHostController) | gapComposer4.changedInstance(artistItem2);
                    Object objRememberedValue4 = gapComposer4.rememberedValue();
                    if (zChangedInstance4 || objRememberedValue4 == neverEqualPolicy) {
                        objRememberedValue4 = new AccountScreenKt$AccountScreen$1$1$11$2$1(navHostController, artistItem2, (byte) 2);
                        gapComposer4.updateRememberedValue(objRememberedValue4);
                    }
                    LibraryScreenKt.PodcastArtistChannelItem(str6, str7, LazyItemScopeImpl.animateItem$default(lazyItemScopeImpl2, ImageKt.m46clickableoSLSa3U$default(modifierFillMaxWidth, false, null, (Function0) objRememberedValue4, 15)), gapComposer4, 0);
                    gapComposer4.end(false);
                }
                break;
        }
        return unit;
    }
}
