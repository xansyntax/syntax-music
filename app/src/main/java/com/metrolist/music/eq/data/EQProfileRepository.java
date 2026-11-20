package com.metrolist.music.eq.data;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.List;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.Intrinsics;
import kotlin.uuid.UuidKt;
import kotlinx.coroutines.flow.ReadonlyStateFlow;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.StateFlowKt;
import kotlinx.serialization.internal.HashSetSerializer;
import kotlinx.serialization.json.JsonImpl;
import okhttp3.ConnectionPool;
import timber.log.Timber;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class EQProfileRepository {
    public final StateFlowImpl _activeProfile;
    public final StateFlowImpl _profiles;
    public final ReadonlyStateFlow activeProfile;
    public final JsonImpl json;
    public final SharedPreferences prefs;
    public final ReadonlyStateFlow profiles;

    public EQProfileRepository(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("nanosonic_eq_profiles", 0);
        sharedPreferences.getClass();
        this.prefs = sharedPreferences;
        JsonImpl jsonImplJson$default = UuidKt.Json$default(new GitHubAutoEqSearch$$ExternalSyntheticLambda0((byte) 1));
        this.json = jsonImplJson$default;
        EmptyList emptyList = EmptyList.INSTANCE;
        StateFlowImpl stateFlowImplMutableStateFlow = StateFlowKt.MutableStateFlow(emptyList);
        this._profiles = stateFlowImplMutableStateFlow;
        this.profiles = StateFlowKt.asStateFlow(stateFlowImplMutableStateFlow);
        StateFlowImpl stateFlowImplMutableStateFlow2 = StateFlowKt.MutableStateFlow(null);
        this._activeProfile = stateFlowImplMutableStateFlow2;
        this.activeProfile = StateFlowKt.asStateFlow(stateFlowImplMutableStateFlow2);
        try {
            String string = sharedPreferences.getString("eq_profiles", null);
            if (string != null) {
                List list = (List) jsonImplJson$default.decodeFromString(new HashSetSerializer(SavedEQProfile.INSTANCE.serializer(), (byte) 1), string);
                stateFlowImplMutableStateFlow.setValue(list);
                String string2 = sharedPreferences.getString("active_profile_id", null);
                for (Object obj : list) {
                    if (Intrinsics.areEqual(((SavedEQProfile) obj).id, string2)) {
                        stateFlowImplMutableStateFlow2.setValue(obj);
                    }
                }
                obj = null;
                stateFlowImplMutableStateFlow2.setValue(obj);
            }
        } catch (Exception unused) {
            Timber.Forest.tag("EQProfileRepository");
            ConnectionPool.e$1(new Object[0]);
            stateFlowImplMutableStateFlow.updateState(null, emptyList);
            stateFlowImplMutableStateFlow2.setValue(null);
        }
    }
}
