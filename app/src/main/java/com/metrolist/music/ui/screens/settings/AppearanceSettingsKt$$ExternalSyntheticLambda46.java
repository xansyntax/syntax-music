package com.metrolist.music.ui.screens.settings;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.compose.foundation.MarqueeSpacing$Companion$$ExternalSyntheticLambda0;
import androidx.compose.foundation.layout.Arrangement$SpacedAligned;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnMeasurePolicy;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowMeasurePolicy;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.shape.RoundedCornerShape;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.MaterialTheme$Values;
import androidx.compose.material3.MaterialThemeKt;
import androidx.compose.material3.SurfaceKt;
import androidx.compose.material3.TextKt;
import androidx.compose.material3.TextKt$$ExternalSyntheticLambda3;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.StaticProvidableCompositionLocal;
import androidx.compose.runtime.Updater$$ExternalSyntheticLambda0;
import androidx.compose.runtime.internal.PersistentCompositionLocalHashMap;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.BiasAlignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.ZIndexModifierKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.text.font.FontWeight;
import androidx.media3.common.Format$$ExternalSyntheticOutline0;
import com.atilika.kuromoji.ipadic.compile.DictionaryEntry;
import com.google.common.math.IntMath;
import com.metrolist.music.constants.GridItemSize;
import com.metrolist.music.constants.LibraryFilter;
import com.metrolist.music.constants.LyricsAnimationStyle;
import com.metrolist.music.constants.MiniPlayerBackgroundStyle;
import com.metrolist.music.constants.PlayerBackgroundStyle;
import com.metrolist.music.constants.PlayerButtonsStyle;
import com.metrolist.music.ui.component.DialogKt;
import com.yalantis.ucrop.R;
import com.yalantis.ucrop.view.CropImageView;
import java.util.Locale;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.math.MathKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class AppearanceSettingsKt$$ExternalSyntheticLambda46 implements Function3 {
    public final /* synthetic */ byte $r8$classId;

    public /* synthetic */ AppearanceSettingsKt$$ExternalSyntheticLambda46(byte b) {
        this.$r8$classId = b;
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        boolean z;
        int i;
        int i2;
        boolean z2;
        int i3;
        int i4;
        boolean z3;
        int i5;
        int i6;
        boolean z4;
        int i7;
        int i8;
        boolean z5;
        int i9;
        int i10;
        boolean z6;
        int i11;
        int i12;
        String strM;
        boolean z7;
        int i13;
        int i14;
        String strM2;
        boolean z8;
        int i15;
        int i16;
        String strValueOf;
        byte b = this.$r8$classId;
        Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
        Unit unit = Unit.INSTANCE;
        switch (b) {
            case 0:
                LyricsPosition lyricsPosition = (LyricsPosition) obj;
                ((Integer) obj3).getClass();
                lyricsPosition.getClass();
                GapComposer gapComposer = (GapComposer) ((Composer) obj2);
                gapComposer.startReplaceGroup(297850209);
                int iOrdinal = lyricsPosition.ordinal();
                if (iOrdinal == 0) {
                    z = false;
                    i = -1528755618;
                    i2 = R.string.left;
                } else if (iOrdinal == 1) {
                    z = false;
                    i = -1528753216;
                    i2 = R.string.center;
                } else {
                    if (iOrdinal != 2) {
                        throw Format$$ExternalSyntheticOutline0.m(gapComposer, -1528757153, false);
                    }
                    i = -1528750785;
                    i2 = R.string.right;
                    z = false;
                }
                String strM3 = Format$$ExternalSyntheticOutline0.m(gapComposer, i, i2, gapComposer, z);
                gapComposer.end(z);
                return strM3;
            case 1:
                LyricsAnimationStyle lyricsAnimationStyle = (LyricsAnimationStyle) obj;
                ((Integer) obj3).getClass();
                lyricsAnimationStyle.getClass();
                GapComposer gapComposer2 = (GapComposer) ((Composer) obj2);
                gapComposer2.startReplaceGroup(-1578182684);
                int iOrdinal2 = lyricsAnimationStyle.ordinal();
                if (iOrdinal2 == 0) {
                    z2 = false;
                    i3 = -510101262;
                    i4 = R.string.lyrics_animation_none;
                } else if (iOrdinal2 == 1) {
                    z2 = false;
                    i3 = -510098190;
                    i4 = R.string.lyrics_animation_fade;
                } else if (iOrdinal2 == 2) {
                    z2 = false;
                    i3 = -510095118;
                    i4 = R.string.lyrics_animation_glow;
                } else if (iOrdinal2 == 3) {
                    z2 = false;
                    i3 = -510092013;
                    i4 = R.string.lyrics_animation_slide;
                } else if (iOrdinal2 == 4) {
                    z2 = false;
                    i3 = -510088811;
                    i4 = R.string.lyrics_animation_karaoke;
                } else {
                    if (iOrdinal2 != 5) {
                        throw Format$$ExternalSyntheticOutline0.m(gapComposer2, -510102645, false);
                    }
                    i3 = -510085613;
                    i4 = R.string.lyrics_animation_apple;
                    z2 = false;
                }
                String strM4 = Format$$ExternalSyntheticOutline0.m(gapComposer2, i3, i4, gapComposer2, z2);
                gapComposer2.end(z2);
                return strM4;
            case 2:
                PlayerButtonsStyle playerButtonsStyle = (PlayerButtonsStyle) obj;
                ((Integer) obj3).getClass();
                playerButtonsStyle.getClass();
                GapComposer gapComposer3 = (GapComposer) ((Composer) obj2);
                gapComposer3.startReplaceGroup(-1393754543);
                int iOrdinal3 = playerButtonsStyle.ordinal();
                if (iOrdinal3 == 0) {
                    z3 = false;
                    i5 = 631683127;
                    i6 = R.string.default_style;
                } else if (iOrdinal3 == 1) {
                    z3 = false;
                    i5 = 631685981;
                    i6 = R.string.primary_color_style;
                } else {
                    if (iOrdinal3 != 2) {
                        throw Format$$ExternalSyntheticOutline0.m(gapComposer3, 631681415, false);
                    }
                    i5 = 631689054;
                    i6 = R.string.tertiary_color_style;
                    z3 = false;
                }
                String strM5 = Format$$ExternalSyntheticOutline0.m(gapComposer3, i5, i6, gapComposer3, z3);
                gapComposer3.end(z3);
                return strM5;
            case 3:
                PlayerBackgroundStyle playerBackgroundStyle = (PlayerBackgroundStyle) obj;
                ((Integer) obj3).getClass();
                playerBackgroundStyle.getClass();
                GapComposer gapComposer4 = (GapComposer) ((Composer) obj2);
                gapComposer4.startReplaceGroup(-279810005);
                int iOrdinal4 = playerBackgroundStyle.ordinal();
                if (iOrdinal4 == 0) {
                    z4 = false;
                    i7 = 1685527536;
                    i8 = R.string.follow_theme;
                } else if (iOrdinal4 == 1) {
                    z4 = false;
                    i7 = 1685530476;
                    i8 = R.string.gradient;
                } else {
                    if (iOrdinal4 != 2) {
                        throw Format$$ExternalSyntheticOutline0.m(gapComposer4, 1685525725, false);
                    }
                    i7 = 1685533178;
                    i8 = R.string.player_background_blur;
                    z4 = false;
                }
                String strM6 = Format$$ExternalSyntheticOutline0.m(gapComposer4, i7, i8, gapComposer4, z4);
                gapComposer4.end(z4);
                return strM6;
            case 4:
                MiniPlayerBackgroundStyle miniPlayerBackgroundStyle = (MiniPlayerBackgroundStyle) obj;
                ((Integer) obj3).getClass();
                miniPlayerBackgroundStyle.getClass();
                GapComposer gapComposer5 = (GapComposer) ((Composer) obj2);
                gapComposer5.startReplaceGroup(-186111885);
                int iOrdinal5 = miniPlayerBackgroundStyle.ordinal();
                if (iOrdinal5 == 0) {
                    z5 = false;
                    i9 = 1535107768;
                    i10 = R.string.follow_theme;
                } else if (iOrdinal5 == 1) {
                    z5 = false;
                    i9 = 1535110935;
                    i10 = R.string.transparent;
                } else if (iOrdinal5 == 2) {
                    z5 = false;
                    i9 = 1535113858;
                    i10 = R.string.player_background_blur;
                } else if (iOrdinal5 == 3) {
                    z5 = false;
                    i9 = 1535117236;
                    i10 = R.string.gradient;
                } else {
                    if (iOrdinal5 != 4) {
                        throw Format$$ExternalSyntheticOutline0.m(gapComposer5, 1535106035, false);
                    }
                    i9 = 1535120246;
                    i10 = R.string.pure_black;
                    z5 = false;
                }
                String strM7 = Format$$ExternalSyntheticOutline0.m(gapComposer5, i9, i10, gapComposer5, z5);
                gapComposer5.end(z5);
                return strM7;
            case 5:
                NavigationTab navigationTab = (NavigationTab) obj;
                ((Integer) obj3).getClass();
                navigationTab.getClass();
                GapComposer gapComposer6 = (GapComposer) ((Composer) obj2);
                gapComposer6.startReplaceGroup(2057092168);
                int iOrdinal6 = navigationTab.ordinal();
                if (iOrdinal6 != 0) {
                    if (iOrdinal6 == 1) {
                        z6 = false;
                        i11 = 1180621991;
                        i12 = R.string.search;
                    } else {
                        if (iOrdinal6 != 2) {
                            throw Format$$ExternalSyntheticOutline0.m(gapComposer6, 1180618126, false);
                        }
                        z6 = false;
                        strM = Format$$ExternalSyntheticOutline0.m(gapComposer6, 1180624463, R.string.filter_library, gapComposer6, false);
                    }
                    gapComposer6.end(z6);
                    return strM;
                }
                z6 = false;
                i11 = 1180619621;
                i12 = R.string.home;
                strM = Format$$ExternalSyntheticOutline0.m(gapComposer6, i11, i12, gapComposer6, z6);
                gapComposer6.end(z6);
                return strM;
            case 6:
                LibraryFilter libraryFilter = (LibraryFilter) obj;
                ((Integer) obj3).getClass();
                libraryFilter.getClass();
                GapComposer gapComposer7 = (GapComposer) ((Composer) obj2);
                gapComposer7.startReplaceGroup(2056695001);
                int iOrdinal7 = libraryFilter.ordinal();
                if (iOrdinal7 == 0) {
                    z7 = false;
                    i13 = 798942167;
                    i14 = R.string.songs;
                } else if (iOrdinal7 == 1) {
                    z7 = false;
                    i13 = 798944601;
                    i14 = R.string.artists;
                } else if (iOrdinal7 == 2) {
                    z7 = false;
                    i13 = 798947064;
                    i14 = R.string.albums;
                } else {
                    if (iOrdinal7 != 3) {
                        if (iOrdinal7 == 4) {
                            z7 = false;
                            i13 = 798952193;
                            i14 = R.string.filter_podcasts;
                        } else {
                            if (iOrdinal7 != 5) {
                                throw Format$$ExternalSyntheticOutline0.m(gapComposer7, 798940888, false);
                            }
                            z7 = false;
                            strM2 = Format$$ExternalSyntheticOutline0.m(gapComposer7, 798954944, R.string.filter_library, gapComposer7, false);
                        }
                        gapComposer7.end(z7);
                        return strM2;
                    }
                    z7 = false;
                    i13 = 798949595;
                    i14 = R.string.playlists;
                }
                strM2 = Format$$ExternalSyntheticOutline0.m(gapComposer7, i13, i14, gapComposer7, z7);
                gapComposer7.end(z7);
                return strM2;
            case 7:
                GridItemSize gridItemSize = (GridItemSize) obj;
                ((Integer) obj3).getClass();
                gridItemSize.getClass();
                GapComposer gapComposer8 = (GapComposer) ((Composer) obj2);
                gapComposer8.startReplaceGroup(-244254196);
                int iOrdinal8 = gridItemSize.ordinal();
                if (iOrdinal8 == 0) {
                    z8 = false;
                    i15 = 1494921192;
                    i16 = R.string.big;
                } else {
                    if (iOrdinal8 != 1) {
                        throw Format$$ExternalSyntheticOutline0.m(gapComposer8, 1494919671, false);
                    }
                    i15 = 1494923466;
                    i16 = R.string.small;
                    z8 = false;
                }
                String strM8 = Format$$ExternalSyntheticOutline0.m(gapComposer8, i15, i16, gapComposer8, z8);
                gapComposer8.end(z8);
                return strM8;
            case 8:
                Composer composer = (Composer) obj2;
                int iIntValue = ((Integer) obj3).intValue();
                ((ColumnScopeInstance) obj).getClass();
                GapComposer gapComposer9 = (GapComposer) composer;
                if (gapComposer9.shouldExecute(iIntValue & 1, (iIntValue & 17) != 16)) {
                    BiasAlignment.Vertical vertical = Alignment.Companion.CenterVertically;
                    Modifier modifierM135padding3ABfNKs = OffsetKt.m135padding3ABfNKs(SizeKt.fillMaxWidth(companion, 1.0f), 24.0f);
                    RowMeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(OffsetKt.Start, vertical, gapComposer9, 48);
                    int iHashCode = Long.hashCode(gapComposer9.compositeKeyHashCode);
                    PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope = gapComposer9.currentCompositionLocalScope();
                    Modifier modifierMaterializeModifier = ZIndexModifierKt.materializeModifier(gapComposer9, modifierM135padding3ABfNKs);
                    ComposeUiNode.Companion.getClass();
                    gapComposer9.startReusableNode();
                    boolean z9 = gapComposer9.inserting;
                    TextKt$$ExternalSyntheticLambda3 textKt$$ExternalSyntheticLambda3 = LayoutNode.Constructor;
                    if (z9) {
                        gapComposer9.createNode(textKt$$ExternalSyntheticLambda3);
                    } else {
                        gapComposer9.useNode();
                    }
                    Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda0 = ComposeUiNode.Companion.SetMeasurePolicy;
                    Stack.m390setimpl(gapComposer9, rowMeasurePolicy, updater$$ExternalSyntheticLambda0);
                    Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda1 = ComposeUiNode.Companion.SetResolvedCompositionLocals;
                    Stack.m390setimpl(gapComposer9, persistentCompositionLocalHashMapCurrentCompositionLocalScope, updater$$ExternalSyntheticLambda1);
                    Integer numValueOf = Integer.valueOf(iHashCode);
                    Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda2 = ComposeUiNode.Companion.SetCompositeKeyHash;
                    Stack.m390setimpl(gapComposer9, numValueOf, updater$$ExternalSyntheticLambda2);
                    Stack.m389reconcileimpl(gapComposer9);
                    Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda3 = ComposeUiNode.Companion.SetModifier;
                    Stack.m390setimpl(gapComposer9, modifierMaterializeModifier, updater$$ExternalSyntheticLambda3);
                    DialogKt.m1459AuralysMarkqi6gXK8(SizeKt.m151size3ABfNKs(companion, 64.0f), 0L, 0L, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, gapComposer9, 6);
                    OffsetKt.Spacer(gapComposer9, SizeKt.m155width3ABfNKs(companion, 20.0f));
                    ColumnMeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(OffsetKt.Top, Alignment.Companion.Start, gapComposer9, 0);
                    int iHashCode2 = Long.hashCode(gapComposer9.compositeKeyHashCode);
                    PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope2 = gapComposer9.currentCompositionLocalScope();
                    Modifier modifierMaterializeModifier2 = ZIndexModifierKt.materializeModifier(gapComposer9, companion);
                    gapComposer9.startReusableNode();
                    if (gapComposer9.inserting) {
                        gapComposer9.createNode(textKt$$ExternalSyntheticLambda3);
                    } else {
                        gapComposer9.useNode();
                    }
                    Stack.m390setimpl(gapComposer9, columnMeasurePolicy, updater$$ExternalSyntheticLambda0);
                    Stack.m390setimpl(gapComposer9, persistentCompositionLocalHashMapCurrentCompositionLocalScope2, updater$$ExternalSyntheticLambda1);
                    IntIntPair$$ExternalSyntheticOutline0.m(iHashCode2, gapComposer9, updater$$ExternalSyntheticLambda2, gapComposer9);
                    Stack.m390setimpl(gapComposer9, modifierMaterializeModifier2, updater$$ExternalSyntheticLambda3);
                    String strStringResource = MathKt.stringResource(R.string.metrolist, gapComposer9);
                    Locale locale = Locale.getDefault();
                    locale.getClass();
                    String lowerCase = strStringResource.toLowerCase(locale);
                    lowerCase.getClass();
                    if (lowerCase.length() > 0) {
                        StringBuilder sb = new StringBuilder();
                        char cCharAt = lowerCase.charAt(0);
                        if (Character.isLowerCase(cCharAt)) {
                            Locale locale2 = Locale.getDefault();
                            locale2.getClass();
                            String strValueOf2 = String.valueOf(cCharAt);
                            strValueOf2.getClass();
                            strValueOf = strValueOf2.toUpperCase(locale2);
                            strValueOf.getClass();
                            if (strValueOf.length() <= 1) {
                                String strValueOf3 = String.valueOf(cCharAt);
                                strValueOf3.getClass();
                                String upperCase = strValueOf3.toUpperCase(Locale.ROOT);
                                upperCase.getClass();
                                if (strValueOf.equals(upperCase)) {
                                    strValueOf = String.valueOf(Character.toTitleCase(cCharAt));
                                }
                            } else if (cCharAt != 329) {
                                char cCharAt2 = strValueOf.charAt(0);
                                String lowerCase2 = strValueOf.substring(1).toLowerCase(Locale.ROOT);
                                lowerCase2.getClass();
                                strValueOf = cCharAt2 + lowerCase2;
                            }
                        } else {
                            strValueOf = String.valueOf(cCharAt);
                        }
                        sb.append((Object) strValueOf);
                        sb.append(lowerCase.substring(1));
                        lowerCase = sb.toString();
                    }
                    String str = lowerCase;
                    StaticProvidableCompositionLocal staticProvidableCompositionLocal = MaterialThemeKt._localMaterialTheme;
                    TextKt.m352TextNvy7gAk(str, null, ((MaterialTheme$Values) gapComposer9.consume(staticProvidableCompositionLocal)).colorScheme.onSurface, 0L, null, FontWeight.Black, null, IntMath.getSp(-0.5d), null, 0L, 0, false, 0, 0, ((MaterialTheme$Values) gapComposer9.consume(staticProvidableCompositionLocal)).typography.headlineLarge, gapComposer9, 1572864, 0, 130746);
                    OffsetKt.Spacer(gapComposer9, SizeKt.m145height3ABfNKs(companion, 8.0f));
                    RowMeasurePolicy rowMeasurePolicy2 = RowKt.rowMeasurePolicy(new Arrangement$SpacedAligned(8.0f, true, new MarqueeSpacing$Companion$$ExternalSyntheticLambda0((byte) 5)), Alignment.Companion.Top, gapComposer9, 6);
                    int iHashCode3 = Long.hashCode(gapComposer9.compositeKeyHashCode);
                    PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope3 = gapComposer9.currentCompositionLocalScope();
                    Modifier modifierMaterializeModifier3 = ZIndexModifierKt.materializeModifier(gapComposer9, companion);
                    gapComposer9.startReusableNode();
                    if (gapComposer9.inserting) {
                        gapComposer9.createNode(textKt$$ExternalSyntheticLambda3);
                    } else {
                        gapComposer9.useNode();
                    }
                    Stack.m390setimpl(gapComposer9, rowMeasurePolicy2, updater$$ExternalSyntheticLambda0);
                    Stack.m390setimpl(gapComposer9, persistentCompositionLocalHashMapCurrentCompositionLocalScope3, updater$$ExternalSyntheticLambda1);
                    IntIntPair$$ExternalSyntheticOutline0.m(iHashCode3, gapComposer9, updater$$ExternalSyntheticLambda2, gapComposer9);
                    Stack.m390setimpl(gapComposer9, modifierMaterializeModifier3, updater$$ExternalSyntheticLambda3);
                    RoundedCornerShape roundedCornerShapeM185RoundedCornerShape0680j_4 = RoundedCornerShapeKt.m185RoundedCornerShape0680j_4(8.0f);
                    long j = ((MaterialTheme$Values) gapComposer9.consume(staticProvidableCompositionLocal)).colorScheme.primary;
                    SurfaceKt.m337SurfaceT9BRK9s(null, roundedCornerShapeM185RoundedCornerShape0680j_4, ColorKt.Color(Color.m485getRedimpl(j), Color.m484getGreenimpl(j), Color.m482getBlueimpl(j), 0.1f, Color.m483getColorSpaceimpl(j)), 0L, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, null, AiSettingsKt.f558lambda$59617265, gapComposer9, 12582912, 121);
                    RoundedCornerShape roundedCornerShapeM185RoundedCornerShape0680j_5 = RoundedCornerShapeKt.m185RoundedCornerShape0680j_4(8.0f);
                    long j2 = ((MaterialTheme$Values) gapComposer9.consume(staticProvidableCompositionLocal)).colorScheme.secondaryContainer;
                    SurfaceKt.m337SurfaceT9BRK9s(null, roundedCornerShapeM185RoundedCornerShape0680j_5, ColorKt.Color(Color.m485getRedimpl(j2), Color.m484getGreenimpl(j2), Color.m482getBlueimpl(j2), 0.5f, Color.m483getColorSpaceimpl(j2)), 0L, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, null, AiSettingsKt.lambda$1356932664, gapComposer9, 12582912, 121);
                    gapComposer9.startReplaceGroup(-1180292072);
                    gapComposer9.end(false);
                    gapComposer9.end(true);
                    gapComposer9.end(true);
                    gapComposer9.end(true);
                } else {
                    gapComposer9.skipToGroupEnd();
                }
                return unit;
            case 9:
                Composer composer2 = (Composer) obj2;
                int iIntValue2 = ((Integer) obj3).intValue();
                ((RowScope) obj).getClass();
                GapComposer gapComposer10 = (GapComposer) composer2;
                if (gapComposer10.shouldExecute(iIntValue2 & 1, (iIntValue2 & 17) != 16)) {
                    IconKt.m290Iconww6aTOc(IntMath.painterResource(R.drawable.telegram, 0, gapComposer10), (String) null, SizeKt.m151size3ABfNKs(companion, 20.0f), 0L, gapComposer10, 440, 8);
                    OffsetKt.Spacer(gapComposer10, SizeKt.m155width3ABfNKs(companion, 12.0f));
                    TextKt.m352TextNvy7gAk("Telegram  ·  @ryuzinetshh", null, 0L, 0L, null, FontWeight.SemiBold, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer10, 1572870, 0, 262078);
                } else {
                    gapComposer10.skipToGroupEnd();
                }
                return unit;
            case 10:
                Composer composer3 = (Composer) obj2;
                int iIntValue3 = ((Integer) obj3).intValue();
                ((RowScope) obj).getClass();
                GapComposer gapComposer11 = (GapComposer) composer3;
                if (gapComposer11.shouldExecute(iIntValue3 & 1, (iIntValue3 & 17) != 16)) {
                    IconKt.m290Iconww6aTOc(IntMath.painterResource(R.drawable.tiktok, 0, gapComposer11), (String) null, SizeKt.m151size3ABfNKs(companion, 20.0f), 0L, gapComposer11, 440, 8);
                    OffsetKt.Spacer(gapComposer11, SizeKt.m155width3ABfNKs(companion, 12.0f));
                    TextKt.m352TextNvy7gAk("TikTok  ·  @dappxml29", null, 0L, 0L, null, FontWeight.SemiBold, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer11, 1572870, 0, 262078);
                } else {
                    gapComposer11.skipToGroupEnd();
                }
                return unit;
            case 11:
                Composer composer4 = (Composer) obj2;
                int iIntValue4 = ((Integer) obj3).intValue();
                ((RowScope) obj).getClass();
                GapComposer gapComposer12 = (GapComposer) composer4;
                if (gapComposer12.shouldExecute(iIntValue4 & 1, (iIntValue4 & 17) != 16)) {
                    TextKt.m352TextNvy7gAk(MathKt.stringResource(android.R.string.ok, gapComposer12), null, 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer12, 0, 0, 262142);
                } else {
                    gapComposer12.skipToGroupEnd();
                }
                return unit;
            case DictionaryEntry.PRONUNCIATION /* 12 */:
                Composer composer5 = (Composer) obj2;
                int iIntValue5 = ((Integer) obj3).intValue();
                ((RowScope) obj).getClass();
                GapComposer gapComposer13 = (GapComposer) composer5;
                if (gapComposer13.shouldExecute(iIntValue5 & 1, (iIntValue5 & 17) != 16)) {
                    TextKt.m352TextNvy7gAk(MathKt.stringResource(android.R.string.ok, gapComposer13), null, 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer13, 0, 0, 262142);
                } else {
                    gapComposer13.skipToGroupEnd();
                }
                return unit;
            case 13:
                Composer composer6 = (Composer) obj2;
                int iIntValue6 = ((Integer) obj3).intValue();
                ((RowScope) obj).getClass();
                GapComposer gapComposer14 = (GapComposer) composer6;
                if (gapComposer14.shouldExecute(iIntValue6 & 1, (iIntValue6 & 17) != 16)) {
                    TextKt.m352TextNvy7gAk(MathKt.stringResource(R.string.ai_system_prompt_reset, gapComposer14), null, 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer14, 0, 0, 262142);
                } else {
                    gapComposer14.skipToGroupEnd();
                }
                return unit;
            case 14:
                Composer composer7 = (Composer) obj2;
                int iIntValue7 = ((Integer) obj3).intValue();
                ((RowScope) obj).getClass();
                GapComposer gapComposer15 = (GapComposer) composer7;
                if (gapComposer15.shouldExecute(iIntValue7 & 1, (iIntValue7 & 17) != 16)) {
                    TextKt.m352TextNvy7gAk(MathKt.stringResource(android.R.string.cancel, gapComposer15), null, 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer15, 0, 0, 262142);
                } else {
                    gapComposer15.skipToGroupEnd();
                }
                return unit;
            case 15:
                Composer composer8 = (Composer) obj2;
                int iIntValue8 = ((Integer) obj3).intValue();
                ((RowScope) obj).getClass();
                GapComposer gapComposer16 = (GapComposer) composer8;
                if (gapComposer16.shouldExecute(iIntValue8 & 1, (iIntValue8 & 17) != 16)) {
                    TextKt.m352TextNvy7gAk(MathKt.stringResource(android.R.string.ok, gapComposer16), null, 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer16, 0, 0, 262142);
                } else {
                    gapComposer16.skipToGroupEnd();
                }
                return unit;
            case 16:
                Composer composer9 = (Composer) obj2;
                int iIntValue9 = ((Integer) obj3).intValue();
                ((RowScope) obj).getClass();
                GapComposer gapComposer17 = (GapComposer) composer9;
                if (gapComposer17.shouldExecute(iIntValue9 & 1, (iIntValue9 & 17) != 16)) {
                    TextKt.m352TextNvy7gAk(MathKt.stringResource(android.R.string.ok, gapComposer17), null, 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer17, 0, 0, 262142);
                } else {
                    gapComposer17.skipToGroupEnd();
                }
                return unit;
            case 17:
                Composer composer10 = (Composer) obj2;
                int iIntValue10 = ((Integer) obj3).intValue();
                ((RowScope) obj).getClass();
                GapComposer gapComposer18 = (GapComposer) composer10;
                if (gapComposer18.shouldExecute(iIntValue10 & 1, (iIntValue10 & 17) != 16)) {
                    TextKt.m352TextNvy7gAk(MathKt.stringResource(android.R.string.cancel, gapComposer18), null, 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer18, 0, 0, 262142);
                } else {
                    gapComposer18.skipToGroupEnd();
                }
                return unit;
            case 18:
                Composer composer11 = (Composer) obj2;
                int iIntValue11 = ((Integer) obj3).intValue();
                ((RowScope) obj).getClass();
                GapComposer gapComposer19 = (GapComposer) composer11;
                if (gapComposer19.shouldExecute(iIntValue11 & 1, (iIntValue11 & 17) != 16)) {
                    TextKt.m352TextNvy7gAk(MathKt.stringResource(R.string.alarm_save, gapComposer19), null, 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer19, 0, 0, 262142);
                } else {
                    gapComposer19.skipToGroupEnd();
                }
                return unit;
            case 19:
                Composer composer12 = (Composer) obj2;
                int iIntValue12 = ((Integer) obj3).intValue();
                ((RowScope) obj).getClass();
                GapComposer gapComposer20 = (GapComposer) composer12;
                if (gapComposer20.shouldExecute(iIntValue12 & 1, (iIntValue12 & 17) != 16)) {
                    TextKt.m352TextNvy7gAk(MathKt.stringResource(android.R.string.cancel, gapComposer20), null, 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer20, 0, 0, 262142);
                } else {
                    gapComposer20.skipToGroupEnd();
                }
                return unit;
            case 20:
                Composer composer13 = (Composer) obj2;
                int iIntValue13 = ((Integer) obj3).intValue();
                ((RowScope) obj).getClass();
                GapComposer gapComposer21 = (GapComposer) composer13;
                if (gapComposer21.shouldExecute(iIntValue13 & 1, (iIntValue13 & 17) != 16)) {
                    TextKt.m352TextNvy7gAk(MathKt.stringResource(R.string.reset, gapComposer21), null, 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer21, 0, 0, 262142);
                } else {
                    gapComposer21.skipToGroupEnd();
                }
                return unit;
            case 21:
                Composer composer14 = (Composer) obj2;
                int iIntValue14 = ((Integer) obj3).intValue();
                ((RowScope) obj).getClass();
                GapComposer gapComposer22 = (GapComposer) composer14;
                if (gapComposer22.shouldExecute(iIntValue14 & 1, (iIntValue14 & 17) != 16)) {
                    TextKt.m352TextNvy7gAk(MathKt.stringResource(android.R.string.cancel, gapComposer22), null, 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer22, 0, 0, 262142);
                } else {
                    gapComposer22.skipToGroupEnd();
                }
                return unit;
            case 22:
                Composer composer15 = (Composer) obj2;
                int iIntValue15 = ((Integer) obj3).intValue();
                ((RowScope) obj).getClass();
                GapComposer gapComposer23 = (GapComposer) composer15;
                if (gapComposer23.shouldExecute(iIntValue15 & 1, (iIntValue15 & 17) != 16)) {
                    TextKt.m352TextNvy7gAk(MathKt.stringResource(android.R.string.ok, gapComposer23), null, 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer23, 0, 0, 262142);
                } else {
                    gapComposer23.skipToGroupEnd();
                }
                return unit;
            case 23:
                Composer composer16 = (Composer) obj2;
                int iIntValue16 = ((Integer) obj3).intValue();
                ((RowScope) obj).getClass();
                GapComposer gapComposer24 = (GapComposer) composer16;
                if (gapComposer24.shouldExecute(iIntValue16 & 1, (iIntValue16 & 17) != 16)) {
                    TextKt.m352TextNvy7gAk(MathKt.stringResource(R.string.reset, gapComposer24), null, 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer24, 0, 0, 262142);
                } else {
                    gapComposer24.skipToGroupEnd();
                }
                return unit;
            case 24:
                Composer composer17 = (Composer) obj2;
                int iIntValue17 = ((Integer) obj3).intValue();
                ((RowScope) obj).getClass();
                GapComposer gapComposer25 = (GapComposer) composer17;
                if (gapComposer25.shouldExecute(iIntValue17 & 1, (iIntValue17 & 17) != 16)) {
                    TextKt.m352TextNvy7gAk(MathKt.stringResource(android.R.string.cancel, gapComposer25), null, 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer25, 0, 0, 262142);
                } else {
                    gapComposer25.skipToGroupEnd();
                }
                return unit;
            case 25:
                Composer composer18 = (Composer) obj2;
                int iIntValue18 = ((Integer) obj3).intValue();
                ((RowScope) obj).getClass();
                GapComposer gapComposer26 = (GapComposer) composer18;
                if (gapComposer26.shouldExecute(iIntValue18 & 1, (iIntValue18 & 17) != 16)) {
                    TextKt.m352TextNvy7gAk(MathKt.stringResource(android.R.string.ok, gapComposer26), null, 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer26, 0, 0, 262142);
                } else {
                    gapComposer26.skipToGroupEnd();
                }
                return unit;
            case 26:
                Composer composer19 = (Composer) obj2;
                int iIntValue19 = ((Integer) obj3).intValue();
                ((RowScope) obj).getClass();
                GapComposer gapComposer27 = (GapComposer) composer19;
                if (gapComposer27.shouldExecute(iIntValue19 & 1, (iIntValue19 & 17) != 16)) {
                    TextKt.m352TextNvy7gAk(MathKt.stringResource(R.string.reset, gapComposer27), null, 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer27, 0, 0, 262142);
                } else {
                    gapComposer27.skipToGroupEnd();
                }
                return unit;
            case 27:
                Composer composer20 = (Composer) obj2;
                int iIntValue20 = ((Integer) obj3).intValue();
                ((RowScope) obj).getClass();
                GapComposer gapComposer28 = (GapComposer) composer20;
                if (gapComposer28.shouldExecute(iIntValue20 & 1, (iIntValue20 & 17) != 16)) {
                    TextKt.m352TextNvy7gAk(MathKt.stringResource(android.R.string.cancel, gapComposer28), null, 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer28, 0, 0, 262142);
                } else {
                    gapComposer28.skipToGroupEnd();
                }
                return unit;
            case 28:
                Composer composer21 = (Composer) obj2;
                int iIntValue21 = ((Integer) obj3).intValue();
                ((RowScope) obj).getClass();
                GapComposer gapComposer29 = (GapComposer) composer21;
                if (gapComposer29.shouldExecute(iIntValue21 & 1, (iIntValue21 & 17) != 16)) {
                    TextKt.m352TextNvy7gAk(MathKt.stringResource(android.R.string.ok, gapComposer29), null, 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer29, 0, 0, 262142);
                } else {
                    gapComposer29.skipToGroupEnd();
                }
                return unit;
            default:
                Composer composer22 = (Composer) obj2;
                int iIntValue22 = ((Integer) obj3).intValue();
                ((RowScope) obj).getClass();
                GapComposer gapComposer30 = (GapComposer) composer22;
                if (gapComposer30.shouldExecute(iIntValue22 & 1, (iIntValue22 & 17) != 16)) {
                    TextKt.m352TextNvy7gAk(MathKt.stringResource(R.string.cancel, gapComposer30), null, 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer30, 0, 0, 262142);
                } else {
                    gapComposer30.skipToGroupEnd();
                }
                return unit;
        }
    }
}
