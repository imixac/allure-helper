package ru.sbtqa.tag.allurehelper;

import ru.yandex.qatools.allure.Allure;
import ru.yandex.qatools.allure.events.StepFinishedEvent;
import ru.yandex.qatools.allure.events.StepStartedEvent;

/**
 * Helper to add parameters to allure report
 */
public class ParamsHelper {

    /**
     * Add parameter to allure report
     *
     * @param fieldName field name to get title
     * @param value - parameter value
     */
    public static void addParam(String fieldName, String value) {
        String safeName = (fieldName == null) ? "Unnamed Field" : fieldName;
        addParam(safeName + ": %s", new String[]{value});
    }
    
    /**
     * Add parameter to allure report
     * 
     * @param format a format string as described in Format string syntax.
     * @param parameters parameters referenced by the format specifiers in the format string
     */
    public static void addParam(String format, String[] parameters) {
        String name = String.format(format, (Object[]) parameters);
        Allure.LIFECYCLE.fire(new StepStartedEvent(name));
        Allure.LIFECYCLE.fire(new StepFinishedEvent());
    }
}
