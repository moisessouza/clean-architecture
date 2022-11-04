package com.workers.usecase;

import com.workers.presenters.models.AnyInput;
import com.workers.presenters.models.AnyOutput;

public interface AnyService {
    AnyOutput executeSubstringForBusinessRules();

    AnyOutput save(AnyInput anyInput);
}
