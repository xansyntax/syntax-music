package com.metrolist.music.eq.data;

import android.content.SharedPreferences;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__IndentKt$$ExternalSyntheticLambda0;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.serialization.internal.HashSetSerializer;
import kotlinx.serialization.json.JsonImpl;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class EQProfileRepository$deleteProfile$2 extends SuspendLambda implements Function2 {
    public final /* synthetic */ String $profileId;
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ EQProfileRepository this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ EQProfileRepository$deleteProfile$2(EQProfileRepository eQProfileRepository, String str, Continuation continuation, byte b) {
        super(2, continuation);
        this.$r8$classId = b;
        this.this$0 = eQProfileRepository;
        this.$profileId = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        byte b = this.$r8$classId;
        String str = this.$profileId;
        EQProfileRepository eQProfileRepository = this.this$0;
        switch (b) {
            case 0:
                return new EQProfileRepository$deleteProfile$2(eQProfileRepository, str, continuation, (byte) 0);
            default:
                return new EQProfileRepository$deleteProfile$2(eQProfileRepository, str, continuation, (byte) 1);
        }
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        CoroutineScope coroutineScope = (CoroutineScope) obj;
        Continuation continuation = (Continuation) obj2;
        switch (b) {
            case 0:
                ((EQProfileRepository$deleteProfile$2) create(coroutineScope, continuation)).invokeSuspend(unit);
                break;
            default:
                ((EQProfileRepository$deleteProfile$2) create(coroutineScope, continuation)).invokeSuspend(unit);
                break;
        }
        return unit;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        String str = this.$profileId;
        EQProfileRepository eQProfileRepository = this.this$0;
        Object obj2 = null;
        switch (b) {
            case 0:
                ResultKt.throwOnFailure(obj);
                ArrayList mutableList = CollectionsKt.toMutableList((Collection) eQProfileRepository._profiles.getValue());
                CollectionsKt__MutableCollectionsKt.removeAll(mutableList, new StringsKt__IndentKt$$ExternalSyntheticLambda0(str, (byte) 13));
                JsonImpl jsonImpl = eQProfileRepository.json;
                jsonImpl.getClass();
                String strEncodeToString = jsonImpl.encodeToString(new HashSetSerializer(SavedEQProfile.INSTANCE.serializer(), (byte) 1), mutableList);
                SharedPreferences sharedPreferences = eQProfileRepository.prefs;
                SharedPreferences.Editor editorEdit = sharedPreferences.edit();
                editorEdit.putString("eq_profiles", strEncodeToString);
                editorEdit.apply();
                StateFlowImpl stateFlowImpl = eQProfileRepository._activeProfile;
                SavedEQProfile savedEQProfile = (SavedEQProfile) stateFlowImpl.getValue();
                if (Intrinsics.areEqual(savedEQProfile != null ? savedEQProfile.id : null, str)) {
                    stateFlowImpl.setValue(null);
                    SharedPreferences.Editor editorEdit2 = sharedPreferences.edit();
                    editorEdit2.remove("active_profile_id");
                    editorEdit2.apply();
                }
                StateFlowImpl stateFlowImpl2 = eQProfileRepository._profiles;
                stateFlowImpl2.getClass();
                stateFlowImpl2.updateState(null, mutableList);
                break;
            default:
                ResultKt.throwOnFailure(obj);
                SharedPreferences sharedPreferences2 = eQProfileRepository.prefs;
                StateFlowImpl stateFlowImpl3 = eQProfileRepository._activeProfile;
                List list = (List) eQProfileRepository._profiles.getValue();
                if (str == null) {
                    stateFlowImpl3.setValue(null);
                    SharedPreferences.Editor editorEdit3 = sharedPreferences2.edit();
                    editorEdit3.remove("active_profile_id");
                    editorEdit3.apply();
                } else {
                    for (Object obj3 : list) {
                        if (Intrinsics.areEqual(((SavedEQProfile) obj3).id, str)) {
                            obj2 = obj3;
                            stateFlowImpl3.setValue((SavedEQProfile) obj2);
                            SharedPreferences.Editor editorEdit4 = sharedPreferences2.edit();
                            editorEdit4.putString("active_profile_id", str);
                            editorEdit4.apply();
                            break;
                        }
                    }
                    stateFlowImpl3.setValue((SavedEQProfile) obj2);
                    SharedPreferences.Editor editorEdit5 = sharedPreferences2.edit();
                    editorEdit5.putString("active_profile_id", str);
                    editorEdit5.apply();
                }
                break;
        }
        return unit;
    }
}
