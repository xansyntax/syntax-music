package okhttp3;

import dagger.hilt.EntryPoints;
import java.util.ArrayList;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public final class CertificatePinner {
    public static final CertificatePinner DEFAULT = new CertificatePinner(CollectionsKt.toSet(new ArrayList()), null);
    public final EntryPoints certificateChainCleaner;
    public final Set pins;

    public CertificatePinner(Set set, EntryPoints entryPoints) {
        this.pins = set;
        this.certificateChainCleaner = entryPoints;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof CertificatePinner)) {
            return false;
        }
        CertificatePinner certificatePinner = (CertificatePinner) obj;
        return certificatePinner.pins.equals(this.pins) && Intrinsics.areEqual(certificatePinner.certificateChainCleaner, this.certificateChainCleaner);
    }

    public final int hashCode() {
        int iHashCode = (this.pins.hashCode() + 1517) * 41;
        EntryPoints entryPoints = this.certificateChainCleaner;
        return iHashCode + (entryPoints != null ? entryPoints.hashCode() : 0);
    }
}
