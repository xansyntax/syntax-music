package com.metrolist.innertubex.models.response;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.internal.EnumsKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0081\b\u0018\u0000 \u00022\u00020\u0001:\u0002\u0003\u0002¨\u0006\u0004"}, d2 = {"Lcom/metrolist/innertubex/models/response/ImageUploadResponse;", "", "Companion", "$serializer", "com.github.MetrolistGroup:innertubex"}, k = 1, mv = {2, 4, 0}, xi = 48)
@Serializable
public final /* data */ class ImageUploadResponse {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion();
    public final String encryptedBlobId;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/metrolist/innertubex/models/response/ImageUploadResponse$Companion;", "", "Lkotlinx/serialization/KSerializer;", "Lcom/metrolist/innertubex/models/response/ImageUploadResponse;", "serializer", "()Lkotlinx/serialization/KSerializer;", "com.github.MetrolistGroup:innertubex"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final class Companion {
        public final KSerializer serializer() {
            return ImageUploadResponse$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ ImageUploadResponse(int i, String str) {
        if (1 == (i & 1)) {
            this.encryptedBlobId = str;
        } else {
            EnumsKt.throwMissingFieldException(ImageUploadResponse$$serializer.INSTANCE.getDescriptor(), i, 1);
            throw null;
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof ImageUploadResponse) && Intrinsics.areEqual(this.encryptedBlobId, ((ImageUploadResponse) obj).encryptedBlobId);
    }

    public final int hashCode() {
        return this.encryptedBlobId.hashCode();
    }

    public final String toString() {
        return IntIntPair$$ExternalSyntheticOutline0.m("ImageUploadResponse(encryptedBlobId=", this.encryptedBlobId, ")");
    }
}
