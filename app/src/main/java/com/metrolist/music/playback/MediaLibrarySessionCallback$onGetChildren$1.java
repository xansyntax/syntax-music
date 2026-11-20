package com.metrolist.music.playback;

import androidx.media3.session.MediaLibraryService;
import java.util.List;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class MediaLibrarySessionCallback$onGetChildren$1 extends SuspendLambda implements Function2 {
    public final /* synthetic */ int $page;
    public final /* synthetic */ int $pageSize;
    public final /* synthetic */ MediaLibraryService.LibraryParams $params;
    public final /* synthetic */ String $parentId;
    public int I$0;
    public int I$1;
    public List L$0;
    public byte label;
    public final /* synthetic */ MediaLibrarySessionCallback this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MediaLibrarySessionCallback$onGetChildren$1(MediaLibrarySessionCallback mediaLibrarySessionCallback, String str, int i, int i2, MediaLibraryService.LibraryParams libraryParams, Continuation continuation) {
        super(2, continuation);
        this.this$0 = mediaLibrarySessionCallback;
        this.$parentId = str;
        this.$page = i;
        this.$pageSize = i2;
        this.$params = libraryParams;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new MediaLibrarySessionCallback$onGetChildren$1(this.this$0, this.$parentId, this.$page, this.$pageSize, this.$params, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((MediaLibrarySessionCallback$onGetChildren$1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code duplicated, block: B:80:0x0218 A[Catch: Exception -> 0x0048, TryCatch #2 {Exception -> 0x0048, blocks: (B:16:0x0040, B:98:0x0260, B:99:0x026f, B:101:0x0275, B:102:0x0281, B:104:0x028d, B:106:0x0297, B:107:0x029b, B:109:0x02a7, B:111:0x02b8, B:112:0x02bc, B:114:0x02cd, B:116:0x02de, B:117:0x02e2, B:119:0x02f4, B:121:0x0313, B:123:0x0317, B:125:0x031b, B:127:0x0321, B:21:0x0051, B:83:0x022c, B:85:0x0232, B:86:0x0235, B:89:0x023a, B:95:0x024d, B:92:0x023f, B:94:0x0248, B:80:0x0218, B:78:0x020d), top: B:179:0x001a, outer: #4 }] */
    /* JADX WARN: Code duplicated, block: B:82:0x022a  */
    /* JADX WARN: Code duplicated, block: B:83:0x022c A[Catch: Exception -> 0x0048, PHI: r1 r10 r13 r15
      0x022c: PHI (r1v29 int) = (r1v26 int), (r1v51 int) binds: [B:81:0x0228, B:22:0x005a] A[DONT_GENERATE, DONT_INLINE]
      0x022c: PHI (r10v21 int) = (r10v19 int), (r10v30 int) binds: [B:81:0x0228, B:22:0x005a] A[DONT_GENERATE, DONT_INLINE]
      0x022c: PHI (r13v11 java.util.List) = (r13v9 java.util.List), (r13v19 java.util.List) binds: [B:81:0x0228, B:22:0x005a] A[DONT_GENERATE, DONT_INLINE]
      0x022c: PHI (r15v13 java.lang.Object) = (r15v12 java.lang.Object), (r15v28 java.lang.Object) binds: [B:81:0x0228, B:22:0x005a] A[DONT_GENERATE, DONT_INLINE], TryCatch #2 {Exception -> 0x0048, blocks: (B:16:0x0040, B:98:0x0260, B:99:0x026f, B:101:0x0275, B:102:0x0281, B:104:0x028d, B:106:0x0297, B:107:0x029b, B:109:0x02a7, B:111:0x02b8, B:112:0x02bc, B:114:0x02cd, B:116:0x02de, B:117:0x02e2, B:119:0x02f4, B:121:0x0313, B:123:0x0317, B:125:0x031b, B:127:0x0321, B:21:0x0051, B:83:0x022c, B:85:0x0232, B:86:0x0235, B:89:0x023a, B:95:0x024d, B:92:0x023f, B:94:0x0248, B:80:0x0218, B:78:0x020d), top: B:179:0x001a, outer: #4 }] */
    /* JADX WARN: Code duplicated, block: B:85:0x0232 A[Catch: Exception -> 0x0048, TryCatch #2 {Exception -> 0x0048, blocks: (B:16:0x0040, B:98:0x0260, B:99:0x026f, B:101:0x0275, B:102:0x0281, B:104:0x028d, B:106:0x0297, B:107:0x029b, B:109:0x02a7, B:111:0x02b8, B:112:0x02bc, B:114:0x02cd, B:116:0x02de, B:117:0x02e2, B:119:0x02f4, B:121:0x0313, B:123:0x0317, B:125:0x031b, B:127:0x0321, B:21:0x0051, B:83:0x022c, B:85:0x0232, B:86:0x0235, B:89:0x023a, B:95:0x024d, B:92:0x023f, B:94:0x0248, B:80:0x0218, B:78:0x020d), top: B:179:0x001a, outer: #4 }] */
    /* JADX WARN: Code duplicated, block: B:88:0x0239  */
    /* JADX WARN: Code duplicated, block: B:91:0x023e  */
    /* JADX WARN: Code duplicated, block: B:92:0x023f A[Catch: Exception -> 0x0048, TryCatch #2 {Exception -> 0x0048, blocks: (B:16:0x0040, B:98:0x0260, B:99:0x026f, B:101:0x0275, B:102:0x0281, B:104:0x028d, B:106:0x0297, B:107:0x029b, B:109:0x02a7, B:111:0x02b8, B:112:0x02bc, B:114:0x02cd, B:116:0x02de, B:117:0x02e2, B:119:0x02f4, B:121:0x0313, B:123:0x0317, B:125:0x031b, B:127:0x0321, B:21:0x0051, B:83:0x022c, B:85:0x0232, B:86:0x0235, B:89:0x023a, B:95:0x024d, B:92:0x023f, B:94:0x0248, B:80:0x0218, B:78:0x020d), top: B:179:0x001a, outer: #4 }] */
    /* JADX WARN: Code duplicated, block: B:94:0x0248 A[Catch: Exception -> 0x0048, TryCatch #2 {Exception -> 0x0048, blocks: (B:16:0x0040, B:98:0x0260, B:99:0x026f, B:101:0x0275, B:102:0x0281, B:104:0x028d, B:106:0x0297, B:107:0x029b, B:109:0x02a7, B:111:0x02b8, B:112:0x02bc, B:114:0x02cd, B:116:0x02de, B:117:0x02e2, B:119:0x02f4, B:121:0x0313, B:123:0x0317, B:125:0x031b, B:127:0x0321, B:21:0x0051, B:83:0x022c, B:85:0x0232, B:86:0x0235, B:89:0x023a, B:95:0x024d, B:92:0x023f, B:94:0x0248, B:80:0x0218, B:78:0x020d), top: B:179:0x001a, outer: #4 }] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v22, types: [java.util.ArrayList, java.util.Collection] */
    /* JADX WARN: Type inference failed for: r0v23, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r0v32, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r0v52 */
    /* JADX WARN: Type inference failed for: r0v53 */
    /* JADX WARN: Type inference failed for: r0v54 */
    /* JADX WARN: Type inference failed for: r0v9, types: [java.util.List] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:81:0x0228 -> B:83:0x022c). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final java.lang.Object invokeSuspend(java.lang.Object r19) {
        /*
            Method dump skipped, instruction units count: 1226
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.metrolist.music.playback.MediaLibrarySessionCallback$onGetChildren$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
