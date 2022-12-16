
package com.systementor.testbed.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;

import com.systementor.testbed.services.RegistrationService.RegisterStatus;
import com.systementor.testbed.services.model.UserAccount;

import jakarta.websocket.RemoteEndpoint.Async;

public class RegistrationServiceTest {
    @Test
    void cantRegisterIfAlreadyRegistered() {
        //ARRANGE
        var userRepository = mock(UserRepository.class);
        var emailSenderService = mock(EmailSenderService.class);
        var service = new RegistrationService(userRepository,emailSenderService);
        when(userRepository.findByEmail("stefan@systementor.se")).thenReturn( new UserAccount() );

        //ACT
        var result = service.Register("stefan@systementor.se", "Stefan Holmberg");

        //ASSERT
        assertEquals(RegisterStatus.AlreadyExisting , result);

    }

    @Test
    void cantRegisterIfWrongDomain() {
        //ARRANGE
        var userRepository = mock(UserRepository.class);
        var emailSenderService = mock(EmailSenderService.class);
        var service = new RegistrationService(userRepository,emailSenderService);
        //ACT
        var result = service.Register("stefan@another.se", "Stefan Holmberg");

        //ASSERT
        assertEquals(RegisterStatus.WrongDomain , result);

    }

    @Test
    void canRegisterIfNotAlreadyExisting() {
        //ARRANGE
        var userRepository = mock(UserRepository.class);
        var emailSenderService = mock(EmailSenderService.class);
        var service = new RegistrationService(userRepository,emailSenderService);
        when(userRepository.findByEmail("stefan@systementor.se")).thenReturn( null );
        //ACT
        var result = service.Register("stefan@systementor.se", "Stefan Holmberg");

        //ASSERT
        assertEquals(RegisterStatus.Ok , result);

    }

    @Test
    void willSendMailWhenRegistering() {
        //ARRANGE
        var userRepository = mock(UserRepository.class);
        var emailSenderService = mock(EmailSenderService.class);
        var service = new RegistrationService(userRepository,emailSenderService);
        when(userRepository.findByEmail("stefan@systementor.se")).thenReturn( null );
        //ACT
        var result = service.Register("stefan@systementor.se", "Stefan Holmberg");

        //ASSERT
        verify(emailSenderService,times(1)).SendEmail("stefan@systementor.se", "Stefan Holmberg", anyString() ,anyString());

    }



}