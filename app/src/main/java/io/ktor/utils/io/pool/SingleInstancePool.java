package io.ktor.utils.io.pool;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.Metadata;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\b&\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00000\u0003B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u00028\u0000H$¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00028\u0000H$¢\u0006\u0004\b\n\u0010\u000bJ\r\u0010\f\u001a\u00028\u0000¢\u0006\u0004\b\f\u0010\u0007J\u0015\u0010\r\u001a\u00020\t2\u0006\u0010\b\u001a\u00028\u0000¢\u0006\u0004\b\r\u0010\u000bJ\r\u0010\u000e\u001a\u00020\t¢\u0006\u0004\b\u000e\u0010\u0005R\u0011\u0010\u0012\u001a\u00020\u000f8F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0013"}, d2 = {"Lio/ktor/utils/io/pool/SingleInstancePool;", "", "T", "Lio/ktor/utils/io/pool/ObjectPool;", "<init>", "()V", "produceInstance", "()Ljava/lang/Object;", "instance", "", "disposeInstance", "(Ljava/lang/Object;)V", "borrow", "recycle", "dispose", "", "getCapacity", "()I", "capacity", "ktor-io"}, k = 1, mv = {2, 3, 0}, xi = 48)
public abstract class SingleInstancePool<T> implements ObjectPool<T> {
    private static final /* synthetic */ AtomicIntegerFieldUpdater borrowed$FU = AtomicIntegerFieldUpdater.newUpdater(SingleInstancePool.class, "borrowed");
    private static final /* synthetic */ AtomicIntegerFieldUpdater disposed$FU = AtomicIntegerFieldUpdater.newUpdater(SingleInstancePool.class, "disposed");
    private volatile /* synthetic */ int borrowed = 0;
    private volatile /* synthetic */ int disposed = 0;
    private volatile /* synthetic */ Object instance = null;

    @Override // io.ktor.utils.io.pool.ObjectPool
    public final T borrow() {
        int i;
        do {
            i = this.borrowed;
            if (i != 0) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("Instance is already consumed");
                return null;
            }
        } while (!borrowed$FU.compareAndSet(this, i, 1));
        T tProduceInstance = produceInstance();
        this.instance = tProduceInstance;
        return tProduceInstance;
    }

    @Override // io.ktor.utils.io.pool.ObjectPool, java.lang.AutoCloseable
    public /* bridge */ void close() {
        super.close();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.ktor.utils.io.pool.ObjectPool
    public final void dispose() {
        Object obj;
        if (!disposed$FU.compareAndSet(this, 0, 1) || (obj = this.instance) == null) {
            return;
        }
        this.instance = null;
        disposeInstance(obj);
    }

    public abstract void disposeInstance(T instance);

    @Override // io.ktor.utils.io.pool.ObjectPool
    public final int getCapacity() {
        return 1;
    }

    public abstract T produceInstance();

    @Override // io.ktor.utils.io.pool.ObjectPool
    public final void recycle(T instance) {
        instance.getClass();
        if (this.instance != instance) {
            if (this.instance != null || this.borrowed == 0) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("Unable to recycle irrelevant instance");
                return;
            } else {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("Already recycled or an irrelevant instance tried to be recycled");
                return;
            }
        }
        this.instance = null;
        if (disposed$FU.compareAndSet(this, 0, 1)) {
            disposeInstance(instance);
        } else {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("An instance is already disposed");
        }
    }
}
