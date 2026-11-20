package com.metrolist.music.ui.screens;

import android.content.Context;
import androidx.activity.OnBackPressedDispatcher$OnBackPressedEventInput$$ExternalSyntheticLambda0;
import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.compose.animation.AnimatedVisibilityScope;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.MarqueeSpacing$Companion$$ExternalSyntheticLambda0;
import androidx.compose.foundation.MutatePriority;
import androidx.compose.foundation.ScrollState$$ExternalSyntheticLambda0;
import androidx.compose.foundation.gestures.DefaultScrollableState;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.gestures.ScrollableKt;
import androidx.compose.foundation.gestures.ScrollableState;
import androidx.compose.foundation.interaction.MutableInteractionSourceImpl;
import androidx.compose.foundation.layout.Arrangement$SpacedAligned;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnMeasurePolicy;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.LayoutWeightElement;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowMeasurePolicy;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.lazy.LazyItemScopeImpl;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.foundation.text.TextFieldScrollKt$textFieldScrollable$2$wrappedScrollableState$1$1;
import androidx.compose.foundation.text.TextFieldScrollerPosition;
import androidx.compose.material3.AppBarKt$$ExternalSyntheticLambda8;
import androidx.compose.material3.BadgeKt$$ExternalSyntheticLambda4;
import androidx.compose.material3.CardKt;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.MaterialTheme$Values;
import androidx.compose.material3.MaterialThemeKt;
import androidx.compose.material3.ScrimKt;
import androidx.compose.material3.TextKt;
import androidx.compose.material3.TextKt$$ExternalSyntheticLambda3;
import androidx.compose.material3.TooltipKt$$ExternalSyntheticLambda5;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.DerivedSnapshotState;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.NeverEqualPolicy;
import androidx.compose.runtime.ParcelableSnapshotMutableIntState;
import androidx.compose.runtime.ParcelableSnapshotMutableState;
import androidx.compose.runtime.SnapshotStateKt__DerivedStateKt;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.State;
import androidx.compose.runtime.StaticProvidableCompositionLocal;
import androidx.compose.runtime.Updater$$ExternalSyntheticLambda0;
import androidx.compose.runtime.internal.PersistentCompositionLocalHashMap;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.BiasAlignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.ZIndexModifierKt;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.media3.common.Format$$ExternalSyntheticOutline0;
import coil3.compose.AsyncImageKt;
import com.google.common.math.IntMath;
import com.metrolist.innertube.models.YouTubeAccount;
import com.metrolist.music.constants.HistorySource;
import com.metrolist.music.ui.component.DialogKt;
import com.metrolist.music.ui.menu.PlayerMenuKt$$ExternalSyntheticLambda120;
import com.metrolist.music.ui.screens.equalizer.wizard.EQProfileVariant;
import com.metrolist.music.viewmodels.HistoryViewModel;
import com.yalantis.ucrop.R;
import com.yalantis.ucrop.view.CropImageView;
import io.ktor.http.MimesKt$$ExternalSyntheticLambda0;
import java.util.List;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.EmptyMap;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.math.MathKt;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class LoginScreenKt$$ExternalSyntheticLambda17 implements Function3 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ Object f$0;
    public final /* synthetic */ Object f$1;
    public final /* synthetic */ boolean f$2;

    public /* synthetic */ LoginScreenKt$$ExternalSyntheticLambda17(Object obj, boolean z, Object obj2, byte b) {
        this.$r8$classId = b;
        this.f$0 = obj;
        this.f$2 = z;
        this.f$1 = obj2;
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        int i;
        boolean z;
        List listListOf;
        boolean z2;
        int i2;
        int i3;
        boolean z3;
        boolean z4;
        boolean z5;
        long j;
        boolean z6;
        long j2;
        byte b = this.$r8$classId;
        boolean z7 = this.f$2;
        NeverEqualPolicy neverEqualPolicy = Composer.Companion.Empty;
        Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda0 = ComposeUiNode.Companion.SetModifier;
        Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda1 = ComposeUiNode.Companion.SetCompositeKeyHash;
        Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda2 = ComposeUiNode.Companion.SetResolvedCompositionLocals;
        Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda3 = ComposeUiNode.Companion.SetMeasurePolicy;
        TextKt$$ExternalSyntheticLambda3 textKt$$ExternalSyntheticLambda3 = LayoutNode.Constructor;
        Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
        Unit unit = Unit.INSTANCE;
        Object obj4 = this.f$1;
        Object obj5 = this.f$0;
        switch (b) {
            case 0:
                Function0 function0 = (Function0) obj5;
                YouTubeAccount youTubeAccount = (YouTubeAccount) obj4;
                Composer composer = (Composer) obj2;
                int iIntValue = ((Integer) obj3).intValue();
                ((ColumnScopeInstance) obj).getClass();
                GapComposer gapComposer = (GapComposer) composer;
                if (gapComposer.shouldExecute(iIntValue & 1, (iIntValue & 17) != 16)) {
                    Modifier modifierM135padding3ABfNKs = OffsetKt.m135padding3ABfNKs(ImageKt.m46clickableoSLSa3U$default(SizeKt.fillMaxWidth(companion, 1.0f), false, null, function0, 15), 12.0f);
                    RowMeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(OffsetKt.Start, Alignment.Companion.CenterVertically, gapComposer, 48);
                    int iHashCode = Long.hashCode(gapComposer.compositeKeyHashCode);
                    PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope = gapComposer.currentCompositionLocalScope();
                    Modifier modifierMaterializeModifier = ZIndexModifierKt.materializeModifier(gapComposer, modifierM135padding3ABfNKs);
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
                    if (youTubeAccount.thumbnailUrl != null) {
                        gapComposer.startReplaceGroup(742024605);
                        AsyncImageKt.m849AsyncImage10Xjiaw(youTubeAccount.thumbnailUrl, ClipKt.clip(SizeKt.m151size3ABfNKs(companion, 40.0f), RoundedCornerShapeKt.CircleShape), ContentScale.Companion.Crop, gapComposer, 1572912, 1976);
                        i = 0;
                        gapComposer.end(false);
                    } else {
                        i = 0;
                        gapComposer.startReplaceGroup(742371340);
                        IconKt.m290Iconww6aTOc(IntMath.painterResource(R.drawable.account, 0, gapComposer), (String) null, SizeKt.m151size3ABfNKs(companion, 40.0f), 0L, gapComposer, 440, 8);
                        gapComposer.end(false);
                    }
                    OffsetKt.Spacer(gapComposer, SizeKt.m155width3ABfNKs(companion, 12.0f));
                    LayoutWeightElement layoutWeightElement = new LayoutWeightElement(1.0f, true);
                    ColumnMeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(OffsetKt.Top, Alignment.Companion.Start, gapComposer, i);
                    int iHashCode2 = Long.hashCode(gapComposer.compositeKeyHashCode);
                    PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope2 = gapComposer.currentCompositionLocalScope();
                    Modifier modifierMaterializeModifier2 = ZIndexModifierKt.materializeModifier(gapComposer, layoutWeightElement);
                    gapComposer.startReusableNode();
                    if (gapComposer.inserting) {
                        gapComposer.createNode(textKt$$ExternalSyntheticLambda3);
                    } else {
                        gapComposer.useNode();
                    }
                    Stack.m390setimpl(gapComposer, columnMeasurePolicy, updater$$ExternalSyntheticLambda3);
                    Stack.m390setimpl(gapComposer, persistentCompositionLocalHashMapCurrentCompositionLocalScope2, updater$$ExternalSyntheticLambda2);
                    IntIntPair$$ExternalSyntheticOutline0.m(iHashCode2, gapComposer, updater$$ExternalSyntheticLambda1, gapComposer);
                    Stack.m390setimpl(gapComposer, modifierMaterializeModifier2, updater$$ExternalSyntheticLambda0);
                    String str = youTubeAccount.name;
                    StaticProvidableCompositionLocal staticProvidableCompositionLocal = MaterialThemeKt._localMaterialTheme;
                    TextKt.m352TextNvy7gAk(str, null, 0L, 0L, null, null, null, 0L, null, 0L, 2, false, 1, 0, ((MaterialTheme$Values) gapComposer.consume(staticProvidableCompositionLocal)).typography.bodyLarge, gapComposer, 0, 24960, 110590);
                    String str2 = youTubeAccount.channelHandle;
                    if (str2 == null) {
                        gapComposer.startReplaceGroup(-474584196);
                        z = false;
                        gapComposer.end(false);
                    } else {
                        gapComposer.startReplaceGroup(-474584195);
                        TextKt.m352TextNvy7gAk(str2, null, ((MaterialTheme$Values) gapComposer.consume(staticProvidableCompositionLocal)).colorScheme.onSurfaceVariant, 0L, null, null, null, 0L, null, 0L, 2, false, 1, 0, ((MaterialTheme$Values) gapComposer.consume(staticProvidableCompositionLocal)).typography.bodyMedium, gapComposer, 0, 24960, 110586);
                        z = false;
                        gapComposer.end(false);
                    }
                    String str3 = youTubeAccount.byline;
                    if (str3 == null) {
                        gapComposer.startReplaceGroup(-474179894);
                        gapComposer.end(z);
                    } else {
                        gapComposer.startReplaceGroup(-474179893);
                        TextKt.m352TextNvy7gAk(str3, null, ((MaterialTheme$Values) gapComposer.consume(staticProvidableCompositionLocal)).colorScheme.onSurfaceVariant, 0L, null, null, null, 0L, null, 0L, 2, false, 1, 0, ((MaterialTheme$Values) gapComposer.consume(staticProvidableCompositionLocal)).typography.bodyMedium, gapComposer, 0, 24960, 110586);
                        gapComposer.end(false);
                    }
                    gapComposer.end(true);
                    ScrimKt.RadioButton(this.f$2, null, null, false, null, gapComposer, 48);
                    gapComposer.end(true);
                } else {
                    gapComposer.skipToGroupEnd();
                }
                return unit;
            case 1:
                TextFieldScrollerPosition textFieldScrollerPosition = (TextFieldScrollerPosition) obj5;
                ParcelableSnapshotMutableState parcelableSnapshotMutableState = textFieldScrollerPosition.orientation$delegate;
                MutableInteractionSourceImpl mutableInteractionSourceImpl = (MutableInteractionSourceImpl) obj4;
                ((Integer) obj3).getClass();
                GapComposer gapComposer2 = (GapComposer) ((Composer) obj2);
                gapComposer2.startReplaceGroup(-2137546592);
                boolean z8 = ((Orientation) parcelableSnapshotMutableState.getValue()) == Orientation.Vertical || !(gapComposer2.consume(CompositionLocalsKt.LocalLayoutDirection) == LayoutDirection.Rtl);
                boolean zChanged = gapComposer2.changed(textFieldScrollerPosition);
                Object objRememberedValue = gapComposer2.rememberedValue();
                if (zChanged || objRememberedValue == neverEqualPolicy) {
                    objRememberedValue = new ScrollState$$ExternalSyntheticLambda0((byte) 22, textFieldScrollerPosition);
                    gapComposer2.updateRememberedValue(objRememberedValue);
                }
                MutableState mutableStateRememberUpdatedState = Stack.rememberUpdatedState((Function1) objRememberedValue, gapComposer2);
                Object objRememberedValue2 = gapComposer2.rememberedValue();
                if (objRememberedValue2 == neverEqualPolicy) {
                    DefaultScrollableState defaultScrollableState = new DefaultScrollableState(new TooltipKt$$ExternalSyntheticLambda5(mutableStateRememberUpdatedState, (byte) 2));
                    gapComposer2.updateRememberedValue(defaultScrollableState);
                    objRememberedValue2 = defaultScrollableState;
                }
                ScrollableState scrollableState = (ScrollableState) objRememberedValue2;
                boolean zChanged2 = gapComposer2.changed(scrollableState) | gapComposer2.changed(textFieldScrollerPosition);
                Object objRememberedValue3 = gapComposer2.rememberedValue();
                if (zChanged2 || objRememberedValue3 == neverEqualPolicy) {
                    objRememberedValue3 = new ScrollableState(textFieldScrollerPosition) { // from class: androidx.compose.foundation.text.TextFieldScrollKt$textFieldScrollable$2$wrappedScrollableState$1$1
                        public final DerivedSnapshotState canScrollBackward$delegate;
                        public final DerivedSnapshotState canScrollForward$delegate;

                        {
                            final byte b2 = 0;
                            this.canScrollForward$delegate = SnapshotStateKt__DerivedStateKt.derivedStateOf(new Function0() { // from class: androidx.compose.foundation.text.TextFieldScrollKt$textFieldScrollable$2$wrappedScrollableState$1$1$$ExternalSyntheticLambda0
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    byte b3 = b2;
                                    TextFieldScrollerPosition textFieldScrollerPosition2 = textFieldScrollerPosition;
                                    switch (b3) {
                                        case 0:
                                            return Boolean.valueOf(textFieldScrollerPosition2.offset$delegate.getFloatValue() < textFieldScrollerPosition2.maximum$delegate.getFloatValue());
                                        default:
                                            return Boolean.valueOf(textFieldScrollerPosition2.offset$delegate.getFloatValue() > CropImageView.DEFAULT_ASPECT_RATIO);
                                    }
                                }
                            });
                            final byte b3 = 1;
                            this.canScrollBackward$delegate = SnapshotStateKt__DerivedStateKt.derivedStateOf(new Function0() { // from class: androidx.compose.foundation.text.TextFieldScrollKt$textFieldScrollable$2$wrappedScrollableState$1$1$$ExternalSyntheticLambda0
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    byte b4 = b3;
                                    TextFieldScrollerPosition textFieldScrollerPosition2 = textFieldScrollerPosition;
                                    switch (b4) {
                                        case 0:
                                            return Boolean.valueOf(textFieldScrollerPosition2.offset$delegate.getFloatValue() < textFieldScrollerPosition2.maximum$delegate.getFloatValue());
                                        default:
                                            return Boolean.valueOf(textFieldScrollerPosition2.offset$delegate.getFloatValue() > CropImageView.DEFAULT_ASPECT_RATIO);
                                    }
                                }
                            });
                        }

                        @Override // androidx.compose.foundation.gestures.ScrollableState
                        public final float dispatchRawDelta(float f) {
                            return this.$$delegate_0.dispatchRawDelta(f);
                        }

                        @Override // androidx.compose.foundation.gestures.ScrollableState
                        public final boolean getCanScrollBackward() {
                            return ((Boolean) this.canScrollBackward$delegate.getValue()).booleanValue();
                        }

                        @Override // androidx.compose.foundation.gestures.ScrollableState
                        public final boolean getCanScrollForward() {
                            return ((Boolean) this.canScrollForward$delegate.getValue()).booleanValue();
                        }

                        @Override // androidx.compose.foundation.gestures.ScrollableState
                        public final boolean isScrollInProgress() {
                            return this.$$delegate_0.isScrollInProgress();
                        }

                        @Override // androidx.compose.foundation.gestures.ScrollableState
                        public final Object scroll(MutatePriority mutatePriority, Function2 function2, ContinuationImpl continuationImpl) {
                            return this.$$delegate_0.scroll(mutatePriority, function2, continuationImpl);
                        }
                    };
                    gapComposer2.updateRememberedValue(objRememberedValue3);
                }
                Modifier modifierScrollable$default = ScrollableKt.scrollable$default((TextFieldScrollKt$textFieldScrollable$2$wrappedScrollableState$1$1) objRememberedValue3, (Orientation) parcelableSnapshotMutableState.getValue(), z7 && textFieldScrollerPosition.maximum$delegate.getFloatValue() != CropImageView.DEFAULT_ASPECT_RATIO, z8, mutableInteractionSourceImpl);
                gapComposer2.end(false);
                return modifierScrollable$default;
            case 2:
                MeasureScope measureScope = (MeasureScope) obj;
                Measurable measurable = (Measurable) obj2;
                Constraints constraints = (Constraints) obj3;
                int iM792constrainWidthK40F9xA = ConstraintsKt.m792constrainWidthK40F9xA(((ParcelableSnapshotMutableIntState) obj5).getIntValue(), constraints.value);
                long j3 = constraints.value;
                int iM791constrainHeightK40F9xA = ConstraintsKt.m791constrainHeightK40F9xA(((ParcelableSnapshotMutableIntState) obj4).getIntValue(), j3);
                int iM786getMinWidthimpl = z7 ? iM792constrainWidthK40F9xA : Constraints.m786getMinWidthimpl(j3);
                if (!z7) {
                    iM792constrainWidthK40F9xA = Constraints.m784getMaxWidthimpl(j3);
                }
                Placeable placeableMo598measureBRTryo0 = measurable.mo598measureBRTryo0(Constraints.m777copyZbe2FdA$default(iM786getMinWidthimpl, iM792constrainWidthK40F9xA, 0, iM791constrainHeightK40F9xA, 4, constraints.value));
                return measureScope.layout(placeableMo598measureBRTryo0.width, placeableMo598measureBRTryo0.height, EmptyMap.INSTANCE, new BadgeKt$$ExternalSyntheticLambda4(placeableMo598measureBRTryo0, (byte) 17));
            case 3:
                Function0 function1 = (Function0) obj5;
                Function0 function2 = (Function0) obj4;
                Composer composer2 = (Composer) obj2;
                int iIntValue2 = ((Integer) obj3).intValue();
                ((AnimatedVisibilityScope) obj).getClass();
                GapComposer gapComposer3 = (GapComposer) composer2;
                if (gapComposer3.shouldExecute(iIntValue2 & 1, (iIntValue2 & 17) != 16)) {
                    RowMeasurePolicy rowMeasurePolicy2 = RowKt.rowMeasurePolicy(new Arrangement$SpacedAligned(8.0f, true, new MarqueeSpacing$Companion$$ExternalSyntheticLambda0((byte) 5)), Alignment.Companion.CenterVertically, gapComposer3, 54);
                    int iHashCode3 = Long.hashCode(gapComposer3.compositeKeyHashCode);
                    PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope3 = gapComposer3.currentCompositionLocalScope();
                    Modifier modifierMaterializeModifier3 = ZIndexModifierKt.materializeModifier(gapComposer3, companion);
                    ComposeUiNode.Companion.getClass();
                    gapComposer3.startReusableNode();
                    if (gapComposer3.inserting) {
                        gapComposer3.createNode(textKt$$ExternalSyntheticLambda3);
                    } else {
                        gapComposer3.useNode();
                    }
                    Stack.m390setimpl(gapComposer3, rowMeasurePolicy2, updater$$ExternalSyntheticLambda3);
                    Stack.m390setimpl(gapComposer3, persistentCompositionLocalHashMapCurrentCompositionLocalScope3, updater$$ExternalSyntheticLambda2);
                    Stack.m390setimpl(gapComposer3, Integer.valueOf(iHashCode3), updater$$ExternalSyntheticLambda1);
                    Stack.m389reconcileimpl(gapComposer3);
                    Stack.m390setimpl(gapComposer3, modifierMaterializeModifier3, updater$$ExternalSyntheticLambda0);
                    CardKt.FilledTonalButton(function1, null, false, null, null, null, null, DialogKt.f22lambda$1695936880, gapComposer3, 805306368, 510);
                    CardKt.FilledTonalButton(function2, null, this.f$2, null, null, null, null, DialogKt.f26lambda$2095624441, gapComposer3, 805306368, 506);
                    gapComposer3.end(true);
                } else {
                    gapComposer3.skipToGroupEnd();
                }
                return unit;
            case 4:
                HistoryViewModel historyViewModel = (HistoryViewModel) obj5;
                State state = (State) obj4;
                Composer composer3 = (Composer) obj2;
                int iIntValue3 = ((Integer) obj3).intValue();
                ((LazyItemScopeImpl) obj).getClass();
                GapComposer gapComposer4 = (GapComposer) composer3;
                if (gapComposer4.shouldExecute(iIntValue3 & 1, (iIntValue3 & 17) != 16)) {
                    HistorySource historySource = HistorySource.LOCAL;
                    if (z7) {
                        gapComposer4.startReplaceGroup(-1044491337);
                        listListOf = CollectionsKt__IterablesKt.listOf((Object[]) new Pair[]{new Pair(historySource, MathKt.stringResource(R.string.local_history, gapComposer4)), new Pair(HistorySource.REMOTE, MathKt.stringResource(R.string.remote_history, gapComposer4))});
                        gapComposer4.end(false);
                    } else {
                        gapComposer4.startReplaceGroup(-1044207625);
                        listListOf = CollectionsKt__IterablesKt.listOf(new Pair(historySource, MathKt.stringResource(R.string.local_history, gapComposer4)));
                        gapComposer4.end(false);
                    }
                    List list = listListOf;
                    HistorySource historySource2 = (HistorySource) state.getValue();
                    boolean zChangedInstance = gapComposer4.changedInstance(historyViewModel);
                    Object objRememberedValue4 = gapComposer4.rememberedValue();
                    if (zChangedInstance || objRememberedValue4 == neverEqualPolicy) {
                        objRememberedValue4 = new MimesKt$$ExternalSyntheticLambda0((byte) 8, historyViewModel);
                        gapComposer4.updateRememberedValue(objRememberedValue4);
                    }
                    DialogKt.m1461ChipsRowyrwZFoE(list, historySource2, (Function1) objRememberedValue4, null, 0L, gapComposer4, 0, 24);
                } else {
                    gapComposer4.skipToGroupEnd();
                }
                return unit;
            case 5:
                String str4 = (String) obj5;
                Context context = (Context) obj4;
                Composer composer4 = (Composer) obj2;
                int iIntValue4 = ((Integer) obj3).intValue();
                ((ColumnScopeInstance) obj).getClass();
                GapComposer gapComposer5 = (GapComposer) composer4;
                if (gapComposer5.shouldExecute(iIntValue4 & 1, (iIntValue4 & 17) != 16)) {
                    Modifier modifierM135padding3ABfNKs2 = OffsetKt.m135padding3ABfNKs(SizeKt.fillMaxWidth(companion, 1.0f), 24.0f);
                    BiasAlignment.Horizontal horizontal = Alignment.Companion.CenterHorizontally;
                    ColumnMeasurePolicy columnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(OffsetKt.Top, horizontal, gapComposer5, 48);
                    int iHashCode4 = Long.hashCode(gapComposer5.compositeKeyHashCode);
                    PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope4 = gapComposer5.currentCompositionLocalScope();
                    Modifier modifierMaterializeModifier4 = ZIndexModifierKt.materializeModifier(gapComposer5, modifierM135padding3ABfNKs2);
                    ComposeUiNode.Companion.getClass();
                    gapComposer5.startReusableNode();
                    if (gapComposer5.inserting) {
                        gapComposer5.createNode(textKt$$ExternalSyntheticLambda3);
                    } else {
                        gapComposer5.useNode();
                    }
                    Stack.m390setimpl(gapComposer5, columnMeasurePolicy2, updater$$ExternalSyntheticLambda3);
                    Stack.m390setimpl(gapComposer5, persistentCompositionLocalHashMapCurrentCompositionLocalScope4, updater$$ExternalSyntheticLambda2);
                    Stack.m390setimpl(gapComposer5, Integer.valueOf(iHashCode4), updater$$ExternalSyntheticLambda1);
                    Stack.m389reconcileimpl(gapComposer5);
                    Stack.m390setimpl(gapComposer5, modifierMaterializeModifier4, updater$$ExternalSyntheticLambda0);
                    String strStringResource = MathKt.stringResource(R.string.room_code, gapComposer5);
                    StaticProvidableCompositionLocal staticProvidableCompositionLocal2 = MaterialThemeKt._localMaterialTheme;
                    TextKt.m352TextNvy7gAk(strStringResource, null, ((MaterialTheme$Values) gapComposer5.consume(staticProvidableCompositionLocal2)).colorScheme.onSurfaceVariant, 0L, null, null, null, 0L, new TextAlign(3), 0L, 0, false, 0, 0, ((MaterialTheme$Values) gapComposer5.consume(staticProvidableCompositionLocal2)).typography.labelLarge, gapComposer5, 0, 0, 130042);
                    OffsetKt.Spacer(gapComposer5, SizeKt.m145height3ABfNKs(companion, 8.0f));
                    TextKt.m352TextNvy7gAk(str4, null, ((MaterialTheme$Values) gapComposer5.consume(staticProvidableCompositionLocal2)).colorScheme.primary, 0L, null, FontWeight.Bold, null, IntMath.getSp(6), new TextAlign(3), 0L, 0, false, 0, 0, ((MaterialTheme$Values) gapComposer5.consume(staticProvidableCompositionLocal2)).typography.displaySmall, gapComposer5, 102236160, 0, 129722);
                    OffsetKt.Spacer(gapComposer5, SizeKt.m145height3ABfNKs(companion, 4.0f));
                    if (z7) {
                        i2 = 827159719;
                        i3 = R.string.listen_together_you_are_host;
                        z2 = false;
                    } else {
                        z2 = false;
                        i2 = 827265894;
                        i3 = R.string.listen_together_you_are_guest;
                    }
                    TextKt.m352TextNvy7gAk(Format$$ExternalSyntheticOutline0.m(gapComposer5, i2, i3, gapComposer5, z2), null, ((MaterialTheme$Values) gapComposer5.consume(staticProvidableCompositionLocal2)).colorScheme.onSurfaceVariant, 0L, null, null, null, 0L, new TextAlign(3), 0L, 0, false, 0, 0, ((MaterialTheme$Values) gapComposer5.consume(staticProvidableCompositionLocal2)).typography.bodyMedium, gapComposer5, 0, 0, 130042);
                    if (z7) {
                        gapComposer5.startReplaceGroup(827658695);
                        OffsetKt.Spacer(gapComposer5, SizeKt.m145height3ABfNKs(companion, 16.0f));
                        boolean zChanged3 = gapComposer5.changed(str4);
                        Object objRememberedValue5 = gapComposer5.rememberedValue();
                        if (zChanged3 || objRememberedValue5 == neverEqualPolicy) {
                            objRememberedValue5 = "https://metrolist.cc/listen?code=".concat(str4);
                            gapComposer5.updateRememberedValue(objRememberedValue5);
                        }
                        String str5 = (String) objRememberedValue5;
                        BiasAlignment.Vertical vertical = Alignment.Companion.CenterVertically;
                        Arrangement$SpacedAligned arrangement$SpacedAligned = new Arrangement$SpacedAligned(8.0f, true, new OnBackPressedDispatcher$OnBackPressedEventInput$$ExternalSyntheticLambda0((byte) 2, horizontal));
                        Modifier modifierFillMaxWidth = SizeKt.fillMaxWidth(companion, 1.0f);
                        RowMeasurePolicy rowMeasurePolicy3 = RowKt.rowMeasurePolicy(arrangement$SpacedAligned, vertical, gapComposer5, 54);
                        int iHashCode5 = Long.hashCode(gapComposer5.compositeKeyHashCode);
                        PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope5 = gapComposer5.currentCompositionLocalScope();
                        Modifier modifierMaterializeModifier5 = ZIndexModifierKt.materializeModifier(gapComposer5, modifierFillMaxWidth);
                        gapComposer5.startReusableNode();
                        if (gapComposer5.inserting) {
                            gapComposer5.createNode(textKt$$ExternalSyntheticLambda3);
                        } else {
                            gapComposer5.useNode();
                        }
                        Stack.m390setimpl(gapComposer5, rowMeasurePolicy3, updater$$ExternalSyntheticLambda3);
                        Stack.m390setimpl(gapComposer5, persistentCompositionLocalHashMapCurrentCompositionLocalScope5, updater$$ExternalSyntheticLambda2);
                        IntIntPair$$ExternalSyntheticOutline0.m(iHashCode5, gapComposer5, updater$$ExternalSyntheticLambda1, gapComposer5);
                        Stack.m390setimpl(gapComposer5, modifierMaterializeModifier5, updater$$ExternalSyntheticLambda0);
                        boolean zChangedInstance2 = gapComposer5.changedInstance(context) | gapComposer5.changed(str5);
                        Object objRememberedValue6 = gapComposer5.rememberedValue();
                        if (zChangedInstance2 || objRememberedValue6 == neverEqualPolicy) {
                            objRememberedValue6 = new PlayerMenuKt$$ExternalSyntheticLambda120(context, str5, (byte) 2);
                            gapComposer5.updateRememberedValue(objRememberedValue6);
                        }
                        CardKt.Button((Function0) objRememberedValue6, null, false, RoundedCornerShapeKt.m185RoundedCornerShape0680j_4(12.0f), null, null, null, null, null, AlbumScreenKt.f310lambda$1682156345, gapComposer5, 805306368, 502);
                        boolean zChangedInstance3 = gapComposer5.changedInstance(context) | gapComposer5.changed(str4);
                        Object objRememberedValue7 = gapComposer5.rememberedValue();
                        if (zChangedInstance3 || objRememberedValue7 == neverEqualPolicy) {
                            objRememberedValue7 = new PlayerMenuKt$$ExternalSyntheticLambda120(context, str4, (byte) 3);
                            gapComposer5.updateRememberedValue(objRememberedValue7);
                        }
                        CardKt.Button((Function0) objRememberedValue7, null, false, RoundedCornerShapeKt.m185RoundedCornerShape0680j_4(12.0f), null, null, null, null, null, AlbumScreenKt.f334lambda$881833296, gapComposer5, 805306368, 502);
                        z3 = true;
                        gapComposer5.end(true);
                        gapComposer5.end(false);
                    } else {
                        z3 = true;
                        gapComposer5.startReplaceGroup(830154412);
                        gapComposer5.end(false);
                    }
                    gapComposer5.end(z3);
                } else {
                    gapComposer5.skipToGroupEnd();
                }
                return unit;
            default:
                Function0 function3 = (Function0) obj5;
                EQProfileVariant eQProfileVariant = (EQProfileVariant) obj4;
                Composer composer5 = (Composer) obj2;
                int iIntValue5 = ((Integer) obj3).intValue();
                ((ColumnScopeInstance) obj).getClass();
                GapComposer gapComposer6 = (GapComposer) composer5;
                if (gapComposer6.shouldExecute(iIntValue5 & 1, (iIntValue5 & 17) != 16)) {
                    Modifier modifierM135padding3ABfNKs3 = OffsetKt.m135padding3ABfNKs(SizeKt.fillMaxWidth(companion, 1.0f), 16.0f);
                    RowMeasurePolicy rowMeasurePolicy4 = RowKt.rowMeasurePolicy(OffsetKt.Start, Alignment.Companion.CenterVertically, gapComposer6, 48);
                    int iHashCode6 = Long.hashCode(gapComposer6.compositeKeyHashCode);
                    PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope6 = gapComposer6.currentCompositionLocalScope();
                    Modifier modifierMaterializeModifier6 = ZIndexModifierKt.materializeModifier(gapComposer6, modifierM135padding3ABfNKs3);
                    ComposeUiNode.Companion.getClass();
                    gapComposer6.startReusableNode();
                    if (gapComposer6.inserting) {
                        gapComposer6.createNode(textKt$$ExternalSyntheticLambda3);
                    } else {
                        gapComposer6.useNode();
                    }
                    Stack.m390setimpl(gapComposer6, rowMeasurePolicy4, updater$$ExternalSyntheticLambda3);
                    Stack.m390setimpl(gapComposer6, persistentCompositionLocalHashMapCurrentCompositionLocalScope6, updater$$ExternalSyntheticLambda2);
                    Stack.m390setimpl(gapComposer6, Integer.valueOf(iHashCode6), updater$$ExternalSyntheticLambda1);
                    Stack.m389reconcileimpl(gapComposer6);
                    Stack.m390setimpl(gapComposer6, modifierMaterializeModifier6, updater$$ExternalSyntheticLambda0);
                    boolean zChanged4 = gapComposer6.changed(function3);
                    Object objRememberedValue8 = gapComposer6.rememberedValue();
                    if (zChanged4 || objRememberedValue8 == neverEqualPolicy) {
                        objRememberedValue8 = new AppBarKt$$ExternalSyntheticLambda8(function3, (byte) 12);
                        gapComposer6.updateRememberedValue(objRememberedValue8);
                    }
                    boolean z9 = this.f$2;
                    CardKt.Checkbox(z9, (Function1) objRememberedValue8, null, false, null, gapComposer6, 0);
                    OffsetKt.Spacer(gapComposer6, SizeKt.m155width3ABfNKs(companion, 12.0f));
                    LayoutWeightElement layoutWeightElement2 = new LayoutWeightElement(1.0f, true);
                    ColumnMeasurePolicy columnMeasurePolicy3 = ColumnKt.columnMeasurePolicy(OffsetKt.Top, Alignment.Companion.Start, gapComposer6, 0);
                    int iHashCode7 = Long.hashCode(gapComposer6.compositeKeyHashCode);
                    PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope7 = gapComposer6.currentCompositionLocalScope();
                    Modifier modifierMaterializeModifier7 = ZIndexModifierKt.materializeModifier(gapComposer6, layoutWeightElement2);
                    gapComposer6.startReusableNode();
                    if (gapComposer6.inserting) {
                        gapComposer6.createNode(textKt$$ExternalSyntheticLambda3);
                    } else {
                        gapComposer6.useNode();
                    }
                    Stack.m390setimpl(gapComposer6, columnMeasurePolicy3, updater$$ExternalSyntheticLambda3);
                    Stack.m390setimpl(gapComposer6, persistentCompositionLocalHashMapCurrentCompositionLocalScope7, updater$$ExternalSyntheticLambda2);
                    IntIntPair$$ExternalSyntheticOutline0.m(iHashCode7, gapComposer6, updater$$ExternalSyntheticLambda1, gapComposer6);
                    Stack.m390setimpl(gapComposer6, modifierMaterializeModifier7, updater$$ExternalSyntheticLambda0);
                    StringBuilder sb = new StringBuilder();
                    sb.append(eQProfileVariant.name);
                    String str6 = eQProfileVariant.variant;
                    if (str6 != null) {
                        sb.append(" - ".concat(str6));
                    }
                    if (eQProfileVariant.isANC) {
                        sb.append(" (ANC)");
                    } else if (eQProfileVariant.isPadModified) {
                        sb.append(" (Velour pads)");
                    }
                    String strSubstringBefore$default = StringsKt.substringBefore$default(sb.toString(), " - ");
                    StaticProvidableCompositionLocal staticProvidableCompositionLocal3 = MaterialThemeKt._localMaterialTheme;
                    TextKt.m352TextNvy7gAk(strSubstringBefore$default, null, 0L, 0L, null, z9 ? FontWeight.SemiBold : FontWeight.Normal, null, 0L, null, 0L, 0, false, 0, 0, ((MaterialTheme$Values) gapComposer6.consume(staticProvidableCompositionLocal3)).typography.titleMedium, gapComposer6, 0, 0, 131006);
                    if (eQProfileVariant.getSourceDisplay().length() <= 0 && eQProfileVariant.getRigDisplay().length() <= 0) {
                        gapComposer6.startReplaceGroup(1184086042);
                        gapComposer6.end(false);
                    } else {
                        gapComposer6.startReplaceGroup(1183217298);
                        OffsetKt.Spacer(gapComposer6, SizeKt.m145height3ABfNKs(companion, 4.0f));
                        if (eQProfileVariant.getSourceDisplay().length() > 0) {
                            gapComposer6.startReplaceGroup(1183346568);
                            String sourceDisplay = eQProfileVariant.getSourceDisplay();
                            TextStyle textStyle = ((MaterialTheme$Values) gapComposer6.consume(staticProvidableCompositionLocal3)).typography.bodySmall;
                            if (z9) {
                                gapComposer6.startReplaceGroup(176726362);
                                j2 = ((MaterialTheme$Values) gapComposer6.consume(staticProvidableCompositionLocal3)).colorScheme.onPrimaryContainer;
                                z6 = false;
                            } else {
                                z6 = false;
                                gapComposer6.startReplaceGroup(176727960);
                                j2 = ((MaterialTheme$Values) gapComposer6.consume(staticProvidableCompositionLocal3)).colorScheme.onSurfaceVariant;
                            }
                            gapComposer6.end(z6);
                            TextKt.m352TextNvy7gAk(sourceDisplay, null, j2, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, textStyle, gapComposer6, 0, 0, 131066);
                            gapComposer6.end(false);
                        } else {
                            gapComposer6.startReplaceGroup(1183662458);
                            gapComposer6.end(false);
                        }
                        if (eQProfileVariant.getRigDisplay().length() > 0) {
                            gapComposer6.startReplaceGroup(1183755179);
                            String rigDisplay = eQProfileVariant.getRigDisplay();
                            TextStyle textStyle2 = ((MaterialTheme$Values) gapComposer6.consume(staticProvidableCompositionLocal3)).typography.bodySmall;
                            if (z9) {
                                gapComposer6.startReplaceGroup(176739450);
                                j = ((MaterialTheme$Values) gapComposer6.consume(staticProvidableCompositionLocal3)).colorScheme.onPrimaryContainer;
                                z5 = false;
                            } else {
                                z5 = false;
                                gapComposer6.startReplaceGroup(176741048);
                                j = ((MaterialTheme$Values) gapComposer6.consume(staticProvidableCompositionLocal3)).colorScheme.onSurfaceVariant;
                            }
                            gapComposer6.end(z5);
                            TextKt.m352TextNvy7gAk(rigDisplay, null, j, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, textStyle2, gapComposer6, 0, 0, 131066);
                            z4 = false;
                            gapComposer6.end(false);
                        } else {
                            z4 = false;
                            gapComposer6.startReplaceGroup(1184068186);
                            gapComposer6.end(false);
                        }
                        gapComposer6.end(z4);
                    }
                    gapComposer6.end(true);
                    gapComposer6.end(true);
                } else {
                    gapComposer6.skipToGroupEnd();
                }
                return unit;
        }
    }

    public /* synthetic */ LoginScreenKt$$ExternalSyntheticLambda17(Function0 function0, Object obj, boolean z, byte b) {
        this.$r8$classId = b;
        this.f$0 = function0;
        this.f$1 = obj;
        this.f$2 = z;
    }

    public /* synthetic */ LoginScreenKt$$ExternalSyntheticLambda17(boolean z, Object obj, Object obj2, byte b) {
        this.$r8$classId = b;
        this.f$2 = z;
        this.f$0 = obj;
        this.f$1 = obj2;
    }
}
