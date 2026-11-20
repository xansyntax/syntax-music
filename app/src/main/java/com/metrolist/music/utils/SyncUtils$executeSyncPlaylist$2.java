package com.metrolist.music.utils;

import androidx.compose.foundation.gestures.ScrollableKt$semanticsScrollBy$2;
import androidx.compose.foundation.text.selection.PlatformSelectionBehaviors;
import androidx.compose.foundation.text.selection.PlatformSelectionBehaviorsImpl;
import androidx.compose.foundation.text.selection.PlatformSelectionBehaviorsImpl$requireTextClassificationSession$2;
import androidx.compose.foundation.text.selection.TextFieldSelectionManager;
import androidx.compose.ui.text.TextRange;
import com.metrolist.innertube.YouTube;
import java.util.List;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.text.StringsKt__IndentKt;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.CoroutineScope;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class SyncUtils$executeSyncPlaylist$2 extends SuspendLambda implements Function2 {
    public Object $browseId;
    public Object $playlistId;
    public final /* synthetic */ byte $r8$classId;
    public Object L$0;
    public SyncUtils L$1;
    public Object L$2;
    public Object L$4;
    public Object L$6;
    public List L$7;
    public Object L$8;
    public Object L$9;
    public byte label;
    public final /* synthetic */ SyncUtils this$0;

    /* JADX INFO: renamed from: com.metrolist.music.utils.SyncUtils$executeSyncPlaylist$2$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class AnonymousClass1 extends SuspendLambda implements Function1 {
        public final /* synthetic */ Object $browseId;
        public final /* synthetic */ byte $r8$classId;
        public byte label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public /* synthetic */ AnonymousClass1(Object obj, Continuation continuation, byte b) {
            super(1, continuation);
            this.$r8$classId = b;
            this.$browseId = obj;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Continuation continuation) {
            byte b = this.$r8$classId;
            Object obj = this.$browseId;
            switch (b) {
                case 0:
                    return new AnonymousClass1((String) obj, continuation, (byte) 0);
                default:
                    return new AnonymousClass1((TextFieldSelectionManager) obj, continuation, (byte) 1);
            }
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Object obj) {
            byte b = this.$r8$classId;
            Unit unit = Unit.INSTANCE;
            Continuation continuation = (Continuation) obj;
            switch (b) {
                case 0:
                    break;
            }
            return ((AnonymousClass1) create(continuation)).invokeSuspend(unit);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object objM1025playlistgIAlus;
            Object objCompletedLibrary;
            Object objWithContext;
            byte b = this.$r8$classId;
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
            Object obj2 = this.$browseId;
            switch (b) {
                case 0:
                    byte b2 = this.label;
                    if (b2 != 0) {
                        if (b2 == 1) {
                            ResultKt.throwOnFailure(obj);
                            objM1025playlistgIAlus = ((Result) obj).value;
                        } else {
                            if (b2 != 2) {
                                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                                return null;
                            }
                            ResultKt.throwOnFailure(obj);
                            objCompletedLibrary = ((Result) obj).value;
                        }
                        return new Result(objCompletedLibrary);
                    }
                    ResultKt.throwOnFailure(obj);
                    this.label = (byte) 1;
                    objM1025playlistgIAlus = YouTube.INSTANCE.m1025playlistgIAlus((String) obj2, this);
                    if (objM1025playlistgIAlus == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                    this.label = (byte) 2;
                    objCompletedLibrary = StringsKt__IndentKt.completedLibrary(objM1025playlistgIAlus, this);
                    if (objCompletedLibrary == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                    return new Result(objCompletedLibrary);
                default:
                    TextFieldSelectionManager textFieldSelectionManager = (TextFieldSelectionManager) obj2;
                    byte b3 = this.label;
                    Unit unit = Unit.INSTANCE;
                    if (b3 != 0) {
                        if (b3 == 1) {
                            ResultKt.throwOnFailure(obj);
                        } else {
                            if (b3 != 2) {
                                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                                return null;
                            }
                            ResultKt.throwOnFailure(obj);
                        }
                        textFieldSelectionManager.textToolbarShownViaProvider = true;
                        return unit;
                    }
                    ResultKt.throwOnFailure(obj);
                    this.label = (byte) 1;
                    if (textFieldSelectionManager.updateClipboardEntry$foundation(this) == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                    Pair contextTextAndSelection = textFieldSelectionManager.getContextTextAndSelection();
                    if (contextTextAndSelection != null) {
                        String str = (String) contextTextAndSelection.first;
                        long j = ((TextRange) contextTextAndSelection.second).packedValue;
                        PlatformSelectionBehaviors platformSelectionBehaviors = textFieldSelectionManager.platformSelectionBehaviors;
                        if (platformSelectionBehaviors != null) {
                            this.label = (byte) 2;
                            PlatformSelectionBehaviorsImpl platformSelectionBehaviorsImpl = (PlatformSelectionBehaviorsImpl) platformSelectionBehaviors;
                            if (str.length() == 0 || TextRange.m741getCollapsedimpl(j)) {
                                objWithContext = unit;
                            } else {
                                objWithContext = AwaitKt.withContext(platformSelectionBehaviorsImpl.coroutineContext, new PlatformSelectionBehaviorsImpl$requireTextClassificationSession$2(platformSelectionBehaviorsImpl, new ScrollableKt$semanticsScrollBy$2(j, platformSelectionBehaviorsImpl, str, (Continuation) null), null), this);
                            }
                            if (objWithContext != coroutineSingletons) {
                                objWithContext = unit;
                            }
                            if (objWithContext == coroutineSingletons) {
                                return coroutineSingletons;
                            }
                        }
                    }
                    textFieldSelectionManager.textToolbarShownViaProvider = true;
                    return unit;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SyncUtils$executeSyncPlaylist$2(String str, String str2, SyncUtils syncUtils, Continuation continuation) {
        super(2, continuation);
        this.$r8$classId = (byte) 0;
        this.$browseId = str;
        this.$playlistId = str2;
        this.this$0 = syncUtils;
    }

    /* JADX WARN: Code duplicated, block: B:103:0x0256 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:105:0x0241 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:22:0x00ca A[PHI: r1
      0x00ca: PHI (r1v33 java.lang.Object) = (r1v30 java.lang.Object), (r1v42 java.lang.Object) binds: [B:32:0x0119, B:21:0x00c1] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:29:0x00f3  */
    /* JADX WARN: Code duplicated, block: B:31:0x00fe  */
    /* JADX WARN: Code duplicated, block: B:36:0x0121  */
    /* JADX WARN: Code duplicated, block: B:38:0x012a  */
    /* JADX WARN: Code duplicated, block: B:42:0x014f A[Catch: Exception -> 0x02d5, LOOP:1: B:40:0x0149->B:42:0x014f, LOOP_END, TryCatch #1 {Exception -> 0x02d5, blocks: (B:19:0x00b7, B:46:0x017b, B:39:0x012d, B:40:0x0149, B:42:0x014f, B:43:0x015b), top: B:94:0x000e }] */
    /* JADX WARN: Code duplicated, block: B:45:0x0179  */
    /* JADX WARN: Code duplicated, block: B:46:0x017b A[Catch: Exception -> 0x02d5, PHI: r0 r1 r2 r3 r4 r10
      0x017b: PHI (r0v22 ??) = (r0v46 ??), (r0v27 ??) binds: [B:44:0x0177, B:20:0x00ba] A[DONT_GENERATE, DONT_INLINE]
      0x017b: PHI (r1v43 java.util.List) = (r1v39 java.util.List), (r1v44 java.util.List) binds: [B:44:0x0177, B:20:0x00ba] A[DONT_GENERATE, DONT_INLINE]
      0x017b: PHI (r2v19 ??) = (r2v43 ??), (r2v44 ??) binds: [B:44:0x0177, B:20:0x00ba] A[DONT_GENERATE, DONT_INLINE]
      0x017b: PHI (r3v17 java.util.Set) = (r3v16 java.util.Set), (r3v20 java.util.Set) binds: [B:44:0x0177, B:20:0x00ba] A[DONT_GENERATE, DONT_INLINE]
      0x017b: PHI (r4v17 java.lang.Object) = (r4v16 java.lang.Object), (r4v19 java.lang.Object) binds: [B:44:0x0177, B:20:0x00ba] A[DONT_GENERATE, DONT_INLINE]
      0x017b: PHI (r10v17 java.lang.Object) = (r10v16 java.lang.Object), (r10v21 java.lang.Object) binds: [B:44:0x0177, B:20:0x00ba] A[DONT_GENERATE, DONT_INLINE], TRY_LEAVE, TryCatch #1 {Exception -> 0x02d5, blocks: (B:19:0x00b7, B:46:0x017b, B:39:0x012d, B:40:0x0149, B:42:0x014f, B:43:0x015b), top: B:94:0x000e }] */
    /* JADX WARN: Code duplicated, block: B:50:0x019c A[Catch: Exception -> 0x0234, TRY_LEAVE, TryCatch #2 {Exception -> 0x0234, blocks: (B:48:0x0196, B:50:0x019c, B:63:0x0238, B:64:0x0241, B:66:0x0247, B:68:0x0256, B:69:0x025a, B:60:0x0224, B:10:0x005e, B:51:0x01a2, B:54:0x01c7, B:57:0x0200, B:13:0x0083, B:16:0x00a2), top: B:94:0x000e, inners: #3 }] */
    /* JADX WARN: Code duplicated, block: B:53:0x01c5  */
    /* JADX WARN: Code duplicated, block: B:54:0x01c7 A[Catch: Exception -> 0x0224, PHI: r0 r1 r2 r3 r4 r7 r10 r11 r12 r13
      0x01c7: PHI (r0v4 ??) = (r0v42 ??), (r0v43 ??) binds: [B:52:0x01c3, B:17:0x00a5] A[DONT_GENERATE, DONT_INLINE]
      0x01c7: PHI (r1v6 com.metrolist.innertube.models.SongItem) = (r1v11 com.metrolist.innertube.models.SongItem), (r1v46 com.metrolist.innertube.models.SongItem) binds: [B:52:0x01c3, B:17:0x00a5] A[DONT_GENERATE, DONT_INLINE]
      0x01c7: PHI (r2v6 ??) = (r2v39 ??), (r2v40 ??) binds: [B:52:0x01c3, B:17:0x00a5] A[DONT_GENERATE, DONT_INLINE]
      0x01c7: PHI (r3v2 java.util.List) = (r3v3 java.util.List), (r3v23 java.util.List) binds: [B:52:0x01c3, B:17:0x00a5] A[DONT_GENERATE, DONT_INLINE]
      0x01c7: PHI (r4v5 java.util.List) = (r4v6 java.util.List), (r4v20 java.util.List) binds: [B:52:0x01c3, B:17:0x00a5] A[DONT_GENERATE, DONT_INLINE]
      0x01c7: PHI (r7v5 int A[IMMUTABLE_TYPE]) = (r7v11 int), (r7v22 int) binds: [B:52:0x01c3, B:17:0x00a5] A[DONT_GENERATE, DONT_INLINE]
      0x01c7: PHI (r10v3 ??) = (r10v30 ??), (r10v31 ??) binds: [B:52:0x01c3, B:17:0x00a5] A[DONT_GENERATE, DONT_INLINE]
      0x01c7: PHI (r11v2 ??) = (r11v32 ??), (r11v33 ??) binds: [B:52:0x01c3, B:17:0x00a5] A[DONT_GENERATE, DONT_INLINE]
      0x01c7: PHI (r12v2 java.lang.Object) = (r12v3 java.lang.Object), (r12v11 java.lang.Object) binds: [B:52:0x01c3, B:17:0x00a5] A[DONT_GENERATE, DONT_INLINE]
      0x01c7: PHI (r13v2 java.lang.Object) = (r13v6 java.lang.Object), (r13v8 java.lang.Object) binds: [B:52:0x01c3, B:17:0x00a5] A[DONT_GENERATE, DONT_INLINE], TryCatch #3 {Exception -> 0x0224, blocks: (B:10:0x005e, B:51:0x01a2, B:54:0x01c7, B:57:0x0200, B:13:0x0083, B:16:0x00a2), top: B:94:0x000e, outer: #2 }] */
    /* JADX WARN: Code duplicated, block: B:56:0x01fe  */
    /* JADX WARN: Code duplicated, block: B:57:0x0200 A[Catch: Exception -> 0x0224, PHI: r0 r1 r2 r3 r4 r10 r11 r12
      0x0200: PHI (r0v3 ??) = (r0v44 ??), (r0v45 ??) binds: [B:55:0x01fc, B:13:0x0083] A[DONT_GENERATE, DONT_INLINE]
      0x0200: PHI (r1v4 com.metrolist.innertube.models.SongItem) = (r1v6 com.metrolist.innertube.models.SongItem), (r1v50 com.metrolist.innertube.models.SongItem) binds: [B:55:0x01fc, B:13:0x0083] A[DONT_GENERATE, DONT_INLINE]
      0x0200: PHI (r2v5 ??) = (r2v41 ??), (r2v42 ??) binds: [B:55:0x01fc, B:13:0x0083] A[DONT_GENERATE, DONT_INLINE]
      0x0200: PHI (r3v1 java.util.List) = (r3v2 java.util.List), (r3v26 java.util.List) binds: [B:55:0x01fc, B:13:0x0083] A[DONT_GENERATE, DONT_INLINE]
      0x0200: PHI (r4v4 java.util.List) = (r4v5 java.util.List), (r4v21 java.util.List) binds: [B:55:0x01fc, B:13:0x0083] A[DONT_GENERATE, DONT_INLINE]
      0x0200: PHI (r10v2 ??) = (r10v32 ??), (r10v33 ??) binds: [B:55:0x01fc, B:13:0x0083] A[DONT_GENERATE, DONT_INLINE]
      0x0200: PHI (r11v1 ??) = (r11v34 ??), (r11v35 ??) binds: [B:55:0x01fc, B:13:0x0083] A[DONT_GENERATE, DONT_INLINE]
      0x0200: PHI (r12v1 java.lang.Object) = (r12v2 java.lang.Object), (r12v12 java.lang.Object) binds: [B:55:0x01fc, B:13:0x0083] A[DONT_GENERATE, DONT_INLINE], TRY_LEAVE, TryCatch #3 {Exception -> 0x0224, blocks: (B:10:0x005e, B:51:0x01a2, B:54:0x01c7, B:57:0x0200, B:13:0x0083, B:16:0x00a2), top: B:94:0x000e, outer: #2 }] */
    /* JADX WARN: Code duplicated, block: B:63:0x0238 A[Catch: Exception -> 0x0234, TryCatch #2 {Exception -> 0x0234, blocks: (B:48:0x0196, B:50:0x019c, B:63:0x0238, B:64:0x0241, B:66:0x0247, B:68:0x0256, B:69:0x025a, B:60:0x0224, B:10:0x005e, B:51:0x01a2, B:54:0x01c7, B:57:0x0200, B:13:0x0083, B:16:0x00a2), top: B:94:0x000e, inners: #3 }] */
    /* JADX WARN: Code duplicated, block: B:66:0x0247 A[Catch: Exception -> 0x0234, TryCatch #2 {Exception -> 0x0234, blocks: (B:48:0x0196, B:50:0x019c, B:63:0x0238, B:64:0x0241, B:66:0x0247, B:68:0x0256, B:69:0x025a, B:60:0x0224, B:10:0x005e, B:51:0x01a2, B:54:0x01c7, B:57:0x0200, B:13:0x0083, B:16:0x00a2), top: B:94:0x000e, inners: #3 }] */
    /* JADX WARN: Code duplicated, block: B:73:0x0277 A[Catch: Exception -> 0x02c0, TRY_LEAVE, TryCatch #0 {Exception -> 0x02c0, blocks: (B:71:0x0271, B:73:0x0277, B:81:0x02c3, B:79:0x02b2, B:7:0x0039, B:77:0x02a4, B:74:0x027d), top: B:94:0x000e, inners: #4 }] */
    /* JADX WARN: Code duplicated, block: B:81:0x02c3 A[Catch: Exception -> 0x02c0, TRY_LEAVE, TryCatch #0 {Exception -> 0x02c0, blocks: (B:71:0x0271, B:73:0x0277, B:81:0x02c3, B:79:0x02b2, B:7:0x0039, B:77:0x02a4, B:74:0x027d), top: B:94:0x000e, inners: #4 }] */
    /* JADX WARN: Code duplicated, block: B:84:0x02e1  */
    /* JADX WARN: Code duplicated, block: B:87:0x02e8  */
    /* JADX WARN: Code duplicated, block: B:88:0x02f3  */
    /* JADX WARN: Code duplicated, block: B:91:0x02fa  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [byte, com.metrolist.innertube.models.SongItem] */
    /* JADX WARN: Type inference failed for: r0v1, types: [com.metrolist.music.utils.SyncUtils] */
    /* JADX WARN: Type inference failed for: r0v22 */
    /* JADX WARN: Type inference failed for: r0v23 */
    /* JADX WARN: Type inference failed for: r0v27 */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v35, types: [java.util.Set] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v41 */
    /* JADX WARN: Type inference failed for: r0v42 */
    /* JADX WARN: Type inference failed for: r0v43 */
    /* JADX WARN: Type inference failed for: r0v44 */
    /* JADX WARN: Type inference failed for: r0v45 */
    /* JADX WARN: Type inference failed for: r0v46 */
    /* JADX WARN: Type inference failed for: r0v5, types: [java.lang.Object, java.util.Set] */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r10v19 */
    /* JADX WARN: Type inference failed for: r10v2, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r10v26 */
    /* JADX WARN: Type inference failed for: r10v27 */
    /* JADX WARN: Type inference failed for: r10v28 */
    /* JADX WARN: Type inference failed for: r10v29 */
    /* JADX WARN: Type inference failed for: r10v3, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r10v30 */
    /* JADX WARN: Type inference failed for: r10v31 */
    /* JADX WARN: Type inference failed for: r10v32 */
    /* JADX WARN: Type inference failed for: r10v33 */
    /* JADX WARN: Type inference failed for: r10v4, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r10v6 */
    /* JADX WARN: Type inference failed for: r11v1, types: [com.metrolist.music.utils.SyncUtils] */
    /* JADX WARN: Type inference failed for: r11v2, types: [com.metrolist.music.utils.SyncUtils] */
    /* JADX WARN: Type inference failed for: r11v24 */
    /* JADX WARN: Type inference failed for: r11v28 */
    /* JADX WARN: Type inference failed for: r11v29 */
    /* JADX WARN: Type inference failed for: r11v3, types: [com.metrolist.music.utils.SyncUtils] */
    /* JADX WARN: Type inference failed for: r11v30 */
    /* JADX WARN: Type inference failed for: r11v31 */
    /* JADX WARN: Type inference failed for: r11v32 */
    /* JADX WARN: Type inference failed for: r11v33 */
    /* JADX WARN: Type inference failed for: r11v34 */
    /* JADX WARN: Type inference failed for: r11v35 */
    /* JADX WARN: Type inference failed for: r11v4 */
    /* JADX WARN: Type inference failed for: r2v0, types: [int] */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v11 */
    /* JADX WARN: Type inference failed for: r2v13, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v15 */
    /* JADX WARN: Type inference failed for: r2v19 */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v20 */
    /* JADX WARN: Type inference failed for: r2v27, types: [java.util.Iterator] */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v35 */
    /* JADX WARN: Type inference failed for: r2v36 */
    /* JADX WARN: Type inference failed for: r2v37 */
    /* JADX WARN: Type inference failed for: r2v38 */
    /* JADX WARN: Type inference failed for: r2v39 */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v40 */
    /* JADX WARN: Type inference failed for: r2v41 */
    /* JADX WARN: Type inference failed for: r2v42 */
    /* JADX WARN: Type inference failed for: r2v43 */
    /* JADX WARN: Type inference failed for: r2v44 */
    /* JADX WARN: Type inference failed for: r2v5, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v6, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v7, types: [java.lang.Object, java.util.Iterator] */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v10, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v11 */
    /* JADX WARN: Type inference failed for: r3v30, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v31 */
    /* JADX WARN: Type inference failed for: r3v32 */
    /* JADX WARN: Type inference failed for: r3v33 */
    /* JADX WARN: Type inference failed for: r3v34 */
    /* JADX WARN: Type inference failed for: r3v6 */
    /* JADX WARN: Type inference failed for: r3v9 */
    /* JADX WARN: Type inference failed for: r4v12, types: [com.metrolist.music.utils.SyncUtils] */
    /* JADX WARN: Type inference failed for: r4v14 */
    /* JADX WARN: Type inference failed for: r4v23, types: [com.metrolist.music.utils.SyncUtils] */
    /* JADX WARN: Type inference failed for: r4v24 */
    /* JADX WARN: Type inference failed for: r4v25 */
    /* JADX WARN: Type inference failed for: r4v26 */
    /* JADX WARN: Type inference failed for: r4v27 */
    /* JADX WARN: Type inference failed for: r4v7 */
    /* JADX WARN: Type inference failed for: r4v9 */
    /* JADX WARN: Type inference failed for: r7v2 */
    /* JADX WARN: Type inference failed for: r7v7 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:58:0x0220 -> B:61:0x0231). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:75:0x02a1 -> B:77:0x02a4). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't find top splitter block for handler:B:60:0x0224
        	at jadx.core.utils.BlockUtils.getTopSplitterForHandler(BlockUtils.java:1478)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.collectHandlerRegions(ExcHandlersRegionMaker.java:53)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.process(ExcHandlersRegionMaker.java:38)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:27)
        */
    private final java.lang.Object invokeSuspend$com$metrolist$music$utils$SyncUtils$executeSyncEpisodesForLater$2(java.lang.Object r17) {
        /*
            Method dump skipped, instruction units count: 794
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.metrolist.music.utils.SyncUtils$executeSyncPlaylist$2.invokeSuspend$com$metrolist$music$utils$SyncUtils$executeSyncEpisodesForLater$2(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        byte b = this.$r8$classId;
        SyncUtils syncUtils = this.this$0;
        switch (b) {
            case 0:
                return new SyncUtils$executeSyncPlaylist$2((String) this.$browseId, (String) this.$playlistId, syncUtils, continuation);
            case 1:
                return new SyncUtils$executeSyncPlaylist$2(syncUtils, continuation, (byte) 1);
            default:
                return new SyncUtils$executeSyncPlaylist$2(syncUtils, continuation, (byte) 2);
        }
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        CoroutineScope coroutineScope = (CoroutineScope) obj;
        Continuation continuation = (Continuation) obj2;
        switch (b) {
            case 0:
                break;
            case 1:
                break;
        }
        return ((SyncUtils$executeSyncPlaylist$2) create(coroutineScope, continuation)).invokeSuspend(unit);
    }

    /* JADX WARN: Code duplicated, block: B:183:0x04e6  */
    /* JADX WARN: Code duplicated, block: B:199:0x0565 A[Catch: Exception -> 0x058f, TryCatch #0 {Exception -> 0x058f, blocks: (B:197:0x0559, B:199:0x0565, B:200:0x056e, B:202:0x0574, B:204:0x0583, B:206:0x058b, B:208:0x0592, B:209:0x059f, B:211:0x05a5, B:212:0x05b1, B:214:0x05bb, B:218:0x05c5, B:227:0x060f, B:228:0x062d, B:230:0x0633, B:232:0x0642, B:236:0x064d, B:237:0x0651, B:238:0x065e, B:240:0x0664, B:241:0x0670), top: B:261:0x0559 }] */
    /* JADX WARN: Code duplicated, block: B:202:0x0574 A[Catch: Exception -> 0x058f, TryCatch #0 {Exception -> 0x058f, blocks: (B:197:0x0559, B:199:0x0565, B:200:0x056e, B:202:0x0574, B:204:0x0583, B:206:0x058b, B:208:0x0592, B:209:0x059f, B:211:0x05a5, B:212:0x05b1, B:214:0x05bb, B:218:0x05c5, B:227:0x060f, B:228:0x062d, B:230:0x0633, B:232:0x0642, B:236:0x064d, B:237:0x0651, B:238:0x065e, B:240:0x0664, B:241:0x0670), top: B:261:0x0559 }] */
    /* JADX WARN: Code duplicated, block: B:211:0x05a5 A[Catch: Exception -> 0x058f, LOOP:5: B:209:0x059f->B:211:0x05a5, LOOP_END, TryCatch #0 {Exception -> 0x058f, blocks: (B:197:0x0559, B:199:0x0565, B:200:0x056e, B:202:0x0574, B:204:0x0583, B:206:0x058b, B:208:0x0592, B:209:0x059f, B:211:0x05a5, B:212:0x05b1, B:214:0x05bb, B:218:0x05c5, B:227:0x060f, B:228:0x062d, B:230:0x0633, B:232:0x0642, B:236:0x064d, B:237:0x0651, B:238:0x065e, B:240:0x0664, B:241:0x0670), top: B:261:0x0559 }] */
    /* JADX WARN: Code duplicated, block: B:221:0x05f4  */
    /* JADX WARN: Code duplicated, block: B:226:0x060d  */
    /* JADX WARN: Code duplicated, block: B:230:0x0633 A[Catch: Exception -> 0x058f, TryCatch #0 {Exception -> 0x058f, blocks: (B:197:0x0559, B:199:0x0565, B:200:0x056e, B:202:0x0574, B:204:0x0583, B:206:0x058b, B:208:0x0592, B:209:0x059f, B:211:0x05a5, B:212:0x05b1, B:214:0x05bb, B:218:0x05c5, B:227:0x060f, B:228:0x062d, B:230:0x0633, B:232:0x0642, B:236:0x064d, B:237:0x0651, B:238:0x065e, B:240:0x0664, B:241:0x0670), top: B:261:0x0559 }] */
    /* JADX WARN: Code duplicated, block: B:236:0x064d A[Catch: Exception -> 0x058f, TryCatch #0 {Exception -> 0x058f, blocks: (B:197:0x0559, B:199:0x0565, B:200:0x056e, B:202:0x0574, B:204:0x0583, B:206:0x058b, B:208:0x0592, B:209:0x059f, B:211:0x05a5, B:212:0x05b1, B:214:0x05bb, B:218:0x05c5, B:227:0x060f, B:228:0x062d, B:230:0x0633, B:232:0x0642, B:236:0x064d, B:237:0x0651, B:238:0x065e, B:240:0x0664, B:241:0x0670), top: B:261:0x0559 }] */
    /* JADX WARN: Code duplicated, block: B:240:0x0664 A[Catch: Exception -> 0x058f, LOOP:7: B:238:0x065e->B:240:0x0664, LOOP_END, TryCatch #0 {Exception -> 0x058f, blocks: (B:197:0x0559, B:199:0x0565, B:200:0x056e, B:202:0x0574, B:204:0x0583, B:206:0x058b, B:208:0x0592, B:209:0x059f, B:211:0x05a5, B:212:0x05b1, B:214:0x05bb, B:218:0x05c5, B:227:0x060f, B:228:0x062d, B:230:0x0633, B:232:0x0642, B:236:0x064d, B:237:0x0651, B:238:0x065e, B:240:0x0664, B:241:0x0670), top: B:261:0x0559 }] */
    /* JADX WARN: Code duplicated, block: B:244:0x06a2  */
    /* JADX WARN: Code duplicated, block: B:251:0x06c4  */
    /* JADX WARN: Code duplicated, block: B:255:0x06d6  */
    /* JADX WARN: Code duplicated, block: B:319:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:324:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:325:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:77:0x0230 A[Catch: Exception -> 0x027d, TRY_LEAVE, TryCatch #10 {Exception -> 0x027d, blocks: (B:75:0x022a, B:77:0x0230, B:84:0x026f, B:86:0x0281), top: B:278:0x022a }] */
    /* JADX WARN: Code duplicated, block: B:81:0x0267  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v100 */
    /* JADX WARN: Type inference failed for: r0v101 */
    /* JADX WARN: Type inference failed for: r0v102 */
    /* JADX WARN: Type inference failed for: r0v103 */
    /* JADX WARN: Type inference failed for: r0v104 */
    /* JADX WARN: Type inference failed for: r0v105 */
    /* JADX WARN: Type inference failed for: r0v106 */
    /* JADX WARN: Type inference failed for: r0v107 */
    /* JADX WARN: Type inference failed for: r0v108 */
    /* JADX WARN: Type inference failed for: r0v109 */
    /* JADX WARN: Type inference failed for: r0v110 */
    /* JADX WARN: Type inference failed for: r0v111 */
    /* JADX WARN: Type inference failed for: r0v112 */
    /* JADX WARN: Type inference failed for: r0v113 */
    /* JADX WARN: Type inference failed for: r0v114 */
    /* JADX WARN: Type inference failed for: r0v115 */
    /* JADX WARN: Type inference failed for: r0v116 */
    /* JADX WARN: Type inference failed for: r0v53, types: [com.metrolist.music.utils.SyncUtils] */
    /* JADX WARN: Type inference failed for: r0v54 */
    /* JADX WARN: Type inference failed for: r0v60 */
    /* JADX WARN: Type inference failed for: r0v61, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r0v62 */
    /* JADX WARN: Type inference failed for: r0v63, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r0v64, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r0v65, types: [java.lang.Object, java.util.List] */
    /* JADX WARN: Type inference failed for: r0v68, types: [com.metrolist.music.utils.SyncUtils] */
    /* JADX WARN: Type inference failed for: r0v70 */
    /* JADX WARN: Type inference failed for: r0v71 */
    /* JADX WARN: Type inference failed for: r0v72 */
    /* JADX WARN: Type inference failed for: r0v73, types: [com.metrolist.music.utils.SyncUtils] */
    /* JADX WARN: Type inference failed for: r0v77 */
    /* JADX WARN: Type inference failed for: r0v99 */
    /* JADX WARN: Type inference failed for: r10v10, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r10v11 */
    /* JADX WARN: Type inference failed for: r10v12, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r10v13 */
    /* JADX WARN: Type inference failed for: r10v9 */
    /* JADX WARN: Type inference failed for: r1v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v100 */
    /* JADX WARN: Type inference failed for: r1v101 */
    /* JADX WARN: Type inference failed for: r1v102 */
    /* JADX WARN: Type inference failed for: r1v105 */
    /* JADX WARN: Type inference failed for: r1v106 */
    /* JADX WARN: Type inference failed for: r1v107 */
    /* JADX WARN: Type inference failed for: r1v108 */
    /* JADX WARN: Type inference failed for: r1v109 */
    /* JADX WARN: Type inference failed for: r1v110 */
    /* JADX WARN: Type inference failed for: r1v111 */
    /* JADX WARN: Type inference failed for: r1v112 */
    /* JADX WARN: Type inference failed for: r1v113 */
    /* JADX WARN: Type inference failed for: r1v114 */
    /* JADX WARN: Type inference failed for: r1v115 */
    /* JADX WARN: Type inference failed for: r1v116 */
    /* JADX WARN: Type inference failed for: r1v15 */
    /* JADX WARN: Type inference failed for: r1v19 */
    /* JADX WARN: Type inference failed for: r1v2, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v20 */
    /* JADX WARN: Type inference failed for: r1v21 */
    /* JADX WARN: Type inference failed for: r1v23 */
    /* JADX WARN: Type inference failed for: r1v24 */
    /* JADX WARN: Type inference failed for: r1v25 */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v33 */
    /* JADX WARN: Type inference failed for: r1v35 */
    /* JADX WARN: Type inference failed for: r1v36, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v38 */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v40 */
    /* JADX WARN: Type inference failed for: r1v41, types: [com.metrolist.innertube.models.AlbumItem] */
    /* JADX WARN: Type inference failed for: r1v44, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v47 */
    /* JADX WARN: Type inference failed for: r1v48, types: [com.metrolist.innertube.models.AlbumItem, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v49, types: [com.metrolist.innertube.models.AlbumItem, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v52 */
    /* JADX WARN: Type inference failed for: r1v54, types: [com.metrolist.innertube.models.AlbumItem, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v8, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v88 */
    /* JADX WARN: Type inference failed for: r1v89 */
    /* JADX WARN: Type inference failed for: r1v90 */
    /* JADX WARN: Type inference failed for: r1v91 */
    /* JADX WARN: Type inference failed for: r1v92 */
    /* JADX WARN: Type inference failed for: r1v93 */
    /* JADX WARN: Type inference failed for: r1v94 */
    /* JADX WARN: Type inference failed for: r1v95 */
    /* JADX WARN: Type inference failed for: r1v96 */
    /* JADX WARN: Type inference failed for: r1v97 */
    /* JADX WARN: Type inference failed for: r1v98 */
    /* JADX WARN: Type inference failed for: r1v99 */
    /* JADX WARN: Type inference failed for: r2v17 */
    /* JADX WARN: Type inference failed for: r2v19 */
    /* JADX WARN: Type inference failed for: r2v24, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r2v25 */
    /* JADX WARN: Type inference failed for: r2v29 */
    /* JADX WARN: Type inference failed for: r2v30, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v31 */
    /* JADX WARN: Type inference failed for: r2v32, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v33, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v34, types: [java.lang.Object, java.util.Iterator] */
    /* JADX WARN: Type inference failed for: r2v50 */
    /* JADX WARN: Type inference failed for: r2v53 */
    /* JADX WARN: Type inference failed for: r2v54, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v56 */
    /* JADX WARN: Type inference failed for: r2v57 */
    /* JADX WARN: Type inference failed for: r2v58 */
    /* JADX WARN: Type inference failed for: r2v67 */
    /* JADX WARN: Type inference failed for: r2v68 */
    /* JADX WARN: Type inference failed for: r2v69 */
    /* JADX WARN: Type inference failed for: r2v70 */
    /* JADX WARN: Type inference failed for: r2v71 */
    /* JADX WARN: Type inference failed for: r2v72 */
    /* JADX WARN: Type inference failed for: r2v73 */
    /* JADX WARN: Type inference failed for: r2v74 */
    /* JADX WARN: Type inference failed for: r2v75 */
    /* JADX WARN: Type inference failed for: r2v76 */
    /* JADX WARN: Type inference failed for: r2v77 */
    /* JADX WARN: Type inference failed for: r2v78 */
    /* JADX WARN: Type inference failed for: r2v79 */
    /* JADX WARN: Type inference failed for: r2v80 */
    /* JADX WARN: Type inference failed for: r2v81 */
    /* JADX WARN: Type inference failed for: r2v82, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r2v83 */
    /* JADX WARN: Type inference failed for: r3v16 */
    /* JADX WARN: Type inference failed for: r3v17 */
    /* JADX WARN: Type inference failed for: r3v18, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v20 */
    /* JADX WARN: Type inference failed for: r3v21 */
    /* JADX WARN: Type inference failed for: r3v22 */
    /* JADX WARN: Type inference failed for: r3v23, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v24 */
    /* JADX WARN: Type inference failed for: r3v25, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v26, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v27, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v28, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v29 */
    /* JADX WARN: Type inference failed for: r3v31, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v32 */
    /* JADX WARN: Type inference failed for: r3v33 */
    /* JADX WARN: Type inference failed for: r3v35 */
    /* JADX WARN: Type inference failed for: r3v37 */
    /* JADX WARN: Type inference failed for: r3v5 */
    /* JADX WARN: Type inference failed for: r3v57 */
    /* JADX WARN: Type inference failed for: r3v58 */
    /* JADX WARN: Type inference failed for: r3v59 */
    /* JADX WARN: Type inference failed for: r3v60 */
    /* JADX WARN: Type inference failed for: r3v61 */
    /* JADX WARN: Type inference failed for: r3v62 */
    /* JADX WARN: Type inference failed for: r3v63 */
    /* JADX WARN: Type inference failed for: r3v64 */
    /* JADX WARN: Type inference failed for: r3v65 */
    /* JADX WARN: Type inference failed for: r3v66 */
    /* JADX WARN: Type inference failed for: r3v67 */
    /* JADX WARN: Type inference failed for: r3v68 */
    /* JADX WARN: Type inference failed for: r3v69 */
    /* JADX WARN: Type inference failed for: r3v70 */
    /* JADX WARN: Type inference failed for: r3v71 */
    /* JADX WARN: Type inference failed for: r3v72 */
    /* JADX WARN: Type inference failed for: r3v73 */
    /* JADX WARN: Type inference failed for: r3v74 */
    /* JADX WARN: Type inference failed for: r3v75 */
    /* JADX WARN: Type inference failed for: r3v76 */
    /* JADX WARN: Type inference failed for: r3v77 */
    /* JADX WARN: Type inference failed for: r4v19 */
    /* JADX WARN: Type inference failed for: r4v20, types: [com.metrolist.music.utils.SyncUtils] */
    /* JADX WARN: Type inference failed for: r4v21, types: [com.metrolist.music.utils.SyncUtils] */
    /* JADX WARN: Type inference failed for: r4v22, types: [com.metrolist.music.utils.SyncUtils] */
    /* JADX WARN: Type inference failed for: r4v23, types: [com.metrolist.music.utils.SyncUtils] */
    /* JADX WARN: Type inference failed for: r4v24, types: [com.metrolist.music.utils.SyncUtils] */
    /* JADX WARN: Type inference failed for: r4v29 */
    /* JADX WARN: Type inference failed for: r4v30 */
    /* JADX WARN: Type inference failed for: r4v33 */
    /* JADX WARN: Type inference failed for: r4v34 */
    /* JADX WARN: Type inference failed for: r4v47 */
    /* JADX WARN: Type inference failed for: r4v48 */
    /* JADX WARN: Type inference failed for: r4v49 */
    /* JADX WARN: Type inference failed for: r4v50 */
    /* JADX WARN: Type inference failed for: r4v51 */
    /* JADX WARN: Type inference failed for: r4v52 */
    /* JADX WARN: Type inference failed for: r4v53 */
    /* JADX WARN: Type inference failed for: r4v54 */
    /* JADX WARN: Type inference failed for: r4v55 */
    /* JADX WARN: Type inference failed for: r4v56 */
    /* JADX WARN: Type inference failed for: r4v57 */
    /* JADX WARN: Type inference failed for: r4v58 */
    /* JADX WARN: Type inference failed for: r4v59 */
    /* JADX WARN: Type inference failed for: r4v60 */
    /* JADX WARN: Type inference failed for: r6v0 */
    /* JADX WARN: Type inference failed for: r6v14 */
    /* JADX WARN: Type inference failed for: r6v15 */
    /* JADX WARN: Type inference failed for: r6v16 */
    /* JADX WARN: Type inference failed for: r6v17, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r6v18 */
    /* JADX WARN: Type inference failed for: r6v19, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r6v20, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r6v21, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r6v22 */
    /* JADX WARN: Type inference failed for: r6v27 */
    /* JADX WARN: Type inference failed for: r6v28 */
    /* JADX WARN: Type inference failed for: r6v29 */
    /* JADX WARN: Type inference failed for: r6v30 */
    /* JADX WARN: Type inference failed for: r6v31 */
    /* JADX WARN: Type inference failed for: r6v32 */
    /* JADX WARN: Type inference failed for: r6v33 */
    /* JADX WARN: Type inference failed for: r6v34 */
    /* JADX WARN: Type inference failed for: r6v35 */
    /* JADX WARN: Type inference failed for: r6v36 */
    /* JADX WARN: Type inference failed for: r6v37 */
    /* JADX WARN: Type inference failed for: r6v38 */
    /* JADX WARN: Type inference failed for: r6v39 */
    /* JADX WARN: Type inference failed for: r6v40 */
    /* JADX WARN: Type inference failed for: r7v17 */
    /* JADX WARN: Type inference failed for: r7v18 */
    /* JADX WARN: Type inference failed for: r7v39 */
    /* JADX WARN: Type inference failed for: r7v40 */
    /* JADX WARN: Type inference failed for: r7v42, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r7v43 */
    /* JADX WARN: Type inference failed for: r7v44, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r7v45 */
    /* JADX WARN: Type inference failed for: r7v46 */
    /* JADX WARN: Type inference failed for: r7v47 */
    /* JADX WARN: Type inference failed for: r7v48, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r7v49 */
    /* JADX WARN: Type inference failed for: r7v50 */
    /* JADX WARN: Type inference failed for: r7v51 */
    /* JADX WARN: Type inference failed for: r7v53 */
    /* JADX WARN: Type inference failed for: r7v54 */
    /* JADX WARN: Type inference failed for: r7v60 */
    /* JADX WARN: Type inference failed for: r7v61 */
    /* JADX WARN: Type inference failed for: r9v17 */
    /* JADX WARN: Type inference failed for: r9v18, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r9v52 */
    /* JADX WARN: Type inference failed for: r9v54 */
    /* JADX WARN: Type inference failed for: r9v55 */
    /* JADX WARN: Type inference failed for: r9v56, types: [com.metrolist.music.utils.SyncUtils] */
    /* JADX WARN: Type inference failed for: r9v57 */
    /* JADX WARN: Type inference failed for: r9v58 */
    /* JADX WARN: Type inference failed for: r9v59 */
    /* JADX WARN: Type inference failed for: r9v8 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:116:0x035d -> B:91:0x0293). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:118:0x0360 -> B:91:0x0293). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:81:0x0267 -> B:82:0x0268). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final java.lang.Object invokeSuspend(java.lang.Object r32) {
        /*
            Method dump skipped, instruction units count: 1796
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.metrolist.music.utils.SyncUtils$executeSyncPlaylist$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SyncUtils$executeSyncPlaylist$2(SyncUtils syncUtils, Continuation continuation, byte b) {
        super(2, continuation);
        this.$r8$classId = b;
        this.this$0 = syncUtils;
    }
}
