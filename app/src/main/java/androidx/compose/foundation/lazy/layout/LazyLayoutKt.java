package androidx.compose.foundation.lazy.layout;

import android.os.Build;
import android.view.View;
import androidx.activity.compose.BackHandlerKt$$ExternalSyntheticLambda2;
import androidx.collection.IntListKt;
import androidx.collection.MutableIntList;
import androidx.collection.internal.Lock;
import androidx.compose.foundation.ScrollState$$ExternalSyntheticLambda0;
import androidx.compose.foundation.ScrollState$$ExternalSyntheticLambda3;
import androidx.compose.foundation.gestures.BringIntoViewSpec;
import androidx.compose.foundation.gestures.BringIntoViewSpec_androidKt;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.internal.InlineClassHelperKt;
import androidx.compose.foundation.pager.PagerScrollScopeKt$LazyLayoutScrollScope$1;
import androidx.compose.material3.ButtonKt$$ExternalSyntheticLambda1;
import androidx.compose.material3.CardKt$$ExternalSyntheticLambda1;
import androidx.compose.material3.SnackbarHostKt$$ExternalSyntheticLambda7;
import androidx.compose.material3.TimePickerKt$$ExternalSyntheticLambda0;
import androidx.compose.material3.TimePickerKt$$ExternalSyntheticLambda2;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.Latch;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.NeverEqualPolicy;
import androidx.compose.runtime.ParcelableSnapshotMutableState;
import androidx.compose.runtime.RecomposeScopeImpl;
import androidx.compose.runtime.Recomposer$$ExternalSyntheticLambda6;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.StaticProvidableCompositionLocal;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableList.AbstractPersistentList;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.runtime.internal.Expect_jvmKt;
import androidx.compose.runtime.saveable.SaveableStateHolder;
import androidx.compose.runtime.saveable.SaveableStateHolderImpl;
import androidx.compose.runtime.saveable.SaveableStateRegistry;
import androidx.compose.runtime.saveable.SaveableStateRegistryKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.runtime.saveable.SaverKt;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.runtime.snapshots.SnapshotId_jvmKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.PinnableContainerKt;
import androidx.compose.ui.layout.RulerKt;
import androidx.compose.ui.layout.SubcomposeLayoutState;
import androidx.compose.ui.node.LayoutNode$$ExternalSyntheticLambda1;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.window.AndroidPopup_androidKt$Popup$lambda$3$0$$inlined$onDispose$1;
import androidx.core.provider.CallbackWrapper;
import com.metrolist.music.MainActivity$$ExternalSyntheticLambda29;
import com.yalantis.ucrop.R;
import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__MutableCollectionsJVMKt;
import kotlin.collections.EmptyList;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.ranges.IntRange;
import kotlin.reflect.KProperty0;
import kotlin.uuid.UuidKt;
import okhttp3.internal.http.StatusLine;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class LazyLayoutKt {
    public static final LazyLayoutItemAnimation[] EmptyArray = new LazyLayoutItemAnimation[0];
    public static final LayoutNode$$ExternalSyntheticLambda1 LazyLayoutMeasuredItemIndexComparator = new LayoutNode$$ExternalSyntheticLambda1((byte) 2);

    public static final void LazyLayout(final Function0 function0, final Modifier modifier, final LazyLayoutPrefetchState lazyLayoutPrefetchState, final LazyLayoutMeasurePolicy lazyLayoutMeasurePolicy, Composer composer, final int i) {
        GapComposer gapComposer = (GapComposer) composer;
        gapComposer.startRestartGroup(1055276397);
        int i2 = (gapComposer.changedInstance(function0) ? 4 : 2) | i | (gapComposer.changed(modifier) ? 32 : 16) | (gapComposer.changed(lazyLayoutPrefetchState) ? 256 : 128) | (gapComposer.changed(lazyLayoutMeasurePolicy) ? 2048 : 1024);
        if (gapComposer.shouldExecute(i2 & 1, (i2 & 1171) != 1170)) {
            final MutableState mutableStateRememberUpdatedState = Stack.rememberUpdatedState(function0, gapComposer);
            LazySaveableStateHolderProvider(Expect_jvmKt.rememberComposableLambda(-933153643, new Function3() { // from class: androidx.compose.foundation.lazy.layout.LazyLayoutKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    Modifier modifierThen;
                    final PrefetchScheduler prefetchScheduler;
                    SaveableStateHolder saveableStateHolder = (SaveableStateHolder) obj;
                    ((Integer) obj3).getClass();
                    GapComposer gapComposer2 = (GapComposer) ((Composer) obj2);
                    Object objRememberedValue = gapComposer2.rememberedValue();
                    NeverEqualPolicy neverEqualPolicy = Composer.Companion.Empty;
                    if (objRememberedValue == neverEqualPolicy) {
                        objRememberedValue = new LazyLayoutItemContentFactory(saveableStateHolder, new MainActivity$$ExternalSyntheticLambda29(mutableStateRememberUpdatedState, (byte) 3));
                        gapComposer2.updateRememberedValue(objRememberedValue);
                    }
                    final LazyLayoutItemContentFactory lazyLayoutItemContentFactory = (LazyLayoutItemContentFactory) objRememberedValue;
                    Object objRememberedValue2 = gapComposer2.rememberedValue();
                    if (objRememberedValue2 == neverEqualPolicy) {
                        objRememberedValue2 = new SubcomposeLayoutState(new CallbackWrapper(lazyLayoutItemContentFactory));
                        gapComposer2.updateRememberedValue(objRememberedValue2);
                    }
                    final SubcomposeLayoutState subcomposeLayoutState = (SubcomposeLayoutState) objRememberedValue2;
                    final LazyLayoutPrefetchState lazyLayoutPrefetchState2 = lazyLayoutPrefetchState;
                    if (lazyLayoutPrefetchState2 != null) {
                        gapComposer2.startReplaceGroup(1743490539);
                        gapComposer2.startReplaceGroup(887527095);
                        String str = Build.FINGERPRINT;
                        if (str == null || !str.equals("robolectric")) {
                            gapComposer2.startReplaceGroup(1345729441);
                            View view = (View) gapComposer2.consume(AndroidCompositionLocals_androidKt.LocalView);
                            boolean zChanged = gapComposer2.changed(view);
                            Object objRememberedValue3 = gapComposer2.rememberedValue();
                            if (zChanged || objRememberedValue3 == neverEqualPolicy) {
                                Object tag = view.getTag(R.id.compose_prefetch_scheduler);
                                objRememberedValue3 = tag instanceof PrefetchScheduler ? (PrefetchScheduler) tag : null;
                                if (objRememberedValue3 == null) {
                                    objRememberedValue3 = new AndroidPrefetchScheduler(view);
                                    view.setTag(R.id.compose_prefetch_scheduler, objRememberedValue3);
                                }
                                gapComposer2.updateRememberedValue(objRememberedValue3);
                            }
                            prefetchScheduler = (PrefetchScheduler) objRememberedValue3;
                            gapComposer2.end(false);
                        } else {
                            gapComposer2.startReplaceGroup(1345548711);
                            Object objRememberedValue4 = gapComposer2.rememberedValue();
                            if (objRememberedValue4 == neverEqualPolicy) {
                                objRememberedValue4 = new PrefetchScheduler_androidKt$noopScheduler$1();
                                gapComposer2.updateRememberedValue(objRememberedValue4);
                            }
                            prefetchScheduler = (PrefetchScheduler_androidKt$noopScheduler$1) objRememberedValue4;
                            gapComposer2.end(false);
                        }
                        gapComposer2.end(false);
                        Object[] objArr = {lazyLayoutPrefetchState2, lazyLayoutItemContentFactory, subcomposeLayoutState, prefetchScheduler};
                        boolean zChanged2 = gapComposer2.changed(lazyLayoutPrefetchState2) | gapComposer2.changedInstance(lazyLayoutItemContentFactory) | gapComposer2.changedInstance(subcomposeLayoutState) | gapComposer2.changedInstance(prefetchScheduler);
                        Object objRememberedValue5 = gapComposer2.rememberedValue();
                        if (zChanged2 || objRememberedValue5 == neverEqualPolicy) {
                            objRememberedValue5 = new Function1() { // from class: androidx.compose.foundation.lazy.layout.LazyLayoutKt$$ExternalSyntheticLambda3
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj4) {
                                    Latch latch = new Latch(lazyLayoutItemContentFactory, subcomposeLayoutState, prefetchScheduler);
                                    LazyLayoutPrefetchState lazyLayoutPrefetchState3 = lazyLayoutPrefetchState2;
                                    lazyLayoutPrefetchState3.prefetchHandleProvider = latch;
                                    return new AndroidPopup_androidKt$Popup$lambda$3$0$$inlined$onDispose$1((byte) 6, lazyLayoutPrefetchState3);
                                }
                            };
                            gapComposer2.updateRememberedValue(objRememberedValue5);
                        }
                        Stack.DisposableEffect(objArr, (Function1) objRememberedValue5, (Composer) gapComposer2);
                        gapComposer2.end(false);
                    } else {
                        gapComposer2.startReplaceGroup(1744076749);
                        gapComposer2.end(false);
                    }
                    Modifier modifier2 = modifier;
                    if (lazyLayoutPrefetchState2 != null && (modifierThen = modifier2.then(new TraversablePrefetchStateModifierElement(lazyLayoutPrefetchState2))) != null) {
                        modifier2 = modifierThen;
                    }
                    boolean zChanged3 = gapComposer2.changed(lazyLayoutItemContentFactory);
                    LazyLayoutMeasurePolicy lazyLayoutMeasurePolicy2 = lazyLayoutMeasurePolicy;
                    boolean zChanged4 = zChanged3 | gapComposer2.changed(lazyLayoutMeasurePolicy2);
                    Object objRememberedValue6 = gapComposer2.rememberedValue();
                    if (zChanged4 || objRememberedValue6 == neverEqualPolicy) {
                        objRememberedValue6 = new ButtonKt$$ExternalSyntheticLambda1(lazyLayoutItemContentFactory, lazyLayoutMeasurePolicy2, (byte) 10);
                        gapComposer2.updateRememberedValue(objRememberedValue6);
                    }
                    RulerKt.SubcomposeLayout(subcomposeLayoutState, modifier2, (Function2) objRememberedValue6, gapComposer2, 8);
                    return Unit.INSTANCE;
                }
            }, gapComposer), gapComposer, 6);
        } else {
            gapComposer.skipToGroupEnd();
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new Function2(modifier, lazyLayoutPrefetchState, lazyLayoutMeasurePolicy, i) { // from class: androidx.compose.foundation.lazy.layout.LazyLayoutKt$$ExternalSyntheticLambda1
                public final /* synthetic */ Modifier f$1;
                public final /* synthetic */ LazyLayoutPrefetchState f$2;
                public final /* synthetic */ LazyLayoutMeasurePolicy f$3;

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    ((Integer) obj2).getClass();
                    int iUpdateChangedFlags = Stack.updateChangedFlags(1);
                    LazyLayoutKt.LazyLayout(this.f$0, this.f$1, this.f$2, this.f$3, (Composer) obj, iUpdateChangedFlags);
                    return Unit.INSTANCE;
                }
            };
        }
    }

    public static final void LazyLayoutPinnableItem(Object obj, int i, LazyLayoutPinnedItemList lazyLayoutPinnedItemList, ComposableLambdaImpl composableLambdaImpl, Composer composer, int i2) {
        int i3;
        GapComposer gapComposer = (GapComposer) composer;
        gapComposer.startRestartGroup(872548579);
        if ((i2 & 6) == 0) {
            i3 = (gapComposer.changedInstance(obj) ? 4 : 2) | i2;
        } else {
            i3 = i2;
        }
        if ((i2 & 48) == 0) {
            i3 |= gapComposer.changed(i) ? 32 : 16;
        }
        if ((i2 & 384) == 0) {
            i3 |= gapComposer.changedInstance(lazyLayoutPinnedItemList) ? 256 : 128;
        }
        if ((i2 & 3072) == 0) {
            i3 |= gapComposer.changedInstance(composableLambdaImpl) ? 2048 : 1024;
        }
        if (gapComposer.shouldExecute(i3 & 1, (i3 & 1171) != 1170)) {
            boolean zChanged = gapComposer.changed(obj) | gapComposer.changed(lazyLayoutPinnedItemList);
            Object objRememberedValue = gapComposer.rememberedValue();
            NeverEqualPolicy neverEqualPolicy = Composer.Companion.Empty;
            if (zChanged || objRememberedValue == neverEqualPolicy) {
                objRememberedValue = new LazyLayoutPinnableItem(obj, lazyLayoutPinnedItemList);
                gapComposer.updateRememberedValue(objRememberedValue);
            }
            LazyLayoutPinnableItem lazyLayoutPinnableItem = (LazyLayoutPinnableItem) objRememberedValue;
            lazyLayoutPinnableItem.index = i;
            ParcelableSnapshotMutableState parcelableSnapshotMutableState = lazyLayoutPinnableItem._parentPinnableContainer$delegate;
            StaticProvidableCompositionLocal staticProvidableCompositionLocal = PinnableContainerKt.LocalPinnableContainer;
            LazyLayoutPinnableItem lazyLayoutPinnableItem2 = (LazyLayoutPinnableItem) gapComposer.consume(staticProvidableCompositionLocal);
            Snapshot currentThreadSnapshot = Lock.getCurrentThreadSnapshot();
            Function1 readObserver = currentThreadSnapshot != null ? currentThreadSnapshot.getReadObserver() : null;
            Snapshot snapshotMakeCurrentNonObservable = Lock.makeCurrentNonObservable(currentThreadSnapshot);
            try {
                if (lazyLayoutPinnableItem2 != ((LazyLayoutPinnableItem) parcelableSnapshotMutableState.getValue())) {
                    parcelableSnapshotMutableState.setValue(lazyLayoutPinnableItem2);
                    if (lazyLayoutPinnableItem.pinsCount > 0) {
                        LazyLayoutPinnableItem lazyLayoutPinnableItem3 = lazyLayoutPinnableItem.parentHandle;
                        if (lazyLayoutPinnableItem3 != null) {
                            lazyLayoutPinnableItem3.release();
                        }
                        if (lazyLayoutPinnableItem2 != null) {
                            lazyLayoutPinnableItem2.pin();
                        } else {
                            lazyLayoutPinnableItem2 = null;
                        }
                        lazyLayoutPinnableItem.parentHandle = lazyLayoutPinnableItem2;
                    }
                }
                Lock.restoreNonObservable(currentThreadSnapshot, snapshotMakeCurrentNonObservable, readObserver);
                boolean zChanged2 = gapComposer.changed(lazyLayoutPinnableItem);
                Object objRememberedValue2 = gapComposer.rememberedValue();
                if (zChanged2 || objRememberedValue2 == neverEqualPolicy) {
                    objRememberedValue2 = new ScrollState$$ExternalSyntheticLambda0((byte) 18, lazyLayoutPinnableItem);
                    gapComposer.updateRememberedValue(objRememberedValue2);
                }
                Stack.DisposableEffect(lazyLayoutPinnableItem, (Function1) objRememberedValue2, gapComposer);
                Stack.CompositionLocalProvider(staticProvidableCompositionLocal.defaultProvidedValue$runtime(lazyLayoutPinnableItem), composableLambdaImpl, gapComposer, ((i3 >> 6) & 112) | 8);
            } catch (Throwable th) {
                Lock.restoreNonObservable(currentThreadSnapshot, snapshotMakeCurrentNonObservable, readObserver);
                throw th;
            }
        } else {
            gapComposer.skipToGroupEnd();
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new TimePickerKt$$ExternalSyntheticLambda2(obj, i, lazyLayoutPinnedItemList, composableLambdaImpl, i2);
        }
    }

    public static final void LazySaveableStateHolderProvider(ComposableLambdaImpl composableLambdaImpl, Composer composer, int i) {
        GapComposer gapComposer = (GapComposer) composer;
        gapComposer.startRestartGroup(-709502251);
        byte b = 2;
        if (gapComposer.shouldExecute(i & 1, (i & 3) != 2)) {
            StaticProvidableCompositionLocal staticProvidableCompositionLocal = SaveableStateRegistryKt.LocalSaveableStateRegistry;
            SaveableStateRegistry saveableStateRegistry = (SaveableStateRegistry) gapComposer.consume(staticProvidableCompositionLocal);
            SaveableStateHolderImpl saveableStateHolderImplRememberSaveableStateHolder = SaverKt.rememberSaveableStateHolder(gapComposer);
            Object[] objArr = {saveableStateRegistry};
            byte b2 = 7;
            CallbackWrapper callbackWrapper = new CallbackWrapper(new ScrollState$$ExternalSyntheticLambda3((byte) 6), new BackHandlerKt$$ExternalSyntheticLambda2(saveableStateRegistry, saveableStateHolderImplRememberSaveableStateHolder, (byte) 27), b2);
            boolean zChangedInstance = gapComposer.changedInstance(saveableStateRegistry) | gapComposer.changedInstance(saveableStateHolderImplRememberSaveableStateHolder);
            Object objRememberedValue = gapComposer.rememberedValue();
            if (zChangedInstance || objRememberedValue == Composer.Companion.Empty) {
                objRememberedValue = new Recomposer$$ExternalSyntheticLambda6(saveableStateRegistry, saveableStateHolderImplRememberSaveableStateHolder, b2);
                gapComposer.updateRememberedValue(objRememberedValue);
            }
            LazySaveableStateHolder lazySaveableStateHolder = (LazySaveableStateHolder) SaverKt.m393rememberSaveable(objArr, (Saver) callbackWrapper, (Function0) objRememberedValue, (Composer) gapComposer, 0);
            Stack.CompositionLocalProvider(staticProvidableCompositionLocal.defaultProvidedValue$runtime(lazySaveableStateHolder), Expect_jvmKt.rememberComposableLambda(-412824043, new ButtonKt$$ExternalSyntheticLambda1(composableLambdaImpl, lazySaveableStateHolder, (byte) 11), gapComposer), gapComposer, 56);
        } else {
            gapComposer.skipToGroupEnd();
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new CardKt$$ExternalSyntheticLambda1(composableLambdaImpl, i, b);
        }
    }

    /* JADX INFO: renamed from: SkippableItem-JVlU9Rs, reason: not valid java name */
    public static final void m174SkippableItemJVlU9Rs(LazyLayoutItemProvider lazyLayoutItemProvider, Object obj, int i, Object obj2, Composer composer, int i2) {
        GapComposer gapComposer = (GapComposer) composer;
        gapComposer.startRestartGroup(1439843069);
        int i3 = (gapComposer.changed(lazyLayoutItemProvider) ? 4 : 2) | i2 | (gapComposer.changed(obj) ? 32 : 16) | (gapComposer.changed(i) ? 256 : 128) | (gapComposer.changed(obj2) ? 2048 : 1024);
        if (gapComposer.shouldExecute(i3 & 1, (i3 & 1171) != 1170)) {
            ((SaveableStateHolder) obj).SaveableStateProvider(obj2, Expect_jvmKt.rememberComposableLambda(980966366, new SnackbarHostKt$$ExternalSyntheticLambda7(i, lazyLayoutItemProvider, obj2), gapComposer), gapComposer, 48);
        } else {
            gapComposer.skipToGroupEnd();
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new TimePickerKt$$ExternalSyntheticLambda0(lazyLayoutItemProvider, obj, i, obj2, i2);
        }
    }

    /* JADX WARN: Code duplicated, block: B:113:0x00c0 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:38:0x00c5 A[Catch: ItemFoundInScroll -> 0x01b0, TryCatch #6 {ItemFoundInScroll -> 0x01b0, blocks: (B:36:0x00c0, B:37:0x00c2, B:38:0x00c5, B:56:0x011a, B:39:0x00d0, B:40:0x00db), top: B:113:0x00c0 }] */
    /* JADX WARN: Code duplicated, block: B:39:0x00d0 A[Catch: ItemFoundInScroll -> 0x01b0, TryCatch #6 {ItemFoundInScroll -> 0x01b0, blocks: (B:36:0x00c0, B:37:0x00c2, B:38:0x00c5, B:56:0x011a, B:39:0x00d0, B:40:0x00db), top: B:113:0x00c0 }] */
    /* JADX WARN: Code duplicated, block: B:40:0x00db A[Catch: ItemFoundInScroll -> 0x01b0, TRY_LEAVE, TryCatch #6 {ItemFoundInScroll -> 0x01b0, blocks: (B:36:0x00c0, B:37:0x00c2, B:38:0x00c5, B:56:0x011a, B:39:0x00d0, B:40:0x00db), top: B:113:0x00c0 }] */
    /* JADX WARN: Code duplicated, block: B:42:0x00e5 A[Catch: ItemFoundInScroll -> 0x01ac, TRY_ENTER, TRY_LEAVE, TryCatch #3 {ItemFoundInScroll -> 0x01ac, blocks: (B:34:0x00bc, B:42:0x00e5, B:55:0x010b, B:57:0x011f, B:61:0x0134, B:65:0x013c), top: B:107:0x00bc }] */
    /* JADX WARN: Code duplicated, block: B:45:0x00f2  */
    /* JADX WARN: Code duplicated, block: B:49:0x00fe  */
    /* JADX WARN: Code duplicated, block: B:52:0x0106 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:53:0x0108  */
    /* JADX WARN: Code duplicated, block: B:54:0x010a  */
    /* JADX WARN: Code duplicated, block: B:59:0x0131  */
    /* JADX WARN: Code duplicated, block: B:60:0x0133  */
    /* JADX WARN: Code duplicated, block: B:63:0x0137  */
    /* JADX WARN: Code duplicated, block: B:64:0x013a  */
    /* JADX WARN: Code duplicated, block: B:74:0x0185  */
    /* JADX WARN: Code duplicated, block: B:7:0x0019  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:74:0x0185 -> B:18:0x005c). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public static final java.lang.Object animateScrollToItem(androidx.compose.foundation.pager.PagerScrollScopeKt$LazyLayoutScrollScope$1 r27, int r28, int r29, androidx.compose.ui.unit.Density r30, kotlin.coroutines.jvm.internal.ContinuationImpl r31) {
        /*
            Method dump skipped, instruction units count: 548
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.lazy.layout.LazyLayoutKt.animateScrollToItem(androidx.compose.foundation.pager.PagerScrollScopeKt$LazyLayoutScrollScope$1, int, int, androidx.compose.ui.unit.Density, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }

    public static final boolean animateScrollToItem$isOvershot(boolean z, PagerScrollScopeKt$LazyLayoutScrollScope$1 pagerScrollScopeKt$LazyLayoutScrollScope$1, int i) {
        if (z) {
            if (pagerScrollScopeKt$LazyLayoutScrollScope$1.getFirstVisibleItemIndex() > i) {
                return true;
            }
            return pagerScrollScopeKt$LazyLayoutScrollScope$1.getFirstVisibleItemIndex() == i && pagerScrollScopeKt$LazyLayoutScrollScope$1.getFirstVisibleItemScrollOffset() > 0;
        }
        if (pagerScrollScopeKt$LazyLayoutScrollScope$1.getFirstVisibleItemIndex() < i) {
            return true;
        }
        return pagerScrollScopeKt$LazyLayoutScrollScope$1.getFirstVisibleItemIndex() == i && pagerScrollScopeKt$LazyLayoutScrollScope$1.getFirstVisibleItemScrollOffset() < 0;
    }

    public static final List applyStickyItems(CachedItem.NoKey noKey, int i, int i2, ArrayList arrayList, MutableIntList mutableIntList, int i3, int i4, int i5, boolean z, Function1 function1) {
        int i6;
        MutableIntList mutableIntList2;
        int i7;
        Object obj;
        int i8;
        if (noKey == null || arrayList.isEmpty() || (i6 = mutableIntList._size) == 0) {
            return EmptyList.INSTANCE;
        }
        int i9 = -1;
        int i10 = 0;
        if (i2 - i < 0 || i6 == 0) {
            mutableIntList2 = IntListKt.EmptyIntList;
        } else {
            IntRange intRangeUntil = UuidKt.until(0, i6);
            int i11 = intRangeUntil.first;
            int i12 = intRangeUntil.last;
            int i13 = -1;
            if (i11 <= i12) {
                while (mutableIntList.get(i11) <= i) {
                    i13 = mutableIntList.get(i11);
                    if (i11 == i12) {
                        break;
                    }
                    i11++;
                }
            }
            if (i13 == -1) {
                mutableIntList2 = IntListKt.EmptyIntList;
            } else {
                MutableIntList mutableIntList3 = IntListKt.EmptyIntList;
                mutableIntList2 = new MutableIntList(1);
                mutableIntList2.add(i13);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList(arrayList.size());
        int size = arrayList.size();
        int i14 = 0;
        while (i14 < size) {
            Object obj2 = arrayList.get(i14);
            int index = ((LazyLayoutMeasuredItem) obj2).getIndex();
            int[] iArr = mutableIntList.content;
            int i15 = mutableIntList._size;
            for (int i16 = i10; i16 < i15; i16++) {
                if (iArr[i16] == index) {
                    arrayList3.add(obj2);
                    break;
                }
            }
            i14++;
            i10 = 0;
        }
        int[] iArr2 = mutableIntList2.content;
        int i17 = mutableIntList2._size;
        int i18 = 0;
        while (i18 < i17) {
            int i19 = iArr2[i18];
            int size2 = arrayList.size();
            int i20 = 0;
            int i21 = 0;
            while (true) {
                if (i21 >= size2) {
                    i20 = i9;
                    break;
                }
                Object obj3 = arrayList.get(i21);
                i21++;
                if (((LazyLayoutMeasuredItem) obj3).getIndex() == i19) {
                    break;
                }
                i20++;
            }
            LazyLayoutMeasuredItem lazyLayoutMeasuredItem = i20 == i9 ? (LazyLayoutMeasuredItem) function1.invoke(Integer.valueOf(i19)) : (LazyLayoutMeasuredItem) arrayList.remove(i20);
            int iMainAxisSizeWithSpacings = mainAxisSizeWithSpacings(lazyLayoutMeasuredItem, z);
            if (i20 == i9) {
                i18 = i18;
                i7 = Integer.MIN_VALUE;
            } else {
                long jMo165getOffsetBjo55l4 = lazyLayoutMeasuredItem.mo165getOffsetBjo55l4(0);
                i7 = (int) (z ? jMo165getOffsetBjo55l4 & 4294967295L : jMo165getOffsetBjo55l4 >> 32);
            }
            int size3 = arrayList3.size();
            int i22 = 0;
            while (true) {
                if (i22 >= size3) {
                    obj = null;
                    break;
                }
                obj = arrayList3.get(i22);
                if (((LazyLayoutMeasuredItem) obj).getIndex() != i19) {
                    break;
                }
                i22++;
            }
            LazyLayoutMeasuredItem lazyLayoutMeasuredItem2 = (LazyLayoutMeasuredItem) obj;
            if (lazyLayoutMeasuredItem2 != null) {
                long jMo165getOffsetBjo55l5 = lazyLayoutMeasuredItem2.mo165getOffsetBjo55l4(0);
                i8 = (int) (z ? jMo165getOffsetBjo55l5 & 4294967295L : jMo165getOffsetBjo55l5 >> 32);
            } else {
                i8 = Integer.MIN_VALUE;
            }
            int iMax = i7 == Integer.MIN_VALUE ? -i3 : Math.max(-i3, i7);
            if (i8 != Integer.MIN_VALUE) {
                iMax = Math.min(iMax, i8 - iMainAxisSizeWithSpacings);
            }
            lazyLayoutMeasuredItem.makeNonScrollable();
            lazyLayoutMeasuredItem.position(iMax, 0, i4, i5);
            arrayList2.add(lazyLayoutMeasuredItem);
            i18++;
            i9 = -1;
        }
        return arrayList2;
    }

    public static final int binarySearch(int i, MutableVector mutableVector) {
        int i2 = mutableVector.size - 1;
        int i3 = 0;
        while (i3 < i2) {
            int i4 = ((i2 - i3) / 2) + i3;
            Object[] objArr = mutableVector.content;
            int i5 = ((IntervalList$Interval) objArr[i4]).startIndex;
            if (i5 != i) {
                if (i5 < i) {
                    i3 = i4 + 1;
                    if (i < ((IntervalList$Interval) objArr[i3]).startIndex) {
                    }
                } else {
                    i2 = i4 - 1;
                }
            }
            return i4;
        }
        return i3;
    }

    public static final MutableIntList calculateLazyLayoutPinnedIndices(LazyLayoutItemProvider lazyLayoutItemProvider, LazyLayoutPinnedItemList lazyLayoutPinnedItemList, LazyLayoutBeyondBoundsInfo lazyLayoutBeyondBoundsInfo) {
        int iMin;
        AbstractPersistentList abstractPersistentList = SnapshotId_jvmKt.getReadable(lazyLayoutPinnedItemList.items).list;
        MutableVector mutableVector = lazyLayoutBeyondBoundsInfo.beyondBoundsItems;
        int i = 1;
        if (!(mutableVector.size != 0) && abstractPersistentList.isEmpty()) {
            return IntListKt.EmptyIntList;
        }
        MutableIntList mutableIntList = new MutableIntList();
        if (lazyLayoutBeyondBoundsInfo.beyondBoundsItems.size != 0) {
            int i2 = mutableVector.size;
            if (i2 == 0) {
                PathKt$$ExternalSyntheticBUOutline0.m$1("MutableVector is empty.");
                return null;
            }
            Object[] objArr = mutableVector.content;
            int i3 = ((LazyLayoutBeyondBoundsInfo.Interval) objArr[0]).start;
            for (int i4 = 0; i4 < i2; i4++) {
                int i5 = ((LazyLayoutBeyondBoundsInfo.Interval) objArr[i4]).start;
                if (i5 < i3) {
                    i3 = i5;
                }
            }
            if (i3 < 0) {
                InlineClassHelperKt.throwIllegalArgumentException("negative minIndex");
            }
            int i6 = mutableVector.size;
            if (i6 == 0) {
                PathKt$$ExternalSyntheticBUOutline0.m$1("MutableVector is empty.");
                return null;
            }
            Object[] objArr2 = mutableVector.content;
            int i7 = ((LazyLayoutBeyondBoundsInfo.Interval) objArr2[0]).end;
            for (int i8 = 0; i8 < i6; i8++) {
                int i9 = ((LazyLayoutBeyondBoundsInfo.Interval) objArr2[i8]).end;
                if (i9 > i7) {
                    i7 = i9;
                }
            }
            iMin = Math.min(i7, lazyLayoutItemProvider.getItemCount() - 1);
            i = i3;
        } else {
            iMin = 0;
        }
        int size = abstractPersistentList.getSize();
        for (int i10 = 0; i10 < size; i10++) {
            LazyLayoutPinnableItem lazyLayoutPinnableItem = (LazyLayoutPinnableItem) abstractPersistentList.get(i10);
            int iFindIndexByKey = findIndexByKey(lazyLayoutPinnableItem.index, lazyLayoutItemProvider, lazyLayoutPinnableItem.key);
            if ((i > iFindIndexByKey || iFindIndexByKey > iMin) && iFindIndexByKey >= 0 && iFindIndexByKey < lazyLayoutItemProvider.getItemCount()) {
                mutableIntList.add(iFindIndexByKey);
            }
        }
        if (i <= iMin) {
            while (true) {
                mutableIntList.add(i);
                if (i == iMin) {
                    break;
                }
                i++;
            }
        }
        int i11 = mutableIntList._size;
        if (i11 == 0) {
            return mutableIntList;
        }
        int[] iArr = mutableIntList.content;
        iArr.getClass();
        Arrays.sort(iArr, 0, i11);
        return mutableIntList;
    }

    /* JADX INFO: renamed from: constructor-impl$default, reason: not valid java name */
    public static MutableState m175constructorimpl$default() {
        return new ParcelableSnapshotMutableState(Unit.INSTANCE, NeverEqualPolicy.INSTANCE);
    }

    public static final int findIndexByKey(int i, LazyLayoutItemProvider lazyLayoutItemProvider, Object obj) {
        int index;
        return (obj == null || lazyLayoutItemProvider.getItemCount() == 0 || (i < lazyLayoutItemProvider.getItemCount() && obj.equals(lazyLayoutItemProvider.getKey(i))) || (index = lazyLayoutItemProvider.getIndex(obj)) == -1) ? i : index;
    }

    public static final int indexOfMaxValue(int[] iArr) {
        int length = iArr.length;
        int i = -1;
        int i2 = Integer.MIN_VALUE;
        for (int i3 = 0; i3 < length; i3++) {
            int i4 = iArr[i3];
            if (i4 > i2) {
                i = i3;
                i2 = i4;
            }
        }
        return i;
    }

    /* JADX INFO: renamed from: invalidateScope-impl, reason: not valid java name */
    public static final void m176invalidateScopeimpl(MutableState mutableState) {
        mutableState.setValue(Unit.INSTANCE);
    }

    public static final boolean isItemVisible(PagerScrollScopeKt$LazyLayoutScrollScope$1 pagerScrollScopeKt$LazyLayoutScrollScope$1, int i) {
        return i <= pagerScrollScopeKt$LazyLayoutScrollScope$1.getLastVisibleItemIndex() && pagerScrollScopeKt$LazyLayoutScrollScope$1.getFirstVisibleItemIndex() <= i;
    }

    public static final Modifier lazyLayoutBeyondBoundsModifier(LazyLayoutBeyondBoundsState lazyLayoutBeyondBoundsState, LazyLayoutBeyondBoundsInfo lazyLayoutBeyondBoundsInfo, Orientation orientation) {
        return new LazyLayoutBeyondBoundsModifierElement(lazyLayoutBeyondBoundsState, lazyLayoutBeyondBoundsInfo, orientation);
    }

    public static final Modifier lazyLayoutItemAnimator(Modifier modifier, LazyLayoutItemAnimator lazyLayoutItemAnimator) {
        return modifier.then(new DisplayingDisappearingItemsElement(lazyLayoutItemAnimator));
    }

    public static final Modifier lazyLayoutSemantics(Modifier modifier, KProperty0 kProperty0, LazyLayoutSemanticState lazyLayoutSemanticState, Orientation orientation, boolean z) {
        return modifier.then(new LazyLayoutSemanticsModifier(kProperty0, lazyLayoutSemanticState, orientation, z));
    }

    public static final int mainAxisSizeWithSpacings(LazyLayoutMeasuredItem lazyLayoutMeasuredItem, boolean z) {
        int horizontalAxisSize;
        int horizontalAxisSpacing;
        if (z) {
            horizontalAxisSize = lazyLayoutMeasuredItem.getVerticalAxisSize();
            horizontalAxisSpacing = lazyLayoutMeasuredItem.getVerticalAxisSpacing();
        } else {
            horizontalAxisSize = lazyLayoutMeasuredItem.getHorizontalAxisSize();
            horizontalAxisSpacing = lazyLayoutMeasuredItem.getHorizontalAxisSpacing();
        }
        return horizontalAxisSpacing + horizontalAxisSize;
    }

    public static final StickyHeaderBringIntoViewSpec rememberLazyLayoutBringIntoViewSpec(int i, Composer composer, Function0 function0, boolean z) {
        GapComposer gapComposer = (GapComposer) composer;
        BringIntoViewSpec bringIntoViewSpec = (BringIntoViewSpec) gapComposer.consume(BringIntoViewSpec_androidKt.LocalBringIntoViewSpec);
        LayoutDirection layoutDirection = (LayoutDirection) gapComposer.consume(CompositionLocalsKt.LocalLayoutDirection);
        boolean zChanged = ((((i & 896) ^ 384) > 256 && gapComposer.changed(function0)) || (i & 384) == 256) | ((((i & 14) ^ 6) > 4 && gapComposer.changed(false)) || (i & 6) == 4) | gapComposer.changed(layoutDirection.ordinal()) | gapComposer.changed(bringIntoViewSpec) | ((((i & 112) ^ 48) > 32 && gapComposer.changed(z)) || (i & 48) == 32);
        Object objRememberedValue = gapComposer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.Companion.Empty) {
            objRememberedValue = new StickyHeaderBringIntoViewSpec(function0, layoutDirection, z, bringIntoViewSpec);
            gapComposer.updateRememberedValue(objRememberedValue);
        }
        return (StickyHeaderBringIntoViewSpec) objRememberedValue;
    }

    public static final List updatedVisibleItems(int i, int i2, ArrayList arrayList, List list) {
        if (arrayList.isEmpty()) {
            return EmptyList.INSTANCE;
        }
        ArrayList arrayList2 = new ArrayList(list);
        int size = arrayList.size();
        for (int i3 = 0; i3 < size; i3++) {
            LazyLayoutMeasuredItem lazyLayoutMeasuredItem = (LazyLayoutMeasuredItem) arrayList.get(i3);
            int index = lazyLayoutMeasuredItem.getIndex();
            if (i <= index && index <= i2) {
                arrayList2.add(lazyLayoutMeasuredItem);
            }
        }
        CollectionsKt__MutableCollectionsJVMKt.sortWith(arrayList2, LazyLayoutMeasuredItemIndexComparator);
        return arrayList2;
    }

    public Object getContentType(int i) {
        IntervalList$Interval intervalList$Interval = getIntervals().get(i);
        return intervalList$Interval.value.getType().invoke(Integer.valueOf(i - intervalList$Interval.startIndex));
    }

    public abstract StatusLine getIntervals();

    public Object getKey(int i) {
        Object objInvoke;
        IntervalList$Interval intervalList$Interval = getIntervals().get(i);
        int i2 = i - intervalList$Interval.startIndex;
        Function1 key = intervalList$Interval.value.getKey();
        return (key == null || (objInvoke = key.invoke(Integer.valueOf(i2))) == null) ? new DefaultLazyKey(i) : objInvoke;
    }
}
