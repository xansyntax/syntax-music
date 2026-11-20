package com.metrolist.music.ui.player;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.compose.animation.AnimatedVisibilityScope;
import androidx.compose.animation.CrossfadeKt;
import androidx.compose.animation.SingleValueAnimationKt;
import androidx.compose.animation.core.AnimateAsStateKt;
import androidx.compose.animation.core.ArcSplineKt;
import androidx.compose.animation.core.SpringSpec;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.interaction.MutableInteractionSourceImpl;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnMeasurePolicy;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.LayoutWeightElement;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.PaddingValuesImpl;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowMeasurePolicy;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.lazy.LazyItemScopeImpl;
import androidx.compose.foundation.lazy.grid.LazyGridItemScopeImpl;
import androidx.compose.foundation.shape.RoundedCornerShape;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material3.ButtonColors;
import androidx.compose.material3.ButtonDefaults;
import androidx.compose.material3.CardKt;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.ListItemColors;
import androidx.compose.material3.ListItemKt;
import androidx.compose.material3.MaterialTheme$Values;
import androidx.compose.material3.MaterialThemeKt;
import androidx.compose.material3.TextKt;
import androidx.compose.material3.TextKt$$ExternalSyntheticLambda3;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.NeverEqualPolicy;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.StaticProvidableCompositionLocal;
import androidx.compose.runtime.Updater$$ExternalSyntheticLambda0;
import androidx.compose.runtime.internal.Expect_jvmKt;
import androidx.compose.runtime.internal.PersistentCompositionLocalHashMap;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.BiasAlignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.ZIndexModifierKt;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.graphics.BlendModeColorFilter;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import androidx.media3.common.Format$$ExternalSyntheticOutline0;
import com.atilika.kuromoji.ipadic.compile.DictionaryEntry;
import com.google.common.math.IntMath;
import com.metrolist.music.constants.DimensionsKt;
import com.metrolist.music.db.entities.LyricsEntity;
import com.metrolist.music.db.entities.Playlist;
import com.metrolist.music.db.entities.PlaylistEntity;
import com.metrolist.music.ui.component.DialogKt;
import com.metrolist.music.ui.component.GlassComponentsKt;
import com.metrolist.music.ui.component.ItemsKt$ListItem$2$1;
import com.metrolist.music.ui.component.MenuKt;
import com.metrolist.music.ui.component.shimmer.ShimmerHostKt;
import com.metrolist.music.ui.menu.AlbumMenuKt;
import com.metrolist.music.ui.menu.AlbumMenuKt$$ExternalSyntheticLambda6;
import com.metrolist.music.ui.menu.SongMenuKt$$ExternalSyntheticLambda2;
import com.metrolist.music.ui.screens.library.LibrarySongsScreenKt$$ExternalSyntheticLambda17;
import com.metrolist.music.ui.screens.podcast.OnlinePodcastScreenKt;
import com.metrolist.music.ui.screens.settings.AiSettingsKt;
import com.metrolist.music.ui.screens.settings.AlarmSettingsKt$$ExternalSyntheticLambda14;
import com.metrolist.music.ui.screens.settings.LyricsPosition;
import com.metrolist.music.ui.theme.UiStyleKt;
import com.yalantis.ucrop.R;
import com.yalantis.ucrop.view.CropImageView;
import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.text.StringsKt;
import kotlin.uuid.UuidKt;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class QueueKt$$ExternalSyntheticLambda21 implements Function3 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ MutableState f$0;

    public /* synthetic */ QueueKt$$ExternalSyntheticLambda21(MutableState mutableState, byte b) {
        this.$r8$classId = b;
        this.f$0 = mutableState;
    }

    private final Object invoke$com$metrolist$music$ui$screens$library$LibraryAlbumsScreenKt$$ExternalSyntheticLambda20(Object obj, Object obj2, Object obj3) throws XmlPullParserException, IOException {
        LazyItemScopeImpl lazyItemScopeImpl = (LazyItemScopeImpl) obj;
        Composer composer = (Composer) obj2;
        int iIntValue = ((Integer) obj3).intValue();
        lazyItemScopeImpl.getClass();
        if ((iIntValue & 6) == 0) {
            iIntValue |= ((GapComposer) composer).changed(lazyItemScopeImpl) ? 4 : 2;
        }
        GapComposer gapComposer = (GapComposer) composer;
        if (gapComposer.shouldExecute(iIntValue & 1, (iIntValue & 19) != 18)) {
            boolean zIsBlank = StringsKt.isBlank((String) this.f$0.getValue());
            Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
            if (zIsBlank) {
                gapComposer.startReplaceGroup(366386517);
                DialogKt.EmptyPlaceholder(R.drawable.album, 0, 0, gapComposer, LazyItemScopeImpl.animateItem$default(lazyItemScopeImpl, companion), MathKt.stringResource(R.string.library_album_empty, gapComposer));
                gapComposer.end(false);
            } else {
                gapComposer.startReplaceGroup(366238709);
                MenuKt.LibrarySearchEmptyPlaceholder(0, 0, 6, gapComposer, LazyItemScopeImpl.animateItem$default(lazyItemScopeImpl, companion), null);
                gapComposer.end(false);
            }
        } else {
            gapComposer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    private final Object invoke$com$metrolist$music$ui$screens$library$LibraryPlaylistsScreenKt$$ExternalSyntheticLambda11(Object obj, Object obj2, Object obj3) throws XmlPullParserException, IOException {
        LazyItemScopeImpl lazyItemScopeImpl = (LazyItemScopeImpl) obj;
        Composer composer = (Composer) obj2;
        int iIntValue = ((Integer) obj3).intValue();
        lazyItemScopeImpl.getClass();
        if ((iIntValue & 6) == 0) {
            iIntValue |= ((GapComposer) composer).changed(lazyItemScopeImpl) ? 4 : 2;
        }
        GapComposer gapComposer = (GapComposer) composer;
        if (gapComposer.shouldExecute(iIntValue & 1, (iIntValue & 19) != 18)) {
            boolean zIsBlank = StringsKt.isBlank((String) this.f$0.getValue());
            Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
            if (zIsBlank) {
                gapComposer.startReplaceGroup(-1365704059);
                MenuKt.LibrarySearchEmptyPlaceholder(R.drawable.playlist_play, 0, 0, gapComposer, LazyItemScopeImpl.animateItem$default(lazyItemScopeImpl, companion), MathKt.stringResource(R.string.library_playlist_empty, gapComposer));
                gapComposer.end(false);
            } else {
                gapComposer.startReplaceGroup(-1365844179);
                MenuKt.LibrarySearchEmptyPlaceholder(0, 0, 6, gapComposer, LazyItemScopeImpl.animateItem$default(lazyItemScopeImpl, companion), null);
                gapComposer.end(false);
            }
        } else {
            gapComposer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    private final Object invoke$com$metrolist$music$ui$screens$library$LibraryPlaylistsScreenKt$$ExternalSyntheticLambda21(Object obj, Object obj2, Object obj3) throws XmlPullParserException, IOException {
        LazyGridItemScopeImpl lazyGridItemScopeImpl = (LazyGridItemScopeImpl) obj;
        Composer composer = (Composer) obj2;
        int iIntValue = ((Integer) obj3).intValue();
        lazyGridItemScopeImpl.getClass();
        if ((iIntValue & 6) == 0) {
            iIntValue |= ((GapComposer) composer).changed(lazyGridItemScopeImpl) ? 4 : 2;
        }
        GapComposer gapComposer = (GapComposer) composer;
        if (gapComposer.shouldExecute(iIntValue & 1, (iIntValue & 19) != 18)) {
            boolean zIsBlank = StringsKt.isBlank((String) this.f$0.getValue());
            Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
            if (zIsBlank) {
                gapComposer.startReplaceGroup(104380240);
                MenuKt.LibrarySearchEmptyPlaceholder(R.drawable.playlist_play, 0, 0, gapComposer, LazyGridItemScopeImpl.animateItem$default(lazyGridItemScopeImpl, companion), MathKt.stringResource(R.string.library_playlist_empty, gapComposer));
                gapComposer.end(false);
            } else {
                gapComposer.startReplaceGroup(104240120);
                MenuKt.LibrarySearchEmptyPlaceholder(0, 0, 6, gapComposer, LazyGridItemScopeImpl.animateItem$default(lazyGridItemScopeImpl, companion), null);
                gapComposer.end(false);
            }
        } else {
            gapComposer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    private final Object invoke$com$metrolist$music$ui$screens$playlist$LocalPlaylistScreenKt$$ExternalSyntheticLambda18(Object obj, Object obj2, Object obj3) {
        Composer composer = (Composer) obj2;
        int iIntValue = ((Integer) obj3).intValue();
        ((ColumnScopeInstance) obj).getClass();
        GapComposer gapComposer = (GapComposer) composer;
        if (gapComposer.shouldExecute(iIntValue & 1, (iIntValue & 17) != 16)) {
            Playlist playlist = (Playlist) this.f$0.getValue();
            PlaylistEntity playlistEntity = playlist != null ? playlist.playlist : null;
            playlistEntity.getClass();
            TextKt.m352TextNvy7gAk(MathKt.stringResource(R.string.remove_download_playlist_confirm, new Object[]{playlistEntity.name}, gapComposer), OffsetKt.m137paddingVpY3zN4$default(Modifier.Companion.$$INSTANCE, 18.0f, CropImageView.DEFAULT_ASPECT_RATIO, 2), 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, ((MaterialTheme$Values) gapComposer.consume(MaterialThemeKt._localMaterialTheme)).typography.bodyLarge, gapComposer, 48, 0, 131068);
        } else {
            gapComposer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    private final Object invoke$com$metrolist$music$ui$screens$playlist$LocalPlaylistScreenKt$$ExternalSyntheticLambda3(Object obj, Object obj2, Object obj3) {
        Composer composer = (Composer) obj2;
        int iIntValue = ((Integer) obj3).intValue();
        ((ColumnScopeInstance) obj).getClass();
        GapComposer gapComposer = (GapComposer) composer;
        if (gapComposer.shouldExecute(iIntValue & 1, (iIntValue & 17) != 16)) {
            Playlist playlist = (Playlist) this.f$0.getValue();
            PlaylistEntity playlistEntity = playlist != null ? playlist.playlist : null;
            playlistEntity.getClass();
            TextKt.m352TextNvy7gAk(MathKt.stringResource(R.string.delete_playlist_confirm, new Object[]{playlistEntity.name}, gapComposer), OffsetKt.m137paddingVpY3zN4$default(Modifier.Companion.$$INSTANCE, 18.0f, CropImageView.DEFAULT_ASPECT_RATIO, 2), 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, ((MaterialTheme$Values) gapComposer.consume(MaterialThemeKt._localMaterialTheme)).typography.bodyLarge, gapComposer, 48, 0, 131068);
        } else {
            gapComposer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    private final Object invoke$com$metrolist$music$ui$screens$podcast$OnlinePodcastScreenKt$$ExternalSyntheticLambda7(Object obj, Object obj2, Object obj3) {
        Composer composer = (Composer) obj2;
        int iIntValue = ((Integer) obj3).intValue();
        ((RowScope) obj).getClass();
        GapComposer gapComposer = (GapComposer) composer;
        if (gapComposer.shouldExecute(iIntValue & 1, (iIntValue & 17) != 16)) {
            MutableState mutableState = this.f$0;
            if (((Boolean) mutableState.getValue()).booleanValue()) {
                gapComposer.startReplaceGroup(1837693035);
                gapComposer.end(false);
            } else {
                gapComposer.startReplaceGroup(1837386476);
                boolean zChanged = gapComposer.changed(mutableState);
                Object objRememberedValue = gapComposer.rememberedValue();
                if (zChanged || objRememberedValue == Composer.Companion.Empty) {
                    objRememberedValue = new LibrarySongsScreenKt$$ExternalSyntheticLambda17(mutableState, (byte) 25);
                    gapComposer.updateRememberedValue(objRememberedValue);
                }
                CardKt.IconButton((Function0) objRememberedValue, null, false, null, null, OnlinePodcastScreenKt.lambda$1686324862, gapComposer, 1572864, 62);
                gapComposer.end(false);
            }
        } else {
            gapComposer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    private final Object invoke$com$metrolist$music$ui$screens$settings$AlarmSettingsKt$$ExternalSyntheticLambda15(Object obj, Object obj2, Object obj3) {
        Composer composer = (Composer) obj2;
        int iIntValue = ((Integer) obj3).intValue();
        ((RowScope) obj).getClass();
        GapComposer gapComposer = (GapComposer) composer;
        if (gapComposer.shouldExecute(iIntValue & 1, (iIntValue & 17) != 16)) {
            Object objRememberedValue = gapComposer.rememberedValue();
            if (objRememberedValue == Composer.Companion.Empty) {
                objRememberedValue = new AlarmSettingsKt$$ExternalSyntheticLambda14(this.f$0, (byte) 2);
                gapComposer.updateRememberedValue(objRememberedValue);
            }
            CardKt.TextButton((Function0) objRememberedValue, null, false, null, null, null, AiSettingsKt.f498lambda$171993303, gapComposer, 805306374, 510);
        } else {
            gapComposer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    private final Object invoke$com$metrolist$music$ui$screens$settings$AndroidAutoSettingsKt$$ExternalSyntheticLambda0(Object obj, Object obj2, Object obj3) {
        Object next;
        String str;
        String strM = (String) obj;
        ((Integer) obj3).getClass();
        strM.getClass();
        GapComposer gapComposer = (GapComposer) ((Composer) obj2);
        gapComposer.startReplaceGroup(193236307);
        if (strM.equals("auto")) {
            strM = Format$$ExternalSyntheticOutline0.m(gapComposer, 1446717181, R.string.android_auto_target_playlist_auto, gapComposer, false);
        } else {
            gapComposer.startReplaceGroup(1446817249);
            gapComposer.end(false);
            Iterator it = ((List) this.f$0.getValue()).iterator();
            do {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
            } while (!Intrinsics.areEqual(((PlaylistEntity) next).id, strM));
            PlaylistEntity playlistEntity = (PlaylistEntity) next;
            if (playlistEntity != null && (str = playlistEntity.name) != null) {
                strM = str;
            }
        }
        gapComposer.end(false);
        return strM;
    }

    private final Object invoke$com$metrolist$music$ui$screens$settings$AppearanceSettingsKt$$ExternalSyntheticLambda81(Object obj, Object obj2, Object obj3) {
        Composer composer = (Composer) obj2;
        int iIntValue = ((Integer) obj3).intValue();
        ((RowScope) obj).getClass();
        GapComposer gapComposer = (GapComposer) composer;
        if (gapComposer.shouldExecute(iIntValue & 1, (iIntValue & 17) != 16)) {
            MutableState mutableState = this.f$0;
            boolean zChanged = gapComposer.changed(mutableState);
            Object objRememberedValue = gapComposer.rememberedValue();
            if (zChanged || objRememberedValue == Composer.Companion.Empty) {
                objRememberedValue = new AlarmSettingsKt$$ExternalSyntheticLambda14(mutableState, (byte) 17);
                gapComposer.updateRememberedValue(objRememberedValue);
            }
            CardKt.TextButton((Function0) objRememberedValue, null, false, null, null, null, AiSettingsKt.f520lambda$202515220, gapComposer, 805306368, 510);
        } else {
            gapComposer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    private final Object invoke$com$metrolist$music$ui$screens$settings$AppearanceSettingsKt$$ExternalSyntheticLambda84(Object obj, Object obj2, Object obj3) {
        Composer composer = (Composer) obj2;
        int iIntValue = ((Integer) obj3).intValue();
        ((RowScope) obj).getClass();
        GapComposer gapComposer = (GapComposer) composer;
        if (gapComposer.shouldExecute(iIntValue & 1, (iIntValue & 17) != 16)) {
            MutableState mutableState = this.f$0;
            boolean zChanged = gapComposer.changed(mutableState);
            Object objRememberedValue = gapComposer.rememberedValue();
            if (zChanged || objRememberedValue == Composer.Companion.Empty) {
                objRememberedValue = new AlarmSettingsKt$$ExternalSyntheticLambda14(mutableState, (byte) 18);
                gapComposer.updateRememberedValue(objRememberedValue);
            }
            CardKt.TextButton((Function0) objRememberedValue, null, false, null, null, null, AiSettingsKt.f557lambda$58105525, gapComposer, 805306368, 510);
        } else {
            gapComposer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(Object obj, Object obj2, Object obj3) throws XmlPullParserException, IOException {
        BiasAlignment biasAlignment;
        BiasAlignment biasAlignment2;
        String strStringResource;
        String strStringResource2;
        boolean z;
        Modifier modifierDrawBehind;
        int i;
        int i2;
        byte b = this.$r8$classId;
        Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda0 = ComposeUiNode.Companion.SetModifier;
        Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda1 = ComposeUiNode.Companion.SetCompositeKeyHash;
        Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda2 = ComposeUiNode.Companion.SetResolvedCompositionLocals;
        Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda3 = ComposeUiNode.Companion.SetMeasurePolicy;
        TextKt$$ExternalSyntheticLambda3 textKt$$ExternalSyntheticLambda3 = LayoutNode.Constructor;
        NeverEqualPolicy neverEqualPolicy = Composer.Companion.Empty;
        Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
        Unit unit = Unit.INSTANCE;
        MutableState mutableState = this.f$0;
        switch (b) {
            case 0:
                Composer composer = (Composer) obj2;
                int iIntValue = ((Integer) obj3).intValue();
                ((AnimatedVisibilityScope) obj).getClass();
                GapComposer gapComposer = (GapComposer) composer;
                if (gapComposer.shouldExecute(iIntValue & 1, (iIntValue & 17) != 16)) {
                    RowMeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(OffsetKt.Start, Alignment.Companion.Top, gapComposer, 0);
                    int iHashCode = Long.hashCode(gapComposer.compositeKeyHashCode);
                    PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope = gapComposer.currentCompositionLocalScope();
                    Modifier modifierMaterializeModifier = ZIndexModifierKt.materializeModifier(gapComposer, companion);
                    ComposeUiNode.Companion.getClass();
                    gapComposer.startReusableNode();
                    if (gapComposer.inserting) {
                        gapComposer.createNode(textKt$$ExternalSyntheticLambda3);
                    } else {
                        gapComposer.useNode();
                    }
                    Stack.m390setimpl(gapComposer, rowMeasurePolicy, updater$$ExternalSyntheticLambda3);
                    Stack.m390setimpl(gapComposer, persistentCompositionLocalHashMapCurrentCompositionLocalScope, updater$$ExternalSyntheticLambda2);
                    Stack.m390setimpl(gapComposer, Integer.valueOf(iHashCode), updater$$ExternalSyntheticLambda1);
                    Stack.m389reconcileimpl(gapComposer);
                    Stack.m390setimpl(gapComposer, modifierMaterializeModifier, updater$$ExternalSyntheticLambda0);
                    boolean zChanged = gapComposer.changed(mutableState);
                    Object objRememberedValue = gapComposer.rememberedValue();
                    if (zChanged || objRememberedValue == neverEqualPolicy) {
                        objRememberedValue = new PlayerKt$$ExternalSyntheticLambda7(mutableState, (byte) 6);
                        gapComposer.updateRememberedValue(objRememberedValue);
                    }
                    CardKt.IconButton((Function0) objRememberedValue, OffsetKt.m137paddingVpY3zN4$default(companion, 6.0f, CropImageView.DEFAULT_ASPECT_RATIO, 2), false, null, null, Expect_jvmKt.rememberComposableLambda(868910250, new QueueKt$$ExternalSyntheticLambda39(mutableState, (byte) 0), gapComposer), gapComposer, 1572912, 60);
                    gapComposer.end(true);
                } else {
                    gapComposer.skipToGroupEnd();
                }
                return unit;
            case 1:
                Composer composer2 = (Composer) obj2;
                int iIntValue2 = ((Integer) obj3).intValue();
                ((ColumnScopeInstance) obj).getClass();
                int i3 = 1;
                GapComposer gapComposer2 = (GapComposer) composer2;
                if (gapComposer2.shouldExecute(iIntValue2 & 1, (iIntValue2 & 17) != 16)) {
                    int i4 = 0;
                    while (i4 < 10) {
                        int iOrdinal = ((LyricsPosition) mutableState.getValue()).ordinal();
                        if (iOrdinal != 0) {
                            biasAlignment = iOrdinal != i3 ? Alignment.Companion.CenterEnd : Alignment.Companion.Center;
                        } else {
                            biasAlignment = Alignment.Companion.CenterStart;
                        }
                        Modifier modifierM136paddingVpY3zN4 = OffsetKt.m136paddingVpY3zN4(SizeKt.fillMaxWidth(companion, 1.0f), 24.0f, 4.0f);
                        MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(biasAlignment, false);
                        int iHashCode2 = Long.hashCode(gapComposer2.compositeKeyHashCode);
                        PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope2 = gapComposer2.currentCompositionLocalScope();
                        Modifier modifierMaterializeModifier2 = ZIndexModifierKt.materializeModifier(gapComposer2, modifierM136paddingVpY3zN4);
                        ComposeUiNode.Companion.getClass();
                        gapComposer2.startReusableNode();
                        if (gapComposer2.inserting) {
                            gapComposer2.createNode(textKt$$ExternalSyntheticLambda3);
                        } else {
                            gapComposer2.useNode();
                        }
                        Stack.m390setimpl(gapComposer2, measurePolicyMaybeCachedBoxMeasurePolicy, updater$$ExternalSyntheticLambda3);
                        Stack.m390setimpl(gapComposer2, persistentCompositionLocalHashMapCurrentCompositionLocalScope2, updater$$ExternalSyntheticLambda2);
                        Stack.m390setimpl(gapComposer2, Integer.valueOf(iHashCode2), updater$$ExternalSyntheticLambda1);
                        Stack.m389reconcileimpl(gapComposer2);
                        Stack.m390setimpl(gapComposer2, modifierMaterializeModifier2, updater$$ExternalSyntheticLambda0);
                        UuidKt.m1896TextPlaceholderuFdPcIQ(null, CropImageView.DEFAULT_ASPECT_RATIO, null, gapComposer2, 0, 7);
                        gapComposer2.end(true);
                        i4++;
                        i3 = 1;
                    }
                } else {
                    gapComposer2.skipToGroupEnd();
                }
                return unit;
            case 2:
                Composer composer3 = (Composer) obj2;
                int iIntValue3 = ((Integer) obj3).intValue();
                ((AnimatedVisibilityScope) obj).getClass();
                GapComposer gapComposer3 = (GapComposer) composer3;
                if (gapComposer3.shouldExecute(iIntValue3 & 1, (iIntValue3 & 17) != 16)) {
                    CardKt.FilledTonalButton((Function0) mutableState.getValue(), null, false, null, null, null, null, DialogKt.lambda$1490944580, gapComposer3, 805306368, 510);
                } else {
                    gapComposer3.skipToGroupEnd();
                }
                return unit;
            case 3:
                Composer composer4 = (Composer) obj2;
                int iIntValue4 = ((Integer) obj3).intValue();
                ((LazyItemScopeImpl) obj).getClass();
                GapComposer gapComposer4 = (GapComposer) composer4;
                if (gapComposer4.shouldExecute(iIntValue4 & 1, (iIntValue4 & 17) != 16)) {
                    LyricsEntity lyricsEntity = (LyricsEntity) mutableState.getValue();
                    String strM = Fragment$5$$ExternalSyntheticOutline0.m("Lyrics from ", lyricsEntity != null ? lyricsEntity.provider : null);
                    long sp = IntMath.getSp(12);
                    long j = ((MaterialTheme$Values) gapComposer4.consume(MaterialThemeKt._localMaterialTheme)).colorScheme.onSurface;
                    TextKt.m352TextNvy7gAk(strM, OffsetKt.m136paddingVpY3zN4(SizeKt.fillMaxWidth(companion, 1.0f), 12.0f, 8.0f), ColorKt.Color(Color.m485getRedimpl(j), Color.m484getGreenimpl(j), Color.m482getBlueimpl(j), 0.6f, Color.m483getColorSpaceimpl(j)), sp, null, FontWeight.Medium, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer4, 1597488, 0, 262056);
                } else {
                    gapComposer4.skipToGroupEnd();
                }
                return unit;
            case 4:
                Composer composer5 = (Composer) obj2;
                int iIntValue5 = ((Integer) obj3).intValue();
                ((LazyItemScopeImpl) obj).getClass();
                GapComposer gapComposer5 = (GapComposer) composer5;
                if (gapComposer5.shouldExecute(iIntValue5 & 1, (iIntValue5 & 17) != 16)) {
                    ShimmerHostKt.ShimmerHost(null, null, null, false, Expect_jvmKt.rememberComposableLambda(1377692310, new QueueKt$$ExternalSyntheticLambda21(mutableState, (byte) 5), gapComposer5), gapComposer5, 24576, 15);
                } else {
                    gapComposer5.skipToGroupEnd();
                }
                return unit;
            case 5:
                Composer composer6 = (Composer) obj2;
                int iIntValue6 = ((Integer) obj3).intValue();
                ((ColumnScopeInstance) obj).getClass();
                int i5 = 1;
                GapComposer gapComposer6 = (GapComposer) composer6;
                if (gapComposer6.shouldExecute(iIntValue6 & 1, (iIntValue6 & 17) != 16)) {
                    int i6 = 0;
                    while (i6 < 10) {
                        int iOrdinal2 = ((LyricsPosition) mutableState.getValue()).ordinal();
                        if (iOrdinal2 == 0) {
                            biasAlignment2 = Alignment.Companion.CenterStart;
                        } else if (iOrdinal2 == i5) {
                            biasAlignment2 = Alignment.Companion.Center;
                        } else {
                            if (iOrdinal2 != 2) {
                                PathKt$$ExternalSyntheticBUOutline0.m$1();
                                return null;
                            }
                            biasAlignment2 = Alignment.Companion.CenterEnd;
                        }
                        Modifier modifierM136paddingVpY3zN5 = OffsetKt.m136paddingVpY3zN4(SizeKt.fillMaxWidth(companion, 1.0f), 24.0f, 4.0f);
                        MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(biasAlignment2, false);
                        int iHashCode3 = Long.hashCode(gapComposer6.compositeKeyHashCode);
                        PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope3 = gapComposer6.currentCompositionLocalScope();
                        Modifier modifierMaterializeModifier3 = ZIndexModifierKt.materializeModifier(gapComposer6, modifierM136paddingVpY3zN5);
                        ComposeUiNode.Companion.getClass();
                        gapComposer6.startReusableNode();
                        if (gapComposer6.inserting) {
                            gapComposer6.createNode(textKt$$ExternalSyntheticLambda3);
                        } else {
                            gapComposer6.useNode();
                        }
                        Stack.m390setimpl(gapComposer6, measurePolicyMaybeCachedBoxMeasurePolicy2, updater$$ExternalSyntheticLambda3);
                        Stack.m390setimpl(gapComposer6, persistentCompositionLocalHashMapCurrentCompositionLocalScope3, updater$$ExternalSyntheticLambda2);
                        Stack.m390setimpl(gapComposer6, Integer.valueOf(iHashCode3), updater$$ExternalSyntheticLambda1);
                        Stack.m389reconcileimpl(gapComposer6);
                        Stack.m390setimpl(gapComposer6, modifierMaterializeModifier3, updater$$ExternalSyntheticLambda0);
                        UuidKt.m1896TextPlaceholderuFdPcIQ(null, CropImageView.DEFAULT_ASPECT_RATIO, null, gapComposer6, 0, 7);
                        gapComposer6.end(true);
                        i6++;
                        i5 = 1;
                    }
                } else {
                    gapComposer6.skipToGroupEnd();
                }
                return unit;
            case 6:
                ColumnScopeInstance columnScopeInstance = (ColumnScopeInstance) obj;
                Composer composer7 = (Composer) obj2;
                int iIntValue7 = ((Integer) obj3).intValue();
                columnScopeInstance.getClass();
                if ((iIntValue7 & 6) == 0) {
                    iIntValue7 |= ((GapComposer) composer7).changed(columnScopeInstance) ? 4 : 2;
                }
                GapComposer gapComposer7 = (GapComposer) composer7;
                if (gapComposer7.shouldExecute(iIntValue7 & 1, (iIntValue7 & 19) != 18)) {
                    if (((List) mutableState.getValue()).size() == 1) {
                        strStringResource = Format$$ExternalSyntheticOutline0.m(gapComposer7, -2007399371, R.string.duplicates_description_single, gapComposer7, false);
                    } else {
                        gapComposer7.startReplaceGroup(-2007291646);
                        strStringResource = MathKt.stringResource(R.string.duplicates_description_multiple, new Object[]{Integer.valueOf(((List) mutableState.getValue()).size())}, gapComposer7);
                        gapComposer7.end(false);
                    }
                    TextKt.m352TextNvy7gAk(strStringResource, columnScopeInstance.align(companion, Alignment.Companion.Start), 0L, 0L, null, null, null, 0L, new TextAlign(5), 0L, 0, false, 0, 0, null, gapComposer7, 0, 0, 261116);
                } else {
                    gapComposer7.skipToGroupEnd();
                }
                return unit;
            case 7:
                Composer composer8 = (Composer) obj2;
                int iIntValue8 = ((Integer) obj3).intValue();
                ((LazyItemScopeImpl) obj).getClass();
                GapComposer gapComposer8 = (GapComposer) composer8;
                if (gapComposer8.shouldExecute(iIntValue8 & 1, (iIntValue8 & 17) != 16)) {
                    Object objRememberedValue2 = gapComposer8.rememberedValue();
                    if (objRememberedValue2 == neverEqualPolicy) {
                        objRememberedValue2 = IntIntPair$$ExternalSyntheticOutline0.m(gapComposer8);
                    }
                    MutableInteractionSourceImpl mutableInteractionSourceImpl = (MutableInteractionSourceImpl) objRememberedValue2;
                    AnimateAsStateKt.animateFloatAsState(((Boolean) coil3.size.SizeKt.collectIsPressedAsState(mutableInteractionSourceImpl, gapComposer8, 6).getValue()).booleanValue() ? 0.7f : 1.0f, ArcSplineKt.spring$default(0.5f, 1500.0f, null, 4), "buttonScale", gapComposer8, 3120, 20);
                    RoundedCornerShape roundedCornerShapeM185RoundedCornerShape0680j_4 = RoundedCornerShapeKt.m185RoundedCornerShape0680j_4(8.0f);
                    PaddingValuesImpl paddingValuesImpl = ButtonDefaults.ContentPadding;
                    StaticProvidableCompositionLocal staticProvidableCompositionLocal = MaterialThemeKt._localMaterialTheme;
                    ButtonColors buttonColorsM249filledTonalButtonColorsro_MJ88 = ButtonDefaults.m249filledTonalButtonColorsro_MJ88(((MaterialTheme$Values) gapComposer8.consume(staticProvidableCompositionLocal)).colorScheme.primary, ((MaterialTheme$Values) gapComposer8.consume(staticProvidableCompositionLocal)).colorScheme.onPrimary, gapComposer8);
                    Modifier modifierM136paddingVpY3zN6 = OffsetKt.m136paddingVpY3zN4(SizeKt.fillMaxWidth(companion, 1.0f), 16.0f, 8.0f);
                    boolean zChanged2 = gapComposer8.changed(mutableState);
                    Object objRememberedValue3 = gapComposer8.rememberedValue();
                    if (zChanged2 || objRememberedValue3 == neverEqualPolicy) {
                        objRememberedValue3 = new AlbumMenuKt$$ExternalSyntheticLambda6(mutableState, (byte) 7);
                        gapComposer8.updateRememberedValue(objRememberedValue3);
                    }
                    CardKt.Button((Function0) objRememberedValue3, modifierM136paddingVpY3zN6, false, roundedCornerShapeM185RoundedCornerShape0680j_4, buttonColorsM249filledTonalButtonColorsro_MJ88, null, null, null, mutableInteractionSourceImpl, AlbumMenuKt.f83lambda$1339332755, gapComposer8, 905969712, 228);
                } else {
                    gapComposer8.skipToGroupEnd();
                }
                return unit;
            case 8:
                ColumnScopeInstance columnScopeInstance2 = (ColumnScopeInstance) obj;
                Composer composer9 = (Composer) obj2;
                int iIntValue9 = ((Integer) obj3).intValue();
                columnScopeInstance2.getClass();
                if ((iIntValue9 & 6) == 0) {
                    iIntValue9 |= ((GapComposer) composer9).changed(columnScopeInstance2) ? 4 : 2;
                }
                GapComposer gapComposer9 = (GapComposer) composer9;
                if (gapComposer9.shouldExecute(iIntValue9 & 1, (iIntValue9 & 19) != 18)) {
                    if (((List) mutableState.getValue()).size() == 1) {
                        strStringResource2 = Format$$ExternalSyntheticOutline0.m(gapComposer9, -1400128227, R.string.duplicates_description_single, gapComposer9, false);
                    } else {
                        gapComposer9.startReplaceGroup(-1400028438);
                        strStringResource2 = MathKt.stringResource(R.string.duplicates_description_multiple, new Object[]{Integer.valueOf(((List) mutableState.getValue()).size())}, gapComposer9);
                        gapComposer9.end(false);
                    }
                    TextKt.m352TextNvy7gAk(strStringResource2, columnScopeInstance2.align(companion, Alignment.Companion.Start), 0L, 0L, null, null, null, 0L, new TextAlign(5), 0L, 0, false, 0, 0, null, gapComposer9, 0, 0, 261116);
                } else {
                    gapComposer9.skipToGroupEnd();
                }
                return unit;
            case 9:
                Composer composer10 = (Composer) obj2;
                int iIntValue10 = ((Integer) obj3).intValue();
                ((LazyItemScopeImpl) obj).getClass();
                GapComposer gapComposer10 = (GapComposer) composer10;
                if (gapComposer10.shouldExecute(iIntValue10 & 1, (iIntValue10 & 17) != 16)) {
                    Object objRememberedValue4 = gapComposer10.rememberedValue();
                    if (objRememberedValue4 == neverEqualPolicy) {
                        objRememberedValue4 = IntIntPair$$ExternalSyntheticOutline0.m(gapComposer10);
                    }
                    MutableInteractionSourceImpl mutableInteractionSourceImpl2 = (MutableInteractionSourceImpl) objRememberedValue4;
                    AnimateAsStateKt.animateFloatAsState(((Boolean) coil3.size.SizeKt.collectIsPressedAsState(mutableInteractionSourceImpl2, gapComposer10, 6).getValue()).booleanValue() ? 0.94f : 1.0f, ArcSplineKt.spring$default(0.5f, 1500.0f, null, 4), "buttonScale", gapComposer10, 3120, 20);
                    RoundedCornerShape roundedCornerShapeM185RoundedCornerShape0680j_5 = RoundedCornerShapeKt.m185RoundedCornerShape0680j_4(8.0f);
                    PaddingValuesImpl paddingValuesImpl2 = ButtonDefaults.ContentPadding;
                    StaticProvidableCompositionLocal staticProvidableCompositionLocal2 = MaterialThemeKt._localMaterialTheme;
                    ButtonColors buttonColorsM249filledTonalButtonColorsro_MJ89 = ButtonDefaults.m249filledTonalButtonColorsro_MJ88(((MaterialTheme$Values) gapComposer10.consume(staticProvidableCompositionLocal2)).colorScheme.primary, ((MaterialTheme$Values) gapComposer10.consume(staticProvidableCompositionLocal2)).colorScheme.onPrimary, gapComposer10);
                    Modifier modifierM136paddingVpY3zN7 = OffsetKt.m136paddingVpY3zN4(SizeKt.fillMaxWidth(companion, 1.0f), 16.0f, 8.0f);
                    boolean zChanged3 = gapComposer10.changed(mutableState);
                    Object objRememberedValue5 = gapComposer10.rememberedValue();
                    if (zChanged3 || objRememberedValue5 == neverEqualPolicy) {
                        objRememberedValue5 = new AlbumMenuKt$$ExternalSyntheticLambda6(mutableState, (byte) 11);
                        gapComposer10.updateRememberedValue(objRememberedValue5);
                    }
                    CardKt.Button((Function0) objRememberedValue5, modifierM136paddingVpY3zN7, false, roundedCornerShapeM185RoundedCornerShape0680j_5, buttonColorsM249filledTonalButtonColorsro_MJ89, null, null, null, mutableInteractionSourceImpl2, AlbumMenuKt.lambda$788582157, gapComposer10, 905969712, 228);
                } else {
                    gapComposer10.skipToGroupEnd();
                }
                return unit;
            case 10:
                Composer composer11 = (Composer) obj2;
                int iIntValue11 = ((Integer) obj3).intValue();
                ((LazyItemScopeImpl) obj).getClass();
                GapComposer gapComposer11 = (GapComposer) composer11;
                if (gapComposer11.shouldExecute(iIntValue11 & 1, (iIntValue11 & 17) != 16)) {
                    String strStringResource3 = MathKt.stringResource(R.string.already_in_playlist, gapComposer11);
                    boolean zChanged4 = gapComposer11.changed(mutableState);
                    Object objRememberedValue6 = gapComposer11.rememberedValue();
                    if (zChanged4 || objRememberedValue6 == neverEqualPolicy) {
                        objRememberedValue6 = new AlbumMenuKt$$ExternalSyntheticLambda6(mutableState, (byte) 14);
                        gapComposer11.updateRememberedValue(objRememberedValue6);
                    }
                    Modifier modifierM46clickableoSLSa3U$default = ImageKt.m46clickableoSLSa3U$default(companion, false, null, (Function0) objRememberedValue6, 15);
                    StaticProvidableCompositionLocal staticProvidableCompositionLocal3 = MaterialThemeKt._localMaterialTheme;
                    long j2 = ((MaterialTheme$Values) gapComposer11.consume(staticProvidableCompositionLocal3)).colorScheme.outlineVariant;
                    long jColor = ColorKt.Color(Color.m485getRedimpl(j2), Color.m484getGreenimpl(j2), Color.m482getBlueimpl(j2), 0.35f, Color.m483getColorSpaceimpl(j2));
                    BiasAlignment.Vertical vertical = Alignment.Companion.CenterVertically;
                    gapComposer11.startReplaceGroup(980878578);
                    gapComposer11.startReplaceGroup(342807021);
                    gapComposer11.end(false);
                    gapComposer11.startReplaceGroup(343091420);
                    Modifier modifierPressScale = DialogKt.pressScale(modifierM46clickableoSLSa3U$default, 0.985f);
                    SpringSpec springSpec = DimensionsKt.NavigationBarAnimationSpec;
                    Modifier modifierM1473hairlineBottomiJQMabo = DialogKt.m1473hairlineBottomiJQMabo(SizeKt.m145height3ABfNKs(modifierPressScale, 64.0f), gapComposer11, 0);
                    if (UiStyleKt.isGlassStyle(gapComposer11)) {
                        gapComposer11.startReplaceGroup(343275033);
                        boolean zChanged5 = gapComposer11.changed(jColor);
                        Object objRememberedValue7 = gapComposer11.rememberedValue();
                        if (zChanged5 || objRememberedValue7 == neverEqualPolicy) {
                            objRememberedValue7 = new ItemsKt$ListItem$2$1(jColor);
                            gapComposer11.updateRememberedValue(objRememberedValue7);
                        }
                        modifierDrawBehind = ClipKt.drawBehind(companion, (Function1) objRememberedValue7);
                        z = false;
                        gapComposer11.end(false);
                    } else {
                        z = false;
                        gapComposer11.startReplaceGroup(343633486);
                        gapComposer11.end(false);
                        modifierDrawBehind = companion;
                    }
                    Modifier modifierThen = modifierM1473hairlineBottomiJQMabo.then(modifierDrawBehind);
                    gapComposer11.end(z);
                    gapComposer11.end(z);
                    Modifier modifierM137paddingVpY3zN4$default = OffsetKt.m137paddingVpY3zN4$default(modifierThen, 14.0f, CropImageView.DEFAULT_ASPECT_RATIO, 2);
                    RowMeasurePolicy rowMeasurePolicy2 = RowKt.rowMeasurePolicy(OffsetKt.Start, vertical, gapComposer11, 48);
                    int iHashCode4 = Long.hashCode(gapComposer11.compositeKeyHashCode);
                    PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope4 = gapComposer11.currentCompositionLocalScope();
                    Modifier modifierMaterializeModifier4 = ZIndexModifierKt.materializeModifier(gapComposer11, modifierM137paddingVpY3zN4$default);
                    ComposeUiNode.Companion.getClass();
                    gapComposer11.startReusableNode();
                    if (gapComposer11.inserting) {
                        gapComposer11.createNode(textKt$$ExternalSyntheticLambda3);
                    } else {
                        gapComposer11.useNode();
                    }
                    Stack.m390setimpl(gapComposer11, rowMeasurePolicy2, updater$$ExternalSyntheticLambda3);
                    Stack.m390setimpl(gapComposer11, persistentCompositionLocalHashMapCurrentCompositionLocalScope4, updater$$ExternalSyntheticLambda2);
                    Stack.m390setimpl(gapComposer11, Integer.valueOf(iHashCode4), updater$$ExternalSyntheticLambda1);
                    Stack.m389reconcileimpl(gapComposer11);
                    Stack.m390setimpl(gapComposer11, modifierMaterializeModifier4, updater$$ExternalSyntheticLambda0);
                    Modifier modifierM135padding3ABfNKs = OffsetKt.m135padding3ABfNKs(companion, 6.0f);
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy3 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.Center, false);
                    int iHashCode5 = Long.hashCode(gapComposer11.compositeKeyHashCode);
                    PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope5 = gapComposer11.currentCompositionLocalScope();
                    Modifier modifierMaterializeModifier5 = ZIndexModifierKt.materializeModifier(gapComposer11, modifierM135padding3ABfNKs);
                    gapComposer11.startReusableNode();
                    if (gapComposer11.inserting) {
                        gapComposer11.createNode(textKt$$ExternalSyntheticLambda3);
                    } else {
                        gapComposer11.useNode();
                    }
                    Stack.m390setimpl(gapComposer11, measurePolicyMaybeCachedBoxMeasurePolicy3, updater$$ExternalSyntheticLambda3);
                    Stack.m390setimpl(gapComposer11, persistentCompositionLocalHashMapCurrentCompositionLocalScope5, updater$$ExternalSyntheticLambda2);
                    IntIntPair$$ExternalSyntheticOutline0.m(iHashCode5, gapComposer11, updater$$ExternalSyntheticLambda1, gapComposer11);
                    Stack.m390setimpl(gapComposer11, modifierMaterializeModifier5, updater$$ExternalSyntheticLambda0);
                    ImageKt.Image(IntMath.painterResource(R.drawable.close, 0, gapComposer11), null, SizeKt.m151size3ABfNKs(companion, 48.0f), null, null, CropImageView.DEFAULT_ASPECT_RATIO, new BlendModeColorFilter(((MaterialTheme$Values) gapComposer11.consume(staticProvidableCompositionLocal3)).colorScheme.onBackground, 5), gapComposer11, 56, 56);
                    gapComposer11.startReplaceGroup(813683088);
                    gapComposer11.end(false);
                    gapComposer11.end(true);
                    Modifier modifierM137paddingVpY3zN4$default2 = OffsetKt.m137paddingVpY3zN4$default(new LayoutWeightElement(1.0f, true), 6.0f, CropImageView.DEFAULT_ASPECT_RATIO, 2);
                    ColumnMeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(OffsetKt.Top, Alignment.Companion.Start, gapComposer11, 0);
                    int iHashCode6 = Long.hashCode(gapComposer11.compositeKeyHashCode);
                    PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope6 = gapComposer11.currentCompositionLocalScope();
                    Modifier modifierMaterializeModifier6 = ZIndexModifierKt.materializeModifier(gapComposer11, modifierM137paddingVpY3zN4$default2);
                    gapComposer11.startReusableNode();
                    if (gapComposer11.inserting) {
                        gapComposer11.createNode(textKt$$ExternalSyntheticLambda3);
                    } else {
                        gapComposer11.useNode();
                    }
                    Stack.m390setimpl(gapComposer11, columnMeasurePolicy, updater$$ExternalSyntheticLambda3);
                    Stack.m390setimpl(gapComposer11, persistentCompositionLocalHashMapCurrentCompositionLocalScope6, updater$$ExternalSyntheticLambda2);
                    IntIntPair$$ExternalSyntheticOutline0.m(iHashCode6, gapComposer11, updater$$ExternalSyntheticLambda1, gapComposer11);
                    Stack.m390setimpl(gapComposer11, modifierMaterializeModifier6, updater$$ExternalSyntheticLambda0);
                    TextStyle textStyle = ((MaterialTheme$Values) gapComposer11.consume(staticProvidableCompositionLocal3)).typography.titleMedium;
                    gapComposer11.startReplaceGroup(-1898635093);
                    long j3 = ((MaterialTheme$Values) gapComposer11.consume(staticProvidableCompositionLocal3)).colorScheme.onSurface;
                    gapComposer11.end(false);
                    TextKt.m352TextNvy7gAk(strStringResource3, null, ((Color) SingleValueAnimationKt.m17animateColorAsStateeuL9pac(j3, ArcSplineKt.tween$default(200, 0, null, 6), "listItemTitleColor", gapComposer11, 432, 8).getValue()).value, 0L, null, null, null, 0L, null, 0L, 2, false, 1, 0, textStyle, gapComposer11, 0, 24960, 110586);
                    gapComposer11.startReplaceGroup(1272246816);
                    gapComposer11.end(false);
                    gapComposer11.end(true);
                    gapComposer11.end(true);
                } else {
                    gapComposer11.skipToGroupEnd();
                }
                return unit;
            case 11:
                Composer composer12 = (Composer) obj2;
                int iIntValue12 = ((Integer) obj3).intValue();
                ((LazyItemScopeImpl) obj).getClass();
                GapComposer gapComposer12 = (GapComposer) composer12;
                if (gapComposer12.shouldExecute(iIntValue12 & 1, (iIntValue12 & 17) != 16)) {
                    Modifier modifierM136paddingVpY3zN8 = OffsetKt.m136paddingVpY3zN4(SizeKt.fillMaxWidth(companion, 1.0f), 24.0f, 16.0f);
                    RowMeasurePolicy rowMeasurePolicy3 = RowKt.rowMeasurePolicy(OffsetKt.Start, Alignment.Companion.CenterVertically, gapComposer12, 54);
                    int iHashCode7 = Long.hashCode(gapComposer12.compositeKeyHashCode);
                    PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope7 = gapComposer12.currentCompositionLocalScope();
                    Modifier modifierMaterializeModifier7 = ZIndexModifierKt.materializeModifier(gapComposer12, modifierM136paddingVpY3zN8);
                    ComposeUiNode.Companion.getClass();
                    gapComposer12.startReusableNode();
                    if (gapComposer12.inserting) {
                        gapComposer12.createNode(textKt$$ExternalSyntheticLambda3);
                    } else {
                        gapComposer12.useNode();
                    }
                    Stack.m390setimpl(gapComposer12, rowMeasurePolicy3, updater$$ExternalSyntheticLambda3);
                    Stack.m390setimpl(gapComposer12, persistentCompositionLocalHashMapCurrentCompositionLocalScope7, updater$$ExternalSyntheticLambda2);
                    Stack.m390setimpl(gapComposer12, Integer.valueOf(iHashCode7), updater$$ExternalSyntheticLambda1);
                    Stack.m389reconcileimpl(gapComposer12);
                    Stack.m390setimpl(gapComposer12, modifierMaterializeModifier7, updater$$ExternalSyntheticLambda0);
                    Painter painterPainterResource = IntMath.painterResource(R.drawable.group, 0, gapComposer12);
                    StaticProvidableCompositionLocal staticProvidableCompositionLocal4 = MaterialThemeKt._localMaterialTheme;
                    IconKt.m290Iconww6aTOc(painterPainterResource, (String) null, SizeKt.m151size3ABfNKs(companion, 40.0f), ((MaterialTheme$Values) gapComposer12.consume(staticProvidableCompositionLocal4)).colorScheme.primary, gapComposer12, 440, 0);
                    OffsetKt.Spacer(gapComposer12, SizeKt.m155width3ABfNKs(companion, 16.0f));
                    ColumnMeasurePolicy columnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(OffsetKt.Top, Alignment.Companion.Start, gapComposer12, 0);
                    int iHashCode8 = Long.hashCode(gapComposer12.compositeKeyHashCode);
                    PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope8 = gapComposer12.currentCompositionLocalScope();
                    Modifier modifierMaterializeModifier8 = ZIndexModifierKt.materializeModifier(gapComposer12, companion);
                    gapComposer12.startReusableNode();
                    if (gapComposer12.inserting) {
                        gapComposer12.createNode(textKt$$ExternalSyntheticLambda3);
                    } else {
                        gapComposer12.useNode();
                    }
                    Stack.m390setimpl(gapComposer12, columnMeasurePolicy2, updater$$ExternalSyntheticLambda3);
                    Stack.m390setimpl(gapComposer12, persistentCompositionLocalHashMapCurrentCompositionLocalScope8, updater$$ExternalSyntheticLambda2);
                    IntIntPair$$ExternalSyntheticOutline0.m(iHashCode8, gapComposer12, updater$$ExternalSyntheticLambda1, gapComposer12);
                    Stack.m390setimpl(gapComposer12, modifierMaterializeModifier8, updater$$ExternalSyntheticLambda0);
                    TextKt.m352TextNvy7gAk(MathKt.stringResource(R.string.manage_user, gapComposer12), null, ((MaterialTheme$Values) gapComposer12.consume(staticProvidableCompositionLocal4)).colorScheme.primary, 0L, null, FontWeight.Bold, null, 0L, null, 0L, 0, false, 0, 0, ((MaterialTheme$Values) gapComposer12.consume(staticProvidableCompositionLocal4)).typography.headlineSmall, gapComposer12, 1572864, 0, 131002);
                    String str = (String) mutableState.getValue();
                    if (str == null) {
                        str = "";
                    }
                    TextKt.m352TextNvy7gAk(str, null, ((MaterialTheme$Values) gapComposer12.consume(staticProvidableCompositionLocal4)).colorScheme.onSurfaceVariant, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, ((MaterialTheme$Values) gapComposer12.consume(staticProvidableCompositionLocal4)).typography.bodyMedium, gapComposer12, 0, 0, 131066);
                    gapComposer12.end(true);
                    gapComposer12.end(true);
                } else {
                    gapComposer12.skipToGroupEnd();
                }
                return unit;
            case DictionaryEntry.PRONUNCIATION /* 12 */:
                Composer composer13 = (Composer) obj2;
                int iIntValue13 = ((Integer) obj3).intValue();
                ((LazyItemScopeImpl) obj).getClass();
                GapComposer gapComposer13 = (GapComposer) composer13;
                if (gapComposer13.shouldExecute(iIntValue13 & 1, (iIntValue13 & 17) != 16)) {
                    ListItemColors listItemColorsGlassListItemColors = GlassComponentsKt.glassListItemColors(gapComposer13);
                    boolean zChanged6 = gapComposer13.changed(mutableState);
                    Object objRememberedValue8 = gapComposer13.rememberedValue();
                    if (zChanged6 || objRememberedValue8 == neverEqualPolicy) {
                        objRememberedValue8 = new SongMenuKt$$ExternalSyntheticLambda2(mutableState, (byte) 4);
                        gapComposer13.updateRememberedValue(objRememberedValue8);
                    }
                    ListItemKt.ListItem(ImageKt.m46clickableoSLSa3U$default(companion, false, null, (Function0) objRememberedValue8, 15), false, AlbumMenuKt.lambda$1679704111, null, null, null, null, listItemColorsGlassListItemColors, null, null, AlbumMenuKt.f272lambda$885384315, gapComposer13, 384, 1786);
                } else {
                    gapComposer13.skipToGroupEnd();
                }
                return unit;
            case 13:
                Composer composer14 = (Composer) obj2;
                int iIntValue14 = ((Integer) obj3).intValue();
                ((RowScope) obj).getClass();
                GapComposer gapComposer14 = (GapComposer) composer14;
                if (!gapComposer14.shouldExecute(iIntValue14 & 1, (iIntValue14 & 17) != 16)) {
                    gapComposer14.skipToGroupEnd();
                } else if (((Boolean) mutableState.getValue()).booleanValue()) {
                    gapComposer14.startReplaceGroup(-708139355);
                    DialogKt.m1464CircularProgressIndicatorLxG7B9w(2.0f, 0, 390, 26, 0L, 0L, gapComposer14, SizeKt.m151size3ABfNKs(companion, 16.0f));
                    gapComposer14.end(false);
                } else {
                    gapComposer14.startReplaceGroup(-707925858);
                    TextKt.m352TextNvy7gAk(MathKt.stringResource(R.string.delete, gapComposer14), null, ((MaterialTheme$Values) gapComposer14.consume(MaterialThemeKt._localMaterialTheme)).colorScheme.error, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer14, 0, 0, 262138);
                    gapComposer14.end(false);
                }
                return unit;
            case 14:
                Composer composer15 = (Composer) obj2;
                int iIntValue15 = ((Integer) obj3).intValue();
                ((LazyItemScopeImpl) obj).getClass();
                GapComposer gapComposer15 = (GapComposer) composer15;
                if (gapComposer15.shouldExecute(iIntValue15 & 1, (iIntValue15 & 17) != 16)) {
                    ListItemColors listItemColorsGlassListItemColors2 = GlassComponentsKt.glassListItemColors(gapComposer15);
                    boolean zChanged7 = gapComposer15.changed(mutableState);
                    Object objRememberedValue9 = gapComposer15.rememberedValue();
                    if (zChanged7 || objRememberedValue9 == neverEqualPolicy) {
                        objRememberedValue9 = new SongMenuKt$$ExternalSyntheticLambda2(mutableState, (byte) 6);
                        gapComposer15.updateRememberedValue(objRememberedValue9);
                    }
                    ListItemKt.ListItem(ImageKt.m46clickableoSLSa3U$default(companion, false, null, (Function0) objRememberedValue9, 15), false, AlbumMenuKt.f123lambda$1683783653, null, null, null, null, listItemColorsGlassListItemColors2, null, null, AlbumMenuKt.f280lambda$950852731, gapComposer15, 384, 1786);
                } else {
                    gapComposer15.skipToGroupEnd();
                }
                return unit;
            case 15:
                Composer composer16 = (Composer) obj2;
                int iIntValue16 = ((Integer) obj3).intValue();
                ((LazyItemScopeImpl) obj).getClass();
                GapComposer gapComposer16 = (GapComposer) composer16;
                if (gapComposer16.shouldExecute(iIntValue16 & 1, (iIntValue16 & 17) != 16)) {
                    ListItemColors listItemColorsGlassListItemColors3 = GlassComponentsKt.glassListItemColors(gapComposer16);
                    boolean zChanged8 = gapComposer16.changed(mutableState);
                    Object objRememberedValue10 = gapComposer16.rememberedValue();
                    if (zChanged8 || objRememberedValue10 == neverEqualPolicy) {
                        objRememberedValue10 = new SongMenuKt$$ExternalSyntheticLambda2(mutableState, (byte) 18);
                        gapComposer16.updateRememberedValue(objRememberedValue10);
                    }
                    ListItemKt.ListItem(ImageKt.m46clickableoSLSa3U$default(companion, false, null, (Function0) objRememberedValue10, 15), false, AlbumMenuKt.lambda$107804849, null, null, null, null, listItemColorsGlassListItemColors3, null, null, AlbumMenuKt.f226lambda$542998905, gapComposer16, 384, 1786);
                } else {
                    gapComposer16.skipToGroupEnd();
                }
                return unit;
            case 16:
                Composer composer17 = (Composer) obj2;
                int iIntValue17 = ((Integer) obj3).intValue();
                ((LazyItemScopeImpl) obj).getClass();
                GapComposer gapComposer17 = (GapComposer) composer17;
                if (gapComposer17.shouldExecute(iIntValue17 & 1, (iIntValue17 & 17) != 16)) {
                    OffsetKt.Spacer(gapComposer17, SizeKt.m145height3ABfNKs(CrossfadeKt.animateContentSize$default(companion, null, 3), ((Boolean) mutableState.getValue()).booleanValue() ? 48.0f : CropImageView.DEFAULT_ASPECT_RATIO));
                } else {
                    gapComposer17.skipToGroupEnd();
                }
                return unit;
            case 17:
                Composer composer18 = (Composer) obj2;
                int iIntValue18 = ((Integer) obj3).intValue();
                ((AnimatedVisibilityScope) obj).getClass();
                GapComposer gapComposer18 = (GapComposer) composer18;
                if (gapComposer18.shouldExecute(iIntValue18 & 1, (iIntValue18 & 17) != 16)) {
                    QueueKt.SeekEffectOverlay((String) mutableState.getValue(), null, gapComposer18, 0);
                } else {
                    gapComposer18.skipToGroupEnd();
                }
                return unit;
            case 18:
                LazyGridItemScopeImpl lazyGridItemScopeImpl = (LazyGridItemScopeImpl) obj;
                Composer composer19 = (Composer) obj2;
                int iIntValue19 = ((Integer) obj3).intValue();
                lazyGridItemScopeImpl.getClass();
                if ((iIntValue19 & 6) == 0) {
                    iIntValue19 |= ((GapComposer) composer19).changed(lazyGridItemScopeImpl) ? 4 : 2;
                }
                GapComposer gapComposer19 = (GapComposer) composer19;
                if (!gapComposer19.shouldExecute(iIntValue19 & 1, (iIntValue19 & 19) != 18)) {
                    gapComposer19.skipToGroupEnd();
                } else if (StringsKt.isBlank((String) mutableState.getValue())) {
                    gapComposer19.startReplaceGroup(-397889078);
                    DialogKt.EmptyPlaceholder(R.drawable.album, 0, 0, gapComposer19, LazyGridItemScopeImpl.animateItem$default(lazyGridItemScopeImpl, companion), MathKt.stringResource(R.string.library_album_empty, gapComposer19));
                    gapComposer19.end(false);
                } else {
                    gapComposer19.startReplaceGroup(-398036886);
                    MenuKt.LibrarySearchEmptyPlaceholder(0, 0, 6, gapComposer19, LazyGridItemScopeImpl.animateItem$default(lazyGridItemScopeImpl, companion), null);
                    gapComposer19.end(false);
                }
                return unit;
            case 19:
                return invoke$com$metrolist$music$ui$screens$library$LibraryAlbumsScreenKt$$ExternalSyntheticLambda20(obj, obj2, obj3);
            case 20:
                return invoke$com$metrolist$music$ui$screens$library$LibraryPlaylistsScreenKt$$ExternalSyntheticLambda11(obj, obj2, obj3);
            case 21:
                return invoke$com$metrolist$music$ui$screens$library$LibraryPlaylistsScreenKt$$ExternalSyntheticLambda21(obj, obj2, obj3);
            case 22:
                return invoke$com$metrolist$music$ui$screens$playlist$LocalPlaylistScreenKt$$ExternalSyntheticLambda18(obj, obj2, obj3);
            case 23:
                return invoke$com$metrolist$music$ui$screens$playlist$LocalPlaylistScreenKt$$ExternalSyntheticLambda3(obj, obj2, obj3);
            case 24:
                return invoke$com$metrolist$music$ui$screens$podcast$OnlinePodcastScreenKt$$ExternalSyntheticLambda7(obj, obj2, obj3);
            case 25:
                return invoke$com$metrolist$music$ui$screens$settings$AlarmSettingsKt$$ExternalSyntheticLambda15(obj, obj2, obj3);
            case 26:
                return invoke$com$metrolist$music$ui$screens$settings$AndroidAutoSettingsKt$$ExternalSyntheticLambda0(obj, obj2, obj3);
            case 27:
                return invoke$com$metrolist$music$ui$screens$settings$AppearanceSettingsKt$$ExternalSyntheticLambda81(obj, obj2, obj3);
            case 28:
                return invoke$com$metrolist$music$ui$screens$settings$AppearanceSettingsKt$$ExternalSyntheticLambda84(obj, obj2, obj3);
            default:
                Composer composer20 = (Composer) obj2;
                int iIntValue20 = ((Integer) obj3).intValue();
                ((RowScope) obj).getClass();
                GapComposer gapComposer20 = (GapComposer) composer20;
                if (gapComposer20.shouldExecute(iIntValue20 & 1, (iIntValue20 & 17) != 16)) {
                    if (((Boolean) mutableState.getValue()).booleanValue()) {
                        i = 1452229609;
                        i2 = R.string.hide_changelog;
                    } else {
                        i = 1452231049;
                        i2 = R.string.view_changelog;
                    }
                    TextKt.m352TextNvy7gAk(Format$$ExternalSyntheticOutline0.m(gapComposer20, i, i2, gapComposer20, false), null, 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer20, 0, 0, 262142);
                } else {
                    gapComposer20.skipToGroupEnd();
                }
                return unit;
        }
    }
}
