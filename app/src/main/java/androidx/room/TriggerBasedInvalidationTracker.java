package androidx.room;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.datastore.core.SimpleActor$offer$2;
import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import coil3.compose.AsyncImagePainter;
import coil3.disk.UtilsKt$$ExternalSyntheticLambda0;
import coil3.network.NetworkFetcher;
import com.metrolist.music.App;
import com.metrolist.music.db.InternalDatabase_Impl;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.EmptySet;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.CoroutineName;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.internal.ContextScope;
import okhttp3.Dispatcher;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class TriggerBasedInvalidationTracker {
    public static final String[] TRIGGERS = {"INSERT", "UPDATE", "DELETE"};
    public final InternalDatabase_Impl database;
    public final ObservedTableStates observedTableStates;
    public final ObservedTableVersions observedTableVersions;
    public final NetworkFetcher.AnonymousClass2 onInvalidatedTablesIds;
    public final LinkedHashMap shadowTablesMap;
    public final String[] tablesNames;
    public final boolean useTempTable;
    public final LinkedHashMap viewTables;
    public final AtomicBoolean pendingRefresh = new AtomicBoolean(false);
    public Function0 onAllowRefresh = new UtilsKt$$ExternalSyntheticLambda0(14);
    public final LinkedHashMap tableIdLookup = new LinkedHashMap();

    /* JADX INFO: renamed from: androidx.room.TriggerBasedInvalidationTracker$checkInvalidatedTables$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class AnonymousClass1 extends ContinuationImpl {
        public Object L$0;
        public int label;
        public /* synthetic */ Object result;

        public AnonymousClass1(ContinuationImpl continuationImpl) {
            super(continuationImpl);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return TriggerBasedInvalidationTracker.this.checkInvalidatedTables(null, this);
        }
    }

    /* JADX INFO: renamed from: androidx.room.TriggerBasedInvalidationTracker$notifyInvalidation$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class C00461 extends ContinuationImpl {
        public Dispatcher L$0;
        public int label;
        public /* synthetic */ Object result;

        public C00461(ContinuationImpl continuationImpl) {
            super(continuationImpl);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return TriggerBasedInvalidationTracker.this.notifyInvalidation(this);
        }
    }

    /* JADX INFO: renamed from: androidx.room.TriggerBasedInvalidationTracker$startTrackingTable$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class C00471 extends ContinuationImpl {
        public int I$0;
        public int I$1;
        public int I$2;
        public PooledConnection L$0;
        public String L$1;
        public String[] L$2;
        public int label;
        public /* synthetic */ Object result;

        public C00471(ContinuationImpl continuationImpl) {
            super(continuationImpl);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return TriggerBasedInvalidationTracker.this.startTrackingTable(null, 0, this);
        }
    }

    /* JADX INFO: renamed from: androidx.room.TriggerBasedInvalidationTracker$stopTrackingTable$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class C00481 extends ContinuationImpl {
        public int I$0;
        public int I$1;
        public PooledConnection L$0;
        public String L$1;
        public String[] L$2;
        public int label;
        public /* synthetic */ Object result;

        public C00481(ContinuationImpl continuationImpl) {
            super(continuationImpl);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return TriggerBasedInvalidationTracker.this.stopTrackingTable(null, 0, this);
        }
    }

    public TriggerBasedInvalidationTracker(InternalDatabase_Impl internalDatabase_Impl, LinkedHashMap linkedHashMap, LinkedHashMap linkedHashMap2, String[] strArr, boolean z, NetworkFetcher.AnonymousClass2 anonymousClass2) {
        String lowerCase;
        this.database = internalDatabase_Impl;
        this.shadowTablesMap = linkedHashMap;
        this.viewTables = linkedHashMap2;
        this.useTempTable = z;
        this.onInvalidatedTablesIds = anonymousClass2;
        int length = strArr.length;
        String[] strArr2 = new String[length];
        for (int i = 0; i < length; i++) {
            String str = strArr[i];
            Locale locale = Locale.ROOT;
            String lowerCase2 = str.toLowerCase(locale);
            lowerCase2.getClass();
            this.tableIdLookup.put(lowerCase2, Integer.valueOf(i));
            String str2 = (String) this.shadowTablesMap.get(strArr[i]);
            if (str2 != null) {
                lowerCase = str2.toLowerCase(locale);
                lowerCase.getClass();
            } else {
                lowerCase = null;
            }
            if (lowerCase != null) {
                lowerCase2 = lowerCase;
            }
            strArr2[i] = lowerCase2;
        }
        this.tablesNames = strArr2;
        for (Map.Entry entry : this.shadowTablesMap.entrySet()) {
            String str3 = (String) entry.getValue();
            Locale locale2 = Locale.ROOT;
            String lowerCase3 = str3.toLowerCase(locale2);
            lowerCase3.getClass();
            if (this.tableIdLookup.containsKey(lowerCase3)) {
                String lowerCase4 = ((String) entry.getKey()).toLowerCase(locale2);
                lowerCase4.getClass();
                LinkedHashMap linkedHashMap3 = this.tableIdLookup;
                linkedHashMap3.put(lowerCase4, MapsKt__MapsKt.getValue(linkedHashMap3, lowerCase3));
            }
        }
        this.observedTableStates = new ObservedTableStates(this.tablesNames.length);
        this.observedTableVersions = new ObservedTableVersions(this.tablesNames.length);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object checkInvalidatedTables(PooledConnection pooledConnection, ContinuationImpl continuationImpl) {
        AnonymousClass1 anonymousClass1;
        if (continuationImpl instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuationImpl;
            int i = anonymousClass1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label = i - Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(continuationImpl);
            }
        } else {
            anonymousClass1 = new AnonymousClass1(continuationImpl);
        }
        Object objUsePrepared = anonymousClass1.result;
        int i2 = anonymousClass1.label;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objUsePrepared);
            RoomDatabase$$ExternalSyntheticLambda2 roomDatabase$$ExternalSyntheticLambda2 = new RoomDatabase$$ExternalSyntheticLambda2((byte) 19);
            anonymousClass1.L$0 = pooledConnection;
            anonymousClass1.label = 1;
            objUsePrepared = pooledConnection.usePrepared("SELECT * FROM room_table_modification_log WHERE invalidated = 1", roomDatabase$$ExternalSyntheticLambda2, anonymousClass1);
            if (objUsePrepared != coroutineSingletons) {
            }
            return coroutineSingletons;
        }
        if (i2 != 1) {
            if (i2 != 2) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            Set set = (Set) anonymousClass1.L$0;
            ResultKt.throwOnFailure(objUsePrepared);
            return set;
        }
        pooledConnection = (PooledConnection) anonymousClass1.L$0;
        ResultKt.throwOnFailure(objUsePrepared);
        Set set2 = (Set) objUsePrepared;
        if (!set2.isEmpty()) {
            anonymousClass1.L$0 = set2;
            anonymousClass1.label = 2;
            if (MathKt.execSQL(pooledConnection, "UPDATE room_table_modification_log SET invalidated = 0 WHERE invalidated = 1", anonymousClass1) == coroutineSingletons) {
                return coroutineSingletons;
            }
        }
        return set2;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$ArrayArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final Object notifyInvalidation(ContinuationImpl continuationImpl) throws Throwable {
        C00461 c00461;
        Dispatcher dispatcher;
        Object value;
        int[] iArr;
        if (continuationImpl instanceof C00461) {
            c00461 = (C00461) continuationImpl;
            int i = c00461.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c00461.label = i - Integer.MIN_VALUE;
            } else {
                c00461 = new C00461(continuationImpl);
            }
        } else {
            c00461 = new C00461(continuationImpl);
        }
        Object objUseConnection = c00461.result;
        int i2 = c00461.label;
        Continuation continuation = null;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objUseConnection);
            InternalDatabase_Impl internalDatabase_Impl = this.database;
            Dispatcher dispatcher2 = internalDatabase_Impl.closeBarrier;
            boolean zBlock$room_runtime = dispatcher2.block$room_runtime();
            EmptySet emptySet = EmptySet.INSTANCE;
            if (!zBlock$room_runtime) {
                return emptySet;
            }
            try {
                if (!this.pendingRefresh.compareAndSet(true, false)) {
                    dispatcher2.unblock$room_runtime();
                    return emptySet;
                }
                if (!((Boolean) this.onAllowRefresh.invoke()).booleanValue()) {
                    dispatcher2.unblock$room_runtime();
                    return emptySet;
                }
                SimpleActor$offer$2 simpleActor$offer$2 = new SimpleActor$offer$2(this, continuation, (byte) 9);
                c00461.L$0 = dispatcher2;
                c00461.label = 1;
                objUseConnection = internalDatabase_Impl.useConnection(false, simpleActor$offer$2, c00461);
                CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
                if (objUseConnection == coroutineSingletons) {
                    return coroutineSingletons;
                }
                dispatcher = dispatcher2;
            } catch (Throwable th) {
                th = th;
                dispatcher = dispatcher2;
                dispatcher.unblock$room_runtime();
                throw th;
            }
        } else {
            if (i2 != 1) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            dispatcher = c00461.L$0;
            try {
                ResultKt.throwOnFailure(objUseConnection);
            } catch (Throwable th2) {
                th = th2;
                dispatcher.unblock$room_runtime();
                throw th;
            }
        }
        Set set = (Set) objUseConnection;
        if (!set.isEmpty()) {
            ObservedTableVersions observedTableVersions = this.observedTableVersions;
            set.getClass();
            if (!set.isEmpty()) {
                StateFlowImpl stateFlowImpl = observedTableVersions.versions;
                do {
                    value = stateFlowImpl.getValue();
                    int[] iArr2 = (int[]) value;
                    int length = iArr2.length;
                    iArr = new int[length];
                    for (int i3 = 0; i3 < length; i3++) {
                        iArr[i3] = set.contains(Integer.valueOf(i3)) ? iArr2[i3] + 1 : iArr2[i3];
                    }
                } while (!stateFlowImpl.compareAndSet(value, iArr));
            }
            this.onInvalidatedTablesIds.invoke(set);
        }
        dispatcher.unblock$room_runtime();
        return set;
    }

    public final void refreshInvalidationAsync$room_runtime(Function0 function0, Function0 function1) {
        function0.getClass();
        function1.getClass();
        if (this.pendingRefresh.compareAndSet(false, true)) {
            function0.invoke();
            ContextScope contextScope = this.database.coroutineScope;
            Continuation continuation = null;
            if (contextScope != null) {
                AwaitKt.launch$default(contextScope, new CoroutineName("Room Invalidation Tracker Refresh"), null, new App.C01391(this, function1, continuation, (byte) 5), 2);
            } else {
                Intrinsics.throwUninitializedPropertyAccessException("coroutineScope");
                throw null;
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:21:0x0089  */
    /* JADX WARN: Code duplicated, block: B:23:0x008f  */
    /* JADX WARN: Code duplicated, block: B:24:0x0092  */
    /* JADX WARN: Code duplicated, block: B:29:0x00dd  */
    /* JADX WARN: Code duplicated, block: B:7:0x001b  */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0075, code lost:
    
        if (kotlin.math.MathKt.execSQL(r1, r3, r4) == r8) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x00d5, code lost:
    
        if (kotlin.math.MathKt.execSQL(r11, r3, r4) == r8) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x00d7, code lost:
    
        return r8;
     */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:26:0x00d5 -> B:28:0x00d8). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object startTrackingTable(Transactor transactor, int i, ContinuationImpl continuationImpl) {
        C00471 c00471;
        int i2;
        int i3;
        String[] strArr;
        PooledConnection pooledConnection;
        int i4;
        String str;
        String str2;
        boolean z;
        PooledConnection pooledConnection2 = transactor;
        int i5 = i;
        if (continuationImpl instanceof C00471) {
            c00471 = (C00471) continuationImpl;
            int i6 = c00471.label;
            if ((i6 & Integer.MIN_VALUE) != 0) {
                c00471.label = i6 - Integer.MIN_VALUE;
            } else {
                c00471 = new C00471(continuationImpl);
            }
        } else {
            c00471 = new C00471(continuationImpl);
        }
        Object obj = c00471.result;
        int i7 = c00471.label;
        boolean z2 = true;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (i7 != 0) {
            if (i7 == 1) {
                int i8 = c00471.I$0;
                PooledConnection pooledConnection3 = c00471.L$0;
                ResultKt.throwOnFailure(obj);
                i5 = i8;
                pooledConnection2 = pooledConnection3;
            } else {
                if (i7 != 2) {
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                i4 = c00471.I$2;
                i3 = c00471.I$1;
                i2 = c00471.I$0;
                strArr = c00471.L$2;
                str = c00471.L$1;
                pooledConnection = c00471.L$0;
                ResultKt.throwOnFailure(obj);
                z = true;
            }
            i3++;
            z2 = z;
            if (i3 < i4) {
                return Unit.INSTANCE;
            }
            String str3 = strArr[i3];
            if (this.useTempTable) {
                str2 = "TEMP";
            } else {
                str2 = "";
            }
            z = z2;
            StringBuilder sbM = IntIntPair$$ExternalSyntheticOutline0.m("CREATE ", str2, " TRIGGER IF NOT EXISTS `", "room_table_modification_trigger_" + str + '_' + str3, "` AFTER ");
            IntIntPair$$ExternalSyntheticOutline0.m6m(sbM, str3, " ON `", str, "` BEGIN UPDATE room_table_modification_log SET invalidated = 1 WHERE table_id = ");
            String strM = Fragment$5$$ExternalSyntheticOutline0.m(sbM, i2, " AND invalidated = 0; END");
            c00471.L$0 = pooledConnection;
            c00471.L$1 = str;
            c00471.L$2 = strArr;
            c00471.I$0 = i2;
            c00471.I$1 = i3;
            c00471.I$2 = i4;
            c00471.label = 2;
        } else {
            ResultKt.throwOnFailure(obj);
            String str4 = "INSERT OR IGNORE INTO room_table_modification_log VALUES(" + i5 + ", 0)";
            c00471.L$0 = pooledConnection2;
            c00471.I$0 = i5;
            c00471.label = 1;
        }
        String str5 = this.tablesNames[i5];
        i2 = i5;
        i3 = 0;
        strArr = TRIGGERS;
        pooledConnection = pooledConnection2;
        i4 = 3;
        str = str5;
        if (i3 < i4) {
            return Unit.INSTANCE;
        }
        String str6 = strArr[i3];
        if (this.useTempTable) {
            str2 = "TEMP";
        } else {
            str2 = "";
        }
        z = z2;
        StringBuilder sbM2 = IntIntPair$$ExternalSyntheticOutline0.m("CREATE ", str2, " TRIGGER IF NOT EXISTS `", "room_table_modification_trigger_" + str + '_' + str6, "` AFTER ");
        IntIntPair$$ExternalSyntheticOutline0.m6m(sbM2, str6, " ON `", str, "` BEGIN UPDATE room_table_modification_log SET invalidated = 1 WHERE table_id = ");
        String strM2 = Fragment$5$$ExternalSyntheticOutline0.m(sbM2, i2, " AND invalidated = 0; END");
        c00471.L$0 = pooledConnection;
        c00471.L$1 = str;
        c00471.L$2 = strArr;
        c00471.I$0 = i2;
        c00471.I$1 = i3;
        c00471.I$2 = i4;
        c00471.label = 2;
    }

    /* JADX WARN: Code duplicated, block: B:16:0x004c  */
    /* JADX WARN: Code duplicated, block: B:18:0x0080 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x007e -> B:19:0x0081). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public final java.lang.Object stopTrackingTable(androidx.room.Transactor r8, int r9, kotlin.coroutines.jvm.internal.ContinuationImpl r10) {
        /*
            r7 = this;
            boolean r0 = r10 instanceof androidx.room.TriggerBasedInvalidationTracker.C00481
            if (r0 == 0) goto L13
            r0 = r10
            androidx.room.TriggerBasedInvalidationTracker$stopTrackingTable$1 r0 = (androidx.room.TriggerBasedInvalidationTracker.C00481) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            androidx.room.TriggerBasedInvalidationTracker$stopTrackingTable$1 r0 = new androidx.room.TriggerBasedInvalidationTracker$stopTrackingTable$1
            r0.<init>(r10)
        L18:
            java.lang.Object r10 = r0.result
            int r1 = r0.label
            r2 = 1
            if (r1 == 0) goto L38
            if (r1 != r2) goto L31
            int r7 = r0.I$1
            int r8 = r0.I$0
            java.lang.String[] r9 = r0.L$2
            java.lang.String r1 = r0.L$1
            androidx.room.PooledConnection r3 = r0.L$0
            kotlin.ResultKt.throwOnFailure(r10)
            r10 = r9
            r9 = r3
            goto L81
        L31:
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0.m$2(r7)
            r7 = 0
            return r7
        L38:
            kotlin.ResultKt.throwOnFailure(r10)
            java.lang.String[] r7 = r7.tablesNames
            r7 = r7[r9]
            java.lang.String[] r9 = androidx.room.TriggerBasedInvalidationTracker.TRIGGERS
            r10 = 0
            r1 = 3
            r6 = r1
            r1 = r7
            r7 = r6
            r6 = r9
            r9 = r8
            r8 = r10
            r10 = r6
        L4a:
            if (r8 >= r7) goto L83
            r3 = r10[r8]
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            java.lang.String r5 = "room_table_modification_trigger_"
            r4.<init>(r5)
            r4.append(r1)
            r5 = 95
            r4.append(r5)
            r4.append(r3)
            java.lang.String r3 = r4.toString()
            java.lang.String r4 = "DROP TRIGGER IF EXISTS `"
            r5 = 96
            java.lang.String r3 = androidx.media3.common.Format$$ExternalSyntheticOutline0.m(r5, r4, r3)
            r0.L$0 = r9
            r0.L$1 = r1
            r0.L$2 = r10
            r0.I$0 = r8
            r0.I$1 = r7
            r0.label = r2
            java.lang.Object r3 = kotlin.math.MathKt.execSQL(r9, r3, r0)
            kotlin.coroutines.intrinsics.CoroutineSingletons r4 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            if (r3 != r4) goto L81
            return r4
        L81:
            int r8 = r8 + r2
            goto L4a
        L83:
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.room.TriggerBasedInvalidationTracker.stopTrackingTable(androidx.room.Transactor, int, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object syncTriggers$room_runtime(ContinuationImpl continuationImpl) {
        TriggerBasedInvalidationTracker$syncTriggers$1 triggerBasedInvalidationTracker$syncTriggers$1;
        Dispatcher dispatcher;
        if (continuationImpl instanceof TriggerBasedInvalidationTracker$syncTriggers$1) {
            triggerBasedInvalidationTracker$syncTriggers$1 = (TriggerBasedInvalidationTracker$syncTriggers$1) continuationImpl;
            int i = triggerBasedInvalidationTracker$syncTriggers$1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                triggerBasedInvalidationTracker$syncTriggers$1.label = i - Integer.MIN_VALUE;
            } else {
                triggerBasedInvalidationTracker$syncTriggers$1 = new TriggerBasedInvalidationTracker$syncTriggers$1(this, continuationImpl);
            }
        } else {
            triggerBasedInvalidationTracker$syncTriggers$1 = new TriggerBasedInvalidationTracker$syncTriggers$1(this, continuationImpl);
        }
        Object obj = triggerBasedInvalidationTracker$syncTriggers$1.result;
        int i2 = triggerBasedInvalidationTracker$syncTriggers$1.label;
        Continuation continuation = null;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            InternalDatabase_Impl internalDatabase_Impl = this.database;
            Dispatcher dispatcher2 = internalDatabase_Impl.closeBarrier;
            if (dispatcher2.block$room_runtime()) {
                try {
                    AsyncImagePainter.AnonymousClass1 anonymousClass1 = new AsyncImagePainter.AnonymousClass1(this, continuation, (byte) 9);
                    triggerBasedInvalidationTracker$syncTriggers$1.L$0 = dispatcher2;
                    triggerBasedInvalidationTracker$syncTriggers$1.label = 1;
                    Object objUseConnection = internalDatabase_Impl.useConnection(false, anonymousClass1, triggerBasedInvalidationTracker$syncTriggers$1);
                    CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
                    if (objUseConnection == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                    dispatcher = dispatcher2;
                    dispatcher.unblock$room_runtime();
                } catch (Throwable th) {
                    th = th;
                    dispatcher = dispatcher2;
                    dispatcher.unblock$room_runtime();
                    throw th;
                }
            }
        } else {
            if (i2 != 1) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            dispatcher = triggerBasedInvalidationTracker$syncTriggers$1.L$0;
            try {
                ResultKt.throwOnFailure(obj);
                dispatcher.unblock$room_runtime();
            } catch (Throwable th2) {
                th = th2;
                dispatcher.unblock$room_runtime();
                throw th;
            }
        }
        return Unit.INSTANCE;
    }
}
