package androidx.media3.session;

import androidx.media3.common.MediaItem;
import androidx.media3.common.util.Util$$ExternalSyntheticLambda0;
import androidx.media3.common.util.Util$$ExternalSyntheticLambda1;
import androidx.room.TransactionExecutor$$ExternalSyntheticLambda0;
import coil3.util.UtilsKt;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.AsyncFunction;
import com.google.common.util.concurrent.DirectExecutor;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.SettableFuture;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class MediaLibraryServiceLegacyStub$$ExternalSyntheticLambda8 implements AsyncFunction {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ MediaLibraryServiceLegacyStub f$0;

    public /* synthetic */ MediaLibraryServiceLegacyStub$$ExternalSyntheticLambda8(MediaLibraryServiceLegacyStub mediaLibraryServiceLegacyStub, byte b) {
        this.$r8$classId = b;
        this.f$0 = mediaLibraryServiceLegacyStub;
    }

    @Override // com.google.common.util.concurrent.AsyncFunction
    public final SettableFuture apply(Object obj) throws Throwable {
        Object obj2;
        Object obj3;
        byte b = this.$r8$classId;
        DirectExecutor directExecutor = DirectExecutor.INSTANCE;
        LibraryResult libraryResult = (LibraryResult) obj;
        switch (b) {
            case 0:
                UtilsKt.checkNotNull(libraryResult, "LibraryResult must not be null");
                SettableFuture settableFuture = new SettableFuture();
                if (libraryResult.resultCode != 0 || (obj2 = libraryResult.value) == null) {
                    settableFuture.set(null);
                } else {
                    ImmutableList immutableList = (ImmutableList) obj2;
                    if (immutableList.isEmpty()) {
                        settableFuture.set(new ArrayList());
                    } else {
                        ArrayList arrayList = new ArrayList();
                        settableFuture.addListener(new TransactionExecutor$$ExternalSyntheticLambda0((Object) settableFuture, (Object) arrayList, (byte) 7), directExecutor);
                        AtomicInteger atomicInteger = new AtomicInteger(0);
                        MediaLibraryServiceLegacyStub mediaLibraryServiceLegacyStub = this.f$0;
                        MediaSessionStub$$ExternalSyntheticLambda3 mediaSessionStub$$ExternalSyntheticLambda3 = new MediaSessionStub$$ExternalSyntheticLambda3(mediaLibraryServiceLegacyStub, atomicInteger, immutableList, arrayList, settableFuture);
                        for (int i = 0; i < immutableList.size(); i++) {
                            byte[] bArr = ((MediaItem) immutableList.get(i)).mediaMetadata.artworkData;
                            if (bArr == null) {
                                arrayList.add(null);
                                mediaSessionStub$$ExternalSyntheticLambda3.run();
                            } else {
                                ListenableFuture listenableFutureDecodeBitmap = mediaLibraryServiceLegacyStub.librarySessionImpl.bitmapLoader.decodeBitmap(bArr);
                                arrayList.add(listenableFutureDecodeBitmap);
                                listenableFutureDecodeBitmap.addListener(mediaSessionStub$$ExternalSyntheticLambda3, directExecutor);
                            }
                        }
                    }
                }
                return settableFuture;
            default:
                UtilsKt.checkNotNull(libraryResult, "LibraryResult must not be null");
                SettableFuture settableFuture2 = new SettableFuture();
                if (libraryResult.resultCode != 0 || (obj3 = libraryResult.value) == null) {
                    settableFuture2.set(null);
                } else {
                    MediaItem mediaItem = (MediaItem) obj3;
                    byte[] bArr2 = mediaItem.mediaMetadata.artworkData;
                    if (bArr2 == null) {
                        settableFuture2.set(LegacyConversions.convertToBrowserItem(mediaItem, null));
                    } else {
                        ListenableFuture listenableFutureDecodeBitmap2 = this.f$0.librarySessionImpl.bitmapLoader.decodeBitmap(bArr2);
                        settableFuture2.addListener(new Util$$ExternalSyntheticLambda0(settableFuture2, listenableFutureDecodeBitmap2, (byte) 1), directExecutor);
                        listenableFutureDecodeBitmap2.addListener(new Util$$ExternalSyntheticLambda1((Object) listenableFutureDecodeBitmap2, (Object) settableFuture2, (Object) mediaItem, (byte) 12), directExecutor);
                    }
                }
                return settableFuture2;
        }
    }
}
