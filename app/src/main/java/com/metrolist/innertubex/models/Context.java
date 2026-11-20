package com.metrolist.innertubex.models;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import com.metrolist.lastfm.LastFM$$ExternalSyntheticLambda1;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.internal.EnumsKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\b\u0087\b\u0018\u0000 \u00022\u00020\u0001:\u0006\u0003\u0004\u0005\u0006\u0007\u0002¨\u0006\b"}, d2 = {"Lcom/metrolist/innertubex/models/Context;", "", "Companion", "Client", "ThirdParty", "Request", "User", "$serializer", "com.github.MetrolistGroup:innertubex"}, k = 1, mv = {2, 4, 0}, xi = 48)
@Serializable
public final /* data */ class Context {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion();
    public final Client client;
    public final Request request;
    public final ThirdParty thirdParty;
    public final User user;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/metrolist/innertubex/models/Context$Companion;", "", "Lkotlinx/serialization/KSerializer;", "Lcom/metrolist/innertubex/models/Context;", "serializer", "()Lkotlinx/serialization/KSerializer;", "com.github.MetrolistGroup:innertubex"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final class Companion {
        public final KSerializer serializer() {
            return Context$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ Context(int i, Client client, ThirdParty thirdParty, Request request, User user) {
        if (1 != (i & 1)) {
            EnumsKt.throwMissingFieldException(Context$$serializer.INSTANCE.getDescriptor(), i, 1);
            throw null;
        }
        this.client = client;
        if ((i & 2) == 0) {
            this.thirdParty = null;
        } else {
            this.thirdParty = thirdParty;
        }
        if ((i & 4) == 0) {
            this.request = new Request();
        } else {
            this.request = request;
        }
        if ((i & 8) == 0) {
            this.user = new User(null, 3);
        } else {
            this.user = user;
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Context)) {
            return false;
        }
        Context context = (Context) obj;
        return Intrinsics.areEqual(this.client, context.client) && Intrinsics.areEqual(this.thirdParty, context.thirdParty) && Intrinsics.areEqual(this.request, context.request) && Intrinsics.areEqual(this.user, context.user);
    }

    public final int hashCode() {
        int iHashCode = this.client.hashCode() * 31;
        ThirdParty thirdParty = this.thirdParty;
        return this.user.hashCode() + ((this.request.hashCode() + ((iHashCode + (thirdParty == null ? 0 : thirdParty.embedUrl.hashCode())) * 31)) * 31);
    }

    public final String toString() {
        return "Context(client=" + this.client + ", thirdParty=" + this.thirdParty + ", request=" + this.request + ", user=" + this.user + ")";
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u0000 \u00022\u00020\u0001:\u0002\u0003\u0002¨\u0006\u0004"}, d2 = {"Lcom/metrolist/innertubex/models/Context$User;", "", "Companion", "$serializer", "com.github.MetrolistGroup:innertubex"}, k = 1, mv = {2, 4, 0}, xi = 48)
    @Serializable
    public static final /* data */ class User {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion();
        public final boolean lockedSafetyMode;
        public final String onBehalfOfUser;

        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/metrolist/innertubex/models/Context$User$Companion;", "", "Lkotlinx/serialization/KSerializer;", "Lcom/metrolist/innertubex/models/Context$User;", "serializer", "()Lkotlinx/serialization/KSerializer;", "com.github.MetrolistGroup:innertubex"}, k = 1, mv = {2, 4, 0}, xi = 48)
        public static final class Companion {
            public final KSerializer serializer() {
                return Context$User$$serializer.INSTANCE;
            }
        }

        public /* synthetic */ User(String str, int i, boolean z) {
            this.lockedSafetyMode = (i & 1) == 0 ? false : z;
            if ((i & 2) == 0) {
                this.onBehalfOfUser = null;
            } else {
                this.onBehalfOfUser = str;
            }
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof User)) {
                return false;
            }
            User user = (User) obj;
            return this.lockedSafetyMode == user.lockedSafetyMode && Intrinsics.areEqual(this.onBehalfOfUser, user.onBehalfOfUser);
        }

        public final int hashCode() {
            int iHashCode = Boolean.hashCode(this.lockedSafetyMode) * 31;
            String str = this.onBehalfOfUser;
            return iHashCode + (str == null ? 0 : str.hashCode());
        }

        public final String toString() {
            return "User(lockedSafetyMode=" + this.lockedSafetyMode + ", onBehalfOfUser=" + this.onBehalfOfUser + ")";
        }

        public User(String str, int i) {
            str = (i & 2) != 0 ? null : str;
            this.lockedSafetyMode = false;
            this.onBehalfOfUser = str;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u0000 \u00022\u00020\u0001:\u0002\u0003\u0002¨\u0006\u0004"}, d2 = {"Lcom/metrolist/innertubex/models/Context$Request;", "", "Companion", "$serializer", "com.github.MetrolistGroup:innertubex"}, k = 1, mv = {2, 4, 0}, xi = 48)
    @Serializable
    public static final /* data */ class Request {
        public final List internalExperimentFlags;
        public final boolean useSsl;

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion();
        public static final Lazy[] $childSerializers = {ResultKt.lazy(LazyThreadSafetyMode.PUBLICATION, new LastFM$$ExternalSyntheticLambda1((byte) 1)), null};

        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/metrolist/innertubex/models/Context$Request$Companion;", "", "Lkotlinx/serialization/KSerializer;", "Lcom/metrolist/innertubex/models/Context$Request;", "serializer", "()Lkotlinx/serialization/KSerializer;", "com.github.MetrolistGroup:innertubex"}, k = 1, mv = {2, 4, 0}, xi = 48)
        public static final class Companion {
            public final KSerializer serializer() {
                return Context$Request$$serializer.INSTANCE;
            }
        }

        public /* synthetic */ Request(int i, List list, boolean z) {
            this.internalExperimentFlags = (i & 1) == 0 ? EmptyList.INSTANCE : list;
            if ((i & 2) == 0) {
                this.useSsl = true;
            } else {
                this.useSsl = z;
            }
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Request)) {
                return false;
            }
            Request request = (Request) obj;
            return Intrinsics.areEqual(this.internalExperimentFlags, request.internalExperimentFlags) && this.useSsl == request.useSsl;
        }

        public final int hashCode() {
            return Boolean.hashCode(this.useSsl) + (this.internalExperimentFlags.hashCode() * 31);
        }

        public final String toString() {
            return "Request(internalExperimentFlags=" + this.internalExperimentFlags + ", useSsl=" + this.useSsl + ")";
        }

        public Request() {
            this.internalExperimentFlags = EmptyList.INSTANCE;
            this.useSsl = true;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u0000 \u00022\u00020\u0001:\u0002\u0003\u0002¨\u0006\u0004"}, d2 = {"Lcom/metrolist/innertubex/models/Context$ThirdParty;", "", "Companion", "$serializer", "com.github.MetrolistGroup:innertubex"}, k = 1, mv = {2, 4, 0}, xi = 48)
    @Serializable
    public static final /* data */ class ThirdParty {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion();
        public final String embedUrl;

        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/metrolist/innertubex/models/Context$ThirdParty$Companion;", "", "Lkotlinx/serialization/KSerializer;", "Lcom/metrolist/innertubex/models/Context$ThirdParty;", "serializer", "()Lkotlinx/serialization/KSerializer;", "com.github.MetrolistGroup:innertubex"}, k = 1, mv = {2, 4, 0}, xi = 48)
        public static final class Companion {
            public final KSerializer serializer() {
                return Context$ThirdParty$$serializer.INSTANCE;
            }
        }

        public /* synthetic */ ThirdParty(int i, String str) {
            if (1 == (i & 1)) {
                this.embedUrl = str;
            } else {
                EnumsKt.throwMissingFieldException(Context$ThirdParty$$serializer.INSTANCE.getDescriptor(), i, 1);
                throw null;
            }
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof ThirdParty) && Intrinsics.areEqual(this.embedUrl, ((ThirdParty) obj).embedUrl);
        }

        public final int hashCode() {
            return this.embedUrl.hashCode();
        }

        public final String toString() {
            return IntIntPair$$ExternalSyntheticOutline0.m("ThirdParty(embedUrl=", this.embedUrl, ")");
        }

        public ThirdParty() {
            this.embedUrl = "https://www.reddit.com/";
        }
    }

    public Context(Client client, ThirdParty thirdParty, User user) {
        Request request = new Request();
        this.client = client;
        this.thirdParty = thirdParty;
        this.request = request;
        this.user = user;
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u0000 \u00022\u00020\u0001:\u0002\u0003\u0002¨\u0006\u0004"}, d2 = {"Lcom/metrolist/innertubex/models/Context$Client;", "", "Companion", "$serializer", "com.github.MetrolistGroup:innertubex"}, k = 1, mv = {2, 4, 0}, xi = 48)
    @Serializable
    public static final /* data */ class Client {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion();
        public final String androidSdkVersion;
        public final String clientName;
        public final String clientVersion;
        public final String deviceMake;
        public final String deviceModel;
        public final String gl;
        public final String hl;
        public final String osName;
        public final String osVersion;
        public final String platform;
        public final String userAgent;
        public final String visitorData;

        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/metrolist/innertubex/models/Context$Client$Companion;", "", "Lkotlinx/serialization/KSerializer;", "Lcom/metrolist/innertubex/models/Context$Client;", "serializer", "()Lkotlinx/serialization/KSerializer;", "com.github.MetrolistGroup:innertubex"}, k = 1, mv = {2, 4, 0}, xi = 48)
        public static final class Companion {
            public final KSerializer serializer() {
                return Context$Client$$serializer.INSTANCE;
            }
        }

        public /* synthetic */ Client(int i, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12) {
            if (3587 != (i & 3587)) {
                EnumsKt.throwMissingFieldException(Context$Client$$serializer.INSTANCE.getDescriptor(), i, 3587);
                throw null;
            }
            this.clientName = str;
            this.clientVersion = str2;
            if ((i & 4) == 0) {
                this.userAgent = null;
            } else {
                this.userAgent = str3;
            }
            if ((i & 8) == 0) {
                this.osName = null;
            } else {
                this.osName = str4;
            }
            if ((i & 16) == 0) {
                this.osVersion = null;
            } else {
                this.osVersion = str5;
            }
            if ((i & 32) == 0) {
                this.deviceMake = null;
            } else {
                this.deviceMake = str6;
            }
            if ((i & 64) == 0) {
                this.deviceModel = null;
            } else {
                this.deviceModel = str7;
            }
            if ((i & 128) == 0) {
                this.androidSdkVersion = null;
            } else {
                this.androidSdkVersion = str8;
            }
            if ((i & 256) == 0) {
                this.platform = null;
            } else {
                this.platform = str9;
            }
            this.gl = str10;
            this.hl = str11;
            this.visitorData = str12;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Client)) {
                return false;
            }
            Client client = (Client) obj;
            return Intrinsics.areEqual(this.clientName, client.clientName) && Intrinsics.areEqual(this.clientVersion, client.clientVersion) && Intrinsics.areEqual(this.userAgent, client.userAgent) && Intrinsics.areEqual(this.osName, client.osName) && Intrinsics.areEqual(this.osVersion, client.osVersion) && Intrinsics.areEqual(this.deviceMake, client.deviceMake) && Intrinsics.areEqual(this.deviceModel, client.deviceModel) && Intrinsics.areEqual(this.androidSdkVersion, client.androidSdkVersion) && Intrinsics.areEqual(this.platform, client.platform) && Intrinsics.areEqual(this.gl, client.gl) && Intrinsics.areEqual(this.hl, client.hl) && Intrinsics.areEqual(this.visitorData, client.visitorData);
        }

        public final int hashCode() {
            int iM = Fragment$5$$ExternalSyntheticOutline0.m(this.clientName.hashCode() * 31, 31, this.clientVersion);
            String str = this.userAgent;
            int iHashCode = (iM + (str == null ? 0 : str.hashCode())) * 31;
            String str2 = this.osName;
            int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.osVersion;
            int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
            String str4 = this.deviceMake;
            int iHashCode4 = (iHashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
            String str5 = this.deviceModel;
            int iHashCode5 = (iHashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31;
            String str6 = this.androidSdkVersion;
            int iHashCode6 = (iHashCode5 + (str6 == null ? 0 : str6.hashCode())) * 31;
            String str7 = this.platform;
            int iM2 = Fragment$5$$ExternalSyntheticOutline0.m(Fragment$5$$ExternalSyntheticOutline0.m((iHashCode6 + (str7 == null ? 0 : str7.hashCode())) * 31, 31, this.gl), 31, this.hl);
            String str8 = this.visitorData;
            return iM2 + (str8 != null ? str8.hashCode() : 0);
        }

        public final String toString() {
            StringBuilder sbM = IntIntPair$$ExternalSyntheticOutline0.m("Client(clientName=", this.clientName, ", clientVersion=", this.clientVersion, ", userAgent=");
            IntIntPair$$ExternalSyntheticOutline0.m6m(sbM, this.userAgent, ", osName=", this.osName, ", osVersion=");
            IntIntPair$$ExternalSyntheticOutline0.m6m(sbM, this.osVersion, ", deviceMake=", this.deviceMake, ", deviceModel=");
            IntIntPair$$ExternalSyntheticOutline0.m6m(sbM, this.deviceModel, ", androidSdkVersion=", this.androidSdkVersion, ", platform=");
            IntIntPair$$ExternalSyntheticOutline0.m6m(sbM, this.platform, ", gl=", this.gl, ", hl=");
            return IntIntPair$$ExternalSyntheticOutline0.m(sbM, this.hl, ", visitorData=", this.visitorData, ")");
        }

        public Client(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12) {
            str.getClass();
            str2.getClass();
            str10.getClass();
            str11.getClass();
            this.clientName = str;
            this.clientVersion = str2;
            this.userAgent = str3;
            this.osName = str4;
            this.osVersion = str5;
            this.deviceMake = str6;
            this.deviceModel = str7;
            this.androidSdkVersion = str8;
            this.platform = str9;
            this.gl = str10;
            this.hl = str11;
            this.visitorData = str12;
        }
    }
}
