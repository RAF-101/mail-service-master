package com.raf.emailservice.configuration;

import com.raf.emailservice.domain.Tip;

public class DefaultTipConfiguration {

    public static Tip[] toAdd = {
            new Tip("Activation", "Hello %username, you have successfully created an account. Visit http://localhost:8081/activateAccount/%username to confirm the account creation.", 2),
            new Tip("Reset", "Hello %username, you have successfully created a request for password reset. Visit http://localhost:8081/passwordReset/%username to choose a new password.", 2),
            new Tip("TwoDaysNotice", "Hello %username, your reservation is scheduled for in 2 days.", 1),
            new Tip("SuccessfulReservation", "Hello %username, you have successfully made a reservation!", 2),
            new Tip("SuccessfulCancellation", "Hello %username, you have successfully canceled your reservation!", 1)
    };

    public DefaultTipConfiguration() {
    }
}
