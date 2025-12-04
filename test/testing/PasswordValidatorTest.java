package testing;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PasswordValidatorTest {

    @Test
    void testValidateMinLength(){
        assertEquals(true, PasswordValidator.validate("signe1234"));
        assertFalse(PasswordValidator.validate("hej"));
    }

    @Test
    void testValidateMaxLenght(){
        assertTrue(PasswordValidator.validate("123456789a12345"));
        assertFalse(PasswordValidator.validate("12345678a01234562"));
    }

    @Test
    void testValidateLetters(){
        assertTrue(PasswordValidator.validate("signe1234"));
        assertFalse(PasswordValidator.validate("123456778"));
    }

    @Test
    void testValidateNullPointer(){
        assertThrows(NullPointerException.class,
                () -> PasswordValidator.validate(null) );
    }
}