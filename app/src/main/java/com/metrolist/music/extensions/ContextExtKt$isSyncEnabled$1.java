package com.metrolist.music.extensions;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkCapabilities;
import android.widget.Toast;
import com.atilika.kuromoji.ipadic.compile.DictionaryEntry;
import com.metrolist.music.constants.PreferenceKeysKt;
import com.metrolist.music.discord.DiscordRpcManager;
import com.metrolist.music.utils.UtilsKt;
import com.yalantis.ucrop.R;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.text.StringsKt__IndentKt;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class ContextExtKt$isSyncEnabled$1 extends SuspendLambda implements Function2 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ Context $this_isSyncEnabled;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ContextExtKt$isSyncEnabled$1(Context context, Continuation continuation, byte b) {
        super(2, continuation);
        this.$r8$classId = b;
        this.$this_isSyncEnabled = context;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        switch (this.$r8$classId) {
            case 0:
                return new ContextExtKt$isSyncEnabled$1(this.$this_isSyncEnabled, continuation, (byte) 0);
            case 1:
                return new ContextExtKt$isSyncEnabled$1(this.$this_isSyncEnabled, continuation, (byte) 1);
            case 2:
                return new ContextExtKt$isSyncEnabled$1(this.$this_isSyncEnabled, continuation, (byte) 2);
            case 3:
                return new ContextExtKt$isSyncEnabled$1(this.$this_isSyncEnabled, continuation, (byte) 3);
            case 4:
                return new ContextExtKt$isSyncEnabled$1(this.$this_isSyncEnabled, continuation, (byte) 4);
            case 5:
                return new ContextExtKt$isSyncEnabled$1(this.$this_isSyncEnabled, continuation, (byte) 5);
            case 6:
                return new ContextExtKt$isSyncEnabled$1(this.$this_isSyncEnabled, continuation, (byte) 6);
            case 7:
                return new ContextExtKt$isSyncEnabled$1(this.$this_isSyncEnabled, continuation, (byte) 7);
            case 8:
                return new ContextExtKt$isSyncEnabled$1(this.$this_isSyncEnabled, continuation, (byte) 8);
            case 9:
                return new ContextExtKt$isSyncEnabled$1(this.$this_isSyncEnabled, continuation, (byte) 9);
            case 10:
                return new ContextExtKt$isSyncEnabled$1(this.$this_isSyncEnabled, continuation, (byte) 10);
            case 11:
                return new ContextExtKt$isSyncEnabled$1(this.$this_isSyncEnabled, continuation, (byte) 11);
            case DictionaryEntry.PRONUNCIATION /* 12 */:
                return new ContextExtKt$isSyncEnabled$1(this.$this_isSyncEnabled, continuation, (byte) 12);
            default:
                return new ContextExtKt$isSyncEnabled$1(this.$this_isSyncEnabled, continuation, (byte) 13);
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
                return ((ContextExtKt$isSyncEnabled$1) create(coroutineScope, continuation)).invokeSuspend(unit);
            case 1:
                return ((ContextExtKt$isSyncEnabled$1) create(coroutineScope, continuation)).invokeSuspend(unit);
            case 2:
                return ((ContextExtKt$isSyncEnabled$1) create(coroutineScope, continuation)).invokeSuspend(unit);
            case 3:
                ((ContextExtKt$isSyncEnabled$1) create(coroutineScope, continuation)).invokeSuspend(unit);
                return unit;
            case 4:
                ((ContextExtKt$isSyncEnabled$1) create(coroutineScope, continuation)).invokeSuspend(unit);
                return unit;
            case 5:
                ((ContextExtKt$isSyncEnabled$1) create(coroutineScope, continuation)).invokeSuspend(unit);
                return unit;
            case 6:
                ((ContextExtKt$isSyncEnabled$1) create(coroutineScope, continuation)).invokeSuspend(unit);
                return unit;
            case 7:
                ((ContextExtKt$isSyncEnabled$1) create(coroutineScope, continuation)).invokeSuspend(unit);
                return unit;
            case 8:
                ((ContextExtKt$isSyncEnabled$1) create(coroutineScope, continuation)).invokeSuspend(unit);
                return unit;
            case 9:
                ((ContextExtKt$isSyncEnabled$1) create(coroutineScope, continuation)).invokeSuspend(unit);
                return unit;
            case 10:
                ((ContextExtKt$isSyncEnabled$1) create(coroutineScope, continuation)).invokeSuspend(unit);
                return unit;
            case 11:
                ((ContextExtKt$isSyncEnabled$1) create(coroutineScope, continuation)).invokeSuspend(unit);
                return unit;
            case DictionaryEntry.PRONUNCIATION /* 12 */:
                ((ContextExtKt$isSyncEnabled$1) create(coroutineScope, continuation)).invokeSuspend(unit);
                return unit;
            default:
                ((ContextExtKt$isSyncEnabled$1) create(coroutineScope, continuation)).invokeSuspend(unit);
                return unit;
        }
    }

    /* JADX WARN: Code duplicated, block: B:44:0x0102  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        boolean z;
        byte b = this.$r8$classId;
        EmptyCoroutineContext emptyCoroutineContext = EmptyCoroutineContext.INSTANCE;
        Continuation continuation = null;
        boolean z2 = true;
        Unit unit = Unit.INSTANCE;
        byte b2 = 0;
        Context context = this.$this_isSyncEnabled;
        switch (b) {
            case 0:
                ResultKt.throwOnFailure(obj);
                return Boolean.valueOf(((Boolean) UtilsKt.get(UtilsKt.getDataStore(context), PreferenceKeysKt.YtmSyncKey, Boolean.TRUE)).booleanValue() && ((Boolean) AwaitKt.runBlockingK(emptyCoroutineContext, new ContextExtKt$isSyncEnabled$1(context, continuation, z2 ? (byte) 1 : (byte) 0))).booleanValue());
            case 1:
                ResultKt.throwOnFailure(obj);
                String str = (String) UtilsKt.get(UtilsKt.getDataStore(context), PreferenceKeysKt.InnerTubeCookieKey);
                if (str == null) {
                    str = "";
                }
                if (StringsKt__IndentKt.parseCookieString(str).containsKey("SAPISID")) {
                    Object systemService = context.getSystemService("connectivity");
                    systemService.getClass();
                    ConnectivityManager connectivityManager = (ConnectivityManager) systemService;
                    NetworkCapabilities networkCapabilities = connectivityManager.getNetworkCapabilities(connectivityManager.getActiveNetwork());
                    z = networkCapabilities != null ? networkCapabilities.hasCapability(12) : false;
                }
                return Boolean.valueOf(z);
            case 2:
                ResultKt.throwOnFailure(obj);
                context.getClass();
                Boolean bool = (Boolean) AwaitKt.runBlockingK(emptyCoroutineContext, new ContextExtKt$isSyncEnabled$1(context, continuation, b2));
                bool.booleanValue();
                return bool;
            case 3:
                ResultKt.throwOnFailure(obj);
                Toast.makeText(context, R.string.error_episode_remove, 0).show();
                return unit;
            case 4:
                ResultKt.throwOnFailure(obj);
                Toast.makeText(context, R.string.error_episode_save, 0).show();
                return unit;
            case 5:
                ResultKt.throwOnFailure(obj);
                Toast.makeText(context, R.string.error_episode_remove, 0).show();
                return unit;
            case 6:
                ResultKt.throwOnFailure(obj);
                Toast.makeText(context, R.string.error_episode_save, 0).show();
                return unit;
            case 7:
                ResultKt.throwOnFailure(obj);
                Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(context.getPackageName());
                if (launchIntentForPackage != null) {
                    launchIntentForPackage.addFlags(268468224);
                    context.startActivity(launchIntentForPackage);
                }
                Runtime.getRuntime().exit(0);
                return unit;
            case 8:
                ResultKt.throwOnFailure(obj);
                DiscordRpcManager discordRpcManager = DiscordRpcManager.INSTANCE;
                if (!discordRpcManager.isInitialized()) {
                    discordRpcManager.init(context);
                }
                return unit;
            case 9:
                ResultKt.throwOnFailure(obj);
                Toast.makeText(context, R.string.restore_failed, 0).show();
                return unit;
            case 10:
                ResultKt.throwOnFailure(obj);
                Toast.makeText(context, R.string.restore_database_incompatible, 1).show();
                return unit;
            case 11:
                ResultKt.throwOnFailure(obj);
                Toast.makeText(context, R.string.restore_database_incompatible, 1).show();
                return unit;
            case DictionaryEntry.PRONUNCIATION /* 12 */:
                ResultKt.throwOnFailure(obj);
                Toast.makeText(context, R.string.restore_failed, 0).show();
                return unit;
            default:
                ResultKt.throwOnFailure(obj);
                Toast.makeText(context, R.string.restore_failed, 0).show();
                return unit;
        }
    }
}
