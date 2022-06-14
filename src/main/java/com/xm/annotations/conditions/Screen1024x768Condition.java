package com.xm.annotations.conditions;

import com.xm.annotations.Screen1024x768;
import com.xm.core.properties.PropertyController;
import org.junit.jupiter.api.extension.ConditionEvaluationResult;
import org.junit.jupiter.api.extension.ExecutionCondition;
import org.junit.jupiter.api.extension.ExtensionContext;

import java.lang.reflect.AnnotatedElement;

import static org.junit.jupiter.api.extension.ConditionEvaluationResult.disabled;
import static org.junit.jupiter.api.extension.ConditionEvaluationResult.enabled;
import static org.junit.platform.commons.support.AnnotationSupport.findAnnotation;

public class Screen1024x768Condition implements ExecutionCondition {
    private static final ConditionEvaluationResult ENABlE_BY_DEFAULT =
            enabled("@Screen1024x768 is not present");

    @Override
    public ConditionEvaluationResult evaluateExecutionCondition(ExtensionContext context) {
        AnnotatedElement element = context
                .getElement()
                .orElseThrow(IllegalStateException::new);
        return findAnnotation(element, Screen1024x768.class)
                .map(annotation -> disableIfUnreachable())
                .orElse(ENABlE_BY_DEFAULT);
    }

    private ConditionEvaluationResult disableIfUnreachable() {
        if ("1024x768".equals(PropertyController.systemProperties().browserScreen()) || PropertyController.systemProperties().browserScreen().isEmpty()) {
            return enabled("Screen resolution is 1024x768");
        }
        return disabled("Screen resolution is NOT 1024x768");
    }
}
