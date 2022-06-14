package com.xm.annotations.conditions;

import com.xm.annotations.Screen800x600;
import com.xm.core.properties.PropertyController;
import org.junit.jupiter.api.extension.ConditionEvaluationResult;
import org.junit.jupiter.api.extension.ExecutionCondition;
import org.junit.jupiter.api.extension.ExtensionContext;

import java.lang.reflect.AnnotatedElement;

import static org.junit.jupiter.api.extension.ConditionEvaluationResult.disabled;
import static org.junit.jupiter.api.extension.ConditionEvaluationResult.enabled;
import static org.junit.platform.commons.support.AnnotationSupport.findAnnotation;

public class Screen800x600Condition implements ExecutionCondition {
    private static final ConditionEvaluationResult ENABlE_BY_DEFAULT =
            enabled("@Screen800x600 is not present");

    @Override
    public ConditionEvaluationResult evaluateExecutionCondition(ExtensionContext context) {
        AnnotatedElement element = context
                .getElement()
                .orElseThrow(IllegalStateException::new);
        return findAnnotation(element, Screen800x600.class)
                .map(annotation -> disableIfUnreachable())
                .orElse(ENABlE_BY_DEFAULT);
    }

    private ConditionEvaluationResult disableIfUnreachable() {
        if ("800x600".equals(PropertyController.systemProperties().browserScreen())) {
            return enabled("Screen resolution is 800x600");
        }
        return disabled("Screen resolution is NOT 800x600");
    }
}
