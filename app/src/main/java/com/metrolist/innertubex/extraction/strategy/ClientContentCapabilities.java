package com.metrolist.innertubex.extraction.strategy;

import com.metrolist.innertubex.extraction.ContentHints;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class ClientContentCapabilities {
    public final CapabilitySupport ageRestricted;
    public final CapabilitySupport explicit;
    public final CapabilitySupport kids;
    public final CapabilitySupport live;
    public final CapabilitySupport normal;
    public final CapabilitySupport uploads;

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ ClientContentCapabilities(CapabilitySupport capabilitySupport, CapabilitySupport capabilitySupport2, CapabilitySupport capabilitySupport3, CapabilitySupport capabilitySupport4, CapabilitySupport capabilitySupport5, int i) {
        CapabilitySupport capabilitySupport6 = (i & 1) != 0 ? CapabilitySupport.SUPPORTED : CapabilitySupport.UNSUPPORTED;
        int i2 = i & 2;
        CapabilitySupport capabilitySupport7 = CapabilitySupport.UNKNOWN;
        this(capabilitySupport6, i2 != 0 ? capabilitySupport7 : capabilitySupport, (i & 4) != 0 ? capabilitySupport7 : capabilitySupport2, (i & 8) != 0 ? capabilitySupport7 : capabilitySupport3, (i & 16) != 0 ? capabilitySupport7 : capabilitySupport4, (i & 32) != 0 ? capabilitySupport7 : capabilitySupport5);
    }

    public static ClientContentCapabilities copy$default(ClientContentCapabilities clientContentCapabilities, int i) {
        int i2 = i & 1;
        CapabilitySupport capabilitySupport = CapabilitySupport.LIMITED;
        CapabilitySupport capabilitySupport2 = i2 != 0 ? clientContentCapabilities.normal : capabilitySupport;
        if ((i & 2) != 0) {
            capabilitySupport = clientContentCapabilities.explicit;
        }
        CapabilitySupport capabilitySupport3 = capabilitySupport;
        CapabilitySupport capabilitySupport4 = clientContentCapabilities.kids;
        CapabilitySupport capabilitySupport5 = (i & 8) != 0 ? clientContentCapabilities.ageRestricted : CapabilitySupport.SUPPORTED;
        CapabilitySupport capabilitySupport6 = clientContentCapabilities.live;
        CapabilitySupport capabilitySupport7 = clientContentCapabilities.uploads;
        capabilitySupport2.getClass();
        capabilitySupport3.getClass();
        capabilitySupport4.getClass();
        capabilitySupport5.getClass();
        capabilitySupport6.getClass();
        capabilitySupport7.getClass();
        return new ClientContentCapabilities(capabilitySupport2, capabilitySupport3, capabilitySupport4, capabilitySupport5, capabilitySupport6, capabilitySupport7);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ClientContentCapabilities)) {
            return false;
        }
        ClientContentCapabilities clientContentCapabilities = (ClientContentCapabilities) obj;
        return this.normal == clientContentCapabilities.normal && this.explicit == clientContentCapabilities.explicit && this.kids == clientContentCapabilities.kids && this.ageRestricted == clientContentCapabilities.ageRestricted && this.live == clientContentCapabilities.live && this.uploads == clientContentCapabilities.uploads;
    }

    public final int hashCode() {
        return this.uploads.hashCode() + ((this.live.hashCode() + ((this.ageRestricted.hashCode() + ((this.kids.hashCode() + ((this.explicit.hashCode() + (this.normal.hashCode() * 31)) * 31)) * 31)) * 31)) * 31);
    }

    public final CapabilitySupport supportFor(ContentHints contentHints) {
        contentHints.getClass();
        Boolean bool = contentHints.isUploaded;
        Boolean bool2 = Boolean.TRUE;
        if (Intrinsics.areEqual(bool, bool2)) {
            return this.uploads;
        }
        if (Intrinsics.areEqual(contentHints.isAgeRestricted, bool2)) {
            return this.ageRestricted;
        }
        if (Intrinsics.areEqual(contentHints.isKidsContent, bool2)) {
            return this.kids;
        }
        return Intrinsics.areEqual(contentHints.isExplicit, bool2) ? this.explicit : this.normal;
    }

    public final String toString() {
        return "ClientContentCapabilities(normal=" + this.normal + ", explicit=" + this.explicit + ", kids=" + this.kids + ", ageRestricted=" + this.ageRestricted + ", live=" + this.live + ", uploads=" + this.uploads + ")";
    }

    public ClientContentCapabilities(CapabilitySupport capabilitySupport, CapabilitySupport capabilitySupport2, CapabilitySupport capabilitySupport3, CapabilitySupport capabilitySupport4, CapabilitySupport capabilitySupport5, CapabilitySupport capabilitySupport6) {
        capabilitySupport.getClass();
        capabilitySupport2.getClass();
        capabilitySupport3.getClass();
        capabilitySupport4.getClass();
        capabilitySupport5.getClass();
        capabilitySupport6.getClass();
        this.normal = capabilitySupport;
        this.explicit = capabilitySupport2;
        this.kids = capabilitySupport3;
        this.ageRestricted = capabilitySupport4;
        this.live = capabilitySupport5;
        this.uploads = capabilitySupport6;
    }
}
