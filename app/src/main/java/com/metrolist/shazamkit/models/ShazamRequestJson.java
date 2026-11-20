package com.metrolist.shazamkit.models;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.EnumsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u0000 62\u00020\u0001:\u00043456B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bBA\b\u0010\u0012\u0006\u0010\f\u001a\u00020\r\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\n\u0010\u0010J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u0005HÆ\u0003J\t\u0010\"\u001a\u00020\u0007HÆ\u0003J\t\u0010#\u001a\u00020\tHÆ\u0003J1\u0010$\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0014\u0010%\u001a\u00020&2\b\u0010'\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010(\u001a\u00020\rHÖ\u0081\u0004J\n\u0010)\u001a\u00020\tHÖ\u0081\u0004J)\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020\u00002\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u000200H\u0001b\u0002\b2¢\u0006\u0002\b1R*\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004r\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0002¢\u0006\u000e\n\u0000\u0012\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R*\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004r\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0017\u0010\u0012\u001a\u0004\b\u0018\u0010\u0019R*\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004r\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0006¢\u0006\u000e\n\u0000\u0012\u0004\b\u001a\u0010\u0012\u001a\u0004\b\u001b\u0010\u001cR*\u0010\b\u001a\u00020\t8\u0006X\u0087\u0004r\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\b¢\u0006\u000e\n\u0000\u0012\u0004\b\u001d\u0010\u0012\u001a\u0004\b\u001e\u0010\u001fÊ\u0001\u0002\b8Ê\u0001\f\b9\u0012\b\b:\u0012\u0004\b\u0003\u0010\u0002¨\u00067"}, d2 = {"Lcom/metrolist/shazamkit/models/ShazamRequestJson;", "", "geolocation", "Lcom/metrolist/shazamkit/models/ShazamRequestJson$Geolocation;", "signature", "Lcom/metrolist/shazamkit/models/ShazamRequestJson$Signature;", "timestamp", "", "timezone", "", "<init>", "(Lcom/metrolist/shazamkit/models/ShazamRequestJson$Geolocation;Lcom/metrolist/shazamkit/models/ShazamRequestJson$Signature;JLjava/lang/String;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILcom/metrolist/shazamkit/models/ShazamRequestJson$Geolocation;Lcom/metrolist/shazamkit/models/ShazamRequestJson$Signature;JLjava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getGeolocation$annotations", "()V", "getGeolocation", "()Lcom/metrolist/shazamkit/models/ShazamRequestJson$Geolocation;", "Lkotlinx/serialization/SerialName;", "value", "getSignature$annotations", "getSignature", "()Lcom/metrolist/shazamkit/models/ShazamRequestJson$Signature;", "getTimestamp$annotations", "getTimestamp", "()J", "getTimezone$annotations", "getTimezone", "()Ljava/lang/String;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$app", "Lkotlin/jvm/JvmStatic;", "Geolocation", "Signature", "$serializer", "Companion", "app", "Lkotlinx/serialization/Serializable;", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
@Serializable
public final /* data */ class ShazamRequestJson {
    public static final int $stable = 0;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final Geolocation geolocation;
    private final Signature signature;
    private final long timestamp;
    private final String timezone;

    public /* synthetic */ ShazamRequestJson(int i, Geolocation geolocation, Signature signature, long j, String str, SerializationConstructorMarker serializationConstructorMarker) {
        if (15 != (i & 15)) {
            EnumsKt.throwMissingFieldException(ShazamRequestJson$$serializer.INSTANCE.getDescriptor(), i, 15);
            throw null;
        }
        this.geolocation = geolocation;
        this.signature = signature;
        this.timestamp = j;
        this.timezone = str;
    }

    public static /* synthetic */ ShazamRequestJson copy$default(ShazamRequestJson shazamRequestJson, Geolocation geolocation, Signature signature, long j, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            geolocation = shazamRequestJson.geolocation;
        }
        if ((i & 2) != 0) {
            signature = shazamRequestJson.signature;
        }
        if ((i & 4) != 0) {
            j = shazamRequestJson.timestamp;
        }
        if ((i & 8) != 0) {
            str = shazamRequestJson.timezone;
        }
        String str2 = str;
        return shazamRequestJson.copy(geolocation, signature, j, str2);
    }

    public static final /* synthetic */ void write$Self$app(ShazamRequestJson self, CompositeEncoder output, SerialDescriptor serialDesc) {
        output.encodeSerializableElement(serialDesc, 0, ShazamRequestJson$Geolocation$$serializer.INSTANCE, self.geolocation);
        output.encodeSerializableElement(serialDesc, 1, ShazamRequestJson$Signature$$serializer.INSTANCE, self.signature);
        output.encodeLongElement(serialDesc, 2, self.timestamp);
        output.encodeStringElement(serialDesc, 3, self.timezone);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Geolocation getGeolocation() {
        return this.geolocation;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Signature getSignature() {
        return this.signature;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final long getTimestamp() {
        return this.timestamp;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getTimezone() {
        return this.timezone;
    }

    public final ShazamRequestJson copy(Geolocation geolocation, Signature signature, long timestamp, String timezone) {
        geolocation.getClass();
        signature.getClass();
        timezone.getClass();
        return new ShazamRequestJson(geolocation, signature, timestamp, timezone);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ShazamRequestJson)) {
            return false;
        }
        ShazamRequestJson shazamRequestJson = (ShazamRequestJson) other;
        return Intrinsics.areEqual(this.geolocation, shazamRequestJson.geolocation) && Intrinsics.areEqual(this.signature, shazamRequestJson.signature) && this.timestamp == shazamRequestJson.timestamp && Intrinsics.areEqual(this.timezone, shazamRequestJson.timezone);
    }

    public final Geolocation getGeolocation() {
        return this.geolocation;
    }

    public final Signature getSignature() {
        return this.signature;
    }

    public final long getTimestamp() {
        return this.timestamp;
    }

    public final String getTimezone() {
        return this.timezone;
    }

    public int hashCode() {
        return this.timezone.hashCode() + IntIntPair$$ExternalSyntheticOutline0.m((this.signature.hashCode() + (this.geolocation.hashCode() * 31)) * 31, 31, this.timestamp);
    }

    public String toString() {
        return "ShazamRequestJson(geolocation=" + this.geolocation + ", signature=" + this.signature + ", timestamp=" + this.timestamp + ", timezone=" + this.timezone + ")";
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u0000 +2\u00020\u0001:\u0002*+B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007B3\b\u0010\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\u0006\u0010\fJ\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J'\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u001e\u001a\u00020\tHÖ\u0081\u0004J\n\u0010\u001f\u001a\u00020 HÖ\u0081\u0004J)\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u00002\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'H\u0001b\u0002\b)¢\u0006\u0002\b(R*\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004r\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0002¢\u0006\u000e\n\u0000\u0012\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R*\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004r\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0013\u0010\u000e\u001a\u0004\b\u0014\u0010\u0010R*\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004r\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0005¢\u0006\u000e\n\u0000\u0012\u0004\b\u0015\u0010\u000e\u001a\u0004\b\u0016\u0010\u0010Ê\u0001\u0002\b-Ê\u0001\f\b.\u0012\b\b/\u0012\u0004\b\u0003\u0010\u0002¨\u0006,"}, d2 = {"Lcom/metrolist/shazamkit/models/ShazamRequestJson$Geolocation;", "", "altitude", "", "latitude", "longitude", "<init>", "(DDD)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IDDDLkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getAltitude$annotations", "()V", "getAltitude", "()D", "Lkotlinx/serialization/SerialName;", "value", "getLatitude$annotations", "getLatitude", "getLongitude$annotations", "getLongitude", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$app", "Lkotlin/jvm/JvmStatic;", "$serializer", "Companion", "app", "Lkotlinx/serialization/Serializable;", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
    @Serializable
    public static final /* data */ class Geolocation {
        public static final int $stable = 0;

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final double altitude;
        private final double latitude;
        private final double longitude;

        public /* synthetic */ Geolocation(int i, double d, double d2, double d3, SerializationConstructorMarker serializationConstructorMarker) {
            if (7 != (i & 7)) {
                EnumsKt.throwMissingFieldException(ShazamRequestJson$Geolocation$$serializer.INSTANCE.getDescriptor(), i, 7);
                throw null;
            }
            this.altitude = d;
            this.latitude = d2;
            this.longitude = d3;
        }

        public static /* synthetic */ Geolocation copy$default(Geolocation geolocation, double d, double d2, double d3, int i, Object obj) {
            if ((i & 1) != 0) {
                d = geolocation.altitude;
            }
            double d4 = d;
            if ((i & 2) != 0) {
                d2 = geolocation.latitude;
            }
            double d5 = d2;
            if ((i & 4) != 0) {
                d3 = geolocation.longitude;
            }
            return geolocation.copy(d4, d5, d3);
        }

        public static final /* synthetic */ void write$Self$app(Geolocation self, CompositeEncoder output, SerialDescriptor serialDesc) {
            output.encodeDoubleElement(serialDesc, 0, self.altitude);
            output.encodeDoubleElement(serialDesc, 1, self.latitude);
            output.encodeDoubleElement(serialDesc, 2, self.longitude);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final double getAltitude() {
            return this.altitude;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final double getLatitude() {
            return this.latitude;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final double getLongitude() {
            return this.longitude;
        }

        public final Geolocation copy(double altitude, double latitude, double longitude) {
            return new Geolocation(altitude, latitude, longitude);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Geolocation)) {
                return false;
            }
            Geolocation geolocation = (Geolocation) other;
            return Double.compare(this.altitude, geolocation.altitude) == 0 && Double.compare(this.latitude, geolocation.latitude) == 0 && Double.compare(this.longitude, geolocation.longitude) == 0;
        }

        public final double getAltitude() {
            return this.altitude;
        }

        public final double getLatitude() {
            return this.latitude;
        }

        public final double getLongitude() {
            return this.longitude;
        }

        public int hashCode() {
            return Double.hashCode(this.longitude) + Fragment$5$$ExternalSyntheticOutline0.m(this.latitude, Double.hashCode(this.altitude) * 31, 31);
        }

        public String toString() {
            return "Geolocation(altitude=" + this.altitude + ", latitude=" + this.latitude + ", longitude=" + this.longitude + ")";
        }

        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lcom/metrolist/shazamkit/models/ShazamRequestJson$Geolocation$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/metrolist/shazamkit/models/ShazamRequestJson$Geolocation;", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final KSerializer serializer() {
                return ShazamRequestJson$Geolocation$$serializer.INSTANCE;
            }

            private Companion() {
            }
        }

        public static /* synthetic */ void getAltitude$annotations() {
        }

        public static /* synthetic */ void getLatitude$annotations() {
        }

        public static /* synthetic */ void getLongitude$annotations() {
        }

        public Geolocation(double d, double d2, double d3) {
            this.altitude = d;
            this.latitude = d2;
            this.longitude = d3;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u0000 ,2\u00020\u0001:\u0002+,B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bB5\b\u0010\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\u0007\u0010\rJ\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0006HÆ\u0003J'\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0014\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010 \u001a\u00020\nHÖ\u0081\u0004J\n\u0010!\u001a\u00020\u0006HÖ\u0081\u0004J)\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u00002\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(H\u0001b\u0002\b*¢\u0006\u0002\b)R*\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004r\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0002¢\u0006\u000e\n\u0000\u0012\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R*\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004r\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0014\u0010\u000f\u001a\u0004\b\u0015\u0010\u0011R*\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004r\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0005¢\u0006\u000e\n\u0000\u0012\u0004\b\u0016\u0010\u000f\u001a\u0004\b\u0017\u0010\u0018Ê\u0001\u0002\b.Ê\u0001\f\b/\u0012\b\b0\u0012\u0004\b\u0003\u0010\u0002¨\u0006-"}, d2 = {"Lcom/metrolist/shazamkit/models/ShazamRequestJson$Signature;", "", "samplems", "", "timestamp", "uri", "", "<init>", "(JJLjava/lang/String;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IJJLjava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getSamplems$annotations", "()V", "getSamplems", "()J", "Lkotlinx/serialization/SerialName;", "value", "getTimestamp$annotations", "getTimestamp", "getUri$annotations", "getUri", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$app", "Lkotlin/jvm/JvmStatic;", "$serializer", "Companion", "app", "Lkotlinx/serialization/Serializable;", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
    @Serializable
    public static final /* data */ class Signature {
        public static final int $stable = 0;

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final long samplems;
        private final long timestamp;
        private final String uri;

        public /* synthetic */ Signature(int i, long j, long j2, String str, SerializationConstructorMarker serializationConstructorMarker) {
            if (7 != (i & 7)) {
                EnumsKt.throwMissingFieldException(ShazamRequestJson$Signature$$serializer.INSTANCE.getDescriptor(), i, 7);
                throw null;
            }
            this.samplems = j;
            this.timestamp = j2;
            this.uri = str;
        }

        public static /* synthetic */ Signature copy$default(Signature signature, long j, long j2, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                j = signature.samplems;
            }
            long j3 = j;
            if ((i & 2) != 0) {
                j2 = signature.timestamp;
            }
            long j4 = j2;
            if ((i & 4) != 0) {
                str = signature.uri;
            }
            return signature.copy(j3, j4, str);
        }

        public static final /* synthetic */ void write$Self$app(Signature self, CompositeEncoder output, SerialDescriptor serialDesc) {
            output.encodeLongElement(serialDesc, 0, self.samplems);
            output.encodeLongElement(serialDesc, 1, self.timestamp);
            output.encodeStringElement(serialDesc, 2, self.uri);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final long getSamplems() {
            return this.samplems;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final long getTimestamp() {
            return this.timestamp;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getUri() {
            return this.uri;
        }

        public final Signature copy(long samplems, long timestamp, String uri) {
            uri.getClass();
            return new Signature(samplems, timestamp, uri);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Signature)) {
                return false;
            }
            Signature signature = (Signature) other;
            return this.samplems == signature.samplems && this.timestamp == signature.timestamp && Intrinsics.areEqual(this.uri, signature.uri);
        }

        public final long getSamplems() {
            return this.samplems;
        }

        public final long getTimestamp() {
            return this.timestamp;
        }

        public final String getUri() {
            return this.uri;
        }

        public int hashCode() {
            return this.uri.hashCode() + IntIntPair$$ExternalSyntheticOutline0.m(Long.hashCode(this.samplems) * 31, 31, this.timestamp);
        }

        public String toString() {
            long j = this.samplems;
            long j2 = this.timestamp;
            String str = this.uri;
            StringBuilder sbM = Fragment$5$$ExternalSyntheticOutline0.m(j, "Signature(samplems=", ", timestamp=");
            sbM.append(j2);
            sbM.append(", uri=");
            sbM.append(str);
            sbM.append(")");
            return sbM.toString();
        }

        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lcom/metrolist/shazamkit/models/ShazamRequestJson$Signature$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/metrolist/shazamkit/models/ShazamRequestJson$Signature;", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final KSerializer serializer() {
                return ShazamRequestJson$Signature$$serializer.INSTANCE;
            }

            private Companion() {
            }
        }

        public static /* synthetic */ void getSamplems$annotations() {
        }

        public static /* synthetic */ void getTimestamp$annotations() {
        }

        public static /* synthetic */ void getUri$annotations() {
        }

        public Signature(long j, long j2, String str) {
            str.getClass();
            this.samplems = j;
            this.timestamp = j2;
            this.uri = str;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lcom/metrolist/shazamkit/models/ShazamRequestJson$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/metrolist/shazamkit/models/ShazamRequestJson;", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer serializer() {
            return ShazamRequestJson$$serializer.INSTANCE;
        }

        private Companion() {
        }
    }

    public static /* synthetic */ void getGeolocation$annotations() {
    }

    public static /* synthetic */ void getSignature$annotations() {
    }

    public static /* synthetic */ void getTimestamp$annotations() {
    }

    public static /* synthetic */ void getTimezone$annotations() {
    }

    public ShazamRequestJson(Geolocation geolocation, Signature signature, long j, String str) {
        geolocation.getClass();
        signature.getClass();
        str.getClass();
        this.geolocation = geolocation;
        this.signature = signature;
        this.timestamp = j;
        this.timezone = str;
    }
}
