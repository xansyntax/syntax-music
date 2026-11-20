package androidx.compose.foundation.lazy.layout;

import android.os.Trace;
import android.view.Choreographer;
import android.view.Display;
import android.view.View;
import androidx.compose.ui.node.LayoutNode$$ExternalSyntheticLambda1;
import androidx.media3.extractor.PositionHolder;
import androidx.tracing.TraceApi29Impl;
import java.util.PriorityQueue;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class AndroidPrefetchScheduler implements PrefetchScheduler, View.OnAttachStateChangeListener, Runnable, Choreographer.FrameCallback {
    public static long frameIntervalNs;
    public long frameStartTimeNanos;
    public boolean isActive;
    public long lastDrawingTimeNanos;
    public boolean prefetchScheduled;
    public final View view;
    public final PriorityQueue prefetchRequests = new PriorityQueue(11, new LayoutNode$$ExternalSyntheticLambda1(1));
    public final Choreographer choreographer = Choreographer.getInstance();
    public final PositionHolder scope = new PositionHolder();

    /* JADX WARN: Code duplicated, block: B:10:0x0040  */
    public AndroidPrefetchScheduler(View view) {
        float refreshRate;
        this.view = view;
        if (frameIntervalNs == 0) {
            Display display = view.getDisplay();
            if (!view.isInEditMode() && display != null) {
                refreshRate = display.getRefreshRate();
                refreshRate = refreshRate < 30.0f ? 60.0f : refreshRate;
            }
            frameIntervalNs = (long) (1.0E9f / refreshRate);
        }
        view.addOnAttachStateChangeListener(this);
        if (view.isAttachedToWindow()) {
            this.isActive = true;
        }
    }

    @Override // android.view.Choreographer.FrameCallback
    public final void doFrame(long j) {
        if (this.isActive) {
            this.frameStartTimeNanos = j;
            this.view.post(this);
        }
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View view) {
        this.isActive = true;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View view) {
        this.isActive = false;
        this.view.removeCallbacks(this);
        this.choreographer.removeFrameCallback(this);
    }

    @Override // java.lang.Runnable
    public final void run() {
        boolean z;
        boolean z2;
        boolean z3;
        boolean zExecute;
        PriorityQueue priorityQueue = this.prefetchRequests;
        if (!priorityQueue.isEmpty() && this.prefetchScheduled && this.isActive) {
            View view = this.view;
            if (view.getWindowVisibility() == 0) {
                long jMax = Math.max(this.frameStartTimeNanos, TimeUnit.MILLISECONDS.toNanos(view.getDrawingTime()));
                boolean z4 = true;
                if (System.nanoTime() - jMax <= 2 * frameIntervalNs) {
                    z = false;
                    z2 = false;
                } else if (this.lastDrawingTimeNanos == jMax) {
                    jMax = System.nanoTime();
                    z2 = false;
                    z = true;
                } else {
                    this.lastDrawingTimeNanos = jMax;
                    view.post(this);
                    z = false;
                    z2 = true;
                }
                long j = jMax + frameIntervalNs;
                PositionHolder positionHolder = this.scope;
                positionHolder.position = j;
                while (true) {
                    if (priorityQueue.isEmpty()) {
                        z4 = false;
                        break;
                    }
                    long jAvailableTimeNanos = positionHolder.availableTimeNanos();
                    if (jAvailableTimeNanos <= 0) {
                        break;
                    }
                    TraceApi29Impl.traceValue(jAvailableTimeNanos, "compose:lazy:prefetch:available_time_nanos");
                    if (z) {
                        Trace.beginSection("compose:lazy:prefetch:idle_frame");
                        try {
                            Object objPeek = priorityQueue.peek();
                            objPeek.getClass();
                            zExecute = ((PriorityTask) objPeek).request.execute(positionHolder);
                            if (!zExecute) {
                                priorityQueue.poll();
                            }
                            Trace.endSection();
                            z3 = false;
                        } catch (Throwable th) {
                            Trace.endSection();
                            throw th;
                        }
                    } else {
                        Object objPeek2 = priorityQueue.peek();
                        objPeek2.getClass();
                        boolean zExecute2 = ((PriorityTask) objPeek2).request.execute(positionHolder);
                        if (!zExecute2) {
                            priorityQueue.poll();
                        }
                        z3 = z;
                        zExecute = zExecute2;
                    }
                    if (zExecute) {
                        break;
                    } else {
                        z = z3;
                    }
                }
                if (z2) {
                    return;
                }
                if (z4) {
                    this.choreographer.postFrameCallback(this);
                    return;
                } else {
                    this.prefetchScheduled = false;
                    return;
                }
            }
        }
        this.prefetchScheduled = false;
    }

    @Override // androidx.compose.foundation.lazy.layout.PrefetchScheduler
    public final void schedulePrefetch(PrefetchHandleProvider$HandleAndRequestImpl prefetchHandleProvider$HandleAndRequestImpl) {
        this.prefetchRequests.add(new PriorityTask(1, prefetchHandleProvider$HandleAndRequestImpl));
        if (this.prefetchScheduled) {
            return;
        }
        this.prefetchScheduled = true;
        this.view.post(this);
    }
}
