package com.ecommerce.user.DTO;

import ch.qos.logback.core.sift.AppenderTracker;
import lombok.Data;

@Data
public class Authlogin {
    private String email;
    private String password;
}
