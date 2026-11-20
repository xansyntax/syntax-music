package androidx.navigation;

import android.content.Context;
import android.net.Uri;
import androidx.compose.animation.core.DecayAnimationSpecImpl;
import androidx.compose.animation.core.SpringSpec;
import androidx.compose.material3.TopAppBarState;
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection;
import androidx.media3.decoder.Buffer;
import androidx.media3.extractor.text.CueDecoder;
import androidx.media3.session.MediaLibraryService;
import androidx.navigation.NavDeepLinkRequest;
import androidx.room.concurrent.FileLock;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import com.metrolist.music.db.BackupCallback;
import com.metrolist.paxsenix.Paxsenix$AppleTokenManager$getToken$1;
import com.yalantis.ucrop.view.CropImageView;
import io.ktor.client.HttpClient;
import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.client.request.HttpRequestKt;
import io.ktor.client.statement.HttpResponse;
import io.ktor.client.statement.HttpResponseKt;
import io.ktor.client.statement.HttpStatement;
import io.ktor.http.HttpMethod;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.ResultKt;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.functions.Function0;
import kotlin.text.MatcherMatchResult;
import kotlin.text.RegexKt;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexImpl;
import okhttp3.ConnectionPool;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;
import okhttp3.internal.connection.Exchange;
import okhttp3.internal.http.ExchangeCodec;
import okio.Okio__OkioKt;
import okio.RealBufferedSink;
import okio.RealBufferedSource;
import okio.Sink;
import okio.Socket;
import okio.Source;
import timber.log.Timber;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class NavDeepLinkRequest implements SupportSQLiteOpenHelper.Factory, Socket {
    public final /* synthetic */ byte $r8$classId;
    public Object action;
    public Object mimeType;
    public Object uri;

    public NavDeepLinkRequest(Exchange exchange) {
        this.$r8$classId = (byte) 10;
        this.mimeType = exchange;
        ExchangeCodec exchangeCodec = (ExchangeCodec) exchange.codec;
        this.uri = new Exchange.RequestBodySink(exchange, exchangeCodec.getSocket().getSink(), -1L, true);
        this.action = new Exchange.ResponseBodySource(exchange, exchangeCodec.getSocket().getSource(), -1L, true);
    }

    @Override // okio.Socket
    public void cancel() {
        switch (this.$r8$classId) {
            case 9:
                ((Socket) this.uri).cancel();
                break;
            default:
                ((ExchangeCodec) ((Exchange) this.mimeType).codec).cancel();
                break;
        }
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper.Factory
    public SupportSQLiteOpenHelper create(NavDeepLinkRequest navDeepLinkRequest) {
        BackupCallback backupCallback = new BackupCallback((Context) this.uri, (Buffer) navDeepLinkRequest.mimeType, (String) this.action);
        Context context = (Context) navDeepLinkRequest.uri;
        context.getClass();
        return ((SupportSQLiteOpenHelper.Factory) this.mimeType).create(new NavDeepLinkRequest(context, backupCallback, (String) navDeepLinkRequest.action));
    }

    public int getRemaining() {
        return ((AtomicInteger) this.mimeType).get();
    }

    @Override // okio.Socket
    public Sink getSink() {
        switch (this.$r8$classId) {
            case 9:
                return (RealBufferedSink) this.mimeType;
            default:
                return (Exchange.RequestBodySink) this.uri;
        }
    }

    @Override // okio.Socket
    public Source getSource() {
        switch (this.$r8$classId) {
            case 9:
                return (RealBufferedSource) this.action;
            default:
                return (Exchange.ResponseBodySource) this.action;
        }
    }

    /* JADX WARN: Code duplicated, block: B:51:0x00bd  */
    /* JADX WARN: Code duplicated, block: B:52:0x00be A[Catch: all -> 0x005d, Exception -> 0x0061, PHI: r1 r5
      0x00be: PHI (r1v11 java.lang.Object) = (r1v10 java.lang.Object), (r1v1 java.lang.Object) binds: [B:50:0x00bb, B:28:0x0059] A[DONT_GENERATE, DONT_INLINE]
      0x00be: PHI (r5v9 kotlinx.coroutines.sync.Mutex) = (r5v8 kotlinx.coroutines.sync.Mutex), (r5v12 kotlinx.coroutines.sync.Mutex) binds: [B:50:0x00bb, B:28:0x0059] A[DONT_GENERATE, DONT_INLINE], TryCatch #6 {Exception -> 0x0061, all -> 0x005d, blocks: (B:28:0x0059, B:52:0x00be, B:54:0x00d9, B:68:0x0143, B:69:0x014a, B:35:0x0067, B:49:0x00b1), top: B:80:0x0031 }] */
    /* JADX WARN: Code duplicated, block: B:54:0x00d9 A[Catch: all -> 0x005d, Exception -> 0x0061, TRY_LEAVE, TryCatch #6 {Exception -> 0x0061, all -> 0x005d, blocks: (B:28:0x0059, B:52:0x00be, B:54:0x00d9, B:68:0x0143, B:69:0x014a, B:35:0x0067, B:49:0x00b1), top: B:80:0x0031 }] */
    /* JADX WARN: Code duplicated, block: B:57:0x00fe  */
    /* JADX WARN: Code duplicated, block: B:68:0x0143 A[Catch: all -> 0x005d, Exception -> 0x0061, TRY_ENTER, TryCatch #6 {Exception -> 0x0061, all -> 0x005d, blocks: (B:28:0x0059, B:52:0x00be, B:54:0x00d9, B:68:0x0143, B:69:0x014a, B:35:0x0067, B:49:0x00b1), top: B:80:0x0031 }] */
    /* JADX WARN: Code duplicated, block: B:7:0x001d  */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x0109, code lost:
    
        if (r1 == r14) goto L60;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v1, types: [io.ktor.client.HttpClient] */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v4, types: [kotlinx.coroutines.sync.Mutex] */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r5v0, types: [int] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object getToken(ContinuationImpl continuationImpl) throws Throwable {
        Paxsenix$AppleTokenManager$getToken$1 paxsenix$AppleTokenManager$getToken$1;
        Mutex mutex;
        Mutex mutex2;
        MatcherMatchResult matcherMatchResultFindNext;
        Mutex mutex3;
        ?? r2 = (HttpClient) this.uri;
        if (continuationImpl instanceof Paxsenix$AppleTokenManager$getToken$1) {
            paxsenix$AppleTokenManager$getToken$1 = (Paxsenix$AppleTokenManager$getToken$1) continuationImpl;
            int i = paxsenix$AppleTokenManager$getToken$1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                paxsenix$AppleTokenManager$getToken$1.label = i - Integer.MIN_VALUE;
            } else {
                paxsenix$AppleTokenManager$getToken$1 = new Paxsenix$AppleTokenManager$getToken$1(this, continuationImpl);
            }
        } else {
            paxsenix$AppleTokenManager$getToken$1 = new Paxsenix$AppleTokenManager$getToken$1(this, continuationImpl);
        }
        Object objBodyAsText$default = paxsenix$AppleTokenManager$getToken$1.result;
        ?? r5 = paxsenix$AppleTokenManager$getToken$1.label;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        try {
            try {
                try {
                    try {
                        if (r5 == 0) {
                            ResultKt.throwOnFailure(objBodyAsText$default);
                            mutex = (MutexImpl) this.mimeType;
                            paxsenix$AppleTokenManager$getToken$1.L$0 = mutex;
                            paxsenix$AppleTokenManager$getToken$1.label = 1;
                            if (mutex.lock(paxsenix$AppleTokenManager$getToken$1) != coroutineSingletons) {
                            }
                            return coroutineSingletons;
                        }
                        if (r5 == 1) {
                            Mutex mutex4 = paxsenix$AppleTokenManager$getToken$1.L$0;
                            ResultKt.throwOnFailure(objBodyAsText$default);
                            mutex = mutex4;
                        } else {
                            if (r5 == 2) {
                                mutex2 = paxsenix$AppleTokenManager$getToken$1.L$0;
                                ResultKt.throwOnFailure(objBodyAsText$default);
                                paxsenix$AppleTokenManager$getToken$1.L$0 = mutex2;
                                paxsenix$AppleTokenManager$getToken$1.label = 3;
                                objBodyAsText$default = HttpResponseKt.bodyAsText$default((HttpResponse) objBodyAsText$default, null, paxsenix$AppleTokenManager$getToken$1, 1, null);
                                if (objBodyAsText$default == coroutineSingletons) {
                                    String str = (String) objBodyAsText$default;
                                    Pattern patternCompile = Pattern.compile("/assets/index~[^/]+\\.js");
                                    patternCompile.getClass();
                                    str.getClass();
                                    Matcher matcher = patternCompile.matcher(str);
                                    matcher.getClass();
                                    matcherMatchResultFindNext = RegexKt.findNext(matcher, 0, str);
                                    if (matcherMatchResultFindNext == null) {
                                        throw new Exception("Could not find index JS URL");
                                    }
                                    String strConcat = "https://beta.music.apple.com".concat(matcherMatchResultFindNext.getValue());
                                    HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
                                    HttpRequestKt.url(httpRequestBuilder, strConcat);
                                    httpRequestBuilder.setMethod(HttpMethod.Get);
                                    HttpStatement httpStatement = new HttpStatement(httpRequestBuilder, r2);
                                    paxsenix$AppleTokenManager$getToken$1.L$0 = mutex2;
                                    paxsenix$AppleTokenManager$getToken$1.label = 4;
                                    objBodyAsText$default = httpStatement.execute(paxsenix$AppleTokenManager$getToken$1);
                                    if (objBodyAsText$default != coroutineSingletons) {
                                        mutex3 = mutex2;
                                        paxsenix$AppleTokenManager$getToken$1.L$0 = mutex3;
                                        paxsenix$AppleTokenManager$getToken$1.label = 5;
                                        objBodyAsText$default = HttpResponseKt.bodyAsText$default((HttpResponse) objBodyAsText$default, null, paxsenix$AppleTokenManager$getToken$1, 1, null);
                                    }
                                }
                                return coroutineSingletons;
                            }
                            if (r5 == 3) {
                                mutex2 = paxsenix$AppleTokenManager$getToken$1.L$0;
                                ResultKt.throwOnFailure(objBodyAsText$default);
                                String str2 = (String) objBodyAsText$default;
                                Pattern patternCompile2 = Pattern.compile("/assets/index~[^/]+\\.js");
                                patternCompile2.getClass();
                                str2.getClass();
                                Matcher matcher2 = patternCompile2.matcher(str2);
                                matcher2.getClass();
                                matcherMatchResultFindNext = RegexKt.findNext(matcher2, 0, str2);
                                if (matcherMatchResultFindNext == null) {
                                    throw new Exception("Could not find index JS URL");
                                }
                                String strConcat2 = "https://beta.music.apple.com".concat(matcherMatchResultFindNext.getValue());
                                HttpRequestBuilder httpRequestBuilder2 = new HttpRequestBuilder();
                                HttpRequestKt.url(httpRequestBuilder2, strConcat2);
                                httpRequestBuilder2.setMethod(HttpMethod.Get);
                                HttpStatement httpStatement2 = new HttpStatement(httpRequestBuilder2, r2);
                                paxsenix$AppleTokenManager$getToken$1.L$0 = mutex2;
                                paxsenix$AppleTokenManager$getToken$1.label = 4;
                                objBodyAsText$default = httpStatement2.execute(paxsenix$AppleTokenManager$getToken$1);
                                if (objBodyAsText$default != coroutineSingletons) {
                                    mutex3 = mutex2;
                                    paxsenix$AppleTokenManager$getToken$1.L$0 = mutex3;
                                    paxsenix$AppleTokenManager$getToken$1.label = 5;
                                    objBodyAsText$default = HttpResponseKt.bodyAsText$default((HttpResponse) objBodyAsText$default, null, paxsenix$AppleTokenManager$getToken$1, 1, null);
                                }
                                return coroutineSingletons;
                            }
                            if (r5 == 4) {
                                mutex3 = paxsenix$AppleTokenManager$getToken$1.L$0;
                                ResultKt.throwOnFailure(objBodyAsText$default);
                                paxsenix$AppleTokenManager$getToken$1.L$0 = mutex3;
                                paxsenix$AppleTokenManager$getToken$1.label = 5;
                                objBodyAsText$default = HttpResponseKt.bodyAsText$default((HttpResponse) objBodyAsText$default, null, paxsenix$AppleTokenManager$getToken$1, 1, null);
                            } else {
                                if (r5 != 5) {
                                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                                    return null;
                                }
                                mutex3 = paxsenix$AppleTokenManager$getToken$1.L$0;
                                ResultKt.throwOnFailure(objBodyAsText$default);
                            }
                        }
                        String str3 = (String) objBodyAsText$default;
                        Pattern patternCompile3 = Pattern.compile("eyJ[A-Za-z0-9\\-_=]+\\.[A-Za-z0-9\\-_=]+\\.[A-Za-z0-9\\-_=]+");
                        patternCompile3.getClass();
                        str3.getClass();
                        Matcher matcher3 = patternCompile3.matcher(str3);
                        matcher3.getClass();
                        MatcherMatchResult matcherMatchResultFindNext2 = RegexKt.findNext(matcher3, 0, str3);
                        if (matcherMatchResultFindNext2 == null) {
                            throw new Exception("Could not find token");
                        }
                        String value = matcherMatchResultFindNext2.getValue();
                        this.action = value;
                        Timber.Forest.getClass();
                        ConnectionPool.d(new Object[0]);
                        mutex3.unlock(null);
                        return value;
                        String str4 = (String) this.action;
                        if (str4 != null) {
                            mutex.unlock(null);
                            return str4;
                        }
                        try {
                            HttpRequestBuilder httpRequestBuilder3 = new HttpRequestBuilder();
                            HttpRequestKt.url(httpRequestBuilder3, "https://beta.music.apple.com");
                            httpRequestBuilder3.setMethod(HttpMethod.Get);
                            HttpStatement httpStatement3 = new HttpStatement(httpRequestBuilder3, r2);
                            paxsenix$AppleTokenManager$getToken$1.L$0 = mutex;
                            paxsenix$AppleTokenManager$getToken$1.label = 2;
                            Object objExecute = httpStatement3.execute(paxsenix$AppleTokenManager$getToken$1);
                            if (objExecute != coroutineSingletons) {
                                mutex2 = mutex;
                                objBodyAsText$default = objExecute;
                                paxsenix$AppleTokenManager$getToken$1.L$0 = mutex2;
                                paxsenix$AppleTokenManager$getToken$1.label = 3;
                                objBodyAsText$default = HttpResponseKt.bodyAsText$default((HttpResponse) objBodyAsText$default, null, paxsenix$AppleTokenManager$getToken$1, 1, null);
                                if (objBodyAsText$default == coroutineSingletons) {
                                    String str5 = (String) objBodyAsText$default;
                                    Pattern patternCompile4 = Pattern.compile("/assets/index~[^/]+\\.js");
                                    patternCompile4.getClass();
                                    str5.getClass();
                                    Matcher matcher4 = patternCompile4.matcher(str5);
                                    matcher4.getClass();
                                    matcherMatchResultFindNext = RegexKt.findNext(matcher4, 0, str5);
                                    if (matcherMatchResultFindNext == null) {
                                        throw new Exception("Could not find index JS URL");
                                    }
                                    String strConcat3 = "https://beta.music.apple.com".concat(matcherMatchResultFindNext.getValue());
                                    HttpRequestBuilder httpRequestBuilder4 = new HttpRequestBuilder();
                                    HttpRequestKt.url(httpRequestBuilder4, strConcat3);
                                    httpRequestBuilder4.setMethod(HttpMethod.Get);
                                    HttpStatement httpStatement4 = new HttpStatement(httpRequestBuilder4, r2);
                                    paxsenix$AppleTokenManager$getToken$1.L$0 = mutex2;
                                    paxsenix$AppleTokenManager$getToken$1.label = 4;
                                    objBodyAsText$default = httpStatement4.execute(paxsenix$AppleTokenManager$getToken$1);
                                    if (objBodyAsText$default != coroutineSingletons) {
                                        mutex3 = mutex2;
                                        paxsenix$AppleTokenManager$getToken$1.L$0 = mutex3;
                                        paxsenix$AppleTokenManager$getToken$1.label = 5;
                                        objBodyAsText$default = HttpResponseKt.bodyAsText$default((HttpResponse) objBodyAsText$default, null, paxsenix$AppleTokenManager$getToken$1, 1, null);
                                    }
                                }
                            }
                            return coroutineSingletons;
                        } catch (Exception e) {
                            e = e;
                            Timber.Forest.getClass();
                            ConnectionPool.e$1(new Object[0]);
                            throw new Exception("Error fetching Apple Music token: " + e.getMessage(), e);
                        }
                    } catch (Throwable th) {
                        th = th;
                        r2 = mutex;
                        r2.unlock(null);
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Exception e2) {
                e = e2;
            }
        } catch (Exception e3) {
            e = e3;
        } catch (Throwable th3) {
            th = th3;
            r2 = r5;
        }
    }

    public String toString() {
        switch (this.$r8$classId) {
            case 0:
                String str = (String) this.mimeType;
                String str2 = (String) this.action;
                StringBuilder sb = new StringBuilder("NavDeepLinkRequest{");
                Uri uri = (Uri) this.uri;
                if (uri != null) {
                    sb.append(" uri=");
                    sb.append(String.valueOf(uri));
                }
                if (str2 != null) {
                    sb.append(" action=");
                    sb.append(str2);
                }
                if (str != null) {
                    sb.append(" mimetype=");
                    sb.append(str);
                }
                sb.append(" }");
                return sb.toString();
            case 3:
                StringBuilder sb2 = new StringBuilder(32);
                sb2.append((String) this.action);
                sb2.append('{');
                FileLock fileLock = (FileLock) ((FileLock) this.uri).lockChannel;
                String str3 = "";
                while (fileLock != null) {
                    Object obj = fileLock.lockFilename;
                    sb2.append(str3);
                    if (obj == null || !obj.getClass().isArray()) {
                        sb2.append(obj);
                    } else {
                        String strDeepToString = Arrays.deepToString(new Object[]{obj});
                        sb2.append((CharSequence) strDeepToString, 1, strDeepToString.length() - 1);
                    }
                    fileLock = (FileLock) fileLock.lockChannel;
                    str3 = ", ";
                }
                sb2.append('}');
                return sb2.toString();
            default:
                return super.toString();
        }
    }

    public NavDeepLinkRequest(Socket socket) {
        this.$r8$classId = (byte) 9;
        this.uri = socket;
        Source source = socket.getSource();
        source.getClass();
        this.action = new RealBufferedSource(source);
        this.mimeType = Okio__OkioKt.buffer(socket.getSink());
    }

    public NavDeepLinkRequest(TopAppBarState topAppBarState, SpringSpec springSpec, DecayAnimationSpecImpl decayAnimationSpecImpl, Function0 function0) {
        this.$r8$classId = (byte) 6;
        topAppBarState.getClass();
        function0.getClass();
        this.uri = topAppBarState;
        this.action = function0;
        this.mimeType = new NestedScrollConnection() { // from class: com.metrolist.music.ui.utils.AppBarScrollBehavior$nestedScrollConnection$1
            @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
            /* JADX INFO: renamed from: onPostScroll-DzOQY0M */
            public final long mo100onPostScrollDzOQY0M(int i, long j, long j2) {
                NavDeepLinkRequest navDeepLinkRequest = this.this$0;
                TopAppBarState topAppBarState2 = (TopAppBarState) navDeepLinkRequest.uri;
                if (!((Boolean) ((Function0) navDeepLinkRequest.action).invoke()).booleanValue()) {
                    return 0L;
                }
                int i2 = (int) (j & 4294967295L);
                topAppBarState2.contentOffset$delegate.setFloatValue(Float.intBitsToFloat(i2) + topAppBarState2.contentOffset$delegate.getFloatValue());
                if ((topAppBarState2._heightOffset.getFloatValue() == CropImageView.DEFAULT_ASPECT_RATIO || topAppBarState2._heightOffset.getFloatValue() == topAppBarState2.heightOffsetLimit) && Float.intBitsToFloat(i2) == CropImageView.DEFAULT_ASPECT_RATIO && Float.intBitsToFloat((int) (j2 & 4294967295L)) > CropImageView.DEFAULT_ASPECT_RATIO) {
                    topAppBarState2.contentOffset$delegate.setFloatValue(CropImageView.DEFAULT_ASPECT_RATIO);
                }
                topAppBarState2.setHeightOffset(Float.intBitsToFloat(i2) + topAppBarState2._heightOffset.getFloatValue());
                return 0L;
            }
        };
    }

    public NavDeepLinkRequest(String str) {
        this.$r8$classId = (byte) 3;
        FileLock fileLock = new FileLock();
        this.uri = fileLock;
        this.mimeType = fileLock;
        this.action = str;
    }

    public /* synthetic */ NavDeepLinkRequest(Object obj, Object obj2, Object obj3, byte b) {
        this.$r8$classId = b;
        this.uri = obj;
        this.action = obj2;
        this.mimeType = obj3;
    }

    public NavDeepLinkRequest(Context context, Buffer buffer, String str) {
        this.$r8$classId = (byte) 2;
        context.getClass();
        buffer.getClass();
        this.uri = context;
        this.action = str;
        this.mimeType = buffer;
    }

    public NavDeepLinkRequest(Context context, String str) {
        this.$r8$classId = (byte) 5;
        CueDecoder cueDecoder = new CueDecoder((byte) 28);
        this.uri = context;
        this.action = str;
        this.mimeType = cueDecoder;
    }

    public NavDeepLinkRequest(HttpClient httpClient) {
        this.$r8$classId = (byte) 7;
        this.uri = httpClient;
        this.mimeType = new MutexImpl();
    }

    public NavDeepLinkRequest(int i) {
        this.$r8$classId = (byte) 4;
        this.uri = new LinkedHashMap();
        this.action = new LinkedHashSet();
        if (i > 0) {
            this.mimeType = new AtomicInteger(i);
        } else {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$1("Player request budget must be positive");
            throw null;
        }
    }

    public NavDeepLinkRequest(MediaLibraryService.MediaLibrarySession mediaLibrarySession) {
        this.$r8$classId = (byte) 1;
        this.action = mediaLibrarySession;
    }
}
