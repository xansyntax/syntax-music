package com.metrolist.music.ui.menu;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.MarqueeSpacing$Companion$$ExternalSyntheticLambda0;
import androidx.compose.foundation.interaction.MutableInteractionSourceImpl;
import androidx.compose.foundation.layout.Arrangement$End$1;
import androidx.compose.foundation.layout.Arrangement$SpacedAligned;
import androidx.compose.foundation.layout.Arrangement$Top$1;
import androidx.compose.foundation.layout.AspectRatioElement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnMeasurePolicy;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.LayoutWeightElement;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowMeasurePolicy;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.lazy.LazyItemScopeImpl;
import androidx.compose.foundation.shape.RoundedCornerShape;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material3.CardKt;
import androidx.compose.material3.ListItemKt$$ExternalSyntheticLambda11;
import androidx.compose.material3.ListItemKt$$ExternalSyntheticLambda17;
import androidx.compose.material3.MaterialTheme$Values;
import androidx.compose.material3.MaterialThemeKt;
import androidx.compose.material3.RippleKt;
import androidx.compose.material3.RippleNodeFactory;
import androidx.compose.material3.SliderColors;
import androidx.compose.material3.SliderDefaults;
import androidx.compose.material3.SliderKt;
import androidx.compose.material3.SliderState;
import androidx.compose.material3.SurfaceKt;
import androidx.compose.material3.TextKt;
import androidx.compose.material3.TextKt$$ExternalSyntheticLambda3;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.GapComposer$$ExternalSyntheticLambda0;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.NeverEqualPolicy;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.State;
import androidx.compose.runtime.StaticProvidableCompositionLocal;
import androidx.compose.runtime.Updater$$ExternalSyntheticLambda0;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.runtime.internal.Expect_jvmKt;
import androidx.compose.runtime.internal.PersistentCompositionLocalHashMap;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.BiasAlignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.ZIndexModifierKt;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import com.metrolist.music.MainActivity$$ExternalSyntheticLambda1;
import com.metrolist.music.constants.ArtistSongSortType;
import com.metrolist.music.constants.PlaylistSongSortType;
import com.metrolist.music.constants.SliderStyle;
import com.metrolist.music.constants.SongSortType;
import com.metrolist.music.db.entities.Song;
import com.metrolist.music.listentogether.ListenTogetherManager;
import com.metrolist.music.listentogether.proto.Listentogether;
import com.metrolist.music.playback.PlayerConnection;
import com.metrolist.music.playback.queues.YouTubeQueue;
import com.metrolist.music.ui.component.GlassComponentsKt;
import com.metrolist.music.ui.component.Material3MenuItemData;
import com.metrolist.music.ui.component.MenuKt;
import com.metrolist.music.ui.component.SortHeaderKt$SortHeader$1$2$1;
import com.metrolist.music.ui.component.SortHeaderKt$SortHeader$1$5;
import com.metrolist.music.ui.player.PlayerKt$$ExternalSyntheticLambda84;
import com.metrolist.music.ui.screens.ListenTogetherScreenKt;
import com.metrolist.music.ui.screens.equalizer.EqScreenKt;
import com.metrolist.music.ui.screens.library.LibraryMixScreenKt$LibraryMixScreen$lambda$24$2$$inlined$SortHeader$1;
import com.metrolist.music.ui.screens.settings.AiSettingsKt;
import com.metrolist.music.ui.theme.UiStyleKt;
import com.metrolist.music.utils.InnerTubeXPlayer$$ExternalSyntheticLambda3;
import com.yalantis.ucrop.R;
import com.yalantis.ucrop.view.CropImageView;
import io.ktor.http.MimesKt$$ExternalSyntheticLambda0;
import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.builders.ListBuilder;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.ClosedFloatRange;
import kotlin.text.HexFormatKt;
import kotlin.uuid.UuidKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class SongMenuKt$$ExternalSyntheticLambda32 implements Function3 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ Object f$0;
    public final /* synthetic */ Object f$1;
    public final /* synthetic */ Object f$2;
    public final /* synthetic */ boolean f$3;
    public final /* synthetic */ Object f$4;

    public /* synthetic */ SongMenuKt$$ExternalSyntheticLambda32(MutableState mutableState, boolean z, ListenTogetherManager listenTogetherManager, Function0 function0, State state) {
        this.$r8$classId = (byte) 1;
        this.f$1 = mutableState;
        this.f$3 = z;
        this.f$0 = listenTogetherManager;
        this.f$2 = function0;
        this.f$4 = state;
    }

    private final Object invoke$com$metrolist$music$ui$screens$artist$ArtistSongsScreenKt$$ExternalSyntheticLambda6(Object obj, Object obj2, Object obj3) {
        Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda0;
        Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda1;
        float f;
        Modifier modifier;
        Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda2;
        int i;
        byte b;
        ArtistSongSortType artistSongSortType = (ArtistSongSortType) this.f$0;
        Function1 function1 = (Function1) this.f$1;
        MimesKt$$ExternalSyntheticLambda0 mimesKt$$ExternalSyntheticLambda0 = (MimesKt$$ExternalSyntheticLambda0) this.f$2;
        State state = (State) this.f$4;
        Composer composer = (Composer) obj2;
        int iIntValue = ((Integer) obj3).intValue();
        ((LazyItemScopeImpl) obj).getClass();
        GapComposer gapComposer = (GapComposer) composer;
        if (gapComposer.shouldExecute(iIntValue & 1, (iIntValue & 17) != 16)) {
            BiasAlignment.Vertical vertical = Alignment.Companion.CenterVertically;
            Modifier modifierM137paddingVpY3zN4$default = Modifier.Companion.$$INSTANCE;
            Modifier modifierM137paddingVpY3zN4$default2 = OffsetKt.m137paddingVpY3zN4$default(modifierM137paddingVpY3zN4$default, 16.0f, CropImageView.DEFAULT_ASPECT_RATIO, 2);
            Arrangement$End$1 arrangement$End$1 = OffsetKt.Start;
            RowMeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(arrangement$End$1, vertical, gapComposer, 48);
            int iHashCode = Long.hashCode(gapComposer.compositeKeyHashCode);
            PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope = gapComposer.currentCompositionLocalScope();
            Modifier modifierMaterializeModifier = ZIndexModifierKt.materializeModifier(gapComposer, modifierM137paddingVpY3zN4$default2);
            ComposeUiNode.Companion.getClass();
            gapComposer.startReusableNode();
            boolean z = gapComposer.inserting;
            TextKt$$ExternalSyntheticLambda3 textKt$$ExternalSyntheticLambda3 = LayoutNode.Constructor;
            if (z) {
                gapComposer.createNode(textKt$$ExternalSyntheticLambda3);
            } else {
                gapComposer.useNode();
            }
            Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda3 = ComposeUiNode.Companion.SetMeasurePolicy;
            Stack.m390setimpl(gapComposer, rowMeasurePolicy, updater$$ExternalSyntheticLambda3);
            Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda4 = ComposeUiNode.Companion.SetResolvedCompositionLocals;
            Stack.m390setimpl(gapComposer, persistentCompositionLocalHashMapCurrentCompositionLocalScope, updater$$ExternalSyntheticLambda4);
            Integer numValueOf = Integer.valueOf(iHashCode);
            Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda5 = ComposeUiNode.Companion.SetCompositeKeyHash;
            Stack.m390setimpl(gapComposer, numValueOf, updater$$ExternalSyntheticLambda5);
            Stack.m389reconcileimpl(gapComposer);
            Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda6 = ComposeUiNode.Companion.SetModifier;
            Stack.m390setimpl(gapComposer, modifierMaterializeModifier, updater$$ExternalSyntheticLambda6);
            Object objRememberedValue = gapComposer.rememberedValue();
            NeverEqualPolicy neverEqualPolicy = Composer.Companion.Empty;
            if (objRememberedValue == neverEqualPolicy) {
                objRememberedValue = Stack.mutableStateOf$default(Boolean.FALSE);
                gapComposer.updateRememberedValue(objRememberedValue);
            }
            MutableState mutableState = (MutableState) objRememberedValue;
            Modifier modifierM137paddingVpY3zN4$default3 = OffsetKt.m137paddingVpY3zN4$default(modifierM137paddingVpY3zN4$default, CropImageView.DEFAULT_ASPECT_RATIO, 8.0f, 1);
            if (UiStyleKt.isGlassStyle(gapComposer)) {
                gapComposer.startReplaceGroup(-2138758585);
                modifier = modifierM137paddingVpY3zN4$default;
                updater$$ExternalSyntheticLambda0 = updater$$ExternalSyntheticLambda5;
                updater$$ExternalSyntheticLambda2 = updater$$ExternalSyntheticLambda4;
                updater$$ExternalSyntheticLambda1 = updater$$ExternalSyntheticLambda3;
                f = 8.0f;
                modifierM137paddingVpY3zN4$default = OffsetKt.m137paddingVpY3zN4$default(GlassComponentsKt.glass(modifier, RoundedCornerShapeKt.RoundedCornerShape(50), false, gapComposer, 6, 2), 8.0f, CropImageView.DEFAULT_ASPECT_RATIO, 2);
                gapComposer.end(false);
            } else {
                updater$$ExternalSyntheticLambda0 = updater$$ExternalSyntheticLambda5;
                updater$$ExternalSyntheticLambda1 = updater$$ExternalSyntheticLambda3;
                f = 8.0f;
                modifier = modifierM137paddingVpY3zN4$default;
                updater$$ExternalSyntheticLambda2 = updater$$ExternalSyntheticLambda4;
                gapComposer.startReplaceGroup(-2138602190);
                gapComposer.end(false);
            }
            Modifier modifierThen = modifierM137paddingVpY3zN4$default3.then(modifierM137paddingVpY3zN4$default);
            RowMeasurePolicy rowMeasurePolicy2 = RowKt.rowMeasurePolicy(arrangement$End$1, vertical, gapComposer, 48);
            int iHashCode2 = Long.hashCode(gapComposer.compositeKeyHashCode);
            PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope2 = gapComposer.currentCompositionLocalScope();
            Modifier modifierMaterializeModifier2 = ZIndexModifierKt.materializeModifier(gapComposer, modifierThen);
            gapComposer.startReusableNode();
            if (gapComposer.inserting) {
                gapComposer.createNode(textKt$$ExternalSyntheticLambda3);
            } else {
                gapComposer.useNode();
            }
            Stack.m390setimpl(gapComposer, rowMeasurePolicy2, updater$$ExternalSyntheticLambda1);
            Stack.m390setimpl(gapComposer, persistentCompositionLocalHashMapCurrentCompositionLocalScope2, updater$$ExternalSyntheticLambda2);
            IntIntPair$$ExternalSyntheticOutline0.m(iHashCode2, gapComposer, updater$$ExternalSyntheticLambda0, gapComposer);
            Stack.m390setimpl(gapComposer, modifierMaterializeModifier2, updater$$ExternalSyntheticLambda6);
            int iOrdinal = artistSongSortType.ordinal();
            if (iOrdinal == 0) {
                i = R.string.sort_by_create_date;
            } else if (iOrdinal == 1) {
                i = R.string.sort_by_name;
            } else {
                if (iOrdinal != 2) {
                    PathKt$$ExternalSyntheticBUOutline0.m$1();
                    return null;
                }
                i = R.string.sort_by_play_time;
            }
            String upperCase = MathKt.stringResource(i, gapComposer).toUpperCase(Locale.ROOT);
            upperCase.getClass();
            StaticProvidableCompositionLocal staticProvidableCompositionLocal = MaterialThemeKt._localMaterialTheme;
            long j = ((MaterialTheme$Values) gapComposer.consume(staticProvidableCompositionLocal)).colorScheme.primary;
            TextStyle textStyle = ((MaterialTheme$Values) gapComposer.consume(staticProvidableCompositionLocal)).typography.labelMedium;
            FontWeight fontWeight = UiStyleKt.isGlassStyle(gapComposer) ? FontWeight.Bold : null;
            Object objRememberedValue2 = gapComposer.rememberedValue();
            if (objRememberedValue2 == neverEqualPolicy) {
                objRememberedValue2 = IntIntPair$$ExternalSyntheticOutline0.m(gapComposer);
            }
            MutableInteractionSourceImpl mutableInteractionSourceImpl = (MutableInteractionSourceImpl) objRememberedValue2;
            RippleNodeFactory rippleNodeFactoryM313rippleOu1YvPQ$default = RippleKt.m313rippleOu1YvPQ$default(false, CropImageView.DEFAULT_ASPECT_RATIO, 0L, null, 254);
            Object objRememberedValue3 = gapComposer.rememberedValue();
            if (objRememberedValue3 == neverEqualPolicy) {
                objRememberedValue3 = new SortHeaderKt$SortHeader$1$2$1(mutableState, (byte) 0);
                gapComposer.updateRememberedValue(objRememberedValue3);
            }
            Modifier modifier2 = modifier;
            TextKt.m352TextNvy7gAk(upperCase, OffsetKt.m136paddingVpY3zN4(ImageKt.m45clickableO2vRcR0$default(modifier2, mutableInteractionSourceImpl, rippleNodeFactoryM313rippleOu1YvPQ$default, false, null, (Function0) objRememberedValue3, 28), 4.0f, f), j, 0L, null, fontWeight, null, 0L, null, 0L, 0, false, 0, 0, textStyle, gapComposer, 0, 0, 131000);
            boolean zM1492SortHeader$lambda1 = MenuKt.m1492SortHeader$lambda1(mutableState);
            Object objRememberedValue4 = gapComposer.rememberedValue();
            if (objRememberedValue4 == neverEqualPolicy) {
                b = 1;
                objRememberedValue4 = new SortHeaderKt$SortHeader$1$2$1(mutableState, b);
                gapComposer.updateRememberedValue(objRememberedValue4);
            } else {
                b = 1;
            }
            CardKt.m256DropdownMenuIlH_yew(zM1492SortHeader$lambda1, (Function0) objRememberedValue4, SizeKt.m157widthInVpY3zN4$default(modifier2, 172.0f, CropImageView.DEFAULT_ASPECT_RATIO, 2), 0L, null, null, null, 0L, CropImageView.DEFAULT_ASPECT_RATIO, Expect_jvmKt.rememberComposableLambda(-1229424361, new LibraryMixScreenKt$LibraryMixScreen$lambda$24$2$$inlined$SortHeader$1(b, mutableState, artistSongSortType, function1), gapComposer), gapComposer, 432, 2040);
            GapComposer gapComposer2 = gapComposer;
            if (artistSongSortType != PlaylistSongSortType.CUSTOM) {
                gapComposer2.startReplaceGroup(-413182842);
                boolean z2 = this.f$3;
                MenuKt.m1491ResizableIconButtonFU0evQE(z2 ? R.drawable.arrow_downward : R.drawable.arrow_upward, OffsetKt.m135padding3ABfNKs(SizeKt.m151size3ABfNKs(modifier2, 32.0f), f), ((MaterialTheme$Values) gapComposer2.consume(staticProvidableCompositionLocal)).colorScheme.primary, false, new SortHeaderKt$SortHeader$1$5(mimesKt$$ExternalSyntheticLambda0, z2), gapComposer2, 48);
                gapComposer2 = gapComposer2;
                gapComposer2.end(false);
            } else {
                gapComposer2.startReplaceGroup(-412803898);
                gapComposer2.end(false);
            }
            gapComposer2.end(true);
            OffsetKt.Spacer(gapComposer2, new LayoutWeightElement(1.0f, true));
            GapComposer gapComposer3 = gapComposer2;
            TextKt.m352TextNvy7gAk(MathKt.pluralStringResource(R.plurals.n_song, ((List) state.getValue()).size(), new Object[]{Integer.valueOf(((List) state.getValue()).size())}, gapComposer2), null, ((MaterialTheme$Values) gapComposer2.consume(staticProvidableCompositionLocal)).colorScheme.secondary, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, ((MaterialTheme$Values) gapComposer2.consume(staticProvidableCompositionLocal)).typography.titleSmall, gapComposer3, 0, 0, 131066);
            gapComposer3.end(true);
        } else {
            gapComposer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    private final Object invoke$com$metrolist$music$ui$screens$library$LibraryPodcastsScreenKt$$ExternalSyntheticLambda15(Object obj, Object obj2, Object obj3) {
        Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda0;
        Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda1;
        float f;
        Modifier modifier;
        Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda2;
        int i;
        SongSortType songSortType = (SongSortType) this.f$0;
        Function1 function1 = (Function1) this.f$1;
        MimesKt$$ExternalSyntheticLambda0 mimesKt$$ExternalSyntheticLambda0 = (MimesKt$$ExternalSyntheticLambda0) this.f$2;
        State state = (State) this.f$4;
        Composer composer = (Composer) obj2;
        int iIntValue = ((Integer) obj3).intValue();
        ((LazyItemScopeImpl) obj).getClass();
        GapComposer gapComposer = (GapComposer) composer;
        if (gapComposer.shouldExecute(iIntValue & 1, (iIntValue & 17) != 16)) {
            BiasAlignment.Vertical vertical = Alignment.Companion.CenterVertically;
            Modifier modifierM137paddingVpY3zN4$default = Modifier.Companion.$$INSTANCE;
            Modifier modifierM137paddingVpY3zN4$default2 = OffsetKt.m137paddingVpY3zN4$default(modifierM137paddingVpY3zN4$default, 16.0f, CropImageView.DEFAULT_ASPECT_RATIO, 2);
            Arrangement$End$1 arrangement$End$1 = OffsetKt.Start;
            RowMeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(arrangement$End$1, vertical, gapComposer, 48);
            int iHashCode = Long.hashCode(gapComposer.compositeKeyHashCode);
            PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope = gapComposer.currentCompositionLocalScope();
            Modifier modifierMaterializeModifier = ZIndexModifierKt.materializeModifier(gapComposer, modifierM137paddingVpY3zN4$default2);
            ComposeUiNode.Companion.getClass();
            gapComposer.startReusableNode();
            boolean z = gapComposer.inserting;
            TextKt$$ExternalSyntheticLambda3 textKt$$ExternalSyntheticLambda3 = LayoutNode.Constructor;
            if (z) {
                gapComposer.createNode(textKt$$ExternalSyntheticLambda3);
            } else {
                gapComposer.useNode();
            }
            Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda3 = ComposeUiNode.Companion.SetMeasurePolicy;
            Stack.m390setimpl(gapComposer, rowMeasurePolicy, updater$$ExternalSyntheticLambda3);
            Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda4 = ComposeUiNode.Companion.SetResolvedCompositionLocals;
            Stack.m390setimpl(gapComposer, persistentCompositionLocalHashMapCurrentCompositionLocalScope, updater$$ExternalSyntheticLambda4);
            Integer numValueOf = Integer.valueOf(iHashCode);
            Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda5 = ComposeUiNode.Companion.SetCompositeKeyHash;
            Stack.m390setimpl(gapComposer, numValueOf, updater$$ExternalSyntheticLambda5);
            Stack.m389reconcileimpl(gapComposer);
            Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda6 = ComposeUiNode.Companion.SetModifier;
            Stack.m390setimpl(gapComposer, modifierMaterializeModifier, updater$$ExternalSyntheticLambda6);
            Object objRememberedValue = gapComposer.rememberedValue();
            NeverEqualPolicy neverEqualPolicy = Composer.Companion.Empty;
            if (objRememberedValue == neverEqualPolicy) {
                objRememberedValue = Stack.mutableStateOf$default(Boolean.FALSE);
                gapComposer.updateRememberedValue(objRememberedValue);
            }
            MutableState mutableState = (MutableState) objRememberedValue;
            Modifier modifierM137paddingVpY3zN4$default3 = OffsetKt.m137paddingVpY3zN4$default(modifierM137paddingVpY3zN4$default, CropImageView.DEFAULT_ASPECT_RATIO, 8.0f, 1);
            if (UiStyleKt.isGlassStyle(gapComposer)) {
                gapComposer.startReplaceGroup(-2138758585);
                modifier = modifierM137paddingVpY3zN4$default;
                updater$$ExternalSyntheticLambda0 = updater$$ExternalSyntheticLambda5;
                updater$$ExternalSyntheticLambda2 = updater$$ExternalSyntheticLambda4;
                updater$$ExternalSyntheticLambda1 = updater$$ExternalSyntheticLambda3;
                f = 8.0f;
                modifierM137paddingVpY3zN4$default = OffsetKt.m137paddingVpY3zN4$default(GlassComponentsKt.glass(modifier, RoundedCornerShapeKt.RoundedCornerShape(50), false, gapComposer, 6, 2), 8.0f, CropImageView.DEFAULT_ASPECT_RATIO, 2);
                gapComposer.end(false);
            } else {
                updater$$ExternalSyntheticLambda0 = updater$$ExternalSyntheticLambda5;
                updater$$ExternalSyntheticLambda1 = updater$$ExternalSyntheticLambda3;
                f = 8.0f;
                modifier = modifierM137paddingVpY3zN4$default;
                updater$$ExternalSyntheticLambda2 = updater$$ExternalSyntheticLambda4;
                gapComposer.startReplaceGroup(-2138602190);
                gapComposer.end(false);
            }
            Modifier modifierThen = modifierM137paddingVpY3zN4$default3.then(modifierM137paddingVpY3zN4$default);
            RowMeasurePolicy rowMeasurePolicy2 = RowKt.rowMeasurePolicy(arrangement$End$1, vertical, gapComposer, 48);
            int iHashCode2 = Long.hashCode(gapComposer.compositeKeyHashCode);
            PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope2 = gapComposer.currentCompositionLocalScope();
            Modifier modifierMaterializeModifier2 = ZIndexModifierKt.materializeModifier(gapComposer, modifierThen);
            gapComposer.startReusableNode();
            if (gapComposer.inserting) {
                gapComposer.createNode(textKt$$ExternalSyntheticLambda3);
            } else {
                gapComposer.useNode();
            }
            Stack.m390setimpl(gapComposer, rowMeasurePolicy2, updater$$ExternalSyntheticLambda1);
            Stack.m390setimpl(gapComposer, persistentCompositionLocalHashMapCurrentCompositionLocalScope2, updater$$ExternalSyntheticLambda2);
            IntIntPair$$ExternalSyntheticOutline0.m(iHashCode2, gapComposer, updater$$ExternalSyntheticLambda0, gapComposer);
            Stack.m390setimpl(gapComposer, modifierMaterializeModifier2, updater$$ExternalSyntheticLambda6);
            int iOrdinal = songSortType.ordinal();
            if (iOrdinal == 0) {
                i = R.string.sort_by_create_date;
            } else if (iOrdinal == 1) {
                i = R.string.sort_by_name;
            } else if (iOrdinal == 2) {
                i = R.string.sort_by_artist;
            } else {
                if (iOrdinal != 3) {
                    PathKt$$ExternalSyntheticBUOutline0.m$1();
                    return null;
                }
                i = R.string.sort_by_play_time;
            }
            String upperCase = MathKt.stringResource(i, gapComposer).toUpperCase(Locale.ROOT);
            upperCase.getClass();
            StaticProvidableCompositionLocal staticProvidableCompositionLocal = MaterialThemeKt._localMaterialTheme;
            long j = ((MaterialTheme$Values) gapComposer.consume(staticProvidableCompositionLocal)).colorScheme.primary;
            TextStyle textStyle = ((MaterialTheme$Values) gapComposer.consume(staticProvidableCompositionLocal)).typography.labelMedium;
            FontWeight fontWeight = UiStyleKt.isGlassStyle(gapComposer) ? FontWeight.Bold : null;
            Object objRememberedValue2 = gapComposer.rememberedValue();
            if (objRememberedValue2 == neverEqualPolicy) {
                objRememberedValue2 = IntIntPair$$ExternalSyntheticOutline0.m(gapComposer);
            }
            MutableInteractionSourceImpl mutableInteractionSourceImpl = (MutableInteractionSourceImpl) objRememberedValue2;
            RippleNodeFactory rippleNodeFactoryM313rippleOu1YvPQ$default = RippleKt.m313rippleOu1YvPQ$default(false, CropImageView.DEFAULT_ASPECT_RATIO, 0L, null, 254);
            Object objRememberedValue3 = gapComposer.rememberedValue();
            if (objRememberedValue3 == neverEqualPolicy) {
                objRememberedValue3 = new SortHeaderKt$SortHeader$1$2$1(mutableState, (byte) 0);
                gapComposer.updateRememberedValue(objRememberedValue3);
            }
            Modifier modifier2 = modifier;
            TextKt.m352TextNvy7gAk(upperCase, OffsetKt.m136paddingVpY3zN4(ImageKt.m45clickableO2vRcR0$default(modifier2, mutableInteractionSourceImpl, rippleNodeFactoryM313rippleOu1YvPQ$default, false, null, (Function0) objRememberedValue3, 28), 4.0f, f), j, 0L, null, fontWeight, null, 0L, null, 0L, 0, false, 0, 0, textStyle, gapComposer, 0, 0, 131000);
            boolean zM1492SortHeader$lambda1 = MenuKt.m1492SortHeader$lambda1(mutableState);
            Object objRememberedValue4 = gapComposer.rememberedValue();
            if (objRememberedValue4 == neverEqualPolicy) {
                objRememberedValue4 = new SortHeaderKt$SortHeader$1$2$1(mutableState, (byte) 1);
                gapComposer.updateRememberedValue(objRememberedValue4);
            }
            CardKt.m256DropdownMenuIlH_yew(zM1492SortHeader$lambda1, (Function0) objRememberedValue4, SizeKt.m157widthInVpY3zN4$default(modifier2, 172.0f, CropImageView.DEFAULT_ASPECT_RATIO, 2), 0L, null, null, null, 0L, CropImageView.DEFAULT_ASPECT_RATIO, Expect_jvmKt.rememberComposableLambda(-1229424361, new LibraryMixScreenKt$LibraryMixScreen$lambda$24$2$$inlined$SortHeader$1((byte) 5, mutableState, songSortType, function1), gapComposer), gapComposer, 432, 2040);
            GapComposer gapComposer2 = gapComposer;
            if (songSortType != PlaylistSongSortType.CUSTOM) {
                gapComposer2.startReplaceGroup(-413182842);
                boolean z2 = this.f$3;
                MenuKt.m1491ResizableIconButtonFU0evQE(z2 ? R.drawable.arrow_downward : R.drawable.arrow_upward, OffsetKt.m135padding3ABfNKs(SizeKt.m151size3ABfNKs(modifier2, 32.0f), f), ((MaterialTheme$Values) gapComposer2.consume(staticProvidableCompositionLocal)).colorScheme.primary, false, new SortHeaderKt$SortHeader$1$5(mimesKt$$ExternalSyntheticLambda0, z2), gapComposer2, 48);
                gapComposer2 = gapComposer2;
                gapComposer2.end(false);
            } else {
                gapComposer2.startReplaceGroup(-412803898);
                gapComposer2.end(false);
            }
            gapComposer2.end(true);
            OffsetKt.Spacer(gapComposer2, new LayoutWeightElement(1.0f, true));
            GapComposer gapComposer3 = gapComposer2;
            TextKt.m352TextNvy7gAk(MathKt.pluralStringResource(R.plurals.n_episode, ((List) state.getValue()).size(), new Object[]{Integer.valueOf(((List) state.getValue()).size())}, gapComposer2), null, ((MaterialTheme$Values) gapComposer2.consume(staticProvidableCompositionLocal)).colorScheme.onSurfaceVariant, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, ((MaterialTheme$Values) gapComposer2.consume(staticProvidableCompositionLocal)).typography.titleSmall, gapComposer3, 0, 0, 131066);
            gapComposer3.end(true);
        } else {
            gapComposer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:158:0x08f9  */
    /* JADX WARN: Code duplicated, block: B:161:0x0932  */
    /* JADX WARN: Code duplicated, block: B:162:0x0936  */
    /* JADX WARN: Code duplicated, block: B:165:0x0961  */
    /* JADX WARN: Code duplicated, block: B:166:0x0965  */
    /* JADX WARN: Code duplicated, block: B:169:0x0986  */
    /* JADX WARN: Code duplicated, block: B:171:0x0999  */
    /* JADX WARN: Code duplicated, block: B:173:0x09aa  */
    /* JADX WARN: Code duplicated, block: B:174:0x09ba  */
    /* JADX WARN: Code duplicated, block: B:182:0x0a0f  */
    /* JADX WARN: Code duplicated, block: B:184:0x0a33  */
    /* JADX WARN: Code duplicated, block: B:186:0x0a46  */
    /* JADX WARN: Code duplicated, block: B:190:0x0a9e  */
    /* JADX WARN: Code duplicated, block: B:192:0x0aa3  */
    /* JADX WARN: Code duplicated, block: B:195:0x0aac  */
    /* JADX WARN: Code duplicated, block: B:197:0x0abf  */
    /* JADX WARN: Code duplicated, block: B:200:0x0b03  */
    /* JADX WARN: Code duplicated, block: B:202:0x0b4c  */
    /* JADX WARN: Code duplicated, block: B:204:0x0b5c  */
    /* JADX WARN: Code duplicated, block: B:205:0x0ba4  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r15v12 */
    /* JADX WARN: Type inference failed for: r15v13, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r15v27 */
    /* JADX WARN: Type inference failed for: r15v28, types: [boolean, byte] */
    /* JADX WARN: Type inference failed for: r15v29 */
    /* JADX WARN: Type inference failed for: r15v67 */
    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        Material3MenuItemData material3MenuItemData;
        Material3MenuItemData material3MenuItemData2;
        Material3MenuItemData material3MenuItemData3;
        int i;
        Material3MenuItemData material3MenuItemData4;
        boolean z;
        Object obj4;
        ?? r15;
        boolean z2;
        Object obj5;
        ArrayList arrayList;
        boolean zChanged;
        Object obj6;
        long j;
        MutableState mutableState;
        ?? r16;
        long j2;
        FontWeight fontWeight;
        long j3;
        String str;
        boolean z3;
        long jColor;
        long j4;
        boolean z4;
        long j5;
        long j6;
        long j7;
        byte b = this.$r8$classId;
        Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda0 = ComposeUiNode.Companion.SetModifier;
        Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda1 = ComposeUiNode.Companion.SetCompositeKeyHash;
        Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda2 = ComposeUiNode.Companion.SetResolvedCompositionLocals;
        Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda3 = ComposeUiNode.Companion.SetMeasurePolicy;
        TextKt$$ExternalSyntheticLambda3 textKt$$ExternalSyntheticLambda3 = LayoutNode.Constructor;
        boolean z5 = this.f$3;
        NeverEqualPolicy neverEqualPolicy = Composer.Companion.Empty;
        Unit unit = Unit.INSTANCE;
        Object obj7 = this.f$4;
        Object obj8 = this.f$2;
        Object obj9 = this.f$1;
        Object obj10 = this.f$0;
        switch (b) {
            case 0:
                ListenTogetherManager listenTogetherManager = (ListenTogetherManager) obj10;
                final Song song = (Song) obj9;
                final Function0 function0 = (Function0) obj8;
                final PlayerConnection playerConnection = (PlayerConnection) obj7;
                Composer composer = (Composer) obj2;
                int iIntValue = ((Integer) obj3).intValue();
                ((LazyItemScopeImpl) obj).getClass();
                GapComposer gapComposer = (GapComposer) composer;
                if (gapComposer.shouldExecute(iIntValue & 1, (iIntValue & 17) != 16)) {
                    if (listenTogetherManager == null || !listenTogetherManager.client.isInRoom() || listenTogetherManager.isHost()) {
                        gapComposer.startReplaceGroup(-1725316313);
                        gapComposer.end(false);
                        material3MenuItemData = null;
                    } else {
                        gapComposer.startReplaceGroup(-1726752171);
                        ComposableLambdaImpl composableLambdaImpl = AlbumMenuKt.lambda$1068111443;
                        ComposableLambdaImpl composableLambdaImpl2 = AlbumMenuKt.lambda$1170588436;
                        boolean zChanged2 = gapComposer.changed(song) | gapComposer.changedInstance(listenTogetherManager) | gapComposer.changed(function0);
                        Object objRememberedValue = gapComposer.rememberedValue();
                        if (zChanged2 || objRememberedValue == neverEqualPolicy) {
                            objRememberedValue = new GapComposer$$ExternalSyntheticLambda0(song, listenTogetherManager, function0, (byte) 25);
                            gapComposer.updateRememberedValue(objRememberedValue);
                        }
                        Material3MenuItemData material3MenuItemData5 = new Material3MenuItemData(composableLambdaImpl, composableLambdaImpl2, null, (Function0) objRememberedValue, null, null, 52);
                        gapComposer.end(false);
                        material3MenuItemData = material3MenuItemData5;
                    }
                    if (z5) {
                        gapComposer.startReplaceGroup(-1724366969);
                        gapComposer.end(false);
                        material3MenuItemData2 = null;
                    } else {
                        gapComposer.startReplaceGroup(-1725192592);
                        ComposableLambdaImpl composableLambdaImpl3 = AlbumMenuKt.f248lambda$678906348;
                        ComposableLambdaImpl composableLambdaImpl4 = AlbumMenuKt.f235lambda$576429355;
                        ComposableLambdaImpl composableLambdaImpl5 = AlbumMenuKt.f210lambda$473952362;
                        boolean zChanged3 = gapComposer.changed(function0) | gapComposer.changedInstance(playerConnection) | gapComposer.changed(song);
                        Object objRememberedValue2 = gapComposer.rememberedValue();
                        if (zChanged3 || objRememberedValue2 == neverEqualPolicy) {
                            z = false;
                            final boolean z6 = false ? 1 : 0;
                            objRememberedValue2 = new Function0() { // from class: com.metrolist.music.ui.menu.SongMenuKt$$ExternalSyntheticLambda56
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() throws Exception {
                                    byte b2 = z6;
                                    Unit unit2 = Unit.INSTANCE;
                                    Song song2 = song;
                                    PlayerConnection playerConnection2 = playerConnection;
                                    Function0 function1 = function0;
                                    switch (b2) {
                                        case 0:
                                            function1.invoke();
                                            playerConnection2.playQueue(YouTubeQueue.INSTANCE.radio(HexFormatKt.toMediaMetadata(song2)));
                                            break;
                                        case 1:
                                            function1.invoke();
                                            playerConnection2.playNext(CollectionsKt__IterablesKt.listOf(UuidKt.toMediaItem(HexFormatKt.toMediaMetadata(song2))));
                                            break;
                                        default:
                                            function1.invoke();
                                            playerConnection2.addToQueue(CollectionsKt__IterablesKt.listOf(UuidKt.toMediaItem(HexFormatKt.toMediaMetadata(song2))));
                                            break;
                                    }
                                    return unit2;
                                }
                            };
                            gapComposer.updateRememberedValue(objRememberedValue2);
                        } else {
                            z = false;
                        }
                        Material3MenuItemData material3MenuItemData6 = new Material3MenuItemData(composableLambdaImpl3, composableLambdaImpl4, composableLambdaImpl5, (Function0) objRememberedValue2, null, null, 48);
                        gapComposer.end(z);
                        material3MenuItemData2 = material3MenuItemData6;
                    }
                    if (z5) {
                        gapComposer.startReplaceGroup(-1723438457);
                        gapComposer.end(false);
                        material3MenuItemData3 = null;
                    } else {
                        gapComposer.startReplaceGroup(-1724243899);
                        ComposableLambdaImpl composableLambdaImpl6 = AlbumMenuKt.lambda$1869043157;
                        ComposableLambdaImpl composableLambdaImpl7 = AlbumMenuKt.lambda$1971520150;
                        ComposableLambdaImpl composableLambdaImpl8 = AlbumMenuKt.lambda$2073997143;
                        boolean zChanged4 = gapComposer.changed(function0) | gapComposer.changedInstance(playerConnection) | gapComposer.changed(song);
                        Object objRememberedValue3 = gapComposer.rememberedValue();
                        if (zChanged4 || objRememberedValue3 == neverEqualPolicy) {
                            final byte b2 = 1;
                            objRememberedValue3 = new Function0() { // from class: com.metrolist.music.ui.menu.SongMenuKt$$ExternalSyntheticLambda56
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() throws Exception {
                                    byte b3 = b2;
                                    Unit unit2 = Unit.INSTANCE;
                                    Song song2 = song;
                                    PlayerConnection playerConnection2 = playerConnection;
                                    Function0 function1 = function0;
                                    switch (b3) {
                                        case 0:
                                            function1.invoke();
                                            playerConnection2.playQueue(YouTubeQueue.INSTANCE.radio(HexFormatKt.toMediaMetadata(song2)));
                                            break;
                                        case 1:
                                            function1.invoke();
                                            playerConnection2.playNext(CollectionsKt__IterablesKt.listOf(UuidKt.toMediaItem(HexFormatKt.toMediaMetadata(song2))));
                                            break;
                                        default:
                                            function1.invoke();
                                            playerConnection2.addToQueue(CollectionsKt__IterablesKt.listOf(UuidKt.toMediaItem(HexFormatKt.toMediaMetadata(song2))));
                                            break;
                                    }
                                    return unit2;
                                }
                            };
                            gapComposer.updateRememberedValue(objRememberedValue3);
                        }
                        Material3MenuItemData material3MenuItemData7 = new Material3MenuItemData(composableLambdaImpl6, composableLambdaImpl7, composableLambdaImpl8, (Function0) objRememberedValue3, null, null, 48);
                        gapComposer.end(false);
                        material3MenuItemData3 = material3MenuItemData7;
                    }
                    if (z5) {
                        i = 0;
                        gapComposer.startReplaceGroup(-1722503993);
                        gapComposer.end(false);
                        material3MenuItemData4 = null;
                    } else {
                        gapComposer.startReplaceGroup(-1723315201);
                        ComposableLambdaImpl composableLambdaImpl9 = AlbumMenuKt.lambda$122025366;
                        ComposableLambdaImpl composableLambdaImpl10 = AlbumMenuKt.lambda$224502359;
                        ComposableLambdaImpl composableLambdaImpl11 = AlbumMenuKt.lambda$326979352;
                        boolean zChanged5 = gapComposer.changed(function0) | gapComposer.changedInstance(playerConnection) | gapComposer.changed(song);
                        Object objRememberedValue4 = gapComposer.rememberedValue();
                        if (zChanged5 || objRememberedValue4 == neverEqualPolicy) {
                            final byte b3 = 2;
                            objRememberedValue4 = new Function0() { // from class: com.metrolist.music.ui.menu.SongMenuKt$$ExternalSyntheticLambda56
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() throws Exception {
                                    byte b4 = b3;
                                    Unit unit2 = Unit.INSTANCE;
                                    Song song2 = song;
                                    PlayerConnection playerConnection2 = playerConnection;
                                    Function0 function1 = function0;
                                    switch (b4) {
                                        case 0:
                                            function1.invoke();
                                            playerConnection2.playQueue(YouTubeQueue.INSTANCE.radio(HexFormatKt.toMediaMetadata(song2)));
                                            break;
                                        case 1:
                                            function1.invoke();
                                            playerConnection2.playNext(CollectionsKt__IterablesKt.listOf(UuidKt.toMediaItem(HexFormatKt.toMediaMetadata(song2))));
                                            break;
                                        default:
                                            function1.invoke();
                                            playerConnection2.addToQueue(CollectionsKt__IterablesKt.listOf(UuidKt.toMediaItem(HexFormatKt.toMediaMetadata(song2))));
                                            break;
                                    }
                                    return unit2;
                                }
                            };
                            gapComposer.updateRememberedValue(objRememberedValue4);
                        }
                        Material3MenuItemData material3MenuItemData8 = new Material3MenuItemData(composableLambdaImpl9, composableLambdaImpl10, composableLambdaImpl11, (Function0) objRememberedValue4, null, null, 48);
                        i = 0;
                        gapComposer.end(false);
                        material3MenuItemData4 = material3MenuItemData8;
                    }
                    MenuKt.Material3MenuGroup(ArraysKt.filterNotNull(new Material3MenuItemData[]{material3MenuItemData, material3MenuItemData2, material3MenuItemData3, material3MenuItemData4}), gapComposer, i);
                } else {
                    gapComposer.skipToGroupEnd();
                }
                return unit;
            case 1:
                MutableState mutableState2 = (MutableState) obj9;
                ListenTogetherManager listenTogetherManager2 = (ListenTogetherManager) obj10;
                Function0 function1 = (Function0) obj8;
                State state = (State) obj7;
                Composer composer2 = (Composer) obj2;
                int iIntValue2 = ((Integer) obj3).intValue();
                ((LazyItemScopeImpl) obj).getClass();
                GapComposer gapComposer2 = (GapComposer) composer2;
                if (gapComposer2.shouldExecute(iIntValue2 & 1, (iIntValue2 & 17) != 16)) {
                    gapComposer2.startReplaceGroup(-847501270);
                    ListBuilder listBuilderCreateListBuilder = CollectionsKt__IterablesKt.createListBuilder();
                    ComposableLambdaImpl composableLambdaImplRememberComposableLambda = Expect_jvmKt.rememberComposableLambda(1087138029, new ListItemKt$$ExternalSyntheticLambda11(state, (byte) 10), gapComposer2);
                    ComposableLambdaImpl composableLambdaImpl12 = AlbumMenuKt.lambda$1905033390;
                    boolean zChanged6 = gapComposer2.changed(mutableState2);
                    Object objRememberedValue5 = gapComposer2.rememberedValue();
                    if (zChanged6 || objRememberedValue5 == neverEqualPolicy) {
                        obj4 = objRememberedValue5;
                        QueueMenuKt$$ExternalSyntheticLambda2 queueMenuKt$$ExternalSyntheticLambda2 = new QueueMenuKt$$ExternalSyntheticLambda2(mutableState2, (byte) 3);
                        gapComposer2.updateRememberedValue(queueMenuKt$$ExternalSyntheticLambda2);
                        obj4 = queueMenuKt$$ExternalSyntheticLambda2;
                    }
                    listBuilderCreateListBuilder.add(new Material3MenuItemData(composableLambdaImplRememberComposableLambda, composableLambdaImpl12, null, (Function0) obj4, null, null, 52));
                    if (z5) {
                        gapComposer2.startReplaceGroup(627501302);
                        ComposableLambdaImpl composableLambdaImpl13 = AlbumMenuKt.lambda$1290657010;
                        ComposableLambdaImpl composableLambdaImpl14 = AlbumMenuKt.lambda$1512568691;
                        boolean zChangedInstance = gapComposer2.changedInstance(listenTogetherManager2) | gapComposer2.changed(function1);
                        Object objRememberedValue6 = gapComposer2.rememberedValue();
                        if (zChangedInstance || objRememberedValue6 == neverEqualPolicy) {
                            z2 = false;
                            PlayerMenuKt$$ExternalSyntheticLambda90 playerMenuKt$$ExternalSyntheticLambda90 = new PlayerMenuKt$$ExternalSyntheticLambda90(listenTogetherManager2, function1, (byte) 0);
                            gapComposer2.updateRememberedValue(playerMenuKt$$ExternalSyntheticLambda90);
                            obj5 = playerMenuKt$$ExternalSyntheticLambda90;
                        } else {
                            z2 = false;
                            obj5 = objRememberedValue6;
                        }
                        listBuilderCreateListBuilder.add(new Material3MenuItemData(composableLambdaImpl13, composableLambdaImpl14, null, (Function0) obj5, null, null, 52));
                        gapComposer2.end(z2);
                        r15 = z2;
                    } else {
                        r15 = 0;
                        gapComposer2.startReplaceGroup(628365241);
                        gapComposer2.end(false);
                    }
                    ListBuilder listBuilderBuild = CollectionsKt__IterablesKt.build(listBuilderCreateListBuilder);
                    gapComposer2.end(r15);
                    MenuKt.Material3MenuGroup(listBuilderBuild, gapComposer2, r15);
                } else {
                    gapComposer2.skipToGroupEnd();
                }
                return unit;
            case 2:
                ArrayList arrayList2 = (ArrayList) obj10;
                MutableState mutableState3 = (MutableState) obj9;
                MutableState mutableState4 = (MutableState) obj8;
                MutableState mutableState5 = (MutableState) obj7;
                Composer composer3 = (Composer) obj2;
                int iIntValue3 = ((Integer) obj3).intValue();
                Arrangement$Top$1 arrangement$Top$1 = OffsetKt.Top;
                ((LazyItemScopeImpl) obj).getClass();
                GapComposer gapComposer3 = (GapComposer) composer3;
                if (gapComposer3.shouldExecute(iIntValue3 & 1, (iIntValue3 & 17) != 16)) {
                    Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
                    Modifier modifierM137paddingVpY3zN4$default = OffsetKt.m137paddingVpY3zN4$default(SizeKt.fillMaxWidth(companion, 1.0f), 16.0f, CropImageView.DEFAULT_ASPECT_RATIO, 2);
                    ColumnMeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(arrangement$Top$1, Alignment.Companion.Start, gapComposer3, 0);
                    MutableState mutableState6 = mutableState5;
                    int iHashCode = Long.hashCode(gapComposer3.compositeKeyHashCode);
                    PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope = gapComposer3.currentCompositionLocalScope();
                    Modifier modifierMaterializeModifier = ZIndexModifierKt.materializeModifier(gapComposer3, modifierM137paddingVpY3zN4$default);
                    ComposeUiNode.Companion.getClass();
                    gapComposer3.startReusableNode();
                    if (gapComposer3.inserting) {
                        gapComposer3.createNode(textKt$$ExternalSyntheticLambda3);
                    } else {
                        gapComposer3.useNode();
                    }
                    Stack.m390setimpl(gapComposer3, columnMeasurePolicy, updater$$ExternalSyntheticLambda3);
                    Stack.m390setimpl(gapComposer3, persistentCompositionLocalHashMapCurrentCompositionLocalScope, updater$$ExternalSyntheticLambda2);
                    IntIntPair$$ExternalSyntheticOutline0.m(iHashCode, gapComposer3, updater$$ExternalSyntheticLambda1, gapComposer3);
                    Stack.m390setimpl(gapComposer3, modifierMaterializeModifier, updater$$ExternalSyntheticLambda0);
                    String strStringResource = MathKt.stringResource(R.string.connected_users, new Object[]{Integer.valueOf(arrayList2.size())}, gapComposer3);
                    StaticProvidableCompositionLocal staticProvidableCompositionLocal = MaterialThemeKt._localMaterialTheme;
                    TextKt.m352TextNvy7gAk(strStringResource, OffsetKt.m139paddingqDBjuR0$default(companion, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, 12.0f, 7), ((MaterialTheme$Values) gapComposer3.consume(staticProvidableCompositionLocal)).colorScheme.primary, 0L, null, FontWeight.Bold, null, 0L, null, 0L, 0, false, 0, 0, ((MaterialTheme$Values) gapComposer3.consume(staticProvidableCompositionLocal)).typography.titleSmall, gapComposer3, 1572912, 0, 131000);
                    Modifier modifierFillMaxWidth = SizeKt.fillMaxWidth(companion, 1.0f);
                    RowMeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(new Arrangement$SpacedAligned(12.0f, true, new MarqueeSpacing$Companion$$ExternalSyntheticLambda0((byte) 5)), Alignment.Companion.Top, gapComposer3, 6);
                    int iHashCode2 = Long.hashCode(gapComposer3.compositeKeyHashCode);
                    PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope2 = gapComposer3.currentCompositionLocalScope();
                    Modifier modifierMaterializeModifier2 = ZIndexModifierKt.materializeModifier(gapComposer3, modifierFillMaxWidth);
                    gapComposer3.startReusableNode();
                    if (gapComposer3.inserting) {
                        gapComposer3.createNode(textKt$$ExternalSyntheticLambda3);
                    } else {
                        gapComposer3.useNode();
                    }
                    Stack.m390setimpl(gapComposer3, rowMeasurePolicy, updater$$ExternalSyntheticLambda3);
                    Stack.m390setimpl(gapComposer3, persistentCompositionLocalHashMapCurrentCompositionLocalScope2, updater$$ExternalSyntheticLambda2);
                    IntIntPair$$ExternalSyntheticOutline0.m(iHashCode2, gapComposer3, updater$$ExternalSyntheticLambda1, gapComposer3);
                    Stack.m390setimpl(gapComposer3, modifierMaterializeModifier2, updater$$ExternalSyntheticLambda0);
                    gapComposer3.startReplaceGroup(771484594);
                    int size = arrayList2.size();
                    int i2 = 0;
                    while (i2 < size) {
                        Object obj11 = arrayList2.get(i2);
                        int i3 = i2 + 1;
                        Listentogether.UserInfo userInfo = (Listentogether.UserInfo) obj11;
                        BiasAlignment.Horizontal horizontal = Alignment.Companion.CenterHorizontally;
                        Modifier modifierM155width3ABfNKs = SizeKt.m155width3ABfNKs(companion, 72.0f);
                        int i4 = size;
                        if (z5) {
                            arrayList = arrayList2;
                            boolean z7 = Intrinsics.areEqual(userInfo.getUserId(), (String) mutableState6.getValue()) ? false : true;
                            zChanged = gapComposer3.changed(mutableState3) | gapComposer3.changed(userInfo) | gapComposer3.changed(mutableState4);
                            Object objRememberedValue7 = gapComposer3.rememberedValue();
                            if (!zChanged || objRememberedValue7 == neverEqualPolicy) {
                                GapComposer$$ExternalSyntheticLambda0 gapComposer$$ExternalSyntheticLambda0 = new GapComposer$$ExternalSyntheticLambda0(userInfo, mutableState3, mutableState4, (byte) 19);
                                gapComposer3.updateRememberedValue(gapComposer$$ExternalSyntheticLambda0);
                                obj6 = gapComposer$$ExternalSyntheticLambda0;
                            } else {
                                obj6 = objRememberedValue7;
                            }
                            MutableState mutableState7 = mutableState4;
                            Modifier modifierM46clickableoSLSa3U$default = ImageKt.m46clickableoSLSa3U$default(modifierM155width3ABfNKs, z7, null, (Function0) obj6, 14);
                            ColumnMeasurePolicy columnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(arrangement$Top$1, horizontal, gapComposer3, 48);
                            int iHashCode3 = Long.hashCode(gapComposer3.compositeKeyHashCode);
                            PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope3 = gapComposer3.currentCompositionLocalScope();
                            Modifier modifierMaterializeModifier3 = ZIndexModifierKt.materializeModifier(gapComposer3, modifierM46clickableoSLSa3U$default);
                            ComposeUiNode.Companion.getClass();
                            gapComposer3.startReusableNode();
                            if (gapComposer3.inserting) {
                                gapComposer3.createNode(textKt$$ExternalSyntheticLambda3);
                            } else {
                                gapComposer3.useNode();
                            }
                            Stack.m390setimpl(gapComposer3, columnMeasurePolicy2, updater$$ExternalSyntheticLambda3);
                            Stack.m390setimpl(gapComposer3, persistentCompositionLocalHashMapCurrentCompositionLocalScope3, updater$$ExternalSyntheticLambda2);
                            IntIntPair$$ExternalSyntheticOutline0.m(iHashCode3, gapComposer3, updater$$ExternalSyntheticLambda1, gapComposer3);
                            Stack.m390setimpl(gapComposer3, modifierMaterializeModifier3, updater$$ExternalSyntheticLambda0);
                            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.Center, false);
                            int iHashCode4 = Long.hashCode(gapComposer3.compositeKeyHashCode);
                            PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope4 = gapComposer3.currentCompositionLocalScope();
                            Modifier modifierMaterializeModifier4 = ZIndexModifierKt.materializeModifier(gapComposer3, companion);
                            gapComposer3.startReusableNode();
                            if (gapComposer3.inserting) {
                                gapComposer3.createNode(textKt$$ExternalSyntheticLambda3);
                            } else {
                                gapComposer3.useNode();
                            }
                            Stack.m390setimpl(gapComposer3, measurePolicyMaybeCachedBoxMeasurePolicy, updater$$ExternalSyntheticLambda3);
                            Stack.m390setimpl(gapComposer3, persistentCompositionLocalHashMapCurrentCompositionLocalScope4, updater$$ExternalSyntheticLambda2);
                            IntIntPair$$ExternalSyntheticOutline0.m(iHashCode4, gapComposer3, updater$$ExternalSyntheticLambda1, gapComposer3);
                            Stack.m390setimpl(gapComposer3, modifierMaterializeModifier4, updater$$ExternalSyntheticLambda0);
                            Modifier modifierM151size3ABfNKs = SizeKt.m151size3ABfNKs(companion, 52.0f);
                            RoundedCornerShape roundedCornerShapeM185RoundedCornerShape0680j_4 = RoundedCornerShapeKt.m185RoundedCornerShape0680j_4(8.0f);
                            if (userInfo.getIsHost()) {
                                gapComposer3.startReplaceGroup(481544286);
                                j = CardKt.getColorScheme(gapComposer3).primary;
                                gapComposer3.end(false);
                            } else if (Intrinsics.areEqual(userInfo.getUserId(), (String) mutableState6.getValue())) {
                                gapComposer3.startReplaceGroup(481712988);
                                j = CardKt.getColorScheme(gapComposer3).secondary;
                                gapComposer3.end(false);
                            } else {
                                gapComposer3.startReplaceGroup(481856983);
                                j = CardKt.getColorScheme(gapComposer3).surfaceVariant;
                                gapComposer3.end(false);
                            }
                            mutableState = mutableState6;
                            SurfaceKt.m337SurfaceT9BRK9s(modifierM151size3ABfNKs, roundedCornerShapeM185RoundedCornerShape0680j_4, j, 0L, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, null, Expect_jvmKt.rememberComposableLambda(-667908330, new MainActivity$$ExternalSyntheticLambda1((Object) userInfo, (Object) mutableState, (byte) 18), gapComposer3), gapComposer3, 12582918, 120);
                            if (!userInfo.getIsHost() || Intrinsics.areEqual(userInfo.getUserId(), (String) mutableState.getValue())) {
                                gapComposer3.startReplaceGroup(483604329);
                                Modifier modifierM151size3ABfNKs2 = SizeKt.m151size3ABfNKs(OffsetKt.m133offsetVpY3zN4(BoxScopeInstance.INSTANCE.align(companion, Alignment.Companion.BottomEnd), 4.0f, 4.0f), 18.0f);
                                RoundedCornerShape roundedCornerShapeM185RoundedCornerShape0680j_5 = RoundedCornerShapeKt.m185RoundedCornerShape0680j_4(8.0f);
                                if (userInfo.getIsHost()) {
                                    gapComposer3.startReplaceGroup(1539637986);
                                    j2 = CardKt.getColorScheme(gapComposer3).primary;
                                    r16 = 0;
                                } else {
                                    r16 = 0;
                                    gapComposer3.startReplaceGroup(1539639236);
                                    j2 = CardKt.getColorScheme(gapComposer3).secondary;
                                }
                                gapComposer3.end(r16);
                                SurfaceKt.m337SurfaceT9BRK9s(modifierM151size3ABfNKs2, roundedCornerShapeM185RoundedCornerShape0680j_5, j2, 0L, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, null, Expect_jvmKt.rememberComposableLambda(293920817, new PlayerMenuKt$$ExternalSyntheticLambda100(userInfo, r16), gapComposer3), gapComposer3, 12582912, 120);
                                gapComposer3.end(r16);
                            } else {
                                gapComposer3.startReplaceGroup(485355271);
                                gapComposer3.end(false);
                            }
                            gapComposer3.end(true);
                            OffsetKt.Spacer(gapComposer3, SizeKt.m145height3ABfNKs(companion, 6.0f));
                            String username = userInfo.getUsername();
                            username.getClass();
                            TextStyle textStyle = CardKt.getTypography(gapComposer3).labelMedium;
                            if (Intrinsics.areEqual(userInfo.getUserId(), (String) mutableState.getValue())) {
                                fontWeight = FontWeight.Bold;
                            } else {
                                fontWeight = FontWeight.Medium;
                            }
                            FontWeight fontWeight2 = fontWeight;
                            if (userInfo.getIsHost()) {
                                gapComposer3.startReplaceGroup(-1551437780);
                                j3 = CardKt.getColorScheme(gapComposer3).primary;
                                gapComposer3.end(false);
                            } else {
                                gapComposer3.startReplaceGroup(-1551303798);
                                j3 = CardKt.getColorScheme(gapComposer3).onSurface;
                                gapComposer3.end(false);
                            }
                            TextKt.m352TextNvy7gAk(username, null, j3, 0L, null, fontWeight2, null, 0L, new TextAlign(3), 0L, 2, false, 1, 0, textStyle, gapComposer3, 0, 24960, 109498);
                            if (userInfo.getIsHost()) {
                                gapComposer3.startReplaceGroup(-1550786749);
                                String strStringResource2 = MathKt.stringResource(R.string.host_label, gapComposer3);
                                TextStyle textStyle2 = CardKt.getTypography(gapComposer3).labelSmall;
                                long j8 = CardKt.getColorScheme(gapComposer3).primary;
                                TextKt.m352TextNvy7gAk(strStringResource2, null, ColorKt.Color(Color.m485getRedimpl(j8), Color.m484getGreenimpl(j8), Color.m482getBlueimpl(j8), 0.8f, Color.m483getColorSpaceimpl(j8)), 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, textStyle2, gapComposer3, 0, 0, 131066);
                                gapComposer3.end(false);
                            } else if (Intrinsics.areEqual(userInfo.getUserId(), (String) mutableState.getValue())) {
                                gapComposer3.startReplaceGroup(-1550347262);
                                String strStringResource3 = MathKt.stringResource(R.string.you_label, gapComposer3);
                                TextStyle textStyle3 = CardKt.getTypography(gapComposer3).labelSmall;
                                long j9 = CardKt.getColorScheme(gapComposer3).secondary;
                                TextKt.m352TextNvy7gAk(strStringResource3, null, ColorKt.Color(Color.m485getRedimpl(j9), Color.m484getGreenimpl(j9), Color.m482getBlueimpl(j9), 0.8f, Color.m483getColorSpaceimpl(j9)), 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, textStyle3, gapComposer3, 0, 0, 131066);
                                gapComposer3.end(false);
                            } else {
                                gapComposer3.startReplaceGroup(-1549991475);
                                gapComposer3.end(false);
                            }
                            gapComposer3.end(true);
                            size = i4;
                            mutableState6 = mutableState;
                            mutableState4 = mutableState7;
                            arrayList2 = arrayList;
                            i2 = i3;
                        } else {
                            arrayList = arrayList2;
                        }
                        zChanged = gapComposer3.changed(mutableState3) | gapComposer3.changed(userInfo) | gapComposer3.changed(mutableState4);
                        Object objRememberedValue8 = gapComposer3.rememberedValue();
                        if (zChanged) {
                            GapComposer$$ExternalSyntheticLambda0 gapComposer$$ExternalSyntheticLambda1 = new GapComposer$$ExternalSyntheticLambda0(userInfo, mutableState3, mutableState4, (byte) 19);
                            gapComposer3.updateRememberedValue(gapComposer$$ExternalSyntheticLambda1);
                            obj6 = gapComposer$$ExternalSyntheticLambda1;
                        } else {
                            GapComposer$$ExternalSyntheticLambda0 gapComposer$$ExternalSyntheticLambda2 = new GapComposer$$ExternalSyntheticLambda0(userInfo, mutableState3, mutableState4, (byte) 19);
                            gapComposer3.updateRememberedValue(gapComposer$$ExternalSyntheticLambda2);
                            obj6 = gapComposer$$ExternalSyntheticLambda2;
                        }
                        MutableState mutableState8 = mutableState4;
                        Modifier modifierM46clickableoSLSa3U$default2 = ImageKt.m46clickableoSLSa3U$default(modifierM155width3ABfNKs, z7, null, (Function0) obj6, 14);
                        ColumnMeasurePolicy columnMeasurePolicy3 = ColumnKt.columnMeasurePolicy(arrangement$Top$1, horizontal, gapComposer3, 48);
                        int iHashCode5 = Long.hashCode(gapComposer3.compositeKeyHashCode);
                        PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope5 = gapComposer3.currentCompositionLocalScope();
                        Modifier modifierMaterializeModifier5 = ZIndexModifierKt.materializeModifier(gapComposer3, modifierM46clickableoSLSa3U$default2);
                        ComposeUiNode.Companion.getClass();
                        gapComposer3.startReusableNode();
                        if (gapComposer3.inserting) {
                            gapComposer3.createNode(textKt$$ExternalSyntheticLambda3);
                        } else {
                            gapComposer3.useNode();
                        }
                        Stack.m390setimpl(gapComposer3, columnMeasurePolicy3, updater$$ExternalSyntheticLambda3);
                        Stack.m390setimpl(gapComposer3, persistentCompositionLocalHashMapCurrentCompositionLocalScope5, updater$$ExternalSyntheticLambda2);
                        IntIntPair$$ExternalSyntheticOutline0.m(iHashCode5, gapComposer3, updater$$ExternalSyntheticLambda1, gapComposer3);
                        Stack.m390setimpl(gapComposer3, modifierMaterializeModifier5, updater$$ExternalSyntheticLambda0);
                        MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.Center, false);
                        int iHashCode6 = Long.hashCode(gapComposer3.compositeKeyHashCode);
                        PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope6 = gapComposer3.currentCompositionLocalScope();
                        Modifier modifierMaterializeModifier6 = ZIndexModifierKt.materializeModifier(gapComposer3, companion);
                        gapComposer3.startReusableNode();
                        if (gapComposer3.inserting) {
                            gapComposer3.createNode(textKt$$ExternalSyntheticLambda3);
                        } else {
                            gapComposer3.useNode();
                        }
                        Stack.m390setimpl(gapComposer3, measurePolicyMaybeCachedBoxMeasurePolicy2, updater$$ExternalSyntheticLambda3);
                        Stack.m390setimpl(gapComposer3, persistentCompositionLocalHashMapCurrentCompositionLocalScope6, updater$$ExternalSyntheticLambda2);
                        IntIntPair$$ExternalSyntheticOutline0.m(iHashCode6, gapComposer3, updater$$ExternalSyntheticLambda1, gapComposer3);
                        Stack.m390setimpl(gapComposer3, modifierMaterializeModifier6, updater$$ExternalSyntheticLambda0);
                        Modifier modifierM151size3ABfNKs3 = SizeKt.m151size3ABfNKs(companion, 52.0f);
                        RoundedCornerShape roundedCornerShapeM185RoundedCornerShape0680j_6 = RoundedCornerShapeKt.m185RoundedCornerShape0680j_4(8.0f);
                        if (userInfo.getIsHost()) {
                            gapComposer3.startReplaceGroup(481544286);
                            j = CardKt.getColorScheme(gapComposer3).primary;
                            gapComposer3.end(false);
                        } else if (Intrinsics.areEqual(userInfo.getUserId(), (String) mutableState6.getValue())) {
                            gapComposer3.startReplaceGroup(481712988);
                            j = CardKt.getColorScheme(gapComposer3).secondary;
                            gapComposer3.end(false);
                        } else {
                            gapComposer3.startReplaceGroup(481856983);
                            j = CardKt.getColorScheme(gapComposer3).surfaceVariant;
                            gapComposer3.end(false);
                        }
                        mutableState = mutableState6;
                        SurfaceKt.m337SurfaceT9BRK9s(modifierM151size3ABfNKs3, roundedCornerShapeM185RoundedCornerShape0680j_6, j, 0L, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, null, Expect_jvmKt.rememberComposableLambda(-667908330, new MainActivity$$ExternalSyntheticLambda1((Object) userInfo, (Object) mutableState, (byte) 18), gapComposer3), gapComposer3, 12582918, 120);
                        if (userInfo.getIsHost()) {
                            gapComposer3.startReplaceGroup(483604329);
                            Modifier modifierM151size3ABfNKs4 = SizeKt.m151size3ABfNKs(OffsetKt.m133offsetVpY3zN4(BoxScopeInstance.INSTANCE.align(companion, Alignment.Companion.BottomEnd), 4.0f, 4.0f), 18.0f);
                            RoundedCornerShape roundedCornerShapeM185RoundedCornerShape0680j_7 = RoundedCornerShapeKt.m185RoundedCornerShape0680j_4(8.0f);
                            if (userInfo.getIsHost()) {
                                gapComposer3.startReplaceGroup(1539637986);
                                j2 = CardKt.getColorScheme(gapComposer3).primary;
                                r16 = 0;
                            } else {
                                r16 = 0;
                                gapComposer3.startReplaceGroup(1539639236);
                                j2 = CardKt.getColorScheme(gapComposer3).secondary;
                            }
                            gapComposer3.end(r16);
                            SurfaceKt.m337SurfaceT9BRK9s(modifierM151size3ABfNKs4, roundedCornerShapeM185RoundedCornerShape0680j_7, j2, 0L, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, null, Expect_jvmKt.rememberComposableLambda(293920817, new PlayerMenuKt$$ExternalSyntheticLambda100(userInfo, r16), gapComposer3), gapComposer3, 12582912, 120);
                            gapComposer3.end(r16);
                        } else {
                            gapComposer3.startReplaceGroup(483604329);
                            Modifier modifierM151size3ABfNKs5 = SizeKt.m151size3ABfNKs(OffsetKt.m133offsetVpY3zN4(BoxScopeInstance.INSTANCE.align(companion, Alignment.Companion.BottomEnd), 4.0f, 4.0f), 18.0f);
                            RoundedCornerShape roundedCornerShapeM185RoundedCornerShape0680j_8 = RoundedCornerShapeKt.m185RoundedCornerShape0680j_4(8.0f);
                            if (userInfo.getIsHost()) {
                                gapComposer3.startReplaceGroup(1539637986);
                                j2 = CardKt.getColorScheme(gapComposer3).primary;
                                r16 = 0;
                            } else {
                                r16 = 0;
                                gapComposer3.startReplaceGroup(1539639236);
                                j2 = CardKt.getColorScheme(gapComposer3).secondary;
                            }
                            gapComposer3.end(r16);
                            SurfaceKt.m337SurfaceT9BRK9s(modifierM151size3ABfNKs5, roundedCornerShapeM185RoundedCornerShape0680j_8, j2, 0L, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, null, Expect_jvmKt.rememberComposableLambda(293920817, new PlayerMenuKt$$ExternalSyntheticLambda100(userInfo, r16), gapComposer3), gapComposer3, 12582912, 120);
                            gapComposer3.end(r16);
                        }
                        gapComposer3.end(true);
                        OffsetKt.Spacer(gapComposer3, SizeKt.m145height3ABfNKs(companion, 6.0f));
                        String username2 = userInfo.getUsername();
                        username2.getClass();
                        TextStyle textStyle4 = CardKt.getTypography(gapComposer3).labelMedium;
                        if (Intrinsics.areEqual(userInfo.getUserId(), (String) mutableState.getValue())) {
                            fontWeight = FontWeight.Bold;
                        } else {
                            fontWeight = FontWeight.Medium;
                        }
                        FontWeight fontWeight3 = fontWeight;
                        if (userInfo.getIsHost()) {
                            gapComposer3.startReplaceGroup(-1551437780);
                            j3 = CardKt.getColorScheme(gapComposer3).primary;
                            gapComposer3.end(false);
                        } else {
                            gapComposer3.startReplaceGroup(-1551303798);
                            j3 = CardKt.getColorScheme(gapComposer3).onSurface;
                            gapComposer3.end(false);
                        }
                        TextKt.m352TextNvy7gAk(username2, null, j3, 0L, null, fontWeight3, null, 0L, new TextAlign(3), 0L, 2, false, 1, 0, textStyle4, gapComposer3, 0, 24960, 109498);
                        if (userInfo.getIsHost()) {
                            gapComposer3.startReplaceGroup(-1550786749);
                            String strStringResource4 = MathKt.stringResource(R.string.host_label, gapComposer3);
                            TextStyle textStyle5 = CardKt.getTypography(gapComposer3).labelSmall;
                            long j10 = CardKt.getColorScheme(gapComposer3).primary;
                            TextKt.m352TextNvy7gAk(strStringResource4, null, ColorKt.Color(Color.m485getRedimpl(j10), Color.m484getGreenimpl(j10), Color.m482getBlueimpl(j10), 0.8f, Color.m483getColorSpaceimpl(j10)), 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, textStyle5, gapComposer3, 0, 0, 131066);
                            gapComposer3.end(false);
                        } else if (Intrinsics.areEqual(userInfo.getUserId(), (String) mutableState.getValue())) {
                            gapComposer3.startReplaceGroup(-1550347262);
                            String strStringResource5 = MathKt.stringResource(R.string.you_label, gapComposer3);
                            TextStyle textStyle6 = CardKt.getTypography(gapComposer3).labelSmall;
                            long j11 = CardKt.getColorScheme(gapComposer3).secondary;
                            TextKt.m352TextNvy7gAk(strStringResource5, null, ColorKt.Color(Color.m485getRedimpl(j11), Color.m484getGreenimpl(j11), Color.m482getBlueimpl(j11), 0.8f, Color.m483getColorSpaceimpl(j11)), 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, textStyle6, gapComposer3, 0, 0, 131066);
                            gapComposer3.end(false);
                        } else {
                            gapComposer3.startReplaceGroup(-1549991475);
                            gapComposer3.end(false);
                        }
                        gapComposer3.end(true);
                        size = i4;
                        mutableState6 = mutableState;
                        mutableState4 = mutableState8;
                        arrayList2 = arrayList;
                        i2 = i3;
                    }
                    Fragment$5$$ExternalSyntheticOutline0.m(gapComposer3, false, true, true);
                } else {
                    gapComposer3.skipToGroupEnd();
                }
                return unit;
            case 3:
                ArrayList arrayList3 = (ArrayList) obj10;
                String str2 = (String) obj9;
                MutableState mutableState9 = (MutableState) obj8;
                MutableState mutableState10 = (MutableState) obj7;
                Composer composer4 = (Composer) obj2;
                int iIntValue4 = ((Integer) obj3).intValue();
                ((LazyItemScopeImpl) obj).getClass();
                GapComposer gapComposer4 = (GapComposer) composer4;
                if (gapComposer4.shouldExecute(iIntValue4 & 1, (iIntValue4 & 17) != 16)) {
                    boolean z8 = this.f$3;
                    boolean zChanged7 = gapComposer4.changed(z8) | gapComposer4.changed(str2) | gapComposer4.changed(mutableState9) | gapComposer4.changed(mutableState10);
                    Object objRememberedValue9 = gapComposer4.rememberedValue();
                    if (zChanged7 || objRememberedValue9 == neverEqualPolicy) {
                        str = str2;
                        PlayerKt$$ExternalSyntheticLambda84 playerKt$$ExternalSyntheticLambda84 = new PlayerKt$$ExternalSyntheticLambda84((byte) 6, (Object) str, (Object) mutableState9, (Object) mutableState10, z8);
                        gapComposer4.updateRememberedValue(playerKt$$ExternalSyntheticLambda84);
                        objRememberedValue9 = playerKt$$ExternalSyntheticLambda84;
                    } else {
                        str = str2;
                    }
                    ListenTogetherScreenKt.ConnectedUsersSection(arrayList3, z8, str, (Function2) objRememberedValue9, gapComposer4, 0);
                } else {
                    gapComposer4.skipToGroupEnd();
                }
                return unit;
            case 4:
                return invoke$com$metrolist$music$ui$screens$artist$ArtistSongsScreenKt$$ExternalSyntheticLambda6(obj, obj2, obj3);
            case 5:
                Function0 function2 = (Function0) obj8;
                Function0 function3 = (Function0) obj10;
                Function0 function4 = (Function0) obj9;
                Function0 function5 = (Function0) obj7;
                Composer composer5 = (Composer) obj2;
                int iIntValue5 = ((Integer) obj3).intValue();
                ((RowScope) obj).getClass();
                GapComposer gapComposer5 = (GapComposer) composer5;
                if (gapComposer5.shouldExecute(iIntValue5 & 1, (iIntValue5 & 17) != 16)) {
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy3 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.TopStart, false);
                    int iHashCode7 = Long.hashCode(gapComposer5.compositeKeyHashCode);
                    PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope7 = gapComposer5.currentCompositionLocalScope();
                    Modifier modifierMaterializeModifier7 = ZIndexModifierKt.materializeModifier(gapComposer5, Modifier.Companion.$$INSTANCE);
                    ComposeUiNode.Companion.getClass();
                    gapComposer5.startReusableNode();
                    if (gapComposer5.inserting) {
                        gapComposer5.createNode(textKt$$ExternalSyntheticLambda3);
                    } else {
                        gapComposer5.useNode();
                    }
                    Stack.m390setimpl(gapComposer5, measurePolicyMaybeCachedBoxMeasurePolicy3, updater$$ExternalSyntheticLambda3);
                    Stack.m390setimpl(gapComposer5, persistentCompositionLocalHashMapCurrentCompositionLocalScope7, updater$$ExternalSyntheticLambda2);
                    Stack.m390setimpl(gapComposer5, Integer.valueOf(iHashCode7), updater$$ExternalSyntheticLambda1);
                    Stack.m389reconcileimpl(gapComposer5);
                    Stack.m390setimpl(gapComposer5, modifierMaterializeModifier7, updater$$ExternalSyntheticLambda0);
                    CardKt.IconButton(function2, null, false, null, null, EqScreenKt.lambda$1219249419, gapComposer5, 1572864, 62);
                    CardKt.m256DropdownMenuIlH_yew(this.f$3, function3, null, 0L, null, null, null, 0L, CropImageView.DEFAULT_ASPECT_RATIO, Expect_jvmKt.rememberComposableLambda(-1061270446, new CustomThumbnailMenuKt$$ExternalSyntheticLambda2(function4, function5, (byte) 2), gapComposer5), gapComposer5, 0, 2044);
                    gapComposer5.end(true);
                } else {
                    gapComposer5.skipToGroupEnd();
                }
                return unit;
            case 6:
                return invoke$com$metrolist$music$ui$screens$library$LibraryPodcastsScreenKt$$ExternalSyntheticLambda15(obj, obj2, obj3);
            default:
                SliderStyle sliderStyle = (SliderStyle) obj10;
                final Function1 function6 = (Function1) obj9;
                final Function1 function7 = (Function1) obj8;
                final MutableState mutableState11 = (MutableState) obj7;
                Composer composer6 = (Composer) obj2;
                int iIntValue6 = ((Integer) obj3).intValue();
                ((ColumnScopeInstance) obj).getClass();
                GapComposer gapComposer6 = (GapComposer) composer6;
                if (!gapComposer6.shouldExecute(iIntValue6 & 1, (iIntValue6 & 17) != 16)) {
                    gapComposer6.skipToGroupEnd();
                    return unit;
                }
                long j12 = CardKt.getColorScheme(gapComposer6).primary;
                boolean zIsSystemInDarkTheme = ImageKt.isSystemInDarkTheme(gapComposer6);
                gapComposer6.startReplaceGroup(-405027689);
                if (zIsSystemInDarkTheme) {
                    gapComposer6.startReplaceGroup(-404996627);
                    long j13 = ((MaterialTheme$Values) gapComposer6.consume(MaterialThemeKt._localMaterialTheme)).colorScheme.outline;
                    jColor = ColorKt.Color(Color.m485getRedimpl(j13), Color.m484getGreenimpl(j13), Color.m482getBlueimpl(j13), 0.4f, Color.m483getColorSpaceimpl(j13));
                    z3 = false;
                    gapComposer6.end(false);
                } else {
                    z3 = false;
                    gapComposer6.startReplaceGroup(-404899349);
                    long j14 = ((MaterialTheme$Values) gapComposer6.consume(MaterialThemeKt._localMaterialTheme)).colorScheme.onSurface;
                    jColor = ColorKt.Color(Color.m485getRedimpl(j14), Color.m484getGreenimpl(j14), Color.m482getBlueimpl(j14), 0.3f, Color.m483getColorSpaceimpl(j14));
                    gapComposer6.end(false);
                }
                long j15 = jColor;
                gapComposer6.end(z3);
                SliderDefaults sliderDefaults = SliderDefaults.INSTANCE;
                SliderColors sliderColorsM328colorsq0g_0yA = SliderDefaults.m328colorsq0g_0yA(j12, j12, j12, j15, 0L, j12, j12, j15, gapComposer6, 656);
                ColumnMeasurePolicy columnMeasurePolicy4 = ColumnKt.columnMeasurePolicy(OffsetKt.m141spacedBy0680j_4(12.0f), Alignment.Companion.Start, gapComposer6, 6);
                int iHashCode8 = Long.hashCode(gapComposer6.compositeKeyHashCode);
                PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope8 = gapComposer6.currentCompositionLocalScope();
                Modifier.Companion companion2 = Modifier.Companion.$$INSTANCE;
                Modifier modifierMaterializeModifier8 = ZIndexModifierKt.materializeModifier(gapComposer6, companion2);
                ComposeUiNode.Companion.getClass();
                gapComposer6.startReusableNode();
                if (gapComposer6.inserting) {
                    gapComposer6.createNode(textKt$$ExternalSyntheticLambda3);
                } else {
                    gapComposer6.useNode();
                }
                Stack.m390setimpl(gapComposer6, columnMeasurePolicy4, updater$$ExternalSyntheticLambda3);
                Stack.m390setimpl(gapComposer6, persistentCompositionLocalHashMapCurrentCompositionLocalScope8, updater$$ExternalSyntheticLambda2);
                Stack.m390setimpl(gapComposer6, Integer.valueOf(iHashCode8), updater$$ExternalSyntheticLambda1);
                Stack.m389reconcileimpl(gapComposer6);
                Stack.m390setimpl(gapComposer6, modifierMaterializeModifier8, updater$$ExternalSyntheticLambda0);
                Arrangement$SpacedAligned arrangement$SpacedAlignedM141spacedBy0680j_4 = OffsetKt.m141spacedBy0680j_4(12.0f);
                BiasAlignment.Vertical vertical = Alignment.Companion.Top;
                RowMeasurePolicy rowMeasurePolicy2 = RowKt.rowMeasurePolicy(arrangement$SpacedAlignedM141spacedBy0680j_4, vertical, gapComposer6, 6);
                int iHashCode9 = Long.hashCode(gapComposer6.compositeKeyHashCode);
                PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope9 = gapComposer6.currentCompositionLocalScope();
                Modifier modifierMaterializeModifier9 = ZIndexModifierKt.materializeModifier(gapComposer6, companion2);
                gapComposer6.startReusableNode();
                if (gapComposer6.inserting) {
                    gapComposer6.createNode(textKt$$ExternalSyntheticLambda3);
                } else {
                    gapComposer6.useNode();
                }
                Stack.m390setimpl(gapComposer6, rowMeasurePolicy2, updater$$ExternalSyntheticLambda3);
                Stack.m390setimpl(gapComposer6, persistentCompositionLocalHashMapCurrentCompositionLocalScope9, updater$$ExternalSyntheticLambda2);
                IntIntPair$$ExternalSyntheticOutline0.m(iHashCode9, gapComposer6, updater$$ExternalSyntheticLambda1, gapComposer6);
                Stack.m390setimpl(gapComposer6, modifierMaterializeModifier9, updater$$ExternalSyntheticLambda0);
                BiasAlignment.Horizontal horizontal2 = Alignment.Companion.CenterHorizontally;
                Arrangement$SpacedAligned arrangement$SpacedAlignedM141spacedBy0680j_5 = OffsetKt.m141spacedBy0680j_4(4.0f);
                Modifier modifierThen = companion2.then(new AspectRatioElement(1.0f));
                RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                Modifier modifierClip = ClipKt.clip(rowScopeInstance.weight(modifierThen, 1.0f, true), RoundedCornerShapeKt.m185RoundedCornerShape0680j_4(16.0f));
                if (sliderStyle != SliderStyle.DEFAULT || z5) {
                    gapComposer6.startReplaceGroup(1706565568);
                    j4 = CardKt.getColorScheme(gapComposer6).outlineVariant;
                    gapComposer6.end(false);
                } else {
                    gapComposer6.startReplaceGroup(1706447303);
                    j4 = CardKt.getColorScheme(gapComposer6).primary;
                    gapComposer6.end(false);
                }
                Modifier modifierM42borderxT4_qwU = ImageKt.m42borderxT4_qwU(modifierClip, 1.0f, j4, RoundedCornerShapeKt.m185RoundedCornerShape0680j_4(16.0f));
                boolean zChanged8 = gapComposer6.changed(function6) | gapComposer6.changed(function7) | gapComposer6.changed(mutableState11);
                Object objRememberedValue10 = gapComposer6.rememberedValue();
                if (zChanged8 || objRememberedValue10 == neverEqualPolicy) {
                    z4 = false;
                    final boolean z9 = false ? 1 : 0;
                    objRememberedValue10 = new Function0() { // from class: com.metrolist.music.ui.screens.settings.AppearanceSettingsKt$$ExternalSyntheticLambda163
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            byte b4 = z9;
                            SliderStyle sliderStyle2 = SliderStyle.WAVY;
                            Unit unit2 = Unit.INSTANCE;
                            MutableState mutableState12 = mutableState11;
                            Function1 function8 = function7;
                            Function1 function9 = function6;
                            switch (b4) {
                                case 0:
                                    function9.invoke(SliderStyle.DEFAULT);
                                    Boolean bool = Boolean.FALSE;
                                    function8.invoke(bool);
                                    mutableState12.setValue(bool);
                                    break;
                                case 1:
                                    function9.invoke(sliderStyle2);
                                    Boolean bool2 = Boolean.FALSE;
                                    function8.invoke(bool2);
                                    mutableState12.setValue(bool2);
                                    break;
                                case 2:
                                    function9.invoke(SliderStyle.SLIM);
                                    Boolean bool3 = Boolean.FALSE;
                                    function8.invoke(bool3);
                                    mutableState12.setValue(bool3);
                                    break;
                                default:
                                    function9.invoke(sliderStyle2);
                                    function8.invoke(Boolean.TRUE);
                                    mutableState12.setValue(Boolean.FALSE);
                                    break;
                            }
                            return unit2;
                        }
                    };
                    gapComposer6.updateRememberedValue(objRememberedValue10);
                } else {
                    z4 = false;
                }
                Modifier modifierM135padding3ABfNKs = OffsetKt.m135padding3ABfNKs(ImageKt.m46clickableoSLSa3U$default(modifierM42borderxT4_qwU, z4, null, (Function0) objRememberedValue10, 15), 12.0f);
                ColumnMeasurePolicy columnMeasurePolicy5 = ColumnKt.columnMeasurePolicy(arrangement$SpacedAlignedM141spacedBy0680j_5, horizontal2, gapComposer6, 54);
                int iHashCode10 = Long.hashCode(gapComposer6.compositeKeyHashCode);
                PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope10 = gapComposer6.currentCompositionLocalScope();
                Modifier modifierMaterializeModifier10 = ZIndexModifierKt.materializeModifier(gapComposer6, modifierM135padding3ABfNKs);
                gapComposer6.startReusableNode();
                if (gapComposer6.inserting) {
                    gapComposer6.createNode(textKt$$ExternalSyntheticLambda3);
                } else {
                    gapComposer6.useNode();
                }
                Stack.m390setimpl(gapComposer6, columnMeasurePolicy5, updater$$ExternalSyntheticLambda3);
                Stack.m390setimpl(gapComposer6, persistentCompositionLocalHashMapCurrentCompositionLocalScope10, updater$$ExternalSyntheticLambda2);
                IntIntPair$$ExternalSyntheticOutline0.m(iHashCode10, gapComposer6, updater$$ExternalSyntheticLambda1, gapComposer6);
                Stack.m390setimpl(gapComposer6, modifierMaterializeModifier10, updater$$ExternalSyntheticLambda0);
                ClosedFloatRange closedFloatRange = new ClosedFloatRange(CropImageView.DEFAULT_ASPECT_RATIO, 1.0f);
                ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                Modifier modifierWeight = columnScopeInstance.weight(companion2, 1.0f, true);
                Object objRememberedValue11 = gapComposer6.rememberedValue();
                if (objRememberedValue11 == neverEqualPolicy) {
                    objRememberedValue11 = new InnerTubeXPlayer$$ExternalSyntheticLambda3((byte) 8);
                    gapComposer6.updateRememberedValue(objRememberedValue11);
                }
                SliderKt.Slider(0.35f, (Function1) objRememberedValue11, modifierWeight, false, closedFloatRange, 0, sliderColorsM328colorsq0g_0yA, null, gapComposer6, 3126, 352);
                TextKt.m352TextNvy7gAk(MathKt.stringResource(R.string.default_, gapComposer6), null, 0L, 0L, null, null, null, 0L, null, 0L, 2, false, 1, 0, CardKt.getTypography(gapComposer6).labelSmall, gapComposer6, 0, 24960, 110590);
                gapComposer6.end(true);
                Arrangement$SpacedAligned arrangement$SpacedAlignedM141spacedBy0680j_6 = OffsetKt.m141spacedBy0680j_4(4.0f);
                Modifier modifierClip2 = ClipKt.clip(rowScopeInstance.weight(companion2.then(new AspectRatioElement(1.0f)), 1.0f, true), RoundedCornerShapeKt.m185RoundedCornerShape0680j_4(16.0f));
                SliderStyle sliderStyle2 = SliderStyle.WAVY;
                if (sliderStyle != sliderStyle2 || z5) {
                    gapComposer6.startReplaceGroup(1708603136);
                    j5 = CardKt.getColorScheme(gapComposer6).outlineVariant;
                    gapComposer6.end(false);
                } else {
                    gapComposer6.startReplaceGroup(1708484871);
                    j5 = CardKt.getColorScheme(gapComposer6).primary;
                    gapComposer6.end(false);
                }
                Modifier modifierM42borderxT4_qwU2 = ImageKt.m42borderxT4_qwU(modifierClip2, 1.0f, j5, RoundedCornerShapeKt.m185RoundedCornerShape0680j_4(16.0f));
                boolean zChanged9 = gapComposer6.changed(function6) | gapComposer6.changed(function7) | gapComposer6.changed(mutableState11);
                Object objRememberedValue12 = gapComposer6.rememberedValue();
                if (zChanged9 || objRememberedValue12 == neverEqualPolicy) {
                    final byte b4 = 1;
                    objRememberedValue12 = new Function0() { // from class: com.metrolist.music.ui.screens.settings.AppearanceSettingsKt$$ExternalSyntheticLambda163
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            byte b5 = b4;
                            SliderStyle sliderStyle3 = SliderStyle.WAVY;
                            Unit unit2 = Unit.INSTANCE;
                            MutableState mutableState12 = mutableState11;
                            Function1 function8 = function7;
                            Function1 function9 = function6;
                            switch (b5) {
                                case 0:
                                    function9.invoke(SliderStyle.DEFAULT);
                                    Boolean bool = Boolean.FALSE;
                                    function8.invoke(bool);
                                    mutableState12.setValue(bool);
                                    break;
                                case 1:
                                    function9.invoke(sliderStyle3);
                                    Boolean bool2 = Boolean.FALSE;
                                    function8.invoke(bool2);
                                    mutableState12.setValue(bool2);
                                    break;
                                case 2:
                                    function9.invoke(SliderStyle.SLIM);
                                    Boolean bool3 = Boolean.FALSE;
                                    function8.invoke(bool3);
                                    mutableState12.setValue(bool3);
                                    break;
                                default:
                                    function9.invoke(sliderStyle3);
                                    function8.invoke(Boolean.TRUE);
                                    mutableState12.setValue(Boolean.FALSE);
                                    break;
                            }
                            return unit2;
                        }
                    };
                    gapComposer6.updateRememberedValue(objRememberedValue12);
                }
                Modifier modifierM135padding3ABfNKs2 = OffsetKt.m135padding3ABfNKs(ImageKt.m46clickableoSLSa3U$default(modifierM42borderxT4_qwU2, false, null, (Function0) objRememberedValue12, 15), 12.0f);
                ColumnMeasurePolicy columnMeasurePolicy6 = ColumnKt.columnMeasurePolicy(arrangement$SpacedAlignedM141spacedBy0680j_6, horizontal2, gapComposer6, 54);
                int iHashCode11 = Long.hashCode(gapComposer6.compositeKeyHashCode);
                PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope11 = gapComposer6.currentCompositionLocalScope();
                Modifier modifierMaterializeModifier11 = ZIndexModifierKt.materializeModifier(gapComposer6, modifierM135padding3ABfNKs2);
                gapComposer6.startReusableNode();
                if (gapComposer6.inserting) {
                    gapComposer6.createNode(textKt$$ExternalSyntheticLambda3);
                } else {
                    gapComposer6.useNode();
                }
                Stack.m390setimpl(gapComposer6, columnMeasurePolicy6, updater$$ExternalSyntheticLambda3);
                Stack.m390setimpl(gapComposer6, persistentCompositionLocalHashMapCurrentCompositionLocalScope11, updater$$ExternalSyntheticLambda2);
                IntIntPair$$ExternalSyntheticOutline0.m(iHashCode11, gapComposer6, updater$$ExternalSyntheticLambda1, gapComposer6);
                Stack.m390setimpl(gapComposer6, modifierMaterializeModifier11, updater$$ExternalSyntheticLambda0);
                ClosedFloatRange closedFloatRange2 = new ClosedFloatRange(CropImageView.DEFAULT_ASPECT_RATIO, 1.0f);
                Modifier modifierWeight2 = columnScopeInstance.weight(companion2, 1.0f, true);
                Object objRememberedValue13 = gapComposer6.rememberedValue();
                if (objRememberedValue13 == neverEqualPolicy) {
                    objRememberedValue13 = new InnerTubeXPlayer$$ExternalSyntheticLambda3((byte) 9);
                    gapComposer6.updateRememberedValue(objRememberedValue13);
                }
                MenuKt.m1496WavySliderf2iHHTE(0.5f, (Function1) objRememberedValue13, modifierWeight2, closedFloatRange2, null, sliderColorsM328colorsq0g_0yA, true, false, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, gapComposer6, 14155830, 3856);
                TextKt.m352TextNvy7gAk(MathKt.stringResource(R.string.wavy, gapComposer6), null, 0L, 0L, null, null, null, 0L, null, 0L, 2, false, 1, 0, CardKt.getTypography(gapComposer6).labelSmall, gapComposer6, 0, 24960, 110590);
                gapComposer6.end(true);
                gapComposer6.end(true);
                RowMeasurePolicy rowMeasurePolicy3 = RowKt.rowMeasurePolicy(OffsetKt.m141spacedBy0680j_4(12.0f), vertical, gapComposer6, 6);
                int iHashCode12 = Long.hashCode(gapComposer6.compositeKeyHashCode);
                PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope12 = gapComposer6.currentCompositionLocalScope();
                Modifier modifierMaterializeModifier12 = ZIndexModifierKt.materializeModifier(gapComposer6, companion2);
                gapComposer6.startReusableNode();
                if (gapComposer6.inserting) {
                    gapComposer6.createNode(textKt$$ExternalSyntheticLambda3);
                } else {
                    gapComposer6.useNode();
                }
                Stack.m390setimpl(gapComposer6, rowMeasurePolicy3, updater$$ExternalSyntheticLambda3);
                Stack.m390setimpl(gapComposer6, persistentCompositionLocalHashMapCurrentCompositionLocalScope12, updater$$ExternalSyntheticLambda2);
                IntIntPair$$ExternalSyntheticOutline0.m(iHashCode12, gapComposer6, updater$$ExternalSyntheticLambda1, gapComposer6);
                Stack.m390setimpl(gapComposer6, modifierMaterializeModifier12, updater$$ExternalSyntheticLambda0);
                Arrangement$SpacedAligned arrangement$SpacedAlignedM141spacedBy0680j_7 = OffsetKt.m141spacedBy0680j_4(4.0f);
                Modifier modifierClip3 = ClipKt.clip(rowScopeInstance.weight(companion2.then(new AspectRatioElement(1.0f)), 1.0f, true), RoundedCornerShapeKt.m185RoundedCornerShape0680j_4(16.0f));
                if (sliderStyle == SliderStyle.SLIM) {
                    gapComposer6.startReplaceGroup(-1572646594);
                    j6 = CardKt.getColorScheme(gapComposer6).primary;
                    gapComposer6.end(false);
                } else {
                    gapComposer6.startReplaceGroup(-1572528329);
                    j6 = CardKt.getColorScheme(gapComposer6).outlineVariant;
                    gapComposer6.end(false);
                }
                Modifier modifierM42borderxT4_qwU3 = ImageKt.m42borderxT4_qwU(modifierClip3, 1.0f, j6, RoundedCornerShapeKt.m185RoundedCornerShape0680j_4(16.0f));
                boolean zChanged10 = gapComposer6.changed(function6) | gapComposer6.changed(function7) | gapComposer6.changed(mutableState11);
                Object objRememberedValue14 = gapComposer6.rememberedValue();
                if (zChanged10 || objRememberedValue14 == neverEqualPolicy) {
                    final byte b5 = 2;
                    objRememberedValue14 = new Function0() { // from class: com.metrolist.music.ui.screens.settings.AppearanceSettingsKt$$ExternalSyntheticLambda163
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            byte b6 = b5;
                            SliderStyle sliderStyle3 = SliderStyle.WAVY;
                            Unit unit2 = Unit.INSTANCE;
                            MutableState mutableState12 = mutableState11;
                            Function1 function8 = function7;
                            Function1 function9 = function6;
                            switch (b6) {
                                case 0:
                                    function9.invoke(SliderStyle.DEFAULT);
                                    Boolean bool = Boolean.FALSE;
                                    function8.invoke(bool);
                                    mutableState12.setValue(bool);
                                    break;
                                case 1:
                                    function9.invoke(sliderStyle3);
                                    Boolean bool2 = Boolean.FALSE;
                                    function8.invoke(bool2);
                                    mutableState12.setValue(bool2);
                                    break;
                                case 2:
                                    function9.invoke(SliderStyle.SLIM);
                                    Boolean bool3 = Boolean.FALSE;
                                    function8.invoke(bool3);
                                    mutableState12.setValue(bool3);
                                    break;
                                default:
                                    function9.invoke(sliderStyle3);
                                    function8.invoke(Boolean.TRUE);
                                    mutableState12.setValue(Boolean.FALSE);
                                    break;
                            }
                            return unit2;
                        }
                    };
                    gapComposer6.updateRememberedValue(objRememberedValue14);
                }
                Modifier modifierM135padding3ABfNKs3 = OffsetKt.m135padding3ABfNKs(ImageKt.m46clickableoSLSa3U$default(modifierM42borderxT4_qwU3, false, null, (Function0) objRememberedValue14, 15), 12.0f);
                ColumnMeasurePolicy columnMeasurePolicy7 = ColumnKt.columnMeasurePolicy(arrangement$SpacedAlignedM141spacedBy0680j_7, horizontal2, gapComposer6, 54);
                int iHashCode13 = Long.hashCode(gapComposer6.compositeKeyHashCode);
                PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope13 = gapComposer6.currentCompositionLocalScope();
                Modifier modifierMaterializeModifier13 = ZIndexModifierKt.materializeModifier(gapComposer6, modifierM135padding3ABfNKs3);
                gapComposer6.startReusableNode();
                if (gapComposer6.inserting) {
                    gapComposer6.createNode(textKt$$ExternalSyntheticLambda3);
                } else {
                    gapComposer6.useNode();
                }
                Stack.m390setimpl(gapComposer6, columnMeasurePolicy7, updater$$ExternalSyntheticLambda3);
                Stack.m390setimpl(gapComposer6, persistentCompositionLocalHashMapCurrentCompositionLocalScope13, updater$$ExternalSyntheticLambda2);
                IntIntPair$$ExternalSyntheticOutline0.m(iHashCode13, gapComposer6, updater$$ExternalSyntheticLambda1, gapComposer6);
                Stack.m390setimpl(gapComposer6, modifierMaterializeModifier13, updater$$ExternalSyntheticLambda0);
                Object objRememberedValue15 = gapComposer6.rememberedValue();
                if (objRememberedValue15 == neverEqualPolicy) {
                    objRememberedValue15 = new SliderState(0.65f, (ClosedFloatRange) null, 6);
                    gapComposer6.updateRememberedValue(objRememberedValue15);
                }
                SliderKt.Slider((SliderState) objRememberedValue15, columnScopeInstance.weight(companion2, 1.0f, true), false, null, null, sliderColorsM328colorsq0g_0yA, null, AiSettingsKt.lambda$260596194, Expect_jvmKt.rememberComposableLambda(1276816321, new ListItemKt$$ExternalSyntheticLambda17((byte) 20, (Object) sliderColorsM328colorsq0g_0yA), gapComposer6), gapComposer6, 113246600, 88);
                TextKt.m352TextNvy7gAk(MathKt.stringResource(R.string.slim, gapComposer6), null, 0L, 0L, null, null, null, 0L, null, 0L, 2, false, 1, 0, CardKt.getTypography(gapComposer6).labelSmall, gapComposer6, 0, 24960, 110590);
                gapComposer6.end(true);
                Arrangement$SpacedAligned arrangement$SpacedAlignedM141spacedBy0680j_8 = OffsetKt.m141spacedBy0680j_4(4.0f);
                Modifier modifierClip4 = ClipKt.clip(rowScopeInstance.weight(companion2.then(new AspectRatioElement(1.0f)), 1.0f, true), RoundedCornerShapeKt.m185RoundedCornerShape0680j_4(16.0f));
                if (sliderStyle == sliderStyle2 && z5) {
                    gapComposer6.startReplaceGroup(-1570323330);
                    j7 = CardKt.getColorScheme(gapComposer6).primary;
                    gapComposer6.end(false);
                } else {
                    gapComposer6.startReplaceGroup(-1570205065);
                    j7 = CardKt.getColorScheme(gapComposer6).outlineVariant;
                    gapComposer6.end(false);
                }
                Modifier modifierM42borderxT4_qwU4 = ImageKt.m42borderxT4_qwU(modifierClip4, 1.0f, j7, RoundedCornerShapeKt.m185RoundedCornerShape0680j_4(16.0f));
                boolean zChanged11 = gapComposer6.changed(function6) | gapComposer6.changed(function7) | gapComposer6.changed(mutableState11);
                Object objRememberedValue16 = gapComposer6.rememberedValue();
                if (zChanged11 || objRememberedValue16 == neverEqualPolicy) {
                    final byte b6 = 3;
                    objRememberedValue16 = new Function0() { // from class: com.metrolist.music.ui.screens.settings.AppearanceSettingsKt$$ExternalSyntheticLambda163
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            byte b7 = b6;
                            SliderStyle sliderStyle3 = SliderStyle.WAVY;
                            Unit unit2 = Unit.INSTANCE;
                            MutableState mutableState12 = mutableState11;
                            Function1 function8 = function7;
                            Function1 function9 = function6;
                            switch (b7) {
                                case 0:
                                    function9.invoke(SliderStyle.DEFAULT);
                                    Boolean bool = Boolean.FALSE;
                                    function8.invoke(bool);
                                    mutableState12.setValue(bool);
                                    break;
                                case 1:
                                    function9.invoke(sliderStyle3);
                                    Boolean bool2 = Boolean.FALSE;
                                    function8.invoke(bool2);
                                    mutableState12.setValue(bool2);
                                    break;
                                case 2:
                                    function9.invoke(SliderStyle.SLIM);
                                    Boolean bool3 = Boolean.FALSE;
                                    function8.invoke(bool3);
                                    mutableState12.setValue(bool3);
                                    break;
                                default:
                                    function9.invoke(sliderStyle3);
                                    function8.invoke(Boolean.TRUE);
                                    mutableState12.setValue(Boolean.FALSE);
                                    break;
                            }
                            return unit2;
                        }
                    };
                    gapComposer6.updateRememberedValue(objRememberedValue16);
                }
                Modifier modifierM135padding3ABfNKs4 = OffsetKt.m135padding3ABfNKs(ImageKt.m46clickableoSLSa3U$default(modifierM42borderxT4_qwU4, false, null, (Function0) objRememberedValue16, 15), 12.0f);
                ColumnMeasurePolicy columnMeasurePolicy8 = ColumnKt.columnMeasurePolicy(arrangement$SpacedAlignedM141spacedBy0680j_8, horizontal2, gapComposer6, 54);
                int iHashCode14 = Long.hashCode(gapComposer6.compositeKeyHashCode);
                PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope14 = gapComposer6.currentCompositionLocalScope();
                Modifier modifierMaterializeModifier14 = ZIndexModifierKt.materializeModifier(gapComposer6, modifierM135padding3ABfNKs4);
                gapComposer6.startReusableNode();
                if (gapComposer6.inserting) {
                    gapComposer6.createNode(textKt$$ExternalSyntheticLambda3);
                } else {
                    gapComposer6.useNode();
                }
                Stack.m390setimpl(gapComposer6, columnMeasurePolicy8, updater$$ExternalSyntheticLambda3);
                Stack.m390setimpl(gapComposer6, persistentCompositionLocalHashMapCurrentCompositionLocalScope14, updater$$ExternalSyntheticLambda2);
                IntIntPair$$ExternalSyntheticOutline0.m(iHashCode14, gapComposer6, updater$$ExternalSyntheticLambda1, gapComposer6);
                Stack.m390setimpl(gapComposer6, modifierMaterializeModifier14, updater$$ExternalSyntheticLambda0);
                ClosedFloatRange closedFloatRange3 = new ClosedFloatRange(CropImageView.DEFAULT_ASPECT_RATIO, 1.0f);
                Modifier modifierWeight3 = columnScopeInstance.weight(companion2, 1.0f, true);
                Object objRememberedValue17 = gapComposer6.rememberedValue();
                if (objRememberedValue17 == neverEqualPolicy) {
                    objRememberedValue17 = new InnerTubeXPlayer$$ExternalSyntheticLambda3((byte) 10);
                    gapComposer6.updateRememberedValue(objRememberedValue17);
                }
                MenuKt.SquigglySlider(0.5f, (Function1) objRememberedValue17, modifierWeight3, false, closedFloatRange3, null, sliderColorsM328colorsq0g_0yA, true, gapComposer6, 12586038, 32);
                TextKt.m352TextNvy7gAk(MathKt.stringResource(R.string.squiggly, gapComposer6), null, 0L, 0L, null, null, null, 0L, null, 0L, 2, false, 2, 0, CardKt.getTypography(gapComposer6).labelSmall, gapComposer6, 0, 24960, 110590);
                Fragment$5$$ExternalSyntheticOutline0.m(gapComposer6, true, true, true);
                return unit;
        }
    }

    public /* synthetic */ SongMenuKt$$ExternalSyntheticLambda32(ListenTogetherManager listenTogetherManager, Song song, Function0 function0, boolean z, PlayerConnection playerConnection) {
        this.$r8$classId = (byte) 0;
        this.f$0 = listenTogetherManager;
        this.f$1 = song;
        this.f$2 = function0;
        this.f$3 = z;
        this.f$4 = playerConnection;
    }

    public /* synthetic */ SongMenuKt$$ExternalSyntheticLambda32(Serializable serializable, boolean z, Object obj, Object obj2, State state, byte b) {
        this.$r8$classId = b;
        this.f$0 = serializable;
        this.f$3 = z;
        this.f$1 = obj;
        this.f$2 = obj2;
        this.f$4 = state;
    }

    public /* synthetic */ SongMenuKt$$ExternalSyntheticLambda32(Function0 function0, boolean z, Function0 function1, Function0 function2, Function0 function3) {
        this.$r8$classId = (byte) 5;
        this.f$2 = function0;
        this.f$3 = z;
        this.f$0 = function1;
        this.f$1 = function2;
        this.f$4 = function3;
    }
}
