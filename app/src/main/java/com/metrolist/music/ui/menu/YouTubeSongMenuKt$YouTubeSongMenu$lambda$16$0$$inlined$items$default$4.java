package com.metrolist.music.ui.menu;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.compose.animation.core.SpringSpec;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowMeasurePolicy;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.lazy.LazyItemScopeImpl;
import androidx.compose.material3.TextKt;
import androidx.compose.material3.TextKt$$ExternalSyntheticLambda3;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.NeverEqualPolicy;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater$$ExternalSyntheticLambda0;
import androidx.compose.runtime.internal.PersistentCompositionLocalHashMap;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.BiasAlignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.ZIndexModifierKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.text.font.FontWeight;
import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import androidx.media3.common.Format$$ExternalSyntheticOutline0;
import androidx.navigation.NavHostController;
import com.google.common.math.IntMath;
import com.metrolist.music.constants.DimensionsKt;
import com.metrolist.music.db.MusicDatabase;
import com.metrolist.music.db.entities.Album;
import com.metrolist.music.db.entities.PodcastEntity;
import com.metrolist.music.eq.data.SavedEQProfile;
import com.metrolist.music.models.MediaMetadata;
import com.metrolist.music.ui.component.LibraryKt;
import com.metrolist.music.ui.component.MenuState;
import com.metrolist.music.ui.screens.AccountScreenKt$AccountScreen$1$1$11$1$1;
import com.metrolist.music.ui.screens.AccountScreenKt$AccountScreen$1$1$17$1$1;
import com.metrolist.music.ui.screens.equalizer.EqScreenKt;
import com.metrolist.music.ui.screens.library.LibraryScreenKt;
import com.yalantis.ucrop.view.CropImageView;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class YouTubeSongMenuKt$YouTubeSongMenu$lambda$16$0$$inlined$items$default$4 implements Function4 {
    public final /* synthetic */ List $items;
    public final /* synthetic */ Object $navController$inlined;
    public final /* synthetic */ Object $onDismiss$inlined;
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ Object $showSelectArtistDialog$delegate$inlined;

    public /* synthetic */ YouTubeSongMenuKt$YouTubeSongMenu$lambda$16$0$$inlined$items$default$4(List list, Object obj, Object obj2, Object obj3, byte b) {
        this.$r8$classId = b;
        this.$items = list;
        this.$navController$inlined = obj;
        this.$showSelectArtistDialog$delegate$inlined = obj2;
        this.$onDismiss$inlined = obj3;
    }

    @Override // kotlin.jvm.functions.Function4
    public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
        MediaMetadata.Album album;
        byte b = this.$r8$classId;
        String str = null;
        Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
        NeverEqualPolicy neverEqualPolicy = Composer.Companion.Empty;
        Unit unit = Unit.INSTANCE;
        List list = this.$items;
        Object obj5 = this.$navController$inlined;
        Object obj6 = this.$showSelectArtistDialog$delegate$inlined;
        Object obj7 = this.$onDismiss$inlined;
        byte b2 = 2;
        final byte b3 = 0;
        final byte b4 = 1;
        switch (b) {
            case 0:
                LazyItemScopeImpl lazyItemScopeImpl = (LazyItemScopeImpl) obj;
                int iIntValue = ((Number) obj2).intValue();
                Composer composer = (Composer) obj3;
                int iIntValue2 = ((Number) obj4).intValue();
                final Function0 function0 = (Function0) obj7;
                final MutableState mutableState = (MutableState) obj6;
                final NavHostController navHostController = (NavHostController) obj5;
                int i = (iIntValue2 & 6) == 0 ? iIntValue2 | (((GapComposer) composer).changed(lazyItemScopeImpl) ? 4 : 2) : iIntValue2;
                if ((iIntValue2 & 48) == 0) {
                    i |= ((GapComposer) composer).changed(iIntValue) ? 32 : 16;
                }
                GapComposer gapComposer = (GapComposer) composer;
                if (!gapComposer.shouldExecute(i & 1, (i & 147) != 146)) {
                    gapComposer.skipToGroupEnd();
                } else {
                    final MediaMetadata.Artist artist = (MediaMetadata.Artist) list.get(iIntValue);
                    gapComposer.startReplaceGroup(1437442614);
                    BiasAlignment.Vertical vertical = Alignment.Companion.CenterVertically;
                    SpringSpec springSpec = DimensionsKt.NavigationBarAnimationSpec;
                    Modifier modifierM145height3ABfNKs = SizeKt.m145height3ABfNKs(companion, 64.0f);
                    boolean zChangedInstance = gapComposer.changedInstance(navHostController) | gapComposer.changedInstance(artist) | gapComposer.changed(mutableState) | gapComposer.changed(function0);
                    Object objRememberedValue = gapComposer.rememberedValue();
                    if (zChangedInstance || objRememberedValue == neverEqualPolicy) {
                        final byte b5 = 0;
                        objRememberedValue = new Function0() { // from class: com.metrolist.music.ui.menu.YouTubeSongMenuKt$YouTubeSongMenu$6$1$1$1$1
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                byte b6 = b5;
                                Unit unit2 = Unit.INSTANCE;
                                Function0 function1 = function0;
                                MutableState mutableState2 = mutableState;
                                MediaMetadata.Artist artist2 = artist;
                                NavHostController navHostController2 = navHostController;
                                switch (b6) {
                                    case 0:
                                        Format$$ExternalSyntheticOutline0.m("artist/", artist2.id, navHostController2);
                                        mutableState2.setValue(Boolean.FALSE);
                                        function1.invoke();
                                        break;
                                    default:
                                        Format$$ExternalSyntheticOutline0.m("artist/", artist2.id, navHostController2);
                                        mutableState2.setValue(Boolean.FALSE);
                                        function1.invoke();
                                        break;
                                }
                                return unit2;
                            }
                        };
                        gapComposer.updateRememberedValue(objRememberedValue);
                    }
                    Modifier modifierM137paddingVpY3zN4$default = OffsetKt.m137paddingVpY3zN4$default(ImageKt.m46clickableoSLSa3U$default(modifierM145height3ABfNKs, false, null, (Function0) objRememberedValue, 15), 12.0f, CropImageView.DEFAULT_ASPECT_RATIO, 2);
                    RowMeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(OffsetKt.Start, vertical, gapComposer, 48);
                    int iHashCode = Long.hashCode(gapComposer.compositeKeyHashCode);
                    PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope = gapComposer.currentCompositionLocalScope();
                    Modifier modifierMaterializeModifier = ZIndexModifierKt.materializeModifier(gapComposer, modifierM137paddingVpY3zN4$default);
                    ComposeUiNode.Companion.getClass();
                    gapComposer.startReusableNode();
                    boolean z = gapComposer.inserting;
                    TextKt$$ExternalSyntheticLambda3 textKt$$ExternalSyntheticLambda3 = LayoutNode.Constructor;
                    if (z) {
                        gapComposer.createNode(textKt$$ExternalSyntheticLambda3);
                    } else {
                        gapComposer.useNode();
                    }
                    Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda0 = ComposeUiNode.Companion.SetMeasurePolicy;
                    Stack.m390setimpl(gapComposer, rowMeasurePolicy, updater$$ExternalSyntheticLambda0);
                    Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda1 = ComposeUiNode.Companion.SetResolvedCompositionLocals;
                    Stack.m390setimpl(gapComposer, persistentCompositionLocalHashMapCurrentCompositionLocalScope, updater$$ExternalSyntheticLambda1);
                    Integer numValueOf = Integer.valueOf(iHashCode);
                    Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda2 = ComposeUiNode.Companion.SetCompositeKeyHash;
                    Stack.m390setimpl(gapComposer, numValueOf, updater$$ExternalSyntheticLambda2);
                    Stack.m389reconcileimpl(gapComposer);
                    Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda3 = ComposeUiNode.Companion.SetModifier;
                    Stack.m390setimpl(gapComposer, modifierMaterializeModifier, updater$$ExternalSyntheticLambda3);
                    BiasAlignment biasAlignment = Alignment.Companion.CenterStart;
                    Modifier modifierM145height3ABfNKs2 = SizeKt.m145height3ABfNKs(LazyItemScopeImpl.fillParentMaxWidth$default(lazyItemScopeImpl), 64.0f);
                    boolean zChangedInstance2 = gapComposer.changedInstance(navHostController) | gapComposer.changedInstance(artist) | gapComposer.changed(mutableState) | gapComposer.changed(function0);
                    Object objRememberedValue2 = gapComposer.rememberedValue();
                    if (zChangedInstance2 || objRememberedValue2 == neverEqualPolicy) {
                        final byte b6 = 1;
                        objRememberedValue2 = new Function0() { // from class: com.metrolist.music.ui.menu.YouTubeSongMenuKt$YouTubeSongMenu$6$1$1$1$1
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                byte b7 = b6;
                                Unit unit2 = Unit.INSTANCE;
                                Function0 function1 = function0;
                                MutableState mutableState2 = mutableState;
                                MediaMetadata.Artist artist2 = artist;
                                NavHostController navHostController2 = navHostController;
                                switch (b7) {
                                    case 0:
                                        Format$$ExternalSyntheticOutline0.m("artist/", artist2.id, navHostController2);
                                        mutableState2.setValue(Boolean.FALSE);
                                        function1.invoke();
                                        break;
                                    default:
                                        Format$$ExternalSyntheticOutline0.m("artist/", artist2.id, navHostController2);
                                        mutableState2.setValue(Boolean.FALSE);
                                        function1.invoke();
                                        break;
                                }
                                return unit2;
                            }
                        };
                        gapComposer.updateRememberedValue(objRememberedValue2);
                    }
                    Modifier modifierM137paddingVpY3zN4$default2 = OffsetKt.m137paddingVpY3zN4$default(ImageKt.m46clickableoSLSa3U$default(modifierM145height3ABfNKs2, false, null, (Function0) objRememberedValue2, 15), 24.0f, CropImageView.DEFAULT_ASPECT_RATIO, 2);
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(biasAlignment, false);
                    int iHashCode2 = Long.hashCode(gapComposer.compositeKeyHashCode);
                    PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope2 = gapComposer.currentCompositionLocalScope();
                    Modifier modifierMaterializeModifier2 = ZIndexModifierKt.materializeModifier(gapComposer, modifierM137paddingVpY3zN4$default2);
                    gapComposer.startReusableNode();
                    if (gapComposer.inserting) {
                        gapComposer.createNode(textKt$$ExternalSyntheticLambda3);
                    } else {
                        gapComposer.useNode();
                    }
                    Stack.m390setimpl(gapComposer, measurePolicyMaybeCachedBoxMeasurePolicy, updater$$ExternalSyntheticLambda0);
                    Stack.m390setimpl(gapComposer, persistentCompositionLocalHashMapCurrentCompositionLocalScope2, updater$$ExternalSyntheticLambda1);
                    IntIntPair$$ExternalSyntheticOutline0.m(iHashCode2, gapComposer, updater$$ExternalSyntheticLambda2, gapComposer);
                    Stack.m390setimpl(gapComposer, modifierMaterializeModifier2, updater$$ExternalSyntheticLambda3);
                    TextKt.m352TextNvy7gAk(artist.name, null, 0L, IntMath.getSp(18), null, FontWeight.Bold, null, 0L, null, 0L, 2, false, 1, 0, null, gapComposer, 1597440, 24960, 241582);
                    Fragment$5$$ExternalSyntheticOutline0.m(gapComposer, true, true, false);
                }
                break;
            case 1:
                LazyItemScopeImpl lazyItemScopeImpl2 = (LazyItemScopeImpl) obj;
                int iIntValue3 = ((Number) obj2).intValue();
                Composer composer2 = (Composer) obj3;
                int iIntValue4 = ((Number) obj4).intValue();
                final Function1 function1 = (Function1) obj7;
                final Function1 function2 = (Function1) obj6;
                int i2 = (iIntValue4 & 6) == 0 ? iIntValue4 | (((GapComposer) composer2).changed(lazyItemScopeImpl2) ? 4 : 2) : iIntValue4;
                if ((iIntValue4 & 48) == 0) {
                    i2 |= ((GapComposer) composer2).changed(iIntValue3) ? 32 : 16;
                }
                GapComposer gapComposer2 = (GapComposer) composer2;
                if (!gapComposer2.shouldExecute(i2 & 1, (i2 & 147) != 146)) {
                    gapComposer2.skipToGroupEnd();
                } else {
                    final SavedEQProfile savedEQProfile = (SavedEQProfile) ((ArrayList) list).get(iIntValue3);
                    gapComposer2.startReplaceGroup(1724918620);
                    boolean zAreEqual = Intrinsics.areEqual((String) obj5, savedEQProfile.id);
                    boolean zChanged = gapComposer2.changed(function2) | gapComposer2.changedInstance(savedEQProfile);
                    Object objRememberedValue3 = gapComposer2.rememberedValue();
                    if (zChanged || objRememberedValue3 == neverEqualPolicy) {
                        objRememberedValue3 = new Function0() { // from class: com.metrolist.music.ui.screens.equalizer.EqScreenKt$EqScreenContent$2$1$1$3$1$1
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                byte b7 = b3;
                                Unit unit2 = Unit.INSTANCE;
                                SavedEQProfile savedEQProfile2 = savedEQProfile;
                                Function1 function3 = function2;
                                switch (b7) {
                                    case 0:
                                        function3.invoke(savedEQProfile2.id);
                                        break;
                                    default:
                                        function3.invoke(savedEQProfile2.id);
                                        break;
                                }
                                return unit2;
                            }
                        };
                        gapComposer2.updateRememberedValue(objRememberedValue3);
                    }
                    Function0 function3 = (Function0) objRememberedValue3;
                    boolean zChanged2 = gapComposer2.changed(function1) | gapComposer2.changedInstance(savedEQProfile);
                    Object objRememberedValue4 = gapComposer2.rememberedValue();
                    if (zChanged2 || objRememberedValue4 == neverEqualPolicy) {
                        objRememberedValue4 = new Function0() { // from class: com.metrolist.music.ui.screens.equalizer.EqScreenKt$EqScreenContent$2$1$1$3$1$1
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                byte b7 = b4;
                                Unit unit2 = Unit.INSTANCE;
                                SavedEQProfile savedEQProfile2 = savedEQProfile;
                                Function1 function4 = function1;
                                switch (b7) {
                                    case 0:
                                        function4.invoke(savedEQProfile2.id);
                                        break;
                                    default:
                                        function4.invoke(savedEQProfile2.id);
                                        break;
                                }
                                return unit2;
                            }
                        };
                        gapComposer2.updateRememberedValue(objRememberedValue4);
                    }
                    SavedEQProfile.Companion companion2 = SavedEQProfile.INSTANCE;
                    EqScreenKt.EQProfileItem(savedEQProfile, zAreEqual, function3, (Function0) objRememberedValue4, gapComposer2, 8);
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
                if (!gapComposer3.shouldExecute(1 & i3, (i3 & 147) != 146)) {
                    gapComposer3.skipToGroupEnd();
                } else {
                    Album album2 = (Album) list.get(iIntValue5);
                    gapComposer3.startReplaceGroup(183226335);
                    String str2 = album2.album.id;
                    MediaMetadata mediaMetadata = (MediaMetadata) ((State) obj6).getValue();
                    if (mediaMetadata != null && (album = mediaMetadata.album) != null) {
                        str = album.id;
                    }
                    LibraryKt.LibraryAlbumListItem(LazyItemScopeImpl.animateItem$default(lazyItemScopeImpl3, companion), (MenuState) obj5, album2, Intrinsics.areEqual(str2, str), ((Boolean) ((State) obj7).getValue()).booleanValue(), gapComposer3, 0);
                    gapComposer3.end(false);
                }
                break;
            default:
                LazyItemScopeImpl lazyItemScopeImpl4 = (LazyItemScopeImpl) obj;
                int iIntValue7 = ((Number) obj2).intValue();
                Composer composer4 = (Composer) obj3;
                int iIntValue8 = ((Number) obj4).intValue();
                MusicDatabase musicDatabase = (MusicDatabase) obj7;
                MenuState menuState = (MenuState) obj6;
                NavHostController navHostController2 = (NavHostController) obj5;
                int i4 = (iIntValue8 & 6) == 0 ? iIntValue8 | (((GapComposer) composer4).changed(lazyItemScopeImpl4) ? 4 : 2) : iIntValue8;
                if ((iIntValue8 & 48) == 0) {
                    i4 |= ((GapComposer) composer4).changed(iIntValue7) ? 32 : 16;
                }
                GapComposer gapComposer4 = (GapComposer) composer4;
                if (!gapComposer4.shouldExecute(i4 & 1, (i4 & 147) != 146)) {
                    gapComposer4.skipToGroupEnd();
                } else {
                    PodcastEntity podcastEntity = (PodcastEntity) list.get(iIntValue7);
                    gapComposer4.startReplaceGroup(121030553);
                    boolean zChangedInstance3 = gapComposer4.changedInstance(navHostController2) | gapComposer4.changed(podcastEntity);
                    Object objRememberedValue5 = gapComposer4.rememberedValue();
                    if (zChangedInstance3 || objRememberedValue5 == neverEqualPolicy) {
                        objRememberedValue5 = new AccountScreenKt$AccountScreen$1$1$17$1$1(navHostController2, podcastEntity, (byte) 1);
                        gapComposer4.updateRememberedValue(objRememberedValue5);
                    }
                    Function0 function4 = (Function0) objRememberedValue5;
                    boolean zChanged3 = gapComposer4.changed(menuState) | gapComposer4.changed(podcastEntity) | gapComposer4.changedInstance(musicDatabase);
                    Object objRememberedValue6 = gapComposer4.rememberedValue();
                    if (zChanged3 || objRememberedValue6 == neverEqualPolicy) {
                        objRememberedValue6 = new AccountScreenKt$AccountScreen$1$1$11$1$1(menuState, (Object) podcastEntity, (Object) musicDatabase, b2);
                        gapComposer4.updateRememberedValue(objRememberedValue6);
                    }
                    LibraryScreenKt.PodcastEpisodePlaylistItem(podcastEntity, function4, (Function0) objRememberedValue6, LazyItemScopeImpl.animateItem$default(lazyItemScopeImpl4, SizeKt.fillMaxWidth(companion, 1.0f)), gapComposer4, 0);
                    gapComposer4.end(false);
                }
                break;
        }
        return unit;
    }
}
