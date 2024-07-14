package org.example.emailcertservice.adapter.in.web;

import lombok.RequiredArgsConstructor;
import org.example.emailcertservice.application.port.in.VerifyEmailCommand;
import org.example.emailcertservice.application.port.in.VerifyEmailUseCase;
import org.example.emailcertservice.common.WebAdapter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

@WebAdapter
@RequiredArgsConstructor
public class VerifyEmailController {

    private final VerifyEmailUseCase useCase;

    @GetMapping("/emailcert/verify")
    public ResponseEntity<Boolean> verify(
            VeriftyEmailRequest request
    ){
        System.out.println(request.getEmail());
        VerifyEmailCommand command = VerifyEmailCommand.builder()
                .email(request.getEmail())
                .uuid(request.getUuid())
                .build();


        return ResponseEntity.ok(useCase.verifyEmail(command));
    }
}
