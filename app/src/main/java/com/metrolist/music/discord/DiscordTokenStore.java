package com.metrolist.music.discord;

import android.content.SharedPreferences;
import java.util.UUID;
import kotlin.ResultKt;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.CompletableDeferredImpl;
import okhttp3.ConnectionPool;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;
import timber.log.Timber;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class DiscordTokenStore {
    public static final DiscordTokenStore INSTANCE = new DiscordTokenStore();
    public static final CompletableDeferredImpl initDeferred = AwaitKt.CompletableDeferred$default();
    public static volatile SharedPreferences prefs;

    /* JADX INFO: renamed from: com.metrolist.music.discord.DiscordTokenStore$retrieveSuspend$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class AnonymousClass1 extends ContinuationImpl {
        public int label;
        public /* synthetic */ Object result;

        public AnonymousClass1(ContinuationImpl continuationImpl) {
            super(continuationImpl);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return DiscordTokenStore.this.retrieveSuspend(this);
        }
    }

    public static String encrypt(String str) {
        if (str == null) {
            return null;
        }
        try {
            return DiscordPresence.INSTANCE.encrypt(str);
        } catch (Exception unused) {
            Timber.Forest.getClass();
            ConnectionPool.e$1(new Object[0]);
            return null;
        }
    }

    public static String getRefreshToken() {
        SharedPreferences sharedPreferences = prefs;
        String strDecrypt = null;
        String string = sharedPreferences != null ? sharedPreferences.getString("refresh_token", null) : null;
        if (string != null) {
            try {
                strDecrypt = DiscordPresence.INSTANCE.decrypt(string);
            } catch (Exception unused) {
                Timber.Forest.getClass();
                ConnectionPool.e$1(new Object[0]);
            }
        }
        Timber.Forest.tag("DiscordSvc");
        ConnectionPool.d(Boolean.valueOf(true ^ (strDecrypt == null || strDecrypt.length() == 0)));
        return strDecrypt;
    }

    public static void storeAccessToken(String str) {
        str.getClass();
        String strEncrypt = encrypt(str);
        if (strEncrypt == null) {
            Timber.Forest.tag("DiscordSvc");
            ConnectionPool.w(new Object[0]);
            return;
        }
        SharedPreferences sharedPreferences = prefs;
        if (sharedPreferences != null) {
            SharedPreferences.Editor editorEdit = sharedPreferences.edit();
            editorEdit.putString("access_token", strEncrypt);
            editorEdit.apply();
        }
        Timber.Forest.tag("DiscordSvc");
        ConnectionPool.d(Integer.valueOf(str.length()));
    }

    public static void storeFull(long j, String str, String str2) {
        String strEncrypt = encrypt(str);
        if (strEncrypt == null) {
            Timber.Forest.tag("DiscordSvc");
            ConnectionPool.w(new Object[0]);
            return;
        }
        SharedPreferences sharedPreferences = prefs;
        if (sharedPreferences != null) {
            SharedPreferences.Editor editorEdit = sharedPreferences.edit();
            editorEdit.putString("access_token", strEncrypt);
            if (str2.length() > 0) {
                String strEncrypt2 = encrypt(str2);
                if (strEncrypt2 != null) {
                    editorEdit.putString("refresh_token", strEncrypt2);
                } else {
                    Timber.Forest.tag("DiscordSvc");
                    ConnectionPool.w(new Object[0]);
                }
            }
            if (j > 0) {
                editorEdit.putLong("expires_at", (System.currentTimeMillis() / 1000) + j);
            }
            editorEdit.apply();
        }
        Timber.Forest.tag("DiscordSvc");
        ConnectionPool.d(Integer.valueOf(str.length()), Boolean.valueOf(str2.length() > 0), Long.valueOf(j));
    }

    public final String getOrCreateId(String str, String str2) {
        synchronized (this) {
            SharedPreferences sharedPreferences = prefs;
            if (sharedPreferences == null) {
                return null;
            }
            String string = sharedPreferences.getString(str, null);
            if (string == null) {
                string = UUID.randomUUID().toString();
                string.getClass();
                SharedPreferences.Editor editorEdit = sharedPreferences.edit();
                editorEdit.putString(str, string);
                editorEdit.apply();
                Timber.Forest.tag("DiscordSvc");
                ConnectionPool.d(str2);
            }
            return string;
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object retrieveSuspend(ContinuationImpl continuationImpl) {
        AnonymousClass1 anonymousClass1;
        if (continuationImpl instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuationImpl;
            int i = anonymousClass1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label = i - Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(continuationImpl);
            }
        } else {
            anonymousClass1 = new AnonymousClass1(continuationImpl);
        }
        Object obj = anonymousClass1.result;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        int i2 = anonymousClass1.label;
        String strDecrypt = null;
        try {
            if (i2 == 0) {
                ResultKt.throwOnFailure(obj);
                CompletableDeferredImpl completableDeferredImpl = initDeferred;
                anonymousClass1.label = 1;
                if (completableDeferredImpl.awaitInternal(anonymousClass1) == coroutineSingletons) {
                    return coroutineSingletons;
                }
            } else {
                if (i2 != 1) {
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                ResultKt.throwOnFailure(obj);
            }
            SharedPreferences sharedPreferences = prefs;
            String string = sharedPreferences != null ? sharedPreferences.getString("access_token", null) : null;
            if (string != null) {
                try {
                    strDecrypt = DiscordPresence.INSTANCE.decrypt(string);
                } catch (Exception unused) {
                    Timber.Forest.getClass();
                    ConnectionPool.e$1(new Object[0]);
                }
            }
            Timber.Forest.tag("DiscordSvc");
            ConnectionPool.d(Boolean.valueOf(!(strDecrypt == null || strDecrypt.length() == 0)));
        } catch (Exception unused2) {
        }
        return strDecrypt;
    }
}
