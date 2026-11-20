package org.slf4j;

import io.ktor.http.Cookie$$ExternalSyntheticOutline0;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.ServiceConfigurationError;
import java.util.ServiceLoader;
import java.util.concurrent.LinkedBlockingQueue;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;
import okio.Path;
import org.slf4j.event.SubstituteLoggingEvent;
import org.slf4j.helpers.NOPLogger;
import org.slf4j.helpers.Reporter;
import org.slf4j.helpers.SubstituteLogger;
import org.slf4j.helpers.SubstituteLoggerFactory;
import org.slf4j.helpers.SubstituteServiceProvider;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public abstract class LoggerFactory {
    public static final String[] API_COMPATIBILITY_LIST;
    public static volatile byte INITIALIZATION_STATE = 0;
    public static volatile SubstituteServiceProvider PROVIDER;
    public static final SubstituteServiceProvider SUBST_PROVIDER = new SubstituteServiceProvider((byte) 0);
    public static final SubstituteServiceProvider NOP_FALLBACK_SERVICE_PROVIDER = new SubstituteServiceProvider((byte) 1);

    static {
        String property;
        try {
            property = System.getProperty("slf4j.detectLoggerNameMismatch");
        } catch (SecurityException unused) {
            property = null;
        }
        if (property != null) {
            property.equalsIgnoreCase("true");
        }
        API_COMPATIBILITY_LIST = new String[]{"2.0"};
    }

    public static ArrayList findServiceProviders() {
        ArrayList arrayList = new ArrayList();
        final ClassLoader classLoader = LoggerFactory.class.getClassLoader();
        String property = System.getProperty("slf4j.provider");
        SubstituteServiceProvider substituteServiceProvider = null;
        if (property != null && !property.isEmpty()) {
            try {
                String str = "Attempting to load provider \"" + property + "\" specified via \"slf4j.provider\" system property";
                if (Cookie$$ExternalSyntheticOutline0.getLevelInt(2) >= Cookie$$ExternalSyntheticOutline0.getLevelInt(Reporter.INTERNAL_VERBOSITY)) {
                    Reporter.getTarget().println("SLF4J(I): ".concat(str));
                }
                substituteServiceProvider = (SubstituteServiceProvider) classLoader.loadClass(property).getConstructor(null).newInstance(null);
            } catch (ClassCastException e) {
                Reporter.error("Specified SLF4JServiceProvider (" + property + ") does not implement SLF4JServiceProvider interface", e);
            } catch (ClassNotFoundException e2) {
                e = e2;
                Reporter.error("Failed to instantiate the specified SLF4JServiceProvider (" + property + ")", e);
            } catch (IllegalAccessException e3) {
                e = e3;
                Reporter.error("Failed to instantiate the specified SLF4JServiceProvider (" + property + ")", e);
            } catch (InstantiationException e4) {
                e = e4;
                Reporter.error("Failed to instantiate the specified SLF4JServiceProvider (" + property + ")", e);
            } catch (NoSuchMethodException e5) {
                e = e5;
                Reporter.error("Failed to instantiate the specified SLF4JServiceProvider (" + property + ")", e);
            } catch (InvocationTargetException e6) {
                e = e6;
                Reporter.error("Failed to instantiate the specified SLF4JServiceProvider (" + property + ")", e);
            }
        }
        if (substituteServiceProvider != null) {
            arrayList.add(substituteServiceProvider);
            return arrayList;
        }
        Iterator it = (System.getSecurityManager() == null ? ServiceLoader.load(SubstituteServiceProvider.class, classLoader) : (ServiceLoader) AccessController.doPrivileged(new PrivilegedAction() { // from class: org.slf4j.LoggerFactory$$ExternalSyntheticLambda0
            @Override // java.security.PrivilegedAction
            public final Object run() {
                return ServiceLoader.load(SubstituteServiceProvider.class, classLoader);
            }
        })).iterator();
        while (it.hasNext()) {
            try {
                arrayList.add((SubstituteServiceProvider) it.next());
            } catch (ServiceConfigurationError e7) {
                Reporter.getTarget().println("SLF4J(E): ".concat("A service provider failed to instantiate:\n" + e7.getMessage()));
            }
        }
        return arrayList;
    }

    public static Logger getLogger(String str) {
        SubstituteServiceProvider substituteServiceProvider;
        ILoggerFactory iLoggerFactory;
        if (INITIALIZATION_STATE == 0) {
            synchronized (LoggerFactory.class) {
                try {
                    if (INITIALIZATION_STATE == 0) {
                        INITIALIZATION_STATE = (byte) 1;
                        performInitialization();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        byte b = INITIALIZATION_STATE;
        if (b == 1) {
            substituteServiceProvider = SUBST_PROVIDER;
        } else {
            if (b == 2) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("org.slf4j.LoggerFactory in failed state. Original exception was thrown EARLIER. See also https://www.slf4j.org/codes.html#unsuccessfulInit");
                return null;
            }
            if (b == 3) {
                substituteServiceProvider = PROVIDER;
            } else {
                if (b != 4) {
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("Unreachable code");
                    return null;
                }
                substituteServiceProvider = NOP_FALLBACK_SERVICE_PROVIDER;
            }
        }
        switch (substituteServiceProvider.$r8$classId) {
            case 0:
                iLoggerFactory = (SubstituteLoggerFactory) substituteServiceProvider.loggerFactory;
                break;
            default:
                iLoggerFactory = (Path.Companion) substituteServiceProvider.loggerFactory;
                break;
        }
        return iLoggerFactory.getLogger(str);
    }

    public static final void performInitialization() {
        try {
            ArrayList arrayListFindServiceProviders = findServiceProviders();
            reportMultipleBindingAmbiguity(arrayListFindServiceProviders);
            if (arrayListFindServiceProviders.isEmpty()) {
                INITIALIZATION_STATE = (byte) 4;
                Reporter.warn("No SLF4J providers were found.");
                Reporter.warn("Defaulting to no-operation (NOP) logger implementation");
                Reporter.warn("See https://www.slf4j.org/codes.html#noProviders for further details.");
                LinkedHashSet linkedHashSet = new LinkedHashSet();
                try {
                    ClassLoader classLoader = LoggerFactory.class.getClassLoader();
                    Enumeration<URL> systemResources = classLoader == null ? ClassLoader.getSystemResources("org/slf4j/impl/StaticLoggerBinder.class") : classLoader.getResources("org/slf4j/impl/StaticLoggerBinder.class");
                    while (systemResources.hasMoreElements()) {
                        linkedHashSet.add(systemResources.nextElement());
                    }
                } catch (IOException e) {
                    Reporter.error("Error getting resources from path", e);
                }
                reportIgnoredStaticLoggerBinders(linkedHashSet);
            } else {
                PROVIDER = (SubstituteServiceProvider) arrayListFindServiceProviders.get(0);
                PROVIDER.getClass();
                PROVIDER.getClass();
                INITIALIZATION_STATE = (byte) 3;
                reportActualBinding(arrayListFindServiceProviders);
            }
            postBindCleanUp();
            if (INITIALIZATION_STATE == 3) {
                try {
                    switch (PROVIDER.$r8$classId) {
                        case 0:
                            throw new UnsupportedOperationException();
                        default:
                            boolean z = false;
                            for (String str : API_COMPATIBILITY_LIST) {
                                if ("2.0.99".startsWith(str)) {
                                    z = true;
                                }
                            }
                            if (z) {
                                return;
                            }
                            Reporter.warn("The requested version 2.0.99 by your slf4j provider is not compatible with " + Arrays.asList(API_COMPATIBILITY_LIST).toString());
                            Reporter.warn("See https://www.slf4j.org/codes.html#version_mismatch for further details.");
                            return;
                    }
                } catch (Throwable th) {
                    Reporter.error("Unexpected problem occurred during version sanity check", th);
                }
            }
        } catch (Exception e2) {
            INITIALIZATION_STATE = (byte) 2;
            Reporter.error("Failed to instantiate SLF4J LoggerFactory", e2);
            throw new IllegalStateException("Unexpected initialization failure", e2);
        }
    }

    public static void postBindCleanUp() {
        SubstituteServiceProvider substituteServiceProvider = SUBST_PROVIDER;
        synchronized (substituteServiceProvider) {
            try {
                ((SubstituteLoggerFactory) substituteServiceProvider.loggerFactory).postInitialization = true;
                ArrayList arrayList = new ArrayList(((SubstituteLoggerFactory) substituteServiceProvider.loggerFactory).loggers.values());
                int size = arrayList.size();
                int i = 0;
                while (i < size) {
                    Object obj = arrayList.get(i);
                    i++;
                    SubstituteLogger substituteLogger = (SubstituteLogger) obj;
                    substituteLogger._delegate = getLogger(substituteLogger.name);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        LinkedBlockingQueue linkedBlockingQueue = ((SubstituteLoggerFactory) SUBST_PROVIDER.loggerFactory).eventQueue;
        int size2 = linkedBlockingQueue.size();
        ArrayList arrayList2 = new ArrayList(128);
        int i2 = 0;
        while (linkedBlockingQueue.drainTo(arrayList2, 128) != 0) {
            int size3 = arrayList2.size();
            int i3 = 0;
            while (i3 < size3) {
                Object obj2 = arrayList2.get(i3);
                i3++;
                SubstituteLoggingEvent substituteLoggingEvent = (SubstituteLoggingEvent) obj2;
                if (substituteLoggingEvent != null) {
                    SubstituteLogger substituteLogger2 = substituteLoggingEvent.logger;
                    String str = substituteLogger2.name;
                    if (substituteLogger2._delegate == null) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("Delegate logger cannot be null at this state.");
                        return;
                    } else if (!(substituteLogger2._delegate instanceof NOPLogger)) {
                        if (!substituteLogger2.isDelegateEventAware()) {
                            Reporter.warn(str);
                        } else if (substituteLogger2.isEnabledForLevel(substituteLoggingEvent.level) && substituteLogger2.isDelegateEventAware()) {
                            try {
                                substituteLogger2.logMethodCache.invoke(substituteLogger2._delegate, substituteLoggingEvent);
                            } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException unused) {
                            }
                        }
                    }
                }
                int i4 = i2 + 1;
                if (i2 == 0) {
                    if (substituteLoggingEvent.logger.isDelegateEventAware()) {
                        Reporter.warn("A number (" + size2 + ") of logging calls during the initialization phase have been intercepted and are");
                        Reporter.warn("now being replayed. These are subject to the filtering rules of the underlying logging system.");
                        Reporter.warn("See also https://www.slf4j.org/codes.html#replay");
                    } else if (!(substituteLoggingEvent.logger._delegate instanceof NOPLogger)) {
                        Reporter.warn("The following set of substitute loggers may have been accessed");
                        Reporter.warn("during the initialization phase. Logging calls during this");
                        Reporter.warn("phase were not honored. However, subsequent logging calls to these");
                        Reporter.warn("loggers will work as normally expected.");
                        Reporter.warn("See also https://www.slf4j.org/codes.html#substituteLogger");
                    }
                }
                i2 = i4;
            }
            arrayList2.clear();
        }
        SubstituteLoggerFactory substituteLoggerFactory = (SubstituteLoggerFactory) SUBST_PROVIDER.loggerFactory;
        substituteLoggerFactory.loggers.clear();
        substituteLoggerFactory.eventQueue.clear();
    }

    public static void reportActualBinding(ArrayList arrayList) {
        if (arrayList.isEmpty()) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("No providers were found which is impossible after successful initialization.");
            return;
        }
        if (arrayList.size() > 1) {
            String str = "Actual provider is of type [" + arrayList.get(0) + "]";
            if (Cookie$$ExternalSyntheticOutline0.getLevelInt(2) >= Cookie$$ExternalSyntheticOutline0.getLevelInt(Reporter.INTERNAL_VERBOSITY)) {
                Reporter.getTarget().println("SLF4J(I): ".concat(str));
                return;
            }
            return;
        }
        String str2 = "Connected with provider of type [" + ((SubstituteServiceProvider) arrayList.get(0)).getClass().getName() + "]";
        int i = Reporter.TARGET_CHOICE;
        if (Cookie$$ExternalSyntheticOutline0.getLevelInt(1) >= Cookie$$ExternalSyntheticOutline0.getLevelInt(Reporter.INTERNAL_VERBOSITY)) {
            Reporter.getTarget().println("SLF4J(D): ".concat(str2));
        }
    }

    public static void reportIgnoredStaticLoggerBinders(LinkedHashSet linkedHashSet) {
        if (linkedHashSet.isEmpty()) {
            return;
        }
        Reporter.warn("Class path contains SLF4J bindings targeting slf4j-api versions 1.7.x or earlier.");
        Iterator it = linkedHashSet.iterator();
        while (it.hasNext()) {
            Reporter.warn("Ignoring binding found at [" + ((URL) it.next()) + "]");
        }
        Reporter.warn("See https://www.slf4j.org/codes.html#ignoredBindings for an explanation.");
    }

    public static void reportMultipleBindingAmbiguity(ArrayList arrayList) {
        if (arrayList.size() > 1) {
            Reporter.warn("Class path contains multiple SLF4J providers.");
            int size = arrayList.size();
            int i = 0;
            while (i < size) {
                Object obj = arrayList.get(i);
                i++;
                Reporter.warn("Found provider [" + ((SubstituteServiceProvider) obj) + "]");
            }
            Reporter.warn("See https://www.slf4j.org/codes.html#multiple_bindings for an explanation.");
        }
    }
}
