package com.metrolist.innertubex.extraction.strategy;

import com.metrolist.innertubex.models.PoTokenBinding;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class ClientPoTokenCapabilities {
    public final PoTokenRule gvs;
    public final PoTokenRule player;
    public final PoTokenRule subtitles;

    /* JADX WARN: Multi-variable type inference failed */
    public ClientPoTokenCapabilities(PoTokenRule poTokenRule, PoTokenRule poTokenRule2, int i) {
        int i2 = 15;
        Object[] objArr = 0;
        Object[] objArr2 = 0;
        Object[] objArr3 = 0;
        Object[] objArr4 = 0;
        Object[] objArr5 = 0;
        Object[] objArr6 = 0;
        poTokenRule = (i & 1) != 0 ? new PoTokenRule((PoTokenRequirement) null, (PoTokenBinding) (0 == true ? 1 : 0), (Set) (0 == true ? 1 : 0), i2) : poTokenRule;
        poTokenRule2 = (i & 2) != 0 ? new PoTokenRule((PoTokenRequirement) (objArr6 == true ? 1 : 0), (PoTokenBinding) (objArr5 == true ? 1 : 0), (Set) (objArr4 == true ? 1 : 0), i2) : poTokenRule2;
        PoTokenRule poTokenRule3 = new PoTokenRule((PoTokenRequirement) (objArr3 == true ? 1 : 0), (PoTokenBinding) (objArr2 == true ? 1 : 0), (Set) (objArr == true ? 1 : 0), i2);
        this.player = poTokenRule;
        this.gvs = poTokenRule2;
        this.subtitles = poTokenRule3;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ClientPoTokenCapabilities)) {
            return false;
        }
        ClientPoTokenCapabilities clientPoTokenCapabilities = (ClientPoTokenCapabilities) obj;
        return this.player.equals(clientPoTokenCapabilities.player) && this.gvs.equals(clientPoTokenCapabilities.gvs) && this.subtitles.equals(clientPoTokenCapabilities.subtitles);
    }

    public final int hashCode() {
        return this.subtitles.hashCode() + ((this.gvs.hashCode() + (this.player.hashCode() * 31)) * 31);
    }

    public final String toString() {
        return "ClientPoTokenCapabilities(player=" + this.player + ", gvs=" + this.gvs + ", subtitles=" + this.subtitles + ")";
    }
}
