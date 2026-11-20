package com.materialkolor.ktx;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.collection.internal.Lock;
import androidx.compose.animation.ColorVectorConverterKt$ColorToVector$1$1;
import androidx.compose.animation.core.ArcSplineKt;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.Transition;
import androidx.compose.animation.core.TransitionInstance;
import androidx.compose.animation.core.TwoWayConverterImpl;
import androidx.compose.material3.ColorScheme;
import androidx.compose.material3.ListItemKt$InteractiveListItem$$inlined$animateColor$1;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.NeverEqualPolicy;
import androidx.compose.runtime.ParcelableSnapshotMutableState;
import androidx.compose.runtime.SnapshotStateKt__DerivedStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.colorspace.ColorSpace;
import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import androidx.media3.common.Format$$ExternalSyntheticOutline0;
import androidx.media3.extractor.flv.TagPayloadReader;
import coil3.network.okhttp.internal.CallsKt$await$2$1;
import com.metrolist.music.MainActivity$$ExternalSyntheticLambda44;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b4\u001aC\u0010\t\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u00002 \b\u0002\u0010\u0006\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00000\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00022\b\b\u0002\u0010\b\u001a\u00020\u0007H\u0007¢\u0006\u0004\b\t\u0010\n¨\u0006;²\u0006\f\u0010\u000b\u001a\u00020\u00058\nX\u008a\u0084\u0002²\u0006\f\u0010\f\u001a\u00020\u00058\nX\u008a\u0084\u0002²\u0006\f\u0010\r\u001a\u00020\u00058\nX\u008a\u0084\u0002²\u0006\f\u0010\u000e\u001a\u00020\u00058\nX\u008a\u0084\u0002²\u0006\f\u0010\u000f\u001a\u00020\u00058\nX\u008a\u0084\u0002²\u0006\f\u0010\u0010\u001a\u00020\u00058\nX\u008a\u0084\u0002²\u0006\f\u0010\u0011\u001a\u00020\u00058\nX\u008a\u0084\u0002²\u0006\f\u0010\u0012\u001a\u00020\u00058\nX\u008a\u0084\u0002²\u0006\f\u0010\u0013\u001a\u00020\u00058\nX\u008a\u0084\u0002²\u0006\f\u0010\u0014\u001a\u00020\u00058\nX\u008a\u0084\u0002²\u0006\f\u0010\u0015\u001a\u00020\u00058\nX\u008a\u0084\u0002²\u0006\f\u0010\u0016\u001a\u00020\u00058\nX\u008a\u0084\u0002²\u0006\f\u0010\u0017\u001a\u00020\u00058\nX\u008a\u0084\u0002²\u0006\f\u0010\u0018\u001a\u00020\u00058\nX\u008a\u0084\u0002²\u0006\f\u0010\u0019\u001a\u00020\u00058\nX\u008a\u0084\u0002²\u0006\f\u0010\u001a\u001a\u00020\u00058\nX\u008a\u0084\u0002²\u0006\f\u0010\u001b\u001a\u00020\u00058\nX\u008a\u0084\u0002²\u0006\f\u0010\u001c\u001a\u00020\u00058\nX\u008a\u0084\u0002²\u0006\f\u0010\u001d\u001a\u00020\u00058\nX\u008a\u0084\u0002²\u0006\f\u0010\u001e\u001a\u00020\u00058\nX\u008a\u0084\u0002²\u0006\f\u0010\u001f\u001a\u00020\u00058\nX\u008a\u0084\u0002²\u0006\f\u0010 \u001a\u00020\u00058\nX\u008a\u0084\u0002²\u0006\f\u0010!\u001a\u00020\u00058\nX\u008a\u0084\u0002²\u0006\f\u0010\"\u001a\u00020\u00058\nX\u008a\u0084\u0002²\u0006\f\u0010#\u001a\u00020\u00058\nX\u008a\u0084\u0002²\u0006\f\u0010$\u001a\u00020\u00058\nX\u008a\u0084\u0002²\u0006\f\u0010%\u001a\u00020\u00058\nX\u008a\u0084\u0002²\u0006\f\u0010&\u001a\u00020\u00058\nX\u008a\u0084\u0002²\u0006\f\u0010'\u001a\u00020\u00058\nX\u008a\u0084\u0002²\u0006\f\u0010(\u001a\u00020\u00058\nX\u008a\u0084\u0002²\u0006\f\u0010)\u001a\u00020\u00058\nX\u008a\u0084\u0002²\u0006\f\u0010*\u001a\u00020\u00058\nX\u008a\u0084\u0002²\u0006\f\u0010+\u001a\u00020\u00058\nX\u008a\u0084\u0002²\u0006\f\u0010,\u001a\u00020\u00058\nX\u008a\u0084\u0002²\u0006\f\u0010-\u001a\u00020\u00058\nX\u008a\u0084\u0002²\u0006\f\u0010.\u001a\u00020\u00058\nX\u008a\u0084\u0002²\u0006\f\u0010/\u001a\u00020\u00058\nX\u008a\u0084\u0002²\u0006\f\u00100\u001a\u00020\u00058\nX\u008a\u0084\u0002²\u0006\f\u00101\u001a\u00020\u00058\nX\u008a\u0084\u0002²\u0006\f\u00102\u001a\u00020\u00058\nX\u008a\u0084\u0002²\u0006\f\u00103\u001a\u00020\u00058\nX\u008a\u0084\u0002²\u0006\f\u00104\u001a\u00020\u00058\nX\u008a\u0084\u0002²\u0006\f\u00105\u001a\u00020\u00058\nX\u008a\u0084\u0002²\u0006\f\u00106\u001a\u00020\u00058\nX\u008a\u0084\u0002²\u0006\f\u00107\u001a\u00020\u00058\nX\u008a\u0084\u0002²\u0006\f\u00108\u001a\u00020\u00058\nX\u008a\u0084\u0002²\u0006\f\u00109\u001a\u00020\u00058\nX\u008a\u0084\u0002²\u0006\f\u0010:\u001a\u00020\u00058\nX\u008a\u0084\u0002"}, d2 = {"Landroidx/compose/material3/ColorScheme;", "colorScheme", "Lkotlin/Function1;", "Landroidx/compose/animation/core/Transition$Segment;", "Landroidx/compose/animation/core/FiniteAnimationSpec;", "Landroidx/compose/ui/graphics/Color;", "animationSpec", "", "label", "animateColorScheme", "(Landroidx/compose/material3/ColorScheme;Lkotlin/jvm/functions/Function3;Ljava/lang/String;Landroidx/compose/runtime/Composer;II)Landroidx/compose/material3/ColorScheme;", "primary", "onPrimary", "primaryContainer", "onPrimaryContainer", "inversePrimary", "secondary", "onSecondary", "secondaryContainer", "onSecondaryContainer", "tertiary", "onTertiary", "tertiaryContainer", "onTertiaryContainer", "surface", "onSurface", "surfaceVariant", "onSurfaceVariant", "surfaceTint", "surfaceBright", "surfaceDim", "surfaceContainer", "surfaceContainerHigh", "surfaceContainerHighest", "surfaceContainerLow", "surfaceContainerLowest", "background", "onBackground", "error", "onError", "errorContainer", "onErrorContainer", "inverseSurface", "inverseOnSurface", "outline", "outlineVariant", "scrim", "primaryFixed", "primaryFixedDim", "onPrimaryFixed", "onPrimaryFixedVariant", "secondaryFixed", "secondaryFixedDim", "onSecondaryFixed", "onSecondaryFixedVariant", "tertiaryFixed", "tertiaryFixedDim", "onTertiaryFixed", "onTertiaryFixedVariant", "MaterialKolor:material-kolor"}, k = 2, mv = {2, 4, 0}, xi = 48)
public final class ColorSchemeKt {
    public static final List animateBackgroundAndErrorColors(TransitionInstance transitionInstance, Function3 function3, Composer composer, int i) {
        Object objM;
        boolean z;
        Object objM2;
        boolean z2;
        Object objM3;
        boolean z3;
        Object objM4;
        boolean z4;
        Object objM5;
        boolean z5;
        Object objM6;
        boolean z6;
        Object objM7;
        TagPayloadReader tagPayloadReader = transitionInstance.transitionState;
        int i2 = (i & 14) | 384 | (i & 112);
        ParcelableSnapshotMutableState parcelableSnapshotMutableState = transitionInstance.targetState$delegate;
        ColorScheme colorScheme = (ColorScheme) parcelableSnapshotMutableState.getValue();
        GapComposer gapComposer = (GapComposer) composer;
        gapComposer.startReplaceGroup(-835464483);
        long j = colorScheme.background;
        gapComposer.end(false);
        ColorSpace colorSpaceM483getColorSpaceimpl = Color.m483getColorSpaceimpl(j);
        boolean zChanged = gapComposer.changed(colorSpaceM483getColorSpaceimpl);
        Object objRememberedValue = gapComposer.rememberedValue();
        ColorVectorConverterKt$ColorToVector$1$1 colorVectorConverterKt$ColorToVector$1$1 = ColorVectorConverterKt$ColorToVector$1$1.INSTANCE;
        NeverEqualPolicy neverEqualPolicy = Composer.Companion.Empty;
        if (zChanged || objRememberedValue == neverEqualPolicy) {
            objRememberedValue = IntIntPair$$ExternalSyntheticOutline0.m(colorVectorConverterKt$ColorToVector$1$1, new CallsKt$await$2$1((byte) 1, colorSpaceM483getColorSpaceimpl), gapComposer);
        }
        TwoWayConverterImpl twoWayConverterImpl = (TwoWayConverterImpl) objRememberedValue;
        int i3 = ((i2 << 3) & 896) | (i2 & 14) | 3072;
        if (transitionInstance.isSeeking()) {
            objM = IntIntPair$$ExternalSyntheticOutline0.m(gapComposer, 1666827533, false, tagPayloadReader);
        } else {
            gapComposer.startReplaceGroup(1666573488);
            boolean z7 = (((i3 & 14) ^ 6) > 4 && gapComposer.changed(transitionInstance)) || (i3 & 6) == 4;
            objM = gapComposer.rememberedValue();
            if (z7 || objM == neverEqualPolicy) {
                Snapshot currentThreadSnapshot = Lock.getCurrentThreadSnapshot();
                Function1 readObserver = currentThreadSnapshot != null ? currentThreadSnapshot.getReadObserver() : null;
                Snapshot snapshotMakeCurrentNonObservable = Lock.makeCurrentNonObservable(currentThreadSnapshot);
                try {
                    Object currentState = tagPayloadReader.getCurrentState();
                    Lock.restoreNonObservable(currentThreadSnapshot, snapshotMakeCurrentNonObservable, readObserver);
                    gapComposer.updateRememberedValue(currentState);
                    objM = currentState;
                } catch (Throwable th) {
                    Lock.restoreNonObservable(currentThreadSnapshot, snapshotMakeCurrentNonObservable, readObserver);
                    throw th;
                }
            }
            gapComposer.end(false);
        }
        gapComposer.startReplaceGroup(-835464483);
        Color colorM = Fragment$5$$ExternalSyntheticOutline0.m(gapComposer, false, ((ColorScheme) objM).background);
        int i4 = i3 & 14;
        int i5 = i4 ^ 6;
        boolean z8 = (i5 > 4 && gapComposer.changed(transitionInstance)) || (i3 & 6) == 4;
        Object objRememberedValue2 = gapComposer.rememberedValue();
        if (z8 || objRememberedValue2 == neverEqualPolicy) {
            objRememberedValue2 = SnapshotStateKt__DerivedStateKt.derivedStateOf(new ListItemKt$InteractiveListItem$$inlined$animateColor$1(transitionInstance, (byte) 29));
            gapComposer.updateRememberedValue(objRememberedValue2);
        }
        ColorScheme colorScheme2 = (ColorScheme) ((State) objRememberedValue2).getValue();
        gapComposer.startReplaceGroup(-835464483);
        Color colorM2 = Fragment$5$$ExternalSyntheticOutline0.m(gapComposer, false, colorScheme2.background);
        boolean z9 = (i5 > 4 && gapComposer.changed(transitionInstance)) || (i3 & 6) == 4;
        Object objRememberedValue3 = gapComposer.rememberedValue();
        if (z9 || objRememberedValue3 == neverEqualPolicy) {
            objRememberedValue3 = SnapshotStateKt__DerivedStateKt.derivedStateOf(new ColorSchemeKt$animateFixedColors$$inlined$animateColor$1(transitionInstance, (byte) 1));
            gapComposer.updateRememberedValue(objRememberedValue3);
        }
        Object value = ((State) objRememberedValue3).getValue();
        int i6 = (i3 >> 3) & 112;
        int i7 = i4 | 196608;
        Transition.TransitionAnimationState transitionAnimationStateCreateTransitionAnimation = ArcSplineKt.createTransitionAnimation(transitionInstance, colorM, colorM2, (FiniteAnimationSpec) function3.invoke(value, gapComposer, Integer.valueOf(i6)), twoWayConverterImpl, gapComposer, i7);
        ColorScheme colorScheme3 = (ColorScheme) parcelableSnapshotMutableState.getValue();
        gapComposer.startReplaceGroup(-223639234);
        long j2 = colorScheme3.onBackground;
        gapComposer.end(false);
        ColorSpace colorSpaceM483getColorSpaceimpl2 = Color.m483getColorSpaceimpl(j2);
        boolean zChanged2 = gapComposer.changed(colorSpaceM483getColorSpaceimpl2);
        Object objRememberedValue4 = gapComposer.rememberedValue();
        if (zChanged2 || objRememberedValue4 == neverEqualPolicy) {
            objRememberedValue4 = IntIntPair$$ExternalSyntheticOutline0.m(colorVectorConverterKt$ColorToVector$1$1, new CallsKt$await$2$1((byte) 1, colorSpaceM483getColorSpaceimpl2), gapComposer);
        }
        TwoWayConverterImpl twoWayConverterImpl2 = (TwoWayConverterImpl) objRememberedValue4;
        if (transitionInstance.isSeeking()) {
            z = false;
            objM2 = IntIntPair$$ExternalSyntheticOutline0.m(gapComposer, 1666827533, false, tagPayloadReader);
        } else {
            gapComposer.startReplaceGroup(1666573488);
            boolean z10 = (i5 > 4 && gapComposer.changed(transitionInstance)) || (i3 & 6) == 4;
            objM2 = gapComposer.rememberedValue();
            if (z10 || objM2 == neverEqualPolicy) {
                Snapshot currentThreadSnapshot2 = Lock.getCurrentThreadSnapshot();
                Function1 readObserver2 = currentThreadSnapshot2 != null ? currentThreadSnapshot2.getReadObserver() : null;
                Snapshot snapshotMakeCurrentNonObservable2 = Lock.makeCurrentNonObservable(currentThreadSnapshot2);
                try {
                    Object currentState2 = tagPayloadReader.getCurrentState();
                    Lock.restoreNonObservable(currentThreadSnapshot2, snapshotMakeCurrentNonObservable2, readObserver2);
                    gapComposer.updateRememberedValue(currentState2);
                    objM2 = currentState2;
                } catch (Throwable th2) {
                    Lock.restoreNonObservable(currentThreadSnapshot2, snapshotMakeCurrentNonObservable2, readObserver2);
                    throw th2;
                }
            }
            z = false;
            gapComposer.end(false);
        }
        gapComposer.startReplaceGroup(-223639234);
        Color colorM3 = Fragment$5$$ExternalSyntheticOutline0.m(gapComposer, z, ((ColorScheme) objM2).onBackground);
        boolean z11 = (i5 > 4 && gapComposer.changed(transitionInstance)) || (i3 & 6) == 4;
        Object objRememberedValue5 = gapComposer.rememberedValue();
        if (z11 || objRememberedValue5 == neverEqualPolicy) {
            objRememberedValue5 = SnapshotStateKt__DerivedStateKt.derivedStateOf(new ColorSchemeKt$animateFixedColors$$inlined$animateColor$1(transitionInstance, (byte) 2));
            gapComposer.updateRememberedValue(objRememberedValue5);
        }
        ColorScheme colorScheme4 = (ColorScheme) ((State) objRememberedValue5).getValue();
        gapComposer.startReplaceGroup(-223639234);
        Color colorM4 = Fragment$5$$ExternalSyntheticOutline0.m(gapComposer, false, colorScheme4.onBackground);
        boolean z12 = (i5 > 4 && gapComposer.changed(transitionInstance)) || (i3 & 6) == 4;
        Object objRememberedValue6 = gapComposer.rememberedValue();
        if (z12 || objRememberedValue6 == neverEqualPolicy) {
            objRememberedValue6 = SnapshotStateKt__DerivedStateKt.derivedStateOf(new ColorSchemeKt$animateFixedColors$$inlined$animateColor$1(transitionInstance, (byte) 3));
            gapComposer.updateRememberedValue(objRememberedValue6);
        }
        Transition.TransitionAnimationState transitionAnimationStateCreateTransitionAnimation2 = ArcSplineKt.createTransitionAnimation(transitionInstance, colorM3, colorM4, (FiniteAnimationSpec) function3.invoke(((State) objRememberedValue6).getValue(), gapComposer, Integer.valueOf(i6)), twoWayConverterImpl2, gapComposer, i7);
        ColorScheme colorScheme5 = (ColorScheme) parcelableSnapshotMutableState.getValue();
        gapComposer.startReplaceGroup(-2038357105);
        long j3 = colorScheme5.error;
        gapComposer.end(false);
        ColorSpace colorSpaceM483getColorSpaceimpl3 = Color.m483getColorSpaceimpl(j3);
        boolean zChanged3 = gapComposer.changed(colorSpaceM483getColorSpaceimpl3);
        Object objRememberedValue7 = gapComposer.rememberedValue();
        if (zChanged3 || objRememberedValue7 == neverEqualPolicy) {
            objRememberedValue7 = IntIntPair$$ExternalSyntheticOutline0.m(colorVectorConverterKt$ColorToVector$1$1, new CallsKt$await$2$1((byte) 1, colorSpaceM483getColorSpaceimpl3), gapComposer);
        }
        TwoWayConverterImpl twoWayConverterImpl3 = (TwoWayConverterImpl) objRememberedValue7;
        if (transitionInstance.isSeeking()) {
            twoWayConverterImpl3 = twoWayConverterImpl3;
            z2 = false;
            objM3 = IntIntPair$$ExternalSyntheticOutline0.m(gapComposer, 1666827533, false, tagPayloadReader);
        } else {
            gapComposer.startReplaceGroup(1666573488);
            boolean z13 = (i5 > 4 && gapComposer.changed(transitionInstance)) || (i3 & 6) == 4;
            objM3 = gapComposer.rememberedValue();
            if (z13 || objM3 == neverEqualPolicy) {
                Snapshot currentThreadSnapshot3 = Lock.getCurrentThreadSnapshot();
                Function1 readObserver3 = currentThreadSnapshot3 != null ? currentThreadSnapshot3.getReadObserver() : null;
                Snapshot snapshotMakeCurrentNonObservable3 = Lock.makeCurrentNonObservable(currentThreadSnapshot3);
                try {
                    Object currentState3 = tagPayloadReader.getCurrentState();
                    Lock.restoreNonObservable(currentThreadSnapshot3, snapshotMakeCurrentNonObservable3, readObserver3);
                    gapComposer.updateRememberedValue(currentState3);
                    objM3 = currentState3;
                } catch (Throwable th3) {
                    Lock.restoreNonObservable(currentThreadSnapshot3, snapshotMakeCurrentNonObservable3, readObserver3);
                    throw th3;
                }
            }
            z2 = false;
            gapComposer.end(false);
        }
        gapComposer.startReplaceGroup(-2038357105);
        Color colorM5 = Fragment$5$$ExternalSyntheticOutline0.m(gapComposer, z2, ((ColorScheme) objM3).error);
        boolean z14 = (i5 > 4 && gapComposer.changed(transitionInstance)) || (i3 & 6) == 4;
        Object objRememberedValue8 = gapComposer.rememberedValue();
        if (z14 || objRememberedValue8 == neverEqualPolicy) {
            objRememberedValue8 = SnapshotStateKt__DerivedStateKt.derivedStateOf(new ColorSchemeKt$animateFixedColors$$inlined$animateColor$1(transitionInstance, (byte) 4));
            gapComposer.updateRememberedValue(objRememberedValue8);
        }
        ColorScheme colorScheme6 = (ColorScheme) ((State) objRememberedValue8).getValue();
        gapComposer.startReplaceGroup(-2038357105);
        Color colorM6 = Fragment$5$$ExternalSyntheticOutline0.m(gapComposer, false, colorScheme6.error);
        boolean z15 = (i5 > 4 && gapComposer.changed(transitionInstance)) || (i3 & 6) == 4;
        Object objRememberedValue9 = gapComposer.rememberedValue();
        if (z15 || objRememberedValue9 == neverEqualPolicy) {
            objRememberedValue9 = SnapshotStateKt__DerivedStateKt.derivedStateOf(new ColorSchemeKt$animateFixedColors$$inlined$animateColor$1(transitionInstance, (byte) 5));
            gapComposer.updateRememberedValue(objRememberedValue9);
        }
        Transition.TransitionAnimationState transitionAnimationStateCreateTransitionAnimation3 = ArcSplineKt.createTransitionAnimation(transitionInstance, colorM5, colorM6, (FiniteAnimationSpec) function3.invoke(((State) objRememberedValue9).getValue(), gapComposer, Integer.valueOf(i6)), twoWayConverterImpl3, gapComposer, i7);
        ColorScheme colorScheme7 = (ColorScheme) parcelableSnapshotMutableState.getValue();
        gapComposer.startReplaceGroup(-1401473906);
        long j4 = colorScheme7.onError;
        gapComposer.end(false);
        ColorSpace colorSpaceM483getColorSpaceimpl4 = Color.m483getColorSpaceimpl(j4);
        boolean zChanged4 = gapComposer.changed(colorSpaceM483getColorSpaceimpl4);
        Object objRememberedValue10 = gapComposer.rememberedValue();
        if (zChanged4 || objRememberedValue10 == neverEqualPolicy) {
            objRememberedValue10 = IntIntPair$$ExternalSyntheticOutline0.m(colorVectorConverterKt$ColorToVector$1$1, new CallsKt$await$2$1((byte) 1, colorSpaceM483getColorSpaceimpl4), gapComposer);
        }
        TwoWayConverterImpl twoWayConverterImpl4 = (TwoWayConverterImpl) objRememberedValue10;
        if (transitionInstance.isSeeking()) {
            twoWayConverterImpl4 = twoWayConverterImpl4;
            z3 = false;
            objM4 = IntIntPair$$ExternalSyntheticOutline0.m(gapComposer, 1666827533, false, tagPayloadReader);
        } else {
            gapComposer.startReplaceGroup(1666573488);
            boolean z16 = (i5 > 4 && gapComposer.changed(transitionInstance)) || (i3 & 6) == 4;
            objM4 = gapComposer.rememberedValue();
            if (z16 || objM4 == neverEqualPolicy) {
                Snapshot currentThreadSnapshot4 = Lock.getCurrentThreadSnapshot();
                Function1 readObserver4 = currentThreadSnapshot4 != null ? currentThreadSnapshot4.getReadObserver() : null;
                Snapshot snapshotMakeCurrentNonObservable4 = Lock.makeCurrentNonObservable(currentThreadSnapshot4);
                try {
                    Object currentState4 = tagPayloadReader.getCurrentState();
                    Lock.restoreNonObservable(currentThreadSnapshot4, snapshotMakeCurrentNonObservable4, readObserver4);
                    gapComposer.updateRememberedValue(currentState4);
                    objM4 = currentState4;
                } catch (Throwable th4) {
                    Lock.restoreNonObservable(currentThreadSnapshot4, snapshotMakeCurrentNonObservable4, readObserver4);
                    throw th4;
                }
            }
            z3 = false;
            gapComposer.end(false);
        }
        gapComposer.startReplaceGroup(-1401473906);
        Color colorM7 = Fragment$5$$ExternalSyntheticOutline0.m(gapComposer, z3, ((ColorScheme) objM4).onError);
        boolean z17 = (i5 > 4 && gapComposer.changed(transitionInstance)) || (i3 & 6) == 4;
        Object objRememberedValue11 = gapComposer.rememberedValue();
        if (z17 || objRememberedValue11 == neverEqualPolicy) {
            objRememberedValue11 = SnapshotStateKt__DerivedStateKt.derivedStateOf(new ColorSchemeKt$animateFixedColors$$inlined$animateColor$1(transitionInstance, (byte) 6));
            gapComposer.updateRememberedValue(objRememberedValue11);
        }
        ColorScheme colorScheme8 = (ColorScheme) ((State) objRememberedValue11).getValue();
        gapComposer.startReplaceGroup(-1401473906);
        Color colorM8 = Fragment$5$$ExternalSyntheticOutline0.m(gapComposer, false, colorScheme8.onError);
        boolean z18 = (i5 > 4 && gapComposer.changed(transitionInstance)) || (i3 & 6) == 4;
        Object objRememberedValue12 = gapComposer.rememberedValue();
        if (z18 || objRememberedValue12 == neverEqualPolicy) {
            objRememberedValue12 = SnapshotStateKt__DerivedStateKt.derivedStateOf(new ColorSchemeKt$animateFixedColors$$inlined$animateColor$1(transitionInstance, (byte) 7));
            gapComposer.updateRememberedValue(objRememberedValue12);
        }
        Transition.TransitionAnimationState transitionAnimationStateCreateTransitionAnimation4 = ArcSplineKt.createTransitionAnimation(transitionInstance, colorM7, colorM8, (FiniteAnimationSpec) function3.invoke(((State) objRememberedValue12).getValue(), gapComposer, Integer.valueOf(i6)), twoWayConverterImpl4, gapComposer, i7);
        ColorScheme colorScheme9 = (ColorScheme) parcelableSnapshotMutableState.getValue();
        gapComposer.startReplaceGroup(1510356562);
        long j5 = colorScheme9.errorContainer;
        gapComposer.end(false);
        ColorSpace colorSpaceM483getColorSpaceimpl5 = Color.m483getColorSpaceimpl(j5);
        boolean zChanged5 = gapComposer.changed(colorSpaceM483getColorSpaceimpl5);
        Object objRememberedValue13 = gapComposer.rememberedValue();
        if (zChanged5 || objRememberedValue13 == neverEqualPolicy) {
            objRememberedValue13 = IntIntPair$$ExternalSyntheticOutline0.m(colorVectorConverterKt$ColorToVector$1$1, new CallsKt$await$2$1((byte) 1, colorSpaceM483getColorSpaceimpl5), gapComposer);
        }
        TwoWayConverterImpl twoWayConverterImpl5 = (TwoWayConverterImpl) objRememberedValue13;
        if (transitionInstance.isSeeking()) {
            twoWayConverterImpl5 = twoWayConverterImpl5;
            z4 = false;
            objM5 = IntIntPair$$ExternalSyntheticOutline0.m(gapComposer, 1666827533, false, tagPayloadReader);
        } else {
            gapComposer.startReplaceGroup(1666573488);
            boolean z19 = (i5 > 4 && gapComposer.changed(transitionInstance)) || (i3 & 6) == 4;
            objM5 = gapComposer.rememberedValue();
            if (z19 || objM5 == neverEqualPolicy) {
                Snapshot currentThreadSnapshot5 = Lock.getCurrentThreadSnapshot();
                Function1 readObserver5 = currentThreadSnapshot5 != null ? currentThreadSnapshot5.getReadObserver() : null;
                Snapshot snapshotMakeCurrentNonObservable5 = Lock.makeCurrentNonObservable(currentThreadSnapshot5);
                try {
                    Object currentState5 = tagPayloadReader.getCurrentState();
                    Lock.restoreNonObservable(currentThreadSnapshot5, snapshotMakeCurrentNonObservable5, readObserver5);
                    gapComposer.updateRememberedValue(currentState5);
                    objM5 = currentState5;
                } catch (Throwable th5) {
                    Lock.restoreNonObservable(currentThreadSnapshot5, snapshotMakeCurrentNonObservable5, readObserver5);
                    throw th5;
                }
            }
            z4 = false;
            gapComposer.end(false);
        }
        gapComposer.startReplaceGroup(1510356562);
        Color colorM9 = Fragment$5$$ExternalSyntheticOutline0.m(gapComposer, z4, ((ColorScheme) objM5).errorContainer);
        boolean z20 = (i5 > 4 && gapComposer.changed(transitionInstance)) || (i3 & 6) == 4;
        Object objRememberedValue14 = gapComposer.rememberedValue();
        if (z20 || objRememberedValue14 == neverEqualPolicy) {
            objRememberedValue14 = SnapshotStateKt__DerivedStateKt.derivedStateOf(new ColorSchemeKt$animateFixedColors$$inlined$animateColor$1(transitionInstance, (byte) 8));
            gapComposer.updateRememberedValue(objRememberedValue14);
        }
        ColorScheme colorScheme10 = (ColorScheme) ((State) objRememberedValue14).getValue();
        gapComposer.startReplaceGroup(1510356562);
        Color colorM10 = Fragment$5$$ExternalSyntheticOutline0.m(gapComposer, false, colorScheme10.errorContainer);
        boolean z21 = (i5 > 4 && gapComposer.changed(transitionInstance)) || (i3 & 6) == 4;
        Object objRememberedValue15 = gapComposer.rememberedValue();
        if (z21 || objRememberedValue15 == neverEqualPolicy) {
            objRememberedValue15 = SnapshotStateKt__DerivedStateKt.derivedStateOf(new ListItemKt$InteractiveListItem$$inlined$animateColor$1(transitionInstance, (byte) 26));
            gapComposer.updateRememberedValue(objRememberedValue15);
        }
        Transition.TransitionAnimationState transitionAnimationStateCreateTransitionAnimation5 = ArcSplineKt.createTransitionAnimation(transitionInstance, colorM9, colorM10, (FiniteAnimationSpec) function3.invoke(((State) objRememberedValue15).getValue(), gapComposer, Integer.valueOf(i6)), twoWayConverterImpl5, gapComposer, i7);
        ColorScheme colorScheme11 = (ColorScheme) parcelableSnapshotMutableState.getValue();
        gapComposer.startReplaceGroup(1963578419);
        long j6 = colorScheme11.onErrorContainer;
        gapComposer.end(false);
        ColorSpace colorSpaceM483getColorSpaceimpl6 = Color.m483getColorSpaceimpl(j6);
        boolean zChanged6 = gapComposer.changed(colorSpaceM483getColorSpaceimpl6);
        Object objRememberedValue16 = gapComposer.rememberedValue();
        if (zChanged6 || objRememberedValue16 == neverEqualPolicy) {
            z5 = true;
            objM6 = IntIntPair$$ExternalSyntheticOutline0.m(colorVectorConverterKt$ColorToVector$1$1, new CallsKt$await$2$1((byte) 1, colorSpaceM483getColorSpaceimpl6), gapComposer);
        } else {
            objM6 = objRememberedValue16;
            z5 = true;
        }
        TwoWayConverterImpl twoWayConverterImpl6 = (TwoWayConverterImpl) objM6;
        if (transitionInstance.isSeeking()) {
            z6 = false;
            objM7 = IntIntPair$$ExternalSyntheticOutline0.m(gapComposer, 1666827533, false, tagPayloadReader);
        } else {
            gapComposer.startReplaceGroup(1666573488);
            boolean z22 = ((i5 <= 4 || !gapComposer.changed(transitionInstance)) && (i3 & 6) != 4) ? false : z5;
            Object objRememberedValue17 = gapComposer.rememberedValue();
            if (z22 || objRememberedValue17 == neverEqualPolicy) {
                Snapshot currentThreadSnapshot6 = Lock.getCurrentThreadSnapshot();
                Function1 readObserver6 = currentThreadSnapshot6 != null ? currentThreadSnapshot6.getReadObserver() : null;
                Snapshot snapshotMakeCurrentNonObservable6 = Lock.makeCurrentNonObservable(currentThreadSnapshot6);
                try {
                    Object currentState6 = tagPayloadReader.getCurrentState();
                    Lock.restoreNonObservable(currentThreadSnapshot6, snapshotMakeCurrentNonObservable6, readObserver6);
                    gapComposer.updateRememberedValue(currentState6);
                    objRememberedValue17 = currentState6;
                } catch (Throwable th6) {
                    Lock.restoreNonObservable(currentThreadSnapshot6, snapshotMakeCurrentNonObservable6, readObserver6);
                    throw th6;
                }
            }
            gapComposer.end(false);
            objM7 = objRememberedValue17;
            z6 = false;
        }
        gapComposer.startReplaceGroup(1963578419);
        Color colorM11 = Fragment$5$$ExternalSyntheticOutline0.m(gapComposer, z6, ((ColorScheme) objM7).onErrorContainer);
        boolean z23 = ((i5 <= 4 || !gapComposer.changed(transitionInstance)) && (i3 & 6) != 4) ? false : z5;
        Object objRememberedValue18 = gapComposer.rememberedValue();
        if (z23 || objRememberedValue18 == neverEqualPolicy) {
            objRememberedValue18 = SnapshotStateKt__DerivedStateKt.derivedStateOf(new ListItemKt$InteractiveListItem$$inlined$animateColor$1(transitionInstance, (byte) 27));
            gapComposer.updateRememberedValue(objRememberedValue18);
        }
        ColorScheme colorScheme12 = (ColorScheme) ((State) objRememberedValue18).getValue();
        gapComposer.startReplaceGroup(1963578419);
        Color colorM12 = Fragment$5$$ExternalSyntheticOutline0.m(gapComposer, false, colorScheme12.onErrorContainer);
        boolean z24 = ((i5 > 4 && gapComposer.changed(transitionInstance)) || (6 & i3) == 4) ? z5 : false;
        Object objRememberedValue19 = gapComposer.rememberedValue();
        if (z24 || objRememberedValue19 == neverEqualPolicy) {
            objRememberedValue19 = SnapshotStateKt__DerivedStateKt.derivedStateOf(new ListItemKt$InteractiveListItem$$inlined$animateColor$1(transitionInstance, (byte) 28));
            gapComposer.updateRememberedValue(objRememberedValue19);
        }
        Transition.TransitionAnimationState transitionAnimationStateCreateTransitionAnimation6 = ArcSplineKt.createTransitionAnimation(transitionInstance, colorM11, colorM12, (FiniteAnimationSpec) function3.invoke(((State) objRememberedValue19).getValue(), gapComposer, Integer.valueOf(i6)), twoWayConverterImpl6, gapComposer, i7);
        Color color = (Color) transitionAnimationStateCreateTransitionAnimation.getValue();
        long j7 = color.value;
        Color color2 = (Color) transitionAnimationStateCreateTransitionAnimation2.getValue();
        long j8 = color2.value;
        Color color3 = (Color) transitionAnimationStateCreateTransitionAnimation3.getValue();
        long j9 = color3.value;
        Color color4 = (Color) transitionAnimationStateCreateTransitionAnimation4.getValue();
        long j10 = color4.value;
        Color color5 = (Color) transitionAnimationStateCreateTransitionAnimation5.getValue();
        long j11 = color5.value;
        Color color6 = (Color) transitionAnimationStateCreateTransitionAnimation6.getValue();
        long j12 = color6.value;
        return CollectionsKt__IterablesKt.listOf((Object[]) new Color[]{color, color2, color3, color4, color5, color6});
    }

    public static final ColorScheme animateColorScheme(ColorScheme colorScheme, Function3 function3, String str, Composer composer, int i, int i2) {
        Object objM;
        ColorVectorConverterKt$ColorToVector$1$1 colorVectorConverterKt$ColorToVector$1$1;
        Object objM2;
        boolean z;
        Object objM3;
        boolean z2;
        Object objM4;
        boolean z3;
        Object objM5;
        boolean z4;
        Object objM6;
        boolean z5;
        Object objM7;
        boolean z6;
        Object objM8;
        boolean z7;
        Object objM9;
        colorScheme.getClass();
        Function3 mainActivity$$ExternalSyntheticLambda44 = (i2 & 2) != 0 ? new MainActivity$$ExternalSyntheticLambda44((byte) 7) : function3;
        TransitionInstance transitionInstanceUpdateTransition = ArcSplineKt.updateTransition(colorScheme, (i2 & 4) != 0 ? "ColorSchemeAnimation" : str, composer, (i & 14) | ((i >> 3) & 112), 0);
        ParcelableSnapshotMutableState parcelableSnapshotMutableState = transitionInstanceUpdateTransition.targetState$delegate;
        TagPayloadReader tagPayloadReader = transitionInstanceUpdateTransition.transitionState;
        int i3 = i & 112;
        int i4 = 384 | i3;
        ColorScheme colorScheme2 = (ColorScheme) parcelableSnapshotMutableState.getValue();
        GapComposer gapComposer = (GapComposer) composer;
        gapComposer.startReplaceGroup(999586274);
        long j = colorScheme2.primary;
        gapComposer.end(false);
        ColorSpace colorSpaceM483getColorSpaceimpl = Color.m483getColorSpaceimpl(j);
        boolean zChanged = gapComposer.changed(colorSpaceM483getColorSpaceimpl);
        Object objRememberedValue = gapComposer.rememberedValue();
        ColorVectorConverterKt$ColorToVector$1$1 colorVectorConverterKt$ColorToVector$1$2 = ColorVectorConverterKt$ColorToVector$1$1.INSTANCE;
        NeverEqualPolicy neverEqualPolicy = Composer.Companion.Empty;
        if (zChanged || objRememberedValue == neverEqualPolicy) {
            objRememberedValue = IntIntPair$$ExternalSyntheticOutline0.m(colorVectorConverterKt$ColorToVector$1$2, new CallsKt$await$2$1((byte) 1, colorSpaceM483getColorSpaceimpl), gapComposer);
        }
        TwoWayConverterImpl twoWayConverterImpl = (TwoWayConverterImpl) objRememberedValue;
        int i5 = ((i4 << 3) & 896) | 3072;
        if (transitionInstanceUpdateTransition.isSeeking()) {
            objM = IntIntPair$$ExternalSyntheticOutline0.m(gapComposer, 1666827533, false, tagPayloadReader);
        } else {
            gapComposer.startReplaceGroup(1666573488);
            boolean zChanged2 = gapComposer.changed(transitionInstanceUpdateTransition);
            objM = gapComposer.rememberedValue();
            if (zChanged2 || objM == neverEqualPolicy) {
                Snapshot currentThreadSnapshot = Lock.getCurrentThreadSnapshot();
                Function1 readObserver = currentThreadSnapshot != null ? currentThreadSnapshot.getReadObserver() : null;
                Snapshot snapshotMakeCurrentNonObservable = Lock.makeCurrentNonObservable(currentThreadSnapshot);
                try {
                    Object currentState = tagPayloadReader.getCurrentState();
                    Lock.restoreNonObservable(currentThreadSnapshot, snapshotMakeCurrentNonObservable, readObserver);
                    gapComposer.updateRememberedValue(currentState);
                    objM = currentState;
                } catch (Throwable th) {
                    Lock.restoreNonObservable(currentThreadSnapshot, snapshotMakeCurrentNonObservable, readObserver);
                    throw th;
                }
            }
            gapComposer.end(false);
        }
        gapComposer.startReplaceGroup(999586274);
        Color colorM = Fragment$5$$ExternalSyntheticOutline0.m(gapComposer, false, ((ColorScheme) objM).primary);
        boolean zChanged3 = gapComposer.changed(transitionInstanceUpdateTransition);
        Object objRememberedValue2 = gapComposer.rememberedValue();
        if (zChanged3 || objRememberedValue2 == neverEqualPolicy) {
            objRememberedValue2 = SnapshotStateKt__DerivedStateKt.derivedStateOf(new ColorSchemeKt$animateFixedColors$$inlined$animateColor$8(transitionInstanceUpdateTransition, (byte) 3));
            gapComposer.updateRememberedValue(objRememberedValue2);
        }
        ColorScheme colorScheme3 = (ColorScheme) ((State) objRememberedValue2).getValue();
        gapComposer.startReplaceGroup(999586274);
        Color colorM2 = Fragment$5$$ExternalSyntheticOutline0.m(gapComposer, false, colorScheme3.primary);
        boolean zChanged4 = gapComposer.changed(transitionInstanceUpdateTransition);
        Object objRememberedValue3 = gapComposer.rememberedValue();
        if (zChanged4 || objRememberedValue3 == neverEqualPolicy) {
            objRememberedValue3 = SnapshotStateKt__DerivedStateKt.derivedStateOf(new ColorSchemeKt$animateFixedColors$$inlined$animateColor$8(transitionInstanceUpdateTransition, (byte) 4));
            gapComposer.updateRememberedValue(objRememberedValue3);
        }
        int i6 = (i5 >> 3) & 112;
        Transition.TransitionAnimationState transitionAnimationStateCreateTransitionAnimation = ArcSplineKt.createTransitionAnimation(transitionInstanceUpdateTransition, colorM, colorM2, (FiniteAnimationSpec) mainActivity$$ExternalSyntheticLambda44.invoke(((State) objRememberedValue3).getValue(), gapComposer, Integer.valueOf(i6)), twoWayConverterImpl, gapComposer, 196608);
        ColorScheme colorScheme4 = (ColorScheme) parcelableSnapshotMutableState.getValue();
        gapComposer.startReplaceGroup(-543523325);
        long j2 = colorScheme4.onPrimary;
        gapComposer.end(false);
        ColorSpace colorSpaceM483getColorSpaceimpl2 = Color.m483getColorSpaceimpl(j2);
        boolean zChanged5 = gapComposer.changed(colorSpaceM483getColorSpaceimpl2);
        Object objRememberedValue4 = gapComposer.rememberedValue();
        if (zChanged5 || objRememberedValue4 == neverEqualPolicy) {
            CallsKt$await$2$1 callsKt$await$2$1 = new CallsKt$await$2$1((byte) 1, colorSpaceM483getColorSpaceimpl2);
            colorVectorConverterKt$ColorToVector$1$1 = colorVectorConverterKt$ColorToVector$1$2;
            objRememberedValue4 = IntIntPair$$ExternalSyntheticOutline0.m(colorVectorConverterKt$ColorToVector$1$1, callsKt$await$2$1, gapComposer);
        } else {
            colorVectorConverterKt$ColorToVector$1$1 = colorVectorConverterKt$ColorToVector$1$2;
        }
        TwoWayConverterImpl twoWayConverterImpl2 = (TwoWayConverterImpl) objRememberedValue4;
        if (transitionInstanceUpdateTransition.isSeeking()) {
            objM2 = IntIntPair$$ExternalSyntheticOutline0.m(gapComposer, 1666827533, false, tagPayloadReader);
        } else {
            gapComposer.startReplaceGroup(1666573488);
            boolean zChanged6 = gapComposer.changed(transitionInstanceUpdateTransition);
            objM2 = gapComposer.rememberedValue();
            if (zChanged6 || objM2 == neverEqualPolicy) {
                Snapshot currentThreadSnapshot2 = Lock.getCurrentThreadSnapshot();
                Function1 readObserver2 = currentThreadSnapshot2 != null ? currentThreadSnapshot2.getReadObserver() : null;
                Snapshot snapshotMakeCurrentNonObservable2 = Lock.makeCurrentNonObservable(currentThreadSnapshot2);
                try {
                    Object currentState2 = tagPayloadReader.getCurrentState();
                    Lock.restoreNonObservable(currentThreadSnapshot2, snapshotMakeCurrentNonObservable2, readObserver2);
                    gapComposer.updateRememberedValue(currentState2);
                    objM2 = currentState2;
                } catch (Throwable th2) {
                    Lock.restoreNonObservable(currentThreadSnapshot2, snapshotMakeCurrentNonObservable2, readObserver2);
                    throw th2;
                }
            }
            gapComposer.end(false);
        }
        gapComposer.startReplaceGroup(-543523325);
        Color colorM3 = Fragment$5$$ExternalSyntheticOutline0.m(gapComposer, false, ((ColorScheme) objM2).onPrimary);
        boolean zChanged7 = gapComposer.changed(transitionInstanceUpdateTransition);
        Object objRememberedValue5 = gapComposer.rememberedValue();
        if (zChanged7 || objRememberedValue5 == neverEqualPolicy) {
            objRememberedValue5 = SnapshotStateKt__DerivedStateKt.derivedStateOf(new ColorSchemeKt$animateFixedColors$$inlined$animateColor$8(transitionInstanceUpdateTransition, (byte) 5));
            gapComposer.updateRememberedValue(objRememberedValue5);
        }
        ColorScheme colorScheme5 = (ColorScheme) ((State) objRememberedValue5).getValue();
        gapComposer.startReplaceGroup(-543523325);
        Color colorM4 = Fragment$5$$ExternalSyntheticOutline0.m(gapComposer, false, colorScheme5.onPrimary);
        boolean zChanged8 = gapComposer.changed(transitionInstanceUpdateTransition);
        Object objRememberedValue6 = gapComposer.rememberedValue();
        if (zChanged8 || objRememberedValue6 == neverEqualPolicy) {
            objRememberedValue6 = SnapshotStateKt__DerivedStateKt.derivedStateOf(new ColorSchemeKt$animateFixedColors$$inlined$animateColor$8(transitionInstanceUpdateTransition, (byte) 6));
            gapComposer.updateRememberedValue(objRememberedValue6);
        }
        ColorVectorConverterKt$ColorToVector$1$1 colorVectorConverterKt$ColorToVector$1$3 = colorVectorConverterKt$ColorToVector$1$1;
        Transition.TransitionAnimationState transitionAnimationStateCreateTransitionAnimation2 = ArcSplineKt.createTransitionAnimation(transitionInstanceUpdateTransition, colorM3, colorM4, (FiniteAnimationSpec) mainActivity$$ExternalSyntheticLambda44.invoke(((State) objRememberedValue6).getValue(), gapComposer, Integer.valueOf(i6)), twoWayConverterImpl2, gapComposer, 196608);
        ColorScheme colorScheme6 = (ColorScheme) parcelableSnapshotMutableState.getValue();
        gapComposer.startReplaceGroup(-158641333);
        long j3 = colorScheme6.primaryContainer;
        gapComposer.end(false);
        ColorSpace colorSpaceM483getColorSpaceimpl3 = Color.m483getColorSpaceimpl(j3);
        boolean zChanged9 = gapComposer.changed(colorSpaceM483getColorSpaceimpl3);
        Object objRememberedValue7 = gapComposer.rememberedValue();
        if (zChanged9 || objRememberedValue7 == neverEqualPolicy) {
            objRememberedValue7 = IntIntPair$$ExternalSyntheticOutline0.m(colorVectorConverterKt$ColorToVector$1$3, new CallsKt$await$2$1((byte) 1, colorSpaceM483getColorSpaceimpl3), gapComposer);
        }
        TwoWayConverterImpl twoWayConverterImpl3 = (TwoWayConverterImpl) objRememberedValue7;
        if (transitionInstanceUpdateTransition.isSeeking()) {
            z = false;
            objM3 = IntIntPair$$ExternalSyntheticOutline0.m(gapComposer, 1666827533, false, tagPayloadReader);
        } else {
            gapComposer.startReplaceGroup(1666573488);
            boolean zChanged10 = gapComposer.changed(transitionInstanceUpdateTransition);
            objM3 = gapComposer.rememberedValue();
            if (zChanged10 || objM3 == neverEqualPolicy) {
                Snapshot currentThreadSnapshot3 = Lock.getCurrentThreadSnapshot();
                Function1 readObserver3 = currentThreadSnapshot3 != null ? currentThreadSnapshot3.getReadObserver() : null;
                Snapshot snapshotMakeCurrentNonObservable3 = Lock.makeCurrentNonObservable(currentThreadSnapshot3);
                try {
                    Object currentState3 = tagPayloadReader.getCurrentState();
                    Lock.restoreNonObservable(currentThreadSnapshot3, snapshotMakeCurrentNonObservable3, readObserver3);
                    gapComposer.updateRememberedValue(currentState3);
                    objM3 = currentState3;
                } catch (Throwable th3) {
                    Lock.restoreNonObservable(currentThreadSnapshot3, snapshotMakeCurrentNonObservable3, readObserver3);
                    throw th3;
                }
            }
            z = false;
            gapComposer.end(false);
        }
        gapComposer.startReplaceGroup(-158641333);
        Color colorM5 = Fragment$5$$ExternalSyntheticOutline0.m(gapComposer, z, ((ColorScheme) objM3).primaryContainer);
        boolean zChanged11 = gapComposer.changed(transitionInstanceUpdateTransition);
        Object objRememberedValue8 = gapComposer.rememberedValue();
        if (zChanged11 || objRememberedValue8 == neverEqualPolicy) {
            objRememberedValue8 = SnapshotStateKt__DerivedStateKt.derivedStateOf(new ColorSchemeKt$animateFixedColors$$inlined$animateColor$8(transitionInstanceUpdateTransition, (byte) 7));
            gapComposer.updateRememberedValue(objRememberedValue8);
        }
        ColorScheme colorScheme7 = (ColorScheme) ((State) objRememberedValue8).getValue();
        gapComposer.startReplaceGroup(-158641333);
        Color colorM6 = Fragment$5$$ExternalSyntheticOutline0.m(gapComposer, false, colorScheme7.primaryContainer);
        boolean zChanged12 = gapComposer.changed(transitionInstanceUpdateTransition);
        Object objRememberedValue9 = gapComposer.rememberedValue();
        if (zChanged12 || objRememberedValue9 == neverEqualPolicy) {
            objRememberedValue9 = SnapshotStateKt__DerivedStateKt.derivedStateOf(new ColorSchemeKt$animateFixedColors$$inlined$animateColor$8(transitionInstanceUpdateTransition, (byte) 8));
            gapComposer.updateRememberedValue(objRememberedValue9);
        }
        Transition.TransitionAnimationState transitionAnimationStateCreateTransitionAnimation3 = ArcSplineKt.createTransitionAnimation(transitionInstanceUpdateTransition, colorM5, colorM6, (FiniteAnimationSpec) mainActivity$$ExternalSyntheticLambda44.invoke(((State) objRememberedValue9).getValue(), gapComposer, Integer.valueOf(i6)), twoWayConverterImpl3, gapComposer, 196608);
        ColorScheme colorScheme8 = (ColorScheme) parcelableSnapshotMutableState.getValue();
        gapComposer.startReplaceGroup(478241866);
        long j4 = colorScheme8.onPrimaryContainer;
        gapComposer.end(false);
        ColorSpace colorSpaceM483getColorSpaceimpl4 = Color.m483getColorSpaceimpl(j4);
        boolean zChanged13 = gapComposer.changed(colorSpaceM483getColorSpaceimpl4);
        Object objRememberedValue10 = gapComposer.rememberedValue();
        if (zChanged13 || objRememberedValue10 == neverEqualPolicy) {
            objRememberedValue10 = IntIntPair$$ExternalSyntheticOutline0.m(colorVectorConverterKt$ColorToVector$1$3, new CallsKt$await$2$1((byte) 1, colorSpaceM483getColorSpaceimpl4), gapComposer);
        }
        TwoWayConverterImpl twoWayConverterImpl4 = (TwoWayConverterImpl) objRememberedValue10;
        if (transitionInstanceUpdateTransition.isSeeking()) {
            z2 = false;
            objM4 = IntIntPair$$ExternalSyntheticOutline0.m(gapComposer, 1666827533, false, tagPayloadReader);
        } else {
            gapComposer.startReplaceGroup(1666573488);
            boolean zChanged14 = gapComposer.changed(transitionInstanceUpdateTransition);
            objM4 = gapComposer.rememberedValue();
            if (zChanged14 || objM4 == neverEqualPolicy) {
                Snapshot currentThreadSnapshot4 = Lock.getCurrentThreadSnapshot();
                Function1 readObserver4 = currentThreadSnapshot4 != null ? currentThreadSnapshot4.getReadObserver() : null;
                Snapshot snapshotMakeCurrentNonObservable4 = Lock.makeCurrentNonObservable(currentThreadSnapshot4);
                try {
                    Object currentState4 = tagPayloadReader.getCurrentState();
                    Lock.restoreNonObservable(currentThreadSnapshot4, snapshotMakeCurrentNonObservable4, readObserver4);
                    gapComposer.updateRememberedValue(currentState4);
                    objM4 = currentState4;
                } catch (Throwable th4) {
                    Lock.restoreNonObservable(currentThreadSnapshot4, snapshotMakeCurrentNonObservable4, readObserver4);
                    throw th4;
                }
            }
            z2 = false;
            gapComposer.end(false);
        }
        gapComposer.startReplaceGroup(478241866);
        Color colorM7 = Fragment$5$$ExternalSyntheticOutline0.m(gapComposer, z2, ((ColorScheme) objM4).onPrimaryContainer);
        boolean zChanged15 = gapComposer.changed(transitionInstanceUpdateTransition);
        Object objRememberedValue11 = gapComposer.rememberedValue();
        if (zChanged15 || objRememberedValue11 == neverEqualPolicy) {
            objRememberedValue11 = SnapshotStateKt__DerivedStateKt.derivedStateOf(new ColorSchemeKt$animateFixedColors$$inlined$animateColor$8(transitionInstanceUpdateTransition, (byte) 9));
            gapComposer.updateRememberedValue(objRememberedValue11);
        }
        ColorScheme colorScheme9 = (ColorScheme) ((State) objRememberedValue11).getValue();
        gapComposer.startReplaceGroup(478241866);
        Color colorM8 = Fragment$5$$ExternalSyntheticOutline0.m(gapComposer, false, colorScheme9.onPrimaryContainer);
        boolean zChanged16 = gapComposer.changed(transitionInstanceUpdateTransition);
        Object objRememberedValue12 = gapComposer.rememberedValue();
        if (zChanged16 || objRememberedValue12 == neverEqualPolicy) {
            objRememberedValue12 = SnapshotStateKt__DerivedStateKt.derivedStateOf(new ColorSchemeKt$animateFixedColors$$inlined$animateColor$8(transitionInstanceUpdateTransition, (byte) 10));
            gapComposer.updateRememberedValue(objRememberedValue12);
        }
        Transition.TransitionAnimationState transitionAnimationStateCreateTransitionAnimation4 = ArcSplineKt.createTransitionAnimation(transitionInstanceUpdateTransition, colorM7, colorM8, (FiniteAnimationSpec) mainActivity$$ExternalSyntheticLambda44.invoke(((State) objRememberedValue12).getValue(), gapComposer, Integer.valueOf(i6)), twoWayConverterImpl4, gapComposer, 196608);
        ColorScheme colorScheme10 = (ColorScheme) parcelableSnapshotMutableState.getValue();
        gapComposer.startReplaceGroup(-314960546);
        long j5 = colorScheme10.inversePrimary;
        gapComposer.end(false);
        ColorSpace colorSpaceM483getColorSpaceimpl5 = Color.m483getColorSpaceimpl(j5);
        boolean zChanged17 = gapComposer.changed(colorSpaceM483getColorSpaceimpl5);
        Object objRememberedValue13 = gapComposer.rememberedValue();
        if (zChanged17 || objRememberedValue13 == neverEqualPolicy) {
            objRememberedValue13 = IntIntPair$$ExternalSyntheticOutline0.m(colorVectorConverterKt$ColorToVector$1$3, new CallsKt$await$2$1((byte) 1, colorSpaceM483getColorSpaceimpl5), gapComposer);
        }
        TwoWayConverterImpl twoWayConverterImpl5 = (TwoWayConverterImpl) objRememberedValue13;
        if (transitionInstanceUpdateTransition.isSeeking()) {
            z3 = false;
            objM5 = IntIntPair$$ExternalSyntheticOutline0.m(gapComposer, 1666827533, false, tagPayloadReader);
        } else {
            gapComposer.startReplaceGroup(1666573488);
            boolean zChanged18 = gapComposer.changed(transitionInstanceUpdateTransition);
            objM5 = gapComposer.rememberedValue();
            if (zChanged18 || objM5 == neverEqualPolicy) {
                Snapshot currentThreadSnapshot5 = Lock.getCurrentThreadSnapshot();
                Function1 readObserver5 = currentThreadSnapshot5 != null ? currentThreadSnapshot5.getReadObserver() : null;
                Snapshot snapshotMakeCurrentNonObservable5 = Lock.makeCurrentNonObservable(currentThreadSnapshot5);
                try {
                    Object currentState5 = tagPayloadReader.getCurrentState();
                    Lock.restoreNonObservable(currentThreadSnapshot5, snapshotMakeCurrentNonObservable5, readObserver5);
                    gapComposer.updateRememberedValue(currentState5);
                    objM5 = currentState5;
                } catch (Throwable th5) {
                    Lock.restoreNonObservable(currentThreadSnapshot5, snapshotMakeCurrentNonObservable5, readObserver5);
                    throw th5;
                }
            }
            z3 = false;
            gapComposer.end(false);
        }
        gapComposer.startReplaceGroup(-314960546);
        Color colorM9 = Fragment$5$$ExternalSyntheticOutline0.m(gapComposer, z3, ((ColorScheme) objM5).inversePrimary);
        boolean zChanged19 = gapComposer.changed(transitionInstanceUpdateTransition);
        Object objRememberedValue14 = gapComposer.rememberedValue();
        if (zChanged19 || objRememberedValue14 == neverEqualPolicy) {
            objRememberedValue14 = SnapshotStateKt__DerivedStateKt.derivedStateOf(new ColorSchemeKt$animateFixedColors$$inlined$animateColor$8(transitionInstanceUpdateTransition, (byte) 11));
            gapComposer.updateRememberedValue(objRememberedValue14);
        }
        ColorScheme colorScheme11 = (ColorScheme) ((State) objRememberedValue14).getValue();
        gapComposer.startReplaceGroup(-314960546);
        Color colorM10 = Fragment$5$$ExternalSyntheticOutline0.m(gapComposer, false, colorScheme11.inversePrimary);
        boolean zChanged20 = gapComposer.changed(transitionInstanceUpdateTransition);
        Object objRememberedValue15 = gapComposer.rememberedValue();
        if (zChanged20 || objRememberedValue15 == neverEqualPolicy) {
            objRememberedValue15 = SnapshotStateKt__DerivedStateKt.derivedStateOf(new ColorSchemeKt$animateFixedColors$$inlined$animateColor$8(transitionInstanceUpdateTransition, (byte) 2));
            gapComposer.updateRememberedValue(objRememberedValue15);
        }
        Transition.TransitionAnimationState transitionAnimationStateCreateTransitionAnimation5 = ArcSplineKt.createTransitionAnimation(transitionInstanceUpdateTransition, colorM9, colorM10, (FiniteAnimationSpec) mainActivity$$ExternalSyntheticLambda44.invoke(((State) objRememberedValue15).getValue(), gapComposer, Integer.valueOf(i6)), twoWayConverterImpl5, gapComposer, 196608);
        Color color = (Color) transitionAnimationStateCreateTransitionAnimation.getValue();
        long j6 = color.value;
        Color color2 = (Color) transitionAnimationStateCreateTransitionAnimation2.getValue();
        long j7 = color2.value;
        Color color3 = (Color) transitionAnimationStateCreateTransitionAnimation3.getValue();
        long j8 = color3.value;
        Color color4 = (Color) transitionAnimationStateCreateTransitionAnimation4.getValue();
        long j9 = color4.value;
        Color color5 = (Color) transitionAnimationStateCreateTransitionAnimation5.getValue();
        long j10 = color5.value;
        List listListOf = CollectionsKt__IterablesKt.listOf((Object[]) new Color[]{color, color2, color3, color4, color5});
        ColorScheme colorScheme12 = (ColorScheme) parcelableSnapshotMutableState.getValue();
        gapComposer.startReplaceGroup(-864381662);
        long j11 = colorScheme12.secondary;
        gapComposer.end(false);
        ColorSpace colorSpaceM483getColorSpaceimpl6 = Color.m483getColorSpaceimpl(j11);
        boolean zChanged21 = gapComposer.changed(colorSpaceM483getColorSpaceimpl6);
        Object objRememberedValue16 = gapComposer.rememberedValue();
        if (zChanged21 || objRememberedValue16 == neverEqualPolicy) {
            objRememberedValue16 = IntIntPair$$ExternalSyntheticOutline0.m(colorVectorConverterKt$ColorToVector$1$3, new CallsKt$await$2$1((byte) 1, colorSpaceM483getColorSpaceimpl6), gapComposer);
        }
        TwoWayConverterImpl twoWayConverterImpl6 = (TwoWayConverterImpl) objRememberedValue16;
        if (transitionInstanceUpdateTransition.isSeeking()) {
            z4 = false;
            objM6 = IntIntPair$$ExternalSyntheticOutline0.m(gapComposer, 1666827533, false, tagPayloadReader);
        } else {
            gapComposer.startReplaceGroup(1666573488);
            boolean zChanged22 = gapComposer.changed(transitionInstanceUpdateTransition);
            objM6 = gapComposer.rememberedValue();
            if (zChanged22 || objM6 == neverEqualPolicy) {
                Snapshot currentThreadSnapshot6 = Lock.getCurrentThreadSnapshot();
                Function1 readObserver6 = currentThreadSnapshot6 != null ? currentThreadSnapshot6.getReadObserver() : null;
                Snapshot snapshotMakeCurrentNonObservable6 = Lock.makeCurrentNonObservable(currentThreadSnapshot6);
                try {
                    Object currentState6 = tagPayloadReader.getCurrentState();
                    Lock.restoreNonObservable(currentThreadSnapshot6, snapshotMakeCurrentNonObservable6, readObserver6);
                    gapComposer.updateRememberedValue(currentState6);
                    objM6 = currentState6;
                } catch (Throwable th6) {
                    Lock.restoreNonObservable(currentThreadSnapshot6, snapshotMakeCurrentNonObservable6, readObserver6);
                    throw th6;
                }
            }
            z4 = false;
            gapComposer.end(false);
        }
        gapComposer.startReplaceGroup(-864381662);
        Color colorM11 = Fragment$5$$ExternalSyntheticOutline0.m(gapComposer, z4, ((ColorScheme) objM6).secondary);
        boolean zChanged23 = gapComposer.changed(transitionInstanceUpdateTransition);
        Object objRememberedValue17 = gapComposer.rememberedValue();
        if (zChanged23 || objRememberedValue17 == neverEqualPolicy) {
            objRememberedValue17 = SnapshotStateKt__DerivedStateKt.derivedStateOf(new ColorSchemeKt$animateFixedColors$$inlined$animateColor$8(transitionInstanceUpdateTransition, (byte) 12));
            gapComposer.updateRememberedValue(objRememberedValue17);
        }
        ColorScheme colorScheme13 = (ColorScheme) ((State) objRememberedValue17).getValue();
        gapComposer.startReplaceGroup(-864381662);
        Color colorM12 = Fragment$5$$ExternalSyntheticOutline0.m(gapComposer, false, colorScheme13.secondary);
        boolean zChanged24 = gapComposer.changed(transitionInstanceUpdateTransition);
        Object objRememberedValue18 = gapComposer.rememberedValue();
        if (zChanged24 || objRememberedValue18 == neverEqualPolicy) {
            objRememberedValue18 = SnapshotStateKt__DerivedStateKt.derivedStateOf(new ColorSchemeKt$animateFixedColors$$inlined$animateColor$8(transitionInstanceUpdateTransition, (byte) 13));
            gapComposer.updateRememberedValue(objRememberedValue18);
        }
        Transition.TransitionAnimationState transitionAnimationStateCreateTransitionAnimation6 = ArcSplineKt.createTransitionAnimation(transitionInstanceUpdateTransition, colorM11, colorM12, (FiniteAnimationSpec) mainActivity$$ExternalSyntheticLambda44.invoke(((State) objRememberedValue18).getValue(), gapComposer, Integer.valueOf(i6)), twoWayConverterImpl6, gapComposer, 196608);
        ColorScheme colorScheme14 = (ColorScheme) parcelableSnapshotMutableState.getValue();
        gapComposer.startReplaceGroup(934256835);
        long j12 = colorScheme14.onSecondary;
        gapComposer.end(false);
        ColorSpace colorSpaceM483getColorSpaceimpl7 = Color.m483getColorSpaceimpl(j12);
        boolean zChanged25 = gapComposer.changed(colorSpaceM483getColorSpaceimpl7);
        Object objRememberedValue19 = gapComposer.rememberedValue();
        if (zChanged25 || objRememberedValue19 == neverEqualPolicy) {
            objRememberedValue19 = IntIntPair$$ExternalSyntheticOutline0.m(colorVectorConverterKt$ColorToVector$1$3, new CallsKt$await$2$1((byte) 1, colorSpaceM483getColorSpaceimpl7), gapComposer);
        }
        TwoWayConverterImpl twoWayConverterImpl7 = (TwoWayConverterImpl) objRememberedValue19;
        if (transitionInstanceUpdateTransition.isSeeking()) {
            z5 = false;
            objM7 = IntIntPair$$ExternalSyntheticOutline0.m(gapComposer, 1666827533, false, tagPayloadReader);
        } else {
            gapComposer.startReplaceGroup(1666573488);
            boolean zChanged26 = gapComposer.changed(transitionInstanceUpdateTransition);
            objM7 = gapComposer.rememberedValue();
            if (zChanged26 || objM7 == neverEqualPolicy) {
                Snapshot currentThreadSnapshot7 = Lock.getCurrentThreadSnapshot();
                Function1 readObserver7 = currentThreadSnapshot7 != null ? currentThreadSnapshot7.getReadObserver() : null;
                Snapshot snapshotMakeCurrentNonObservable7 = Lock.makeCurrentNonObservable(currentThreadSnapshot7);
                try {
                    Object currentState7 = tagPayloadReader.getCurrentState();
                    Lock.restoreNonObservable(currentThreadSnapshot7, snapshotMakeCurrentNonObservable7, readObserver7);
                    gapComposer.updateRememberedValue(currentState7);
                    objM7 = currentState7;
                } catch (Throwable th7) {
                    Lock.restoreNonObservable(currentThreadSnapshot7, snapshotMakeCurrentNonObservable7, readObserver7);
                    throw th7;
                }
            }
            z5 = false;
            gapComposer.end(false);
        }
        gapComposer.startReplaceGroup(934256835);
        Color colorM13 = Fragment$5$$ExternalSyntheticOutline0.m(gapComposer, z5, ((ColorScheme) objM7).onSecondary);
        boolean zChanged27 = gapComposer.changed(transitionInstanceUpdateTransition);
        Object objRememberedValue20 = gapComposer.rememberedValue();
        if (zChanged27 || objRememberedValue20 == neverEqualPolicy) {
            objRememberedValue20 = SnapshotStateKt__DerivedStateKt.derivedStateOf(new ColorSchemeKt$animateFixedColors$$inlined$animateColor$8(transitionInstanceUpdateTransition, (byte) 14));
            gapComposer.updateRememberedValue(objRememberedValue20);
        }
        ColorScheme colorScheme15 = (ColorScheme) ((State) objRememberedValue20).getValue();
        gapComposer.startReplaceGroup(934256835);
        Color colorM14 = Fragment$5$$ExternalSyntheticOutline0.m(gapComposer, false, colorScheme15.onSecondary);
        boolean zChanged28 = gapComposer.changed(transitionInstanceUpdateTransition);
        Object objRememberedValue21 = gapComposer.rememberedValue();
        if (zChanged28 || objRememberedValue21 == neverEqualPolicy) {
            objRememberedValue21 = SnapshotStateKt__DerivedStateKt.derivedStateOf(new ColorSchemeKt$animateFixedColors$$inlined$animateColor$8(transitionInstanceUpdateTransition, (byte) 15));
            gapComposer.updateRememberedValue(objRememberedValue21);
        }
        Transition.TransitionAnimationState transitionAnimationStateCreateTransitionAnimation7 = ArcSplineKt.createTransitionAnimation(transitionInstanceUpdateTransition, colorM13, colorM14, (FiniteAnimationSpec) mainActivity$$ExternalSyntheticLambda44.invoke(((State) objRememberedValue21).getValue(), gapComposer, Integer.valueOf(i6)), twoWayConverterImpl7, gapComposer, 196608);
        ColorScheme colorScheme16 = (ColorScheme) parcelableSnapshotMutableState.getValue();
        gapComposer.startReplaceGroup(765186471);
        long j13 = colorScheme16.secondaryContainer;
        gapComposer.end(false);
        ColorSpace colorSpaceM483getColorSpaceimpl8 = Color.m483getColorSpaceimpl(j13);
        boolean zChanged29 = gapComposer.changed(colorSpaceM483getColorSpaceimpl8);
        Object objRememberedValue22 = gapComposer.rememberedValue();
        if (zChanged29 || objRememberedValue22 == neverEqualPolicy) {
            objRememberedValue22 = IntIntPair$$ExternalSyntheticOutline0.m(colorVectorConverterKt$ColorToVector$1$3, new CallsKt$await$2$1((byte) 1, colorSpaceM483getColorSpaceimpl8), gapComposer);
        }
        TwoWayConverterImpl twoWayConverterImpl8 = (TwoWayConverterImpl) objRememberedValue22;
        if (transitionInstanceUpdateTransition.isSeeking()) {
            z6 = false;
            objM8 = IntIntPair$$ExternalSyntheticOutline0.m(gapComposer, 1666827533, false, tagPayloadReader);
        } else {
            gapComposer.startReplaceGroup(1666573488);
            boolean zChanged30 = gapComposer.changed(transitionInstanceUpdateTransition);
            objM8 = gapComposer.rememberedValue();
            if (zChanged30 || objM8 == neverEqualPolicy) {
                Snapshot currentThreadSnapshot8 = Lock.getCurrentThreadSnapshot();
                Function1 readObserver8 = currentThreadSnapshot8 != null ? currentThreadSnapshot8.getReadObserver() : null;
                Snapshot snapshotMakeCurrentNonObservable8 = Lock.makeCurrentNonObservable(currentThreadSnapshot8);
                try {
                    Object currentState8 = tagPayloadReader.getCurrentState();
                    Lock.restoreNonObservable(currentThreadSnapshot8, snapshotMakeCurrentNonObservable8, readObserver8);
                    gapComposer.updateRememberedValue(currentState8);
                    objM8 = currentState8;
                } catch (Throwable th8) {
                    Lock.restoreNonObservable(currentThreadSnapshot8, snapshotMakeCurrentNonObservable8, readObserver8);
                    throw th8;
                }
            }
            z6 = false;
            gapComposer.end(false);
        }
        gapComposer.startReplaceGroup(765186471);
        Color colorM15 = Fragment$5$$ExternalSyntheticOutline0.m(gapComposer, z6, ((ColorScheme) objM8).secondaryContainer);
        boolean zChanged31 = gapComposer.changed(transitionInstanceUpdateTransition);
        Object objRememberedValue23 = gapComposer.rememberedValue();
        if (zChanged31 || objRememberedValue23 == neverEqualPolicy) {
            objRememberedValue23 = SnapshotStateKt__DerivedStateKt.derivedStateOf(new ColorSchemeKt$animateFixedColors$$inlined$animateColor$8(transitionInstanceUpdateTransition, (byte) 16));
            gapComposer.updateRememberedValue(objRememberedValue23);
        }
        ColorScheme colorScheme17 = (ColorScheme) ((State) objRememberedValue23).getValue();
        gapComposer.startReplaceGroup(765186471);
        Color colorM16 = Fragment$5$$ExternalSyntheticOutline0.m(gapComposer, false, colorScheme17.secondaryContainer);
        boolean zChanged32 = gapComposer.changed(transitionInstanceUpdateTransition);
        Object objRememberedValue24 = gapComposer.rememberedValue();
        if (zChanged32 || objRememberedValue24 == neverEqualPolicy) {
            objRememberedValue24 = SnapshotStateKt__DerivedStateKt.derivedStateOf(new ColorSchemeKt$animateFixedColors$$inlined$animateColor$8(transitionInstanceUpdateTransition, (byte) 17));
            gapComposer.updateRememberedValue(objRememberedValue24);
        }
        Transition.TransitionAnimationState transitionAnimationStateCreateTransitionAnimation8 = ArcSplineKt.createTransitionAnimation(transitionInstanceUpdateTransition, colorM15, colorM16, (FiniteAnimationSpec) mainActivity$$ExternalSyntheticLambda44.invoke(((State) objRememberedValue24).getValue(), gapComposer, Integer.valueOf(i6)), twoWayConverterImpl8, gapComposer, 196608);
        ColorScheme colorScheme18 = (ColorScheme) parcelableSnapshotMutableState.getValue();
        gapComposer.startReplaceGroup(1477659430);
        long j14 = colorScheme18.onSecondaryContainer;
        gapComposer.end(false);
        ColorSpace colorSpaceM483getColorSpaceimpl9 = Color.m483getColorSpaceimpl(j14);
        boolean zChanged33 = gapComposer.changed(colorSpaceM483getColorSpaceimpl9);
        Object objRememberedValue25 = gapComposer.rememberedValue();
        if (zChanged33 || objRememberedValue25 == neverEqualPolicy) {
            objRememberedValue25 = IntIntPair$$ExternalSyntheticOutline0.m(colorVectorConverterKt$ColorToVector$1$3, new CallsKt$await$2$1((byte) 1, colorSpaceM483getColorSpaceimpl9), gapComposer);
        }
        TwoWayConverterImpl twoWayConverterImpl9 = (TwoWayConverterImpl) objRememberedValue25;
        if (transitionInstanceUpdateTransition.isSeeking()) {
            z7 = false;
            objM9 = IntIntPair$$ExternalSyntheticOutline0.m(gapComposer, 1666827533, false, tagPayloadReader);
        } else {
            gapComposer.startReplaceGroup(1666573488);
            boolean zChanged34 = gapComposer.changed(transitionInstanceUpdateTransition);
            objM9 = gapComposer.rememberedValue();
            if (zChanged34 || objM9 == neverEqualPolicy) {
                Snapshot currentThreadSnapshot9 = Lock.getCurrentThreadSnapshot();
                Function1 readObserver9 = currentThreadSnapshot9 != null ? currentThreadSnapshot9.getReadObserver() : null;
                Snapshot snapshotMakeCurrentNonObservable9 = Lock.makeCurrentNonObservable(currentThreadSnapshot9);
                try {
                    Object currentState9 = tagPayloadReader.getCurrentState();
                    Lock.restoreNonObservable(currentThreadSnapshot9, snapshotMakeCurrentNonObservable9, readObserver9);
                    gapComposer.updateRememberedValue(currentState9);
                    objM9 = currentState9;
                } catch (Throwable th9) {
                    Lock.restoreNonObservable(currentThreadSnapshot9, snapshotMakeCurrentNonObservable9, readObserver9);
                    throw th9;
                }
            }
            z7 = false;
            gapComposer.end(false);
        }
        gapComposer.startReplaceGroup(1477659430);
        Color colorM17 = Fragment$5$$ExternalSyntheticOutline0.m(gapComposer, z7, ((ColorScheme) objM9).onSecondaryContainer);
        boolean zChanged35 = gapComposer.changed(transitionInstanceUpdateTransition);
        Object objRememberedValue26 = gapComposer.rememberedValue();
        if (zChanged35 || objRememberedValue26 == neverEqualPolicy) {
            objRememberedValue26 = SnapshotStateKt__DerivedStateKt.derivedStateOf(new ColorSchemeKt$animateFixedColors$$inlined$animateColor$8(transitionInstanceUpdateTransition, (byte) 18));
            gapComposer.updateRememberedValue(objRememberedValue26);
        }
        ColorScheme colorScheme19 = (ColorScheme) ((State) objRememberedValue26).getValue();
        gapComposer.startReplaceGroup(1477659430);
        Color colorM18 = Fragment$5$$ExternalSyntheticOutline0.m(gapComposer, false, colorScheme19.onSecondaryContainer);
        boolean zChanged36 = gapComposer.changed(transitionInstanceUpdateTransition);
        Object objRememberedValue27 = gapComposer.rememberedValue();
        if (zChanged36 || objRememberedValue27 == neverEqualPolicy) {
            objRememberedValue27 = SnapshotStateKt__DerivedStateKt.derivedStateOf(new ColorSchemeKt$animateFixedColors$$inlined$animateColor$8(transitionInstanceUpdateTransition, (byte) 19));
            gapComposer.updateRememberedValue(objRememberedValue27);
        }
        Transition.TransitionAnimationState transitionAnimationStateCreateTransitionAnimation9 = ArcSplineKt.createTransitionAnimation(transitionInstanceUpdateTransition, colorM17, colorM18, (FiniteAnimationSpec) mainActivity$$ExternalSyntheticLambda44.invoke(((State) objRememberedValue27).getValue(), gapComposer, Integer.valueOf(i6)), twoWayConverterImpl9, gapComposer, 196608);
        Color color6 = (Color) transitionAnimationStateCreateTransitionAnimation6.value$delegate.getValue();
        long j15 = color6.value;
        Color color7 = (Color) transitionAnimationStateCreateTransitionAnimation7.value$delegate.getValue();
        long j16 = color7.value;
        Color color8 = (Color) transitionAnimationStateCreateTransitionAnimation8.value$delegate.getValue();
        long j17 = color8.value;
        Color color9 = (Color) transitionAnimationStateCreateTransitionAnimation9.value$delegate.getValue();
        long j18 = color9.value;
        List listListOf2 = CollectionsKt__IterablesKt.listOf((Object[]) new Color[]{color6, color7, color8, color9});
        List listAnimateTertiaryColors = animateTertiaryColors(transitionInstanceUpdateTransition, mainActivity$$ExternalSyntheticLambda44, composer, i3);
        List listAnimateSurfaceColors = animateSurfaceColors(transitionInstanceUpdateTransition, mainActivity$$ExternalSyntheticLambda44, composer, i3);
        List listAnimateBackgroundAndErrorColors = animateBackgroundAndErrorColors(transitionInstanceUpdateTransition, mainActivity$$ExternalSyntheticLambda44, composer, i3);
        List listAnimateUtilityColors = animateUtilityColors(transitionInstanceUpdateTransition, mainActivity$$ExternalSyntheticLambda44, composer, i3);
        List listAnimateFixedColors = animateFixedColors(transitionInstanceUpdateTransition, mainActivity$$ExternalSyntheticLambda44, composer, i3);
        return new ColorScheme(((Color) listListOf.get(0)).value, ((Color) listListOf.get(1)).value, ((Color) listListOf.get(2)).value, ((Color) listListOf.get(3)).value, ((Color) listListOf.get(4)).value, ((Color) listListOf2.get(0)).value, ((Color) listListOf2.get(1)).value, ((Color) listListOf2.get(2)).value, ((Color) listListOf2.get(3)).value, ((Color) listAnimateTertiaryColors.get(0)).value, ((Color) listAnimateTertiaryColors.get(1)).value, ((Color) listAnimateTertiaryColors.get(2)).value, ((Color) listAnimateTertiaryColors.get(3)).value, ((Color) listAnimateBackgroundAndErrorColors.get(0)).value, ((Color) listAnimateBackgroundAndErrorColors.get(1)).value, ((Color) listAnimateSurfaceColors.get(0)).value, ((Color) listAnimateSurfaceColors.get(1)).value, ((Color) listAnimateSurfaceColors.get(2)).value, ((Color) listAnimateSurfaceColors.get(3)).value, ((Color) listAnimateSurfaceColors.get(4)).value, ((Color) listAnimateUtilityColors.get(0)).value, ((Color) listAnimateUtilityColors.get(1)).value, ((Color) listAnimateBackgroundAndErrorColors.get(2)).value, ((Color) listAnimateBackgroundAndErrorColors.get(3)).value, ((Color) listAnimateBackgroundAndErrorColors.get(4)).value, ((Color) listAnimateBackgroundAndErrorColors.get(5)).value, ((Color) listAnimateUtilityColors.get(2)).value, ((Color) listAnimateUtilityColors.get(3)).value, ((Color) listAnimateUtilityColors.get(4)).value, ((Color) listAnimateSurfaceColors.get(5)).value, ((Color) listAnimateSurfaceColors.get(6)).value, ((Color) listAnimateSurfaceColors.get(7)).value, ((Color) listAnimateSurfaceColors.get(8)).value, ((Color) listAnimateSurfaceColors.get(9)).value, ((Color) listAnimateSurfaceColors.get(10)).value, ((Color) listAnimateSurfaceColors.get(11)).value, ((Color) listAnimateFixedColors.get(0)).value, ((Color) listAnimateFixedColors.get(1)).value, ((Color) listAnimateFixedColors.get(2)).value, ((Color) listAnimateFixedColors.get(3)).value, ((Color) listAnimateFixedColors.get(4)).value, ((Color) listAnimateFixedColors.get(5)).value, ((Color) listAnimateFixedColors.get(6)).value, ((Color) listAnimateFixedColors.get(7)).value, ((Color) listAnimateFixedColors.get(8)).value, ((Color) listAnimateFixedColors.get(9)).value, ((Color) listAnimateFixedColors.get(10)).value, ((Color) listAnimateFixedColors.get(11)).value);
    }

    /* JADX WARN: Code duplicated, block: B:110:0x020b  */
    /* JADX WARN: Code duplicated, block: B:114:0x024e  */
    /* JADX WARN: Code duplicated, block: B:117:0x0260  */
    /* JADX WARN: Code duplicated, block: B:128:0x027d  */
    /* JADX WARN: Code duplicated, block: B:130:0x0283  */
    /* JADX WARN: Code duplicated, block: B:131:0x0288  */
    /* JADX WARN: Code duplicated, block: B:139:0x02a1  */
    /* JADX WARN: Code duplicated, block: B:151:0x02ce  */
    /* JADX WARN: Code duplicated, block: B:163:0x030c  */
    /* JADX WARN: Code duplicated, block: B:167:0x0351  */
    /* JADX WARN: Code duplicated, block: B:170:0x0363  */
    /* JADX WARN: Code duplicated, block: B:181:0x0381  */
    /* JADX WARN: Code duplicated, block: B:183:0x0387  */
    /* JADX WARN: Code duplicated, block: B:184:0x038c  */
    /* JADX WARN: Code duplicated, block: B:192:0x03a5  */
    /* JADX WARN: Code duplicated, block: B:204:0x03d5  */
    /* JADX WARN: Code duplicated, block: B:218:0x0415  */
    /* JADX WARN: Code duplicated, block: B:224:0x045b  */
    /* JADX WARN: Code duplicated, block: B:227:0x046f  */
    /* JADX WARN: Code duplicated, block: B:238:0x048e  */
    /* JADX WARN: Code duplicated, block: B:240:0x0494  */
    /* JADX WARN: Code duplicated, block: B:241:0x0499  */
    /* JADX WARN: Code duplicated, block: B:249:0x04b2  */
    /* JADX WARN: Code duplicated, block: B:261:0x04e3  */
    /* JADX WARN: Code duplicated, block: B:273:0x0520  */
    /* JADX WARN: Code duplicated, block: B:277:0x0563  */
    /* JADX WARN: Code duplicated, block: B:280:0x0575  */
    /* JADX WARN: Code duplicated, block: B:291:0x0594  */
    /* JADX WARN: Code duplicated, block: B:293:0x059a  */
    /* JADX WARN: Code duplicated, block: B:294:0x059f  */
    /* JADX WARN: Code duplicated, block: B:302:0x05b8  */
    /* JADX WARN: Code duplicated, block: B:314:0x05e9  */
    /* JADX WARN: Code duplicated, block: B:326:0x0627  */
    /* JADX WARN: Code duplicated, block: B:330:0x066a  */
    /* JADX WARN: Code duplicated, block: B:333:0x067c  */
    /* JADX WARN: Code duplicated, block: B:344:0x069b  */
    /* JADX WARN: Code duplicated, block: B:346:0x06a1  */
    /* JADX WARN: Code duplicated, block: B:347:0x06a6  */
    /* JADX WARN: Code duplicated, block: B:355:0x06bf  */
    /* JADX WARN: Code duplicated, block: B:367:0x06f0  */
    /* JADX WARN: Code duplicated, block: B:379:0x072e  */
    /* JADX WARN: Code duplicated, block: B:383:0x0771  */
    /* JADX WARN: Code duplicated, block: B:386:0x0783  */
    /* JADX WARN: Code duplicated, block: B:397:0x07a2  */
    /* JADX WARN: Code duplicated, block: B:399:0x07a8  */
    /* JADX WARN: Code duplicated, block: B:400:0x07ad  */
    /* JADX WARN: Code duplicated, block: B:408:0x07c6  */
    /* JADX WARN: Code duplicated, block: B:420:0x07f7  */
    /* JADX WARN: Code duplicated, block: B:432:0x0835  */
    /* JADX WARN: Code duplicated, block: B:436:0x0878  */
    /* JADX WARN: Code duplicated, block: B:439:0x088a  */
    /* JADX WARN: Code duplicated, block: B:450:0x08a9  */
    /* JADX WARN: Code duplicated, block: B:452:0x08af  */
    /* JADX WARN: Code duplicated, block: B:453:0x08b4  */
    /* JADX WARN: Code duplicated, block: B:461:0x08cd  */
    /* JADX WARN: Code duplicated, block: B:473:0x08fe  */
    /* JADX WARN: Code duplicated, block: B:485:0x093c  */
    /* JADX WARN: Code duplicated, block: B:489:0x097f  */
    /* JADX WARN: Code duplicated, block: B:492:0x0991  */
    /* JADX WARN: Code duplicated, block: B:503:0x09b0  */
    /* JADX WARN: Code duplicated, block: B:505:0x09b6  */
    /* JADX WARN: Code duplicated, block: B:506:0x09bb  */
    /* JADX WARN: Code duplicated, block: B:514:0x09d4  */
    /* JADX WARN: Code duplicated, block: B:526:0x0a05  */
    /* JADX WARN: Code duplicated, block: B:538:0x0a43  */
    /* JADX WARN: Code duplicated, block: B:542:0x0a86  */
    /* JADX WARN: Code duplicated, block: B:545:0x0a98  */
    /* JADX WARN: Code duplicated, block: B:556:0x0ab7  */
    /* JADX WARN: Code duplicated, block: B:558:0x0abd  */
    /* JADX WARN: Code duplicated, block: B:559:0x0ac2  */
    /* JADX WARN: Code duplicated, block: B:567:0x0adb  */
    /* JADX WARN: Code duplicated, block: B:579:0x0b0c  */
    /* JADX WARN: Code duplicated, block: B:591:0x0b4a  */
    /* JADX WARN: Code duplicated, block: B:597:0x0b91  */
    /* JADX WARN: Code duplicated, block: B:600:0x0ba3  */
    /* JADX WARN: Code duplicated, block: B:611:0x0bc2  */
    /* JADX WARN: Code duplicated, block: B:613:0x0bc8  */
    /* JADX WARN: Code duplicated, block: B:614:0x0bcd  */
    /* JADX WARN: Code duplicated, block: B:61:0x0153  */
    /* JADX WARN: Code duplicated, block: B:622:0x0be6  */
    /* JADX WARN: Code duplicated, block: B:634:0x0c17  */
    /* JADX WARN: Code duplicated, block: B:646:0x0c56  */
    /* JADX WARN: Code duplicated, block: B:64:0x0165  */
    /* JADX WARN: Code duplicated, block: B:75:0x0182  */
    /* JADX WARN: Code duplicated, block: B:77:0x0188  */
    /* JADX WARN: Code duplicated, block: B:78:0x018d  */
    /* JADX WARN: Code duplicated, block: B:86:0x01a6  */
    /* JADX WARN: Code duplicated, block: B:98:0x01d2  */
    public static final List animateFixedColors(TransitionInstance transitionInstance, Function3 function3, Composer composer, int i) {
        Object objM;
        NeverEqualPolicy neverEqualPolicy;
        ColorSpace colorSpaceM483getColorSpaceimpl;
        boolean zChanged;
        Object objRememberedValue;
        Object objM2;
        boolean z;
        Object objRememberedValue2;
        boolean z2;
        Object objRememberedValue3;
        ColorSpace colorSpaceM483getColorSpaceimpl2;
        boolean zChanged2;
        Object objRememberedValue4;
        Object objM3;
        boolean z3;
        Object objRememberedValue5;
        boolean z4;
        Object objRememberedValue6;
        ColorSpace colorSpaceM483getColorSpaceimpl3;
        boolean zChanged3;
        Object objRememberedValue7;
        Object objM4;
        boolean z5;
        Object objRememberedValue8;
        boolean z6;
        Object objRememberedValue9;
        ColorSpace colorSpaceM483getColorSpaceimpl4;
        boolean zChanged4;
        Object objRememberedValue10;
        boolean z7;
        Object objM5;
        boolean z8;
        Object objRememberedValue11;
        boolean z9;
        Object objRememberedValue12;
        ColorSpace colorSpaceM483getColorSpaceimpl5;
        boolean zChanged5;
        Object objRememberedValue13;
        Object objM6;
        boolean z10;
        Object objRememberedValue14;
        boolean z11;
        Object objRememberedValue15;
        ColorSpace colorSpaceM483getColorSpaceimpl6;
        boolean zChanged6;
        Object objRememberedValue16;
        Object objM7;
        boolean z12;
        Object objRememberedValue17;
        boolean z13;
        Object objRememberedValue18;
        ColorSpace colorSpaceM483getColorSpaceimpl7;
        boolean zChanged7;
        Object objRememberedValue19;
        Object objM8;
        boolean z14;
        Object objRememberedValue20;
        boolean z15;
        Object objRememberedValue21;
        ColorSpace colorSpaceM483getColorSpaceimpl8;
        boolean zChanged8;
        Object objRememberedValue22;
        Object objM9;
        boolean z16;
        Object objRememberedValue23;
        boolean z17;
        Object objRememberedValue24;
        ColorSpace colorSpaceM483getColorSpaceimpl9;
        boolean zChanged9;
        Object objRememberedValue25;
        Object objM10;
        boolean z18;
        Object objRememberedValue26;
        boolean z19;
        Object objRememberedValue27;
        ColorSpace colorSpaceM483getColorSpaceimpl10;
        boolean zChanged10;
        Object objRememberedValue28;
        Object objM11;
        boolean z20;
        Object objRememberedValue29;
        boolean z21;
        Object objRememberedValue30;
        ColorSpace colorSpaceM483getColorSpaceimpl11;
        boolean zChanged11;
        boolean z22;
        Object objM12;
        Object objM13;
        boolean z23;
        Object objRememberedValue31;
        boolean z24;
        Object objRememberedValue32;
        boolean z25;
        Snapshot currentThreadSnapshot;
        Function1 readObserver;
        Snapshot snapshotMakeCurrentNonObservable;
        boolean z26;
        Snapshot currentThreadSnapshot2;
        Function1 readObserver2;
        Snapshot snapshotMakeCurrentNonObservable2;
        boolean z27;
        Snapshot currentThreadSnapshot3;
        Function1 readObserver3;
        Snapshot snapshotMakeCurrentNonObservable3;
        boolean z28;
        Snapshot currentThreadSnapshot4;
        Function1 readObserver4;
        Snapshot snapshotMakeCurrentNonObservable4;
        boolean z29;
        Snapshot currentThreadSnapshot5;
        Function1 readObserver5;
        Snapshot snapshotMakeCurrentNonObservable5;
        boolean z30;
        Snapshot currentThreadSnapshot6;
        Function1 readObserver6;
        Snapshot snapshotMakeCurrentNonObservable6;
        boolean z31;
        Snapshot currentThreadSnapshot7;
        Function1 readObserver7;
        Snapshot snapshotMakeCurrentNonObservable7;
        boolean z32;
        Snapshot currentThreadSnapshot8;
        Function1 readObserver8;
        Snapshot snapshotMakeCurrentNonObservable8;
        boolean z33;
        Snapshot currentThreadSnapshot9;
        Function1 readObserver9;
        Snapshot snapshotMakeCurrentNonObservable9;
        boolean z34;
        Snapshot currentThreadSnapshot10;
        Function1 readObserver10;
        Snapshot snapshotMakeCurrentNonObservable10;
        boolean z35;
        Snapshot currentThreadSnapshot11;
        Function1 readObserver11;
        Snapshot snapshotMakeCurrentNonObservable11;
        int i2 = (i & 14) | 384 | (i & 112);
        ColorScheme colorScheme = (ColorScheme) transitionInstance.getTargetState();
        GapComposer gapComposer = (GapComposer) composer;
        gapComposer.startReplaceGroup(705124748);
        long j = colorScheme.primaryFixed;
        gapComposer.endReplaceGroup();
        ColorSpace colorSpaceM483getColorSpaceimpl12 = Color.m483getColorSpaceimpl(j);
        boolean zChanged12 = gapComposer.changed(colorSpaceM483getColorSpaceimpl12);
        Object objRememberedValue33 = gapComposer.rememberedValue();
        ColorVectorConverterKt$ColorToVector$1$1 colorVectorConverterKt$ColorToVector$1$1 = ColorVectorConverterKt$ColorToVector$1$1.INSTANCE;
        NeverEqualPolicy neverEqualPolicy2 = Composer.Companion.Empty;
        if (zChanged12 || objRememberedValue33 == neverEqualPolicy2) {
            objRememberedValue33 = IntIntPair$$ExternalSyntheticOutline0.m(colorVectorConverterKt$ColorToVector$1$1, new CallsKt$await$2$1((byte) 1, colorSpaceM483getColorSpaceimpl12), gapComposer);
        }
        TwoWayConverterImpl twoWayConverterImpl = (TwoWayConverterImpl) objRememberedValue33;
        int i3 = ((i2 << 3) & 896) | (i2 & 14) | 3072;
        if (transitionInstance.isSeeking()) {
            objM = Format$$ExternalSyntheticOutline0.m(gapComposer, 1666827533, transitionInstance);
        } else {
            gapComposer.startReplaceGroup(1666573488);
            boolean z36 = (((i3 & 14) ^ 6) > 4 && gapComposer.changed(transitionInstance)) || (i3 & 6) == 4;
            objM = gapComposer.rememberedValue();
            if (z36 || objM == neverEqualPolicy2) {
                Snapshot currentThreadSnapshot12 = Lock.getCurrentThreadSnapshot();
                Function1 readObserver12 = currentThreadSnapshot12 != null ? currentThreadSnapshot12.getReadObserver() : null;
                Snapshot snapshotMakeCurrentNonObservable12 = Lock.makeCurrentNonObservable(currentThreadSnapshot12);
                try {
                    Object currentState = transitionInstance.getCurrentState();
                    Lock.restoreNonObservable(currentThreadSnapshot12, snapshotMakeCurrentNonObservable12, readObserver12);
                    gapComposer.updateRememberedValue(currentState);
                    objM = currentState;
                } catch (Throwable th) {
                    Lock.restoreNonObservable(currentThreadSnapshot12, snapshotMakeCurrentNonObservable12, readObserver12);
                    throw th;
                }
            }
            gapComposer.endReplaceGroup();
        }
        gapComposer.startReplaceGroup(705124748);
        long j2 = ((ColorScheme) objM).primaryFixed;
        gapComposer.endReplaceGroup();
        Color colorM478boximpl = Color.m478boximpl(j2);
        int i4 = i3 & 14;
        int i5 = i4 ^ 6;
        boolean z37 = (i5 > 4 && gapComposer.changed(transitionInstance)) || (i3 & 6) == 4;
        Object objRememberedValue34 = gapComposer.rememberedValue();
        if (z37 || objRememberedValue34 == neverEqualPolicy2) {
            objRememberedValue34 = SnapshotStateKt__DerivedStateKt.derivedStateOf(new ColorSchemeKt$animateFixedColors$$inlined$animateColor$1(transitionInstance, (byte) 0));
            gapComposer.updateRememberedValue(objRememberedValue34);
        }
        ColorScheme colorScheme2 = (ColorScheme) ((State) objRememberedValue34).getValue();
        gapComposer.startReplaceGroup(705124748);
        long j3 = colorScheme2.primaryFixed;
        gapComposer.endReplaceGroup();
        Color colorM478boximpl2 = Color.m478boximpl(j3);
        boolean z38 = (i5 > 4 && gapComposer.changed(transitionInstance)) || (i3 & 6) == 4;
        Object objRememberedValue35 = gapComposer.rememberedValue();
        if (!z38) {
            neverEqualPolicy = neverEqualPolicy2;
            if (objRememberedValue35 == neverEqualPolicy) {
            }
            int i6 = (i3 >> 3) & 112;
            int i7 = i4 | 196608;
            Transition.TransitionAnimationState transitionAnimationStateCreateTransitionAnimation = ArcSplineKt.createTransitionAnimation(transitionInstance, colorM478boximpl, colorM478boximpl2, (FiniteAnimationSpec) function3.invoke(((State) objRememberedValue35).getValue(), gapComposer, Integer.valueOf(i6)), twoWayConverterImpl, gapComposer, i7);
            ColorScheme colorScheme3 = (ColorScheme) transitionInstance.getTargetState();
            gapComposer.startReplaceGroup(-1062804668);
            long j4 = colorScheme3.primaryFixedDim;
            gapComposer.endReplaceGroup();
            colorSpaceM483getColorSpaceimpl = Color.m483getColorSpaceimpl(j4);
            zChanged = gapComposer.changed(colorSpaceM483getColorSpaceimpl);
            objRememberedValue = gapComposer.rememberedValue();
            if (zChanged || objRememberedValue == neverEqualPolicy) {
                objRememberedValue = IntIntPair$$ExternalSyntheticOutline0.m(colorVectorConverterKt$ColorToVector$1$1, new CallsKt$await$2$1((byte) 1, colorSpaceM483getColorSpaceimpl), gapComposer);
            }
            TwoWayConverterImpl twoWayConverterImpl2 = (TwoWayConverterImpl) objRememberedValue;
            if (transitionInstance.isSeeking()) {
                objM2 = Format$$ExternalSyntheticOutline0.m(gapComposer, 1666827533, transitionInstance);
            } else {
                gapComposer.startReplaceGroup(1666573488);
                z35 = (i5 <= 4 && gapComposer.changed(transitionInstance)) || (i3 & 6) == 4;
                objM2 = gapComposer.rememberedValue();
                if (z35 || objM2 == neverEqualPolicy) {
                    currentThreadSnapshot11 = Lock.getCurrentThreadSnapshot();
                    if (currentThreadSnapshot11 != null) {
                        readObserver11 = currentThreadSnapshot11.getReadObserver();
                    } else {
                        readObserver11 = null;
                    }
                    snapshotMakeCurrentNonObservable11 = Lock.makeCurrentNonObservable(currentThreadSnapshot11);
                    try {
                        Object currentState2 = transitionInstance.getCurrentState();
                        Lock.restoreNonObservable(currentThreadSnapshot11, snapshotMakeCurrentNonObservable11, readObserver11);
                        gapComposer.updateRememberedValue(currentState2);
                        objM2 = currentState2;
                    } catch (Throwable th2) {
                        Lock.restoreNonObservable(currentThreadSnapshot11, snapshotMakeCurrentNonObservable11, readObserver11);
                        throw th2;
                    }
                }
                gapComposer.endReplaceGroup();
            }
            gapComposer.startReplaceGroup(-1062804668);
            long j5 = ((ColorScheme) objM2).primaryFixedDim;
            gapComposer.endReplaceGroup();
            Color colorM478boximpl3 = Color.m478boximpl(j5);
            z = (i5 <= 4 && gapComposer.changed(transitionInstance)) || (i3 & 6) == 4;
            objRememberedValue2 = gapComposer.rememberedValue();
            if (z || objRememberedValue2 == neverEqualPolicy) {
                objRememberedValue2 = SnapshotStateKt__DerivedStateKt.derivedStateOf(new ColorSchemeKt$animateFixedColors$$inlined$animateColor$1(transitionInstance, (byte) 25));
                gapComposer.updateRememberedValue(objRememberedValue2);
            }
            ColorScheme colorScheme4 = (ColorScheme) ((State) objRememberedValue2).getValue();
            gapComposer.startReplaceGroup(-1062804668);
            long j6 = colorScheme4.primaryFixedDim;
            gapComposer.endReplaceGroup();
            Color colorM478boximpl4 = Color.m478boximpl(j6);
            z2 = (i5 <= 4 && gapComposer.changed(transitionInstance)) || (i3 & 6) == 4;
            objRememberedValue3 = gapComposer.rememberedValue();
            if (z2 || objRememberedValue3 == neverEqualPolicy) {
                objRememberedValue3 = SnapshotStateKt__DerivedStateKt.derivedStateOf(new ColorSchemeKt$animateFixedColors$$inlined$animateColor$1(transitionInstance, (byte) 26));
                gapComposer.updateRememberedValue(objRememberedValue3);
            }
            Transition.TransitionAnimationState transitionAnimationStateCreateTransitionAnimation2 = ArcSplineKt.createTransitionAnimation(transitionInstance, colorM478boximpl3, colorM478boximpl4, (FiniteAnimationSpec) function3.invoke(((State) objRememberedValue3).getValue(), gapComposer, Integer.valueOf(i6)), twoWayConverterImpl2, gapComposer, i7);
            ColorScheme colorScheme5 = (ColorScheme) transitionInstance.getTargetState();
            gapComposer.startReplaceGroup(-1037969973);
            long j7 = colorScheme5.onPrimaryFixed;
            gapComposer.endReplaceGroup();
            colorSpaceM483getColorSpaceimpl2 = Color.m483getColorSpaceimpl(j7);
            zChanged2 = gapComposer.changed(colorSpaceM483getColorSpaceimpl2);
            objRememberedValue4 = gapComposer.rememberedValue();
            if (zChanged2 || objRememberedValue4 == neverEqualPolicy) {
                objRememberedValue4 = IntIntPair$$ExternalSyntheticOutline0.m(colorVectorConverterKt$ColorToVector$1$1, new CallsKt$await$2$1((byte) 1, colorSpaceM483getColorSpaceimpl2), gapComposer);
            }
            TwoWayConverterImpl twoWayConverterImpl3 = (TwoWayConverterImpl) objRememberedValue4;
            if (transitionInstance.isSeeking()) {
                objM3 = Format$$ExternalSyntheticOutline0.m(gapComposer, 1666827533, transitionInstance);
            } else {
                gapComposer.startReplaceGroup(1666573488);
                z34 = (i5 <= 4 && gapComposer.changed(transitionInstance)) || (i3 & 6) == 4;
                objM3 = gapComposer.rememberedValue();
                if (z34 || objM3 == neverEqualPolicy) {
                    currentThreadSnapshot10 = Lock.getCurrentThreadSnapshot();
                    if (currentThreadSnapshot10 != null) {
                        readObserver10 = currentThreadSnapshot10.getReadObserver();
                    } else {
                        readObserver10 = null;
                    }
                    snapshotMakeCurrentNonObservable10 = Lock.makeCurrentNonObservable(currentThreadSnapshot10);
                    try {
                        Object currentState3 = transitionInstance.getCurrentState();
                        Lock.restoreNonObservable(currentThreadSnapshot10, snapshotMakeCurrentNonObservable10, readObserver10);
                        gapComposer.updateRememberedValue(currentState3);
                        objM3 = currentState3;
                    } catch (Throwable th3) {
                        Lock.restoreNonObservable(currentThreadSnapshot10, snapshotMakeCurrentNonObservable10, readObserver10);
                        throw th3;
                    }
                }
                gapComposer.endReplaceGroup();
            }
            gapComposer.startReplaceGroup(-1037969973);
            long j8 = ((ColorScheme) objM3).onPrimaryFixed;
            gapComposer.endReplaceGroup();
            Color colorM478boximpl5 = Color.m478boximpl(j8);
            z3 = (i5 <= 4 && gapComposer.changed(transitionInstance)) || (i3 & 6) == 4;
            objRememberedValue5 = gapComposer.rememberedValue();
            if (z3 || objRememberedValue5 == neverEqualPolicy) {
                objRememberedValue5 = SnapshotStateKt__DerivedStateKt.derivedStateOf(new ColorSchemeKt$animateFixedColors$$inlined$animateColor$1(transitionInstance, (byte) 27));
                gapComposer.updateRememberedValue(objRememberedValue5);
            }
            ColorScheme colorScheme6 = (ColorScheme) ((State) objRememberedValue5).getValue();
            gapComposer.startReplaceGroup(-1037969973);
            long j9 = colorScheme6.onPrimaryFixed;
            gapComposer.endReplaceGroup();
            Color colorM478boximpl6 = Color.m478boximpl(j9);
            z4 = (i5 <= 4 && gapComposer.changed(transitionInstance)) || (i3 & 6) == 4;
            objRememberedValue6 = gapComposer.rememberedValue();
            if (z4 || objRememberedValue6 == neverEqualPolicy) {
                objRememberedValue6 = SnapshotStateKt__DerivedStateKt.derivedStateOf(new ColorSchemeKt$animateFixedColors$$inlined$animateColor$1(transitionInstance, (byte) 28));
                gapComposer.updateRememberedValue(objRememberedValue6);
            }
            Transition.TransitionAnimationState transitionAnimationStateCreateTransitionAnimation3 = ArcSplineKt.createTransitionAnimation(transitionInstance, colorM478boximpl5, colorM478boximpl6, (FiniteAnimationSpec) function3.invoke(((State) objRememberedValue6).getValue(), gapComposer, Integer.valueOf(i6)), twoWayConverterImpl3, gapComposer, i7);
            ColorScheme colorScheme7 = (ColorScheme) transitionInstance.getTargetState();
            gapComposer.startReplaceGroup(-1429178142);
            long j10 = colorScheme7.onPrimaryFixedVariant;
            gapComposer.endReplaceGroup();
            colorSpaceM483getColorSpaceimpl3 = Color.m483getColorSpaceimpl(j10);
            zChanged3 = gapComposer.changed(colorSpaceM483getColorSpaceimpl3);
            objRememberedValue7 = gapComposer.rememberedValue();
            if (zChanged3 || objRememberedValue7 == neverEqualPolicy) {
                objRememberedValue7 = IntIntPair$$ExternalSyntheticOutline0.m(colorVectorConverterKt$ColorToVector$1$1, new CallsKt$await$2$1((byte) 1, colorSpaceM483getColorSpaceimpl3), gapComposer);
            }
            TwoWayConverterImpl twoWayConverterImpl4 = (TwoWayConverterImpl) objRememberedValue7;
            if (transitionInstance.isSeeking()) {
                objM4 = Format$$ExternalSyntheticOutline0.m(gapComposer, 1666827533, transitionInstance);
            } else {
                gapComposer.startReplaceGroup(1666573488);
                z33 = (i5 <= 4 && gapComposer.changed(transitionInstance)) || (i3 & 6) == 4;
                objM4 = gapComposer.rememberedValue();
                if (z33 || objM4 == neverEqualPolicy) {
                    currentThreadSnapshot9 = Lock.getCurrentThreadSnapshot();
                    if (currentThreadSnapshot9 != null) {
                        readObserver9 = currentThreadSnapshot9.getReadObserver();
                    } else {
                        readObserver9 = null;
                    }
                    snapshotMakeCurrentNonObservable9 = Lock.makeCurrentNonObservable(currentThreadSnapshot9);
                    try {
                        Object currentState4 = transitionInstance.getCurrentState();
                        Lock.restoreNonObservable(currentThreadSnapshot9, snapshotMakeCurrentNonObservable9, readObserver9);
                        gapComposer.updateRememberedValue(currentState4);
                        objM4 = currentState4;
                    } catch (Throwable th4) {
                        Lock.restoreNonObservable(currentThreadSnapshot9, snapshotMakeCurrentNonObservable9, readObserver9);
                        throw th4;
                    }
                }
                gapComposer.endReplaceGroup();
            }
            gapComposer.startReplaceGroup(-1429178142);
            long j11 = ((ColorScheme) objM4).onPrimaryFixedVariant;
            gapComposer.endReplaceGroup();
            Color colorM478boximpl7 = Color.m478boximpl(j11);
            z5 = (i5 <= 4 && gapComposer.changed(transitionInstance)) || (i3 & 6) == 4;
            objRememberedValue8 = gapComposer.rememberedValue();
            if (z5 || objRememberedValue8 == neverEqualPolicy) {
                objRememberedValue8 = SnapshotStateKt__DerivedStateKt.derivedStateOf(new ColorSchemeKt$animateFixedColors$$inlined$animateColor$1(transitionInstance, (byte) 29));
                gapComposer.updateRememberedValue(objRememberedValue8);
            }
            ColorScheme colorScheme8 = (ColorScheme) ((State) objRememberedValue8).getValue();
            gapComposer.startReplaceGroup(-1429178142);
            long j12 = colorScheme8.onPrimaryFixedVariant;
            gapComposer.endReplaceGroup();
            Color colorM478boximpl8 = Color.m478boximpl(j12);
            z6 = (i5 <= 4 && gapComposer.changed(transitionInstance)) || (i3 & 6) == 4;
            objRememberedValue9 = gapComposer.rememberedValue();
            if (z6 || objRememberedValue9 == neverEqualPolicy) {
                objRememberedValue9 = SnapshotStateKt__DerivedStateKt.derivedStateOf(new ColorSchemeKt$animateFixedColors$$inlined$animateColor$8(transitionInstance, (byte) 0));
                gapComposer.updateRememberedValue(objRememberedValue9);
            }
            Transition.TransitionAnimationState transitionAnimationStateCreateTransitionAnimation4 = ArcSplineKt.createTransitionAnimation(transitionInstance, colorM478boximpl7, colorM478boximpl8, (FiniteAnimationSpec) function3.invoke(((State) objRememberedValue9).getValue(), gapComposer, Integer.valueOf(i6)), twoWayConverterImpl4, gapComposer, i7);
            ColorScheme colorScheme9 = (ColorScheme) transitionInstance.getTargetState();
            gapComposer.startReplaceGroup(-489786278);
            long j13 = colorScheme9.secondaryFixed;
            gapComposer.endReplaceGroup();
            colorSpaceM483getColorSpaceimpl4 = Color.m483getColorSpaceimpl(j13);
            zChanged4 = gapComposer.changed(colorSpaceM483getColorSpaceimpl4);
            objRememberedValue10 = gapComposer.rememberedValue();
            if (!zChanged4 || objRememberedValue10 == neverEqualPolicy) {
                z7 = false;
                objRememberedValue10 = IntIntPair$$ExternalSyntheticOutline0.m(colorVectorConverterKt$ColorToVector$1$1, new CallsKt$await$2$1((byte) 1, colorSpaceM483getColorSpaceimpl4), gapComposer);
            } else {
                z7 = false;
            }
            TwoWayConverterImpl twoWayConverterImpl5 = (TwoWayConverterImpl) objRememberedValue10;
            if (transitionInstance.isSeeking()) {
                objM5 = Format$$ExternalSyntheticOutline0.m(gapComposer, 1666827533, transitionInstance);
            } else {
                gapComposer.startReplaceGroup(1666573488);
                z32 = ((i5 > 4 || !gapComposer.changed(transitionInstance)) && (i3 & 6) != 4) ? z7 : true;
                objM5 = gapComposer.rememberedValue();
                if (z32 || objM5 == neverEqualPolicy) {
                    currentThreadSnapshot8 = Lock.getCurrentThreadSnapshot();
                    if (currentThreadSnapshot8 != null) {
                        readObserver8 = currentThreadSnapshot8.getReadObserver();
                    } else {
                        readObserver8 = null;
                    }
                    snapshotMakeCurrentNonObservable8 = Lock.makeCurrentNonObservable(currentThreadSnapshot8);
                    try {
                        Object currentState5 = transitionInstance.getCurrentState();
                        Lock.restoreNonObservable(currentThreadSnapshot8, snapshotMakeCurrentNonObservable8, readObserver8);
                        gapComposer.updateRememberedValue(currentState5);
                        objM5 = currentState5;
                    } catch (Throwable th5) {
                        Lock.restoreNonObservable(currentThreadSnapshot8, snapshotMakeCurrentNonObservable8, readObserver8);
                        throw th5;
                    }
                }
                gapComposer.endReplaceGroup();
            }
            gapComposer.startReplaceGroup(-489786278);
            long j14 = ((ColorScheme) objM5).secondaryFixed;
            gapComposer.endReplaceGroup();
            Color colorM478boximpl9 = Color.m478boximpl(j14);
            z8 = ((i5 > 4 || !gapComposer.changed(transitionInstance)) && (i3 & 6) != 4) ? z7 : true;
            objRememberedValue11 = gapComposer.rememberedValue();
            if (z8 || objRememberedValue11 == neverEqualPolicy) {
                objRememberedValue11 = SnapshotStateKt__DerivedStateKt.derivedStateOf(new ColorSchemeKt$animateFixedColors$$inlined$animateColor$8(transitionInstance, (byte) 1));
                gapComposer.updateRememberedValue(objRememberedValue11);
            }
            ColorScheme colorScheme10 = (ColorScheme) ((State) objRememberedValue11).getValue();
            gapComposer.startReplaceGroup(-489786278);
            long j15 = colorScheme10.secondaryFixed;
            gapComposer.endReplaceGroup();
            Color colorM478boximpl10 = Color.m478boximpl(j15);
            z9 = ((i5 > 4 || !gapComposer.changed(transitionInstance)) && (i3 & 6) != 4) ? z7 : true;
            objRememberedValue12 = gapComposer.rememberedValue();
            if (z9 || objRememberedValue12 == neverEqualPolicy) {
                objRememberedValue12 = SnapshotStateKt__DerivedStateKt.derivedStateOf(new ColorSchemeKt$animateFixedColors$$inlined$animateColor$1(transitionInstance, (byte) 9));
                gapComposer.updateRememberedValue(objRememberedValue12);
            }
            Transition.TransitionAnimationState transitionAnimationStateCreateTransitionAnimation5 = ArcSplineKt.createTransitionAnimation(transitionInstance, colorM478boximpl9, colorM478boximpl10, (FiniteAnimationSpec) function3.invoke(((State) objRememberedValue12).getValue(), gapComposer, Integer.valueOf(i6)), twoWayConverterImpl5, gapComposer, i7);
            ColorScheme colorScheme11 = (ColorScheme) transitionInstance.getTargetState();
            gapComposer.startReplaceGroup(-1968230986);
            long j16 = colorScheme11.secondaryFixedDim;
            gapComposer.endReplaceGroup();
            colorSpaceM483getColorSpaceimpl5 = Color.m483getColorSpaceimpl(j16);
            zChanged5 = gapComposer.changed(colorSpaceM483getColorSpaceimpl5);
            objRememberedValue13 = gapComposer.rememberedValue();
            if (zChanged5 || objRememberedValue13 == neverEqualPolicy) {
                objRememberedValue13 = IntIntPair$$ExternalSyntheticOutline0.m(colorVectorConverterKt$ColorToVector$1$1, new CallsKt$await$2$1((byte) 1, colorSpaceM483getColorSpaceimpl5), gapComposer);
            }
            TwoWayConverterImpl twoWayConverterImpl6 = (TwoWayConverterImpl) objRememberedValue13;
            if (transitionInstance.isSeeking()) {
                objM6 = Format$$ExternalSyntheticOutline0.m(gapComposer, 1666827533, transitionInstance);
            } else {
                gapComposer.startReplaceGroup(1666573488);
                z31 = ((i5 > 4 || !gapComposer.changed(transitionInstance)) && (i3 & 6) != 4) ? z7 : true;
                objM6 = gapComposer.rememberedValue();
                if (z31 || objM6 == neverEqualPolicy) {
                    currentThreadSnapshot7 = Lock.getCurrentThreadSnapshot();
                    if (currentThreadSnapshot7 != null) {
                        readObserver7 = currentThreadSnapshot7.getReadObserver();
                    } else {
                        readObserver7 = null;
                    }
                    snapshotMakeCurrentNonObservable7 = Lock.makeCurrentNonObservable(currentThreadSnapshot7);
                    try {
                        Object currentState6 = transitionInstance.getCurrentState();
                        Lock.restoreNonObservable(currentThreadSnapshot7, snapshotMakeCurrentNonObservable7, readObserver7);
                        gapComposer.updateRememberedValue(currentState6);
                        objM6 = currentState6;
                    } catch (Throwable th6) {
                        Lock.restoreNonObservable(currentThreadSnapshot7, snapshotMakeCurrentNonObservable7, readObserver7);
                        throw th6;
                    }
                }
                gapComposer.endReplaceGroup();
            }
            gapComposer.startReplaceGroup(-1968230986);
            long j17 = ((ColorScheme) objM6).secondaryFixedDim;
            gapComposer.endReplaceGroup();
            Color colorM478boximpl11 = Color.m478boximpl(j17);
            z10 = ((i5 > 4 || !gapComposer.changed(transitionInstance)) && (i3 & 6) != 4) ? z7 : true;
            objRememberedValue14 = gapComposer.rememberedValue();
            if (z10 || objRememberedValue14 == neverEqualPolicy) {
                objRememberedValue14 = SnapshotStateKt__DerivedStateKt.derivedStateOf(new ColorSchemeKt$animateFixedColors$$inlined$animateColor$1(transitionInstance, (byte) 10));
                gapComposer.updateRememberedValue(objRememberedValue14);
            }
            ColorScheme colorScheme12 = (ColorScheme) ((State) objRememberedValue14).getValue();
            gapComposer.startReplaceGroup(-1968230986);
            long j18 = colorScheme12.secondaryFixedDim;
            gapComposer.endReplaceGroup();
            Color colorM478boximpl12 = Color.m478boximpl(j18);
            z11 = ((i5 > 4 || !gapComposer.changed(transitionInstance)) && (i3 & 6) != 4) ? z7 : true;
            objRememberedValue15 = gapComposer.rememberedValue();
            if (z11 || objRememberedValue15 == neverEqualPolicy) {
                objRememberedValue15 = SnapshotStateKt__DerivedStateKt.derivedStateOf(new ColorSchemeKt$animateFixedColors$$inlined$animateColor$1(transitionInstance, (byte) 11));
                gapComposer.updateRememberedValue(objRememberedValue15);
            }
            Transition.TransitionAnimationState transitionAnimationStateCreateTransitionAnimation6 = ArcSplineKt.createTransitionAnimation(transitionInstance, colorM478boximpl11, colorM478boximpl12, (FiniteAnimationSpec) function3.invoke(((State) objRememberedValue15).getValue(), gapComposer, Integer.valueOf(i6)), twoWayConverterImpl6, gapComposer, i7);
            ColorScheme colorScheme13 = (ColorScheme) transitionInstance.getTargetState();
            gapComposer.startReplaceGroup(-566567719);
            long j19 = colorScheme13.onSecondaryFixed;
            gapComposer.endReplaceGroup();
            colorSpaceM483getColorSpaceimpl6 = Color.m483getColorSpaceimpl(j19);
            zChanged6 = gapComposer.changed(colorSpaceM483getColorSpaceimpl6);
            objRememberedValue16 = gapComposer.rememberedValue();
            if (zChanged6 || objRememberedValue16 == neverEqualPolicy) {
                objRememberedValue16 = IntIntPair$$ExternalSyntheticOutline0.m(colorVectorConverterKt$ColorToVector$1$1, new CallsKt$await$2$1((byte) 1, colorSpaceM483getColorSpaceimpl6), gapComposer);
            }
            TwoWayConverterImpl twoWayConverterImpl7 = (TwoWayConverterImpl) objRememberedValue16;
            if (transitionInstance.isSeeking()) {
                objM7 = Format$$ExternalSyntheticOutline0.m(gapComposer, 1666827533, transitionInstance);
            } else {
                gapComposer.startReplaceGroup(1666573488);
                z30 = ((i5 > 4 || !gapComposer.changed(transitionInstance)) && (i3 & 6) != 4) ? z7 : true;
                objM7 = gapComposer.rememberedValue();
                if (z30 || objM7 == neverEqualPolicy) {
                    currentThreadSnapshot6 = Lock.getCurrentThreadSnapshot();
                    if (currentThreadSnapshot6 != null) {
                        readObserver6 = currentThreadSnapshot6.getReadObserver();
                    } else {
                        readObserver6 = null;
                    }
                    snapshotMakeCurrentNonObservable6 = Lock.makeCurrentNonObservable(currentThreadSnapshot6);
                    try {
                        Object currentState7 = transitionInstance.getCurrentState();
                        Lock.restoreNonObservable(currentThreadSnapshot6, snapshotMakeCurrentNonObservable6, readObserver6);
                        gapComposer.updateRememberedValue(currentState7);
                        objM7 = currentState7;
                    } catch (Throwable th7) {
                        Lock.restoreNonObservable(currentThreadSnapshot6, snapshotMakeCurrentNonObservable6, readObserver6);
                        throw th7;
                    }
                }
                gapComposer.endReplaceGroup();
            }
            gapComposer.startReplaceGroup(-566567719);
            long j20 = ((ColorScheme) objM7).onSecondaryFixed;
            gapComposer.endReplaceGroup();
            Color colorM478boximpl13 = Color.m478boximpl(j20);
            z12 = ((i5 > 4 || !gapComposer.changed(transitionInstance)) && (i3 & 6) != 4) ? z7 : true;
            objRememberedValue17 = gapComposer.rememberedValue();
            if (z12 || objRememberedValue17 == neverEqualPolicy) {
                objRememberedValue17 = SnapshotStateKt__DerivedStateKt.derivedStateOf(new ColorSchemeKt$animateFixedColors$$inlined$animateColor$1(transitionInstance, (byte) 12));
                gapComposer.updateRememberedValue(objRememberedValue17);
            }
            ColorScheme colorScheme14 = (ColorScheme) ((State) objRememberedValue17).getValue();
            gapComposer.startReplaceGroup(-566567719);
            long j21 = colorScheme14.onSecondaryFixed;
            gapComposer.endReplaceGroup();
            Color colorM478boximpl14 = Color.m478boximpl(j21);
            z13 = ((i5 > 4 || !gapComposer.changed(transitionInstance)) && (i3 & 6) != 4) ? z7 : true;
            objRememberedValue18 = gapComposer.rememberedValue();
            if (z13 || objRememberedValue18 == neverEqualPolicy) {
                objRememberedValue18 = SnapshotStateKt__DerivedStateKt.derivedStateOf(new ColorSchemeKt$animateFixedColors$$inlined$animateColor$1(transitionInstance, (byte) 13));
                gapComposer.updateRememberedValue(objRememberedValue18);
            }
            Transition.TransitionAnimationState transitionAnimationStateCreateTransitionAnimation7 = ArcSplineKt.createTransitionAnimation(transitionInstance, colorM478boximpl13, colorM478boximpl14, (FiniteAnimationSpec) function3.invoke(((State) objRememberedValue18).getValue(), gapComposer, Integer.valueOf(i6)), twoWayConverterImpl7, gapComposer, i7);
            ColorScheme colorScheme15 = (ColorScheme) transitionInstance.getTargetState();
            gapComposer.startReplaceGroup(1193412116);
            long j22 = colorScheme15.onSecondaryFixedVariant;
            gapComposer.endReplaceGroup();
            colorSpaceM483getColorSpaceimpl7 = Color.m483getColorSpaceimpl(j22);
            zChanged7 = gapComposer.changed(colorSpaceM483getColorSpaceimpl7);
            objRememberedValue19 = gapComposer.rememberedValue();
            if (zChanged7 || objRememberedValue19 == neverEqualPolicy) {
                objRememberedValue19 = IntIntPair$$ExternalSyntheticOutline0.m(colorVectorConverterKt$ColorToVector$1$1, new CallsKt$await$2$1((byte) 1, colorSpaceM483getColorSpaceimpl7), gapComposer);
            }
            TwoWayConverterImpl twoWayConverterImpl8 = (TwoWayConverterImpl) objRememberedValue19;
            if (transitionInstance.isSeeking()) {
                objM8 = Format$$ExternalSyntheticOutline0.m(gapComposer, 1666827533, transitionInstance);
            } else {
                gapComposer.startReplaceGroup(1666573488);
                z29 = ((i5 > 4 || !gapComposer.changed(transitionInstance)) && (i3 & 6) != 4) ? z7 : true;
                objM8 = gapComposer.rememberedValue();
                if (z29 || objM8 == neverEqualPolicy) {
                    currentThreadSnapshot5 = Lock.getCurrentThreadSnapshot();
                    if (currentThreadSnapshot5 != null) {
                        readObserver5 = currentThreadSnapshot5.getReadObserver();
                    } else {
                        readObserver5 = null;
                    }
                    snapshotMakeCurrentNonObservable5 = Lock.makeCurrentNonObservable(currentThreadSnapshot5);
                    try {
                        Object currentState8 = transitionInstance.getCurrentState();
                        Lock.restoreNonObservable(currentThreadSnapshot5, snapshotMakeCurrentNonObservable5, readObserver5);
                        gapComposer.updateRememberedValue(currentState8);
                        objM8 = currentState8;
                    } catch (Throwable th8) {
                        Lock.restoreNonObservable(currentThreadSnapshot5, snapshotMakeCurrentNonObservable5, readObserver5);
                        throw th8;
                    }
                }
                gapComposer.endReplaceGroup();
            }
            gapComposer.startReplaceGroup(1193412116);
            long j23 = ((ColorScheme) objM8).onSecondaryFixedVariant;
            gapComposer.endReplaceGroup();
            Color colorM478boximpl15 = Color.m478boximpl(j23);
            z14 = ((i5 > 4 || !gapComposer.changed(transitionInstance)) && (i3 & 6) != 4) ? z7 : true;
            objRememberedValue20 = gapComposer.rememberedValue();
            if (z14 || objRememberedValue20 == neverEqualPolicy) {
                objRememberedValue20 = SnapshotStateKt__DerivedStateKt.derivedStateOf(new ColorSchemeKt$animateFixedColors$$inlined$animateColor$1(transitionInstance, (byte) 14));
                gapComposer.updateRememberedValue(objRememberedValue20);
            }
            ColorScheme colorScheme16 = (ColorScheme) ((State) objRememberedValue20).getValue();
            gapComposer.startReplaceGroup(1193412116);
            long j24 = colorScheme16.onSecondaryFixedVariant;
            gapComposer.endReplaceGroup();
            Color colorM478boximpl16 = Color.m478boximpl(j24);
            z15 = ((i5 > 4 || !gapComposer.changed(transitionInstance)) && (i3 & 6) != 4) ? z7 : true;
            objRememberedValue21 = gapComposer.rememberedValue();
            if (z15 || objRememberedValue21 == neverEqualPolicy) {
                objRememberedValue21 = SnapshotStateKt__DerivedStateKt.derivedStateOf(new ColorSchemeKt$animateFixedColors$$inlined$animateColor$1(transitionInstance, (byte) 15));
                gapComposer.updateRememberedValue(objRememberedValue21);
            }
            Transition.TransitionAnimationState transitionAnimationStateCreateTransitionAnimation8 = ArcSplineKt.createTransitionAnimation(transitionInstance, colorM478boximpl15, colorM478boximpl16, (FiniteAnimationSpec) function3.invoke(((State) objRememberedValue21).getValue(), gapComposer, Integer.valueOf(i6)), twoWayConverterImpl8, gapComposer, i7);
            ColorScheme colorScheme17 = (ColorScheme) transitionInstance.getTargetState();
            gapComposer.startReplaceGroup(426203248);
            long j25 = colorScheme17.tertiaryFixed;
            gapComposer.endReplaceGroup();
            colorSpaceM483getColorSpaceimpl8 = Color.m483getColorSpaceimpl(j25);
            zChanged8 = gapComposer.changed(colorSpaceM483getColorSpaceimpl8);
            objRememberedValue22 = gapComposer.rememberedValue();
            if (zChanged8 || objRememberedValue22 == neverEqualPolicy) {
                objRememberedValue22 = IntIntPair$$ExternalSyntheticOutline0.m(colorVectorConverterKt$ColorToVector$1$1, new CallsKt$await$2$1((byte) 1, colorSpaceM483getColorSpaceimpl8), gapComposer);
            }
            TwoWayConverterImpl twoWayConverterImpl9 = (TwoWayConverterImpl) objRememberedValue22;
            if (transitionInstance.isSeeking()) {
                objM9 = Format$$ExternalSyntheticOutline0.m(gapComposer, 1666827533, transitionInstance);
            } else {
                gapComposer.startReplaceGroup(1666573488);
                z28 = ((i5 > 4 || !gapComposer.changed(transitionInstance)) && (i3 & 6) != 4) ? z7 : true;
                objM9 = gapComposer.rememberedValue();
                if (z28 || objM9 == neverEqualPolicy) {
                    currentThreadSnapshot4 = Lock.getCurrentThreadSnapshot();
                    if (currentThreadSnapshot4 != null) {
                        readObserver4 = currentThreadSnapshot4.getReadObserver();
                    } else {
                        readObserver4 = null;
                    }
                    snapshotMakeCurrentNonObservable4 = Lock.makeCurrentNonObservable(currentThreadSnapshot4);
                    try {
                        Object currentState9 = transitionInstance.getCurrentState();
                        Lock.restoreNonObservable(currentThreadSnapshot4, snapshotMakeCurrentNonObservable4, readObserver4);
                        gapComposer.updateRememberedValue(currentState9);
                        objM9 = currentState9;
                    } catch (Throwable th9) {
                        Lock.restoreNonObservable(currentThreadSnapshot4, snapshotMakeCurrentNonObservable4, readObserver4);
                        throw th9;
                    }
                }
                gapComposer.endReplaceGroup();
            }
            gapComposer.startReplaceGroup(426203248);
            long j26 = ((ColorScheme) objM9).tertiaryFixed;
            gapComposer.endReplaceGroup();
            Color colorM478boximpl17 = Color.m478boximpl(j26);
            z16 = ((i5 > 4 || !gapComposer.changed(transitionInstance)) && (i3 & 6) != 4) ? z7 : true;
            objRememberedValue23 = gapComposer.rememberedValue();
            if (z16 || objRememberedValue23 == neverEqualPolicy) {
                objRememberedValue23 = SnapshotStateKt__DerivedStateKt.derivedStateOf(new ColorSchemeKt$animateFixedColors$$inlined$animateColor$1(transitionInstance, (byte) 16));
                gapComposer.updateRememberedValue(objRememberedValue23);
            }
            ColorScheme colorScheme18 = (ColorScheme) ((State) objRememberedValue23).getValue();
            gapComposer.startReplaceGroup(426203248);
            long j27 = colorScheme18.tertiaryFixed;
            gapComposer.endReplaceGroup();
            Color colorM478boximpl18 = Color.m478boximpl(j27);
            z17 = ((i5 > 4 || !gapComposer.changed(transitionInstance)) && (i3 & 6) != 4) ? z7 : true;
            objRememberedValue24 = gapComposer.rememberedValue();
            if (z17 || objRememberedValue24 == neverEqualPolicy) {
                objRememberedValue24 = SnapshotStateKt__DerivedStateKt.derivedStateOf(new ColorSchemeKt$animateFixedColors$$inlined$animateColor$1(transitionInstance, (byte) 17));
                gapComposer.updateRememberedValue(objRememberedValue24);
            }
            Transition.TransitionAnimationState transitionAnimationStateCreateTransitionAnimation9 = ArcSplineKt.createTransitionAnimation(transitionInstance, colorM478boximpl17, colorM478boximpl18, (FiniteAnimationSpec) function3.invoke(((State) objRememberedValue24).getValue(), gapComposer, Integer.valueOf(i6)), twoWayConverterImpl9, gapComposer, i7);
            ColorScheme colorScheme19 = (ColorScheme) transitionInstance.getTargetState();
            gapComposer.startReplaceGroup(348506592);
            long j28 = colorScheme19.tertiaryFixedDim;
            gapComposer.endReplaceGroup();
            colorSpaceM483getColorSpaceimpl9 = Color.m483getColorSpaceimpl(j28);
            zChanged9 = gapComposer.changed(colorSpaceM483getColorSpaceimpl9);
            objRememberedValue25 = gapComposer.rememberedValue();
            if (zChanged9 || objRememberedValue25 == neverEqualPolicy) {
                objRememberedValue25 = IntIntPair$$ExternalSyntheticOutline0.m(colorVectorConverterKt$ColorToVector$1$1, new CallsKt$await$2$1((byte) 1, colorSpaceM483getColorSpaceimpl9), gapComposer);
            }
            TwoWayConverterImpl twoWayConverterImpl10 = (TwoWayConverterImpl) objRememberedValue25;
            if (transitionInstance.isSeeking()) {
                objM10 = Format$$ExternalSyntheticOutline0.m(gapComposer, 1666827533, transitionInstance);
            } else {
                gapComposer.startReplaceGroup(1666573488);
                z27 = ((i5 > 4 || !gapComposer.changed(transitionInstance)) && (i3 & 6) != 4) ? z7 : true;
                objM10 = gapComposer.rememberedValue();
                if (z27 || objM10 == neverEqualPolicy) {
                    currentThreadSnapshot3 = Lock.getCurrentThreadSnapshot();
                    if (currentThreadSnapshot3 != null) {
                        readObserver3 = currentThreadSnapshot3.getReadObserver();
                    } else {
                        readObserver3 = null;
                    }
                    snapshotMakeCurrentNonObservable3 = Lock.makeCurrentNonObservable(currentThreadSnapshot3);
                    try {
                        Object currentState10 = transitionInstance.getCurrentState();
                        Lock.restoreNonObservable(currentThreadSnapshot3, snapshotMakeCurrentNonObservable3, readObserver3);
                        gapComposer.updateRememberedValue(currentState10);
                        objM10 = currentState10;
                    } catch (Throwable th10) {
                        Lock.restoreNonObservable(currentThreadSnapshot3, snapshotMakeCurrentNonObservable3, readObserver3);
                        throw th10;
                    }
                }
                gapComposer.endReplaceGroup();
            }
            gapComposer.startReplaceGroup(348506592);
            long j29 = ((ColorScheme) objM10).tertiaryFixedDim;
            gapComposer.endReplaceGroup();
            Color colorM478boximpl19 = Color.m478boximpl(j29);
            z18 = ((i5 > 4 || !gapComposer.changed(transitionInstance)) && (i3 & 6) != 4) ? z7 : true;
            objRememberedValue26 = gapComposer.rememberedValue();
            if (z18 || objRememberedValue26 == neverEqualPolicy) {
                objRememberedValue26 = SnapshotStateKt__DerivedStateKt.derivedStateOf(new ColorSchemeKt$animateFixedColors$$inlined$animateColor$1(transitionInstance, (byte) 18));
                gapComposer.updateRememberedValue(objRememberedValue26);
            }
            ColorScheme colorScheme20 = (ColorScheme) ((State) objRememberedValue26).getValue();
            gapComposer.startReplaceGroup(348506592);
            long j30 = colorScheme20.tertiaryFixedDim;
            gapComposer.endReplaceGroup();
            Color colorM478boximpl20 = Color.m478boximpl(j30);
            z19 = ((i5 > 4 || !gapComposer.changed(transitionInstance)) && (i3 & 6) != 4) ? z7 : true;
            objRememberedValue27 = gapComposer.rememberedValue();
            if (z19 || objRememberedValue27 == neverEqualPolicy) {
                objRememberedValue27 = SnapshotStateKt__DerivedStateKt.derivedStateOf(new ColorSchemeKt$animateFixedColors$$inlined$animateColor$1(transitionInstance, (byte) 19));
                gapComposer.updateRememberedValue(objRememberedValue27);
            }
            Transition.TransitionAnimationState transitionAnimationStateCreateTransitionAnimation10 = ArcSplineKt.createTransitionAnimation(transitionInstance, colorM478boximpl19, colorM478boximpl20, (FiniteAnimationSpec) function3.invoke(((State) objRememberedValue27).getValue(), gapComposer, Integer.valueOf(i6)), twoWayConverterImpl10, gapComposer, i7);
            ColorScheme colorScheme21 = (ColorScheme) transitionInstance.getTargetState();
            gapComposer.startReplaceGroup(-2070125551);
            long j31 = colorScheme21.onTertiaryFixed;
            gapComposer.endReplaceGroup();
            colorSpaceM483getColorSpaceimpl10 = Color.m483getColorSpaceimpl(j31);
            zChanged10 = gapComposer.changed(colorSpaceM483getColorSpaceimpl10);
            objRememberedValue28 = gapComposer.rememberedValue();
            if (zChanged10 || objRememberedValue28 == neverEqualPolicy) {
                objRememberedValue28 = IntIntPair$$ExternalSyntheticOutline0.m(colorVectorConverterKt$ColorToVector$1$1, new CallsKt$await$2$1((byte) 1, colorSpaceM483getColorSpaceimpl10), gapComposer);
            }
            TwoWayConverterImpl twoWayConverterImpl11 = (TwoWayConverterImpl) objRememberedValue28;
            if (transitionInstance.isSeeking()) {
                objM11 = Format$$ExternalSyntheticOutline0.m(gapComposer, 1666827533, transitionInstance);
            } else {
                gapComposer.startReplaceGroup(1666573488);
                z26 = ((i5 > 4 || !gapComposer.changed(transitionInstance)) && (i3 & 6) != 4) ? z7 : true;
                objM11 = gapComposer.rememberedValue();
                if (z26 || objM11 == neverEqualPolicy) {
                    currentThreadSnapshot2 = Lock.getCurrentThreadSnapshot();
                    if (currentThreadSnapshot2 != null) {
                        readObserver2 = currentThreadSnapshot2.getReadObserver();
                    } else {
                        readObserver2 = null;
                    }
                    snapshotMakeCurrentNonObservable2 = Lock.makeCurrentNonObservable(currentThreadSnapshot2);
                    try {
                        Object currentState11 = transitionInstance.getCurrentState();
                        Lock.restoreNonObservable(currentThreadSnapshot2, snapshotMakeCurrentNonObservable2, readObserver2);
                        gapComposer.updateRememberedValue(currentState11);
                        objM11 = currentState11;
                    } catch (Throwable th11) {
                        Lock.restoreNonObservable(currentThreadSnapshot2, snapshotMakeCurrentNonObservable2, readObserver2);
                        throw th11;
                    }
                }
                gapComposer.endReplaceGroup();
            }
            gapComposer.startReplaceGroup(-2070125551);
            long j32 = ((ColorScheme) objM11).onTertiaryFixed;
            gapComposer.endReplaceGroup();
            Color colorM478boximpl21 = Color.m478boximpl(j32);
            z20 = ((i5 > 4 || !gapComposer.changed(transitionInstance)) && (i3 & 6) != 4) ? z7 : true;
            objRememberedValue29 = gapComposer.rememberedValue();
            if (z20 || objRememberedValue29 == neverEqualPolicy) {
                objRememberedValue29 = SnapshotStateKt__DerivedStateKt.derivedStateOf(new ColorSchemeKt$animateFixedColors$$inlined$animateColor$1(transitionInstance, (byte) 20));
                gapComposer.updateRememberedValue(objRememberedValue29);
            }
            ColorScheme colorScheme22 = (ColorScheme) ((State) objRememberedValue29).getValue();
            gapComposer.startReplaceGroup(-2070125551);
            long j33 = colorScheme22.onTertiaryFixed;
            gapComposer.endReplaceGroup();
            Color colorM478boximpl22 = Color.m478boximpl(j33);
            z21 = ((i5 > 4 || !gapComposer.changed(transitionInstance)) && (i3 & 6) != 4) ? z7 : true;
            objRememberedValue30 = gapComposer.rememberedValue();
            if (z21 || objRememberedValue30 == neverEqualPolicy) {
                objRememberedValue30 = SnapshotStateKt__DerivedStateKt.derivedStateOf(new ColorSchemeKt$animateFixedColors$$inlined$animateColor$1(transitionInstance, (byte) 21));
                gapComposer.updateRememberedValue(objRememberedValue30);
            }
            Transition.TransitionAnimationState transitionAnimationStateCreateTransitionAnimation11 = ArcSplineKt.createTransitionAnimation(transitionInstance, colorM478boximpl21, colorM478boximpl22, (FiniteAnimationSpec) function3.invoke(((State) objRememberedValue30).getValue(), gapComposer, Integer.valueOf(i6)), twoWayConverterImpl11, gapComposer, i7);
            ColorScheme colorScheme23 = (ColorScheme) transitionInstance.getTargetState();
            gapComposer.startReplaceGroup(1502375900);
            long j34 = colorScheme23.onTertiaryFixedVariant;
            gapComposer.endReplaceGroup();
            colorSpaceM483getColorSpaceimpl11 = Color.m483getColorSpaceimpl(j34);
            zChanged11 = gapComposer.changed(colorSpaceM483getColorSpaceimpl11);
            Object objRememberedValue36 = gapComposer.rememberedValue();
            if (!zChanged11 || objRememberedValue36 == neverEqualPolicy) {
                z22 = true;
                objM12 = IntIntPair$$ExternalSyntheticOutline0.m(colorVectorConverterKt$ColorToVector$1$1, new CallsKt$await$2$1((byte) 1, colorSpaceM483getColorSpaceimpl11), gapComposer);
            } else {
                objM12 = objRememberedValue36;
                z22 = true;
            }
            TwoWayConverterImpl twoWayConverterImpl12 = (TwoWayConverterImpl) objM12;
            if (transitionInstance.isSeeking()) {
                objM13 = Format$$ExternalSyntheticOutline0.m(gapComposer, 1666827533, transitionInstance);
            } else {
                gapComposer.startReplaceGroup(1666573488);
                z25 = ((i5 > 4 || !gapComposer.changed(transitionInstance)) && (i3 & 6) != 4) ? z7 : z22;
                objM13 = gapComposer.rememberedValue();
                if (z25 || objM13 == neverEqualPolicy) {
                    currentThreadSnapshot = Lock.getCurrentThreadSnapshot();
                    if (currentThreadSnapshot != null) {
                        readObserver = currentThreadSnapshot.getReadObserver();
                    } else {
                        readObserver = null;
                    }
                    snapshotMakeCurrentNonObservable = Lock.makeCurrentNonObservable(currentThreadSnapshot);
                    try {
                        Object currentState12 = transitionInstance.getCurrentState();
                        Lock.restoreNonObservable(currentThreadSnapshot, snapshotMakeCurrentNonObservable, readObserver);
                        gapComposer.updateRememberedValue(currentState12);
                        objM13 = currentState12;
                    } catch (Throwable th12) {
                        Lock.restoreNonObservable(currentThreadSnapshot, snapshotMakeCurrentNonObservable, readObserver);
                        throw th12;
                    }
                }
                gapComposer.endReplaceGroup();
            }
            gapComposer.startReplaceGroup(1502375900);
            long j35 = ((ColorScheme) objM13).onTertiaryFixedVariant;
            gapComposer.endReplaceGroup();
            Color colorM478boximpl23 = Color.m478boximpl(j35);
            z23 = ((i5 > 4 || !gapComposer.changed(transitionInstance)) && (i3 & 6) != 4) ? z7 : true;
            objRememberedValue31 = gapComposer.rememberedValue();
            if (z23 || objRememberedValue31 == neverEqualPolicy) {
                objRememberedValue31 = SnapshotStateKt__DerivedStateKt.derivedStateOf(new ColorSchemeKt$animateFixedColors$$inlined$animateColor$1(transitionInstance, (byte) 22));
                gapComposer.updateRememberedValue(objRememberedValue31);
            }
            ColorScheme colorScheme24 = (ColorScheme) ((State) objRememberedValue31).getValue();
            gapComposer.startReplaceGroup(1502375900);
            long j36 = colorScheme24.onTertiaryFixedVariant;
            gapComposer.endReplaceGroup();
            Color colorM478boximpl24 = Color.m478boximpl(j36);
            z24 = ((i5 > 4 || !gapComposer.changed(transitionInstance)) && (i3 & 6) != 4) ? z7 : true;
            objRememberedValue32 = gapComposer.rememberedValue();
            if (z24 || objRememberedValue32 == neverEqualPolicy) {
                objRememberedValue32 = SnapshotStateKt__DerivedStateKt.derivedStateOf(new ColorSchemeKt$animateFixedColors$$inlined$animateColor$1(transitionInstance, (byte) 23));
                gapComposer.updateRememberedValue(objRememberedValue32);
            }
            return CollectionsKt__IterablesKt.listOf((Object[]) new Color[]{Color.m478boximpl(animateFixedColors$lambda$1(transitionAnimationStateCreateTransitionAnimation)), Color.m478boximpl(animateFixedColors$lambda$3(transitionAnimationStateCreateTransitionAnimation2)), Color.m478boximpl(animateFixedColors$lambda$5(transitionAnimationStateCreateTransitionAnimation3)), Color.m478boximpl(animateFixedColors$lambda$7(transitionAnimationStateCreateTransitionAnimation4)), Color.m478boximpl(animateFixedColors$lambda$9(transitionAnimationStateCreateTransitionAnimation5)), Color.m478boximpl(animateFixedColors$lambda$11(transitionAnimationStateCreateTransitionAnimation6)), Color.m478boximpl(animateFixedColors$lambda$13(transitionAnimationStateCreateTransitionAnimation7)), Color.m478boximpl(animateFixedColors$lambda$15(transitionAnimationStateCreateTransitionAnimation8)), Color.m478boximpl(animateFixedColors$lambda$17(transitionAnimationStateCreateTransitionAnimation9)), Color.m478boximpl(animateFixedColors$lambda$19(transitionAnimationStateCreateTransitionAnimation10)), Color.m478boximpl(animateFixedColors$lambda$21(transitionAnimationStateCreateTransitionAnimation11)), Color.m478boximpl(animateFixedColors$lambda$23(ArcSplineKt.createTransitionAnimation(transitionInstance, colorM478boximpl23, colorM478boximpl24, (FiniteAnimationSpec) function3.invoke(((State) objRememberedValue32).getValue(), gapComposer, Integer.valueOf(i6)), twoWayConverterImpl12, gapComposer, i7)))});
        }
        neverEqualPolicy = neverEqualPolicy2;
        objRememberedValue35 = SnapshotStateKt__DerivedStateKt.derivedStateOf(new ColorSchemeKt$animateFixedColors$$inlined$animateColor$1(transitionInstance, (byte) 24));
        gapComposer.updateRememberedValue(objRememberedValue35);
        int i8 = (i3 >> 3) & 112;
        int i9 = i4 | 196608;
        Transition.TransitionAnimationState transitionAnimationStateCreateTransitionAnimation12 = ArcSplineKt.createTransitionAnimation(transitionInstance, colorM478boximpl, colorM478boximpl2, (FiniteAnimationSpec) function3.invoke(((State) objRememberedValue35).getValue(), gapComposer, Integer.valueOf(i8)), twoWayConverterImpl, gapComposer, i9);
        ColorScheme colorScheme25 = (ColorScheme) transitionInstance.getTargetState();
        gapComposer.startReplaceGroup(-1062804668);
        long j37 = colorScheme25.primaryFixedDim;
        gapComposer.endReplaceGroup();
        colorSpaceM483getColorSpaceimpl = Color.m483getColorSpaceimpl(j37);
        zChanged = gapComposer.changed(colorSpaceM483getColorSpaceimpl);
        objRememberedValue = gapComposer.rememberedValue();
        if (zChanged) {
            objRememberedValue = IntIntPair$$ExternalSyntheticOutline0.m(colorVectorConverterKt$ColorToVector$1$1, new CallsKt$await$2$1((byte) 1, colorSpaceM483getColorSpaceimpl), gapComposer);
        } else {
            objRememberedValue = IntIntPair$$ExternalSyntheticOutline0.m(colorVectorConverterKt$ColorToVector$1$1, new CallsKt$await$2$1((byte) 1, colorSpaceM483getColorSpaceimpl), gapComposer);
        }
        TwoWayConverterImpl twoWayConverterImpl13 = (TwoWayConverterImpl) objRememberedValue;
        if (transitionInstance.isSeeking()) {
            gapComposer.startReplaceGroup(1666573488);
            if (i5 <= 4) {
            }
            objM2 = gapComposer.rememberedValue();
            if (z35) {
                currentThreadSnapshot11 = Lock.getCurrentThreadSnapshot();
                if (currentThreadSnapshot11 != null) {
                    readObserver11 = currentThreadSnapshot11.getReadObserver();
                } else {
                    readObserver11 = null;
                }
                snapshotMakeCurrentNonObservable11 = Lock.makeCurrentNonObservable(currentThreadSnapshot11);
                Object currentState13 = transitionInstance.getCurrentState();
                Lock.restoreNonObservable(currentThreadSnapshot11, snapshotMakeCurrentNonObservable11, readObserver11);
                gapComposer.updateRememberedValue(currentState13);
                objM2 = currentState13;
            } else {
                currentThreadSnapshot11 = Lock.getCurrentThreadSnapshot();
                if (currentThreadSnapshot11 != null) {
                    readObserver11 = currentThreadSnapshot11.getReadObserver();
                } else {
                    readObserver11 = null;
                }
                snapshotMakeCurrentNonObservable11 = Lock.makeCurrentNonObservable(currentThreadSnapshot11);
                Object currentState14 = transitionInstance.getCurrentState();
                Lock.restoreNonObservable(currentThreadSnapshot11, snapshotMakeCurrentNonObservable11, readObserver11);
                gapComposer.updateRememberedValue(currentState14);
                objM2 = currentState14;
            }
            gapComposer.endReplaceGroup();
        } else {
            objM2 = Format$$ExternalSyntheticOutline0.m(gapComposer, 1666827533, transitionInstance);
        }
        gapComposer.startReplaceGroup(-1062804668);
        long j38 = ((ColorScheme) objM2).primaryFixedDim;
        gapComposer.endReplaceGroup();
        Color colorM478boximpl25 = Color.m478boximpl(j38);
        if (i5 <= 4) {
        }
        objRememberedValue2 = gapComposer.rememberedValue();
        if (z) {
            objRememberedValue2 = SnapshotStateKt__DerivedStateKt.derivedStateOf(new ColorSchemeKt$animateFixedColors$$inlined$animateColor$1(transitionInstance, (byte) 25));
            gapComposer.updateRememberedValue(objRememberedValue2);
        } else {
            objRememberedValue2 = SnapshotStateKt__DerivedStateKt.derivedStateOf(new ColorSchemeKt$animateFixedColors$$inlined$animateColor$1(transitionInstance, (byte) 25));
            gapComposer.updateRememberedValue(objRememberedValue2);
        }
        ColorScheme colorScheme26 = (ColorScheme) ((State) objRememberedValue2).getValue();
        gapComposer.startReplaceGroup(-1062804668);
        long j39 = colorScheme26.primaryFixedDim;
        gapComposer.endReplaceGroup();
        Color colorM478boximpl26 = Color.m478boximpl(j39);
        if (i5 <= 4) {
        }
        objRememberedValue3 = gapComposer.rememberedValue();
        if (z2) {
            objRememberedValue3 = SnapshotStateKt__DerivedStateKt.derivedStateOf(new ColorSchemeKt$animateFixedColors$$inlined$animateColor$1(transitionInstance, (byte) 26));
            gapComposer.updateRememberedValue(objRememberedValue3);
        } else {
            objRememberedValue3 = SnapshotStateKt__DerivedStateKt.derivedStateOf(new ColorSchemeKt$animateFixedColors$$inlined$animateColor$1(transitionInstance, (byte) 26));
            gapComposer.updateRememberedValue(objRememberedValue3);
        }
        Transition.TransitionAnimationState transitionAnimationStateCreateTransitionAnimation13 = ArcSplineKt.createTransitionAnimation(transitionInstance, colorM478boximpl25, colorM478boximpl26, (FiniteAnimationSpec) function3.invoke(((State) objRememberedValue3).getValue(), gapComposer, Integer.valueOf(i8)), twoWayConverterImpl13, gapComposer, i9);
        ColorScheme colorScheme27 = (ColorScheme) transitionInstance.getTargetState();
        gapComposer.startReplaceGroup(-1037969973);
        long j40 = colorScheme27.onPrimaryFixed;
        gapComposer.endReplaceGroup();
        colorSpaceM483getColorSpaceimpl2 = Color.m483getColorSpaceimpl(j40);
        zChanged2 = gapComposer.changed(colorSpaceM483getColorSpaceimpl2);
        objRememberedValue4 = gapComposer.rememberedValue();
        if (zChanged2) {
            objRememberedValue4 = IntIntPair$$ExternalSyntheticOutline0.m(colorVectorConverterKt$ColorToVector$1$1, new CallsKt$await$2$1((byte) 1, colorSpaceM483getColorSpaceimpl2), gapComposer);
        } else {
            objRememberedValue4 = IntIntPair$$ExternalSyntheticOutline0.m(colorVectorConverterKt$ColorToVector$1$1, new CallsKt$await$2$1((byte) 1, colorSpaceM483getColorSpaceimpl2), gapComposer);
        }
        TwoWayConverterImpl twoWayConverterImpl14 = (TwoWayConverterImpl) objRememberedValue4;
        if (transitionInstance.isSeeking()) {
            gapComposer.startReplaceGroup(1666573488);
            if (i5 <= 4) {
            }
            objM3 = gapComposer.rememberedValue();
            if (z34) {
                currentThreadSnapshot10 = Lock.getCurrentThreadSnapshot();
                if (currentThreadSnapshot10 != null) {
                    readObserver10 = currentThreadSnapshot10.getReadObserver();
                } else {
                    readObserver10 = null;
                }
                snapshotMakeCurrentNonObservable10 = Lock.makeCurrentNonObservable(currentThreadSnapshot10);
                Object currentState15 = transitionInstance.getCurrentState();
                Lock.restoreNonObservable(currentThreadSnapshot10, snapshotMakeCurrentNonObservable10, readObserver10);
                gapComposer.updateRememberedValue(currentState15);
                objM3 = currentState15;
            } else {
                currentThreadSnapshot10 = Lock.getCurrentThreadSnapshot();
                if (currentThreadSnapshot10 != null) {
                    readObserver10 = currentThreadSnapshot10.getReadObserver();
                } else {
                    readObserver10 = null;
                }
                snapshotMakeCurrentNonObservable10 = Lock.makeCurrentNonObservable(currentThreadSnapshot10);
                Object currentState16 = transitionInstance.getCurrentState();
                Lock.restoreNonObservable(currentThreadSnapshot10, snapshotMakeCurrentNonObservable10, readObserver10);
                gapComposer.updateRememberedValue(currentState16);
                objM3 = currentState16;
            }
            gapComposer.endReplaceGroup();
        } else {
            objM3 = Format$$ExternalSyntheticOutline0.m(gapComposer, 1666827533, transitionInstance);
        }
        gapComposer.startReplaceGroup(-1037969973);
        long j41 = ((ColorScheme) objM3).onPrimaryFixed;
        gapComposer.endReplaceGroup();
        Color colorM478boximpl27 = Color.m478boximpl(j41);
        if (i5 <= 4) {
        }
        objRememberedValue5 = gapComposer.rememberedValue();
        if (z3) {
            objRememberedValue5 = SnapshotStateKt__DerivedStateKt.derivedStateOf(new ColorSchemeKt$animateFixedColors$$inlined$animateColor$1(transitionInstance, (byte) 27));
            gapComposer.updateRememberedValue(objRememberedValue5);
        } else {
            objRememberedValue5 = SnapshotStateKt__DerivedStateKt.derivedStateOf(new ColorSchemeKt$animateFixedColors$$inlined$animateColor$1(transitionInstance, (byte) 27));
            gapComposer.updateRememberedValue(objRememberedValue5);
        }
        ColorScheme colorScheme28 = (ColorScheme) ((State) objRememberedValue5).getValue();
        gapComposer.startReplaceGroup(-1037969973);
        long j42 = colorScheme28.onPrimaryFixed;
        gapComposer.endReplaceGroup();
        Color colorM478boximpl28 = Color.m478boximpl(j42);
        if (i5 <= 4) {
        }
        objRememberedValue6 = gapComposer.rememberedValue();
        if (z4) {
            objRememberedValue6 = SnapshotStateKt__DerivedStateKt.derivedStateOf(new ColorSchemeKt$animateFixedColors$$inlined$animateColor$1(transitionInstance, (byte) 28));
            gapComposer.updateRememberedValue(objRememberedValue6);
        } else {
            objRememberedValue6 = SnapshotStateKt__DerivedStateKt.derivedStateOf(new ColorSchemeKt$animateFixedColors$$inlined$animateColor$1(transitionInstance, (byte) 28));
            gapComposer.updateRememberedValue(objRememberedValue6);
        }
        Transition.TransitionAnimationState transitionAnimationStateCreateTransitionAnimation14 = ArcSplineKt.createTransitionAnimation(transitionInstance, colorM478boximpl27, colorM478boximpl28, (FiniteAnimationSpec) function3.invoke(((State) objRememberedValue6).getValue(), gapComposer, Integer.valueOf(i8)), twoWayConverterImpl14, gapComposer, i9);
        ColorScheme colorScheme29 = (ColorScheme) transitionInstance.getTargetState();
        gapComposer.startReplaceGroup(-1429178142);
        long j110 = colorScheme29.onPrimaryFixedVariant;
        gapComposer.endReplaceGroup();
        colorSpaceM483getColorSpaceimpl3 = Color.m483getColorSpaceimpl(j110);
        zChanged3 = gapComposer.changed(colorSpaceM483getColorSpaceimpl3);
        objRememberedValue7 = gapComposer.rememberedValue();
        if (zChanged3) {
            objRememberedValue7 = IntIntPair$$ExternalSyntheticOutline0.m(colorVectorConverterKt$ColorToVector$1$1, new CallsKt$await$2$1((byte) 1, colorSpaceM483getColorSpaceimpl3), gapComposer);
        } else {
            objRememberedValue7 = IntIntPair$$ExternalSyntheticOutline0.m(colorVectorConverterKt$ColorToVector$1$1, new CallsKt$await$2$1((byte) 1, colorSpaceM483getColorSpaceimpl3), gapComposer);
        }
        TwoWayConverterImpl twoWayConverterImpl15 = (TwoWayConverterImpl) objRememberedValue7;
        if (transitionInstance.isSeeking()) {
            gapComposer.startReplaceGroup(1666573488);
            if (i5 <= 4) {
            }
            objM4 = gapComposer.rememberedValue();
            if (z33) {
                currentThreadSnapshot9 = Lock.getCurrentThreadSnapshot();
                if (currentThreadSnapshot9 != null) {
                    readObserver9 = currentThreadSnapshot9.getReadObserver();
                } else {
                    readObserver9 = null;
                }
                snapshotMakeCurrentNonObservable9 = Lock.makeCurrentNonObservable(currentThreadSnapshot9);
                Object currentState17 = transitionInstance.getCurrentState();
                Lock.restoreNonObservable(currentThreadSnapshot9, snapshotMakeCurrentNonObservable9, readObserver9);
                gapComposer.updateRememberedValue(currentState17);
                objM4 = currentState17;
            } else {
                currentThreadSnapshot9 = Lock.getCurrentThreadSnapshot();
                if (currentThreadSnapshot9 != null) {
                    readObserver9 = currentThreadSnapshot9.getReadObserver();
                } else {
                    readObserver9 = null;
                }
                snapshotMakeCurrentNonObservable9 = Lock.makeCurrentNonObservable(currentThreadSnapshot9);
                Object currentState18 = transitionInstance.getCurrentState();
                Lock.restoreNonObservable(currentThreadSnapshot9, snapshotMakeCurrentNonObservable9, readObserver9);
                gapComposer.updateRememberedValue(currentState18);
                objM4 = currentState18;
            }
            gapComposer.endReplaceGroup();
        } else {
            objM4 = Format$$ExternalSyntheticOutline0.m(gapComposer, 1666827533, transitionInstance);
        }
        gapComposer.startReplaceGroup(-1429178142);
        long j111 = ((ColorScheme) objM4).onPrimaryFixedVariant;
        gapComposer.endReplaceGroup();
        Color colorM478boximpl29 = Color.m478boximpl(j111);
        if (i5 <= 4) {
        }
        objRememberedValue8 = gapComposer.rememberedValue();
        if (z5) {
            objRememberedValue8 = SnapshotStateKt__DerivedStateKt.derivedStateOf(new ColorSchemeKt$animateFixedColors$$inlined$animateColor$1(transitionInstance, (byte) 29));
            gapComposer.updateRememberedValue(objRememberedValue8);
        } else {
            objRememberedValue8 = SnapshotStateKt__DerivedStateKt.derivedStateOf(new ColorSchemeKt$animateFixedColors$$inlined$animateColor$1(transitionInstance, (byte) 29));
            gapComposer.updateRememberedValue(objRememberedValue8);
        }
        ColorScheme colorScheme30 = (ColorScheme) ((State) objRememberedValue8).getValue();
        gapComposer.startReplaceGroup(-1429178142);
        long j112 = colorScheme30.onPrimaryFixedVariant;
        gapComposer.endReplaceGroup();
        Color colorM478boximpl30 = Color.m478boximpl(j112);
        if (i5 <= 4) {
        }
        objRememberedValue9 = gapComposer.rememberedValue();
        if (z6) {
            objRememberedValue9 = SnapshotStateKt__DerivedStateKt.derivedStateOf(new ColorSchemeKt$animateFixedColors$$inlined$animateColor$8(transitionInstance, (byte) 0));
            gapComposer.updateRememberedValue(objRememberedValue9);
        } else {
            objRememberedValue9 = SnapshotStateKt__DerivedStateKt.derivedStateOf(new ColorSchemeKt$animateFixedColors$$inlined$animateColor$8(transitionInstance, (byte) 0));
            gapComposer.updateRememberedValue(objRememberedValue9);
        }
        Transition.TransitionAnimationState transitionAnimationStateCreateTransitionAnimation15 = ArcSplineKt.createTransitionAnimation(transitionInstance, colorM478boximpl29, colorM478boximpl30, (FiniteAnimationSpec) function3.invoke(((State) objRememberedValue9).getValue(), gapComposer, Integer.valueOf(i8)), twoWayConverterImpl15, gapComposer, i9);
        ColorScheme colorScheme31 = (ColorScheme) transitionInstance.getTargetState();
        gapComposer.startReplaceGroup(-489786278);
        long j113 = colorScheme31.secondaryFixed;
        gapComposer.endReplaceGroup();
        colorSpaceM483getColorSpaceimpl4 = Color.m483getColorSpaceimpl(j113);
        zChanged4 = gapComposer.changed(colorSpaceM483getColorSpaceimpl4);
        objRememberedValue10 = gapComposer.rememberedValue();
        if (zChanged4) {
            z7 = false;
            objRememberedValue10 = IntIntPair$$ExternalSyntheticOutline0.m(colorVectorConverterKt$ColorToVector$1$1, new CallsKt$await$2$1((byte) 1, colorSpaceM483getColorSpaceimpl4), gapComposer);
        } else {
            z7 = false;
            objRememberedValue10 = IntIntPair$$ExternalSyntheticOutline0.m(colorVectorConverterKt$ColorToVector$1$1, new CallsKt$await$2$1((byte) 1, colorSpaceM483getColorSpaceimpl4), gapComposer);
        }
        TwoWayConverterImpl twoWayConverterImpl16 = (TwoWayConverterImpl) objRememberedValue10;
        if (transitionInstance.isSeeking()) {
            gapComposer.startReplaceGroup(1666573488);
            if (i5 > 4) {
            }
            objM5 = gapComposer.rememberedValue();
            if (z32) {
                currentThreadSnapshot8 = Lock.getCurrentThreadSnapshot();
                if (currentThreadSnapshot8 != null) {
                    readObserver8 = currentThreadSnapshot8.getReadObserver();
                } else {
                    readObserver8 = null;
                }
                snapshotMakeCurrentNonObservable8 = Lock.makeCurrentNonObservable(currentThreadSnapshot8);
                Object currentState19 = transitionInstance.getCurrentState();
                Lock.restoreNonObservable(currentThreadSnapshot8, snapshotMakeCurrentNonObservable8, readObserver8);
                gapComposer.updateRememberedValue(currentState19);
                objM5 = currentState19;
            } else {
                currentThreadSnapshot8 = Lock.getCurrentThreadSnapshot();
                if (currentThreadSnapshot8 != null) {
                    readObserver8 = currentThreadSnapshot8.getReadObserver();
                } else {
                    readObserver8 = null;
                }
                snapshotMakeCurrentNonObservable8 = Lock.makeCurrentNonObservable(currentThreadSnapshot8);
                Object currentState110 = transitionInstance.getCurrentState();
                Lock.restoreNonObservable(currentThreadSnapshot8, snapshotMakeCurrentNonObservable8, readObserver8);
                gapComposer.updateRememberedValue(currentState110);
                objM5 = currentState110;
            }
            gapComposer.endReplaceGroup();
        } else {
            objM5 = Format$$ExternalSyntheticOutline0.m(gapComposer, 1666827533, transitionInstance);
        }
        gapComposer.startReplaceGroup(-489786278);
        long j114 = ((ColorScheme) objM5).secondaryFixed;
        gapComposer.endReplaceGroup();
        Color colorM478boximpl31 = Color.m478boximpl(j114);
        if (i5 > 4) {
        }
        objRememberedValue11 = gapComposer.rememberedValue();
        if (z8) {
            objRememberedValue11 = SnapshotStateKt__DerivedStateKt.derivedStateOf(new ColorSchemeKt$animateFixedColors$$inlined$animateColor$8(transitionInstance, (byte) 1));
            gapComposer.updateRememberedValue(objRememberedValue11);
        } else {
            objRememberedValue11 = SnapshotStateKt__DerivedStateKt.derivedStateOf(new ColorSchemeKt$animateFixedColors$$inlined$animateColor$8(transitionInstance, (byte) 1));
            gapComposer.updateRememberedValue(objRememberedValue11);
        }
        ColorScheme colorScheme110 = (ColorScheme) ((State) objRememberedValue11).getValue();
        gapComposer.startReplaceGroup(-489786278);
        long j115 = colorScheme110.secondaryFixed;
        gapComposer.endReplaceGroup();
        Color colorM478boximpl110 = Color.m478boximpl(j115);
        if (i5 > 4) {
        }
        objRememberedValue12 = gapComposer.rememberedValue();
        if (z9) {
            objRememberedValue12 = SnapshotStateKt__DerivedStateKt.derivedStateOf(new ColorSchemeKt$animateFixedColors$$inlined$animateColor$1(transitionInstance, (byte) 9));
            gapComposer.updateRememberedValue(objRememberedValue12);
        } else {
            objRememberedValue12 = SnapshotStateKt__DerivedStateKt.derivedStateOf(new ColorSchemeKt$animateFixedColors$$inlined$animateColor$1(transitionInstance, (byte) 9));
            gapComposer.updateRememberedValue(objRememberedValue12);
        }
        Transition.TransitionAnimationState transitionAnimationStateCreateTransitionAnimation16 = ArcSplineKt.createTransitionAnimation(transitionInstance, colorM478boximpl31, colorM478boximpl110, (FiniteAnimationSpec) function3.invoke(((State) objRememberedValue12).getValue(), gapComposer, Integer.valueOf(i8)), twoWayConverterImpl16, gapComposer, i9);
        ColorScheme colorScheme111 = (ColorScheme) transitionInstance.getTargetState();
        gapComposer.startReplaceGroup(-1968230986);
        long j116 = colorScheme111.secondaryFixedDim;
        gapComposer.endReplaceGroup();
        colorSpaceM483getColorSpaceimpl5 = Color.m483getColorSpaceimpl(j116);
        zChanged5 = gapComposer.changed(colorSpaceM483getColorSpaceimpl5);
        objRememberedValue13 = gapComposer.rememberedValue();
        if (zChanged5) {
            objRememberedValue13 = IntIntPair$$ExternalSyntheticOutline0.m(colorVectorConverterKt$ColorToVector$1$1, new CallsKt$await$2$1((byte) 1, colorSpaceM483getColorSpaceimpl5), gapComposer);
        } else {
            objRememberedValue13 = IntIntPair$$ExternalSyntheticOutline0.m(colorVectorConverterKt$ColorToVector$1$1, new CallsKt$await$2$1((byte) 1, colorSpaceM483getColorSpaceimpl5), gapComposer);
        }
        TwoWayConverterImpl twoWayConverterImpl17 = (TwoWayConverterImpl) objRememberedValue13;
        if (transitionInstance.isSeeking()) {
            gapComposer.startReplaceGroup(1666573488);
            if (i5 > 4) {
            }
            objM6 = gapComposer.rememberedValue();
            if (z31) {
                currentThreadSnapshot7 = Lock.getCurrentThreadSnapshot();
                if (currentThreadSnapshot7 != null) {
                    readObserver7 = currentThreadSnapshot7.getReadObserver();
                } else {
                    readObserver7 = null;
                }
                snapshotMakeCurrentNonObservable7 = Lock.makeCurrentNonObservable(currentThreadSnapshot7);
                Object currentState20 = transitionInstance.getCurrentState();
                Lock.restoreNonObservable(currentThreadSnapshot7, snapshotMakeCurrentNonObservable7, readObserver7);
                gapComposer.updateRememberedValue(currentState20);
                objM6 = currentState20;
            } else {
                currentThreadSnapshot7 = Lock.getCurrentThreadSnapshot();
                if (currentThreadSnapshot7 != null) {
                    readObserver7 = currentThreadSnapshot7.getReadObserver();
                } else {
                    readObserver7 = null;
                }
                snapshotMakeCurrentNonObservable7 = Lock.makeCurrentNonObservable(currentThreadSnapshot7);
                Object currentState21 = transitionInstance.getCurrentState();
                Lock.restoreNonObservable(currentThreadSnapshot7, snapshotMakeCurrentNonObservable7, readObserver7);
                gapComposer.updateRememberedValue(currentState21);
                objM6 = currentState21;
            }
            gapComposer.endReplaceGroup();
        } else {
            objM6 = Format$$ExternalSyntheticOutline0.m(gapComposer, 1666827533, transitionInstance);
        }
        gapComposer.startReplaceGroup(-1968230986);
        long j117 = ((ColorScheme) objM6).secondaryFixedDim;
        gapComposer.endReplaceGroup();
        Color colorM478boximpl111 = Color.m478boximpl(j117);
        if (i5 > 4) {
        }
        objRememberedValue14 = gapComposer.rememberedValue();
        if (z10) {
            objRememberedValue14 = SnapshotStateKt__DerivedStateKt.derivedStateOf(new ColorSchemeKt$animateFixedColors$$inlined$animateColor$1(transitionInstance, (byte) 10));
            gapComposer.updateRememberedValue(objRememberedValue14);
        } else {
            objRememberedValue14 = SnapshotStateKt__DerivedStateKt.derivedStateOf(new ColorSchemeKt$animateFixedColors$$inlined$animateColor$1(transitionInstance, (byte) 10));
            gapComposer.updateRememberedValue(objRememberedValue14);
        }
        ColorScheme colorScheme112 = (ColorScheme) ((State) objRememberedValue14).getValue();
        gapComposer.startReplaceGroup(-1968230986);
        long j118 = colorScheme112.secondaryFixedDim;
        gapComposer.endReplaceGroup();
        Color colorM478boximpl112 = Color.m478boximpl(j118);
        if (i5 > 4) {
        }
        objRememberedValue15 = gapComposer.rememberedValue();
        if (z11) {
            objRememberedValue15 = SnapshotStateKt__DerivedStateKt.derivedStateOf(new ColorSchemeKt$animateFixedColors$$inlined$animateColor$1(transitionInstance, (byte) 11));
            gapComposer.updateRememberedValue(objRememberedValue15);
        } else {
            objRememberedValue15 = SnapshotStateKt__DerivedStateKt.derivedStateOf(new ColorSchemeKt$animateFixedColors$$inlined$animateColor$1(transitionInstance, (byte) 11));
            gapComposer.updateRememberedValue(objRememberedValue15);
        }
        Transition.TransitionAnimationState transitionAnimationStateCreateTransitionAnimation17 = ArcSplineKt.createTransitionAnimation(transitionInstance, colorM478boximpl111, colorM478boximpl112, (FiniteAnimationSpec) function3.invoke(((State) objRememberedValue15).getValue(), gapComposer, Integer.valueOf(i8)), twoWayConverterImpl17, gapComposer, i9);
        ColorScheme colorScheme113 = (ColorScheme) transitionInstance.getTargetState();
        gapComposer.startReplaceGroup(-566567719);
        long j119 = colorScheme113.onSecondaryFixed;
        gapComposer.endReplaceGroup();
        colorSpaceM483getColorSpaceimpl6 = Color.m483getColorSpaceimpl(j119);
        zChanged6 = gapComposer.changed(colorSpaceM483getColorSpaceimpl6);
        objRememberedValue16 = gapComposer.rememberedValue();
        if (zChanged6) {
            objRememberedValue16 = IntIntPair$$ExternalSyntheticOutline0.m(colorVectorConverterKt$ColorToVector$1$1, new CallsKt$await$2$1((byte) 1, colorSpaceM483getColorSpaceimpl6), gapComposer);
        } else {
            objRememberedValue16 = IntIntPair$$ExternalSyntheticOutline0.m(colorVectorConverterKt$ColorToVector$1$1, new CallsKt$await$2$1((byte) 1, colorSpaceM483getColorSpaceimpl6), gapComposer);
        }
        TwoWayConverterImpl twoWayConverterImpl18 = (TwoWayConverterImpl) objRememberedValue16;
        if (transitionInstance.isSeeking()) {
            gapComposer.startReplaceGroup(1666573488);
            if (i5 > 4) {
            }
            objM7 = gapComposer.rememberedValue();
            if (z30) {
                currentThreadSnapshot6 = Lock.getCurrentThreadSnapshot();
                if (currentThreadSnapshot6 != null) {
                    readObserver6 = currentThreadSnapshot6.getReadObserver();
                } else {
                    readObserver6 = null;
                }
                snapshotMakeCurrentNonObservable6 = Lock.makeCurrentNonObservable(currentThreadSnapshot6);
                Object currentState22 = transitionInstance.getCurrentState();
                Lock.restoreNonObservable(currentThreadSnapshot6, snapshotMakeCurrentNonObservable6, readObserver6);
                gapComposer.updateRememberedValue(currentState22);
                objM7 = currentState22;
            } else {
                currentThreadSnapshot6 = Lock.getCurrentThreadSnapshot();
                if (currentThreadSnapshot6 != null) {
                    readObserver6 = currentThreadSnapshot6.getReadObserver();
                } else {
                    readObserver6 = null;
                }
                snapshotMakeCurrentNonObservable6 = Lock.makeCurrentNonObservable(currentThreadSnapshot6);
                Object currentState23 = transitionInstance.getCurrentState();
                Lock.restoreNonObservable(currentThreadSnapshot6, snapshotMakeCurrentNonObservable6, readObserver6);
                gapComposer.updateRememberedValue(currentState23);
                objM7 = currentState23;
            }
            gapComposer.endReplaceGroup();
        } else {
            objM7 = Format$$ExternalSyntheticOutline0.m(gapComposer, 1666827533, transitionInstance);
        }
        gapComposer.startReplaceGroup(-566567719);
        long j210 = ((ColorScheme) objM7).onSecondaryFixed;
        gapComposer.endReplaceGroup();
        Color colorM478boximpl113 = Color.m478boximpl(j210);
        if (i5 > 4) {
        }
        objRememberedValue17 = gapComposer.rememberedValue();
        if (z12) {
            objRememberedValue17 = SnapshotStateKt__DerivedStateKt.derivedStateOf(new ColorSchemeKt$animateFixedColors$$inlined$animateColor$1(transitionInstance, (byte) 12));
            gapComposer.updateRememberedValue(objRememberedValue17);
        } else {
            objRememberedValue17 = SnapshotStateKt__DerivedStateKt.derivedStateOf(new ColorSchemeKt$animateFixedColors$$inlined$animateColor$1(transitionInstance, (byte) 12));
            gapComposer.updateRememberedValue(objRememberedValue17);
        }
        ColorScheme colorScheme114 = (ColorScheme) ((State) objRememberedValue17).getValue();
        gapComposer.startReplaceGroup(-566567719);
        long j211 = colorScheme114.onSecondaryFixed;
        gapComposer.endReplaceGroup();
        Color colorM478boximpl114 = Color.m478boximpl(j211);
        if (i5 > 4) {
        }
        objRememberedValue18 = gapComposer.rememberedValue();
        if (z13) {
            objRememberedValue18 = SnapshotStateKt__DerivedStateKt.derivedStateOf(new ColorSchemeKt$animateFixedColors$$inlined$animateColor$1(transitionInstance, (byte) 13));
            gapComposer.updateRememberedValue(objRememberedValue18);
        } else {
            objRememberedValue18 = SnapshotStateKt__DerivedStateKt.derivedStateOf(new ColorSchemeKt$animateFixedColors$$inlined$animateColor$1(transitionInstance, (byte) 13));
            gapComposer.updateRememberedValue(objRememberedValue18);
        }
        Transition.TransitionAnimationState transitionAnimationStateCreateTransitionAnimation18 = ArcSplineKt.createTransitionAnimation(transitionInstance, colorM478boximpl113, colorM478boximpl114, (FiniteAnimationSpec) function3.invoke(((State) objRememberedValue18).getValue(), gapComposer, Integer.valueOf(i8)), twoWayConverterImpl18, gapComposer, i9);
        ColorScheme colorScheme115 = (ColorScheme) transitionInstance.getTargetState();
        gapComposer.startReplaceGroup(1193412116);
        long j212 = colorScheme115.onSecondaryFixedVariant;
        gapComposer.endReplaceGroup();
        colorSpaceM483getColorSpaceimpl7 = Color.m483getColorSpaceimpl(j212);
        zChanged7 = gapComposer.changed(colorSpaceM483getColorSpaceimpl7);
        objRememberedValue19 = gapComposer.rememberedValue();
        if (zChanged7) {
            objRememberedValue19 = IntIntPair$$ExternalSyntheticOutline0.m(colorVectorConverterKt$ColorToVector$1$1, new CallsKt$await$2$1((byte) 1, colorSpaceM483getColorSpaceimpl7), gapComposer);
        } else {
            objRememberedValue19 = IntIntPair$$ExternalSyntheticOutline0.m(colorVectorConverterKt$ColorToVector$1$1, new CallsKt$await$2$1((byte) 1, colorSpaceM483getColorSpaceimpl7), gapComposer);
        }
        TwoWayConverterImpl twoWayConverterImpl19 = (TwoWayConverterImpl) objRememberedValue19;
        if (transitionInstance.isSeeking()) {
            gapComposer.startReplaceGroup(1666573488);
            if (i5 > 4) {
            }
            objM8 = gapComposer.rememberedValue();
            if (z29) {
                currentThreadSnapshot5 = Lock.getCurrentThreadSnapshot();
                if (currentThreadSnapshot5 != null) {
                    readObserver5 = currentThreadSnapshot5.getReadObserver();
                } else {
                    readObserver5 = null;
                }
                snapshotMakeCurrentNonObservable5 = Lock.makeCurrentNonObservable(currentThreadSnapshot5);
                Object currentState24 = transitionInstance.getCurrentState();
                Lock.restoreNonObservable(currentThreadSnapshot5, snapshotMakeCurrentNonObservable5, readObserver5);
                gapComposer.updateRememberedValue(currentState24);
                objM8 = currentState24;
            } else {
                currentThreadSnapshot5 = Lock.getCurrentThreadSnapshot();
                if (currentThreadSnapshot5 != null) {
                    readObserver5 = currentThreadSnapshot5.getReadObserver();
                } else {
                    readObserver5 = null;
                }
                snapshotMakeCurrentNonObservable5 = Lock.makeCurrentNonObservable(currentThreadSnapshot5);
                Object currentState25 = transitionInstance.getCurrentState();
                Lock.restoreNonObservable(currentThreadSnapshot5, snapshotMakeCurrentNonObservable5, readObserver5);
                gapComposer.updateRememberedValue(currentState25);
                objM8 = currentState25;
            }
            gapComposer.endReplaceGroup();
        } else {
            objM8 = Format$$ExternalSyntheticOutline0.m(gapComposer, 1666827533, transitionInstance);
        }
        gapComposer.startReplaceGroup(1193412116);
        long j213 = ((ColorScheme) objM8).onSecondaryFixedVariant;
        gapComposer.endReplaceGroup();
        Color colorM478boximpl115 = Color.m478boximpl(j213);
        if (i5 > 4) {
        }
        objRememberedValue20 = gapComposer.rememberedValue();
        if (z14) {
            objRememberedValue20 = SnapshotStateKt__DerivedStateKt.derivedStateOf(new ColorSchemeKt$animateFixedColors$$inlined$animateColor$1(transitionInstance, (byte) 14));
            gapComposer.updateRememberedValue(objRememberedValue20);
        } else {
            objRememberedValue20 = SnapshotStateKt__DerivedStateKt.derivedStateOf(new ColorSchemeKt$animateFixedColors$$inlined$animateColor$1(transitionInstance, (byte) 14));
            gapComposer.updateRememberedValue(objRememberedValue20);
        }
        ColorScheme colorScheme116 = (ColorScheme) ((State) objRememberedValue20).getValue();
        gapComposer.startReplaceGroup(1193412116);
        long j214 = colorScheme116.onSecondaryFixedVariant;
        gapComposer.endReplaceGroup();
        Color colorM478boximpl116 = Color.m478boximpl(j214);
        if (i5 > 4) {
        }
        objRememberedValue21 = gapComposer.rememberedValue();
        if (z15) {
            objRememberedValue21 = SnapshotStateKt__DerivedStateKt.derivedStateOf(new ColorSchemeKt$animateFixedColors$$inlined$animateColor$1(transitionInstance, (byte) 15));
            gapComposer.updateRememberedValue(objRememberedValue21);
        } else {
            objRememberedValue21 = SnapshotStateKt__DerivedStateKt.derivedStateOf(new ColorSchemeKt$animateFixedColors$$inlined$animateColor$1(transitionInstance, (byte) 15));
            gapComposer.updateRememberedValue(objRememberedValue21);
        }
        Transition.TransitionAnimationState transitionAnimationStateCreateTransitionAnimation19 = ArcSplineKt.createTransitionAnimation(transitionInstance, colorM478boximpl115, colorM478boximpl116, (FiniteAnimationSpec) function3.invoke(((State) objRememberedValue21).getValue(), gapComposer, Integer.valueOf(i8)), twoWayConverterImpl19, gapComposer, i9);
        ColorScheme colorScheme117 = (ColorScheme) transitionInstance.getTargetState();
        gapComposer.startReplaceGroup(426203248);
        long j215 = colorScheme117.tertiaryFixed;
        gapComposer.endReplaceGroup();
        colorSpaceM483getColorSpaceimpl8 = Color.m483getColorSpaceimpl(j215);
        zChanged8 = gapComposer.changed(colorSpaceM483getColorSpaceimpl8);
        objRememberedValue22 = gapComposer.rememberedValue();
        if (zChanged8) {
            objRememberedValue22 = IntIntPair$$ExternalSyntheticOutline0.m(colorVectorConverterKt$ColorToVector$1$1, new CallsKt$await$2$1((byte) 1, colorSpaceM483getColorSpaceimpl8), gapComposer);
        } else {
            objRememberedValue22 = IntIntPair$$ExternalSyntheticOutline0.m(colorVectorConverterKt$ColorToVector$1$1, new CallsKt$await$2$1((byte) 1, colorSpaceM483getColorSpaceimpl8), gapComposer);
        }
        TwoWayConverterImpl twoWayConverterImpl20 = (TwoWayConverterImpl) objRememberedValue22;
        if (transitionInstance.isSeeking()) {
            gapComposer.startReplaceGroup(1666573488);
            if (i5 > 4) {
            }
            objM9 = gapComposer.rememberedValue();
            if (z28) {
                currentThreadSnapshot4 = Lock.getCurrentThreadSnapshot();
                if (currentThreadSnapshot4 != null) {
                    readObserver4 = currentThreadSnapshot4.getReadObserver();
                } else {
                    readObserver4 = null;
                }
                snapshotMakeCurrentNonObservable4 = Lock.makeCurrentNonObservable(currentThreadSnapshot4);
                Object currentState26 = transitionInstance.getCurrentState();
                Lock.restoreNonObservable(currentThreadSnapshot4, snapshotMakeCurrentNonObservable4, readObserver4);
                gapComposer.updateRememberedValue(currentState26);
                objM9 = currentState26;
            } else {
                currentThreadSnapshot4 = Lock.getCurrentThreadSnapshot();
                if (currentThreadSnapshot4 != null) {
                    readObserver4 = currentThreadSnapshot4.getReadObserver();
                } else {
                    readObserver4 = null;
                }
                snapshotMakeCurrentNonObservable4 = Lock.makeCurrentNonObservable(currentThreadSnapshot4);
                Object currentState27 = transitionInstance.getCurrentState();
                Lock.restoreNonObservable(currentThreadSnapshot4, snapshotMakeCurrentNonObservable4, readObserver4);
                gapComposer.updateRememberedValue(currentState27);
                objM9 = currentState27;
            }
            gapComposer.endReplaceGroup();
        } else {
            objM9 = Format$$ExternalSyntheticOutline0.m(gapComposer, 1666827533, transitionInstance);
        }
        gapComposer.startReplaceGroup(426203248);
        long j216 = ((ColorScheme) objM9).tertiaryFixed;
        gapComposer.endReplaceGroup();
        Color colorM478boximpl117 = Color.m478boximpl(j216);
        if (i5 > 4) {
        }
        objRememberedValue23 = gapComposer.rememberedValue();
        if (z16) {
            objRememberedValue23 = SnapshotStateKt__DerivedStateKt.derivedStateOf(new ColorSchemeKt$animateFixedColors$$inlined$animateColor$1(transitionInstance, (byte) 16));
            gapComposer.updateRememberedValue(objRememberedValue23);
        } else {
            objRememberedValue23 = SnapshotStateKt__DerivedStateKt.derivedStateOf(new ColorSchemeKt$animateFixedColors$$inlined$animateColor$1(transitionInstance, (byte) 16));
            gapComposer.updateRememberedValue(objRememberedValue23);
        }
        ColorScheme colorScheme118 = (ColorScheme) ((State) objRememberedValue23).getValue();
        gapComposer.startReplaceGroup(426203248);
        long j217 = colorScheme118.tertiaryFixed;
        gapComposer.endReplaceGroup();
        Color colorM478boximpl118 = Color.m478boximpl(j217);
        if (i5 > 4) {
        }
        objRememberedValue24 = gapComposer.rememberedValue();
        if (z17) {
            objRememberedValue24 = SnapshotStateKt__DerivedStateKt.derivedStateOf(new ColorSchemeKt$animateFixedColors$$inlined$animateColor$1(transitionInstance, (byte) 17));
            gapComposer.updateRememberedValue(objRememberedValue24);
        } else {
            objRememberedValue24 = SnapshotStateKt__DerivedStateKt.derivedStateOf(new ColorSchemeKt$animateFixedColors$$inlined$animateColor$1(transitionInstance, (byte) 17));
            gapComposer.updateRememberedValue(objRememberedValue24);
        }
        Transition.TransitionAnimationState transitionAnimationStateCreateTransitionAnimation20 = ArcSplineKt.createTransitionAnimation(transitionInstance, colorM478boximpl117, colorM478boximpl118, (FiniteAnimationSpec) function3.invoke(((State) objRememberedValue24).getValue(), gapComposer, Integer.valueOf(i8)), twoWayConverterImpl20, gapComposer, i9);
        ColorScheme colorScheme119 = (ColorScheme) transitionInstance.getTargetState();
        gapComposer.startReplaceGroup(348506592);
        long j218 = colorScheme119.tertiaryFixedDim;
        gapComposer.endReplaceGroup();
        colorSpaceM483getColorSpaceimpl9 = Color.m483getColorSpaceimpl(j218);
        zChanged9 = gapComposer.changed(colorSpaceM483getColorSpaceimpl9);
        objRememberedValue25 = gapComposer.rememberedValue();
        if (zChanged9) {
            objRememberedValue25 = IntIntPair$$ExternalSyntheticOutline0.m(colorVectorConverterKt$ColorToVector$1$1, new CallsKt$await$2$1((byte) 1, colorSpaceM483getColorSpaceimpl9), gapComposer);
        } else {
            objRememberedValue25 = IntIntPair$$ExternalSyntheticOutline0.m(colorVectorConverterKt$ColorToVector$1$1, new CallsKt$await$2$1((byte) 1, colorSpaceM483getColorSpaceimpl9), gapComposer);
        }
        TwoWayConverterImpl twoWayConverterImpl110 = (TwoWayConverterImpl) objRememberedValue25;
        if (transitionInstance.isSeeking()) {
            gapComposer.startReplaceGroup(1666573488);
            if (i5 > 4) {
            }
            objM10 = gapComposer.rememberedValue();
            if (z27) {
                currentThreadSnapshot3 = Lock.getCurrentThreadSnapshot();
                if (currentThreadSnapshot3 != null) {
                    readObserver3 = currentThreadSnapshot3.getReadObserver();
                } else {
                    readObserver3 = null;
                }
                snapshotMakeCurrentNonObservable3 = Lock.makeCurrentNonObservable(currentThreadSnapshot3);
                Object currentState111 = transitionInstance.getCurrentState();
                Lock.restoreNonObservable(currentThreadSnapshot3, snapshotMakeCurrentNonObservable3, readObserver3);
                gapComposer.updateRememberedValue(currentState111);
                objM10 = currentState111;
            } else {
                currentThreadSnapshot3 = Lock.getCurrentThreadSnapshot();
                if (currentThreadSnapshot3 != null) {
                    readObserver3 = currentThreadSnapshot3.getReadObserver();
                } else {
                    readObserver3 = null;
                }
                snapshotMakeCurrentNonObservable3 = Lock.makeCurrentNonObservable(currentThreadSnapshot3);
                Object currentState112 = transitionInstance.getCurrentState();
                Lock.restoreNonObservable(currentThreadSnapshot3, snapshotMakeCurrentNonObservable3, readObserver3);
                gapComposer.updateRememberedValue(currentState112);
                objM10 = currentState112;
            }
            gapComposer.endReplaceGroup();
        } else {
            objM10 = Format$$ExternalSyntheticOutline0.m(gapComposer, 1666827533, transitionInstance);
        }
        gapComposer.startReplaceGroup(348506592);
        long j219 = ((ColorScheme) objM10).tertiaryFixedDim;
        gapComposer.endReplaceGroup();
        Color colorM478boximpl119 = Color.m478boximpl(j219);
        if (i5 > 4) {
        }
        objRememberedValue26 = gapComposer.rememberedValue();
        if (z18) {
            objRememberedValue26 = SnapshotStateKt__DerivedStateKt.derivedStateOf(new ColorSchemeKt$animateFixedColors$$inlined$animateColor$1(transitionInstance, (byte) 18));
            gapComposer.updateRememberedValue(objRememberedValue26);
        } else {
            objRememberedValue26 = SnapshotStateKt__DerivedStateKt.derivedStateOf(new ColorSchemeKt$animateFixedColors$$inlined$animateColor$1(transitionInstance, (byte) 18));
            gapComposer.updateRememberedValue(objRememberedValue26);
        }
        ColorScheme colorScheme210 = (ColorScheme) ((State) objRememberedValue26).getValue();
        gapComposer.startReplaceGroup(348506592);
        long j310 = colorScheme210.tertiaryFixedDim;
        gapComposer.endReplaceGroup();
        Color colorM478boximpl210 = Color.m478boximpl(j310);
        if (i5 > 4) {
        }
        objRememberedValue27 = gapComposer.rememberedValue();
        if (z19) {
            objRememberedValue27 = SnapshotStateKt__DerivedStateKt.derivedStateOf(new ColorSchemeKt$animateFixedColors$$inlined$animateColor$1(transitionInstance, (byte) 19));
            gapComposer.updateRememberedValue(objRememberedValue27);
        } else {
            objRememberedValue27 = SnapshotStateKt__DerivedStateKt.derivedStateOf(new ColorSchemeKt$animateFixedColors$$inlined$animateColor$1(transitionInstance, (byte) 19));
            gapComposer.updateRememberedValue(objRememberedValue27);
        }
        Transition.TransitionAnimationState transitionAnimationStateCreateTransitionAnimation110 = ArcSplineKt.createTransitionAnimation(transitionInstance, colorM478boximpl119, colorM478boximpl210, (FiniteAnimationSpec) function3.invoke(((State) objRememberedValue27).getValue(), gapComposer, Integer.valueOf(i8)), twoWayConverterImpl110, gapComposer, i9);
        ColorScheme colorScheme211 = (ColorScheme) transitionInstance.getTargetState();
        gapComposer.startReplaceGroup(-2070125551);
        long j311 = colorScheme211.onTertiaryFixed;
        gapComposer.endReplaceGroup();
        colorSpaceM483getColorSpaceimpl10 = Color.m483getColorSpaceimpl(j311);
        zChanged10 = gapComposer.changed(colorSpaceM483getColorSpaceimpl10);
        objRememberedValue28 = gapComposer.rememberedValue();
        if (zChanged10) {
            objRememberedValue28 = IntIntPair$$ExternalSyntheticOutline0.m(colorVectorConverterKt$ColorToVector$1$1, new CallsKt$await$2$1((byte) 1, colorSpaceM483getColorSpaceimpl10), gapComposer);
        } else {
            objRememberedValue28 = IntIntPair$$ExternalSyntheticOutline0.m(colorVectorConverterKt$ColorToVector$1$1, new CallsKt$await$2$1((byte) 1, colorSpaceM483getColorSpaceimpl10), gapComposer);
        }
        TwoWayConverterImpl twoWayConverterImpl111 = (TwoWayConverterImpl) objRememberedValue28;
        if (transitionInstance.isSeeking()) {
            gapComposer.startReplaceGroup(1666573488);
            if (i5 > 4) {
            }
            objM11 = gapComposer.rememberedValue();
            if (z26) {
                currentThreadSnapshot2 = Lock.getCurrentThreadSnapshot();
                if (currentThreadSnapshot2 != null) {
                    readObserver2 = currentThreadSnapshot2.getReadObserver();
                } else {
                    readObserver2 = null;
                }
                snapshotMakeCurrentNonObservable2 = Lock.makeCurrentNonObservable(currentThreadSnapshot2);
                Object currentState113 = transitionInstance.getCurrentState();
                Lock.restoreNonObservable(currentThreadSnapshot2, snapshotMakeCurrentNonObservable2, readObserver2);
                gapComposer.updateRememberedValue(currentState113);
                objM11 = currentState113;
            } else {
                currentThreadSnapshot2 = Lock.getCurrentThreadSnapshot();
                if (currentThreadSnapshot2 != null) {
                    readObserver2 = currentThreadSnapshot2.getReadObserver();
                } else {
                    readObserver2 = null;
                }
                snapshotMakeCurrentNonObservable2 = Lock.makeCurrentNonObservable(currentThreadSnapshot2);
                Object currentState114 = transitionInstance.getCurrentState();
                Lock.restoreNonObservable(currentThreadSnapshot2, snapshotMakeCurrentNonObservable2, readObserver2);
                gapComposer.updateRememberedValue(currentState114);
                objM11 = currentState114;
            }
            gapComposer.endReplaceGroup();
        } else {
            objM11 = Format$$ExternalSyntheticOutline0.m(gapComposer, 1666827533, transitionInstance);
        }
        gapComposer.startReplaceGroup(-2070125551);
        long j312 = ((ColorScheme) objM11).onTertiaryFixed;
        gapComposer.endReplaceGroup();
        Color colorM478boximpl211 = Color.m478boximpl(j312);
        if (i5 > 4) {
        }
        objRememberedValue29 = gapComposer.rememberedValue();
        if (z20) {
            objRememberedValue29 = SnapshotStateKt__DerivedStateKt.derivedStateOf(new ColorSchemeKt$animateFixedColors$$inlined$animateColor$1(transitionInstance, (byte) 20));
            gapComposer.updateRememberedValue(objRememberedValue29);
        } else {
            objRememberedValue29 = SnapshotStateKt__DerivedStateKt.derivedStateOf(new ColorSchemeKt$animateFixedColors$$inlined$animateColor$1(transitionInstance, (byte) 20));
            gapComposer.updateRememberedValue(objRememberedValue29);
        }
        ColorScheme colorScheme212 = (ColorScheme) ((State) objRememberedValue29).getValue();
        gapComposer.startReplaceGroup(-2070125551);
        long j313 = colorScheme212.onTertiaryFixed;
        gapComposer.endReplaceGroup();
        Color colorM478boximpl212 = Color.m478boximpl(j313);
        if (i5 > 4) {
        }
        objRememberedValue30 = gapComposer.rememberedValue();
        if (z21) {
            objRememberedValue30 = SnapshotStateKt__DerivedStateKt.derivedStateOf(new ColorSchemeKt$animateFixedColors$$inlined$animateColor$1(transitionInstance, (byte) 21));
            gapComposer.updateRememberedValue(objRememberedValue30);
        } else {
            objRememberedValue30 = SnapshotStateKt__DerivedStateKt.derivedStateOf(new ColorSchemeKt$animateFixedColors$$inlined$animateColor$1(transitionInstance, (byte) 21));
            gapComposer.updateRememberedValue(objRememberedValue30);
        }
        Transition.TransitionAnimationState transitionAnimationStateCreateTransitionAnimation111 = ArcSplineKt.createTransitionAnimation(transitionInstance, colorM478boximpl211, colorM478boximpl212, (FiniteAnimationSpec) function3.invoke(((State) objRememberedValue30).getValue(), gapComposer, Integer.valueOf(i8)), twoWayConverterImpl111, gapComposer, i9);
        ColorScheme colorScheme213 = (ColorScheme) transitionInstance.getTargetState();
        gapComposer.startReplaceGroup(1502375900);
        long j314 = colorScheme213.onTertiaryFixedVariant;
        gapComposer.endReplaceGroup();
        colorSpaceM483getColorSpaceimpl11 = Color.m483getColorSpaceimpl(j314);
        zChanged11 = gapComposer.changed(colorSpaceM483getColorSpaceimpl11);
        Object objRememberedValue37 = gapComposer.rememberedValue();
        if (zChanged11) {
            z22 = true;
            objM12 = IntIntPair$$ExternalSyntheticOutline0.m(colorVectorConverterKt$ColorToVector$1$1, new CallsKt$await$2$1((byte) 1, colorSpaceM483getColorSpaceimpl11), gapComposer);
        } else {
            z22 = true;
            objM12 = IntIntPair$$ExternalSyntheticOutline0.m(colorVectorConverterKt$ColorToVector$1$1, new CallsKt$await$2$1((byte) 1, colorSpaceM483getColorSpaceimpl11), gapComposer);
        }
        TwoWayConverterImpl twoWayConverterImpl112 = (TwoWayConverterImpl) objM12;
        if (transitionInstance.isSeeking()) {
            gapComposer.startReplaceGroup(1666573488);
            if (i5 > 4) {
            }
            objM13 = gapComposer.rememberedValue();
            if (z25) {
                currentThreadSnapshot = Lock.getCurrentThreadSnapshot();
                if (currentThreadSnapshot != null) {
                    readObserver = currentThreadSnapshot.getReadObserver();
                } else {
                    readObserver = null;
                }
                snapshotMakeCurrentNonObservable = Lock.makeCurrentNonObservable(currentThreadSnapshot);
                Object currentState115 = transitionInstance.getCurrentState();
                Lock.restoreNonObservable(currentThreadSnapshot, snapshotMakeCurrentNonObservable, readObserver);
                gapComposer.updateRememberedValue(currentState115);
                objM13 = currentState115;
            } else {
                currentThreadSnapshot = Lock.getCurrentThreadSnapshot();
                if (currentThreadSnapshot != null) {
                    readObserver = currentThreadSnapshot.getReadObserver();
                } else {
                    readObserver = null;
                }
                snapshotMakeCurrentNonObservable = Lock.makeCurrentNonObservable(currentThreadSnapshot);
                Object currentState116 = transitionInstance.getCurrentState();
                Lock.restoreNonObservable(currentThreadSnapshot, snapshotMakeCurrentNonObservable, readObserver);
                gapComposer.updateRememberedValue(currentState116);
                objM13 = currentState116;
            }
            gapComposer.endReplaceGroup();
        } else {
            objM13 = Format$$ExternalSyntheticOutline0.m(gapComposer, 1666827533, transitionInstance);
        }
        gapComposer.startReplaceGroup(1502375900);
        long j315 = ((ColorScheme) objM13).onTertiaryFixedVariant;
        gapComposer.endReplaceGroup();
        Color colorM478boximpl213 = Color.m478boximpl(j315);
        if (i5 > 4) {
        }
        objRememberedValue31 = gapComposer.rememberedValue();
        if (z23) {
            objRememberedValue31 = SnapshotStateKt__DerivedStateKt.derivedStateOf(new ColorSchemeKt$animateFixedColors$$inlined$animateColor$1(transitionInstance, (byte) 22));
            gapComposer.updateRememberedValue(objRememberedValue31);
        } else {
            objRememberedValue31 = SnapshotStateKt__DerivedStateKt.derivedStateOf(new ColorSchemeKt$animateFixedColors$$inlined$animateColor$1(transitionInstance, (byte) 22));
            gapComposer.updateRememberedValue(objRememberedValue31);
        }
        ColorScheme colorScheme214 = (ColorScheme) ((State) objRememberedValue31).getValue();
        gapComposer.startReplaceGroup(1502375900);
        long j316 = colorScheme214.onTertiaryFixedVariant;
        gapComposer.endReplaceGroup();
        Color colorM478boximpl214 = Color.m478boximpl(j316);
        if (i5 > 4) {
        }
        objRememberedValue32 = gapComposer.rememberedValue();
        if (z24) {
            objRememberedValue32 = SnapshotStateKt__DerivedStateKt.derivedStateOf(new ColorSchemeKt$animateFixedColors$$inlined$animateColor$1(transitionInstance, (byte) 23));
            gapComposer.updateRememberedValue(objRememberedValue32);
        } else {
            objRememberedValue32 = SnapshotStateKt__DerivedStateKt.derivedStateOf(new ColorSchemeKt$animateFixedColors$$inlined$animateColor$1(transitionInstance, (byte) 23));
            gapComposer.updateRememberedValue(objRememberedValue32);
        }
        return CollectionsKt__IterablesKt.listOf((Object[]) new Color[]{Color.m478boximpl(animateFixedColors$lambda$1(transitionAnimationStateCreateTransitionAnimation12)), Color.m478boximpl(animateFixedColors$lambda$3(transitionAnimationStateCreateTransitionAnimation13)), Color.m478boximpl(animateFixedColors$lambda$5(transitionAnimationStateCreateTransitionAnimation14)), Color.m478boximpl(animateFixedColors$lambda$7(transitionAnimationStateCreateTransitionAnimation15)), Color.m478boximpl(animateFixedColors$lambda$9(transitionAnimationStateCreateTransitionAnimation16)), Color.m478boximpl(animateFixedColors$lambda$11(transitionAnimationStateCreateTransitionAnimation17)), Color.m478boximpl(animateFixedColors$lambda$13(transitionAnimationStateCreateTransitionAnimation18)), Color.m478boximpl(animateFixedColors$lambda$15(transitionAnimationStateCreateTransitionAnimation19)), Color.m478boximpl(animateFixedColors$lambda$17(transitionAnimationStateCreateTransitionAnimation20)), Color.m478boximpl(animateFixedColors$lambda$19(transitionAnimationStateCreateTransitionAnimation110)), Color.m478boximpl(animateFixedColors$lambda$21(transitionAnimationStateCreateTransitionAnimation111)), Color.m478boximpl(animateFixedColors$lambda$23(ArcSplineKt.createTransitionAnimation(transitionInstance, colorM478boximpl213, colorM478boximpl214, (FiniteAnimationSpec) function3.invoke(((State) objRememberedValue32).getValue(), gapComposer, Integer.valueOf(i8)), twoWayConverterImpl112, gapComposer, i9)))});
    }

    public static final long animateFixedColors$lambda$1(Transition.TransitionAnimationState transitionAnimationState) {
        return ((Color) transitionAnimationState.getValue()).value;
    }

    public static final long animateFixedColors$lambda$11(Transition.TransitionAnimationState transitionAnimationState) {
        return ((Color) transitionAnimationState.getValue()).value;
    }

    public static final long animateFixedColors$lambda$13(Transition.TransitionAnimationState transitionAnimationState) {
        return ((Color) transitionAnimationState.getValue()).value;
    }

    public static final long animateFixedColors$lambda$15(Transition.TransitionAnimationState transitionAnimationState) {
        return ((Color) transitionAnimationState.getValue()).value;
    }

    public static final long animateFixedColors$lambda$17(Transition.TransitionAnimationState transitionAnimationState) {
        return ((Color) transitionAnimationState.getValue()).value;
    }

    public static final long animateFixedColors$lambda$19(Transition.TransitionAnimationState transitionAnimationState) {
        return ((Color) transitionAnimationState.getValue()).value;
    }

    public static final long animateFixedColors$lambda$21(Transition.TransitionAnimationState transitionAnimationState) {
        return ((Color) transitionAnimationState.getValue()).value;
    }

    public static final long animateFixedColors$lambda$23(Transition.TransitionAnimationState transitionAnimationState) {
        return ((Color) transitionAnimationState.getValue()).value;
    }

    public static final long animateFixedColors$lambda$3(Transition.TransitionAnimationState transitionAnimationState) {
        return ((Color) transitionAnimationState.getValue()).value;
    }

    public static final long animateFixedColors$lambda$5(Transition.TransitionAnimationState transitionAnimationState) {
        return ((Color) transitionAnimationState.getValue()).value;
    }

    public static final long animateFixedColors$lambda$7(Transition.TransitionAnimationState transitionAnimationState) {
        return ((Color) transitionAnimationState.getValue()).value;
    }

    public static final long animateFixedColors$lambda$9(Transition.TransitionAnimationState transitionAnimationState) {
        return ((Color) transitionAnimationState.getValue()).value;
    }

    public static final List animateSurfaceColors(TransitionInstance transitionInstance, Function3 function3, Composer composer, int i) {
        Object objM;
        Object objM2;
        Object objM3;
        Object objM4;
        Object objM5;
        Object objM6;
        Object objM7;
        Object objM8;
        Object objM9;
        Object objM10;
        Object objM11;
        boolean z;
        Object objM12;
        Object objM13;
        int i2 = (i & 14) | 384 | (i & 112);
        ColorScheme colorScheme = (ColorScheme) transitionInstance.getTargetState();
        GapComposer gapComposer = (GapComposer) composer;
        gapComposer.startReplaceGroup(1645312066);
        long j = colorScheme.surface;
        gapComposer.endReplaceGroup();
        ColorSpace colorSpaceM483getColorSpaceimpl = Color.m483getColorSpaceimpl(j);
        boolean zChanged = gapComposer.changed(colorSpaceM483getColorSpaceimpl);
        Object objRememberedValue = gapComposer.rememberedValue();
        ColorVectorConverterKt$ColorToVector$1$1 colorVectorConverterKt$ColorToVector$1$1 = ColorVectorConverterKt$ColorToVector$1$1.INSTANCE;
        NeverEqualPolicy neverEqualPolicy = Composer.Companion.Empty;
        if (zChanged || objRememberedValue == neverEqualPolicy) {
            objRememberedValue = IntIntPair$$ExternalSyntheticOutline0.m(colorVectorConverterKt$ColorToVector$1$1, new CallsKt$await$2$1((byte) 1, colorSpaceM483getColorSpaceimpl), gapComposer);
        }
        TwoWayConverterImpl twoWayConverterImpl = (TwoWayConverterImpl) objRememberedValue;
        int i3 = ((i2 << 3) & 896) | (i2 & 14) | 3072;
        if (transitionInstance.isSeeking()) {
            objM = Format$$ExternalSyntheticOutline0.m(gapComposer, 1666827533, transitionInstance);
        } else {
            gapComposer.startReplaceGroup(1666573488);
            boolean z2 = (((i3 & 14) ^ 6) > 4 && gapComposer.changed(transitionInstance)) || (i3 & 6) == 4;
            objM = gapComposer.rememberedValue();
            if (z2 || objM == neverEqualPolicy) {
                Snapshot currentThreadSnapshot = Lock.getCurrentThreadSnapshot();
                Function1 readObserver = currentThreadSnapshot != null ? currentThreadSnapshot.getReadObserver() : null;
                Snapshot snapshotMakeCurrentNonObservable = Lock.makeCurrentNonObservable(currentThreadSnapshot);
                try {
                    Object currentState = transitionInstance.getCurrentState();
                    Lock.restoreNonObservable(currentThreadSnapshot, snapshotMakeCurrentNonObservable, readObserver);
                    gapComposer.updateRememberedValue(currentState);
                    objM = currentState;
                } catch (Throwable th) {
                    Lock.restoreNonObservable(currentThreadSnapshot, snapshotMakeCurrentNonObservable, readObserver);
                    throw th;
                }
            }
            gapComposer.endReplaceGroup();
        }
        gapComposer.startReplaceGroup(1645312066);
        long j2 = ((ColorScheme) objM).surface;
        gapComposer.endReplaceGroup();
        Color colorM478boximpl = Color.m478boximpl(j2);
        int i4 = i3 & 14;
        int i5 = i4 ^ 6;
        boolean z3 = (i5 > 4 && gapComposer.changed(transitionInstance)) || (i3 & 6) == 4;
        Object objRememberedValue2 = gapComposer.rememberedValue();
        if (z3 || objRememberedValue2 == neverEqualPolicy) {
            objRememberedValue2 = SnapshotStateKt__DerivedStateKt.derivedStateOf(new ColorSchemeKt$animateSurfaceColors$$inlined$animateColor$1(transitionInstance, (byte) 0));
            gapComposer.updateRememberedValue(objRememberedValue2);
        }
        ColorScheme colorScheme2 = (ColorScheme) ((State) objRememberedValue2).getValue();
        gapComposer.startReplaceGroup(1645312066);
        long j3 = colorScheme2.surface;
        gapComposer.endReplaceGroup();
        Color colorM478boximpl2 = Color.m478boximpl(j3);
        boolean z4 = (i5 > 4 && gapComposer.changed(transitionInstance)) || (i3 & 6) == 4;
        Object objRememberedValue3 = gapComposer.rememberedValue();
        if (z4 || objRememberedValue3 == neverEqualPolicy) {
            objRememberedValue3 = SnapshotStateKt__DerivedStateKt.derivedStateOf(new ColorSchemeKt$animateSurfaceColors$$inlined$animateColor$1(transitionInstance, (byte) 6));
            gapComposer.updateRememberedValue(objRememberedValue3);
        }
        Object value = ((State) objRememberedValue3).getValue();
        int i6 = (i3 >> 3) & 112;
        FiniteAnimationSpec finiteAnimationSpec = (FiniteAnimationSpec) function3.invoke(value, gapComposer, Integer.valueOf(i6));
        int i7 = 196608 | i4;
        Transition.TransitionAnimationState transitionAnimationStateCreateTransitionAnimation = ArcSplineKt.createTransitionAnimation(transitionInstance, colorM478boximpl, colorM478boximpl2, finiteAnimationSpec, twoWayConverterImpl, gapComposer, i7);
        ColorScheme colorScheme3 = (ColorScheme) transitionInstance.getTargetState();
        gapComposer.startReplaceGroup(102202467);
        long j4 = colorScheme3.onSurface;
        gapComposer.endReplaceGroup();
        ColorSpace colorSpaceM483getColorSpaceimpl2 = Color.m483getColorSpaceimpl(j4);
        boolean zChanged2 = gapComposer.changed(colorSpaceM483getColorSpaceimpl2);
        Object objRememberedValue4 = gapComposer.rememberedValue();
        if (zChanged2 || objRememberedValue4 == neverEqualPolicy) {
            objRememberedValue4 = IntIntPair$$ExternalSyntheticOutline0.m(colorVectorConverterKt$ColorToVector$1$1, new CallsKt$await$2$1((byte) 1, colorSpaceM483getColorSpaceimpl2), gapComposer);
        }
        TwoWayConverterImpl twoWayConverterImpl2 = (TwoWayConverterImpl) objRememberedValue4;
        if (transitionInstance.isSeeking()) {
            objM2 = Format$$ExternalSyntheticOutline0.m(gapComposer, 1666827533, transitionInstance);
        } else {
            gapComposer.startReplaceGroup(1666573488);
            boolean z5 = (i5 > 4 && gapComposer.changed(transitionInstance)) || (i3 & 6) == 4;
            objM2 = gapComposer.rememberedValue();
            if (z5 || objM2 == neverEqualPolicy) {
                Snapshot currentThreadSnapshot2 = Lock.getCurrentThreadSnapshot();
                Function1 readObserver2 = currentThreadSnapshot2 != null ? currentThreadSnapshot2.getReadObserver() : null;
                Snapshot snapshotMakeCurrentNonObservable2 = Lock.makeCurrentNonObservable(currentThreadSnapshot2);
                try {
                    Object currentState2 = transitionInstance.getCurrentState();
                    Lock.restoreNonObservable(currentThreadSnapshot2, snapshotMakeCurrentNonObservable2, readObserver2);
                    gapComposer.updateRememberedValue(currentState2);
                    objM2 = currentState2;
                } catch (Throwable th2) {
                    Lock.restoreNonObservable(currentThreadSnapshot2, snapshotMakeCurrentNonObservable2, readObserver2);
                    throw th2;
                }
            }
            gapComposer.endReplaceGroup();
        }
        gapComposer.startReplaceGroup(102202467);
        long j5 = ((ColorScheme) objM2).onSurface;
        gapComposer.endReplaceGroup();
        Color colorM478boximpl3 = Color.m478boximpl(j5);
        boolean z6 = (i5 > 4 && gapComposer.changed(transitionInstance)) || (i3 & 6) == 4;
        Object objRememberedValue5 = gapComposer.rememberedValue();
        if (z6 || objRememberedValue5 == neverEqualPolicy) {
            objRememberedValue5 = SnapshotStateKt__DerivedStateKt.derivedStateOf(new ColorSchemeKt$animateSurfaceColors$$inlined$animateColor$1(transitionInstance, (byte) 7));
            gapComposer.updateRememberedValue(objRememberedValue5);
        }
        ColorScheme colorScheme4 = (ColorScheme) ((State) objRememberedValue5).getValue();
        gapComposer.startReplaceGroup(102202467);
        long j6 = colorScheme4.onSurface;
        gapComposer.endReplaceGroup();
        Color colorM478boximpl4 = Color.m478boximpl(j6);
        boolean z7 = (i5 > 4 && gapComposer.changed(transitionInstance)) || (i3 & 6) == 4;
        Object objRememberedValue6 = gapComposer.rememberedValue();
        if (z7 || objRememberedValue6 == neverEqualPolicy) {
            objRememberedValue6 = SnapshotStateKt__DerivedStateKt.derivedStateOf(new ColorSchemeKt$animateSurfaceColors$$inlined$animateColor$1(transitionInstance, (byte) 8));
            gapComposer.updateRememberedValue(objRememberedValue6);
        }
        Transition.TransitionAnimationState transitionAnimationStateCreateTransitionAnimation2 = ArcSplineKt.createTransitionAnimation(transitionInstance, colorM478boximpl3, colorM478boximpl4, (FiniteAnimationSpec) function3.invoke(((State) objRememberedValue6).getValue(), gapComposer, Integer.valueOf(i6)), twoWayConverterImpl2, gapComposer, i7);
        ColorScheme colorScheme5 = (ColorScheme) transitionInstance.getTargetState();
        gapComposer.startReplaceGroup(-835141639);
        long j7 = colorScheme5.surfaceVariant;
        gapComposer.endReplaceGroup();
        ColorSpace colorSpaceM483getColorSpaceimpl3 = Color.m483getColorSpaceimpl(j7);
        boolean zChanged3 = gapComposer.changed(colorSpaceM483getColorSpaceimpl3);
        Object objRememberedValue7 = gapComposer.rememberedValue();
        if (zChanged3 || objRememberedValue7 == neverEqualPolicy) {
            objRememberedValue7 = IntIntPair$$ExternalSyntheticOutline0.m(colorVectorConverterKt$ColorToVector$1$1, new CallsKt$await$2$1((byte) 1, colorSpaceM483getColorSpaceimpl3), gapComposer);
        }
        TwoWayConverterImpl twoWayConverterImpl3 = (TwoWayConverterImpl) objRememberedValue7;
        if (transitionInstance.isSeeking()) {
            objM3 = Format$$ExternalSyntheticOutline0.m(gapComposer, 1666827533, transitionInstance);
        } else {
            gapComposer.startReplaceGroup(1666573488);
            boolean z8 = (i5 > 4 && gapComposer.changed(transitionInstance)) || (i3 & 6) == 4;
            objM3 = gapComposer.rememberedValue();
            if (z8 || objM3 == neverEqualPolicy) {
                Snapshot currentThreadSnapshot3 = Lock.getCurrentThreadSnapshot();
                Function1 readObserver3 = currentThreadSnapshot3 != null ? currentThreadSnapshot3.getReadObserver() : null;
                Snapshot snapshotMakeCurrentNonObservable3 = Lock.makeCurrentNonObservable(currentThreadSnapshot3);
                try {
                    Object currentState3 = transitionInstance.getCurrentState();
                    Lock.restoreNonObservable(currentThreadSnapshot3, snapshotMakeCurrentNonObservable3, readObserver3);
                    gapComposer.updateRememberedValue(currentState3);
                    objM3 = currentState3;
                } catch (Throwable th3) {
                    Lock.restoreNonObservable(currentThreadSnapshot3, snapshotMakeCurrentNonObservable3, readObserver3);
                    throw th3;
                }
            }
            gapComposer.endReplaceGroup();
        }
        gapComposer.startReplaceGroup(-835141639);
        long j8 = ((ColorScheme) objM3).surfaceVariant;
        gapComposer.endReplaceGroup();
        Color colorM478boximpl5 = Color.m478boximpl(j8);
        boolean z9 = (i5 > 4 && gapComposer.changed(transitionInstance)) || (i3 & 6) == 4;
        Object objRememberedValue8 = gapComposer.rememberedValue();
        if (z9 || objRememberedValue8 == neverEqualPolicy) {
            objRememberedValue8 = SnapshotStateKt__DerivedStateKt.derivedStateOf(new ColorSchemeKt$animateSurfaceColors$$inlined$animateColor$1(transitionInstance, (byte) 9));
            gapComposer.updateRememberedValue(objRememberedValue8);
        }
        ColorScheme colorScheme6 = (ColorScheme) ((State) objRememberedValue8).getValue();
        gapComposer.startReplaceGroup(-835141639);
        long j9 = colorScheme6.surfaceVariant;
        gapComposer.endReplaceGroup();
        Color colorM478boximpl6 = Color.m478boximpl(j9);
        boolean z10 = (i5 > 4 && gapComposer.changed(transitionInstance)) || (i3 & 6) == 4;
        Object objRememberedValue9 = gapComposer.rememberedValue();
        if (z10 || objRememberedValue9 == neverEqualPolicy) {
            objRememberedValue9 = SnapshotStateKt__DerivedStateKt.derivedStateOf(new ColorSchemeKt$animateSurfaceColors$$inlined$animateColor$1(transitionInstance, (byte) 10));
            gapComposer.updateRememberedValue(objRememberedValue9);
        }
        Transition.TransitionAnimationState transitionAnimationStateCreateTransitionAnimation3 = ArcSplineKt.createTransitionAnimation(transitionInstance, colorM478boximpl5, colorM478boximpl6, (FiniteAnimationSpec) function3.invoke(((State) objRememberedValue9).getValue(), gapComposer, Integer.valueOf(i6)), twoWayConverterImpl3, gapComposer, i7);
        ColorScheme colorScheme7 = (ColorScheme) transitionInstance.getTargetState();
        gapComposer.startReplaceGroup(-1607662408);
        long j10 = colorScheme7.onSurfaceVariant;
        gapComposer.endReplaceGroup();
        ColorSpace colorSpaceM483getColorSpaceimpl4 = Color.m483getColorSpaceimpl(j10);
        boolean zChanged4 = gapComposer.changed(colorSpaceM483getColorSpaceimpl4);
        Object objRememberedValue10 = gapComposer.rememberedValue();
        if (zChanged4 || objRememberedValue10 == neverEqualPolicy) {
            objRememberedValue10 = IntIntPair$$ExternalSyntheticOutline0.m(colorVectorConverterKt$ColorToVector$1$1, new CallsKt$await$2$1((byte) 1, colorSpaceM483getColorSpaceimpl4), gapComposer);
        }
        TwoWayConverterImpl twoWayConverterImpl4 = (TwoWayConverterImpl) objRememberedValue10;
        if (transitionInstance.isSeeking()) {
            twoWayConverterImpl4 = twoWayConverterImpl4;
            objM4 = Format$$ExternalSyntheticOutline0.m(gapComposer, 1666827533, transitionInstance);
        } else {
            gapComposer.startReplaceGroup(1666573488);
            boolean z11 = (i5 > 4 && gapComposer.changed(transitionInstance)) || (i3 & 6) == 4;
            objM4 = gapComposer.rememberedValue();
            if (z11 || objM4 == neverEqualPolicy) {
                Snapshot currentThreadSnapshot4 = Lock.getCurrentThreadSnapshot();
                Function1 readObserver4 = currentThreadSnapshot4 != null ? currentThreadSnapshot4.getReadObserver() : null;
                Snapshot snapshotMakeCurrentNonObservable4 = Lock.makeCurrentNonObservable(currentThreadSnapshot4);
                try {
                    Object currentState4 = transitionInstance.getCurrentState();
                    Lock.restoreNonObservable(currentThreadSnapshot4, snapshotMakeCurrentNonObservable4, readObserver4);
                    gapComposer.updateRememberedValue(currentState4);
                    objM4 = currentState4;
                } catch (Throwable th4) {
                    Lock.restoreNonObservable(currentThreadSnapshot4, snapshotMakeCurrentNonObservable4, readObserver4);
                    throw th4;
                }
            }
            gapComposer.endReplaceGroup();
        }
        gapComposer.startReplaceGroup(-1607662408);
        long j11 = ((ColorScheme) objM4).onSurfaceVariant;
        gapComposer.endReplaceGroup();
        Color colorM478boximpl7 = Color.m478boximpl(j11);
        boolean z12 = (i5 > 4 && gapComposer.changed(transitionInstance)) || (i3 & 6) == 4;
        Object objRememberedValue11 = gapComposer.rememberedValue();
        if (z12 || objRememberedValue11 == neverEqualPolicy) {
            objRememberedValue11 = SnapshotStateKt__DerivedStateKt.derivedStateOf(new ColorSchemeKt$animateSurfaceColors$$inlined$animateColor$1(transitionInstance, (byte) 11));
            gapComposer.updateRememberedValue(objRememberedValue11);
        }
        ColorScheme colorScheme8 = (ColorScheme) ((State) objRememberedValue11).getValue();
        gapComposer.startReplaceGroup(-1607662408);
        long j12 = colorScheme8.onSurfaceVariant;
        gapComposer.endReplaceGroup();
        Color colorM478boximpl8 = Color.m478boximpl(j12);
        boolean z13 = (i5 > 4 && gapComposer.changed(transitionInstance)) || (i3 & 6) == 4;
        Object objRememberedValue12 = gapComposer.rememberedValue();
        if (z13 || objRememberedValue12 == neverEqualPolicy) {
            objRememberedValue12 = SnapshotStateKt__DerivedStateKt.derivedStateOf(new ColorSchemeKt$animateSurfaceColors$$inlined$animateColor$1(transitionInstance, (byte) 12));
            gapComposer.updateRememberedValue(objRememberedValue12);
        }
        Transition.TransitionAnimationState transitionAnimationStateCreateTransitionAnimation4 = ArcSplineKt.createTransitionAnimation(transitionInstance, colorM478boximpl7, colorM478boximpl8, (FiniteAnimationSpec) function3.invoke(((State) objRememberedValue12).getValue(), gapComposer, Integer.valueOf(i6)), twoWayConverterImpl4, gapComposer, i7);
        ColorScheme colorScheme9 = (ColorScheme) transitionInstance.getTargetState();
        gapComposer.startReplaceGroup(561656925);
        long j13 = colorScheme9.surfaceTint;
        gapComposer.endReplaceGroup();
        ColorSpace colorSpaceM483getColorSpaceimpl5 = Color.m483getColorSpaceimpl(j13);
        boolean zChanged5 = gapComposer.changed(colorSpaceM483getColorSpaceimpl5);
        Object objRememberedValue13 = gapComposer.rememberedValue();
        if (zChanged5 || objRememberedValue13 == neverEqualPolicy) {
            objRememberedValue13 = IntIntPair$$ExternalSyntheticOutline0.m(colorVectorConverterKt$ColorToVector$1$1, new CallsKt$await$2$1((byte) 1, colorSpaceM483getColorSpaceimpl5), gapComposer);
        }
        TwoWayConverterImpl twoWayConverterImpl5 = (TwoWayConverterImpl) objRememberedValue13;
        if (transitionInstance.isSeeking()) {
            twoWayConverterImpl5 = twoWayConverterImpl5;
            objM5 = Format$$ExternalSyntheticOutline0.m(gapComposer, 1666827533, transitionInstance);
        } else {
            gapComposer.startReplaceGroup(1666573488);
            boolean z14 = (i5 > 4 && gapComposer.changed(transitionInstance)) || (i3 & 6) == 4;
            objM5 = gapComposer.rememberedValue();
            if (z14 || objM5 == neverEqualPolicy) {
                Snapshot currentThreadSnapshot5 = Lock.getCurrentThreadSnapshot();
                Function1 readObserver5 = currentThreadSnapshot5 != null ? currentThreadSnapshot5.getReadObserver() : null;
                Snapshot snapshotMakeCurrentNonObservable5 = Lock.makeCurrentNonObservable(currentThreadSnapshot5);
                try {
                    Object currentState5 = transitionInstance.getCurrentState();
                    Lock.restoreNonObservable(currentThreadSnapshot5, snapshotMakeCurrentNonObservable5, readObserver5);
                    gapComposer.updateRememberedValue(currentState5);
                    objM5 = currentState5;
                } catch (Throwable th5) {
                    Lock.restoreNonObservable(currentThreadSnapshot5, snapshotMakeCurrentNonObservable5, readObserver5);
                    throw th5;
                }
            }
            gapComposer.endReplaceGroup();
        }
        gapComposer.startReplaceGroup(561656925);
        long j14 = ((ColorScheme) objM5).surfaceTint;
        gapComposer.endReplaceGroup();
        Color colorM478boximpl9 = Color.m478boximpl(j14);
        boolean z15 = (i5 > 4 && gapComposer.changed(transitionInstance)) || (i3 & 6) == 4;
        Object objRememberedValue14 = gapComposer.rememberedValue();
        if (z15 || objRememberedValue14 == neverEqualPolicy) {
            objRememberedValue14 = SnapshotStateKt__DerivedStateKt.derivedStateOf(new ColorSchemeKt$animateSurfaceColors$$inlined$animateColor$1(transitionInstance, (byte) 13));
            gapComposer.updateRememberedValue(objRememberedValue14);
        }
        ColorScheme colorScheme10 = (ColorScheme) ((State) objRememberedValue14).getValue();
        gapComposer.startReplaceGroup(561656925);
        long j15 = colorScheme10.surfaceTint;
        gapComposer.endReplaceGroup();
        Color colorM478boximpl10 = Color.m478boximpl(j15);
        boolean z16 = (i5 > 4 && gapComposer.changed(transitionInstance)) || (i3 & 6) == 4;
        Object objRememberedValue15 = gapComposer.rememberedValue();
        if (z16 || objRememberedValue15 == neverEqualPolicy) {
            objRememberedValue15 = SnapshotStateKt__DerivedStateKt.derivedStateOf(new ColorSchemeKt$animateFixedColors$$inlined$animateColor$8(transitionInstance, (byte) 20));
            gapComposer.updateRememberedValue(objRememberedValue15);
        }
        Transition.TransitionAnimationState transitionAnimationStateCreateTransitionAnimation5 = ArcSplineKt.createTransitionAnimation(transitionInstance, colorM478boximpl9, colorM478boximpl10, (FiniteAnimationSpec) function3.invoke(((State) objRememberedValue15).getValue(), gapComposer, Integer.valueOf(i6)), twoWayConverterImpl5, gapComposer, i7);
        ColorScheme colorScheme11 = (ColorScheme) transitionInstance.getTargetState();
        gapComposer.startReplaceGroup(1343000860);
        long j16 = colorScheme11.surfaceBright;
        gapComposer.endReplaceGroup();
        ColorSpace colorSpaceM483getColorSpaceimpl6 = Color.m483getColorSpaceimpl(j16);
        boolean zChanged6 = gapComposer.changed(colorSpaceM483getColorSpaceimpl6);
        Object objRememberedValue16 = gapComposer.rememberedValue();
        if (zChanged6 || objRememberedValue16 == neverEqualPolicy) {
            objRememberedValue16 = IntIntPair$$ExternalSyntheticOutline0.m(colorVectorConverterKt$ColorToVector$1$1, new CallsKt$await$2$1((byte) 1, colorSpaceM483getColorSpaceimpl6), gapComposer);
        }
        TwoWayConverterImpl twoWayConverterImpl6 = (TwoWayConverterImpl) objRememberedValue16;
        if (transitionInstance.isSeeking()) {
            twoWayConverterImpl6 = twoWayConverterImpl6;
            objM6 = Format$$ExternalSyntheticOutline0.m(gapComposer, 1666827533, transitionInstance);
        } else {
            gapComposer.startReplaceGroup(1666573488);
            boolean z17 = (i5 > 4 && gapComposer.changed(transitionInstance)) || (i3 & 6) == 4;
            objM6 = gapComposer.rememberedValue();
            if (z17 || objM6 == neverEqualPolicy) {
                Snapshot currentThreadSnapshot6 = Lock.getCurrentThreadSnapshot();
                Function1 readObserver6 = currentThreadSnapshot6 != null ? currentThreadSnapshot6.getReadObserver() : null;
                Snapshot snapshotMakeCurrentNonObservable6 = Lock.makeCurrentNonObservable(currentThreadSnapshot6);
                try {
                    Object currentState6 = transitionInstance.getCurrentState();
                    Lock.restoreNonObservable(currentThreadSnapshot6, snapshotMakeCurrentNonObservable6, readObserver6);
                    gapComposer.updateRememberedValue(currentState6);
                    objM6 = currentState6;
                } catch (Throwable th6) {
                    Lock.restoreNonObservable(currentThreadSnapshot6, snapshotMakeCurrentNonObservable6, readObserver6);
                    throw th6;
                }
            }
            gapComposer.endReplaceGroup();
        }
        gapComposer.startReplaceGroup(1343000860);
        long j17 = ((ColorScheme) objM6).surfaceBright;
        gapComposer.endReplaceGroup();
        Color colorM478boximpl11 = Color.m478boximpl(j17);
        boolean z18 = (i5 > 4 && gapComposer.changed(transitionInstance)) || (i3 & 6) == 4;
        Object objRememberedValue17 = gapComposer.rememberedValue();
        if (z18 || objRememberedValue17 == neverEqualPolicy) {
            objRememberedValue17 = SnapshotStateKt__DerivedStateKt.derivedStateOf(new ColorSchemeKt$animateFixedColors$$inlined$animateColor$8(transitionInstance, (byte) 21));
            gapComposer.updateRememberedValue(objRememberedValue17);
        }
        ColorScheme colorScheme12 = (ColorScheme) ((State) objRememberedValue17).getValue();
        gapComposer.startReplaceGroup(1343000860);
        long j18 = colorScheme12.surfaceBright;
        gapComposer.endReplaceGroup();
        Color colorM478boximpl12 = Color.m478boximpl(j18);
        boolean z19 = (i5 > 4 && gapComposer.changed(transitionInstance)) || (i3 & 6) == 4;
        Object objRememberedValue18 = gapComposer.rememberedValue();
        if (z19 || objRememberedValue18 == neverEqualPolicy) {
            objRememberedValue18 = SnapshotStateKt__DerivedStateKt.derivedStateOf(new ColorSchemeKt$animateFixedColors$$inlined$animateColor$8(transitionInstance, (byte) 22));
            gapComposer.updateRememberedValue(objRememberedValue18);
        }
        Transition.TransitionAnimationState transitionAnimationStateCreateTransitionAnimation6 = ArcSplineKt.createTransitionAnimation(transitionInstance, colorM478boximpl11, colorM478boximpl12, (FiniteAnimationSpec) function3.invoke(((State) objRememberedValue18).getValue(), gapComposer, Integer.valueOf(i6)), twoWayConverterImpl6, gapComposer, i7);
        ColorScheme colorScheme13 = (ColorScheme) transitionInstance.getTargetState();
        gapComposer.startReplaceGroup(-495778564);
        long j19 = colorScheme13.surfaceDim;
        gapComposer.endReplaceGroup();
        ColorSpace colorSpaceM483getColorSpaceimpl7 = Color.m483getColorSpaceimpl(j19);
        boolean zChanged7 = gapComposer.changed(colorSpaceM483getColorSpaceimpl7);
        Object objRememberedValue19 = gapComposer.rememberedValue();
        if (zChanged7 || objRememberedValue19 == neverEqualPolicy) {
            objRememberedValue19 = IntIntPair$$ExternalSyntheticOutline0.m(colorVectorConverterKt$ColorToVector$1$1, new CallsKt$await$2$1((byte) 1, colorSpaceM483getColorSpaceimpl7), gapComposer);
        }
        TwoWayConverterImpl twoWayConverterImpl7 = (TwoWayConverterImpl) objRememberedValue19;
        if (transitionInstance.isSeeking()) {
            twoWayConverterImpl7 = twoWayConverterImpl7;
            objM7 = Format$$ExternalSyntheticOutline0.m(gapComposer, 1666827533, transitionInstance);
        } else {
            gapComposer.startReplaceGroup(1666573488);
            boolean z20 = (i5 > 4 && gapComposer.changed(transitionInstance)) || (i3 & 6) == 4;
            objM7 = gapComposer.rememberedValue();
            if (z20 || objM7 == neverEqualPolicy) {
                Snapshot currentThreadSnapshot7 = Lock.getCurrentThreadSnapshot();
                Function1 readObserver7 = currentThreadSnapshot7 != null ? currentThreadSnapshot7.getReadObserver() : null;
                Snapshot snapshotMakeCurrentNonObservable7 = Lock.makeCurrentNonObservable(currentThreadSnapshot7);
                try {
                    Object currentState7 = transitionInstance.getCurrentState();
                    Lock.restoreNonObservable(currentThreadSnapshot7, snapshotMakeCurrentNonObservable7, readObserver7);
                    gapComposer.updateRememberedValue(currentState7);
                    objM7 = currentState7;
                } catch (Throwable th7) {
                    Lock.restoreNonObservable(currentThreadSnapshot7, snapshotMakeCurrentNonObservable7, readObserver7);
                    throw th7;
                }
            }
            gapComposer.endReplaceGroup();
        }
        gapComposer.startReplaceGroup(-495778564);
        long j20 = ((ColorScheme) objM7).surfaceDim;
        gapComposer.endReplaceGroup();
        Color colorM478boximpl13 = Color.m478boximpl(j20);
        boolean z21 = (i5 > 4 && gapComposer.changed(transitionInstance)) || (i3 & 6) == 4;
        Object objRememberedValue20 = gapComposer.rememberedValue();
        if (z21 || objRememberedValue20 == neverEqualPolicy) {
            objRememberedValue20 = SnapshotStateKt__DerivedStateKt.derivedStateOf(new ColorSchemeKt$animateFixedColors$$inlined$animateColor$8(transitionInstance, (byte) 23));
            gapComposer.updateRememberedValue(objRememberedValue20);
        }
        ColorScheme colorScheme14 = (ColorScheme) ((State) objRememberedValue20).getValue();
        gapComposer.startReplaceGroup(-495778564);
        long j21 = colorScheme14.surfaceDim;
        gapComposer.endReplaceGroup();
        Color colorM478boximpl14 = Color.m478boximpl(j21);
        boolean z22 = (i5 > 4 && gapComposer.changed(transitionInstance)) || (i3 & 6) == 4;
        Object objRememberedValue21 = gapComposer.rememberedValue();
        if (z22 || objRememberedValue21 == neverEqualPolicy) {
            objRememberedValue21 = SnapshotStateKt__DerivedStateKt.derivedStateOf(new ColorSchemeKt$animateFixedColors$$inlined$animateColor$8(transitionInstance, (byte) 24));
            gapComposer.updateRememberedValue(objRememberedValue21);
        }
        Transition.TransitionAnimationState transitionAnimationStateCreateTransitionAnimation7 = ArcSplineKt.createTransitionAnimation(transitionInstance, colorM478boximpl13, colorM478boximpl14, (FiniteAnimationSpec) function3.invoke(((State) objRememberedValue21).getValue(), gapComposer, Integer.valueOf(i6)), twoWayConverterImpl7, gapComposer, i7);
        ColorScheme colorScheme15 = (ColorScheme) transitionInstance.getTargetState();
        gapComposer.startReplaceGroup(213451701);
        long j22 = colorScheme15.surfaceContainer;
        gapComposer.endReplaceGroup();
        ColorSpace colorSpaceM483getColorSpaceimpl8 = Color.m483getColorSpaceimpl(j22);
        boolean zChanged8 = gapComposer.changed(colorSpaceM483getColorSpaceimpl8);
        Object objRememberedValue22 = gapComposer.rememberedValue();
        if (zChanged8 || objRememberedValue22 == neverEqualPolicy) {
            objRememberedValue22 = IntIntPair$$ExternalSyntheticOutline0.m(colorVectorConverterKt$ColorToVector$1$1, new CallsKt$await$2$1((byte) 1, colorSpaceM483getColorSpaceimpl8), gapComposer);
        }
        TwoWayConverterImpl twoWayConverterImpl8 = (TwoWayConverterImpl) objRememberedValue22;
        if (transitionInstance.isSeeking()) {
            twoWayConverterImpl8 = twoWayConverterImpl8;
            objM8 = Format$$ExternalSyntheticOutline0.m(gapComposer, 1666827533, transitionInstance);
        } else {
            gapComposer.startReplaceGroup(1666573488);
            boolean z23 = (i5 > 4 && gapComposer.changed(transitionInstance)) || (i3 & 6) == 4;
            objM8 = gapComposer.rememberedValue();
            if (z23 || objM8 == neverEqualPolicy) {
                Snapshot currentThreadSnapshot8 = Lock.getCurrentThreadSnapshot();
                Function1 readObserver8 = currentThreadSnapshot8 != null ? currentThreadSnapshot8.getReadObserver() : null;
                Snapshot snapshotMakeCurrentNonObservable8 = Lock.makeCurrentNonObservable(currentThreadSnapshot8);
                try {
                    Object currentState8 = transitionInstance.getCurrentState();
                    Lock.restoreNonObservable(currentThreadSnapshot8, snapshotMakeCurrentNonObservable8, readObserver8);
                    gapComposer.updateRememberedValue(currentState8);
                    objM8 = currentState8;
                } catch (Throwable th8) {
                    Lock.restoreNonObservable(currentThreadSnapshot8, snapshotMakeCurrentNonObservable8, readObserver8);
                    throw th8;
                }
            }
            gapComposer.endReplaceGroup();
        }
        gapComposer.startReplaceGroup(213451701);
        long j23 = ((ColorScheme) objM8).surfaceContainer;
        gapComposer.endReplaceGroup();
        Color colorM478boximpl15 = Color.m478boximpl(j23);
        boolean z24 = (i5 > 4 && gapComposer.changed(transitionInstance)) || (i3 & 6) == 4;
        Object objRememberedValue23 = gapComposer.rememberedValue();
        if (z24 || objRememberedValue23 == neverEqualPolicy) {
            objRememberedValue23 = SnapshotStateKt__DerivedStateKt.derivedStateOf(new ColorSchemeKt$animateFixedColors$$inlined$animateColor$8(transitionInstance, (byte) 25));
            gapComposer.updateRememberedValue(objRememberedValue23);
        }
        ColorScheme colorScheme16 = (ColorScheme) ((State) objRememberedValue23).getValue();
        gapComposer.startReplaceGroup(213451701);
        long j24 = colorScheme16.surfaceContainer;
        gapComposer.endReplaceGroup();
        Color colorM478boximpl16 = Color.m478boximpl(j24);
        boolean z25 = (i5 > 4 && gapComposer.changed(transitionInstance)) || (i3 & 6) == 4;
        Object objRememberedValue24 = gapComposer.rememberedValue();
        if (z25 || objRememberedValue24 == neverEqualPolicy) {
            objRememberedValue24 = SnapshotStateKt__DerivedStateKt.derivedStateOf(new ColorSchemeKt$animateFixedColors$$inlined$animateColor$8(transitionInstance, (byte) 26));
            gapComposer.updateRememberedValue(objRememberedValue24);
        }
        Transition.TransitionAnimationState transitionAnimationStateCreateTransitionAnimation8 = ArcSplineKt.createTransitionAnimation(transitionInstance, colorM478boximpl15, colorM478boximpl16, (FiniteAnimationSpec) function3.invoke(((State) objRememberedValue24).getValue(), gapComposer, Integer.valueOf(i6)), twoWayConverterImpl8, gapComposer, i7);
        ColorScheme colorScheme17 = (ColorScheme) transitionInstance.getTargetState();
        gapComposer.startReplaceGroup(-1129354377);
        long j25 = colorScheme17.surfaceContainerHigh;
        gapComposer.endReplaceGroup();
        ColorSpace colorSpaceM483getColorSpaceimpl9 = Color.m483getColorSpaceimpl(j25);
        boolean zChanged9 = gapComposer.changed(colorSpaceM483getColorSpaceimpl9);
        Object objRememberedValue25 = gapComposer.rememberedValue();
        if (zChanged9 || objRememberedValue25 == neverEqualPolicy) {
            objRememberedValue25 = IntIntPair$$ExternalSyntheticOutline0.m(colorVectorConverterKt$ColorToVector$1$1, new CallsKt$await$2$1((byte) 1, colorSpaceM483getColorSpaceimpl9), gapComposer);
        }
        TwoWayConverterImpl twoWayConverterImpl9 = (TwoWayConverterImpl) objRememberedValue25;
        if (transitionInstance.isSeeking()) {
            twoWayConverterImpl9 = twoWayConverterImpl9;
            objM9 = Format$$ExternalSyntheticOutline0.m(gapComposer, 1666827533, transitionInstance);
        } else {
            gapComposer.startReplaceGroup(1666573488);
            boolean z26 = (i5 > 4 && gapComposer.changed(transitionInstance)) || (i3 & 6) == 4;
            objM9 = gapComposer.rememberedValue();
            if (z26 || objM9 == neverEqualPolicy) {
                Snapshot currentThreadSnapshot9 = Lock.getCurrentThreadSnapshot();
                Function1 readObserver9 = currentThreadSnapshot9 != null ? currentThreadSnapshot9.getReadObserver() : null;
                Snapshot snapshotMakeCurrentNonObservable9 = Lock.makeCurrentNonObservable(currentThreadSnapshot9);
                try {
                    Object currentState9 = transitionInstance.getCurrentState();
                    Lock.restoreNonObservable(currentThreadSnapshot9, snapshotMakeCurrentNonObservable9, readObserver9);
                    gapComposer.updateRememberedValue(currentState9);
                    objM9 = currentState9;
                } catch (Throwable th9) {
                    Lock.restoreNonObservable(currentThreadSnapshot9, snapshotMakeCurrentNonObservable9, readObserver9);
                    throw th9;
                }
            }
            gapComposer.endReplaceGroup();
        }
        gapComposer.startReplaceGroup(-1129354377);
        long j26 = ((ColorScheme) objM9).surfaceContainerHigh;
        gapComposer.endReplaceGroup();
        Color colorM478boximpl17 = Color.m478boximpl(j26);
        boolean z27 = (i5 > 4 && gapComposer.changed(transitionInstance)) || (i3 & 6) == 4;
        Object objRememberedValue26 = gapComposer.rememberedValue();
        if (z27 || objRememberedValue26 == neverEqualPolicy) {
            objRememberedValue26 = SnapshotStateKt__DerivedStateKt.derivedStateOf(new ColorSchemeKt$animateFixedColors$$inlined$animateColor$8(transitionInstance, (byte) 27));
            gapComposer.updateRememberedValue(objRememberedValue26);
        }
        ColorScheme colorScheme18 = (ColorScheme) ((State) objRememberedValue26).getValue();
        gapComposer.startReplaceGroup(-1129354377);
        long j27 = colorScheme18.surfaceContainerHigh;
        gapComposer.endReplaceGroup();
        Color colorM478boximpl18 = Color.m478boximpl(j27);
        boolean z28 = (i5 > 4 && gapComposer.changed(transitionInstance)) || (i3 & 6) == 4;
        Object objRememberedValue27 = gapComposer.rememberedValue();
        if (z28 || objRememberedValue27 == neverEqualPolicy) {
            objRememberedValue27 = SnapshotStateKt__DerivedStateKt.derivedStateOf(new ColorSchemeKt$animateFixedColors$$inlined$animateColor$8(transitionInstance, (byte) 28));
            gapComposer.updateRememberedValue(objRememberedValue27);
        }
        Transition.TransitionAnimationState transitionAnimationStateCreateTransitionAnimation9 = ArcSplineKt.createTransitionAnimation(transitionInstance, colorM478boximpl17, colorM478boximpl18, (FiniteAnimationSpec) function3.invoke(((State) objRememberedValue27).getValue(), gapComposer, Integer.valueOf(i6)), twoWayConverterImpl9, gapComposer, i7);
        ColorScheme colorScheme19 = (ColorScheme) transitionInstance.getTargetState();
        gapComposer.startReplaceGroup(468788165);
        long j28 = colorScheme19.surfaceContainerHighest;
        gapComposer.endReplaceGroup();
        ColorSpace colorSpaceM483getColorSpaceimpl10 = Color.m483getColorSpaceimpl(j28);
        boolean zChanged10 = gapComposer.changed(colorSpaceM483getColorSpaceimpl10);
        Object objRememberedValue28 = gapComposer.rememberedValue();
        if (zChanged10 || objRememberedValue28 == neverEqualPolicy) {
            objRememberedValue28 = IntIntPair$$ExternalSyntheticOutline0.m(colorVectorConverterKt$ColorToVector$1$1, new CallsKt$await$2$1((byte) 1, colorSpaceM483getColorSpaceimpl10), gapComposer);
        }
        TwoWayConverterImpl twoWayConverterImpl10 = (TwoWayConverterImpl) objRememberedValue28;
        if (transitionInstance.isSeeking()) {
            twoWayConverterImpl10 = twoWayConverterImpl10;
            objM10 = Format$$ExternalSyntheticOutline0.m(gapComposer, 1666827533, transitionInstance);
        } else {
            gapComposer.startReplaceGroup(1666573488);
            boolean z29 = (i5 > 4 && gapComposer.changed(transitionInstance)) || (i3 & 6) == 4;
            objM10 = gapComposer.rememberedValue();
            if (z29 || objM10 == neverEqualPolicy) {
                Snapshot currentThreadSnapshot10 = Lock.getCurrentThreadSnapshot();
                Function1 readObserver10 = currentThreadSnapshot10 != null ? currentThreadSnapshot10.getReadObserver() : null;
                Snapshot snapshotMakeCurrentNonObservable10 = Lock.makeCurrentNonObservable(currentThreadSnapshot10);
                try {
                    Object currentState10 = transitionInstance.getCurrentState();
                    Lock.restoreNonObservable(currentThreadSnapshot10, snapshotMakeCurrentNonObservable10, readObserver10);
                    gapComposer.updateRememberedValue(currentState10);
                    objM10 = currentState10;
                } catch (Throwable th10) {
                    Lock.restoreNonObservable(currentThreadSnapshot10, snapshotMakeCurrentNonObservable10, readObserver10);
                    throw th10;
                }
            }
            gapComposer.endReplaceGroup();
        }
        gapComposer.startReplaceGroup(468788165);
        long j29 = ((ColorScheme) objM10).surfaceContainerHighest;
        gapComposer.endReplaceGroup();
        Color colorM478boximpl19 = Color.m478boximpl(j29);
        boolean z30 = (i5 > 4 && gapComposer.changed(transitionInstance)) || (i3 & 6) == 4;
        Object objRememberedValue29 = gapComposer.rememberedValue();
        if (z30 || objRememberedValue29 == neverEqualPolicy) {
            objRememberedValue29 = SnapshotStateKt__DerivedStateKt.derivedStateOf(new ColorSchemeKt$animateFixedColors$$inlined$animateColor$8(transitionInstance, (byte) 29));
            gapComposer.updateRememberedValue(objRememberedValue29);
        }
        ColorScheme colorScheme20 = (ColorScheme) ((State) objRememberedValue29).getValue();
        gapComposer.startReplaceGroup(468788165);
        long j30 = colorScheme20.surfaceContainerHighest;
        gapComposer.endReplaceGroup();
        Color colorM478boximpl20 = Color.m478boximpl(j30);
        boolean z31 = (i5 > 4 && gapComposer.changed(transitionInstance)) || (i3 & 6) == 4;
        Object objRememberedValue30 = gapComposer.rememberedValue();
        if (z31 || objRememberedValue30 == neverEqualPolicy) {
            objRememberedValue30 = SnapshotStateKt__DerivedStateKt.derivedStateOf(new ColorSchemeKt$animateSurfaceColors$$inlined$animateColor$1(transitionInstance, (byte) 1));
            gapComposer.updateRememberedValue(objRememberedValue30);
        }
        Transition.TransitionAnimationState transitionAnimationStateCreateTransitionAnimation10 = ArcSplineKt.createTransitionAnimation(transitionInstance, colorM478boximpl19, colorM478boximpl20, (FiniteAnimationSpec) function3.invoke(((State) objRememberedValue30).getValue(), gapComposer, Integer.valueOf(i6)), twoWayConverterImpl10, gapComposer, i7);
        ColorScheme colorScheme21 = (ColorScheme) transitionInstance.getTargetState();
        gapComposer.startReplaceGroup(-1518988939);
        long j31 = colorScheme21.surfaceContainerLow;
        gapComposer.endReplaceGroup();
        ColorSpace colorSpaceM483getColorSpaceimpl11 = Color.m483getColorSpaceimpl(j31);
        boolean zChanged11 = gapComposer.changed(colorSpaceM483getColorSpaceimpl11);
        Object objRememberedValue31 = gapComposer.rememberedValue();
        if (zChanged11 || objRememberedValue31 == neverEqualPolicy) {
            objRememberedValue31 = IntIntPair$$ExternalSyntheticOutline0.m(colorVectorConverterKt$ColorToVector$1$1, new CallsKt$await$2$1((byte) 1, colorSpaceM483getColorSpaceimpl11), gapComposer);
        }
        TwoWayConverterImpl twoWayConverterImpl11 = (TwoWayConverterImpl) objRememberedValue31;
        if (transitionInstance.isSeeking()) {
            twoWayConverterImpl11 = twoWayConverterImpl11;
            objM11 = Format$$ExternalSyntheticOutline0.m(gapComposer, 1666827533, transitionInstance);
        } else {
            gapComposer.startReplaceGroup(1666573488);
            boolean z32 = (i5 > 4 && gapComposer.changed(transitionInstance)) || (i3 & 6) == 4;
            objM11 = gapComposer.rememberedValue();
            if (z32 || objM11 == neverEqualPolicy) {
                Snapshot currentThreadSnapshot11 = Lock.getCurrentThreadSnapshot();
                Function1 readObserver11 = currentThreadSnapshot11 != null ? currentThreadSnapshot11.getReadObserver() : null;
                Snapshot snapshotMakeCurrentNonObservable11 = Lock.makeCurrentNonObservable(currentThreadSnapshot11);
                try {
                    Object currentState11 = transitionInstance.getCurrentState();
                    Lock.restoreNonObservable(currentThreadSnapshot11, snapshotMakeCurrentNonObservable11, readObserver11);
                    gapComposer.updateRememberedValue(currentState11);
                    objM11 = currentState11;
                } catch (Throwable th11) {
                    Lock.restoreNonObservable(currentThreadSnapshot11, snapshotMakeCurrentNonObservable11, readObserver11);
                    throw th11;
                }
            }
            gapComposer.endReplaceGroup();
        }
        gapComposer.startReplaceGroup(-1518988939);
        long j32 = ((ColorScheme) objM11).surfaceContainerLow;
        gapComposer.endReplaceGroup();
        Color colorM478boximpl21 = Color.m478boximpl(j32);
        boolean z33 = (i5 > 4 && gapComposer.changed(transitionInstance)) || (i3 & 6) == 4;
        Object objRememberedValue32 = gapComposer.rememberedValue();
        if (z33 || objRememberedValue32 == neverEqualPolicy) {
            objRememberedValue32 = SnapshotStateKt__DerivedStateKt.derivedStateOf(new ColorSchemeKt$animateSurfaceColors$$inlined$animateColor$1(transitionInstance, (byte) 2));
            gapComposer.updateRememberedValue(objRememberedValue32);
        }
        ColorScheme colorScheme22 = (ColorScheme) ((State) objRememberedValue32).getValue();
        gapComposer.startReplaceGroup(-1518988939);
        long j33 = colorScheme22.surfaceContainerLow;
        gapComposer.endReplaceGroup();
        Color colorM478boximpl22 = Color.m478boximpl(j33);
        boolean z34 = (i5 > 4 && gapComposer.changed(transitionInstance)) || (i3 & 6) == 4;
        Object objRememberedValue33 = gapComposer.rememberedValue();
        if (z34 || objRememberedValue33 == neverEqualPolicy) {
            objRememberedValue33 = SnapshotStateKt__DerivedStateKt.derivedStateOf(new ColorSchemeKt$animateSurfaceColors$$inlined$animateColor$1(transitionInstance, (byte) 3));
            gapComposer.updateRememberedValue(objRememberedValue33);
        }
        Transition.TransitionAnimationState transitionAnimationStateCreateTransitionAnimation11 = ArcSplineKt.createTransitionAnimation(transitionInstance, colorM478boximpl21, colorM478boximpl22, (FiniteAnimationSpec) function3.invoke(((State) objRememberedValue33).getValue(), gapComposer, Integer.valueOf(i6)), twoWayConverterImpl11, gapComposer, i7);
        ColorScheme colorScheme23 = (ColorScheme) transitionInstance.getTargetState();
        gapComposer.startReplaceGroup(-2132814585);
        long j34 = colorScheme23.surfaceContainerLowest;
        gapComposer.endReplaceGroup();
        ColorSpace colorSpaceM483getColorSpaceimpl12 = Color.m483getColorSpaceimpl(j34);
        boolean zChanged12 = gapComposer.changed(colorSpaceM483getColorSpaceimpl12);
        Object objRememberedValue34 = gapComposer.rememberedValue();
        if (zChanged12 || objRememberedValue34 == neverEqualPolicy) {
            z = true;
            objM12 = IntIntPair$$ExternalSyntheticOutline0.m(colorVectorConverterKt$ColorToVector$1$1, new CallsKt$await$2$1((byte) 1, colorSpaceM483getColorSpaceimpl12), gapComposer);
        } else {
            objM12 = objRememberedValue34;
            z = true;
        }
        TwoWayConverterImpl twoWayConverterImpl12 = (TwoWayConverterImpl) objM12;
        if (transitionInstance.isSeeking()) {
            objM13 = Format$$ExternalSyntheticOutline0.m(gapComposer, 1666827533, transitionInstance);
        } else {
            gapComposer.startReplaceGroup(1666573488);
            boolean z35 = ((i5 <= 4 || !gapComposer.changed(transitionInstance)) && (i3 & 6) != 4) ? false : z;
            objM13 = gapComposer.rememberedValue();
            if (z35 || objM13 == neverEqualPolicy) {
                Snapshot currentThreadSnapshot12 = Lock.getCurrentThreadSnapshot();
                Function1 readObserver12 = currentThreadSnapshot12 != null ? currentThreadSnapshot12.getReadObserver() : null;
                Snapshot snapshotMakeCurrentNonObservable12 = Lock.makeCurrentNonObservable(currentThreadSnapshot12);
                try {
                    Object currentState12 = transitionInstance.getCurrentState();
                    Lock.restoreNonObservable(currentThreadSnapshot12, snapshotMakeCurrentNonObservable12, readObserver12);
                    gapComposer.updateRememberedValue(currentState12);
                    objM13 = currentState12;
                } catch (Throwable th12) {
                    Lock.restoreNonObservable(currentThreadSnapshot12, snapshotMakeCurrentNonObservable12, readObserver12);
                    throw th12;
                }
            }
            gapComposer.endReplaceGroup();
        }
        gapComposer.startReplaceGroup(-2132814585);
        long j35 = ((ColorScheme) objM13).surfaceContainerLowest;
        gapComposer.endReplaceGroup();
        Color colorM478boximpl23 = Color.m478boximpl(j35);
        boolean z36 = (i5 > 4 && gapComposer.changed(transitionInstance)) || (i3 & 6) == 4;
        Object objRememberedValue35 = gapComposer.rememberedValue();
        if (z36 || objRememberedValue35 == neverEqualPolicy) {
            objRememberedValue35 = SnapshotStateKt__DerivedStateKt.derivedStateOf(new ColorSchemeKt$animateSurfaceColors$$inlined$animateColor$1(transitionInstance, (byte) 4));
            gapComposer.updateRememberedValue(objRememberedValue35);
        }
        ColorScheme colorScheme24 = (ColorScheme) ((State) objRememberedValue35).getValue();
        gapComposer.startReplaceGroup(-2132814585);
        long j36 = colorScheme24.surfaceContainerLowest;
        gapComposer.endReplaceGroup();
        Color colorM478boximpl24 = Color.m478boximpl(j36);
        boolean z37 = (i5 > 4 && gapComposer.changed(transitionInstance)) || (i3 & 6) == 4;
        Object objRememberedValue36 = gapComposer.rememberedValue();
        if (z37 || objRememberedValue36 == neverEqualPolicy) {
            objRememberedValue36 = SnapshotStateKt__DerivedStateKt.derivedStateOf(new ColorSchemeKt$animateSurfaceColors$$inlined$animateColor$1(transitionInstance, (byte) 5));
            gapComposer.updateRememberedValue(objRememberedValue36);
        }
        return CollectionsKt__IterablesKt.listOf((Object[]) new Color[]{Color.m478boximpl(animateSurfaceColors$lambda$1(transitionAnimationStateCreateTransitionAnimation)), Color.m478boximpl(animateSurfaceColors$lambda$3(transitionAnimationStateCreateTransitionAnimation2)), Color.m478boximpl(animateSurfaceColors$lambda$5(transitionAnimationStateCreateTransitionAnimation3)), Color.m478boximpl(animateSurfaceColors$lambda$7(transitionAnimationStateCreateTransitionAnimation4)), Color.m478boximpl(animateSurfaceColors$lambda$9(transitionAnimationStateCreateTransitionAnimation5)), Color.m478boximpl(animateSurfaceColors$lambda$11(transitionAnimationStateCreateTransitionAnimation6)), Color.m478boximpl(animateSurfaceColors$lambda$13(transitionAnimationStateCreateTransitionAnimation7)), Color.m478boximpl(animateSurfaceColors$lambda$15(transitionAnimationStateCreateTransitionAnimation8)), Color.m478boximpl(animateSurfaceColors$lambda$17(transitionAnimationStateCreateTransitionAnimation9)), Color.m478boximpl(animateSurfaceColors$lambda$19(transitionAnimationStateCreateTransitionAnimation10)), Color.m478boximpl(animateSurfaceColors$lambda$21(transitionAnimationStateCreateTransitionAnimation11)), Color.m478boximpl(animateSurfaceColors$lambda$23(ArcSplineKt.createTransitionAnimation(transitionInstance, colorM478boximpl23, colorM478boximpl24, (FiniteAnimationSpec) function3.invoke(((State) objRememberedValue36).getValue(), gapComposer, Integer.valueOf(i6)), twoWayConverterImpl12, gapComposer, i7)))});
    }

    public static final long animateSurfaceColors$lambda$1(Transition.TransitionAnimationState transitionAnimationState) {
        return ((Color) transitionAnimationState.getValue()).value;
    }

    public static final long animateSurfaceColors$lambda$11(Transition.TransitionAnimationState transitionAnimationState) {
        return ((Color) transitionAnimationState.getValue()).value;
    }

    public static final long animateSurfaceColors$lambda$13(Transition.TransitionAnimationState transitionAnimationState) {
        return ((Color) transitionAnimationState.getValue()).value;
    }

    public static final long animateSurfaceColors$lambda$15(Transition.TransitionAnimationState transitionAnimationState) {
        return ((Color) transitionAnimationState.getValue()).value;
    }

    public static final long animateSurfaceColors$lambda$17(Transition.TransitionAnimationState transitionAnimationState) {
        return ((Color) transitionAnimationState.getValue()).value;
    }

    public static final long animateSurfaceColors$lambda$19(Transition.TransitionAnimationState transitionAnimationState) {
        return ((Color) transitionAnimationState.getValue()).value;
    }

    public static final long animateSurfaceColors$lambda$21(Transition.TransitionAnimationState transitionAnimationState) {
        return ((Color) transitionAnimationState.getValue()).value;
    }

    public static final long animateSurfaceColors$lambda$23(Transition.TransitionAnimationState transitionAnimationState) {
        return ((Color) transitionAnimationState.getValue()).value;
    }

    public static final long animateSurfaceColors$lambda$3(Transition.TransitionAnimationState transitionAnimationState) {
        return ((Color) transitionAnimationState.getValue()).value;
    }

    public static final long animateSurfaceColors$lambda$5(Transition.TransitionAnimationState transitionAnimationState) {
        return ((Color) transitionAnimationState.getValue()).value;
    }

    public static final long animateSurfaceColors$lambda$7(Transition.TransitionAnimationState transitionAnimationState) {
        return ((Color) transitionAnimationState.getValue()).value;
    }

    public static final long animateSurfaceColors$lambda$9(Transition.TransitionAnimationState transitionAnimationState) {
        return ((Color) transitionAnimationState.getValue()).value;
    }

    public static final List animateTertiaryColors(TransitionInstance transitionInstance, Function3 function3, Composer composer, int i) {
        Object objM;
        Object objM2;
        boolean z;
        Object objM3;
        boolean z2;
        Object objM4;
        boolean z3;
        Object objM5;
        int i2 = (i & 14) | 384 | (i & 112);
        ParcelableSnapshotMutableState parcelableSnapshotMutableState = transitionInstance.targetState$delegate;
        TagPayloadReader tagPayloadReader = transitionInstance.transitionState;
        ColorScheme colorScheme = (ColorScheme) parcelableSnapshotMutableState.getValue();
        GapComposer gapComposer = (GapComposer) composer;
        gapComposer.startReplaceGroup(193446150);
        long j = colorScheme.tertiary;
        boolean z4 = false;
        gapComposer.end(false);
        ColorSpace colorSpaceM483getColorSpaceimpl = Color.m483getColorSpaceimpl(j);
        boolean zChanged = gapComposer.changed(colorSpaceM483getColorSpaceimpl);
        Object objRememberedValue = gapComposer.rememberedValue();
        ColorVectorConverterKt$ColorToVector$1$1 colorVectorConverterKt$ColorToVector$1$1 = ColorVectorConverterKt$ColorToVector$1$1.INSTANCE;
        NeverEqualPolicy neverEqualPolicy = Composer.Companion.Empty;
        if (zChanged || objRememberedValue == neverEqualPolicy) {
            objRememberedValue = IntIntPair$$ExternalSyntheticOutline0.m(colorVectorConverterKt$ColorToVector$1$1, new CallsKt$await$2$1((byte) 1, colorSpaceM483getColorSpaceimpl), gapComposer);
        }
        TwoWayConverterImpl twoWayConverterImpl = (TwoWayConverterImpl) objRememberedValue;
        int i3 = ((i2 << 3) & 896) | (i2 & 14) | 3072;
        if (transitionInstance.isSeeking()) {
            objM = IntIntPair$$ExternalSyntheticOutline0.m(gapComposer, 1666827533, false, tagPayloadReader);
        } else {
            gapComposer.startReplaceGroup(1666573488);
            boolean z5 = (((i3 & 14) ^ 6) > 4 && gapComposer.changed(transitionInstance)) || (i3 & 6) == 4;
            objM = gapComposer.rememberedValue();
            if (z5 || objM == neverEqualPolicy) {
                Snapshot currentThreadSnapshot = Lock.getCurrentThreadSnapshot();
                Function1 readObserver = currentThreadSnapshot != null ? currentThreadSnapshot.getReadObserver() : null;
                Snapshot snapshotMakeCurrentNonObservable = Lock.makeCurrentNonObservable(currentThreadSnapshot);
                try {
                    Object currentState = tagPayloadReader.getCurrentState();
                    Lock.restoreNonObservable(currentThreadSnapshot, snapshotMakeCurrentNonObservable, readObserver);
                    gapComposer.updateRememberedValue(currentState);
                    objM = currentState;
                } catch (Throwable th) {
                    Lock.restoreNonObservable(currentThreadSnapshot, snapshotMakeCurrentNonObservable, readObserver);
                    throw th;
                }
            }
            gapComposer.end(false);
        }
        gapComposer.startReplaceGroup(193446150);
        Color colorM = Fragment$5$$ExternalSyntheticOutline0.m(gapComposer, false, ((ColorScheme) objM).tertiary);
        int i4 = i3 & 14;
        int i5 = i4 ^ 6;
        boolean z6 = (i5 > 4 && gapComposer.changed(transitionInstance)) || (i3 & 6) == 4;
        Object objRememberedValue2 = gapComposer.rememberedValue();
        if (z6 || objRememberedValue2 == neverEqualPolicy) {
            objRememberedValue2 = SnapshotStateKt__DerivedStateKt.derivedStateOf(new ColorSchemeKt$animateSurfaceColors$$inlined$animateColor$1(transitionInstance, (byte) 14));
            gapComposer.updateRememberedValue(objRememberedValue2);
        }
        ColorScheme colorScheme2 = (ColorScheme) ((State) objRememberedValue2).getValue();
        gapComposer.startReplaceGroup(193446150);
        Color colorM2 = Fragment$5$$ExternalSyntheticOutline0.m(gapComposer, false, colorScheme2.tertiary);
        boolean z7 = (i5 > 4 && gapComposer.changed(transitionInstance)) || (i3 & 6) == 4;
        Object objRememberedValue3 = gapComposer.rememberedValue();
        if (z7 || objRememberedValue3 == neverEqualPolicy) {
            objRememberedValue3 = SnapshotStateKt__DerivedStateKt.derivedStateOf(new ColorSchemeKt$animateSurfaceColors$$inlined$animateColor$1(transitionInstance, (byte) 15));
            gapComposer.updateRememberedValue(objRememberedValue3);
        }
        int i6 = (i3 >> 3) & 112;
        FiniteAnimationSpec finiteAnimationSpec = (FiniteAnimationSpec) function3.invoke(((State) objRememberedValue3).getValue(), gapComposer, Integer.valueOf(i6));
        int i7 = 196608 | i4;
        Transition.TransitionAnimationState transitionAnimationStateCreateTransitionAnimation = ArcSplineKt.createTransitionAnimation(transitionInstance, colorM, colorM2, finiteAnimationSpec, twoWayConverterImpl, gapComposer, i7);
        ColorScheme colorScheme3 = (ColorScheme) parcelableSnapshotMutableState.getValue();
        gapComposer.startReplaceGroup(-971161369);
        long j2 = colorScheme3.onTertiary;
        gapComposer.end(false);
        ColorSpace colorSpaceM483getColorSpaceimpl2 = Color.m483getColorSpaceimpl(j2);
        boolean zChanged2 = gapComposer.changed(colorSpaceM483getColorSpaceimpl2);
        Object objRememberedValue4 = gapComposer.rememberedValue();
        if (zChanged2 || objRememberedValue4 == neverEqualPolicy) {
            objRememberedValue4 = IntIntPair$$ExternalSyntheticOutline0.m(colorVectorConverterKt$ColorToVector$1$1, new CallsKt$await$2$1((byte) 1, colorSpaceM483getColorSpaceimpl2), gapComposer);
        }
        TwoWayConverterImpl twoWayConverterImpl2 = (TwoWayConverterImpl) objRememberedValue4;
        if (transitionInstance.isSeeking()) {
            objM2 = IntIntPair$$ExternalSyntheticOutline0.m(gapComposer, 1666827533, false, tagPayloadReader);
        } else {
            gapComposer.startReplaceGroup(1666573488);
            boolean z8 = (i5 > 4 && gapComposer.changed(transitionInstance)) || (i3 & 6) == 4;
            objM2 = gapComposer.rememberedValue();
            if (z8 || objM2 == neverEqualPolicy) {
                Snapshot currentThreadSnapshot2 = Lock.getCurrentThreadSnapshot();
                Function1 readObserver2 = currentThreadSnapshot2 != null ? currentThreadSnapshot2.getReadObserver() : null;
                Snapshot snapshotMakeCurrentNonObservable2 = Lock.makeCurrentNonObservable(currentThreadSnapshot2);
                try {
                    Object currentState2 = tagPayloadReader.getCurrentState();
                    Lock.restoreNonObservable(currentThreadSnapshot2, snapshotMakeCurrentNonObservable2, readObserver2);
                    gapComposer.updateRememberedValue(currentState2);
                    objM2 = currentState2;
                    z4 = false;
                } catch (Throwable th2) {
                    Lock.restoreNonObservable(currentThreadSnapshot2, snapshotMakeCurrentNonObservable2, readObserver2);
                    throw th2;
                }
            }
            gapComposer.end(z4);
        }
        gapComposer.startReplaceGroup(-971161369);
        Color colorM3 = Fragment$5$$ExternalSyntheticOutline0.m(gapComposer, z4, ((ColorScheme) objM2).onTertiary);
        boolean z9 = (i5 > 4 && gapComposer.changed(transitionInstance)) || (i3 & 6) == 4;
        Object objRememberedValue5 = gapComposer.rememberedValue();
        if (z9 || objRememberedValue5 == neverEqualPolicy) {
            objRememberedValue5 = SnapshotStateKt__DerivedStateKt.derivedStateOf(new ColorSchemeKt$animateSurfaceColors$$inlined$animateColor$1(transitionInstance, (byte) 16));
            gapComposer.updateRememberedValue(objRememberedValue5);
        }
        ColorScheme colorScheme4 = (ColorScheme) ((State) objRememberedValue5).getValue();
        gapComposer.startReplaceGroup(-971161369);
        Color colorM4 = Fragment$5$$ExternalSyntheticOutline0.m(gapComposer, false, colorScheme4.onTertiary);
        boolean z10 = (i5 > 4 && gapComposer.changed(transitionInstance)) || (i3 & 6) == 4;
        Object objRememberedValue6 = gapComposer.rememberedValue();
        if (z10 || objRememberedValue6 == neverEqualPolicy) {
            objRememberedValue6 = SnapshotStateKt__DerivedStateKt.derivedStateOf(new ColorSchemeKt$animateSurfaceColors$$inlined$animateColor$1(transitionInstance, (byte) 17));
            gapComposer.updateRememberedValue(objRememberedValue6);
        }
        Transition.TransitionAnimationState transitionAnimationStateCreateTransitionAnimation2 = ArcSplineKt.createTransitionAnimation(transitionInstance, colorM3, colorM4, (FiniteAnimationSpec) function3.invoke(((State) objRememberedValue6).getValue(), gapComposer, Integer.valueOf(i6)), twoWayConverterImpl2, gapComposer, i7);
        ColorScheme colorScheme5 = (ColorScheme) parcelableSnapshotMutableState.getValue();
        gapComposer.startReplaceGroup(-639376011);
        long j3 = colorScheme5.tertiaryContainer;
        gapComposer.end(false);
        ColorSpace colorSpaceM483getColorSpaceimpl3 = Color.m483getColorSpaceimpl(j3);
        boolean zChanged3 = gapComposer.changed(colorSpaceM483getColorSpaceimpl3);
        Object objRememberedValue7 = gapComposer.rememberedValue();
        if (zChanged3 || objRememberedValue7 == neverEqualPolicy) {
            objRememberedValue7 = IntIntPair$$ExternalSyntheticOutline0.m(colorVectorConverterKt$ColorToVector$1$1, new CallsKt$await$2$1((byte) 1, colorSpaceM483getColorSpaceimpl3), gapComposer);
        }
        TwoWayConverterImpl twoWayConverterImpl3 = (TwoWayConverterImpl) objRememberedValue7;
        if (transitionInstance.isSeeking()) {
            transitionAnimationStateCreateTransitionAnimation2 = transitionAnimationStateCreateTransitionAnimation2;
            z = false;
            objM3 = IntIntPair$$ExternalSyntheticOutline0.m(gapComposer, 1666827533, false, tagPayloadReader);
        } else {
            gapComposer.startReplaceGroup(1666573488);
            boolean z11 = (i5 > 4 && gapComposer.changed(transitionInstance)) || (i3 & 6) == 4;
            objM3 = gapComposer.rememberedValue();
            if (z11 || objM3 == neverEqualPolicy) {
                Snapshot currentThreadSnapshot3 = Lock.getCurrentThreadSnapshot();
                Function1 readObserver3 = currentThreadSnapshot3 != null ? currentThreadSnapshot3.getReadObserver() : null;
                Snapshot snapshotMakeCurrentNonObservable3 = Lock.makeCurrentNonObservable(currentThreadSnapshot3);
                try {
                    Object currentState3 = tagPayloadReader.getCurrentState();
                    Lock.restoreNonObservable(currentThreadSnapshot3, snapshotMakeCurrentNonObservable3, readObserver3);
                    gapComposer.updateRememberedValue(currentState3);
                    objM3 = currentState3;
                } catch (Throwable th3) {
                    Lock.restoreNonObservable(currentThreadSnapshot3, snapshotMakeCurrentNonObservable3, readObserver3);
                    throw th3;
                }
            }
            z = false;
            gapComposer.end(false);
        }
        gapComposer.startReplaceGroup(-639376011);
        Color colorM5 = Fragment$5$$ExternalSyntheticOutline0.m(gapComposer, z, ((ColorScheme) objM3).tertiaryContainer);
        boolean z12 = (i5 > 4 && gapComposer.changed(transitionInstance)) || (i3 & 6) == 4;
        Object objRememberedValue8 = gapComposer.rememberedValue();
        if (z12 || objRememberedValue8 == neverEqualPolicy) {
            objRememberedValue8 = SnapshotStateKt__DerivedStateKt.derivedStateOf(new ColorSchemeKt$animateSurfaceColors$$inlined$animateColor$1(transitionInstance, (byte) 18));
            gapComposer.updateRememberedValue(objRememberedValue8);
        }
        ColorScheme colorScheme6 = (ColorScheme) ((State) objRememberedValue8).getValue();
        gapComposer.startReplaceGroup(-639376011);
        Color colorM6 = Fragment$5$$ExternalSyntheticOutline0.m(gapComposer, false, colorScheme6.tertiaryContainer);
        boolean z13 = (i5 > 4 && gapComposer.changed(transitionInstance)) || (i3 & 6) == 4;
        Object objRememberedValue9 = gapComposer.rememberedValue();
        if (z13 || objRememberedValue9 == neverEqualPolicy) {
            objRememberedValue9 = SnapshotStateKt__DerivedStateKt.derivedStateOf(new ColorSchemeKt$animateSurfaceColors$$inlined$animateColor$1(transitionInstance, (byte) 19));
            gapComposer.updateRememberedValue(objRememberedValue9);
        }
        Transition.TransitionAnimationState transitionAnimationState = transitionAnimationStateCreateTransitionAnimation2;
        Transition.TransitionAnimationState transitionAnimationStateCreateTransitionAnimation3 = ArcSplineKt.createTransitionAnimation(transitionInstance, colorM5, colorM6, (FiniteAnimationSpec) function3.invoke(((State) objRememberedValue9).getValue(), gapComposer, Integer.valueOf(i6)), twoWayConverterImpl3, gapComposer, i7);
        ColorScheme colorScheme7 = (ColorScheme) parcelableSnapshotMutableState.getValue();
        gapComposer.startReplaceGroup(1520022196);
        long j4 = colorScheme7.onTertiaryContainer;
        gapComposer.end(false);
        ColorSpace colorSpaceM483getColorSpaceimpl4 = Color.m483getColorSpaceimpl(j4);
        boolean zChanged4 = gapComposer.changed(colorSpaceM483getColorSpaceimpl4);
        Object objRememberedValue10 = gapComposer.rememberedValue();
        if (zChanged4 || objRememberedValue10 == neverEqualPolicy) {
            z2 = true;
            objM4 = IntIntPair$$ExternalSyntheticOutline0.m(colorVectorConverterKt$ColorToVector$1$1, new CallsKt$await$2$1((byte) 1, colorSpaceM483getColorSpaceimpl4), gapComposer);
        } else {
            objM4 = objRememberedValue10;
            z2 = true;
        }
        TwoWayConverterImpl twoWayConverterImpl4 = (TwoWayConverterImpl) objM4;
        if (transitionInstance.isSeeking()) {
            z3 = false;
            objM5 = IntIntPair$$ExternalSyntheticOutline0.m(gapComposer, 1666827533, false, tagPayloadReader);
        } else {
            gapComposer.startReplaceGroup(1666573488);
            boolean z14 = ((i5 <= 4 || !gapComposer.changed(transitionInstance)) && (i3 & 6) != 4) ? false : z2;
            Object objRememberedValue11 = gapComposer.rememberedValue();
            if (z14 || objRememberedValue11 == neverEqualPolicy) {
                Snapshot currentThreadSnapshot4 = Lock.getCurrentThreadSnapshot();
                Function1 readObserver4 = currentThreadSnapshot4 != null ? currentThreadSnapshot4.getReadObserver() : null;
                Snapshot snapshotMakeCurrentNonObservable4 = Lock.makeCurrentNonObservable(currentThreadSnapshot4);
                try {
                    Object currentState4 = tagPayloadReader.getCurrentState();
                    Lock.restoreNonObservable(currentThreadSnapshot4, snapshotMakeCurrentNonObservable4, readObserver4);
                    gapComposer.updateRememberedValue(currentState4);
                    objRememberedValue11 = currentState4;
                } catch (Throwable th4) {
                    Lock.restoreNonObservable(currentThreadSnapshot4, snapshotMakeCurrentNonObservable4, readObserver4);
                    throw th4;
                }
            }
            gapComposer.end(false);
            objM5 = objRememberedValue11;
            z3 = false;
        }
        gapComposer.startReplaceGroup(1520022196);
        Color colorM7 = Fragment$5$$ExternalSyntheticOutline0.m(gapComposer, z3, ((ColorScheme) objM5).onTertiaryContainer);
        boolean z15 = ((i5 <= 4 || !gapComposer.changed(transitionInstance)) && (i3 & 6) != 4) ? false : z2;
        Object objRememberedValue12 = gapComposer.rememberedValue();
        if (z15 || objRememberedValue12 == neverEqualPolicy) {
            objRememberedValue12 = SnapshotStateKt__DerivedStateKt.derivedStateOf(new ColorSchemeKt$animateSurfaceColors$$inlined$animateColor$1(transitionInstance, (byte) 20));
            gapComposer.updateRememberedValue(objRememberedValue12);
        }
        ColorScheme colorScheme8 = (ColorScheme) ((State) objRememberedValue12).getValue();
        gapComposer.startReplaceGroup(1520022196);
        Color colorM8 = Fragment$5$$ExternalSyntheticOutline0.m(gapComposer, false, colorScheme8.onTertiaryContainer);
        if ((i5 <= 4 || !gapComposer.changed(transitionInstance)) && (i3 & 6) != 4) {
            z2 = false;
        }
        Object objRememberedValue13 = gapComposer.rememberedValue();
        if (z2 || objRememberedValue13 == neverEqualPolicy) {
            objRememberedValue13 = SnapshotStateKt__DerivedStateKt.derivedStateOf(new ColorSchemeKt$animateSurfaceColors$$inlined$animateColor$1(transitionInstance, (byte) 21));
            gapComposer.updateRememberedValue(objRememberedValue13);
        }
        Transition.TransitionAnimationState transitionAnimationStateCreateTransitionAnimation4 = ArcSplineKt.createTransitionAnimation(transitionInstance, colorM7, colorM8, (FiniteAnimationSpec) function3.invoke(((State) objRememberedValue13).getValue(), gapComposer, Integer.valueOf(i6)), twoWayConverterImpl4, gapComposer, i7);
        Color color = (Color) transitionAnimationStateCreateTransitionAnimation.value$delegate.getValue();
        long j5 = color.value;
        Color color2 = (Color) transitionAnimationState.value$delegate.getValue();
        long j6 = color2.value;
        Color color3 = (Color) transitionAnimationStateCreateTransitionAnimation3.value$delegate.getValue();
        long j7 = color3.value;
        Color color4 = (Color) transitionAnimationStateCreateTransitionAnimation4.value$delegate.getValue();
        long j8 = color4.value;
        return CollectionsKt__IterablesKt.listOf((Object[]) new Color[]{color, color2, color3, color4});
    }

    public static final List animateUtilityColors(final TransitionInstance transitionInstance, Function3 function3, Composer composer, int i) {
        Object objM;
        Object objM2;
        Object objM3;
        Object objM4;
        boolean z;
        Object objM5;
        final byte b;
        Object objDerivedStateOf;
        int i2 = (i & 14) | 384 | (i & 112);
        ParcelableSnapshotMutableState parcelableSnapshotMutableState = transitionInstance.targetState$delegate;
        TagPayloadReader tagPayloadReader = transitionInstance.transitionState;
        ColorScheme colorScheme = (ColorScheme) parcelableSnapshotMutableState.getValue();
        GapComposer gapComposer = (GapComposer) composer;
        gapComposer.startReplaceGroup(-129903265);
        long j = colorScheme.inverseSurface;
        boolean z2 = false;
        gapComposer.end(false);
        ColorSpace colorSpaceM483getColorSpaceimpl = Color.m483getColorSpaceimpl(j);
        boolean zChanged = gapComposer.changed(colorSpaceM483getColorSpaceimpl);
        Object objRememberedValue = gapComposer.rememberedValue();
        ColorVectorConverterKt$ColorToVector$1$1 colorVectorConverterKt$ColorToVector$1$1 = ColorVectorConverterKt$ColorToVector$1$1.INSTANCE;
        NeverEqualPolicy neverEqualPolicy = Composer.Companion.Empty;
        if (zChanged || objRememberedValue == neverEqualPolicy) {
            objRememberedValue = IntIntPair$$ExternalSyntheticOutline0.m(colorVectorConverterKt$ColorToVector$1$1, new CallsKt$await$2$1((byte) 1, colorSpaceM483getColorSpaceimpl), gapComposer);
        }
        TwoWayConverterImpl twoWayConverterImpl = (TwoWayConverterImpl) objRememberedValue;
        int i3 = ((i2 << 3) & 896) | (i2 & 14) | 3072;
        if (transitionInstance.isSeeking()) {
            objM = IntIntPair$$ExternalSyntheticOutline0.m(gapComposer, 1666827533, false, tagPayloadReader);
        } else {
            gapComposer.startReplaceGroup(1666573488);
            boolean z3 = (((i3 & 14) ^ 6) > 4 && gapComposer.changed(transitionInstance)) || (i3 & 6) == 4;
            objM = gapComposer.rememberedValue();
            if (z3 || objM == neverEqualPolicy) {
                Snapshot currentThreadSnapshot = Lock.getCurrentThreadSnapshot();
                Function1 readObserver = currentThreadSnapshot != null ? currentThreadSnapshot.getReadObserver() : null;
                Snapshot snapshotMakeCurrentNonObservable = Lock.makeCurrentNonObservable(currentThreadSnapshot);
                try {
                    Object currentState = tagPayloadReader.getCurrentState();
                    Lock.restoreNonObservable(currentThreadSnapshot, snapshotMakeCurrentNonObservable, readObserver);
                    gapComposer.updateRememberedValue(currentState);
                    objM = currentState;
                } catch (Throwable th) {
                    Lock.restoreNonObservable(currentThreadSnapshot, snapshotMakeCurrentNonObservable, readObserver);
                    throw th;
                }
            }
            gapComposer.end(false);
        }
        gapComposer.startReplaceGroup(-129903265);
        Color colorM = Fragment$5$$ExternalSyntheticOutline0.m(gapComposer, false, ((ColorScheme) objM).inverseSurface);
        int i4 = i3 & 14;
        int i5 = i4 ^ 6;
        boolean z4 = (i5 > 4 && gapComposer.changed(transitionInstance)) || (i3 & 6) == 4;
        Object objRememberedValue2 = gapComposer.rememberedValue();
        if (z4 || objRememberedValue2 == neverEqualPolicy) {
            objRememberedValue2 = SnapshotStateKt__DerivedStateKt.derivedStateOf(new ColorSchemeKt$animateSurfaceColors$$inlined$animateColor$1(transitionInstance, (byte) 23));
            gapComposer.updateRememberedValue(objRememberedValue2);
        }
        ColorScheme colorScheme2 = (ColorScheme) ((State) objRememberedValue2).getValue();
        gapComposer.startReplaceGroup(-129903265);
        Color colorM2 = Fragment$5$$ExternalSyntheticOutline0.m(gapComposer, false, colorScheme2.inverseSurface);
        boolean z5 = (i5 > 4 && gapComposer.changed(transitionInstance)) || (i3 & 6) == 4;
        Object objRememberedValue3 = gapComposer.rememberedValue();
        if (z5 || objRememberedValue3 == neverEqualPolicy) {
            objRememberedValue3 = SnapshotStateKt__DerivedStateKt.derivedStateOf(new ColorSchemeKt$animateSurfaceColors$$inlined$animateColor$1(transitionInstance, (byte) 24));
            gapComposer.updateRememberedValue(objRememberedValue3);
        }
        int i6 = (i3 >> 3) & 112;
        FiniteAnimationSpec finiteAnimationSpec = (FiniteAnimationSpec) function3.invoke(((State) objRememberedValue3).getValue(), gapComposer, Integer.valueOf(i6));
        int i7 = 196608 | i4;
        Transition.TransitionAnimationState transitionAnimationStateCreateTransitionAnimation = ArcSplineKt.createTransitionAnimation(transitionInstance, colorM, colorM2, finiteAnimationSpec, twoWayConverterImpl, gapComposer, i7);
        ColorScheme colorScheme3 = (ColorScheme) parcelableSnapshotMutableState.getValue();
        gapComposer.startReplaceGroup(-917575040);
        long j2 = colorScheme3.inverseOnSurface;
        gapComposer.end(false);
        ColorSpace colorSpaceM483getColorSpaceimpl2 = Color.m483getColorSpaceimpl(j2);
        boolean zChanged2 = gapComposer.changed(colorSpaceM483getColorSpaceimpl2);
        Object objRememberedValue4 = gapComposer.rememberedValue();
        if (zChanged2 || objRememberedValue4 == neverEqualPolicy) {
            objRememberedValue4 = IntIntPair$$ExternalSyntheticOutline0.m(colorVectorConverterKt$ColorToVector$1$1, new CallsKt$await$2$1((byte) 1, colorSpaceM483getColorSpaceimpl2), gapComposer);
        }
        TwoWayConverterImpl twoWayConverterImpl2 = (TwoWayConverterImpl) objRememberedValue4;
        if (transitionInstance.isSeeking()) {
            objM2 = IntIntPair$$ExternalSyntheticOutline0.m(gapComposer, 1666827533, false, tagPayloadReader);
        } else {
            gapComposer.startReplaceGroup(1666573488);
            boolean z6 = (i5 > 4 && gapComposer.changed(transitionInstance)) || (i3 & 6) == 4;
            objM2 = gapComposer.rememberedValue();
            if (z6 || objM2 == neverEqualPolicy) {
                Snapshot currentThreadSnapshot2 = Lock.getCurrentThreadSnapshot();
                Function1 readObserver2 = currentThreadSnapshot2 != null ? currentThreadSnapshot2.getReadObserver() : null;
                Snapshot snapshotMakeCurrentNonObservable2 = Lock.makeCurrentNonObservable(currentThreadSnapshot2);
                try {
                    Object currentState2 = tagPayloadReader.getCurrentState();
                    Lock.restoreNonObservable(currentThreadSnapshot2, snapshotMakeCurrentNonObservable2, readObserver2);
                    gapComposer.updateRememberedValue(currentState2);
                    objM2 = currentState2;
                } catch (Throwable th2) {
                    Lock.restoreNonObservable(currentThreadSnapshot2, snapshotMakeCurrentNonObservable2, readObserver2);
                    throw th2;
                }
            }
            gapComposer.end(false);
        }
        gapComposer.startReplaceGroup(-917575040);
        Color colorM3 = Fragment$5$$ExternalSyntheticOutline0.m(gapComposer, false, ((ColorScheme) objM2).inverseOnSurface);
        boolean z7 = (i5 > 4 && gapComposer.changed(transitionInstance)) || (i3 & 6) == 4;
        Object objRememberedValue5 = gapComposer.rememberedValue();
        if (z7 || objRememberedValue5 == neverEqualPolicy) {
            objRememberedValue5 = SnapshotStateKt__DerivedStateKt.derivedStateOf(new ColorSchemeKt$animateSurfaceColors$$inlined$animateColor$1(transitionInstance, (byte) 25));
            gapComposer.updateRememberedValue(objRememberedValue5);
        }
        ColorScheme colorScheme4 = (ColorScheme) ((State) objRememberedValue5).getValue();
        gapComposer.startReplaceGroup(-917575040);
        Color colorM4 = Fragment$5$$ExternalSyntheticOutline0.m(gapComposer, false, colorScheme4.inverseOnSurface);
        boolean z8 = (i5 > 4 && gapComposer.changed(transitionInstance)) || (i3 & 6) == 4;
        Object objRememberedValue6 = gapComposer.rememberedValue();
        if (z8 || objRememberedValue6 == neverEqualPolicy) {
            objRememberedValue6 = SnapshotStateKt__DerivedStateKt.derivedStateOf(new ColorSchemeKt$animateSurfaceColors$$inlined$animateColor$1(transitionInstance, (byte) 26));
            gapComposer.updateRememberedValue(objRememberedValue6);
        }
        Transition.TransitionAnimationState transitionAnimationStateCreateTransitionAnimation2 = ArcSplineKt.createTransitionAnimation(transitionInstance, colorM3, colorM4, (FiniteAnimationSpec) function3.invoke(((State) objRememberedValue6).getValue(), gapComposer, Integer.valueOf(i6)), twoWayConverterImpl2, gapComposer, i7);
        ColorScheme colorScheme5 = (ColorScheme) parcelableSnapshotMutableState.getValue();
        gapComposer.startReplaceGroup(736165112);
        long j3 = colorScheme5.outline;
        gapComposer.end(false);
        ColorSpace colorSpaceM483getColorSpaceimpl3 = Color.m483getColorSpaceimpl(j3);
        boolean zChanged3 = gapComposer.changed(colorSpaceM483getColorSpaceimpl3);
        Object objRememberedValue7 = gapComposer.rememberedValue();
        if (zChanged3 || objRememberedValue7 == neverEqualPolicy) {
            objRememberedValue7 = IntIntPair$$ExternalSyntheticOutline0.m(colorVectorConverterKt$ColorToVector$1$1, new CallsKt$await$2$1((byte) 1, colorSpaceM483getColorSpaceimpl3), gapComposer);
        }
        TwoWayConverterImpl twoWayConverterImpl3 = (TwoWayConverterImpl) objRememberedValue7;
        if (transitionInstance.isSeeking()) {
            objM3 = IntIntPair$$ExternalSyntheticOutline0.m(gapComposer, 1666827533, false, tagPayloadReader);
        } else {
            gapComposer.startReplaceGroup(1666573488);
            boolean z9 = (i5 > 4 && gapComposer.changed(transitionInstance)) || (i3 & 6) == 4;
            objM3 = gapComposer.rememberedValue();
            if (z9 || objM3 == neverEqualPolicy) {
                Snapshot currentThreadSnapshot3 = Lock.getCurrentThreadSnapshot();
                Function1 readObserver3 = currentThreadSnapshot3 != null ? currentThreadSnapshot3.getReadObserver() : null;
                Snapshot snapshotMakeCurrentNonObservable3 = Lock.makeCurrentNonObservable(currentThreadSnapshot3);
                try {
                    Object currentState3 = tagPayloadReader.getCurrentState();
                    Lock.restoreNonObservable(currentThreadSnapshot3, snapshotMakeCurrentNonObservable3, readObserver3);
                    gapComposer.updateRememberedValue(currentState3);
                    objM3 = currentState3;
                } catch (Throwable th3) {
                    Lock.restoreNonObservable(currentThreadSnapshot3, snapshotMakeCurrentNonObservable3, readObserver3);
                    throw th3;
                }
            }
            gapComposer.end(false);
        }
        gapComposer.startReplaceGroup(736165112);
        Color colorM5 = Fragment$5$$ExternalSyntheticOutline0.m(gapComposer, false, ((ColorScheme) objM3).outline);
        boolean z10 = (i5 > 4 && gapComposer.changed(transitionInstance)) || (i3 & 6) == 4;
        Object objRememberedValue8 = gapComposer.rememberedValue();
        if (z10 || objRememberedValue8 == neverEqualPolicy) {
            objRememberedValue8 = SnapshotStateKt__DerivedStateKt.derivedStateOf(new ColorSchemeKt$animateSurfaceColors$$inlined$animateColor$1(transitionInstance, (byte) 27));
            gapComposer.updateRememberedValue(objRememberedValue8);
        }
        ColorScheme colorScheme6 = (ColorScheme) ((State) objRememberedValue8).getValue();
        gapComposer.startReplaceGroup(736165112);
        Color colorM6 = Fragment$5$$ExternalSyntheticOutline0.m(gapComposer, false, colorScheme6.outline);
        boolean z11 = (i5 > 4 && gapComposer.changed(transitionInstance)) || (i3 & 6) == 4;
        Object objRememberedValue9 = gapComposer.rememberedValue();
        if (z11 || objRememberedValue9 == neverEqualPolicy) {
            objRememberedValue9 = SnapshotStateKt__DerivedStateKt.derivedStateOf(new ColorSchemeKt$animateSurfaceColors$$inlined$animateColor$1(transitionInstance, (byte) 28));
            gapComposer.updateRememberedValue(objRememberedValue9);
        }
        Transition.TransitionAnimationState transitionAnimationStateCreateTransitionAnimation3 = ArcSplineKt.createTransitionAnimation(transitionInstance, colorM5, colorM6, (FiniteAnimationSpec) function3.invoke(((State) objRememberedValue9).getValue(), gapComposer, Integer.valueOf(i6)), twoWayConverterImpl3, gapComposer, i7);
        ColorScheme colorScheme7 = (ColorScheme) parcelableSnapshotMutableState.getValue();
        gapComposer.startReplaceGroup(598084837);
        long j4 = colorScheme7.outlineVariant;
        gapComposer.end(false);
        ColorSpace colorSpaceM483getColorSpaceimpl4 = Color.m483getColorSpaceimpl(j4);
        boolean zChanged4 = gapComposer.changed(colorSpaceM483getColorSpaceimpl4);
        Object objRememberedValue10 = gapComposer.rememberedValue();
        if (zChanged4 || objRememberedValue10 == neverEqualPolicy) {
            objRememberedValue10 = IntIntPair$$ExternalSyntheticOutline0.m(colorVectorConverterKt$ColorToVector$1$1, new CallsKt$await$2$1((byte) 1, colorSpaceM483getColorSpaceimpl4), gapComposer);
        }
        TwoWayConverterImpl twoWayConverterImpl4 = (TwoWayConverterImpl) objRememberedValue10;
        if (transitionInstance.isSeeking()) {
            objM4 = IntIntPair$$ExternalSyntheticOutline0.m(gapComposer, 1666827533, false, tagPayloadReader);
        } else {
            gapComposer.startReplaceGroup(1666573488);
            boolean z12 = (i5 > 4 && gapComposer.changed(transitionInstance)) || (i3 & 6) == 4;
            objM4 = gapComposer.rememberedValue();
            if (z12 || objM4 == neverEqualPolicy) {
                Snapshot currentThreadSnapshot4 = Lock.getCurrentThreadSnapshot();
                Function1 readObserver4 = currentThreadSnapshot4 != null ? currentThreadSnapshot4.getReadObserver() : null;
                Snapshot snapshotMakeCurrentNonObservable4 = Lock.makeCurrentNonObservable(currentThreadSnapshot4);
                try {
                    Object currentState4 = tagPayloadReader.getCurrentState();
                    Lock.restoreNonObservable(currentThreadSnapshot4, snapshotMakeCurrentNonObservable4, readObserver4);
                    gapComposer.updateRememberedValue(currentState4);
                    objM4 = currentState4;
                    z2 = false;
                } catch (Throwable th4) {
                    Lock.restoreNonObservable(currentThreadSnapshot4, snapshotMakeCurrentNonObservable4, readObserver4);
                    throw th4;
                }
            }
            gapComposer.end(z2);
        }
        gapComposer.startReplaceGroup(598084837);
        Color colorM7 = Fragment$5$$ExternalSyntheticOutline0.m(gapComposer, z2, ((ColorScheme) objM4).outlineVariant);
        boolean z13 = (i5 > 4 && gapComposer.changed(transitionInstance)) || (i3 & 6) == 4;
        Object objRememberedValue11 = gapComposer.rememberedValue();
        if (z13 || objRememberedValue11 == neverEqualPolicy) {
            objRememberedValue11 = SnapshotStateKt__DerivedStateKt.derivedStateOf(new ColorSchemeKt$animateSurfaceColors$$inlined$animateColor$1(transitionInstance, (byte) 29));
            gapComposer.updateRememberedValue(objRememberedValue11);
        }
        ColorScheme colorScheme8 = (ColorScheme) ((State) objRememberedValue11).getValue();
        gapComposer.startReplaceGroup(598084837);
        Color colorM8 = Fragment$5$$ExternalSyntheticOutline0.m(gapComposer, false, colorScheme8.outlineVariant);
        boolean z14 = (i5 > 4 && gapComposer.changed(transitionInstance)) || (i3 & 6) == 4;
        Object objRememberedValue12 = gapComposer.rememberedValue();
        if (z14 || objRememberedValue12 == neverEqualPolicy) {
            final byte b2 = 0;
            objRememberedValue12 = SnapshotStateKt__DerivedStateKt.derivedStateOf(new Function0() { // from class: com.materialkolor.ktx.ColorSchemeKt$animateUtilityColors$$inlined$animateColor$8
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    byte b3 = b2;
                    TransitionInstance transitionInstance2 = transitionInstance;
                    switch (b3) {
                        case 0:
                            return transitionInstance2.getSegment();
                        default:
                            return transitionInstance2.targetState$delegate.getValue();
                    }
                }
            });
            gapComposer.updateRememberedValue(objRememberedValue12);
        }
        Transition.TransitionAnimationState transitionAnimationStateCreateTransitionAnimation4 = ArcSplineKt.createTransitionAnimation(transitionInstance, colorM7, colorM8, (FiniteAnimationSpec) function3.invoke(((State) objRememberedValue12).getValue(), gapComposer, Integer.valueOf(i6)), twoWayConverterImpl4, gapComposer, i7);
        ColorScheme colorScheme9 = (ColorScheme) parcelableSnapshotMutableState.getValue();
        gapComposer.startReplaceGroup(-1333650948);
        long j5 = colorScheme9.scrim;
        gapComposer.end(false);
        ColorSpace colorSpaceM483getColorSpaceimpl5 = Color.m483getColorSpaceimpl(j5);
        boolean zChanged5 = gapComposer.changed(colorSpaceM483getColorSpaceimpl5);
        Object objRememberedValue13 = gapComposer.rememberedValue();
        if (zChanged5 || objRememberedValue13 == neverEqualPolicy) {
            objRememberedValue13 = IntIntPair$$ExternalSyntheticOutline0.m(colorVectorConverterKt$ColorToVector$1$1, new CallsKt$await$2$1((byte) 1, colorSpaceM483getColorSpaceimpl5), gapComposer);
        }
        TwoWayConverterImpl twoWayConverterImpl5 = (TwoWayConverterImpl) objRememberedValue13;
        if (transitionInstance.isSeeking()) {
            z = false;
            objM5 = IntIntPair$$ExternalSyntheticOutline0.m(gapComposer, 1666827533, false, tagPayloadReader);
        } else {
            gapComposer.startReplaceGroup(1666573488);
            boolean z15 = (i5 > 4 && gapComposer.changed(transitionInstance)) || (i3 & 6) == 4;
            objM5 = gapComposer.rememberedValue();
            if (z15 || objM5 == neverEqualPolicy) {
                Snapshot currentThreadSnapshot5 = Lock.getCurrentThreadSnapshot();
                Function1 readObserver5 = currentThreadSnapshot5 != null ? currentThreadSnapshot5.getReadObserver() : null;
                Snapshot snapshotMakeCurrentNonObservable5 = Lock.makeCurrentNonObservable(currentThreadSnapshot5);
                try {
                    Object currentState5 = tagPayloadReader.getCurrentState();
                    Lock.restoreNonObservable(currentThreadSnapshot5, snapshotMakeCurrentNonObservable5, readObserver5);
                    gapComposer.updateRememberedValue(currentState5);
                    objM5 = currentState5;
                } catch (Throwable th5) {
                    Lock.restoreNonObservable(currentThreadSnapshot5, snapshotMakeCurrentNonObservable5, readObserver5);
                    throw th5;
                }
            }
            z = false;
            gapComposer.end(false);
        }
        gapComposer.startReplaceGroup(-1333650948);
        Color colorM9 = Fragment$5$$ExternalSyntheticOutline0.m(gapComposer, z, ((ColorScheme) objM5).scrim);
        boolean z16 = (i5 > 4 && gapComposer.changed(transitionInstance)) || (i3 & 6) == 4;
        Object objRememberedValue14 = gapComposer.rememberedValue();
        if (z16 || objRememberedValue14 == neverEqualPolicy) {
            b = 1;
            objDerivedStateOf = SnapshotStateKt__DerivedStateKt.derivedStateOf(new Function0() { // from class: com.materialkolor.ktx.ColorSchemeKt$animateUtilityColors$$inlined$animateColor$8
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    byte b3 = b;
                    TransitionInstance transitionInstance2 = transitionInstance;
                    switch (b3) {
                        case 0:
                            return transitionInstance2.getSegment();
                        default:
                            return transitionInstance2.targetState$delegate.getValue();
                    }
                }
            });
            gapComposer.updateRememberedValue(objDerivedStateOf);
        } else {
            objDerivedStateOf = objRememberedValue14;
            b = 1;
        }
        ColorScheme colorScheme10 = (ColorScheme) ((State) objDerivedStateOf).getValue();
        gapComposer.startReplaceGroup(-1333650948);
        Color colorM10 = Fragment$5$$ExternalSyntheticOutline0.m(gapComposer, false, colorScheme10.scrim);
        if ((i5 <= 4 || !gapComposer.changed(transitionInstance)) && (i3 & 6) != 4) {
            b = 0;
        }
        Object objRememberedValue15 = gapComposer.rememberedValue();
        if (b != 0 || objRememberedValue15 == neverEqualPolicy) {
            objRememberedValue15 = SnapshotStateKt__DerivedStateKt.derivedStateOf(new ColorSchemeKt$animateSurfaceColors$$inlined$animateColor$1(transitionInstance, (byte) 22));
            gapComposer.updateRememberedValue(objRememberedValue15);
        }
        Transition.TransitionAnimationState transitionAnimationStateCreateTransitionAnimation5 = ArcSplineKt.createTransitionAnimation(transitionInstance, colorM9, colorM10, (FiniteAnimationSpec) function3.invoke(((State) objRememberedValue15).getValue(), gapComposer, Integer.valueOf(i6)), twoWayConverterImpl5, gapComposer, i7);
        Color color = (Color) transitionAnimationStateCreateTransitionAnimation.getValue();
        long j6 = color.value;
        Color color2 = (Color) transitionAnimationStateCreateTransitionAnimation2.getValue();
        long j7 = color2.value;
        Color color3 = (Color) transitionAnimationStateCreateTransitionAnimation3.getValue();
        long j8 = color3.value;
        Color color4 = (Color) transitionAnimationStateCreateTransitionAnimation4.getValue();
        long j9 = color4.value;
        Color color5 = (Color) transitionAnimationStateCreateTransitionAnimation5.getValue();
        long j10 = color5.value;
        return CollectionsKt__IterablesKt.listOf((Object[]) new Color[]{color, color2, color3, color4, color5});
    }
}
