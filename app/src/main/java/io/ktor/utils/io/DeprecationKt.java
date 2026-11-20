package io.ktor.utils.io;

import com.yalantis.ucrop.BuildConfig;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlinx.io.Sink;
import kotlinx.io.Source;
import kotlinx.io.Utf8Kt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0013\u0010\u0006\u001a\u00020\u0005*\u00020\u0004H\u0007¢\u0006\u0004\b\u0006\u0010\u0007\"\u0014\u0010\b\u001a\u00020\u00018\u0000X\u0080T¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lkotlinx/io/Source;", "", "readText", "(Lkotlinx/io/Source;)Ljava/lang/String;", "Lkotlinx/io/Sink;", "", BuildConfig.BUILD_TYPE, "(Lkotlinx/io/Sink;)V", "IO_DEPRECATION_MESSAGE", "Ljava/lang/String;", "ktor-io"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class DeprecationKt {
    public static final String IO_DEPRECATION_MESSAGE = "\n    We're migrating to the new kotlinx-io library.\n    This declaration is deprecated and will be removed in Ktor 4.0.0\n    If you have any problems with migration, please contact us in \n    https://youtrack.jetbrains.com/issue/KTOR-6030/Migrate-to-new-kotlinx.io-library\n    ";

    public static final String readText(Source source) {
        source.getClass();
        source.request(Long.MAX_VALUE);
        return Utf8Kt.commonReadUtf8(source.getBuffer(), source.getBuffer().sizeMut);
    }

    @Deprecated
    public static final void release(Sink sink) {
        sink.getClass();
        sink.close();
    }
}
