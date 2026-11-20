package androidx.media3.common;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.SharedMemory;
import android.system.OsConstants;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.Util;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Maps;
import java.nio.ByteBuffer;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class BundleableByteArray {
    public static final String FIELD_IN_PROCESS_BINDER;
    public static final String FIELD_SHARED_MEMORY;
    public static final String FIELD_SPLIT_ARRAY_RETRIEVER;
    public final byte[] byteArray;
    public final InProcessBinder inProcessBinder = new InProcessBinder();
    public SharedMemoryApi27 sharedMemoryApi27;
    public SplitArrayRetriever splitArrayRetriever;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class InProcessBinder extends Binder {
        public static final /* synthetic */ int $r8$clinit = 0;

        public InProcessBinder() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class SharedMemoryApi27 {
        public final SharedMemory sharedMemory;

        public SharedMemoryApi27(SharedMemory sharedMemory) {
            this.sharedMemory = sharedMemory;
        }

        public static SharedMemoryApi27 create(byte[] bArr) {
            SharedMemory sharedMemoryCreate;
            try {
                sharedMemoryCreate = SharedMemory.create("BundleableByteArray", bArr.length);
                try {
                    ByteBuffer byteBufferMapReadWrite = sharedMemoryCreate.mapReadWrite();
                    byteBufferMapReadWrite.put(bArr);
                    SharedMemory.unmap(byteBufferMapReadWrite);
                    sharedMemoryCreate.setProtect(OsConstants.PROT_READ);
                    return new SharedMemoryApi27(sharedMemoryCreate);
                } catch (Exception e) {
                    e = e;
                    Log.w("BundleableByteArray", "Failed to allocate shared memory for byte array, size=" + bArr.length, e);
                    if (sharedMemoryCreate != null) {
                        sharedMemoryCreate.close();
                    }
                    return null;
                }
            } catch (Exception e2) {
                e = e2;
                sharedMemoryCreate = null;
            }
        }

        public static byte[] readFromBundle(Bundle bundle) throws Throwable {
            ByteBuffer byteBufferMapReadOnly;
            SharedMemory sharedMemory = (SharedMemory) bundle.getParcelable(BundleableByteArray.FIELD_SHARED_MEMORY);
            try {
                if (sharedMemory == null) {
                    return null;
                }
                try {
                    byteBufferMapReadOnly = sharedMemory.mapReadOnly();
                    try {
                        byte[] bArr = new byte[sharedMemory.getSize()];
                        byteBufferMapReadOnly.get(bArr);
                        SharedMemory.unmap(byteBufferMapReadOnly);
                        sharedMemory.close();
                        return bArr;
                    } catch (Exception e) {
                        e = e;
                        Log.w("BundleableByteArray", "Failed to read byte array from shared memory", e);
                        if (byteBufferMapReadOnly != null) {
                            SharedMemory.unmap(byteBufferMapReadOnly);
                        }
                        sharedMemory.close();
                        return null;
                    }
                } catch (Exception e2) {
                    e = e2;
                    byteBufferMapReadOnly = null;
                } catch (Throwable th) {
                    th = th;
                    if (0 != 0) {
                        SharedMemory.unmap(null);
                    }
                    sharedMemory.close();
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class SplitArrayRetriever {
        public static final int CHUNK_SIZE = C.SUGGESTED_MAX_IPC_SIZE;
        public final BundleListRetriever bundleListRetriever;

        public SplitArrayRetriever(byte[] bArr) {
            ImmutableList.Builder builder = ImmutableList.builder();
            int length = bArr.length;
            int i = CHUNK_SIZE;
            int iCeilDivide = Util.ceilDivide(length, i);
            for (int i2 = 0; i2 < iCeilDivide; i2++) {
                Bundle bundle = new Bundle();
                int i3 = i2 * i;
                bundle.putByteArray("bytes", Arrays.copyOfRange(bArr, i3, Math.min(i3 + i, bArr.length)));
                builder.add((Object) bundle);
            }
            this.bundleListRetriever = new BundleListRetriever(builder.build());
        }

        public static byte[] readFromBundle(Bundle bundle) {
            IBinder binder = bundle.getBinder(BundleableByteArray.FIELD_SPLIT_ARRAY_RETRIEVER);
            if (binder != null) {
                try {
                    ImmutableList list = BundleListRetriever.getList(binder);
                    if (list.isEmpty()) {
                        return Util.EMPTY_BYTE_ARRAY;
                    }
                    byte[] byteArray = ((Bundle) Maps.getLast(list)).getByteArray("bytes");
                    if (byteArray != null) {
                        int size = list.size() - 1;
                        int i = CHUNK_SIZE;
                        int i2 = size * i;
                        byte[] bArr = new byte[byteArray.length + i2];
                        System.arraycopy(byteArray, 0, bArr, i2, byteArray.length);
                        for (int i3 = 0; i3 < size; i3++) {
                            byte[] byteArray2 = ((Bundle) list.get(i3)).getByteArray("bytes");
                            if (byteArray2 != null && byteArray2.length == i) {
                                System.arraycopy(byteArray2, 0, bArr, i3 * i, i);
                            }
                        }
                        return bArr;
                    }
                } catch (RuntimeException e) {
                    Log.w("BundleableByteArray", "Failed to read byte array from bundle list retriever", e);
                    return null;
                }
            }
            return null;
        }
    }

    static {
        String str = Util.DEVICE_DEBUG_INFO;
        FIELD_IN_PROCESS_BINDER = Integer.toString(0, 36);
        FIELD_SHARED_MEMORY = Integer.toString(1, 36);
        FIELD_SPLIT_ARRAY_RETRIEVER = Integer.toString(2, 36);
    }

    public BundleableByteArray(byte[] bArr) {
        this.byteArray = bArr;
    }
}
