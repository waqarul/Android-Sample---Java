/*
 * Copyright (c) 2020 Payoneer Germany GmbH
 * https://www.payoneer.com
 *
 * This file is open source and available under the MIT license.
 * See the LICENSE file for more information.
 */

package com.wtmcodex.samplepaymentapp.core.data.model;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

/**
 * Customer data what should be used to pre-fill payment form.
 */
@Getter
@Setter
public class CustomerFormData {
    /** optional */
    private Date birthday;
}
