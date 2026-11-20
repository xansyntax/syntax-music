package com.metrolist.innertubex.models.body;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import com.metrolist.innertubex.models.Context;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.internal.EnumsKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0081\b\u0018\u0000 \u00022\u00020\u0001:\u0002\u0003\u0002¨\u0006\u0004"}, d2 = {"Lcom/metrolist/innertubex/models/body/AccountsListBody;", "", "Companion", "$serializer", "com.github.MetrolistGroup:innertubex"}, k = 1, mv = {2, 4, 0}, xi = 48)
@Serializable
public final /* data */ class AccountsListBody {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion();
    public final String callCircumstance;
    public final Context context;
    public final String requestType;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/metrolist/innertubex/models/body/AccountsListBody$Companion;", "", "Lkotlinx/serialization/KSerializer;", "Lcom/metrolist/innertubex/models/body/AccountsListBody;", "serializer", "()Lkotlinx/serialization/KSerializer;", "com.github.MetrolistGroup:innertubex"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final class Companion {
        public final KSerializer serializer() {
            return AccountsListBody$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ AccountsListBody(int i, Context context, String str, String str2) {
        if (1 != (i & 1)) {
            EnumsKt.throwMissingFieldException(AccountsListBody$$serializer.INSTANCE.getDescriptor(), i, 1);
            throw null;
        }
        this.context = context;
        if ((i & 2) == 0) {
            this.requestType = "ACCOUNTS_LIST_REQUEST_TYPE_CHANNEL_SWITCHER";
        } else {
            this.requestType = str;
        }
        if ((i & 4) == 0) {
            this.callCircumstance = "SWITCHING_USERS_FULL";
        } else {
            this.callCircumstance = str2;
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AccountsListBody)) {
            return false;
        }
        AccountsListBody accountsListBody = (AccountsListBody) obj;
        return Intrinsics.areEqual(this.context, accountsListBody.context) && Intrinsics.areEqual(this.requestType, accountsListBody.requestType) && Intrinsics.areEqual(this.callCircumstance, accountsListBody.callCircumstance);
    }

    public final int hashCode() {
        return this.callCircumstance.hashCode() + Fragment$5$$ExternalSyntheticOutline0.m(this.context.hashCode() * 31, 31, this.requestType);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("AccountsListBody(context=");
        sb.append(this.context);
        sb.append(", requestType=");
        sb.append(this.requestType);
        sb.append(", callCircumstance=");
        return IntIntPair$$ExternalSyntheticOutline0.m(sb, this.callCircumstance, ")");
    }

    public AccountsListBody(Context context) {
        this.context = context;
        this.requestType = "ACCOUNTS_LIST_REQUEST_TYPE_CHANNEL_SWITCHER";
        this.callCircumstance = "SWITCHING_USERS_FULL";
    }
}
