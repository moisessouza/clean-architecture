package com.workers.presenters.models.phone;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class PhoneOutputImpl implements PhoneOutput {

    private boolean error;
    private String message;

    private Long id;
    private String ddi;
    private String ddd;
    private String phoneNumber;
    private String userEmail;
}
