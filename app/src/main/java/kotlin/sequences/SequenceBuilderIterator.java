package kotlin.sequences;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.internal.markers.KMappedMarker;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class SequenceBuilderIterator extends SequenceScope implements Iterator, Continuation, KMappedMarker {
    public Continuation nextStep;
    public Object nextValue;
    public byte state;

    public final RuntimeException exceptionalState() {
        byte b = this.state;
        if (b == 4) {
            return new NoSuchElementException();
        }
        if (b == 5) {
            return new IllegalStateException("Iterator has failed.");
        }
        return new IllegalStateException("Unexpected state of the iterator: " + ((int) this.state));
    }

    @Override // kotlin.coroutines.Continuation
    public final CoroutineContext getContext() {
        return EmptyCoroutineContext.INSTANCE;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        byte b;
        while (true) {
            b = this.state;
            if (b != 0) {
                break;
            }
            this.state = (byte) 5;
            Continuation continuation = this.nextStep;
            continuation.getClass();
            this.nextStep = null;
            continuation.resumeWith(Unit.INSTANCE);
        }
        if (b == 1) {
            throw null;
        }
        if (b == 2 || b == 3) {
            return true;
        }
        if (b == 4) {
            return false;
        }
        throw exceptionalState();
    }

    @Override // java.util.Iterator
    public final Object next() {
        byte b = this.state;
        if (b == 0 || b == 1) {
            if (hasNext()) {
                return next();
            }
            _UtilJvmKt$$ExternalSyntheticLambda0.m$1();
            return null;
        }
        if (b == 2) {
            this.state = (byte) 1;
            throw null;
        }
        if (b != 3) {
            throw exceptionalState();
        }
        this.state = (byte) 0;
        Object obj = this.nextValue;
        this.nextValue = null;
        return obj;
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // kotlin.coroutines.Continuation
    public final void resumeWith(Object obj) {
        ResultKt.throwOnFailure(obj);
        this.state = (byte) 4;
    }

    @Override // kotlin.sequences.SequenceScope
    public final void yield(Object obj, Continuation continuation) {
        this.nextValue = obj;
        this.state = (byte) 3;
        this.nextStep = continuation;
        continuation.getClass();
    }
}
