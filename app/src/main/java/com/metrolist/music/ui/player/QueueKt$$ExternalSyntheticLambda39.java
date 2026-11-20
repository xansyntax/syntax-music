package com.metrolist.music.ui.player;

import androidx.compose.foundation.layout.LayoutWeightElement;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowMeasurePolicy;
import androidx.compose.material3.CardKt;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.MaterialTheme$Values;
import androidx.compose.material3.MaterialThemeKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.NeverEqualPolicy;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.internal.PersistentCompositionLocalHashMap;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.ZIndexModifierKt;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.text.input.TextFieldValue;
import androidx.media3.common.Format$$ExternalSyntheticOutline0;
import com.atilika.kuromoji.ipadic.compile.DictionaryEntry;
import com.google.common.math.IntMath;
import com.metrolist.innertube.pages.BrowseResult;
import com.metrolist.music.constants.LibraryFilter;
import com.metrolist.music.constants.LibraryViewType;
import com.metrolist.music.constants.PreferenceKeysKt;
import com.metrolist.music.constants.SearchSource;
import com.metrolist.music.ui.component.DialogKt;
import com.metrolist.music.ui.menu.SongMenuKt$$ExternalSyntheticLambda2;
import com.metrolist.music.ui.screens.StatsScreenKt$$ExternalSyntheticLambda7;
import com.metrolist.music.ui.screens.equalizer.EQState;
import com.metrolist.music.ui.screens.equalizer.EqScreenKt;
import com.metrolist.music.ui.screens.playlist.TopPlaylistScreenKt;
import com.metrolist.music.ui.screens.search.LocalSearchScreenKt;
import com.metrolist.music.ui.screens.settings.AiSettingsKt;
import com.metrolist.music.ui.screens.settings.AiSettingsKt$$ExternalSyntheticLambda3;
import com.yalantis.ucrop.R;
import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import java.io.IOException;
import java.util.List;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.text.StringsKt;
import kotlin.text.StringsKt__StringsJVMKt;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class QueueKt$$ExternalSyntheticLambda39 implements Function2 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ MutableState f$0;

    public /* synthetic */ QueueKt$$ExternalSyntheticLambda39(MutableState mutableState, byte b) {
        this.$r8$classId = b;
        this.f$0 = mutableState;
    }

    /* JADX WARN: Code duplicated, block: B:136:0x03b9  */
    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) throws XmlPullParserException, IOException {
        long j;
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        String strM;
        int i6;
        int i7;
        String strM2;
        String strM3;
        String strM4;
        int i8;
        int i9;
        String strM5;
        byte b = this.$r8$classId;
        int i10 = R.drawable.lock_open;
        int i11 = R.drawable.arrow_back;
        NeverEqualPolicy neverEqualPolicy = Composer.Companion.Empty;
        Unit unit = Unit.INSTANCE;
        MutableState mutableState = this.f$0;
        switch (b) {
            case 0:
                Composer composer = (Composer) obj;
                int iIntValue = ((Integer) obj2).intValue();
                GapComposer gapComposer = (GapComposer) composer;
                if (gapComposer.shouldExecute(1 & iIntValue, (iIntValue & 3) != 2)) {
                    if (((Boolean) mutableState.getValue()).booleanValue()) {
                        i10 = R.drawable.lock;
                    }
                    Painter painterPainterResource = IntMath.painterResource(i10, 0, gapComposer);
                    if (((Boolean) mutableState.getValue()).booleanValue()) {
                        gapComposer.startReplaceGroup(1799103994);
                        j = ((MaterialTheme$Values) gapComposer.consume(MaterialThemeKt._localMaterialTheme)).colorScheme.onSurfaceVariant;
                    } else {
                        gapComposer.startReplaceGroup(1799105521);
                        j = ((MaterialTheme$Values) gapComposer.consume(MaterialThemeKt._localMaterialTheme)).colorScheme.primary;
                    }
                    gapComposer.end(false);
                    IconKt.m290Iconww6aTOc(painterPainterResource, (String) null, (Modifier) null, j, gapComposer, 56, 4);
                } else {
                    gapComposer.skipToGroupEnd();
                }
                return unit;
            case 1:
                Composer composer2 = (Composer) obj;
                int iIntValue2 = ((Integer) obj2).intValue();
                GapComposer gapComposer2 = (GapComposer) composer2;
                if (gapComposer2.shouldExecute(1 & iIntValue2, (iIntValue2 & 3) != 2)) {
                    Object objRememberedValue = gapComposer2.rememberedValue();
                    if (objRememberedValue == neverEqualPolicy) {
                        objRememberedValue = new SongMenuKt$$ExternalSyntheticLambda2(mutableState, (byte) 29);
                        gapComposer2.updateRememberedValue(objRememberedValue);
                    }
                    CardKt.TextButton((Function0) objRememberedValue, null, false, null, null, null, QueueKt.lambda$1200555266, gapComposer2, 805306374, 510);
                } else {
                    gapComposer2.skipToGroupEnd();
                }
                return unit;
            case 2:
                Composer composer3 = (Composer) obj;
                int iIntValue3 = ((Integer) obj2).intValue();
                GapComposer gapComposer3 = (GapComposer) composer3;
                if (gapComposer3.shouldExecute(1 & iIntValue3, (iIntValue3 & 3) != 2)) {
                    BrowseResult browseResult = (BrowseResult) mutableState.getValue();
                    String str = browseResult != null ? browseResult.title : null;
                    TextKt.m352TextNvy7gAk(str == null ? "" : str, null, 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer3, 0, 0, 262142);
                } else {
                    gapComposer3.skipToGroupEnd();
                }
                return unit;
            case 3:
                Composer composer4 = (Composer) obj;
                int iIntValue4 = ((Integer) obj2).intValue();
                GapComposer gapComposer4 = (GapComposer) composer4;
                if (gapComposer4.shouldExecute(1 & iIntValue4, (iIntValue4 & 3) != 2)) {
                    Object objRememberedValue2 = gapComposer4.rememberedValue();
                    if (objRememberedValue2 == neverEqualPolicy) {
                        objRememberedValue2 = new PlayerKt$$ExternalSyntheticLambda7(mutableState, (byte) 15);
                        gapComposer4.updateRememberedValue(objRememberedValue2);
                    }
                    CardKt.TextButton((Function0) objRememberedValue2, null, false, null, null, null, EqScreenKt.lambda$39252988, gapComposer4, 805306374, 510);
                } else {
                    gapComposer4.skipToGroupEnd();
                }
                return unit;
            case 4:
                Composer composer5 = (Composer) obj;
                int iIntValue5 = ((Integer) obj2).intValue();
                GapComposer gapComposer5 = (GapComposer) composer5;
                if (gapComposer5.shouldExecute(1 & iIntValue5, (iIntValue5 & 3) != 2)) {
                    String str2 = (String) mutableState.getValue();
                    TextKt.m352TextNvy7gAk(str2 == null ? "" : str2, null, 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer5, 0, 0, 262142);
                } else {
                    gapComposer5.skipToGroupEnd();
                }
                return unit;
            case 5:
                Composer composer6 = (Composer) obj;
                int iIntValue6 = ((Integer) obj2).intValue();
                GapComposer gapComposer6 = (GapComposer) composer6;
                if (gapComposer6.shouldExecute(1 & iIntValue6, (iIntValue6 & 3) != 2)) {
                    Object objRememberedValue3 = gapComposer6.rememberedValue();
                    if (objRememberedValue3 == neverEqualPolicy) {
                        objRememberedValue3 = new PlayerKt$$ExternalSyntheticLambda7(mutableState, (byte) 18);
                        gapComposer6.updateRememberedValue(objRememberedValue3);
                    }
                    CardKt.IconButton((Function0) objRememberedValue3, null, false, null, null, EqScreenKt.lambda$293440587, gapComposer6, 1572870, 62);
                } else {
                    gapComposer6.skipToGroupEnd();
                }
                return unit;
            case 6:
                Composer composer7 = (Composer) obj;
                int iIntValue7 = ((Integer) obj2).intValue();
                GapComposer gapComposer7 = (GapComposer) composer7;
                if (gapComposer7.shouldExecute(1 & iIntValue7, (iIntValue7 & 3) != 2)) {
                    Object objRememberedValue4 = gapComposer7.rememberedValue();
                    if (objRememberedValue4 == neverEqualPolicy) {
                        objRememberedValue4 = new PlayerKt$$ExternalSyntheticLambda7(mutableState, (byte) 17);
                        gapComposer7.updateRememberedValue(objRememberedValue4);
                    }
                    CardKt.TextButton((Function0) objRememberedValue4, null, false, null, null, null, EqScreenKt.f352lambda$1150062208, gapComposer7, 805306374, 510);
                } else {
                    gapComposer7.skipToGroupEnd();
                }
                return unit;
            case 7:
                Composer composer8 = (Composer) obj;
                int iIntValue8 = ((Integer) obj2).intValue();
                GapComposer gapComposer8 = (GapComposer) composer8;
                if (gapComposer8.shouldExecute(1 & iIntValue8, (iIntValue8 & 3) != 2)) {
                    String str3 = ((EQState) mutableState.getValue()).error;
                    TextKt.m352TextNvy7gAk(MathKt.stringResource(R.string.error_eq_apply_failed, new Object[]{str3 != null ? str3 : ""}, gapComposer8), null, 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer8, 0, 0, 262142);
                } else {
                    gapComposer8.skipToGroupEnd();
                }
                return unit;
            case 8:
                Composer composer9 = (Composer) obj;
                int iIntValue9 = ((Integer) obj2).intValue();
                GapComposer gapComposer9 = (GapComposer) composer9;
                if (gapComposer9.shouldExecute(iIntValue9 & 1, (iIntValue9 & 3) != 2)) {
                    int iOrdinal = ((LibraryViewType) mutableState.getValue()).ordinal();
                    if (iOrdinal == 0) {
                        i = R.drawable.list;
                    } else {
                        if (iOrdinal != 1) {
                            PathKt$$ExternalSyntheticBUOutline0.m$1();
                            return null;
                        }
                        i = R.drawable.grid_view;
                    }
                    Painter painterPainterResource2 = IntMath.painterResource(i, 0, gapComposer9);
                    int iOrdinal2 = ((LibraryViewType) mutableState.getValue()).ordinal();
                    if (iOrdinal2 == 0) {
                        i2 = R.string.switch_to_grid_view;
                    } else {
                        if (iOrdinal2 != 1) {
                            PathKt$$ExternalSyntheticBUOutline0.m$1();
                            return null;
                        }
                        i2 = R.string.switch_to_list_view;
                    }
                    IconKt.m290Iconww6aTOc(painterPainterResource2, MathKt.stringResource(i2, gapComposer9), (Modifier) null, 0L, gapComposer9, 8, 12);
                } else {
                    gapComposer9.skipToGroupEnd();
                }
                return unit;
            case 9:
                Composer composer10 = (Composer) obj;
                int iIntValue10 = ((Integer) obj2).intValue();
                GapComposer gapComposer10 = (GapComposer) composer10;
                if (gapComposer10.shouldExecute(iIntValue10 & 1, (iIntValue10 & 3) != 2)) {
                    int iOrdinal3 = ((LibraryViewType) mutableState.getValue()).ordinal();
                    if (iOrdinal3 == 0) {
                        i3 = R.drawable.list;
                    } else {
                        if (iOrdinal3 != 1) {
                            PathKt$$ExternalSyntheticBUOutline0.m$1();
                            return null;
                        }
                        i3 = R.drawable.grid_view;
                    }
                    Painter painterPainterResource3 = IntMath.painterResource(i3, 0, gapComposer10);
                    int iOrdinal4 = ((LibraryViewType) mutableState.getValue()).ordinal();
                    if (iOrdinal4 == 0) {
                        i4 = R.string.switch_to_grid_view;
                    } else {
                        if (iOrdinal4 != 1) {
                            PathKt$$ExternalSyntheticBUOutline0.m$1();
                            return null;
                        }
                        i4 = R.string.switch_to_list_view;
                    }
                    IconKt.m290Iconww6aTOc(painterPainterResource3, MathKt.stringResource(i4, gapComposer10), (Modifier) null, 0L, gapComposer10, 8, 12);
                } else {
                    gapComposer10.skipToGroupEnd();
                }
                return unit;
            case 10:
                Composer composer11 = (Composer) obj;
                int iIntValue11 = ((Integer) obj2).intValue();
                GapComposer gapComposer11 = (GapComposer) composer11;
                if (gapComposer11.shouldExecute(iIntValue11 & 1, (iIntValue11 & 3) != 2)) {
                    RowMeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(OffsetKt.Start, Alignment.Companion.Top, gapComposer11, 0);
                    int iHashCode = Long.hashCode(gapComposer11.compositeKeyHashCode);
                    PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope = gapComposer11.currentCompositionLocalScope();
                    Modifier modifierMaterializeModifier = ZIndexModifierKt.materializeModifier(gapComposer11, Modifier.Companion.$$INSTANCE);
                    ComposeUiNode.Companion.getClass();
                    gapComposer11.startReusableNode();
                    if (gapComposer11.inserting) {
                        gapComposer11.createNode(LayoutNode.Constructor);
                    } else {
                        gapComposer11.useNode();
                    }
                    Stack.m390setimpl(gapComposer11, rowMeasurePolicy, ComposeUiNode.Companion.SetMeasurePolicy);
                    Stack.m390setimpl(gapComposer11, persistentCompositionLocalHashMapCurrentCompositionLocalScope, ComposeUiNode.Companion.SetResolvedCompositionLocals);
                    Stack.m390setimpl(gapComposer11, Integer.valueOf(iHashCode), ComposeUiNode.Companion.SetCompositeKeyHash);
                    Stack.m389reconcileimpl(gapComposer11);
                    Stack.m390setimpl(gapComposer11, modifierMaterializeModifier, ComposeUiNode.Companion.SetModifier);
                    List listListOf = CollectionsKt__IterablesKt.listOf((Object[]) new Pair[]{new Pair(LibraryFilter.PLAYLISTS, MathKt.stringResource(R.string.filter_playlists, gapComposer11)), new Pair(LibraryFilter.SONGS, MathKt.stringResource(R.string.filter_songs, gapComposer11)), new Pair(LibraryFilter.ALBUMS, MathKt.stringResource(R.string.filter_albums, gapComposer11)), new Pair(LibraryFilter.ARTISTS, MathKt.stringResource(R.string.filter_artists, gapComposer11)), new Pair(LibraryFilter.PODCASTS, MathKt.stringResource(R.string.filter_podcasts, gapComposer11))});
                    LibraryFilter libraryFilter = (LibraryFilter) mutableState.getValue();
                    boolean zChanged = gapComposer11.changed(mutableState);
                    Object objRememberedValue5 = gapComposer11.rememberedValue();
                    if (zChanged || objRememberedValue5 == neverEqualPolicy) {
                        objRememberedValue5 = new StatsScreenKt$$ExternalSyntheticLambda7(mutableState, (byte) 4);
                        gapComposer11.updateRememberedValue(objRememberedValue5);
                    }
                    DialogKt.m1461ChipsRowyrwZFoE(listListOf, libraryFilter, (Function1) objRememberedValue5, new LayoutWeightElement(1.0f, true), 0L, gapComposer11, 0, 16);
                    gapComposer11.end(true);
                } else {
                    gapComposer11.skipToGroupEnd();
                }
                return unit;
            case 11:
                Composer composer12 = (Composer) obj;
                int iIntValue12 = ((Integer) obj2).intValue();
                GapComposer gapComposer12 = (GapComposer) composer12;
                if (gapComposer12.shouldExecute(1 & iIntValue12, (iIntValue12 & 3) != 2)) {
                    if (TopPlaylistScreenKt.AutoPlaylistScreen$lambda$16(mutableState)) {
                        i11 = R.drawable.close;
                    }
                    IconKt.m290Iconww6aTOc(IntMath.painterResource(i11, 0, gapComposer12), (String) null, (Modifier) null, 0L, gapComposer12, 56, 12);
                } else {
                    gapComposer12.skipToGroupEnd();
                }
                return unit;
            case DictionaryEntry.PRONUNCIATION /* 12 */:
                Composer composer13 = (Composer) obj;
                int iIntValue13 = ((Integer) obj2).intValue();
                GapComposer gapComposer13 = (GapComposer) composer13;
                if (gapComposer13.shouldExecute(1 & iIntValue13, (iIntValue13 & 3) != 2)) {
                    if (TopPlaylistScreenKt.CachePlaylistScreen$lambda$7(mutableState)) {
                        i11 = R.drawable.close;
                    }
                    IconKt.m290Iconww6aTOc(IntMath.painterResource(i11, 0, gapComposer13), (String) null, (Modifier) null, 0L, gapComposer13, 56, 12);
                } else {
                    gapComposer13.skipToGroupEnd();
                }
                return unit;
            case 13:
                Composer composer14 = (Composer) obj;
                int iIntValue14 = ((Integer) obj2).intValue();
                GapComposer gapComposer14 = (GapComposer) composer14;
                if (gapComposer14.shouldExecute(1 & iIntValue14, (iIntValue14 & 3) != 2)) {
                    if (((Boolean) mutableState.getValue()).booleanValue()) {
                        i10 = R.drawable.lock;
                    }
                    IconKt.m290Iconww6aTOc(IntMath.painterResource(i10, 0, gapComposer14), (String) null, (Modifier) null, 0L, gapComposer14, 56, 12);
                } else {
                    gapComposer14.skipToGroupEnd();
                }
                return unit;
            case 14:
                Composer composer15 = (Composer) obj;
                int iIntValue15 = ((Integer) obj2).intValue();
                GapComposer gapComposer15 = (GapComposer) composer15;
                if (gapComposer15.shouldExecute(1 & iIntValue15, (iIntValue15 & 3) != 2)) {
                    if (TopPlaylistScreenKt.OnlinePlaylistScreen$lambda$20(mutableState)) {
                        i11 = R.drawable.close;
                    }
                    IconKt.m290Iconww6aTOc(IntMath.painterResource(i11, 0, gapComposer15), (String) null, (Modifier) null, 0L, gapComposer15, 56, 12);
                } else {
                    gapComposer15.skipToGroupEnd();
                }
                return unit;
            case 15:
                Composer composer16 = (Composer) obj;
                int iIntValue16 = ((Integer) obj2).intValue();
                GapComposer gapComposer16 = (GapComposer) composer16;
                if (gapComposer16.shouldExecute(1 & iIntValue16, (iIntValue16 & 3) != 2)) {
                    if (TopPlaylistScreenKt.TopPlaylistScreen$lambda$15(mutableState)) {
                        i11 = R.drawable.close;
                    }
                    IconKt.m290Iconww6aTOc(IntMath.painterResource(i11, 0, gapComposer16), (String) null, (Modifier) null, 0L, gapComposer16, 56, 12);
                } else {
                    gapComposer16.skipToGroupEnd();
                }
                return unit;
            case 16:
                Composer composer17 = (Composer) obj;
                int iIntValue17 = ((Integer) obj2).intValue();
                GapComposer gapComposer17 = (GapComposer) composer17;
                if (!gapComposer17.shouldExecute(1 & iIntValue17, (iIntValue17 & 3) != 2)) {
                    gapComposer17.skipToGroupEnd();
                } else if (((TextFieldValue) mutableState.getValue()).annotatedString.text.length() > 0) {
                    gapComposer17.startReplaceGroup(1488149400);
                    boolean zChanged2 = gapComposer17.changed(mutableState);
                    Object objRememberedValue6 = gapComposer17.rememberedValue();
                    if (zChanged2 || objRememberedValue6 == neverEqualPolicy) {
                        objRememberedValue6 = new AiSettingsKt$$ExternalSyntheticLambda3(mutableState, (byte) 2);
                        gapComposer17.updateRememberedValue(objRememberedValue6);
                    }
                    CardKt.IconButton((Function0) objRememberedValue6, null, false, null, null, LocalSearchScreenKt.lambda$2128929299, gapComposer17, 1572864, 62);
                    gapComposer17.end(false);
                } else {
                    gapComposer17.startReplaceGroup(1488608758);
                    gapComposer17.end(false);
                }
                return unit;
            case 17:
                Composer composer18 = (Composer) obj;
                int iIntValue18 = ((Integer) obj2).intValue();
                GapComposer gapComposer18 = (GapComposer) composer18;
                if (gapComposer18.shouldExecute(iIntValue18 & 1, (iIntValue18 & 3) != 2)) {
                    int iOrdinal5 = ((SearchSource) mutableState.getValue()).ordinal();
                    if (iOrdinal5 == 0) {
                        i5 = R.drawable.library_music;
                    } else {
                        if (iOrdinal5 != 1) {
                            PathKt$$ExternalSyntheticBUOutline0.m$1();
                            return null;
                        }
                        i5 = R.drawable.language;
                    }
                    IconKt.m290Iconww6aTOc(IntMath.painterResource(i5, 0, gapComposer18), (String) null, (Modifier) null, ((MaterialTheme$Values) gapComposer18.consume(MaterialThemeKt._localMaterialTheme)).colorScheme.onSurface, gapComposer18, 56, 4);
                } else {
                    gapComposer18.skipToGroupEnd();
                }
                return unit;
            case 18:
                Composer composer19 = (Composer) obj;
                int iIntValue19 = ((Integer) obj2).intValue();
                GapComposer gapComposer19 = (GapComposer) composer19;
                if (gapComposer19.shouldExecute(1 & iIntValue19, (iIntValue19 & 3) != 2)) {
                    boolean zChanged3 = gapComposer19.changed(mutableState);
                    Object objRememberedValue7 = gapComposer19.rememberedValue();
                    if (zChanged3 || objRememberedValue7 == neverEqualPolicy) {
                        objRememberedValue7 = new AiSettingsKt$$ExternalSyntheticLambda3(mutableState, (byte) 27);
                        gapComposer19.updateRememberedValue(objRememberedValue7);
                    }
                    CardKt.IconButton((Function0) objRememberedValue7, null, false, null, null, AiSettingsKt.f565lambda$697088351, gapComposer19, 1572864, 62);
                } else {
                    gapComposer19.skipToGroupEnd();
                }
                return unit;
            case 19:
                Composer composer20 = (Composer) obj;
                int iIntValue20 = ((Integer) obj2).intValue();
                GapComposer gapComposer20 = (GapComposer) composer20;
                if (gapComposer20.shouldExecute(1 & iIntValue20, (iIntValue20 & 3) != 2)) {
                    gapComposer20.startReplaceGroup(1119338410);
                    String strStringResource = (String) mutableState.getValue();
                    if (StringsKt.isBlank(strStringResource)) {
                        strStringResource = MathKt.stringResource(R.string.not_set, gapComposer20);
                    }
                    gapComposer20.end(false);
                    TextKt.m352TextNvy7gAk(strStringResource, null, 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer20, 0, 0, 262142);
                } else {
                    gapComposer20.skipToGroupEnd();
                }
                return unit;
            case 20:
                Composer composer21 = (Composer) obj;
                int iIntValue21 = ((Integer) obj2).intValue();
                GapComposer gapComposer21 = (GapComposer) composer21;
                if (gapComposer21.shouldExecute(1 & iIntValue21, (iIntValue21 & 3) != 2)) {
                    if (((String) mutableState.getValue()).length() > 0) {
                        gapComposer21.startReplaceGroup(-1674993861);
                        gapComposer21.end(false);
                        strM = StringsKt__StringsJVMKt.repeat(Math.min(((String) mutableState.getValue()).length(), 8), "•");
                    } else {
                        strM = Format$$ExternalSyntheticOutline0.m(gapComposer21, -1674861181, R.string.not_set, gapComposer21, false);
                    }
                    TextKt.m352TextNvy7gAk(strM, null, 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer21, 0, 0, 262142);
                } else {
                    gapComposer21.skipToGroupEnd();
                }
                return unit;
            case 21:
                Composer composer22 = (Composer) obj;
                int iIntValue22 = ((Integer) obj2).intValue();
                GapComposer gapComposer22 = (GapComposer) composer22;
                if (gapComposer22.shouldExecute(1 & iIntValue22, (iIntValue22 & 3) != 2)) {
                    String str4 = (String) mutableState.getValue();
                    int iHashCode2 = str4.hashCode();
                    if (iHashCode2 != 3318169) {
                        if (iHashCode2 != 3357525) {
                            if (iHashCode2 == 1544803905 && str4.equals("default")) {
                                i6 = 1302891633;
                                i7 = R.string.ai_deepl_formality_default;
                                strM2 = Format$$ExternalSyntheticOutline0.m(gapComposer22, i6, i7, gapComposer22, false);
                            } else {
                                gapComposer22.startReplaceGroup(1302901516);
                                gapComposer22.end(false);
                                strM2 = (String) mutableState.getValue();
                            }
                        } else if (str4.equals("more")) {
                            i6 = 1302895022;
                            i7 = R.string.ai_deepl_formality_more;
                            strM2 = Format$$ExternalSyntheticOutline0.m(gapComposer22, i6, i7, gapComposer22, false);
                        } else {
                            gapComposer22.startReplaceGroup(1302901516);
                            gapComposer22.end(false);
                            strM2 = (String) mutableState.getValue();
                        }
                    } else if (str4.equals("less")) {
                        i6 = 1302898318;
                        i7 = R.string.ai_deepl_formality_less;
                        strM2 = Format$$ExternalSyntheticOutline0.m(gapComposer22, i6, i7, gapComposer22, false);
                    } else {
                        gapComposer22.startReplaceGroup(1302901516);
                        gapComposer22.end(false);
                        strM2 = (String) mutableState.getValue();
                    }
                    TextKt.m352TextNvy7gAk(strM2, null, 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer22, 0, 0, 262142);
                } else {
                    gapComposer22.skipToGroupEnd();
                }
                return unit;
            case 22:
                Composer composer23 = (Composer) obj;
                int iIntValue23 = ((Integer) obj2).intValue();
                GapComposer gapComposer23 = (GapComposer) composer23;
                if (gapComposer23.shouldExecute(1 & iIntValue23, (iIntValue23 & 3) != 2)) {
                    if (((String) mutableState.getValue()).length() > 0) {
                        gapComposer23.startReplaceGroup(-2066910899);
                        gapComposer23.end(false);
                        strM3 = StringsKt__StringsJVMKt.repeat(Math.min(((String) mutableState.getValue()).length(), 8), "•");
                    } else {
                        strM3 = Format$$ExternalSyntheticOutline0.m(gapComposer23, -2066773414, R.string.not_set, gapComposer23, false);
                    }
                    TextKt.m352TextNvy7gAk(strM3, null, 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer23, 0, 0, 262142);
                } else {
                    gapComposer23.skipToGroupEnd();
                }
                return unit;
            case 23:
                Composer composer24 = (Composer) obj;
                int iIntValue24 = ((Integer) obj2).intValue();
                GapComposer gapComposer24 = (GapComposer) composer24;
                if (gapComposer24.shouldExecute(1 & iIntValue24, (iIntValue24 & 3) != 2)) {
                    boolean zChanged4 = gapComposer24.changed(mutableState);
                    Object objRememberedValue8 = gapComposer24.rememberedValue();
                    if (zChanged4 || objRememberedValue8 == neverEqualPolicy) {
                        objRememberedValue8 = new AiSettingsKt$$ExternalSyntheticLambda3(mutableState, (byte) 24);
                        gapComposer24.updateRememberedValue(objRememberedValue8);
                    }
                    CardKt.TextButton((Function0) objRememberedValue8, null, false, null, null, null, AiSettingsKt.f450lambda$1170272528, gapComposer24, 805306368, 510);
                } else {
                    gapComposer24.skipToGroupEnd();
                }
                return unit;
            case 24:
                Composer composer25 = (Composer) obj;
                int iIntValue25 = ((Integer) obj2).intValue();
                GapComposer gapComposer25 = (GapComposer) composer25;
                if (gapComposer25.shouldExecute(1 & iIntValue25, (iIntValue25 & 3) != 2)) {
                    gapComposer25.startReplaceGroup(-421798029);
                    String strStringResource2 = (String) mutableState.getValue();
                    if (StringsKt.isBlank(strStringResource2)) {
                        strStringResource2 = MathKt.stringResource(R.string.not_set, gapComposer25);
                    }
                    gapComposer25.end(false);
                    TextKt.m352TextNvy7gAk(strStringResource2, null, 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer25, 0, 0, 262142);
                } else {
                    gapComposer25.skipToGroupEnd();
                }
                return unit;
            case 25:
                Composer composer26 = (Composer) obj;
                int iIntValue26 = ((Integer) obj2).intValue();
                GapComposer gapComposer26 = (GapComposer) composer26;
                if (gapComposer26.shouldExecute(1 & iIntValue26, (iIntValue26 & 3) != 2)) {
                    String str5 = (String) mutableState.getValue();
                    if (Intrinsics.areEqual(str5, "Literal")) {
                        i8 = -76694923;
                        i9 = R.string.ai_translation_literal;
                    } else {
                        if (Intrinsics.areEqual(str5, "Transcribed")) {
                            i8 = -76691431;
                            i9 = R.string.ai_translation_transcribed;
                        } else {
                            gapComposer26.startReplaceGroup(-76688141);
                            gapComposer26.end(false);
                            strM4 = (String) mutableState.getValue();
                        }
                        TextKt.m352TextNvy7gAk(strM4, null, 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer26, 0, 0, 262142);
                    }
                    strM4 = Format$$ExternalSyntheticOutline0.m(gapComposer26, i8, i9, gapComposer26, false);
                    TextKt.m352TextNvy7gAk(strM4, null, 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer26, 0, 0, 262142);
                } else {
                    gapComposer26.skipToGroupEnd();
                }
                return unit;
            case 26:
                Composer composer27 = (Composer) obj;
                int iIntValue27 = ((Integer) obj2).intValue();
                GapComposer gapComposer27 = (GapComposer) composer27;
                if (gapComposer27.shouldExecute(1 & iIntValue27, (iIntValue27 & 3) != 2)) {
                    boolean zChanged5 = gapComposer27.changed(mutableState);
                    Object objRememberedValue9 = gapComposer27.rememberedValue();
                    if (zChanged5 || objRememberedValue9 == neverEqualPolicy) {
                        objRememberedValue9 = new AiSettingsKt$$ExternalSyntheticLambda3(mutableState, (byte) 26);
                        gapComposer27.updateRememberedValue(objRememberedValue9);
                    }
                    CardKt.IconButton((Function0) objRememberedValue9, null, false, null, null, AiSettingsKt.f560lambda$652339193, gapComposer27, 1572864, 62);
                } else {
                    gapComposer27.skipToGroupEnd();
                }
                return unit;
            case 27:
                Composer composer28 = (Composer) obj;
                int iIntValue28 = ((Integer) obj2).intValue();
                GapComposer gapComposer28 = (GapComposer) composer28;
                if (gapComposer28.shouldExecute(1 & iIntValue28, (iIntValue28 & 3) != 2)) {
                    if (StringsKt.isBlank((String) mutableState.getValue())) {
                        strM5 = Format$$ExternalSyntheticOutline0.m(gapComposer28, 1032556060, R.string.ai_system_prompt_default, gapComposer28, false);
                    } else {
                        gapComposer28.startReplaceGroup(1032297923);
                        gapComposer28.end(false);
                        strM5 = StringsKt.take(60, (String) mutableState.getValue());
                        if (((String) mutableState.getValue()).length() > 60) {
                            strM5 = strM5.concat("…");
                        }
                    }
                    TextKt.m352TextNvy7gAk(strM5, null, 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer28, 0, 0, 262142);
                } else {
                    gapComposer28.skipToGroupEnd();
                }
                return unit;
            case 28:
                Composer composer29 = (Composer) obj;
                int iIntValue29 = ((Integer) obj2).intValue();
                GapComposer gapComposer29 = (GapComposer) composer29;
                if (gapComposer29.shouldExecute(1 & iIntValue29, (iIntValue29 & 3) != 2)) {
                    String str6 = (String) PreferenceKeysKt.LanguageCodeToName.get((String) mutableState.getValue());
                    if (str6 == null) {
                        str6 = (String) mutableState.getValue();
                    }
                    TextKt.m352TextNvy7gAk(str6, null, 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer29, 0, 0, 262142);
                } else {
                    gapComposer29.skipToGroupEnd();
                }
                return unit;
            default:
                Composer composer30 = (Composer) obj;
                int iIntValue30 = ((Integer) obj2).intValue();
                GapComposer gapComposer30 = (GapComposer) composer30;
                if (gapComposer30.shouldExecute(1 & iIntValue30, (iIntValue30 & 3) != 2)) {
                    boolean zChanged6 = gapComposer30.changed(mutableState);
                    Object objRememberedValue10 = gapComposer30.rememberedValue();
                    if (zChanged6 || objRememberedValue10 == neverEqualPolicy) {
                        objRememberedValue10 = new AiSettingsKt$$ExternalSyntheticLambda3(mutableState, (byte) 23);
                        gapComposer30.updateRememberedValue(objRememberedValue10);
                    }
                    CardKt.TextButton((Function0) objRememberedValue10, null, false, null, null, null, AiSettingsKt.f438lambda$1016236071, gapComposer30, 805306368, 510);
                } else {
                    gapComposer30.skipToGroupEnd();
                }
                return unit;
        }
    }
}
