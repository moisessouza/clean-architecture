package com.clean.architecture.usecase;

import com.clean.architecture.presenters.models.AnyInput;
import com.clean.architecture.presenters.models.AnyOutput;

public interface AnyService {
    AnyOutput executeSubstringForBusinessRules();

    AnyOutput save(AnyInput anyInput);
}
