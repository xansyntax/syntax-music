package androidx.compose.runtime;

import androidx.compose.material3.SnackbarHostKt$$ExternalSyntheticLambda7;
import androidx.compose.runtime.GapComposer.CompositionContextImpl;
import androidx.compose.runtime.composer.gapbuffer.GapAnchor;
import androidx.compose.runtime.composer.gapbuffer.SlotReader;
import androidx.compose.runtime.composer.gapbuffer.SlotWriter;
import androidx.compose.runtime.composer.gapbuffer.changelist.Operation;
import androidx.compose.runtime.composer.gapbuffer.changelist.Operations;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.runtime.internal.PersistentCompositionLocalHashMap;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.LayoutNode$$ExternalSyntheticLambda1;
import coil3.compose.AsyncImagePainter;
import coil3.size.SizeKt;
import com.metrolist.music.discord.DiscordRpcManager;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.SafeFlow;
import kotlinx.coroutines.flow.SharedFlow;
import kotlinx.coroutines.flow.StateFlow;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class Stack {
    public static final ComposableLambdaImpl lambda$954879418 = new ComposableLambdaImpl(false, 954879418, new Updater$$ExternalSyntheticLambda0((byte) 5));
    public static final ComposableLambdaImpl lambda$1918065384 = new ComposableLambdaImpl(false, 1918065384, new Updater$$ExternalSyntheticLambda0((byte) 6));
    public static final Object PendingApplyNoModifications = new Object();
    public static final DisposableEffectScope InternalDisposableEffectScope = new DisposableEffectScope();
    public static final LayoutNode$$ExternalSyntheticLambda1 InvalidationLocationAscending = new LayoutNode$$ExternalSyntheticLambda1(3);

    /* JADX WARN: Code duplicated, block: B:26:0x00db  */
    /* JADX WARN: Code duplicated, block: B:29:0x00e7  */
    /* JADX WARN: Code duplicated, block: B:31:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public static final void CompositionLocalProvider(ProvidedValue[] providedValueArr, Function2 function2, Composer composer, int i) {
        PersistentCompositionLocalHashMap persistentCompositionLocalHashMapBuild;
        boolean z;
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup;
        GapComposer gapComposer = (GapComposer) composer;
        gapComposer.startRestartGroup(415205898);
        IntStack intStack = gapComposer.providersInvalidStack;
        PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope = gapComposer.currentCompositionLocalScope();
        gapComposer.startGroup(201, ComposerKt.provider);
        boolean z2 = gapComposer.inserting;
        OpaqueKey opaqueKey = ComposerKt.providerMaps;
        if (z2) {
            PersistentCompositionLocalHashMap persistentCompositionLocalHashMapUpdateCompositionMap = updateCompositionMap(providedValueArr, persistentCompositionLocalHashMapCurrentCompositionLocalScope, PersistentCompositionLocalHashMap.Empty);
            PersistentCompositionLocalHashMap.Builder builder = persistentCompositionLocalHashMapCurrentCompositionLocalScope.builder$1();
            builder.putAll(persistentCompositionLocalHashMapUpdateCompositionMap);
            persistentCompositionLocalHashMapBuild = builder.build$1();
            gapComposer.startGroup(204, opaqueKey);
            gapComposer.nextSlot();
            gapComposer.updateValue(persistentCompositionLocalHashMapBuild);
            gapComposer.nextSlot();
            gapComposer.updateValue(persistentCompositionLocalHashMapUpdateCompositionMap);
            gapComposer.end(false);
            gapComposer.writerHasAProvider = true;
        } else {
            SlotReader slotReader = gapComposer.reader;
            Object objGroupGet = slotReader.groupGet(slotReader.currentGroup, 0);
            objGroupGet.getClass();
            PersistentCompositionLocalHashMap persistentCompositionLocalHashMap = (PersistentCompositionLocalHashMap) objGroupGet;
            SlotReader slotReader2 = gapComposer.reader;
            Object objGroupGet2 = slotReader2.groupGet(slotReader2.currentGroup, 1);
            objGroupGet2.getClass();
            PersistentCompositionLocalHashMap persistentCompositionLocalHashMap2 = (PersistentCompositionLocalHashMap) objGroupGet2;
            PersistentCompositionLocalHashMap persistentCompositionLocalHashMapUpdateCompositionMap2 = updateCompositionMap(providedValueArr, persistentCompositionLocalHashMapCurrentCompositionLocalScope, persistentCompositionLocalHashMap2);
            if (!gapComposer.getSkipping() || gapComposer.reusing || !persistentCompositionLocalHashMap2.equals(persistentCompositionLocalHashMapUpdateCompositionMap2)) {
                PersistentCompositionLocalHashMap.Builder builder2 = persistentCompositionLocalHashMapCurrentCompositionLocalScope.builder$1();
                builder2.putAll(persistentCompositionLocalHashMapUpdateCompositionMap2);
                persistentCompositionLocalHashMapBuild = builder2.build$1();
                gapComposer.startGroup(204, opaqueKey);
                gapComposer.nextSlot();
                gapComposer.updateValue(persistentCompositionLocalHashMapBuild);
                gapComposer.nextSlot();
                gapComposer.updateValue(persistentCompositionLocalHashMapUpdateCompositionMap2);
                gapComposer.end(false);
                if (gapComposer.reusing || !persistentCompositionLocalHashMapBuild.equals(persistentCompositionLocalHashMap)) {
                    z = true;
                }
                if (z && !gapComposer.inserting) {
                    gapComposer.recordProviderUpdate(persistentCompositionLocalHashMapBuild);
                }
                intStack.push(gapComposer.providersInvalid ? 1 : 0);
                gapComposer.providersInvalid = z;
                gapComposer.providerCache = persistentCompositionLocalHashMapBuild;
                gapComposer.m384startAzEfcrM(202, 0, ComposerKt.compositionLocalMap, persistentCompositionLocalHashMapBuild);
                function2.invoke(gapComposer, Integer.valueOf((i >> 3) & 14));
                gapComposer.end(false);
                gapComposer.end(false);
                gapComposer.providersInvalid = intStack.pop() != 0;
                gapComposer.providerCache = null;
                recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
                if (recomposeScopeImplEndRestartGroup != null) {
                    recomposeScopeImplEndRestartGroup.block = new SnackbarHostKt$$ExternalSyntheticLambda7(providedValueArr, function2, i, (byte) 8);
                }
            }
            gapComposer.groupNodeCount = gapComposer.reader.skipGroup() + gapComposer.groupNodeCount;
            persistentCompositionLocalHashMapBuild = persistentCompositionLocalHashMap;
        }
        z = false;
        if (z) {
            gapComposer.recordProviderUpdate(persistentCompositionLocalHashMapBuild);
        }
        intStack.push(gapComposer.providersInvalid ? 1 : 0);
        gapComposer.providersInvalid = z;
        gapComposer.providerCache = persistentCompositionLocalHashMapBuild;
        gapComposer.m384startAzEfcrM(202, 0, ComposerKt.compositionLocalMap, persistentCompositionLocalHashMapBuild);
        function2.invoke(gapComposer, Integer.valueOf((i >> 3) & 14));
        gapComposer.end(false);
        gapComposer.end(false);
        gapComposer.providersInvalid = intStack.pop() != 0;
        gapComposer.providerCache = null;
        recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new SnackbarHostKt$$ExternalSyntheticLambda7(providedValueArr, function2, i, (byte) 8);
        }
    }

    public static final void DisposableEffect(Object[] objArr, Function1 function1, Composer composer) {
        Object[] objArrCopyOf = Arrays.copyOf(objArr, objArr.length);
        GapComposer gapComposer = (GapComposer) composer;
        boolean zChanged = gapComposer.changed(objArrCopyOf.length);
        for (Object obj : objArrCopyOf) {
            zChanged |= gapComposer.changed(obj);
        }
        Object objRememberedValue = gapComposer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.Companion.Empty) {
            gapComposer.updateRememberedValue(new DisposableEffectImpl(function1));
        }
    }

    public static final void LaunchedEffect(Object[] objArr, Function2 function2, Composer composer) {
        CoroutineContext coroutineContext = ((GapComposer) composer).applyCoroutineContext;
        Object[] objArrCopyOf = Arrays.copyOf(objArr, objArr.length);
        GapComposer gapComposer = (GapComposer) composer;
        boolean zChanged = gapComposer.changed(objArrCopyOf.length);
        for (Object obj : objArrCopyOf) {
            zChanged |= gapComposer.changed(obj);
        }
        Object objRememberedValue = gapComposer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.Companion.Empty) {
            gapComposer.updateRememberedValue(new LaunchedEffectImpl(coroutineContext, function2));
        }
    }

    public static final void SideEffect(Function0 function0, Composer composer) {
        Operations operations = ((GapComposer) composer).changeListWriter.changeList.operations;
        operations.pushOp(Operation.SideEffect.INSTANCE);
        SizeKt.m873setObjectsGr0YRc(operations, 0, function0);
    }

    public static void adoptAnchoredScopes$runtime(SlotWriter slotWriter, List list, CompositionImpl compositionImpl) {
        if (list.isEmpty()) {
            return;
        }
        int size = list.size();
        for (int i = 0; i < size; i++) {
            int iAnchorIndex = slotWriter.anchorIndex((GapAnchor) list.get(i));
            int iSlotIndex = slotWriter.slotIndex(slotWriter.groupIndexToAddress(iAnchorIndex), slotWriter.groups);
            Object obj = iSlotIndex < slotWriter.dataIndex(slotWriter.groupIndexToAddress(iAnchorIndex + 1), slotWriter.groups) ? slotWriter.slots[slotWriter.dataIndexToDataAddress(iSlotIndex)] : Composer.Companion.Empty;
            RecomposeScopeImpl recomposeScopeImpl = obj instanceof RecomposeScopeImpl ? (RecomposeScopeImpl) obj : null;
            if (recomposeScopeImpl != null) {
                recomposeScopeImpl.owner = compositionImpl;
            }
        }
    }

    public static final MutableState collectAsState(SharedFlow sharedFlow, Object obj, CoroutineContext coroutineContext, NeverEqualPolicy neverEqualPolicy, Composer composer, int i) {
        GapComposer gapComposer = (GapComposer) composer;
        boolean zChangedInstance = gapComposer.changedInstance(coroutineContext) | gapComposer.changedInstance(sharedFlow);
        Object objRememberedValue = gapComposer.rememberedValue();
        Continuation continuation = null;
        NeverEqualPolicy neverEqualPolicy2 = Composer.Companion.Empty;
        if (zChangedInstance || objRememberedValue == neverEqualPolicy2) {
            objRememberedValue = new AsyncImagePainter.AnonymousClass1(coroutineContext, sharedFlow, continuation, (byte) 7);
            gapComposer.updateRememberedValue(objRememberedValue);
        }
        Function2 function2 = (Function2) objRememberedValue;
        Object objRememberedValue2 = gapComposer.rememberedValue();
        if (objRememberedValue2 == neverEqualPolicy2) {
            objRememberedValue2 = new ParcelableSnapshotMutableState(obj, neverEqualPolicy);
            gapComposer.updateRememberedValue(objRememberedValue2);
        }
        MutableState mutableState = (MutableState) objRememberedValue2;
        boolean zChangedInstance2 = gapComposer.changedInstance(function2);
        Object objRememberedValue3 = gapComposer.rememberedValue();
        if (zChangedInstance2 || objRememberedValue3 == neverEqualPolicy2) {
            objRememberedValue3 = new SnapshotStateKt__ProduceStateKt$produceState$1$1(function2, mutableState, continuation, (byte) 2);
            gapComposer.updateRememberedValue(objRememberedValue3);
        }
        LaunchedEffect(sharedFlow, coroutineContext, (Function2) objRememberedValue3, gapComposer);
        return mutableState;
    }

    public static final void collectNodesFrom$lambda$0$collectFromGroup(SlotReader slotReader, ArrayList arrayList, int i) {
        boolean zIsNode = slotReader.isNode(i);
        int[] iArr = slotReader.groups;
        if (zIsNode) {
            arrayList.add(slotReader.node(i));
            return;
        }
        int i2 = iArr[(i * 5) + 3] + i;
        for (int i3 = i + 1; i3 < i2; i3 += iArr[(i3 * 5) + 3]) {
            collectNodesFrom$lambda$0$collectFromGroup(slotReader, arrayList, i3);
        }
    }

    public static final CoroutineScope createCompositionCoroutineScope(Composer composer) {
        return new RememberedCoroutineScope(((GapComposer) composer).applyCoroutineContext);
    }

    public static final ParcelableSnapshotMutableFloatState createSnapshotMutableFloatState(float f) {
        return new ParcelableSnapshotMutableFloatState(f);
    }

    public static final int findLocation(int i, List list) {
        int size = list.size() - 1;
        int i2 = 0;
        while (i2 <= size) {
            int i3 = (i2 + size) >>> 1;
            int iCompare = Intrinsics.compare(((Invalidation) list.get(i3)).location, i);
            if (iCompare < 0) {
                i2 = i3 + 1;
            } else {
                if (iCompare <= 0) {
                    return i3;
                }
                size = i3 - 1;
            }
        }
        return -(i2 + 1);
    }

    public static final long getCurrentCompositeKeyHashCode(Composer composer) {
        return ((GapComposer) composer).compositeKeyHashCode;
    }

    public static final MonotonicFrameClock getMonotonicFrameClock(CoroutineContext coroutineContext) {
        MonotonicFrameClock monotonicFrameClock = (MonotonicFrameClock) coroutineContext.get(NeverEqualPolicy.$$INSTANCE);
        if (monotonicFrameClock != null) {
            return monotonicFrameClock;
        }
        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("A MonotonicFrameClock is not available in this CoroutineContext. Callers should supply an appropriate MonotonicFrameClock using withContext.");
        return null;
    }

    /* JADX INFO: renamed from: init-impl, reason: not valid java name */
    public static final void m386initimpl(Composer composer, Integer num) {
        if (((GapComposer) composer).inserting) {
            ((GapComposer) composer).apply(num, ComposeUiNode.Companion.SetCompositeKeyHash);
        }
    }

    /* JADX INFO: renamed from: isNotEmpty-impl, reason: not valid java name */
    public static final boolean m387isNotEmptyimpl(ArrayList arrayList) {
        return !arrayList.isEmpty();
    }

    public static final SnapshotStateList mutableStateListOf() {
        return new SnapshotStateList();
    }

    public static ParcelableSnapshotMutableState mutableStateOf$default(Object obj) {
        return new ParcelableSnapshotMutableState(obj, NeverEqualPolicy.INSTANCE$3);
    }

    /* JADX INFO: renamed from: pop-impl, reason: not valid java name */
    public static final Object m388popimpl(ArrayList arrayList) {
        return arrayList.remove(arrayList.size() - 1);
    }

    public static final MutableState produceState(Object obj, Object obj2, Function2 function2, Composer composer) {
        GapComposer gapComposer = (GapComposer) composer;
        Object objRememberedValue = gapComposer.rememberedValue();
        NeverEqualPolicy neverEqualPolicy = Composer.Companion.Empty;
        if (objRememberedValue == neverEqualPolicy) {
            objRememberedValue = mutableStateOf$default(obj);
            gapComposer.updateRememberedValue(objRememberedValue);
        }
        MutableState mutableState = (MutableState) objRememberedValue;
        boolean zChangedInstance = gapComposer.changedInstance(function2);
        Object objRememberedValue2 = gapComposer.rememberedValue();
        if (zChangedInstance || objRememberedValue2 == neverEqualPolicy) {
            objRememberedValue2 = new SnapshotStateKt__ProduceStateKt$produceState$1$1(function2, mutableState, null, (byte) 1);
            gapComposer.updateRememberedValue(objRememberedValue2);
        }
        LaunchedEffect(gapComposer, obj2, (Function2) objRememberedValue2);
        return mutableState;
    }

    public static final Object read(PersistentCompositionLocalHashMap persistentCompositionLocalHashMap, ProvidableCompositionLocal providableCompositionLocal) {
        providableCompositionLocal.getClass();
        Object defaultValueHolder$runtime = persistentCompositionLocalHashMap.get(providableCompositionLocal);
        if (defaultValueHolder$runtime == null) {
            defaultValueHolder$runtime = providableCompositionLocal.getDefaultValueHolder$runtime();
        }
        return ((ValueHolder) defaultValueHolder$runtime).readValue(persistentCompositionLocalHashMap);
    }

    /* JADX INFO: renamed from: reconcile-impl, reason: not valid java name */
    public static final void m389reconcileimpl(Composer composer) {
        ((GapComposer) composer).apply(Unit.INSTANCE, new Updater$$ExternalSyntheticLambda0((byte) 0));
    }

    public static final GapComposer.CompositionContextImpl rememberCompositionContext(Composer composer) {
        GapComposer gapComposer = (GapComposer) composer;
        gapComposer.startGroup(206, ComposerKt.reference);
        if (gapComposer.inserting) {
            SlotWriter.markGroup$default(gapComposer.writer);
        }
        Object objNextSlot = gapComposer.nextSlot();
        RememberObserverHolder reusableGapRememberObserverHolder = objNextSlot instanceof RememberObserverHolder ? (RememberObserverHolder) objNextSlot : null;
        if (reusableGapRememberObserverHolder == null) {
            reusableGapRememberObserverHolder = new ReusableGapRememberObserverHolder(new GapComposer.CompositionContextHolder(gapComposer.new CompositionContextImpl(gapComposer.compositeKeyHashCode, gapComposer.forceRecomposeScopes, gapComposer.sourceMarkersEnabled, gapComposer.composition.observerHolder)), -1);
            gapComposer.updateValue(reusableGapRememberObserverHolder);
        }
        RememberObserver wrapped = reusableGapRememberObserverHolder.getWrapped();
        wrapped.getClass();
        GapComposer.CompositionContextImpl compositionContextImpl = ((GapComposer.CompositionContextHolder) wrapped).ref;
        compositionContextImpl.compositionLocalScope$delegate.setValue(gapComposer.currentCompositionLocalScope());
        gapComposer.end(false);
        return compositionContextImpl;
    }

    public static final MutableState rememberUpdatedState(Object obj, Composer composer) {
        GapComposer gapComposer = (GapComposer) composer;
        Object objRememberedValue = gapComposer.rememberedValue();
        if (objRememberedValue == Composer.Companion.Empty) {
            objRememberedValue = mutableStateOf$default(obj);
            gapComposer.updateRememberedValue(objRememberedValue);
        }
        MutableState mutableState = (MutableState) objRememberedValue;
        mutableState.setValue(obj);
        return mutableState;
    }

    public static final void removeData(SlotWriter slotWriter, int i, Object obj) {
        int iDataIndexToDataAddress = slotWriter.dataIndexToDataAddress(i);
        Object[] objArr = slotWriter.slots;
        Object obj2 = objArr[iDataIndexToDataAddress];
        objArr[iDataIndexToDataAddress] = Composer.Companion.Empty;
        if (obj == obj2) {
            return;
        }
        ComposerKt.composeImmediateRuntimeError("Slot table is out of sync (expected " + obj + ", got " + obj2 + ")");
    }

    public static final void removeRange(int i, int i2, List list) {
        int iFindLocation = findLocation(i, list);
        if (iFindLocation < 0) {
            iFindLocation = -(iFindLocation + 1);
        }
        while (iFindLocation < list.size() && ((Invalidation) list.get(iFindLocation)).location < i2) {
        }
    }

    /* JADX INFO: renamed from: set-impl, reason: not valid java name */
    public static final void m390setimpl(Composer composer, Object obj, Function2 function2) {
        if (((GapComposer) composer).inserting || !Intrinsics.areEqual(((GapComposer) composer).rememberedValue(), obj)) {
            GapComposer gapComposer = (GapComposer) composer;
            gapComposer.updateRememberedValue(obj);
            gapComposer.apply(obj, function2);
        }
    }

    public static final SafeFlow snapshotFlow(Function0 function0) {
        return new SafeFlow((byte) 0, new DiscordRpcManager.AnonymousClass4(function0, null, (byte) 2));
    }

    public static final SnapshotStateList toMutableStateList(Collection collection) {
        SnapshotStateList snapshotStateList = new SnapshotStateList();
        snapshotStateList.addAll(collection);
        return snapshotStateList;
    }

    public static final int updateChangedFlags(int i) {
        int i2 = 306783378 & i;
        int i3 = 613566756 & i;
        return (i & (-920350135)) | (i3 >> 1) | i2 | ((i2 << 1) & i3);
    }

    public static final PersistentCompositionLocalHashMap updateCompositionMap(ProvidedValue[] providedValueArr, PersistentCompositionLocalHashMap persistentCompositionLocalHashMap, PersistentCompositionLocalHashMap persistentCompositionLocalHashMap2) {
        PersistentCompositionLocalHashMap.Builder builder = PersistentCompositionLocalHashMap.Empty.builder$1();
        for (ProvidedValue providedValue : providedValueArr) {
            ProvidableCompositionLocal providableCompositionLocal = providedValue.compositionLocal;
            if (providedValue.canOverride || !persistentCompositionLocalHashMap.containsKey(providableCompositionLocal)) {
                builder.put(providableCompositionLocal, providableCompositionLocal.updatedStateOf$runtime(providedValue, (ValueHolder) persistentCompositionLocalHashMap2.get(providableCompositionLocal)));
            }
        }
        return builder.build$1();
    }

    public static final void DisposableEffect(Object obj, Object obj2, Function1 function1, Composer composer) {
        GapComposer gapComposer = (GapComposer) composer;
        boolean zChanged = gapComposer.changed(obj) | gapComposer.changed(obj2);
        Object objRememberedValue = gapComposer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.Companion.Empty) {
            objRememberedValue = new DisposableEffectImpl(function1);
            gapComposer.updateRememberedValue(objRememberedValue);
        }
    }

    public static final void LaunchedEffect(Object obj, Object obj2, Function2 function2, Composer composer) {
        CoroutineContext coroutineContext = ((GapComposer) composer).applyCoroutineContext;
        GapComposer gapComposer = (GapComposer) composer;
        boolean zChanged = gapComposer.changed(obj) | gapComposer.changed(obj2);
        Object objRememberedValue = gapComposer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.Companion.Empty) {
            objRememberedValue = new LaunchedEffectImpl(coroutineContext, function2);
            gapComposer.updateRememberedValue(objRememberedValue);
        }
    }

    public static final void DisposableEffect(Object obj, Function1 function1, Composer composer) {
        GapComposer gapComposer = (GapComposer) composer;
        boolean zChanged = gapComposer.changed(obj);
        Object objRememberedValue = gapComposer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.Companion.Empty) {
            objRememberedValue = new DisposableEffectImpl(function1);
            gapComposer.updateRememberedValue(objRememberedValue);
        }
    }

    public static final void LaunchedEffect(Object obj, Object obj2, Object obj3, Function2 function2, Composer composer) {
        CoroutineContext coroutineContext = ((GapComposer) composer).applyCoroutineContext;
        GapComposer gapComposer = (GapComposer) composer;
        boolean zChanged = gapComposer.changed(obj) | gapComposer.changed(obj2) | gapComposer.changed(obj3);
        Object objRememberedValue = gapComposer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.Companion.Empty) {
            objRememberedValue = new LaunchedEffectImpl(coroutineContext, function2);
            gapComposer.updateRememberedValue(objRememberedValue);
        }
    }

    public static final void LaunchedEffect(Composer composer, Object obj, Function2 function2) {
        CoroutineContext coroutineContext = ((GapComposer) composer).applyCoroutineContext;
        GapComposer gapComposer = (GapComposer) composer;
        boolean zChanged = gapComposer.changed(obj);
        Object objRememberedValue = gapComposer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.Companion.Empty) {
            objRememberedValue = new LaunchedEffectImpl(coroutineContext, function2);
            gapComposer.updateRememberedValue(objRememberedValue);
        }
    }

    public static final MutableState collectAsState(StateFlow stateFlow, Composer composer, int i) {
        return collectAsState(stateFlow, stateFlow.getValue(), EmptyCoroutineContext.INSTANCE, NeverEqualPolicy.INSTANCE$3, composer, 0);
    }

    /* JADX WARN: Code duplicated, block: B:46:0x00bc  */
    /* JADX WARN: Code duplicated, block: B:49:0x00c7  */
    /* JADX WARN: Code duplicated, block: B:51:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public static final void CompositionLocalProvider(ProvidedValue providedValue, Function2 function2, Composer composer, int i) {
        ValueHolder valueHolder;
        boolean z;
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup;
        GapComposer gapComposer = (GapComposer) composer;
        gapComposer.startRestartGroup(-149765515);
        IntStack intStack = gapComposer.providersInvalidStack;
        PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope = gapComposer.currentCompositionLocalScope();
        gapComposer.startGroup(201, ComposerKt.provider);
        Object objRememberedValue = gapComposer.rememberedValue();
        if (Intrinsics.areEqual(objRememberedValue, Composer.Companion.Empty)) {
            valueHolder = null;
        } else {
            objRememberedValue.getClass();
            valueHolder = (ValueHolder) objRememberedValue;
        }
        ProvidableCompositionLocal providableCompositionLocal = providedValue.compositionLocal;
        ValueHolder valueHolderUpdatedStateOf$runtime = providableCompositionLocal.updatedStateOf$runtime(providedValue, valueHolder);
        boolean zEquals = valueHolderUpdatedStateOf$runtime.equals(valueHolder);
        if (!zEquals) {
            gapComposer.updateRememberedValue(valueHolderUpdatedStateOf$runtime);
        }
        if (gapComposer.inserting) {
            if (providedValue.canOverride || !persistentCompositionLocalHashMapCurrentCompositionLocalScope.containsKey(providableCompositionLocal)) {
                persistentCompositionLocalHashMapCurrentCompositionLocalScope = persistentCompositionLocalHashMapCurrentCompositionLocalScope.putValue(providableCompositionLocal, valueHolderUpdatedStateOf$runtime);
            }
            gapComposer.writerHasAProvider = true;
        } else {
            SlotReader slotReader = gapComposer.reader;
            Object objAux = slotReader.aux(slotReader.currentGroup, slotReader.groups);
            objAux.getClass();
            PersistentCompositionLocalHashMap persistentCompositionLocalHashMap = (PersistentCompositionLocalHashMap) objAux;
            if ((gapComposer.getSkipping() && zEquals) || (!providedValue.canOverride && persistentCompositionLocalHashMapCurrentCompositionLocalScope.containsKey(providableCompositionLocal))) {
                if ((zEquals && !gapComposer.providersInvalid) || !gapComposer.providersInvalid) {
                    persistentCompositionLocalHashMapCurrentCompositionLocalScope = persistentCompositionLocalHashMap;
                }
            } else {
                persistentCompositionLocalHashMapCurrentCompositionLocalScope = persistentCompositionLocalHashMapCurrentCompositionLocalScope.putValue(providableCompositionLocal, valueHolderUpdatedStateOf$runtime);
            }
            if (gapComposer.reusing || persistentCompositionLocalHashMap != persistentCompositionLocalHashMapCurrentCompositionLocalScope) {
                z = true;
            }
            if (z && !gapComposer.inserting) {
                gapComposer.recordProviderUpdate(persistentCompositionLocalHashMapCurrentCompositionLocalScope);
            }
            intStack.push(gapComposer.providersInvalid ? 1 : 0);
            gapComposer.providersInvalid = z;
            gapComposer.providerCache = persistentCompositionLocalHashMapCurrentCompositionLocalScope;
            gapComposer.m384startAzEfcrM(202, 0, ComposerKt.compositionLocalMap, persistentCompositionLocalHashMapCurrentCompositionLocalScope);
            function2.invoke(gapComposer, Integer.valueOf((i >> 3) & 14));
            gapComposer.end(false);
            gapComposer.end(false);
            gapComposer.providersInvalid = intStack.pop() != 0;
            gapComposer.providerCache = null;
            recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
            if (recomposeScopeImplEndRestartGroup != null) {
                recomposeScopeImplEndRestartGroup.block = new SnackbarHostKt$$ExternalSyntheticLambda7(providedValue, function2, i, (byte) 7);
            }
        }
        z = false;
        if (z) {
            gapComposer.recordProviderUpdate(persistentCompositionLocalHashMapCurrentCompositionLocalScope);
        }
        intStack.push(gapComposer.providersInvalid ? 1 : 0);
        gapComposer.providersInvalid = z;
        gapComposer.providerCache = persistentCompositionLocalHashMapCurrentCompositionLocalScope;
        gapComposer.m384startAzEfcrM(202, 0, ComposerKt.compositionLocalMap, persistentCompositionLocalHashMapCurrentCompositionLocalScope);
        function2.invoke(gapComposer, Integer.valueOf((i >> 3) & 14));
        gapComposer.end(false);
        gapComposer.end(false);
        gapComposer.providersInvalid = intStack.pop() != 0;
        gapComposer.providerCache = null;
        recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new SnackbarHostKt$$ExternalSyntheticLambda7(providedValue, function2, i, (byte) 7);
        }
    }
}
