package io.ktor.http.content;

import io.ktor.utils.io.ByteReadChannel;
import io.ktor.utils.io.jvm.javaio.BlockingKt;
import java.io.InputStream;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\"$\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u00008FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0003\u0010\u0004¨\u0006\b"}, d2 = {"Lio/ktor/http/content/PartData$FileItem;", "Lkotlin/Function0;", "Ljava/io/InputStream;", "getStreamProvider", "(Lio/ktor/http/content/PartData$FileItem;)Lkotlin/jvm/functions/Function0;", "getStreamProvider$annotations", "(Lio/ktor/http/content/PartData$FileItem;)V", "streamProvider", "ktor-http"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class MultipartJvmKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final InputStream _get_streamProvider_$lambda$0(PartData.FileItem fileItem) {
        return BlockingKt.toInputStream$default((ByteReadChannel) fileItem.getProvider().invoke(), null, 1, null);
    }

    public static final Function0 getStreamProvider(PartData.FileItem fileItem) {
        fileItem.getClass();
        return new MultipartJvmKt$$ExternalSyntheticLambda0((byte) 0, fileItem);
    }

    @Deprecated
    public static /* synthetic */ void getStreamProvider$annotations(PartData.FileItem fileItem) {
    }
}
