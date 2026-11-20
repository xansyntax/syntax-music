package com.metrolist.music.db.daos;

import androidx.room.RoomDatabase;
import androidx.room.coroutines.FlowUtil$createFlow$$inlined$map$1;
import coil3.util.LifecyclesKt;
import com.dokar.quickjs.QuickJs$$ExternalSyntheticLambda1;
import com.metrolist.music.db.DatabaseDao_Impl;
import com.metrolist.music.db.DatabaseDao_Impl$$ExternalSyntheticLambda7;
import com.metrolist.music.db.entities.SpeedDialItem;
import kotlin.Unit;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.text.StringsKt__IndentKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class SpeedDialDao_Impl {
    public final RoomDatabase __db;
    public final DatabaseDao_Impl.AnonymousClass1 __insertAdapterOfSpeedDialItem = new DatabaseDao_Impl.AnonymousClass1(18);

    public SpeedDialDao_Impl(RoomDatabase roomDatabase) {
        this.__db = roomDatabase;
    }

    public final Object delete(String str, SuspendLambda suspendLambda) {
        Object objPerformSuspending = DatabaseDao_Impl.AnonymousClass17.performSuspending(this.__db, false, true, new StringsKt__IndentKt$$ExternalSyntheticLambda0(str, (byte) 11), suspendLambda);
        return objPerformSuspending == CoroutineSingletons.COROUTINE_SUSPENDED ? objPerformSuspending : Unit.INSTANCE;
    }

    public final FlowUtil$createFlow$$inlined$map$1 getAll() {
        DatabaseDao_Impl$$ExternalSyntheticLambda7 databaseDao_Impl$$ExternalSyntheticLambda7 = new DatabaseDao_Impl$$ExternalSyntheticLambda7((byte) 5);
        return LifecyclesKt.createFlow(this.__db, false, new String[]{"speed_dial_item"}, databaseDao_Impl$$ExternalSyntheticLambda7);
    }

    public final Object insert(SpeedDialItem speedDialItem, SuspendLambda suspendLambda) {
        Object objPerformSuspending = DatabaseDao_Impl.AnonymousClass17.performSuspending(this.__db, false, true, new QuickJs$$ExternalSyntheticLambda1(this, speedDialItem, (byte) 20), suspendLambda);
        return objPerformSuspending == CoroutineSingletons.COROUTINE_SUSPENDED ? objPerformSuspending : Unit.INSTANCE;
    }

    public final FlowUtil$createFlow$$inlined$map$1 isPinned(String str) {
        str.getClass();
        StringsKt__IndentKt$$ExternalSyntheticLambda0 stringsKt__IndentKt$$ExternalSyntheticLambda0 = new StringsKt__IndentKt$$ExternalSyntheticLambda0(str, (byte) 10);
        return LifecyclesKt.createFlow(this.__db, false, new String[]{"speed_dial_item"}, stringsKt__IndentKt$$ExternalSyntheticLambda0);
    }
}
