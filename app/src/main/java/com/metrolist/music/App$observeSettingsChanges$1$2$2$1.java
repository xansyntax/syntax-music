package com.metrolist.music;

import androidx.datastore.preferences.core.MutablePreferences;
import com.metrolist.music.constants.PreferenceKeysKt;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class App$observeSettingsChanges$1$2$2$1 extends SuspendLambda implements Function2 {
    public final /* synthetic */ String $newVisitorData;
    public final /* synthetic */ byte $r8$classId;
    public /* synthetic */ Object L$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ App$observeSettingsChanges$1$2$2$1(String str, Continuation continuation, byte b) {
        super(2, continuation);
        this.$r8$classId = b;
        this.$newVisitorData = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        byte b = this.$r8$classId;
        String str = this.$newVisitorData;
        switch (b) {
            case 0:
                App$observeSettingsChanges$1$2$2$1 app$observeSettingsChanges$1$2$2$1 = new App$observeSettingsChanges$1$2$2$1(str, continuation, (byte) 0);
                app$observeSettingsChanges$1$2$2$1.L$0 = obj;
                return app$observeSettingsChanges$1$2$2$1;
            case 1:
                App$observeSettingsChanges$1$2$2$1 app$observeSettingsChanges$1$2$2$2 = new App$observeSettingsChanges$1$2$2$1(str, continuation, (byte) 1);
                app$observeSettingsChanges$1$2$2$2.L$0 = obj;
                return app$observeSettingsChanges$1$2$2$2;
            case 2:
                App$observeSettingsChanges$1$2$2$1 app$observeSettingsChanges$1$2$2$3 = new App$observeSettingsChanges$1$2$2$1(str, continuation, (byte) 2);
                app$observeSettingsChanges$1$2$2$3.L$0 = obj;
                return app$observeSettingsChanges$1$2$2$3;
            case 3:
                App$observeSettingsChanges$1$2$2$1 app$observeSettingsChanges$1$2$2$4 = new App$observeSettingsChanges$1$2$2$1(str, continuation, (byte) 3);
                app$observeSettingsChanges$1$2$2$4.L$0 = obj;
                return app$observeSettingsChanges$1$2$2$4;
            case 4:
                App$observeSettingsChanges$1$2$2$1 app$observeSettingsChanges$1$2$2$5 = new App$observeSettingsChanges$1$2$2$1(str, continuation, (byte) 4);
                app$observeSettingsChanges$1$2$2$5.L$0 = obj;
                return app$observeSettingsChanges$1$2$2$5;
            case 5:
                App$observeSettingsChanges$1$2$2$1 app$observeSettingsChanges$1$2$2$6 = new App$observeSettingsChanges$1$2$2$1(str, continuation, (byte) 5);
                app$observeSettingsChanges$1$2$2$6.L$0 = obj;
                return app$observeSettingsChanges$1$2$2$6;
            case 6:
                App$observeSettingsChanges$1$2$2$1 app$observeSettingsChanges$1$2$2$7 = new App$observeSettingsChanges$1$2$2$1(str, continuation, (byte) 6);
                app$observeSettingsChanges$1$2$2$7.L$0 = obj;
                return app$observeSettingsChanges$1$2$2$7;
            case 7:
                App$observeSettingsChanges$1$2$2$1 app$observeSettingsChanges$1$2$2$8 = new App$observeSettingsChanges$1$2$2$1(str, continuation, (byte) 7);
                app$observeSettingsChanges$1$2$2$8.L$0 = obj;
                return app$observeSettingsChanges$1$2$2$8;
            case 8:
                App$observeSettingsChanges$1$2$2$1 app$observeSettingsChanges$1$2$2$9 = new App$observeSettingsChanges$1$2$2$1(str, continuation, (byte) 8);
                app$observeSettingsChanges$1$2$2$9.L$0 = obj;
                return app$observeSettingsChanges$1$2$2$9;
            case 9:
                App$observeSettingsChanges$1$2$2$1 app$observeSettingsChanges$1$2$2$10 = new App$observeSettingsChanges$1$2$2$1(str, continuation, (byte) 9);
                app$observeSettingsChanges$1$2$2$10.L$0 = obj;
                return app$observeSettingsChanges$1$2$2$10;
            case 10:
                App$observeSettingsChanges$1$2$2$1 app$observeSettingsChanges$1$2$2$11 = new App$observeSettingsChanges$1$2$2$1(str, continuation, (byte) 10);
                app$observeSettingsChanges$1$2$2$11.L$0 = obj;
                return app$observeSettingsChanges$1$2$2$11;
            default:
                App$observeSettingsChanges$1$2$2$1 app$observeSettingsChanges$1$2$2$12 = new App$observeSettingsChanges$1$2$2$1(str, continuation, (byte) 11);
                app$observeSettingsChanges$1$2$2$12.L$0 = obj;
                return app$observeSettingsChanges$1$2$2$12;
        }
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        MutablePreferences mutablePreferences = (MutablePreferences) obj;
        Continuation continuation = (Continuation) obj2;
        switch (b) {
            case 0:
                ((App$observeSettingsChanges$1$2$2$1) create(mutablePreferences, continuation)).invokeSuspend(unit);
                break;
            case 1:
                ((App$observeSettingsChanges$1$2$2$1) create(mutablePreferences, continuation)).invokeSuspend(unit);
                break;
            case 2:
                ((App$observeSettingsChanges$1$2$2$1) create(mutablePreferences, continuation)).invokeSuspend(unit);
                break;
            case 3:
                ((App$observeSettingsChanges$1$2$2$1) create(mutablePreferences, continuation)).invokeSuspend(unit);
                break;
            case 4:
                ((App$observeSettingsChanges$1$2$2$1) create(mutablePreferences, continuation)).invokeSuspend(unit);
                break;
            case 5:
                ((App$observeSettingsChanges$1$2$2$1) create(mutablePreferences, continuation)).invokeSuspend(unit);
                break;
            case 6:
                ((App$observeSettingsChanges$1$2$2$1) create(mutablePreferences, continuation)).invokeSuspend(unit);
                break;
            case 7:
                ((App$observeSettingsChanges$1$2$2$1) create(mutablePreferences, continuation)).invokeSuspend(unit);
                break;
            case 8:
                ((App$observeSettingsChanges$1$2$2$1) create(mutablePreferences, continuation)).invokeSuspend(unit);
                break;
            case 9:
                ((App$observeSettingsChanges$1$2$2$1) create(mutablePreferences, continuation)).invokeSuspend(unit);
                break;
            case 10:
                ((App$observeSettingsChanges$1$2$2$1) create(mutablePreferences, continuation)).invokeSuspend(unit);
                break;
            default:
                ((App$observeSettingsChanges$1$2$2$1) create(mutablePreferences, continuation)).invokeSuspend(unit);
                break;
        }
        return unit;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        String str = this.$newVisitorData;
        MutablePreferences mutablePreferences = (MutablePreferences) this.L$0;
        switch (b) {
            case 0:
                ResultKt.throwOnFailure(obj);
                mutablePreferences.set(PreferenceKeysKt.VisitorDataKey, str);
                break;
            case 1:
                ResultKt.throwOnFailure(obj);
                mutablePreferences.set(PreferenceKeysKt.ListenTogetherServerUrlKey, str);
                break;
            case 2:
                ResultKt.throwOnFailure(obj);
                mutablePreferences.set(PreferenceKeysKt.ListenTogetherBlockedUsersKey, str);
                break;
            case 3:
                ResultKt.throwOnFailure(obj);
                mutablePreferences.set(PreferenceKeysKt.DiscordStateTemplateKey, str);
                break;
            case 4:
                ResultKt.throwOnFailure(obj);
                mutablePreferences.set(PreferenceKeysKt.DiscordDetailsTemplateKey, str);
                break;
            case 5:
                ResultKt.throwOnFailure(obj);
                mutablePreferences.set(PreferenceKeysKt.DiscordButton1LabelKey, str);
                break;
            case 6:
                ResultKt.throwOnFailure(obj);
                mutablePreferences.set(PreferenceKeysKt.DiscordButton1UrlKey, str);
                break;
            case 7:
                ResultKt.throwOnFailure(obj);
                mutablePreferences.set(PreferenceKeysKt.DiscordButton2LabelKey, str);
                break;
            case 8:
                ResultKt.throwOnFailure(obj);
                mutablePreferences.set(PreferenceKeysKt.DiscordButton2UrlKey, str);
                break;
            case 9:
                ResultKt.throwOnFailure(obj);
                mutablePreferences.set(PreferenceKeysKt.DiscordUserStatusKey, str);
                break;
            case 10:
                ResultKt.throwOnFailure(obj);
                mutablePreferences.set(PreferenceKeysKt.DiscordActivityTypeKey, str);
                break;
            default:
                ResultKt.throwOnFailure(obj);
                mutablePreferences.set(PreferenceKeysKt.DiscordActivityNameKey, str);
                break;
        }
        return unit;
    }
}
