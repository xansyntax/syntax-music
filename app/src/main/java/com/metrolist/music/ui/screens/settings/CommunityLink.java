package com.metrolist.music.ui.screens.settings;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import com.yalantis.ucrop.R;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class CommunityLink {
    public final boolean equals(Object obj) {
        return this == obj || (obj instanceof CommunityLink);
    }

    public final int hashCode() {
        return ((Integer.hashCode(R.drawable.info) + (Integer.hashCode(R.string.credits_license_name) * 31)) * 31) - 516194342;
    }

    public final String toString() {
        return IntIntPair$$ExternalSyntheticOutline0.m(R.string.credits_license_name, "CommunityLink(labelRes=", ", iconRes=", R.drawable.info, ", url=https://www.gnu.org/licenses/gpl-3.0.html)");
    }
}
