package ru.sbtqa.tag.allurehelper;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Vadim Polosov <warorc@ngs.ru>
 */
public class AllureNonCriticalFailure {

    private static final Map<Thread, Throwable> failureMap = new HashMap<>();

    /**
     * Add thread as key and exception as value to failure map, for non
     * CriticalError during test executing
     *
     * @param throvv - throw stack trace
     */
    public static void fire(Throwable throvv) {
        failureMap.put(Thread.currentThread(), throvv);
    }

    /**
     * return failure which failureMap contains
     *
     * @return
     */
    public static Map<Thread, Throwable> getFailure() {
        return failureMap;
    }

    /**
     * clear failureMap
     */
    public static void clrFailure() {
        failureMap.clear();
    }
}