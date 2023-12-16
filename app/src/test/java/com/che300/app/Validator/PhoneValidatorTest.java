package com.che300.app.Validator;

import javafx.beans.binding.Binding;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author caijiangfan
 * @version 1.0.0
 * @ClassName PhoneValidatorTest.java
 * @Description TODO
 * @createTime 2023/12/14 15:28
 */
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.validation.ConstraintValidatorContext;
import java.util.stream.Stream;

import static org.mockito.Mockito.*;

public class PhoneValidatorTest {
    private PhoneValidator validator;
    private ConstraintValidatorContext context;

    @BeforeEach
    void setUp() {
        validator = new PhoneValidator();
        context = mock(ConstraintValidatorContext.class);
    }

    @Test
    void testIsValid_WithEmptyValue_ReturnsFalse() {
        // Arrange
        String value = "";

        // Act
        boolean result = validator.isValid(value, context);

        // Assert
        assertFalse(result);
    }

    @Test
    void testIsValid_WithNonMobileValue_ReturnsFalse() {
        // Arrange
        String value = "1234567890";

        // Act
        boolean result = validator.isValid(value, context);

        // Assert
        assertFalse(result);
    }

    @Test
    void testIsValid_WithValidMobileValue_ReturnsTrue() {
        // Arrange
        String value = "18612345678";

        // Act
        boolean result = validator.isValid(value, context);

        // Assert
        assertTrue(result);
    }

    @Test
    void testIsValid_WithNullValue_ReturnsTrue() {
        // Arrange
        String value = null;

        // Act
        boolean result = validator.isValid(value, context);

        // Assert
        assertFalse(result);
    }
}
