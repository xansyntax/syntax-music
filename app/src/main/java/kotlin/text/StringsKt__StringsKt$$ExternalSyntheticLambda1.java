package kotlin.text;

import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.FillElement;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.text.BasicTextKt;
import androidx.compose.foundation.text.selection.TextFieldSelectionManager;
import androidx.compose.material3.MaterialTheme$Values;
import androidx.compose.material3.MaterialThemeKt;
import androidx.compose.material3.SliderColors;
import androidx.compose.material3.SliderDefaults;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.StaticProvidableCompositionLocal;
import androidx.compose.runtime.internal.PersistentCompositionLocalHashMap;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.BiasAlignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.ZIndexModifierKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.lifecycle.SavedStateHandle;
import androidx.media3.common.Format$$ExternalSyntheticOutline0;
import com.metrolist.innertube.models.ArtistItem;
import com.metrolist.innertube.models.YTItem;
import com.metrolist.music.MainActivityKt;
import com.metrolist.music.constants.MiniPlayerBackgroundStyle;
import com.metrolist.music.constants.SliderStyle;
import com.metrolist.music.db.entities.Album;
import com.metrolist.music.db.entities.Song;
import com.metrolist.music.eq.data.SavedEQProfile;
import com.metrolist.music.listentogether.proto.Listentogether;
import com.metrolist.music.ui.screens.search.SearchScreenKt;
import com.metrolist.music.utils.ArtistNameAliases;
import com.yalantis.ucrop.R;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.ranges.IntRange;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class StringsKt__StringsKt$$ExternalSyntheticLambda1 implements Function2 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ Object f$0;
    public final /* synthetic */ boolean f$1;

    public /* synthetic */ StringsKt__StringsKt$$ExternalSyntheticLambda1(boolean z, SavedStateHandle savedStateHandle, int i) {
        this.$r8$classId = (byte) 9;
        this.f$1 = z;
        this.f$0 = savedStateHandle;
    }

    /* JADX WARN: Code duplicated, block: B:155:0x0503  */
    /* JADX WARN: Code duplicated, block: B:197:0x05a6 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:198:0x05a8 A[LOOP:2: B:187:0x057a->B:198:0x05a8, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:206:0x059c A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:207:0x0503 A[SYNTHETIC] */
    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        Object next;
        String str;
        Pair pair;
        String str2;
        boolean z;
        Object next2;
        String title;
        long j;
        long j2;
        long j3;
        long j4;
        int i;
        int i2;
        String strM;
        long jColor;
        int i3;
        int i4;
        String strM2;
        int i5;
        int i6;
        byte b = this.$r8$classId;
        Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
        Unit unit = Unit.INSTANCE;
        boolean z2 = this.f$1;
        Object obj3 = this.f$0;
        switch (b) {
            case 0:
                List list = (List) obj3;
                CharSequence charSequence = (CharSequence) obj;
                int iIntValue = ((Integer) obj2).intValue();
                charSequence.getClass();
                boolean z3 = this.f$1;
                if (z3 || list.size() != 1) {
                    int i7 = iIntValue >= 0 ? iIntValue : 0;
                    IntRange intRange = new IntRange(i7, charSequence.length(), 1);
                    boolean z4 = charSequence instanceof String;
                    int i8 = intRange.step;
                    int i9 = intRange.last;
                    if (z4) {
                        if ((i8 <= 0 || i7 > i9) && (i8 >= 0 || i9 > i7)) {
                            pair = null;
                        } else {
                            int i10 = i7;
                            while (true) {
                                Iterator it = list.iterator();
                                while (true) {
                                    if (it.hasNext()) {
                                        next2 = it.next();
                                        String str3 = (String) next2;
                                        boolean z5 = z3;
                                        z = z5;
                                        if (!StringsKt__StringsJVMKt.regionMatches(0, i10, str3.length(), str3, (String) charSequence, z5)) {
                                            z3 = z;
                                        }
                                    } else {
                                        z = z3;
                                        next2 = null;
                                    }
                                }
                                String str4 = (String) next2;
                                if (str4 != null) {
                                    pair = new Pair(Integer.valueOf(i10), str4);
                                } else if (i10 != i9) {
                                    i10 += i8;
                                    z3 = z;
                                } else {
                                    pair = null;
                                }
                            }
                        }
                    } else if ((i8 <= 0 || i7 > i9) && (i8 >= 0 || i9 > i7)) {
                        pair = null;
                    } else {
                        int i11 = i7;
                        while (true) {
                            Iterator it2 = list.iterator();
                            do {
                                if (it2.hasNext()) {
                                    next = it2.next();
                                    str2 = (String) next;
                                } else {
                                    next = null;
                                }
                                str = (String) next;
                                if (str != null) {
                                    pair = new Pair(Integer.valueOf(i11), str);
                                } else if (i11 != i9) {
                                    i11 += i8;
                                } else {
                                    pair = null;
                                }
                            } while (!StringsKt.regionMatchesImpl(str2, 0, charSequence, i11, str2.length(), z3));
                            str = (String) next;
                            if (str != null) {
                                pair = new Pair(Integer.valueOf(i11), str);
                            } else if (i11 != i9) {
                                i11 += i8;
                            } else {
                                pair = null;
                            }
                        }
                    }
                } else {
                    String str5 = (String) CollectionsKt.single((Iterable) list);
                    int iIndexOf$default = StringsKt.indexOf$default(charSequence, str5, iIntValue, false, 4);
                    if (iIndexOf$default < 0) {
                        pair = null;
                    } else {
                        pair = new Pair(Integer.valueOf(iIndexOf$default), str5);
                    }
                }
                if (pair != null) {
                    return new Pair(pair.first, Integer.valueOf(((String) pair.second).length()));
                }
                return null;
            case 1:
                ((Integer) obj2).getClass();
                BasicTextKt.DefaultCursorHandle((Modifier) obj3, (Composer) obj, Stack.updateChangedFlags(1), z2 ? 1 : 0);
                return unit;
            case 2:
                ((Integer) obj2).getClass();
                BasicTextKt.SelectionToolbarAndHandles((TextFieldSelectionManager) obj3, z2, (Composer) obj, Stack.updateChangedFlags(1));
                return unit;
            case 3:
                SliderDefaults sliderDefaults = SliderDefaults.INSTANCE;
                SliderDefaults.m329drawStopIndicatorx3O1jOs((DrawScope) obj, ((Offset) obj2).packedValue, ((SliderColors) obj3).m327trackColorWaAFU9c$material3(z2, true));
                return unit;
            case 4:
                YTItem yTItem = (YTItem) obj3;
                Composer composer = (Composer) obj;
                int iIntValue2 = ((Integer) obj2).intValue();
                GapComposer gapComposer = (GapComposer) composer;
                if (gapComposer.shouldExecute(iIntValue2 & 1, (iIntValue2 & 3) != 2)) {
                    if (yTItem instanceof ArtistItem) {
                        gapComposer.startReplaceGroup(951611422);
                        ArtistNameAliases artistNameAliases = ArtistNameAliases.INSTANCE;
                        ArtistItem artistItem = (ArtistItem) yTItem;
                        title = ArtistNameAliases.resolve(artistItem.id, artistItem.title, (Map) gapComposer.consume(MainActivityKt.LocalArtistNameAliases));
                        gapComposer.end(false);
                    } else {
                        gapComposer.startReplaceGroup(951724386);
                        gapComposer.end(false);
                        title = yTItem.getTitle();
                    }
                    String str6 = title;
                    StaticProvidableCompositionLocal staticProvidableCompositionLocal = MaterialThemeKt._localMaterialTheme;
                    TextStyle textStyle = ((MaterialTheme$Values) gapComposer.consume(staticProvidableCompositionLocal)).typography.titleMedium;
                    if (z2) {
                        gapComposer.startReplaceGroup(1554726589);
                        j = ((MaterialTheme$Values) gapComposer.consume(staticProvidableCompositionLocal)).colorScheme.primary;
                    } else {
                        gapComposer.startReplaceGroup(1554727839);
                        j = ((MaterialTheme$Values) gapComposer.consume(staticProvidableCompositionLocal)).colorScheme.onSurface;
                    }
                    gapComposer.end(false);
                    TextKt.m352TextNvy7gAk(str6, SizeKt.fillMaxWidth(companion, 1.0f), j, 0L, null, null, null, 0L, new TextAlign(5), 0L, 2, false, 1, 0, textStyle, gapComposer, 48, 24960, 109560);
                } else {
                    gapComposer.skipToGroupEnd();
                }
                return unit;
            case 5:
                Song song = (Song) obj3;
                Composer composer2 = (Composer) obj;
                int iIntValue3 = ((Integer) obj2).intValue();
                GapComposer gapComposer2 = (GapComposer) composer2;
                if (gapComposer2.shouldExecute(iIntValue3 & 1, (iIntValue3 & 3) != 2)) {
                    String str7 = song.song.title;
                    StaticProvidableCompositionLocal staticProvidableCompositionLocal2 = MaterialThemeKt._localMaterialTheme;
                    TextStyle textStyle2 = ((MaterialTheme$Values) gapComposer2.consume(staticProvidableCompositionLocal2)).typography.titleMedium;
                    if (z2) {
                        gapComposer2.startReplaceGroup(-58284682);
                        j2 = ((MaterialTheme$Values) gapComposer2.consume(staticProvidableCompositionLocal2)).colorScheme.primary;
                    } else {
                        gapComposer2.startReplaceGroup(-58283432);
                        j2 = ((MaterialTheme$Values) gapComposer2.consume(staticProvidableCompositionLocal2)).colorScheme.onSurface;
                    }
                    gapComposer2.end(false);
                    TextKt.m352TextNvy7gAk(str7, SizeKt.fillMaxWidth(companion, 1.0f), j2, 0L, null, null, null, 0L, null, 0L, 2, false, 1, 0, textStyle2, gapComposer2, 48, 24960, 110584);
                } else {
                    gapComposer2.skipToGroupEnd();
                }
                return unit;
            case 6:
                Album album = (Album) obj3;
                Composer composer3 = (Composer) obj;
                int iIntValue4 = ((Integer) obj2).intValue();
                GapComposer gapComposer3 = (GapComposer) composer3;
                if (gapComposer3.shouldExecute(iIntValue4 & 1, (iIntValue4 & 3) != 2)) {
                    String str8 = album.album.title;
                    StaticProvidableCompositionLocal staticProvidableCompositionLocal3 = MaterialThemeKt._localMaterialTheme;
                    TextStyle textStyle3 = ((MaterialTheme$Values) gapComposer3.consume(staticProvidableCompositionLocal3)).typography.titleMedium;
                    if (z2) {
                        gapComposer3.startReplaceGroup(-496136268);
                        j3 = ((MaterialTheme$Values) gapComposer3.consume(staticProvidableCompositionLocal3)).colorScheme.primary;
                    } else {
                        gapComposer3.startReplaceGroup(-496135018);
                        j3 = ((MaterialTheme$Values) gapComposer3.consume(staticProvidableCompositionLocal3)).colorScheme.onSurface;
                    }
                    gapComposer3.end(false);
                    TextKt.m352TextNvy7gAk(str8, SizeKt.fillMaxWidth(companion, 1.0f), j3, 0L, null, null, null, 0L, null, 0L, 2, false, 1, 0, textStyle3, gapComposer3, 48, 24960, 110584);
                } else {
                    gapComposer3.skipToGroupEnd();
                }
                return unit;
            case 7:
                Listentogether.UserInfo userInfo = (Listentogether.UserInfo) obj3;
                Composer composer4 = (Composer) obj;
                int iIntValue5 = ((Integer) obj2).intValue();
                GapComposer gapComposer4 = (GapComposer) composer4;
                if (gapComposer4.shouldExecute(iIntValue5 & 1, (iIntValue5 & 3) != 2)) {
                    BiasAlignment biasAlignment = Alignment.Companion.Center;
                    FillElement fillElement = SizeKt.FillWholeMaxSize;
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(biasAlignment, false);
                    int iHashCode = Long.hashCode(gapComposer4.compositeKeyHashCode);
                    PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope = gapComposer4.currentCompositionLocalScope();
                    Modifier modifierMaterializeModifier = ZIndexModifierKt.materializeModifier(gapComposer4, fillElement);
                    ComposeUiNode.Companion.getClass();
                    gapComposer4.startReusableNode();
                    if (gapComposer4.inserting) {
                        gapComposer4.createNode(LayoutNode.Constructor);
                    } else {
                        gapComposer4.useNode();
                    }
                    Stack.m390setimpl(gapComposer4, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.Companion.SetMeasurePolicy);
                    Stack.m390setimpl(gapComposer4, persistentCompositionLocalHashMapCurrentCompositionLocalScope, ComposeUiNode.Companion.SetResolvedCompositionLocals);
                    Stack.m390setimpl(gapComposer4, Integer.valueOf(iHashCode), ComposeUiNode.Companion.SetCompositeKeyHash);
                    Stack.m389reconcileimpl(gapComposer4);
                    Stack.m390setimpl(gapComposer4, modifierMaterializeModifier, ComposeUiNode.Companion.SetModifier);
                    String username = userInfo.getUsername();
                    username.getClass();
                    String upperCase = StringsKt.take(1, username).toUpperCase(Locale.ROOT);
                    upperCase.getClass();
                    StaticProvidableCompositionLocal staticProvidableCompositionLocal4 = MaterialThemeKt._localMaterialTheme;
                    TextStyle textStyle4 = ((MaterialTheme$Values) gapComposer4.consume(staticProvidableCompositionLocal4)).typography.titleLarge;
                    FontWeight fontWeight = FontWeight.Bold;
                    if (userInfo.getIsHost()) {
                        gapComposer4.startReplaceGroup(-2028137296);
                        j4 = ((MaterialTheme$Values) gapComposer4.consume(staticProvidableCompositionLocal4)).colorScheme.onPrimary;
                        gapComposer4.end(false);
                    } else if (z2) {
                        gapComposer4.startReplaceGroup(-2028134574);
                        j4 = ((MaterialTheme$Values) gapComposer4.consume(staticProvidableCompositionLocal4)).colorScheme.onSecondary;
                        gapComposer4.end(false);
                    } else {
                        gapComposer4.startReplaceGroup(-2028132073);
                        j4 = ((MaterialTheme$Values) gapComposer4.consume(staticProvidableCompositionLocal4)).colorScheme.onSurfaceVariant;
                        gapComposer4.end(false);
                    }
                    TextKt.m352TextNvy7gAk(upperCase, null, j4, 0L, null, fontWeight, null, 0L, null, 0L, 0, false, 0, 0, textStyle4, gapComposer4, 1572864, 0, 131002);
                    gapComposer4.end(true);
                } else {
                    gapComposer4.skipToGroupEnd();
                }
                return unit;
            case 8:
                SavedEQProfile savedEQProfile = (SavedEQProfile) obj3;
                Composer composer5 = (Composer) obj;
                int iIntValue6 = ((Integer) obj2).intValue();
                GapComposer gapComposer5 = (GapComposer) composer5;
                if (gapComposer5.shouldExecute(iIntValue6 & 1, (iIntValue6 & 3) != 2)) {
                    TextKt.m352TextNvy7gAk(savedEQProfile.deviceModel, null, 0L, 0L, null, z2 ? FontWeight.SemiBold : FontWeight.Normal, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer5, 0, 0, 262078);
                } else {
                    gapComposer5.skipToGroupEnd();
                }
                return unit;
            case 9:
                ((Integer) obj2).getClass();
                SearchScreenKt.SearchScreen(z2, (SavedStateHandle) obj3, (Composer) obj, Stack.updateChangedFlags(1));
                return unit;
            case 10:
                MiniPlayerBackgroundStyle miniPlayerBackgroundStyle = (MiniPlayerBackgroundStyle) obj3;
                Composer composer6 = (Composer) obj;
                int iIntValue7 = ((Integer) obj2).intValue();
                GapComposer gapComposer6 = (GapComposer) composer6;
                if (gapComposer6.shouldExecute(iIntValue7 & 1, (iIntValue7 & 3) != 2)) {
                    if (z2) {
                        gapComposer6.startReplaceGroup(-146447027);
                        int iOrdinal = miniPlayerBackgroundStyle.ordinal();
                        if (iOrdinal == 0) {
                            i = -1390194400;
                            i2 = R.string.follow_theme;
                        } else if (iOrdinal == 1) {
                            i = -1390190337;
                            i2 = R.string.transparent;
                        } else if (iOrdinal == 2) {
                            i = -1390186518;
                            i2 = R.string.player_background_blur;
                        } else if (iOrdinal == 3) {
                            i = -1390182244;
                            i2 = R.string.gradient;
                        } else {
                            if (iOrdinal != 4) {
                                throw Format$$ExternalSyntheticOutline0.m(gapComposer6, -1390197419, false);
                            }
                            i = -1390178338;
                            i2 = R.string.pure_black;
                        }
                        strM = Format$$ExternalSyntheticOutline0.m(gapComposer6, i, i2, gapComposer6, false);
                        gapComposer6.end(false);
                    } else {
                        strM = Format$$ExternalSyntheticOutline0.m(gapComposer6, -146663438, R.string.mini_player_background_not_available, gapComposer6, false);
                    }
                    String str9 = strM;
                    if (z2) {
                        gapComposer6.startReplaceGroup(-145468667);
                        jColor = ((MaterialTheme$Values) gapComposer6.consume(MaterialThemeKt._localMaterialTheme)).colorScheme.onSurfaceVariant;
                        gapComposer6.end(false);
                    } else {
                        gapComposer6.startReplaceGroup(-145616072);
                        long j5 = ((MaterialTheme$Values) gapComposer6.consume(MaterialThemeKt._localMaterialTheme)).colorScheme.onSurface;
                        jColor = ColorKt.Color(Color.m485getRedimpl(j5), Color.m484getGreenimpl(j5), Color.m482getBlueimpl(j5), 0.38f, Color.m483getColorSpaceimpl(j5));
                        gapComposer6.end(false);
                    }
                    TextKt.m352TextNvy7gAk(str9, null, jColor, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer6, 0, 0, 262138);
                } else {
                    gapComposer6.skipToGroupEnd();
                }
                return unit;
            default:
                SliderStyle sliderStyle = (SliderStyle) obj3;
                Composer composer7 = (Composer) obj;
                int iIntValue8 = ((Integer) obj2).intValue();
                GapComposer gapComposer7 = (GapComposer) composer7;
                if (gapComposer7.shouldExecute(iIntValue8 & 1, (iIntValue8 & 3) != 2)) {
                    int iOrdinal2 = sliderStyle.ordinal();
                    if (iOrdinal2 != 0) {
                        if (iOrdinal2 == 1) {
                            gapComposer7.startReplaceGroup(1542800710);
                            if (z2) {
                                i5 = 1542852356;
                                i6 = R.string.squiggly;
                            } else {
                                i5 = 1542981161;
                                i6 = R.string.wavy;
                            }
                            strM2 = Format$$ExternalSyntheticOutline0.m(gapComposer7, i5, i6, gapComposer7, false);
                            gapComposer7.end(false);
                        } else {
                            if (iOrdinal2 != 2) {
                                throw Format$$ExternalSyntheticOutline0.m(gapComposer7, -781523808, false);
                            }
                            i3 = 1543283504;
                            i4 = R.string.slim;
                        }
                        TextKt.m352TextNvy7gAk(strM2, null, 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer7, 0, 0, 262142);
                    } else {
                        i3 = 1542620972;
                        i4 = R.string.default_;
                    }
                    strM2 = Format$$ExternalSyntheticOutline0.m(gapComposer7, i3, i4, gapComposer7, false);
                    TextKt.m352TextNvy7gAk(strM2, null, 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer7, 0, 0, 262142);
                } else {
                    gapComposer7.skipToGroupEnd();
                }
                return unit;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ StringsKt__StringsKt$$ExternalSyntheticLambda1(Modifier modifier, int i, int i2) {
        this.$r8$classId = (byte) 1;
        this.f$0 = modifier;
        this.f$1 = i2;
    }

    public /* synthetic */ StringsKt__StringsKt$$ExternalSyntheticLambda1(Object obj, boolean z, byte b) {
        this.$r8$classId = b;
        this.f$0 = obj;
        this.f$1 = z;
    }

    public /* synthetic */ StringsKt__StringsKt$$ExternalSyntheticLambda1(TextFieldSelectionManager textFieldSelectionManager, boolean z, int i) {
        this.$r8$classId = (byte) 2;
        this.f$0 = textFieldSelectionManager;
        this.f$1 = z;
    }

    public /* synthetic */ StringsKt__StringsKt$$ExternalSyntheticLambda1(boolean z, MiniPlayerBackgroundStyle miniPlayerBackgroundStyle) {
        this.$r8$classId = (byte) 10;
        this.f$1 = z;
        this.f$0 = miniPlayerBackgroundStyle;
    }
}
