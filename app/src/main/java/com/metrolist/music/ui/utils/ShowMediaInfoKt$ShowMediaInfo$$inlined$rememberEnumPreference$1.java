package com.metrolist.music.ui.utils;

import androidx.datastore.preferences.core.MutablePreferences;
import androidx.datastore.preferences.core.Preferences$Key;
import com.metrolist.music.constants.AddToPlaylistPosition;
import com.metrolist.music.constants.AudioQuality;
import com.metrolist.music.constants.LoudnessLevel;
import com.metrolist.music.constants.PlayerButtonsStyle;
import com.metrolist.music.constants.QuickPicks;
import com.metrolist.music.ui.screens.settings.AppearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$5$1;
import com.metrolist.music.ui.screens.settings.AppearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$5$2$1;
import com.metrolist.music.ui.screens.settings.AppearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$7$1;
import com.metrolist.music.ui.screens.settings.AppearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$7$2$1;
import com.metrolist.music.ui.screens.settings.AppearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$9$1;
import com.metrolist.music.ui.screens.settings.AppearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$9$2$1;
import com.metrolist.music.ui.screens.settings.ContentSettingsKt$ContentSettings$$inlined$rememberEnumPreference$1$1;
import com.metrolist.music.ui.screens.settings.ContentSettingsKt$ContentSettings$$inlined$rememberEnumPreference$1$2$1;
import com.metrolist.music.ui.screens.settings.ContentSettingsKt$ContentSettings$$inlined$rememberEnumPreference$3$1;
import com.metrolist.music.ui.screens.settings.ContentSettingsKt$ContentSettings$$inlined$rememberEnumPreference$3$2$1;
import com.metrolist.music.ui.screens.settings.ContentSettingsKt$ContentSettings$$inlined$rememberEnumPreference$5$1;
import com.metrolist.music.ui.screens.settings.ContentSettingsKt$ContentSettings$$inlined$rememberEnumPreference$5$2$1;
import com.metrolist.music.ui.screens.settings.DarkMode;
import com.metrolist.music.ui.screens.settings.LyricsPosition;
import com.metrolist.music.ui.screens.settings.NavigationTab;
import com.metrolist.music.ui.screens.settings.PlayerSettingsKt$PlayerSettings$$inlined$rememberEnumPreference$1$1;
import com.metrolist.music.ui.screens.settings.PlayerSettingsKt$PlayerSettings$$inlined$rememberEnumPreference$1$2$1;
import com.metrolist.music.ui.screens.settings.PlayerSettingsKt$PlayerSettings$$inlined$rememberEnumPreference$3$1;
import com.metrolist.music.ui.screens.settings.PlayerSettingsKt$PlayerSettings$$inlined$rememberEnumPreference$3$2$1;
import com.metrolist.music.ui.screens.settings.ThemeScreenKt$ThemeScreen$$inlined$rememberEnumPreference$1$1;
import com.metrolist.music.ui.screens.settings.ThemeScreenKt$ThemeScreen$$inlined$rememberEnumPreference$1$2$1;
import java.net.Proxy;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class ShowMediaInfoKt$ShowMediaInfo$$inlined$rememberEnumPreference$1 implements Flow {
    public final /* synthetic */ Preferences$Key $key$inlined;
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ Flow $this_unsafeTransform$inlined;

    /* JADX INFO: renamed from: com.metrolist.music.ui.utils.ShowMediaInfoKt$ShowMediaInfo$$inlined$rememberEnumPreference$1$1, reason: invalid class name */
    public final class AnonymousClass1 extends ContinuationImpl {
        public int label;
        public /* synthetic */ Object result;

        public AnonymousClass1(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ShowMediaInfoKt$ShowMediaInfo$$inlined$rememberEnumPreference$1.this.collect(null, this);
        }
    }

    /* JADX INFO: renamed from: com.metrolist.music.ui.utils.ShowMediaInfoKt$ShowMediaInfo$$inlined$rememberEnumPreference$1$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class AnonymousClass2 implements FlowCollector {
        public final /* synthetic */ Preferences$Key $key$inlined;
        public final /* synthetic */ byte $r8$classId;
        public final /* synthetic */ FlowCollector $this_unsafeFlow;

        /* JADX INFO: renamed from: com.metrolist.music.ui.utils.ShowMediaInfoKt$ShowMediaInfo$$inlined$rememberEnumPreference$1$2$1, reason: invalid class name */
        public final class AnonymousClass1 extends ContinuationImpl {
            public int label;
            public /* synthetic */ Object result;

            public AnonymousClass1(Continuation continuation) {
                super(continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                this.result = obj;
                this.label |= Integer.MIN_VALUE;
                return AnonymousClass2.this.emit(null, this);
            }
        }

        public AnonymousClass2(FlowCollector flowCollector, Preferences$Key preferences$Key, byte b) {
            this.$r8$classId = b;
            switch (b) {
                case 1:
                    this.$this_unsafeFlow = flowCollector;
                    this.$key$inlined = preferences$Key;
                    break;
                case 2:
                    this.$this_unsafeFlow = flowCollector;
                    this.$key$inlined = preferences$Key;
                    break;
                case 3:
                    this.$this_unsafeFlow = flowCollector;
                    this.$key$inlined = preferences$Key;
                    break;
                case 4:
                    Proxy.Type type = Proxy.Type.HTTP;
                    this.$this_unsafeFlow = flowCollector;
                    this.$key$inlined = preferences$Key;
                    break;
                case 5:
                    this.$this_unsafeFlow = flowCollector;
                    this.$key$inlined = preferences$Key;
                    break;
                case 6:
                    this.$this_unsafeFlow = flowCollector;
                    this.$key$inlined = preferences$Key;
                    break;
                case 7:
                    this.$this_unsafeFlow = flowCollector;
                    this.$key$inlined = preferences$Key;
                    break;
                case 8:
                    this.$this_unsafeFlow = flowCollector;
                    this.$key$inlined = preferences$Key;
                    break;
                case 9:
                    this.$this_unsafeFlow = flowCollector;
                    this.$key$inlined = preferences$Key;
                    break;
                default:
                    this.$this_unsafeFlow = flowCollector;
                    this.$key$inlined = preferences$Key;
                    break;
            }
        }

        /* JADX WARN: Code duplicated, block: B:104:0x017d  */
        /* JADX WARN: Code duplicated, block: B:123:0x01c2  */
        /* JADX WARN: Code duplicated, block: B:142:0x0207  */
        /* JADX WARN: Code duplicated, block: B:161:0x024c  */
        /* JADX WARN: Code duplicated, block: B:180:0x0291  */
        /* JADX WARN: Code duplicated, block: B:28:0x006b  */
        /* JADX WARN: Code duplicated, block: B:47:0x00ae  */
        /* JADX WARN: Code duplicated, block: B:66:0x00f3  */
        /* JADX WARN: Code duplicated, block: B:85:0x0138  */
        /* JADX WARN: Code duplicated, block: B:9:0x0026  */
        @Override // kotlinx.coroutines.flow.FlowCollector
        public final Object emit(Object obj, Continuation continuation) {
            AnonymousClass1 anonymousClass1;
            AppearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$5$2$1 appearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$5$2$1;
            AppearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$7$2$1 appearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$7$2$1;
            AppearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$9$2$1 appearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$9$2$1;
            ContentSettingsKt$ContentSettings$$inlined$rememberEnumPreference$1$2$1 contentSettingsKt$ContentSettings$$inlined$rememberEnumPreference$1$2$1;
            ContentSettingsKt$ContentSettings$$inlined$rememberEnumPreference$3$2$1 contentSettingsKt$ContentSettings$$inlined$rememberEnumPreference$3$2$1;
            ContentSettingsKt$ContentSettings$$inlined$rememberEnumPreference$5$2$1 contentSettingsKt$ContentSettings$$inlined$rememberEnumPreference$5$2$1;
            PlayerSettingsKt$PlayerSettings$$inlined$rememberEnumPreference$1$2$1 playerSettingsKt$PlayerSettings$$inlined$rememberEnumPreference$1$2$1;
            PlayerSettingsKt$PlayerSettings$$inlined$rememberEnumPreference$3$2$1 playerSettingsKt$PlayerSettings$$inlined$rememberEnumPreference$3$2$1;
            ThemeScreenKt$ThemeScreen$$inlined$rememberEnumPreference$1$2$1 themeScreenKt$ThemeScreen$$inlined$rememberEnumPreference$1$2$1;
            byte b = this.$r8$classId;
            LoudnessLevel loudnessLevelValueOf = LoudnessLevel.BALANCED;
            Unit unit = Unit.INSTANCE;
            Preferences$Key preferences$Key = this.$key$inlined;
            FlowCollector flowCollector = this.$this_unsafeFlow;
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
            switch (b) {
                case 0:
                    if (continuation instanceof AnonymousClass1) {
                        anonymousClass1 = (AnonymousClass1) continuation;
                        int i = anonymousClass1.label;
                        if ((i & Integer.MIN_VALUE) != 0) {
                            anonymousClass1.label = i - Integer.MIN_VALUE;
                        } else {
                            anonymousClass1 = new AnonymousClass1(continuation);
                        }
                    } else {
                        anonymousClass1 = new AnonymousClass1(continuation);
                    }
                    Object obj2 = anonymousClass1.result;
                    int i2 = anonymousClass1.label;
                    if (i2 != 0) {
                        if (i2 == 1) {
                            ResultKt.throwOnFailure(obj2);
                            return unit;
                        }
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(obj2);
                    String str = (String) ((MutablePreferences) obj).get(preferences$Key);
                    if (str != null) {
                        try {
                            loudnessLevelValueOf = LoudnessLevel.valueOf(str);
                            break;
                        } catch (IllegalArgumentException unused) {
                        }
                    }
                    anonymousClass1.label = 1;
                    return flowCollector.emit(loudnessLevelValueOf, anonymousClass1) == coroutineSingletons ? coroutineSingletons : unit;
                case 1:
                    if (continuation instanceof AppearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$5$2$1) {
                        appearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$5$2$1 = (AppearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$5$2$1) continuation;
                        int i3 = appearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$5$2$1.label;
                        if ((i3 & Integer.MIN_VALUE) != 0) {
                            appearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$5$2$1.label = i3 - Integer.MIN_VALUE;
                        } else {
                            appearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$5$2$1 = new AppearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$5$2$1(this, continuation);
                        }
                    } else {
                        appearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$5$2$1 = new AppearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$5$2$1(this, continuation);
                    }
                    Object obj3 = appearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$5$2$1.result;
                    int i4 = appearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$5$2$1.label;
                    if (i4 != 0) {
                        if (i4 == 1) {
                            ResultKt.throwOnFailure(obj3);
                            return unit;
                        }
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(obj3);
                    String str2 = (String) ((MutablePreferences) obj).get(preferences$Key);
                    NavigationTab navigationTabValueOf = NavigationTab.HOME;
                    if (str2 != null) {
                        try {
                            navigationTabValueOf = NavigationTab.valueOf(str2);
                            break;
                        } catch (IllegalArgumentException unused2) {
                        }
                    }
                    appearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$5$2$1.label = 1;
                    return flowCollector.emit(navigationTabValueOf, appearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$5$2$1) == coroutineSingletons ? coroutineSingletons : unit;
                case 2:
                    if (continuation instanceof AppearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$7$2$1) {
                        appearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$7$2$1 = (AppearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$7$2$1) continuation;
                        int i5 = appearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$7$2$1.label;
                        if ((i5 & Integer.MIN_VALUE) != 0) {
                            appearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$7$2$1.label = i5 - Integer.MIN_VALUE;
                        } else {
                            appearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$7$2$1 = new AppearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$7$2$1(this, continuation);
                        }
                    } else {
                        appearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$7$2$1 = new AppearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$7$2$1(this, continuation);
                    }
                    Object obj4 = appearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$7$2$1.result;
                    int i6 = appearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$7$2$1.label;
                    if (i6 != 0) {
                        if (i6 == 1) {
                            ResultKt.throwOnFailure(obj4);
                            return unit;
                        }
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(obj4);
                    String str3 = (String) ((MutablePreferences) obj).get(preferences$Key);
                    PlayerButtonsStyle playerButtonsStyleValueOf = PlayerButtonsStyle.DEFAULT;
                    if (str3 != null) {
                        try {
                            playerButtonsStyleValueOf = PlayerButtonsStyle.valueOf(str3);
                            break;
                        } catch (IllegalArgumentException unused3) {
                        }
                    }
                    appearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$7$2$1.label = 1;
                    return flowCollector.emit(playerButtonsStyleValueOf, appearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$7$2$1) == coroutineSingletons ? coroutineSingletons : unit;
                case 3:
                    if (continuation instanceof AppearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$9$2$1) {
                        appearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$9$2$1 = (AppearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$9$2$1) continuation;
                        int i7 = appearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$9$2$1.label;
                        if ((i7 & Integer.MIN_VALUE) != 0) {
                            appearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$9$2$1.label = i7 - Integer.MIN_VALUE;
                        } else {
                            appearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$9$2$1 = new AppearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$9$2$1(this, continuation);
                        }
                    } else {
                        appearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$9$2$1 = new AppearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$9$2$1(this, continuation);
                    }
                    Object obj5 = appearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$9$2$1.result;
                    int i8 = appearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$9$2$1.label;
                    if (i8 != 0) {
                        if (i8 == 1) {
                            ResultKt.throwOnFailure(obj5);
                            return unit;
                        }
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(obj5);
                    String str4 = (String) ((MutablePreferences) obj).get(preferences$Key);
                    LyricsPosition lyricsPositionValueOf = LyricsPosition.CENTER;
                    if (str4 != null) {
                        try {
                            lyricsPositionValueOf = LyricsPosition.valueOf(str4);
                            break;
                        } catch (IllegalArgumentException unused4) {
                        }
                    }
                    appearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$9$2$1.label = 1;
                    return flowCollector.emit(lyricsPositionValueOf, appearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$9$2$1) == coroutineSingletons ? coroutineSingletons : unit;
                case 4:
                    if (continuation instanceof ContentSettingsKt$ContentSettings$$inlined$rememberEnumPreference$1$2$1) {
                        contentSettingsKt$ContentSettings$$inlined$rememberEnumPreference$1$2$1 = (ContentSettingsKt$ContentSettings$$inlined$rememberEnumPreference$1$2$1) continuation;
                        int i9 = contentSettingsKt$ContentSettings$$inlined$rememberEnumPreference$1$2$1.label;
                        if ((i9 & Integer.MIN_VALUE) != 0) {
                            contentSettingsKt$ContentSettings$$inlined$rememberEnumPreference$1$2$1.label = i9 - Integer.MIN_VALUE;
                        } else {
                            contentSettingsKt$ContentSettings$$inlined$rememberEnumPreference$1$2$1 = new ContentSettingsKt$ContentSettings$$inlined$rememberEnumPreference$1$2$1(this, continuation);
                        }
                    } else {
                        contentSettingsKt$ContentSettings$$inlined$rememberEnumPreference$1$2$1 = new ContentSettingsKt$ContentSettings$$inlined$rememberEnumPreference$1$2$1(this, continuation);
                    }
                    Object obj6 = contentSettingsKt$ContentSettings$$inlined$rememberEnumPreference$1$2$1.result;
                    int i10 = contentSettingsKt$ContentSettings$$inlined$rememberEnumPreference$1$2$1.label;
                    if (i10 != 0) {
                        if (i10 == 1) {
                            ResultKt.throwOnFailure(obj6);
                            return unit;
                        }
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(obj6);
                    String str5 = (String) ((MutablePreferences) obj).get(preferences$Key);
                    Proxy.Type typeValueOf = Proxy.Type.HTTP;
                    if (str5 != null) {
                        try {
                            typeValueOf = Proxy.Type.valueOf(str5);
                            break;
                        } catch (IllegalArgumentException unused5) {
                        }
                    }
                    contentSettingsKt$ContentSettings$$inlined$rememberEnumPreference$1$2$1.label = 1;
                    return flowCollector.emit(typeValueOf, contentSettingsKt$ContentSettings$$inlined$rememberEnumPreference$1$2$1) == coroutineSingletons ? coroutineSingletons : unit;
                case 5:
                    if (continuation instanceof ContentSettingsKt$ContentSettings$$inlined$rememberEnumPreference$3$2$1) {
                        contentSettingsKt$ContentSettings$$inlined$rememberEnumPreference$3$2$1 = (ContentSettingsKt$ContentSettings$$inlined$rememberEnumPreference$3$2$1) continuation;
                        int i11 = contentSettingsKt$ContentSettings$$inlined$rememberEnumPreference$3$2$1.label;
                        if ((i11 & Integer.MIN_VALUE) != 0) {
                            contentSettingsKt$ContentSettings$$inlined$rememberEnumPreference$3$2$1.label = i11 - Integer.MIN_VALUE;
                        } else {
                            contentSettingsKt$ContentSettings$$inlined$rememberEnumPreference$3$2$1 = new ContentSettingsKt$ContentSettings$$inlined$rememberEnumPreference$3$2$1(this, continuation);
                        }
                    } else {
                        contentSettingsKt$ContentSettings$$inlined$rememberEnumPreference$3$2$1 = new ContentSettingsKt$ContentSettings$$inlined$rememberEnumPreference$3$2$1(this, continuation);
                    }
                    Object obj7 = contentSettingsKt$ContentSettings$$inlined$rememberEnumPreference$3$2$1.result;
                    int i12 = contentSettingsKt$ContentSettings$$inlined$rememberEnumPreference$3$2$1.label;
                    if (i12 != 0) {
                        if (i12 == 1) {
                            ResultKt.throwOnFailure(obj7);
                            return unit;
                        }
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(obj7);
                    String str6 = (String) ((MutablePreferences) obj).get(preferences$Key);
                    QuickPicks quickPicksValueOf = QuickPicks.QUICK_PICKS;
                    if (str6 != null) {
                        try {
                            quickPicksValueOf = QuickPicks.valueOf(str6);
                            break;
                        } catch (IllegalArgumentException unused6) {
                        }
                    }
                    contentSettingsKt$ContentSettings$$inlined$rememberEnumPreference$3$2$1.label = 1;
                    return flowCollector.emit(quickPicksValueOf, contentSettingsKt$ContentSettings$$inlined$rememberEnumPreference$3$2$1) == coroutineSingletons ? coroutineSingletons : unit;
                case 6:
                    if (continuation instanceof ContentSettingsKt$ContentSettings$$inlined$rememberEnumPreference$5$2$1) {
                        contentSettingsKt$ContentSettings$$inlined$rememberEnumPreference$5$2$1 = (ContentSettingsKt$ContentSettings$$inlined$rememberEnumPreference$5$2$1) continuation;
                        int i13 = contentSettingsKt$ContentSettings$$inlined$rememberEnumPreference$5$2$1.label;
                        if ((i13 & Integer.MIN_VALUE) != 0) {
                            contentSettingsKt$ContentSettings$$inlined$rememberEnumPreference$5$2$1.label = i13 - Integer.MIN_VALUE;
                        } else {
                            contentSettingsKt$ContentSettings$$inlined$rememberEnumPreference$5$2$1 = new ContentSettingsKt$ContentSettings$$inlined$rememberEnumPreference$5$2$1(this, continuation);
                        }
                    } else {
                        contentSettingsKt$ContentSettings$$inlined$rememberEnumPreference$5$2$1 = new ContentSettingsKt$ContentSettings$$inlined$rememberEnumPreference$5$2$1(this, continuation);
                    }
                    Object obj8 = contentSettingsKt$ContentSettings$$inlined$rememberEnumPreference$5$2$1.result;
                    int i14 = contentSettingsKt$ContentSettings$$inlined$rememberEnumPreference$5$2$1.label;
                    if (i14 != 0) {
                        if (i14 == 1) {
                            ResultKt.throwOnFailure(obj8);
                            return unit;
                        }
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(obj8);
                    String str7 = (String) ((MutablePreferences) obj).get(preferences$Key);
                    AddToPlaylistPosition addToPlaylistPositionValueOf = AddToPlaylistPosition.BEGINNING;
                    if (str7 != null) {
                        try {
                            addToPlaylistPositionValueOf = AddToPlaylistPosition.valueOf(str7);
                            break;
                        } catch (IllegalArgumentException unused7) {
                        }
                    }
                    contentSettingsKt$ContentSettings$$inlined$rememberEnumPreference$5$2$1.label = 1;
                    return flowCollector.emit(addToPlaylistPositionValueOf, contentSettingsKt$ContentSettings$$inlined$rememberEnumPreference$5$2$1) == coroutineSingletons ? coroutineSingletons : unit;
                case 7:
                    if (continuation instanceof PlayerSettingsKt$PlayerSettings$$inlined$rememberEnumPreference$1$2$1) {
                        playerSettingsKt$PlayerSettings$$inlined$rememberEnumPreference$1$2$1 = (PlayerSettingsKt$PlayerSettings$$inlined$rememberEnumPreference$1$2$1) continuation;
                        int i15 = playerSettingsKt$PlayerSettings$$inlined$rememberEnumPreference$1$2$1.label;
                        if ((i15 & Integer.MIN_VALUE) != 0) {
                            playerSettingsKt$PlayerSettings$$inlined$rememberEnumPreference$1$2$1.label = i15 - Integer.MIN_VALUE;
                        } else {
                            playerSettingsKt$PlayerSettings$$inlined$rememberEnumPreference$1$2$1 = new PlayerSettingsKt$PlayerSettings$$inlined$rememberEnumPreference$1$2$1(this, continuation);
                        }
                    } else {
                        playerSettingsKt$PlayerSettings$$inlined$rememberEnumPreference$1$2$1 = new PlayerSettingsKt$PlayerSettings$$inlined$rememberEnumPreference$1$2$1(this, continuation);
                    }
                    Object obj9 = playerSettingsKt$PlayerSettings$$inlined$rememberEnumPreference$1$2$1.result;
                    int i16 = playerSettingsKt$PlayerSettings$$inlined$rememberEnumPreference$1$2$1.label;
                    if (i16 != 0) {
                        if (i16 == 1) {
                            ResultKt.throwOnFailure(obj9);
                            return unit;
                        }
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(obj9);
                    String str8 = (String) ((MutablePreferences) obj).get(preferences$Key);
                    AudioQuality audioQualityValueOf = AudioQuality.AUTO;
                    if (str8 != null) {
                        try {
                            audioQualityValueOf = AudioQuality.valueOf(str8);
                            break;
                        } catch (IllegalArgumentException unused8) {
                        }
                    }
                    playerSettingsKt$PlayerSettings$$inlined$rememberEnumPreference$1$2$1.label = 1;
                    return flowCollector.emit(audioQualityValueOf, playerSettingsKt$PlayerSettings$$inlined$rememberEnumPreference$1$2$1) == coroutineSingletons ? coroutineSingletons : unit;
                case 8:
                    if (continuation instanceof PlayerSettingsKt$PlayerSettings$$inlined$rememberEnumPreference$3$2$1) {
                        playerSettingsKt$PlayerSettings$$inlined$rememberEnumPreference$3$2$1 = (PlayerSettingsKt$PlayerSettings$$inlined$rememberEnumPreference$3$2$1) continuation;
                        int i17 = playerSettingsKt$PlayerSettings$$inlined$rememberEnumPreference$3$2$1.label;
                        if ((i17 & Integer.MIN_VALUE) != 0) {
                            playerSettingsKt$PlayerSettings$$inlined$rememberEnumPreference$3$2$1.label = i17 - Integer.MIN_VALUE;
                        } else {
                            playerSettingsKt$PlayerSettings$$inlined$rememberEnumPreference$3$2$1 = new PlayerSettingsKt$PlayerSettings$$inlined$rememberEnumPreference$3$2$1(this, continuation);
                        }
                    } else {
                        playerSettingsKt$PlayerSettings$$inlined$rememberEnumPreference$3$2$1 = new PlayerSettingsKt$PlayerSettings$$inlined$rememberEnumPreference$3$2$1(this, continuation);
                    }
                    Object obj10 = playerSettingsKt$PlayerSettings$$inlined$rememberEnumPreference$3$2$1.result;
                    int i18 = playerSettingsKt$PlayerSettings$$inlined$rememberEnumPreference$3$2$1.label;
                    if (i18 != 0) {
                        if (i18 == 1) {
                            ResultKt.throwOnFailure(obj10);
                            return unit;
                        }
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(obj10);
                    String str9 = (String) ((MutablePreferences) obj).get(preferences$Key);
                    if (str9 != null) {
                        try {
                            loudnessLevelValueOf = LoudnessLevel.valueOf(str9);
                            break;
                        } catch (IllegalArgumentException unused9) {
                        }
                    }
                    playerSettingsKt$PlayerSettings$$inlined$rememberEnumPreference$3$2$1.label = 1;
                    return flowCollector.emit(loudnessLevelValueOf, playerSettingsKt$PlayerSettings$$inlined$rememberEnumPreference$3$2$1) == coroutineSingletons ? coroutineSingletons : unit;
                default:
                    if (continuation instanceof ThemeScreenKt$ThemeScreen$$inlined$rememberEnumPreference$1$2$1) {
                        themeScreenKt$ThemeScreen$$inlined$rememberEnumPreference$1$2$1 = (ThemeScreenKt$ThemeScreen$$inlined$rememberEnumPreference$1$2$1) continuation;
                        int i19 = themeScreenKt$ThemeScreen$$inlined$rememberEnumPreference$1$2$1.label;
                        if ((i19 & Integer.MIN_VALUE) != 0) {
                            themeScreenKt$ThemeScreen$$inlined$rememberEnumPreference$1$2$1.label = i19 - Integer.MIN_VALUE;
                        } else {
                            themeScreenKt$ThemeScreen$$inlined$rememberEnumPreference$1$2$1 = new ThemeScreenKt$ThemeScreen$$inlined$rememberEnumPreference$1$2$1(this, continuation);
                        }
                    } else {
                        themeScreenKt$ThemeScreen$$inlined$rememberEnumPreference$1$2$1 = new ThemeScreenKt$ThemeScreen$$inlined$rememberEnumPreference$1$2$1(this, continuation);
                    }
                    Object obj11 = themeScreenKt$ThemeScreen$$inlined$rememberEnumPreference$1$2$1.result;
                    int i20 = themeScreenKt$ThemeScreen$$inlined$rememberEnumPreference$1$2$1.label;
                    if (i20 != 0) {
                        if (i20 == 1) {
                            ResultKt.throwOnFailure(obj11);
                            return unit;
                        }
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(obj11);
                    String str10 = (String) ((MutablePreferences) obj).get(preferences$Key);
                    DarkMode darkModeValueOf = DarkMode.AUTO;
                    if (str10 != null) {
                        try {
                            darkModeValueOf = DarkMode.valueOf(str10);
                            break;
                        } catch (IllegalArgumentException unused10) {
                        }
                    }
                    themeScreenKt$ThemeScreen$$inlined$rememberEnumPreference$1$2$1.label = 1;
                    return flowCollector.emit(darkModeValueOf, themeScreenKt$ThemeScreen$$inlined$rememberEnumPreference$1$2$1) == coroutineSingletons ? coroutineSingletons : unit;
            }
        }
    }

    public ShowMediaInfoKt$ShowMediaInfo$$inlined$rememberEnumPreference$1(Flow flow, Preferences$Key preferences$Key, byte b) {
        this.$r8$classId = b;
        switch (b) {
            case 1:
                this.$this_unsafeTransform$inlined = flow;
                this.$key$inlined = preferences$Key;
                break;
            case 2:
                this.$this_unsafeTransform$inlined = flow;
                this.$key$inlined = preferences$Key;
                break;
            case 3:
                this.$this_unsafeTransform$inlined = flow;
                this.$key$inlined = preferences$Key;
                break;
            case 4:
                Proxy.Type type = Proxy.Type.HTTP;
                this.$this_unsafeTransform$inlined = flow;
                this.$key$inlined = preferences$Key;
                break;
            case 5:
                this.$this_unsafeTransform$inlined = flow;
                this.$key$inlined = preferences$Key;
                break;
            case 6:
                this.$this_unsafeTransform$inlined = flow;
                this.$key$inlined = preferences$Key;
                break;
            case 7:
                this.$this_unsafeTransform$inlined = flow;
                this.$key$inlined = preferences$Key;
                break;
            case 8:
                this.$this_unsafeTransform$inlined = flow;
                this.$key$inlined = preferences$Key;
                break;
            case 9:
                this.$this_unsafeTransform$inlined = flow;
                this.$key$inlined = preferences$Key;
                break;
            default:
                this.$this_unsafeTransform$inlined = flow;
                this.$key$inlined = preferences$Key;
                break;
        }
    }

    /* JADX WARN: Code duplicated, block: B:114:0x01be  */
    /* JADX WARN: Code duplicated, block: B:129:0x01f8  */
    /* JADX WARN: Code duplicated, block: B:144:0x0231  */
    /* JADX WARN: Code duplicated, block: B:24:0x005f  */
    /* JADX WARN: Code duplicated, block: B:39:0x009a  */
    /* JADX WARN: Code duplicated, block: B:54:0x00d4  */
    /* JADX WARN: Code duplicated, block: B:69:0x010e  */
    /* JADX WARN: Code duplicated, block: B:84:0x0148  */
    /* JADX WARN: Code duplicated, block: B:99:0x0184  */
    /* JADX WARN: Code duplicated, block: B:9:0x0024  */
    @Override // kotlinx.coroutines.flow.Flow
    public final Object collect(FlowCollector flowCollector, Continuation continuation) {
        AnonymousClass1 anonymousClass1;
        AppearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$5$1 appearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$5$1;
        AppearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$7$1 appearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$7$1;
        AppearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$9$1 appearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$9$1;
        ContentSettingsKt$ContentSettings$$inlined$rememberEnumPreference$1$1 contentSettingsKt$ContentSettings$$inlined$rememberEnumPreference$1$1;
        ContentSettingsKt$ContentSettings$$inlined$rememberEnumPreference$3$1 contentSettingsKt$ContentSettings$$inlined$rememberEnumPreference$3$1;
        ContentSettingsKt$ContentSettings$$inlined$rememberEnumPreference$5$1 contentSettingsKt$ContentSettings$$inlined$rememberEnumPreference$5$1;
        PlayerSettingsKt$PlayerSettings$$inlined$rememberEnumPreference$1$1 playerSettingsKt$PlayerSettings$$inlined$rememberEnumPreference$1$1;
        PlayerSettingsKt$PlayerSettings$$inlined$rememberEnumPreference$3$1 playerSettingsKt$PlayerSettings$$inlined$rememberEnumPreference$3$1;
        ThemeScreenKt$ThemeScreen$$inlined$rememberEnumPreference$1$1 themeScreenKt$ThemeScreen$$inlined$rememberEnumPreference$1$1;
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        Preferences$Key preferences$Key = this.$key$inlined;
        Flow flow = this.$this_unsafeTransform$inlined;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        switch (b) {
            case 0:
                if (continuation instanceof AnonymousClass1) {
                    anonymousClass1 = (AnonymousClass1) continuation;
                    int i = anonymousClass1.label;
                    if ((i & Integer.MIN_VALUE) != 0) {
                        anonymousClass1.label = i - Integer.MIN_VALUE;
                    } else {
                        anonymousClass1 = new AnonymousClass1(continuation);
                    }
                } else {
                    anonymousClass1 = new AnonymousClass1(continuation);
                }
                Object obj = anonymousClass1.result;
                int i2 = anonymousClass1.label;
                if (i2 == 0) {
                    ResultKt.throwOnFailure(obj);
                    AnonymousClass2 anonymousClass2 = new AnonymousClass2(flowCollector, preferences$Key, (byte) 0);
                    anonymousClass1.label = 1;
                    return flow.collect(anonymousClass2, anonymousClass1) == coroutineSingletons ? coroutineSingletons : unit;
                }
                if (i2 == 1) {
                    ResultKt.throwOnFailure(obj);
                    return unit;
                }
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            case 1:
                if (continuation instanceof AppearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$5$1) {
                    appearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$5$1 = (AppearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$5$1) continuation;
                    int i3 = appearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$5$1.label;
                    if ((i3 & Integer.MIN_VALUE) != 0) {
                        appearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$5$1.label = i3 - Integer.MIN_VALUE;
                    } else {
                        appearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$5$1 = new AppearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$5$1(this, continuation);
                    }
                } else {
                    appearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$5$1 = new AppearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$5$1(this, continuation);
                }
                Object obj2 = appearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$5$1.result;
                int i4 = appearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$5$1.label;
                if (i4 == 0) {
                    ResultKt.throwOnFailure(obj2);
                    AnonymousClass2 anonymousClass3 = new AnonymousClass2(flowCollector, preferences$Key, (byte) 1);
                    appearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$5$1.label = 1;
                    return flow.collect(anonymousClass3, appearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$5$1) == coroutineSingletons ? coroutineSingletons : unit;
                }
                if (i4 == 1) {
                    ResultKt.throwOnFailure(obj2);
                    return unit;
                }
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            case 2:
                if (continuation instanceof AppearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$7$1) {
                    appearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$7$1 = (AppearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$7$1) continuation;
                    int i5 = appearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$7$1.label;
                    if ((i5 & Integer.MIN_VALUE) != 0) {
                        appearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$7$1.label = i5 - Integer.MIN_VALUE;
                    } else {
                        appearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$7$1 = new AppearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$7$1(this, continuation);
                    }
                } else {
                    appearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$7$1 = new AppearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$7$1(this, continuation);
                }
                Object obj3 = appearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$7$1.result;
                int i6 = appearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$7$1.label;
                if (i6 == 0) {
                    ResultKt.throwOnFailure(obj3);
                    AnonymousClass2 anonymousClass4 = new AnonymousClass2(flowCollector, preferences$Key, (byte) 2);
                    appearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$7$1.label = 1;
                    return flow.collect(anonymousClass4, appearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$7$1) == coroutineSingletons ? coroutineSingletons : unit;
                }
                if (i6 == 1) {
                    ResultKt.throwOnFailure(obj3);
                    return unit;
                }
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            case 3:
                if (continuation instanceof AppearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$9$1) {
                    appearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$9$1 = (AppearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$9$1) continuation;
                    int i7 = appearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$9$1.label;
                    if ((i7 & Integer.MIN_VALUE) != 0) {
                        appearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$9$1.label = i7 - Integer.MIN_VALUE;
                    } else {
                        appearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$9$1 = new AppearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$9$1(this, continuation);
                    }
                } else {
                    appearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$9$1 = new AppearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$9$1(this, continuation);
                }
                Object obj4 = appearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$9$1.result;
                int i8 = appearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$9$1.label;
                if (i8 == 0) {
                    ResultKt.throwOnFailure(obj4);
                    AnonymousClass2 anonymousClass5 = new AnonymousClass2(flowCollector, preferences$Key, (byte) 3);
                    appearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$9$1.label = 1;
                    return flow.collect(anonymousClass5, appearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$9$1) == coroutineSingletons ? coroutineSingletons : unit;
                }
                if (i8 == 1) {
                    ResultKt.throwOnFailure(obj4);
                    return unit;
                }
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            case 4:
                if (continuation instanceof ContentSettingsKt$ContentSettings$$inlined$rememberEnumPreference$1$1) {
                    contentSettingsKt$ContentSettings$$inlined$rememberEnumPreference$1$1 = (ContentSettingsKt$ContentSettings$$inlined$rememberEnumPreference$1$1) continuation;
                    int i9 = contentSettingsKt$ContentSettings$$inlined$rememberEnumPreference$1$1.label;
                    if ((i9 & Integer.MIN_VALUE) != 0) {
                        contentSettingsKt$ContentSettings$$inlined$rememberEnumPreference$1$1.label = i9 - Integer.MIN_VALUE;
                    } else {
                        contentSettingsKt$ContentSettings$$inlined$rememberEnumPreference$1$1 = new ContentSettingsKt$ContentSettings$$inlined$rememberEnumPreference$1$1(this, continuation);
                    }
                } else {
                    contentSettingsKt$ContentSettings$$inlined$rememberEnumPreference$1$1 = new ContentSettingsKt$ContentSettings$$inlined$rememberEnumPreference$1$1(this, continuation);
                }
                Object obj5 = contentSettingsKt$ContentSettings$$inlined$rememberEnumPreference$1$1.result;
                int i10 = contentSettingsKt$ContentSettings$$inlined$rememberEnumPreference$1$1.label;
                if (i10 != 0) {
                    if (i10 == 1) {
                        ResultKt.throwOnFailure(obj5);
                        return unit;
                    }
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                ResultKt.throwOnFailure(obj5);
                Proxy.Type type = Proxy.Type.HTTP;
                AnonymousClass2 anonymousClass6 = new AnonymousClass2(flowCollector, preferences$Key, (byte) 4);
                contentSettingsKt$ContentSettings$$inlined$rememberEnumPreference$1$1.label = 1;
                return flow.collect(anonymousClass6, contentSettingsKt$ContentSettings$$inlined$rememberEnumPreference$1$1) == coroutineSingletons ? coroutineSingletons : unit;
            case 5:
                if (continuation instanceof ContentSettingsKt$ContentSettings$$inlined$rememberEnumPreference$3$1) {
                    contentSettingsKt$ContentSettings$$inlined$rememberEnumPreference$3$1 = (ContentSettingsKt$ContentSettings$$inlined$rememberEnumPreference$3$1) continuation;
                    int i11 = contentSettingsKt$ContentSettings$$inlined$rememberEnumPreference$3$1.label;
                    if ((i11 & Integer.MIN_VALUE) != 0) {
                        contentSettingsKt$ContentSettings$$inlined$rememberEnumPreference$3$1.label = i11 - Integer.MIN_VALUE;
                    } else {
                        contentSettingsKt$ContentSettings$$inlined$rememberEnumPreference$3$1 = new ContentSettingsKt$ContentSettings$$inlined$rememberEnumPreference$3$1(this, continuation);
                    }
                } else {
                    contentSettingsKt$ContentSettings$$inlined$rememberEnumPreference$3$1 = new ContentSettingsKt$ContentSettings$$inlined$rememberEnumPreference$3$1(this, continuation);
                }
                Object obj6 = contentSettingsKt$ContentSettings$$inlined$rememberEnumPreference$3$1.result;
                int i12 = contentSettingsKt$ContentSettings$$inlined$rememberEnumPreference$3$1.label;
                if (i12 == 0) {
                    ResultKt.throwOnFailure(obj6);
                    AnonymousClass2 anonymousClass7 = new AnonymousClass2(flowCollector, preferences$Key, (byte) 5);
                    contentSettingsKt$ContentSettings$$inlined$rememberEnumPreference$3$1.label = 1;
                    return flow.collect(anonymousClass7, contentSettingsKt$ContentSettings$$inlined$rememberEnumPreference$3$1) == coroutineSingletons ? coroutineSingletons : unit;
                }
                if (i12 == 1) {
                    ResultKt.throwOnFailure(obj6);
                    return unit;
                }
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            case 6:
                if (continuation instanceof ContentSettingsKt$ContentSettings$$inlined$rememberEnumPreference$5$1) {
                    contentSettingsKt$ContentSettings$$inlined$rememberEnumPreference$5$1 = (ContentSettingsKt$ContentSettings$$inlined$rememberEnumPreference$5$1) continuation;
                    int i13 = contentSettingsKt$ContentSettings$$inlined$rememberEnumPreference$5$1.label;
                    if ((i13 & Integer.MIN_VALUE) != 0) {
                        contentSettingsKt$ContentSettings$$inlined$rememberEnumPreference$5$1.label = i13 - Integer.MIN_VALUE;
                    } else {
                        contentSettingsKt$ContentSettings$$inlined$rememberEnumPreference$5$1 = new ContentSettingsKt$ContentSettings$$inlined$rememberEnumPreference$5$1(this, continuation);
                    }
                } else {
                    contentSettingsKt$ContentSettings$$inlined$rememberEnumPreference$5$1 = new ContentSettingsKt$ContentSettings$$inlined$rememberEnumPreference$5$1(this, continuation);
                }
                Object obj7 = contentSettingsKt$ContentSettings$$inlined$rememberEnumPreference$5$1.result;
                int i14 = contentSettingsKt$ContentSettings$$inlined$rememberEnumPreference$5$1.label;
                if (i14 == 0) {
                    ResultKt.throwOnFailure(obj7);
                    AnonymousClass2 anonymousClass8 = new AnonymousClass2(flowCollector, preferences$Key, (byte) 6);
                    contentSettingsKt$ContentSettings$$inlined$rememberEnumPreference$5$1.label = 1;
                    return flow.collect(anonymousClass8, contentSettingsKt$ContentSettings$$inlined$rememberEnumPreference$5$1) == coroutineSingletons ? coroutineSingletons : unit;
                }
                if (i14 == 1) {
                    ResultKt.throwOnFailure(obj7);
                    return unit;
                }
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            case 7:
                if (continuation instanceof PlayerSettingsKt$PlayerSettings$$inlined$rememberEnumPreference$1$1) {
                    playerSettingsKt$PlayerSettings$$inlined$rememberEnumPreference$1$1 = (PlayerSettingsKt$PlayerSettings$$inlined$rememberEnumPreference$1$1) continuation;
                    int i15 = playerSettingsKt$PlayerSettings$$inlined$rememberEnumPreference$1$1.label;
                    if ((i15 & Integer.MIN_VALUE) != 0) {
                        playerSettingsKt$PlayerSettings$$inlined$rememberEnumPreference$1$1.label = i15 - Integer.MIN_VALUE;
                    } else {
                        playerSettingsKt$PlayerSettings$$inlined$rememberEnumPreference$1$1 = new PlayerSettingsKt$PlayerSettings$$inlined$rememberEnumPreference$1$1(this, continuation);
                    }
                } else {
                    playerSettingsKt$PlayerSettings$$inlined$rememberEnumPreference$1$1 = new PlayerSettingsKt$PlayerSettings$$inlined$rememberEnumPreference$1$1(this, continuation);
                }
                Object obj8 = playerSettingsKt$PlayerSettings$$inlined$rememberEnumPreference$1$1.result;
                int i16 = playerSettingsKt$PlayerSettings$$inlined$rememberEnumPreference$1$1.label;
                if (i16 == 0) {
                    ResultKt.throwOnFailure(obj8);
                    AnonymousClass2 anonymousClass9 = new AnonymousClass2(flowCollector, preferences$Key, (byte) 7);
                    playerSettingsKt$PlayerSettings$$inlined$rememberEnumPreference$1$1.label = 1;
                    return flow.collect(anonymousClass9, playerSettingsKt$PlayerSettings$$inlined$rememberEnumPreference$1$1) == coroutineSingletons ? coroutineSingletons : unit;
                }
                if (i16 == 1) {
                    ResultKt.throwOnFailure(obj8);
                    return unit;
                }
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            case 8:
                if (continuation instanceof PlayerSettingsKt$PlayerSettings$$inlined$rememberEnumPreference$3$1) {
                    playerSettingsKt$PlayerSettings$$inlined$rememberEnumPreference$3$1 = (PlayerSettingsKt$PlayerSettings$$inlined$rememberEnumPreference$3$1) continuation;
                    int i17 = playerSettingsKt$PlayerSettings$$inlined$rememberEnumPreference$3$1.label;
                    if ((i17 & Integer.MIN_VALUE) != 0) {
                        playerSettingsKt$PlayerSettings$$inlined$rememberEnumPreference$3$1.label = i17 - Integer.MIN_VALUE;
                    } else {
                        playerSettingsKt$PlayerSettings$$inlined$rememberEnumPreference$3$1 = new PlayerSettingsKt$PlayerSettings$$inlined$rememberEnumPreference$3$1(this, continuation);
                    }
                } else {
                    playerSettingsKt$PlayerSettings$$inlined$rememberEnumPreference$3$1 = new PlayerSettingsKt$PlayerSettings$$inlined$rememberEnumPreference$3$1(this, continuation);
                }
                Object obj9 = playerSettingsKt$PlayerSettings$$inlined$rememberEnumPreference$3$1.result;
                int i18 = playerSettingsKt$PlayerSettings$$inlined$rememberEnumPreference$3$1.label;
                if (i18 == 0) {
                    ResultKt.throwOnFailure(obj9);
                    AnonymousClass2 anonymousClass10 = new AnonymousClass2(flowCollector, preferences$Key, (byte) 8);
                    playerSettingsKt$PlayerSettings$$inlined$rememberEnumPreference$3$1.label = 1;
                    return flow.collect(anonymousClass10, playerSettingsKt$PlayerSettings$$inlined$rememberEnumPreference$3$1) == coroutineSingletons ? coroutineSingletons : unit;
                }
                if (i18 == 1) {
                    ResultKt.throwOnFailure(obj9);
                    return unit;
                }
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            default:
                if (continuation instanceof ThemeScreenKt$ThemeScreen$$inlined$rememberEnumPreference$1$1) {
                    themeScreenKt$ThemeScreen$$inlined$rememberEnumPreference$1$1 = (ThemeScreenKt$ThemeScreen$$inlined$rememberEnumPreference$1$1) continuation;
                    int i19 = themeScreenKt$ThemeScreen$$inlined$rememberEnumPreference$1$1.label;
                    if ((i19 & Integer.MIN_VALUE) != 0) {
                        themeScreenKt$ThemeScreen$$inlined$rememberEnumPreference$1$1.label = i19 - Integer.MIN_VALUE;
                    } else {
                        themeScreenKt$ThemeScreen$$inlined$rememberEnumPreference$1$1 = new ThemeScreenKt$ThemeScreen$$inlined$rememberEnumPreference$1$1(this, continuation);
                    }
                } else {
                    themeScreenKt$ThemeScreen$$inlined$rememberEnumPreference$1$1 = new ThemeScreenKt$ThemeScreen$$inlined$rememberEnumPreference$1$1(this, continuation);
                }
                Object obj10 = themeScreenKt$ThemeScreen$$inlined$rememberEnumPreference$1$1.result;
                int i20 = themeScreenKt$ThemeScreen$$inlined$rememberEnumPreference$1$1.label;
                if (i20 == 0) {
                    ResultKt.throwOnFailure(obj10);
                    AnonymousClass2 anonymousClass11 = new AnonymousClass2(flowCollector, preferences$Key, (byte) 9);
                    themeScreenKt$ThemeScreen$$inlined$rememberEnumPreference$1$1.label = 1;
                    return flow.collect(anonymousClass11, themeScreenKt$ThemeScreen$$inlined$rememberEnumPreference$1$1) == coroutineSingletons ? coroutineSingletons : unit;
                }
                if (i20 == 1) {
                    ResultKt.throwOnFailure(obj10);
                    return unit;
                }
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
        }
    }
}
