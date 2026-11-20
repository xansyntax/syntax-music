package com.metrolist.innertube.models;

import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.internal.EnumsKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0087\b\u0018\u0000 \u00022\u00020\u0001:\u0003\u0003\u0004\u0002¨\u0006\u0005"}, d2 = {"Lcom/metrolist/innertube/models/ResponseContext;", "", "Companion", "ServiceTrackingParam", "$serializer", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
@Serializable
public final /* data */ class ResponseContext {
    public final List serviceTrackingParams;
    public final String visitorData;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion();
    public static final Lazy[] $childSerializers = {null, ResultKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Runs$$ExternalSyntheticLambda0(22))};

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/metrolist/innertube/models/ResponseContext$Companion;", "", "Lkotlinx/serialization/KSerializer;", "Lcom/metrolist/innertube/models/ResponseContext;", "serializer", "()Lkotlinx/serialization/KSerializer;", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final class Companion {
        public final KSerializer serializer() {
            return ResponseContext$$serializer.INSTANCE;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0087\b\u0018\u0000 \u00022\u00020\u0001:\u0003\u0003\u0004\u0002¨\u0006\u0005"}, d2 = {"Lcom/metrolist/innertube/models/ResponseContext$ServiceTrackingParam;", "", "Companion", "Param", "$serializer", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
    @Serializable
    public static final /* data */ class ServiceTrackingParam {
        public final List params;
        public final String service;

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion();
        public static final Lazy[] $childSerializers = {ResultKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Runs$$ExternalSyntheticLambda0(23)), null};

        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/metrolist/innertube/models/ResponseContext$ServiceTrackingParam$Companion;", "", "Lkotlinx/serialization/KSerializer;", "Lcom/metrolist/innertube/models/ResponseContext$ServiceTrackingParam;", "serializer", "()Lkotlinx/serialization/KSerializer;", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
        public static final class Companion {
            public final KSerializer serializer() {
                return ResponseContext$ServiceTrackingParam$$serializer.INSTANCE;
            }
        }

        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u0000 \u00022\u00020\u0001:\u0002\u0003\u0002¨\u0006\u0004"}, d2 = {"Lcom/metrolist/innertube/models/ResponseContext$ServiceTrackingParam$Param;", "", "Companion", "$serializer", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
        @Serializable
        public static final /* data */ class Param {

            /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
            public static final Companion INSTANCE = new Companion();
            public final String key;
            public final String value;

            /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
            @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/metrolist/innertube/models/ResponseContext$ServiceTrackingParam$Param$Companion;", "", "Lkotlinx/serialization/KSerializer;", "Lcom/metrolist/innertube/models/ResponseContext$ServiceTrackingParam$Param;", "serializer", "()Lkotlinx/serialization/KSerializer;", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
            public static final class Companion {
                public final KSerializer serializer() {
                    return ResponseContext$ServiceTrackingParam$Param$$serializer.INSTANCE;
                }
            }

            public /* synthetic */ Param(int i, String str, String str2) {
                if (3 != (i & 3)) {
                    EnumsKt.throwMissingFieldException(ResponseContext$ServiceTrackingParam$Param$$serializer.INSTANCE.getDescriptor(), i, 3);
                    throw null;
                }
                this.key = str;
                this.value = str2;
            }

            public final boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof Param)) {
                    return false;
                }
                Param param = (Param) obj;
                return Intrinsics.areEqual(this.key, param.key) && Intrinsics.areEqual(this.value, param.value);
            }

            public final int hashCode() {
                return this.value.hashCode() + (this.key.hashCode() * 31);
            }

            public final String toString() {
                return Fragment$5$$ExternalSyntheticOutline0.m("Param(key=", this.key, ", value=", this.value, ")");
            }
        }

        public /* synthetic */ ServiceTrackingParam(String str, int i, List list) {
            if (3 != (i & 3)) {
                EnumsKt.throwMissingFieldException(ResponseContext$ServiceTrackingParam$$serializer.INSTANCE.getDescriptor(), i, 3);
                throw null;
            }
            this.params = list;
            this.service = str;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ServiceTrackingParam)) {
                return false;
            }
            ServiceTrackingParam serviceTrackingParam = (ServiceTrackingParam) obj;
            return Intrinsics.areEqual(this.params, serviceTrackingParam.params) && Intrinsics.areEqual(this.service, serviceTrackingParam.service);
        }

        public final int hashCode() {
            return this.service.hashCode() + (this.params.hashCode() * 31);
        }

        public final String toString() {
            return "ServiceTrackingParam(params=" + this.params + ", service=" + this.service + ")";
        }
    }

    public /* synthetic */ ResponseContext(String str, int i, List list) {
        if (3 != (i & 3)) {
            EnumsKt.throwMissingFieldException(ResponseContext$$serializer.INSTANCE.getDescriptor(), i, 3);
            throw null;
        }
        this.visitorData = str;
        this.serviceTrackingParams = list;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ResponseContext)) {
            return false;
        }
        ResponseContext responseContext = (ResponseContext) obj;
        return Intrinsics.areEqual(this.visitorData, responseContext.visitorData) && Intrinsics.areEqual(this.serviceTrackingParams, responseContext.serviceTrackingParams);
    }

    public final int hashCode() {
        String str = this.visitorData;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        List list = this.serviceTrackingParams;
        return iHashCode + (list != null ? list.hashCode() : 0);
    }

    public final String toString() {
        return "ResponseContext(visitorData=" + this.visitorData + ", serviceTrackingParams=" + this.serviceTrackingParams + ")";
    }
}
