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
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\b\u0081\b\u0018\u0000 \u00022\u00020\u0001:\u0005\u0003\u0004\u0005\u0006\u0002¨\u0006\u0007"}, d2 = {"Lcom/metrolist/innertubex/models/body/PlayerBody;", "", "Companion", "PlaybackContext", "ServiceIntegrityDimensions", "ThirdParty", "$serializer", "com.github.MetrolistGroup:innertubex"}, k = 1, mv = {2, 4, 0}, xi = 48)
@Serializable
public final /* data */ class PlayerBody {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion();
    public final boolean contentCheckOk;
    public final Context context;
    public final PlaybackContext playbackContext;
    public final String playlistId;
    public final boolean racyCheckOk;
    public final ServiceIntegrityDimensions serviceIntegrityDimensions;
    public final ThirdParty thirdParty;
    public final Boolean videoCheckOk;
    public final String videoId;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/metrolist/innertubex/models/body/PlayerBody$Companion;", "", "Lkotlinx/serialization/KSerializer;", "Lcom/metrolist/innertubex/models/body/PlayerBody;", "serializer", "()Lkotlinx/serialization/KSerializer;", "com.github.MetrolistGroup:innertubex"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final class Companion {
        public final KSerializer serializer() {
            return PlayerBody$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ PlayerBody(int i, Context context, String str, String str2, PlaybackContext playbackContext, ThirdParty thirdParty, ServiceIntegrityDimensions serviceIntegrityDimensions, boolean z, boolean z2, Boolean bool) {
        if (195 != (i & 195)) {
            EnumsKt.throwMissingFieldException(PlayerBody$$serializer.INSTANCE.getDescriptor(), i, 195);
            throw null;
        }
        this.context = context;
        this.videoId = str;
        if ((i & 4) == 0) {
            this.playlistId = null;
        } else {
            this.playlistId = str2;
        }
        if ((i & 8) == 0) {
            this.playbackContext = null;
        } else {
            this.playbackContext = playbackContext;
        }
        if ((i & 16) == 0) {
            this.thirdParty = null;
        } else {
            this.thirdParty = thirdParty;
        }
        if ((i & 32) == 0) {
            this.serviceIntegrityDimensions = null;
        } else {
            this.serviceIntegrityDimensions = serviceIntegrityDimensions;
        }
        this.contentCheckOk = z;
        this.racyCheckOk = z2;
        if ((i & 256) == 0) {
            this.videoCheckOk = null;
        } else {
            this.videoCheckOk = bool;
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PlayerBody)) {
            return false;
        }
        PlayerBody playerBody = (PlayerBody) obj;
        return Intrinsics.areEqual(this.context, playerBody.context) && Intrinsics.areEqual(this.videoId, playerBody.videoId) && Intrinsics.areEqual(this.playlistId, playerBody.playlistId) && Intrinsics.areEqual(this.playbackContext, playerBody.playbackContext) && Intrinsics.areEqual(this.thirdParty, playerBody.thirdParty) && Intrinsics.areEqual(this.serviceIntegrityDimensions, playerBody.serviceIntegrityDimensions) && this.contentCheckOk == playerBody.contentCheckOk && this.racyCheckOk == playerBody.racyCheckOk && Intrinsics.areEqual(this.videoCheckOk, playerBody.videoCheckOk);
    }

    public final int hashCode() {
        int iM = Fragment$5$$ExternalSyntheticOutline0.m(this.context.hashCode() * 31, 31, this.videoId);
        String str = this.playlistId;
        int iHashCode = (iM + (str == null ? 0 : str.hashCode())) * 31;
        PlaybackContext playbackContext = this.playbackContext;
        int iHashCode2 = (iHashCode + (playbackContext == null ? 0 : playbackContext.contentPlaybackContext.hashCode())) * 31;
        ThirdParty thirdParty = this.thirdParty;
        int iHashCode3 = (iHashCode2 + (thirdParty == null ? 0 : thirdParty.embedUrl.hashCode())) * 31;
        ServiceIntegrityDimensions serviceIntegrityDimensions = this.serviceIntegrityDimensions;
        int iM2 = IntIntPair$$ExternalSyntheticOutline0.m(IntIntPair$$ExternalSyntheticOutline0.m((iHashCode3 + (serviceIntegrityDimensions == null ? 0 : serviceIntegrityDimensions.poToken.hashCode())) * 31, this.contentCheckOk, 31), this.racyCheckOk, 31);
        Boolean bool = this.videoCheckOk;
        return iM2 + (bool != null ? bool.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("PlayerBody(context=");
        sb.append(this.context);
        sb.append(", videoId=");
        sb.append(this.videoId);
        sb.append(", playlistId=");
        sb.append(this.playlistId);
        sb.append(", playbackContext=");
        sb.append(this.playbackContext);
        sb.append(", thirdParty=");
        sb.append(this.thirdParty);
        sb.append(", serviceIntegrityDimensions=");
        sb.append(this.serviceIntegrityDimensions);
        sb.append(", contentCheckOk=");
        Fragment$5$$ExternalSyntheticOutline0.m(sb, this.contentCheckOk, ", racyCheckOk=", this.racyCheckOk, ", videoCheckOk=");
        sb.append(this.videoCheckOk);
        sb.append(")");
        return sb.toString();
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0087\b\u0018\u0000 \u00022\u00020\u0001:\u0003\u0003\u0004\u0002¨\u0006\u0005"}, d2 = {"Lcom/metrolist/innertubex/models/body/PlayerBody$PlaybackContext;", "", "Companion", "ContentPlaybackContext", "$serializer", "com.github.MetrolistGroup:innertubex"}, k = 1, mv = {2, 4, 0}, xi = 48)
    @Serializable
    public static final /* data */ class PlaybackContext {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion();
        public final ContentPlaybackContext contentPlaybackContext;

        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/metrolist/innertubex/models/body/PlayerBody$PlaybackContext$Companion;", "", "Lkotlinx/serialization/KSerializer;", "Lcom/metrolist/innertubex/models/body/PlayerBody$PlaybackContext;", "serializer", "()Lkotlinx/serialization/KSerializer;", "com.github.MetrolistGroup:innertubex"}, k = 1, mv = {2, 4, 0}, xi = 48)
        public static final class Companion {
            public final KSerializer serializer() {
                return PlayerBody$PlaybackContext$$serializer.INSTANCE;
            }
        }

        public /* synthetic */ PlaybackContext(int i, ContentPlaybackContext contentPlaybackContext) {
            if (1 == (i & 1)) {
                this.contentPlaybackContext = contentPlaybackContext;
            } else {
                EnumsKt.throwMissingFieldException(PlayerBody$PlaybackContext$$serializer.INSTANCE.getDescriptor(), i, 1);
                throw null;
            }
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof PlaybackContext) && Intrinsics.areEqual(this.contentPlaybackContext, ((PlaybackContext) obj).contentPlaybackContext);
        }

        public final int hashCode() {
            return this.contentPlaybackContext.hashCode();
        }

        public final String toString() {
            return "PlaybackContext(contentPlaybackContext=" + this.contentPlaybackContext + ")";
        }

        public PlaybackContext(ContentPlaybackContext contentPlaybackContext) {
            this.contentPlaybackContext = contentPlaybackContext;
        }

        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u0000 \u00022\u00020\u0001:\u0002\u0003\u0002¨\u0006\u0004"}, d2 = {"Lcom/metrolist/innertubex/models/body/PlayerBody$PlaybackContext$ContentPlaybackContext;", "", "Companion", "$serializer", "com.github.MetrolistGroup:innertubex"}, k = 1, mv = {2, 4, 0}, xi = 48)
        @Serializable
        public static final /* data */ class ContentPlaybackContext {

            /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
            public static final Companion INSTANCE = new Companion();
            public final String encryptedHostFlags;
            public final String html5Preference;
            public final Integer signatureTimestamp;

            /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
            @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/metrolist/innertubex/models/body/PlayerBody$PlaybackContext$ContentPlaybackContext$Companion;", "", "Lkotlinx/serialization/KSerializer;", "Lcom/metrolist/innertubex/models/body/PlayerBody$PlaybackContext$ContentPlaybackContext;", "serializer", "()Lkotlinx/serialization/KSerializer;", "com.github.MetrolistGroup:innertubex"}, k = 1, mv = {2, 4, 0}, xi = 48)
            public static final class Companion {
                public final KSerializer serializer() {
                    return PlayerBody$PlaybackContext$ContentPlaybackContext$$serializer.INSTANCE;
                }
            }

            public /* synthetic */ ContentPlaybackContext(int i, Integer num, String str, String str2) {
                if ((i & 1) == 0) {
                    this.html5Preference = null;
                } else {
                    this.html5Preference = str;
                }
                if ((i & 2) == 0) {
                    this.signatureTimestamp = null;
                } else {
                    this.signatureTimestamp = num;
                }
                if ((i & 4) == 0) {
                    this.encryptedHostFlags = null;
                } else {
                    this.encryptedHostFlags = str2;
                }
            }

            public final boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof ContentPlaybackContext)) {
                    return false;
                }
                ContentPlaybackContext contentPlaybackContext = (ContentPlaybackContext) obj;
                return Intrinsics.areEqual(this.html5Preference, contentPlaybackContext.html5Preference) && Intrinsics.areEqual(this.signatureTimestamp, contentPlaybackContext.signatureTimestamp) && Intrinsics.areEqual(this.encryptedHostFlags, contentPlaybackContext.encryptedHostFlags);
            }

            public final int hashCode() {
                String str = this.html5Preference;
                int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
                Integer num = this.signatureTimestamp;
                int iHashCode2 = (iHashCode + (num == null ? 0 : num.hashCode())) * 31;
                String str2 = this.encryptedHostFlags;
                return iHashCode2 + (str2 != null ? str2.hashCode() : 0);
            }

            public final String toString() {
                StringBuilder sb = new StringBuilder("ContentPlaybackContext(html5Preference=");
                sb.append(this.html5Preference);
                sb.append(", signatureTimestamp=");
                sb.append(this.signatureTimestamp);
                sb.append(", encryptedHostFlags=");
                return IntIntPair$$ExternalSyntheticOutline0.m(sb, this.encryptedHostFlags, ")");
            }

            public ContentPlaybackContext(String str, Integer num, String str2) {
                this.html5Preference = str;
                this.signatureTimestamp = num;
                this.encryptedHostFlags = str2;
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u0000 \u00022\u00020\u0001:\u0002\u0003\u0002¨\u0006\u0004"}, d2 = {"Lcom/metrolist/innertubex/models/body/PlayerBody$ServiceIntegrityDimensions;", "", "Companion", "$serializer", "com.github.MetrolistGroup:innertubex"}, k = 1, mv = {2, 4, 0}, xi = 48)
    @Serializable
    public static final /* data */ class ServiceIntegrityDimensions {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion();
        public final String poToken;

        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/metrolist/innertubex/models/body/PlayerBody$ServiceIntegrityDimensions$Companion;", "", "Lkotlinx/serialization/KSerializer;", "Lcom/metrolist/innertubex/models/body/PlayerBody$ServiceIntegrityDimensions;", "serializer", "()Lkotlinx/serialization/KSerializer;", "com.github.MetrolistGroup:innertubex"}, k = 1, mv = {2, 4, 0}, xi = 48)
        public static final class Companion {
            public final KSerializer serializer() {
                return PlayerBody$ServiceIntegrityDimensions$$serializer.INSTANCE;
            }
        }

        public /* synthetic */ ServiceIntegrityDimensions(int i, String str) {
            if (1 == (i & 1)) {
                this.poToken = str;
            } else {
                EnumsKt.throwMissingFieldException(PlayerBody$ServiceIntegrityDimensions$$serializer.INSTANCE.getDescriptor(), i, 1);
                throw null;
            }
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof ServiceIntegrityDimensions) && Intrinsics.areEqual(this.poToken, ((ServiceIntegrityDimensions) obj).poToken);
        }

        public final int hashCode() {
            return this.poToken.hashCode();
        }

        public final String toString() {
            return IntIntPair$$ExternalSyntheticOutline0.m("ServiceIntegrityDimensions(poToken=", this.poToken, ")");
        }

        public ServiceIntegrityDimensions(String str) {
            str.getClass();
            this.poToken = str;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u0000 \u00022\u00020\u0001:\u0002\u0003\u0002¨\u0006\u0004"}, d2 = {"Lcom/metrolist/innertubex/models/body/PlayerBody$ThirdParty;", "", "Companion", "$serializer", "com.github.MetrolistGroup:innertubex"}, k = 1, mv = {2, 4, 0}, xi = 48)
    @Serializable
    public static final /* data */ class ThirdParty {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion();
        public final String embedUrl;

        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/metrolist/innertubex/models/body/PlayerBody$ThirdParty$Companion;", "", "Lkotlinx/serialization/KSerializer;", "Lcom/metrolist/innertubex/models/body/PlayerBody$ThirdParty;", "serializer", "()Lkotlinx/serialization/KSerializer;", "com.github.MetrolistGroup:innertubex"}, k = 1, mv = {2, 4, 0}, xi = 48)
        public static final class Companion {
            public final KSerializer serializer() {
                return PlayerBody$ThirdParty$$serializer.INSTANCE;
            }
        }

        public /* synthetic */ ThirdParty(int i, String str) {
            if (1 == (i & 1)) {
                this.embedUrl = str;
            } else {
                EnumsKt.throwMissingFieldException(PlayerBody$ThirdParty$$serializer.INSTANCE.getDescriptor(), i, 1);
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

        public ThirdParty(String str) {
            this.embedUrl = str;
        }
    }

    public PlayerBody(Context context, String str, PlaybackContext playbackContext, ThirdParty thirdParty, ServiceIntegrityDimensions serviceIntegrityDimensions, Boolean bool) {
        str.getClass();
        this.context = context;
        this.videoId = str;
        this.playlistId = null;
        this.playbackContext = playbackContext;
        this.thirdParty = thirdParty;
        this.serviceIntegrityDimensions = serviceIntegrityDimensions;
        this.contentCheckOk = true;
        this.racyCheckOk = true;
        this.videoCheckOk = bool;
    }
}
