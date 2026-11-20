package com.metrolist.music.ui.screens.settings.integrations;

import androidx.compose.runtime.MutableState;
import com.metrolist.lastfm.LastFM;
import com.metrolist.lastfm.models.Authentication;
import com.metrolist.music.ui.screens.artist.ArtistScreenKt$ArtistScreen$1$1;
import com.metrolist.music.utils.DataStoreKt$rememberPreference$1$1;
import com.metrolist.music.utils.SyncUtils$createPlaylist$1;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.internal.MainDispatcherLoader;
import kotlinx.coroutines.scheduling.DefaultScheduler;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class LastFMSettingsKt$LastFMSettings$2$1$1$1 extends SuspendLambda implements Function2 {
    public final /* synthetic */ CoroutineScope $coroutineScope;
    public final /* synthetic */ MutableState $isLoggingIn$delegate;
    public final /* synthetic */ DataStoreKt$rememberPreference$1$1 $lastfmSession$delegate;
    public final /* synthetic */ MutableState $lastfmUsername$delegate;
    public final /* synthetic */ MutableState $loginError$delegate;
    public final /* synthetic */ MutableState $showLoginDialog$delegate;
    public final /* synthetic */ MutableState $tempPassword$delegate;
    public final /* synthetic */ MutableState $tempUsername$delegate;
    public boolean label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LastFMSettingsKt$LastFMSettings$2$1$1$1(CoroutineScope coroutineScope, MutableState mutableState, MutableState mutableState2, MutableState mutableState3, DataStoreKt$rememberPreference$1$1 dataStoreKt$rememberPreference$1$1, MutableState mutableState4, MutableState mutableState5, MutableState mutableState6, Continuation continuation) {
        super(2, continuation);
        this.$coroutineScope = coroutineScope;
        this.$tempUsername$delegate = mutableState;
        this.$tempPassword$delegate = mutableState2;
        this.$lastfmUsername$delegate = mutableState3;
        this.$lastfmSession$delegate = dataStoreKt$rememberPreference$1$1;
        this.$isLoggingIn$delegate = mutableState4;
        this.$showLoginDialog$delegate = mutableState5;
        this.$loginError$delegate = mutableState6;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new LastFMSettingsKt$LastFMSettings$2$1$1$1(this.$coroutineScope, this.$tempUsername$delegate, this.$tempPassword$delegate, this.$lastfmUsername$delegate, this.$lastfmSession$delegate, this.$isLoggingIn$delegate, this.$showLoginDialog$delegate, this.$loginError$delegate, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((LastFMSettingsKt$LastFMSettings$2$1$1$1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object objM1050getMobileSession0E7RQCE;
        Exception exc;
        MutableState mutableState;
        boolean z = this.label;
        CoroutineScope coroutineScope = this.$coroutineScope;
        MutableState mutableState2 = this.$loginError$delegate;
        MutableState mutableState3 = this.$isLoggingIn$delegate;
        if (!z) {
            ResultKt.throwOnFailure(obj);
            try {
                LastFM lastFM = LastFM.INSTANCE;
                String str = (String) this.$tempUsername$delegate.getValue();
                String str2 = (String) this.$tempPassword$delegate.getValue();
                this.label = true;
                objM1050getMobileSession0E7RQCE = lastFM.m1050getMobileSession0E7RQCE(str, str2, this);
                CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
                if (objM1050getMobileSession0E7RQCE == coroutineSingletons) {
                    return coroutineSingletons;
                }
            } catch (Exception e) {
                e = e;
                mutableState = mutableState3;
                exc = e;
                DefaultScheduler defaultScheduler = Dispatchers.Default;
                AwaitKt.launch$default(coroutineScope, MainDispatcherLoader.dispatcher, null, new ArtistScreenKt$ArtistScreen$1$1(mutableState, mutableState2, null, (byte) 2), 2);
                exc.printStackTrace();
                return Unit.INSTANCE;
            }
        } else {
            if (!z) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            try {
                ResultKt.throwOnFailure(obj);
                objM1050getMobileSession0E7RQCE = ((Result) obj).value;
            } catch (Exception e2) {
                exc = e2;
                mutableState = mutableState3;
                DefaultScheduler defaultScheduler2 = Dispatchers.Default;
                AwaitKt.launch$default(coroutineScope, MainDispatcherLoader.dispatcher, null, new ArtistScreenKt$ArtistScreen$1$1(mutableState, mutableState2, null, (byte) 2), 2);
                exc.printStackTrace();
            }
        }
        MutableState mutableState4 = this.$lastfmUsername$delegate;
        DataStoreKt$rememberPreference$1$1 dataStoreKt$rememberPreference$1$1 = this.$lastfmSession$delegate;
        MutableState mutableState5 = this.$showLoginDialog$delegate;
        if (!(objM1050getMobileSession0E7RQCE instanceof Result.Failure)) {
            Authentication.Session session = ((Authentication) objM1050getMobileSession0E7RQCE).session;
            mutableState4.setValue(session.name);
            dataStoreKt$rememberPreference$1$1.setValue(session.key);
            LastFM lastFM2 = LastFM.INSTANCE;
            LastFM.sessionKey = session.key;
            DefaultScheduler defaultScheduler3 = Dispatchers.Default;
            AwaitKt.launch$default(coroutineScope, MainDispatcherLoader.dispatcher, null, new SyncUtils$createPlaylist$1.AnonymousClass1(mutableState3, mutableState5, mutableState2, (Continuation) null, (byte) 17), 2);
        }
        Throwable thM1866exceptionOrNullimpl = Result.m1866exceptionOrNullimpl(objM1050getMobileSession0E7RQCE);
        if (thM1866exceptionOrNullimpl != null) {
            DefaultScheduler defaultScheduler4 = Dispatchers.Default;
            mutableState = mutableState3;
            try {
                AwaitKt.launch$default(coroutineScope, MainDispatcherLoader.dispatcher, null, new SyncUtils$createPlaylist$1.AnonymousClass1(thM1866exceptionOrNullimpl, mutableState, mutableState2, (Continuation) null, (byte) 18), 2);
                thM1866exceptionOrNullimpl.printStackTrace();
            } catch (Exception e3) {
                e = e3;
                exc = e;
                DefaultScheduler defaultScheduler5 = Dispatchers.Default;
                AwaitKt.launch$default(coroutineScope, MainDispatcherLoader.dispatcher, null, new ArtistScreenKt$ArtistScreen$1$1(mutableState, mutableState2, null, (byte) 2), 2);
                exc.printStackTrace();
            }
        }
        return Unit.INSTANCE;
    }
}
