package com.metrolist.innertubex.extraction.strategy;

import com.metrolist.innertubex.models.PoTokenBinding;
import java.util.Set;
import kotlin.collections.EmptySet;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class PoTokenRule {
    public final PoTokenBinding binding;
    public final boolean premiumMayBypass;
    public final Set providers;
    public final PoTokenRequirement requirement;

    public PoTokenRule(PoTokenRequirement poTokenRequirement, PoTokenBinding poTokenBinding, Set set, boolean z) {
        poTokenRequirement.getClass();
        set.getClass();
        this.requirement = poTokenRequirement;
        this.binding = poTokenBinding;
        this.providers = set;
        this.premiumMayBypass = z;
        PoTokenRequirement poTokenRequirement2 = PoTokenRequirement.NONE;
        if (poTokenRequirement != poTokenRequirement2 && poTokenBinding == null) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$1("A PO token rule must declare its content binding");
            throw null;
        }
        if (poTokenRequirement == poTokenRequirement2 || !set.isEmpty()) {
            return;
        }
        _UtilJvmKt$$ExternalSyntheticLambda0.m$1("A PO token rule must declare at least one compatible provider");
        throw null;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PoTokenRule)) {
            return false;
        }
        PoTokenRule poTokenRule = (PoTokenRule) obj;
        return this.requirement == poTokenRule.requirement && this.binding == poTokenRule.binding && Intrinsics.areEqual(this.providers, poTokenRule.providers) && this.premiumMayBypass == poTokenRule.premiumMayBypass;
    }

    public final int hashCode() {
        int iHashCode = this.requirement.hashCode() * 31;
        PoTokenBinding poTokenBinding = this.binding;
        return Boolean.hashCode(this.premiumMayBypass) + ((this.providers.hashCode() + ((iHashCode + (poTokenBinding == null ? 0 : poTokenBinding.hashCode())) * 31)) * 31);
    }

    public final String toString() {
        return "PoTokenRule(requirement=" + this.requirement + ", binding=" + this.binding + ", providers=" + this.providers + ", premiumMayBypass=" + this.premiumMayBypass + ")";
    }

    public /* synthetic */ PoTokenRule(PoTokenRequirement poTokenRequirement, PoTokenBinding poTokenBinding, Set set, int i) {
        this((i & 1) != 0 ? PoTokenRequirement.NONE : poTokenRequirement, (i & 2) != 0 ? null : poTokenBinding, (i & 4) != 0 ? EmptySet.INSTANCE : set, false);
    }
}
