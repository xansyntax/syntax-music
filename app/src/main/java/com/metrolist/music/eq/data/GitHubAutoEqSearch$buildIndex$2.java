package com.metrolist.music.eq.data;

import androidx.compose.foundation.text.TextDelegate;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.serialization.json.JsonImpl;
import okhttp3.ConnectionPool;
import timber.log.Timber;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class GitHubAutoEqSearch$buildIndex$2 extends SuspendLambda implements Function2 {
    public final /* synthetic */ TextDelegate this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GitHubAutoEqSearch$buildIndex$2(TextDelegate textDelegate, Continuation continuation) {
        super(2, continuation);
        this.this$0 = textDelegate;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new GitHubAutoEqSearch$buildIndex$2(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((GitHubAutoEqSearch$buildIndex$2) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        TextDelegate textDelegate = this.this$0;
        ResultKt.throwOnFailure(obj);
        boolean z = false;
        try {
            ((File) textDelegate.density).mkdirs();
            String cachedOrFetchTree = textDelegate.getCachedOrFetchTree();
            if (cachedOrFetchTree == null) {
                return Boolean.FALSE;
            }
            GitHubAutoEqSearch$GitHubTreeResponse gitHubAutoEqSearch$GitHubTreeResponse = (GitHubAutoEqSearch$GitHubTreeResponse) ((JsonImpl) textDelegate.paragraphIntrinsics).decodeFromString(GitHubAutoEqSearch$GitHubTreeResponse.INSTANCE.serializer(), cachedOrFetchTree);
            if (gitHubAutoEqSearch$GitHubTreeResponse.truncated) {
                Timber.Forest.tag("GitHubAutoEqSearch");
                ConnectionPool.w(new Object[0]);
            }
            List list = gitHubAutoEqSearch$GitHubTreeResponse.tree;
            ArrayList arrayList = new ArrayList();
            for (Object obj2 : list) {
                GitHubAutoEqSearch$GitHubTreeNode gitHubAutoEqSearch$GitHubTreeNode = (GitHubAutoEqSearch$GitHubTreeNode) obj2;
                String str = gitHubAutoEqSearch$GitHubTreeNode.type;
                String str2 = gitHubAutoEqSearch$GitHubTreeNode.path;
                if (Intrinsics.areEqual(str, "blob") && StringsKt__StringsJVMKt.startsWith(str2, "results/", false) && StringsKt__StringsJVMKt.endsWith(str2, " ParametricEQ.txt", false)) {
                    arrayList.add(obj2);
                }
            }
            ArrayList arrayList2 = new ArrayList();
            int size = arrayList.size();
            int i = 0;
            while (i < size) {
                Object obj3 = arrayList.get(i);
                i++;
                try {
                    Entry entryFromPath = textDelegate.parseEntryFromPath(((GitHubAutoEqSearch$GitHubTreeNode) obj3).path);
                    if (entryFromPath != null) {
                        arrayList2.add(entryFromPath);
                    }
                } catch (Exception unused) {
                }
            }
            ((ArrayList) textDelegate.text).clear();
            ((ArrayList) textDelegate.text).addAll(arrayList2);
            textDelegate.softWrap = true;
            Timber.Forest.tag("GitHubAutoEqSearch");
            ((ArrayList) textDelegate.text).size();
            ConnectionPool.d(new Object[0]);
            z = true;
            return Boolean.valueOf(z);
        } catch (Exception unused2) {
            Timber.Forest.tag("GitHubAutoEqSearch");
            ConnectionPool.e$1(new Object[0]);
        }
    }
}
