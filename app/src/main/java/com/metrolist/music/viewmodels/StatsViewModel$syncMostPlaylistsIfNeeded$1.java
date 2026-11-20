package com.metrolist.music.viewmodels;

import android.content.Context;
import androidx.compose.runtime.Recomposer$join$2;
import androidx.datastore.preferences.core.MutablePreferences;
import com.metrolist.music.constants.PreferenceKeysKt;
import com.metrolist.music.constants.StatPeriod;
import com.metrolist.music.db.MusicDatabase;
import com.metrolist.music.utils.UtilsKt;
import com.yalantis.ucrop.R;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.StateFlowKt;
import kotlinx.coroutines.sync.Mutex;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class StatsViewModel$syncMostPlaylistsIfNeeded$1 extends SuspendLambda implements Function2 {
    public final /* synthetic */ boolean $force;
    public int I$0;
    public int I$1;
    public int I$2;
    public int I$3;
    public int I$4;
    public int I$5;
    public long J$0;
    public Mutex L$0;
    public StatsViewModel L$1;
    public LocalDateTime L$2;
    public MutablePreferences L$3;
    public boolean Z$0;
    public byte label;
    public final /* synthetic */ StatsViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StatsViewModel$syncMostPlaylistsIfNeeded$1(StatsViewModel statsViewModel, boolean z, Continuation continuation) {
        super(2, continuation);
        this.this$0 = statsViewModel;
        this.$force = z;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new StatsViewModel$syncMostPlaylistsIfNeeded$1(this.this$0, this.$force, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((StatsViewModel$syncMostPlaylistsIfNeeded$1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code duplicated, block: B:100:0x023b A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:111:0x027e  */
    /* JADX WARN: Code duplicated, block: B:114:0x0284 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:117:0x028d A[Catch: all -> 0x008f, TryCatch #7 {all -> 0x008f, blocks: (B:128:0x030f, B:132:0x032e, B:23:0x007f, B:88:0x01fa, B:90:0x020a, B:93:0x0213, B:101:0x023d, B:103:0x024d, B:106:0x0258, B:117:0x028d, B:121:0x02a9), top: B:165:0x007f }] */
    /* JADX WARN: Code duplicated, block: B:119:0x02a5  */
    /* JADX WARN: Code duplicated, block: B:120:0x02a8  */
    /* JADX WARN: Code duplicated, block: B:123:0x02e8  */
    /* JADX WARN: Code duplicated, block: B:124:0x02eb  */
    /* JADX WARN: Code duplicated, block: B:126:0x0304  */
    /* JADX WARN: Code duplicated, block: B:128:0x030f A[Catch: all -> 0x008f, TryCatch #7 {all -> 0x008f, blocks: (B:128:0x030f, B:132:0x032e, B:23:0x007f, B:88:0x01fa, B:90:0x020a, B:93:0x0213, B:101:0x023d, B:103:0x024d, B:106:0x0258, B:117:0x028d, B:121:0x02a9), top: B:165:0x007f }] */
    /* JADX WARN: Code duplicated, block: B:130:0x0329  */
    /* JADX WARN: Code duplicated, block: B:131:0x032c  */
    /* JADX WARN: Code duplicated, block: B:135:0x0366  */
    /* JADX WARN: Code duplicated, block: B:137:0x037c  */
    /* JADX WARN: Code duplicated, block: B:139:0x038d A[Catch: all -> 0x00c4, TRY_ENTER, TryCatch #2 {all -> 0x00c4, blocks: (B:139:0x038d, B:146:0x039d, B:33:0x00bf), top: B:157:0x000b }] */
    /* JADX WARN: Code duplicated, block: B:141:0x0393  */
    /* JADX WARN: Code duplicated, block: B:142:0x0396  */
    /* JADX WARN: Code duplicated, block: B:144:0x0399  */
    /* JADX WARN: Code duplicated, block: B:145:0x039c  */
    /* JADX WARN: Code duplicated, block: B:168:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:169:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:49:0x0127  */
    /* JADX WARN: Code duplicated, block: B:50:0x0128 A[Catch: all -> 0x0139, PHI: r0 r2 r3 r4 r5 r12
      0x0128: PHI (r0v9 boolean) = (r0v6 boolean), (r0v16 boolean) binds: [B:48:0x0125, B:39:0x00d3] A[DONT_GENERATE, DONT_INLINE]
      0x0128: PHI (r2v4 kotlinx.coroutines.sync.Mutex) = (r2v1 kotlinx.coroutines.sync.Mutex), (r2v6 kotlinx.coroutines.sync.Mutex) binds: [B:48:0x0125, B:39:0x00d3] A[DONT_GENERATE, DONT_INLINE]
      0x0128: PHI (r3v8 java.lang.Object) = (r3v6 java.lang.Object), (r3v13 java.lang.Object) binds: [B:48:0x0125, B:39:0x00d3] A[DONT_GENERATE, DONT_INLINE]
      0x0128: PHI (r4v2 java.time.LocalDateTime) = (r4v1 java.time.LocalDateTime), (r4v5 java.time.LocalDateTime) binds: [B:48:0x0125, B:39:0x00d3] A[DONT_GENERATE, DONT_INLINE]
      0x0128: PHI (r5v3 com.metrolist.music.viewmodels.StatsViewModel) = (r5v1 com.metrolist.music.viewmodels.StatsViewModel), (r5v5 com.metrolist.music.viewmodels.StatsViewModel) binds: [B:48:0x0125, B:39:0x00d3] A[DONT_GENERATE, DONT_INLINE]
      0x0128: PHI (r12v1 long) = (r12v0 long), (r12v2 long) binds: [B:48:0x0125, B:39:0x00d3] A[DONT_GENERATE, DONT_INLINE], TryCatch #6 {all -> 0x0139, blocks: (B:77:0x01af, B:50:0x0128, B:52:0x0134, B:56:0x013e, B:58:0x0148, B:61:0x0150, B:70:0x017b, B:47:0x0103), top: B:164:0x0103 }] */
    /* JADX WARN: Code duplicated, block: B:52:0x0134 A[Catch: all -> 0x0139, TryCatch #6 {all -> 0x0139, blocks: (B:77:0x01af, B:50:0x0128, B:52:0x0134, B:56:0x013e, B:58:0x0148, B:61:0x0150, B:70:0x017b, B:47:0x0103), top: B:164:0x0103 }] */
    /* JADX WARN: Code duplicated, block: B:55:0x013d  */
    /* JADX WARN: Code duplicated, block: B:58:0x0148 A[Catch: all -> 0x0139, TryCatch #6 {all -> 0x0139, blocks: (B:77:0x01af, B:50:0x0128, B:52:0x0134, B:56:0x013e, B:58:0x0148, B:61:0x0150, B:70:0x017b, B:47:0x0103), top: B:164:0x0103 }] */
    /* JADX WARN: Code duplicated, block: B:59:0x014d  */
    /* JADX WARN: Code duplicated, block: B:61:0x0150 A[Catch: all -> 0x0139, TryCatch #6 {all -> 0x0139, blocks: (B:77:0x01af, B:50:0x0128, B:52:0x0134, B:56:0x013e, B:58:0x0148, B:61:0x0150, B:70:0x017b, B:47:0x0103), top: B:164:0x0103 }] */
    /* JADX WARN: Code duplicated, block: B:63:0x0170  */
    /* JADX WARN: Code duplicated, block: B:64:0x0171  */
    /* JADX WARN: Code duplicated, block: B:66:0x0174  */
    /* JADX WARN: Code duplicated, block: B:67:0x0175  */
    /* JADX WARN: Code duplicated, block: B:70:0x017b A[Catch: all -> 0x0139, TryCatch #6 {all -> 0x0139, blocks: (B:77:0x01af, B:50:0x0128, B:52:0x0134, B:56:0x013e, B:58:0x0148, B:61:0x0150, B:70:0x017b, B:47:0x0103), top: B:164:0x0103 }] */
    /* JADX WARN: Code duplicated, block: B:72:0x01a1  */
    /* JADX WARN: Code duplicated, block: B:73:0x01a3  */
    /* JADX WARN: Code duplicated, block: B:75:0x01ac  */
    /* JADX WARN: Code duplicated, block: B:76:0x01ae  */
    /* JADX WARN: Code duplicated, block: B:80:0x01d9  */
    /* JADX WARN: Code duplicated, block: B:82:0x01ea  */
    /* JADX WARN: Code duplicated, block: B:84:0x01f0  */
    /* JADX WARN: Code duplicated, block: B:87:0x01f8 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:98:0x0237  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v22, types: [int] */
    /* JADX WARN: Type inference failed for: r0v45 */
    /* JADX WARN: Type inference failed for: r0v53 */
    /* JADX WARN: Type inference failed for: r0v63 */
    /* JADX WARN: Type inference failed for: r0v64 */
    /* JADX WARN: Type inference failed for: r10v10 */
    /* JADX WARN: Type inference failed for: r10v11 */
    /* JADX WARN: Type inference failed for: r10v18 */
    /* JADX WARN: Type inference failed for: r10v19, types: [int] */
    /* JADX WARN: Type inference failed for: r10v22 */
    /* JADX WARN: Type inference failed for: r10v32 */
    /* JADX WARN: Type inference failed for: r10v33 */
    /* JADX WARN: Type inference failed for: r10v7, types: [int] */
    /* JADX WARN: Type inference failed for: r10v8 */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v17 */
    /* JADX WARN: Type inference failed for: r1v2, types: [kotlinx.coroutines.sync.Mutex] */
    /* JADX WARN: Type inference failed for: r1v28 */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v39 */
    /* JADX WARN: Type inference failed for: r1v42 */
    /* JADX WARN: Type inference failed for: r1v44 */
    /* JADX WARN: Type inference failed for: r1v55 */
    /* JADX WARN: Type inference failed for: r1v56 */
    /* JADX WARN: Type inference failed for: r1v57 */
    /* JADX WARN: Type inference failed for: r1v9 */
    /* JADX WARN: Type inference failed for: r23v1 */
    /* JADX WARN: Type inference failed for: r28v1 */
    /* JADX WARN: Type inference failed for: r2v18 */
    /* JADX WARN: Type inference failed for: r2v25, types: [int] */
    /* JADX WARN: Type inference failed for: r2v28 */
    /* JADX WARN: Type inference failed for: r4v27 */
    /* JADX WARN: Type inference failed for: r4v32, types: [int] */
    /* JADX WARN: Type inference failed for: r4v34 */
    /* JADX WARN: Type inference failed for: r8v27 */
    /* JADX WARN: Type inference failed for: r8v3 */
    /* JADX WARN: Type inference failed for: r8v4, types: [int] */
    /* JADX WARN: Type inference failed for: r9v17 */
    /* JADX WARN: Type inference failed for: r9v7, types: [int] */
    /* JADX WARN: Type inference failed for: r9v9 */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object obj2;
        ?? r1;
        Mutex mutex;
        StatsViewModel statsViewModel;
        boolean z;
        LocalDateTime localDateTimeNow;
        long jCurrentTimeMillis;
        Object objFirst;
        MutablePreferences mutablePreferences;
        Boolean bool;
        ?? BooleanValue;
        Boolean bool2;
        boolean z2;
        Object objFirst2;
        boolean z3;
        ?? r0;
        MutablePreferences mutablePreferences2;
        LocalDateTime localDateTime;
        Object objWithTransaction;
        Mutex mutex2;
        boolean zBooleanValue;
        ?? r10;
        int i;
        Object objFirst3;
        boolean z4;
        ?? r11;
        MutablePreferences mutablePreferences3;
        int i2;
        StatsViewModel statsViewModel2;
        LocalDateTime localDateTime2;
        Mutex mutex3;
        int i3;
        long j;
        boolean z5;
        int i4;
        ?? r28;
        boolean z6;
        boolean z7;
        int i5;
        StatsViewModel statsViewModel3;
        CoroutineSingletons coroutineSingletons;
        long j2;
        String string;
        LocalDateTime localDateTime3;
        boolean z8;
        StatsViewModel statsViewModel4;
        long j3;
        int i6;
        int i7;
        int i8;
        boolean z9;
        StatsViewModel statsViewModel5;
        LocalDateTime localDateTime4;
        int i9;
        int i10;
        Mutex mutex4;
        long j4;
        ?? r12;
        ?? r9;
        CoroutineSingletons coroutineSingletons2;
        int i11;
        ?? r2;
        ?? r4;
        int i12;
        boolean z10;
        long j5;
        int i13;
        int i14;
        String string2;
        LocalDateTime localDateTime5;
        boolean z11;
        long j6;
        ?? r3;
        int i15;
        int i16;
        Mutex mutex5;
        int i17;
        boolean z12;
        long j7;
        StatsViewModel statsViewModel6;
        ?? r5;
        Context context;
        StatsViewModel$syncMostPlaylistsIfNeeded$1$1$1 statsViewModel$syncMostPlaylistsIfNeeded$1$1$1;
        boolean z13;
        boolean z14;
        Mutex mutex6;
        byte b = this.label;
        Unit unit = Unit.INSTANCE;
        ?? r6 = 2;
        char c = 2;
        CoroutineSingletons coroutineSingletons3 = CoroutineSingletons.COROUTINE_SUSPENDED;
        try {
            switch (b) {
                case 0:
                    ResultKt.throwOnFailure(obj);
                    StatsViewModel statsViewModel7 = this.this$0;
                    mutex = statsViewModel7.periodicMostPlaylistSyncMutex;
                    this.L$0 = mutex;
                    this.L$1 = statsViewModel7;
                    boolean z15 = this.$force;
                    this.Z$0 = z15;
                    this.label = (byte) 1;
                    if (mutex.lock(this) != coroutineSingletons3) {
                        statsViewModel = statsViewModel7;
                        z = z15;
                        try {
                            localDateTimeNow = LocalDateTime.now();
                            jCurrentTimeMillis = System.currentTimeMillis();
                            Flow data = UtilsKt.getDataStore(statsViewModel.context).getData();
                            this.L$0 = mutex;
                            this.L$1 = statsViewModel;
                            this.L$2 = localDateTimeNow;
                            this.Z$0 = z;
                            this.J$0 = jCurrentTimeMillis;
                            this.label = (byte) 2;
                            objFirst = StateFlowKt.first(data, this);
                            if (objFirst == coroutineSingletons3) {
                                mutablePreferences = (MutablePreferences) objFirst;
                                bool = (Boolean) mutablePreferences.get(PreferenceKeysKt.HideVideoSongsKey);
                                if (bool != null) {
                                    BooleanValue = bool.booleanValue();
                                } else {
                                    BooleanValue = 0;
                                }
                                bool2 = (Boolean) mutablePreferences.get(PreferenceKeysKt.ShowMostStatsPlaylistsKey);
                                if (bool2 != null) {
                                    zBooleanValue = bool2.booleanValue();
                                } else {
                                    z2 = true;
                                }
                                if (z2) {
                                    MusicDatabase musicDatabase = statsViewModel.database;
                                    musicDatabase.getClass();
                                    Flow flowPlaylist = musicDatabase.$$delegate_0.playlist("LP_WEEKLY_MOST");
                                    this.L$0 = mutex;
                                    this.L$1 = statsViewModel;
                                    this.L$2 = localDateTimeNow;
                                    this.L$3 = mutablePreferences;
                                    this.Z$0 = z;
                                    this.J$0 = jCurrentTimeMillis;
                                    this.I$0 = z2 ? 1 : 0;
                                    this.I$1 = BooleanValue;
                                    this.label = (byte) 4;
                                    objFirst2 = StateFlowKt.first(flowPlaylist, this);
                                    if (objFirst2 == coroutineSingletons3) {
                                        z2 = zBooleanValue;
                                    } else {
                                        LocalDateTime localDateTime6 = localDateTimeNow;
                                        z3 = z;
                                        r0 = BooleanValue;
                                        mutablePreferences2 = mutablePreferences;
                                        localDateTime = localDateTime6;
                                        if (objFirst2 != null) {
                                            z2 = zBooleanValue;
                                            r10 = z2;
                                            i = 1;
                                        } else {
                                            z2 = zBooleanValue;
                                            r10 = z2;
                                            i = 0;
                                        }
                                        MusicDatabase musicDatabase2 = statsViewModel.database;
                                        musicDatabase2.getClass();
                                        Flow flowPlaylist2 = musicDatabase2.$$delegate_0.playlist("LP_MONTHLY_MOST");
                                        this.L$0 = mutex;
                                        this.L$1 = statsViewModel;
                                        this.L$2 = localDateTime;
                                        this.L$3 = mutablePreferences2;
                                        this.Z$0 = z3;
                                        this.J$0 = jCurrentTimeMillis;
                                        this.I$0 = r10;
                                        this.I$1 = r0;
                                        this.I$2 = i;
                                        this.label = (byte) 5;
                                        objFirst3 = StateFlowKt.first(flowPlaylist2, this);
                                        if (objFirst3 != coroutineSingletons3) {
                                            z4 = z3;
                                            ?? r23 = r10;
                                            r11 = r0;
                                            mutablePreferences3 = mutablePreferences2;
                                            i2 = i;
                                            statsViewModel2 = statsViewModel;
                                            localDateTime2 = localDateTime;
                                            long j8 = jCurrentTimeMillis;
                                            mutex3 = mutex;
                                            i3 = r23 == true ? 1 : 0;
                                            j = j8;
                                            if (objFirst3 != null) {
                                                i4 = 1;
                                                z5 = true;
                                            } else {
                                                z5 = true;
                                                i4 = 0;
                                            }
                                            r28 = r11;
                                            if (!z4 || i2 == 0) {
                                                z6 = z5;
                                            } else {
                                                Long l = (Long) mutablePreferences3.get(PreferenceKeysKt.LastWeeklyMostPlaylistSyncKey);
                                                localDateTime2.getClass();
                                                statsViewModel2.getClass();
                                                if ((l == null || l.longValue() <= 0) ? z5 : !LocalDateTime.ofInstant(Instant.ofEpochMilli(l.longValue()), ZoneId.systemDefault()).plusWeeks(1L).isAfter(localDateTime2)) {
                                                    z6 = z5;
                                                } else {
                                                    z6 = false;
                                                }
                                            }
                                            if (z4 && i4 != 0) {
                                                Long l2 = (Long) mutablePreferences3.get(PreferenceKeysKt.LastMonthlyMostPlaylistSyncKey);
                                                localDateTime2.getClass();
                                                statsViewModel2.getClass();
                                                if (!((l2 == null || l2.longValue() <= 0) ? z5 : !LocalDateTime.ofInstant(Instant.ofEpochMilli(l2.longValue()), ZoneId.systemDefault()).plusMonths(1L).isAfter(localDateTime2))) {
                                                    z7 = false;
                                                }
                                                if (!z6 || z7) {
                                                    if (z6) {
                                                        string = statsViewModel2.context.getString(R.string.weekly_most_playlist_name);
                                                        string.getClass();
                                                        localDateTime3 = StatPeriod.WEEK_1.toLocalDateTime();
                                                        if (r28 != 0) {
                                                            z8 = z5;
                                                        } else {
                                                            z8 = false;
                                                        }
                                                        localDateTime2.getClass();
                                                        this.L$0 = mutex3;
                                                        this.L$1 = statsViewModel2;
                                                        this.L$2 = localDateTime2;
                                                        statsViewModel4 = statsViewModel2;
                                                        this.L$3 = null;
                                                        this.Z$0 = z4;
                                                        this.J$0 = j;
                                                        this.I$0 = i3 == true ? 1 : 0;
                                                        this.I$1 = r28 == true ? 1 : 0;
                                                        this.I$2 = i2;
                                                        this.I$3 = i4;
                                                        this.I$4 = z6 ? 1 : 0;
                                                        this.I$5 = z7 ? 1 : 0;
                                                        this.label = (byte) 6;
                                                        j3 = j;
                                                        coroutineSingletons = coroutineSingletons3;
                                                        if (statsViewModel4.syncMostPlaylist("LP_WEEKLY_MOST", string, localDateTime3, z8, localDateTime2, this) == coroutineSingletons) {
                                                            return coroutineSingletons;
                                                        }
                                                        i6 = i2;
                                                        i7 = z6 ? 1 : 0;
                                                        i8 = r28 == true ? 1 : 0;
                                                        z9 = z4;
                                                        statsViewModel5 = statsViewModel4;
                                                        localDateTime4 = localDateTime2;
                                                        i9 = z7 ? 1 : 0;
                                                        i10 = i3 == true ? 1 : 0;
                                                        mutex4 = mutex3;
                                                        j4 = j3;
                                                        i5 = i8;
                                                        Mutex mutex7 = mutex4;
                                                        r12 = i9;
                                                        statsViewModel3 = statsViewModel5;
                                                        z4 = z9;
                                                        i2 = i6;
                                                        j2 = j4;
                                                        i3 = i10;
                                                        localDateTime2 = localDateTime4;
                                                        mutex3 = mutex7;
                                                        r9 = i7;
                                                    } else {
                                                        i5 = r28 == true ? 1 : 0;
                                                        statsViewModel3 = statsViewModel2;
                                                        long j9 = j;
                                                        coroutineSingletons = coroutineSingletons3;
                                                        j2 = j9;
                                                    }
                                                    if (r12 != 0) {
                                                        r9 = z6;
                                                        r12 = z7;
                                                        CoroutineSingletons coroutineSingletons4 = coroutineSingletons;
                                                        string2 = statsViewModel3.context.getString(R.string.monthly_most_playlist_name);
                                                        string2.getClass();
                                                        localDateTime5 = StatPeriod.MONTH_1.toLocalDateTime();
                                                        if (i5 != 0) {
                                                            z11 = z5;
                                                        } else {
                                                            z11 = false;
                                                        }
                                                        localDateTime2.getClass();
                                                        this.L$0 = mutex3;
                                                        this.L$1 = statsViewModel3;
                                                        this.L$2 = null;
                                                        this.L$3 = null;
                                                        this.Z$0 = z4;
                                                        this.J$0 = j2;
                                                        this.I$0 = i3;
                                                        this.I$1 = i5;
                                                        this.I$2 = i2;
                                                        this.I$3 = i4;
                                                        this.I$4 = r9;
                                                        this.I$5 = r12;
                                                        this.label = (byte) 7;
                                                        coroutineSingletons2 = coroutineSingletons4;
                                                        j6 = j2;
                                                        if (statsViewModel3.syncMostPlaylist("LP_MONTHLY_MOST", string2, localDateTime5, z11, localDateTime2, this) == coroutineSingletons2) {
                                                            return coroutineSingletons2;
                                                        }
                                                        i11 = i2;
                                                        r3 = r9;
                                                        i15 = i5;
                                                        i16 = i3;
                                                        mutex5 = mutex3;
                                                        i17 = i4;
                                                        z12 = z4;
                                                        j7 = j6;
                                                        statsViewModel6 = statsViewModel3;
                                                        r5 = r12;
                                                        int i18 = i15;
                                                        r4 = r5;
                                                        statsViewModel3 = statsViewModel6;
                                                        i13 = i17;
                                                        r2 = r3;
                                                        mutex2 = mutex5;
                                                        z10 = z12;
                                                        i14 = i16;
                                                        i12 = i18 == true ? 1 : 0;
                                                        j5 = j7;
                                                    } else {
                                                        r9 = z6;
                                                        r12 = z7;
                                                        long j10 = j2;
                                                        unit = unit;
                                                        coroutineSingletons2 = coroutineSingletons;
                                                        i11 = i2;
                                                        r2 = r9;
                                                        r4 = r12;
                                                        i12 = i5;
                                                        mutex2 = mutex3;
                                                        z10 = z4;
                                                        j5 = j10;
                                                        i13 = i4;
                                                        i14 = i3;
                                                    }
                                                    if (!z10) {
                                                        context = statsViewModel3.context;
                                                        if (r2 != 0) {
                                                            z13 = z5;
                                                        } else {
                                                            z13 = false;
                                                        }
                                                        if (r4 != 0) {
                                                            z14 = z5;
                                                        } else {
                                                            z14 = false;
                                                        }
                                                        statsViewModel$syncMostPlaylistsIfNeeded$1$1$1 = new StatsViewModel$syncMostPlaylistsIfNeeded$1$1$1(z13, j5, z14, null);
                                                        this.L$0 = mutex2;
                                                        this.L$1 = null;
                                                        this.L$2 = null;
                                                        this.L$3 = null;
                                                        this.J$0 = j5;
                                                        this.I$0 = i14;
                                                        this.I$1 = i12;
                                                        this.I$2 = i11;
                                                        this.I$3 = i13;
                                                        this.I$4 = r2;
                                                        this.I$5 = r4;
                                                        this.label = (byte) 8;
                                                        if (UtilsKt.safeDataStoreEdit(context, statsViewModel$syncMostPlaylistsIfNeeded$1$1$1, this) == coroutineSingletons2) {
                                                            return coroutineSingletons2;
                                                        }
                                                    }
                                                } else {
                                                    unit = unit;
                                                    mutex2 = mutex3;
                                                }
                                                mutex2.unlock(null);
                                                return unit;
                                            }
                                            coroutineSingletons3 = coroutineSingletons3;
                                            z7 = z5;
                                            if (z6) {
                                            }
                                            if (z6) {
                                                string = statsViewModel2.context.getString(R.string.weekly_most_playlist_name);
                                                string.getClass();
                                                localDateTime3 = StatPeriod.WEEK_1.toLocalDateTime();
                                                if (r28 != 0) {
                                                    z8 = z5;
                                                } else {
                                                    z8 = false;
                                                }
                                                localDateTime2.getClass();
                                                this.L$0 = mutex3;
                                                this.L$1 = statsViewModel2;
                                                this.L$2 = localDateTime2;
                                                statsViewModel4 = statsViewModel2;
                                                this.L$3 = null;
                                                this.Z$0 = z4;
                                                this.J$0 = j;
                                                this.I$0 = i3 == true ? 1 : 0;
                                                this.I$1 = r28 == true ? 1 : 0;
                                                this.I$2 = i2;
                                                this.I$3 = i4;
                                                this.I$4 = z6 ? 1 : 0;
                                                this.I$5 = z7 ? 1 : 0;
                                                this.label = (byte) 6;
                                                j3 = j;
                                                coroutineSingletons = coroutineSingletons3;
                                                if (statsViewModel4.syncMostPlaylist("LP_WEEKLY_MOST", string, localDateTime3, z8, localDateTime2, this) == coroutineSingletons) {
                                                    return coroutineSingletons;
                                                }
                                                i6 = i2;
                                                i7 = z6 ? 1 : 0;
                                                i8 = r28 == true ? 1 : 0;
                                                z9 = z4;
                                                statsViewModel5 = statsViewModel4;
                                                localDateTime4 = localDateTime2;
                                                i9 = z7 ? 1 : 0;
                                                i10 = i3 == true ? 1 : 0;
                                                mutex4 = mutex3;
                                                j4 = j3;
                                                i5 = i8;
                                                Mutex mutex8 = mutex4;
                                                r12 = i9;
                                                statsViewModel3 = statsViewModel5;
                                                z4 = z9;
                                                i2 = i6;
                                                j2 = j4;
                                                i3 = i10;
                                                localDateTime2 = localDateTime4;
                                                mutex3 = mutex8;
                                                r9 = i7;
                                            } else {
                                                i5 = r28 == true ? 1 : 0;
                                                statsViewModel3 = statsViewModel2;
                                                long j11 = j;
                                                coroutineSingletons = coroutineSingletons3;
                                                j2 = j11;
                                            }
                                            if (r12 != 0) {
                                                r9 = z6;
                                                r12 = z7;
                                                CoroutineSingletons coroutineSingletons5 = coroutineSingletons;
                                                string2 = statsViewModel3.context.getString(R.string.monthly_most_playlist_name);
                                                string2.getClass();
                                                localDateTime5 = StatPeriod.MONTH_1.toLocalDateTime();
                                                if (i5 != 0) {
                                                    z11 = z5;
                                                } else {
                                                    z11 = false;
                                                }
                                                localDateTime2.getClass();
                                                this.L$0 = mutex3;
                                                this.L$1 = statsViewModel3;
                                                this.L$2 = null;
                                                this.L$3 = null;
                                                this.Z$0 = z4;
                                                this.J$0 = j2;
                                                this.I$0 = i3;
                                                this.I$1 = i5;
                                                this.I$2 = i2;
                                                this.I$3 = i4;
                                                this.I$4 = r9;
                                                this.I$5 = r12;
                                                this.label = (byte) 7;
                                                coroutineSingletons2 = coroutineSingletons5;
                                                j6 = j2;
                                                if (statsViewModel3.syncMostPlaylist("LP_MONTHLY_MOST", string2, localDateTime5, z11, localDateTime2, this) == coroutineSingletons2) {
                                                    return coroutineSingletons2;
                                                }
                                                i11 = i2;
                                                r3 = r9;
                                                i15 = i5;
                                                i16 = i3;
                                                mutex5 = mutex3;
                                                i17 = i4;
                                                z12 = z4;
                                                j7 = j6;
                                                statsViewModel6 = statsViewModel3;
                                                r5 = r12;
                                                int i19 = i15;
                                                r4 = r5;
                                                statsViewModel3 = statsViewModel6;
                                                i13 = i17;
                                                r2 = r3;
                                                mutex2 = mutex5;
                                                z10 = z12;
                                                i14 = i16;
                                                i12 = i19 == true ? 1 : 0;
                                                j5 = j7;
                                            } else {
                                                r9 = z6;
                                                r12 = z7;
                                                long j12 = j2;
                                                unit = unit;
                                                coroutineSingletons2 = coroutineSingletons;
                                                i11 = i2;
                                                r2 = r9;
                                                r4 = r12;
                                                i12 = i5;
                                                mutex2 = mutex3;
                                                z10 = z4;
                                                j5 = j12;
                                                i13 = i4;
                                                i14 = i3;
                                            }
                                            if (!z10) {
                                                context = statsViewModel3.context;
                                                if (r2 != 0) {
                                                    z13 = z5;
                                                } else {
                                                    z13 = false;
                                                }
                                                if (r4 != 0) {
                                                    z14 = z5;
                                                } else {
                                                    z14 = false;
                                                }
                                                statsViewModel$syncMostPlaylistsIfNeeded$1$1$1 = new StatsViewModel$syncMostPlaylistsIfNeeded$1$1$1(z13, j5, z14, null);
                                                this.L$0 = mutex2;
                                                this.L$1 = null;
                                                this.L$2 = null;
                                                this.L$3 = null;
                                                this.J$0 = j5;
                                                this.I$0 = i14;
                                                this.I$1 = i12;
                                                this.I$2 = i11;
                                                this.I$3 = i13;
                                                this.I$4 = r2;
                                                this.I$5 = r4;
                                                this.label = (byte) 8;
                                                if (UtilsKt.safeDataStoreEdit(context, statsViewModel$syncMostPlaylistsIfNeeded$1$1$1, this) == coroutineSingletons2) {
                                                    return coroutineSingletons2;
                                                }
                                            }
                                            mutex2.unlock(null);
                                            return unit;
                                        }
                                    }
                                } else {
                                    this.L$0 = mutex;
                                    this.L$1 = null;
                                    this.L$2 = null;
                                    this.J$0 = jCurrentTimeMillis;
                                    this.I$0 = z2 ? 1 : 0;
                                    this.I$1 = BooleanValue;
                                    this.label = (byte) 3;
                                    objWithTransaction = statsViewModel.database.withTransaction(new Recomposer$join$2(c, null, (byte) 11), this);
                                    if (objWithTransaction != coroutineSingletons3) {
                                        objWithTransaction = unit;
                                    }
                                    if (objWithTransaction != coroutineSingletons3) {
                                        z2 = zBooleanValue;
                                        z2 = zBooleanValue;
                                        mutex2 = mutex;
                                        unit = unit;
                                        mutex2.unlock(null);
                                        return unit;
                                    }
                                    z2 = zBooleanValue;
                                    z2 = zBooleanValue;
                                }
                            }
                        } catch (Throwable th) {
                            th = th;
                            r6 = mutex;
                            obj2 = null;
                            r1 = r6;
                            r1.unlock(obj2);
                            throw th;
                        }
                    }
                    return coroutineSingletons3;
                case 1:
                    z = this.Z$0;
                    StatsViewModel statsViewModel8 = this.L$1;
                    Mutex mutex9 = this.L$0;
                    ResultKt.throwOnFailure(obj);
                    statsViewModel = statsViewModel8;
                    mutex = mutex9;
                    localDateTimeNow = LocalDateTime.now();
                    jCurrentTimeMillis = System.currentTimeMillis();
                    Flow data2 = UtilsKt.getDataStore(statsViewModel.context).getData();
                    this.L$0 = mutex;
                    this.L$1 = statsViewModel;
                    this.L$2 = localDateTimeNow;
                    this.Z$0 = z;
                    this.J$0 = jCurrentTimeMillis;
                    this.label = (byte) 2;
                    objFirst = StateFlowKt.first(data2, this);
                    if (objFirst == coroutineSingletons3) {
                        mutablePreferences = (MutablePreferences) objFirst;
                        bool = (Boolean) mutablePreferences.get(PreferenceKeysKt.HideVideoSongsKey);
                        if (bool != null) {
                            BooleanValue = bool.booleanValue();
                        } else {
                            BooleanValue = 0;
                        }
                        bool2 = (Boolean) mutablePreferences.get(PreferenceKeysKt.ShowMostStatsPlaylistsKey);
                        if (bool2 != null) {
                            zBooleanValue = bool2.booleanValue();
                        } else {
                            z2 = true;
                        }
                        if (z2) {
                            this.L$0 = mutex;
                            this.L$1 = null;
                            this.L$2 = null;
                            this.J$0 = jCurrentTimeMillis;
                            this.I$0 = z2 ? 1 : 0;
                            this.I$1 = BooleanValue;
                            this.label = (byte) 3;
                            objWithTransaction = statsViewModel.database.withTransaction(new Recomposer$join$2(c, null, (byte) 11), this);
                            if (objWithTransaction != coroutineSingletons3) {
                                objWithTransaction = unit;
                            }
                            if (objWithTransaction != coroutineSingletons3) {
                                z2 = zBooleanValue;
                                z2 = zBooleanValue;
                                mutex2 = mutex;
                                unit = unit;
                                mutex2.unlock(null);
                                return unit;
                            }
                            z2 = zBooleanValue;
                            z2 = zBooleanValue;
                        } else {
                            MusicDatabase musicDatabase3 = statsViewModel.database;
                            musicDatabase3.getClass();
                            Flow flowPlaylist3 = musicDatabase3.$$delegate_0.playlist("LP_WEEKLY_MOST");
                            this.L$0 = mutex;
                            this.L$1 = statsViewModel;
                            this.L$2 = localDateTimeNow;
                            this.L$3 = mutablePreferences;
                            this.Z$0 = z;
                            this.J$0 = jCurrentTimeMillis;
                            this.I$0 = z2 ? 1 : 0;
                            this.I$1 = BooleanValue;
                            this.label = (byte) 4;
                            objFirst2 = StateFlowKt.first(flowPlaylist3, this);
                            if (objFirst2 == coroutineSingletons3) {
                                z2 = zBooleanValue;
                            } else {
                                LocalDateTime localDateTime7 = localDateTimeNow;
                                z3 = z;
                                r0 = BooleanValue;
                                mutablePreferences2 = mutablePreferences;
                                localDateTime = localDateTime7;
                                if (objFirst2 != null) {
                                    z2 = zBooleanValue;
                                    r10 = z2;
                                    i = 1;
                                } else {
                                    z2 = zBooleanValue;
                                    r10 = z2;
                                    i = 0;
                                }
                                MusicDatabase musicDatabase4 = statsViewModel.database;
                                musicDatabase4.getClass();
                                Flow flowPlaylist4 = musicDatabase4.$$delegate_0.playlist("LP_MONTHLY_MOST");
                                this.L$0 = mutex;
                                this.L$1 = statsViewModel;
                                this.L$2 = localDateTime;
                                this.L$3 = mutablePreferences2;
                                this.Z$0 = z3;
                                this.J$0 = jCurrentTimeMillis;
                                this.I$0 = r10;
                                this.I$1 = r0;
                                this.I$2 = i;
                                this.label = (byte) 5;
                                objFirst3 = StateFlowKt.first(flowPlaylist4, this);
                                if (objFirst3 != coroutineSingletons3) {
                                    z4 = z3;
                                    ?? r24 = r10;
                                    r11 = r0;
                                    mutablePreferences3 = mutablePreferences2;
                                    i2 = i;
                                    statsViewModel2 = statsViewModel;
                                    localDateTime2 = localDateTime;
                                    long j13 = jCurrentTimeMillis;
                                    mutex3 = mutex;
                                    i3 = r24 == true ? 1 : 0;
                                    j = j13;
                                    if (objFirst3 != null) {
                                        i4 = 1;
                                        z5 = true;
                                    } else {
                                        z5 = true;
                                        i4 = 0;
                                    }
                                    r28 = r11;
                                    if (z4) {
                                        z6 = z5;
                                    } else {
                                        z6 = z5;
                                    }
                                    if (z4) {
                                        coroutineSingletons3 = coroutineSingletons3;
                                        z7 = z5;
                                    } else {
                                        coroutineSingletons3 = coroutineSingletons3;
                                        z7 = z5;
                                    }
                                    if (z6) {
                                    }
                                    if (z6) {
                                        string = statsViewModel2.context.getString(R.string.weekly_most_playlist_name);
                                        string.getClass();
                                        localDateTime3 = StatPeriod.WEEK_1.toLocalDateTime();
                                        if (r28 != 0) {
                                            z8 = z5;
                                        } else {
                                            z8 = false;
                                        }
                                        localDateTime2.getClass();
                                        this.L$0 = mutex3;
                                        this.L$1 = statsViewModel2;
                                        this.L$2 = localDateTime2;
                                        statsViewModel4 = statsViewModel2;
                                        this.L$3 = null;
                                        this.Z$0 = z4;
                                        this.J$0 = j;
                                        this.I$0 = i3 == true ? 1 : 0;
                                        this.I$1 = r28 == true ? 1 : 0;
                                        this.I$2 = i2;
                                        this.I$3 = i4;
                                        this.I$4 = z6 ? 1 : 0;
                                        this.I$5 = z7 ? 1 : 0;
                                        this.label = (byte) 6;
                                        j3 = j;
                                        coroutineSingletons = coroutineSingletons3;
                                        if (statsViewModel4.syncMostPlaylist("LP_WEEKLY_MOST", string, localDateTime3, z8, localDateTime2, this) == coroutineSingletons) {
                                            return coroutineSingletons;
                                        }
                                        i6 = i2;
                                        i7 = z6 ? 1 : 0;
                                        i8 = r28 == true ? 1 : 0;
                                        z9 = z4;
                                        statsViewModel5 = statsViewModel4;
                                        localDateTime4 = localDateTime2;
                                        i9 = z7 ? 1 : 0;
                                        i10 = i3 == true ? 1 : 0;
                                        mutex4 = mutex3;
                                        j4 = j3;
                                        i5 = i8;
                                        Mutex mutex10 = mutex4;
                                        r12 = i9;
                                        statsViewModel3 = statsViewModel5;
                                        z4 = z9;
                                        i2 = i6;
                                        j2 = j4;
                                        i3 = i10;
                                        localDateTime2 = localDateTime4;
                                        mutex3 = mutex10;
                                        r9 = i7;
                                    } else {
                                        i5 = r28 == true ? 1 : 0;
                                        statsViewModel3 = statsViewModel2;
                                        long j14 = j;
                                        coroutineSingletons = coroutineSingletons3;
                                        j2 = j14;
                                    }
                                    if (r12 != 0) {
                                        r9 = z6;
                                        r12 = z7;
                                        CoroutineSingletons coroutineSingletons6 = coroutineSingletons;
                                        string2 = statsViewModel3.context.getString(R.string.monthly_most_playlist_name);
                                        string2.getClass();
                                        localDateTime5 = StatPeriod.MONTH_1.toLocalDateTime();
                                        if (i5 != 0) {
                                            z11 = z5;
                                        } else {
                                            z11 = false;
                                        }
                                        localDateTime2.getClass();
                                        this.L$0 = mutex3;
                                        this.L$1 = statsViewModel3;
                                        this.L$2 = null;
                                        this.L$3 = null;
                                        this.Z$0 = z4;
                                        this.J$0 = j2;
                                        this.I$0 = i3;
                                        this.I$1 = i5;
                                        this.I$2 = i2;
                                        this.I$3 = i4;
                                        this.I$4 = r9;
                                        this.I$5 = r12;
                                        this.label = (byte) 7;
                                        coroutineSingletons2 = coroutineSingletons6;
                                        j6 = j2;
                                        if (statsViewModel3.syncMostPlaylist("LP_MONTHLY_MOST", string2, localDateTime5, z11, localDateTime2, this) == coroutineSingletons2) {
                                            return coroutineSingletons2;
                                        }
                                        i11 = i2;
                                        r3 = r9;
                                        i15 = i5;
                                        i16 = i3;
                                        mutex5 = mutex3;
                                        i17 = i4;
                                        z12 = z4;
                                        j7 = j6;
                                        statsViewModel6 = statsViewModel3;
                                        r5 = r12;
                                        int i110 = i15;
                                        r4 = r5;
                                        statsViewModel3 = statsViewModel6;
                                        i13 = i17;
                                        r2 = r3;
                                        mutex2 = mutex5;
                                        z10 = z12;
                                        i14 = i16;
                                        i12 = i110 == true ? 1 : 0;
                                        j5 = j7;
                                    } else {
                                        r9 = z6;
                                        r12 = z7;
                                        long j15 = j2;
                                        unit = unit;
                                        coroutineSingletons2 = coroutineSingletons;
                                        i11 = i2;
                                        r2 = r9;
                                        r4 = r12;
                                        i12 = i5;
                                        mutex2 = mutex3;
                                        z10 = z4;
                                        j5 = j15;
                                        i13 = i4;
                                        i14 = i3;
                                    }
                                    if (!z10) {
                                        context = statsViewModel3.context;
                                        if (r2 != 0) {
                                            z13 = z5;
                                        } else {
                                            z13 = false;
                                        }
                                        if (r4 != 0) {
                                            z14 = z5;
                                        } else {
                                            z14 = false;
                                        }
                                        statsViewModel$syncMostPlaylistsIfNeeded$1$1$1 = new StatsViewModel$syncMostPlaylistsIfNeeded$1$1$1(z13, j5, z14, null);
                                        this.L$0 = mutex2;
                                        this.L$1 = null;
                                        this.L$2 = null;
                                        this.L$3 = null;
                                        this.J$0 = j5;
                                        this.I$0 = i14;
                                        this.I$1 = i12;
                                        this.I$2 = i11;
                                        this.I$3 = i13;
                                        this.I$4 = r2;
                                        this.I$5 = r4;
                                        this.label = (byte) 8;
                                        if (UtilsKt.safeDataStoreEdit(context, statsViewModel$syncMostPlaylistsIfNeeded$1$1$1, this) == coroutineSingletons2) {
                                            return coroutineSingletons2;
                                        }
                                    }
                                    mutex2.unlock(null);
                                    return unit;
                                }
                            }
                        }
                    }
                    return coroutineSingletons3;
                case 2:
                    long j16 = this.J$0;
                    z = this.Z$0;
                    localDateTimeNow = this.L$2;
                    statsViewModel = this.L$1;
                    Mutex mutex11 = this.L$0;
                    try {
                        ResultKt.throwOnFailure(obj);
                        jCurrentTimeMillis = j16;
                        mutex = mutex11;
                        objFirst = obj;
                        mutablePreferences = (MutablePreferences) objFirst;
                        bool = (Boolean) mutablePreferences.get(PreferenceKeysKt.HideVideoSongsKey);
                        if (bool != null) {
                            BooleanValue = bool.booleanValue();
                        } else {
                            BooleanValue = 0;
                        }
                        bool2 = (Boolean) mutablePreferences.get(PreferenceKeysKt.ShowMostStatsPlaylistsKey);
                        if (bool2 != null) {
                            zBooleanValue = bool2.booleanValue();
                        } else {
                            z2 = true;
                        }
                        if (z2) {
                            this.L$0 = mutex;
                            this.L$1 = null;
                            this.L$2 = null;
                            this.J$0 = jCurrentTimeMillis;
                            this.I$0 = z2 ? 1 : 0;
                            this.I$1 = BooleanValue;
                            this.label = (byte) 3;
                            objWithTransaction = statsViewModel.database.withTransaction(new Recomposer$join$2(c, null, (byte) 11), this);
                            if (objWithTransaction != coroutineSingletons3) {
                                objWithTransaction = unit;
                            }
                            if (objWithTransaction != coroutineSingletons3) {
                                z2 = zBooleanValue;
                                z2 = zBooleanValue;
                                mutex2 = mutex;
                                unit = unit;
                                mutex2.unlock(null);
                                return unit;
                            }
                            z2 = zBooleanValue;
                            z2 = zBooleanValue;
                        } else {
                            MusicDatabase musicDatabase5 = statsViewModel.database;
                            musicDatabase5.getClass();
                            Flow flowPlaylist5 = musicDatabase5.$$delegate_0.playlist("LP_WEEKLY_MOST");
                            this.L$0 = mutex;
                            this.L$1 = statsViewModel;
                            this.L$2 = localDateTimeNow;
                            this.L$3 = mutablePreferences;
                            this.Z$0 = z;
                            this.J$0 = jCurrentTimeMillis;
                            this.I$0 = z2 ? 1 : 0;
                            this.I$1 = BooleanValue;
                            this.label = (byte) 4;
                            objFirst2 = StateFlowKt.first(flowPlaylist5, this);
                            if (objFirst2 == coroutineSingletons3) {
                                z2 = zBooleanValue;
                            } else {
                                LocalDateTime localDateTime8 = localDateTimeNow;
                                z3 = z;
                                r0 = BooleanValue;
                                mutablePreferences2 = mutablePreferences;
                                localDateTime = localDateTime8;
                                if (objFirst2 != null) {
                                    z2 = zBooleanValue;
                                    r10 = z2;
                                    i = 1;
                                } else {
                                    z2 = zBooleanValue;
                                    r10 = z2;
                                    i = 0;
                                }
                                MusicDatabase musicDatabase6 = statsViewModel.database;
                                musicDatabase6.getClass();
                                Flow flowPlaylist6 = musicDatabase6.$$delegate_0.playlist("LP_MONTHLY_MOST");
                                this.L$0 = mutex;
                                this.L$1 = statsViewModel;
                                this.L$2 = localDateTime;
                                this.L$3 = mutablePreferences2;
                                this.Z$0 = z3;
                                this.J$0 = jCurrentTimeMillis;
                                this.I$0 = r10;
                                this.I$1 = r0;
                                this.I$2 = i;
                                this.label = (byte) 5;
                                objFirst3 = StateFlowKt.first(flowPlaylist6, this);
                                if (objFirst3 != coroutineSingletons3) {
                                    z4 = z3;
                                    ?? r25 = r10;
                                    r11 = r0;
                                    mutablePreferences3 = mutablePreferences2;
                                    i2 = i;
                                    statsViewModel2 = statsViewModel;
                                    localDateTime2 = localDateTime;
                                    long j17 = jCurrentTimeMillis;
                                    mutex3 = mutex;
                                    i3 = r25 == true ? 1 : 0;
                                    j = j17;
                                    if (objFirst3 != null) {
                                        i4 = 1;
                                        z5 = true;
                                    } else {
                                        z5 = true;
                                        i4 = 0;
                                    }
                                    r28 = r11;
                                    if (z4) {
                                        z6 = z5;
                                    } else {
                                        z6 = z5;
                                    }
                                    if (z4) {
                                        coroutineSingletons3 = coroutineSingletons3;
                                        z7 = z5;
                                    } else {
                                        coroutineSingletons3 = coroutineSingletons3;
                                        z7 = z5;
                                    }
                                    if (z6) {
                                    }
                                    if (z6) {
                                        string = statsViewModel2.context.getString(R.string.weekly_most_playlist_name);
                                        string.getClass();
                                        localDateTime3 = StatPeriod.WEEK_1.toLocalDateTime();
                                        if (r28 != 0) {
                                            z8 = z5;
                                        } else {
                                            z8 = false;
                                        }
                                        localDateTime2.getClass();
                                        this.L$0 = mutex3;
                                        this.L$1 = statsViewModel2;
                                        this.L$2 = localDateTime2;
                                        statsViewModel4 = statsViewModel2;
                                        this.L$3 = null;
                                        this.Z$0 = z4;
                                        this.J$0 = j;
                                        this.I$0 = i3 == true ? 1 : 0;
                                        this.I$1 = r28 == true ? 1 : 0;
                                        this.I$2 = i2;
                                        this.I$3 = i4;
                                        this.I$4 = z6 ? 1 : 0;
                                        this.I$5 = z7 ? 1 : 0;
                                        this.label = (byte) 6;
                                        j3 = j;
                                        coroutineSingletons = coroutineSingletons3;
                                        if (statsViewModel4.syncMostPlaylist("LP_WEEKLY_MOST", string, localDateTime3, z8, localDateTime2, this) == coroutineSingletons) {
                                            return coroutineSingletons;
                                        }
                                        i6 = i2;
                                        i7 = z6 ? 1 : 0;
                                        i8 = r28 == true ? 1 : 0;
                                        z9 = z4;
                                        statsViewModel5 = statsViewModel4;
                                        localDateTime4 = localDateTime2;
                                        i9 = z7 ? 1 : 0;
                                        i10 = i3 == true ? 1 : 0;
                                        mutex4 = mutex3;
                                        j4 = j3;
                                        i5 = i8;
                                        Mutex mutex12 = mutex4;
                                        r12 = i9;
                                        statsViewModel3 = statsViewModel5;
                                        z4 = z9;
                                        i2 = i6;
                                        j2 = j4;
                                        i3 = i10;
                                        localDateTime2 = localDateTime4;
                                        mutex3 = mutex12;
                                        r9 = i7;
                                    } else {
                                        i5 = r28 == true ? 1 : 0;
                                        statsViewModel3 = statsViewModel2;
                                        long j18 = j;
                                        coroutineSingletons = coroutineSingletons3;
                                        j2 = j18;
                                    }
                                    if (r12 != 0) {
                                        r9 = z6;
                                        r12 = z7;
                                        CoroutineSingletons coroutineSingletons7 = coroutineSingletons;
                                        string2 = statsViewModel3.context.getString(R.string.monthly_most_playlist_name);
                                        string2.getClass();
                                        localDateTime5 = StatPeriod.MONTH_1.toLocalDateTime();
                                        if (i5 != 0) {
                                            z11 = z5;
                                        } else {
                                            z11 = false;
                                        }
                                        localDateTime2.getClass();
                                        this.L$0 = mutex3;
                                        this.L$1 = statsViewModel3;
                                        this.L$2 = null;
                                        this.L$3 = null;
                                        this.Z$0 = z4;
                                        this.J$0 = j2;
                                        this.I$0 = i3;
                                        this.I$1 = i5;
                                        this.I$2 = i2;
                                        this.I$3 = i4;
                                        this.I$4 = r9;
                                        this.I$5 = r12;
                                        this.label = (byte) 7;
                                        coroutineSingletons2 = coroutineSingletons7;
                                        j6 = j2;
                                        if (statsViewModel3.syncMostPlaylist("LP_MONTHLY_MOST", string2, localDateTime5, z11, localDateTime2, this) == coroutineSingletons2) {
                                            return coroutineSingletons2;
                                        }
                                        i11 = i2;
                                        r3 = r9;
                                        i15 = i5;
                                        i16 = i3;
                                        mutex5 = mutex3;
                                        i17 = i4;
                                        z12 = z4;
                                        j7 = j6;
                                        statsViewModel6 = statsViewModel3;
                                        r5 = r12;
                                        int i111 = i15;
                                        r4 = r5;
                                        statsViewModel3 = statsViewModel6;
                                        i13 = i17;
                                        r2 = r3;
                                        mutex2 = mutex5;
                                        z10 = z12;
                                        i14 = i16;
                                        i12 = i111 == true ? 1 : 0;
                                        j5 = j7;
                                    } else {
                                        r9 = z6;
                                        r12 = z7;
                                        long j19 = j2;
                                        unit = unit;
                                        coroutineSingletons2 = coroutineSingletons;
                                        i11 = i2;
                                        r2 = r9;
                                        r4 = r12;
                                        i12 = i5;
                                        mutex2 = mutex3;
                                        z10 = z4;
                                        j5 = j19;
                                        i13 = i4;
                                        i14 = i3;
                                    }
                                    if (!z10) {
                                        context = statsViewModel3.context;
                                        if (r2 != 0) {
                                            z13 = z5;
                                        } else {
                                            z13 = false;
                                        }
                                        if (r4 != 0) {
                                            z14 = z5;
                                        } else {
                                            z14 = false;
                                        }
                                        statsViewModel$syncMostPlaylistsIfNeeded$1$1$1 = new StatsViewModel$syncMostPlaylistsIfNeeded$1$1$1(z13, j5, z14, null);
                                        this.L$0 = mutex2;
                                        this.L$1 = null;
                                        this.L$2 = null;
                                        this.L$3 = null;
                                        this.J$0 = j5;
                                        this.I$0 = i14;
                                        this.I$1 = i12;
                                        this.I$2 = i11;
                                        this.I$3 = i13;
                                        this.I$4 = r2;
                                        this.I$5 = r4;
                                        this.label = (byte) 8;
                                        if (UtilsKt.safeDataStoreEdit(context, statsViewModel$syncMostPlaylistsIfNeeded$1$1$1, this) == coroutineSingletons2) {
                                            return coroutineSingletons2;
                                        }
                                    }
                                    mutex2.unlock(null);
                                    return unit;
                                }
                            }
                        }
                        return coroutineSingletons3;
                    } catch (Throwable th2) {
                        th = th2;
                        r6 = mutex11;
                        obj2 = null;
                        r1 = r6;
                        r1.unlock(obj2);
                        throw th;
                    }
                case 3:
                    Mutex mutex13 = this.L$0;
                    ResultKt.throwOnFailure(obj);
                    mutex2 = mutex13;
                    unit = unit;
                    mutex2.unlock(null);
                    return unit;
                case 4:
                    int i20 = this.I$1;
                    int i21 = this.I$0;
                    long j20 = this.J$0;
                    z3 = this.Z$0;
                    MutablePreferences mutablePreferences4 = this.L$3;
                    LocalDateTime localDateTime9 = this.L$2;
                    StatsViewModel statsViewModel9 = this.L$1;
                    Mutex mutex14 = this.L$0;
                    try {
                        ResultKt.throwOnFailure(obj);
                        mutex = mutex14;
                        jCurrentTimeMillis = j20;
                        localDateTime = localDateTime9;
                        mutablePreferences2 = mutablePreferences4;
                        statsViewModel = statsViewModel9;
                        r10 = i21;
                        objFirst2 = obj;
                        r0 = i20;
                        if (objFirst2 != null) {
                            z2 = zBooleanValue;
                            r10 = z2;
                            i = 1;
                        } else {
                            z2 = zBooleanValue;
                            r10 = z2;
                            i = 0;
                        }
                        MusicDatabase musicDatabase7 = statsViewModel.database;
                        musicDatabase7.getClass();
                        Flow flowPlaylist7 = musicDatabase7.$$delegate_0.playlist("LP_MONTHLY_MOST");
                        this.L$0 = mutex;
                        this.L$1 = statsViewModel;
                        this.L$2 = localDateTime;
                        this.L$3 = mutablePreferences2;
                        this.Z$0 = z3;
                        this.J$0 = jCurrentTimeMillis;
                        this.I$0 = r10;
                        this.I$1 = r0;
                        this.I$2 = i;
                        this.label = (byte) 5;
                        objFirst3 = StateFlowKt.first(flowPlaylist7, this);
                        if (objFirst3 != coroutineSingletons3) {
                            z4 = z3;
                            ?? r26 = r10;
                            r11 = r0;
                            mutablePreferences3 = mutablePreferences2;
                            i2 = i;
                            statsViewModel2 = statsViewModel;
                            localDateTime2 = localDateTime;
                            long j110 = jCurrentTimeMillis;
                            mutex3 = mutex;
                            i3 = r26 == true ? 1 : 0;
                            j = j110;
                            if (objFirst3 != null) {
                                i4 = 1;
                                z5 = true;
                            } else {
                                z5 = true;
                                i4 = 0;
                            }
                            r28 = r11;
                            if (z4) {
                                z6 = z5;
                            } else {
                                z6 = z5;
                            }
                            if (z4) {
                                coroutineSingletons3 = coroutineSingletons3;
                                z7 = z5;
                            } else {
                                coroutineSingletons3 = coroutineSingletons3;
                                z7 = z5;
                            }
                            if (z6) {
                            }
                            if (z6) {
                                string = statsViewModel2.context.getString(R.string.weekly_most_playlist_name);
                                string.getClass();
                                localDateTime3 = StatPeriod.WEEK_1.toLocalDateTime();
                                if (r28 != 0) {
                                    z8 = z5;
                                } else {
                                    z8 = false;
                                }
                                localDateTime2.getClass();
                                this.L$0 = mutex3;
                                this.L$1 = statsViewModel2;
                                this.L$2 = localDateTime2;
                                statsViewModel4 = statsViewModel2;
                                this.L$3 = null;
                                this.Z$0 = z4;
                                this.J$0 = j;
                                this.I$0 = i3 == true ? 1 : 0;
                                this.I$1 = r28 == true ? 1 : 0;
                                this.I$2 = i2;
                                this.I$3 = i4;
                                this.I$4 = z6 ? 1 : 0;
                                this.I$5 = z7 ? 1 : 0;
                                this.label = (byte) 6;
                                j3 = j;
                                coroutineSingletons = coroutineSingletons3;
                                if (statsViewModel4.syncMostPlaylist("LP_WEEKLY_MOST", string, localDateTime3, z8, localDateTime2, this) == coroutineSingletons) {
                                    return coroutineSingletons;
                                }
                                i6 = i2;
                                i7 = z6 ? 1 : 0;
                                i8 = r28 == true ? 1 : 0;
                                z9 = z4;
                                statsViewModel5 = statsViewModel4;
                                localDateTime4 = localDateTime2;
                                i9 = z7 ? 1 : 0;
                                i10 = i3 == true ? 1 : 0;
                                mutex4 = mutex3;
                                j4 = j3;
                                i5 = i8;
                                Mutex mutex15 = mutex4;
                                r12 = i9;
                                statsViewModel3 = statsViewModel5;
                                z4 = z9;
                                i2 = i6;
                                j2 = j4;
                                i3 = i10;
                                localDateTime2 = localDateTime4;
                                mutex3 = mutex15;
                                r9 = i7;
                            } else {
                                i5 = r28 == true ? 1 : 0;
                                statsViewModel3 = statsViewModel2;
                                long j111 = j;
                                coroutineSingletons = coroutineSingletons3;
                                j2 = j111;
                            }
                            if (r12 != 0) {
                                r9 = z6;
                                r12 = z7;
                                CoroutineSingletons coroutineSingletons8 = coroutineSingletons;
                                string2 = statsViewModel3.context.getString(R.string.monthly_most_playlist_name);
                                string2.getClass();
                                localDateTime5 = StatPeriod.MONTH_1.toLocalDateTime();
                                if (i5 != 0) {
                                    z11 = z5;
                                } else {
                                    z11 = false;
                                }
                                localDateTime2.getClass();
                                this.L$0 = mutex3;
                                this.L$1 = statsViewModel3;
                                this.L$2 = null;
                                this.L$3 = null;
                                this.Z$0 = z4;
                                this.J$0 = j2;
                                this.I$0 = i3;
                                this.I$1 = i5;
                                this.I$2 = i2;
                                this.I$3 = i4;
                                this.I$4 = r9;
                                this.I$5 = r12;
                                this.label = (byte) 7;
                                coroutineSingletons2 = coroutineSingletons8;
                                j6 = j2;
                                if (statsViewModel3.syncMostPlaylist("LP_MONTHLY_MOST", string2, localDateTime5, z11, localDateTime2, this) == coroutineSingletons2) {
                                    return coroutineSingletons2;
                                }
                                i11 = i2;
                                r3 = r9;
                                i15 = i5;
                                i16 = i3;
                                mutex5 = mutex3;
                                i17 = i4;
                                z12 = z4;
                                j7 = j6;
                                statsViewModel6 = statsViewModel3;
                                r5 = r12;
                                int i112 = i15;
                                r4 = r5;
                                statsViewModel3 = statsViewModel6;
                                i13 = i17;
                                r2 = r3;
                                mutex2 = mutex5;
                                z10 = z12;
                                i14 = i16;
                                i12 = i112 == true ? 1 : 0;
                                j5 = j7;
                            } else {
                                r9 = z6;
                                r12 = z7;
                                long j112 = j2;
                                unit = unit;
                                coroutineSingletons2 = coroutineSingletons;
                                i11 = i2;
                                r2 = r9;
                                r4 = r12;
                                i12 = i5;
                                mutex2 = mutex3;
                                z10 = z4;
                                j5 = j112;
                                i13 = i4;
                                i14 = i3;
                            }
                            if (!z10) {
                                context = statsViewModel3.context;
                                if (r2 != 0) {
                                    z13 = z5;
                                } else {
                                    z13 = false;
                                }
                                if (r4 != 0) {
                                    z14 = z5;
                                } else {
                                    z14 = false;
                                }
                                statsViewModel$syncMostPlaylistsIfNeeded$1$1$1 = new StatsViewModel$syncMostPlaylistsIfNeeded$1$1$1(z13, j5, z14, null);
                                this.L$0 = mutex2;
                                this.L$1 = null;
                                this.L$2 = null;
                                this.L$3 = null;
                                this.J$0 = j5;
                                this.I$0 = i14;
                                this.I$1 = i12;
                                this.I$2 = i11;
                                this.I$3 = i13;
                                this.I$4 = r2;
                                this.I$5 = r4;
                                this.label = (byte) 8;
                                if (UtilsKt.safeDataStoreEdit(context, statsViewModel$syncMostPlaylistsIfNeeded$1$1$1, this) == coroutineSingletons2) {
                                    return coroutineSingletons2;
                                }
                            }
                            mutex2.unlock(null);
                            return unit;
                        }
                        return coroutineSingletons3;
                    } catch (Throwable th3) {
                        th = th3;
                        r6 = mutex14;
                        obj2 = null;
                        r1 = r6;
                        r1.unlock(obj2);
                        throw th;
                    }
                case 5:
                    int i22 = this.I$2;
                    int i23 = this.I$1;
                    int i24 = this.I$0;
                    long j21 = this.J$0;
                    boolean z16 = this.Z$0;
                    MutablePreferences mutablePreferences5 = this.L$3;
                    LocalDateTime localDateTime10 = this.L$2;
                    StatsViewModel statsViewModel10 = this.L$1;
                    mutex3 = this.L$0;
                    try {
                        ResultKt.throwOnFailure(obj);
                        i2 = i22;
                        mutablePreferences3 = mutablePreferences5;
                        objFirst3 = obj;
                        z4 = z16;
                        localDateTime2 = localDateTime10;
                        r11 = i23;
                        statsViewModel2 = statsViewModel10;
                        i3 = i24;
                        j = j21;
                        if (objFirst3 != null) {
                            i4 = 1;
                            z5 = true;
                        } else {
                            z5 = true;
                            i4 = 0;
                        }
                        r28 = r11;
                        if (z4) {
                            z6 = z5;
                        } else {
                            z6 = z5;
                        }
                        if (z4) {
                            coroutineSingletons3 = coroutineSingletons3;
                            z7 = z5;
                        } else {
                            coroutineSingletons3 = coroutineSingletons3;
                            z7 = z5;
                        }
                        if (z6) {
                        }
                        if (z6) {
                            string = statsViewModel2.context.getString(R.string.weekly_most_playlist_name);
                            string.getClass();
                            localDateTime3 = StatPeriod.WEEK_1.toLocalDateTime();
                            if (r28 != 0) {
                                z8 = z5;
                            } else {
                                z8 = false;
                            }
                            localDateTime2.getClass();
                            this.L$0 = mutex3;
                            this.L$1 = statsViewModel2;
                            this.L$2 = localDateTime2;
                            statsViewModel4 = statsViewModel2;
                            this.L$3 = null;
                            this.Z$0 = z4;
                            this.J$0 = j;
                            this.I$0 = i3 == true ? 1 : 0;
                            this.I$1 = r28 == true ? 1 : 0;
                            this.I$2 = i2;
                            this.I$3 = i4;
                            this.I$4 = z6 ? 1 : 0;
                            this.I$5 = z7 ? 1 : 0;
                            this.label = (byte) 6;
                            j3 = j;
                            coroutineSingletons = coroutineSingletons3;
                            if (statsViewModel4.syncMostPlaylist("LP_WEEKLY_MOST", string, localDateTime3, z8, localDateTime2, this) == coroutineSingletons) {
                                return coroutineSingletons;
                            }
                            i6 = i2;
                            i7 = z6 ? 1 : 0;
                            i8 = r28 == true ? 1 : 0;
                            z9 = z4;
                            statsViewModel5 = statsViewModel4;
                            localDateTime4 = localDateTime2;
                            i9 = z7 ? 1 : 0;
                            i10 = i3 == true ? 1 : 0;
                            mutex4 = mutex3;
                            j4 = j3;
                            i5 = i8;
                            Mutex mutex16 = mutex4;
                            r12 = i9;
                            statsViewModel3 = statsViewModel5;
                            z4 = z9;
                            i2 = i6;
                            j2 = j4;
                            i3 = i10;
                            localDateTime2 = localDateTime4;
                            mutex3 = mutex16;
                            r9 = i7;
                        } else {
                            i5 = r28 == true ? 1 : 0;
                            statsViewModel3 = statsViewModel2;
                            long j113 = j;
                            coroutineSingletons = coroutineSingletons3;
                            j2 = j113;
                        }
                        if (r12 != 0) {
                            r9 = z6;
                            r12 = z7;
                            CoroutineSingletons coroutineSingletons9 = coroutineSingletons;
                            string2 = statsViewModel3.context.getString(R.string.monthly_most_playlist_name);
                            string2.getClass();
                            localDateTime5 = StatPeriod.MONTH_1.toLocalDateTime();
                            if (i5 != 0) {
                                z11 = z5;
                            } else {
                                z11 = false;
                            }
                            localDateTime2.getClass();
                            this.L$0 = mutex3;
                            this.L$1 = statsViewModel3;
                            this.L$2 = null;
                            this.L$3 = null;
                            this.Z$0 = z4;
                            this.J$0 = j2;
                            this.I$0 = i3;
                            this.I$1 = i5;
                            this.I$2 = i2;
                            this.I$3 = i4;
                            this.I$4 = r9;
                            this.I$5 = r12;
                            this.label = (byte) 7;
                            coroutineSingletons2 = coroutineSingletons9;
                            j6 = j2;
                            if (statsViewModel3.syncMostPlaylist("LP_MONTHLY_MOST", string2, localDateTime5, z11, localDateTime2, this) == coroutineSingletons2) {
                                return coroutineSingletons2;
                            }
                            i11 = i2;
                            r3 = r9;
                            i15 = i5;
                            i16 = i3;
                            mutex5 = mutex3;
                            i17 = i4;
                            z12 = z4;
                            j7 = j6;
                            statsViewModel6 = statsViewModel3;
                            r5 = r12;
                            int i113 = i15;
                            r4 = r5;
                            statsViewModel3 = statsViewModel6;
                            i13 = i17;
                            r2 = r3;
                            mutex2 = mutex5;
                            z10 = z12;
                            i14 = i16;
                            i12 = i113 == true ? 1 : 0;
                            j5 = j7;
                        } else {
                            r9 = z6;
                            r12 = z7;
                            long j114 = j2;
                            unit = unit;
                            coroutineSingletons2 = coroutineSingletons;
                            i11 = i2;
                            r2 = r9;
                            r4 = r12;
                            i12 = i5;
                            mutex2 = mutex3;
                            z10 = z4;
                            j5 = j114;
                            i13 = i4;
                            i14 = i3;
                        }
                        if (!z10) {
                            context = statsViewModel3.context;
                            if (r2 != 0) {
                                z13 = z5;
                            } else {
                                z13 = false;
                            }
                            if (r4 != 0) {
                                z14 = z5;
                            } else {
                                z14 = false;
                            }
                            statsViewModel$syncMostPlaylistsIfNeeded$1$1$1 = new StatsViewModel$syncMostPlaylistsIfNeeded$1$1$1(z13, j5, z14, null);
                            this.L$0 = mutex2;
                            this.L$1 = null;
                            this.L$2 = null;
                            this.L$3 = null;
                            this.J$0 = j5;
                            this.I$0 = i14;
                            this.I$1 = i12;
                            this.I$2 = i11;
                            this.I$3 = i13;
                            this.I$4 = r2;
                            this.I$5 = r4;
                            this.label = (byte) 8;
                            if (UtilsKt.safeDataStoreEdit(context, statsViewModel$syncMostPlaylistsIfNeeded$1$1$1, this) == coroutineSingletons2) {
                                return coroutineSingletons2;
                            }
                        }
                        mutex2.unlock(null);
                        return unit;
                    } catch (Throwable th4) {
                        th = th4;
                        r6 = mutex3;
                        obj2 = null;
                        r1 = r6;
                        r1.unlock(obj2);
                        throw th;
                    }
                case 6:
                    i9 = this.I$5;
                    i7 = this.I$4;
                    int i25 = this.I$3;
                    i6 = this.I$2;
                    i8 = this.I$1;
                    i10 = this.I$0;
                    j4 = this.J$0;
                    z9 = this.Z$0;
                    LocalDateTime localDateTime11 = this.L$2;
                    statsViewModel5 = this.L$1;
                    mutex4 = this.L$0;
                    try {
                        ResultKt.throwOnFailure(obj);
                        z5 = true;
                        localDateTime4 = localDateTime11;
                        i4 = i25;
                        coroutineSingletons = coroutineSingletons3;
                        i5 = i8;
                        Mutex mutex17 = mutex4;
                        r12 = i9;
                        statsViewModel3 = statsViewModel5;
                        z4 = z9;
                        i2 = i6;
                        j2 = j4;
                        i3 = i10;
                        localDateTime2 = localDateTime4;
                        mutex3 = mutex17;
                        r9 = i7;
                        if (r12 != 0) {
                            r9 = z6;
                            r12 = z7;
                            CoroutineSingletons coroutineSingletons10 = coroutineSingletons;
                            string2 = statsViewModel3.context.getString(R.string.monthly_most_playlist_name);
                            string2.getClass();
                            localDateTime5 = StatPeriod.MONTH_1.toLocalDateTime();
                            if (i5 != 0) {
                                z11 = z5;
                            } else {
                                z11 = false;
                            }
                            localDateTime2.getClass();
                            this.L$0 = mutex3;
                            this.L$1 = statsViewModel3;
                            this.L$2 = null;
                            this.L$3 = null;
                            this.Z$0 = z4;
                            this.J$0 = j2;
                            this.I$0 = i3;
                            this.I$1 = i5;
                            this.I$2 = i2;
                            this.I$3 = i4;
                            this.I$4 = r9;
                            this.I$5 = r12;
                            this.label = (byte) 7;
                            coroutineSingletons2 = coroutineSingletons10;
                            j6 = j2;
                            if (statsViewModel3.syncMostPlaylist("LP_MONTHLY_MOST", string2, localDateTime5, z11, localDateTime2, this) == coroutineSingletons2) {
                                return coroutineSingletons2;
                            }
                            i11 = i2;
                            r3 = r9;
                            i15 = i5;
                            i16 = i3;
                            mutex5 = mutex3;
                            i17 = i4;
                            z12 = z4;
                            j7 = j6;
                            statsViewModel6 = statsViewModel3;
                            r5 = r12;
                            int i114 = i15;
                            r4 = r5;
                            statsViewModel3 = statsViewModel6;
                            i13 = i17;
                            r2 = r3;
                            mutex2 = mutex5;
                            z10 = z12;
                            i14 = i16;
                            i12 = i114 == true ? 1 : 0;
                            j5 = j7;
                        } else {
                            r9 = z6;
                            r12 = z7;
                            long j115 = j2;
                            unit = unit;
                            coroutineSingletons2 = coroutineSingletons;
                            i11 = i2;
                            r2 = r9;
                            r4 = r12;
                            i12 = i5;
                            mutex2 = mutex3;
                            z10 = z4;
                            j5 = j115;
                            i13 = i4;
                            i14 = i3;
                        }
                        if (!z10) {
                            context = statsViewModel3.context;
                            if (r2 != 0) {
                                z13 = z5;
                            } else {
                                z13 = false;
                            }
                            if (r4 != 0) {
                                z14 = z5;
                            } else {
                                z14 = false;
                            }
                            statsViewModel$syncMostPlaylistsIfNeeded$1$1$1 = new StatsViewModel$syncMostPlaylistsIfNeeded$1$1$1(z13, j5, z14, null);
                            this.L$0 = mutex2;
                            this.L$1 = null;
                            this.L$2 = null;
                            this.L$3 = null;
                            this.J$0 = j5;
                            this.I$0 = i14;
                            this.I$1 = i12;
                            this.I$2 = i11;
                            this.I$3 = i13;
                            this.I$4 = r2;
                            this.I$5 = r4;
                            this.label = (byte) 8;
                            if (UtilsKt.safeDataStoreEdit(context, statsViewModel$syncMostPlaylistsIfNeeded$1$1$1, this) == coroutineSingletons2) {
                                return coroutineSingletons2;
                            }
                        }
                        mutex2.unlock(null);
                        return unit;
                    } catch (Throwable th5) {
                        th = th5;
                        r6 = mutex4;
                        obj2 = null;
                        r1 = r6;
                        r1.unlock(obj2);
                        throw th;
                    }
                case 7:
                    int i26 = this.I$5;
                    int i27 = this.I$4;
                    i17 = this.I$3;
                    i11 = this.I$2;
                    i15 = this.I$1;
                    i16 = this.I$0;
                    j7 = this.J$0;
                    z12 = this.Z$0;
                    statsViewModel6 = this.L$1;
                    mutex5 = this.L$0;
                    try {
                        ResultKt.throwOnFailure(obj);
                        z5 = true;
                        coroutineSingletons2 = coroutineSingletons3;
                        r5 = i26;
                        r3 = i27;
                        int i115 = i15;
                        r4 = r5;
                        statsViewModel3 = statsViewModel6;
                        i13 = i17;
                        r2 = r3;
                        mutex2 = mutex5;
                        z10 = z12;
                        i14 = i16;
                        i12 = i115 == true ? 1 : 0;
                        j5 = j7;
                        if (!z10) {
                            context = statsViewModel3.context;
                            if (r2 != 0) {
                                z13 = z5;
                            } else {
                                z13 = false;
                            }
                            if (r4 != 0) {
                                z14 = z5;
                            } else {
                                z14 = false;
                            }
                            statsViewModel$syncMostPlaylistsIfNeeded$1$1$1 = new StatsViewModel$syncMostPlaylistsIfNeeded$1$1$1(z13, j5, z14, null);
                            this.L$0 = mutex2;
                            this.L$1 = null;
                            this.L$2 = null;
                            this.L$3 = null;
                            this.J$0 = j5;
                            this.I$0 = i14;
                            this.I$1 = i12;
                            this.I$2 = i11;
                            this.I$3 = i13;
                            this.I$4 = r2;
                            this.I$5 = r4;
                            this.label = (byte) 8;
                            if (UtilsKt.safeDataStoreEdit(context, statsViewModel$syncMostPlaylistsIfNeeded$1$1$1, this) == coroutineSingletons2) {
                                return coroutineSingletons2;
                            }
                        }
                        mutex2.unlock(null);
                        return unit;
                    } catch (Throwable th6) {
                        th = th6;
                        mutex6 = mutex5;
                        obj2 = null;
                        r1 = mutex6;
                        r1.unlock(obj2);
                        throw th;
                    }
                case 8:
                    mutex6 = this.L$0;
                    try {
                        ResultKt.throwOnFailure(obj);
                        mutex2 = mutex6;
                        unit = unit;
                        mutex2.unlock(null);
                        return unit;
                    } catch (Throwable th7) {
                        th = th7;
                        obj2 = null;
                        r1 = mutex6;
                        r1.unlock(obj2);
                        throw th;
                    }
                default:
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
            }
        } catch (Throwable th8) {
            th = th8;
        }
    }
}
