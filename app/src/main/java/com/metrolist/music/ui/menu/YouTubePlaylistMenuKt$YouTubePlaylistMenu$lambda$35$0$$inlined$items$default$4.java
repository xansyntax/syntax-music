package com.metrolist.music.ui.menu;

import androidx.compose.animation.core.SpringSpec;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.lazy.LazyItemScopeImpl;
import androidx.compose.foundation.lazy.grid.LazyGridItemScopeImpl;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material3.ListItemColors;
import androidx.compose.material3.ListItemKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.runtime.internal.Expect_jvmKt;
import androidx.compose.runtime.internal.PersistentCompositionLocalHashMap;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.BiasAlignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.ZIndexModifierKt;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.LayoutNode;
import androidx.navigation.NavHostController;
import androidx.navigation.compose.NavHostKt$NavHost$32;
import coil3.compose.AsyncImageKt;
import com.metrolist.innertube.models.YTItem;
import com.metrolist.innertube.pages.MoodAndGenres;
import com.metrolist.music.constants.DimensionsKt;
import com.metrolist.music.models.MediaMetadata;
import com.metrolist.music.ui.component.DraggableLyricsProviderItem;
import com.metrolist.music.ui.component.GlassComponentsKt;
import com.metrolist.music.ui.screens.AlbumScreenKt;
import com.metrolist.music.ui.utils.YouTubeUtilsKt;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.text.CharsKt;
import okhttp3.internal.http2.Http2Connection;
import sh.calvin.reorderable.ReorderableLazyListState;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class YouTubePlaylistMenuKt$YouTubePlaylistMenu$lambda$35$0$$inlined$items$default$4 implements Function4 {
    public final /* synthetic */ Object $artistNameAliases$inlined;
    public final /* synthetic */ List $items;
    public final /* synthetic */ byte $r8$classId;

    public /* synthetic */ YouTubePlaylistMenuKt$YouTubePlaylistMenu$lambda$35$0$$inlined$items$default$4(List list, Object obj, byte b) {
        this.$r8$classId = b;
        this.$items = list;
        this.$artistNameAliases$inlined = obj;
    }

    @Override // kotlin.jvm.functions.Function4
    public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
        Object obj5;
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        Object obj6 = this.$artistNameAliases$inlined;
        List list = this.$items;
        byte b2 = 4;
        boolean z = true;
        final byte b3 = 0;
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
                    final MediaMetadata mediaMetadata = (MediaMetadata) list.get(iIntValue);
                    gapComposer.startReplaceGroup(-1945679676);
                    ListItemColors listItemColorsGlassListItemColors = GlassComponentsKt.glassListItemColors(gapComposer);
                    ComposableLambdaImpl composableLambdaImplRememberComposableLambda = Expect_jvmKt.rememberComposableLambda(707869374, new Function2() { // from class: com.metrolist.music.ui.menu.YouTubePlaylistMenuKt$YouTubePlaylistMenu$13$1$2$1
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj7, Object obj8) {
                            byte b4 = b3;
                            Unit unit2 = Unit.INSTANCE;
                            MediaMetadata mediaMetadata2 = mediaMetadata;
                            switch (b4) {
                                case 0:
                                    Composer composer2 = (Composer) obj7;
                                    int iIntValue3 = ((Number) obj8).intValue();
                                    GapComposer gapComposer2 = (GapComposer) composer2;
                                    if (!gapComposer2.shouldExecute(iIntValue3 & 1, (iIntValue3 & 3) != 2)) {
                                        gapComposer2.skipToGroupEnd();
                                    } else {
                                        BiasAlignment biasAlignment = Alignment.Companion.Center;
                                        SpringSpec springSpec = DimensionsKt.NavigationBarAnimationSpec;
                                        Modifier modifierM151size3ABfNKs = SizeKt.m151size3ABfNKs(Modifier.Companion.$$INSTANCE, 48.0f);
                                        MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(biasAlignment, false);
                                        int iHashCode = Long.hashCode(gapComposer2.compositeKeyHashCode);
                                        PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope = gapComposer2.currentCompositionLocalScope();
                                        Modifier modifierMaterializeModifier = ZIndexModifierKt.materializeModifier(gapComposer2, modifierM151size3ABfNKs);
                                        ComposeUiNode.Companion.getClass();
                                        gapComposer2.startReusableNode();
                                        if (gapComposer2.inserting) {
                                            gapComposer2.createNode(LayoutNode.Constructor);
                                        } else {
                                            gapComposer2.useNode();
                                        }
                                        Stack.m390setimpl(gapComposer2, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.Companion.SetMeasurePolicy);
                                        Stack.m390setimpl(gapComposer2, persistentCompositionLocalHashMapCurrentCompositionLocalScope, ComposeUiNode.Companion.SetResolvedCompositionLocals);
                                        Stack.m390setimpl(gapComposer2, Integer.valueOf(iHashCode), ComposeUiNode.Companion.SetCompositeKeyHash);
                                        Stack.m389reconcileimpl(gapComposer2);
                                        Stack.m390setimpl(gapComposer2, modifierMaterializeModifier, ComposeUiNode.Companion.SetModifier);
                                        String str = mediaMetadata2.thumbnailUrl;
                                        AsyncImageKt.m849AsyncImage10Xjiaw(str != null ? YouTubeUtilsKt.resize(str, 200, 200) : null, ClipKt.clip(SizeKt.FillWholeMaxSize, RoundedCornerShapeKt.m185RoundedCornerShape0680j_4(10.0f)), null, gapComposer2, 48, 2040);
                                        gapComposer2.end(true);
                                    }
                                    break;
                                default:
                                    Composer composer3 = (Composer) obj7;
                                    int iIntValue4 = ((Number) obj8).intValue();
                                    GapComposer gapComposer3 = (GapComposer) composer3;
                                    if (!gapComposer3.shouldExecute(iIntValue4 & 1, (iIntValue4 & 3) != 2)) {
                                        gapComposer3.skipToGroupEnd();
                                    } else {
                                        TextKt.m352TextNvy7gAk(mediaMetadata2.title, null, 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer3, 0, 0, 262142);
                                    }
                                    break;
                            }
                            return unit2;
                        }
                    }, gapComposer);
                    ComposableLambdaImpl composableLambdaImplRememberComposableLambda2 = Expect_jvmKt.rememberComposableLambda(-1684200895, new NavHostKt$NavHost$32.AnonymousClass1(mediaMetadata, (Map) obj6, b2), gapComposer);
                    final byte b4 = z ? (byte) 1 : (byte) 0;
                    ListItemKt.ListItem(null, false, composableLambdaImplRememberComposableLambda, null, composableLambdaImplRememberComposableLambda2, null, null, listItemColorsGlassListItemColors, null, null, Expect_jvmKt.rememberComposableLambda(1581568532, new Function2() { // from class: com.metrolist.music.ui.menu.YouTubePlaylistMenuKt$YouTubePlaylistMenu$13$1$2$1
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj7, Object obj8) {
                            byte b5 = b4;
                            Unit unit2 = Unit.INSTANCE;
                            MediaMetadata mediaMetadata2 = mediaMetadata;
                            switch (b5) {
                                case 0:
                                    Composer composer2 = (Composer) obj7;
                                    int iIntValue3 = ((Number) obj8).intValue();
                                    GapComposer gapComposer2 = (GapComposer) composer2;
                                    if (!gapComposer2.shouldExecute(iIntValue3 & 1, (iIntValue3 & 3) != 2)) {
                                        gapComposer2.skipToGroupEnd();
                                    } else {
                                        BiasAlignment biasAlignment = Alignment.Companion.Center;
                                        SpringSpec springSpec = DimensionsKt.NavigationBarAnimationSpec;
                                        Modifier modifierM151size3ABfNKs = SizeKt.m151size3ABfNKs(Modifier.Companion.$$INSTANCE, 48.0f);
                                        MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(biasAlignment, false);
                                        int iHashCode = Long.hashCode(gapComposer2.compositeKeyHashCode);
                                        PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope = gapComposer2.currentCompositionLocalScope();
                                        Modifier modifierMaterializeModifier = ZIndexModifierKt.materializeModifier(gapComposer2, modifierM151size3ABfNKs);
                                        ComposeUiNode.Companion.getClass();
                                        gapComposer2.startReusableNode();
                                        if (gapComposer2.inserting) {
                                            gapComposer2.createNode(LayoutNode.Constructor);
                                        } else {
                                            gapComposer2.useNode();
                                        }
                                        Stack.m390setimpl(gapComposer2, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.Companion.SetMeasurePolicy);
                                        Stack.m390setimpl(gapComposer2, persistentCompositionLocalHashMapCurrentCompositionLocalScope, ComposeUiNode.Companion.SetResolvedCompositionLocals);
                                        Stack.m390setimpl(gapComposer2, Integer.valueOf(iHashCode), ComposeUiNode.Companion.SetCompositeKeyHash);
                                        Stack.m389reconcileimpl(gapComposer2);
                                        Stack.m390setimpl(gapComposer2, modifierMaterializeModifier, ComposeUiNode.Companion.SetModifier);
                                        String str = mediaMetadata2.thumbnailUrl;
                                        AsyncImageKt.m849AsyncImage10Xjiaw(str != null ? YouTubeUtilsKt.resize(str, 200, 200) : null, ClipKt.clip(SizeKt.FillWholeMaxSize, RoundedCornerShapeKt.m185RoundedCornerShape0680j_4(10.0f)), null, gapComposer2, 48, 2040);
                                        gapComposer2.end(true);
                                    }
                                    break;
                                default:
                                    Composer composer3 = (Composer) obj7;
                                    int iIntValue4 = ((Number) obj8).intValue();
                                    GapComposer gapComposer3 = (GapComposer) composer3;
                                    if (!gapComposer3.shouldExecute(iIntValue4 & 1, (iIntValue4 & 3) != 2)) {
                                        gapComposer3.skipToGroupEnd();
                                    } else {
                                        TextKt.m352TextNvy7gAk(mediaMetadata2.title, null, 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer3, 0, 0, 262142);
                                    }
                                    break;
                            }
                            return unit2;
                        }
                    }, gapComposer), gapComposer, 196992, 1755);
                    gapComposer.end(false);
                }
                break;
            case 1:
                LazyItemScopeImpl lazyItemScopeImpl2 = (LazyItemScopeImpl) obj;
                int iIntValue3 = ((Number) obj2).intValue();
                Composer composer2 = (Composer) obj3;
                int iIntValue4 = ((Number) obj4).intValue();
                int i2 = (iIntValue4 & 6) == 0 ? (((GapComposer) composer2).changed(lazyItemScopeImpl2) ? 4 : 2) | iIntValue4 : iIntValue4;
                if ((iIntValue4 & 48) == 0) {
                    i2 |= ((GapComposer) composer2).changed(iIntValue3) ? 32 : 16;
                }
                GapComposer gapComposer2 = (GapComposer) composer2;
                if (!gapComposer2.shouldExecute(i2 & 1, (i2 & 147) != 146)) {
                    gapComposer2.skipToGroupEnd();
                } else {
                    DraggableLyricsProviderItem draggableLyricsProviderItem = (DraggableLyricsProviderItem) list.get(iIntValue3);
                    gapComposer2.startReplaceGroup(1707242633);
                    CharsKt.ReorderableItem(lazyItemScopeImpl2, (ReorderableLazyListState) obj6, draggableLyricsProviderItem.id, null, false, null, Expect_jvmKt.rememberComposableLambda(-986376362, new SongMenuKt$SongMenu$lambda$33$0$$inlined$items$default$4((byte) 5, draggableLyricsProviderItem), gapComposer2), gapComposer2, (i2 & 14) | 1572864);
                    gapComposer2.end(false);
                }
                break;
            case 2:
                LazyGridItemScopeImpl lazyGridItemScopeImpl = (LazyGridItemScopeImpl) obj;
                int iIntValue5 = ((Number) obj2).intValue();
                Composer composer3 = (Composer) obj3;
                int iIntValue6 = ((Number) obj4).intValue();
                NavHostController navHostController = (NavHostController) obj6;
                int i3 = (iIntValue6 & 6) == 0 ? iIntValue6 | (((GapComposer) composer3).changed(lazyGridItemScopeImpl) ? 4 : 2) : iIntValue6;
                if ((iIntValue6 & 48) == 0) {
                    i3 |= ((GapComposer) composer3).changed(iIntValue5) ? 32 : 16;
                }
                GapComposer gapComposer3 = (GapComposer) composer3;
                if (!gapComposer3.shouldExecute(i3 & 1, (i3 & 147) != 146)) {
                    gapComposer3.skipToGroupEnd();
                } else {
                    MoodAndGenres.Item item = (MoodAndGenres.Item) ((ArrayList) list).get(iIntValue5);
                    gapComposer3.startReplaceGroup(1520002122);
                    String str = item.title;
                    boolean zChangedInstance = gapComposer3.changedInstance(navHostController) | gapComposer3.changedInstance(item);
                    Object objRememberedValue = gapComposer3.rememberedValue();
                    if (zChangedInstance || objRememberedValue == Composer.Companion.Empty) {
                        obj5 = objRememberedValue;
                        Http2Connection.ReaderRunnable readerRunnable = new Http2Connection.ReaderRunnable(navHostController, item, (byte) 7);
                        gapComposer3.updateRememberedValue(readerRunnable);
                        obj5 = readerRunnable;
                    }
                    obj5 = objRememberedValue;
                    AlbumScreenKt.MoodAndGenresButton(str, (Function0) obj5, SizeKt.m155width3ABfNKs(OffsetKt.m135padding3ABfNKs(Modifier.Companion.$$INSTANCE, 6.0f), 180.0f), gapComposer3, 384);
                    gapComposer3.end(false);
                }
                break;
            default:
                LazyItemScopeImpl lazyItemScopeImpl3 = (LazyItemScopeImpl) obj;
                int iIntValue7 = ((Number) obj2).intValue();
                Composer composer4 = (Composer) obj3;
                int iIntValue8 = ((Number) obj4).intValue();
                int i4 = (iIntValue8 & 6) == 0 ? (((GapComposer) composer4).changed(lazyItemScopeImpl3) ? 4 : 2) | iIntValue8 : iIntValue8;
                if ((iIntValue8 & 48) == 0) {
                    i4 |= ((GapComposer) composer4).changed(iIntValue7) ? 32 : 16;
                }
                GapComposer gapComposer4 = (GapComposer) composer4;
                if (!gapComposer4.shouldExecute(i4 & 1, (i4 & 147) != 146)) {
                    gapComposer4.skipToGroupEnd();
                } else {
                    YTItem yTItem = (YTItem) list.get(iIntValue7);
                    gapComposer4.startReplaceGroup(317249555);
                    ((ComposableLambdaImpl) obj6).invoke(lazyItemScopeImpl3, yTItem, gapComposer4, Integer.valueOf(384 | (i4 & 14)));
                    gapComposer4.end(false);
                }
                break;
        }
        return unit;
    }
}
