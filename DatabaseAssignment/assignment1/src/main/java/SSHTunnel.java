
import java.io.ByteArrayInputStream;

import com.jcraft.jsch.*;

/**
 * Class for managing an SSH tunnel using jsch library. Required in order to
 * communicate with RMIT Oracle Database server (behind firewall)
 **/
public class SSHTunnel {
    private static JSch jsch = null;
    public static Session session = null;

    /**
     * establishes ssh tunnel into RMIT servers (through firewall)
     **/
    public static void open() {
        final String DATABASE_HOST = "talsprddb01.int.its.rmit.edu.au";
        final int DATABASE_PORT = 1521;

        final String RMIT_INTERNAL_HOST = "saturn.csit.rmit.edu.au";
        final int SSH_PORT = 22;
        final int LOCAL_PORT = 9922;

        // create secure shell object
        if (jsch == null) {
            jsch = new JSch();
        }

        try {

            // known host key for RMIT servers - Titan/Jupiter/Saturn
            String knownHostPublicKey = """
         titan.csit.rmit.edu.au ecdsa-sha2-nistp256 AAAAE2VjZHNhLXNoYTItbmlzdHAyNTYAAAAIbmlzdHAyNTYAAABBBBltbi1u2aEhqXgc+8h4lPYt89CsV7Ha2ZcHxzVWRx74241Fp9S/5PiTjNQWCOIDSFrwUS4NLZB8Vne6A94a5d0=
         titan.csit.rmit.edu.au ssh-rsa AAAAB3NzaC1yc2EAAAABIwAAAQEAu4U2smgk3cbCi/HAIJfABsNsvcHVkb8EmGm1/G0Bt9rOsVlW/o+3x404f3mLrp2hZTSvSY1zCaJqSI6hmB5Hu5uFAWLjMBhHk9OvrGvt8ADdfsrnfktKpB0cOTYB+o7k/qhY0bR/tsd/d9p9dZXPAEDB3Uu/qpMohuuKkSTv1ampC7DmdIrSV6NoZ3xULLMtmoDPDb+AF97SHnLpjmvFn8rb/VRhJlZJ1kpRNG5nVjx6L81KYRKvyzPXgO0Sf+zEuJ9xG3OqUCuwy9wj4oFfLtiHkJVvDPlIidi1rjDnWDuRxXV/a9Rdk3uyLjwMB7QlYkQ23dqaosVtbQi+jT4ABQ==
         titan.csit.rmit.edu.au ssh-ed25519 AAAAC3NzaC1lZDI1NTE5AAAAIBOKy2o2kneq8Uyr8LFtH9OhDKd8vmOKrI6ePRLcxn0H
         jupiter.csit.rmit.edu.au ssh-ed25519 AAAAC3NzaC1lZDI1NTE5AAAAIBGfufAHX8s62R5z1VP3FN5NcuWIv1OMBuYOKJEhOaDQ
         jupiter.csit.rmit.edu.au ssh-rsa AAAAB3NzaC1yc2EAAAABIwAAAQEAwlslVsFfrm/0hdyA5QGjj9LGBjJzZjG2JNPv/L2dgSXa0t9LdBpdGROenQYGimVFROV6zks2JyXO6smV+6Q2VyDPcKCweRQygaDeS3eB47ryPMTQtvGUnram+WCgMVheFT21jlo9Bsc52n0WcwtWGK7DafGJI296ntpnAQSQRURXvh7wOzjzW7gTPoapcrrjmrQU9dTRmg1rIOyOqhfEaC9rdGzQSsbaOg3KP+YJMPJijTuaTmSXGCLWxEJ83hopkfKD7krf+p6o14UB+v6wyakUwDSI8xMpIUx5+ptTU2BpC0oq0tgWM4K/eUaeWBP8OMSTWKeyoVo1EDXrj4geuw==
         jupiter.csit.rmit.edu.au ecdsa-sha2-nistp256 AAAAE2VjZHNhLXNoYTItbmlzdHAyNTYAAAAIbmlzdHAyNTYAAABBBKHNxkaZ01ab60wQ2DpT3Ynvtejw6Js3Xo1cT7UmWpcDtFIic+wyTHG4XQTIFLRuR1e76RfXZ/BOn9K5SH/YSko=
         saturn.csit.rmit.edu.au ssh-rsa AAAAB3NzaC1yc2EAAAABIwAAAQEA80Qw/ONnF76nOlSDGapPOzqOSaLLkU1Y+JgL6ibT+m3vhmb+Xs1WRZR8xrAfBtR4EQVGJbR7pX39tCVHxLz5XbRRL3CjDrgNSLSHXarAJR7aV8KQB4qXR/BrGOaIAmtt9CvvO47p8SX1ah2RtzIxx70CbOfsHQidc+z3xBdSBjwx8pf1eeJ0t4cU2cJHr+3HrqjVHFPMMAK/S74VMWSyssfRAasGXxAFNuQz9ekLLOKSiN3VyceF22yVRnyVCjvmDpdhar94b8P0uuSwWyZaVE6cHccU6+SzSvnDzY7tYruXyAyVPG5eytELqPgdH2hHGDjDnOGr249IFEhUD+KRZQ==
         saturn.csit.rmit.edu.au ssh-ed25519 AAAAC3NzaC1lZDI1NTE5AAAAIGPDgcQnMsYJZ5FvK4rVD3aqJPG3ZFBONHKacg6DA4dR
         saturn.csit.rmit.edu.au ecdsa-sha2-nistp256 AAAAE2VjZHNhLXNoYTItbmlzdHAyNTYAAAAIbmlzdHAyNTYAAABBBG5Iy3/ZGGq+uKBWfdiuIEeCAHwoSkF6H/HHDNkrIkwlJr88QVG+X51PIa9la4ffsA1tLQdWqOEwdlX4GK2cWHc=""";

            // create tunnel to RMIT_INTERNAL_HOST on port SSH_PORT (22)
            session = jsch.getSession(App.RMIT_USERNAME, RMIT_INTERNAL_HOST, SSH_PORT);
            // add RMIT servers to known hosts list
            jsch.setKnownHosts(new ByteArrayInputStream(knownHostPublicKey.getBytes()));
            // sets ssh tunnel password
            session.setPassword(String.valueOf(App.pass));
            // connects to ssh tunnel
            session.connect(10000);
            // sets up port forward details
            session.setPortForwardingL(LOCAL_PORT, DATABASE_HOST, DATABASE_PORT);
            System.out.println("SSH session established");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * returns ssh tunnel connection checks if tunnel is down and re-establishes
     **/
    public static Session getSession() {
        try {
            ChannelExec testChannel = (ChannelExec) session.openChannel("exec");
            testChannel.setCommand("true");
            testChannel.connect();

            // testChannel.exit();
        } catch (Throwable t) {
            System.out.println("SSH Session terminated. Create a new one.");
            SSHTunnel.open();
        }
        return session;
    }

    /**
     * closes ssh tunnel
     **/
    public static void close() {
        if (session != null && session.isConnected()) {
            session.disconnect();
            System.out.println("SSH session closed");
        }
    }
}
