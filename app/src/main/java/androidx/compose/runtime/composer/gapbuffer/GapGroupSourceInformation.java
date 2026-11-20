package androidx.compose.runtime.composer.gapbuffer;

import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class GapGroupSourceInformation {
    public ArrayList groups;

    public abstract boolean getClosed();

    public abstract int getDataEndOffset();

    public abstract int getDataStartOffset();

    public abstract ArrayList getGroups();

    public abstract int getKey();

    public abstract String getSourceInformation();

    public abstract boolean hasAnchor(GapAnchor gapAnchor);

    public abstract GapGroupSourceInformation openInformation();

    public abstract boolean removeAnchor(GapAnchor gapAnchor);
}
