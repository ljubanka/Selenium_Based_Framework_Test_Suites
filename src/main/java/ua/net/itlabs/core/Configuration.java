package ua.net.itlabs.core;

public class Configuration {
    //default interval for WaitFor.until - smart waiting check one condition, in milliseconds
    public static long timeout = 4000;
    //interval between checks inside WaitFor.until, in milliseconds
    public static long pollingInterval = 100;
}
