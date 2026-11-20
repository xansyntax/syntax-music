package androidx.compose.material3;

import android.view.KeyEvent;
import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.collection.IntListKt;
import androidx.collection.MutableIntList;
import androidx.compose.animation.CrossfadeKt;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.IndicationKt;
import androidx.compose.foundation.MutatePriority;
import androidx.compose.foundation.ScrollState$$ExternalSyntheticLambda3;
import androidx.compose.foundation.interaction.MutableInteractionSourceImpl;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnMeasurePolicy;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.OffsetKt$$ExternalSyntheticLambda0;
import androidx.compose.foundation.layout.PaddingValuesImpl;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowMeasurePolicy;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.shape.DpCornerSize;
import androidx.compose.foundation.shape.RoundedCornerShape;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material3.internal.Icons$Filled;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.GapComposer$$ExternalSyntheticLambda0;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.NeverEqualPolicy;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImpl;
import androidx.compose.runtime.SnapshotStateKt__DerivedStateKt;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater$$ExternalSyntheticLambda0;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.runtime.internal.Expect_jvmKt;
import androidx.compose.runtime.internal.PersistentCompositionLocalHashMap;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.runtime.saveable.SaverKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.BiasAlignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.ZIndexModifierKt;
import androidx.compose.ui.ZIndexNode$$ExternalSyntheticLambda0;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.focus.FocusOwner;
import androidx.compose.ui.focus.FocusOwnerImpl;
import androidx.compose.ui.focus.FocusRequester;
import androidx.compose.ui.focus.FocusTraversalKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.colorspace.ColorSpaces;
import androidx.compose.ui.graphics.colorspace.Rgb;
import androidx.compose.ui.input.InputMode;
import androidx.compose.ui.input.InputModeManager;
import androidx.compose.ui.input.InputModeManagerImpl;
import androidx.compose.ui.input.key.Key;
import androidx.compose.ui.layout.HorizontalAlignmentLine;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.layout.RulerKt;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.Ref;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.LineHeightStyle;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.core.provider.CallbackWrapper;
import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import com.metrolist.music.App$Companion$forgetAccount$2;
import com.metrolist.music.MainActivity$$ExternalSyntheticLambda9;
import com.metrolist.music.lyrics.LyricsUtils$$ExternalSyntheticLambda0;
import com.metrolist.music.utils.SyncUtils;
import com.metrolist.music.utils.SyncUtils$createPlaylist$1;
import com.yalantis.ucrop.R;
import com.yalantis.ucrop.view.CropImageView;
import io.ktor.http.CookieKt$$ExternalSyntheticLambda3;
import io.ktor.sse.ServerSentEventKt;
import io.ktor.utils.io.ByteChannelKt;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.EmptyMap;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.math.MathKt;
import kotlin.uuid.UuidKt;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.CoroutineScope;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class TimePickerKt {
    public static final MutableIntList ExtraHours;
    public static final MutableIntList Hours;
    public static final MutableIntList Minutes = IntListKt.intListOf(0, 5, 10, 15, 20, 25, 30, 35, 40, 45, 50, 55);

    static {
        MutableIntList mutableIntListIntListOf = IntListKt.intListOf(12, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11);
        Hours = mutableIntListIntListOf;
        MutableIntList mutableIntList = new MutableIntList(mutableIntListIntListOf._size);
        int[] iArr = mutableIntListIntListOf.content;
        int i = mutableIntListIntListOf._size;
        for (int i2 = 0; i2 < i; i2++) {
            mutableIntList.add((iArr[i2] % 12) + 12);
        }
        ExtraHours = mutableIntList;
    }

    public static final void CircularLayout(Modifier modifier, final float f, ComposableLambdaImpl composableLambdaImpl, Composer composer, int i) {
        GapComposer gapComposer = (GapComposer) composer;
        gapComposer.startRestartGroup(-1041042571);
        int i2 = (gapComposer.changed(modifier) ? 4 : 2) | i | (gapComposer.changed(f) ? 32 : 16);
        if (gapComposer.shouldExecute(i2 & 1, (i2 & 147) != 146)) {
            boolean z = (i2 & 112) == 32;
            Object objRememberedValue = gapComposer.rememberedValue();
            if (z || objRememberedValue == Composer.Companion.Empty) {
                objRememberedValue = new MeasurePolicy() { // from class: androidx.compose.material3.TimePickerKt$CircularLayout$1$1
                    @Override // androidx.compose.ui.layout.MeasurePolicy
                    /* JADX INFO: renamed from: measure-3p2s80s */
                    public final MeasureResult mo13measure3p2s80s(MeasureScope measureScope, List list, final long j) {
                        LayoutId layoutId;
                        LayoutId layoutId2;
                        Object obj;
                        Object obj2;
                        final float fM783getMaxHeightimpl = Constraints.m783getMaxHeightimpl(j) * f;
                        int i3 = 0;
                        long jM777copyZbe2FdA$default = Constraints.m777copyZbe2FdA$default(0, 0, 0, 0, 10, j);
                        ArrayList arrayList = new ArrayList(list.size());
                        int size = list.size();
                        int i4 = 0;
                        while (true) {
                            layoutId = LayoutId.InnerCircle;
                            layoutId2 = LayoutId.Selector;
                            if (i4 >= size) {
                                break;
                            }
                            Object obj3 = list.get(i4);
                            Measurable measurable = (Measurable) obj3;
                            if (RulerKt.getLayoutId(measurable) != layoutId2 && RulerKt.getLayoutId(measurable) != layoutId) {
                                arrayList.add(obj3);
                            }
                            i4++;
                        }
                        final ArrayList arrayList2 = new ArrayList(arrayList.size());
                        int size2 = arrayList.size();
                        for (int i5 = 0; i5 < size2; i5++) {
                            arrayList2.add(((Measurable) arrayList.get(i5)).mo598measureBRTryo0(jM777copyZbe2FdA$default));
                        }
                        int size3 = list.size();
                        int i6 = 0;
                        while (true) {
                            if (i6 >= size3) {
                                obj = null;
                                break;
                            }
                            obj = list.get(i6);
                            if (RulerKt.getLayoutId((Measurable) obj) == layoutId2) {
                                break;
                            }
                            i6++;
                        }
                        Measurable measurable2 = (Measurable) obj;
                        int size4 = list.size();
                        while (true) {
                            if (i3 >= size4) {
                                obj2 = null;
                                break;
                            }
                            obj2 = list.get(i3);
                            if (RulerKt.getLayoutId((Measurable) obj2) == layoutId) {
                                break;
                            }
                            i3++;
                        }
                        Measurable measurable3 = (Measurable) obj2;
                        final float size5 = 6.2831855f / arrayList2.size();
                        Placeable placeableMo598measureBRTryo0 = measurable2 != null ? measurable2.mo598measureBRTryo0(jM777copyZbe2FdA$default) : null;
                        final Placeable placeableMo598measureBRTryo1 = measurable3 != null ? measurable3.mo598measureBRTryo0(jM777copyZbe2FdA$default) : null;
                        final Placeable placeable = placeableMo598measureBRTryo0;
                        return measureScope.layout(Constraints.m786getMinWidthimpl(j), Constraints.m785getMinHeightimpl(j), EmptyMap.INSTANCE, new Function1() { // from class: androidx.compose.material3.TimePickerKt$CircularLayout$1$1$$ExternalSyntheticLambda0
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj4) {
                                long j2;
                                Placeable.PlacementScope placementScope = (Placeable.PlacementScope) obj4;
                                int i7 = 0;
                                Placeable placeable2 = placeable;
                                if (placeable2 != null) {
                                    placementScope.place(placeable2, 0, 0, CropImageView.DEFAULT_ASPECT_RATIO);
                                }
                                ArrayList arrayList3 = arrayList2;
                                int size6 = arrayList3.size();
                                while (true) {
                                    j2 = j;
                                    if (i7 >= size6) {
                                        break;
                                    }
                                    Placeable placeable3 = (Placeable) arrayList3.get(i7);
                                    int iM784getMaxWidthimpl = (Constraints.m784getMaxWidthimpl(j2) / 2) - (placeable3.width / 2);
                                    int iM783getMaxHeightimpl = (Constraints.m783getMaxHeightimpl(j2) / 2) - (placeable3.height / 2);
                                    double d = fM783getMaxHeightimpl;
                                    double d2 = ((double) (size5 * i7)) - 1.5707963267948966d;
                                    placementScope.place(placeable3, MathKt.roundToInt((Math.cos(d2) * d) + ((double) iM784getMaxWidthimpl)), MathKt.roundToInt((Math.sin(d2) * d) + ((double) iM783getMaxHeightimpl)), CropImageView.DEFAULT_ASPECT_RATIO);
                                    i7++;
                                    arrayList3 = arrayList3;
                                }
                                Placeable placeable4 = placeableMo598measureBRTryo1;
                                if (placeable4 != null) {
                                    placementScope.place(placeable4, (Constraints.m786getMinWidthimpl(j2) - placeable4.width) / 2, (Constraints.m785getMinHeightimpl(j2) - placeable4.height) / 2, CropImageView.DEFAULT_ASPECT_RATIO);
                                }
                                return Unit.INSTANCE;
                            }
                        });
                    }
                };
                gapComposer.updateRememberedValue(objRememberedValue);
            }
            MeasurePolicy measurePolicy = (MeasurePolicy) objRememberedValue;
            int iHashCode = Long.hashCode(gapComposer.compositeKeyHashCode);
            PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope = gapComposer.currentCompositionLocalScope();
            Modifier modifierMaterializeModifier = ZIndexModifierKt.materializeModifier(gapComposer, modifier);
            ComposeUiNode.Companion.getClass();
            gapComposer.startReusableNode();
            if (gapComposer.inserting) {
                gapComposer.createNode(LayoutNode.Constructor);
            } else {
                gapComposer.useNode();
            }
            Stack.m390setimpl(gapComposer, measurePolicy, ComposeUiNode.Companion.SetMeasurePolicy);
            Stack.m390setimpl(gapComposer, persistentCompositionLocalHashMapCurrentCompositionLocalScope, ComposeUiNode.Companion.SetResolvedCompositionLocals);
            Stack.m390setimpl(gapComposer, Integer.valueOf(iHashCode), ComposeUiNode.Companion.SetCompositeKeyHash);
            Stack.m389reconcileimpl(gapComposer);
            Stack.m390setimpl(gapComposer, modifierMaterializeModifier, ComposeUiNode.Companion.SetModifier);
            Fragment$5$$ExternalSyntheticOutline0.m(6, composableLambdaImpl, gapComposer, true);
        } else {
            gapComposer.skipToGroupEnd();
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new TimePickerKt$$ExternalSyntheticLambda23(modifier, f, composableLambdaImpl, i, (byte) 0);
        }
    }

    public static final void ClockDisplayNumbers(TimePickerState timePickerState, TimePickerColors timePickerColors, Composer composer, int i) {
        int i2;
        GapComposer gapComposer = (GapComposer) composer;
        gapComposer.startRestartGroup(-1980690316);
        if ((i & 6) == 0) {
            i2 = ((i & 8) == 0 ? gapComposer.changed(timePickerState) : gapComposer.changedInstance(timePickerState) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= gapComposer.changed(timePickerColors) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= gapComposer.changed((Object) null) ? 256 : 128;
        }
        boolean z = true;
        if (gapComposer.shouldExecute(i2 & 1, (i2 & 147) != 146)) {
            float f = (ScrimKt.defaultTimePickerLayoutType(gapComposer) == 1 && timePickerState.is24hour()) ? 132.0f : 100.0f;
            if ((i2 & 14) != 4 && ((i2 & 8) == 0 || !gapComposer.changedInstance(timePickerState))) {
                z = false;
            }
            Object objRememberedValue = gapComposer.rememberedValue();
            if (z || objRememberedValue == Composer.Companion.Empty) {
                objRememberedValue = new TimePickerKt$$ExternalSyntheticLambda12(timePickerState, (byte) 0);
                gapComposer.updateRememberedValue(objRememberedValue);
            }
            Stack.CompositionLocalProvider(new ProvidedValue[]{TextKt.LocalTextStyle.defaultProvidedValue$runtime(CardKt.getValue(3, gapComposer)), CompositionLocalsKt.LocalLayoutDirection.defaultProvidedValue$runtime(LayoutDirection.Ltr)}, Expect_jvmKt.rememberComposableLambda(-1100528716, new MainActivity$$ExternalSyntheticLambda9(f, timePickerState, timePickerColors, (Function0) objRememberedValue), gapComposer), gapComposer, 56);
        } else {
            gapComposer.skipToGroupEnd();
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new TimePickerKt$$ExternalSyntheticLambda7(timePickerState, timePickerColors, i, (byte) 2);
        }
    }

    public static final void ClockFace(int i, AnalogTimePickerState analogTimePickerState, TimePickerColors timePickerColors, Composer composer, Modifier modifier, boolean z) {
        int i2;
        GapComposer gapComposer;
        GapComposer gapComposer2 = (GapComposer) composer;
        gapComposer2.startRestartGroup(-478841003);
        if ((i & 6) == 0) {
            i2 = (gapComposer2.changed(modifier) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= gapComposer2.changedInstance(analogTimePickerState) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= gapComposer2.changed(timePickerColors) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= gapComposer2.changed(z) ? 2048 : 1024;
        }
        if (gapComposer2.shouldExecute(i2 & 1, (i2 & 1171) != 1170)) {
            FocusOwner focusOwner = (FocusOwner) gapComposer2.consume(CompositionLocalsKt.LocalFocusManager);
            Object objRememberedValue = gapComposer2.rememberedValue();
            NeverEqualPolicy neverEqualPolicy = Composer.Companion.Empty;
            if (objRememberedValue == neverEqualPolicy) {
                objRememberedValue = new FocusRequester();
                gapComposer2.updateRememberedValue(objRememberedValue);
            }
            FocusRequester focusRequester = (FocusRequester) objRememberedValue;
            Object objRememberedValue2 = gapComposer2.rememberedValue();
            if (objRememberedValue2 == neverEqualPolicy) {
                objRememberedValue2 = new FocusRequester();
                gapComposer2.updateRememberedValue(objRememberedValue2);
            }
            FocusRequester focusRequester2 = (FocusRequester) objRememberedValue2;
            Object objRememberedValue3 = gapComposer2.rememberedValue();
            if (objRememberedValue3 == neverEqualPolicy) {
                objRememberedValue3 = new FocusRequester();
                gapComposer2.updateRememberedValue(objRememberedValue3);
            }
            FocusRequester focusRequester3 = (FocusRequester) objRememberedValue3;
            Object objRememberedValue4 = gapComposer2.rememberedValue();
            if (objRememberedValue4 == neverEqualPolicy) {
                objRememberedValue4 = new FocusRequester();
                gapComposer2.updateRememberedValue(objRememberedValue4);
            }
            FocusRequester focusRequester4 = (FocusRequester) objRememberedValue4;
            gapComposer = gapComposer2;
            CrossfadeKt.Crossfade(analogTimePickerState.state.mo241getSelectionyecRtBI() == 1 ? Minutes : Hours, ImageKt.focusGroup(ClipKt.drawWithContent(ImageKt.m39backgroundbw27NRU(modifier, timePickerColors.clockDialColor, RoundedCornerShapeKt.CircleShape).then(new ClockDialModifier(analogTimePickerState, z, analogTimePickerState.state.mo241getSelectionyecRtBI(), CardKt.m272valueyDoVZcs(0, gapComposer2))), new ZIndexNode$$ExternalSyntheticLambda0((Object) analogTimePickerState, (Object) timePickerColors, (byte) 16))), CardKt.m272valueyDoVZcs(3, gapComposer2), null, Expect_jvmKt.rememberComposableLambda(747010833, new TimePickerKt$$ExternalSyntheticLambda8(analogTimePickerState, timePickerColors, focusRequester, focusRequester2, z, focusOwner, focusRequester4, focusRequester3), gapComposer2), gapComposer, 24576, 8);
        } else {
            gapComposer = gapComposer2;
            gapComposer.skipToGroupEnd();
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new TimePickerKt$$ExternalSyntheticLambda4(modifier, analogTimePickerState, timePickerColors, z, i);
        }
    }

    public static final void ClockText(final Modifier modifier, final AnalogTimePickerState analogTimePickerState, final int i, boolean z, final FocusOwner focusOwner, final boolean z2, Composer composer, final int i2) {
        boolean z3;
        GapComposer gapComposer;
        Density density;
        boolean z4;
        MutableState mutableState;
        MutableState mutableState2;
        Object obj;
        final MutableInteractionSourceImpl mutableInteractionSourceImpl;
        GapComposer gapComposer2 = (GapComposer) composer;
        gapComposer2.startRestartGroup(282481562);
        int i3 = i2 | (gapComposer2.changed(modifier) ? 4 : 2) | (gapComposer2.changedInstance(analogTimePickerState) ? 32 : 16) | (gapComposer2.changed(i) ? 256 : 128) | (gapComposer2.changed(z) ? 2048 : 1024) | (gapComposer2.changedInstance(focusOwner) ? 16384 : 8192) | (gapComposer2.changed(z2) ? 131072 : 65536);
        if (gapComposer2.shouldExecute(i3 & 1, (74899 & i3) != 74898)) {
            InputModeManager inputModeManager = (InputModeManager) gapComposer2.consume(CompositionLocalsKt.LocalInputModeManager);
            TextStyle value = CardKt.getValue(0, gapComposer2);
            Density density2 = (Density) gapComposer2.consume(CompositionLocalsKt.LocalDensity);
            float fMo81toPx0680j_4 = density2.mo81toPx0680j_4(74.0f);
            Object objRememberedValue = gapComposer2.rememberedValue();
            NeverEqualPolicy neverEqualPolicy = Composer.Companion.Empty;
            if (objRememberedValue == neverEqualPolicy) {
                objRememberedValue = Stack.mutableStateOf$default(new Offset(0L));
                gapComposer2.updateRememberedValue(objRememberedValue);
            }
            MutableState mutableState3 = (MutableState) objRememberedValue;
            Object objRememberedValue2 = gapComposer2.rememberedValue();
            if (objRememberedValue2 == neverEqualPolicy) {
                objRememberedValue2 = Stack.mutableStateOf$default(new IntOffset(0L));
                gapComposer2.updateRememberedValue(objRememberedValue2);
            }
            MutableState mutableState4 = (MutableState) objRememberedValue2;
            Object objRememberedValue3 = gapComposer2.rememberedValue();
            if (objRememberedValue3 == neverEqualPolicy) {
                objRememberedValue3 = Stack.mutableStateOf$default(Rect.Zero);
                gapComposer2.updateRememberedValue(objRememberedValue3);
            }
            MutableState mutableState5 = (MutableState) objRememberedValue3;
            Object objRememberedValue4 = gapComposer2.rememberedValue();
            if (objRememberedValue4 == neverEqualPolicy) {
                objRememberedValue4 = IntIntPair$$ExternalSyntheticOutline0.m(gapComposer2);
            }
            MutableInteractionSourceImpl mutableInteractionSourceImpl2 = (MutableInteractionSourceImpl) objRememberedValue4;
            Object objRememberedValue5 = gapComposer2.rememberedValue();
            if (objRememberedValue5 == neverEqualPolicy) {
                objRememberedValue5 = Stack.createCompositionCoroutineScope(gapComposer2);
                gapComposer2.updateRememberedValue(objRememberedValue5);
            }
            final CoroutineScope coroutineScope = (CoroutineScope) objRememberedValue5;
            TimePickerState timePickerState = analogTimePickerState.state;
            int i4 = i3 & 896;
            String strM358numberContentDescriptiondSwYdS4 = m358numberContentDescriptiondSwYdS4(timePickerState.mo241getSelectionyecRtBI(), timePickerState.is24hour(), i, gapComposer2);
            String localString$default = CalendarLocale_jvmAndAndroidKt.toLocalString$default(i, 15);
            int iMo241getSelectionyecRtBI = timePickerState.mo241getSelectionyecRtBI();
            boolean zChanged = gapComposer2.changed(timePickerState.getHour()) | gapComposer2.changed(iMo241getSelectionyecRtBI) | gapComposer2.changed(timePickerState.getMinute()) | gapComposer2.changed(timePickerState.is24hour()) | (i4 == 256);
            Object objRememberedValue6 = gapComposer2.rememberedValue();
            if (zChanged || objRememberedValue6 == neverEqualPolicy) {
                if (timePickerState.mo241getSelectionyecRtBI() != 0) {
                    density = density2;
                    z4 = i == ((int) (((float) Math.rint((double) (((float) timePickerState.getMinute()) / 5.0f))) * 5.0f)) % 60;
                } else if (!timePickerState.is24hour() ? i == getHourForDisplay(analogTimePickerState) : i == timePickerState.getHour()) {
                    density = density2;
                } else {
                    density = density2;
                }
                objRememberedValue6 = Boolean.valueOf(z4);
                gapComposer2.updateRememberedValue(objRememberedValue6);
            } else {
                density = density2;
            }
            boolean zBooleanValue = ((Boolean) objRememberedValue6).booleanValue();
            boolean zChanged2 = gapComposer2.changed(analogTimePickerState);
            Object objRememberedValue7 = gapComposer2.rememberedValue();
            if (zChanged2 || objRememberedValue7 == neverEqualPolicy) {
                objRememberedValue7 = SnapshotStateKt__DerivedStateKt.derivedStateOf(new GapComposer$$ExternalSyntheticLambda0(analogTimePickerState, density, mutableState5, (byte) 6));
                gapComposer2.updateRememberedValue(objRememberedValue7);
            }
            State state = (State) objRememberedValue7;
            boolean zChangedInstance = gapComposer2.changedInstance(coroutineScope) | gapComposer2.changedInstance(analogTimePickerState) | gapComposer2.changed(fMo81toPx0680j_4);
            Object objRememberedValue8 = gapComposer2.rememberedValue();
            if (zChangedInstance || objRememberedValue8 == neverEqualPolicy) {
                mutableState = mutableState4;
                mutableState2 = mutableState3;
                TimePickerKt$$ExternalSyntheticLambda45 timePickerKt$$ExternalSyntheticLambda45 = new TimePickerKt$$ExternalSyntheticLambda45(coroutineScope, analogTimePickerState, fMo81toPx0680j_4, mutableState2, mutableState);
                gapComposer2.updateRememberedValue(timePickerKt$$ExternalSyntheticLambda45);
                objRememberedValue8 = timePickerKt$$ExternalSyntheticLambda45;
            } else {
                mutableState = mutableState4;
                mutableState2 = mutableState3;
            }
            final Function1 function1 = (Function1) objRememberedValue8;
            if (zBooleanValue && z2) {
                gapComposer2.startReplaceGroup(1569432824);
                Boolean bool = (Boolean) analogTimePickerState.isDialFocusable$delegate.getValue();
                bool.getClass();
                boolean zChangedInstance2 = gapComposer2.changedInstance(analogTimePickerState);
                Object objRememberedValue9 = gapComposer2.rememberedValue();
                if (zChangedInstance2 || objRememberedValue9 == neverEqualPolicy) {
                    objRememberedValue9 = new SyncUtils.AnonymousClass3(analogTimePickerState, null, (byte) 2);
                    gapComposer2.updateRememberedValue(objRememberedValue9);
                }
                Stack.LaunchedEffect(gapComposer2, bool, (Function2) objRememberedValue9);
                gapComposer2.end(false);
            } else {
                state = state;
                i3 = r28;
                gapComposer2.startReplaceGroup(1569601960);
                gapComposer2.end(false);
            }
            BiasAlignment biasAlignment = Alignment.Companion.Center;
            Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
            Modifier modifierThen = modifier.then(zBooleanValue ? FocusTraversalKt.focusRequester(companion, analogTimePickerState.dialFocusRequester) : companion);
            Object objRememberedValue10 = gapComposer2.rememberedValue();
            if (objRememberedValue10 == neverEqualPolicy) {
                objRememberedValue10 = new TimePickerKt$$ExternalSyntheticLambda46(mutableState, mutableState5, mutableState2, (byte) 0);
                gapComposer2.updateRememberedValue(objRememberedValue10);
            }
            Modifier modifierOnGloballyPositioned = RulerKt.onGloballyPositioned(modifierThen, (Function1) objRememberedValue10);
            HorizontalAlignmentLine horizontalAlignmentLine = InteractiveComponentSizeKt.MinimumInteractiveTopAlignmentLine;
            Modifier modifierM151size3ABfNKs = SizeKt.m151size3ABfNKs(modifierOnGloballyPositioned.then(MinimumInteractiveModifier.INSTANCE), 48.0f);
            boolean zChangedInstance3 = gapComposer2.changedInstance(focusOwner) | gapComposer2.changedInstance(analogTimePickerState) | gapComposer2.changed(function1) | gapComposer2.changedInstance(coroutineScope);
            Object objRememberedValue11 = gapComposer2.rememberedValue();
            if (zChangedInstance3 || objRememberedValue11 == neverEqualPolicy) {
                final MutableState mutableState6 = mutableState2;
                mutableInteractionSourceImpl = mutableInteractionSourceImpl2;
                obj = new Function1() { // from class: androidx.compose.material3.TimePickerKt$ClockText$3$1
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        KeyEvent keyEvent = ((androidx.compose.ui.input.key.KeyEvent) obj2).nativeKeyEvent;
                        if (Key.m581getTypeZmokQxo(keyEvent) == 2) {
                            boolean zM579equalsimpl0 = Key.m579equalsimpl0(((long) keyEvent.getKeyCode()) << 32, 85899345920L);
                            FocusOwner focusOwner2 = focusOwner;
                            if (zM579equalsimpl0 || Key.m579equalsimpl0(((long) keyEvent.getKeyCode()) << 32, -4294967304589934592L) || Key.m579equalsimpl0(((long) keyEvent.getKeyCode()) << 32, 94489280512L) || Key.m579equalsimpl0(((long) keyEvent.getKeyCode()) << 32, -4294967313179869184L)) {
                                ((FocusOwnerImpl) focusOwner2).m412moveFocusaToIllA(1, true);
                                return Boolean.TRUE;
                            }
                            if (Key.m579equalsimpl0(((long) keyEvent.getKeyCode()) << 32, 81604378624L) || Key.m579equalsimpl0(((long) keyEvent.getKeyCode()) << 32, -4294967300294967296L) || Key.m579equalsimpl0(((long) keyEvent.getKeyCode()) << 32, 90194313216L) || Key.m579equalsimpl0(((long) keyEvent.getKeyCode()) << 32, -4294967308884901888L)) {
                                ((FocusOwnerImpl) focusOwner2).m412moveFocusaToIllA(2, true);
                                return Boolean.TRUE;
                            }
                            if (Key.m579equalsimpl0(((long) keyEvent.getKeyCode()) << 32, 261993005056L)) {
                                boolean zIsShiftPressed = keyEvent.isShiftPressed();
                                AnalogTimePickerState analogTimePickerState2 = analogTimePickerState;
                                if (zIsShiftPressed) {
                                    analogTimePickerState2.setDialFocusable(false);
                                    if (analogTimePickerState2.state.mo241getSelectionyecRtBI() == 0) {
                                        FocusRequester.m415requestFocus3ESFkO8$default(analogTimePickerState2.hourNodeFocusRequester);
                                    } else {
                                        FocusRequester.m415requestFocus3ESFkO8$default(analogTimePickerState2.minuteNodeFocusRequester);
                                    }
                                } else {
                                    TimePickerState timePickerState2 = analogTimePickerState2.state;
                                    FocusRequester focusRequester = analogTimePickerState2.minuteNodeFocusRequester;
                                    if (timePickerState2.mo241getSelectionyecRtBI() == 0) {
                                        FocusRequester.m415requestFocus3ESFkO8$default(focusRequester);
                                    } else if (analogTimePickerState2.state.is24hour()) {
                                        FocusRequester.m415requestFocus3ESFkO8$default(focusRequester);
                                        ((FocusOwnerImpl) focusOwner2).m412moveFocusaToIllA(1, true);
                                    } else {
                                        FocusRequester.m415requestFocus3ESFkO8$default(analogTimePickerState2.amPmNodeFocusRequester);
                                    }
                                }
                                return Boolean.TRUE;
                            }
                        }
                        if (Key.m581getTypeZmokQxo(keyEvent) == 1) {
                            long keyCode = ((long) keyEvent.getKeyCode()) << 32;
                            if (Key.m579equalsimpl0(keyCode, 98784247808L) || Key.m579equalsimpl0(keyCode, 283467841536L) || Key.m579equalsimpl0(keyCode, 687194767360L) || Key.m579equalsimpl0(keyCode, 266287972352L)) {
                                function1.invoke(Boolean.FALSE);
                                AwaitKt.launch$default(coroutineScope, null, null, new SliderState.AnonymousClass2(mutableInteractionSourceImpl, mutableState6, null, (byte) 20), 3);
                                return Boolean.TRUE;
                            }
                        }
                        return Boolean.FALSE;
                    }
                };
                gapComposer2.updateRememberedValue(obj);
            } else {
                obj = objRememberedValue11;
                mutableInteractionSourceImpl = mutableInteractionSourceImpl2;
            }
            Modifier modifierOnKeyEvent = Key.onKeyEvent(modifierM151size3ABfNKs, (Function1) obj);
            boolean zChangedInstance4 = ((i3 & 458752) == 131072) | gapComposer2.changedInstance(analogTimePickerState) | gapComposer2.changedInstance(r22);
            Object objRememberedValue12 = gapComposer2.rememberedValue();
            if (zChangedInstance4 || objRememberedValue12 == neverEqualPolicy) {
                objRememberedValue12 = new LyricsUtils$$ExternalSyntheticLambda0(z2, (Object) analogTimePickerState, (Object) inputModeManager, (byte) 4);
                gapComposer2.updateRememberedValue(objRememberedValue12);
            }
            Modifier modifierFocusable = ImageKt.focusable(IndicationKt.indication(FocusTraversalKt.focusProperties(modifierOnKeyEvent, (Function1) objRememberedValue12), mutableInteractionSourceImpl, RippleKt.m313rippleOu1YvPQ$default(false, 24.0f, 0L, null, 253)), true, mutableInteractionSourceImpl);
            State state2 = state;
            boolean zChanged3 = gapComposer2.changed(function1) | ((i3 & 7168) == 2048) | gapComposer2.changed(state2);
            Object objRememberedValue13 = gapComposer2.rememberedValue();
            if (zChanged3 || objRememberedValue13 == neverEqualPolicy) {
                z3 = z;
                objRememberedValue13 = new LyricsUtils$$ExternalSyntheticLambda0((Object) function1, z3, (Object) state2, (byte) 5);
                gapComposer2.updateRememberedValue(objRememberedValue13);
            } else {
                z3 = z;
            }
            Modifier modifierSemantics = SemanticsModifierKt.semantics(modifierFocusable, true, (Function1) objRememberedValue13);
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(biasAlignment, false);
            int iHashCode = Long.hashCode(gapComposer2.compositeKeyHashCode);
            PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope = gapComposer2.currentCompositionLocalScope();
            Modifier modifierMaterializeModifier = ZIndexModifierKt.materializeModifier(gapComposer2, modifierSemantics);
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
            boolean zChanged4 = gapComposer2.changed(strM358numberContentDescriptiondSwYdS4);
            Object objRememberedValue14 = gapComposer2.rememberedValue();
            if (zChanged4 || objRememberedValue14 == neverEqualPolicy) {
                objRememberedValue14 = new IconKt$$ExternalSyntheticLambda1(strM358numberContentDescriptiondSwYdS4, (byte) 8);
                gapComposer2.updateRememberedValue(objRememberedValue14);
            }
            TextKt.m352TextNvy7gAk(localString$default, SemanticsModifierKt.clearAndSetSemantics(companion, (Function1) objRememberedValue14), 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, value, gapComposer2, 0, 0, 131068);
            gapComposer = gapComposer2;
            gapComposer.end(true);
        } else {
            z3 = z;
            gapComposer = gapComposer2;
            gapComposer.skipToGroupEnd();
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            final boolean z5 = z3;
            recomposeScopeImplEndRestartGroup.block = new Function2(analogTimePickerState, i, z5, focusOwner, z2, i2) { // from class: androidx.compose.material3.TimePickerKt$$ExternalSyntheticLambda50
                public final /* synthetic */ AnalogTimePickerState f$1;
                public final /* synthetic */ int f$2;
                public final /* synthetic */ boolean f$3;
                public final /* synthetic */ FocusOwner f$4;
                public final /* synthetic */ boolean f$5;

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj2, Object obj3) {
                    ((Integer) obj3).getClass();
                    int iUpdateChangedFlags = Stack.updateChangedFlags(1);
                    TimePickerKt.ClockText(this.f$0, this.f$1, this.f$2, this.f$3, this.f$4, this.f$5, (Composer) obj2, iUpdateChangedFlags);
                    return Unit.INSTANCE;
                }
            };
        }
    }

    public static final void DisplaySeparator(Modifier modifier, Composer composer, int i) {
        GapComposer gapComposer = (GapComposer) composer;
        gapComposer.startRestartGroup(2100674302);
        int i2 = (gapComposer.changed(modifier) ? 4 : 2) | i;
        if (gapComposer.shouldExecute(i2 & 1, (i2 & 3) != 2)) {
            TextStyle textStyle = (TextStyle) gapComposer.consume(TextKt.LocalTextStyle);
            LineHeightStyle.Alignment.m771constructorimpl(0.5f);
            TextStyle textStyleM750copyp1EtxEg$default = TextStyle.m750copyp1EtxEg$default(textStyle, 0L, 0L, null, null, null, null, 0L, 0L, null, new LineHeightStyle(0.5f, 17, 0), 15695871);
            Object objRememberedValue = gapComposer.rememberedValue();
            if (objRememberedValue == Composer.Companion.Empty) {
                objRememberedValue = new TextKt$$ExternalSyntheticLambda0((byte) 8);
                gapComposer.updateRememberedValue(objRememberedValue);
            }
            Modifier modifierClearAndSetSemantics = SemanticsModifierKt.clearAndSetSemantics(modifier, (Function1) objRememberedValue);
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.Center, false);
            int iHashCode = Long.hashCode(gapComposer.compositeKeyHashCode);
            PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope = gapComposer.currentCompositionLocalScope();
            Modifier modifierMaterializeModifier = ZIndexModifierKt.materializeModifier(gapComposer, modifierClearAndSetSemantics);
            ComposeUiNode.Companion.getClass();
            gapComposer.startReusableNode();
            if (gapComposer.inserting) {
                gapComposer.createNode(LayoutNode.Constructor);
            } else {
                gapComposer.useNode();
            }
            Stack.m390setimpl(gapComposer, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.Companion.SetMeasurePolicy);
            Stack.m390setimpl(gapComposer, persistentCompositionLocalHashMapCurrentCompositionLocalScope, ComposeUiNode.Companion.SetResolvedCompositionLocals);
            Stack.m390setimpl(gapComposer, Integer.valueOf(iHashCode), ComposeUiNode.Companion.SetCompositeKeyHash);
            Stack.m389reconcileimpl(gapComposer);
            Stack.m390setimpl(gapComposer, modifierMaterializeModifier, ComposeUiNode.Companion.SetModifier);
            TextKt.m352TextNvy7gAk(ServerSentEventKt.COLON, OffsetKt.m133offsetVpY3zN4(Modifier.Companion.$$INSTANCE, CropImageView.DEFAULT_ASPECT_RATIO, -4.0f), ColorSchemeKt.getValue(17, gapComposer), 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, textStyleM750copyp1EtxEg$default, gapComposer, 54, 0, 131064);
            gapComposer = gapComposer;
            gapComposer.end(true);
        } else {
            gapComposer.skipToGroupEnd();
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new TimePickerKt$$ExternalSyntheticLambda35(modifier, i, (byte) 0);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void HorizontalClockDisplay(TimePickerState timePickerState, TimePickerColors timePickerColors, Composer composer, int i) {
        int i2;
        byte b;
        boolean z;
        GapComposer gapComposer = (GapComposer) composer;
        gapComposer.startRestartGroup(-2034719658);
        if ((i & 6) == 0) {
            i2 = ((i & 8) == 0 ? gapComposer.changed(timePickerState) : gapComposer.changedInstance(timePickerState) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= gapComposer.changed(timePickerColors) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= gapComposer.changed((Object) null) ? 256 : 128;
        }
        if (gapComposer.shouldExecute(i2 & 1, (i2 & 147) != 146)) {
            ColumnMeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(OffsetKt.Center, Alignment.Companion.Start, gapComposer, 6);
            int iHashCode = Long.hashCode(gapComposer.compositeKeyHashCode);
            PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope = gapComposer.currentCompositionLocalScope();
            Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
            Modifier modifierMaterializeModifier = ZIndexModifierKt.materializeModifier(gapComposer, companion);
            ComposeUiNode.Companion.getClass();
            gapComposer.startReusableNode();
            boolean z2 = gapComposer.inserting;
            TextKt$$ExternalSyntheticLambda3 textKt$$ExternalSyntheticLambda3 = LayoutNode.Constructor;
            if (z2) {
                gapComposer.createNode(textKt$$ExternalSyntheticLambda3);
            } else {
                gapComposer.useNode();
            }
            Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda0 = ComposeUiNode.Companion.SetMeasurePolicy;
            Stack.m390setimpl(gapComposer, columnMeasurePolicy, updater$$ExternalSyntheticLambda0);
            Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda1 = ComposeUiNode.Companion.SetResolvedCompositionLocals;
            Stack.m390setimpl(gapComposer, persistentCompositionLocalHashMapCurrentCompositionLocalScope, updater$$ExternalSyntheticLambda1);
            Integer numValueOf = Integer.valueOf(iHashCode);
            Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda2 = ComposeUiNode.Companion.SetCompositeKeyHash;
            Stack.m390setimpl(gapComposer, numValueOf, updater$$ExternalSyntheticLambda2);
            Stack.m389reconcileimpl(gapComposer);
            Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda3 = ComposeUiNode.Companion.SetModifier;
            Stack.m390setimpl(gapComposer, modifierMaterializeModifier, updater$$ExternalSyntheticLambda3);
            ClockDisplayNumbers(timePickerState, timePickerColors, gapComposer, i2 & 1022);
            if (timePickerState.is24hour()) {
                z = true;
                gapComposer.startReplaceGroup(-1222586602);
                gapComposer.end(false);
            } else {
                gapComposer.startReplaceGroup(-1223300625);
                Modifier modifierM139paddingqDBjuR0$default = OffsetKt.m139paddingqDBjuR0$default(companion, CropImageView.DEFAULT_ASPECT_RATIO, 16.0f, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, 13);
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.TopStart, false);
                int iHashCode2 = Long.hashCode(gapComposer.compositeKeyHashCode);
                PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope2 = gapComposer.currentCompositionLocalScope();
                Modifier modifierMaterializeModifier2 = ZIndexModifierKt.materializeModifier(gapComposer, modifierM139paddingqDBjuR0$default);
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
                HorizontalPeriodToggle(SizeKt.m152sizeVpY3zN4(companion, 216.0f, 38.0f), timePickerState, toTimeInputColors(timePickerColors, gapComposer), gapComposer, (i2 << 3) & 7280);
                z = true;
                gapComposer.end(true);
                gapComposer.end(false);
            }
            gapComposer.end(z);
            b = z;
        } else {
            b = 1;
            gapComposer.skipToGroupEnd();
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new TimePickerKt$$ExternalSyntheticLambda7(timePickerState, timePickerColors, i, b);
        }
    }

    public static final void HorizontalPeriodToggle(Modifier modifier, TimePickerState timePickerState, TimeInputColors timeInputColors, Composer composer, int i) {
        int i2;
        GapComposer gapComposer = (GapComposer) composer;
        gapComposer.startRestartGroup(-606031626);
        byte b = 2;
        if ((i & 6) == 0) {
            i2 = (gapComposer.changed(modifier) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= (i & 64) == 0 ? gapComposer.changed(timePickerState) : gapComposer.changedInstance(timePickerState) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= gapComposer.changed(timeInputColors) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= gapComposer.changed((Object) null) ? 2048 : 1024;
        }
        if (gapComposer.shouldExecute(i2 & 1, (i2 & 1171) != 1170)) {
            gapComposer.startReplaceGroup(1754694070);
            boolean z = (i2 & 7168) == 2048;
            Object objRememberedValue = gapComposer.rememberedValue();
            if (z || objRememberedValue == Composer.Companion.Empty) {
                objRememberedValue = new BadgeKt$BadgedBox$1$1(b);
                gapComposer.updateRememberedValue(objRememberedValue);
            }
            gapComposer.end(false);
            Shape value = ShapesKt.getValue(14, gapComposer);
            ShapesKt.getValue(6, gapComposer);
            value.getClass();
            RoundedCornerShape roundedCornerShape = (RoundedCornerShape) value;
            PeriodToggleImpl(modifier, timePickerState, timeInputColors, (MeasurePolicy) objRememberedValue, ShapesKt.start$default(roundedCornerShape), ShapesKt.end$default(roundedCornerShape), gapComposer, (i2 & 1022) | ((i2 << 9) & 3670016));
        } else {
            gapComposer.skipToGroupEnd();
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new TimePickerKt$$ExternalSyntheticLambda11(modifier, timePickerState, timeInputColors, i, (byte) 1);
        }
    }

    public static final void HorizontalTimePicker(int i, AnalogTimePickerState analogTimePickerState, TimePickerColors timePickerColors, Composer composer, Modifier modifier, boolean z) {
        int i2;
        GapComposer gapComposer = (GapComposer) composer;
        gapComposer.startRestartGroup(901507182);
        if ((i & 6) == 0) {
            i2 = (gapComposer.changedInstance(analogTimePickerState) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= gapComposer.changed(modifier) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= gapComposer.changed(timePickerColors) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= gapComposer.changed(z) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i2 |= gapComposer.changed((Object) null) ? 16384 : 8192;
        }
        if (gapComposer.shouldExecute(i2 & 1, (i2 & 9363) != 9362)) {
            gapComposer.startDefaults();
            if ((i & 1) != 0 && !gapComposer.getDefaultsInvalid()) {
                gapComposer.skipToGroupEnd();
            }
            gapComposer.endDefaults();
            Object objRememberedValue = gapComposer.rememberedValue();
            if (objRememberedValue == Composer.Companion.Empty) {
                objRememberedValue = new TextKt$$ExternalSyntheticLambda0((byte) 10);
                gapComposer.updateRememberedValue(objRememberedValue);
            }
            Modifier modifierSemantics = SemanticsModifierKt.semantics(modifier, false, (Function1) objRememberedValue);
            RowMeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(OffsetKt.Start, Alignment.Companion.CenterVertically, gapComposer, 48);
            int iHashCode = Long.hashCode(gapComposer.compositeKeyHashCode);
            PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope = gapComposer.currentCompositionLocalScope();
            Modifier modifierMaterializeModifier = ZIndexModifierKt.materializeModifier(gapComposer, modifierSemantics);
            ComposeUiNode.Companion.getClass();
            gapComposer.startReusableNode();
            if (gapComposer.inserting) {
                gapComposer.createNode(LayoutNode.Constructor);
            } else {
                gapComposer.useNode();
            }
            Stack.m390setimpl(gapComposer, rowMeasurePolicy, ComposeUiNode.Companion.SetMeasurePolicy);
            Stack.m390setimpl(gapComposer, persistentCompositionLocalHashMapCurrentCompositionLocalScope, ComposeUiNode.Companion.SetResolvedCompositionLocals);
            Stack.m390setimpl(gapComposer, Integer.valueOf(iHashCode), ComposeUiNode.Companion.SetCompositeKeyHash);
            Stack.m389reconcileimpl(gapComposer);
            Stack.m390setimpl(gapComposer, modifierMaterializeModifier, ComposeUiNode.Companion.SetModifier);
            HorizontalClockDisplay(analogTimePickerState, timePickerColors, gapComposer, (i2 & 14) | ((i2 >> 3) & 112) | ((i2 >> 6) & 896));
            OffsetKt.Spacer(gapComposer, SizeKt.m155width3ABfNKs(Modifier.Companion.$$INSTANCE, 36.0f));
            ClockFace(((i2 << 3) & 112) | (i2 & 896) | (i2 & 7168), analogTimePickerState, timePickerColors, gapComposer, new ClockFaceSizeModifier(), z);
            gapComposer.end(true);
        } else {
            gapComposer.skipToGroupEnd();
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new TimePickerKt$$ExternalSyntheticLambda4(analogTimePickerState, modifier, timePickerColors, z, i, (byte) 1);
        }
    }

    public static final void PeriodToggleImpl(Modifier modifier, final TimePickerState timePickerState, TimeInputColors timeInputColors, MeasurePolicy measurePolicy, RoundedCornerShape roundedCornerShape, RoundedCornerShape roundedCornerShape2, Composer composer, int i) {
        int i2;
        RoundedCornerShape roundedCornerShape3;
        boolean z;
        GapComposer gapComposer = (GapComposer) composer;
        gapComposer.startRestartGroup(889485609);
        if ((i & 6) == 0) {
            i2 = (gapComposer.changed(modifier) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= (i & 64) == 0 ? gapComposer.changed(timePickerState) : gapComposer.changedInstance(timePickerState) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= gapComposer.changed(timeInputColors) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= gapComposer.changed(measurePolicy) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            roundedCornerShape3 = roundedCornerShape;
            i2 |= gapComposer.changed(roundedCornerShape3) ? 16384 : 8192;
        } else {
            roundedCornerShape3 = roundedCornerShape;
        }
        if ((i & 196608) == 0) {
            i2 |= gapComposer.changed(roundedCornerShape2) ? 131072 : 65536;
        }
        if ((1572864 & i) == 0) {
            i2 |= gapComposer.changed((Object) null) ? ByteChannelKt.CHANNEL_MAX_SIZE : 524288;
        }
        int i3 = i2 | 12582912;
        if (gapComposer.shouldExecute(i3 & 1, (4793491 & i3) != 4793490)) {
            final TextStyle value = CardKt.getValue(13, gapComposer);
            String strM373getString2EP1pXo = Icons$Filled.m373getString2EP1pXo(R.string.m3c_time_picker_period_toggle_description, gapComposer);
            int i4 = i3 & 112;
            boolean z2 = i4 == 32 || ((i3 & 64) != 0 && gapComposer.changedInstance(timePickerState));
            Object objRememberedValue = gapComposer.rememberedValue();
            NeverEqualPolicy neverEqualPolicy = Composer.Companion.Empty;
            if (z2 || objRememberedValue == neverEqualPolicy) {
                objRememberedValue = new TimePickerKt$$ExternalSyntheticLambda20(timePickerState, (byte) 3);
                gapComposer.updateRememberedValue(objRememberedValue);
            }
            Modifier modifierOnFocusChanged = FocusTraversalKt.onFocusChanged(modifier, (Function1) objRememberedValue);
            boolean zChanged = gapComposer.changed(strM373getString2EP1pXo);
            Object objRememberedValue2 = gapComposer.rememberedValue();
            if (zChanged || objRememberedValue2 == neverEqualPolicy) {
                objRememberedValue2 = new IconKt$$ExternalSyntheticLambda1(strM373getString2EP1pXo, (byte) 5);
                gapComposer.updateRememberedValue(objRememberedValue2);
            }
            Modifier modifierSemantics = SemanticsModifierKt.semantics(SemanticsModifierKt.semantics(modifierOnFocusChanged, false, (Function1) objRememberedValue2), false, new OffsetKt$$ExternalSyntheticLambda0((byte) 22));
            gapComposer.startReplaceGroup(97227921);
            gapComposer.end(false);
            Modifier modifierFocusRequester = Modifier.Companion.$$INSTANCE;
            Modifier modifierThen = modifierSemantics.then(modifierFocusRequester);
            if (timePickerState instanceof AnalogTimePickerState) {
                modifierFocusRequester = FocusTraversalKt.focusRequester(modifierFocusRequester, ((AnalogTimePickerState) timePickerState).amPmNodeFocusRequester);
            }
            Modifier modifierThen2 = modifierThen.then(modifierFocusRequester);
            int iHashCode = Long.hashCode(gapComposer.compositeKeyHashCode);
            PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope = gapComposer.currentCompositionLocalScope();
            Modifier modifierMaterializeModifier = ZIndexModifierKt.materializeModifier(gapComposer, modifierThen2);
            ComposeUiNode.Companion.getClass();
            gapComposer.startReusableNode();
            if (gapComposer.inserting) {
                gapComposer.createNode(LayoutNode.Constructor);
            } else {
                gapComposer.useNode();
            }
            Stack.m390setimpl(gapComposer, measurePolicy, ComposeUiNode.Companion.SetMeasurePolicy);
            Stack.m390setimpl(gapComposer, persistentCompositionLocalHashMapCurrentCompositionLocalScope, ComposeUiNode.Companion.SetResolvedCompositionLocals);
            Stack.m390setimpl(gapComposer, Integer.valueOf(iHashCode), ComposeUiNode.Companion.SetCompositeKeyHash);
            Stack.m389reconcileimpl(gapComposer);
            Stack.m390setimpl(gapComposer, modifierMaterializeModifier, ComposeUiNode.Companion.SetModifier);
            gapComposer.startReplaceGroup(-263114224);
            if (timePickerState.is24hour()) {
                z = false;
                gapComposer.startReplaceGroup(-259637822);
                gapComposer.end(false);
            } else {
                gapComposer.startReplaceGroup(-263078202);
                gapComposer.startReplaceGroup(-261379712);
                boolean z3 = !isPm(timePickerState);
                boolean z4 = i4 == 32 || ((i3 & 64) != 0 && gapComposer.changedInstance(timePickerState));
                Object objRememberedValue3 = gapComposer.rememberedValue();
                if (z4 || objRememberedValue3 == neverEqualPolicy) {
                    objRememberedValue3 = new TimePickerKt$$ExternalSyntheticLambda12(timePickerState, (byte) 1);
                    gapComposer.updateRememberedValue(objRememberedValue3);
                }
                final byte b = 0;
                int i5 = (i3 & 896) | 196608 | ((i3 >> 6) & 57344);
                z = false;
                ToggleItem(z3, (Function0) objRememberedValue3, timeInputColors, null, Expect_jvmKt.rememberComposableLambda(844669755, new Function3() { // from class: androidx.compose.material3.TimePickerKt$$ExternalSyntheticLambda28
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        byte b2 = b;
                        Unit unit = Unit.INSTANCE;
                        TimePickerState timePickerState2 = timePickerState;
                        switch (b2) {
                            case 0:
                                Composer composer2 = (Composer) obj2;
                                int iIntValue = ((Integer) obj3).intValue();
                                GapComposer gapComposer2 = (GapComposer) composer2;
                                if (!gapComposer2.shouldExecute(iIntValue & 1, (iIntValue & 17) != 16)) {
                                    gapComposer2.skipToGroupEnd();
                                } else {
                                    boolean zIsPm = TimePickerKt.isPm(timePickerState2);
                                    TextStyle textStyleM750copyp1EtxEg$default = value;
                                    if (!zIsPm) {
                                        textStyleM750copyp1EtxEg$default = TextStyle.m750copyp1EtxEg$default(textStyleM750copyp1EtxEg$default, 0L, 0L, FontWeight.Bold, null, null, null, 0L, 0L, null, null, 16777211);
                                    }
                                    TextKt.m352TextNvy7gAk(Icons$Filled.m373getString2EP1pXo(R.string.m3c_time_picker_am, gapComposer2), null, 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, textStyleM750copyp1EtxEg$default, gapComposer2, 0, 0, 131070);
                                }
                                break;
                            default:
                                Composer composer3 = (Composer) obj2;
                                int iIntValue2 = ((Integer) obj3).intValue();
                                GapComposer gapComposer3 = (GapComposer) composer3;
                                if (!gapComposer3.shouldExecute(iIntValue2 & 1, (iIntValue2 & 17) != 16)) {
                                    gapComposer3.skipToGroupEnd();
                                } else {
                                    boolean zIsPm2 = TimePickerKt.isPm(timePickerState2);
                                    TextStyle textStyleM750copyp1EtxEg$default2 = value;
                                    if (zIsPm2) {
                                        textStyleM750copyp1EtxEg$default2 = TextStyle.m750copyp1EtxEg$default(textStyleM750copyp1EtxEg$default2, 0L, 0L, FontWeight.Bold, null, null, null, 0L, 0L, null, null, 16777211);
                                    }
                                    TextKt.m352TextNvy7gAk(Icons$Filled.m373getString2EP1pXo(R.string.m3c_time_picker_pm, gapComposer3), null, 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, textStyleM750copyp1EtxEg$default2, gapComposer3, 0, 0, 131070);
                                }
                                break;
                        }
                        return unit;
                    }
                }, gapComposer), gapComposer, i5);
                boolean zIsPm = isPm(timePickerState);
                boolean z5 = i4 == 32 || ((i3 & 64) != 0 && gapComposer.changedInstance(timePickerState));
                Object objRememberedValue4 = gapComposer.rememberedValue();
                if (z5 || objRememberedValue4 == neverEqualPolicy) {
                    objRememberedValue4 = new TimePickerKt$$ExternalSyntheticLambda12(timePickerState, (byte) 2);
                    gapComposer.updateRememberedValue(objRememberedValue4);
                }
                final byte b2 = 1;
                ToggleItem(zIsPm, (Function0) objRememberedValue4, timeInputColors, null, Expect_jvmKt.rememberComposableLambda(-632095374, new Function3() { // from class: androidx.compose.material3.TimePickerKt$$ExternalSyntheticLambda28
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        byte b3 = b2;
                        Unit unit = Unit.INSTANCE;
                        TimePickerState timePickerState2 = timePickerState;
                        switch (b3) {
                            case 0:
                                Composer composer2 = (Composer) obj2;
                                int iIntValue = ((Integer) obj3).intValue();
                                GapComposer gapComposer2 = (GapComposer) composer2;
                                if (!gapComposer2.shouldExecute(iIntValue & 1, (iIntValue & 17) != 16)) {
                                    gapComposer2.skipToGroupEnd();
                                } else {
                                    boolean zIsPm2 = TimePickerKt.isPm(timePickerState2);
                                    TextStyle textStyleM750copyp1EtxEg$default = value;
                                    if (!zIsPm2) {
                                        textStyleM750copyp1EtxEg$default = TextStyle.m750copyp1EtxEg$default(textStyleM750copyp1EtxEg$default, 0L, 0L, FontWeight.Bold, null, null, null, 0L, 0L, null, null, 16777211);
                                    }
                                    TextKt.m352TextNvy7gAk(Icons$Filled.m373getString2EP1pXo(R.string.m3c_time_picker_am, gapComposer2), null, 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, textStyleM750copyp1EtxEg$default, gapComposer2, 0, 0, 131070);
                                }
                                break;
                            default:
                                Composer composer3 = (Composer) obj2;
                                int iIntValue2 = ((Integer) obj3).intValue();
                                GapComposer gapComposer3 = (GapComposer) composer3;
                                if (!gapComposer3.shouldExecute(iIntValue2 & 1, (iIntValue2 & 17) != 16)) {
                                    gapComposer3.skipToGroupEnd();
                                } else {
                                    boolean zIsPm3 = TimePickerKt.isPm(timePickerState2);
                                    TextStyle textStyleM750copyp1EtxEg$default2 = value;
                                    if (zIsPm3) {
                                        textStyleM750copyp1EtxEg$default2 = TextStyle.m750copyp1EtxEg$default(textStyleM750copyp1EtxEg$default2, 0L, 0L, FontWeight.Bold, null, null, null, 0L, 0L, null, null, 16777211);
                                    }
                                    TextKt.m352TextNvy7gAk(Icons$Filled.m373getString2EP1pXo(R.string.m3c_time_picker_pm, gapComposer3), null, 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, textStyleM750copyp1EtxEg$default2, gapComposer3, 0, 0, 131070);
                                }
                                break;
                        }
                        return unit;
                    }
                }, gapComposer), gapComposer, i5);
                gapComposer.end(false);
                gapComposer.end(false);
            }
            gapComposer.startReplaceGroup(-259612775);
            gapComposer.end(z);
            gapComposer.end(z);
            gapComposer.end(true);
        } else {
            gapComposer.skipToGroupEnd();
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new TimePickerKt$$ExternalSyntheticLambda25(modifier, timePickerState, timeInputColors, measurePolicy, roundedCornerShape3, roundedCornerShape2, i);
        }
    }

    /* JADX INFO: renamed from: TimePicker-mT9BvqQ, reason: not valid java name */
    public static final void m354TimePickermT9BvqQ(TimePickerState timePickerState, Modifier modifier, TimePickerColors timePickerColors, int i, Composer composer, int i2) {
        Modifier modifier2;
        TimePickerColors timePickerColors2;
        int i3;
        int i4;
        Modifier modifier3;
        int i5;
        TimePickerColors timePickerColors3;
        GapComposer gapComposer = (GapComposer) composer;
        gapComposer.startRestartGroup(-619286452);
        int i6 = i2 | (gapComposer.changed(timePickerState) ? 4 : 2) | 1200;
        if (gapComposer.shouldExecute(i6 & 1, (i6 & 1171) != 1170)) {
            gapComposer.startDefaults();
            if ((i2 & 1) == 0 || gapComposer.getDefaultsInvalid()) {
                ColorScheme colorScheme = ((MaterialTheme$Values) gapComposer.consume(MaterialThemeKt._localMaterialTheme)).colorScheme;
                TimePickerColors timePickerColors4 = colorScheme.defaultTimePickerColorsCached;
                if (timePickerColors4 == null) {
                    TimePickerColors timePickerColors5 = new TimePickerColors(ColorSchemeKt.m284fromToken_Htp75A(colorScheme, 38), ColorSchemeKt.m284fromToken_Htp75A(colorScheme, 25), ColorSchemeKt.m284fromToken_Htp75A(colorScheme, 37), ColorSchemeKt.m284fromToken_Htp75A(colorScheme, 23), ColorSchemeKt.m284fromToken_Htp75A(colorScheme, 9), ColorSchemeKt.m284fromToken_Htp75A(colorScheme, 17), ColorSchemeKt.m284fromToken_Htp75A(colorScheme, 26), ColorSchemeKt.m284fromToken_Htp75A(colorScheme, 40), ColorSchemeKt.m284fromToken_Htp75A(colorScheme, 10), ColorSchemeKt.m284fromToken_Htp75A(colorScheme, 18), ColorSchemeKt.m284fromToken_Htp75A(colorScheme, 26), ColorSchemeKt.m284fromToken_Htp75A(colorScheme, 38), ColorSchemeKt.m284fromToken_Htp75A(colorScheme, 10), ColorSchemeKt.m284fromToken_Htp75A(colorScheme, 17));
                    colorScheme.defaultTimePickerColorsCached = timePickerColors5;
                    timePickerColors4 = timePickerColors5;
                }
                int iDefaultTimePickerLayoutType = ScrimKt.defaultTimePickerLayoutType(gapComposer);
                i4 = i6 & (-8065);
                modifier3 = Modifier.Companion.$$INSTANCE;
                TimePickerColors timePickerColors6 = timePickerColors4;
                i5 = iDefaultTimePickerLayoutType;
                timePickerColors3 = timePickerColors6;
            } else {
                gapComposer.skipToGroupEnd();
                timePickerColors3 = timePickerColors;
                i5 = i;
                i4 = i6 & (-8065);
                modifier3 = modifier;
            }
            gapComposer.endDefaults();
            m355TimePickerImplNdgjQFA(timePickerState, modifier3, timePickerColors3, i5, gapComposer, i4 & 8190);
            modifier2 = modifier3;
            timePickerColors2 = timePickerColors3;
            i3 = i5;
        } else {
            gapComposer.skipToGroupEnd();
            modifier2 = modifier;
            timePickerColors2 = timePickerColors;
            i3 = i;
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new TimePickerKt$$ExternalSyntheticLambda0(timePickerState, modifier2, timePickerColors2, i3, i2);
        }
    }

    /* JADX INFO: renamed from: TimePickerImpl-NdgjQFA, reason: not valid java name */
    public static final void m355TimePickerImplNdgjQFA(TimePickerState timePickerState, Modifier modifier, TimePickerColors timePickerColors, int i, Composer composer, int i2) {
        int i3;
        GapComposer gapComposer;
        Integer num;
        AnalogTimePickerState analogTimePickerState;
        GapComposer gapComposer2 = (GapComposer) composer;
        gapComposer2.startRestartGroup(-3751149);
        if ((i2 & 6) == 0) {
            i3 = ((i2 & 8) == 0 ? gapComposer2.changed(timePickerState) : gapComposer2.changedInstance(timePickerState) ? 4 : 2) | i2;
        } else {
            i3 = i2;
        }
        if ((i2 & 48) == 0) {
            i3 |= gapComposer2.changed(modifier) ? 32 : 16;
        }
        if ((i2 & 384) == 0) {
            i3 |= gapComposer2.changed(timePickerColors) ? 256 : 128;
        }
        if ((i2 & 3072) == 0) {
            i3 |= gapComposer2.changed(i) ? 2048 : 1024;
        }
        int i4 = i3 | 24576;
        if (gapComposer2.shouldExecute(i4 & 1, (i4 & 9363) != 9362)) {
            gapComposer2.startDefaults();
            if ((i2 & 1) != 0 && !gapComposer2.getDefaultsInvalid()) {
                gapComposer2.skipToGroupEnd();
            }
            gapComposer2.endDefaults();
            boolean z = (((Boolean) Icons$Filled.rememberAccessibilityServiceState(0, 7, gapComposer2).getValue()).booleanValue() || (((InputMode) ((InputModeManagerImpl) ((InputModeManager) gapComposer2.consume(CompositionLocalsKt.LocalInputModeManager))).inputMode$delegate.getValue()).value == 2)) ? false : true;
            Object objRememberedValue = gapComposer2.rememberedValue();
            NeverEqualPolicy neverEqualPolicy = Composer.Companion.Empty;
            if (objRememberedValue == neverEqualPolicy) {
                objRememberedValue = new Ref();
                gapComposer2.updateRememberedValue(objRememberedValue);
            }
            Ref ref = (Ref) objRememberedValue;
            int i5 = i4 & 14;
            boolean z2 = i5 == 4 || ((i4 & 8) != 0 && gapComposer2.changed(timePickerState));
            Object objRememberedValue2 = gapComposer2.rememberedValue();
            if (z2 || objRememberedValue2 == neverEqualPolicy) {
                objRememberedValue2 = new AnalogTimePickerState(timePickerState, ref);
                gapComposer2.updateRememberedValue(objRememberedValue2);
            }
            AnalogTimePickerState analogTimePickerState2 = (AnalogTimePickerState) objRememberedValue2;
            Integer numValueOf = Integer.valueOf(timePickerState.getHour());
            Integer numValueOf2 = Integer.valueOf(timePickerState.getMinute());
            boolean zChangedInstance = gapComposer2.changedInstance(ref) | gapComposer2.changedInstance(analogTimePickerState2) | (i5 == 4 || ((i4 & 8) != 0 && gapComposer2.changedInstance(timePickerState)));
            Object objRememberedValue3 = gapComposer2.rememberedValue();
            if (zChangedInstance || objRememberedValue3 == neverEqualPolicy) {
                num = numValueOf;
                SyncUtils$createPlaylist$1.AnonymousClass1 anonymousClass1 = new SyncUtils$createPlaylist$1.AnonymousClass1((Object) ref, (Object) analogTimePickerState2, (Object) timePickerState, (Continuation) null, (byte) 2);
                analogTimePickerState = analogTimePickerState2;
                gapComposer2.updateRememberedValue(anonymousClass1);
                objRememberedValue3 = anonymousClass1;
            } else {
                analogTimePickerState = analogTimePickerState2;
                num = numValueOf;
            }
            Stack.LaunchedEffect(num, numValueOf2, (Function2) objRememberedValue3, gapComposer2);
            if (i == 1) {
                gapComposer2.startReplaceGroup(-80438663);
                gapComposer = gapComposer2;
                VerticalTimePicker(58352 & i4, analogTimePickerState, timePickerColors, gapComposer, modifier, z);
                gapComposer.end(false);
            } else {
                gapComposer = gapComposer2;
                gapComposer.startReplaceGroup(-80220361);
                HorizontalTimePicker(58352 & i4, analogTimePickerState, timePickerColors, gapComposer, modifier, z);
                gapComposer.end(false);
            }
        } else {
            gapComposer = gapComposer2;
            gapComposer.skipToGroupEnd();
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new TimePickerKt$$ExternalSyntheticLambda2(timePickerState, modifier, timePickerColors, i, i2);
        }
    }

    /* JADX INFO: renamed from: TimeSelector-iO60bNI, reason: not valid java name */
    public static final void m356TimeSelectoriO60bNI(Modifier modifier, int i, TimePickerState timePickerState, int i2, TimeInputColors timeInputColors, Function0 function0, Composer composer, int i3) {
        GapComposer gapComposer;
        TextFieldColors textFieldColors = timeInputColors.timeTextFieldColors;
        GapComposer gapComposer2 = (GapComposer) composer;
        gapComposer2.startRestartGroup(1881663166);
        byte b = 4;
        int i4 = 2;
        int i5 = i3 | (gapComposer2.changed(modifier) ? 4 : 2) | (gapComposer2.changed(i) ? 32 : 16) | (gapComposer2.changed(timePickerState) ? 256 : 128) | (gapComposer2.changed(i2) ? 2048 : 1024) | (gapComposer2.changed(timeInputColors) ? 16384 : 8192) | (gapComposer2.changed((Object) null) ? ByteChannelKt.CHANNEL_MAX_SIZE : 524288) | (gapComposer2.changedInstance(function0) ? 8388608 : 4194304);
        if (gapComposer2.shouldExecute(i5 & 1, (4793491 & i5) != 4793490)) {
            Boolean bool = Boolean.TRUE;
            Object objRememberedValue = gapComposer2.rememberedValue();
            Continuation continuation = null;
            NeverEqualPolicy neverEqualPolicy = Composer.Companion.Empty;
            if (objRememberedValue == neverEqualPolicy) {
                objRememberedValue = new App$Companion$forgetAccount$2(i4, continuation, b);
                gapComposer2.updateRememberedValue(objRememberedValue);
            }
            Stack.LaunchedEffect(gapComposer2, bool, (Function2) objRememberedValue);
            boolean z = timePickerState.mo241getSelectionyecRtBI() == i2;
            String strM373getString2EP1pXo = Icons$Filled.m373getString2EP1pXo(i2 == 0 ? R.string.m3c_time_picker_hour_selection : R.string.m3c_time_picker_minute_selection, gapComposer2);
            gapComposer2.startReplaceGroup(97092482);
            gapComposer2.end(false);
            long jM343containerColorXeAY9LY = textFieldColors.m343containerColorXeAY9LY(true, z);
            gapComposer2.startReplaceGroup(97097024);
            gapComposer2.end(false);
            long jM346textColorXeAY9LY = textFieldColors.m346textColorXeAY9LY(true, z);
            boolean zChanged = gapComposer2.changed(strM373getString2EP1pXo);
            Object objRememberedValue2 = gapComposer2.rememberedValue();
            if (zChanged || objRememberedValue2 == neverEqualPolicy) {
                objRememberedValue2 = new IconKt$$ExternalSyntheticLambda1(strM373getString2EP1pXo, (byte) 6);
                gapComposer2.updateRememberedValue(objRememberedValue2);
            }
            Modifier modifierSemantics = SemanticsModifierKt.semantics(modifier, true, (Function1) objRememberedValue2);
            gapComposer2.startReplaceGroup(97115395);
            Shape value = ShapesKt.getValue(14, gapComposer2);
            gapComposer2.end(false);
            gapComposer2.startReplaceGroup(-1284061729);
            gapComposer2.end(false);
            boolean z2 = ((i5 & 896) == 256) | ((i5 & 7168) == 2048) | ((i5 & 29360128) == 8388608);
            Object objRememberedValue3 = gapComposer2.rememberedValue();
            if (z2 || objRememberedValue3 == neverEqualPolicy) {
                objRememberedValue3 = new TimePickerKt$$ExternalSyntheticLambda40(i2, timePickerState, function0);
                gapComposer2.updateRememberedValue(objRememberedValue3);
            }
            gapComposer = gapComposer2;
            SurfaceKt.m338Surfaced85dljk(z, (Function0) objRememberedValue3, modifierSemantics, false, value, jM343containerColorXeAY9LY, 0L, CropImageView.DEFAULT_ASPECT_RATIO, null, null, Expect_jvmKt.rememberComposableLambda(-320986392, new TimePickerKt$$ExternalSyntheticLambda41(i2, timePickerState, i, jM346textColorXeAY9LY), gapComposer2), gapComposer, 0, 1480);
        } else {
            gapComposer = gapComposer2;
            gapComposer.skipToGroupEnd();
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new CheckboxKt$$ExternalSyntheticLambda3(modifier, i, timePickerState, i2, timeInputColors, function0, i3);
        }
    }

    public static final void ToggleItem(boolean z, Function0 function0, TimeInputColors timeInputColors, Shape shape, ComposableLambdaImpl composableLambdaImpl, Composer composer, int i) {
        int i2;
        Shape shape2;
        int i3;
        Shape shape3;
        GapComposer gapComposer = (GapComposer) composer;
        gapComposer.startRestartGroup(1699743818);
        if ((i & 6) == 0) {
            i2 = (gapComposer.changed(z) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= gapComposer.changedInstance(function0) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= gapComposer.changed(timeInputColors) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= 1024;
        }
        if ((i & 24576) == 0) {
            i2 |= gapComposer.changed((Object) null) ? 16384 : 8192;
        }
        if ((196608 & i) == 0) {
            i2 |= gapComposer.changedInstance(composableLambdaImpl) ? 131072 : 65536;
        }
        if (gapComposer.shouldExecute(i2 & 1, (74899 & i2) != 74898)) {
            gapComposer.startDefaults();
            if ((i & 1) == 0 || gapComposer.getDefaultsInvalid()) {
                i3 = i2 & (-7169);
                shape3 = RoundedCornerShapeKt.CircleShape;
            } else {
                gapComposer.skipToGroupEnd();
                i3 = i2 & (-7169);
                shape3 = shape;
            }
            gapComposer.endDefaults();
            gapComposer.startReplaceGroup(-595946704);
            float f = ToggleButtonDefaults.size;
            long j = timeInputColors.periodSelectorContainerColor;
            long j2 = timeInputColors.periodSelectorContentColor;
            long j3 = timeInputColors.periodSelectorSelectedContainerColor;
            long j4 = timeInputColors.periodSelectorSelectedContentColor;
            Rgb rgb = ColorSpaces.Unspecified;
            long jColor = ColorKt.Color(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, rgb);
            long jColor2 = ColorKt.Color(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, rgb);
            ColorScheme colorScheme = ((MaterialTheme$Values) gapComposer.consume(MaterialThemeKt._localMaterialTheme)).colorScheme;
            ToggleButtonColors toggleButtonColors = colorScheme.defaultToggleButtonColorsCached;
            if (toggleButtonColors == null) {
                long jM284fromToken_Htp75A = ColorSchemeKt.m284fromToken_Htp75A(colorScheme, 36);
                long jM284fromToken_Htp75A2 = ColorSchemeKt.m284fromToken_Htp75A(colorScheme, 18);
                long jM284fromToken_Htp75A3 = ColorSchemeKt.m284fromToken_Htp75A(colorScheme, 17);
                long jColor3 = ColorKt.Color(Color.m485getRedimpl(jM284fromToken_Htp75A3), Color.m484getGreenimpl(jM284fromToken_Htp75A3), Color.m482getBlueimpl(jM284fromToken_Htp75A3), 0.1f, Color.m483getColorSpaceimpl(jM284fromToken_Htp75A3));
                long jM284fromToken_Htp75A4 = ColorSchemeKt.m284fromToken_Htp75A(colorScheme, 18);
                toggleButtonColors = new ToggleButtonColors(jM284fromToken_Htp75A, jM284fromToken_Htp75A2, jColor3, ColorKt.Color(Color.m485getRedimpl(jM284fromToken_Htp75A4), Color.m484getGreenimpl(jM284fromToken_Htp75A4), Color.m482getBlueimpl(jM284fromToken_Htp75A4), 0.38f, Color.m483getColorSpaceimpl(jM284fromToken_Htp75A4)), ColorSchemeKt.m284fromToken_Htp75A(colorScheme, 25), ColorSchemeKt.m284fromToken_Htp75A(colorScheme, 9));
                colorScheme.defaultToggleButtonColorsCached = toggleButtonColors;
            }
            if (j == 16) {
                j = toggleButtonColors.containerColor;
            }
            long j5 = j;
            long j6 = j2 != 16 ? j2 : toggleButtonColors.contentColor;
            long j7 = jColor != 16 ? jColor : toggleButtonColors.disabledContainerColor;
            long j8 = jColor2 != 16 ? jColor2 : toggleButtonColors.disabledContentColor;
            long j9 = j3 != 16 ? j3 : toggleButtonColors.checkedContainerColor;
            if (j4 == 16) {
                j4 = toggleButtonColors.checkedContentColor;
            }
            ToggleButtonColors toggleButtonColors2 = new ToggleButtonColors(j5, j6, j7, j8, j9, j4);
            ToggleButtonShapes toggleButtonShapes = new ToggleButtonShapes(RoundedCornerShapeKt.CircleShape, RoundedCornerShapeKt.m185RoundedCornerShape0680j_4(12.0f), RoundedCornerShapeKt.m185RoundedCornerShape0680j_4(12.0f));
            boolean z2 = (i3 & 112) == 32;
            Object objRememberedValue = gapComposer.rememberedValue();
            NeverEqualPolicy neverEqualPolicy = Composer.Companion.Empty;
            if (z2 || objRememberedValue == neverEqualPolicy) {
                objRememberedValue = new AppBarKt$$ExternalSyntheticLambda8(function0, (byte) 7);
                gapComposer.updateRememberedValue(objRememberedValue);
            }
            Function1 function1 = (Function1) objRememberedValue;
            Modifier modifierThen = ZIndexModifierKt.zIndex(Modifier.Companion.$$INSTANCE, z ? CropImageView.DEFAULT_ASPECT_RATIO : 1.0f).then(SizeKt.FillWholeMaxSize);
            int i4 = i3 & 14;
            boolean z3 = i4 == 4;
            Object objRememberedValue2 = gapComposer.rememberedValue();
            if (z3 || objRememberedValue2 == neverEqualPolicy) {
                objRememberedValue2 = new CookieKt$$ExternalSyntheticLambda3((byte) 2, z);
                gapComposer.updateRememberedValue(objRememberedValue2);
            }
            ScrimKt.m323ToggleButtonEwToSPQ(z, function1, SemanticsModifierKt.semantics(modifierThen, false, (Function1) objRememberedValue2), CropImageView.DEFAULT_ASPECT_RATIO, false, toggleButtonShapes, toggleButtonColors2, null, new PaddingValuesImpl(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO), composableLambdaImpl, gapComposer, i4, ((i3 >> 9) & 896) | 6);
            gapComposer.end(false);
            shape2 = shape3;
        } else {
            gapComposer.skipToGroupEnd();
            shape2 = shape;
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new CheckboxKt$$ExternalSyntheticLambda3(z, function0, timeInputColors, shape2, composableLambdaImpl, i);
        }
    }

    public static final void VerticalClockDisplay(TimePickerState timePickerState, TimePickerColors timePickerColors, Composer composer, int i) {
        int i2;
        boolean z;
        GapComposer gapComposer = (GapComposer) composer;
        gapComposer.startRestartGroup(-407468860);
        if ((i & 6) == 0) {
            i2 = ((i & 8) == 0 ? gapComposer.changed(timePickerState) : gapComposer.changedInstance(timePickerState) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= gapComposer.changed(timePickerColors) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= gapComposer.changed((Object) null) ? 256 : 128;
        }
        if (gapComposer.shouldExecute(i2 & 1, (i2 & 147) != 146)) {
            RowMeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(OffsetKt.Center, Alignment.Companion.Top, gapComposer, 6);
            int iHashCode = Long.hashCode(gapComposer.compositeKeyHashCode);
            PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope = gapComposer.currentCompositionLocalScope();
            Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
            Modifier modifierMaterializeModifier = ZIndexModifierKt.materializeModifier(gapComposer, companion);
            ComposeUiNode.Companion.getClass();
            gapComposer.startReusableNode();
            boolean z2 = gapComposer.inserting;
            TextKt$$ExternalSyntheticLambda3 textKt$$ExternalSyntheticLambda3 = LayoutNode.Constructor;
            if (z2) {
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
            ClockDisplayNumbers(timePickerState, timePickerColors, gapComposer, i2 & 1022);
            if (timePickerState.is24hour()) {
                z = true;
                gapComposer.startReplaceGroup(1694341818);
                gapComposer.end(false);
            } else {
                gapComposer.startReplaceGroup(1693443283);
                Modifier modifierM139paddingqDBjuR0$default = OffsetKt.m139paddingqDBjuR0$default(companion, 4.0f, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, 14);
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.TopStart, false);
                int iHashCode2 = Long.hashCode(gapComposer.compositeKeyHashCode);
                PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope2 = gapComposer.currentCompositionLocalScope();
                Modifier modifierMaterializeModifier2 = ZIndexModifierKt.materializeModifier(gapComposer, modifierM139paddingqDBjuR0$default);
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
                VerticalPeriodToggle(SizeKt.m152sizeVpY3zN4(companion, 52.0f, 80.0f), timePickerState, toTimeInputColors(timePickerColors, gapComposer), gapComposer, (i2 << 3) & 7280);
                z = true;
                gapComposer.end(true);
                gapComposer.end(false);
            }
            gapComposer.end(z);
        } else {
            gapComposer.skipToGroupEnd();
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new TimePickerKt$$ExternalSyntheticLambda7(timePickerState, timePickerColors, i, (byte) 0);
        }
    }

    public static final void VerticalPeriodToggle(Modifier modifier, TimePickerState timePickerState, TimeInputColors timeInputColors, Composer composer, int i) {
        int i2;
        TimeInputColors timeInputColors2;
        GapComposer gapComposer = (GapComposer) composer;
        gapComposer.startRestartGroup(-2040118428);
        if ((i & 6) == 0) {
            i2 = (gapComposer.changed(modifier) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= (i & 64) == 0 ? gapComposer.changed(timePickerState) : gapComposer.changedInstance(timePickerState) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            timeInputColors2 = timeInputColors;
            i2 |= gapComposer.changed(timeInputColors2) ? 256 : 128;
        } else {
            timeInputColors2 = timeInputColors;
        }
        if ((i & 3072) == 0) {
            i2 |= gapComposer.changed((Object) null) ? 2048 : 1024;
        }
        if (gapComposer.shouldExecute(i2 & 1, (i2 & 1171) != 1170)) {
            gapComposer.startReplaceGroup(914467264);
            boolean z = (i2 & 7168) == 2048;
            Object objRememberedValue = gapComposer.rememberedValue();
            if (z || objRememberedValue == Composer.Companion.Empty) {
                objRememberedValue = new BadgeKt$BadgedBox$1$1((byte) 3);
                gapComposer.updateRememberedValue(objRememberedValue);
            }
            gapComposer.end(false);
            Shape value = ShapesKt.getValue(14, gapComposer);
            ShapesKt.getValue(6, gapComposer);
            value.getClass();
            RoundedCornerShape roundedCornerShape = (RoundedCornerShape) value;
            RoundedCornerShape roundedCornerShape2 = ShapesKt.top$default(roundedCornerShape);
            DpCornerSize dpCornerSize = ShapeDefaults.CornerNone;
            PeriodToggleImpl(modifier, timePickerState, timeInputColors2, (MeasurePolicy) objRememberedValue, roundedCornerShape2, RoundedCornerShape.copy$default(roundedCornerShape, dpCornerSize, dpCornerSize, null, null, 12), gapComposer, (i2 & 1022) | ((i2 << 9) & 3670016));
        } else {
            gapComposer.skipToGroupEnd();
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new TimePickerKt$$ExternalSyntheticLambda11(modifier, timePickerState, timeInputColors, i, (byte) 0);
        }
    }

    public static final void VerticalTimePicker(int i, AnalogTimePickerState analogTimePickerState, TimePickerColors timePickerColors, Composer composer, Modifier modifier, boolean z) {
        int i2;
        GapComposer gapComposer = (GapComposer) composer;
        gapComposer.startRestartGroup(362821824);
        if ((i & 6) == 0) {
            i2 = (gapComposer.changedInstance(analogTimePickerState) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= gapComposer.changed(modifier) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= gapComposer.changed(timePickerColors) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= gapComposer.changed(z) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i2 |= gapComposer.changed((Object) null) ? 16384 : 8192;
        }
        if (gapComposer.shouldExecute(i2 & 1, (i2 & 9363) != 9362)) {
            gapComposer.startDefaults();
            if ((i & 1) != 0 && !gapComposer.getDefaultsInvalid()) {
                gapComposer.skipToGroupEnd();
            }
            gapComposer.endDefaults();
            Object objRememberedValue = gapComposer.rememberedValue();
            if (objRememberedValue == Composer.Companion.Empty) {
                objRememberedValue = new TextKt$$ExternalSyntheticLambda0((byte) 9);
                gapComposer.updateRememberedValue(objRememberedValue);
            }
            Modifier modifierSemantics = SemanticsModifierKt.semantics(modifier, false, (Function1) objRememberedValue);
            ColumnMeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(OffsetKt.Top, Alignment.Companion.CenterHorizontally, gapComposer, 48);
            int iHashCode = Long.hashCode(gapComposer.compositeKeyHashCode);
            PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope = gapComposer.currentCompositionLocalScope();
            Modifier modifierMaterializeModifier = ZIndexModifierKt.materializeModifier(gapComposer, modifierSemantics);
            ComposeUiNode.Companion.getClass();
            gapComposer.startReusableNode();
            if (gapComposer.inserting) {
                gapComposer.createNode(LayoutNode.Constructor);
            } else {
                gapComposer.useNode();
            }
            Stack.m390setimpl(gapComposer, columnMeasurePolicy, ComposeUiNode.Companion.SetMeasurePolicy);
            Stack.m390setimpl(gapComposer, persistentCompositionLocalHashMapCurrentCompositionLocalScope, ComposeUiNode.Companion.SetResolvedCompositionLocals);
            Stack.m390setimpl(gapComposer, Integer.valueOf(iHashCode), ComposeUiNode.Companion.SetCompositeKeyHash);
            Stack.m389reconcileimpl(gapComposer);
            Stack.m390setimpl(gapComposer, modifierMaterializeModifier, ComposeUiNode.Companion.SetModifier);
            VerticalClockDisplay(analogTimePickerState, timePickerColors, gapComposer, (i2 & 14) | ((i2 >> 3) & 112) | ((i2 >> 6) & 896));
            Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
            OffsetKt.Spacer(gapComposer, SizeKt.m145height3ABfNKs(companion, 36.0f));
            ClockFace((i2 & 7168) | ((i2 << 3) & 112) | (i2 & 896), analogTimePickerState, timePickerColors, gapComposer, SizeKt.m151size3ABfNKs(companion, 256.0f), z);
            OffsetKt.Spacer(gapComposer, SizeKt.m145height3ABfNKs(companion, 24.0f));
            gapComposer.end(true);
        } else {
            gapComposer.skipToGroupEnd();
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new TimePickerKt$$ExternalSyntheticLambda4(analogTimePickerState, modifier, timePickerColors, z, i, (byte) 0);
        }
    }

    public static final int getHourForDisplay(TimePickerState timePickerState) {
        if (timePickerState.is24hour()) {
            return timePickerState.getHour() % 24;
        }
        if (timePickerState.getHour() % 12 == 0) {
            return 12;
        }
        return isPm(timePickerState) ? timePickerState.getHour() - 12 : timePickerState.getHour();
    }

    public static final long getSelectorPos(AnalogTimePickerState analogTimePickerState) {
        float fM240getCurrentDiameterD9Ej5fM;
        float f;
        float fM240getCurrentDiameterD9Ej5fM2 = ((analogTimePickerState.m240getCurrentDiameterD9Ej5fM() / 256.0f) * 24.0f) + CropImageView.DEFAULT_ASPECT_RATIO;
        TimePickerState timePickerState = analogTimePickerState.state;
        if (timePickerState.is24hour() && isPm(analogTimePickerState) && timePickerState.mo241getSelectionyecRtBI() == 0) {
            fM240getCurrentDiameterD9Ej5fM = analogTimePickerState.m240getCurrentDiameterD9Ej5fM();
            f = 0.26953125f;
        } else {
            fM240getCurrentDiameterD9Ej5fM = analogTimePickerState.m240getCurrentDiameterD9Ej5fM();
            f = 0.39453125f;
        }
        float f2 = ((Dp) UuidKt.coerceAtLeast(new Dp((((fM240getCurrentDiameterD9Ej5fM * f) + CropImageView.DEFAULT_ASPECT_RATIO) - fM240getCurrentDiameterD9Ej5fM2) + CropImageView.DEFAULT_ASPECT_RATIO), new Dp(CropImageView.DEFAULT_ASPECT_RATIO))).value + fM240getCurrentDiameterD9Ej5fM2 + CropImageView.DEFAULT_ASPECT_RATIO;
        return (((long) Float.floatToRawIntBits((((analogTimePickerState.m240getCurrentDiameterD9Ej5fM() / 2.0f) + CropImageView.DEFAULT_ASPECT_RATIO) + ((((float) Math.cos(((Number) analogTimePickerState.anim.getValue()).floatValue())) * f2) + CropImageView.DEFAULT_ASPECT_RATIO)) + CropImageView.DEFAULT_ASPECT_RATIO)) << 32) | (((long) Float.floatToRawIntBits((analogTimePickerState.m240getCurrentDiameterD9Ej5fM() / 2.0f) + CropImageView.DEFAULT_ASPECT_RATIO + (f2 * ((float) Math.sin(((Number) analogTimePickerState.anim.getValue()).floatValue()))) + CropImageView.DEFAULT_ASPECT_RATIO + CropImageView.DEFAULT_ASPECT_RATIO)) & 4294967295L);
    }

    public static final boolean isPm(TimePickerState timePickerState) {
        return timePickerState.getHour() >= 12;
    }

    public static final boolean isValidHour(TimePickerState timePickerState, int i) {
        if (timePickerState.is24hour()) {
            return i >= 0 && i < 24;
        }
        if (isPm(timePickerState)) {
            return 12 <= i && i < 24;
        }
        return i >= 0 && i < 12;
    }

    /* JADX INFO: renamed from: moveSelector-d3b8Pxo, reason: not valid java name */
    public static final void m357moveSelectord3b8Pxo(TimePickerState timePickerState, float f, float f2, float f3, long j) {
        if (timePickerState.mo241getSelectionyecRtBI() == 0 && timePickerState.is24hour()) {
            float fHypot = (float) Math.hypot(((int) (j >> 32)) - f, ((int) (j & 4294967295L)) - f2);
            if (isPm(timePickerState)) {
                timePickerState.setHour(timePickerState.getHour() - (fHypot >= f3 ? 12 : 0));
            } else {
                timePickerState.setHour(timePickerState.getHour() + (fHypot < f3 ? 12 : 0));
            }
        }
    }

    /* JADX INFO: renamed from: numberContentDescription-dSwYdS4, reason: not valid java name */
    public static final String m358numberContentDescriptiondSwYdS4(int i, boolean z, int i2, Composer composer) {
        int i3;
        if (i == 1) {
            i3 = R.string.m3c_time_picker_minute_suffix;
        } else {
            i3 = z ? R.string.m3c_time_picker_hour_24h_suffix : R.string.m3c_time_picker_hour_suffix;
        }
        Object[] objArr = {Integer.valueOf(i2)};
        String strM373getString2EP1pXo = Icons$Filled.m373getString2EP1pXo(i3, composer);
        Locale locale = ((androidx.compose.ui.text.intl.Locale) ((GapComposer) composer).consume(CompositionLocalsKt.LocalLocale)).platformLocale;
        Object[] objArrCopyOf = Arrays.copyOf(objArr, 1);
        return String.format(locale, strM373getString2EP1pXo, Arrays.copyOf(objArrCopyOf, objArrCopyOf.length));
    }

    /* JADX WARN: Code duplicated, block: B:41:0x00e7  */
    /* JADX WARN: Code duplicated, block: B:8:0x0016  */
    /* JADX INFO: renamed from: onTap-uYHVD98, reason: not valid java name */
    public static final Object m359onTapuYHVD98(AnalogTimePickerState analogTimePickerState, float f, float f2, float f3, boolean z, long j, AnimationSpec animationSpec, ContinuationImpl continuationImpl) {
        TimePickerKt$onTap$1 timePickerKt$onTap$1;
        float f4;
        float fRint;
        boolean z2;
        int i;
        AnalogTimePickerState analogTimePickerState2;
        boolean z3;
        if (continuationImpl instanceof TimePickerKt$onTap$1) {
            timePickerKt$onTap$1 = (TimePickerKt$onTap$1) continuationImpl;
            int i2 = timePickerKt$onTap$1.label;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                timePickerKt$onTap$1.label = i2 - Integer.MIN_VALUE;
            } else {
                timePickerKt$onTap$1 = new TimePickerKt$onTap$1(continuationImpl);
            }
        } else {
            timePickerKt$onTap$1 = new TimePickerKt$onTap$1(continuationImpl);
        }
        TimePickerKt$onTap$1 timePickerKt$onTap$2 = timePickerKt$onTap$1;
        Object obj = timePickerKt$onTap$2.result;
        int i3 = timePickerKt$onTap$2.label;
        Unit unit = Unit.INSTANCE;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (i3 != 0) {
            if (i3 == 1) {
                boolean z4 = timePickerKt$onTap$2.Z$0;
                analogTimePickerState2 = timePickerKt$onTap$2.L$0;
                ResultKt.throwOnFailure(obj);
                z2 = z4;
                i = 1;
            } else {
                if (i3 != 2) {
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                z3 = timePickerKt$onTap$2.Z$0;
                analogTimePickerState2 = timePickerKt$onTap$2.L$0;
                ResultKt.throwOnFailure(obj);
                i = 1;
            }
            z2 = z3;
            if (z2) {
                analogTimePickerState2.mo242setSelection6_8s6DQ(i);
            }
            return unit;
        }
        ResultKt.throwOnFailure(obj);
        float fAtan2 = ((float) Math.atan2(f2 - ((int) (j & 4294967295L)), f - ((int) (j >> 32)))) - 1.5707964f;
        if (fAtan2 < CropImageView.DEFAULT_ASPECT_RATIO) {
            fAtan2 += 6.2831855f;
        }
        if (analogTimePickerState.state.mo241getSelectionyecRtBI() == 1) {
            f4 = 0.10471976f;
            fRint = ((float) Math.rint((fAtan2 / 0.10471976f) / 5.0f)) * 5.0f;
        } else {
            f4 = 0.5235988f;
            fRint = (float) Math.rint(fAtan2 / 0.5235988f);
        }
        float f5 = fRint * f4;
        m357moveSelectord3b8Pxo(analogTimePickerState, f, f2, f3, j);
        timePickerKt$onTap$2.L$0 = analogTimePickerState;
        z2 = z;
        timePickerKt$onTap$2.Z$0 = z2;
        timePickerKt$onTap$2.label = 1;
        analogTimePickerState.userOverride.value = Boolean.FALSE;
        i = 1;
        Object objMutate = analogTimePickerState.mutex.mutate(MutatePriority.UserInput, new AnalogTimePickerState$rotateTo$2(analogTimePickerState, f5, true, animationSpec, null), timePickerKt$onTap$2);
        if (objMutate != coroutineSingletons) {
            objMutate = unit;
        }
        if (objMutate != coroutineSingletons) {
            analogTimePickerState2 = analogTimePickerState;
        }
        return coroutineSingletons;
        if (analogTimePickerState2.state.mo241getSelectionyecRtBI() == 0 && z2) {
            timePickerKt$onTap$2.L$0 = analogTimePickerState2;
            timePickerKt$onTap$2.Z$0 = z2;
            timePickerKt$onTap$2.label = 2;
            if (AwaitKt.delay(100L, timePickerKt$onTap$2) != coroutineSingletons) {
                z3 = z2;
                z2 = z3;
            }
            return coroutineSingletons;
        }
        if (z2) {
            analogTimePickerState2.mo242setSelection6_8s6DQ(i);
        }
        return unit;
    }

    public static final TimePickerStateImpl rememberTimePickerState(final int i, final int i2, Composer composer, int i3) {
        Object[] objArr = new Object[0];
        CallbackWrapper callbackWrapper = new CallbackWrapper(new ScrollState$$ExternalSyntheticLambda3((byte) 20), new TextKt$$ExternalSyntheticLambda0((byte) 11), (byte) 7);
        boolean z = true;
        boolean z2 = ((((i3 & 14) ^ 6) > 4 && ((GapComposer) composer).changed(i)) || (i3 & 6) == 4) | ((((i3 & 112) ^ 48) > 32 && ((GapComposer) composer).changed(i2)) || (i3 & 48) == 32);
        if ((((i3 & 896) ^ 384) <= 256 || !((GapComposer) composer).changed(true)) && (i3 & 384) != 256) {
            z = false;
        }
        boolean z3 = z2 | z;
        GapComposer gapComposer = (GapComposer) composer;
        Object objRememberedValue = gapComposer.rememberedValue();
        if (z3 || objRememberedValue == Composer.Companion.Empty) {
            objRememberedValue = new Function0() { // from class: androidx.compose.material3.TimePickerKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return new TimePickerStateImpl(i, i2, 0, true);
                }
            };
            gapComposer.updateRememberedValue(objRememberedValue);
        }
        return (TimePickerStateImpl) SaverKt.m393rememberSaveable(objArr, (Saver) callbackWrapper, (Function0) objRememberedValue, (Composer) gapComposer, 0);
    }

    public static final TimeInputColors toTimeInputColors(TimePickerColors timePickerColors, Composer composer) {
        return new TimeInputColors(timePickerColors.containerColor, timePickerColors.periodSelectorBorderColor, timePickerColors.periodSelectorSelectedContainerColor, timePickerColors.periodSelectorContainerColor, timePickerColors.periodSelectorSelectedContentColor, timePickerColors.periodSelectorContentColor, TextFieldDefaults.m347colors0hiis_0(timePickerColors.timeSelectorSelectedContentColor, timePickerColors.timeSelectorContentColor, 0L, 0L, timePickerColors.timeSelectorSelectedContainerColor, timePickerColors.timeSelectorContainerColor, 0L, 0L, null, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composer, 3072, 2147483596, 4095));
    }
}
