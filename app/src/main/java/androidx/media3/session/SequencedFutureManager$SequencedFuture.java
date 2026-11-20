package androidx.media3.session;

import com.google.common.util.concurrent.AbstractFuture;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class SequencedFutureManager$SequencedFuture extends AbstractFuture {
    public final Object resultWhenClosed;
    public final int sequenceNumber;

    public SequencedFutureManager$SequencedFuture(int i, Object obj) {
        this.sequenceNumber = i;
        this.resultWhenClosed = obj;
    }

    public final void setWithTheValueOfResultWhenClosed() {
        super.set(this.resultWhenClosed);
    }
}
