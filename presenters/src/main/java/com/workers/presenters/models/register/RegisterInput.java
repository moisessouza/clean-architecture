package com.workers.presenters.models.register;

import java.util.Date;

public interface RegisterInput {

    String getName();

    String getDocumentNumber();

    Date getBirthdate();

    String getUserEmail();

}
