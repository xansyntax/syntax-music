package com.metrolist.music;

import androidx.compose.material3.TopAppBarState;
import androidx.navigation.NavDeepLinkRequest;
import com.metrolist.music.ui.utils.AppBarKt;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class MainActivity$MetrolistApp$6$1$1$10$3$onNavItemClick$1$1$1 extends SuspendLambda implements Function2 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ NavDeepLinkRequest $topAppBarScrollBehavior;
    public boolean label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ MainActivity$MetrolistApp$6$1$1$10$3$onNavItemClick$1$1$1(NavDeepLinkRequest navDeepLinkRequest, Continuation continuation, byte b) {
        super(2, continuation);
        this.$r8$classId = b;
        this.$topAppBarScrollBehavior = navDeepLinkRequest;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        byte b = this.$r8$classId;
        NavDeepLinkRequest navDeepLinkRequest = this.$topAppBarScrollBehavior;
        switch (b) {
            case 0:
                return new MainActivity$MetrolistApp$6$1$1$10$3$onNavItemClick$1$1$1(navDeepLinkRequest, continuation, (byte) 0);
            default:
                return new MainActivity$MetrolistApp$6$1$1$10$3$onNavItemClick$1$1$1(navDeepLinkRequest, continuation, (byte) 1);
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
        }
        return ((MainActivity$MetrolistApp$6$1$1$10$3$onNavItemClick$1$1$1) create(coroutineScope, continuation)).invokeSuspend(unit);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        NavDeepLinkRequest navDeepLinkRequest = this.$topAppBarScrollBehavior;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        switch (b) {
            case 0:
                boolean z = this.label;
                if (!z) {
                    ResultKt.throwOnFailure(obj);
                    TopAppBarState topAppBarState = (TopAppBarState) navDeepLinkRequest.uri;
                    this.label = true;
                    return AppBarKt.resetHeightOffset(topAppBarState, this) == coroutineSingletons ? coroutineSingletons : unit;
                }
                if (z) {
                    ResultKt.throwOnFailure(obj);
                    return unit;
                }
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            default:
                boolean z2 = this.label;
                if (!z2) {
                    ResultKt.throwOnFailure(obj);
                    TopAppBarState topAppBarState2 = (TopAppBarState) navDeepLinkRequest.uri;
                    this.label = true;
                    return AppBarKt.resetHeightOffset(topAppBarState2, this) == coroutineSingletons ? coroutineSingletons : unit;
                }
                if (z2) {
                    ResultKt.throwOnFailure(obj);
                    return unit;
                }
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
        }
    }
}
